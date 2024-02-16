package Agent_Module;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Convox.ObjectRepository.AgentModule.AgentLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class FThreading_Multi {


	static int count;
	public static void main(String[] args) throws Throwable {

		String csvFilePath = ".\\src\\test\\resources\\Agent_And_Stations.xlsx";

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
			String line;

			// Number of threads
			ExecutorService executor = Executors.newFixedThreadPool(2); 

			count=1;
			while ((line = csvReader.readLine()) != null) {
				String[] data = line.split(",");

				// Agent is in the first column
				String agent = data[0]; 

				// Assuming station is in the second column
				String station = data[1]; 

				Runnable worker = new WorkerThread(agent, station);
				executor.execute(worker);
				if(count%5 == 0)
				{
					Thread.sleep(4000);
				}


			}

			csvReader.close();
			executor.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class WorkerThread implements Runnable {
	private String agent;
	private String station;

	public WorkerThread(String agent, String station) {
		this.agent = agent;
		this.station = station;
	}

	@Override
	public void run() {

		long threadId = Thread.currentThread().getId();
		System.out.println("Thread " + threadId + " started.");

		// Login to the Multiple Agents with Multiple stations

		DesiredCapabilities caps = new DesiredCapabilities();
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("-private");
		caps.setCapability("moz:firefoxOptions",fo);
		fo.setHeadless(true);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
			driver.get("http://172.16.13.86/ConVoxCCS/index.php");

			// Login to agent panel with Multiple Stations
			AgentLoginPage alp = new AgentLoginPage(driver);
			alp.LoginToAgentModule(agent, "1234", station);
			WebElement clickOnAgent = driver.findElement(By.id("agent"));
			clickOnAgent.click();

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// driver.quit();
		}
		System.out.println("Thread " + threadId + " finished.");
	}

}
