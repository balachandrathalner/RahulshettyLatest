package Academy.Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		
		super(driver);
	
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//div[@class='cart']//h3")
	List<WebElement>cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkout;
	
	
	
	
	
	
	
	
	public List<String> getCartProducts() {
		
		List<String>CartList=new ArrayList<>();
		
		for(WebElement prod:cartProducts) {
			
			System.out.println(prod.getText());
			CartList.add(prod.getText());
			
		}
		
		return CartList;
		
	}
	
	public CheckOutPage clickOnCheckOut() {
		
		checkout.click();
		
		
		return new CheckOutPage(driver);
		
		
	}
	
	
	
	
}
