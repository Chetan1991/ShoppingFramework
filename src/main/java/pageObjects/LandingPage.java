package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import resources.Utils;

public class LandingPage extends BaseTest {
	
	Utils util;
	
	ProductCatalogue productCatalogue;
	WebDriver driver;
	
	@FindBy(id = "userEmail")
	private WebElement userEmail;

	@FindBy(id = "userPassword")
	private WebElement passwordEle;

	@FindBy(id = "login")
	private WebElement submit;

	@FindBy(css = "[class*='flyInOut']")
	private WebElement errorMessage;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		util=new Utils();
	}

	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public String getErrorMessage()
	{
		util.waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
