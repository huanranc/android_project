package cn.chenhuanran.app.dao;

import java.util.ArrayList;
import java.util.List;

import cn.chenhuanran.app.bean.User;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDaoImpl implements UserDao {

	private MyHellper2  myHelper;
	private SQLiteDatabase db;
	public UserDaoImpl(Context context){
		myHelper=new MyHellper2(context);
	}
	@Override
	public void insert(User user) {
		db=myHelper.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("username", user.getUsername());
		cv.put("password", user.getPassword());
		db.insert("user_info", null, cv);
		db.close();
	}

	@Override
	public void delete(String name) {
		db = myHelper.getWritableDatabase();
		db.delete("user_info", "username = ?", new String[]{name});
		db.close();
	}

	@Override
	public void update(User user) {
		db = myHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("password", user.getPassword());
		db.update("user_info", values, "username = ?", new String[]{user.getUsername()});
		db.close();	
	}

	@Override
	public User query(String username) {
		User name= null;
		db = myHelper.getWritableDatabase();
		Cursor cursor = db.query("user_info", null, "username=?",new String[]{username}, null, null, null);
		while(cursor.moveToNext()){
			String password=cursor.getString(2);
			name=new User(username,password);
		}
		cursor.close();
		db.close();
		return name;
	}


}
