package com.example.recview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText anameEV, dobEV, fnameEV, roll10EV, per10EV, roll12EV, per12EV, mobEV, cmobEV, emailEV, addEV;
    RadioButton maleRB, femaleRB, otherRB;
    Spinner foccSpn, board10Spn, board12Spn, progSpn1;
    Button smtBtn;

    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anameEV = (EditText) findViewById(R.id.anameEV);
        dobEV = (EditText) findViewById(R.id.dobEV);
        fnameEV = (EditText) findViewById(R.id.fnameEV);
        roll10EV = (EditText) findViewById(R.id.roll10EV);
        per10EV = (EditText) findViewById(R.id.per10EV);
        roll12EV = (EditText) findViewById(R.id.roll12EV);
        per12EV = (EditText) findViewById(R.id.per12EV);
        mobEV = (EditText) findViewById(R.id.mobEV);
        cmobEV = (EditText) findViewById(R.id.cmobEV);
        emailEV = (EditText) findViewById(R.id.emailEV);
        addEV = (EditText) findViewById(R.id.addEV);

        maleRB = (RadioButton) findViewById(R.id.maleRB);
        femaleRB = (RadioButton) findViewById(R.id.femaleRB);
        otherRB = (RadioButton) findViewById(R.id.otherRB);

        foccSpn = (Spinner) findViewById(R.id.foccSpn);
        board10Spn = (Spinner) findViewById(R.id.board10Spn);
        board12Spn = (Spinner) findViewById(R.id.board12Spn);
        progSpn1 = (Spinner) findViewById(R.id.progSpn);

        smtBtn = (Button) findViewById(R.id.smtBtn);

        myDB = new DBHelper(this);

        smtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = anameEV.getText().toString();
                String gender = null;
                if(maleRB.isChecked()){
                    gender = maleRB.getText().toString();
                }
                else if(femaleRB.isChecked()){
                    gender = femaleRB.getText().toString();
                }
                else if(otherRB.isChecked()){
                    gender = otherRB.getText().toString();
                }

                String dob = dobEV.getText().toString();
                String fname = fnameEV.getText().toString();

                String focc = null;
                String focc1 = foccSpn.getSelectedItem().toString();
                if(!focc1.equals("--Please Select--")){
                    focc = focc1;
                }

                String board10 = null;
                String board101 = board10Spn.getSelectedItem().toString();
                if(!board101.equals("--Please Select--")){
                    board10 = board101;
                }

                String roll10 = roll10EV.getText().toString();
                String per10 = per10EV.getText().toString();

                String board12 = null;
                String board121 = board12Spn.getSelectedItem().toString();
                if(!board121.equals("--Please Select--")){
                    board12 = board121;
                }


                String roll12 = roll12EV.getText().toString();
                String per12 = per12EV.getText().toString();
                String mob = mobEV.getText().toString();
                String cmob = cmobEV.getText().toString();
                String email = emailEV.getText().toString();
                String address = addEV.getText().toString();

                String prog = null;
                String prof1 = progSpn1.getSelectedItem().toString();
                if(!prof1.equals("--Please Select--")){
                    prog = prof1;
                }

                String time = getCurrentTimeStamp();

                if(name.length()!=0 && gender!=null && dob.length()!=0 && fname.length()!=0
                    && board10!=null && roll10.length()!=0 && per10.length()!=0
                        && board12!=null && roll12.length()!=0 && per12.length()!=0
                        && mob.length()!=0 && cmob.length()!=0 && email.length()!=0
                        && address.length()!=0 && prog!=null){

                    if(mob.equals(cmob) && mob.length()==10) {

                        if (Integer.parseInt(per10) > 100 || Integer.parseInt(per12) > 100) {
                            Toast.makeText(MainActivity.this, "Percentage Can't be more than 100.", Toast.LENGTH_LONG).show();
                        } else {
                            AddData(name, gender, dob, fname, focc, board10, roll10, per10, board12, roll12, per12, mob,
                                    cmob, email, address, prog, time);

                            anameEV.setText("");
                            dobEV.setText("");
                            fnameEV.setText("");
                            roll10EV.setText("");
                            per10EV.setText("");
                            roll12EV.setText("");
                            per12EV.setText("");
                            mobEV.setText("");
                            cmobEV.setText("");
                            emailEV.setText("");
                            addEV.setText("");

                            Intent i = new Intent(MainActivity.this, app_front.class);
                            startActivity(i);
                        }
                    } else {
                        Toast.makeText(MainActivity.this,"Please confirm the entered mobile number (10 digits).", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this,"Please Fill Mandatory Fields!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String name, String gender,  String dob, String fname, String focc, String board10, String roll10, String per10,
                        String board12, String roll12, String per12, String mob, String cmob, String email, String address, String programme, String time){
        boolean insertData = myDB.add_data(name, gender, dob, fname, focc, board10, roll10, per10, board12, roll12, per12, mob, email, address, programme, time);

        if(insertData){
            Toast.makeText(MainActivity.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(MainActivity.this,"Something Went Wrong", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
