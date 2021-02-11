package com.test.dcx.ie.pom.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.dcx.ie.pom.pages.CelcomPlanDetailsPage;
import com.test.dcx.ie.pom.pages.CelcomeLogInAppPage;
import com.test.dcx.ie.pom.testcases.base.BaseTest;
import com.test.dcx.ie.pom.util.CelcomConstants;
import com.test.dcx.ie.pom.util.DataUtil;

@SuppressWarnings("unused")

public class CelcomPlanDetailsTest extends BaseTest{
	String testCaseName="CelcomDashboardTest";

	@Test(dataProvider="getData")
	public void CelcomDashboardTest(Hashtable<String,String> data) throws Exception{
		test = extent.startTest(testCaseName);
		
		test.log(LogStatus.INFO, "Starting Appium Server");
	
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(CelcomConstants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		test.log(LogStatus.INFO, "Starting test AppLogIn_BrowserTest");
		init(data.get("Browser"));
	
		CelcomPlanDetailsPage dashpage= new CelcomPlanDetailsPage(driver,test);
		PageFactory.initElements(driver, dashpage);
		dashpage.launch();
		dashpage.EnterMobileNo(data.get("Browser"),data.get("Mobileno"));
		dashpage.EnterOTP();
		dashpage.Login();
		dashpage.dashboard(data.get("Browser"),data.get("Mobileno"),data.get("Plandetails"));

	
	}
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}

}
