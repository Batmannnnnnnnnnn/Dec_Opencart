package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	//Elements...........................................
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linkLogin;
//Action Methods
	
      public void ClickMyAccount() {
	linkMyaccount.click();
	}
	
      public void ClickOnRegister() {
    	   linkRegister.click();
    }

	
      public void ClickOnLogin() {
   	   linkLogin.click();
   }
	
	
	
	
	
	
	

}
