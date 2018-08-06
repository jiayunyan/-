package com.yjy.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.service.StudentManager;

public class UpdateStudent extends HttpServlet {

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
		String action = request.getParameter("action");
		String msg = "学生信息修改失败";
		int id = Integer.parseInt(request.getParameter("id"));
		StudentManager studentManager = new StudentManager();
		if( action.equals("updatename")){
			//修改名字
			String name = request.getParameter("name");
			if( name != null){
				try {
					studentManager.updateName(id, name);
					msg = "学生信息修改成功";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if( action.equals("updatemajor")){
			//修改专业
			String major = request.getParameter("major");
			if( major != null ){
				try {
					studentManager.updateMajor(id, major);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	    msg = "学生信息修改失败";
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
