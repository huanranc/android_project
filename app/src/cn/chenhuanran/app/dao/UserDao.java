package cn.chenhuanran.app.dao;

import java.util.List;

import cn.chenhuanran.app.bean.User;


public interface UserDao {

	void insert(User user);
	void delete(String name);
	void update(User user);
	User query(String username);

}
