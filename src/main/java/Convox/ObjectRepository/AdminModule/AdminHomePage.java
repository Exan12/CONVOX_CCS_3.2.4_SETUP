package Convox.ObjectRepository.AdminModule;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Convox.GenericLibraries.WebDriverLibrary;

public class AdminHomePage extends WebDriverLibrary {

	WebDriverLibrary wLib = new WebDriverLibrary();

	// Declaration
	@FindBy (xpath = "//img[@src=\"../images/ADMIN_logo.png\"]")
	private WebElement AdminImg;

	@FindBy (xpath = "//button[@title='Sign Off']")
	private WebElement AdminLogoutBtn;

	@FindBy (xpath = "//font[normalize-space()='System Settings']")
	private WebElement SystemSettingsDropDown;

	@FindBy (xpath = "//a[@href='/ConVoxCCS/Admin/index.php?user_sel_menu=Lists']")
	private WebElement ListBtn;

	@FindBy (css = "img[title='Add List']")
	private WebElement AddListLookupBtn;

	@FindBy (xpath = "//input[@id='lname']")
	private WebElement ListName;

	@FindBy (xpath = "//select[@id='crm_id']")
	private WebElement CrmDD;

	@FindBy (xpath = "//select[@id='process']")
	private WebElement ProcessDropDown;

	@FindBy (xpath = "//input[@id='form_type']")
	private WebElement AddButton;

	@FindBy (xpath = "//tbody[1]/tr[1]/td[9]/button[4]/img[1]")
	private WebElement ListUploadBtn;

	@FindBy (xpath = "//input[@id='filen']")
	private WebElement ChooseFileBtn;

	@FindBy (xpath = "//input[@id='hasheader']")
	private WebElement HasHeaderCheckbox;

	@FindBy (xpath = "input[value='Next']")
	private WebElement NextBtn;

	@FindBy (xpath = "//input[@value='CANCEL']")
	private WebElement CancelBtn;

	@FindBy (xpath = "//select[@id='option1']")
	private WebElement MappingDropDown;

	@FindBy (xpath = "//input[@id='back']")
	private WebElement BackButton;

	@FindBy (xpath = "//input[@id='continue']")
	private WebElement ContinueButton;

	@FindBy (xpath = "//input[@id='done']")
	private WebElement DoneButton;
	
	@FindBy (xpath = "//body//div//thead//td[3]")
	private WebElement ProcessStoppedButton;
	
	// Initialization
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getAdminImg() {
		return AdminImg;
	}

	public WebElement getAdminLogoutBtn() {
		return AdminLogoutBtn;
	}

	public WebElement getSystemSettingsDD() {
		return SystemSettingsDropDown;
	}

	public WebElement getListBtn() {
		return ListBtn;
	}

	public WebElement getAddListLookupBtn() {
		return AddListLookupBtn;
	}

	public WebElement getListName() {
		return ListName;
	}

	public WebElement getCrmDD() {
		return CrmDD;
	}

	public WebElement getCRMProcessBtn() {
		return ProcessDropDown;
	}

	public WebElement getAddButton() {
		return AddButton;
	}

	public WebElement getListUploadBtn() {
		return ListUploadBtn;
	}

	public WebElement getChooseFileBtn() {
		return ChooseFileBtn;
	}

	public WebElement getHasHeaderCheckbox() {
		return HasHeaderCheckbox;
	}

	public WebElement getNextBtn() {
		return NextBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getMappingDropDown() {
		return MappingDropDown;
	}

	public WebElement getBackButton() {
		return BackButton;
	}

	public WebElement getContinueButton() {
		return ContinueButton;
	}

	public WebElement getDoneButton() {
		return DoneButton;
	}


// Business Library Logics

	/**
	 * This Method is used to logout the Admin from Convox CCS 3.2.4 Application
	 */
	public void AdminLogout()
	{
		AdminImg.click();
		AdminLogoutBtn.click();
	}

	/**
	 * This Method is used to Create the List in Admin Module of Convox CCS 3.2.4 Application
	 * @throws Throwable 
	 */
	public void ListCreation(WebDriver driver) throws Throwable
	{
		wLib.mouseHoverOn(driver, SystemSettingsDropDown);
		SystemSettingsDropDown.click();
		Reporter.log("SystemSettings Dropdown clicked Succesfully",true);
		ListBtn.click();
		Reporter.log("Clicked on List Button",true);
		System.out.println("Enter the List Name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		Thread.sleep(1000);
		wLib.switchToFrame(driver, "active_list");
		Reporter.log("Switched to Active List Frame",true);
		List<WebElement> AllOp = driver.findElements(By.xpath("//table[@class='INBOX']"));
		for (WebElement oneop:AllOp)
		{
			String text = oneop.getText();
			System.out.println(text);	
			if(text.contains(name))
			{
				Thread.sleep(3000);
				System.out.println(name+" already exists in the field ");
			}
			else
			{
				AddListLookupBtn.click();
				Reporter.log("Clicked on Add List Lookup Button",true);
				ListName.sendKeys(name);
				Reporter.log(name+" Name Added Succesfully to the List Name Textbox",true);
				wLib.handleDropDown("ConVoxProcess", ProcessDropDown);
				AddButton.click();
				wLib.switchToDefaultFrame(driver);
				sc.close();
				Reporter.log("List Created Successfully",true);
			}
		}

	}
	
	
	/**
	 * This Method is used to upload the List in Admin Module of ConVox CCS 3.2.4 Application
	 * @param driver
	 */
	public void Listupload(WebDriver driver)
	{
		wLib.switchToFrame(driver, "active_list");
		Reporter.log("Switched to Active List Frame",true);
		ListUploadBtn.click();
		Reporter.log("Clicked on upload List Button Succesfully",true);
		ChooseFileBtn.click();
		String filepath = "/home/dtel/Downloads/25000 Mobile Numbers.csv";
		ChooseFileBtn.sendKeys(filepath);
		HasHeaderCheckbox.click();
		NextBtn.click();
		wLib.handleDropDown("Mobile Number", MappingDropDown);
		ContinueButton.click();
		Reporter.log("List Created Successfully",true);	
	}
	
	/**
	 * This Method is used to Active the List in Admin Module of ConVox CCS 3.2.4 Application
	 * @param driver
	 * @throws Throwable
	 */
	public void ProcessActive(WebDriver driver) throws Throwable
	{
		wLib.switchToFrame(driver, "active_list");
		Reporter.log("Switched to Active List Frame",true);
		ProcessStoppedButton.click();
		Thread.sleep(2000);
		wLib.switchToDefaultFrame(driver);
		Reporter.log("Campaign Started Succesfully",true);
	}
	
	/**
	 *This Method is used to In-Active the List in Admin Module of ConVox CCS 3.2.4 Application 
	 * @param driver
	 * @throws Throwable
	 */
	public void ProcessInActive(WebDriver driver) throws Throwable
	{
		wLib.switchToFrame(driver, "active_list");
		Reporter.log("Switched to Active List Frame",true);
		Thread.sleep(2000);   
		ProcessStoppedButton.click();
		wLib.switchToDefaultFrame(driver);
		Reporter.log("Campaign Stopped Succesfully",true);
	}
	
	

}
