package mps.komponenten.supplier.adapter;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import mps.komponenten.product.entities.Product;

public class SupplierAdapter {

	public Date getLieferDatum(Product product, int count){
		
		Random rand = new Random(21);
		int tage = 7 + (rand.nextInt()*count);
		// create Calendar instance with actual date
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);

		// add 5 days to calendar instance
		calendar.add(Calendar.DAY_OF_MONTH, tage);

		// get the date instance
		Date future = calendar.getTime();
		// print out the dates...
		
		return future;
		
		//DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		//System.out.println("Future: " + dateFormat.format(future));
	}
	
	
	
	
}
