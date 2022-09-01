package Test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basic1 {

	
	@BeforeSuite
	public void onceAgain()
	{
		System.out.println("Again before suite");
	}
	
	@AfterSuite
	public void onceAfter()
	{
		System.out.println("Again After suite");
	}
	
	@BeforeTest
	public void secondBefore()
	{
		System.out.println("Again Before Test");
	}
	
	@AfterTest
	public void secondAfter()
	{
		System.out.println("Again After Test");
	}
	
	@Test(priority=1)
	public void demo() throws InterruptedException {
		// TODO Auto-generated method stub
			System.out.println("Hello");
			Thread.sleep(2000);
			Assert.fail();
			System.out.println("failed");
	}
	
	@Test(priority=2)
	public void eem()
	{
		System.out.println("Byeee");
	}

}
