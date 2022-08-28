package serviceNowApplication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller extends ProjectServiceNowApplication {
@Test
	public void createNewCaller() throws InterruptedException {
		// TODO Auto-generated method stub
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

		Shadow shadow=new Shadow(driver); 
		Thread.sleep(10000);
		shadow.setImplicitWait(10);
		WebElement dom = shadow.findElementByXPath("//div[@id='all']");
		dom.click();
		Thread.sleep(2000); 
		shadow.setImplicitWait(10);
		WebElement filter = shadow.findElementByXPath("//input[@placeholder='Filter']");
		//WebElement filter1 = shadow.findElementByXPath("//input[@id='filter']");

		//Click-All and Enter Callers in filter navigator and press enter 
		
		filter.click(); 
		Thread.sleep(2000); 
		shadow.setImplicitWait(10);
		filter.sendKeys("Callers",Keys.ENTER);
		dom.click();
		
		Thread.sleep(2000);
		shadow.setImplicitWait(10);
		WebElement callers = shadow.findElementByXPath("//span[@class='item-icon']");
		callers.click();
		Thread.sleep(1000);
		
		// Create new Caller by filling all the fields and click 'Submit'.
		
		WebDriver frame = driver.switchTo().frame(shadow.findElementByXPath("iframe[@id='gsft_main']"));

		WebElement newButton = driver.findElement(By.xpath("//button[text()='New']"));
		newButton.click();
		
		WebElement fname = driver.findElement(By.xpath("//input[@id='sys_user.first_name']"));
		fname.sendKeys("Ajith");
		
		WebElement lname = driver.findElement(By.xpath("//input[@id='sys_user.last_name']"));
		lname.sendKeys("kumar");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='sys_user.email']"));
		email.sendKeys("ajithak98@gmail.com");
		
		WebElement businessNum = driver.findElement(By.xpath("//input[@id='sys_user.phone']"));
		businessNum.sendKeys("8838275034");
		
		WebElement title = driver.findElement(By.xpath("//input[@id='sys_user.title']"));
		title.sendKeys("Jr.Tester");
		
		WebElement mobNum = driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']"));
		mobNum.sendKeys("7708550630");
		
		WebElement submit = driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default']"));
		submit.click();
		
		// Search and verify the newly created Caller"
		
		WebElement drop = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select select = new Select(drop);
		select.selectByVisibleText("First name");
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search.sendKeys("Ajith",Keys.ENTER);
		
		String name = driver.findElement(By.xpath("//table//tr[1]//td[4]")).getText();
		System.out.println(name);
		
	}

}
