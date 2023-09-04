package Agent_Module;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Convox.GenericLibraries.BaseClass;
import Convox.GenericLibraries.XLUtility;
import Convox.ObjectRepository.AgentModule.AgentHomePage;
import Convox.ObjectRepository.AgentModule.AgentLoginPage;

@Listeners(Convox.GenericLibraries.ListenersImplementationLibrary.class)
public class AgentMultipleLoginTest extends BaseClass{

	@Test(dataProvider = "LoginData")
	public void MultipleLogin(String USERNAME,String PASSWORD,String STATION) throws Throwable
	{
		AgentLoginPage alp = new AgentLoginPage(driver);
		alp.LoginToAgentModule(USERNAME, PASSWORD, STATION);
		Reporter.log("Runnning Current Thread: "+Thread.currentThread().getId(),true);
		Reporter.log(USERNAME+" --- Logged Into Agent Module Succesfully --- ",true);

		// Predective Calling Mode with Pacing 1
		try {

			while(true) {
				AgentHomePage ahp = new AgentHomePage(driver);
				ahp.SwitchToAgentFrame(driver);
				String Queuetext = ahp.QueueNumber.getText();
				System.out.println(Queuetext);
				for(int i=0;i<Queuetext.length();i++)
				{
					// Random Hold
					//Crm Update
					ahp.CrmUpdateAndEndCall(driver,"Welcome to DPTEL", "DEEPIJA","Deepija Main Product was Convox","No Remark","Main Branch","Hyderabad", "Test --- Test_Call");
					Reporter.log("CRM updated Succesfully",true);
					Thread.sleep(3000);
					
					// Agent Logout
					ahp.LogoutFromAgentModule(driver);
					Reporter.log(USERNAME+" --- Logged Out from Agent Module Succesfully --- ",true);

				}
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 

	}

	@DataProvider(name = "LoginData")
	public String [][] getMultipleusername() throws Throwable
	{
		//get the data from excel
		String path=".\\src\\test\\resources\\Agent Login.xlsx";
		XLUtility xlutil=new XLUtility(path);

		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	

		String loginData[][]=new String[totalrows][totalcols];


		for(int i=1;i<=totalrows;i++) //Row ---> 1
		{
			for(int j=0;j<totalcols;j++) //Coloumn ---> 0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}

		}

		return loginData;
	}
}
