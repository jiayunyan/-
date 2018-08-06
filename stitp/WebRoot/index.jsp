<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>STITP项目管理系统</title>
	
	
	<link href="style/style.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script src="js/common.js" type="text/javascript"></script>
  </head>
  
  <body>
    <div class="layout_header">
        <div class="header">
        	<h3>欢迎使用STITP管理系统</h3>
        </div>
    </div><hr>
    
    <div class="layout_leftnav">
    <div class="inner">
        <div class="nav-vertical">
            <ul class="accordion">
                <li id="one"> <a href="#one">学生管理<span></span></a>
                    <ul class="sub-menu">
                        <li><a href="saveStudent.html" target="content">录入信息</a></li>
                        <li><a href="studentList.jsp" target="content">学生管理</a></li>
                    </ul>
                </li>
                <li id="two"> <a href="#two">老师管理<span></span></a>
                    <ul class="sub-menu">
                        <li><a href="saveTeacher.html" target="content">录入信息</a></li>
                        <li><a href="teacherList.jsp" target="content">教师管理</a></li>
                    </ul>
                </li>
                <li id="three"> <a href="#three">立项管理<span></span></a>
                    <ul class="sub-menu">
                        <li><a href="projectSave.html" target="content">录入信息</a></li>
                        <li><a href="projectList.jsp" target="content">立项情况</a></li>
                    </ul>
                </li>
                
            </ul>
            <script type="text/javascript">
                $(document).ready(function() {
                    // Store variables
                    var accordion_head = $('.accordion > li > a'),
                            accordion_body = $('.accordion li > .sub-menu');
                    // Open the first tab on load
                    accordion_head.first().addClass('active').next().slideDown('normal');
                    // Click function
                    accordion_head.on('click', function(event) {
                        // Disable header links
                        event.preventDefault();
                        // Show and hide the tabs on click
                        if ($(this).attr('class') != 'active'){
                            accordion_body.slideUp('normal');
                            $(this).next().stop(true,true).slideToggle('normal');
                            accordion_head.removeClass('active');
                            $(this).addClass('active');
                        }
                    });
                });
            </script>
        </div>
    </div>
</div>
<div class="layout_rightmain">
    <iframe width="100%" height="100%" src="tip.html" name="content"></iframe>
</div>

<div class="layout_footer">&copy; 版权所有  </div>
<script>
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cdiv style='display:none;' %3E %3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fa04bc642fb15cb6b591f8fe5423f1bc2' type='text/javascript'%3E%3C/script%3E"));
</script>
  </body>
</html>
