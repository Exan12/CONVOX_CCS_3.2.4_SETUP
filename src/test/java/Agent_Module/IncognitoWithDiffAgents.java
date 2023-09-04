package Agent_Module;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Convox.ObjectRepository.AgentModule.AgentLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IncognitoWithDiffAgents {
    
    public static void main(String[] args) throws Throwable {
        
        String csvFilePath = ".\\src\\test\\resources\\agents and station2_4Servers.csv";

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            
            // Number of threads
            ExecutorService executor = Executors.newFixedThreadPool(5);

            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(",");

                // Agent is in the first column
                String agent = data[0]; 
                
                // Assuming station is in the second column
                String station = data[1]; 
                    
                Runnable worker = new WorkerThread2(agent, station);
                executor.execute(worker);
            }

            csvReader.close();
            executor.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WorkerThread2 implements Runnable {
    private String agent;
    private String station;

    public WorkerThread2(String agent, String station) {
        this.agent = agent;
        this.station = station;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("Thread " + threadId + " started.");

        // Login to the Multiple Agents with Multiple stations
        DesiredCapabilities caps = new DesiredCapabilities();
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions fo = new FirefoxOptions();
        fo.addArguments("-private"); // Enable private browsing (incognito mode)
        caps.setCapability("moz:firefoxOptions", fo);
        WebDriver driver = new FirefoxDriver(fo);

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
            //driver.get("http://h77.deepijatel.in/ConVoxCCS/index.php");

            // Login to agent panel with Multiple Stations
            AgentLoginPage alp = new AgentLoginPage(driver);
            alp.LoginToAgentModule(agent, "1234", station);  
            
            // Open multiple tabs within the same browser instance
            for (int i = 0; i < 5; i++) {
            driver.switchTo().newWindow(WindowType.TAB);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
        System.out.println("Thread " + threadId + " finished.");
    }
}
