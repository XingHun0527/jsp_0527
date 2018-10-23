package com.briup.jsp.dao;

import java.util.List;

import com.briup.jsp.bean.User;

/**
 * �����ݿ��е��û�����н���
 * ��ɾ�Ĳ�
 * */
public interface IUserDao {
	void saveUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
	User selectUserByName(String name);
	List<User> selectAllUser();
	
}
