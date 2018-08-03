package Indeed;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://path2usa.com/travel-companions");
		
		//pick May 10 as a date
		driver.findElement(By.id("travel_date")).click();
		
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-switch']")).getText().contains("May"))
		{
			driver.findElement(By.cssSelector("[class='next']")).click();
		}
		List<WebElement> dates = driver.findElements(By.className("day"));

		
		System.out.println(dates);
		
		int count = driver.findElements(By.className("day")).size();
		for(int i=0;i<count; i++) 
		{
			String text =driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("10"))
			{	
				driver.findElements(By.className("day")).get(i).click();
				break;
				
								
			}
		}
	}
	}
			
		
		
	
///html/body/div[4]/div[1]/table/tbody/tr[4]/td[6]
///html/body/div[4]/div[1]/table/tbody/tr[1]/td[6]