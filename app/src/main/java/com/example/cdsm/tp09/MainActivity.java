package com.example.cdsm.tp09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    Spinner Spn_Continent;
    ListView Lv_Pays;
    TextView Tv_Pays;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spn_Continent = (Spinner) findViewById(R.id.Spinner_Continent);
        Lv_Pays = (ListView) findViewById(R.id.Listview_Pays);
        Tv_Pays = (TextView) findViewById(R.id.Textview_Pays);

        String[] Amerique = {"Venezuela","USA","Canada","Argentine","Chili"};
        String[] Europe = {"France","Espagne","Italie","Suisse"};
        String[] Asie = {""};
        String[] Afrique = {""};
        String[] Océanie = {""};


        final Map <String,String[]> Continent = new HashMap<String, String[]>();
        Continent.put("Amerique",Amerique);
        Continent.put("Europe",Europe);
        Continent.put("Asie",Asie);
        Continent.put("Afrique",Afrique);
        Continent.put("Océanie",Océanie);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,new ArrayList<String>(Continent.keySet()));
        //ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Continent);

        Spn_Continent.setAdapter(adapter);
        //Lv_Pays.setAdapter(adap);

        Lv_Pays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String text = "Position: "+i+"\nData:"+ Continent.get(i);

                Tv_Pays.setText(text);
            }
        });

        Spn_Continent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Tv_Pays.setText("Vous avez choisi "+adapterView.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
