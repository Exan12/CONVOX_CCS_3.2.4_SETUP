package Convox.ObjectRepository.AgentModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Convox.GenericLibraries.WebDriverLibrary;

/**
 * This class consists of the all the Elements which are present in the Home Page of 
 * ConVox CCS 3.2.4 Application
 * @author Kiran
 *
 */
public class AgentHomePage{
	
	WebDriverLibrary wLib = new WebDriverLibrary();
	
	// Declaration
	@FindBy(xpath = "//img[@src='../images/exit.png']")
	private WebElement ExitBtn;
	
	@FindBy(xpath = "//img[@id='OUTBOUND']")
	private  WebElement OutboundBtn;
	
	@FindBy (xpath = "//input[@id='dial_phone_number']")
	private WebElement PhoneNumTxtField;
	
	@FindBy (xpath = "//strong[normalize-space()='CALL']")
	private WebElement CallBtn;
	
	@FindBy(xpath = "//button[@id='hold']")
	private WebElement HoldAndUnholdBtn;
	
	@FindBy(xpath = "//button[@id='mute']")
	private WebElement MuteAndUnMuteBtn;

	@FindBy(xpath = "//button[@id='PAUSE']")
	private WebElement BreakDropDown;

	@FindBy (xpath = "//a[normalize-space()='Lunch']")
	private WebElement LunchBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Tea']")
	private WebElement TeaBtn;
	
	@FindBy (xpath = "//th[@id='status_row']//center")
	private WebElement StatusCenter;
	
	@FindBy (xpath = "//input[@id='READY']")
	private WebElement ReadyBtn;
	
	@FindBy (xpath = "//li[@class='active']//a[1]")
	private WebElement CrmModule;
	
	@FindBy (xpath = "//textarea[@id='comments']")
	private WebElement CommentsTxtField;
	
	@FindBy (xpath = "//input[@id='crm_field_1']")
	private WebElement CompanyNameTxtField;
	
	@FindBy (xpath = "//select[@id='crm_field_1']")
	private WebElement CompanyLoctaionDropDown;
	
	@FindBy (xpath = "//select[@id='disp']")
	private WebElement DispositionsDropDowm;
	
	@FindBy (xpath = "//select[@id='set_followUps']")
	private WebElement SetFollowupDropDown;
	
	@FindBy (xpath = "//select[@id='break']")
	private WebElement BreakDD;
	
	@FindBy (xpath = "//select[@id='transfer']")
	private WebElement TransferDropDown;
	
	@FindBy (xpath = "//input[@value='EndCall']")
	private WebElement EndCallBtn;
	
	@FindBy (xpath = "//button[@id='Conf']")
	private WebElement ConferenceButton;
	
	@FindBy (xpath = "//input[@id='line_1']")
	private WebElement Line1;
	
	@FindBy (xpath = "//input[@id='line_2']")
	private WebElement Line2;
	
	@FindBy (xpath = "//input[@id='line_3']")
	private WebElement Line3;
	
	@FindBy (xpath = "//input[@id='line_4']")
	private WebElement Line4;
	
	@FindBy (xpath = "//input[@id='line_5']")
	private WebElement Line5;
	
	@FindBy (xpath = "//input[@id='phone_number_span1']")
	private WebElement PhoneNumberTextField1;
	
	@FindBy (xpath = "//input[@id='phone_number_span2']")
	private WebElement PhoneNumberTextField2;
	
	@FindBy (xpath = "//input[@id='phone_number_span3']")
	private WebElement PhoneNumberTextField3;
	
	@FindBy (xpath = "//input[@id='phone_number_span4']")
	private WebElement PhoneNumberTextField4;
	
	@FindBy (xpath = "//input[@id='phone_number_span5']")
	private WebElement PhoneNumberTextField5;
	
	@FindBy (xpath = "//input[@id='call_1']")
	private WebElement Callbutton1;
	
	@FindBy (xpath = "//input[@id='call_2']")
	private WebElement Callbutton2;
	
	@FindBy (xpath = "//input[@id='call_3']")
	private WebElement Callbutton3;
	
	@FindBy (xpath = "//input[@id='call_4']")
	private WebElement Callbutton4;
	
	@FindBy (xpath = "//input[@id='call_5']")
	private WebElement Callbutton5;
	
	@FindBy (xpath = "//input[@id='play_1']")
	private WebElement MergeButton1;
	
	@FindBy (xpath = "//input[@id='play_2']")
	private WebElement MergeButton2;
	
	@FindBy (xpath = "//input[@id='play_3']")
	private WebElement MergeButton3;
	
	@FindBy (xpath = "//input[@id='play_4']")
	private WebElement MergeButton4;
	
	@FindBy (xpath = "//input[@id='play_5']")
	private WebElement MergeButton5;
	
	@FindBy (xpath = "//input[@id='hold_1']")
	private WebElement HoldButton1;
	
	@FindBy (xpath = "//input[@id='hold_2']")
	private WebElement HoldButton2;
	
	@FindBy (xpath = "//input[@id='hold_3']")
	private WebElement HoldButton3;
	
	@FindBy (xpath = "//input[@id='hold_4']")
	private WebElement HoldButton4;
	
	@FindBy (xpath = "//input[@id='hold_5']")
	private WebElement HoldButton5;
	
	@FindBy (xpath = "//input[@id='hangup_1']")
	private  WebElement HangupCall1;
	
	@FindBy (xpath = "//input[@id='hangup_2']")
	private WebElement HangupCall2;
	
	@FindBy (xpath = "//input[@id='hangup_3']")
	private WebElement HangupCall3;
	
	@FindBy (xpath = "//input[@id='hangup_4']")
	private WebElement HangupCall4;
	
	@FindBy (xpath = "//input[@id='hangup_5']")
	private WebElement HangupCall5;
	
	@FindBy (xpath = "//input[@id='conference']")
	private WebElement ConfButton;
	
	@FindBy (xpath = "//input[@id='exit_conference']")
	private WebElement ExitConference;
	
	@FindBy (xpath = "//input[@id='transfer']")
	private WebElement TransferButton;
	
	@FindBy (xpath = "//input[@id='EndCall']")
	private WebElement EndAllCalls;
	
	@FindBy (xpath = "//tbody/tr/td[2]/div[1]")
	public WebElement QueueNumber;
	
	@FindBy (xpath = "//input[@id='first_name']")
	public WebElement FirstName;
	
	@FindBy (xpath = "//input[@id='crm_field_4']")
	public WebElement AboutCompanyTxtField;
	
	@FindBy (id =  "crm_field_2")
	public WebElement RemarkTxtField;
	
	@FindBy (xpath = "//input[@id='crm_field_3']")
	public WebElement AreaTxtField;
	
	// Initialization
	public AgentHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	
	public WebElement getExitBtn() {
		return ExitBtn;
	}
	
	public WebElement getOutboundBtn() {
		return OutboundBtn;
	}

	public WebElement getPhoneNumTxtField() {
		return PhoneNumTxtField;
	}

	public WebElement getCallBtn() {
		return CallBtn;
	}
	
	public WebElement getHoldAndUnholdBtn() {
		return HoldAndUnholdBtn;
	}

	public WebElement getMuteAndUnMuteBtn() {
		return MuteAndUnMuteBtn;
	}
	
	public WebElement getBreakDropDown() {
		return BreakDropDown;
	}

	public WebElement getLunchBtn() {
		return LunchBtn;
	}

	public WebElement getTeaBtn() {
		return TeaBtn;
	}

	public WebElement getStatusCenter() {
		return StatusCenter;
	}

	public WebElement getReadyBtn() {
		return ReadyBtn;
	}
	
	public WebElement getCrmModule() {
		return CrmModule;
	}

	public WebElement getCommentsTxtField() {
		return CommentsTxtField;
	}

	public WebElement getCompanyNameTxtField() {
		return CompanyNameTxtField;
	}

	public WebElement getCompanyLoctaionDropDown() {
		return CompanyLoctaionDropDown;
	}

	public WebElement getDispositionsDropDowm() {
		return DispositionsDropDowm;
	}

	public WebElement getSetFollowupDropDown() {
		return SetFollowupDropDown;
	}

	public WebElement getBreak() {
		return BreakDD;
	}

	public WebElement getTransferDropDown() {
		return TransferDropDown;
	}

	public WebElement getEndCallBtn() {
		return EndCallBtn;
	}
	
	public WebElement getConferenceButton() {
		return ConferenceButton;
	}

	public WebElement getLine1() {
		return Line1;
	}

	public WebElement getLine2() {
		return Line2;
	}

	public WebElement getLine3() {
		return Line3;
	}

	public WebElement getLine4() {
		return Line4;
	}

	public WebElement getLine5() {
		return Line5;
	}

	public WebElement getPhoneNumberTextField1() {
		return PhoneNumberTextField1;
	}

	public WebElement getPhoneNumberTextField2() {
		return PhoneNumberTextField2;
	}

	public WebElement getPhoneNumberTextField3() {
		return PhoneNumberTextField3;
	}

	public WebElement getPhoneNumberTextField4() {
		return PhoneNumberTextField4;
	}

	public WebElement getPhoneNumberTextField5() {
		return PhoneNumberTextField5;
	}

	public WebElement getCallbutton1() {
		return Callbutton1;
	}

	public WebElement getCallbutton2() {
		return Callbutton2;
	}

	public WebElement getCallbutton3() {
		return Callbutton3;
	}

	public WebElement getCallbutton4() {
		return Callbutton4;
	}

	public WebElement getCallbutton5() {
		return Callbutton5;
	}

	public WebElement getMergeButton1() {
		return MergeButton1;
	}

	public WebElement getMergeButton2() {
		return MergeButton2;
	}

	public WebElement getMergeButton3() {
		return MergeButton3;
	}

	public WebElement getMergeButton4() {
		return MergeButton4;
	}

	public WebElement getMergeButton5() {
		return MergeButton5;
	}

	public WebElement getHoldButton1() {
		return HoldButton1;
	}

	public WebElement getHoldButton2() {
		return HoldButton2;
	}

	public WebElement getHoldButton3() {
		return HoldButton3;
	}

	public WebElement getHoldButton4() {
		return HoldButton4;
	}

	public WebElement getHoldButton5() {
		return HoldButton5;
	}

	public WebElement getHangupCall1() {
		return HangupCall1;
	}

	public WebElement getHangupCall2() {
		return HangupCall2;
	}

	public WebElement getHangupCall3() {
		return HangupCall3;
	}

	public WebElement getHangupCall4() {
		return HangupCall4;
	}

	public WebElement getHangupCall5() {
		return HangupCall5;
	}

	public WebElement getConfButton() {
		return ConfButton;
	}

	public WebElement getExitConference() {
		return ExitConference;
	}

	public WebElement getTransferButton() {
		return TransferButton;
	}
	
// Business Library Logics
	
	/**
	 * This Method is used to logout from Agent Module in ConVox CCS 3.2.4 Application
	 * @param driver
	 */
	public void LogoutFromAgentModule(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
		ExitBtn.click();
		Reporter.log("Clicked on Logout Button Succesfully",true);
		wLib.switchToDefaultFrame(driver);
	}
	
	
	/**
	 * This Method is used to do Manual Outbound Call in ConVox CCS 3.2.4 Application
	 * @param driver
	 * @param number
	 * @throws InterruptedException 
	 */
	public void Outboundcall(WebDriver driver,String number) throws InterruptedException
	{
		wLib.switchToFrame(driver, "agentframe");
		OutboundBtn.click();
		Reporter.log("Clicked on Outbound button Succesfully",true);
		wLib.switchToDefaultFrame(driver);
		wLib.switchToFrame(driver, "agentframe");
		PhoneNumTxtField.sendKeys(number);
		Reporter.log("Data entered in PhoneNumber Textfield Succesfully",true);
		wLib.switchToDefaultFrame(driver);
		Thread.sleep(5000);
		wLib.switchToFrame(driver, "agentframe");
		CallBtn.click();
		Reporter.log("Clicked on call Button Succesfully",true);
		wLib.switchToDefaultFrame(driver);
		Thread.sleep(5000);
	}
	
	/**
	 * This Method is used to Hold and Unhold the Call in ConVas CCS 3.2.4 Application
	 * @param driver
	 */
	public void HoldAndUnholdCall(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
		HoldAndUnholdBtn.click();
		Reporter.log("Successfully Clicked on the Hold Button",true);
		wLib.waitForPageLoad(driver);
		HoldAndUnholdBtn.click();
		Reporter.log("Successfully Clicked on the UnHold Button",true);
		wLib.switchToDefaultFrame(driver);
		
	}
	
	/**
	 * This Method is used to Hold and Unhold the Call in ConVas CCS 3.2.4 Application
	 * @param driver
	 */
	public void MuteAndUnMuteCall(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
		MuteAndUnMuteBtn.click();
		Reporter.log("Successfully Clicked on the Mute Button",true);
		wLib.waitForPageLoad(driver);
		MuteAndUnMuteBtn.click();
		Reporter.log("Successfully Clicked on the UnMute Button",true);
		wLib.switchToDefaultFrame(driver);
		
	}
	
	/**
	 * This Method is used to Take the Call in ConVas CCS 3.2.4 Application
	 * @param driver
	 */
	public void ReadyToCall(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
		ReadyBtn.click();
		Reporter.log("Successfully Clicked on the Ready Button",true);
		wLib.switchToDefaultFrame(driver);
	}
	
	/**
	 * This Method is used to Take Break from the call in ConVas CCS 3.2.4 Application
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void BreakFromCall(WebDriver driver,String Break) 
	{
		wLib.switchToFrame(driver, "agentframe");
		BreakDropDown.click();
		Reporter.log("Successfully Clicked on the Break Button",true);
		if(Break.equalsIgnoreCase("Lunch"))
		{
			LunchBtn.click();
			Reporter.log("Successfully Selected Lunch Option",true);
		}
		else
		{
			TeaBtn.click();
			Reporter.log("Successfully Selected Tea Option",true);
		}
		wLib.switchToDefaultFrame(driver);
		
	}

	/**
	 * This Method is used to Tell the Status of Agent in ConVas CCS 3.2.4 Application
	 */
	public void StatusOfAgent(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
	    String status = StatusCenter.getText();
	    System.out.println(status);
		if (status.contains("BREAK"))
		{
			System.out.println("--- Agent was in  Break Status ---");
		}
		
		else if(status.equals("IDLE"))
		{
			System.out.println("--- Agent is in Ready status to take calls");
		}
		else
		{
			System.out.println("Invalid Status of Agent");
		}
		wLib.switchToDefaultFrame(driver);
	}
	
	/**
	 * This method is used to tell about the CRM Popup of Agent Module in ConVax CCS 3.2.4 Application
	 */
	public void CrmPopup(WebDriver driver)
	{
		wLib.switchToFrame(driver, "mainframe");
		String crm = CrmModule.getText();
		System.out.println(crm+"Poppedup Succefully");
		wLib.switchToDefaultFrame(driver);
	}
	
	
	/**
	 * This method is used to Update the CRM Popup of Agent Module in ConVax CCS 3.2.4 Application
	 * @param driver
	 * @param comments
	 * @param companyName,
	 * @param text
	 */
	public void CrmUpdateAndEndCall(WebDriver driver,String comments,String firstname ,String remark,String area,String aboutcompanytxtfield,String companyLocation,String Disposition)
	{
		wLib.switchToDefaultFrame(driver);
		Reporter.log("Successfully Switched to Default Frame");
		wLib.switchToFrame(driver, "mainframe");
		Reporter.log("Successfully Switched to Main Frame");
		wLib.switchToFrame(driver, "ecrmframe");
		Reporter.log("Successfully Switched to CRM Frame");
		CommentsTxtField.clear();
		CommentsTxtField.sendKeys(comments);
		FirstName.clear();
		FirstName.sendKeys(firstname);
		AboutCompanyTxtField.clear();
		AboutCompanyTxtField.sendKeys(aboutcompanytxtfield);
		RemarkTxtField.clear();
		RemarkTxtField.sendKeys(remark);
		AreaTxtField.clear();
		AreaTxtField.sendKeys(area);
		wLib.handleDropDown(companyLocation, CompanyLoctaionDropDown);
		wLib.handleDropDown(Disposition, DispositionsDropDowm);
		EndCallBtn.click();
		Reporter.log("Primary Number Call Ended Succesfully",true);
		wLib.switchToDefaultFrame(driver); 
		Reporter.log("Data of primary Number Recorded Succesfully in CRM",true);
	}
	
	/**
	 * This method is used to End the Call in CRM Popup of Agent Module in ConVax CCS 3.2.4 Application
	 * @param driver
	 */
	public void EndCall(WebDriver driver)
	{
		wLib.switchToDefaultFrame(driver);
		wLib.switchToFrame(driver, "mainframe");
		wLib.switchToFrame(driver, "ecrmframe");
		EndCallBtn.click();
		wLib.switchToDefaultFrame(driver);
		Reporter.log("Primary Number Call Ended Succesfully",true);
	}
	
	/**
	 * This method is used to Wrapup the Call of Agent Module in ConVax CCS 3.2.4 Application
	 * @param driver
	 */
	public void WrapupCall(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
		String callStatus = StatusCenter.getText();
		if(callStatus.contains("WRAPUP"))
		{
		  Reporter.log("Customer Wrapup the Call",true);
		}else {
			Reporter.log("Customer Talking with the Agent",true);
		}
		wLib.switchToDefaultFrame(driver);
	}

	/**
	 * This Method is used to switch to the Agent Frame
	 * @param driver
	 */
	public void SwitchToAgentFrame(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
	}
	
	/**
	 * This method is used to fetch the QueueNumber
	 */
	public void QueueNumber()
	{
		String queuenumber =  QueueNumber.getText();
		System.out.println(queuenumber);
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void ConferenceInAgent(WebDriver driver)
	{
		wLib.switchToFrame(driver, "agentframe");
		Reporter.log("Switched to Agent Frame");
		ConferenceButton.click();
	}
}
