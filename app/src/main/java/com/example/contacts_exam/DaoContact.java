package com.example.contacts_exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;


    public class DaoContact extends SQLiteOpenHelper {

    private static final String DB_NAME="DB_Contact";
    private static final int DB_VERSION= 1;

    private static final String TABLE_NAME = "Contacts";
    private static final String CODE_Contact="codecontact";
    private static final String NOM_Contact="fnamecontact";
    private static final String PRENOM_Contact="snamecontact";
    private static final String NUMBER_Contact="numbercontact";

    public DaoContact(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String req= "CREATE TABLE Contacts ("+"codeContact INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "fnamecontact TEXT, "+"snamecontact TEXT,"+"numbercontact TEXT"+")";
        db.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Contacts");
        this.onCreate(db);
    }

    public void addContact(Contact e){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();
        cv.put(NOM_Contact, e.getFirstname());
        cv.put(PRENOM_Contact, e.getSecondname());
        cv.put(NUMBER_Contact, e.getNumber());
        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public List<Contact> getAllContact(){
        SQLiteDatabase db= this.getReadableDatabase();
        List<Contact> etds= new LinkedList<Contact>();
        String req="SELECT * FROM "+ TABLE_NAME;

        Cursor c= db.rawQuery(req, null);
        Contact e=null;
        if(c.moveToFirst()){
            do{
                e= new Contact();
                e.setCodecontact(Integer.parseInt(c.getString(0)));
                e.setFirstname(c.getString(1));
                e.setSecondname(c.getString(2));
                e.setNumber(c.getString(3));

                etds.add(e);

            }while (c.moveToNext());
        }



        return etds;

    }

    public Contact getStudentByID(int code){
        Contact et=null;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c= db.query(TABLE_NAME,
                new String[]{CODE_Contact, PRENOM_Contact, NOM_Contact},
                CODE_Contact+ "=?",
                new String[]{String.valueOf(code)},
                null,
                null,
                null,
                null
        );
        if(c.moveToFirst()){
            et= new Contact();
            et.setCodecontact(Integer.parseInt(c.getString(0)));
            et.setFirstname(c.getString(1));
            et.setSecondname(c.getString(2));
            et.setNumber(c.getString(3));
        }

        return  et;
    }


}