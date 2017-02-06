package com.example.winnie.fypassignment;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Winnie on 5/2/2017.
 */

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";

    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("name", user.name);
        userLocalDatabaseEditor.putString("username", user.username);
        userLocalDatabaseEditor.putString("password", user.password);
        userLocalDatabaseEditor.putInt("age", user.age);
        userLocalDatabaseEditor.commit();
    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putBoolean("loggedIn", loggedIn);
        userLocalDatabaseEditor.commit();
    }

    public void clearUserData() {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.clear();
        userLocalDatabaseEditor.commit();
    }

    public User getLoggedInUser() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == false) {
            return null;
        }

        String name = userLocalDatabase.getString("name", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        int age = userLocalDatabase.getInt("age", -1);

        User user = new User(username, password, age, name);
        return user;
    }
}

//public class UserLocalStore {
//
//    public static final String SP_NAME = "userDetails";
//    SharedPreferences userLocalDatabase;
//
//    public UserLocalStore(Context context){
//        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
//    }
//
//    public void storeUserData(User user){
//        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
//        spEditor.putString("username",user.username);
//        spEditor.putString("password",user.password);
//        spEditor.putInt("age",user.age);
//        spEditor.putString("name",user.name);
//    }
//
//    public User getLoggedInUser(){
//        if (userLocalDatabase.getBoolean("loggedIn", false) == false) {
//            return null;
//        }
//        String username = userLocalDatabase.getString("username","");
//        String password = userLocalDatabase.getString("password","");
//        String name = userLocalDatabase.getString("name","");
//        int age = userLocalDatabase.getInt("age",-1);
//
//System.out.println("hahahaha" + username+ password+age+name);
//
//        User storedUser = new User( username, password,age,name);
//
//        return storedUser;
//    }
//
////    public boolean getUserLoggedIn(){
////        if (userLocalDatabase.getBoolean("LoggedIn", false)==true)
////            return true;
////        else
////
////        return false;
////
////    }
//
//    public void setUserLoggedIn(boolean loggedIn){
//        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
//        spEditor.putBoolean("loggedIn",loggedIn);
//        spEditor.commit();
//
//    }
//
//    public  void clearUserData(){
//        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
//        spEditor.clear();
//        spEditor.commit();
//
//    }
//}

