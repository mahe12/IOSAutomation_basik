import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauseLabs {
	
//		  public static final String USERNAME = "ahameed";
//		  public static final String ACCESS_KEY = "ccffbc8b-ef98-4c2f-b945-711d8daf63de";
	
	RemoteWebDriver driver;
	 public static final String USERNAME = "vvasu";
     public static final String ACCESS_KEY = "45227988-98e3-4b63-92ed-28bb91835827";
     public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		 
     @Test
		  public void browser() throws Exception {
		

		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("name", "Facebook_safari_Screenshot");
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("browserName", "chrome");
		    caps.setCapability("version", "53.0");
		    caps.setCapability("build", "Facebook_SauceLabs");
		 
		     driver = new RemoteWebDriver(new URL(URL), caps);
		
		    driver.get("https://www.facebook.com");
		    System.out.println("title of page is: " + driver.getTitle());
		 
		    
		  }
     
     
     @AfterMethod
	  public void teardown(ITestResult result) throws Exception {
	
    	 ((JavascriptExecutor) driver). executeScript("sauce:job-result=" + (result.isSuccess() ? "passed":"failed"));

    	 driver.quit();
	  }
	}
