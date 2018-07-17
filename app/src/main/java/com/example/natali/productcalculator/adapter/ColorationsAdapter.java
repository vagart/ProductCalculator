package com.example.natali.productcalculator.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.natali.productcalculator.R;
import com.example.natali.productcalculator.fragment.CutawaceFragment;
import com.example.natali.productcalculator.fragment.CutawaceFragment.coloration;

import java.util.ArrayList;

public class ColorationsAdapter extends ArrayAdapter<coloration> {

    private Context context;
    ArrayList<coloration> data = null;

    public ColorationsAdapter(@NonNull Context context, int resource, ArrayList<coloration> data) {
        super(context, resource,data);
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
            row = LayoutInflater.from(getContext()).inflate(R.layout.coloration_layout,parent,false);
        }

        coloration item = data.get(position);

        if (item!=null){

            TextView myColor = (TextView) row.findViewById(R.id.colorationName);

            if (myColor != null) {
                myColor.setText(item.getName());
            }
        }
        return row;
    }
}
