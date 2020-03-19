package com.example.recview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class delete_records extends AppCompatActivity {
    Button delete;
    EditText delName;
    DBHelper myDB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_delete_records);

        myDB = new DBHelper(this);

        delete=(Button)findViewById(R.id.deleteBtn);
        delName=(EditText)findViewById(R.id.delnameEV);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = delName.getText().toString();
                if(name.length()==0){
                    delName.setError("enter name");
                } else {
                    deletion(name);
                    delName.setText("");
                    Intent i = new Intent(delete_records.this,storage.class);
                    startActivity(i);
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
