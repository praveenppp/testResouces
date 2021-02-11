package com.test.dcx.ie.pom.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.dcx.ie.pom.base.BasePage;
import com.test.dcx.ie.pom.util.CelcomConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.offset.PointOption;

public class CelcomPlanDetailsPage extends BasePage{

	public WebDriverWait wait1; 


	@FindBy(how = How.XPATH , using =CelcomConstants.ENTER_MOBILE_NUMBER)
	public WebElement ENTER_MOBILE_NUMBER;
	@FindBy(how = How.XPATH , using =CelcomConstants.ENTER_MOBILE_NUMBERTEXT)
	public WebElement ENTER_MOBILE_NUMBERTEXT;
	@FindBy(how = How.XPATH , using =CelcomConstants.SEND_OTP_BUTTON)
	public WebElement SEND_OTP_BUTTON;
	@FindBy(how = How.XPATH , using =CelcomConstants.ALLOW_BUTTON)
	public WebElement ALLOW_BUTTON;
	@FindBy(how = How.XPATH , using =CelcomConstants.MOBILECONNECTNOW_BUTTON)
	public WebElement MOBILECONNECTNOW_BUTTON;
	@FindBy(how = How.XPATH , using =CelcomConstants.MOBILECONNECT_TEXT)
	public WebElement MOBILECONNECT_TEXT;
	@FindBy(how = How.XPATH , using =CelcomConstants.ENTEROTP_TEXT)
	public WebElement ENTEROTP_TEXT;
	@FindBy(how = How.XPATH , using =CelcomConstants.SEND_OTP)
	public WebElement SEND_OTP;
	@FindBy(how = How.XPATH , using =CelcomConstants.LOGIN_BUTTON)
	public WebElement LOGIN_BUTTON;
	@FindBy(how = How.XPATH , using =CelcomConstants.ACCEPT_TEXT)
	public WebElement ACCEPT_TEXT;
	@FindBy(how = How.XPATH , using =CelcomConstants.ACCEPT_BUTTON)
	public WebElement ACCEPT_BUTTON;
	@FindBy(how = How.XPATH , using =CelcomConstants.SLIDE_1)
	public WebElement SLIDE_1;

	@FindBy(how = How.XPATH , using =CelcomConstants.SLIDE_2)
	public WebElement SLIDE_2;

	@FindBy(how = How.XPATH , using =CelcomConstants.SLIDE_3)
	public WebElement SLIDE_3;

	@FindBy(how = How.XPATH , using =CelcomConstants.GUIDE_SLIDETEXT1)
	public WebElement GUIDE_SLIDETEXT1;
	@FindBy(how = How.XPATH , using =CelcomConstants.GUIDE_SLIDETEXT2)
	public WebElement GUIDE_SLIDETEXT2;
	@FindBy(how = How.XPATH , using =CelcomConstants.GUIDE_SLIDETEXT3)
	public WebElement GUIDE_SLIDETEXT3;
	@FindBy(how = How.XPATH , using =CelcomConstants.GUIDE_SLIDETEXT4)
	public WebElement GUIDE_SLIDETEXT4;
	@FindBy(how = How.XPATH , using =CelcomConstants.DONE_BUTTON)
	public WebElement DONE_BUTTON;
	@FindBy(how = How.XPATH , using =CelcomConstants.DASHBOARD_MOBILENUM)
	public WebElement DASHBOARD_MOBILENUM;
	@FindBy(how = How.XPATH , using =CelcomConstants.VIDEO_CALLS)
	public WebElement VIDEO_CALLS;
	@FindBy(how = How.XPATH , using =CelcomConstants.MMS)
	public WebElement MMS;
	@FindBy(how = How.XPATH , using =CelcomConstants.CALLS)
	public WebElement CALLS;
	@FindBy(how = How.XPATH , using =CelcomConstants.SMS)
	public WebElement SMS;
	@FindBy(how = How.XPATH , using =CelcomConstants.INTERNET)
	public WebElement INTERNET;
	@FindBy(how = How.XPATH , using =CelcomConstants.VIDEOCALLS_DETAILS)
	public WebElement VIDEOCALLS_DETAILS;
	@FindBy(how = How.XPATH , using =CelcomConstants.MMS_DETAILS)
	public WebElement MMS_DETAILS;
	@FindBy(how = How.XPATH , using =CelcomConstants.CALLS_DETAILS)
	public WebElement CALLS_DETAILS;
	@FindBy(how = How.XPATH , using =CelcomConstants.SMS_DETAILS)
	public WebElement SMS_DETAILS;
	@FindBy(how = How.XPATH , using =CelcomConstants.INTERNET_DETAILS)
	public WebElement INTERNET_DETAILS;
	//	@FindBy(how = How.XPATH , using =CelcomConstants.INTERNET)
	//	public WebElement INTERNET;
	//	



	public CelcomPlanDetailsPage(AppiumDriver<MobileElement> driver,ExtentTest test){
		super(driver,test);
	}

	public void launch() throws InterruptedException{


		takeScreenShot();

		wait1 = new WebDriverWait(driver, 10);

		ALLOW_BUTTON.click();
		ALLOW_BUTTON.click();
		Thread.sleep(1000);

	}
	public void EnterMobileNo(String Browser,String mobilenumber) throws InterruptedException {

		driver.runAppInBackground(Duration.ofSeconds(3));
		//driver.runAppInBackground(seconds);
		if (wait1.until(ExpectedConditions.visibilityOf(ENTER_MOBILE_NUMBERTEXT)) != null) {
			Assert.assertTrue(ENTER_MOBILE_NUMBERTEXT.isDisplayed());

		}
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(CelcomConstants.ENTER_MOBILE_NUMBER)));
		ENTER_MOBILE_NUMBER.sendKeys(mobilenumber);
		test.log(LogStatus.INFO, "Entering Mobile Number in as -"+mobilenumber);
		driver.hideKeyboard();
		Thread.sleep(1000);
		SEND_OTP_BUTTON.click();
		takeScreenShot();

		boolean mobileconnect=isElementPresent(CelcomConstants.MOBILECONNECTNOW_BUTTON); 
		if(mobileconnect) { 
			takeScreenShot();
			MOBILECONNECT_TEXT.click();
			System.out.println("Inside mobileconnect");
		}
	}
	public void EnterOTP() throws Exception {
		if (wait1.until(ExpectedConditions.visibilityOf(ENTEROTP_TEXT)) != null) {
			Assert.assertTrue(ENTEROTP_TEXT.isDisplayed());

		}
		SEND_OTP.click();
		Thread.sleep(1000);
		SEND_OTP.sendKeys("1303");
		driver.hideKeyboard();
		takeScreenShot();
	}
	public void Login() throws Exception {

		if(LOGIN_BUTTON==null) {
			wait1.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
			Assert.assertTrue(LOGIN_BUTTON.isDisplayed());
			System.out.println("Entered loop");

		}

		LOGIN_BUTTON.click();

		if(ACCEPT_TEXT==null) {
			wait1.until(ExpectedConditions.elementToBeClickable(ACCEPT_TEXT));
			Assert.assertTrue(ACCEPT_TEXT.isDisplayed());
			System.out.println("Entered loop");

		}

		ACCEPT_BUTTON.click();
		Thread.sleep(1000);
		LOGIN_BUTTON.click();


		if(wait1.until(ExpectedConditions.visibilityOf(GUIDE_SLIDETEXT1)) != null) {
			Assert.assertTrue(GUIDE_SLIDETEXT1.isDisplayed());
			Thread.sleep(1000);
			SLIDE_1.click();
		} else {
			Assert.assertFalse(false, "Slide1 is not displaying ");
		}
		Thread.sleep(1000);

		if(wait1.until(ExpectedConditions.visibilityOf(GUIDE_SLIDETEXT2)) != null) {
			Assert.assertTrue(GUIDE_SLIDETEXT2.isDisplayed());
			SLIDE_2.click();
		} else {
			Assert.assertFalse(false, "Slide2 is not displaying ");
		}


		if (wait1.until(ExpectedConditions.visibilityOf(GUIDE_SLIDETEXT3)) != null) {
			Assert.assertTrue(GUIDE_SLIDETEXT3.isDisplayed());
			SLIDE_3.click();
		}
		else {
			Assert.assertFalse(false, "Slide3 is not displaying ");
		}

		if (wait1.until(ExpectedConditions.visibilityOf(GUIDE_SLIDETEXT4)) != null) {
			Assert.assertTrue(GUIDE_SLIDETEXT4.isDisplayed());
			DONE_BUTTON.click();
		}
		else {
			Assert.assertFalse(false, "Slide3 is not displaying ");
		}

	}
	public  void dashboard(String Browser,String mobilenumber,String plandetails) throws InterruptedException
	{

		Thread.sleep(6000);
		System.out.println("tapping now");
		tapOnNumber();
		System.out.println("tapped");
		test.log(LogStatus.PASS, "Result link is clicked Successfully");
		takeScreenShot();
		
		
		String results = plandetails;

		switch(results) 
		{
		case "FIRST Gold Plus for Business" :

			test.log(LogStatus.PASS, "FIRST Gold Plus for Business");
			takeScreenShot();


			if (VIDEO_CALLS != null) {
				Assert.assertTrue(VIDEOCALLS_DETAILS.isDisplayed());
				System.out.println("verified video calls");
				String videocall= VIDEOCALLS_DETAILS.getText();
				test.log(LogStatus.PASS, "Video call plan details displayed as "+ videocall);
			} 
			if (MMS != null) {
				Assert.assertTrue(MMS_DETAILS.isDisplayed());
				System.out.println("verified MMS");
			}if (CALLS != null) {
				Assert.assertTrue(CALLS_DETAILS.isDisplayed());
				System.out.println("verified  calls");
			}
			if (SMS != null) {
				Assert.assertTrue(SMS_DETAILS.isDisplayed());
				System.out.println("verified SMS");
			}
			swipeUp();
			Thread.sleep(3000);
			if (INTERNET != null) {
				Assert.assertTrue(INTERNET_DETAILS.isDisplayed());
				System.out.println("verified Internet");
			}
			break;





		case "DAILY_MILLION_VIEWRESULT" :
			test.log(LogStatus.PASS, "FIRST Gold Plus for Business");
			takeScreenShot();


			if (VIDEO_CALLS != null) {
				Assert.assertTrue(VIDEOCALLS_DETAILS.isDisplayed());
				System.out.println("verified video calls");
				String videocall= VIDEOCALLS_DETAILS.getText();
				test.log(LogStatus.PASS, "Video call plan details displayed as "+ videocall);
			} 
			if (MMS != null) {
				Assert.assertTrue(MMS_DETAILS.isDisplayed());
				System.out.println("verified MMS");
			}if (CALLS != null) {
				Assert.assertTrue(CALLS_DETAILS.isDisplayed());
				System.out.println("verified  calls");
			}
			if (SMS != null) {
				Assert.assertTrue(SMS_DETAILS.isDisplayed());
				System.out.println("verified SMS");
			}
			swipeUp();
			Thread.sleep(3000);
			if (INTERNET != null) {
				Assert.assertTrue(INTERNET_DETAILS.isDisplayed());
				System.out.println("verified Internet");
			}

			break;
		}




	}

	//	        case "EURO_MILLION_VIEWRESULT" :
	//	        EURO_MILLION_VIEWRESULT.click();
	//	        test.log(LogStatus.PASS, "Euro million view result link is clicked Successfully");
	//	    takeScreenShot();
	//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CHECK_MY_TICKETS_LINK);
	//	        CHECK_MY_TICKETS_LINK.click();
	//	        test.log(LogStatus.PASS, "Check my ticket link is clicked and loaded to check my ticket page Successfully");
	//	    takeScreenShot();
	//	        System.out.println("clicking Euro view results"); 
	//	           break;
	//	           
	//	        case "MILLIONAIRE_RAFFLE_VIEWRESULT" :
	//	        MILLIONAIRE_RAFFLE_VIEWRESULT.click();
	//	        test.log(LogStatus.PASS, "Millionaire raffle view result link is clicked Successfully");
	//	    takeScreenShot();
	//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CHECK_MY_TICKETS_LINK);
	//	        CHECK_MY_TICKETS_LINK.click();
	//	        test.log(LogStatus.PASS, "Check my ticket link is clicked and loaded to check my ticket page Successfully");
	//	    takeScreenShot();
	//	        System.out.println("clicking Millionaire Raffle view results"); 
	//	           break;
	//	           
	//	        case "TELLY_BINGO_VIEWRESULT" :
	//	        TELLY_BINGO_VIEWRESULT.click();
	//	        test.log(LogStatus.PASS, "Telly Bingo view result link is clicked Successfully");
	//	    takeScreenShot();
	//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CHECK_MY_TICKETS_LINK);
	//	        CHECK_MY_TICKETS_LINK.click();
	//	        test.log(LogStatus.PASS, "Check my ticket link is clicked and loaded to check my ticket page Successfully");
	//	    takeScreenShot();
	//	        System.out.println("clicking Telly Bingo view results"); 
	//	           break;
	//	           
	//	        case "LOTTO54321_VIEWRESULT" :
	//	        LOTTO54321_VIEWRESULT.click();
	//	        test.log(LogStatus.PASS, "Lotto54321 view result link is clicked Successfully");
	//	    takeScreenShot();
	//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CHECK_MY_TICKETS_LINK);
	//	        CHECK_MY_TICKETS_LINK.click();
	//	        test.log(LogStatus.PASS, "Check my ticket link is clicked and loaded to check my ticket page Successfully");
	//	    takeScreenShot();
	////	        System.out.println("clicking Lotto54321 view results"); 
	////	            break;
	//	            
	//	     }


	public void tapOnNumber() {

		int screen_width = driver.manage().window().getSize().getWidth();

		int x = screen_width/2;
		int y = DASHBOARD_MOBILENUM.getLocation().getY();

		TouchAction touchAction = new TouchAction((AppiumDriver<MobileElement>) driver); 
		touchAction.press(PointOption.point(704,246)).release().perform();
		//touchAction.press(PointOption.point(x,y)).release().perform();
		System.out.println("Executed");

	}
	public void swipeUp() {

		int screen_width = driver.manage().window().getSize().getWidth();
		int screen_height = driver.manage().window().getSize().getHeight();

		int x1 = screen_width/2;
		int y1 = screen_height*3/4;

		int x2 = screen_width/2;
		int y2 = screen_height/4;

		TouchAction touchAction = new TouchAction((AppiumDriver<MobileElement>) driver); 
		//touchAction.press(PointOption.point(704,246)).release().perform();
		touchAction.press(PointOption.point(x1,y1)).moveTo(PointOption.point(x2,y2)).release().perform();


	}
}
