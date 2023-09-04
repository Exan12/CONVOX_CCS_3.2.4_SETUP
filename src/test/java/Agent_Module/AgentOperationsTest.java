package Agent_Module;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Convox.GenericLibraries.BaseClass;
import Convox.ObjectRepository.AgentModule.AgentHomePage;

@Listeners(Convox.GenericLibraries.ListenersImplementationLibrary.class)
public class AgentOperationsTest extends BaseClass {
	
	/**
	 * This Test Script is used to make OutBound calls in ConVox CCS 3.2.4 Application
	 * @throws InterruptedException
	 */
	@Test
	public void OutboundCallManual() throws InterruptedException
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.Outboundcall(driver, "9100187911");
	}
	
	
	/**
	 * This Test Script is used to Click Hold and Unhold button in ConVox CCS 3.2.4 Application
	 * @throws InterruptedException
	 */
	@Test
	public void HoldAndUnholdCall() throws InterruptedException
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.Outboundcall(driver, "9100187911");
		ahp.HoldAndUnholdCall(driver);
	}
	
	/**
	 *This Tetst Script is used to Click Mute and UnMute button in ConVox CCS 3.2.4 Application 
	 * @throws InterruptedException
	 */
	@Test
	public void MuteAndUnMuteCall() throws InterruptedException
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.Outboundcall(driver, "9100187911");
		ahp.MuteAndUnMuteCall(driver);
	}
	
	/**
	 * This Test Script is used to Take the calls in ConVox CCS 3.2.4 Application
	 * @throws Throwable 
	 */
	@Test
	public void ReadyToCall() throws Throwable
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.ReadyToCall(driver);
	}
	
	/**
	 * This Test Script is used to Take Break From the calls in ConVox CCS 3.2.4 Application
	 * @throws InterruptedException 
	 */
	@Test
	public void BreakFromCall() throws InterruptedException
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.ReadyToCall(driver);
		Thread.sleep(3000);
		ahp.BreakFromCall(driver,"Lunch");
		ahp.StatusOfAgent(driver);
		
	}
	
	/**
	 * This Test Script is used to show the status of CRM Popup in ConVox CCS 3.2.4 Application
	 * @throws Throwable
	 */
	@Test
	public void CrmPopup() throws Throwable
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.Outboundcall(driver, "9100187911");
		ahp.CrmPopup(driver);
	}
	
	/**
	 * This Test Script is used to Update the  CRM popup and End the call in ConVox CCS 3.2.4 Application
	 * @throws InterruptedException
	 */
	@Test
	public void CrmUpdateAndEndCall() throws InterruptedException
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.Outboundcall(driver, "9100187911");
		ahp.CrmPopup(driver);
		Thread.sleep(3000);
		ahp.CrmUpdateAndEndCall(driver, "Checking CRM Update", "Deepija telecom ","Deepija Main Product Convox","No Remark","Main Branch", "Hyderabad", "NI --- Not Interested");
	}
	
	/**
	 * This Test Script is used to Wrap up The call in ConVox CCS 3.2.4 Application
	 * @throws Throwable
	 */
	@Test
	public void Wrapupcall() throws Throwable
	{
		AgentHomePage ahp = new AgentHomePage(driver);
		ahp.Outboundcall(driver, "9100187911");
		ahp.CrmPopup(driver);
		Thread.sleep(3000);
		ahp.WrapupCall(driver);
	}
	
	/**
	 * This Test Script is used to Initiate calls Automatically and update CRM in 
	 * ConVox CCS 3.2.4 Application
	 */
	@Test
	public void PredectiveCallTest() 
	{
		try {
			
			while(true) {
				AgentHomePage ahp = new AgentHomePage(driver);
				ahp.SwitchToAgentFrame(driver);
				String Queuetext = ahp.QueueNumber.getText();
				System.out.println(Queuetext);
				for(int i=0;i<Queuetext.length();i++)
				{
					ahp.CrmUpdateAndEndCall(driver,"Welcome to DTEL", "DEEPIJA","Deepija Main Product was ConVox","No Remark","Main Branch","Hyderabad", "Test --- Test_Call");
					Reporter.log("CRM updated Succesfully",true);
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
