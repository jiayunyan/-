package com.yjy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yjy.bean.TeacherInfo;
import com.yjy.db.ConnDB;

/**
 * 与教师有关的相关的业务逻辑处理
 * @author zhanghongbin01
 *
 */
public class TeacherManager {
	private ConnDB connDB;
	
	public TeacherManager(){
		connDB = new ConnDB();
	}
	
	/**
	 * 录入老师信息
	 * @param teacherInfo
	 * @return
	 * @throws SQLException
	 */
	public boolean addTeacher(TeacherInfo teacherInfo) throws SQLException{
		String sql = "INSERT INTO teacher(gender,name) VALUE('"+teacherInfo.getGender()+"','"+teacherInfo.getName()+"')";
		return connDB.doUpdate(sql);
	}
	
	/**
	 * 删除老师信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean removeTeacher(int id) throws SQLException{
		String sql = "DELETE FROM teacher WHERE id="+id+"";
		return connDB.doUpdate(sql);
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
	public boolean updateName(int id,String name) throws SQLException{
		String sql = "UPDATE teacher SET name='"+name+"' WHERE id="+id+"";
		return connDB.doUpdate(sql);
	}
	
	/**
	 * 通过名字来获取ID
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public int getIdByName(String name) throws SQLException{
		int id = -1;
		String sql = "SELECT * FROM teacher WHERE name='"+name+"'";
		ResultSet rs = connDB.doQuery(sql);
		if( rs != null ){
			while(rs.next()){
				id = rs.getInt("id");
			}
		}
		return id;
	}
	
	public List<TeacherInfo> queryAll() throws SQLException{
		List<TeacherInfo> result = new ArrayList<TeacherInfo>();
		String sql = "SELECT * FROM teacher";
		ResultSet rs = connDB.doQuery(sql);
		while( rs.next() ){
			TeacherInfo teacher = new TeacherInfo();
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			int id = rs.getInt("id");
			teacher.setGender(gender);
			teacher.setId(id);
			teacher.setName(name);
			result.add(teacher);
		}
		return result;
	}
}
