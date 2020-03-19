package com.example.recview;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    TextView login;
    EditText user, email, pass, cpass;
    Button signup;
    DBHelper myDB = null;
    CheckBox showpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        myDB = new DBHelper(this);

        login = (TextView)findViewById(R.id.loginBtn);
        user = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.emailaddEV);
        pass = (EditText)findViewById(R.id.passEV);
        cpass = (EditText)findViewById(R.id.cpassEV);
        signup = (Button)findViewById(R.id.signupBtn);
        showpass= (CheckBox)findViewById(R.id.show_signUpPassCB);

        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = user.getText().toString();
                String emailID = email.getText().toString();
                String password = pass.getText().toString();
                String cpassword = cpass.getText().toString();

                boolean chkUser = myDB.chkUser(username);

                if(username.length()==0 || emailID.length()==0 ||
                        password.length()==0 || cpassword.length()==0){
                    Toast.makeText(com.example.recview.signup.this, "All fields are mandatory!!", Toast.LENGTH_LONG).show();
                } else {

                    if (chkUser) {
                        if (password.equals(cpassword)) {
                            add_loginData(username, emailID, password);

                            Intent i = new Intent(com.example.recview.signup.this, com.example.recview.login.class);
                            startActivity(i);
                        } else {
                            cpass.setError("Password Donot match.");
                        }
                    } else {
                        Toast.makeText(com.example.recview.signup.this, "User Already Exists", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signup.this, com.example.recview.login.class);
                startActivity(i);
            }
        });
    }

    public void add_loginData(String username, String emailID, String password){


        boolean data = myDB.add_loginData(username, emailID, password);

        if(data){
            Toast.makeText(this,"Successfully Registered.",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Error in registering new User!!",Toast.LENGTH_LONG).show();
        }

    }

}
