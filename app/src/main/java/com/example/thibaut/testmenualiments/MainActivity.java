package com.example.thibaut.testmenualiments;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;

import android.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MainActivity extends Activity {

    //Liste des aliments
    HashMap<String, Integer> HashPoisson = new HashMap<String, Integer>();


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
        // Remplissage de la HashMap
        HashPoisson.put("Cabillaud",R.mipmap.ic_launcher);
        HashPoisson.put("Calamars",R.mipmap.ic_launcher);
        HashPoisson.put("Colin",R.mipmap.ic_launcher);
        HashPoisson.put("Crevettes",R.mipmap.ic_launcher);
        HashPoisson.put("Daurade",R.mipmap.ic_launcher);
        HashPoisson.put("Fl�tan",R.mipmap.ic_launcher);
        HashPoisson.put("Gambas",R.mipmap.ic_launcher);
        HashPoisson.put("Haddock",R.mipmap.ic_launcher);
        HashPoisson.put("Hareng",R.mipmap.ic_launcher);
        HashPoisson.put("Lieu",R.mipmap.ic_launcher);
        HashPoisson.put("Maquerau",R.mipmap.ic_launcher);
        HashPoisson.put("Merlu",R.mipmap.ic_launcher);
        HashPoisson.put("Moules",R.mipmap.ic_launcher);
        HashPoisson.put("Oeufs de lump",R.mipmap.ic_launcher);
        HashPoisson.put("Saint Jacques",R.mipmap.ic_launcher);
        HashPoisson.put("Sardines",R.mipmap.ic_launcher);
        HashPoisson.put("Saumon",R.mipmap.ic_launcher);
        HashPoisson.put("Saumon fum�",R.mipmap.ic_launcher);
        HashPoisson.put("Sole",R.mipmap.ic_launcher);
        HashPoisson.put("Surimi",R.mipmap.ic_launcher);
        HashPoisson.put("Thon en boite",R.mipmap.ic_launcher);
        HashPoisson.put("Truite",R.mipmap.ic_launcher);

        arrayListAliments=new ArrayList<Aliment>();
        //remplissage de l'arrayList avec des objets aliments
        createArrayList();
        //on cr�e l'adapter personnalis� et on l'associe � l'adapterView
        lv.setAdapter(new MyAdapter(arrayListAliments,context));

    }


      public void createArrayList(){

          Iterator<String> keySetIterator = HashPoisson.keySet().iterator();

          while(keySetIterator.hasNext()){
              String key = keySetIterator.next();
              Aliment alim = new Aliment(HashPoisson.get(key),key);
              arrayListAliments.add(alim);
          }
      }
}
