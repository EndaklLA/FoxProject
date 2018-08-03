
package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class DatadrivenTest {
	public WebDriver driver=null;
	
	
	@Test
	public  void login() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\softwaredistribution\\workspace\\TestNGProject\\src\\datadriven\\datadriven.properties");
		
		prop.load(fis);		
		
		//System.out.println(prop.getProperty("username"));
		if(prop.getProperty("Browser").contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(prop.getProperty("Browser").equals("firefox"))
		{
			driver = new ChromeDriver();	
		}
		else
		{
			 driver = new InternetExplorerDriver();
		}
			
		driver.get(prop.getProperty("URL"));
		
		//driver.findelement(By.xpath:').sendkeys(username)
		
	 }
		

}


