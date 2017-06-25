package cn.chenhuanran.app.dao;

import java.util.List;

import cn.chenhuanran.app.bean.BreakFast;



public interface BreakFastDao {
	
	void insert();
	void insert(BreakFast breakf);
	void update(String meal, BreakFast breakf);
	BreakFast query(String meal);
	List<BreakFast> queryAll();
	
}
