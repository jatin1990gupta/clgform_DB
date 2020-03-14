package com.example.recview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class options extends AppCompatActivity {
    Button view, delete;
    EditText delName;
    DBHelper myDB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        myDB = new DBHelper(this);

        delete=(Button)findViewById(R.id.deleteBtn);
        view=(Button)findViewById(R.id.viewBtn);
        delName = (EditText)findViewById(R.id.delNameEV);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(options.this,storage.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = delName.getText().toString();
                if(name.length()==0){
                    delName.setError("enter name");
                } else {
                    deletion(name);
                    delName.setText("");
                }
                }
        });
    }

    public void deletion(String name){
        boolean isdeleted = myDB.delete_data(name);

        if (isdeleted) {
            Toast.makeText(this, "Successfully Deleted.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"No entry found named, "+name, Toast.LENGTH_LONG).show();
        }
    }

}
