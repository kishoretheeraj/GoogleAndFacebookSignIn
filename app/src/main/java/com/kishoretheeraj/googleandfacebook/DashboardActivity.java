package com.kishoretheeraj.googleandfacebook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView etId, etName, etEmail;
    String id;
    String name;
    String email;
    Uri image;
    ImageView Profilepic;
    Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentuser = mAuth.getCurrentUser();
        Profilepic = findViewById(R.id.profile_image);
        etId = findViewById(R.id.id_txt);
        etName = findViewById(R.id.name_txt);
        etEmail = findViewById(R.id.email_txt);
        signout = findViewById(R.id.sign_out_btn);


        if (mAuth.getCurrentUser() != null) {
            name = currentuser.getDisplayName();
            id = currentuser.getUid();
            email = currentuser.getEmail();
            image = currentuser.getPhotoUrl();
        }

        etId.setText(id);
        etEmail.setText(email);
        etName.setText(name);

        Glide.with(this).load(image).into(Profilepic);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                Toast.makeText(DashboardActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}