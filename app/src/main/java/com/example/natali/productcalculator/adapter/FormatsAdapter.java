package com.example.natali.productcalculator.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.natali.productcalculator.R;
import com.example.natali.productcalculator.data.Formats;

import java.util.ArrayList;
import java.util.List;

public class FormatsAdapter extends ArrayAdapter<Formats> {
    private Context context;
    ArrayList<Formats> data = null;

    public FormatsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Formats> data) {
        super(context, resource, data);
        this.context = context;
        this.data    = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.format_layout, parent, false);
        }

        Formats item = data.get(position);

        if (item != null) { // парсим данные с каждого объекта

            TextView  myFormat = (TextView) row.findViewById(R.id.formatName);

            if (myFormat != null)
                myFormat.setText(item.getTitle());
        }

        return row;
    }
}
