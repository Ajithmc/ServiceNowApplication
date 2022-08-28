package serviceNowApplication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectServiceNowApplication {
RemoteWebDriver driver;
	@Parameters({  "URL","username","password" })
	@BeforeMethod
	public void preCondition(String url,String username,String password) {
		WebDriverManager.chromedriver().setup(); //setup
		driver = new ChromeDriver();
		driver.get(url);//load URL
		driver.manage().window().maximize();//maximize
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
		
		//Login with valid credential
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
		userName.sendKeys(username);
		WebElement userPswd = driver.findElement(By.xpath("//input[@id='user_password']"));
		userPswd.sendKeys(password);
		WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();

	}
	
	  @AfterMethod public void postCondition() { 
		  // TODO Auto-generated method stub
	  driver.close();
	  }
	 
	
	
	
}
