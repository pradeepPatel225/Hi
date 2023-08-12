package onlineWebsitesAutomation;



import org.testng.annotations.Test;

import utillityLayer.WebUtil;

public class test {	
	
	
	
	public static void main1(String[] args) {
		WebUtil util =	new WebUtil();
		util.initHtmlReport();
		util.launchBrowser("Chrome");
		util.hitUrl("http://localhost:8888");
        
		util.flushReport();

		
		





		///////////////////How to open notepad with code //////////////////////

		//		Runtime rntime =	Runtime.getRuntime();
		//		try {
		//			rntime.exec("notepad");
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		//		



		/////////////////// How to Date and Time //////////////////////

		//		SimpleDateFormat date =	new SimpleDateFormat("dd-mm-yyyy   -hh-mm-ss");
		//		Date dt =	new	Date();
		//		String d =	date.format(dt);
		//		System.out.println(d);



		/////////////////// How to Date and Time //////////////////////

		//		long dateMills = 	System.currentTimeMillis();
		//		java.sql.Date date =	new java.sql.Date(dateMills);
		//		System.out.println(date);
		//
		//		long timeMills = 	System.currentTimeMillis();
		//		java.sql.Time time =	new java.sql.Time(timeMills);
		//		System.out.println(time);




	}




}
