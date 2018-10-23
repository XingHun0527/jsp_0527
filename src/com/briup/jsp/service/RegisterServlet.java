package com.briup.jsp.service;

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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ܲ���
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zip = request.getParameter("zip");
		String address = request.getParameter("address");
		//1.2��װ��һ����
		User user = new User();
		user.setName(name);
		user.setPassword(password);
/*		user.setZip(zip);
		user.setAddress(address);*/
		//2.����service����
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		String info = userServiceImpl.registerUser(user);
		//3.���ݷ��ؽ�������в�ͬҳ����ת
		if("ok".equals(info)){
			//ע��ɹ�
			response.sendRedirect("login.html");
		}else{
			//ע��ʧ��
			response.sendRedirect("register.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
