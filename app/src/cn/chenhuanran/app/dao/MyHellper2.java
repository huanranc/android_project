package cn.chenhuanran.app.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHellper2 extends SQLiteOpenHelper{

	public MyHellper2(Context context) {
		super(context, "user.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String str = "create table user_info(_id integer primary key autoincrement,username text not null,password text);";
		db.execSQL(str);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		

	}
		
}
