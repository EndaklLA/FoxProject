package Indeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com/");
		
		/*Select s= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByVisibleText("USD");
		System.out.println("s");*/
		
		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		//driver.findElement(By.xpath("//a[@value='GOI']")).click();
		//driver.findElement(By.xpath("//*[@id='//*[@id=\'ctl00_mainContent_ddl_destinationStation1_CTXT\']")).click();
		//driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		//true false
		
		//Radio button
		/*int count = driver.findElements(By.xpath("add value here")).size()
				
		for (int i=0; i<count;i++)
			
		{
			String text = driver.findElements(By.xpath("add value here")).get(i).getAttribute("value");
			if (text.equals("Cheese"))
			{
				driver.findElements(By.xpath("add value here")).get(i).click();	
			}
		}*/
				
		
		
				
		

	}

}
