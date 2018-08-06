package com.yjy.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.bean.TeacherInfo;
import com.yjy.service.TeacherManager;

public class SaveTeacher extends HttpServlet {

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
        String msg = "录入老师信息失败";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//获取请求参数
		String name = request.getParameter("name");
		String gender = request.getParameter("gender").trim();
		if( name != null && gender != null ){
			TeacherManager manager = new TeacherManager();
			TeacherInfo teacher = new TeacherInfo();
			teacher.setGender(gender);
			teacher.setName(name);
			try {
				manager.addTeacher(teacher);
				msg = "教师信息录入成功";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(msg);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
