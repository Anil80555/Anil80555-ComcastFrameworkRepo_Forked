package com.comcast.crm.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Date dateobj = new Date();
         
     SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
     String actDate = simple.format(dateobj);
     
          
     Calendar calendar = simple.getCalendar();
     calendar.add(calendar.DAY_OF_MONTH,30);
     String datereq = simple.format(calendar.getTime());
      
     
	}

}
