package com.example.recview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class admin_options extends AppCompatActivity {

    RecyclerView rec;
    ArrayList<user_data> ulist;
    DBHelper myDB = new DBHelper(this);
    ImageButton delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);

        delete = (ImageButton)findViewById(R.id.goto_delete);

        rec = (RecyclerView)findViewById(R.id.user_recycler);
        ulist = myDB.getUserData();

        user_data_adapter uadapter = new user_data_adapter(ulist, this);
        rec.setAdapter(uadapter);
        rec.setLayoutManager(new LinearLayoutManager(this));
        uadapter.notifyDataSetChanged();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(admin_options.this,delete_user.class);
                startActivity(i);
            }
        });
    }

}
