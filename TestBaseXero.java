package XeroProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBaseXero {
	protected static WebDriver driver;
	  static ExtentReports reports;
	  static ExtentTest logger;
	  static String reportFolder = "C:\\Users\\Raj\\Documents\\Vidhya_Folder_Test\\TekArch_Enexus\\2ndProjectAuto\\Report\\";
	  
	  public static void InitializeDriver(){
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
	  }

		   public static void InitializeReport(){
		        reports = new ExtentReports(reportFolder + new SimpleDateFormat("'XeroProjReport_'YYYYMMddHHmm'.html'").format(new Date()));
		        System.out.println("Reports var " + reports);
		    }
		   
		   public static String takeScreenshot() throws IOException {
		        TakesScreenshot srcShot = ((TakesScreenshot) driver);
		        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		        String imagePath = reportFolder + "ScreenShots\\" + new SimpleDateFormat("'Image_'YYYYMMddHHmm'.png'").format(new Date());
		        File destFile = new File(imagePath);
		       // FileHandler.copy(srcFile,destFile);
		        FileUtils.copyFile(srcFile,destFile);
		        return imagePath;
		    }

		   
		    public static void enterText(WebElement ele, String txtValue, String objectName) throws IOException{
		        if(ele.isDisplayed()){
		            ele.sendKeys(txtValue);
		            System.out.println(txtValue + "has been successfully Entered  into " + objectName);
		        }
		        else{
		        	 System.out.println(ele + " is not displayed in the web page.");
			            logger.log(LogStatus.ERROR,ele + " is not displayed in the web page." +
			                    logger.addScreenCapture(takeScreenshot()));
			        }
		        }
		    

		    public static void clickElement(WebElement ele, String ObjectName) throws IOException{
		        if(ele.isDisplayed())
		        {
		            ele.click();;
		            System.out.println(ObjectName + " has been successfully clicked");
		        }
		        else
		        {
		            System.out.println(ObjectName + " is not displayed in the web page.");
		            logger.log(LogStatus.ERROR,ObjectName + " is not displayed in the web page." +
		                    logger.addScreenCapture(takeScreenshot()));
		        }
		    }
		    
		    

		    @SuppressWarnings("deprecation")
			public static String[][] readXlData(String path, String sheetName) throws IOException {
		        FileInputStream fs=new FileInputStream(new File(path));
		        HSSFWorkbook wb=new HSSFWorkbook(fs);
		        HSSFSheet sheet=wb.getSheet(sheetName);
		        int rowCount=sheet.getLastRowNum()+1;
		        int colCount=sheet.getRow(0).getLastCellNum();
		        String[][] data=new String[rowCount][colCount];
		        for(int i=0;i<rowCount;i++){
		            for(int j=0;j<colCount;j++){
		                int cellType=sheet.getRow(i).getCell(j).getCellType();
		                if(cellType== HSSFCell.CELL_TYPE_NUMERIC){
		                    int val=(int)sheet.getRow(i).getCell(j).getNumericCellValue();
		                    data[i][j]=String.valueOf(val);
		                }
		                else
		                    data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		            }
		        }
		        return (data);
		    }

		    public static void writeXlData(String fileName, String sheetName, int row, int col, String value) throws IOException{
		        File file=new File(fileName);
		        FileInputStream fs=new FileInputStream(file);
		        HSSFWorkbook wb=new HSSFWorkbook(fs);
		        HSSFSheet sheet=wb.getSheet(sheetName);
		        sheet.createRow(row).createCell(col).setCellValue(value);
		        FileOutputStream fo=new FileOutputStream(file);
		        wb.write(fo);
		        fo.flush();
		        fo.close();
		    }


}
