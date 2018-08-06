package com.yjy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yjy.bean.ProjectInfo;
import com.yjy.db.ConnDB;

public class ProjectManager {
	private ConnDB connDB;

	public ProjectManager() {
		connDB = new ConnDB();
	}

	/**
	 * 录入项目信息
	 * 
	 * @param project
	 * @return
	 * @throws SQLException
	 */
	public boolean addProject(ProjectInfo project) throws SQLException {
		String sql = "INSERT INTO project(name,projectid,studentid,teacherid,time,type) VALUE('"
				+ project.getName()
				+ "','"
				+ project.getProjectid()
				+ "','"
				+ project.getStuddentid()
				+ "','"
				+ project.getTeacherid()
				+ "','" + project.getTime() + "','" + project.getType() + "')";
		return connDB.doUpdate(sql);
	}
    
	/**
	 * 查看立项情况
	 * @return
	 * @throws SQLException
	 */
	public List<ProjectInfo> queryAll() throws SQLException {
		String sql = "SELECT * FROM project";
		ResultSet rs = connDB.doQuery(sql);
		List<ProjectInfo> result = null;
		if( rs != null ){
			result = new ArrayList<ProjectInfo>();
			while(rs.next()){
				ProjectInfo project = new ProjectInfo();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String projectid = rs.getString("projectid");
				int studentid = rs.getInt("studentid");
				int teacherid = rs.getInt("teacherid");
				String time = rs.getString("time");
				String type = rs.getString("type");
				
				project.setId(id);
				project.setName(name);
				project.setProjectid(projectid);
				project.setStuddentid(studentid);
				project.setTeacherid(teacherid);
				project.setTime(time);
				project.setType(type);
				
				result.add(project);
			}
		}
		return result;
	}
}
