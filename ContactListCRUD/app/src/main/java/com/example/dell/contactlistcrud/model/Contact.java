package com.example.dell.contactlistcrud.model;

import android.content.ContentValues;

/**
 * Created by Dell on 09/11/2015.
 */
public class Contact {

    private int id_contact;
    private String name;
    private int mobile_phone;
    private int home_phone;

    public Contact(){

    }
    public Contact(int id, String name, int mobile, int home){
        this.id_contact = id;
        this.name = name;
        this.mobile_phone= mobile;
        this.home_phone= home;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mobile_phone", mobile_phone);
        contentValues.put("home_phone", home_phone);
        return contentValues;
    }
}
