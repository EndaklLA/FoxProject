package Indeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/dropppable/");
		
		driver.findElement(By.xpath(.))
		
		//click inside a frame
		driver.switchTo().frame(driver.findElement(By.xpath(xpathExpression)));  
		driver.findElement(By.xpath(xpathExpression))).click
		
		//drag and drop 
		Actions a =new actions (driver);
		WebElement source =driver.findElement(By.id("Draggable"));
		WebElement target =driver.findElement(By.id("Droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
	}

}
