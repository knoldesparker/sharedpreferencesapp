package com.example.sharedpreferencesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharPref;

    public static final String Email = "mailKey";
    public static final String Password = "pwdKey";

    private static final String TAG = "MainActivity";
    TextView tvGreeting, tvUserName, tvMessages;
    Button btnDK,btnES,btnDE;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        tvGreeting = findViewById(R.id.tvGreeting);
        tvUserName = findViewById(R.id.tvUserName);
        tvMessages = findViewById(R.id.tvMessages);
        btnDK = findViewById(R.id.btnDK);
        btnDE = findViewById(R.id.btnDE);
        btnES = findViewById(R.id.btnES);
        btnDK.setOnClickListener(onBtnClickDK);
        btnES.setOnClickListener(onBtnClickES);
        setValues();
        //Intent intent = getIntent();
    }

    private void setValues(){
        String userEmailSP = sharPref.getString(Email,"");
        String userPwdSP = sharPref.getString(Password, "");

        Log.d(TAG, "setValues: userName: " + userEmailSP + "\n" + " password: " + userPwdSP);

        tvUserName.setText(userEmailSP);


    }

    private View.OnClickListener onBtnClickDK = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Locale locale = new Locale("da");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            Log.d(TAG, "onClick: something happend DK");
        }
    };

    private View.OnClickListener onBtnClickES = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Configuration config = new Configuration();
            Locale locale = new Locale("es");
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            Log.d(TAG, "onClick: something happend ES");
        }
    };
}
