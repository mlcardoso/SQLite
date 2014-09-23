package com.example.mysqlite;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	EditText input = (EditText) findViewById(R.id.texto);
	Button button = (Button) findViewById(R.id.botao);
	private MySQLite dh;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.dh = new MySQLite(this);
        this.dh.deleteAll();
        this.dh.insert(getTexto());
        
       View.OnClickListener handler = new View.OnClickListener(){

    		@Override
    		public void onClick(View view) {
    			// TODO Auto-generated method stub
    			Intent intentMain = new Intent(MainActivity.this,SecondActivity.class);
    			startActivity(intentMain);
    		}
        	
        };
        
        button.setOnClickListener(handler);
        
    }

	
    
    //getTexto
    public String  getTexto(){
    	EditText input = (EditText) findViewById(R.id.texto);
    	String string = input.getText().toString();
    	return string;
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



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
