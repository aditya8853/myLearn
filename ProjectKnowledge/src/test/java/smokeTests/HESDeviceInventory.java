package smokeTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class HESDeviceInventory extends BaseTest {

	
	@Test
	public void getDevice() throws InterruptedException
	{
		driver.get(prop.getProperty("Hesurl"));
		//log.debug("Inside Test");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(OR.getProperty("btl"))).click();
		//log.debug("Clicked Manager");
		
	}
}
