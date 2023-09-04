package Convox.GenericLibraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class  consist of all the Generic methods related to WebDriver Actions
 * @author Kiran
 *
 */
public class WebDriverLibrary {
	
	/**
	 * This method is used to maximise the web application Window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait for 20 sec to load the page 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
	}
	
	/**
	 * This method is used to wait for 20sec for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForAnElementToVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20L));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	/**
	 * This method is used to wait for 20sec for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForAnElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20L));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This is a custom/fluent wait which is used to wait for element and perform click action
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickable(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count < 10)
		{
			try 
			{
				element.click();
				break;
			} 
			catch (Exception e) 
			{
				Thread.sleep(2000);
				count++;
			}
		}
	}
	
	/**
	 * This method will handle drop-down through select class and select data by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop-down through select class and select data by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle drop-down through select class and select data by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform right click on the web page
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform double click on web page
	 * @param driver
	 */
	public void doubleClickOn(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on a particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will drag and drop from source element to destination element
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropOn(WebDriver driver, WebElement srcElement, WebElement dstElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).perform();
	}
	
	/**
	 * This is method will mouse hover using offset value for x and y co-ordinates.
	 * @param driver
	 * @param xOff
	 * @param yOff
	 */
	public void mouseHoverOn(WebDriver driver, int xOff, int yOff)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xOff, yOff).perform();
	}
	
	/**
     * This method will switch to frame based on index
     * @param driver
     * @param index
     */
    public void switchToFrame(WebDriver driver, int index)
    {
      driver.switchTo().frame(index);
    }

    /**
     * This method will switch to frame based on name or id
     * @param driver
     * @param nameOrId
     */
    public void switchToFrame(WebDriver driver, String nameOrId)
    {
      driver.switchTo().frame(nameOrId);
    }

    /**
     * This method will switch to frame based on element
     * @param driver
     * @param element
     */
    public void switchToFrame(WebDriver driver, WebElement element)
    {
      driver.switchTo().frame(element);
    }

    /**
     * This method will switch from current frame to immediate parent
     * @param driver
     */
    public void switchToParentFrame(WebDriver driver)
    {
      driver.switchTo().parentFrame();
    }

    /**
     * This method will switch from current frame to default frame
     * @param driver
     */
    public void switchToDefaultFrame(WebDriver driver)
    {
      driver.switchTo().defaultContent();
    }

    /**
     * This method will click accept in alert pop up
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
      driver.switchTo().alert().accept();
    }

    /**
     * This method will click on cancel in alert pop up
     * @param driver
     */
    public void dismisAlert(WebDriver driver)
    {
      driver.switchTo().alert().dismiss();
    }

    /**
     * This method will return the text of alert pop up to the caller
     * @param driver
     * @return
     */
    public String getAlertText(WebDriver driver)
    {
      String alertText = driver.switchTo().alert().getText();
      return alertText;
    }

    /**
     * This method will press the enter key
     * @throws AWTException
     */
    public void pressEnter() throws AWTException
    {
      Robot r = new Robot();
      r.keyPress(KeyEvent.VK_ENTER);
      r.keyRelease(KeyEvent.VK_ENTER);	
    }
    
    
    /**
     * This method which is used to Take Screenshots
     * @param driver
     * @param screenshotName
     * @return 
     * @throws IOException
     */
    public String takeScreenshot(WebDriver driver , String screenshotName) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	String path = ".\\ScreenShots\\"+screenshotName+".png";
    	File dest = new File(path);
    	Files.copy(src, dest);
    	
    	return dest.getAbsolutePath();
    }
    
    /**
	 * This method will used to perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("winodw.scrollBy(0,500)", "");
	}
	
	/**
	 * This method will used to scroll until the particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].scrollIntoView()", element);
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	/**
	 * This method will switch to the window with respect to the window title
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//Step 1: get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//Step 2: iterate thru all the windowIds
		Iterator<String> it = windowIds.iterator();
		
		//Step 3: navigate inside the windows
		while(it.hasNext())  //loop untill windowidSs exist
		{
			//capture all the window ids
			String winId = it.next();
			
			//switch to the window and capture the title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if(currentTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
}
