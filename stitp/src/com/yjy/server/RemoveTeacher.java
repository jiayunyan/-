package com.yjy.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.service.TeacherManager;

public class RemoveTeacher extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msg = "删除失败";
		int id = Integer.parseInt(request.getParameter("id"));
		TeacherManager manager = new TeacherManager();
		try {
			boolean result = manager.removeTeacher(id);
			if( result == true ){
				msg = "删除成功";
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>删除结果</TITLE>");
		out.println("<link rel='stylesheet' type='text/css' href='style/style.css'>");
		out.println("</HEADER>");
		out.println("  <BODY>");
		out.println("<CENTER>");
		out.println(msg);
		out.println("<BR>");
		out.println("<A HREF='index.jsp'>返回首页</A>");
		out.println("</CENTER>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
