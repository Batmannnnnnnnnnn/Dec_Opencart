package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
       //elements
	@FindBy(xpath="//h2[normalize-space()='My Account']")//my account HeadingPage
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement linkLogout;
	
	//Methods
	public boolean  isMyacountPageExists(){
		try{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e){
			return (false);
		}
	}
	  public void clickLogout(){
		  linkLogout.click();
	  }
	
	
	
	
	
	
	
	
}
