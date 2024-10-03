package com.example.contacts_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

    public class ContactAdapter extends BaseAdapter {

        List<HashMap<String,Object>> listElts;
        LayoutInflater myInflater;
        Context contaxt;

        public ContactAdapter(List<HashMap<String, Object>> listElts, Context contaxt) {
            this.listElts = listElts;
            this.contaxt = contaxt;
            this.myInflater= LayoutInflater.from(contaxt);
        }

        @Override
        public int getCount() {
            return this.listElts.size();
        }

        @Override
        public Object getItem(int position) {
            return this.listElts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public static class ViewHolder {
            TextView lablenumber, valnumber, labelfname, valfname,labelsname,valsname;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder vholder;
            if(view==null){
                view= myInflater.inflate(R.layout.contactstructure, null);
                vholder= new ViewHolder();
                vholder.labelfname= view.findViewById(R.id.labelfirstname);
                vholder.valfname= view.findViewById(R.id.valfirstname);
                vholder.labelsname= view.findViewById(R.id.labelsecondname);
                vholder.valsname= view.findViewById(R.id.valsecondname);
                vholder.lablenumber= view.findViewById(R.id.labelnumber);
                vholder.valnumber= view.findViewById(R.id.valnumber);
                view.setTag(vholder);
            }
            else
                vholder= (ViewHolder) view.getTag();

            vholder.labelfname.setText(listElts.get(position).get("label_fname").toString());
            vholder.valfname.setText(listElts.get(position).get("val_fname").toString());
            vholder.labelsname.setText(listElts.get(position).get("label_sname").toString());
            vholder.valsname.setText(listElts.get(position).get("val_sname").toString());
            vholder.lablenumber.setText(listElts.get(position).get("label_number").toString());
            vholder.valnumber.setText(listElts.get(position).get("val_number").toString());
            return view;
        }
    }