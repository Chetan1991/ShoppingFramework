package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[text()=' HOME ']")
	private WebElement homeBtn;

	@FindBy(xpath = "//*[text()=' Sign Out ']")
	private WebElement signOutBtn;

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	
}
