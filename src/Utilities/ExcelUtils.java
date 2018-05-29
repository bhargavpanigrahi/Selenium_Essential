package Utilities;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// public static WebDriver driver;
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	// public static XSSFRow row = null;
	public static XSSFRow headerRow;
	public static XSSFCell cell = null;
	public static int lastrow;

	public static String getCellData(String xlFilePath, String sheetName, String colName, int rowNum) {
		try {

			fis = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(fis);
			fis.close();
			int col_Num = -1;
			sheet = workbook.getSheet(sheetName);
			lastrow = sheet.getLastRowNum();
			Iterator<Row> rowIterator = sheet.iterator();
			// row = sheet.getRow(0);
			
			if (rowIterator.hasNext()) {
				headerRow = (XSSFRow) rowIterator.next();
				if (headerRow != null) {

					for (int i = 0; i < headerRow.getLastCellNum(); i++) {
						if (headerRow.getCell(i).getStringCellValue().trim().equals(colName.trim()))

							col_Num = i;
					}

				}
			}
			headerRow = sheet.getRow(rowNum);
			cell = (XSSFCell) headerRow.getCell(col_Num);
			// System.out.println(cell.getStringCellValue());
			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist  in Excel";
		}

	}

}
