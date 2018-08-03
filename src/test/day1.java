package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class day1{
		
		@Test
		public void demo() 
		{
			System.out.println("Hello-World");
			Assert.assertTrue(false);
		}
		
		@Test
		public void AFsuite() {
			System.out.println("The last person");

		}
		@Test
		public void SecondTest() 
		{
			System.out.println("Aftertest00");
		}
		
	}
