package com.test.dcx.ie.pom.testcases.base;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.dcx.ie.pom.util.ExtentManager;
import com.test.dcx.ie.pom.util.CelcomConstants;
import com.test.dcx.ie.pom.util.Xls_Reader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//For Excel Output
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Satya Prakash
 *Every test case will extend this page
 *This call has all the functionality of initialization , reading configuration and other pre-requisite for start for scripts
 */
public class BaseTest {
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public Xls_Reader xls = new Xls_Reader(CelcomConstants.DATA_XLS_PATH);

	
	public AppiumDriver<MobileElement> driver;
	/**
	 * @author SATYA PRAKASH
	 * This function read browser type from excel and open respective browser type
	 */
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void init(String bType) throws MalformedURLException{
		test.log(LogStatus.INFO, "Opening browser - "+ bType);
		if(!CelcomConstants.GRID_RUN){
			// local machine
			if(bType.equals("Mozilla")){
				System.setProperty("webdriver.gecko.driver", CelcomConstants.FIREFOX_DRIVER_EXE);
				//driver= new FirefoxDriver();
				driver.manage().window().maximize();//
			}
			else if(bType.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", CelcomConstants.CHROME_DRIVER_EXE);
				//driver= new ChromeDriver();
				driver.manage().window().maximize();
			}
				else if(bType.equals("IE")){
				System.setProperty("webdriver.ie.driver", CelcomConstants.IE_DRIVER_EXE);
				//driver= new InternetExplorerDriver();
				driver.manage().window().maximize();
			}
			else if(bType.equals("Opera")){
				System.setProperty("webdriver.chrome.driver", "D:\\MySoftware\\Jars\\operadriver_win64\\operadriver_win64\\operadriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setBinary("C:\\Program Files\\Opera\\47.0.2631.55\\opera.exe");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				new ChromeDriver(capabilities);
		       
		        
			}
			else if(bType.equals("Android_App")){
				System.out.println("APP is "+bType);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("platformName","android");
				capabilities.setCapability("deviceName","ENU7N15C15000758");
				capabilities.setCapability("version","8.1.0");
				capabilities.setCapability("appPackage","com.celcom.mycelcom");
				capabilities.setCapability("appActivity","com.celcom.mycelcom.MainActivity");
				//capabilities.setCapability("noReset",("noReset"));

				driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			}
		}else{
			
			DesiredCapabilities cap=null;
			if(bType.equals("Mozilla")){
				System.setProperty("webdriver.gecko.driver", CelcomConstants.FIREFOX_DRIVER_EXE);
				
				
				cap = DesiredCapabilities.firefox();
				cap.setCapability("marionette", true);
				cap.setBrowserName("firefox"); 
				cap.setJavascriptEnabled(true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				try {
					//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
					driver.manage().window().maximize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(bType.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", CelcomConstants.CHROME_DRIVER_EXE);
				 cap = DesiredCapabilities.chrome();
				 cap.setBrowserName("chrome");
				 cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				 try {
						//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
						driver.manage().window().maximize();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			else if(bType.equals("IE")){
				System.setProperty("webdriver.ie.driver", CelcomConstants.IE_DRIVER_EXE);
				 cap = DesiredCapabilities.internetExplorer();
				 cap.setBrowserName("chrome");
				 cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				 try {
						///driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
						driver.manage().window().maximize();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test.log(LogStatus.INFO, "Opened browser successfully - "+ bType);

	}
	
	/**
	 * @author SATYA PRAKASH
	 * This function is used to terminate execution and report failure when test case fails
	 * Users needs to pass error message wherever it is called
	 * It will be also captured in generated HTML report
	 */
	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	/**
	 * @author SATYA PRAKASH
	 * This function is used to Capture screenshot upon pass/Fail
	 * Users needs to call this wherever needed
	 * It has no arguments and it generates screenshot as per date and time stamp
	 * Screenshot location is mentioned in Constant File (i.e. PLIConstants.java file)
	 */
	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=CelcomConstants.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
	
	/**
	 * @author SATYA PRAKASH
	 * This boolean function is used to verify element on the page
	 * Users needs to call this wherever needed and pass locators as parameter
	 *Parameter can be xpath , CSS , ID etc.
	 * It will return true or false based upon element found on the page
	 */
	public boolean isElementPresent(String locator) throws InterruptedException{
		//test.log(LogStatus.INFO, "Trying to find element -> "+ locator);
		
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0){
			//test.log(LogStatus.INFO, "Element not found");
			//takeScreenShot();
			return false;
			
		}
		else{
			//test.log(LogStatus.INFO, "Element found");
			//takeScreenShot();			
			return true;
		}
		
	}
	/**
	 * @author SATYA PRAKASH
	 * This function is used to verify Login functionality
	 * Users needs to call this wherever needed
	 *Below parameters is required wherever it is called
	 */
	public void validateLogin(String userName, String passWord , String verifyText, String browserType , String locator) throws InterruptedException{
		
		//driver.get(CelcomConstants.UAT2_URL);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CelcomConstants.UAT2_USERNAME1)));
		
		//driver.findElement(By.xpath(FBConstants.LOGIN_USERNAME)).sendKeys(userName);
//		setText(driver.findElement(By.xpath(PLIConstants.UAT2_USERNAME1)), userName, browserType);
//		//driver.findElement(By.xpath(FBConstants.LOGIN_PASSWORD)).sendKeys(passWord);
//		setText(driver.findElement(By.xpath(PLIConstants.UAT2_PASSWORD1)), passWord, browserType);
		//driver.findElement(By.xpath(PLIConstants.LOGIN_HOMEPAGE_BUTTON)).click();
		Thread.sleep(7000);
		////locator= PLIConstants.LOGIN_SUBMIT_BUTTON;
		String myText = driver.findElement(By.xpath(locator)).getText();
		//System.out.println("MyText is "+myText);
		if(myText.equalsIgnoreCase(verifyText)){
		test.log(LogStatus.PASS, "Logged in successfully");
		takeScreenShot();
		
		}
		
	}
	/**
	 * @author SATYA PRAKASH
	 * This function is used to Capture and store result in excel
	 */
	public static void captureResult(Xls_Reader xls,String testCaseName, String data , int colNumber){

		String sheetName=CelcomConstants.TESTDATA_SHEET;
		// reads data for only testCaseName
		
		int testStartRowNum=1;
		//System.out.println(xls.getCellData(sheetName, 0, testStartRowNum)); 
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		// calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		System.out.println("Total rows are  - "+rows );
		
		//calculate total cols
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		System.out.println("Total cols are  - "+cols );
		
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			
			String Flag = xls.getCellData(sheetName, 0, rNum);
			if(Flag.equalsIgnoreCase("Y")){
			
			//	System.out.println("CNum is "+cNum);
				//System.out.println("RowNum is "+rNum);
				//System.out.println("Key Value is -----"+value);
				xls.setCellData1(sheetName, colNumber, rNum, data);
				// 0,0 0,1 0,2
				//1,0 1,1
			}
			
		}
		
	
		
		
	}
	/**
	 * @author SATYA PRAKASH
	 * This function is used to Capture dynamic result and store result in excel
	 * User needs to enter test case name where it is called along with data and col name
	 */
	public static void captureDynamicResult(Xls_Reader xls,String testCaseName, String data , String colName){

		String sheetName=CelcomConstants.TESTDATA_SHEET;
		// reads data for only testCaseName
		
		int testStartRowNum=1;
		//System.out.println(xls.getCellData(sheetName, 0, testStartRowNum)); 
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		//System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		// calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		//System.out.println("Total rows are  - "+rows );
		
		//calculate total cols
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals(colName)){
			cols++;
		}
		System.out.println("The column number for   - "+colName+" is "+cols );
		//System.out.println("Total cols are  - "+cols );
		
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			//String myStatus = xls.getCellData(sheetName, colName, rNum);
			String myStatus = xls.getCellData(sheetName, cols, rNum);
			System.out.println("Status is "+myStatus);
			//System.out.println("sheetName "+sheetName);
			System.out.println("colName and number are "+colName+"  --- "+cols);
			System.out.println("rNum "+rNum);
			String Flag = xls.getCellData(sheetName, 0, rNum);
			//System.out.println("Flag is "+Flag);//Unsuccessful
			
			if(colName.equalsIgnoreCase("Comments")){
				System.out.println("Column name is "+colName);
				int tempColNum= findColumnNumberResult(xls, testCaseName, "Status");
				System.out.println("The column number for status is -- "+tempColNum);
				String myText = xls.getCellData(sheetName, tempColNum, rNum);
				System.out.println("Previous Column value is "+myText);
				if(Flag.equalsIgnoreCase("Y")){
				if(myStatus.equalsIgnoreCase("")){
					if(myText.equalsIgnoreCase("Unsuccessful")){
												
						System.out.println("**** Inside if Comments Column***** ");
					System.out.println("sheetName is "+sheetName);
						System.out.println("cols number is "+cols);
						System.out.println("rNum  is -----"+rNum);
						System.out.println("data  is -----"+data);
						System.out.println();
						//System.out.println("**** Inside if ***** "+sheetName+" "+cols+" "+rNum+" "+data);
						xls.setCellData1(sheetName, cols, rNum, data);
						// 0,0 0,1 0,2
						
						
						break;
					}
				}}
			}else if(!colName.equalsIgnoreCase("Comments") && !colName.equalsIgnoreCase("Status")){
				System.out.println("Column name is "+colName);
				int tempColNum= findColumnNumberResult(xls, testCaseName, "Status");
				System.out.println("The column number for status is -- "+tempColNum);
				String myNewText = xls.getCellData(sheetName, tempColNum, rNum);
				System.out.println(" Inside if else -- and value is - "+myNewText);
				if(Flag.equalsIgnoreCase("Y") && myNewText.equalsIgnoreCase("")){
					
					//Unsuccessful
					//Comments
					//Status
				if(myStatus.equalsIgnoreCase("")){
										
					System.out.println("**** Inside if ***** ");
				//System.out.println("sheetName is "+sheetName);
					System.out.println("cols number is "+cols);
					System.out.println("rNum  is -----"+rNum);
					System.out.println("data  is -----"+data);
					//System.out.println("**** Inside if ***** "+sheetName+" "+cols+" "+rNum+" "+data);
					xls.setCellData1(sheetName, cols, rNum, data);
					// 0,0 0,1 0,2
					
					
					break;
				}
				
				}
			}else if(colName.equalsIgnoreCase("Status")){
				
				if(Flag.equalsIgnoreCase("Y")){
					
					//Unsuccessful
					//Comments
					//Status
				if(myStatus.equalsIgnoreCase("")){
										
					System.out.println("**** Inside if ***** ");
				//System.out.println("sheetName is "+sheetName);
					System.out.println("cols number is "+cols);
					System.out.println("rNum  is -----"+rNum);
					System.out.println("data  is -----"+data);
					//System.out.println("**** Inside if ***** "+sheetName+" "+cols+" "+rNum+" "+data);
					xls.setCellData1(sheetName, cols, rNum, data);
					// 0,0 0,1 0,2
					
					
					break;
				}
				
				}
			}
			
			}
			
		
		
	
		
		
	}
	/**
	 * @author SATYA PRAKASH
	 * This function internal and not used directly in any test case
	 * It is used to find column number of given column name
	 * User needs to enter test case name and col name
	 */
	public static int findColumnNumberResult(Xls_Reader xls,String testCaseName,String colName){

		String sheetName=CelcomConstants.TESTDATA_SHEET;
		// reads data for only testCaseName
		
		int testStartRowNum=1;
		//System.out.println(xls.getCellData(sheetName, 0, testStartRowNum)); 
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		//System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		// calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		//System.out.println("Total rows are  - "+rows );
		
		//calculate total cols
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals(colName)){
			cols++;
		}
		System.out.println("The column Number for the column - "+colName+" is - "+cols);
		return cols;
	}
	/**
	 * @author SATYA PRAKASH
	 * This function is used  to Verify text on web page and web element
	 * It accepts locators and expected text to be verified
	 * 
	 */
	public boolean verifyText(String locator,String expText) throws InterruptedException{
		test.log(LogStatus.INFO, "Verifying the text " +"\""+ expText+"\""+" on the page.");
		
		WebElement myConfirmMsg = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myConfirmMsg);
		String myText = driver.findElement(By.xpath(locator)).getText();
		//System.out.println("MyText is "+myText);
		if(myText.equalsIgnoreCase(expText)){
		test.log(LogStatus.PASS, "\""+expText+"\""+" is displayed on the page.");
		takeScreenShot();
		
		return true;
		}else{
			return false;
		}
		
	}
	/**
	 * @author SATYA PRAKASH
	 * This function is used  to Set text on text field
	 * It accepts webElement , text to be entered and browser type
	 * 
	 */
public void setText(WebElement eElement,String text, String browserType) throws InterruptedException{
		
		if(browserType.equalsIgnoreCase("Mozilla")){
			eElement.click();
			eElement.sendKeys(text);
		}else if(browserType.equalsIgnoreCase("Chrome")){
			Actions builder = new Actions(driver);
			builder.moveToElement(eElement).click().sendKeys(text).build().perform();
		}else if(browserType.equalsIgnoreCase("MobileBrowser_Chrome")){
			Actions builder = new Actions(driver);
			builder.moveToElement(eElement).click().sendKeys(text).build().perform();
		}
		
	}
/**
 * @author SATYA PRAKASH
 * This function is not generic and related to PLI only
 * It return the balance amount of the user
 * It accepts Web element as parameter
 * 
 */
public float getBalanceAmount(WebElement eElement) throws InterruptedException{
	test.log(LogStatus.INFO, "Going to Add Fund page");
	float totalBalanceAmount;
	String Total = eElement.getText();
	int strlength = Total.length();
	Total = Total.substring(1, strlength-1);
	//System.out.println("Sub String : "+Total);
	totalBalanceAmount = Float.parseFloat(Total);
	System.out.println("Initial Amount :  �"+totalBalanceAmount);
	
	return  totalBalanceAmount;
	
}
public static Object[] storeValue(String frequency) {
    Object[] objArray;
    float number1 =  Float.parseFloat(frequency);
    int number = (int)number1;
    int mynumber = number * 6;
objArray = new Object[mynumber];
// NUMBER1_ROW1
String numberValue = "NUMBER";
String rowValue = "_ROW";
for(int arrSize=0;arrSize<objArray.length;arrSize++){
       
System.out.println("Array size is "+arrSize);
for(int rowNum=1;rowNum<=number;rowNum++){
       System.out.println("Array size is "+arrSize+" and row number is "+rowNum);
       for(int numVal =0 ;numVal<6;numVal++){
             System.out.println("Array size is "+arrSize+" and row number is "+rowNum+" and num value is "+(numVal+1));
                    objArray[arrSize] = numberValue+(numVal+1)+rowValue+rowNum;//12345
                    arrSize++;
       }
      
}
}
return objArray;
 
}
public static Object[] storeValueEuro(String frequency) {
    Object[] objArray;
    float number1 =  Float.parseFloat(frequency);
    int number = (int)number1;
    int mynumber = number * 7;
objArray = new Object[mynumber];
// NUMBER1_ROW1
String numberValue = "NUMBER";
String rowValue = "_ROW";
for(int arrSize=0;arrSize<objArray.length;arrSize++){
       
System.out.println("Array size is "+arrSize);
for(int rowNum=1;rowNum<=number;rowNum++){
       System.out.println("Array size is "+arrSize+" and row number is "+rowNum);
       for(int numVal =0 ;numVal<7;numVal++){
             System.out.println("Array size is "+arrSize+" and row number is "+rowNum+" and num value is "+(numVal+1));
                    objArray[arrSize] = numberValue+(numVal+1)+rowValue+rowNum;//12345
                    arrSize++;
       }
      
}
}
return objArray;
}
public static Object[] storeValueCommonEuro(String frequency) {
    Object[] objArray;
    float number1 =  Float.parseFloat(frequency);
    int number = (int)number1;
    int mynumber = number * 7;
objArray = new Object[mynumber];
// NUMBER1_ROW1
String numberValue = "EURO_NUMBER";
String rowValue = "_ROW";
for(int arrSize=0;arrSize<objArray.length;arrSize++){
       
System.out.println("Array size is "+arrSize);
for(int rowNum=1;rowNum<=number;rowNum++){
       System.out.println("Array size is "+arrSize+" and row number is "+rowNum);
       for(int numVal =0 ;numVal<7;numVal++){
             System.out.println("Array size is "+arrSize+" and row number is "+rowNum+" and num value is "+(numVal+1));
                    objArray[arrSize] = numberValue+(numVal+1)+rowValue+rowNum;//12345
                    arrSize++;
       }
      
}
}
return objArray;
}
public static Object[] storeValueCommonLotto(String frequency) {
    Object[] objArray;
    float number1 =  Float.parseFloat(frequency);
    int number = (int)number1;
    int mynumber = number * 6;
objArray = new Object[mynumber];
// NUMBER1_ROW1
String numberValue = "LOTTO_NUMBER";
String rowValue = "_ROW";
for(int arrSize=0;arrSize<objArray.length;arrSize++){
       
System.out.println("Array size is "+arrSize);
for(int rowNum=1;rowNum<=number;rowNum++){
       System.out.println("Array size is "+arrSize+" and row number is "+rowNum);
       for(int numVal =0 ;numVal<6;numVal++){
             System.out.println("Array size is "+arrSize+" and row number is "+rowNum+" and num value is "+(numVal+1));
                    objArray[arrSize] = numberValue+(numVal+1)+rowValue+rowNum;//12345
                    arrSize++;
       }
      
}
}
return objArray;
 
}
public static Object[] storeValueCommonDaily(String frequency) {
    Object[] objArray;
    float number1 =  Float.parseFloat(frequency);
    int number = (int)number1;
    int mynumber = number * 6;
objArray = new Object[mynumber];
// NUMBER1_ROW1
String numberValue = "DAILY_NUMBER";
String rowValue = "_ROW";
for(int arrSize=0;arrSize<objArray.length;arrSize++){
       
System.out.println("Array size is "+arrSize);
for(int rowNum=1;rowNum<=number;rowNum++){
       System.out.println("Array size is "+arrSize+" and row number is "+rowNum);
       for(int numVal =0 ;numVal<6;numVal++){
             System.out.println("Array size is "+arrSize+" and row number is "+rowNum+" and num value is "+(numVal+1));
                    objArray[arrSize] = numberValue+(numVal+1)+rowValue+rowNum;//12345
                    arrSize++;
       }
      
}
}
return objArray;
 
}






/**
 * This program illustrates how to update an existing Microsoft Excel document.
 * Append new rows to an existing sheet.
 *
 * @author www.codejava.net
 *
 */


//public static void OutputData(String Username,String LinesPlayed,String AddPlus,String Draws,String TicketNumber,String TicketType,String TicketCost) 

	public static void OutputData(String TestcaseName,String Username,String UserID,String LinesPlayed,String AddPlus,String Draws,String TicketNumber,String RaffleFrom,String RaffleTo,String TicketType,String TicketCost,String beforeAddingFundAmount,String fundToTransfer,String AfterAddingFundAmount) 
	{
		String excelFilePath = CelcomConstants.EXCEL_REPORTS_PATH;
		Date d=new Date();
		String date= d.toString().replace(":", "/").replace(" ", "/");

		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);
			CellStyle cellStyle = workbook.createCellStyle();
			//CreationHelper createHelper = workbook.getCreationHelper();
			CreationHelper createHelper = workbook.getCreationHelper();
			// Set the date format of date
			cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
					"dd/MM/yyyy hh:mm:ss"));

			Object[][] bookData = {
					//{Username, LinesPlayed,AddPlus,Draws,TicketNumber,TicketType,TicketCost,date},
					{TestcaseName,Username,UserID,LinesPlayed,AddPlus,Draws,TicketNumber,RaffleFrom,RaffleTo,TicketType,TicketCost,beforeAddingFundAmount,fundToTransfer,AfterAddingFundAmount,date},

			};

			int rowCount = sheet.getLastRowNum();

			for (Object[] aBook : bookData) {
				Row row = sheet.createRow(++rowCount);

				int columnCount = 0;

				Cell cell = row.createCell(columnCount);
				cell.setCellValue(rowCount);

				for (Object field : aBook) {
					cell = row.createCell(++columnCount);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}

			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(CelcomConstants.EXCEL_REPORTS_PATH);
			workbook.write(outputStream);
			outputStream.close();
			outputStream.close();

		} catch (IOException | EncryptedDocumentException
				| InvalidFormatException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * @author SANDEEP KINI
	 *Automation method for launching Appium server
	 *
	 *//*
		public void startServer(String server) throws InterruptedException {
			Runtime runtime = Runtime.getRuntime();
			try {
				String command1 = "cmd.exe /c start cmd.exe /k appium";
				//String command2 = " --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"";
			    String finalcommand = command1;
				runtime.exec(finalcommand);
				//runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
				Thread.sleep(20000);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*//**
		 * @author SANDEEP KINI
		 *Automation method for stopping Appium Server
		 *
		 *//*
		public void stopServer() {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("taskkill /F /IM node.exe");
				runtime.exec("taskkill /F /IM cmd.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
 }
 
