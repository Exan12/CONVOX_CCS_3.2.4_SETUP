package Convox.GenericLibraries;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class consists of all abstract Methods of ITestListener Interface
 * @author Kiran
 *
 */
public class ListenersImplementationLibrary implements ITestListener
{
	ExtentReports report ;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		String METHODNAME = result.getMethod().getMethodName();
		//Reporter.log("Test is Started---> "+METHODNAME,true);
		test = report.createTest(METHODNAME);
		test.log(Status.INFO,"Test is Started");
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String METHODNAME = result.getMethod().getMethodName();
	//Reporter.log("Test is Succeded ---> "+METHODNAME,true);
	test.log(Status.PASS,METHODNAME+" ---> Test is Successed");
	}

	public void onTestFailure(ITestResult result) 
	{
		WebDriverLibrary wLib = new WebDriverLibrary();
		JavaLibrary jLib = new JavaLibrary();
		String METHODNAME = result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//Reporter.log("Test is Failed ---> "+METHODNAME,true);
		test.log(Status.FAIL,METHODNAME+" ---> Test is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			
			String path = wLib.takeScreenshot(BaseClass.sDriver, METHODNAME);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	{
		String METHODNAME = result.getMethod().getMethodName();
		Reporter.log("Test is Skipped ---> "+METHODNAME,true);
		test.log(Status.SKIP, METHODNAME+" ---> Test is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context)
	{
		Reporter.log("Execution of Suite File was Started",true);
		
		// Execution of Suite File started, Configure the Extent Reports.Reports-11-11-2022-11-03.html
		ExtentSparkReporter htmlReports = new ExtentSparkReporter(".\\ExtenReports_ConVox\\Reports - "+new JavaLibrary().getSystemDateInFormat()+" .html");
		htmlReports.config().setDocumentTitle("Extent Reports For CONVOX CSS 3.2.4  Applicaction");
		htmlReports.config().setTheme(Theme.DARK);
		htmlReports.config().setReportName("CONVOX CCS 3.2.4 Execution Reports");
		
		// Attach Report to Extent Reports
		report = new ExtentReports();
		report.attachReporter(htmlReports);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base Platform", "windows-10");
		report.setSystemInfo("Base Url", "http://h77.deepijatel.in/ConVoxCCS/");
		report.setSystemInfo("Reporter Name", "KIRAN");
		
		
	}

	public void onFinish(ITestContext context) 
	{
		Reporter.log("Execution of Suite File was Finished",true);
		
		// Flush the Report - Here Execution was finished
		report.flush();
	}
	
}
