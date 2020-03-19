package com.example.recview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class storage extends AppCompatActivity {

    RecyclerView rcv;
    DBHelper myDB;
    ArrayList<data> ilist;
    ImageButton delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        delete = (ImageButton)findViewById(R.id.deleteRecordsBtn);

        ilist = new ArrayList<data>();
        myDB = new DBHelper(this);
        ilist = myDB.getListContents();

        data_adapter dadapter = new data_adapter(ilist,this);
        rcv = (RecyclerView) findViewById(R.id.recycler);
        rcv.setAdapter(dadapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        dadapter.notifyDataSetChanged();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(storage.this, delete_records.class);
                startActivity(i);
            }
        });
    }


}
