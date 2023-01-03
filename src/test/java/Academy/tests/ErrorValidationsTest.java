package Academy.tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Academy.Pageobjects.CartPage;
import Academy.Pageobjects.CheckOutPage;
import Academy.Pageobjects.ConfirmationPage;
import Academy.Pageobjects.ProductCatalogue;
import Academy.TestComponents.BaseTest;
import Academy.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	
	@Test(groups = "smoke",retryAnalyzer = Retry.class)
	
	public void loginErrorValidations() throws IOException, InterruptedException {
	
		
		landingPage.loginApplication("punithRaj@gmail.com", "punithRaj11");
		
		System.out.println(landingPage.getErrorMessage());
		
		
		Assert.assertEquals( landingPage.getErrorMessage(),"Incorrect email or password.");
		
		
				
	}
	@Test
	
	public void productErrorValidation() throws IOException, InterruptedException {
	
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("punithRaj@gmail.com", "punithRaj1");
		
		
		
		List<String>products=productCatalogue.getProductsList();
		
		
		System.out.println("Total Products: "+products.size());
		
		
	

	String name="111ADIDAS ORIGINAL";
	productCatalogue.addProductToCartByName(name);
		
	String msg=productCatalogue.getToastMessage();
		
	System.out.println(msg);
	
		
		Thread.sleep(5000);
		
		CartPage cartPage=productCatalogue.goToCartPage();
		
		List<String>cartList=cartPage.getCartProducts();

		Assert.assertFalse(cartList.contains(name),"Invalid");
				
		
	}

}
