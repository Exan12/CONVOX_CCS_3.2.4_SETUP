package Convox.GenericLibraries;


import java.util.Date;
import java.util.Random;

/**
 * 
 * This class contains all the generic methods related to Java
 * @author Kiran
 *
 */
public class JavaLibrary {
	
	/**
	 * This method is used to generate the Random Number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;
	}
	
	/**
	 * This method is used to generate the System Date
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will return the current system date in a specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String month = dArr[1];
		String date = dArr[2];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		
		String dateInFormat = date+"-"+month+"-"+year+"-"+time;
		return dateInFormat;
	}
}
