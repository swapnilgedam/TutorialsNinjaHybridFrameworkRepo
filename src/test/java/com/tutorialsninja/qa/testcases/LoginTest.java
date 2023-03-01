package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	
	public LoginTest() {
		
		super();
	}
	
	
	 public WebDriver driver;
	@BeforeMethod
	public void setup() {
		//loadPropertiesFile();
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homepage= new HomePage(driver);
		loginpage=homepage.nevigateToLoginPage();
		//homepage.clickOnMyAccount();
	    //loginpage=homepage.selectLoginOptions();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
		
	}
    @AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1,dataProvider="validCredentialsSupplier")

	public void verifyLoginWithValidCredentials(String Email,String Password) {
        //LoginPage lp= new LoginPage(driver);
		//loginpage.enterEmailAddress(Email);
		//loginpage.enterPassword(Password);
		//driver.findElement(By.id("input-email")).sendKeys(Email);
		//driver.findElement(By.id("input-password")).sendKeys(Password);
		//AccountPage accountPage=loginpage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//AccountPage accountPage= new AccountPage(driver);
		AccountPage accountPage=loginpage.login(Email, Password);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformation(),"Edit Account Information option is not display");
		

	}
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		Object [][] data =Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)

	public void verifyLoginWithInvalidCredentials() {
		//LoginPage lp= new LoginPage(driver);
		//loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginpage.enterPassword(dataprop.getProperty("invalidPassword"));
		//driver.findElement(By.id("input-email")).sendKeys( Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		//loginpage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		loginpage.login(Utilities.generateEmailWithTimeStamp(), dataprop.getProperty("invalidPassword"));
		String actualwarningMessage = loginpage.retrieveEmailPasswordMatchWarningMessageText();
		String expectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualwarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not display");
		

	}

	@Test(priority = 3)

	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		//LoginPage lp= new LoginPage(driver);
		
		loginpage.login(Utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"));
		//loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//loginpage.clickOnLoginButton();
		
		String actualwarningMessage = loginpage.retrieveEmailPasswordMatchWarningMessageText();
		String expectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualwarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not display");
		

		//String actualwarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				//.getText();
		//String expectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
		//Assert.assertTrue(actualwarningMessage.contains(expectedWarningMessage),
			//	"Expected warning message is not display");
		

	}

	@Test(priority = 4)

	public void verifyLoginWithValidEmailAndInValidPassword() {
		//LoginPage lp= new LoginPage(driver);
		loginpage.login(Utilities.generateEmailWithTimeStamp(),dataprop.getProperty("invalidPassword"));
		//loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginpage.enterPassword(dataprop.getProperty("invalidPassword"));
		//loginpage.clickOnLoginButton();
		
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();

		/*
		 * String actualwarningMessage =
		 * driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
		 * .getText(); String expectedWarningMessage =
		 * dataprop.getProperty("emailPasswordNoMatchWarning");
		 * Assert.assertTrue(actualwarningMessage.contains(expectedWarningMessage),
		 * "Expected warning message is not display");
		 */
		String actualwarningMessage = loginpage.retrieveEmailPasswordMatchWarningMessageText();
		String expectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualwarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not display");
		

	}



	@Test(priority = 5)

	public void verifyLoginWithoutProvidingCredentials() {
		
		//LoginPage lp= new LoginPage(driver);
		loginpage.clickOnLoginButton();
		/*
		 * driver.findElement(By.xpath("//input[@value='Login']")).click();
		 * 
		 * String actualwarningMessage =
		 * driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
		 * .getText(); String expectedWarningMessage =
		 * dataprop.getProperty("emailPasswordNoMatchWarning");
		 * Assert.assertTrue(actualwarningMessage.contains(expectedWarningMessage),
		 * "Expected warning message is not display");
		 */
		String actualwarningMessage = loginpage.retrieveEmailPasswordMatchWarningMessageText();
		String expectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualwarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not display");
		

	}
}
