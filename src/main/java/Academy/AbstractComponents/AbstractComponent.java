package Academy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Academy.Pageobjects.CartPage;
import Academy.Pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	


	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	
	
	
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	

	public void waitForWebElementToAppear(WebElement ele) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.visibilityOf(ele));
	
	}
	
	public void waitForElementToclickable(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		}
		
	
	
	public CartPage goToCartPage() {
		
		cart.click();
		
		
		
		return new CartPage(driver);
		
	
	}
	
	

	public OrderPage goToOrderPage() {
		
		orderHeader.click();
		
		return new OrderPage(driver);
		
	
	}
	
	
	public void sendKeysByActionsClass(WebElement element,String text) {
		
	Actions a=new Actions(driver);
		
	a.sendKeys(element, text).build().perform();
		
	}

}
