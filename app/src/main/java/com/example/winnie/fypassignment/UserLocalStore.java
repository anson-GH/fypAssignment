package com.example.winnie.fypassignment;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Winnie on 5/2/2017.
 */

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);

    }

    public User getLoggedInUser(){
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");

        User storeUser = new User( username, password);
        return storeUser;
    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("LoggedIn", false)==true)
            return true;
        else
            return false;

    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();

    }

    public  void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();

    }
}

