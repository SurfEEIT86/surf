package com.surf.forums.controller;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class aa {
	public static void main(String[] args) throws ParseException{
		
//		LocalDateTime dateTime = LocalDateTime.now();
//		
//		Timestamp stamp = Timestamp.valueOf(dateTime);
//		System.out.println(stamp);
/*		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String day=sdf.format(date);
		System.out.println(day);*/
		
		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String year = "-1";
		if(year.equalsIgnoreCase("-1")){
			Date now = new Date();
			String day = SimpleDateFormat.format(now);
			System.out.println(day);
			
		}
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date a = format.parse("2016-03-00");		  
		System.out.println(format.format(a));
	}
}
