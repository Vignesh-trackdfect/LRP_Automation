package commonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class TestNgXml {
	static String testCase_ID_Header = Utils.getDataFromTestConfig("Test_Case_ID_Header");
	static String url_Header = Utils.getDataFromTestConfig("Url_Header");
	static String DataSets_Header = Utils.getDataFromTestConfig("DataSet_Header");
	static String filepath_Header = Utils.getDataFromTestConfig("Excel_FileName_Header");
	static String Sheet_Names_Header = Utils.getDataFromTestConfig("Excel_Sheet_Names_Header");
	static String flag_Options_Header = Utils.getDataFromTestConfig("Flag_Option_Header");
	static String Priority_Header = Utils.getDataFromTestConfig("Priority_Header");
	static String testNG_xml_With_Script_Name_Option = Utils.getDataFromTestConfig("testNG_xml_With_Script_Name");
	static String Locator_Environment_Header = Utils.getDataFromTestConfig("Locator_Environment_Header");
	static String Locator_Environment_FilePath_Header = Utils
			.getDataFromTestConfig("Locator_Environment_FilePath_Header");

	public static String testExecutionFile = System.getProperty("user.dir")
			+ Utils.getDataFromTestConfig("TestExeFile");
	public static String testExecutionSheetName = Utils.getDataFromTestConfig("TestExeFileSheetName");
	Utils util = new Utils();

	public void testNgXmlSuite() {

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		List<XmlClass> classes = new ArrayList<XmlClass>();
		XmlSuite suite = new XmlSuite();
		suite.setName("ProgramSuite");
		XmlTest test = new XmlTest(suite);
		test.setName("ProgramTest");
		{
			XmlClass clss1 = new XmlClass("commonMethods.Testcases");
			classes.add(clss1);

		}

		test.setXmlClasses(classes);
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}

	static Map<String, Map<String, String>> testCaseData = new HashMap<>();

	public static void loadExecutionData() {
		List<String> TestcaseID = extractExcelContentByColumnHeader(testCase_ID_Header);
		List<String> Environment = extractExcelContentByColumnHeader(url_Header);
		List<String> DataSets = extractExcelContentByColumnHeader(DataSets_Header);
		List<String> FilePaths = extractExcelContentByColumnHeader(filepath_Header);
		List<String> SheetNames = extractExcelContentByColumnHeader(Sheet_Names_Header);
		List<String> Flags = extractExcelContentByColumnHeader(flag_Options_Header);
		List<String> LocatorEnvironments = extractExcelContentByColumnHeader(Locator_Environment_Header);
		List<String> LocatorEnvironmentFilePaths = extractExcelContentByColumnHeader(Locator_Environment_FilePath_Header);
		List<String> priorities = extractExcelContentByColumnHeader(Priority_Header);

		for (int i = 0; i < TestcaseID.size(); i++) {
			Map<String, String> data = new HashMap<>();
			data.put("Environment", Environment.get(i));
			data.put("DataSets", DataSets.get(i));
			data.put("FilePaths", FilePaths.get(i));
			data.put("SheetNames", SheetNames.get(i));
			data.put("Flags", Flags.get(i));
			data.put("LocatorEnvironments", LocatorEnvironments.get(i));
			data.put("LocatorEnvironmentFilePaths", LocatorEnvironmentFilePaths.get(i));
			data.put("Priorities", priorities.get(i));
			testCaseData.put(TestcaseID.get(i), data);
		}
	}

	private static boolean isDataLoaded = false;

	private static HashMap<String, String> getDataFromExecution(String keyName) {
		if (!isDataLoaded) {
			loadExecutionData(); // Only if NOT loaded
			isDataLoaded = true;
		}
		HashMap<String, String> result = new HashMap<>();
		for (String testCaseId : testCaseData.keySet()) {
			result.put(testCaseId, testCaseData.get(testCaseId).get(keyName));
		}
		return result;
	}

	// Now your methods exact names but internally optimized
	public static HashMap<String, String> getdatafromExecution() {
		return getDataFromExecution("Environment");
	}

	public static HashMap<String, String> getdataSet_fromExecution() {
		return getDataFromExecution("DataSets");
	}

	public static HashMap<String, String> getfilePath_FromExecution() {
		return getDataFromExecution("FilePaths");
	}

	public static HashMap<String, String> getsheetName_FromExecution() {
		return getDataFromExecution("SheetNames");
	}

	public static HashMap<String, String> getFlagValue_FromExecution() {
		return getDataFromExecution("Flags");
	}

	public static HashMap<String, String> LocatorEnvironmet_FromExecution() {
		return getDataFromExecution("LocatorEnvironments");
	}

	public static HashMap<String, String> LocatorEnvironmentFilePath_FromExecution() {
		return getDataFromExecution("LocatorEnvironmentFilePaths");
	}
	public static HashMap<String, Integer> getPriority_FromExecution() {
	    HashMap<String, Integer> priorityMap = new HashMap<>();
	    // Iterate through the test case data to get the priorities
	    for (String testCaseID : testCaseData.keySet()) {
	        Map<String, String> data = testCaseData.get(testCaseID);
	        String priorityStr = data.get("Priorities");
	        try {
	            int priority = Integer.parseInt(priorityStr); // Convert the priority to an integer
	            priorityMap.put(testCaseID, priority);
	        } catch (NumberFormatException e) {
	            e.printStackTrace(); // Handle invalid priority values (e.g., non-numeric)
	        }
	    }
	    return priorityMap;
	}
	// static HashMap<String, String> values;
	//
	// public static HashMap<String, String> getdatafromExecution() {
	// values = new HashMap<String, String>();
	// List<String> TestcaseID =
	// extractExcelContentByColumnHeader(testCase_ID_Header);
	// List<String> Environment = extractExcelContentByColumnHeader(url_Header);
	// for (int k = 0; k < TestcaseID.size(); k++) {
	// values.put(TestcaseID.get(k), Environment.get(k));
	// }
	// return values;
	// }
	//
	// static HashMap<String, String> data_Set;
	//
	// public static HashMap<String, String> getdataSet_fromExecution() {
	// data_Set = new HashMap<String, String>();
	// List<String> TestcaseID =
	// extractExcelContentByColumnHeader(testCase_ID_Header);
	// List<String> Environment =
	// extractExcelContentByColumnHeader(DataSets_Header);
	// for (int k = 0; k < TestcaseID.size(); k++) {
	// data_Set.put(TestcaseID.get(k), Environment.get(k));
	// }
	// return data_Set;
	// }
	//
	// static HashMap<String, String> file_Path;
	//
	// public static HashMap<String, String> getfilePath_FromExecution() {
	// file_Path = new HashMap<String, String>();
	// List<String> TestcaseID =
	// extractExcelContentByColumnHeader(testCase_ID_Header);
	// List<String> Environment =
	// extractExcelContentByColumnHeader(filepath_Header);
	// for (int k = 0; k < TestcaseID.size(); k++) {
	// file_Path.put(TestcaseID.get(k), Environment.get(k));
	// }
	// return file_Path;
	// }
	//
	// static HashMap<String, String> sheet_Name;
	//
	// public static HashMap<String, String> getsheetName_FromExecution() {
	// sheet_Name = new HashMap<String, String>();
	// List<String> TestcaseID =
	// extractExcelContentByColumnHeader(testCase_ID_Header);
	// List<String> Environment =
	// extractExcelContentByColumnHeader(Sheet_Names_Header);
	// for (int k = 0; k < TestcaseID.size(); k++) {
	// sheet_Name.put(TestcaseID.get(k), Environment.get(k));
	// }
	// return sheet_Name;
	// }
	//
	// static HashMap<String, String> flag;
	//
	// public static HashMap<String, String> getFlagValue_FromExecution() {
	// flag = new HashMap<String, String>();
	// List<String> TestcaseID =
	// extractExcelContentByColumnHeader(testCase_ID_Header);
	// List<String> Environment =
	// extractExcelContentByColumnHeader(flag_Options_Header);
	// for (int k = 0; k < TestcaseID.size(); k++) {
	// flag.put(TestcaseID.get(k), Environment.get(k));
	// }
	// return flag;
	// }
	// static HashMap<String, String> LocatorEnvironmet;
	//
	// public static HashMap<String, String> LocatorEnvironmet_FromExecution() {
	// LocatorEnvironmet = new HashMap<String, String>();
	// List<String> TestcaseID =
	// extractExcelContentByColumnHeader(testCase_ID_Header);
	// List<String> Environment =
	// extractExcelContentByColumnHeader(Locator_Environment_Header);
	// for (int k = 0; k < TestcaseID.size(); k++) {
	// LocatorEnvironmet.put(TestcaseID.get(k), Environment.get(k));
	// }
	// return LocatorEnvironmet;
	// }
	// static HashMap<String, String> LocatorEnvironmentFilePath;
	//
	// public static HashMap<String, String>
	// LocatorEnvironmentFilePath_FromExecution() {
	// LocatorEnvironmentFilePath = new HashMap<String, String>();
	// List<String> TestcaseID =
	// extractExcelContentByColumnHeader(testCase_ID_Header);
	// List<String> Environment =
	// extractExcelContentByColumnHeader(Locator_Environment_FilePath_Header);
	// for (int k = 0; k < TestcaseID.size(); k++) {
	// LocatorEnvironmentFilePath.put(TestcaseID.get(k), Environment.get(k));
	// }
	// return LocatorEnvironmentFilePath;
	// }

	public static void main(String args[]) throws MalformedURLException {
		if (testNG_xml_With_Script_Name_Option.equalsIgnoreCase("Yes")) {
			execution();
		} else {
			generateUpdatedXml();
		}
	}

	public static ArrayList<String> extractExcelContentByColumnIndex(int columnIndex) {
		ArrayList<String> columndata = null;
		try {
			File f = new File(testExecutionFile);
			FileInputStream ios = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheet(testExecutionSheetName);
			Iterator<Row> rowIterator = sheet.iterator();
			columndata = new ArrayList<String>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (row.getRowNum() > 0) {
						if (cell.getColumnIndex() == columnIndex) {
							switch (cell.getCellTypeEnum()) {
							case STRING:
								columndata.add(cell.getStringCellValue());
								break;
							case NUMERIC:
								columndata.add(String.valueOf(cell.getNumericCellValue()));
								break;
							// Add BOOLEAN, FORMULA, etc. if necessary
							}
						}
					}
				}
			}

			workbook.close();
			ios.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columndata;
	}
	//
	// public static ArrayList<String> extractExcelContentByColumnHeader(String
	// columnHeader) {
	// ArrayList<String> columnData = null;
	// try {
	// File f = new File(testExecutionFile);
	// FileInputStream ios = new FileInputStream(f);
	// XSSFWorkbook workbook = new XSSFWorkbook(ios);
	// XSSFSheet sheet = workbook.getSheet(testExecutionSheetName);
	// Iterator<Row> rowIterator = sheet.iterator();
	//
	// columnData = new ArrayList<String>();
	// int columnIndex = -1; // To store the column index based on the header
	//
	// // Read the first row (header row) to get the column index
	// if (rowIterator.hasNext()) {
	// Row headerRow = rowIterator.next();
	// Iterator<Cell> cellIterator = headerRow.cellIterator();
	// while (cellIterator.hasNext()) {
	// Cell cell = cellIterator.next();
	// if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	// if (cell.getStringCellValue().equalsIgnoreCase(columnHeader)) {
	// columnIndex = cell.getColumnIndex();
	// break;
	// }
	// }
	// }
	// }
	//
	// // If columnIndex is still -1, the column header was not found
	// if (columnIndex == -1) {
	// System.out.println("Column header not found: " + columnHeader);
	// return columnData; // Return empty list or handle error as needed
	// }
	//
	// // Now read data from the identified column
	// while (rowIterator.hasNext()) {
	// Row row = rowIterator.next();
	// Cell cell = row.getCell(columnIndex);
	// if (cell != null) {
	// if (row.getRowNum() > 0) { // Skip header row
	// switch (cell.getCellType()) {
	// case Cell.CELL_TYPE_NUMERIC:
	// columnData.add(cell.getNumericCellValue() + "");
	// break;
	// case Cell.CELL_TYPE_STRING:
	// columnData.add(cell.getStringCellValue());
	// break;
	// }
	// }
	// }
	// }
	//
	// workbook.close();
	// ios.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return columnData;
	// }

	static Map<String, ArrayList<String>> excelDataMap = new HashMap<>();
	static boolean isExcelLoaded = false;

	public static void loadExcelData() {
		if (isExcelLoaded) {
			return; // Already loaded, skip
		}

		try (FileInputStream ios = new FileInputStream(new File(testExecutionFile));
				XSSFWorkbook workbook = new XSSFWorkbook(ios)) {
			XSSFSheet sheet = workbook.getSheet(testExecutionSheetName);
			if (sheet == null) {
				System.out.println("Sheet not found: " + testExecutionSheetName);
				return;
			}
			ArrayList<String> headers = new ArrayList<>();
			Iterator<Row> rowIterator = sheet.iterator();
			if (rowIterator.hasNext()) {
				Row headerRow = rowIterator.next();
				for (Cell cell : headerRow) {
					headers.add(cell.getStringCellValue());
					excelDataMap.put(cell.getStringCellValue(), new ArrayList<>());
				}
			}
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				for (int i = 0; i < headers.size(); i++) {
					Cell cell = row.getCell(i);
					String value = "";
					if (cell != null) {
						switch (cell.getCellTypeEnum()) { // For older versions of POI
						case STRING:
							value = cell.getStringCellValue();
							break;
						case NUMERIC:
							value = String.valueOf(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							value = String.valueOf(cell.getBooleanCellValue());
							break;
						case FORMULA:
							value = cell.getCellFormula();
							break;
						default:
							value = "";
						}
					}
					excelDataMap.get(headers.get(i)).add(value);
				}
			}
			isExcelLoaded = true; // Mark as loaded

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> extractExcelContentByColumnHeader(String columnHeader) {
		loadExcelData(); // Ensure loaded before extracting
		return excelDataMap.getOrDefault(columnHeader, new ArrayList<>());
	}

	public static void execution() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// root element
			Element rootElement = doc.createElement("suite");
			doc.appendChild(rootElement);

			Attr suiteattr1 = doc.createAttribute("configfailurepolicy");
			suiteattr1.setValue("continue");
			rootElement.setAttributeNode(suiteattr1);

			Attr suiteattr2 = doc.createAttribute("name");
			suiteattr2.setValue("Suite");
			rootElement.setAttributeNode(suiteattr2);

			Attr suiteattr3 = doc.createAttribute("parallel");
			suiteattr3.setValue("none");
			rootElement.setAttributeNode(suiteattr3);

			Element test = doc.createElement("test");
			rootElement.appendChild(test);

			Attr testattr1 = doc.createAttribute("name");
			testattr1.setValue("Test");
			test.setAttributeNode(testattr1);

			Attr testattr2 = doc.createAttribute("preserve-order");
			testattr2.setValue("true");
			test.setAttributeNode(testattr2);

			if (Utils.getDataFromTestConfig("Execution Type").equalsIgnoreCase("parallel")) {

				Attr testattr3 = doc.createAttribute("parallel");
				testattr3.setValue("methods");
				test.setAttributeNode(testattr3);

				Attr testattr4 = doc.createAttribute("thread-count");
				testattr4.setValue(Utils.getDataFromTestConfig("ParallelTests").replace(".0", ""));
				test.setAttributeNode(testattr4);

			}
			;

			Element classes = doc.createElement("classes");
			test.appendChild(classes);

			Element class1 = doc.createElement("class");
			classes.appendChild(class1);

			Attr classattr1 = doc.createAttribute("name");
			classattr1.setValue("commonMethods.Testcases");
			class1.setAttributeNode(classattr1);

			Element methods = doc.createElement("methods");
			class1.appendChild(methods);

			// Step 1: Create data class
			class TestCaseData {
				String name;
				int priority;
				String flag;

				TestCaseData(String name, int priority, String flag) {
					this.name = name;
					this.priority = priority;
					this.flag = flag;
				}
			}

			// Step 2: Read values from Excel
			List<String> testCases = extractExcelContentByColumnHeader(testCase_ID_Header);
			List<String> flags = extractExcelContentByColumnHeader(flag_Options_Header);
			List<String> priorities = extractExcelContentByColumnHeader(Priority_Header);

			List<TestCaseData> testCaseDataList = new ArrayList<>();
			for (int i = 0; i < testCases.size(); i++) {
				try {
					int p = Integer.parseInt(priorities.get(i).replace(".0", "").trim());
					testCaseDataList.add(new TestCaseData(testCases.get(i), p, flags.get(i)));
				} catch (NumberFormatException e) {
					System.err.println("Invalid priority for test case: " + testCases.get(i));
				}
			}

			// Step 3: Sort by priority
			testCaseDataList.sort(Comparator.comparingInt(tc -> tc.priority));

			// Step 4: Generate <include> elements
			for (TestCaseData tc : testCaseDataList) {
				if (tc.flag.equalsIgnoreCase("Yes")) {
					Element include = doc.createElement("include");
					include.setAttribute("name", tc.name);
					include.setAttribute("priority", String.valueOf(tc.priority));
					methods.appendChild(include);
				}
			}

			Element listeners = doc.createElement("listeners");
			rootElement.appendChild(listeners);
			String noListeners[] = {};
			String mailListener[] = { "Mail.CustomTestListener" };

			String triggerValue = Utils.getDataFromTestConfig("Trigger");
			String[] listenersToAdd = triggerValue.equalsIgnoreCase("No") ? noListeners : mailListener;

			for (String listenerClass : listenersToAdd) {
				Element listener = doc.createElement("listener");
				listeners.appendChild(listener);
				listener.setAttribute("class-name", listenerClass);
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "\\testng.xml"));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generateUpdatedXml() {
		 try {
	            // Initialize the DocumentBuilder
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.newDocument();

	            // Root element
	            Element rootElement = doc.createElement("suite");
	            doc.appendChild(rootElement);

	            // Add suite attributes
	            rootElement.setAttribute("configfailurepolicy", "continue");
	            rootElement.setAttribute("name", "Suite");
	            rootElement.setAttribute("parallel", "none");

	            // Add test element
	            Element test = doc.createElement("test");
	            rootElement.appendChild(test);

	            // Add test attributes
	            test.setAttribute("name", "Test");
	            test.setAttribute("preserve-order", "true");

	            // Add classes element
	            Element classes = doc.createElement("classes");
	            test.appendChild(classes);

	            // Add class element for Testcases
	            Element classElement = doc.createElement("class");
	            classes.appendChild(classElement);
	            classElement.setAttribute("name", "commonMethods.Testcases");

	            // Add listeners element
	            Element listeners = doc.createElement("listeners");
	            rootElement.appendChild(listeners);

	            // Add TestMethodFilter listener
	            Element testMethodFilterListener = doc.createElement("listener");
	            testMethodFilterListener.setAttribute("class-name", "commonMethods.TestMethodFilter");
	            listeners.appendChild(testMethodFilterListener);

	            // Add Mail.CustomTestListener if Trigger is not "No"
	            String triggerValue = "Yes"; // You can fetch this value dynamically as per your config
	            if (!triggerValue.equalsIgnoreCase("No")) {
	                Element mailListener = doc.createElement("listener");
	                mailListener.setAttribute("class-name", "Mail.CustomTestListener");
	                listeners.appendChild(mailListener);
	            }

	            // Write the content into the XML file
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();

	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "\\testng.xml"));
	            transformer.transform(source, result);

	            // Output to console for testing
	            StreamResult consoleResult = new StreamResult(System.out);
	            transformer.transform(source, consoleResult);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}