package org.baseclass;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;

public class BaseClass extends Setup{
	
	
	protected static ExtentHtmlReporter report = new ExtentHtmlReporter("./target/Report1.html");
	protected static ExtentReports extent  = new ExtentReports();
   
	
	
	public static Logger Log = Slf4j.loadlogger(BaseClass.class);
	
	
//	@BeforeSuite
//	public static void browserLaunch() throws Exception {
//		
//		extent.attachReporter(report);
//		Log.info("launching the browser");
//		browserLaunch("chrome");
//		
//	}
	@Parameters({"Browser"})
	@BeforeTest
	public static void launchBrowser(String browser) throws Exception {
		
		extent.attachReporter(report);
		Log.info("launching the browser");
		browserLaunch(browser);
		
	}
	
	
	@BeforeClass
	public  void toLoadURl() throws Exception {
		
		loadUrl(ReadData.getConfigPropData("url"));
		
		
	}
	

	
	public static WebDriver driver = null;

	public static void browserLaunch(String key) throws Exception {
		
	    switch (key){
	    
	    case "chrome":
	    
	     System.setProperty(ReadData.getConfigPropData("chromevariable"),"./Driver/chromedriver.exe");
	     driver= new ChromeDriver();
	     break;
		
	    case "firefox":
	    	
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		driver= new FirefoxDriver();
		break;
		
		default:
		System.out.println("the given key is not present in the case");
		
	    }
	    
		}
	
	
	public void browserMax() {
		
		driver.manage().window().maximize();
	}
	

	public static void loadUrl(String URL) {
		
		driver.get(URL);
		
		
	}
	
      	 
	public By locatorFinderbyID(String Data) {
		   
		   
		   
		   return By.id(Data);
	   }
	     
	 
	 
	   
	  public  By locatorFinderbyXpath(String Data) {
		   
		   
		   
		   return By.xpath(Data);
	   }
	  
	  
	  
	  public  WebElement elementFinder(By Locator) {
		   
		   
		   return driver.findElement(Locator);
	   }
	  
	  
	  
	  public void elementClick(WebElement element) {
		   	
		   	
		   	
	 		element.click();	
	     	
	     }
	  
	  
	  public static void type(WebElement element, String data) {
		  
			element.clear();
			element.sendKeys(data);
		}
	  
	  
	  
	   
	   public String getText(WebElement element) {
		   
		   String text = element.getText();
		   return text;
		   
		  
	   }
	   
	   
	   
	   
//	   @AfterSuite
//	   public static void tearDown() {
//	   extent.flush();
//	   driver.quit();
//	   
//	   
//	   }	
	   
	   
	   @AfterTest
	   public static void tearDown() {
	   extent.flush();
	   driver.quit();
	   
	   
	   }	
	
	   
	   
}	    
	    
	
	

