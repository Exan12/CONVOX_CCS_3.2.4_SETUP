package AdminModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Convox.GenericLibraries.WebDriverLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProcessCreation {


	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverLibrary wLib = new WebDriverLibrary();
		//Browser Initiation
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// Implicitly wait of 30 seconds globally
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launching required URL

		//String link = "https://h58.deepijatel.in/ConVoxCCS/index";
		String link = "http://172.16.12.129/ConVoxCCS/Admin/index";
		driver.get(link);

		// Login to the Admin Pannel
		WebElement Admin = driver.findElement(By.xpath("//img[@title='Admin Login']"));
		Admin.click();
		String username = "admin";
		String pass = "admin";
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println(" - - - Admin Logged In successfully - - - ");

		// Enter Into Process Module under System settings
		WebElement systemSettings = driver.findElement(By.xpath("//font[normalize-space()='System Settings']"));
		systemSettings.click();

		// Click on Process Button
		WebElement ProcessBtn = driver.findElement(By.xpath("//a[@href='?user_sel_menu=Process']"));
		ProcessBtn.click();

		for (int var=26;var<=30;var++)
		{
			// Process Add Lookup Button
			WebElement addProcessLookupBtn = driver.findElement(By.xpath("//img[@title='Add Process']"));
			addProcessLookupBtn.click();
			WebElement ProcessTextField = driver.findElement(By.xpath("//input[@id='process']"));
			
			String ProcessName = "Process"+var;
			ProcessTextField.sendKeys(ProcessName);
			WebElement processDescription = driver.findElement(By.xpath("//textarea[@id='process_description']"));
			processDescription.sendKeys("This Process is for Automation Testing");
			driver.findElement(By.xpath("//input[@id='PROCESS_SUBMIT']")).click();

			// Checking all Auto Functionalites
			driver.findElement(By.xpath("//input[@id='auto_wp']")).click(); // Auto Wrapup
			driver.findElement(By.xpath("//input[@id='auto_mp']")).click(); // Auto Missed
			driver.findElement(By.xpath("//input[@id='auto_fp']")).click(); // Auto First Login
			driver.findElement(By.xpath("//input[@id='auto_op']")).click(); // Auto Outbound

			WebElement webform = driver.findElement(By.xpath("//textarea[@id='web_form']"));
			webform.sendKeys("https://www.google.co.in/");
			driver.findElement(By.xpath("//input[@id='channels']")).clear();
			driver.findElement(By.xpath("//input[@id='channels']")).sendKeys("25");
			System.out.println(" --- Process"+var+" created Successfully - - - ");

			// Recording File name order
			driver.findElement(By.xpath("//option[@value='Process']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_fields,selected_fields)']")).click();

			driver.findElement(By.xpath("//option[@value='Queue']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_fields,selected_fields)']")).click();

			driver.findElement(By.xpath("//option[@value='AgentID']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_fields,selected_fields)']")).click();

			driver.findElement(By.xpath("//option[@value='Extension']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_fields,selected_fields)']")).click();

			driver.findElement(By.xpath("//option[@value='CallMode']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_fields,selected_fields)']")).click();

			// Buffer Level
			driver.findElement(By.xpath("//input[@id='buffer_level']")).clear();
			driver.findElement(By.xpath("//input[@id='buffer_level']")).sendKeys("10");

			// Outbound Route
			WebElement outboundRoute = driver.findElement(By.xpath("//select[@id='outbound_route_id']"));
			Select sel = new Select(outboundRoute);
			sel.selectByVisibleText("ROUTE");

			// Dailable Status
			driver.findElement(By.xpath("//option[@value='AUTOWRAPUP']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_statuses,selected_statuses)']")).click();

			driver.findElement(By.xpath("//option[@value='KIRAN']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_statuses,selected_statuses)']")).click();

			driver.findElement(By.xpath("//option[@value='NEW']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_statuses,selected_statuses)']")).click();

			driver.findElement(By.xpath("//option[@value='ANA--Normal Call Clearing']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_statuses,selected_statuses)']")).click();
			
			driver.findElement(By.xpath("//option[@value='NI']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_statuses,selected_statuses)']")).click();
			
			// Inbound Fields
			WebElement GreetingFile = driver.findElement(By.xpath("//select[@id='greeting_file_select']"));
			wLib.handleDropDown("SalesQ", GreetingFile);

			// Selecting Accepting Greeting file
			WebElement acceptGreeting = driver.findElement(By.xpath("//select[@id='greeting_accept']"));
			wLib.handleDropDown("Y", acceptGreeting);


			/**
			 * ADDING QUEUES TO THE PROCESS MODULE IN CONVOX 3.3 APPLICATION
			 */
			driver.findElement(By.xpath("//span[normalize-space()='Add Queue']")).click();

			// Switching Window from parent to Child
			wLib.switchToWindow(driver, "add_records");
			System.out.println(" - - - Switched To Queues Window - - - ");
			
			String QueueName = "Queue"+var;
			driver.findElement(By.xpath("//input[@id='queue_name']")).sendKeys(QueueName);
		
						
			// Selecting Waiting message in the queue
			WebElement waitingMessage = driver.findElement(By.id("call_queue_file_id"));
			wLib.handleDropDown(waitingMessage, "1");

			// Selecting Greeting File in the Queue
			WebElement queueGreetingFile = driver.findElement(By.xpath("//select[@id='greeting_file_id']"));
			wLib.handleDropDown(queueGreetingFile, "1");

			// Sending Queue drop time
			driver.findElement(By.xpath("//input[@id='queue_drop_time']")).sendKeys("300");

			//	Selecting Queue drop action
			WebElement queueDropaction = driver.findElement(By.xpath("//select[@id='queue_drop_action']"));
			wLib.handleDropDown(queueDropaction, "play");

			// Selecting Queue Drop value
			WebElement queueDropValue = driver.findElement(By.xpath("//select[@id='queue_drop_value']"));
			wLib.handleDropDown(queueDropValue, "3");

			// Sending Queue Length
			driver.findElement(By.xpath("//input[@id='queue_length']")).sendKeys("0");
			WebElement queueADD = driver.findElement(By.xpath("//input[@id='form_type']"));
			queueADD.click();

			wLib.switchToWindow(driver, "index");
			System.out.println(" - - - Switched To Parent Window - - - ");
			
			// Selecting Queues from available Tab
			driver.findElement(By.xpath("//option[@value='"+QueueName+"']")).click();
			driver.findElement(By.xpath("//input[@onclick='a_move_right(available_queues,selected_queues)']")).click();
			
			// Checking the DTMF check boxes
			driver.findElement(By.xpath("//input[@id='Dtmf']")).click();
			
		    WebElement DefaultQueue = driver.findElement(By.xpath("//select[@id='d_queue']"));
		    wLib.handleDropDown(DefaultQueue,QueueName);
		    
		    /**
		     *  ADDING DISPOSITIONS TO THE PROCESS MODULE IN CONVOX 3.3 APPLICATION
		     */
		    driver.findElement(By.xpath("//span[normalize-space()='Add Disposition']")).click();
		    wLib.switchToWindow(driver, "add_records");
			System.out.println(" - - - Switched To Dispositions Window - - - ");
			
			String DispositionCode = "DISPO"+var;
			driver.findElement(By.xpath("//input[@id='dispo_code']")).sendKeys(DispositionCode);
			
			String DispositionName = "Kiran Disposition "+var;
			driver.findElement(By.id("dispo_name")).sendKeys(DispositionName);
			WebElement PTPEnable = driver.findElement(By.xpath("//select[@id='is_ptp']"));
			wLib.handleDropDown(PTPEnable, "0");
			WebElement AddDispo = driver.findElement(By.xpath("//input[@id='form_type']"));
			AddDispo.click();
			wLib.switchToWindow(driver, "index");
			System.out.println(" - - - Switched To Parent Window - - - ");
			
			//WebElement availableStatus = driver.findElement(By.xpath("//select[@id='available_dispositions']"));
			//wLib.handleDropDown(availableStatus,DispositionCode);
			driver.findElement(By.xpath("//option[contains(@value,'DNC')]")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_dispositions,selected_dispositions)']")).click();
			//wLib.acceptAlert(driver);
			driver.findElement(By.xpath("//option[@value='"+DispositionCode+"']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_dispositions,selected_dispositions)']")).click();
			
			
			/**
		     *  ADDING BREAKS TO THE PROCESS MODULE IN CONVOX 3.3 APPLICATION
		     */
			driver.findElement(By.xpath("//span[normalize-space()='Add Break']")).click();
			wLib.switchToWindow(driver, "add_records");
			System.out.println(" - - - Switched To BREAK Window - - - ");
			
			String BreakName = "TEA"+var;
			driver.findElement(By.xpath("//input[@id='break']")).sendKeys(BreakName);
			driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Tea Break"+var);
			WebElement BreakTime = driver.findElement(By.xpath("//select[@id='min']"));
			wLib.handleDropDown(BreakTime, "05");
			WebElement addBreak = driver.findElement(By.xpath("//input[@id='form_type']"));
			addBreak.click();
			wLib.switchToWindow(driver, "index");
			System.out.println(" - - - Switched To Parent Window - - - ");
			
			driver.findElement(By.xpath("//option[@value='"+BreakName+"']")).click();
			driver.findElement(By.xpath("//input[@onclick='move_right(available_breaks,selected_breaks)']")).click();
			
			// Click on Modify Button
			WebElement Modifybutton = driver.findElement(By.xpath("//input[@name='form_type']"));
			Modifybutton.click();
			System.out.println(" - - - Succesfully Created "+ProcessName);
		}

	}

}
