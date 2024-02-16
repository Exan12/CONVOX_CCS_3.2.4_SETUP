package AdminModule;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserCreationScript {

	static String x;

	public static void main(String[] args) throws InterruptedException {

		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dtel\\Downloads\\cr driv\\chromedriver_new\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");*/

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));// implicitly wait of 30 seconds globally

		String link = "http://172.16.12.129/ConVoxCCS/Admin/index";

		driver.get(link);

		WebElement Admin = driver.findElement(By.xpath("//img[@title='Admin Login']"));

		Admin.click();// clicking on Admin tab

		String username = "admin";

		String pass = "admin";

		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(pass);

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		System.out.println(" - - - Admin logged in successfully - - - ");

		WebElement SystemSettings = driver.findElement(By.xpath("(//font[normalize-space()='System Settings'])[1]"));

		SystemSettings.click();

		driver.findElement(By.xpath("//a[@onclick='postURL(\"?user_sel_menu=Users\",\"false\");return false;']")).click();
		for (int i = 322; i <= 333; i++) {

			driver.findElement(By.xpath("//img[@title='Add Users']")).click();

			x = "agent";

			driver.findElement(By.xpath("//input[@id='agent_id']")).sendKeys(String.valueOf(x + i));

			driver.findElement(By.xpath("//input[@id='agent_name']")).sendKeys(String.valueOf(x + i));

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234");

			WebElement AvailableProcess = driver.findElement(By.xpath("//select[@id='available_processes']//option[@value='ConVoxProcess'][normalize-space()='ConVoxProcess']"));

			// Selecting Process
			/*Select processdropdown = new Select(process);
			processdropdown.selectByValue("ConVoxProcess");*/
			AvailableProcess.click();
			WebElement forwardArrow = driver.findElement(By.xpath("//input[@onclick='move_process(available_processes,selected_processes); process_queues();']"));
			forwardArrow.click();

			WebElement agentActive = driver.findElement(By.xpath("//select[@id='active']"));

			Select agentActivedropdown = new Select(agentActive);

			agentActivedropdown.selectByValue("1");// selecting yes

			WebElement showrecentcalls = driver.findElement(By.xpath("//select[@name='show_recent_calls']"));

			Select showrecentcallsdropdown = new Select(showrecentcalls);

			showrecentcallsdropdown.selectByValue("1");// selecting yes

			//	WebElement enableFollowUps = driver.findElement(By.xpath("//select[@id='only_callbacks']"));

			//	Select enableFollowupsdropdown = new Select(enableFollowUps);

			//	enableFollowupsdropdown.selectByValue("Y");// selecting yes

			//	WebElement enablecallbacks = driver.findElement(By.xpath("//select[@id='allow_auto_callbacks']"));

			//	Select enablecallbacksdropdown = new Select(enablecallbacks);

			//	enablecallbacksdropdown.selectByValue("Y");// selecting yes 

			driver.findElement(By.xpath("//input[@id='manual_outbound']")).click();

			WebElement queues = driver.findElement(By.id("queue_from"));

			Select queuesdropdown = new Select(queues);

			queuesdropdown.selectByValue("SalesQ");// selecting salesQ

			driver.findElement(By.xpath("//input[@onclick='move_right();']")).click();

			//	WebElement queues2 = driver.findElement(By.id("queue_from"));

			//	Select queuesdropdown2 = new Select(queues2);

			//	queuesdropdown2.selectByValue("SupportQ");// selecting supportQ

			//	driver.findElement(By.xpath("//input[@onclick='move_right();']")).click();

			driver.findElement(By.xpath("//input[@id='form_type']")).click();

			Thread.sleep(2000);
			
			//	driver.findElement(By.xpath("//input[@alt='alternative login']")).click();

			System.out.println(" - - - User"+i+" Created Succesfully - - - ");
		}
	}
}