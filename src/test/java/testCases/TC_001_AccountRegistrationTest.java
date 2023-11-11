package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression", "Master"})	//Step 8
	public void test_account_Registration()
	{
		logger.info("*********** Starting TC_001_AccountRegistrationTest ************ ");
		logger.debug("**** Generating debug logs ****");
		
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on my Account link");
			hp.clickRegister(); // open registration page
			logger.info("Clicked on my Registration link");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			logger.info("Providing customer details......");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");
			regpage.setTelephone(randomNumber());
			
			String pwd=randomAlphaNumeric();
			regpage.setPassword(pwd);
			regpage.setConfirmPassword(pwd);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("Clicked on continue button...");
			
			String confmsg=regpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				logger.info("test  passed");
				AssertJUnit.assertTrue(true);
			}
			else
			{
				logger.error("test failed");
				AssertJUnit.assertTrue(false);
			}
		} 
		catch (Exception e) {
			AssertJUnit.fail();
		}

		logger.info("*********** Finished TC_001_AccountRegistrationTest ************ ");
		
	}
	

	
	
	
	
	

}
