package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	void test_LoginDdt(String email,String password,String exp) {
		
		logger.info("*******Starting TC_LoginDDT");
		try {
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickOnLogin();


		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email); // valid email from config.properties
		lp.setPassword(password);     //valid password from config.properties file
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);  
		boolean targetpage=macc.isMyacountPageExists();
		
		if(exp.equals("Valid"))
		  {  if(targetpage==true)
		      {
			  macc.clickLogout();
			  Assert.assertEquals(true, true);
		      } 
		  else {
			  Assert.fail();
		       }	
		  }
		
		
		if(exp.equals("Inalid"))
		  {  if(targetpage==true)
		      {
			  macc.clickLogout();
			  Assert.assertEquals(true, false);
		      } 
		  else {
			  Assert.assertTrue(true);
		       }	
		  }
		
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("*******Finised TC_LoginDDT");
		
		
		
		
	}
	
		
	
}
