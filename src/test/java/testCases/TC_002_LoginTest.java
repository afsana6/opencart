package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"}) // Step 8
	public void Test_Login()
	{
		logger.info("Starting TC_002_LoginTest......");
		
		try
		{
		HomePage hp=new HomePage(driver);	// Home Page
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);	// Login Page
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC_002_LoginTest......");
	}

}
