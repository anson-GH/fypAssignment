package com.example.winnie.fypassignment;

/**
 * Created by Winnie on 5/2/2017.
 */

public class User {

    String  name, username, password;
    int age;
    public User(String username,String password,int age, String name){
        this.username = username;
        this.password = password;
        this.age = age;
        this.name = name;

    }

    public User(String username,String password){
        this.username = username;
        this.password = password;
        this.age = -1;
        this.name = "";

    }
}
