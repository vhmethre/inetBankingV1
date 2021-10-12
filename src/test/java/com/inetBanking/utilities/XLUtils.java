package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class XLUtils {

	public static FileInputStream fi;
	public static Workbook wb;
	
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fo;

	public static int getRowCount(String xlfile, String xlsheet ) throws EncryptedDocumentException, IOException {
		fi = new FileInputStream(xlfile);
		wb = WorkbookFactory.create(fi);
		sh = wb.getSheet(xlsheet);
		int rowcount = sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum)
			throws EncryptedDocumentException, IOException {

		fi = new FileInputStream(xlfile);
		wb = WorkbookFactory.create(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		int cellcount = row.getLastCellNum();

		wb.close();
		fi.close();
		return cellcount;

	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum)
			throws EncryptedDocumentException, IOException {
		fi = new FileInputStream(xlfile);
		wb = WorkbookFactory.create(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws EncryptedDocumentException, IOException {
		fi = new FileInputStream(xlfile);
		wb = WorkbookFactory.create(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
}
