package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;


import smokeTests.HESCellularMonitoring;

public class BaseTest {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop,OR;
	
	
	@BeforeSuite
	public void initializeTest() throws IOException
	{
		if(driver==null)
		{
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
			prop=new Properties();
			prop.load(fis);
			//log.debug("File loaded");
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
			OR=new Properties();
			OR.load(fis);
			
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver","C:\\eclipse\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			//log.debug("Browser Opened");
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\Selenium Projects\\DataDrivenFramework\\src\\test\\resources\\executables\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicit.wait"))));
		
		
		
		
	}
	
	public void getScreen(String testName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\Reports\\"+testName+".png";
		FileUtils.copyFile(src, new File(dest));
		
	}
	
	@AfterSuite
	public void clearAll()
	{
		if(driver!=null)
		driver.quit();
	}
	
	
	
}

