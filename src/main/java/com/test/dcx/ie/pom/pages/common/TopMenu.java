package com.test.dcx.ie.pom.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.dcx.ie.pom.util.CelcomConstants;
/**
 * @author SATYA PRAKASH
 * This Page is coomon to every page
 * All the function can be called directly to other page
 * 
 */
public class TopMenu {


	@FindBy(xpath=CelcomConstants.LOGOUT_BUTTON)
	public WebElement LOGOUT_BUTTON;
	//	@FindBy(xpath=CelcomConstants.SIGNOUT_CONFIRMATION_BUTTON)
	//	public WebElement SIGNOUT_CONFIRMATION_BUTTON;
	ExtentTest test;


	WebDriver driver;

	public TopMenu(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}

	public void logout() throws InterruptedException{
		test.log(LogStatus.INFO, "logging out");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",LOGOUT_BUTTON);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		LOGOUT_BUTTON = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CelcomConstants.LOGOUT_BUTTON)));
		LOGOUT_BUTTON.click();
		Thread.sleep(500);

		test.log(LogStatus.PASS, "Logged out successfully");
	}


}
