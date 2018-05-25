package com.zhangyisheng.test;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Test1 {
	public static void main(String args[]){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		String str = format.format(date);
		//System.out.println(str);
		String str1="2018-05-02";
		java.sql.Date date1=java.sql.Date.valueOf(str1);
		java.sql.Date b = new java.sql.Date(new java.util.Date().getTime());
		System.out.println(b);
		//System.out.println(date1);
	}
}
