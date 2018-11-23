package com.g.android.mathsgameworking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText emailField;
    EditText passwordField;
    Button registerButton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        registerButton = (Button) findViewById(R.id.registerButton);

        firebaseAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                validation(email, password);
                registerUser(email, password);
            }
        });



    }

    public void registerUser(String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("MathsGame", "Registration Compelete " + task.isSuccessful());
                if(!task.isSuccessful()){
                    Log.d("MathsGame", "Registration Failed" + task.getException().toString());
                    //showAlertDialogue("Registration Failed!");
                } else {
                    // getDisplayName();
                    Intent startLogin = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(startLogin);

                }

            }
        });

    }
    public void validation(String email, String password) {


        if (email.length() < 7 || password.length() < 7) {
            Toast.makeText(MainActivity.this, "Email or Password is too short", Toast.LENGTH_LONG).show();
        }

    }
}




