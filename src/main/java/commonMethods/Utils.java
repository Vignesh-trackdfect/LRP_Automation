package commonMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import atu.testng.reports.ATUReports;

public class Utils {
	public static ExtentTest test;
	public static ExtentTest test1;

	// public static String
	// testDataFile=System.getProperty("user.dir")+"/data/TestData/FlipTestData";
	// public static String testDataFile=getDataFromTestConfig("Test Data Path");
	public static String getDataFromTestData(String autoTestCaseNameVal, String label, String sheetno) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(sheetno);
			int rowNum = ws.getLastRowNum() + 1;

			Iterator rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}
			for (int index = 0; index < rowNum; index++) {

				XSSFRow row = ws.getRow(index);
				XSSFCell cell = row.getCell(0);
				String cellVal = cellToString(cell);
				// System.out.println(cellVal);
				if (cellVal.equals(autoTestCaseNameVal)) {
					// System.out.println("Entered"+cellVal+"Row Index:"+index);
					for (int cellIndex = 1; cellIndex < numberOfCells; cellIndex++) {
						XSSFCell findLable = row.getCell(cellIndex);
						String labelString = cellToString(findLable);
						if (labelString.equals(label)) {
							// System.out.println("Cell Index: "+cellIndex);
							XSSFRow nextRow = ws.getRow(index + 1);
							XSSFCell adjacentRowCell = nextRow.getCell(cellIndex);
							String adjacentRowCellVal = cellToString(adjacentRowCell);
							// System.out.println("Cell Val: "+adjacentRowCellVal);
							requiredCellVal = adjacentRowCellVal;
							break;
						}
					}

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requiredCellVal.trim();
	}

	// EMS Module Utils
	public static String getDataFromTestData_EMS(String autoTestCaseNameVal, String label, String sheetno) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/TestData_EMS.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(sheetno);
			int rowNum = ws.getLastRowNum() + 1;

			Iterator rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}
			for (int index = 0; index < rowNum; index++) {

				XSSFRow row = ws.getRow(index);
				XSSFCell cell = row.getCell(0);
				String cellVal = cellToString(cell);
				// System.out.println(cellVal);
				if (cellVal.equals(autoTestCaseNameVal)) {
					// System.out.println("Entered"+cellVal+"Row Index:"+index);
					for (int cellIndex = 1; cellIndex < numberOfCells; cellIndex++) {
						XSSFCell findLable = row.getCell(cellIndex);
						String labelString = cellToString(findLable);
						if (labelString.equals(label)) {
							// System.out.println("Cell Index: "+cellIndex);
							XSSFRow nextRow = ws.getRow(index + 1);
							XSSFCell adjacentRowCell = nextRow.getCell(cellIndex);
							String adjacentRowCellVal = cellToString(adjacentRowCell);
							// System.out.println("Cell Val: "+adjacentRowCellVal);
							requiredCellVal = adjacentRowCellVal;
							break;
						}
					}

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requiredCellVal.trim();
	}

	public static String getDataFromTestConfig(String component) {
		String requiredCellVal = "";
		try {
			// FileInputStream fis = new
			// FileInputStream(System.getProperty("user.dir")+"/data/TestConfiguration.xlsx");
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/TestConfiguration.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			int rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}

			for (int index = 0; index < rowNum; index++) {
				XSSFRow row = ws.getRow(index);

				for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) {
					XSSFCell cell = row.getCell(cellIndex);
					String cellVal = cellToString(cell);
					if (cellVal.equals(component)) {
						XSSFCell adjacentCell = row.getCell(cellIndex + 1);
						String adjacentCellVal = cellToString(adjacentCell);
						requiredCellVal = adjacentCellVal;
						break;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return requiredCellVal;
	}

	public static String cellToString(XSSFCell cell) {
		int type;
		String result;
		type = cell.getCellType();

		switch (type) {

		case Cell.CELL_TYPE_NUMERIC: // numeric value in Excel
			result = "" + cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA: // precomputed value based on formula
			result = "" + cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_STRING: // String Value in Excel
			result = "" + cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BLANK:
			result = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN: // boolean value
			result = "" + cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_ERROR:
			result = "Error";
		default:
			throw new RuntimeException("There is no support for this type of cell");
		}

		return result.toString();
	}

	@Test
	public static String multipleDataExecution(String Path, int ColumnNum, int RowNum) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(Path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			int rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}
			for (int index = 0; index < rowNum; index++) {
				XSSFRow row = ws.getRow(index);
				for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) {
					XSSFCell cell = row.getCell(cellIndex);
					try {
						String cellVal = cellToString(cell);
						if ((cellIndex == ColumnNum) && (index == RowNum)) {
							XSSFCell adjacentCell = row.getCell(cellIndex);
							String adjacentCellVal = cellToString(adjacentCell);

							requiredCellVal = adjacentCellVal;
							break;
						}
					} catch (NullPointerException w) {
						requiredCellVal = "";
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return requiredCellVal;
	}

	public static int getNoOfRows(String Path) {
		int rowNum = 0;
		try {
			FileInputStream fis = new FileInputStream(Path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			rowNum = ws.getLastRowNum() + 1;

			java.util.Iterator<Row> rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			/*
			 * if (rowIterator.hasNext()) { Row headerRow = (Row) rowIterator.next(); //get
			 * the number of cells in the header row numberOfCells =
			 * headerRow.getLastCellNum(); } for (int index = 0; index < rowNum; index++) {
			 * XSSFRow row = ws.getRow(index); for(int cellIndex=0; cellIndex<numberOfCells;
			 * cellIndex++) { XSSFCell cell = row.getCell(cellIndex);
			 * 
			 * XSSFCell adjacentCell = row.getCell(cellIndex); String adjacentCellVal =
			 * cellToString(adjacentCell); requiredCellVal = adjacentCellVal;
			 * System.out.println(requiredCellVal+"requiredCellVal");
			 * 
			 * }
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowNum;
	}

	public List<String> getdata(String Testcasename, String Sheetname, String testcasecolumn,
			String conditioncolumnname, String data) {

		String excelFilePath = System.getProperty("user.dir") + "//data//TestExecution.xlsx";

		List<String> testCaseData = new ArrayList<>();

		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(Sheetname);

			// Create a map to store column names and their corresponding indices
			Map<String, Integer> columnIndices = new HashMap<>();

			// Assuming the first row is the header
			Row headerRow = sheet.getRow(0);
			if (headerRow != null) {
				for (Cell cell : headerRow) {
					columnIndices.put(getCellValueAsString(cell), cell.getColumnIndex());
				}
			}

			// Iterate through each row in the sheet, starting from the second row
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				// Get cells by column names
				Cell testCaseCell = row.getCell(columnIndices.get(testcasecolumn));
				Cell conditionCell = row.getCell(columnIndices.get(conditioncolumnname));
				Cell dataCell = row.getCell(columnIndices.get(data));

				// Check if the cells are not null and the condition is "yes"
				if (testCaseCell != null && conditionCell != null && dataCell != null
						&& "yes".equalsIgnoreCase(getCellValueAsString(conditionCell))) {
					String testCaseName = getCellValueAsString(testCaseCell);
					String dataValue = getCellValueAsString(dataCell);

					// Add the data value to the corresponding test case list
					if (Testcasename.equalsIgnoreCase(testCaseName)) {
						testCaseData.add(dataValue);
					}
				}
			}

			// Close the workbook and input stream
			workbook.close();
			fis.close();

			// Print the lists (for testing purposes)
			System.out.println("Test Case Data: " + testCaseData);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return testCaseData;
	}

	public static String getCellValueAsString(Cell cell) {
		switch (cell.getCellTypeEnum()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "";
		}
	}

	public static Properties readproperties() throws Exception {
		FileInputStream file;
		Properties prop = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/data/Properties.properties");
			prop = new Properties();
			prop.load(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return prop;

	}

	public static String getproperties(String key) throws Exception {
		Properties prop = readproperties();
		return prop.getProperty(key).toString();
	}

	static HashMap<String, String> values1;

	public static HashMap<String, String> Getdatavalue(String sheetName, String Fieldname, String Datacolumn,
			String Filename) {

		values1 = new HashMap<String, String>();

		String filepath = "./data/" + Filename + ".xlsx";

		try (FileInputStream file = new FileInputStream(filepath);

				Workbook workbook = new XSSFWorkbook(file)) {

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet " + sheetName + " not found in the file.");
			}

			// Get the header row
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				throw new IllegalArgumentException("Sheet " + sheetName + " has no header row.");
			}

			// Create a map of column names to indices
			Map<String, Integer> columnIndices = new HashMap<>();
			for (Cell cell : headerRow) {
				columnIndices.put(cell.getStringCellValue(), cell.getColumnIndex());
			}

			// Get the indices of the key and locator columns
			Integer keyColumnIndex = columnIndices.get(Fieldname);
			Integer locatorColumnIndex = columnIndices.get(Datacolumn);

			if (keyColumnIndex == null || locatorColumnIndex == null) {
				throw new IllegalArgumentException("One or both of the specified column names were not found.");
			}

			// Iterate over the rows to extract the key-locator pairs
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row != null) {
					Cell keyCell = row.getCell(keyColumnIndex);
					Cell locatorCell = row.getCell(locatorColumnIndex);

					if (keyCell != null && locatorCell != null) {
						String key = keyCell.getStringCellValue();
						String locator = locatorCell.getStringCellValue();
						values1.put(key, locator);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return values1;
	}

	public static Map<String, String> GetAllData(String sheetName, String Fieldname, String Datacolumn,
			String Filename) {
		Map<String, String> dataMap = new HashMap<>();
		String filepath = "./data/" + Filename + ".xlsx";
		Fillo fillo = new Fillo();
		Connection connection = null;
		Recordset recordset = null;

		try {
			connection = fillo.getConnection(filepath);
			String query = String.format("SELECT %s, %s FROM %s", Fieldname, Datacolumn, sheetName);
			recordset = connection.executeQuery(query);

			while (recordset.next()) {
				String key = recordset.getField(Fieldname);
				String value = recordset.getField(Datacolumn);
				dataMap.put(key, value);
			}
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			if (recordset != null) {
				recordset.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return dataMap;
	}

	public static Connection loadExcel(String fileName) {
		String filepath = "./data/" + fileName + ".xlsx";
		Fillo fillo = new Fillo();
		try {
			return fillo.getConnection(filepath);
		} catch (FilloException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Map<String, String> getDataAsMap(Connection connection, String sheetName, String keyColumn,
			String valueColumn) {
		Map<String, String> dataMap = new HashMap<>();
		Recordset recordset = null;

		try {
			String query = String.format("SELECT %s, %s FROM %s", keyColumn, valueColumn, sheetName);
			recordset = connection.executeQuery(query);

			while (recordset.next()) {
				String key = recordset.getField(keyColumn).trim();
				String value = recordset.getField(valueColumn);
				dataMap.put(key, value);
			}
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			if (recordset != null) {
				recordset.close();
			}
		}
		return dataMap;
	}

	public static void writeExcelValueByReferenceMap(String filePath, String targetColumnName,
			Map<String, String> refValueMap) {
		String filepath = "./data/" + filePath + ".xlsx";
		Fillo fillo = new Fillo();
		Connection connection = null;
		try {
			connection = fillo.getConnection(filepath);
			List<String> sheetNames = connection.getMetaData().getTableNames();

			for (String sheetName : sheetNames) {
				for (Map.Entry<String, String> entry : refValueMap.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();

					// Assuming first column name is "ID" — update this if needed
					String query = String.format("UPDATE %s SET %s = '%s' WHERE ID = '%s'", sheetName, targetColumnName,
							value, key);

					try {
						connection.executeUpdate(query);
					} catch (Exception e) {
						System.out.println(
								"⚠️ Error updating sheet: " + sheetName + ", Key: " + key + " ➜ " + e.getMessage());
					}
				}
			}

			System.out.println("✅ Excel updated successfully across all sheets using Fillo.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	 public static String extractReportData1(String filePath,String SheetName,String testCaseName, String reportColumn, String datasetName) {
	        StringBuilder result = new StringBuilder();
	        String filepath = "./data/" + filePath + ".xlsx";  
	        try (FileInputStream fis = new FileInputStream(filepath);
	             Workbook workbook = new XSSFWorkbook(fis)) {
	            Sheet sheet = workbook.getSheet(SheetName);

	            Row headerRow = sheet.getRow(0);

	            int testCaseCol = -1, reportCol = -1, datasetCol = -1;

	            // Find column indices
	            for (Cell cell : headerRow) {
	                String value = cell.getStringCellValue();
	                if (value.equalsIgnoreCase(testCaseName)) testCaseCol = cell.getColumnIndex();
	                else if (value.equalsIgnoreCase(reportColumn)) reportCol = cell.getColumnIndex();
	                else if (value.equalsIgnoreCase(datasetName)) datasetCol = cell.getColumnIndex();
	            }

	            if (testCaseCol == -1 || reportCol == -1 || datasetCol == -1) {
	                return "Column not found.";
	            }

	            // Iterate over rows and construct output
	            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue;

	                Cell reportCell = row.getCell(reportCol);
	                if (reportCell != null && "Yes".equalsIgnoreCase(reportCell.getStringCellValue())) {
	                    String fieldName = row.getCell(testCaseCol).getStringCellValue();
	                    Cell valueCell = row.getCell(datasetCol);
	                    String value = valueCell != null ? getCellValueAsString(valueCell) : "";
	                    result.append(fieldName).append(" : ").append(value).append("\n");
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error: " + e.getMessage();
	        }
	        return result.toString().trim();
	    }

	public static void writeOrUpdateExcelValue(String filePath, String sheetName, String keyColumnName,
			String valueColumnName, String key, String value) {
		String filepath = "./data/" + filePath + ".xlsx";
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			// Open existing file
			fis = new FileInputStream(filepath);
			workbook = WorkbookFactory.create(fis);
			fis.close(); // Close input stream early
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				sheet = workbook.createSheet(sheetName);
			}
			int keyColIndex = -1;
			int valueColIndex = -1;
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				headerRow = sheet.createRow(0);
			}
			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equalsIgnoreCase(keyColumnName)) {
					keyColIndex = cell.getColumnIndex();
				}
				if (cell.getStringCellValue().equalsIgnoreCase(valueColumnName)) {
					valueColIndex = cell.getColumnIndex();
				}
			}
			if (keyColIndex == -1) {
				keyColIndex = headerRow.getLastCellNum();
				if (keyColIndex < 0)
					keyColIndex = 0;
				headerRow.createCell(keyColIndex).setCellValue(keyColumnName);
			}
			if (valueColIndex == -1) {
				valueColIndex = headerRow.getLastCellNum();
				if (valueColIndex < 0)
					valueColIndex = 0;
				headerRow.createCell(valueColIndex).setCellValue(valueColumnName);
			}
			boolean isUpdated = false;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell keyCell = row.getCell(keyColIndex);
					if (keyCell != null && key.equalsIgnoreCase(keyCell.getStringCellValue())) {
						Cell valueCell = row.getCell(valueColIndex);
						if (valueCell == null) {
							valueCell = row.createCell(valueColIndex);
						}
						valueCell.setCellValue(value);
						isUpdated = true;
						break;
					}
				}
			}
			if (!isUpdated) {
				int newRowNum = sheet.getLastRowNum() + 1;
				Row newRow = sheet.createRow(newRowNum);
				newRow.createCell(keyColIndex).setCellValue(key);
				newRow.createCell(valueColIndex).setCellValue(value);
			}
			FileOutputStream fos = new FileOutputStream(filepath);
			workbook.write(fos);
			fos.close();
			workbook.close();
			System.out.println("Excel updated successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (workbook != null)
					workbook.close();
				if (fis != null)
					fis.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
