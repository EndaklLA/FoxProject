package Indeed;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a= new Actions(driver);
		WebElement move=driver.findElement(By.xpath("//*[@id='nav-link-accountList\']/span[2]"));
		
		//click on the edit box and type in all CAPS
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("endalk").doubleClick().build().perform();
		a.moveToElement(move).contextClick().build().perform();
		
		
		//hoover over 
		//a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList\']/span[2]"))).build().perform();
		
		
		
		
	
		//*[@id="nav-link-accountList"]/span[2]

	}

}
