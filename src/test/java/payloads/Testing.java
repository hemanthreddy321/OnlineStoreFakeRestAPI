package payloads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pojo.Cart;

//return new Cart(userId, new Date(), products);

public class Testing {

	public static void main(String[] args) throws ParseException {
		
	
		
		Date inputDate=new Date();   // Here getDate() returns data in Date format( Ex: Wed Feb 19 12:52:27 IST 2025)
		System.out.println("new Date() :  "+new Date());
	
		// Define output date format
		 SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		 // Format the Date object to the required format
	     String formattedDate = outputFormat.format(new Date());

	      // Print the formatted date
	        System.out.println("Formatted Date in String format: "+ formattedDate);
		
	}

}
