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

import androidx.appcompat.app.AppCompatActivity;

public class admin_login extends AppCompatActivity {

    EditText username, password;
    Button login;
    CheckBox showpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username = (EditText) findViewById(R.id.admin_user);
        password = (EditText) findViewById(R.id.admin_pass);
        login = (Button)findViewById(R.id.admin_login);
        showpass = (CheckBox) findViewById(R.id.show_adminPassCB);

        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("abc")){

                    if(pass.equals("abc123")){

                        username.setText("");
                        password.setText("");

                        Intent i = new Intent(admin_login.this,admin_options.class);
                        i.putExtra("admin_name", user);
                        startActivity(i);

                    } else {
                        password.setError("Password didn't match");
                    }
                } else {
                    username.setError("Check Username");
                }

            }
        });
    }
}
