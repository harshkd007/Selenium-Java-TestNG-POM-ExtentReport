package baseTest;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest {

	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest logger;

	@BeforeTest
	public void beforeTestMethod()
	{
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"SDETADDAE");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Tests Results by SDET ADDA");
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String brower, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		setupDriver(brower);
		driver.get(Constants.url);
		driver.manage().window().maximize();
	}

	public void setupDriver(String browser)
	{
		switch (browser)
		{
		case "chrome": WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		case "firefox": WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
		case "edge": WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		default:     	break;
		}

	}

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		switch (result.getStatus()) 
		{
		case ITestResult.FAILURE: logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - Test Case Failed", ExtentColor.RED));
		break;

		case ITestResult.SUCCESS: logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Passed", ExtentColor.GREEN));
		break;

		case ITestResult.SKIP: logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - Test Case Skipped", ExtentColor.ORANGE));
		break;

		default:               	  break;
		}
		driver.quit();
	}

	@AfterTest
	public void aftertest()
	{
		extent.flush();
	}




}
