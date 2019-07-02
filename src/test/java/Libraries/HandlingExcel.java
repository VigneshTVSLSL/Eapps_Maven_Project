package Libraries;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HandlingExcel {

	public String getDataFromExcel(String filePath, String sheetName, int rowNum, int colNum)
			throws EncryptedDocumentException, IOException

	{

		FileInputStream excelFiS = new FileInputStream(filePath);
		Workbook excelWorkBook = WorkbookFactory.create(excelFiS);

		String cellValue = excelWorkBook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellValue;

	}
}
