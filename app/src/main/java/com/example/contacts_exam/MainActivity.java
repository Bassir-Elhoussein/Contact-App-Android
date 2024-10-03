package com.example.contacts_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i1= new Intent(getApplicationContext(), addContact.class);
        startActivity(i1);
        setContentView(R.layout.activity_add_contact);
    }
}