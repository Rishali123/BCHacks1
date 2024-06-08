package com.example.bchacks;

public class HelperClass
{
    String name, email, phone, interests, username, password, UID;

    public HelperClass()
    {
    }

    public HelperClass(String name, String email, String phone, String interests, String username, String password, String UID)
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.interests = interests;
        this.username = username;
        this.password = password;
        this.UID = UID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getInterests()
    {
        return interests;
    }

    public void setInterests(String interests)
    {
        this.interests = interests;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUID()
    {
        return UID;
    }

    public void setUID(String UID)
    {
        this.UID = UID;
    }

}