package com.example.dell.contactlistcrud;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dell.contactlistcrud.db.DataBaseDAO;
import com.example.dell.contactlistcrud.db.DataBaseHelper;
import com.example.dell.contactlistcrud.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DataBaseDAO dbAdapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lv = (ListView)findViewById(R.id.lvContacts);
        dbAdapter = new DataBaseDAO(this);
        List<Contact> contacts = dbAdapter.getContacts();
        ContactCursorAdapter adapter = new ContactCursorAdapter(this.getBaseContext(),contacts);
        lv.setAdapter(adapter);
        setContentView(R.layout.activity_main);
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
}
