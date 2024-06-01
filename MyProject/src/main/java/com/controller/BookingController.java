package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.bean.Booking;
import com.dao.BookingDao;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024* 512) // 512MB
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);// form-data; name="product_image"; filename="shoes1.jpg"
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}
	
	public static long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("book now"))
		{
			Date date1=null;
			Date date2=null;
			try {
				date1=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("from_date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				date2=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("to_date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long dd=getDifferenceDays(date1, date2);
			int ppd=Integer.parseInt(request.getParameter("car_ppd"));
			int total_amount=(int) (dd*ppd);
			Booking b=new Booking();
			b.setCid(Integer.parseInt(request.getParameter("cid")));
			b.setUid(Integer.parseInt(request.getParameter("uid")));
			b.setFrom_date(request.getParameter("from_date"));
			b.setTo_date(request.getParameter("to_date"));
			b.setPayment_status("pending");
			b.setTotal_amount(total_amount);
			
			String savePath = "F:\\Local Disk\\Eclipse\\Java_2\\MyProject\\src\\main\\webapp\\user_document";
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			Part file1 = request.getPart("identity_document");
			String fileName = extractfilename(file1);
			file1.write(savePath + File.separator + fileName);
			String savePath2 = "F:\\Local Disk\\Eclipse\\Java_2\\MyProject\\src\\main\\webapp\\user_document";
			File imgSaveDir = new File(savePath2);
			if (!imgSaveDir.exists()) {
				imgSaveDir.mkdir();
			}
			b.setIdentity_document(fileName);
			BookingDao.addBooking(b);
			response.sendRedirect("car.jsp");
		}
	}

}
