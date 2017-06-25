package cn.chenhuanran.app.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyHellper extends SQLiteOpenHelper {

	public MyHellper(Context context) {
		super(context, "breakfast.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String str = "create table breakfast_info(_id integer primary key autoincrement,meal text,way text,time text);";
		db.execSQL(str);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	

}

