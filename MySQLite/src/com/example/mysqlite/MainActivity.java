package com.example.mysqlite;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity{

	EditText input;
	EditText date;
	EditText time;
	
	Button button;
	MySQLite dh;
	String string;
	String _date;
	String _time;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        input = (EditText) findViewById(R.id.texto);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
    	button = (Button) findViewById(R.id.botao);
    	string = input.getText().toString();
		_date = date.getText().toString();
    	_time = time.getText().toString();
        dh = new MySQLite(this);
        
        button.setOnClickListener( new View.OnClickListener(){

    		@Override
    		public void onClick(View view) {
    			// TODO Auto-generated method stub
    			string = input.getText().toString();
    			_date = date.getText().toString();
    	    	_time = time.getText().toString();
    			// this.dh.deleteAll();
    	        dh.insert(string,_date,_time);
    			Intent intentMain = new Intent(view.getContext(),SecondActivity.class);
    			intentMain.putExtra("info",string);
    			startActivity(intentMain);
    		}
        	
        });
        
        
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
