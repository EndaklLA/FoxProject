package Indeed;


import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin");
		driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/content/div/div/div/div/a/content/span")).click();
		
		
		Set<String>ids=driver.getWindowHandles();	
		Iterator<String> it=ids.iterator();
		
		String parentid=it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);		
		
		
	}

}
