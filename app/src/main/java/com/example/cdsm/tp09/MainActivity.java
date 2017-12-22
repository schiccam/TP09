package com.example.cdsm.tp09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    Spinner Spn_Continent;
    ListView Lv_Pays;
    TextView Tv_Pays;
    HashMap <String,HashMap<String, String>> Continent;
    HashMap <String,String> Amerique;
    HashMap <String,String> Europe;
    HashMap <String,String> Asie;
    HashMap <String,String> Afrique;
    HashMap <String,String> Océanie;
    String Pays;
    List lPays;
    List lContinent;
    String sContinent;
    String sPays;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spn_Continent = (Spinner) findViewById(R.id.Spinner_Continent);
        Lv_Pays = (ListView) findViewById(R.id.Listview_Pays);
        Tv_Pays = (TextView) findViewById(R.id.Textview_Pays);

        /*final String[] Amerique = {"Venezuela","USA","Canada","Argentine","Chili"};
        final String[] Europe = {"France","Espagne","Italie","Suisse"};
        final String[] Asie = {"Chine","Japon","Inde","Russie","Qatar","Singapour"};
        final String[] Afrique = {"Angola","Egypte","Gabon","Mali","Togo"};
        final String[] Océanie = {"Ausralie","Palaos","Tonga","Nauru","Samoa"};*/

        Amerique = new HashMap<String, String>();
        Amerique.put("Venezuela","Caracas");
        Amerique.put("USA","WashingtonDC");
        Amerique.put("Canada","Ottawa");
        Amerique.put("Argentine","Buenos Aires");
        Amerique.put("Chili","Santiago");

        Europe = new HashMap<String, String>();
        Europe.put("France","Paris");
        Europe.put("Espagne","Madrid");
        Europe.put("Italie","Rome");
        Europe.put("Suisse","Genève");

        Asie = new HashMap<String, String>();
        Asie.put("Chine","Pékin");
        Asie.put("Japon","Tokyo");
        Asie.put("Qatar","Doha");
        Asie.put("Singapour","Singapour");

        Afrique = new HashMap<String, String>();
        Afrique.put("Angola","Luanda");
        Afrique.put("Egypte","Le Caire");
        Afrique.put("Gabon","Libreville");
        Afrique.put("Mali","Bamako");

        Océanie = new HashMap<String, String>();
        Océanie.put("Ausralie","Canberra");
        Océanie.put("Palaos","Ngerulmud");
        Océanie.put("Tonga","Nuku'alofa");
        Océanie.put("Nauru","Yaren");

        Continent = new HashMap<String, HashMap<String, String>>();
        Continent.put("Amerique",Amerique);
        Continent.put("Europe",Europe);
        Continent.put("Asie",Asie);
        Continent.put("Afrique",Afrique);
        Continent.put("Océanie",Océanie);



        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,lContinent = new ArrayList<String>(Continent.keySet()));


        Spn_Continent.setAdapter(adapter);


        Lv_Pays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                sPays = lPays.get(i).toString();
                Tv_Pays.setText(Continent.get(sContinent).get(sPays));


            }
        });

        Spn_Continent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Pays = adapterView.getSelectedItem().toString();
                ListePays(Pays);
                sContinent = lContinent.get(i).toString();

                //Tv_Pays.setText(Pays);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void ListePays (String x)
    {
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lPays = new ArrayList<String>(Continent.get(x).keySet()));
        Lv_Pays.setAdapter(adap);
    }

    public void toResultat()
    {
        //Continent.get(sContinent).get(sPays);

        Intent intent = new Intent(this, Resultat.class);
        intent.putExtra("Pays",sPays);
        intent.putExtra("Capital",Continent.get(sContinent).get(sPays));
    }
}
