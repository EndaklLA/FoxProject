package Indeed;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Give me the count of links on the page
		
		
		driver.get("http://qaclickacademy.com/practice.php");
		//entire pg
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//find links in the footer
		
		//bottome page
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));	
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
				
		//one column
		WebElement Endalk=footerdriver.findElement(By.xpath("//table//tbody//tr//td[1]//ul"));
		System.out.println(Endalk.findElements(By.tagName("a")).size());
		
		//click on each link and check if the pages are opening and grab the title
		
		for(int i=1;i<Endalk.findElements(By.tagName("a")).size();i++)
		{
			String Clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			Endalk.findElements(By.tagName("a")).get(i).sendKeys(Clickonlink);
			
		}	//open all the tabs
			//Thread.sleep(5000L);
			Set<String> nameWindows=driver.getWindowHandles();
			System.out.println(nameWindows);
			Iterator<String> it = nameWindows.iterator();
			
			while(it.hasNext())
			{
		
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
			
	}
 
}
