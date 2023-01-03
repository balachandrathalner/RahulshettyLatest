package Academy.Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponent;


public class OrderPage extends AbstractComponent {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//div[1]//tbody/tr/th")
	List<WebElement> orderIds;

	
	
	public boolean verifyOrderIdIsDisplyed(String orderId) {
		
		boolean match=false;
		
		for(WebElement e:orderIds) {
		
			if(e.getText().equals(orderId)) {
				match=true;
				break;
			}
		
		}
		return match;
		
		
	}
	
	
	
	
}
