<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yjy.service.*" %>
<%@ page import="com.yjy.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师信息管理</title>
    
	<link href="style/style.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script src="js/common.js" type="text/javascript"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <div class="layout_allmain">
	    <div class="list-table ">
	    	<table>
	            <thead>
	              <tr>
	                <td>序号</td><td>姓名</td><td>性别</td><td>操作</td>
	              </tr>
	            </thead>
	            <tbody>
	              <% 
	                 TeacherManager manager = new TeacherManager();
	                 List<TeacherInfo> result = manager.queryAll();
	              %>
	              <%for(TeacherInfo teacher : result ) {%>
	                 <tr>
	                <td><%=teacher.getId() %></td><td><%=teacher.getName() %></td><td><%=teacher.getGender() %></td><td><a href="RemoveTeacher?id=<%=teacher.getId()%>">删除</a></td>
	              </tr>
	              <%} %>
	              
	            </tbody>
	    	</table>
	    </div>
    </div>
  </body>
</html>
