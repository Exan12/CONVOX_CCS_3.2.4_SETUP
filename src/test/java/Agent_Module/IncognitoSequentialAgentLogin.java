package Agent_Module;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Convox.ObjectRepository.AgentModule.AgentLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IncognitoSequentialAgentLogin {

	public static void main(String[] args) {

		String csvFilePath = ".\\src\\test\\resources\\agents and station2_4Servers.csv";

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();

		// Enable private browsing (incognito mode)
		fo.addArguments("-private"); 
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("moz:firefoxOptions", fo);
		WebDriver driver = new FirefoxDriver(fo);

		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
			driver.get("http://h77.deepijatel.in/ConVoxCCS/index.php");

			BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
			String line;

			int tabCount = 0;
			while ((line = csvReader.readLine()) != null && tabCount < 5) {
				String[] data = line.split(",");

				// Agent is in the first column
				String agent = data[0]; 

				// Assuming station is in the second column
				String station = data[1]; 

				if (tabCount > 0) 
				{
					// Open new tab
					driver.switchTo().newWindow(WindowType.TAB);
					driver.switchTo().window(driver.getWindowHandles().toArray()[tabCount].toString());
				}

				processAgent(driver, agent, station);

				tabCount++;
			}

			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// driver.quit();
		}
	}

	public static void processAgent(WebDriver driver, String agent, String station) {
		try {
			driver.get("http://h77.deepijatel.in/ConVoxCCS/index.php");
			// Login to agent panel with Multiple Stations
			AgentLoginPage alp = new AgentLoginPage(driver);
			alp.LoginToAgentModule(agent, "1234", station);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
