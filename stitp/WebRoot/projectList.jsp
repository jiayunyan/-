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
    
    <title>项目信息管理</title>
    
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
                <td>序号</td><td>项目名</td><td>项目编号</td><td>项目类别</td><td>开展时间</td>
              </tr>
            </thead>
            <tbody>
            <%
              ProjectManager manager = new ProjectManager();
              List<ProjectInfo>  result = manager.queryAll();
            %>
            
            <%for(ProjectInfo project : result ){ %>
                <tr>
                <td><%=project.getId() %></td><td><%=project.getName() %></td><td><%=project.getProjectid() %></td><td><%=project.getType() %></td><td><%=project.getTime() %></td>
              </tr>
            <%} %>
              
            </tbody>
    	</table>
    </div>
    </div>
   
  </body>
</html>
