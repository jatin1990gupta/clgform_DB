package com.example.recview;

import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class storage extends AppCompatActivity {

    RecyclerView rcv;
    DBHelper myDB;
    ArrayList<data> ilist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        ilist = new ArrayList<data>();
        myDB = new DBHelper(this);
        ilist = myDB.getListContents();

        data_adapter dadapter = new data_adapter(ilist,this);
        rcv = (RecyclerView) findViewById(R.id.recycler);
        rcv.setAdapter(dadapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        dadapter.notifyDataSetChanged();
    }
}
