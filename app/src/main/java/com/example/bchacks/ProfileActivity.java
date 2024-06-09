package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    TextView profileName, profileInterest, profilePhone;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profileName);
        profilePhone = findViewById(R.id.profilePhone);
        profileInterest = findViewById(R.id.profileInterest);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();  // Get the current user ID
            Log.d(TAG, "User ID: " + userId);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
            // Assuming you want to retrieve the user by UID
            ref.orderByChild("uid").equalTo(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                            String nameFromDB = userSnapshot.child("name").getValue(String.class);
                            String phoneFromDB = userSnapshot.child("phone").getValue(String.class);
                            String interestsFromDB = userSnapshot.child("interests").getValue(String.class);

                            Log.d(TAG, "Name: " + nameFromDB);
                            Log.d(TAG, "Phone: " + phoneFromDB);
                            Log.d(TAG, "Interests: " + interestsFromDB);

                            profileName.setText(nameFromDB);
                            profilePhone.setText(phoneFromDB);
                            profileInterest.setText(interestsFromDB);
                        }
                    } else {
                        Log.w(TAG, "User data not found");
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e(TAG, "Database error: " + databaseError.getMessage());
                }
            });
        } else {
            Log.w(TAG, "No Firebase user logged in");
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.Profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.Home) {
                startActivity(new Intent(getApplicationContext(), CardAdapter.class));
                finish();
                return true;
            } else if (itemId == R.id.Profile) {
                return true;
            } else if (itemId == R.id.History) {
                startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                finish();
                return true;
            }
            return false;
        });
    }
}


