package smokeTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.BaseTest;
import base.ExcelReader;

public class HESCellularMonitoring extends BaseTest {

	
	public static  Logger log=LogManager.getLogger(HESCellularMonitoring.class.getName());
	
	@Test(dataProvider="getData")
	public void hesCheck(String fname, String lname, String pin) throws InterruptedException
	{
		driver.get(prop.getProperty("Hesurl"));
		log.debug("Inside Test");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(OR.getProperty("btl"))).click();
		log.debug("Clicked Manager");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty("add"))).isDisplayed());
		driver.findElement(By.xpath(OR.getProperty("add"))).click();
		
		driver.findElement(By.cssSelector(OR.getProperty("fname"))).sendKeys(fname);
		driver.findElement(By.cssSelector(OR.getProperty("lname"))).sendKeys(lname);
		driver.findElement(By.cssSelector(OR.getProperty("pin"))).sendKeys(pin);
		Thread.sleep(2000);
		//Assert.fail();
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException
	{
		ExcelReader rc=new ExcelReader();
		String [][] ad=new String[rc.getRowCount()-1][rc.getColCount()-1];
		
		
		for(int i=0;i<rc.getRowCount()-1;i++)
		{
			for(int j=0;j<rc.getColCount()-1;j++)
			{
				ad[i][j]=rc.getCellValue();
			}
		}
		/*for(int i=0;i<num;i++)
		{
			if(xl.getSheetName(i).equalsIgnoreCase("Data"))
			{
				XSSFSheet ss=xl.getSheetAt(i);
				Iterator<Row> rows=ss.rowIterator();
				
				Row frow=rows.next();
				
				Iterator<Cell> cc=frow.cellIterator();
				
			
				int r=0,c=0;
				while(cc.hasNext())
				{
					Cell value=cc.next();
					
						while(rows.hasNext())
						{
						Row srow=rows.next();
						Iterator<Cell> cd=srow.cellIterator();
						while(cd.hasNext())
						{
							Cell u=cd.next();
							if(u.getCellType()==CellType.STRING)
							{
								ad[r][c]=u.getStringCellValue();
								c++;
							}
							else
							{
								ad[r][c]=NumberToTextConverter.toText(u.getNumericCellValue());
								c++;
							}
						}
						c=0;
						//System.out.println(c);
						//System.out.println(cd.next());
						r++;
						}
					}
						
				}
				
				
			}*/
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.println(ad[i][j]);
			}
		}
		
		
		return ad;
		
	}
}
