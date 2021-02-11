package com.test.dcx.ie.pom.testcases;

import java.io.IOException;
import java.util.Hashtable;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.test.dcx.ie.pom.base.BasePage;
import com.test.dcx.ie.pom.pages.CelcomeLogInAppPage;
import com.test.dcx.ie.pom.pages.common.TopMenu;
import com.test.dcx.ie.pom.testcases.base.BaseTest;
import com.test.dcx.ie.pom.util.DataUtil;
import com.test.dcx.ie.pom.util.CelcomConstants;



@SuppressWarnings("unused")

public class CelcomeApp_LoginTest extends BaseTest{
	String testCaseName="CelcomeApp_LoginTest";

	@Test(dataProvider="getData")
	public void CelcomeApp_LoginTest(Hashtable<String,String> data) throws InterruptedException, IOException{
		test = extent.startTest(testCaseName);
		
		test.log(LogStatus.INFO, "Starting Appium Server");
	
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(CelcomConstants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		test.log(LogStatus.INFO, "Starting test PLIAppLogIn_BrowserTest");
		init(data.get("Browser"));
	
		CelcomeLogInAppPage loginApp = new CelcomeLogInAppPage(driver,test);
		PageFactory.initElements(driver, loginApp);
		loginApp.doLogin(data.get("Browser"),data.get("Mobileno"));
		loginApp.logout();
	
	}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
			//stopServer();
				test.log(LogStatus.PASS, "Stopping Appium server");
				extent.endTest(test);
				extent.flush();
		}
		if(driver!=null)
			driver.quit();
		//driver.close();
		//stopServer();
		test.log(LogStatus.PASS, "Stopping Appium Server");
	}

	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}


}
