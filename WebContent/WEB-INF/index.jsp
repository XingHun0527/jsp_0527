<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" session="true" isThreadSafe="true" autoFlush="true"  errorPage="error.jsp" %>
<%@ page import="java.lang.Object" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Jsp</title>
</head>
<body>
	<div>
		<form action=""></form>
		<hr>
	</div>
	<!-- 编写Java代码 -->
	<!-- 一：jsp脚本元素 -->
	<!-- 1.表达式 打印到浏览器  打印到控制台 System.out.println(东西);-->
	<%="helloworld" %>
	<%=1 %>
	<%=1+1 %>
	<%=request.getMethod()%>
	<!-- 2.脚本  编写代码 位于_jspService方法中-->
	<%
		int a=10;
		int b=0;
		int sum=a+b;
		int dev=a/b;
		System.out.println(sum);
		System.out.println(request);
		System.out.println(response);
		//从请求中获取参数
		String value1=request.getParameter("test");
		System.out.println("value1="+value1);
		//response.sendRedirect("registe+ 1r.html");
	%>
	<!-- 3.声明  可以在该类中定义方法和属性-->
	<%!
		//属性
		private int age;
		//方法
		public void test1(String info){
			System.out.println("--"+info+"--");
		}
	%>
	<%
		//调用自定义方法
		test1("Index");
	%>
	<!-- 二：jsp指令元素 -->
	<!-- 1. page 指令 -->
</body>
</html>