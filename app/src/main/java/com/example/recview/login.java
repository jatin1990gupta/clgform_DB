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

public class login extends AppCompatActivity {

    EditText user, pass;
    Button loginBtn;
    CheckBox showpassCB;
    TextView signup;
    DBHelper myDB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        showpassCB = (CheckBox)findViewById(R.id.showpassCB);
        signup = (TextView)findViewById(R.id.signupTV);

        showpassCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = user.getText().toString();
                String password = pass.getText().toString();

                String spass = myDB.searchPass(username);

                if(spass.equals(password)){

                    user.setText("");
                    pass.setText("");

                    Intent i = new Intent(login.this,storage.class);
                    startActivity(i);
                } else {
                    Toast.makeText(login.this,"Check Username or Password.", Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, com.example.recview.signup.class);
                startActivity(i);
            }
        });
    }
}
