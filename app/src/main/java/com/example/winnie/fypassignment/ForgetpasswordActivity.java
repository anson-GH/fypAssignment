package com.example.winnie.fypassignment;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetpasswordActivity extends ActionBarActivity  implements View.OnClickListener{

    Button bSubmit;
    EditText etEmailRecovery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        bSubmit = (Button) findViewById(R.id.bSubmit);
        etEmailRecovery = (EditText) findViewById(R.id.etEmailRecovery);

        bSubmit.setOnClickListener(this);

    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bSubmit:

                String email = etEmailRecovery.getText().toString();
                User user = new User(email,null,null);


                ServerRequestPassword serverRequestPassword = new ServerRequestPassword(this);
                serverRequestPassword.fetchUserDataInBackground(user, new GetUserCallBack() {
                    @Override
                    public void done(User user) {
                        if(user==null){
                            Toast.makeText(ForgetpasswordActivity.this, "Invalid email!",Toast.LENGTH_LONG).show();
                        }else{

                            sendEmail(user.email,user.username);

                        }
                    }
                });


                break;

        }

    }
    public void sendEmail(String email, String username) {
        //Getting content for email
        String subject = "TAR University College Password Recovery";
        String message = "<span style=\"color:#0078D7;font-size:40px\">Password recovery</span>\n\n"+"Hello "  + username + "," +"\n\n"+"We have received a request to reset your old password at socialtainment.com."+
                "\n\nIn order to change your password, click the link below:"+
                "\n\nReset My Password (<a href=\\\"http://192.168.0.7/recovery.aspx\" style=\"color:#0078D7\">http://192.168.0.7/recovery.aspx</a>)"+
" \n\nIf you have not made any password reset request, it is likely that another user entered your email address by mistake and you can simply disregard this email.\n\nThanks, \nTunku Abdul Rahman University College";


        //Creating SendMail object
     SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }


}
