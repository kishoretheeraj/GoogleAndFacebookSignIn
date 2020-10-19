package com.kishoretheeraj.googleandfacebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fauth = FirebaseAuth.getInstance();
        final FirebaseUser user = fauth.getCurrentUser();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //check if the  user is logged in

                if (user != null) {
                    startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                    finish();
                }

            }

        }, 2000);


    }
}