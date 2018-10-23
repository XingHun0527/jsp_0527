package com.briup.jsp.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.jsp.bean.User;
import com.briup.jsp.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/One")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ղ���
		String name=request.getParameter("name");
		String password=request.getParameter("password");	
		String zip=request.getParameter("zip");
		String address=request.getParameter("address");
		String telephone=request.getParameter("telephone");
		String email=request.getParameter("email");
		//1.2 ��װ����
		User user=new User();
		user.getName();
		user.getPassword();
		user.getGender();
		
		//2.����service����
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		String info=userServiceImpl.registerUser(user);
		//3.���ݷ��ؽ�������в�ͬҳ����ת++
		
		if("ok".equals(info)) {
			//ע��ɹ�
			response.sendRedirect("login.html");
		}else {
			//ע��ʧ��
			response.sendRedirect("register.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
