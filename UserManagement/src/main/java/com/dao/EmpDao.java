package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Emp;
import com.util.EmpUtil;

public class EmpDao {

	public static void signupEmp(Emp e)
	{
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="insert into emp(fname,lname,email,mobile,password) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, e.getFname());
			pst.setString(2, e.getLname());
			pst.setString(3, e.getEmail());
			pst.setLong(4, e.getMobile());
			pst.setString(5, e.getPassword());
			pst.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public static boolean checkEmail(String email)
	{
		boolean flag=false;
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="select * from emp where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static Emp loginEmp(String email)
	{
		Emp e=null;
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="select * from emp where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				e=new Emp();
				e.setEid(rs.getInt("eid"));
				e.setFname(rs.getString("fname"));
				e.setLname(rs.getString("lname"));
				e.setEmail(rs.getString("email"));
				e.setMobile(rs.getLong("mobile"));
				e.setPassword(rs.getString("password"));
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;
	}
	public static void changePassword(String email,String password)
	{
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="update emp set password=? where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
