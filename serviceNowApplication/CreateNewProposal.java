package serviceNowApplication;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewProposal extends ProjectServiceNowApplication {
@Test
	public void createNewProposal() throws InterruptedException {
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

		// Click All and Enter Proposal in filter navigator and press enter
		
		Shadow shadow=new Shadow(driver); 
		Thread.sleep(10000); 
		shadow.setImplicitWait(10);
		WebElement dom = shadow.findElementByXPath("//div[@id='all']");
		dom.click();
		Thread.sleep(2000); 
		shadow.setImplicitWait(10);
		WebElement filter = shadow.findElementByXPath("//input[@placeholder='Filter']");
		//WebElement filter1 = shadow.findElementByXPath("//input[@id='filter']");

		filter.click(); 
		Thread.sleep(2000); 
		filter.sendKeys("Proposal",Keys.ENTER);

		dom.click();
		Thread.sleep(2000); 
		WebElement myProposal = shadow.findElementByXPath("//a[@class='nested-item item-label keyboard-navigatable highlighted-item']");

		myProposal.click();
		Thread.sleep(1000);
		
		//Click- new  and  fill mandatory fields and click 'Submit' Button.
		
		driver.switchTo().frame(shadow.findElementByXPath("iframe[@id='gsft_main']"));

		WebElement newButton = driver.findElement(By.xpath("//button[text()='New']"));
		newButton.click();

		WebElement temDescription = driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']"));
		temDescription.sendKeys("This is my new Proposal",Keys.ENTER);
		Thread.sleep(1000); 
		WebElement submit = driver.findElement(By.xpath("(//button[text()='Submit'])[2]"));
		submit.click();

		String temDescrip = driver.findElement(By.xpath("//td[text()='This is my new Proposal']")).getText();
		System.out.println(temDescrip);
		//Verify the successful creation of new Proposal"
		
		WebElement text = shadow.findElementByXPath("//td[text()='This is my new Proposal']");
		//td[text()='This is my new Proposal']
		System.out.println(text);
	}

}
