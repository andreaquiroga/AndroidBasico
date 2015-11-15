package com.example.dell.contactlistcrud;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.dell.contactlistcrud.db.DataBaseDAO;
import com.example.dell.contactlistcrud.model.Contact;

import java.util.List;

/**
 * Created by Dell on 09/11/2015.
 */
public class ContactCursorAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private List<Contact> todoList;

    public ContactCursorAdapter(Context context, List<Contact> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        this.context = context;
        this.todoList = objects;
    }

}
