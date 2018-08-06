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
    
    <title>学生信息管理</title>
    
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
                <td>序号</td><td>姓名</td><td>性别<td>学号</td><td>专业</td><td>操作</td>
              </tr>
            </thead>
            <tbody>
              <%
                StudentManager manager = new StudentManager();
                List<StudentInfo> result = manager.queryAll();
              %>
              <%for(StudentInfo student : result ) {%>
                 <tr>
                 <td><%=student.getId() %></td><td><%=student.getName() %></td><td><%=student.getGender() %><td><%=student.getStudentID() %></td><td><%=student.getMajor() %></td><td><a href="RemoveStudent?id=<%=student.getId() %>">删除</a>|<a href="">修改</a></td>
                </tr>
              <%} %>
            </tbody>
    	</table>
    </div>
    </div>
  </body>
</html>
