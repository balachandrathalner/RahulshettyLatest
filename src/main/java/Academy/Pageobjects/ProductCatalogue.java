package Academy.Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	
	
	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver) {
	
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy(xpath= "//h5//b")
	
	List<WebElement> products;
	
	By productsby= By.xpath("//h5//b");
	
	
	@FindBy(xpath = "//*[@id='products']//button[2]")
	List<WebElement> addtocart;
	
	@FindBy(id=("toast-container"))
	WebElement toastmessage;
	
	By toastMSG=By.id("toast-container");
	
	
	
	
	
	public List<String> getProductsList() throws InterruptedException {
		
	//	waitForElementToAppear(productsby);

		List<String>productList=new ArrayList<>();
		
		for(WebElement prod:products) {
			
			String txt=prod.getText();
			
			productList.add(txt);
		
		
	}
		
		
		return productList;
		
		
		
		
		
	}
	
	
	public void addProductToCartByName(String productName) throws InterruptedException {
		
		
		for (int i = 0; i < products.size();i++) {

		
			
		
		if(products.get(i).getText().equalsIgnoreCase(productName));

		{	
			waitForElementToclickable(addtocart.get(i));

			addtocart.get(i).click();
			
			break;
			
			
			

		}

		
			
			
			
	}
	
}

	public String getToastMessage() {
		
		
		waitForElementToAppear(toastMSG);
		return toastmessage.getText();
		
	}
	
	
	
}
