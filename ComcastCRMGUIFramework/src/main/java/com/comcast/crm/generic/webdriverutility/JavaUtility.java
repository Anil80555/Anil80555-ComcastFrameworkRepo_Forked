package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNum() {
	 Random ranDom = new Random();
	 int randomNum = ranDom.nextInt(5000);
	 return randomNum;
	}
	
	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
				
	}
	
	
	public String getRequiredDateYYYYDDMM(int days) {
		
        
	     SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
	     Calendar calendar = Calendar.getInstance();
	     calendar.add(calendar.DAY_OF_MONTH,days);
	     String endDate = simple.format(calendar.getTime());
	     
	     return endDate;
		
	}
}
