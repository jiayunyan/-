package com.yjy.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.bean.StudentInfo;
import com.yjy.service.StudentManager;

public class SaveStudent extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String msg = "学生信息录入失败";
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String studentid = request.getParameter("studentid");
		String major = request.getParameter("major");
		if( name != null && gender !=null && studentid!=null && major!=null ){
			StudentManager manager = new StudentManager();
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setGender(gender);
			studentInfo.setMajor(major);
			studentInfo.setName(name);
			studentInfo.setStudentID(studentid);
			try {
				manager.addStudent(studentInfo);
				msg = "学生信息录入成功";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		PrintWriter out = response.getWriter();
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
