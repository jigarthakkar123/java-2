package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Car;
import com.util.UserUtil;

public class CarDao {

	public static void addCar(Car c)
	{
		try {
			Connection conn=UserUtil.create_conn();
			String sql="insert into tblcar(uid,car_company,car_name,car_mileage,car_transmission,car_capacity,car_luggage_cap,car_fuel,car_image,car_ppd) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, c.getUid());
			pst.setString(2,c.getCar_company());
			pst.setString(3,c.getCar_name());
			pst.setInt(4,c.getCar_mileage());
			pst.setString(5,c.getCar_transmission());
			pst.setInt(6,c.getCar_capacity());
			pst.setInt(7,c.getCar_luggage_cap());
			pst.setString(8,c.getCar_fuel());
			pst.setString(9,c.getCar_image());
			pst.setInt(10, c.getCar_ppd());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Car> getCarsByUser(int uid)
	{
		List<Car> list=new ArrayList<Car>();
		try {
			Connection conn=UserUtil.create_conn();
			String sql="select * from tblcar where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Car c=new Car();
				c.setCid(rs.getInt("cid"));
				c.setUid(rs.getInt("uid"));
				c.setCar_company(rs.getString("car_company"));
				c.setCar_name(rs.getString("car_name"));
				c.setCar_capacity(rs.getInt("car_capacity"));
				c.setCar_fuel(rs.getString("car_fuel"));
				c.setCar_image(rs.getString("car_image"));
				c.setCar_luggage_cap(rs.getInt("car_luggage_cap"));
				c.setCar_mileage(rs.getInt("car_mileage"));
				c.setCar_transmission(rs.getString("car_transmission"));
				c.setCar_ppd(rs.getInt("car_ppd"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
