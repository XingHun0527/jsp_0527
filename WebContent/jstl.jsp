<%@page import="com.briup.jsp.bean.User"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
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
	
	Set<String> set=new HashSet<>();
	set.add("山竹");
	set.add("榴莲");
	set.add("芒果");
	
	application.setAttribute("set", set);
	
	User u1=new User(67891,"lisi","123","男");
	User u2=new User(21234,"til","167","男");
	User u3=new User(31883,"lily","113","女");
	
	Map<Integer,User> map2 = new HashMap<>();
	map2.put(u1.getId(),u1);
	map2.put(u2.getId(),u2);
	map2.put(u3.getId(),u3);
	
	session.setAttribute("map2", map2);
	
	
	%>
	<!--
		for(数据类型 变量:数组/集合){}
		遍历数组  
		iterms 需要遍历的数组/集合
		var 每一个元素接受的变量名
		begin="0" end="10" step="2"
	-->
	<c:forEach items="${arr123 }" var="num">
		${num }
	</c:forEach>
	<br>
	<!-- 遍历list集合 -->
	<c:forEach items="${fruits }" var="fruit">
		${fruit }<br>
	</c:forEach>
	<hr>
	<!-- 遍历set集合 -->
	<c:forEach items="${set }" var="x">
		${x }<br>
	</c:forEach>
	<!-- 遍历Map集合 -->
	<c:forEach items="${map }" var="kv">
		${kv.key}-${kv.value }<br>
	</c:forEach>
	<hr>
	<c:forEach items="${map2 }" var="kv">
		${kv.key}-${kv.value.name }<br>
	</c:forEach>
	<table border="1">
		<caption>用户列表</caption>
		<thead>
			<tr>
				<td>序号</td>
				<td>名称</td>
				<td>密码</td>
				<td>性别</td>
				<td>身份证</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${map2 }" var="kv" varStatus="s" >
				<tr>
					<td>${s.index+1 }</td>
					<td>${kv.value.name }</td>
					<td>${kv.value.passwd }</td>
					<td>${kv.value.gender }</td>
					<td>${kv.key }</td>
				</tr>
			</c:forEach>
			
			
		</tbody>
	</table>
	<!-- c:if -->
	<%
		request.setAttribute("score", 57);
		request.setAttribute("info", 2880);
	%>
	<c:if test="${score>=60 }">
		<font color="red">好高兴啊，及格了！</font>
	</c:if>
	<c:if test="${score<60 }">
		<font >太伤心了，居然没及格！</font>
	</c:if>
	
	<!-- 积分 0-500  500-2000  2000-5000 5000-10000 10.。。。    -->
	<c:choose>
		<c:when test="${info<100 }">青铜</c:when>
		<c:when test="${info<500 }">白银</c:when>
		<c:when test="${info<2000 }">黄金</c:when>
		<c:otherwise>钻石</c:otherwise>
	</c:choose>
</body>
</html>