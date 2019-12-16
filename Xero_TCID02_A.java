/* Author : Vidhya S.G
 * Creation date : 12/14/2019
 * Test case : ID01_A
 * Description : Navigate to XERO userhome page should be displayed.
 */

package XeroProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Xero_TCID02_A  extends TestBaseXero{
  @Test
  public static void Xero_TCID02_A() throws IOException, InterruptedException {
	  
	  String[][] data = readXlData("C:\\Users\\Raj\\Documents\\Vidhya_Folder_Test\\TekArch_Enexus\\2ndProjectAuto\\TCID02A_TestData.xls","TestData");
		logger = reports.startTest("Xero_TCID02_A starts");
		InitializeDriver();
		driver.get(data[0][1]);
		
		//click on free trial button 
		WebElement freetrial= driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickElement(freetrial,"clicked on freetrial button");
		String pagename=driver.getTitle();
		System.out.println(pagename);
		Thread.sleep(3000);
		
		//click on firstname 
		WebElement fn=driver.findElement(By.name("FirstName"));
		enterText(fn,data[1][1],"firstname");
		
		//click on lastname
		WebElement ln=driver.findElement(By.name("LastName"));
		enterText(ln,data[2][1],"lastname");
		
		
		WebElement email=driver.findElement(By.name("EmailAddress"));
		enterText(email,data[3][1],"emailid");
		
		WebElement phone=driver.findElement(By.name("PhoneNumber"));
		enterText(phone,data[4][1],"phone");
		
		//code for selecting the country ddl
		WebElement countryddl=driver.findElement(By.name("LocationCode"));
		Select sc = new Select(countryddl);
		sc.selectByVisibleText("United States");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		//checkbox
		WebElement checkbox1=driver.findElement(By.id("recaptcha-anchor"));
		checkbox1.clear();
		System.out.println("im not a robot Clicked");
		
		WebElement termscheckbox=driver.findElement(By.name("TermsAccepted"));
		clickElement(termscheckbox,"agreedtoterms");
		
		//click on GetStarted button
		
		WebElement submit=driver.findElement(By.className("btn btn-primary"));
		clickElement(submit,"clicked on getstarted button");
		Thread.sleep(3000);
		
		logger.log(LogStatus.PASS, "Screenshot" + logger.addScreenCapture(takeScreenshot()));
		
		logger.log(LogStatus.INFO,  "Xero_TCID02A_ends");
		reports.endTest(logger);
	driver.close();

  }
}
