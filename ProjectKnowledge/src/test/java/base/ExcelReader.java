package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	int num;
	XSSFWorkbook xl;

	public ExcelReader() throws IOException {
		FileInputStream fs = new FileInputStream(
				"C:\\Users\\Admin\\Selenium Projects\\ProjectKnowledge\\src\\test\\resources\\Excel\\Testdata.xlsx");
		xl = new XSSFWorkbook(fs);
		// String ad[][]=new String[2][3];
		num = xl.getNumberOfSheets();
	}

	public int getRowCount() {
		int rcnt = 0;
		for (int i = 0; i < num; i++) {
			if (xl.getSheetName(i).equalsIgnoreCase("Data")) {
				XSSFSheet ss = xl.getSheetAt(i);
				Iterator<Row> rows = ss.rowIterator();

				while (rows.hasNext()) {
					rows.next();
					rcnt++;

				}

			}
		}
		return rcnt;

	}

	public int getColCount() {
		int ccnt = 0;
		for (int i = 0; i < num; i++) {
			if (xl.getSheetName(i).equalsIgnoreCase("Data")) {
				XSSFSheet ss = xl.getSheetAt(i);
				Iterator<Row> rows = ss.rowIterator();

				Row frow = rows.next();
				Iterator<Cell> cc = frow.cellIterator();
				while (cc.hasNext()) {
					cc.next();
					ccnt++;
				}

			}
		}
		return ccnt;

	}

	public String getCellValue() {
		String val=null;
		for (int i = 0; i < num; i++) {
			if (xl.getSheetName(i).equalsIgnoreCase("Data")) {
				XSSFSheet ss = xl.getSheetAt(i);
				Iterator<Row> rows = ss.rowIterator();

				Row frow = rows.next();
				Iterator<Cell> cc = frow.cellIterator();
				while (cc.hasNext()) {

					Cell value = cc.next();

					while (rows.hasNext()) {
						Row srow = rows.next();
						Iterator<Cell> cd = srow.cellIterator();
						while (cd.hasNext()) {
							Cell u = cd.next();
							if (u.getCellType() == CellType.STRING) {
								val = u.getStringCellValue();
								return val;
							} else {
								val = NumberToTextConverter.toText(u.getNumericCellValue());
								return val;
							}
						}

					}
				}

			}
		}
		return val;

	}
	
	public static void main(String args[]) throws IOException
	{
		ExcelReader e=new ExcelReader();
		System.out.println(e.getCellValue());
		System.out.println(e.getCellValue());
		
	}

	

}
