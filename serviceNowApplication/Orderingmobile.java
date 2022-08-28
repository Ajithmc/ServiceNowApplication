package serviceNowApplication;

import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Orderingmobile extends ProjectServiceNowApplication {
@Test
	public  void orderingMobile() throws InterruptedException  {
		/*
		 * WebDriverManager.chromedriver().setup(); //setup ChromeDriver driver = new
		 * ChromeDriver(); driver.get("https://dev92105.service-now.com");//load URL
		 * driver.manage().window().maximize();//maximize
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit
		 * wait
		 * 
		 * //Login with valid credential
		 * 
		 * WebElement userName =
		 * driver.findElement(By.xpath("//input[@id='user_name']"));
		 * userName.sendKeys("admin"); WebElement userPswd =
		 * driver.findElement(By.xpath("//input[@id='user_password']"));
		 * userPswd.sendKeys("Ajithmc@98"); WebElement login =
		 * driver.findElement(By.xpath("//button[text()='Log in']")); login.click();
		 */
		
		//Click-AllEnter Service catalog in filter navigator and press enter 
		
		Shadow shadow=new Shadow(driver); 
		Thread.sleep(10000);
		shadow.setImplicitWait(10);
		WebElement dom = shadow.findElementByXPath("//div[@id='all']");
		dom.click();
		
		Thread.sleep(2000); 
		shadow.setImplicitWait(10);
		WebElement serviceCatalog = shadow.findElementByXPath("//span[text()='Service Catalog']");
		serviceCatalog.click();
		
		//Click on  mobiles
		
		Thread.sleep(10000); 
		WebElement frameHandle = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameHandle);
		driver.findElement(By.xpath("//h2[contains(text(), 'Mobiles')]")).click();
		//driver.findElement(By.xpath("//span[contains(text(), 'Cell phones to meet your business needs')]")).click();
		
		//Select Apple iphone6s
		
		driver.findElement(By.xpath("(//table[@class='no_underline_table'])[2]")).click();
		WebElement select1 = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
	
		//Update color field to rose gold and storage field to 128GB
		
		Select dropdown = new Select(select1);
		dropdown.selectByVisibleText("Gold");
	
		WebElement select2 = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2] "));
		
		Select dropdown2 = new Select(select2);
		dropdown2.selectByVisibleText("128");
		
		//Select  Order now option
		
		WebElement orderNow = driver.findElement(By.xpath("//button[@id='oi_order_now_button']"));
		orderNow.click();
		
		WebElement text = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']"));
		String orderText = text.getText();
		
		//Verify order is placed and copy the request number"
		
		if(orderText.equalsIgnoreCase("Thank you, your request has been submitted")) {
			System.out.println("Order is Placed");
			WebElement reqNum = driver.findElement(By.xpath("//a[@id='requesturl']"));
			System.out.println(reqNum.getText());
			
			/*String orderStatus = driver.findElement(By.xpath("//div[@class='notification notification-success']/span"))
					.getText();
			System.out.println("Ordered Status is: " + orderStatus);
			String expectedResult = "Thank you, your request has been submitted";

			if (orderStatus.equals(expectedResult)) {
				System.out.println("Order is Placed");
			} else {
				System.out.println("Order is not placed");*/
			}
			
			
		}
		
	}


