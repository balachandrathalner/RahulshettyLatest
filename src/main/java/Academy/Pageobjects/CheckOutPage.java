package Academy.Pageobjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
	
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryTextbox;
	
	
	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted']/span")
	List<WebElement> contryList;
	
	@FindBy(css = "a[class*='btnn action__submit ']")
	WebElement placeOrder;
	
	
	By contryBy=By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']/span");
	
	public void selectCountry(String text) throws InterruptedException {
	
		
		countryTextbox.click();
		sendKeysByActionsClass(countryTextbox, text);
		
		
		
		//List<WebElement>contries=contryList;
		
		 for(WebElement e:contryList) {
			 
		 System.out.println(e.getText());
			
			 if(e.getText().equalsIgnoreCase("India")) {
		
		
					
				 e.click();
				 
				 break;
			 }
		 }
		
	
	
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException {

		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", placeOrder);
		
		
		//Thread.sleep(2000);
	//	placeOrder.click();
		
		
		return new ConfirmationPage(driver);
		
	}
	
	
}
