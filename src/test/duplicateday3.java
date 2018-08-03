package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class duplicateday3 {
	@BeforeClass
	public void befoclass()
	{
		System.out.println("ok good untill here");
	}
	
@Parameters({"URL","APIKey/username"})
	@Test
	public void Weblogincar (String urlName, String key) 
	{
		System.out.println("print weblogincar");
		System.out.println(urlName);
		System.out.println(key);
	}
	
	
	public void BFsuite() 
	{
		System.out.println("I am No 1");

	}
	@Test(dataProvider= "getData")
	public void Mobilelogincarloan(String username, String password)
	{
		System.out.println(username);
		System.out.println(password);
		System.out.println("smoke3");
	}
	
	@AfterTest
	public void LoginAPIcarLoan() 
	{
		System.out.println("Aftertest");
	}
	@DataProvider
	public Object[][] getData()
	{
		//1st combination  - username password good credit history
		//2nd username password bad credit history 
		//3rd fraduelent credity history 
		Object [][] data=new Object[3][2];//3 row and 2 colunm
		//1st
		data[0][0]= "firstsetusername";
		data[0][1]= "firstpassword";
		//columns in the row are values for that particular combination(row)
		//2nd
		data[1][0]= "secondsetusername";
		data[1][1]= "secondpassword";
		//3rd
		data[2][0]= "Thirdsetusername";
		data[2][1]= "Thirdpassword";
		return data;
				
		
		
	}
	
}
