package com.example.bchacks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    // UI elements
    EditText loginUsername, loginPassword;
    Button loginButton;
    TextView signupRedirectText;

    // Firebase authentication
    static private FirebaseAuth auth;
    public String loginemail;
    public static String loginuser;

    // Firebase authentication instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase authentication
        auth = FirebaseAuth.getInstance();

        // Initialize UI elements
        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        signupRedirectText = findViewById(R.id.signUpRedirectText);
        loginButton = findViewById(R.id.login_button);

        mAuth = FirebaseAuth.getInstance();

        // Login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            // Validate username and password
            @Override
            public void onClick(View v) {
                if (!validateUsername() | !validatePassword()) {
                    // Handle validation errors
                } else {
                    // Perform user authentication
                    checkUser();
                }
            }
        });

        // Redirect to signup activity
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    // Update UI based on user authentication
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            // Navigate to main activity
            Log.i("Login", "In UpdateUI ");
            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please sign in to continue", Toast.LENGTH_SHORT).show();
        }
    }

    // Validate username
    public Boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if (val.isEmpty()) {
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    // Validate password
    public Boolean validatePassword() {
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }

    // Check user credentials
    public void checkUser() {
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();
        String email;

        // Query database for user credentials
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // User exists in database
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)) {
                        // Valid credentials, navigate to main activity
                        // Retrieve user information from database

                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                        String interestsFromDB = snapshot.child(userUsername).child("interests").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);

                        loginemail = emailFromDB;
                        loginuser = usernameFromDB;

                        loginUsername.setError(null);
                        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);

                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phone", phoneFromDB);
                        intent.putExtra("interests", interestsFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        Log.i("Signup", "Sign-in before: " + emailFromDB + " Password - " + userPassword);

                        assert emailFromDB != null;

                        // Sign in with Firebase authentication
                        auth.signInWithEmailAndPassword(emailFromDB, userPassword)
                                .addOnSuccessListener(authResult -> {
                                    Log.i("Signup", "Sign-in Successful for: " + emailFromDB + " - UID - " + auth.getCurrentUser().getUid());
                                    startActivity(intent);
                                    finish();
                                }).addOnFailureListener(e -> Log.i("Signup", "Sign-in failed for: " + emailFromDB + " - UID - " + auth.getCurrentUser().getUid() + " - " + e.getMessage()));
                    } else {
                        // Invalid password
                        loginPassword.setError("Invalid credentials");
                        loginPassword.requestFocus();
                    }
                } else {
                    // User does not exist
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
            }
        });
    }
}
