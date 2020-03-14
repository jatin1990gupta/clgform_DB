package com.example.recview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class app_front extends AppCompatActivity {

    Button knwMore, fillForm, clgBtn;
    ImageButton contact, email, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_front);

        knwMore = (Button) findViewById(R.id.knwMoreBtn);
        fillForm = (Button) findViewById(R.id.fillBtn);
        clgBtn = (Button) findViewById(R.id.clgBtn);

        contact = (ImageButton) findViewById(R.id.cntctBtn);
        email = (ImageButton) findViewById(R.id.emailBtn);
        location = (ImageButton) findViewById(R.id.locateBtn);

        knwMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("android.intent.action.VIEW",
                        Uri.parse("http://www.oistbpl.com/oct-bhopal/index.php"));
                startActivity(i);

            }
        });

        fillForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(app_front.this,MainActivity.class);
                startActivity(i);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse("tel: +917552529026");
                Toast.makeText(getApplicationContext(),"Calling at: 0755-2529026", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Intent.ACTION_DIAL, u);
                startActivity(i);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Intent i = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "oistbpl@oriental.ac.in"));
                    startActivity(i);
                }catch(Exception ex){
                    Log.e("ERROR",ex.toString());
                }
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://goo.gl/maps/rhswUstB3Yvp3Pg78"));
                startActivity(i);

            }
        });

        clgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(app_front.this,login.class);
                startActivity(i);
            }
        });


    }

}
