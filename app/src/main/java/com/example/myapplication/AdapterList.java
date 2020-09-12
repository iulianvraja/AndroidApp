package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<FullDataAntrenament> {
    private final Context context;
    private final ArrayList<FullDataAntrenament> values;

    public AdapterList(Context context, ArrayList<FullDataAntrenament> values) {
        super(context, -1,values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.exercice_list, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.day);
        TextView textView2 = (TextView) rowView.findViewById(R.id.exAndsets);
        TextView textView3 = (TextView) rowView.findViewById(R.id.reps);
        textView.setText(values.get(position).getDay());
        textView2.setText(values.get(position).getExe()+" X "+values.get(position).getSets());
        textView3.setText(values.get(position).getReps());
        // change the icon for Windows and iPhone

        return rowView;
    }
}