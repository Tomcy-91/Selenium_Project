package testscript;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import utilities.ScreenShotUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
 
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  	driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod(ITestResult itResult) throws IOException {
	  
	  if (itResult.getStatus() == ITestResult.FAILURE) {
		  ScreenShotUtility sc = new ScreenShotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		if (driver != null) {
			driver.quit();
		}
	  
	  //driver.close();
  }

}
