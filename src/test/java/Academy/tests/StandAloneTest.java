package Academy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.Pageobjects.CartPage;
import Academy.Pageobjects.CheckOutPage;
import Academy.Pageobjects.ConfirmationPage;
import Academy.Pageobjects.LandingPage;
import Academy.Pageobjects.OrderPage;
import Academy.Pageobjects.ProductCatalogue;
import Academy.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	String OrderId;
	ConfirmationPage confirmationPage;
	@Test(dataProvider = "getData", groups = {"smoke","purchase"})
	
	public void submitOrder(HashMap<String, String>input) throws IOException, InterruptedException {
	
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("Password"));
		
		
		
		List<String>products=productCatalogue.getProductsList();
		
		
		System.out.println("Total Products: "+products.size());
		
		
	

	//String name="ADIDAS ORIGINAL";
	productCatalogue.addProductToCartByName(input.get("productName"));
		
	String msg=productCatalogue.getToastMessage();
		
	System.out.println(msg);
	
		
		Thread.sleep(5000);
		
		CartPage cartPage=productCatalogue.goToCartPage();
		
		
		
		List<String>cartList=cartPage.getCartProducts();

		Assert.assertTrue(cartList.contains(input.get("productName")));
		
		
		
		CheckOutPage checkOutPage=cartPage.clickOnCheckOut();

		checkOutPage.selectCountry("Ind");
		
		confirmationPage=checkOutPage.submitOrder();
		
		String Confmsg=confirmationPage.getConfirmationMsg();
		System.out.println(Confmsg);
		
		Assert.assertTrue(Confmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		OrderId=confirmationPage.getOrderId();
		System.out.println(OrderId);
		
	}
	
	
	@Test(dependsOnMethods = "submitOrder")
	public void orderHistoryTest() {
		

		ProductCatalogue productCatalogue=landingPage.loginApplication("ravichandran@gmail.com", "Ravichandran1");
		
		OrderPage orderPage=productCatalogue.goToOrderPage();
		
		boolean match=orderPage.verifyOrderIdIsDisplyed(OrderId);
		
		
		
		Assert.assertTrue(match);
		
		
		
	}
		
	
@DataProvider
public Object[][] getData() throws IOException {
			
	
	/*//Need to read the data from Json file with the help of utility
	
	HashMap<String, String>map=new HashMap<String,String>();
	
	map.put("UN", "punithRaj@gmail.com");
	map.put("PW", "punithRaj1");
	map.put("productName", "ADIDAS ORIGINAL");
	
HashMap<String, String>map1=new HashMap<String,String>();
	
	map1.put("UN", "ravichandran@gmail.com");
	map1.put("PW", "Ravichandran1");
	map1.put("productName", "IPHONE 13 PRO");
	
	*/
	
	List<HashMap<String, String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Academy\\data\\purchaesOrder.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)}};
			
		}
	
	
	//@DataProvider
	//public Object[][] getData() {
		
		
		//return new Object[][]  {{"punithRaj@gmail.com","punithRaj1","ADIDAS ORIGINAL"},{"ravichandran@gmail.com","Ravichandran1","IPHONE 13 PRO"}};
		
//	}
	


	
}

