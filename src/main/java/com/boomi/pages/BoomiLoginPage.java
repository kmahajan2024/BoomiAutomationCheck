package com.boomi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.boomi.base.BrowserLaunch;

public class BoomiLoginPage extends BrowserLaunch{
	
	

	@FindBy(xpath="//input[@type='email']")
	public WebElement emailAddress;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	public WebElement signIn;
	
	@FindBy(xpath="//button[contains(text(),'Close')]")
	public WebElement closeDialogue;
	
	@FindBy(xpath="//button[contains(text(),'No, Thanks')]")
	public WebElement closeDialogueNoThanks;
	
	@FindBy(xpath="//*[contains(text(),'OraFinTest')]")
	WebElement oraFinTestSelect;
	
	public BoomiLoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void loginToBoomi() {
		
		pageLoadTimeOut(driver, emailAddress);

		userSendKeys(driver, emailAddress, prop.getProperty("username"));

		userSendKeys(driver, password, prop.getProperty("password"));

		userClickAndWait(driver, signIn);
		
		try {
			if(closeDialogue.isEnabled() == true) {
				System.out.println("Element is visible");
				userClick(driver, closeDialogue);
			}	
			
			if(closeDialogueNoThanks.isEnabled() == true) {
				System.out.println("Element is visible");
				userClick(driver, closeDialogueNoThanks);
			}
		}
		catch(Exception e) {
			
		}

		userClickAndWait(driver, oraFinTestSelect);
		
	}
	
	
}
