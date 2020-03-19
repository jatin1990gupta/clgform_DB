package com.example.recview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class delete_user extends AppCompatActivity {

    EditText name;
    Button delete;
    DBHelper myDB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        name = (EditText)findViewById(R.id.deleteUserEV);
        delete = (Button) findViewById(R.id.deleteUserBtn);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                boolean delete = myDB.delete_user(username);

                if(delete){
                    Toast.makeText(delete_user.this,"("+username+") successfully deleted", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(delete_user.this,admin_options.class);
                    startActivity(i);
                } else {
                    Toast.makeText(delete_user.this,"("+username+") not found.", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}
