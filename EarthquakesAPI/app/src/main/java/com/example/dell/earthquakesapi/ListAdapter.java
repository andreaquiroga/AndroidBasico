package com.example.dell.earthquakesapi;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by possiblelabs on 7/17/15.
 */
public class ListAdapter extends ArrayAdapter<EarthQuake> {

    private Context context;
    private List<EarthQuake> todoList;

    public ListAdapter(Context context, List<EarthQuake> objects) {
        super(context, R.layout.activity_main, objects);
        this.context = context;
        this.todoList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView todoText = (TextView) rowView.findViewById(R.id.txtView);
        if(todoList.get(position).getMagnitude()>8.2)
            todoText.setBackgroundColor(Color.YELLOW);
        else
            todoText.setBackgroundColor(Color.MAGENTA);
        todoText.setText(todoList.get(position).toString());

        return rowView;
    }
}