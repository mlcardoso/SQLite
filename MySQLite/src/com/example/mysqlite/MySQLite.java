package com.example.mysqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class MySQLite {
	
	private static final String DATABASE_NAME = "lixo.db";
	   private static final int DATABASE_VERSION = 1;
	   private static final String TABLE_NAME = "teste";
	   private Context context;
	   private SQLiteDatabase db;
	   private SQLiteStatement insertStmt;
	   private static final String INSERT = "insert into "
			      + TABLE_NAME + "(name) values (?)";
	   

	   
	public MySQLite(Context context) {
		this.context = context;
	    OpenHelper openHelper = new OpenHelper(this.context);
	    this.db = openHelper.getWritableDatabase();
	    this.insertStmt = this.db.compileStatement(INSERT);
		// TODO Auto-generated constructor stub
	}
	
	 public long insert(String name) {
	      this.insertStmt.bindString(1, name);
	      return this.insertStmt.executeInsert();
	 }
	 public void deleteAll() {
	      this.db.delete(TABLE_NAME, null, null);
	   }

	   public List<String> selectAll() {
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = this.db.query(TABLE_NAME, new String[] { "name" },
	        null, null, null, null, "name desc");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	  }


	private static class OpenHelper extends SQLiteOpenHelper {

		OpenHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	     }

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY, name TEXT)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}

}

