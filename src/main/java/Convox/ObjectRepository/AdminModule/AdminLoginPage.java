package Convox.ObjectRepository.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Convox.GenericLibraries.WebDriverLibrary;

/**
 * This class is used to Sign In to the Admin Module in Convox CCS 3.2.4 Application
 * @author Kiran
 *
 */
public class AdminLoginPage extends WebDriverLibrary{

	// Declaration
	@FindBy(xpath = "//img[@title='Admin Login']")
	private WebElement AdminImg;

	@FindBy(id = "username")
	private WebElement AdminusernameTxtField;

	@FindBy(id = "password")
	private WebElement AdminpasswordTxtField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement AdminloginBtn;
	
	// Initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	// Utilization
	public WebElement getAdminImg() {
		return AdminImg;
	}

	public WebElement getAdminusernameTxtField() {
		return AdminusernameTxtField;
	}

	public WebElement getAdminpasswordTxtField() {
		return AdminpasswordTxtField;
	}

	public WebElement getAdminloginBtn() {
		return AdminloginBtn;
	}
	
	
// Business Library Logics
	
	/**
	 * This Method is used to Login to the Admin Module in ConVox CCS 3.2.4 Application
	 * @param adminusername
	 * @param adminpassword
	 * @throws Throwable
	 */
	public void LoginToAdminModule(String adminusername,String adminpassword) throws Throwable
	{
		AdminImg.click();
		AdminusernameTxtField.sendKeys(adminusername);
		AdminpasswordTxtField.sendKeys(adminpassword);
		//AdminloginBtn.click();		   
	}
	
}
