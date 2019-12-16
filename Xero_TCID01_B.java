/* Author : Vidhya S.G
 * Creation date : 12/14/2019
 * Test case : ID01_B
 * Description : Incorrect Password
 */

package XeroProject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Xero_TCID01_B extends TestBaseXero{
  @Test
  public static void Xero_TCID01_B () throws IOException, InterruptedException {

	//	String[][] data2 = readXlData("C:\\Users\\Raj\\Documents\\Vidhya_Folder_Test\\TekArch_Enexus\\2ndProjectAuto\\TCID01B_TestData.xls","TestData");
		  
	  logger = reports.startTest("Xero_TCID01_B starts");
		InitializeDriver();
		driver.get("https://login.xero.com/");
		//driver.get(data2[0][1]);
		
		WebElement email=driver.findElement(By.id("email"));
		enterText(email,"vidsg07@gmail.com","emailid");
		
		//invalid password 
		WebElement pword=driver.findElement(By.id("password"));
		enterText(pword,"Welcome123","pword");
		
		WebElement login=driver.findElement(By.id("submitButton"));
		clickElement(login,"clickedlogin");
		
		String expected = "Your email or password is incorrect";
		String actual = driver.findElement(By.xpath("//*[@id=\"contentTop\"]/div[2]/div[1]/div[2]")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
logger.log(LogStatus.PASS, "Screenshot" + logger.addScreenCapture(takeScreenshot()));
		
		Thread.sleep(2000);
		logger.log(LogStatus.INFO,  "Xero_TCID01_B ends");
		reports.endTest(logger);
	driver.close();
		
  }
}
