package com.example.jivisha_awayoflife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText mFullName,mPassword;
    Button mLogin_button;
    TextView mRegister_text;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFullName   = findViewById(R.id.email);
        mPassword   = findViewById(R.id.Password);
        fAuth = FirebaseAuth.getInstance();
        mLogin_button= findViewById(R.id.login_button);
        mRegister_text   = findViewById(R.id.register_already);

        mLogin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = mFullName.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                if(TextUtils.isEmpty(fullname)){
                    mFullName.setError("Name is required");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required");
                    return;
                }
                if (password.length()<6) {
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;

                }
                //authentication ke liye
                fAuth.signInWithEmailAndPassword(fullname,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "You are logged in!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            Toast.makeText(Login.this, "Oops! That's an error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        mRegister_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stopping stacking
                startActivity(new Intent(getApplicationContext(),Register.class));
                finish();
            }
        });
    }}
