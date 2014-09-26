package com.example.mysqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends Activity{

	private MySQLite dh;
	ListView listview;
	List<String> lista_a;
	List<String> lista_b;
	List<String> lista_c;
	String name;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        
        this.dh = new MySQLite(this);
        
        listview = (ListView) findViewById(R.id.lista);
        lista_a = new ArrayList<String>();
        lista_b = new ArrayList<String>();
        lista_c = new ArrayList<String>();
        name = this.getIntent().getStringExtra("info");
        
        lista_a.addAll(this.dh.SelectAllTime(name));
        //lista_c.addAll(this.dh.SelectAll());
        
        lista_b.addAll(this.dh.SelectAllDate(name));
        
        
       // lista.add(this.dh.selectLine());
       /* final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, lista);
        listview.setAdapter(adapter);*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lista_b);
        listview.setAdapter(adapter);
        //valor = getValor(); //from sqlite
        
        //lista.add(valor);
        //SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.listitemlayout,c, from, to);
        
	}
	
	private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }

}
