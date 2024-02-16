package AdminModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Convox.GenericLibraries.WebDriverLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ListCreation {

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

		// Enter Into List Module under System settings
		WebElement systemSettings = driver.findElement(By.cssSelector("li[id='system_li'] font[align='right']"));
		wLib.mouseHoverOn(driver, systemSettings);
		driver.findElement(By.xpath("//a[@href='?user_sel_menu=Lists']")).click();
		
		

	}

}
