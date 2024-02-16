package Agent_Module;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Convox.GenericLibraries.WebDriverLibrary;
import Convox.ObjectRepository.AgentModule.AgentLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConvoxAIDisposition {
	
	static List<WebDriver> drivers;
	static String[] agentStatus;
	static String statusOfCall;
	static WebElement agentDetails;
	static String agent;
	static String[] agent1;
	static WebDriver driver;

    public static void main(String[] args) throws Throwable {
        String csvFilePath = ".\\src\\test\\resources\\Agent_And_Stations.csv";

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
            String line;

            // Number of threads
            ExecutorService executor = Executors.newFixedThreadPool(4);

            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(",");
                String agent = data[0];
                String station = data[1];
                Runnable worker = new WorkerThread1(agent, station);
                executor.execute(worker);
            }

            csvReader.close();
            executor.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WorkerThread1 implements Runnable {
    private String agent;
    private String station;

    public WorkerThread1(String agent, String station) {
        this.agent = agent;
        this.station = station;
    }

    @Override
    public void run() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
        driver.get("http://172.16.12.212/ConVoxCCS/index.php");

        AgentLoginPage alp = new AgentLoginPage(driver);
        try {
            alp.LoginToAgentModule(agent, "1234", station);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        WebElement clickOnAgent = driver.findElement(By.id("agent"));
        clickOnAgent.click();

        String windowHandle = driver.getWindowHandle();
	    System.out.println("Window ID is " + windowHandle);

        while (true) {

			WebDriver[] drivers = null;
			for (WebDriver driver1 : drivers) {
				String mainWindow = driver.getWindowHandle();
				String statusOfCall = null;
				// System.out.println("Main window handle is " + mainWindow);
				do {
					// To handle all newly opened windows
					for (String windowHandle1 : driver.getWindowHandles()) {
						 System.out.println("Window handle: " + windowHandle);

						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("agentframe"));// switching to agent frame
																										

						// System.out.println("Switched to agent frame");

						WebElement agentCallDetails = driver.findElement(By.xpath("//span[@id='agent_status_span']"));

						String[] agentStatus = agentCallDetails.getText().split(" ");// splitting agent status from time

						statusOfCall = agentStatus[0];

						// System.out.println(statusOfCall);

						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// waiting 2 seconds to find the agent details in below line
						WebElement agentDetails = driver.findElement(By.xpath(
								"//html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/center[1]"));// xpath for agent details in tab 
						
						// System.out.println("Window handle: " + windowHandle + " AgentText:" + agentDetails.getText());

						agent = agentDetails.getText();

						String[] agent1 = agent.split("\n");

						String agentpart = agent1[0];

						// System.out.println(agentpart);

						if (statusOfCall.equals("ONCALL") || statusOfCall.equals("WRAPUP")) {

							driver.switchTo().defaultContent();

							driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='mainframe']")));

							// System.out.println("SWITCHED TO MAIN FRAME TO ENTER DETAILS");

							driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ecrmframe']")));

							WebElement hidden = driver.findElement(By.xpath("(//input[@id='mobile_number'])[1]"));

							String PrimaryNumber = hidden.getAttribute("value");

							driver.findElement(By.xpath("//input[@value='EndCall']")).click();

							System.out.println("Cliked on end call successfully for : " + "" + agentpart + ""
									+ " To Number " + PrimaryNumber);

						}

						else {
							// System.out.println("Agent is in some other status ");
						}

						driver.switchTo().defaultContent();

						// System.out.println("Switched to default content");

					}

				} while (statusOfCall.equals("ONCALL"));

			}
		}

    }
}
