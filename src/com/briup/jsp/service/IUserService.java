package com.briup.jsp.service;

import com.briup.jsp.bean.User;

/**
 * ҵ���߼���
 * ҵ����	�û�����
 * 			ע��
 * 			��½
 * 			�鿴
 * 			�޸�
 * 			ע��
 * 
 * */
public interface IUserService {
	String registerUser(User user);
	String loginUser(String username,String password);
	String selectUserByName(String user);
	void updateUser(User user);
	void deleteUser(User user);
}
