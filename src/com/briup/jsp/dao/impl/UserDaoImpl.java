package com.briup.jsp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.briup.jsp.bean.User;
import com.briup.jsp.dao.IUserDao;
import com.briup.jsp.utils.ConnectionFactory;

public class UserDaoImpl implements IUserDao{

	@Override
	public void saveUser(User user) {
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			//1.获取连接对象
			connection=ConnectionFactory.getConnection();
			//2.获取搬运工对象
			String sql="insert into briup_user(id,username,password) values(briup_user_seq.nextval,?,?)";
			pStatement=
					connection.prepareStatement(sql);
			//3.执行SQL语句
			pStatement.setString(1,user.getName());
			pStatement.setString(2,user.getPassword());
			pStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5.关闭资源
			ConnectionFactory.close(connection, pStatement, null);
		}
	}

	@Override
	public void deleteUser(User user) {
		
	}

	@Override
	public void updateUser(User user) {
		
	}

	@Override
	public User selectUserByName(String name) {
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet resultSet=null;
		User user=null;
		try {
			//1.获取连接对象
			connection=ConnectionFactory.getConnection();
			//2.获取搬运工对象
			String sql="select id,username,password from briup_user where username = ?";
			pStatement=
					connection.prepareStatement(sql);
			//3.执行SQL语句
			pStatement.setString(1, name);
			resultSet=pStatement.executeQuery();
			//4.处理结构集
			while(resultSet.next()) {
				user=new User();
				int id=resultSet.getInt("id");
				String username=resultSet.getString("username");
				String password=resultSet.getString("password");
				user.setId(id);
				user.setName(username);
				user.setPassword(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5.关闭资源
			ConnectionFactory.close(connection, pStatement, resultSet);
		}
		return user;
	}

	@Override
	public List<User> selectAllUser() {
		return null;
	}

}

