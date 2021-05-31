package com.saliq.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Bill {
	Book book = new Book();
	
	HashMap<String,String> map = new HashMap<>(book.client);
	

	public void bill(Date iss , Date ret,String name) throws ParseException {
		float bill = (float) 0.0;
		 SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");   
		
		
         long time_difference = ret.getTime() - iss.getTime();  
         if(time_difference <=14)
        	 bill = 0;
        	 
		
		 long days_difference = (time_difference / (1000*60*60*24)) % 365;   
      
         long years_difference = (time_difference / (1000l*60*60*24*365));   
		
        long delay = years_difference*365 + days_difference; //This is zero because function is calling on same day
        delay = (long) 10.0; //let asssume delay is 10 days
		//bill = delay*20 + bill;		
		System.out.println(name +" Your Bill is : " +bill+ " \n---------------------------------");
	}
	
	public void billing(int delay,String name ) {
		float bill = delay*20;
		System.out.println("---------------------------------\n "+ name +" Your Bill is : " +bill);
	}
	
}
