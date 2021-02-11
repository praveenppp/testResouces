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



	public class CelcomDashboardPage extends BasePage{



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
		@FindBy(how = How.XPATH , using =CelcomConstants.MENU_BUTTON)
		public WebElement MENU_BUTTON;
		@FindBy(how = How.XPATH , using =CelcomConstants.LOGOUT_BUTTON)
		public WebElement LOGOUT_BUTTON;
		@FindBy(how = How.XPATH , using =CelcomConstants.DASHBOARD_MOBILENUM)
		public WebElement DASHBOARD_TEXT;



		public CelcomDashboardPage(AppiumDriver<MobileElement> driver,ExtentTest test){
			super(driver,test);

		}

		public void doLogin(String Browser,String mobilenumber) throws InterruptedException{
			try{

				takeScreenShot();

				WebDriverWait wait1 = new WebDriverWait(driver, 10);

				ALLOW_BUTTON.click();
				ALLOW_BUTTON.click();
				Thread.sleep(1000);
				driver.runAppInBackground(Duration.ofSeconds(3));
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

				if (wait1.until(ExpectedConditions.visibilityOf(ENTEROTP_TEXT)) != null) {
					Assert.assertTrue(ENTEROTP_TEXT.isDisplayed());

				}
				SEND_OTP.click();
				Thread.sleep(1000);
				SEND_OTP.sendKeys("1303");
				driver.hideKeyboard();
				takeScreenShot();

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
				//			if (wait1.until(ExpectedConditions.visibilityOf(ACCEPT_TEXT)) != null) {
				//				Assert.assertTrue(ACCEPT_TEXT.isDisplayed());
				//			}
				ACCEPT_BUTTON.click();
				Thread.sleep(1000);
				LOGIN_BUTTON.click();



				if(wait1.until(ExpectedConditions.visibilityOf(GUIDE_SLIDETEXT1)) != null) {
					Assert.assertTrue(GUIDE_SLIDETEXT1.isDisplayed());
					SLIDE_1.click();
				} else {
					Assert.assertFalse(false, "Slide1 is not displaying ");
				}

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

				if (wait1.until(ExpectedConditions.visibilityOf(DASHBOARD_TEXT)) != null) {
					Assert.assertTrue(DASHBOARD_TEXT.isDisplayed());
					MENU_BUTTON.click();
				}
				else {
					Assert.assertFalse(false, "Menu button is not displaying ");
				}


			}


			catch(Exception e){
				System.out.println(e.getMessage());
			}

		}

		public void logout() throws InterruptedException {

			boolean logoutresult = isElementPresent(CelcomConstants.LOGOUT_BUTTON);
			if(logoutresult){
				test.log(LogStatus.PASS, "Logged out successfully");
				takeScreenShot();
				LOGOUT_BUTTON.click();
				Thread.sleep(2000);
			}else{
				reportFailure("Still it is in menu page");
			}

		}
	}












