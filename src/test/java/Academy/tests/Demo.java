package Academy.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Demo {

	

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        try {
            // Create a local instance of cookie store
            CookieStore cookieStore = new BasicCookieStore();

            // Create local HTTP context
            HttpClientContext localContext = HttpClientContext.create();
            // Bind custom cookie store to the local context
            localContext.setCookieStore(cookieStore);

            HttpGet httpget = new HttpGet("https://www.hepsiburada.com/ayagina-gelsin/giris");
            System.out.println("Executing request " + httpget.getRequestLine());

            httpclient.start();

            // Pass local context as a parameter
            Future<HttpResponse> future = httpclient.execute(httpget, localContext, null);

            // Please note that it may be unsafe to access HttpContext instance
            // while the request is still being executed

            System.out.println("Shutting down");

            HttpPost httpPost = new HttpPost("https://rahulshettyacademy.com/client");
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("em", "punithRaj@gmail.com"));
            params.add(new BasicNameValuePair("p", "punithRaj1"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            future = httpclient.execute(httpPost,localContext,null);
            HttpResponse response = future.get();
            System.out.println("Response: " + response.getStatusLine());
            List<Cookie> cookies = cookieStore.getCookies();
            cookies = cookieStore.getCookies();
            

            System.out.println(cookies.size());

            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            
           
           
            
            
            System.setProperty("webdriver.chrome.driver","C:\\Users\\balachandra.4\\Verynew-Workspace\\SeleniumFrameworkDesignBalu\\src\\main\\java\\Academy\\resources\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.navigate().to("https://rahulshettyacademy.com/client");
            
            
            driver.findElement(By.id("userEmail")).sendKeys("punithRaj@gmail.com");
            driver.findElement(By.id("userPassword")).sendKeys("punithRaj1");
            
            driver.findElement(By.id("login")).click();

            driver.manage().getCookies();
            
            org.openqa.selenium.Cookie c;
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("Local cookie: " + cookies.get(i));
                c = new org.openqa.selenium.Cookie(cookies.get(i).getName(),cookies.get(i).getValue());
                driver.manage().addCookie(c);
            }
            driver.navigate().to("https://rahulshettyacademy.com/client/dashboard/dash");


        } finally {
            httpclient.close();
        }

    }

    
    
	
}
