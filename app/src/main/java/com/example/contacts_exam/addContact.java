package com.example.contacts_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




    public class addContact extends AppCompatActivity {

        EditText txtN, txtP,txtnu;
        Button btnAdd, btnCnl, btnAll;
        DaoContact d;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_contact);

            d= new DaoContact(this);
            txtN= findViewById(R.id.nomContact);
            txtP= findViewById(R.id.prenomContact);
            txtnu= findViewById(R.id.numContact);
            btnAdd= findViewById(R.id.btnAdd);
            btnCnl= findViewById(R.id.btnCnl);
            btnAll= findViewById(R.id.btnAll);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Contact et= new Contact();
                    et.setFirstname(txtN.getText().toString());
                    et.setSecondname(txtP.getText().toString());
                    et.setNumber(txtnu.getText().toString());
                    d.addContact(et);
                    txtN.setText("");
                    txtP.setText("");
                    txtnu.setText("");
                }
            });
            btnCnl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtN.setText("");
                    txtP.setText("");
                    txtnu.setText("");
                }
            });
            btnAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i1= new Intent(getApplicationContext(), list.class);
                    startActivity(i1);
                }
            });

        }
    }