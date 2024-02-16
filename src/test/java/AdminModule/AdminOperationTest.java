package AdminModule;


import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Convox.GenericLibraries.BaseClass;
import Convox.GenericLibraries.PropertyFileLibrary;
import Convox.ObjectRepository.AdminModule.AdminHomePage;
import Convox.ObjectRepository.AdminModule.AdminLoginPage;

@Listeners(Convox.GenericLibraries.ListenersImplementationLibrary.class)
public class AdminOperationTest extends BaseClass{

	@Test
	public void adminOperationsTest() throws Throwable
	{	

		PropertyFileLibrary pLib = new PropertyFileLibrary();
		String URL = pLib.getpropertyfile("url");
		String USERNAME = pLib.getpropertyfile("admin_Username");
		String PASSWORD = pLib.getpropertyfile("admin_Password");
		driver.get(URL);

		// ADMIN Login to the ConVox CCS 3.2.4 Application 
		AdminLoginPage adlp = new AdminLoginPage(driver);
		adlp.LoginToAdminModule(USERNAME, PASSWORD);
		Reporter.log("--- Logged Into Admin Module Succesfully ---",true);

		// LIST Creation in ConVox CCS 3.2.4 Application
		AdminHomePage adhp = new AdminHomePage(driver);
		adhp.ListCreation(driver);
		adhp.ProcessActive(driver);
		adhp.ProcessInActive(driver);
	
		// ADMIN Logout from ConVox CCS 3.2.4 Application
		adhp.AdminLogout();
		Reporter.log("--- Logged Out from Admin Module Succesfully ---",true);
		driver.quit();

	}

}
