package com.example.mysqlite;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends ListActivity implements OnClickListener{

	private MySQLite dh;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        ListView listview = (ListView) findViewById(R.id.lista);
        List<String> lista = this.dh.selectAll();
        
        this.dh = new MySQLite(this);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lista);
        listview.setAdapter(adapter);
        //valor = getValor(); //from sqlite
        
        //lista.add(valor);
        //SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.listitemlayout,c, from, to);
        
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
