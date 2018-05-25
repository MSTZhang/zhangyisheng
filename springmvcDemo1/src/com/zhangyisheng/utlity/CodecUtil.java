package com.zhangyisheng.utlity;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.zhangyisheng.entity.Room;

  
/**        
 * Title: 鐢熸垚UUID    
 * @author rico       
 * @created 2017骞�鏈�鏃�涓嬪崍5:13:16    
 */      
public class CodecUtil {
	
	public static String createUUID(){
		return UUID.randomUUID().toString();
	}
	public static String createNumber(){
		Random rd = new Random();
		String str="";
		for(int i=0;i<9;i++){
			str=str+rd.nextInt(10);
		}
		return str;
	}
	public static Double totalMoney(Date checkDate,Date endDate,Double singlePrice,Double discount){
		int days=(int) Math.ceil( (((double)(endDate.getTime()-checkDate.getTime()))/((24*60*60*1000))));
		return days*singlePrice*discount;
	}
}
