package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_Account_RegistrationTest extends BaseClass   {
	
	
	@Test(groups= {"Regression","Master"})
void account_registration() {

		
		logger.info("*******starting TC_Account_RegistrationTest*******");
		
try {
	HomePage hp=new HomePage(driver);
	hp.ClickMyAccount();
	logger.info("clicked on my account link");
	logger.info("Clicked on register link");
	hp.ClickOnRegister();
	logger.info("Clicked on register link");
	AccountRegistrationPage reg=new AccountRegistrationPage(driver);
	
	reg.setFirstName(randomString().toUpperCase());

	reg.setLastName(randomString().toUpperCase());
	logger.info("provided first and last name");
	reg.setEmail(randomString()+"@gmail.com");   //random email

	reg.setTelephone(randomNumber());
//	reg.setTelephone(654785);	
	String pass=randomAlpaNumeric();
	reg.setPassword(pass);
	
	reg.setConfirmPassword(pass);
	
	reg.setPrivacyPolicy();
	
	reg.clickContinue();
	logger.info("Clicked on continue button");
	
	String confmsg=reg.getConfirmationMsg();
	logger.info("Validating Expected msg");
	Assert.assertEquals(confmsg, "Your Account Has Been Created!","not getting expected msg");
	
    }
	catch(Exception e)
    {
		logger.info("test failed");
		Assert.fail();
		}

logger.info("*******finised TC_Account_RegistrationTest*******");
}


}
