<%@page import="java.awt.List"%>
<%@page import="java.io.Console"%>
<%@page import="kr.or.connect.todolist.dto.TodoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	String[] todoTypes = {"TODO", "DOING", "DONE"};
	request.setAttribute("todoTypes", todoTypes);

%>

<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>todolist</title>
</head>
<body>

<div class="display_all">
 <header class="headers">
  <h1 class="todo_list">TODOLIST</h1>
  <button class="todo_register" onclick="location.href='todo.html'">register</button>
 </header>
 
<section class="sections">
	<div class="section_list">
		<c:forEach var="todoType" items="${todoTypes}">
			<ul id="${todoType}" class="todoType">
		
			<li class="${todoType}">${todoType}</li>
			<c:forEach var="list" items="${todoList}"> 
					<c:if test="${todoType eq list.type }">
					<li class="list">
						<p class="list_title">${list.title }</p>
						<div class="list_info">
						등록날자 : 2020.04.13,
						${list.name},  우선순위 : ${list.sequence}						
						<c:if test="${todoType ne 'DONE'}">
						<input class="next" type="button" value="->" onclick="clicked(${list.id}, this)"/>										
						</c:if>		
						</div>	
									
					</li>
					</c:if>
			
			</c:forEach>
				</ul>
		</c:forEach>
	</div>
	
										
</section> 
</div>
</body>
	<script src="todo.js" type="text/javascript"></script>


</html>