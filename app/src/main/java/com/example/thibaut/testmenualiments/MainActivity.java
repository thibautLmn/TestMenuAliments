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

    // image associ�e aux aliments : j'utilise une ic�ne psk j'ai rien d'autre pour l'instant et c'est la m�me pour tous les produits
    private int imageAliment=R.drawable.ic_launcher;
    // l'ArrayList va stocker les objets aliments
    private ArrayList<Aliment> arrayListAliments;
    //l'adapter view est un GridView pour mettre les deux aliments c�te � c�te (param�tre deux colonnes voir xml)
    private GridView lv;
    //contexte  de l'activit�
    private Context context=MainActivity.this;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        d�finition du layout de l'activit� MainActivity qui est un GridView et non listview (je me suis tromp� dans le nom du fichier, mais le xml contient bien un gridview)
         */
        setContentView(R.layout.listview);
        //on r�cup�re le gridView
        lv=(GridView)findViewById(R.id.ListViewFishChoice);
        //instanciation de la liste qui va contenir les objets aliments
        arrayListAliments=new ArrayList<Aliment>();
        //remplissage de l'arrayListe avec des objets aliments
        createArrayList();
        //on cr�e l'adapter personnalis� et on l'associe � l'adapterView
        lv.setAdapter(new MyAdapter(arrayListAliments,context));

    }


      public void createArrayList(){

          int sizeNomAliments=this.nomAlimants.length;
          for(int i=0; i< sizeNomAliments;i++){
              /*
              Cr�ation des objets aliments
               */
              Aliment nom= new Aliment(imageAliment,nomAlimants[i]);
              arrayListAliments.add(nom);
          }
      }

}
