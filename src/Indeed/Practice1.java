package Indeed;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import org.openqa.selenium.firefox.FirefoxDriver;

//public class FirefoxBrowserLaunchDemo

public class Practice1 {

	private static WebDriver driver;

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		//Launch Browser
	
		System.setProperty("webdriver.gecko.driver", "./Config/geckodriver.exe");
		driver = new FirefoxDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
//		System.setProperty("webdriver.chrome.driver", "./Config/chromedriver.exe");
////		 System.setProperty("webdriver.chrome.driver", "/lib/chromeDriver/chromedriver.exe");
//		driver = new ChromeDriver();
		 
		// open indeed home page
		driver.get("http://www.indeed.co.uk");
		//System.out.print("Sam");
		
		//Find what field and enter "Selinum"
		driver.findElement(By.id("text-input-what")).sendKeys("Selenium");
		
		
		//System.out.print("Hello Endalk");
		//Find Location field enter "London"
		driver.findElement(By.id("text-input-where")).sendKeys("London");
		
		//Find FindJob Button click on it
		//driver.findElement(By.id("fj")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/form/div[3]/button")).click();
		//div/div[1][@class='Account_signupColumnSplit_YtgPc']/input
		//div/input[@name='signupFirstName']
		//input[@name='signupFirstName']
		driver.findElement(By.id("prime-popover-close-button")).click();
				
		//From Job search result page get page title and jobs count message
		
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		System.out.println(driver.getTitle());
		
	}
	
	@Test
	public void shit() {
		
	}

}
