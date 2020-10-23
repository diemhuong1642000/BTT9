package com.example.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserAccount extends AppCompatActivity {

    private String userName;

    public UserAccount(String userName)  {
        this.userName= userName;
    }

    public UserAccount(String userName, String userType, boolean active)  {
        this.userName= userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return this.userName +"";
    }

}