package Convox.GenericLibraries;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains all the Generic Methods related to property file.
 * @author Kiran
 *
 */
public class PropertyFileLibrary {
	
	/**
	 * This method will read the Key from Propertyfile and return the Value
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String getpropertyfile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IconstantsLibrary.propPATH);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}

}
