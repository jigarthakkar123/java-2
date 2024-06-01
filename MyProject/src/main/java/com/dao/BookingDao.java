package com.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Booking;
import com.util.UserUtil;

public class BookingDao {

	public static void addBooking(Booking b)
	{
		try {
			Connection conn=UserUtil.create_conn();
			String sql="insert into tblbooking(uid,cid,from_date,to_date,identity_document,payment_status,total_amount) values(?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, b.getUid());
			pst.setInt(2, b.getCid());
			pst.setString(3, b.getFrom_date());
			pst.setString(4, b.getTo_date());
			pst.setString(5, b.getIdentity_document());
			pst.setString(6, b.getPayment_status());
			pst.setInt(7, b.getTotal_amount());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Booking> getBookingByUser(int uid)
	{
		List<Booking> list=new ArrayList<Booking>();
		try {
			Connection conn=UserUtil.create_conn();
			String sql="select * from tblbooking where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Booking b=new Booking();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setUid(rs.getInt("uid"));
				b.setFrom_date(rs.getString("from_date"));
				b.setTo_date(rs.getString("to_date"));
				b.setIdentity_document(rs.getString("identity_document"));
				b.setPayment_status(rs.getString("payment_status"));
				b.setTotal_amount(rs.getInt("total_amount"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Booking getBooking(int bid)
	{
		Booking b=null;
		try {
			Connection conn=UserUtil.create_conn();
			String sql="select * from tblbooking where bid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, bid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				b=new Booking();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setUid(rs.getInt("uid"));
				b.setFrom_date(rs.getString("from_date"));
				b.setTo_date(rs.getString("to_date"));
				b.setIdentity_document(rs.getString("identity_document"));
				b.setPayment_status(rs.getString("payment_status"));
				b.setTotal_amount(rs.getInt("total_amount"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public static void updatePaymentStatus(int bid)
	{
		String payment_status="paid";
		try {
			Connection conn=UserUtil.create_conn();
			String sql="update tblbooking set payment_status=? where bid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, payment_status);
			pst.setInt(2, bid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
