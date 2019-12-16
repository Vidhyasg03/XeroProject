/* Author : Vidhya S.G
 * Creation date : 12/14/2019
 * Test case : ID02_D
 * Description : Offer Details" link
 */


package XeroProject;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Xero_TCID02_D extends TestBaseXero{
  @Test
  public static void Xero_TCID02_D() throws InterruptedException, IOException {
	  
	  
	  logger = reports.startTest("Xero_TCID02_D starts");
		InitializeDriver();
		driver.get("https://www.xero.com/us/");
		//driver.get(data2[0][1]);
		
		
		//click on free trial button 
		WebElement freetrial= driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickElement(freetrial,"clicked on freetrial button");
		String pagename=driver.getTitle();
		System.out.println(pagename);
		Thread.sleep(3000);
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		//click on offer details 
		WebElement offer=driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		clickElement(offer,"clicked offer link");
		
		Thread.sleep(3000);
		
		logger.log(LogStatus.PASS, "ScreenshotTCID02D" + logger.addScreenCapture(takeScreenshot()));
		
		ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs3.get(1));
	    driver.close();
	    driver.switchTo().window(tabs3.get(0));
	    
	    Thread.sleep(2000);
		logger.log(LogStatus.INFO,  "Xero_TCID02_D ends");
		reports.endTest(logger);
	driver.close();
		
		
		
  }
}
