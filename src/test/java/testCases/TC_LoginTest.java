package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void test_Login() {
		try {
			
		
		logger.info("******starting TC_LoginTest******");
		
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked On My Account link");
		hp.ClickOnLogin();
		logger.info("Clicked On My Login link");

		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email")); // valid email from config.properties
		logger.info("Set Email");

		lp.setPassword(rb.getString("pass"));     //valid password from config.properties file
		logger.info("set Password");

		lp.clickLogin();
		logger.info("Clicked On Login Button");

		MyAccountPage macc=new MyAccountPage(driver); 
		
		boolean targetpage=macc.isMyacountPageExists();
		Assert.assertEquals(targetpage, true);

		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******Finished- TC_LoginTest******");
		
	}
	

	
}
