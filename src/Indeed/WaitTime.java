package Indeed;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


    public class WaitTime {
	public static void main(String[] args) throws InterruptedException {
	
		
	
		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.bookit.com");
		System.out.println(driver.getTitle());
		
		String x = driver.findElement(By.xpath("//*[@id='ember566']/div")).getAttribute("class");
		System.out.println(x);
		if (x.equals("trip-select c green-bg")) {
		driver.findElement(By.xpath("//*[@id='ember566']/div")).click();
		
		}
		
		
		//driver.findElement(By.xpath("//*[@id='ember568']/div")).click();
		System.out.println("Here");
	
		Select s = new Select(driver.findElement(By.xpath("//*[@name='rm']")));
		s.selectByValue("3");
		System.out.println("room selected");
		
		driver.findElement(By.xpath("//input[@id=\"ember578-inpu']")).sendKeys("Los Angeles");
		driver.findElement(By.xpath("//*[@id=\"ember526\"]/div/div/div[7]/div[1]/div/div[2]/button/span[1']")).click();
			
		
		WebDriverWait d=new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='15409084\']/div[2]/div/a"))).click();
		
	    //driver.findElement(By.xpath("//*[@id='15409084\']/div[2]/div/a")).click();
		
		//*[@id="15409084"]/div[2]/div/a
		
		Thread.sleep(5000L);
		//driver.findElement(By.xpath("//*[@id='hotel-name']")).getText();
		//Thread.sleep(5000L);
		System.out.println(driver.getWindowHandles());
		//System.out.println(driver.findElement(By.xpath("//*[@id='hotel-name']")).getText());
		
		
		/*driver.findElement(By.xpath("//input[@id='fromCity1']")).sendKeys("Los Angeles, CA (All Airports)");
		driver.findElement(By.xpath("//input[@id='toCity1']")).sendKeys("Miami, FL (MIA-Miami Intl.)");     
		driver.findElement(By.xpath("//input[@id='toCity1']")).sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//input[@id='departureDate1']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='returnDate']")).sendKeys(Keys.TAB);
		//driver.findElement(By.xpath("//input[@id='advanced-search-form\']/div[4]/div[1]/span/div/svg/path']")).sendKeys(Keys.TAB);
		//driver.findElement(By.xpath("//input[@id='advanced-search-form\']/div[4]/div[2]/span/div/svg']")).sendKeys(Keys.TAB);
		//System.out.println("No");
		driver.findElement(By.xpath("//*[@id='adultCount']")).sendKeys(Keys.TAB);
		//driver.findElement(By.xpath("//a[@id='advanced-search-form\"]/div[5]/div[2]/div/label/a']")).sendKeys(Keys.TAB);
		//System.out.println("Right");
		//driver.findElement(By.xpath("//*[@id='childrenCountDropDown\"]/div']")).sendKeys(Keys.TAB);
		//*[@id="childrenCountDropDown"]/div
		
		System.out.println("Yes");
		driver.findElement(By.xpath("//input[@id='findFlights']")).sendKeys(Keys.ENTER);*/	
		
		//Find airline tickets, low airfares, and discount flights | Alaska Airlines
		//Find cheap airline tickets and more - book today | Alaska Airlines
			
	Thread.sleep(10000L);
	System.out.println(driver.getTitle());
	driver.close();

		

	}
    }
		