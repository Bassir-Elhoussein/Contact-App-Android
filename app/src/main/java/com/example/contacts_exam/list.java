package com.example.contacts_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;






public class list extends AppCompatActivity {
    ListView listView;

    List<HashMap<String, Object>> listElements;
    HashMap<String, Object> element;
    ContactAdapter adapter;
    DaoContact daoContact;
    List<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.letds);
        listElements = new ArrayList<HashMap<String, Object>>();
        daoContact = new DaoContact(this);
        contacts = daoContact.getAllContact();

        for (Contact contact : contacts) {
            element = new HashMap<String, Object>();
            element.put("label_fname", "NOM: ");
            element.put("val_fname", contact.getFirstname());
            element.put("label_sname", "PRENOM: ");
            element.put("val_sname", contact.getSecondname());
            element.put("label_number", "NUMERO: ");
            element.put("val_number", contact.getNumber());
            listElements.add(element);
        }



            adapter = new ContactAdapter(listElements, this);
            listView.setAdapter(adapter);

    }
}
