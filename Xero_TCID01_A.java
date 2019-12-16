/* Author : Vidhya S.G
 * Creation date : 12/14/2019
 * Test case : ID01_A
 * Description : Navigate to Xero App
 */


package XeroProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Xero_TCID01_A extends TestBaseXero{
  @Test
  public static void Xero_TCID01_A() throws IOException, InterruptedException {
	  
	//String[][] data1 = readXlData("C:\\Users\\Raj\\Documents\\Vidhya_Folder_Test\\TekArch_Enexus\\2ndProjectAuto\\TCID01A_TestData.xls","TestData");
	InitializeDriver();
	  logger = reports.startTest("Xero_TCID01_A starts");
		
	//driver.get(data1[0][1]);
	  driver.get("https://www.xero.com/us/");
	  WebElement login=driver.findElement(By.partialLinkText("Login"));
	  clickElement(login,"clicked login");
		WebElement email=driver.findElement(By.id("email"));
		enterText(email, "vidsg07@gmail.com","emailid");
		WebElement pword=driver.findElement(By.id("password"));
		enterText(pword,"Welcome@123","pword");
		//click on login button 
		WebElement login1=driver.findElement(By.id("submitButton"));
		clickElement(login1,"clickedlogin");
		Thread.sleep(3000);
		String pagename=driver.getTitle();
		System.out.println(pagename);
		logger.log(LogStatus.PASS, "Screenshot" + logger.addScreenCapture(takeScreenshot()));
		
		Thread.sleep(3000);
		driver.close();
		
  }
}
