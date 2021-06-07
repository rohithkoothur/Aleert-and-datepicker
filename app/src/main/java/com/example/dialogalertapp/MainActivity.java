package com.example.dialogalertapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(MainActivity.this);
        myAlertDialog.setTitle("Alerting!!!");
        myAlertDialog.setMessage("Click Ok button to continue");
        myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "CLicked OK button",Toast.LENGTH_SHORT).show();
            }
        });
        myAlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked cancell button", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertDialog.show();


    }

    public void onClickDate(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");

    }
    public void processDatePickerResult(int year,int month,int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_String = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_String);
        Toast.makeText(this,"Date: "+ dateMessage,Toast.LENGTH_SHORT).show();

    }


}