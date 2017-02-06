package com.example.winnie.fypassignment;

/**
 * Created by Winnie on 5/2/2017.
 */

public class User {

    String  name, username, password,email;
    int age;
    public User(String username,String password,int age, String name,String email){
        this.username = username;
        this.password = password;
        this.age = age;
        this.name = name;
        this.email = email;

    }

    public User(String username,String password){
        this.username = username;
        this.password = password;
        this.age = -1;
        this.name = "";
        this.email = "";

    }
}
