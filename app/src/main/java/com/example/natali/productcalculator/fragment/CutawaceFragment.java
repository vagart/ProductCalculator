package com.example.natali.productcalculator.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.natali.productcalculator.R;
import com.example.natali.productcalculator.adapter.ColorationsAdapter;
import com.example.natali.productcalculator.adapter.FormatsAdapter;
import com.example.natali.productcalculator.data.Formats;
import com.example.natali.productcalculator.widget.SwitchButton;

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

        SwitchButton mSwitchButton;
        mSwitchButton = (SwitchButton) view.findViewById(R.id.switchButton);

        setSwitchButton(3,mSwitchButton);
        mSwitchButton.setOnChangeListener(new SwitchButton.OnChangeListener() {

            @Override
            public void onChange(int position) {

            }
        });

        ArrayList<Formats> formats = new ArrayList<>();
        formats.add(new Formats(90,50));
        formats.add(new Formats(85,55));
        formats.add(new Formats(90,55));

//        String[] formats ={"90x50","85x55","90x55"};
        Spinner format = (Spinner) view.findViewById(R.id.formatCutawace);
        // Создаем адаптер FormatsAdapter с помощью массива элементов класса Формат и стандартной разметки элемета spinner
        FormatsAdapter formatAdapter = new FormatsAdapter(context,android.R.layout.simple_spinner_item, formats);
        // Определяем разметку для использования при выборе элемента
        //formatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        format.setAdapter(formatAdapter);

        ArrayList<coloration> colorations = new ArrayList<>();
        colorations.add(coloration.FullColor);
        colorations.add(coloration.BlackWhite);

        //получаем спиннер
        Spinner colors = (Spinner) view.findViewById(R.id.spinnerColoration);

        //создаем адаптер для спиннера цветности
        ColorationsAdapter colorationsAdapter = new ColorationsAdapter(context, android.R.layout.simple_spinner_item, colorations);
        // Применяем адаптер к элементу spinner
        colors.setAdapter(colorationsAdapter);


        //установим слушателя на свич "Другой формат"
        final Switch mSwitchDrFormat = (Switch) view.findViewById(R.id.swCutSvoyFormat);

        EditText cutWihgtFormat = (EditText) view.findViewById(R.id.cutWihgtFormat);
        EditText cutHighFormat  = (EditText) view.findViewById(R.id.cutHighFormat);
        TextView textViewX      = (TextView) view.findViewById(R.id.textViewX);

        cutWihgtFormat.setVisibility(View.INVISIBLE);
        cutHighFormat.setVisibility(View.INVISIBLE);
        textViewX.setVisibility(View.INVISIBLE);

        mSwitchDrFormat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                EditText cutWihgtFormat = (EditText) view.findViewById(R.id.cutWihgtFormat);
                EditText cutHighFormat  = (EditText) view.findViewById(R.id.cutHighFormat);
                TextView textViewX      = (TextView) view.findViewById(R.id.textViewX);
                Spinner format = (Spinner) view.findViewById(R.id.formatCutawace);

                if (b){
                    cutWihgtFormat.setVisibility(View.VISIBLE);
                    cutHighFormat.setVisibility(View.VISIBLE);
                    textViewX.setVisibility(View.VISIBLE);
                    format.setVisibility(View.INVISIBLE);
                }
                else {
                    cutWihgtFormat.setVisibility(View.INVISIBLE);
                    cutHighFormat.setVisibility(View.INVISIBLE);
                    textViewX.setVisibility(View.INVISIBLE);
                    format.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public enum coloration{
        FullColor("Полноцветная"),
        BlackWhite("Черно-белая");

        private String name;


        coloration(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }


        @Override
        public String toString() {
            return this.name;
        }
    }

    public void setSwitchButton(int count, SwitchButton mSwitchButton) {
        String[] mTexts = new String[count];
        mTexts[0] = getString(R.string.digitalprinting);
        mTexts[1] = getString(R.string.embossed);
        mTexts[2] = getString(R.string.serigraphy);
        mSwitchButton.setTextArray(mTexts);
        mSwitchButton.notifyDataSetChange();
    }

}
