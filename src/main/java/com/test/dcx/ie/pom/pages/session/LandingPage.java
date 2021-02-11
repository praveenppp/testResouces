package com.test.dcx.ie.pom.pages.session;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.dcx.ie.pom.base.BasePage;
import com.test.dcx.ie.pom.util.CelcomConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LandingPage extends BasePage{
	
	
	
	//PLI
//	@FindBy(xpath=CelcomConstants.YOUR_BALANCE_AMOUNT)
//	public WebElement YOUR_BALANCE_AMOUNT;
//	@FindBy(xpath=CelcomConstants.TRANSFER_FUNDS_BUTTON)
//	public WebElement TRANSFER_FUNDS_BUTTON;
//	@FindBy(how = How.ID , using =CelcomConstants.WITHDRAW_FUNDS_LINK)
//	public WebElement WITHDRAW_FUNDS_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.PLAY_LINK)
//	public WebElement PLAY_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.DRAWBASEDGAMES_LINK)
//	public WebElement DRAWBASEDGAMES_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.PLAYLOTTO_LINK)
//	public WebElement PLAYLOTTO_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.PLAYDAILYMILLION_LINK)
//	public WebElement PLAYDAILYMILLION_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.PLAYEURO_LINK)
//	public WebElement PLAYEURO_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.INSTANTWINGAMES_LINK)
//	public WebElement INSTANTWINGAMES_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.VIEWALLINSTANTWINGAMES_LINK)
//	public WebElement VIEWALLINSTANTWINGAMES_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.LUCKINLOVE_PLAYORTRY_LINK)
//	public WebElement LUCKINLOVE_PLAYORTRY_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.LUCKINLOVE_TRY_LINK)
//	public WebElement LUCKINLOVE_TRY_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.LUCKINLOVE_PLAYNOW_BUTTON)
//	public WebElement LUCKINLOVE_PLAYNOW_BUTTON;
//	@FindBy(how = How.ID , using =CelcomConstants.MYACCOUNTLOGINHINTS_LINK)
//	public WebElement MYACCOUNTLOGINHINTS_LINK;
//	@FindBy(how = How.ID , using =CelcomConstants.MYACCOUNTNOTIFICATION_LINK)
//	public WebElement MYACCOUNTNOTIFICATION_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.MYACCOUNT_BUTTON)
//	public WebElement MYACCOUNT_BUTTON;
//	@FindBy(how = How.ID , using =CelcomConstants.MYACCOUNTCHANGEPASSWORD_LINK)
//	public WebElement MYACCOUNTCHANGEPASSWORD_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.MYACCOUNT_MYWALLET_BUTTON)
//	public WebElement MYACCOUNT_MYWALLET_BUTTON;
//	@FindBy(how = How.XPATH , using =CelcomConstants.SPENDING_LIMITS_LINK)
//	public WebElement SPENDING_LIMITS_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.MANAGE_MY_SPENDING_LIMIT_MYACCOUNT)
//	public WebElement MANAGE_MY_SPENDING_LIMIT_MYACCOUNT;
//	@FindBy(how = How.XPATH , using =CelcomConstants.GOODCAUSES_AND_WINNERS_LINK)
//	public WebElement GOODCAUSES_AND_WINNERS_LINK;
//	@FindBy(how = How.XPATH , using =CelcomConstants.PLAYMILLIONAIRERAFFLE_LINK)
//	public WebElement PLAYMILLIONAIRERAFFLE_LINK;
//	
	
	
	public LandingPage(AppiumDriver<MobileElement> driver,ExtentTest test){
		super(driver,test);
	}
	
	//PLI
	/**
	 * @author SATYA PRAKASH
	 * This function is used for adding funds
	 * It return object of FundTransaction Page
	 */
	/*public FundTransactionPage gotoAddFundsPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to Add Fund page");
		TRANSFER_FUNDS_BUTTON.click();
		Thread.sleep(1000);
		FundTransactionPage addfundPage = new FundTransactionPage(driver,test);
		PageFactory.initElements(driver, addfundPage);
		return addfundPage;
	}
	
	public PlayLottoPage  gotoPlayLottoPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to Play Lotto page");
		PLAY_LINK.click();
		Thread.sleep(2000);
		DRAWBASEDGAMES_LINK.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		PLAYLOTTO_LINK = wait.until(ExpectedConditions.visibilityOf(PLAYLOTTO_LINK));
		PLAYLOTTO_LINK.click();
		PlayLottoPage playLottopage = new PlayLottoPage(driver,test);
		PageFactory.initElements(driver, playLottopage);
		return playLottopage;
	}
	public PlayEuroPage  gotoPlayEuroPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to Play Euro page");
		PLAY_LINK.click();
		Thread.sleep(2000);
		DRAWBASEDGAMES_LINK.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		PLAYEURO_LINK = wait.until(ExpectedConditions.visibilityOf(PLAYEURO_LINK));
		PLAYEURO_LINK.click();
		PlayEuroPage playEuropage = new PlayEuroPage(driver,test);
		PageFactory.initElements(driver, playEuropage);
		return playEuropage;
	}
	public PlayIWGPage gotoIWGPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to Play Luck In Love page");
		PLAY_LINK.click();
		Thread.sleep(500);
		INSTANTWINGAMES_LINK.click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",VIEWALLINSTANTWINGAMES_LINK);
		VIEWALLINSTANTWINGAMES_LINK.click();
		PlayIWGPage playIWGpage = new PlayIWGPage(driver,test);
		PageFactory.initElements(driver, playIWGpage);
		return playIWGpage;
	}
	
	public PLI_ChangePasswordPage   gotoPLI_ChangePasswordPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to My Account page");
		MYACCOUNT_BUTTON.click();
		WebDriverWait wait = new WebDriverWait(driver,7);
		MYACCOUNTCHANGEPASSWORD_LINK = wait.until(ExpectedConditions.visibilityOf(MYACCOUNTCHANGEPASSWORD_LINK));
		MYACCOUNTCHANGEPASSWORD_LINK.click();
		PLI_ChangePasswordPage changepasswordpage = new PLI_ChangePasswordPage(driver,test);
		PageFactory.initElements(driver, changepasswordpage);
		return changepasswordpage;
	}
	public PLI_ChangeLogInHintPage   gotoPLI_ChangeLogInHintPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to My Account page");
		MYACCOUNT_BUTTON.click();
		WebDriverWait wait = new WebDriverWait(driver,7);
		MYACCOUNTLOGINHINTS_LINK = wait.until(ExpectedConditions.visibilityOf(MYACCOUNTLOGINHINTS_LINK));
		MYACCOUNTLOGINHINTS_LINK.click();
		PLI_ChangeLogInHintPage changeloginhintdpage = new PLI_ChangeLogInHintPage(driver,test);
		PageFactory.initElements(driver, changeloginhintdpage);
		return changeloginhintdpage;
	}
	public PLI_MyAccountDeleteNotificationPage   gotoPLI_MyAccountDeleteNotificationPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to My Account page");
		MYACCOUNT_BUTTON.click();
		WebDriverWait wait = new WebDriverWait(driver,7);
		MYACCOUNTNOTIFICATION_LINK = wait.until(ExpectedConditions.visibilityOf(MYACCOUNTNOTIFICATION_LINK));
		MYACCOUNTNOTIFICATION_LINK.click();
		PLI_MyAccountDeleteNotificationPage deletenotificationpage = new PLI_MyAccountDeleteNotificationPage(driver,test);
		PageFactory.initElements(driver, deletenotificationpage);
		return deletenotificationpage;
	} 
	public SpendinglimitPage   gotoSpendinglimitPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to My Account page");
		MYACCOUNT_BUTTON.click();
		MANAGE_MY_SPENDING_LIMIT_MYACCOUNT.click();
		MYACCOUNT_MYWALLET_BUTTON.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		WebDriverWait wait = new WebDriverWait(driver,7);
		SPENDING_LIMITS_LINK = wait.until(ExpectedConditions.visibilityOf(SPENDING_LIMITS_LINK));
		takeScreenShot();
		SPENDING_LIMITS_LINK.click();
		SpendinglimitPage spendinglimitpage = new SpendinglimitPage(driver,test);
		PageFactory.initElements(driver, spendinglimitpage);
		return spendinglimitpage;
	} 
	public PlayDailyMillionPage  gotoPlayDailyMillionPage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to Play Lotto page");
		PLAY_LINK.click();
		Thread.sleep(2000);
		DRAWBASEDGAMES_LINK.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		PLAYDAILYMILLION_LINK = wait.until(ExpectedConditions.visibilityOf(PLAYDAILYMILLION_LINK));
		PLAYDAILYMILLION_LINK.click();
		PlayDailyMillionPage playDailyMillionpage = new PlayDailyMillionPage(driver,test);
		PageFactory.initElements(driver, playDailyMillionpage);
		return playDailyMillionpage;
	}
	public IWG_MoneyMultipliersDigitalPage gotoIWGPageMMD20X() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to Play Luck In Love page");
		PLAY_LINK.click();
		Thread.sleep(500);
		INSTANTWINGAMES_LINK.click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",VIEWALLINSTANTWINGAMES_LINK);
		VIEWALLINSTANTWINGAMES_LINK.click();
		IWG_MoneyMultipliersDigitalPage playIWGpageMMD20X = new IWG_MoneyMultipliersDigitalPage(driver,test);
		PageFactory.initElements(driver, playIWGpageMMD20X);
		return playIWGpageMMD20X;
	}
	public PlayMillionaireRafflePage  gotoPlayMillionaireRafflePage() throws InterruptedException {
		test.log(LogStatus.INFO, "Going to Play MillionaireRaffle page");
		PLAY_LINK.click();
		Thread.sleep(2000);
		DRAWBASEDGAMES_LINK.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		PLAYMILLIONAIRERAFFLE_LINK = wait.until(ExpectedConditions.visibilityOf(PLAYMILLIONAIRERAFFLE_LINK));
		PLAYMILLIONAIRERAFFLE_LINK.click();
		PlayMillionaireRafflePage playMillionrafflepage = new PlayMillionaireRafflePage(driver,test);
		PageFactory.initElements(driver, playMillionrafflepage);
		return playMillionrafflepage;
	}*/
	
	
}
