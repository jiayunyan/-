package com.yjy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yjy.bean.StudentInfo;
import com.yjy.db.ConnDB;

/**
 * 学生管理
 * 
 * @author zhanghongbin01
 * 
 */
public class StudentManager {
	private ConnDB connDB;

	/**
	 * 执行初始化操作，获取到数据库操作的工具或者叫做接口
	 */
	public StudentManager() {
		connDB = new ConnDB();
	}
    
	/**
	 * 录入学生信息
	 * @param studentInfo     要录入的学生信息实体bean
	 * @return                录入的返回结果
	 * @throws SQLException   抛出的异常
	 */
	public boolean addStudent(StudentInfo studentInfo) throws SQLException {
		String sql = "INSERT INTO student(gender,major,name,studentID) VALUE('"
				+ studentInfo.getGender() + "','" + studentInfo.getMajor()
				+ "','" + studentInfo.getName() + "','"
				+ studentInfo.getStudentID() + "')";
	   return connDB.doUpdate(sql);
	}
	
	/**
	 * 删除学生信息
	 * @param id             要删除的学生的ID
	 * @return               删除的结果
	 * @throws SQLException  数据库操作的异常
	 */
	public boolean removeStudent(int id) throws SQLException{
		String sql = "DELETE FROM student WHERE id="+id+"";
		return connDB.doUpdate(sql);
	}
	
	/**
	 * 修改学生的名字
	 * @param id        要修改的学生的ID
	 * @param name      修改的目标名字
	 * @return          修改的结果
	 * @throws SQLException  数据库异常
	 */
	public boolean updateName(int id,String name) throws SQLException{
		String sql = "UPDATE student SET name='"+name+"' WHERE id="+id+"";
		return connDB.doUpdate(sql);
	}
	
	/**
	 * 修改学生的专业
	 * @param id        要修改的学生的ID
	 * @param name      修改的目标专业
	 * @return          修改的结果
	 * @throws SQLException  数据库异常
	 */
	public boolean updateMajor(int id,String major) throws SQLException{
		String sql = "UPDATE student SET major='"+major+"' WHERE id="+id+"";
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
		String sql = "SELECT * FROM student WHERE name='"+name+"'";
		ResultSet rs = connDB.doQuery(sql);
		if( rs != null ){
			while(rs.next()){
				id = rs.getInt("id");
			}
		}
		return id;
	}
	
	/**
	 * 获取所有学生的信息
	 * @return
	 * @throws SQLException
	 */
	public List<StudentInfo> queryAll() throws SQLException{
		List<StudentInfo> result = new ArrayList<StudentInfo>();
		String sql = "SELECT * FROM student";
		ResultSet rs = connDB.doQuery(sql);
		while( rs.next() ){
			StudentInfo student = new StudentInfo();
			String gender = rs.getString("gender");
			int id = rs.getInt("id");
			String major = rs.getString("major");
			String name = rs.getString("name");
			String studentID = rs.getString("studentid");
			student.setGender(gender);
			student.setId(id);
			student.setMajor(major);
			student.setName(name);
			student.setStudentID(studentID);
			result.add(student);
		}
		return result;
	}
}
