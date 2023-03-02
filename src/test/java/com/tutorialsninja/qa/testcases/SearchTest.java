package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;
// Updated comment
public class SearchTest extends Base {
	
	SearchPage	searchpage;
	HomePage homepage;
	
	
	public SearchTest() {
		super();
		
	}
	 
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		 homepage= new HomePage(driver);
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		
		//HomePage homepage= new HomePage(driver);
		 searchpage=	homepage.searchForAProduct(dataprop.getProperty("validProduct"));
		//homepage.enterProductIntoSearchBoxField(dataprop.getProperty("validProduct"));
		//searchpage=homepage.clickOnSearchButton();
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataprop.getProperty("validProduct"));
		//driver.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']")).click();
		//searchpage= new SearchPage(driver);
		Assert.assertTrue(searchpage.displayStatusofHPValidProduct(),"valid product HP is not display in the Search result");
		
		
	}
	@Test(priority = 2)
	public void verifySearchWithInValidProduct() {
		//HomePage homepage= new HomePage(driver);
		 searchpage=homepage.searchForAProduct(dataprop.getProperty("invalidproduct"));
	//	homepage.enterProductIntoSearchBoxField(dataprop.getProperty("invalidproduct"));
	 // searchpage =homepage.clickOnSearchButton();
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataprop.getProperty("invalidproduct"));
		//driver.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']")).click();
		//SearchPage searchpage= new SearchPage(driver);
		//String actualsearchmsg=searchpage.retrieveNoProductMessageText();
		
		Assert.assertEquals(searchpage.retrieveNoProductMessageText(),dataprop.getProperty("noproductTextSearchResult"),"no search product msg is not display");
	}
		
	@Test(priority = 3)
	public void verifySearchWithoutanyProduct() {
		
		//HomePage homepage= new HomePage(driver);
		 searchpage=homepage.clickOnSearchButton();
		
		//driver.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']")).click();
		//String actualsearchmsg= driver.findElement(By.xpath("//div[@id='content']//h2/following-sibling::p")).getText();
		//SearchPage searchpage= new SearchPage(driver);
		//String actualsearchmsg=searchpage.retrieveNoProductMessageText();
		
		Assert.assertEquals(searchpage.retrieveNoProductMessageText(),dataprop.getProperty("noproductTextSearchResult"),"no search product msg is not display");
	}
		
		
		
		
		
		
		
		
		
	}

