package Academy.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
	
		super(driver);
	
		
		this.driver=driver;
		
		
	PageFactory.initElements(driver,this);
	
	}

	
	@FindBy(css = "h1[class='hero-primary']")
	WebElement confirmationMsg;
	
	@FindBy(xpath = "//tbody//tr[3]/td/label")
	WebElement orderId;

public String getConfirmationMsg() {
	
	
	return confirmationMsg.getText();
	
	
}

public String getOrderId() {
	
	
	//return orderId.getText();
	
	String s=orderId.getText();
		String a[]=s.split(" ");
		
		String[] b=a[1].split(" ");
		return b[0];
	
}



}

