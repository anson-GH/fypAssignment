package com.example.winnie.fypassignment;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity  extends ActionBarActivity implements View.OnClickListener {
    Button bLogout;
    EditText etUsername, etPassword;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate()==true){
            displayUserDetails();
        }
    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etPassword.setText(user.password);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                startActivity( new Intent(this, LoginActivity.class));
                break;


        }


    }
}
