package cn.chenhuanran.app.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import cn.chenhuanran.app.bean.BreakFast;

public class BreakFastDaoImpl extends BreakFast implements BreakFastDao {
	
	private MyHellper myHellper;
	private SQLiteDatabase db;
	
	@Override
	public void update(String meal,BreakFast breakf) {
		// TODO Auto-generated method stub
		db = myHellper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("meal",breakf.getMeal() );
		values.put("way", breakf.getWay());
		values.put("time",breakf.getTime() );
		db.update("breakfast_info", values, "meal = ?", new String[]{meal});
		db.close();
	}

	@Override
	public BreakFast query(String meal) {
		// TODO Auto-generated method stub
		BreakFast breakf = null;
		db = myHellper.getReadableDatabase();
		Cursor cursor = db.query("breakfast_info", null, "meal = ?", new String[]{meal}, null, null, null);
		while(cursor.moveToNext()){
			breakf = new BreakFast(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
		}
		cursor.close();
		db.close();
		return breakf;
	}

	@Override
	public List<BreakFast> queryAll() {
		// TODO Auto-generated method stub
		List<BreakFast> breakfList = new ArrayList<BreakFast>();
		db = myHellper.getReadableDatabase();
		Cursor cursor = db.query("breakfast_info", null, null, null, null, null, null);
		while(cursor.moveToNext()){
			BreakFast breakf = new BreakFast(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
			breakfList.add(breakf);
		}
		cursor.close();
		db.close();
		return breakfList;
	}
	
	public BreakFastDaoImpl(Context context) {
		myHellper = new MyHellper(context);
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		db = myHellper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("meal","包子" );
		values.put("way", "来源食堂");
		values.put("time","9:00" );
		db.insert("breakfast_info", null, values);
		db.close();
	}

	@Override
	public void insert(BreakFast breakf) {
		// TODO Auto-generated method stub
		db = myHellper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("meal",breakf.getMeal() );
		values.put("way", breakf.getWay());
		values.put("time",breakf.getTime() );
		db.insert("breakfast_info", null, values);
		db.close();
	}
}
