package com.briup.jsp.service.impl;

import com.briup.jsp.bean.User;
import com.briup.jsp.dao.impl.UserDaoImpl;
import com.briup.jsp.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public String registerUser(User user) {
		//���ʵ��ע��  		���� user
		//1.�ж��û����Ƿ�ռ�� 
			//����Dao��
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User user2=userDaoImpl.selectUserByName(user.getName());
		if(user2==null){
			//2.û��ע�� ִ��ע����� ����ok
			userDaoImpl.saveUser(user);
			return "ok";
		}else {
			//3.ע�� �򷵻�error
			return"error";
		}
	}

	@Override
	public String loginUser(String username, String password) {

		return null;
	}

	@Override
	public String selectUserByName(String user) {
	
		return null;
	}

	@Override
	public void updateUser(User user) {
	
		
	}

	@Override
	public void deleteUser(User user) {

		
	}

}
