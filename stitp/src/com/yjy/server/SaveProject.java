package com.yjy.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.bean.ProjectInfo;
import com.yjy.service.ProjectManager;
import com.yjy.service.StudentManager;
import com.yjy.service.TeacherManager;

public class SaveProject extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msg = "项目信息录入失败";
		String name = request.getParameter("name");
		String projectid = request.getParameter("projectid");
		String studentname = request.getParameter("studentname");
		String teachername = request.getParameter("teachername");
		String projecttype = request.getParameter("projecttype");
		String projecttime = request.getParameter("projecttime");
		StudentManager studentManager = new StudentManager();
		TeacherManager teacherManager = new TeacherManager();
		
		if( name != null ){
			int sid = -1;
			int tid = -1;
			try {
				sid = studentManager.getIdByName(studentname);
				tid = teacherManager.getIdByName(teachername);
			} catch (SQLException e1) {
			    e1.printStackTrace();
			}
			if(sid>0 && tid>0){
				ProjectManager manager = new ProjectManager();
				ProjectInfo project = new ProjectInfo();
				project.setName(name);
				project.setProjectid(projectid);
				//project.setStuddentid(studdentid);
				//project.setTeacherid(teacherid);
				project.setTime(projecttime);
				project.setType(projecttype);
				try {
					manager.addProject(project);
					msg = "项目信息录入成功";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				msg = "您输入的学生或者老师的信息不存在，请确认";
			}
			
		}
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(msg);
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
