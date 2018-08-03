package Indeed;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//enter the letters BNG 
//verify if airport option is displayed in the suggested box
public class Autosuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ksrtc.in/oprs-web/");
		

		driver.findElement(By.id("fromPlaceName")).sendKeys("Beng");
		Thread.sleep(10000L);
		
			//driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);	
			//driver.findElement(By.id("fromPlaceName")).click();
				
			System.out.println("done");
	
			/*driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);*/
				
		System.out.println(driver.findElement(By.xpath("//*[@id='fromPlaceName']")).getText());
	
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String script="return document.getElementById(\"fromPlaceName\").value;";
		String text=(String) js.executeScript(script);
		System.out.println(script);
		System.out.println(text);
		
		int i=0;
		//select airport
		while(!(text.equalsIgnoreCase("BENGALURU INTERNATION AIPORT"))) 
			
		{
			i++;
			System.out.println(text);
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);	
			
			text=(String) js.executeScript(script);
			System.out.println(text);
			if(i>10) 
			{
				break;
			}			
		}
		if(i>10) 
		{
			System.out.println("Element not found");
		}
		else	
		{
		System.out.println("Element found");
		}
	}
}

	