package XeroProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Xero_TCID01_D extends TestBaseXero {
  @Test
  public static void Xero_TCID01_D() throws IOException, InterruptedException {
	  
	  logger = reports.startTest("Xero_TCID01_D starts");
		InitializeDriver();
		driver.get("https://www.xero.com/us/");
		//driver.get(data2[0][1]);
		
		// click on login 
		WebElement login = driver.findElement(By.partialLinkText("Login"));
		clickElement(login, "Clickedlogin");
		
		Thread.sleep(2000);
		
		//click on "forgot password"
		WebElement linkforg=driver.findElement(By.xpath("//a[@class='forgot-password-advert']"));
		clickElement(linkforg, "forgot password clicked");
		
		WebElement uname=driver.findElement(By.id("UserName"));
		enterText(uname,"vidsg07@gmail.com","enterd emailid");
		
		//click  submit button
		
		WebElement submit=driver.findElement(By.id("submitButton"));
		clickElement(submit,"sendlink clicked");
		
		
		String expected ="A link to reset your password has been sent to:\n" + 
				"vidsg07@gmail.com";
				
		String actuals = driver.findElement(By.xpath("//p[contains(text(),'A link to reset your password has been sent to:')]")).getText();
		Assert.assertEquals(actuals, expected);
		logger.log(LogStatus.PASS, "Screenshot" + logger.addScreenCapture(takeScreenshot()));
		
		Thread.sleep(2000);
		logger.log(LogStatus.INFO,  "Xero_TCID01_D ends");
		reports.endTest(logger);
	driver.close();
  }
}
