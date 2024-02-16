package Agent_Module;
import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_Disp {

	static String userName;
	public static void main(String[] args) throws InterruptedException, IOException {
		List<WebDriver> drivers = new ArrayList<WebDriver>();

		WebDriverManager.firefoxdriver().setup();
		String csvFilePath = ".\\src\\test\\resources\\Agent_And_Stations.csv";

		WebDriverManager.firefoxdriver().setup();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) {
					userName = parts[0].trim();
					String password = parts[1].trim();
					String station = parts[2].trim();

					WebDriver driver = new FirefoxDriver();
					drivers.add(driver);

					driver.manage().window().maximize();
					driver.get("http://172.16.12.212/ConVoxCCS/index.php");

					WebElement clickOnAgent = driver.findElement(By.id("agent"));
					clickOnAgent.click();

					WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
					WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
					WebElement stationNumberField = driver.findElement(By.xpath("//input[@id='station']"));
					WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
					usernameField.sendKeys(userName);
					passwordField.sendKeys(password);
					stationNumberField.sendKeys(station);
					loginButton.click();
					Thread.sleep(3000);
				}
			}
		}

		for (WebDriver driver : drivers) {

			while (true) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("agentframe"));

				WebElement agentCallDetails = driver.findElement(By.xpath("//span[@id='agent_status_span']"));
				String[] agentStatus = agentCallDetails.getText().split(" ");
				String statusOfCall = agentStatus[0];
				System.out.println(statusOfCall);

				if (statusOfCall.equals("RINGING") || statusOfCall.equals("WRAPUP")) {

					System.out.println("Came into IF Loop");
					// Switch to the appropriate frames and get the necessary elements
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='mainframe']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ecrmframe']")));

					WebElement hidden = driver.findElement(By.xpath("(//input[@id='mobile_number'])[1]"));
					String PrimaryNumber = hidden.getAttribute("value");

					// Click the "EndCall" button
					driver.findElement(By.xpath("//input[@value='EndCall']")).click();
					System.out.println("Clicked on EndCall "+userName+" with Primary Number: " + PrimaryNumber);


				}

				// Switch back to the agent frame
				driver.switchTo().defaultContent();

				// Add a delay to control how often you check agent status, e.g., sleep for 5 seconds
				Thread.sleep(1000);

			}
		}
	}
}

