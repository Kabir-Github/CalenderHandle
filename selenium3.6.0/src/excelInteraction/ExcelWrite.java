/**
 * 
 */
package excelInteraction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * How to write to Excel
 *
 */
public class ExcelWrite {
	public static void main(String[] args) throws IOException {
		File file = new File("F://test.xlsx");
		FileOutputStream file1 = new FileOutputStream(file);
		XSSFWorkbook b = new XSSFWorkbook();
		XSSFSheet sheet = b.createSheet("Hello");
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Kabir");

		Cell cell2 = row1.createCell(1);
		cell2.setCellValue(100);

		b.write(file1);
		b.close();
		System.out.println("Writing complete");
	}

}
