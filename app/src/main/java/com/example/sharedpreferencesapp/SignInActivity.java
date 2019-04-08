package com.example.sharedpreferencesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
     EditText etEm,etPw;
     Button btnReg, btnSignIn;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Email = "mailKey";
    public static final String Password = "pwdKey";
    SharedPreferences sharPref;
    private static final String TAG = "SignInActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);
        etEm = findViewById(R.id.etEmail);
        etPw = findViewById(R.id.etPwd);
        btnReg = findViewById(R.id.btnReg);
        btnSignIn = findViewById(R.id.btnSignIn);
        sharPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        btnReg.setOnClickListener(onClickSaveUser);
        btnSignIn.setOnClickListener(onClickSignInUser);
    }

    private View.OnClickListener onClickSaveUser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (etEm.getText().toString().trim().isEmpty() || etPw.getText().toString().trim().isEmpty()){
                Toast.makeText(SignInActivity.this,"Missing information",Toast.LENGTH_LONG).show();
            } else {

                String userMail = etEm.getText().toString().trim().toLowerCase();
                String userPwd = etPw.getText().toString().trim().toLowerCase();

                SharedPreferences.Editor editor = sharPref.edit();

                editor.putString(Email, userMail);
                editor.putString(Password, userPwd);
                editor.apply();
                Toast.makeText(SignInActivity.this, "User registered", Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener onClickSignInUser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String userEmailSP = sharPref.getString(Email,"");
            String userPwdSP = sharPref.getString(Password, "");

            String userMail = etEm.getText().toString().trim().toLowerCase();
            String userPwd = etPw.getText().toString().trim().toLowerCase();

            if (userMail.equals(userEmailSP) && userPwd.equals(userPwdSP)) {
                Toast.makeText(SignInActivity.this,"User sign in",Toast.LENGTH_LONG).show();
                signInOK();
            } else {
                Toast.makeText(SignInActivity.this, "ERROR. Wrong email or password", Toast.LENGTH_LONG).show();

            }

        }
    };

    private void init(){



    }

    public void signInOK() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }


}
