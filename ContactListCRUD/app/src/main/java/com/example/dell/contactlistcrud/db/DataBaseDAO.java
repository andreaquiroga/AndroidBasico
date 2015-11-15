package com.example.dell.contactlistcrud.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.contactlistcrud.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 08/11/2015.
 */
public class DataBaseDAO {

    private DataBaseHelper dbHelper;
    private SQLiteDatabase db;

    public DataBaseDAO(Context context)
    {
        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        db.close();
    }

    public void addContact(Contact contact) {
        db.insert("Contact", null, contact.toContentValues());
    }

    public void deleteContact(int contactId) {
        db.delete("Contact", "contact_id=" + contactId, null);
    }

    public List<Contact> getContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        String[] columns = new String[]{"contact_id", "name", "mobile_phone", "home_phone"};
        Cursor cursor = db.query("Contact", columns, null, null, null, null, null);
        cursor.moveToFirst();// mueve el puntero al primer elemento
        while (!cursor.isAfterLast()) {

            int id = cursor.getColumnIndex("contact_id");
            int name = cursor.getColumnIndex("name");
            int mobile_phone = cursor.getColumnIndex("mobile_phone");
            int home_phone = cursor.getColumnIndex("home_phone");
            Contact contact = new Contact(cursor.getInt(id), cursor.getString(name), cursor.getInt(mobile_phone), cursor.getInt(home_phone));
            contactList.add(contact);
            cursor.moveToNext();
        }
        return contactList;
    }

    public void updateContact(int contactId, Contact contact) {
        db.update("Contact", contact.toContentValues(), "contact_id=" + contact, null);
    }

    public Contact getContact(int contactId) {
        Cursor c = db.rawQuery("SELECT contact_id, mobile_phone, home_phone FROM Contact WHERE contact_id=" + contactId, null);
        c.moveToFirst();
        return new Contact(c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3));
    }

    public Cursor getCursor() throws SQLException
    {
        String[] columns = new String[]{"name", "mobile_phone", "home_phone"};
        Cursor cursor = db.query("Contact", columns, null, null, null, null, null);
        return cursor;
    }
}
