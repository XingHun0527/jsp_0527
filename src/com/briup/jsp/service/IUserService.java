package com.briup.jsp.service;

import com.briup.jsp.bean.User;

/**
 * 业务逻辑层
 * 业务功能	用户功能
 * 			注册
 * 			登陆
 * 			查看
 * 			修改
 * 			注销
 * 
 * */
public interface IUserService {
	String registerUser(User user);
	String loginUser(String username,String password);
	String selectUserByName(String user);
	void updateUser(User user);
	void deleteUser(User user);
}
