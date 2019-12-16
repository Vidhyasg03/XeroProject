/* Author : Vidhya S.G
 * Creation date : 12/14/2019
 * Test case : ID02_B
 * Description : Offer Details" link
 */

package XeroProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Xero_TCID02_B extends TestBaseXero{
  @Test
  public static void Xero_TCID02_B() throws IOException, InterruptedException {
	  
	  logger = reports.startTest("Xero_TCID02_B starts");
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
		
		WebElement submit=driver.findElement(By.className("g-recaptcha-submit"));
		clickElement(submit,"clicked on getstarted button");
		Thread.sleep(3000);
		
		String fnamerror= driver.findElement(By.id("signup-form-error-message-1")).getText();
		System.out.println(fnamerror);
		
		String lnameerror=driver.findElement(By.id("signup-form-error-message-2")).getText();
		System.out.println(lnameerror);
	  
	  String emailerror=driver.findElement(By.id("signup-form-error-message-3")).getText();
	  System.out.println(emailerror);
	  
	  String phoneerror=driver.findElement(By.id("signup-form-error-message-4")).getText();
	  System.out.println(phoneerror);
	  
	  
	  WebElement fn=driver.findElement(By.name("FirstName"));
		enterText(fn,"vidhya","firstname");
		
		//click on lastname
		WebElement ln=driver.findElement(By.name("LastName"));
		enterText(ln,"Sg","lastname");
		

		WebElement phone=driver.findElement(By.name("PhoneNumber"));
		enterText(phone,"123456780","phone");
		
		WebElement emailid=driver.findElement(By.name("EmailAddress"));
		  enterText(emailid,"vidsg07","enteredemailid");
		  
		  String emailerror2=driver.findElement(By.id("signup-form-error-message-3")).getText();
		  System.out.println(emailerror2);
		  
	  
	  WebElement submit1=driver.findElement(By.className("g-recaptcha-submit"));
		clickElement(submit1,"clicked on getstarted button");
		Thread.sleep(3000);
		
	  
	  
		// Thread.sleep(2000);
			logger.log(LogStatus.INFO,  "Xero_TCID02_B ends");
			
			reports.endTest(logger);
		driver.close();
				  
	  
  }
}
