package com.example.thibaut.testmenualiments;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;

import android.widget.GridView;


import java.util.ArrayList;


public class MainActivity extends Activity {

    //Liste des aliments
    private  final String[] nomAlimants={"cabillaud",
            "calamars",
            "colin",
            "crevettes",
            "daurade",
            "fletan",
            "gambas",
            "haddock",
            "hareng",
            "lieu",
            "maquereau",
            "merlu",
            "moules",
            "oeufs de lump",
            "Saint Jacques",
            "sardines",
            "saumon",
            "saumon fume",
            "sole",
            "surimi",
            "thon en boite",
            "truite"};

    // image associée aux aliments : j'utilise une icône psk j'ai rien d'autre pour l'instant et c'est la même pour tous les produits
    private int imageAliment=R.drawable.ic_launcher;
    // l'ArrayList va stocker les objets aliments
    private ArrayList<Aliment> arrayListAliments;
    //l'adapter view est un GridView pour mettre les deux aliments côte à côte (paramètre deux colonnes voir xml)
    private GridView lv;
    //contexte  de l'activité
    private Context context=MainActivity.this;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        définition du layout de l'activité MainActivity qui est un GridView et non listview (je me suis trompé dans le nom du fichier, mais le xml contient bien un gridview)
         */
        setContentView(R.layout.listview);
        //on récupère le gridView
        lv=(GridView)findViewById(R.id.ListViewFishChoice);
        //instanciation de la liste qui va contenir les objets aliments
        arrayListAliments=new ArrayList<Aliment>();
        //remplissage de l'arrayListe avec des objets aliments
        createArrayList();
        //on crée l'adapter personnalisé et on l'associe à l'adapterView
        lv.setAdapter(new MyAdapter(arrayListAliments,context));

    }


      public void createArrayList(){

          int sizeNomAliments=this.nomAlimants.length;
          for(int i=0; i< sizeNomAliments;i++){
              /*
              Création des objets aliments
               */
              Aliment nom= new Aliment(imageAliment,nomAlimants[i]);
              arrayListAliments.add(nom);
          }
      }

}
