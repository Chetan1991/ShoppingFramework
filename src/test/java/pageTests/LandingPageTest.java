package pageTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;

public class LandingPageTest extends BaseTest{
	WebDriver driver;
	LandingPage landingPage;
	ProductCatalogue productCatalogue;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		landingPage= new LandingPage(driver);
		productCatalogue= new ProductCatalogue(driver);
	}
	
	@Test
	public void Verify_login_with_valid_credentials()
	{	
		//Open the browser and navigate to the login page.
		//Locate the username input field (e.g., by ID or name) and enter valid credentials.
		//Locate the password input field and enter the valid password.
		//Click the login button.
		landingPage.loginApplication("123ser@gmail.com", "@Chetan123");
		//Assert that the user is redirected to the dashboard URL or confirm successful login with a visible element.
		Assert.assertEquals("Sign Out", productCatalogue.getSignOutBtn().getText());
	}
	
	//Test Case 1.2: Verify error message for invalid credentials\
	@Test
	public void verify_error_message_invalid_credentials()
	{
		landingPage.loginApplication("123ser@gmail.com", "@Chetan");
		Assert.assertEquals("Incorrect email orpassword.", landingPage.getErrorMessage());
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
