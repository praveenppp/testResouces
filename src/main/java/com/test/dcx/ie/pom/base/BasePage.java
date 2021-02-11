package com.test.dcx.ie.pom.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.dcx.ie.pom.pages.common.TopMenu;
import com.test.dcx.ie.pom.util.CelcomConstants;
import com.test.dcx.ie.pom.util.Xls_Reader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {

	public AppiumDriver<MobileElement> driver;
	public TopMenu menu;
	public ExtentTest test;

	
	public BasePage(){}
	
	public BasePage(AppiumDriver<MobileElement> driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		menu = new TopMenu(driver, test);
		PageFactory.initElements(driver, menu);
	}
	
	public String verifyTitle(String expTitle){
		test.log(LogStatus.INFO, "Verifying the title " + expTitle);
		// webdriver code
		return "";
	}
	/**
	 * @author SATYA PRAKASH
	 * This boolean function is Text on web page
	 * It return true on success else return false
	 * It accepts locator and text to be verified as parameter
	 * 
	 */
	public boolean verifyText(String locator,String expText) throws InterruptedException{
		test.log(LogStatus.INFO, "Verifying the text " + expText);
		
		WebElement myConfirmMsg = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myConfirmMsg);
		String myText = driver.findElement(By.xpath(locator)).getText();
		//System.out.println("MyText is "+myText);
		if(myText.equalsIgnoreCase(expText)){
		test.log(LogStatus.PASS, expText+" is displayed");
		takeScreenShot();
		
		return true;
		}else{
			return false;
		}
		
	}
	/**
	 * @author SATYA PRAKASH
	 * This boolean function verifies that given web element is present in page or not
	 * It return true on success else return false
	 * It accepts locator as parameter
	 * 
	 */
	public boolean isElementPresent(String locator) throws InterruptedException{
		//test.log(LogStatus.INFO, "Trying to find element -> "+ locator);
		int s ;
		if(locator.endsWith("_ID")){
			s = driver.findElements(By.id(locator)).size();	
			return true;
		}
		
		 s = driver.findElements(By.xpath(locator)).size();
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
	 * This boolean function all the menu web elements common to every page
	 * It return menu object
	 * 
	 */
	public TopMenu getMenu(){
		return menu;
	}
	/**
	 * @author SATYA PRAKASH
	 * This boolean function takes screenshot
	 * It capture screenshot with date/time stamp and store it i location
	 * Captured screenshot is also linked to html report automatically
	 * For location of captured screenshot file , please refer PLIConstant file
	 * 
	 */
	public void takeScreenShot() throws InterruptedException{
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
		Thread.sleep(2000);
	}
	/**
	 * @author SATYA PRAKASH
	 * This report failure and terminates the scripts upon failure
	 * It capture screenshot along with error message
	 * It is also reflected in generated to html report
	 * It accepts error message as inputs
	 * 
	 */
	public void reportFailure(String failureMessage) throws InterruptedException{
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	
	/*
	public void waitForPageToLoad() {
		wait(1);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state = (String)js.executeScript("return document.readyState");
		
		while(!state.equals("complete")){
			wait(2);
			state = (String)js.executeScript("return document.readyState");
		}
	}
	
	public void wait(int timeToWaitInSec){
		try {
			Thread.sleep(timeToWaitInSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	/**
	 * @author SATYA PRAKASH
	 * This Capture dynamic result and store it in excel
	 * It accepts test case name , data and col name as input parameter
	 * 
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
		
		@SuppressWarnings("unused")
		int cNum;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			//String myStatus = xls.getCellData(sheetName, colName, rNum);
			String myStatus = xls.getCellData(sheetName, cols, rNum);
			//System.out.println("Status is "+myStatus);
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
	 * This function is used for entering text in text filed
	 * It accepts test webelement , text to be enter and browser type as input parameter
	 * 
	 */
	public void setText(WebElement eElement,String text, String browserType) throws InterruptedException{
		
		if(browserType.equalsIgnoreCase("Mozilla")){
			eElement.click();
			eElement.sendKeys(text);
		}else if(browserType.equalsIgnoreCase("Chrome")){
			Actions builder  = new Actions(driver);
			builder.moveToElement(eElement).click().sendKeys(text).build().perform();
		}else if(browserType.equalsIgnoreCase("IE")){
			eElement.click();
			eElement.sendKeys(text);
		}else if(browserType.equalsIgnoreCase("Opera")){
			Actions builder = new Actions(driver);
			builder.moveToElement(eElement).click().sendKeys(text).build().perform();
		}
		
	}
	/**
	 * @author SATYA PRAKASH
	 * This is internal function used for finding column number of the given column name
	 * It accepts test case name and column name as input parameter
	 * 
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
	
}
