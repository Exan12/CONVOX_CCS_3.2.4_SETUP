import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NotepadData {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Set up WebDriver for Firefox
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Navigate to the web page
        driver.get("http://www.postalpincode.in/Search-By-Location");

        // Locate the state dropdown and select an option (e.g., ANDAMAN)
        WebElement processActiveDropdown = driver.findElement(By.id("ContentPlaceHolder1_ddlState"));
        Select selectStateDropdown = new Select(processActiveDropdown);
        selectStateDropdown.selectByValue("1");

        // Create a BufferedWriter to write data to a text file
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\kk\\Desktop\\STATES\\output.txt"));

        while (true) {
            // Extract data from the current page's table (first 3 columns) and write to the file
            extractTableData(driver, writer);

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
        driver.quit();

        // Close the file writer
        writer.close();
    }

    // Function to extract table data (first 3 columns) from the current page and write to a file
    private static void extractTableData(WebDriver driver, BufferedWriter writer) throws IOException {
        // Locate the table element
        WebElement table = driver.findElement(By.id("ContentPlaceHolder1_gvBranch"));

        for (WebElement row : table.findElements(By.tagName("tr"))) {
            // Find all cells in the current row
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));

            if (cells.size() >= 4) {
                // Extract data from the first 3 columns
                StringBuilder cellData = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    cellData.append(cells.get(i).getText()).append("\t"); // Assuming tab-separated data
                }

                // Write the data to the file
                writer.write(cellData.toString().trim());
                writer.newLine();
                System.out.println("Data was completed");
            }
        }
    }
}
