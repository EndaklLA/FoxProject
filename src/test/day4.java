package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day4 {
	
	@Test
	public void WebloginHomeLoan () 
	{
		System.out.println("smoke4");
	}
	
	@Test
	public void MobileloginHomeLoan()
	{
		System.out.println("MobileloginHomeLoan");
	}
	@Test
	public void befofevery()
	{
		System.out.println("beforemethod");

	}
	//skip this test case
	//@Test(enabled=false)

	
	@Test
			public void LoginAPIHomeLoan() 
	{
		System.out.println("LoginAPIHomeLoan");
	}
}
