package Convox.ObjectRepository.AgentModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Convox.GenericLibraries.WebDriverLibrary;

/**
 * This class is used to Sign In to the Agent Module in Convox CCS 3.2.4 Application
 * @author Kiran
 *
 */
public class AgentLoginPage extends WebDriverLibrary{

	// Declaration
	@FindBy(id = "agent")
	private WebElement AgentImg;

	@FindBy(id = "username")
	private WebElement UsernameTxtField;

	@FindBy(id = "password")
	private WebElement PasswordTxtField;

	@FindBy(id = "station")
	private WebElement StationTxtField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginBtn;


	// Initialization
	public AgentLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getAgentImg() {
		return AgentImg;
	}


	public WebElement getUsernameTxtField() {
		return UsernameTxtField;
	}


	public WebElement getPasswordTxtField() {
		return PasswordTxtField;
	}


	public WebElement getStationTxtField() {
		return StationTxtField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	// Business Library Logics

	/**
	 * This Method is used to Login to the Agent Modile in ConVox CCS 3.2.4 Application
	 * @throws Throwable 
	 */
	public void LoginToAgentModule(String username,String password,String station) throws Throwable
	{
		AgentImg.click();
		UsernameTxtField.sendKeys(username);
		PasswordTxtField.sendKeys(password);
		StationTxtField.sendKeys(station);
		LoginBtn.click();		   
	}
}
