package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	RegisterPage registerpage;
	 AccountSuccessPage accountsuccesspage;
	
public  RegisterTest() {
		
		super();
	}
	
	
	
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homepage= new HomePage(driver);
		//homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 //registerpage=	homepage.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click();
		 registerpage= homepage.nevigateToRegisterPage();
	}
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryField() {
		accountsuccesspage=registerpage.register(dataprop.getProperty("firstName"),dataprop.getProperty("lastName"),Utilities.generateEmailWithTimeStamp(), dataprop.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		//RegisterPage registerpage= new RegisterPage(driver);
		//registerpage.enterFirstName(dataprop.getProperty("firstName"));
		//registerpage.enterLastName(dataprop.getProperty("lastName"));
		//registerpage.enterEmailField(Utilities.generateEmailWithTimeStamp());
		
		//registerpage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		//registerpage.enterPasswordField(prop.getProperty("validPassword"));
		//registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		//registerpage.selectPrivacyPolicyField();
	 /// accountsuccesspage=registerpage.clickOnContinueButton();
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));

		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//AccountSuccessPage accountsuccesspage=new AccountSuccessPage(driver);
		
		String actualSuccessHeading =  accountsuccesspage.retrieveAccountSuccessPageHeading();
				
		Assert.assertEquals(actualSuccessHeading,dataprop.getProperty("accountSuccessfullyCreatedHeading"),
				"Account success page is not display");

		
	}

	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		//RegisterPage registerpage= new RegisterPage(driver);
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmailField(Utilities.generateEmailWithTimeStamp());
		
		registerpage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		
		registerpage.selectYesNewsletterOption();
		registerpage.selectPrivacyPolicyField();
	    accountsuccesspage=registerpage.clickOnContinueButton();
		

		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));

		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
       // AccountSuccessPage accountsuccesspage=new AccountSuccessPage(driver);
		
		String actualSuccessHeading =  accountsuccesspage.retrieveAccountSuccessPageHeading();
		
		Assert.assertEquals(actualSuccessHeading, dataprop.getProperty("accountSuccessfullyCreatedHeading"),
				"Account success page is not display");

		// driver.quit();

	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {

		//RegisterPage registerpage= new RegisterPage(driver);
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
        registerpage.enterEmailField(prop.getProperty("validEmail"));
        registerpage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		
		registerpage.selectYesNewsletterOption();
		registerpage.selectPrivacyPolicyField();
		registerpage.clickOnContinueButton();
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));

		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualwarningmsg = registerpage.retrieveDuplicateEmailAddress();
				

		Assert.assertEquals(actualwarningmsg, dataprop.getProperty("duplicateEmailWarning"));

	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingDetails() {
		//RegisterPage registerpage= new RegisterPage(driver);
		
		registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualprivacypolicywarning =registerpage.retrievePrivacyPolicyWarning();
				
		Assert.assertTrue(actualprivacypolicywarning.contains(dataprop.getProperty("privacyPolicyWarning")),
				"privacy msg is not display");

	}

}
