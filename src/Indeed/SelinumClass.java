package Indeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class SelinumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.gecko.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		//driver.findElement(By.id("email")).sendKeys("Myemail");
		//driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("Myemail");
		//driver.findElement(By.linkText("Forgot account?")).click();
		//driver.findElement(By.xpath("//input[contains(@id,'u_0')]")).click();
		//driver.findElement(By.cssSelector("input#u_0_2")).click();
		//driver.findElement(By.cssSelector("input[id*='u_0_2']")).click();
		//driver.findElement(By.cssSelector("input[value='Log In']")).click();
		//driver.findElement(By.xpath("//input[@id=\'lst-ib\']")).sendKeys("test01");
		//driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Name");		
		//System.setProperty("webdiver.chrome.driver", "")
		
			
		//driver.findElement(By.xpath("//*[@id=\'loginbutton\']")).click();
		//System.out.println(driver.findElement(By.xpath("//*[@id=\'globalContainer\']/div[3]/div")).getText());
		//div[@class='lst-ib']/div/div(2)/div/input
		
		
		
		//driver.close();
		 
		 
	}

}
  