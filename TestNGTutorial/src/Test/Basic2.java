package Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic2 {

	@BeforeSuite
	public void veryFirst()
	{
		System.out.println("First of all");
	}
	
	@AfterSuite
	public void veryLast()
	{
		System.out.println("After all");
		System.out.println("Git test");
	}
	
	
	@BeforeMethod
	public void frequent()
	{
		System.out.println("Everytime before");
	}
	
	@AfterMethod
	public void frequent2()
	{
		System.out.println("Everytime after");
	}
	
	
	@Test(dataProvider="getData")
	public void perform(String unname, String password)
	{
		System.out.println(unname);
		System.out.println(password);
	}
	
	@Parameters({"URL","UName"})
	@Test(timeOut=400)
	public void carLoan(String url, String name)
	{
		System.out.println("carloan");
		System.out.println(url);
		System.out.println(name);
		//Assert.fail();
	}
	
	
	@Test(dependsOnMethods="carLoan", alwaysRun=true)
	public void bikeLoan()
	{
		System.out.println("bikeloan");
	}
	
	
	@Test(groups="Smoke")
	public void truckLoan()
	{
		System.out.println("TruckLoan");
	}
	
	@BeforeTest
	public void preRequisite()
	{
		System.out.println("BeforeTest");
	}
	
	@AfterTest
	public void post()
	{
		System.out.println("After Test");
	}
	
	@DataProvider(parallel=true)
	public String[][] getData()
	{
		String[][] data=new String[3][2];
		data[0][0]="FirstName";
		data[0][1]="Pass1";
		
		
		data[1][0]="SecondName";
		data[1][1]="Pass2";
		
		
		data[2][0]="ThirdName";
		data[2][1]="Pass3";
		
		return data;
	}
}
