package foxProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataTable {

	private File inputFile = null;
	private FileInputStream inputStream = null;
	private XSSFWorkbook workbook = null;
	private String activeSheet;
	private ArrayList<String> columns = new ArrayList<String>();

	public DataTable(String fileName, String filePath) throws IOException {
		inputFile = new File(filePath + fileName);
		inputStream = new FileInputStream(inputFile);
		workbook = new XSSFWorkbook(inputStream);
	}

	public XSSFSheet getSheet() {
		return workbook.getSheet(activeSheet);
	}

	private XSSFRow readRow(int row) {
		return getSheet().getRow(row);
	}

	private XSSFRow writeRow(int row) {
		return getSheet().createRow(row);
	}

	public void setActiveSheet(String sheetName) {

		columns.clear();
		this.activeSheet = sheetName;
		Iterator<Cell> cellIter = workbook.getSheet(activeSheet).iterator().next().iterator();
		while (cellIter.hasNext())
			columns.add(cellIter.next().getStringCellValue());

	}

	public Sheet getActiveSheet() {
		return workbook.getSheet(activeSheet);
	}

	private int getColumn(String column) {
		return columns.indexOf(column);
	}

	public String getCellData(int row, String column) {

		return readRow(row).getCell(getColumn(column)).getStringCellValue();
	}

	public String getCellData(int row, int column) {
		return readRow(row).getCell(column).getStringCellValue();
	}

	public void setShowsData(int row, String column, String value) {

		// if(getActiveSheet().getRow(row).getFirstCellNum() != -1)
		// readRow(row).createCell(getColumn(column)).setCellValue(value);
		// else
		writeRow(row).createCell(getColumn(column)).setCellValue(value);
	}

	public void setOtherData(int row, String column, String value) {

		// if(getActiveSheet().getRow(row).getFirstCellNum() != -1)
		// System.out.println(row);
		System.out.println(getColumn(column));
		readRow(row).createCell(getColumn(column)).setCellValue(value);
		// else
		// writeRow(row).createCell(getColumn(column)).setCellValue(value);
	}

	public void closeDataFile() {

		try {
			FileOutputStream outputStream = new FileOutputStream(inputFile);
			workbook.write(outputStream);
			workbook.close();
			inputStream.close();
			outputStream.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
