package Indeed;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.TakesScreenshot;


public class Tableexercises {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	int sum=0;
		System.setProperty("webdriver.chrome.driver", "C:\\softwaredistribution\\workspace\\EndalkFox\\Config\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//deleting cookies
		driver.manage().deleteAllCookies();
		
		//Writting Dynamic xpath
		//starts-with(@attribute,'value')...("//input[contains(@name,'lastname')]")
		//ends-with(@attribute,'value')
		//contains-with(@attribute,'value')
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20483/vkv-vs-madurai-15th-match-tamil-nadu-premier-league-2018");
	
		//screenshoot
		File src=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\softwaredistribution\\Endalk\\screenshots.png"));
		
		//to close excel
		WindowsUtils.killByName("excel.exe");
		
		//access to entire table
		WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		//counting row
		int rowcount=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		//System.out.println(rowcount);
		
		int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		
		for(int i=0;i<count-2;i++)
		{
		String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
		int valueinteger= Integer.parseInt(value);	
		sum = sum + valueinteger;
		}
		String Extras =driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
	
		int Extravalues =Integer.parseInt(Extras);
		int TotalSumValue = sum+Extravalues;
		
		System.out.println(TotalSumValue);
		String finalresult=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int Endalkvalue =Integer.parseInt(finalresult);
		
		if(Endalkvalue==TotalSumValue) 
		{
			System.out.println("it worked");
		}
		else 
		{
			System.out.println("failed");
		}
		}
		}
