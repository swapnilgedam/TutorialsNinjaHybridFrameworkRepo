package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	@FindBy(id = "input-firstname")

	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordfield;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsletterOption;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
		

	}
	
	// Actions
	
	
	
	public AccountSuccessPage register(String firstNameText, String lastNameText,String emailText,String telephone,String passwordText,String conformPasswordText ) {
		
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephone);
		passwordfield.sendKeys(passwordText);
		passwordConfirmField.sendKeys(conformPasswordText);
		privacyPolicyField.click();
          continueButton.click();
		
		return new AccountSuccessPage(driver);
	}
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
		
		
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
}
	public void enterEmailField(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String telephone) {
		
		telephoneField.sendKeys(telephone);
		
	}
	
	public void enterPasswordField(String passwordText) {
		passwordfield.sendKeys(passwordText);
		
	}
	public void enterConfirmPasswordField(String conformPasswordText) {
		passwordConfirmField.sendKeys(conformPasswordText);
	}
	
	public void selectPrivacyPolicyField() {
		privacyPolicyField.click();
		
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		
		continueButton.click();
		
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsletterOption() {
		
		yesNewsletterOption.click();
		
	}
	
	public String retrieveDuplicateEmailAddress() {
		
	String	duplicateEmailAddressWarningText=duplicateEmailAddressWarning.getText();
	
	return duplicateEmailAddressWarningText;
	}
	
	public String retrievePrivacyPolicyWarning() {
	String	privacyPolicyWarningText=	privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	}