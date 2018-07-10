package com.example.natali.productcalculator.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.natali.productcalculator.R;
import com.example.natali.productcalculator.adapter.FormatsAdapter;
import com.example.natali.productcalculator.data.Formats;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CutawaceFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_cutawace;

    @Nullable
    public static CutawaceFragment getInstance(Context context){


        CutawaceFragment fragment = new CutawaceFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_cutawace));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        ArrayList<Formats> formats = new ArrayList<>();
        formats.add(new Formats(90,50));
        formats.add(new Formats(85,55));
        formats.add(new Formats(90,55));

//        String[] formats ={"90x50","85x55","90x55"};
        Spinner format = (Spinner) view.findViewById(R.id.formatCutawace);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        //ArrayAdapter<Formats> formatAdapter = new ArrayAdapter<Formats>(context, android.R.layout.simple_spinner_item, formats);
        FormatsAdapter formatAdapter = new FormatsAdapter(context,android.R.layout.simple_spinner_item, formats);
        // Определяем разметку для использования при выборе элемента
        formatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        format.setAdapter(formatAdapter);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
