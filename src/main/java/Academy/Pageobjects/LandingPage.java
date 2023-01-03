package Academy.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	
	public LandingPage(WebDriver driver) {
	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	@FindBy(id = "userEmail")
	WebElement userName;
	
	@FindBy(id = "userPassword")
	WebElement passwordEle;
	
	
	@FindBy(id ="login" )
	WebElement loginButton;
	
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public ProductCatalogue loginApplication(String email,String password) {
		
		userName.sendKeys(email);
		passwordEle.sendKeys(password);
		
		loginButton.click();
		
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		
	waitForWebElementToAppear(errorMessage);	
	return	errorMessage.getText();
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
}

