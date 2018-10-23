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
		//1.接受参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zip = request.getParameter("zip");
		String address = request.getParameter("address");
		//1.2封装下一数据
		User user = new User();
		user.setName(name);
		user.setPassword(password);
/*		user.setZip(zip);
		user.setAddress(address);*/
		//2.调用service方法
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		String info = userServiceImpl.registerUser(user);
		//3.根据返回结果，进行不同页面跳转
		if("ok".equals(info)){
			//注册成功
			response.sendRedirect("login.html");
		}else{
			//注册失败
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
