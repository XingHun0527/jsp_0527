<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.jsp.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式</title>
</head>
<body>
	<!-- el 取值操作  从范围中取值 -->
	<!-- 1.接受客户端参数  浏览器  -->
	a:<%=request.getParameter("a") %>
	<hr>
	a:${param.a }
	<%
		//往范围中放值  pageContext request session application
		pageContext.setAttribute("p1", "拍");
		request.setAttribute("r1", "djkn");
		request.setAttribute("p1", "蚊子");
		session.setAttribute("s1", 12);
		application.setAttribute("a1", 89);
		
		User user=new User(1,"大于","123","男");
		session.setAttribute("user", user);
		
		int[] arr={1,2,43,5};
		request.setAttribute("arr123", arr);
		
		List<String> list=new ArrayList<>();
		list.add("山竹");
		list.add("榴莲");
		list.add("芒果");
		
		application.setAttribute("fruits", list);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a",100);
		map.put("b",200);
		map.put("c",300);
		
		session.setAttribute("map", map);
		
	%>
	<hr>
	<!-- 2.根据范围对象从范围中取值 -->
	p:<%=pageContext.getAttribute("p1") %>
	r:<%=request.getAttribute("r1") %>
	p:${pageScope.p1 }
	r:${requestScope.r1 }
	s:${sessionScope.s1 }
	a:${applicationScope.a1 }
	<hr>
	<!-- 3.直接从范围中取值 pageContext->request->session->application -->
	${p1}-${r1}-${s1}-${a1}
	${requestScope.p1 }
	<hr>
	<!-- 4.从范围中取值 对象 获取属性 -->
	${sessionScope.user }<br>
	${user }<br>
	Id:${user.id}<br>
	name:${user.name }<br>
	gender:${user.gender }<br>
	passwd:${user.passwd }<br>
	<!-- 5.输出字符串  -->
	${"hello" }
	hello
	<!-- 6.输出运算结果或者boolean表达式 -->
	${1+1 }
	${1>3?"真":"飞针走线" }
	${empty "" }
	${empty "123" }
	${empty  user}
	${! empty  "123"}
	${not empty  "123"}
	<!-- 7.输出数组、集合中的元素 -->
	${requestScope.arr123 }
	${arr123 }
	${arr123[0] }
	${arr123[1] }
	${arr123[2] }
	${arr123[10] }
	${applicationScope.fruits }
	${fruits }
	${fruits[0] }
	${fruits[1] }
	${fruits[2] }
	${map }
	${map["a"] }
	${map["b"] }
	${map["c"] }
	
</body>
</html>