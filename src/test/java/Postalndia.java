import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Postalndia {

	public static void main(String[] args) throws InterruptedException {

	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.postalpincode.in/Search-By-Location");
		WebElement processActiveDropdown = driver.findElement(By.id("ContentPlaceHolder1_ddlState"));
		Select selectStateDropdown = new Select(processActiveDropdown);
		
		//for AP
		selectStateDropdown.selectByValue("6");
		Thread.sleep(5000);
		System.out.println("Selected State Andhra Pradesh");

		while (true) {
			// Extract data from the current page's table (first 3 columns)
			extractTableData(driver);

			// Click on the "Next" button to move to the next page
			WebElement nextButton = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_gvBranch_GridViewPaging_imgBtnNext']"));
			if (nextButton.isEnabled()) {
				nextButton.click();
			} else {
				// If "Next" button is disabled, break out of the loop (no more pages)
				break;
			}
		}

		// Close the WebDriver
		//driver.quit();
	}

	// Function to extract table data (first 3 columns) from the current page
	private static void extractTableData(WebDriver driver) {
		// Locate the table element
		WebElement table = driver.findElement(By.id("ContentPlaceHolder1_gvBranch"));


		for (WebElement row : table.findElements(By.tagName("tr"))) {
			// Find all cells in the current row
			java.util.List<WebElement> cells = row.findElements(By.tagName("td"));

			if (cells.size() >= 4) {
				// Extract data from the first 3 columns
				String cellData = "";
				for (int i = 0; i < 4; i++) {
					cellData += cells.get(i).getText() + "\t"; // Assuming tab-separated data
					
				}

				System.out.println(cellData.trim());

			}
		}
	}
}