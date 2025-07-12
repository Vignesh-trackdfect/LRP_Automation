package commonMethods;

import java.awt.AWTException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.License;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.sun.jna.platform.win32.KnownFolders;
import com.sun.jna.platform.win32.Shell32Util;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Directory;
import locators.Common_Locators;
import locators.ImportDocumentation_Locators;
import locators.LoadConfirmation_Locators;

//All the methods which we are using 
public class Keywords extends ATUReports implements Common_Locators {

	public String ElementWait = Utils.getDataFromTestConfig("Wait Time");
	public int WaitElementSeconds = Integer.parseInt(ElementWait);
	public String ProcessingWait = Utils.getDataFromTestConfig("Processing_Time");
	public int Processing_WaitTime = Integer.parseInt(ProcessingWait);
	public String WaitForDisplay_Time = Utils.getDataFromTestConfig("WaitForDisplay_Time");
	public int Display_WaitTime = Integer.parseInt(WaitForDisplay_Time);
	public String ScrollWaitTime = Utils.getDataFromTestConfig("ScrollWaitTime");
	public int Scroll_WaitTime = Integer.parseInt(ScrollWaitTime);
	public String AlertWaitTime = Utils.getDataFromTestConfig("AlertWaitTime");
	public int Alert_WaitTime = Integer.parseInt(AlertWaitTime);

	public String Credential_Conditon = Utils.getDataFromTestConfig("LoginUsingTestConfiguration");
	public String Login_Username = Utils.getDataFromTestConfig("Login_Username");
	public String Login_Password = Utils.getDataFromTestConfig("Login_Password");

	public String Download_Wait = Utils.getDataFromTestConfig("Download_Time");
	public int downloadWait = Integer.parseInt(Download_Wait);
	public String Main_Window = "";
	public ArrayList<String> tabs;
	public WebElement fromElement;
	public static ITestResult result;
	public String report_Filepath = Utils.getDataFromTestConfig("Reports  path");
	public String date = getCurrentDate();
	public String folder_name = report_Filepath.concat(date);
	public String folder_name_subfolder = folder_name.concat("/");
	public String report_folder_create = folder_name_subfolder;
	public String report_name = "PocReport";
	public String filepath_date_concat = folder_name_subfolder.concat(report_name).concat(".html");
	public String screenshot_folder_name = folder_name_subfolder.concat("Screenshot");
	public String screenshot_folder_path = screenshot_folder_name.concat("/");
	public String screenshot_folder_create = screenshot_folder_path;
	public String firstValue;
	public String secondValue;
	public boolean failureScreenshot = Directory.TestPassScreenshot;
	public static ExtentTest test;
	public static boolean serverStatus = true;
	public static List<String> global = new ArrayList<>();
	public static List<String> Encryptedpassword = new ArrayList<>();
	public static String OTP_For_Login_Option = Utils.getDataFromTestConfig("OTP_For_Login_Option");
	public static String provider_For_OTP = Utils.getDataFromTestConfig("provider_For_OTP");
	public static String Mail_Url_For_OTP = Utils.getDataFromTestConfig("Mail_Url_For_OTP");
	public static String MailID_For_OTP = Utils.getDataFromTestConfig("MailID_For_OTP");
	public static String MailPassword_For_OTP = Utils.getDataFromTestConfig("MailPassword_For_OTP");
	/*
	 * Used to get the Current Date Value
	 */
	private static final SecureRandom RANDOM = new SecureRandom();

	/*
	 * Used to get the Current Date Value
	 */
	public String getCurrentDate() {
		Format formatter = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date date = new Date();
		String value = formatter.format(date);
		return value;
	}

	/*
	 * Used to Split the LocatorValue by using '>", And store the split values into
	 * array. split into 'Reference Value' and 'XpathValue'
	 */
	public static String[] splitXpath(String path) {
		String[] a = path.split(">");
		return a;
	}

	/*
	 * Used to get the screenshot
	 */

	public static LocalDate getOnlyCurrentDate() {
		return LocalDate.now(); // Returns the current date
	}
	/*
	 * Used to compare the different date format
	 */

	public static boolean compareMonthAndYear(String date1, String date2) {
		try {
			DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date1Parsed = LocalDate.parse(date1, dateFormatter1);
			date2 = date2.toUpperCase(); // Ensure the month is in uppercase
			DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formattedDate2 = "01-" + convertMonthToNumeric(date2);
			LocalDate date2Parsed = LocalDate.parse(formattedDate2, dateFormatter2);
			return (date1Parsed.getMonthValue() == date2Parsed.getMonthValue())
					&& (date1Parsed.getYear() == date2Parsed.getYear());
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static String addDaysToDate(String inputDate, String daysToAdd) {

		int AddDays = Integer.parseInt(daysToAdd);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(inputDate, formatter);
		LocalDate resultDate = date.plusDays(AddDays);
		return resultDate.format(formatter);
	}

	public static String convertMonthToNumeric(String monthYear) {
		// Split the input by "-"
		String[] parts = monthYear.split("-");

		// Check if the input is in the correct format (Month-Year)
		if (parts.length != 2) {
			throw new IllegalArgumentException("Input must be in the format 'MON-YYYY' (e.g., JAN-2024)");
		}
		String month = parts[0].toUpperCase(); // Get the month part and convert to uppercase
		String year = parts[1]; // Get the year part
		String monthNumeric;
		switch (month) {
		case "JAN":
			monthNumeric = "01";
			break;
		case "FEB":
			monthNumeric = "02";
			break;
		case "MAR":
			monthNumeric = "03";
			break;
		case "APR":
			monthNumeric = "04";
			break;
		case "MAY":
			monthNumeric = "05";
			break;
		case "JUN":
			monthNumeric = "06";
			break;
		case "JUL":
			monthNumeric = "07";
			break;
		case "AUG":
			monthNumeric = "08";
			break;
		case "SEP":
			monthNumeric = "09";
			break;
		case "OCT":
			monthNumeric = "10";
			break;
		case "NOV":
			monthNumeric = "11";
			break;
		case "DEC":
			monthNumeric = "12";
			break;
		default:
			throw new IllegalArgumentException("Invalid month abbreviation: " + month);
		}
		return monthNumeric + "-" + year;
	}

	public String screenshot(WebDriver driver, String screenshotName) {
		String image_dest = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String currenttime = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
			image_dest = System.getProperty("user.dir").concat("\\snaptrude\\" + currenttime + screenshotName)
					.concat(".png");
			System.out.println(image_dest);
			File destination = new File(image_dest);
			FileUtils.copyFile(source, destination);
			return image_dest;
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot" + e.getMessage());
			return e.getMessage();
		}
	}

	/*
	 * Used to wait for the Visibility of the Element in the page (30 seconds)
	 */

	public void dragAndDrop(WebDriver driver, String DragPath, String DropPath) {
		String[] dragvalues = splitXpath(DragPath);
		String[] dropvalues = splitXpath(DropPath);
		try {
			WebElement source = driver.findElement(By.xpath(dragvalues[1]));
			WebElement target = driver.findElement(By.xpath(dropvalues[1]));

			Actions actions = new Actions(driver);
			actions.clickAndHold(source).moveToElement(target).release().build().perform();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public boolean isColumnPinnedRight(WebDriver driver, String headerLocator, String headerText) {
		String[] values = splitXpath(headerLocator);
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			String locator = String.format(values[1], headerText);
			WebElement header = driver.findElement(By.xpath(locator));
			boolean pinnedRight = header.findElements(By.xpath("./ancestor::div[contains(@class,'ag-pinned-right')]"))
					.size() > 0;

			return pinnedRight; // ← TRUE / FALSE
		} catch (NoSuchElementException e) {
			return false; // header not found = not pinned
		}
	}

	public void waitForElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			Extent_pass(driver, "Waiting for the " + values[0], test, test1);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + values[0] + " -> " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + values[0] + e.getLocalizedMessage());
		}
	}

	public static List<String> removeDuplicateStrings(List<String> inputList) {
		if (inputList == null || inputList.isEmpty()) {
			return new ArrayList<>();
		}

		// Using LinkedHashSet to preserve insertion order
		return new ArrayList<>(new LinkedHashSet<>(inputList));
	}

	/*
	 * Used to wait for the Pop-up message
	 */
	public void waitForPopup(WebDriver driver, String xpath, String ExpectedValue) {
		String[] values = splitXpath(xpath);
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "The Expected Pop-up '" + ExpectedValue + "' is Not Displayed", test, test1);
		}
	}

	/*
	 * Used to wait for the Pop-up message
	 */
	public void waitForPopup(WebDriver driver, WebElement element, String ExpectedValue) {
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Extent_fail(driver, "The Expected Pop-up '" + ExpectedValue + "' is Not Displayed", test, test1);
		}
	}

	public void reArrangeAG_GridColumns_VoyageWindow(WebDriver driver, String Select_Columns) {
		waitForElement(driver, AG_Grid_Columns_Button1);
		safeclick(driver, AG_Grid_Columns_Button1);
		waitForElement(driver, AG_Grid_Column_All_Select_Checkbox1);
		safeclick(driver, AG_Grid_Column_All_Select_Checkbox1);
		List<String> columns = splitAndExpand(Select_Columns);
		for (String column : columns) {
			waitForElement(driver, AG_Grid_Column_Searchbox1);
			clear(driver, AG_Grid_Column_Searchbox1);
			waitForElement(driver, AG_Grid_Column_Searchbox1);
			sendKeys(driver, AG_Grid_Column_Searchbox1, column);
			String check_box = String.format(column + AG_Grid_Column_Checkboxs1, column, column);
			click(driver, check_box);
		}
		waitForElement(driver, AG_Grid_Columns_Button1);
		click(driver, AG_Grid_Columns_Button1);
	}

	public void selectDatePicker(WebDriver driver, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		try {
			datePicker(DateValue, day, month, year);
			waitForElement(driver, Month_DD);
			selectByText(driver, Month_DD, month.toString());
			waitForElement(driver, Year_DD);
			selectByText(driver, Year_DD, year.toString());
			String date_select = String.format(Date_Select, day);
			click(driver, date_select);
		} catch (Exception e) {
		}
	}

	public boolean compareTableDataContains(List<List<String>> table1, List<List<String>> table2) {
		// Find the minimum number of rows to compare
		int minRows = Math.min(table1.size(), table2.size());

		// Iterate through each row up to the minimum count and compare values
		for (int i = 0; i < minRows; i++) {
			List<String> row1 = table1.get(i);
			List<String> row2 = table2.get(i);

			// Ensure both rows have the same number of columns
			if (row1.size() != row2.size()) {
				System.out.println("Mismatch in the number of columns at row " + (i + 1));
				return false;
			}

			// Compare each value in the row using contains
			for (int j = 0; j < row1.size(); j++) {
				String value1 = row1.get(j).replace(",", "").trim(); // Remove commas and trim
				String value2 = row2.get(j).replace(",", "").trim(); // Remove commas and trim

				if (!value1.contains(value2) && !value2.contains(value1)) {
					System.out.println("Mismatch at row " + (i + 1) + ", column " + (j + 1));
					System.out.println("Table1: " + value1 + " | Table2: " + value2);
					return false;
				}
			}
		}
		// If all compared rows match, return true
		System.out.println("Tables match up to the first " + minRows + " rows.");
		return true;
	}

	public static void sendKeysUsingRobot(String text) throws AWTException {
		Robot robot = new Robot();

		for (char c : text.toCharArray()) {
			boolean upperCase = Character.isUpperCase(c); // Check if uppercase
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException("Cannot type character: " + c);
			}

			if (upperCase) {
				robot.keyPress(KeyEvent.VK_SHIFT); // Press Shift for uppercase letters
			}

			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);

			if (upperCase) {
				robot.keyRelease(KeyEvent.VK_SHIFT); // Release Shift key
			}
		}
	}

	public void VerticalTop(WebDriver driver, String Xpath) {
		try {
			String[] values = splitXpath(Xpath);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Display_WaitTime));
			WebElement scroller = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// First, try scrollTop
			js.executeScript("arguments[0].scrollTop = 0;", scroller);

			// If not working, use scrollIntoView
			js.executeScript("arguments[0].scrollIntoView({block: 'start', behavior: 'smooth'});", scroller);

		} catch (Exception e) {
			System.out.println("Scrolling failed: " + e.getMessage());
		}
	}

	public double getValuesByFirstTwoColumnAndHeader(List<Map<String, String>> tableData, String firstColumnHeader,
			String firstColumnValue, String secondolumnHeader, String secondColumnValue, String columnHeader) {
		double ExpAmount = 0;

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader) && row.get(firstColumnHeader).equals(firstColumnValue)
					&& (row.containsKey(firstColumnHeader) && row.get(secondolumnHeader).equals(secondColumnValue))) {
				// If there's a match, add the value from the specified column header to the
				// list
				if (row.containsKey(columnHeader)) {
					String rowAmountValue = row.get(columnHeader).replace(",", "");
					double amountNum = Double.parseDouble(rowAmountValue);
					ExpAmount = ExpAmount + amountNum;

					ExpAmount = Double.parseDouble(String.format("%.2f", ExpAmount));
				}
			}
		}
		return ExpAmount; // Return the list of matching values
	}

	public double getValuesByFirstTwoColumnAndHeader(List<Map<String, String>> tableData, String firstColumnHeader,
			String firstColumnValue, String secondolumnHeader, String secondColumnValue, String thirdColumnHeader,
			String ThirdColumnValue, String AmountHeader) {
		double ExpAmount = 0;
		for (Map<String, String> row : tableData) {

			if (row.containsKey(firstColumnHeader) && !row.get(firstColumnHeader).equals(firstColumnValue)) {

				if (row.containsKey(secondolumnHeader) && row.get(secondolumnHeader).equals(secondColumnValue)) {

					if (row.containsKey(thirdColumnHeader) && row.get(thirdColumnHeader).equals(ThirdColumnValue)) {
						String rowAmountValue = row.get(AmountHeader).replace(",", "");
						double amountNum = Double.parseDouble(rowAmountValue);
						ExpAmount = ExpAmount + amountNum;

						ExpAmount = Double.parseDouble(String.format("%.2f", ExpAmount));
					}
				}
			}

		}
		return ExpAmount; // Return the list of matching values
	}

	public Map<String, List<String>> getValuesByID1(List<Map<String, String>> tableData, String firstColumnHeader,
			List<String> columnHeaders) {

		Map<String, List<String>> filteredData = new HashMap<>();

		for (Map<String, String> row : tableData) {
			String containerID = row.get(firstColumnHeader);
			// Only store values if the Container ID is in the specified list
			if (containerID != null) {
				List<String> matchingValues = new ArrayList<>();
				// Extract values for the specified column headers (excluding the
				// firstColumnHeader)
				for (String header : columnHeaders) {
					if (!header.equals(firstColumnHeader)) {
						String headerValue = row.get(header);
						matchingValues.add(headerValue != null ? headerValue : ""); // Avoid null values
					}
				}
				filteredData.put(containerID, matchingValues);
			}
		}
		return filteredData; // Return the filtered map
	}

	// Method to extract a value using a regular expression
	public static String extractPdfValue(String input, String Start, String End) {
		String regex = Start + "\\s*(.*?)\\s*(?=(?:\\s*" + End + "|\\Z))";
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			return matcher.group(1).trim();
		}
		return "";
	}

	public String selectedValue(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {

			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Select selectBox = new Select(webElement);
			String selectedText = selectBox.getFirstSelectedOption().getText();
			return selectedText;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
			return "";
		}
	}

	/*
	 * Used to clear the value on the element by using Actions class (Keyboard
	 * action)
	 */
	public void Newclear_Type(WebDriver driver) {
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();

			// Need a wait for performing the action keys, It will take some time for
			// performing the actions

			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void LRP_Login(WebDriver driver, String Username, String Password) {
//		waitForDisplay(driver, Login);
//		if (isDisplayed(driver, Login)) {
//			System.out.println(
//					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is displayed");
//			Extent_pass(driver,
//					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is displayed",
//					test, test1);
//		} else {
//			System.out.println(
//					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is not displayed");
//			Extent_fail(driver,
//					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is not displayed",
//					test, test1);
//		}
//
//		if (Credential_Conditon.equals("Yes")) {
//
//			waitForElement(driver, Username_input);
//			sendKeys(driver, Username_input, Login_Username);
//			waitForElement(driver, Password_input);
//			sendKeys(driver, Password_input, Login_Password);
//
//		} else {
//
//			waitForElement(driver, Username_input);
//			sendKeys(driver, Username_input, Username);
//			waitForElement(driver, Password_input);
//			sendKeys(driver, Password_input, Password);
//
//		}
//		waitForElement(driver, Login);
//		safeclick(driver, Login);
//
//		SimpleDateFormat formatternew = new SimpleDateFormat("HHmmss");
//		Date datenew = new Date();
//		String valuenew = formatternew.format(datenew);
//
//		System.out.println("Alert Started : " + valuenew);
//
//		SimpleDateFormat formatternew1 = new SimpleDateFormat("HHmmss");
//		Date datenew1 = new Date();
//		String valuenew1 = formatternew1.format(datenew1);
//		if (OTP_For_Login_Option.equalsIgnoreCase("Yes")) {
//			String mailOTP = Email_login_OTP(driver, provider_For_OTP, Mail_Url_For_OTP, MailID_For_OTP,
//					MailPassword_For_OTP);
//			closeTab(driver);
//			System.out.println("mailOTP : " + mailOTP);
//
//			waitForElement(driver, OTP_Input_Field);
//			sendKeys(driver, OTP_Input_Field, mailOTP);
//
//			waitForElement(driver, OTP_Proceed_Button);
//			click(driver, OTP_Proceed_Button);
//		}
//		System.out.println("Alert Ended : " + valuenew1);
//		waitForDisplay(driver, Home_Logo);
//		if (isDisplayed(driver, Home_Logo)) {
//			System.out.println(
//					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is displayed");
//			Extent_pass(driver,
//					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is displayed",
//					test, test1);
//		} else {
//			System.out.println(
//					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is not displayed");
//			Extent_fail(driver,
//					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is not displayed",
//					test, test1);
//		}
//
//		SimpleDateFormat formatternew2 = new SimpleDateFormat("HHmmss");
//		Date datenew2 = new Date();
//		String valuenew2 = formatternew2.format(datenew2);
//
//		System.out.println("Home logo displayed : " + valuenew2);
//
//	}
	// 04-07-2025 modified by ArunKumar
	public void LRP_Login(WebDriver driver, String Username, String Password) {
		waitForDisplay(driver, Login);
		if (isDisplayed(driver, Login)) {
			System.out.println(
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is displayed");
			Extent_pass(driver,
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is displayed",
					test, test1);
		} else if (isdisplayed(driver, Login_With_OTP_Button)) {
			click(driver, Login_With_OTP_Button);
		} else {
			System.out.println(
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is not displayed");
			Extent_fail(driver,
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is not displayed",
					test, test1);
		}

		if (Credential_Conditon.equals("Yes")) {

			waitForElement(driver, Username_input);
			sendKeys(driver, Username_input, Login_Username);
			waitForElement(driver, Password_input);
			sendKeys(driver, Password_input, Login_Password);

		} else {

			waitForElement(driver, Username_input);
			sendKeys(driver, Username_input, Username);
			waitForElement(driver, Password_input);
			sendKeys(driver, Password_input, Password);

		}
		waitForElement(driver, Login);
		safeclick(driver, Login);

		SimpleDateFormat formatternew = new SimpleDateFormat("HHmmss");
		Date datenew = new Date();
		String valuenew = formatternew.format(datenew);

		System.out.println("Alert Started : " + valuenew);

		SimpleDateFormat formatternew1 = new SimpleDateFormat("HHmmss");
		Date datenew1 = new Date();
		String valuenew1 = formatternew1.format(datenew1);
		if (OTP_For_Login_Option.equalsIgnoreCase("Yes")) {
			String mailOTP = Email_login_OTP(driver, provider_For_OTP, Mail_Url_For_OTP, MailID_For_OTP,
					MailPassword_For_OTP);
			closeTab(driver);
			System.out.println("mailOTP : " + mailOTP);

			waitForElement(driver, OTP_Input_Field);
			sendKeys(driver, OTP_Input_Field, mailOTP);

			waitForElement(driver, OTP_Proceed_Button);
			click(driver, OTP_Proceed_Button);
		}
		System.out.println("Alert Ended : " + valuenew1);
		waitForDisplay(driver, Home_Logo);
		if (isDisplayed(driver, Home_Logo)) {
			System.out.println(
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is displayed");
			Extent_pass(driver,
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is displayed",
					test, test1);
		} else {
			System.out.println(
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is not displayed");
			Extent_fail(driver,
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is not displayed",
					test, test1);
		}

		SimpleDateFormat formatternew2 = new SimpleDateFormat("HHmmss");
		Date datenew2 = new Date();
		String valuenew2 = formatternew2.format(datenew2);

		System.out.println("Home logo displayed : " + valuenew2);

	}

	public void LRP_Login_With_OTP(WebDriver driver, String Username, String Password, String Provider, String url,
			String MailID, String mailPassword) {
		waitForDisplay(driver, Login);
		if (isDisplayed(driver, Login)) {
			System.out.println(
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is displayed");
			Extent_pass(driver,
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is displayed",
					test, test1);
		} else {
			System.out.println(
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is not displayed");
			Extent_fail(driver,
					"Expected result is : After launch the url, Login page should be displayed || Actual result is : After launch the url, Login page is not displayed",
					test, test1);
		}

		if (Credential_Conditon.equals("Yes")) {

			waitForElement(driver, Username_input);
			sendKeys(driver, Username_input, Login_Username);
			waitForElement(driver, Password_input);
			sendKeys(driver, Password_input, Login_Password);

		} else {

			waitForElement(driver, Username_input);
			sendKeys(driver, Username_input, Username);
			waitForElement(driver, Password_input);
			sendKeys(driver, Password_input, Password);

		}
		waitForElement(driver, Login);
		safeclick(driver, Login);

		SimpleDateFormat formatternew = new SimpleDateFormat("HHmmss");
		Date datenew = new Date();
		String valuenew = formatternew.format(datenew);

		System.out.println("Alert Started : " + valuenew);

		SimpleDateFormat formatternew1 = new SimpleDateFormat("HHmmss");
		Date datenew1 = new Date();
		String valuenew1 = formatternew1.format(datenew1);

		System.out.println("Alert Ended : " + valuenew1);
		String mailOTP = Email_login_OTP(driver, Provider, url, MailID, mailPassword);
		closeTab(driver);
		System.out.println("mailOTP : " + mailOTP);

		waitForElement(driver, OTP_Input_Field);
		sendKeys(driver, OTP_Input_Field, mailOTP);

		waitForElement(driver, OTP_Proceed_Button);
		click(driver, OTP_Proceed_Button);

		waitForDisplay(driver, Home_Logo);
		if (isDisplayed(driver, Home_Logo)) {
			System.out.println(
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is displayed");
			Extent_pass(driver,
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is displayed",
					test, test1);
		} else {
			System.out.println(
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is not displayed");
			Extent_fail(driver,
					"Expected result is : After login, Home page should be displayed || Actual result is : Home page is not displayed",
					test, test1);
		}

		SimpleDateFormat formatternew2 = new SimpleDateFormat("HHmmss");
		Date datenew2 = new Date();
		String valuenew2 = formatternew2.format(datenew2);

		System.out.println("Home logo displayed : " + valuenew2);

	}

	public static boolean CompareMapValues1(Map<String, String> exp, Map<String, String> act) {
		// Check if both maps are null or have different sizes
		if (exp == null || act == null || exp.size() != act.size()) {
			return false;
		}

		// Iterate through each entry in the expected map
		for (Map.Entry<String, String> entry : exp.entrySet()) {
			String key = entry.getKey();
			String expectedValue = entry.getValue();

			// Check if the key exists in the actual map
			if (!act.containsKey(key)) {
				return false;
			}

			// Retrieve the actual value
			String actualValue = act.get(key);

			if (expectedValue.contains(",")) {
				expectedValue = expectedValue.replace(",", "");
			}
			if (actualValue.contains(",")) {
				actualValue = actualValue.replace(",", "");
			}

			// Compare values as BigDecimal if they are numeric
			if (isNumeric(expectedValue) && isNumeric(actualValue)) {
				BigDecimal expNum = new BigDecimal(expectedValue);
				BigDecimal actNum = new BigDecimal(actualValue);
				if (expNum.compareTo(actNum) != 0) {
					return false;
				}
			} else {
				// Compare as regular strings for non-numeric values
				if (!expectedValue.equals(actualValue)) {
					return false;
				}
			}
		}

		// If all key-value pairs match, return true
		return true;
	}

	public boolean isEmpty(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Display_WaitTime));

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			return false; // Element not present or visible
		}

		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			String text = webElement.getText().trim();
			String value = webElement.getDomAttribute("value");

			// Return true if both text and value are empty or null
			return text.isEmpty() && (value == null || value.trim().isEmpty());
		} catch (Exception e) {
			return false; // Error accessing the element
		}
	}

	public static boolean compareLists(List<String> expected, List<String> actual) {
		// Check for null lists or different sizes
		if (expected == null || actual == null || expected.size() != actual.size()) {
			return false;
		}

		// Sort both lists to ignore order differences
		List<String> sortedExpected = new ArrayList<>(expected);
		List<String> sortedActual = new ArrayList<>(actual);
		Collections.sort(sortedExpected);
		Collections.sort(sortedActual);

		// Compare each element with numeric handling
		for (int i = 0; i < sortedExpected.size(); i++) {
			String expValue = sortedExpected.get(i);
			String actValue = sortedActual.get(i);

			if (expValue.contains(",")) {
				expValue = expValue.replace(",", "");
			}
			if (actValue.contains(",")) {
				actValue = actValue.replace(",", "");
			}

			if (isNumeric(expValue) && isNumeric(actValue)) {
				BigDecimal expNum = new BigDecimal(expValue);
				BigDecimal actNum = new BigDecimal(actValue);
				if (expNum.compareTo(actNum) != 0) {
					return false;
				}
			} else {
				if (!expValue.equals(actValue)) {
					return false;
				}
			}
		}
		return true;
	}

	public static String getColorName(String hexaCode) {
		String colorName = "Unknown Color";

		switch (hexaCode.toUpperCase()) {
		// Whites
		case "#FFFFFF":
			colorName = "White";
			break;
		case "#FFFAF0":
			colorName = "Floral white";
			break;
		case "#F5F5F5":
		case "#DCDCDC":
			colorName = "Light Gray";
			break;
		case "#808080":
			colorName = "Gray";
			break;
		case "#696969":
			colorName = "Dark Gray";
			break;

		// Blacks
		case "#000000":
			colorName = "Black";
			break;
		case "#212121":
			colorName = "Eerie Black";
			break;
		// Reds
		case "#FF0000":
			colorName = "Red";
			break;
		case "#8B0000":
			colorName = "Dark Red";
			break;
		case "#FF6666":
			colorName = "Light Red";
			break;
		case "#FFB6C1":
			colorName = "Light Pink";
			break;
		// Greens
		case "#00FF00":
			colorName = "Green";
			break;
		case "#006400":
			colorName = "Dark Green";
			break;
		case "#90EE90":
			colorName = "Light Green";
			break;
		case "#FAFAD2":
			colorName = "Light Green";
			break;

		case "#800000":
			colorName = "Maroon";
			break;
		// Blues
		case "#0000FF":
			colorName = "Blue";
			break;
		case "#00BFFF":
			colorName = "Deep Sky Blue";
			break;
		case "#00008B":
			colorName = "Dark Blue";
			break;
		case "#ADD8E6":
			colorName = "Light Blue";
			break;
		case "#00FFFF":
			colorName = "Greenish Blue";
			break;
		// Yellows
		case "#FFFF00":
			colorName = "Yellow";
			break;
		case "#FFD700":
			colorName = "Golden Yellow";
			break;
		case "#FFFACD":
			colorName = "Light Yellow";
			break;
		case "#FFEB3B":
			colorName = "Yellow";
			break;
		case "#9ACD32":
			colorName = "Yellow-Green";
			break;
		// Purples
		case "#800080":
			colorName = "Purple";
			break;
		case "#4B0082":
			colorName = "Dark Purple";
			break;
		case "#DA70D6":
			colorName = "Light Purple";
			break;

		// Oranges
		case "#FFA500":
			colorName = "Orange";
			break;
		case "#FF8C00":
			colorName = "Dark Orange";
			break;
		case "#FFDAB9":
			colorName = "Light Orange";
			break;

		// Pinks
		case "#FFC0CB":
			colorName = "Pink";
			break;
		case "#FF69B4":
			colorName = "Hot Pink";
			break;
		case "#F08080":
			colorName = "Light Pink";
			break;
		case "#7CFC00":
			colorName = "lawn green";
			break;
		case "#D62D20":
			colorName = "Red";
			break;
		default:
			colorName = "Unknown Color"; // If the hex code is not listed
			break;
		}
		return colorName;
	}

	public String Email_login_OTP(WebDriver driver, String Website, String EmailURL, String EmailID,
			String EmailPassword) {

		if (Website.equals("Outlook")) {
			navigateUrl_NewTab(driver, EmailURL);

			waitForElement(driver, Outlook_EmailInput);
			sendKeys(driver, Outlook_EmailInput, EmailID);

			waitForElement(driver, Outlook_ClickNext);
			click(driver, Outlook_ClickNext);

			waitForElement(driver, Outlook_PasswordInput);
			sendKeys(driver, Outlook_PasswordInput, EmailPassword);

			waitForElement(driver, Outlook_ClickNext);
			click(driver, Outlook_ClickNext);

			try {
				if (isdisplayed(driver, Outlook_ClickNext)) {
					click(driver, Outlook_ClickNext);
				}
			} catch (Exception e) {
				System.out.println("Stay signed in prompt not displayed.");
			}

			// Wait for inbox and open the OTP mail
			waitForElement(driver, OTP_Mail_Content);
			click(driver, OTP_Mail_Content);

			// Wait and get the OTP text from email body
			waitForElement(driver, Outlook_OTP);
			String OTP = getText(driver, Outlook_OTP);

			// // Extract OTP using Regex
			// Pattern pattern = Pattern.compile("OTP\\) is\\s+([a-zA-Z0-9]+)");
			// Matcher matcher = pattern.matcher(emailBody);
			return OTP;
		} else if (Website.equals("Gmail")) {
			// Handle Gmail if needed (same idea)
		}

		return null;
	}
	// public void verifyMainMenu(WebDriver driver) {
	//
	// SimpleDateFormat formatternew = new SimpleDateFormat("ddMMyyyyHHmmss");
	// Date datenew = new Date();
	// String valuenew = formatternew.format(datenew);
	//
	// System.out.println("Verify Main menu started : " + valuenew);
	//
	// waitForDisplay(driver, main_Menu_ID);
	// if (isdisplayed(driver, main_Menu_ID)) {
	// click(driver, hide_Menu_ID);
	// waitForDisplay(driver, main_Menu_ID);
	// if (!isdisplayed(driver, main_Menu_ID)) {
	// System.out.println(
	// "Expected result : Main Menu should be Hided After Clicking The Hide Menu
	// Button || Actual result is : Main Menu Hided After Clicking The Hide Menu
	// Button");
	// Extent_pass(driver,
	// "Expected result : Main Menu should be Hided After Clicking The Hide Menu
	// Button || Actual result is : Main Menu Hided After Clicking The Hide Menu
	// Button",
	// test, test1);
	// } else {
	// System.out.println(
	// "Expected result : Main Menu should be Hided After Clicking The Hide Menu
	// Button || Actual result is : Main Menu not Hided After Clicking The Hide Menu
	// Button");
	// Extent_fail(driver,
	// "Expected result : Main Menu should be Hided After Clicking The Hide Menu
	// Button || Actual result is : Main Menu not Hided After Clicking The Hide Menu
	// Button",
	// test, test1);
	// }
	// }
	//
	// SimpleDateFormat formatternew2 = new SimpleDateFormat("ddMMyyyyHHmmss");
	// Date datenew2 = new Date();
	// String valuenew2 = formatternew2.format(datenew2);
	//
	// System.out.println("Verify Main menu started : " + valuenew2);
	//
	// }

	public String convertListintoTableForReport(String header, List<String> items) {
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<table style='border-collapse: collapse; width: 50%;'>")
				.append("<thead><tr><th style='border: 1px solid black; padding: 5px;'>").append(header)
				.append("</th></tr></thead>").append("<tbody>");
		for (String item : items) {
			tableBuilder.append("<tr><td style='border: 1px solid black; padding: 5px;'>").append(item)
					.append("</td></tr>");
		}

		tableBuilder.append("</tbody></table>");

		return tableBuilder.toString();
	}

	public void selectservice_Discharge(WebDriver driver, String Servicecode, String vesselCode, String Voyagenumber,
			String Boundinput, String portCode, String terminalCode) {
		waitForElement(driver, dischargeload_servicecode);
		sendKeys(driver, dischargeload_servicecode, Servicecode);

		waitForElement(driver, dischargevessel_Input);
		sendKeys(driver, dischargevessel_Input, vesselCode);

		waitForElement(driver, discharge_VoyageInput);
		sendKeys(driver, discharge_VoyageInput, Voyagenumber);

		waitForElement(driver, dischare_Boundinput);
		sendKeys(driver, dischare_Boundinput, Boundinput);

		waitForElement(driver, dischargeportCode_Inputfield);
		sendKeys(driver, dischargeportCode_Inputfield, portCode);

		waitForElement(driver, discharge_terminalCode_Inputfield);
		sendKeys(driver, discharge_terminalCode_Inputfield, terminalCode);

		waitForElement(driver, LC_select_Service);
		click(driver, LC_select_Service);
		waitForElement(driver, select_Service_Discharge);
		click(driver, select_Service_Discharge);
	}

	public void selectservice(WebDriver driver, String Servicecode, String vesselCode, String Voyagenumber,
			String Boundinput, String portCode, String terminalCode) {
		waitForElement(driver, LC_load_servicecode);
		sendKeys(driver, LC_load_servicecode, Servicecode);

		waitForElement(driver, LC_vessel_Input);
		sendKeys(driver, LC_vessel_Input, vesselCode);

		waitForElement(driver, LC_VoyageInput);
		sendKeys(driver, LC_VoyageInput, Voyagenumber);

		waitForElement(driver, LC_Boundinput);
		sendKeys(driver, LC_Boundinput, Boundinput);

		waitForElement(driver, LC_portCode_Inputfield);
		sendKeys(driver, LC_portCode_Inputfield, portCode);

		waitForElement(driver, LC_terminalCode_Inputfield);
		sendKeys(driver, LC_terminalCode_Inputfield, terminalCode);

		waitForElement(driver, LC_select_Service);
		click(driver, LC_select_Service);
		waitForElement(driver, select_Service_Discharge);
		click(driver, select_Service_Discharge);
	}

	public void editSchedule(WebDriver driver, String Service) {
		waitForElement(driver, Routingedit);
		safeclick(driver, Routingedit);
		waitForDisplay(driver, popup_Message_No_Button);
		if (isdisplayed(driver, popup_Message_No_Button)) {
			waitForElement(driver, popup_Message_No_Button);
			safeclick(driver, popup_Message_No_Button);
		}
		waitForElement(driver, Routing_search_ToolPannel);
		click(driver, Routing_search_ToolPannel);
		waitForElement(driver, Routing_Search_ConditionFilter);
		click(driver, Routing_Search_ConditionFilter);

		waitForElement(driver, Routing_Search_Servicefilter);
		sendKeys(driver, Routing_Search_Servicefilter, Service);
		waitForElement(driver, Routing_Search_valueSelect);
		click(driver, Routing_Search_valueSelect);
		waitForElement(driver, Routing_Search_Ok_Btn);
		click(driver, Routing_Search_Ok_Btn);
	}

	public String getTextJavascript(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					webElement);
			return text;

		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * used to verify the element is not editable
	 */
	public boolean elementNotclickable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath); // Assuming you have a method to split the XPath
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			// Check if the element is enabled
			if (webElement.isEnabled()) {
				// Check the aria-readonly and aria-disabled attributes
				String ariaReadOnly = webElement.getDomAttribute("aria-readonly");
				String ariaDisabled = webElement.getDomAttribute("aria-disabled");
				// The field is considered not editable if it is read-only or disabled
				return "false".equals(ariaReadOnly) || "false".equals(ariaDisabled);
			}
			return true; // Not enabled
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Used to download and save the pdf file
	 */
	public void downloadedPdfFile(WebDriver driver, String filename) {
		String os = System.getProperty("os.name").toLowerCase();
		String downloadPath = "";
		if (os.contains("win")) {
			// For Windows, using Shell32Util
			downloadPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		} else {
			// Defaulting to user home directory if OS is not recognized
			downloadPath = System.getProperty("user.home");
		}

		// String downloadsPath = "C:\\Users\\TRACK\\Downloads";
		String downloadDir = downloadPath;
		File dir = new File(downloadDir);
		String Downloadedfile = "";

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles((dir1, name) -> name.contains("" + filename + ".pdf"));
			if (files != null && files.length > 0) {
				// Sort files by last modified timestamp in descending order
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
				// Get the first (latest) file
				File latestFile = files[0];
				Downloadedfile = latestFile.getAbsolutePath();
				System.out
						.println("Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath());
				Extent_pass(driver,
						"Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath(), test,
						test1);
			} else {
				System.out.println("Downloaded file was not present in the downloads folder ");
				Extent_fail(driver, "Downloaded file was not present in the downloads folder ", test, test1);
			}
		} else {
			System.out.println("Directory does not exist or is not a directory.");
			Extent_fail(driver, "Directory does not exist or is not a directory.", test, test1);
		}

		System.out.println("Latest Downloaded PDF file :" + Downloadedfile);
		Extent_pass1(test, "Latest Downloaded PDF file :" + Downloadedfile);
	}

	public String alertAccept(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(Alert_WaitTime)); // Wait up to
			// 10
			// seconds
			wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert to be present
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			return alertText;
		} catch (Exception e) {
			return null;
		}
	}

	public static List<String> removeDuplicates(List<String> list) {
		if (list == null) {
			return new ArrayList<>();
		}
		return new ArrayList<>(new HashSet<>(list)); // Removes duplicates
	}

	/*
	 * used to Load confirmation scripts //23-03-25 created by arunthathi
	 */
	public void selectservice_NonDischarge(WebDriver driver, String Servicecode, String vesselCode, String Voyagenumber,
			String Boundinput, String portCode, String terminalCode) {
		waitForElement(driver, dischargeload_servicecode);
		sendKeys(driver, dischargeload_servicecode, Servicecode);

		waitForElement(driver, dischargevessel_Input1);
		sendKeys(driver, dischargevessel_Input1, vesselCode);

		waitForElement(driver, discharge_VoyageInput1);
		sendKeys(driver, discharge_VoyageInput1, Voyagenumber);

		waitForElement(driver, dischare_Boundinput1);
		sendKeys(driver, dischare_Boundinput1, Boundinput);

		waitForElement(driver, dischargeportCode_Inputfield1);
		sendKeys(driver, dischargeportCode_Inputfield1, portCode);

		waitForElement(driver, discharge_terminalCode_Inputfield1);
		sendKeys(driver, discharge_terminalCode_Inputfield1, terminalCode);

		waitForElement(driver, LC_select_Service);
		click(driver, LC_select_Service);
		waitForElement(driver, select_Service_Discharge);
		click(driver, select_Service_Discharge);
	}

	public List<String> getExcelValue(String excelFilePath, String SheetName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		Sheet sheet = workbook.getSheet(SheetName);
		List<String> excelvalue = new ArrayList<String>();
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			Row row = sheet.getRow(rowIndex); // Get the row at the current index
			if (row != null) {
				String RGEmailID13_value = "";

				Cell RGEmailID13Cell = row.getCell(0);
				if (RGEmailID13Cell != null) {
					CellType cellType = RGEmailID13Cell.getCellTypeEnum();
					if (cellType == CellType.STRING) {
						RGEmailID13_value = RGEmailID13Cell.getStringCellValue();
					} else if (cellType == CellType.NUMERIC) {
						// Handle numeric values if needed
						RGEmailID13_value = String.valueOf(RGEmailID13Cell.getNumericCellValue());
					} else if (cellType == CellType.BLANK) {
						// Handle blank cells
						RGEmailID13_value = ""; // Or any default value you want to use
					} else if (cellType == CellType.FORMULA) {
						// Handle formula cells
						RGEmailID13_value = ""; // Or evaluate the formula if needed
					}
				} else {
					// Cell is null, handle accordingly
					RGEmailID13_value = ""; // Or any default value you want to use
				}

				excelvalue.add(RGEmailID13_value);

			}
		}
		return excelvalue;
	}

	public static boolean containsAllValues(List<String> expected, List<String> actual) {
		if (expected == null || actual == null) {
			return false;
		}

		for (String expValue : expected) {
			boolean matchFound = false;
			for (String actValue : actual) {
				if (areEqual(expValue, actValue)) {
					matchFound = true;
					break; // Found a match, no need to check further for this value
				}
			}
			if (!matchFound) {
				return false; // If any expected value is not found, return false
			}
		}
		return true;
	}

	public void RightClick1(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + element + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + element);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + element + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + element);
			verifyServerStatus(driver);
			Assert.fail();
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
			builder.contextClick(element).build().perform();
			Extent_pass(driver, "Able to click on " + element + "- ", test, test1);
			wait(driver, "1");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + element);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	public void selectDatePickerWith_Time(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		StringBuilder time = new StringBuilder();
		datePickerWithTime(DateValue, day, month, year, time);
		waitForElement(driver, Locator);
		click(driver, Locator);
		waitForElement(driver, Year_DD);
		selectByText(driver, Year_DD, year.toString());
		waitForElement(driver, Month_DD);
		selectByText(driver, Month_DD, month.toString());
		String date_Select = String.format(LoadConfirmation_Locators.date_select, day);
		waitForElement(driver, date_Select);
		jsClick(driver, date_Select);
		waitForDisplay(driver, calender_close);
		if (isdisplayed(driver, calender_close)) {
			waitForElement(driver, calender_close);
			click(driver, calender_close);
		}
		waitForElement(driver, Locator);
		click(driver, Locator);
		waitForElement(driver, timeInput);
		doubleClick(driver, timeInput);
		waitForElement(driver, timeInput);
		clearAndType(driver, timeInput, time.toString());
		waitForElement(driver, timeInput);
		click(driver, timeInput);
		waitForDisplay(driver, calender_close);
		if (isdisplayed(driver, calender_close)) {
			waitForElement(driver, calender_close);
			click(driver, calender_close);
		}
	}

	public void Scroll_ElementVisible(WebDriver driver, String xpath, String scroll) {

		String value[] = splitXpath(xpath);
		String scrollpath[] = splitXpath(scroll);

		WebElement scroller = driver.findElement(By.xpath(scrollpath[1]));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean elementFound = false;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Scroll_WaitTime));

		while (!elementFound) {
			try {

				WebElement element = driver.findElement(By.xpath(value[1]));

				if (element.isDisplayed()) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Scroll_WaitTime));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					elementFound = true;
					System.out.println("Element is visible!");
				} else {
					// Scroll to bring it into view if found but not visible
					js.executeScript("arguments[0].scrollIntoView(true);", element);
				}
			} catch (Exception e) {
				// If not found or still not visible, scroll further
				Long currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scroller))
						.longValue();
				Long maxScroll = ((Number) js
						.executeScript("return arguments[0].scrollWidth - arguments[0].clientWidth;", scroller))
						.longValue();

				if (currentScroll >= maxScroll) {
					System.out.println("Reached the end of the scroll area. Element not found.");
					break; // Exit loop if no more scrolling possible
				}

				// Scroll horizontally
				js.executeScript("arguments[0].scrollLeft += 500;", scroller);
			}
		}

	}

	public List<Map<String, String>> getTableData2(WebDriver driver, String Header, String Row) {
		String[] columnheader = splitXpath(Header);
		String[] row = splitXpath(Row);
		List<WebElement> headers = driver.findElements(By.xpath(columnheader[1]));
		List<String> headerTexts = new ArrayList<>();
		for (WebElement header : headers) {
			String headername = header.getDomAttribute("aria-label");
			try {
				if (headername.contains(":")) {
					String[] headerName = headername.split(":");
					headerTexts.add(headerName[1]);
				} else {
					headerTexts.add(headername);
				}
			} catch (NullPointerException e) {
				headerTexts.add(null);
				continue;
			}
		}
		// Locate the values table
		List<WebElement> rows = driver.findElements(By.xpath(row[1]));
		// List to hold all row data as a list of maps
		List<Map<String, String>> tableData = new ArrayList<>();
		// Iterate through each row (starting from 1 to skip the header row)
		int k = 1;
		for (WebElement tableRow : rows) {
			try {
				List<WebElement> cells = tableRow.findElements(By.tagName("td"));
				// Create a map for each row
				Map<String, String> rowData = new HashMap<>();

				for (int j = 0; j < cells.size(); j++) {
					if (j < headerTexts.size()) {
						rowData.put(headerTexts.get(j), cells.get(j).getText());
					}
				}
				// Add the row map to the list
				tableData.add(rowData);
			} catch (Exception e) {
				System.err.println("Error processing row " + k + ": " + e.getMessage());
				e.printStackTrace();
				Extent_fail(driver, "Error processing row " + k + ": " + e.getMessage(), test, test1);
				global.add("Error processing row " + k + ": " + e.getMessage());
				verifyServerStatus(driver);
				Assert.fail("Element is not present " + e.getLocalizedMessage());
			}
			k++;
		}
		// Fetch values by header
		return tableData;
	}

	public void waitInvisible(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(values[1])));
			Extent_pass(driver, "Waiting for the " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Element is not present " + values[0] + " -> " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + values[0] + e.getLocalizedMessage());
		}
	}

	public String evaluateExpression(String formulaText, String simulatorValue) {
		String updatedText = formulaText.replaceAll("#[^#]+#", simulatorValue);

		try {
			// Create JEXL Engine
			JexlEngine jexl = new JexlBuilder().create();
			JexlExpression jexlExpression = jexl.createExpression(updatedText);
			JexlContext context = new MapContext();

			// Evaluate the mathematical expression
			Object result = jexlExpression.evaluate(context);
			System.out.println("Evaluated Result: " + result);

			return result.toString(); // Return evaluated result as String
		} catch (Exception e) {
			System.out.println("Error evaluating expression: " + e.getMessage());
			return "Error"; // Return an error message
		}
	}

	public void twoColumnSearchWindow(WebDriver driver, String Column_Header, String Condition_Filter, String value) {
		String columnHeader = String.format(two_Column_Search_Column_Header, Column_Header);
		waitForElement(driver, columnHeader);
		String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
		String filter_Field = String.format(Filter_Input_Field, columnIndex);
		String filter_Btn = String.format(Filter_Button, columnIndex);
		String column_Values = String.format(column_Value, columnIndex);
		boolean flag = true;
		if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
			waitForElement(driver, filter_Field);
			sendKeys(driver, filter_Field, value);
			waitForElement(driver, filter_Btn);
			click(driver, filter_Btn);
			waitForElement(driver, Filter_Operator);
			click(driver, Filter_Operator);
			waitForElement(driver, Equals_Option);
			click(driver, Equals_Option);
			waitForElement(driver, columnHeader);
			click(driver, columnHeader);
			waitForElement(driver, column_Values);
			click(driver, column_Values);
			waitForElement(driver, select_Button);
			click(driver, select_Button);
		} else {
			waitForElement(driver, filter_Field);
			sendKeys(driver, filter_Field, value);
			List<WebElement> cloumns_Values = listOfElements(driver, column_Values);
			for (WebElement cloumns_Value : cloumns_Values) {
				String column_Text = cloumns_Value.getText();
				if (column_Text.contains(value)) {
					cloumns_Value.click();
					flag = false;
					break;
				}
			}
			if (flag) {
				Extent_fail(driver, value + " The value is Not found in the current window", test, test1);
			} else {
				waitForElement(driver, select_Button);
				click(driver, select_Button);
			}
		}
	}

	public void Escape(WebDriver driver) {
		try {
			// Action class take some time performing action, So we have gave the manual
			// wait here
			wait(driver, ScrollWaitTime);
			Actions actionObject = new Actions(driver);
			actionObject.sendKeys(Keys.ESCAPE).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail(e.getLocalizedMessage());
		}
	}

	public String dateconverter(String Convertedvalue) {

		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Parse and format the date
		LocalDate date = LocalDate.parse(Convertedvalue, inputFormatter);
		return date.format(outputFormatter);
	}

	public void AG_DistinctFilter(WebDriver driver, String columnanme, String searchvalue) {

		formatLocatorClick(driver, AG_Grid_DistinctFilter_Filterbutton, columnanme);

		waitForDisplay(driver, AG_Grid_DistinctFilter_FilterInput);
		if (!isdisplayed(driver, AG_Grid_DistinctFilter_FilterInput)) {

			waitForElement(driver, AG_Grid_DistinctFilter_FilterTab);
			click(driver, AG_Grid_DistinctFilter_FilterTab);

		}

		waitForDisplay(driver, AG_Grid_DistinctFilter_SelectAll);
		jsClick(driver, AG_Grid_DistinctFilter_SelectAll);

		waitForElement(driver, AG_Grid_DistinctFilter_FilterInput);
		sendKeys(driver, AG_Grid_DistinctFilter_FilterInput, searchvalue);

		String selectvalue = String.format(AG_Grid_DistinctFilter_Selectvalue, searchvalue);

		VerticalScroll_Visible(driver, selectvalue, AG_FilterOptionScroller);

		formatLocatorClick(driver, AG_Grid_DistinctFilter_Selectvalue, searchvalue);

		Escape(driver);

	}

	public void twoColumnSearchWindowMultipleValue(WebDriver driver, String Column_Header, String Condition_Filter,
			String value) {
		String columnHeader = String.format(two_Column_Search_Column_Header, Column_Header);
		waitForElement(driver, columnHeader);
		String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
		String filter_Field = String.format(Filter_Input_Field, columnIndex);
		String filter_Btn = String.format(Filter_Button, columnIndex);
		String column_Values = String.format(column_Value, columnIndex);
		List<String> Column_Sel_Values = splitAndExpand(value);
		for (String Column_Sel_Value : Column_Sel_Values) {
			boolean flag = true;
			if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
				waitForElement(driver, filter_Field);
				clear(driver, filter_Field);
				sendKeys(driver, filter_Field, Column_Sel_Value);
				waitForElement(driver, filter_Btn);
				click(driver, filter_Btn);
				waitForElement(driver, Filter_Operator);
				click(driver, Filter_Operator);
				waitForElement(driver, Equals_Option);
				click(driver, Equals_Option);
				waitForElement(driver, columnHeader);
				click(driver, columnHeader);
				waitForElement(driver, column_Values);
				click(driver, column_Values);
			} else {
				waitForElement(driver, filter_Field);
				clear(driver, filter_Field);
				sendKeys(driver, filter_Field, Column_Sel_Value);
				List<WebElement> cloumns_Values = listOfElements(driver, column_Values);
				for (WebElement cloumns_Value : cloumns_Values) {
					String column_Text = cloumns_Value.getText();
					if (column_Text.contains(Column_Sel_Value)) {
						cloumns_Value.click();
						flag = false;
						break;
					}
				}
				if (flag) {
					Extent_fail(driver, value + " The value is Not found in the current window", test, test1);
				}
			}
		}
		waitForElement(driver, select_Button);
		click(driver, select_Button);
	}

	public void AGGridValueFilter(WebDriver driver, String Column_Header, String Condition_Filter, String value) {
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);
		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		List<String> headers = splitAndExpand(Column_Header, ",");
		List<String> inputValues = splitAndExpand(value, ",");
		for (int i = 0; i < headers.size(); i++) {
			String givenHeader = headers.get(i);
			String inputValue = inputValues.get(i);
			String columnHeader = String.format(AG_Grid_Headers, givenHeader, givenHeader);
			waitForElement(driver, columnHeader);
			String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
			String filterField = String.format(AG_Grid_Filter_Field, columnIndex, columnIndex);
			String filterButton = String.format(AG_Grid_Filter_Button, columnIndex, columnIndex);
			waitForElement(driver, filterField);
			clear(driver, filterField);
			waitForElement(driver, filterField);
			sendKeys(driver, filterField, inputValue);
			if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
				waitForElement(driver, filterButton);
				click(driver, filterButton);
				waitForElement(driver, Filter_Operator);
				click(driver, Filter_Operator);
				waitForElement(driver, Equals_Option);
				click(driver, Equals_Option);
				waitForElement(driver, columnHeader);
				click(driver, columnHeader);
			}
		}
		waitForDisplay(driver, AG_Grid_Row_CheckBox);
		if (isdisplayed(driver, AG_Grid_Row_CheckBox)) {
			click(driver, AG_Grid_Row_CheckBox);
		}
	}

	// 25-03-25 modified by vignesh
	public String readPdf(String filepath, String input1, String input2) {
		String extractedText = "";

		try {
			File file = new File(filepath);
			PDDocument document = PDDocument.load(file);

			// Extract text from PDF
			PDFTextStripper stripper = new PDFTextStripper();
			String pdfText = stripper.getText(document);

			// Close the document
			document.close();

			// Debug: Print extracted text (optional)
			// System.out.println("Extracted PDF Text: \n" + pdfText);

			// Define dynamic regex pattern
			String regex = "(?i)" + input1 + "\\s*(.*?)\\s*(?=" + input2 + "|$)";

			// Extract value using regex
			extractedText = extractValue(pdfText, regex);

			System.out.println("Extracted Text: " + extractedText);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return extractedText;
	}

	public void verifyMainMenu(WebDriver driver) {

		SimpleDateFormat formatternew = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date datenew = new Date();
		String valuenew = formatternew.format(datenew);

		System.out.println("Verify main menu started : " + valuenew);

		waitForDisplay(driver, main_Menu_ID);
		if (isdisplayed(driver, main_Menu_ID)) {
			click(driver, hide_Menu_ID);
			if (!isdisplayed(driver, main_Menu_ID)) {
				System.out.println(
						"Expected result : Main Menu should be Hided After Clicking The Hide Menu Button || Actual result is : Main Menu Hided After Clicking The Hide Menu Button");
				Extent_pass(driver,
						"Expected result : Main Menu should be Hided After Clicking The Hide Menu Button || Actual result is : Main Menu Hided After Clicking The Hide Menu Button",
						test, test1);
			} else {
				System.out.println(
						"Expected result : Main Menu should be Hided After Clicking The Hide Menu Button || Actual result is : Main Menu not Hided After Clicking The Hide Menu Button");
				Extent_fail(driver,
						"Expected result : Main Menu should be Hided After Clicking The Hide Menu Button || Actual result is : Main Menu not Hided After Clicking The Hide Menu Button",
						test, test1);
			}
		}

		SimpleDateFormat formatternew2 = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date datenew2 = new Date();
		String valuenew2 = formatternew2.format(datenew2);

		System.out.println("Verify main menu Ended : " + valuenew2);

	}

	public void typeText(String text) throws AWTException {

		try {
			wait(driver, WaitForDisplay_Time);
			for (char c : text.toCharArray()) {
				int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
					throw new RuntimeException("Key code not found for character '" + c + "'");
				}

				Robot robot = new Robot();
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);
			}
		} catch (AWTException e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test);
		}
	}

	public void globalValueSearchWindow(WebDriver driver, String Condition, String Search_Type1, String Search_Input1,
			String Search_Type2, String Search_Input2, String Search_Type3, String Search_Input3) {
		waitForElement(driver, type_Select1);
		if (!Search_Type1.equals("")) {
			selectByText(driver, type_Select1, Search_Type1);
		}
		if (!Condition.equals("")) {
			selectByText(driver, globalSearch_Condition_Dropdown1, Condition);
		}
		sendKeys(driver, globalSearch_InputTextfield1, Search_Input1);
		if (!Search_Input2.equals("")) {
			waitForElement(driver, type_Select2);
			selectByText(driver, type_Select2, Search_Type2);
			selectByText(driver, globalSearch_Condition_Dropdown2, Condition);
			sendKeys(driver, globalSearch_InputTextfield2, Search_Input2);
		}
		if (!Search_Input3.equals("")) {
			waitForElement(driver, type_Select3);
			selectByText(driver, type_Select3, Search_Type3);
			selectByText(driver, globalSearch_Condition_Dropdown3, Condition);
			sendKeys(driver, globalSearch_InputTextfield3, Search_Input3);
		}
		click(driver, globalSearch_Frame_SearchButton);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		elementnotvisible1(driver, SelectButton);
	}

	public void selectDatePicker(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		try {
			click(driver, Locator);
			datePicker(DateValue, day, month, year);
			waitForElement(driver, Month_DD);
			selectByText(driver, Month_DD, month.toString());
			waitForElement(driver, Year_DD);
			selectByText(driver, Year_DD, year.toString());
			String date_select = String.format(Date_Select, day);
			click(driver, date_select);
		} catch (Exception e) {
		}
	}

	public void rateRequestDateSelect(WebDriver driver, String date_Perform, String date_Picker, String From_Date_Input,
			String To_Date_Input) {
		if (date_Perform.equalsIgnoreCase("Yes")) {
			waitForElement(driver, From_Date_Field_RR);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, From_Date_Field_RR, From_Date_Input);
			} else {
				waitForElement(driver, From_Date_Field_RR);
				clearAndType(driver, From_Date_Field_RR, From_Date_Input);
			}
			// Selecting the to Date
			waitForElement(driver, To_Date_Field_RR);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, To_Date_Field_RR, To_Date_Input);
			} else {
				waitForElement(driver, To_Date_Field_RR);
				clearAndType(driver, To_Date_Field_RR, To_Date_Input);
			}
		}
	}

	public void rateRequestRoutingDays(WebDriver driver, String Exp_Det_Days_Input, String Imp_Det_Days_Input,
			String Exp_Demmurage_Input, String Imp_Demmurage_Input) {
		waitForDisplay(driver, Exp_Days);
		if (isdisplayed(driver, Exp_Days) && isElementAccessible(driver, Exp_Days)) {
			clear(driver, Exp_Days);
			sendKeys(driver, Exp_Days, Exp_Det_Days_Input);
		}
		if (isdisplayed(driver, Imp_Days) && isElementAccessible(driver, Imp_Days)) {
			clear(driver, Imp_Days);
			sendKeys(driver, Imp_Days, Imp_Det_Days_Input);
		}
		if (isdisplayed(driver, Exp_Demurage) && isElementAccessible(driver, Exp_Demurage)) {
			clear(driver, Exp_Demurage);
			sendKeys(driver, Exp_Demurage, Exp_Demmurage_Input);
		}
		if (isdisplayed(driver, Imp_Demurage) && isElementAccessible(driver, Imp_Demurage)) {
			clear(driver, Imp_Demurage);
			sendKeys(driver, Imp_Demurage, Imp_Demmurage_Input);
		}
	}

	public void rateRequestCustomerExistOption(WebDriver driver) {
		waitForDisplay(driver, CustName_ExitBtn);
		if (isdisplayed(driver, CustName_ExitBtn)) {
			waitForElement(driver, CustName_ExitBtn);
			click(driver, CustName_ExitBtn);
		}
	}

	public void rateRequestPaymentMode_Select(WebDriver driver, String payment_Mode, String Select_type_location,
			String condition, String payLocation) {
		waitForDisplay(driver, paymentMode_Dropdown_RR);
		if (isdisplayed(driver, paymentMode_Dropdown_RR) && isElementAccessible(driver, paymentMode_Dropdown_RR)) {
			waitForElement(driver, paymentMode_Dropdown_RR);
			click(driver, paymentMode_Dropdown_RR);

			formatLocatorClick(driver, DropDown_Select, payment_Mode);
			waitForElement(driver, payLocation_SearchButton_RR);
			if (isdisplayed(driver, payLocation_SearchButton_RR)
					&& isElementAccessible(driver, payLocation_SearchButton_RR)) {
				click(driver, payLocation_SearchButton_RR);
				twoColumnSearchWindow(driver, Select_type_location, condition, payLocation);
			}
		}
	}

	public void selectDatePickerDoubleClick(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		try {
			click(driver, Locator);
			waitForElement(driver, Locator);
			doubleClick(driver, Locator);
			datePicker(DateValue, day, month, year);
			waitForElement(driver, Month_DD);
			selectByText(driver, Month_DD, month.toString());
			waitForElement(driver, Year_DD);
			selectByText(driver, Year_DD, year.toString());
			String date_select = String.format(Date_Select, day);
			click(driver, date_select);
			if (isdisplayed(driver, calender_close)) {
				waitForElement(driver, calender_close);
				click(driver, calender_close);
			}
		} catch (Exception e) {
		}
	}

	public void globalValueSearchWindow1(WebDriver driver, String Condition, String Search_Type1, String Search_Input1,
			String Search_Type2, String Search_Input2, String Search_Type3, String Search_Input3) {
		waitForElement(driver, type_Select1);
		selectByText(driver, type_Select1, Search_Type1);
		selectByText(driver, globalSearch_Condition_Dropdown1, Condition);
		sendKeys(driver, globalSearch_InputTextfield1, Search_Input1);
		if (!Search_Input2.equals("")) {
			waitForElement(driver, type_Select2);
			selectByText(driver, type_Select2, Search_Type2);
			selectByText(driver, globalSearch_Condition_Dropdown2, Condition);
			sendKeys(driver, globalSearch_InputTextfield2, Search_Input2);
		}
		if (!Search_Input3.equals("")) {
			waitForElement(driver, type_Select3);
			selectByText(driver, type_Select3, Search_Type3);
			selectByText(driver, globalSearch_Condition_Dropdown3, Condition);
			sendKeys(driver, globalSearch_InputTextfield3, Search_Input3);
		}
		click(driver, globalSearch_Frame_SearchButton);

	}

	public void globalValueSearchWindowScrollAndSelect(WebDriver driver, String Status_Filter,
			String Status_Filer_Data) {
		waitForElement(driver, DO_horizontal_Scroll);
		horizontalscroll(driver, DO_horizontal_Scroll, 2500);
		waitForElement(driver, Status_Filter);
		sendKeys(driver, Status_Filter, Status_Filer_Data);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
	}

//	public void SwitchProfile(WebDriver driver, String AgencyUser) {
//		if (!AgencyUser.equals("")) {
//			waitForElement(driver, Switch_Profile);
//			safeclick(driver, Switch_Profile);
//			waitForElement(driver, agency_Code_Filter);
//			sendKeys(driver, agency_Code_Filter, AgencyUser);
//			waitForDisplay(driver, select_Agency);
//			if (isdisplayed(driver, select_Agency)) {
//				waitForElement(driver, select_Agency);
//				safeclick(driver, select_Agency);
//				waitForElement(driver, Switch_Profile_Button);
//				safeclick(driver, Switch_Profile_Button);
//			} else {
//				waitForElement(driver, Profile_Dropdown);
//				safeclick(driver, Profile_Dropdown);
//				waitForElement(driver, Corporate_Profile);
//				safeclick(driver, Corporate_Profile);
//				waitForElement(driver, Profile_Dropdown);
//				safeclick(driver, Profile_Dropdown);
//				waitForElement(driver, Location_Profile);
//				safeclick(driver, Location_Profile);
//				waitForElement(driver, agency_Code_Filter);
//				sendKeys(driver, agency_Code_Filter, AgencyUser);
//				waitForElement(driver, select_Agency);
//				safeclick(driver, select_Agency);
//				waitForElement(driver, Switch_Profile_Button);
//				safeclick(driver, Switch_Profile_Button);
//			}
//		}
//	}
	public void SwitchProfile(WebDriver driver, String AgencyUser) {
		if (!AgencyUser.equals("")) {
			waitForElement(driver, Switch_Profile);
			safeclick(driver, Switch_Profile);
			waitForElement(driver, agency_Code_Filter);
			sendKeys(driver, agency_Code_Filter, AgencyUser.trim());
			waitForDisplay(driver, select_Agency);
			if (isdisplayed(driver, select_Agency)) {
				waitForElement(driver, select_Agency);
				safeclick(driver, select_Agency);
				waitForElement(driver, Switch_Profile_Button);
				safeclick(driver, Switch_Profile_Button);
			} else {
				waitForElement(driver, Profile_Dropdown);
				safeclick(driver, Profile_Dropdown);
				waitForElement(driver, Corporate_Profile);
				safeclick(driver, Corporate_Profile);
				waitForElement(driver, Profile_Dropdown);
				safeclick(driver, Profile_Dropdown);
				waitForElement(driver, Location_Profile);
				safeclick(driver, Location_Profile);
				waitForElement(driver, agency_Code_Filter);
				sendKeys(driver, agency_Code_Filter, AgencyUser.trim());
				waitForElement(driver, select_Agency);
				safeclick(driver, select_Agency);
				waitForElement(driver, Switch_Profile_Button);
				safeclick(driver, Switch_Profile_Button);
			}
		}
	}

	public void ResetProfile(WebDriver driver) {
		waitForElement(driver, Switch_Profile);
		safeclick(driver, Switch_Profile);
		waitForElement(driver, reset_Profile_Button);
		safeclick(driver, reset_Profile_Button);
		if (isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}

	}

	public String DateFormatConversion(WebDriver driver, String Date) {
		try {
			// Original date in the format "yyyy-MM-dd HH:mm:ss.S"
			String originalDateStr = Date;

			// Input SimpleDateFormat (the original format of the date string)
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			Date date = inputFormat.parse(originalDateStr); // Parse the string into Date object

			// Output SimpleDateFormat (the desired format for the date string)
			SimpleDateFormat outputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

			// Set the time zone to IST (Indian Standard Time)
			outputFormat.setTimeZone(TimeZone.getTimeZone("IST"));

			// Format the date into the desired string
			String formattedDate = outputFormat.format(date);

			// Print the formatted date
			System.out.println(formattedDate);
			return formattedDate;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "date format was not changed", test, test1);
			return null;

		}
	}

	/*
	 * Used to get the day count
	 */
	public static int countSpecificDay(String startDateStr, String endDateStr, DayOfWeek targetDay) {
		// Convert date strings to LocalDate (assuming the format is d/M/yyyy)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate startDate = LocalDate.parse(startDateStr, formatter);
		LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		int dayCount = 0;
		// Iterate from start date to end date
		while (!startDate.isAfter(endDate)) {
			if (startDate.getDayOfWeek() == targetDay) {
				dayCount++;
			}
			startDate = startDate.plusDays(1);
		}
		return dayCount;
	}
// 12/06/2025 Modified by Ashok

	public String DateFormatConversion1(WebDriver driver, String Date) {
		try {
			// Step 1: Parse the input date format
			SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date originalDate = inputFormat.parse(Date);

			// Step 2: Use calendar to zero out seconds and milliseconds
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(originalDate);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			Date updatedDate = calendar.getTime();

			// Step 3: Convert to desired output format
			SimpleDateFormat outputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
			outputFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // or whatever zone you want

			String updatedDateStr = outputFormat.format(updatedDate);

			System.out.println("Updated Date: " + updatedDateStr);
			return updatedDateStr;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "date format was not changed", test, test1);
			return null;
		}
	}

	public long dayCount(String StartDateInput, String Current_Date, String Count_Of_Days) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Parse the "from" and "to" dates using LocalDate
		LocalDate fromDate = LocalDate.parse(StartDateInput, formatter);
		LocalDate toDate = LocalDate.parse(Current_Date, formatter);

		// Calculate the number of days between the two dates, inclusive of both start
		// and end dates
		long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate) + 1; // +1 to include both start and end dates

		// Print the result
		System.out.println("Number of days between " + fromDate + " and " + toDate + " is: " + daysBetween);

		long Count_Of_Day = Long.parseLong(Count_Of_Days);
		long Count_days = (daysBetween / Count_Of_Day) + 1;

		System.out.println(" Count of Days " + Count_Of_Days + " and Batch generated : " + Count_days);
		return Count_days;

	}

	/*
	 * Used to convert The Day
	 */
	public String convertWeekDays(String Day) {
		String day = "";
		if (Day.equals("Mon")) {
			day = "MONDAY";
		} else if (Day.equals("Tue")) {
			day = "TUESDAY";
		} else if (Day.equals("Wed")) {
			day = "WEDNESDAY";
		} else if (Day.equals("Thu")) {
			day = "THURSDAY";
		} else if (Day.equals("Fri")) {
			day = "FRIDAY";
		} else if (Day.equals("Sat")) {
			day = "SATURDAY";
		} else if (Day.equals("Sun")) {
			day = "SUNDAY";
		}
		return day;
	}

	/*
	 * Used to wait for the presence of the Element in the page
	 */
	public void waitForPresenceOfElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//div[contains(@class,'blockUI blockMsg blockElement')]//span[text()='Processing..']")));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			Extent_pass(driver, "Waiting for the " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Element is not present " + values[0] + " -> " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + values[0] + e.getLocalizedMessage());
		}
	}

	public static List<String> readColumnDataFromExcel_firstrow(String excelFilePath, String columnName,
			String sheetName) throws IOException, EncryptedDocumentException, InvalidFormatException {
		List<String> dataList = new ArrayList<>();

		try (FileInputStream file = new FileInputStream(new File(excelFilePath));
				Workbook workbook = WorkbookFactory.create(file)) { // Auto-detects .xls or .xlsx

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet '" + sheetName + "' not found.");
			}

			// Get the column index based on row 2 (index 1)
			int columnIndex = getColumnIndexByName1(sheet, columnName);
			if (columnIndex == -1) {
				throw new IllegalArgumentException("Column '" + columnName + "' not found in row 2.");
			}

			// Iterate from row 3 (index 2) to get column data
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell cell = row.getCell(columnIndex);
					if (cell != null) {
						dataList.add(getCellValueAsString2(cell));
					}
				}
			}

		} catch (OLE2NotOfficeXmlFileException e) {
			System.err.println(
					"Error: The file appears to be an OLE2 (Excel 97-2003) format. Ensure it is a valid Excel file.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	public static int getColumnIndexByName1(Sheet sheet, String columnName) {
		Row headerRow = sheet.getRow(0); // Excel row 1 = index 0
		if (headerRow == null)
			return -1;

		for (Cell cell : headerRow) {
			if (cell.getCellTypeEnum() == CellType.STRING
					&& cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
				return cell.getColumnIndex();
			}
		}
		return -1;
	}

	/*
	 * Used to get the first row value by using column header
	 */
	public String getFirstRowValueByHeaderFromTableData(List<Map<String, String>> tableData, String columnHeader) {
		if (tableData == null || tableData.isEmpty()) {
			return null; // No data available
		}
		// Get the first row (which is at index 0)
		Map<String, String> firstRow = tableData.get(0);
		// Check if the column header exists in the first row
		if (firstRow.containsKey(columnHeader)) {
			// Return the value for the column header in the first row
			return firstRow.get(columnHeader);
		}
		// Return null if the column header is not found
		return null;
	}

	public void reArrangeAG_GridColumnsNew(WebDriver driver, String Locator, String Select_Columns) {
		waitForElement(driver, Locator);
		safeclick(driver, Locator);
		waitForElement(driver, Column_Search_Input);
		safeclick(driver, SelectAll_Column_CheckBox);
		List<String> columns = splitAndExpand(Select_Columns);
		for (String column : columns) {
			waitForElement(driver, Column_Search_Input);
			Newclear(driver, Column_Search_Input);
			waitForElement(driver, Column_Search_Input);
			sendKeys(driver, Column_Search_Input, column);

			String check_box = String.format(Select_Column_tableHead, column, column);
			waitForDisplay(driver, check_box);
			jsClick(driver, check_box);
		}
		waitForElement(driver, Locator);
		click(driver, Locator);
	}

	public void reArrangeAG_GridColumns(WebDriver driver, String Select_Columns) {
		waitForElement(driver, AG_Grid_Columns_Button);
		safeclick(driver, AG_Grid_Columns_Button);
		waitForElement(driver, AG_Grid_Column_All_Select_Checkbox);
		safeclick(driver, AG_Grid_Column_All_Select_Checkbox);
		String actualStatus = getAttribute(driver, AG_Grid_Column_All_Select_Checkbox, "class");
		if (actualStatus.contains("checked")) {
			safeclick(driver, AG_Grid_Column_All_Select_Checkbox);
		}
		List<String> columns = splitAndExpand(Select_Columns, ",");
		for (String column : columns) {
			waitForElement(driver, AG_Grid_Column_Searchbox);
			clear(driver, AG_Grid_Column_Searchbox);
			waitForElement(driver, AG_Grid_Column_Searchbox);
			sendKeys(driver, AG_Grid_Column_Searchbox, column);
			String check_box = String.format(column + AG_Grid_Column_Checkboxs, column, column);
			click(driver, check_box);
		}
		waitForElement(driver, AG_Grid_Columns_Button);
		click(driver, AG_Grid_Columns_Button);
	}

	public void reArrangeAG_GridColumns_Expense_Report(WebDriver driver, String Select_Columns) {
		waitForElement(driver, Expense_AG_Grid_Column);
		safeclick(driver, Expense_AG_Grid_Column);
		waitForElement(driver, Expense_AG_Grid_Select_All_Checkbox);
		safeclick(driver, Expense_AG_Grid_Select_All_Checkbox);
		List<String> columns = splitAndExpand(Select_Columns);
		for (String column : columns) {
			waitForElement(driver, Expense_AG_Grid_Searchbox);
			clear(driver, Expense_AG_Grid_Searchbox);
			waitForElement(driver, Expense_AG_Grid_Searchbox);
			sendKeys(driver, Expense_AG_Grid_Searchbox, column);
			String check_box = String.format(column + AG_Grid_Column_Checkboxs1, column, column);
			click(driver, check_box);
		}
		waitForElement(driver, Expense_AG_Grid_Column);
		click(driver, Expense_AG_Grid_Column);
	}

	public void AGGridValueSearchFilter(WebDriver driver, String Column_Header, String Condition_Filter, String value) {
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);
		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		List<String> headers = splitAndExpand(Column_Header, ",");
		List<String> inputValues = splitAndExpand(value, ",");
		for (int i = 0; i < headers.size(); i++) {
			String givenHeader = headers.get(i);
			String inputValue = inputValues.get(i);
			String columnHeader = String.format(AG_Grid_Headers, givenHeader, givenHeader);
			waitForElement(driver, columnHeader);
			String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
			String filterField = String.format(AG_Grid_Filter_Field, columnIndex, columnIndex);
			String filterButton = String.format(AG_Grid_Filter_Button, columnIndex, columnIndex);
			waitForElement(driver, filterField);
			clear(driver, filterField);
			waitForElement(driver, filterField);
			sendKeys(driver, filterField, inputValue);
			if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
				waitForElement(driver, filterButton);
				click(driver, filterButton);
				waitForElement(driver, Filter_Operator);
				click(driver, Filter_Operator);
				waitForElement(driver, Equals_Option);
				click(driver, Equals_Option);
				waitForElement(driver, columnHeader);
				click(driver, columnHeader);
			}
		}
	}

	public void waitForDownload(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(downloadWait));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(downloadWait));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
		} catch (Exception e) {
			Extent_fail(driver, "Element is not present " + values[0] + e.getLocalizedMessage(), test, test1);
			verifyServerStatus(driver);
			Assert.fail();
		}
	}

	public List<Map<String, String>> extractTableDataDirect2(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			// Wait for the table to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate the table container
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));

			// Get all headers and their respective aria-colindex values
			List<WebElement> headerElements = tableContainer
					.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));

			Map<Integer, String> columnIndexToHeader = new HashMap<>();
			for (WebElement header : headerElements) {
				String colIndex = header.getDomAttribute("aria-colindex");
				if (colIndex != null) {
					columnIndexToHeader.put(Integer.parseInt(colIndex), header.getText().trim());
				}
			}

			// Get all rows
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eCenterContainer']//div[@role='row']"));

			// Store table data
			List<Map<String, String>> tableData = new ArrayList<>();

			// Iterate through rows
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-auto')]"));
				Map<String, String> rowData = new HashMap<>();

				for (WebElement cell : cells) {
					String colIndex = cell.getDomAttribute("aria-colindex");
					if (colIndex != null) {
						int index = Integer.parseInt(colIndex);
						String header = columnIndexToHeader.get(index);
						if (header != null) {
							rowData.put(header, cell.getText().trim());
						}
					}
				}

				if (!rowData.isEmpty()) {
					tableData.add(rowData);
				}
			}

			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	public Map<String, Map<String, String>> getRowValuesByHeaders(List<Map<String, String>> tableData,
			List<String> headers, String rowCount) {
		// Initialize the result list
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();

		Map<String, String> headvalues = new HashMap<String, String>();
		// Iterate over each row in the table data
		for (Map<String, String> rowData : tableData) {
			// Iterate over the headers to maintain the order
			for (String header : headers) {
				// If the header does not exist, add null
				String value = rowData.get(header);
				// System.out.println("value : "+value);
				headvalues.put(header, value);
			}
		}
		// System.out.println("headvalues : "+headvalues);
		result.put(rowCount, headvalues);
		// Return the list of values grouped by headers
		return result;
	}

	public static String extractVariableName(String formula) {
		Pattern pattern = Pattern.compile("#(\\w+)#");
		Matcher matcher = pattern.matcher(formula);
		return matcher.find() ? matcher.group(1) : null;
	}

	public String TableDataForMatchingRow(WebDriver driver, List<Map<String, String>> tableData, String tableName,
			List<String> excelHeaders, String matchHeader, String matchValue) {

		// Determine maximum column widths
		int[] columnWidths = new int[excelHeaders.size()];

		// Initialize widths based on header lengths
		for (int i = 0; i < excelHeaders.size(); i++) {
			columnWidths[i] = excelHeaders.get(i).length();
		}

		// Find matching row and update widths
		Map<String, String> matchedRow = null;
		for (Map<String, String> row : tableData) {
			String value = getCaseInsensitiveValue(row, matchHeader);
			if (value != null && value.equalsIgnoreCase(matchValue)) {
				matchedRow = row;

				// Update column widths based on matched row
				for (int i = 0; i < excelHeaders.size(); i++) {
					String val = getCaseInsensitiveValue(row, excelHeaders.get(i));
					if (val != null) {
						columnWidths[i] = Math.max(columnWidths[i], val.length());
					}
				}
				break; // Only the first matched row is printed
			}
		}

		// Return if no match found
		if (matchedRow == null) {
			return "<p>No matching row found for " + matchHeader + " = " + matchValue + "</p>";
		}

		// StringBuilder for HTML table
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<h3>").append(tableName).append("</h3>");
		tableBuilder.append("<table style='width:100%; border-collapse: collapse;'>");
		tableBuilder.append("<thead><tr>");

		StringBuilder headerRow = new StringBuilder();
		for (String header : excelHeaders) {
			tableBuilder.append("<th style='border: 1px solid #ddd; padding: 8px;'>").append(header).append("</th>");
			headerRow.append(String.format("%-" + (columnWidths[excelHeaders.indexOf(header)] + 2) + "s", header));
		}
		tableBuilder.append("</tr></thead><tbody>");

		int lineLength = Arrays.stream(columnWidths).sum() + 2 * columnWidths.length;
		String separator = repeatChar('-', lineLength);

		System.out.println(separator);
		System.out.println(tableName + " : ");
		System.out.println(separator);
		System.out.println(headerRow.toString());
		System.out.println(separator);

		// Only print the matched row
		tableBuilder.append("<tr>");
		StringBuilder rowOutput = new StringBuilder();
		for (String header : excelHeaders) {
			String value = getCaseInsensitiveValue(matchedRow, header);
			if (value != null) {
				tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>").append(value).append("</td>");
				rowOutput.append(String.format("%-" + (columnWidths[excelHeaders.indexOf(header)] + 2) + "s", value));
			} else {
				tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>N/A</td>");
				rowOutput.append(String.format("%-" + (columnWidths[excelHeaders.indexOf(header)] + 2) + "s", "N/A"));
			}
		}
		tableBuilder.append("</tr>");
		tableBuilder.append("</tbody></table>");

		System.out.println(rowOutput.toString());
		System.out.println(separator);

		return tableBuilder.toString();
	}

	public static double getNumberValue(String value) {

		double numberValue = 0;
		try {
			if (value.contains(",")) {
				value = value.replace(",", "");
			}
			numberValue = Double.parseDouble(value);
			numberValue = Double.parseDouble(String.format("%.2f", numberValue));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return numberValue;

	}

	public static boolean compareAmounts(double expected, double actual, double tolerance) {
		if (Math.abs(expected - actual) <= tolerance) {
			return true; // Values are considered equal within the acceptable range
		} else {
			return false;
		}
	}

	/*
	 * Used to get the table value
	 */
	public List<Map<String, String>> extractTableDataDirect1(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			// Wait until the table is present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate the parent div containing the table data
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));

			// Get all header cells
			List<WebElement> headers = tableContainer
					.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));

			// Store headers in a list
			List<String> columnHeaders = new ArrayList<>();
			for (WebElement header : headers) {
				columnHeaders.add(header.getText().trim());
			}

			// Get all rows from the container
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));

			// List to store each row as a map
			List<Map<String, String>> tableData = new ArrayList<>();

			// Iterate through the rows
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-value')]"));

				// Ensure the number of cells matches the number of headers
				if (cells.size() == columnHeaders.size()) {
					Map<String, String> rowData = new HashMap<>();
					for (int i = 0; i < cells.size(); i++) {
						rowData.put(columnHeaders.get(i), cells.get(i).getText().trim());
					}
					tableData.add(rowData);
				} else {
					System.out.println("Row cell count mismatch with header count.");
				}
			}

			return tableData;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	/*
	 * Used to get the Column value From the table data by using the column header
	 */
	public static List<String> extractDataByHeader(WebDriver driver, List<Map<String, String>> tableData,
			String columnHeader) {
		// Check if the table data is null or empty
		if (tableData == null || tableData.isEmpty()) {
			System.out.println("Table data is empty or null.");
			return new ArrayList<>();
		}

		// Extract column values
		List<String> columnValues = new ArrayList<>();
		for (Map<String, String> row : tableData) {
			if (row.containsKey(columnHeader)) {
				columnValues.add(row.get(columnHeader));
			} else {
				System.out.println("Warning: Row does not contain the column header: " + columnHeader);
			}
		}

		return columnValues;
	}

	/*
	 * Used to Get the Column values in excel sheet by using Column header
	 */
	public static List<String> getExcelColumnDataByHeader(String filePath, String sheetName, String columnHeader)
			throws IOException, InvalidFormatException {
		String filepath = ".\\uploads\\" + filePath;
		File file = new File(filepath);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetName);
		// Get the first row (headers)
		Row headerRow = sheet.getRow(0);
		// Find the column index for the specified header
		int columnIndex = -1;
		for (Cell cell : headerRow) {
			if (cell.getStringCellValue().equalsIgnoreCase(columnHeader)) {
				columnIndex = cell.getColumnIndex();
				break;
			}
		}
		// If column is not found, return an empty list
		if (columnIndex == -1) {
			System.out.println("Column header not found.");
			workbook.close();
			return new ArrayList<>();
		}
		// Get all data from the found column
		List<String> columnData = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.iterator();
		// Skip the header row (already processed)
		rowIterator.next();
		// Iterate through the rows and get values from the column
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell cell = row.getCell(columnIndex);
			// Handle the case where the cell is empty
			if (cell != null) {
				columnData.add(cell.toString());
			} else {
				columnData.add(""); // Add empty string if cell is blank
			}
		}
		workbook.close();
		return columnData;
	}

	/*
	 * Used to get the count of unique value in column value
	 */
	public static int getUniqueCountFromList(List<String> dataList) {
		// Using a Set to store unique values
		Set<String> uniqueValues = new HashSet<>(dataList);
		// The size of the Set gives the count of unique elements
		return uniqueValues.size();
	}

	/*
	 * Used to click the web element
	 */
	public void Click(WebDriver driver, WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			element.click();
			Extent_pass(driver, "Click on Element", test, test1);

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to click on Element " + e.getLocalizedMessage(), test, test1);

			Assert.fail();
			verifyServerStatus(driver);
		}

	}

	/*
	 * Used to wait the invisibility of element
	 */
	public void elementnotvisible(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			for (int i = 1; i <= WaitElementSeconds; i++) {
				boolean flag = webElement.isDisplayed();
				if (flag == true) {
					wait(driver, WaitForDisplay_Time);
				} else {
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	/*
	 * Used to Upload the file
	 */
	public void uploadfile2(WebDriver driver, String path) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
		}
	}

	// vignesh
	public static boolean CompareDateValues(String dateStr1, String dateStr2) {
		List<DateTimeFormatter> formatters = Arrays.asList(DateTimeFormatter.ofPattern("dd/MM/yyyy"),
				DateTimeFormatter.ofPattern("MM/dd/yyyy"), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm") // Corrected
		// time
		// format
		);

		LocalDate date1 = parseToDate(dateStr1, formatters);
		LocalDate date2 = parseToDate(dateStr2, formatters);

		return date1 != null && date2 != null && date1.equals(date2);
	}

	private static LocalDate parseToDate(String dateStr, List<DateTimeFormatter> formatters) {
		for (DateTimeFormatter formatter : formatters) {
			try {
				// Try parsing as LocalDate
				return LocalDate.parse(dateStr, formatter);
			} catch (DateTimeParseException ignored) {
			}

			try {
				// Try parsing as LocalDateTime (if time is included) and extract LocalDate
				return LocalDateTime.parse(dateStr, formatter).toLocalDate();
			} catch (DateTimeParseException ignored) {
			}
		}
		return null; // Return null if no valid format is found
	}

	/*
	 * Used to verify the particular element is having the text
	 */
	public boolean verifyElementHasText(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		boolean temp = false;
		try {
			String text = driver.findElement(By.xpath(values[1])).getText();
			if (text.equals("")) {
				temp = false;
				verifyServerStatus(driver);
				Assert.fail();

			} else {
				temp = true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, values[0] + " is Not Available", test, test1);
			verifyServerStatus(driver);
			global.add(values[0] + " is Not Available");
			Assert.fail();
		}
		return temp;
	}

	/*
	 * Used to wait for the Visibility of the Element in the page (30 seconds)
	 */
	public void waitForElement(WebDriver driver, WebElement element) {
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			Extent_pass(driver, "Waiting for the Element", test, test1);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - ");
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to wait and click the particular Element
	 */
	public void click(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
			WebElement element = driver.findElement(By.xpath(values[1]));
			element.click();
			Extent_pass(driver, "Click on " + values[0], test, test1);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to click on " + values[0] + "  " + e.getLocalizedMessage(), test, test1);
			global.add("Unable to click on - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
	}

	public void twoColumnMultipleSearchWindow(WebDriver driver, String Column_Header, String Condition_Filter,
			String value) {
		List<String> headers = splitAndExpand(Column_Header, ",");
		List<String> inputValues = splitAndExpand(value, ",");

		String columnValuesLocator = "";
		String filterButton = "";
		String columnHeader = "";
		String inputValue = "";
		for (int i = 0; i < headers.size(); i++) {
			String givenHeader = headers.get(i);
			inputValue = inputValues.get(i);
			columnHeader = String.format(two_Column_Search_Column_Header, givenHeader);
			waitForElement(driver, columnHeader);
			String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");

			String filterField = String.format(Filter_Input_Field, columnIndex);
			filterButton = String.format(Filter_Button, columnIndex);
			columnValuesLocator = String.format(column_Value, columnIndex);

			waitForElement(driver, filterField);
			sendKeys(driver, filterField, inputValue);
		}
		if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
			applyEqualsFilter(driver, filterButton, columnHeader, columnValuesLocator);
			waitForElement(driver, columnValuesLocator);
			click(driver, columnValuesLocator);
		} else {
			selectMatchingValue(driver, columnValuesLocator, inputValue);
		}
		waitForElement(driver, select_Button);
		click(driver, select_Button);
	}

	public void twoColumnMultipleSearchWindowWithScroll(WebDriver driver, String Column_Header, String Condition_Filter,
			String value, String scrollLength) {
		List<String> headers = splitAndExpand(Column_Header, ",");
		List<String> inputValues = splitAndExpand(value, ",");
		String columnValuesLocator = "";
		String filterButton = "";
		String columnHeader = "";
		String inputValue = "";
		int length = Integer.parseInt(scrollLength);
		for (int i = 0; i < headers.size(); i++) {
			String givenHeader = headers.get(i);
			inputValue = inputValues.get(i);
			columnHeader = String.format(two_Column_Search_Column_Header, givenHeader);
			waitForDisplay(driver, columnHeader);
			if (!isdisplayed(driver, columnHeader) && isdisplayed(driver, searchBookNo_Scrollbar)) {
				horizontalscroll(driver, searchBookNo_Scrollbar, length);
			}
			waitForElement(driver, columnHeader);
			String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
			String filterField = String.format(Filter_Input_Field, columnIndex);
			filterButton = String.format(Filter_Button, columnIndex);
			columnValuesLocator = String.format(column_Value, columnIndex);
			waitForElement(driver, filterField);
			sendKeys(driver, filterField, inputValue);
		}
		if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
			applyEqualsFilter(driver, filterButton, columnHeader, columnValuesLocator);
			waitForElement(driver, columnValuesLocator);
			click(driver, columnValuesLocator);
		} else {
			selectMatchingValue(driver, columnValuesLocator, inputValue);
		}
		waitForElement(driver, select_Button);
		click(driver, select_Button);
	}

	private void applyEqualsFilter(WebDriver driver, String filterButton, String columnHeader,
			String columnValuesLocator) {
		waitForElement(driver, filterButton);
		click(driver, filterButton);
		waitForElement(driver, Filter_Operator);
		click(driver, Filter_Operator);
		waitForElement(driver, Equals_Option);
		click(driver, Equals_Option);
		waitForElement(driver, columnHeader);
		click(driver, columnHeader);

	}

	public String Getdate() {

		String formattedDate = "";
		try {
			LocalDate today = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			formattedDate = today.format(formatter);
			System.out.println(formattedDate);

		} catch (Exception e) {

		}
		return formattedDate;
	}

	private void selectMatchingValue(WebDriver driver, String columnValuesLocator, String expectedValue) {
		List<WebElement> columnValues = listOfElements(driver, columnValuesLocator);
		boolean valueFound = false;

		for (WebElement columnValue : columnValues) {
			if (columnValue.getText().contains(expectedValue)) {
				Click(driver, columnValue);
				valueFound = true;
				break;
			}
		}

		if (!valueFound) {
			Extent_fail(driver, expectedValue + " The value is Not found in the current window", test, test1);
		}
	}

	/*
	 * Used to perform the Right click action for the particular element
	 */
	public void RightClick(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}

		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
			builder.contextClick(element).build().perform();
			Extent_pass(driver, "Able to click on " + values[0] + "- ", test, test1);
			wait(driver, "1");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to upload the file in to application
	 */
	public void uploadfile1(WebDriver driver, String xpath, String path) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = driver.findElement(By.xpath(values[1]));
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			Extent_pass(driver, "uploaded the file " + path, test, test);

			// Fileupload will take sometimes so we gave some manual wait for that

			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			Extent_fail(driver, "upload is falied - " + path + e.getLocalizedMessage(), test, test);
			e.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Used to Send the value to the particular Element
	 */
	public String getText1(WebDriver driver, WebElement element) {
		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			verifyServerStatus(driver);
			Assert.fail();

			return null;
		}
	}

	public String extractValue(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return "Not found"; // Return a default message if no match is found
	}

	/*
	 * Used to scroll down to element by using that elements height
	 */
	public void scrollDownByHeight(WebDriver driver, String xpath) {

		String[] splitXp = xpath.split(">");
		try {
			WebElement element = driver.findElement(By.xpath(splitXp[1]));
			Dimension ele = element.getSize();
			int height = ele.getHeight();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop += " + height + ";", element);
			Extent_pass(driver, "Scrolled to " + splitXp[0], test, test1);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to scroll " + splitXp[0], test, test1);
			Assert.fail();
		}
	}

	/*
	 * Used to Upload The File
	 */
	public void uploadfile_new(WebDriver driver, String xpath, String excelpath) {

		String filepath = System.getProperty("user.dir") + "/uploads/" + excelpath;

		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = driver.findElement(By.xpath(values[1]));
			File file = new File(filepath);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			Extent_pass(driver, values[0] + "Scucessfully uploaded the " + excelpath, test, test1);

			// File upload may take some time, so we gave some manual wait here
			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, values[0] + "Failed to upload the " + excelpath + e, test, test1);
		}
	}

	/*
	 * Used to get the row count from the Excel sheet
	 */
	public String rowcountxls(WebDriver driver, String excelpath, String sheetName) {

		String filepath = ".\\uploads\\" + excelpath; // Corrected file path reference
		int dataRows = 0; // Declare variable outside try block

		try {
			FileInputStream file = new FileInputStream(new File(filepath));
			Workbook workbook = WorkbookFactory.create(file); // Auto-detect .xls or .xlsx
			Sheet sheet = workbook.getSheet(sheetName); // Get sheet by name

			if (sheet == null) {
				System.out.println("Sheet with name '" + sheetName + "' not found.");
			} else {
				int totalRows = sheet.getPhysicalNumberOfRows(); // Counts non-empty rows
				dataRows = (totalRows > 1) ? totalRows - 1 : 0; // Exclude header row
				System.out.println("Total rows (excluding header): " + dataRows);
			}

			workbook.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(dataRows); // Convert int to String as return type is String
	}

	/*
	 * Used to open the new tab
	 */
	public void newTab(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		// Switch to the new tab
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		wait(driver, WaitForDisplay_Time);
		driver.switchTo().window(tab.get(tab.size() - 1));
		wait(driver, WaitForDisplay_Time);
	}

	/*
	 * Used to Navigate the URL without server check
	 */
	public void NavigateUrl(WebDriver driver, String inputData) {
		try {
			if (inputData == null) {
				Assert.fail(inputData);
			} else {
				driver.navigate().to(inputData);
				Extent_pass(driver, "Navigated to " + inputData, test, test1);
			}
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			e.printStackTrace();
			Assert.fail();
		}

	}

	/*
	 * Used to Download and get the file path of .jnlp file
	 */
	public String downloadJNLPFilePath(WebDriver driver, String pdfLinkXPath) throws IOException {
		// Get default download folder path based on the operating system
		String[] values = splitXpath(pdfLinkXPath);
		String downloadFolder = getDefaultDownloadFolderPath();
		String downloadedFilePath = null; // Variable to store the downloaded file path
		try {
			// Locate the PDF download link
			WebElement pdfLink = driver.findElement(By.xpath(values[1]));
			pdfLink.click(); // Click the link to download the PDF (assuming the link directly opens the PDF)
			// Wait for the PDF to be downloaded (adjust the sleep time as needed)
			wait(driver, WaitForDisplay_Time);// This time can be adjusted based on your internet speed and PDF size
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "PDF is Not Downloaded " + e.getLocalizedMessage(), test, test);
		}
		File downloadDir = new File(downloadFolder);
		if (downloadDir.exists() && downloadDir.isDirectory()) {
			// Filter for .pdf files in the download folder (if there are multiple, you can
			// pick the latest)
			File[] files = downloadDir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".jnlp"); // Only consider .pdf files
				}
			});
			if (files != null && files.length > 0) {
				// Sort files by the last modified date, with the most recent file first
				Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));
				// Get the most recent downloaded PDF file
				File downloadedPDF = files[0];
				downloadedFilePath = downloadedPDF.getAbsolutePath(); // Get the full file path
				System.out.println("PDF downloaded successfully at: " + downloadedFilePath);
				Extent_pass(driver, "PDF downloaded successfully at: " + downloadedFilePath, test, test);
			} else {
				System.out.println("PDF download failed. No PDF found in the download folder.");
				Extent_fail(driver, "PDF download failed. No PDF found in the download folder.", test, test);
			}
		} else {
			System.out.println("Download folder does not exist or is not a directory.");
			Extent_fail(driver, "Download folder does not exist or is not a directory.", test, test);
		}
		return downloadedFilePath;
	}

	/*
	 * Used to Scroll the particular element
	 */
	public void scrollToElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds)); // 10 seconds wait
		try {
			// Wait for the element to be visible
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			// wait.until(ExpectedConditions.visibilityOf(element));
			// Attempt to scroll to the element with retries
			for (int i = 0; i < 3; i++) { // Retry up to 3 times
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					break; // Break if successful
				} catch (Exception e) {
					System.err.println("Scroll attempt " + (i + 1) + " failed: " + e.getMessage());
					if (i == 2) { // On the last attempt, fail
						verifyServerStatus(driver); // Assuming this method checks the server status
						Assert.fail("Scrolling failed after multiple attempts.");
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Element not visible or other issue: " + e.getMessage());
			verifyServerStatus(driver); // Check server status in case of failure
			Assert.fail("Scrolling failed due to an exception: " + e.getMessage());
		}
	}

	/*
	 * Used to verify the particular element is not present
	 */
	public boolean verifyElementIsNotPresent(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			element.isDisplayed();
			Assert.fail();
			Extent_fail(driver, values[0] + " is Displayed", test, test1);
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	/*
	 * Used to verify mail
	 */
	public void mail_Verification(WebDriver driver, String Mail_SignIn_Page_Url, String mailId, String mailPassword,
			String subjectText) throws InterruptedException {
		String[] mail = splitXpath(Email_Text_Field);
		String[] password = splitXpath(mail_Password_Text_Field);
		String[] passwordNext = splitXpath(mail_Password_Next_Button);
		String[] mailNext = splitXpath(Email_Next_Button);
		String[] inbox = splitXpath(mail_Inbox);
		String[] refresh = splitXpath(mail_Refresh);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
		newTab(driver);
		NavigateUrl(driver, Mail_SignIn_Page_Url);
		try {
			WebElement inboxelement = driver.findElement(By.xpath(inbox[1]));
		} catch (Exception e1) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			try {
				WebElement emailField = driver.findElement(By.xpath(mail[1]));
				emailField.sendKeys(mailId); // Enter your email
				Extent_pass(driver, "Type on " + mail[0] + " -> The Typing Value is : " + mailId, test, test1);
			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver, "Unable to type on " + mail[0] + "  " + e.getLocalizedMessage() + "  "
						+ "The Typing Value is : " + mailId, test, test1);
			}
			try {
				driver.findElement(By.xpath(mailNext[1])).click();
				Extent_pass(driver, "Click on " + mailNext[0], test, test1);
				wait(driver, WaitForDisplay_Time); // Wait for the password field to appear
			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver, "Unable to click on " + mailNext[0] + "  " + e.getLocalizedMessage(), test, test1);
			}
			try {
				WebElement passwordField = driver.findElement(By.xpath(password[1]));
				passwordField.sendKeys(mailPassword); // Enter your password
				Extent_pass(driver, "Type on " + password[0] + " -> The Typing Value is : " + mailPassword, test,
						test1);
			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver, "Unable to type on " + password[0] + "  " + e.getLocalizedMessage() + "  "
						+ "The Typing Value is : " + mailPassword, test, test1);
			}
			try {
				driver.findElement(By.xpath(passwordNext[1])).click();
				Extent_pass(driver, "Click on " + passwordNext[0], test, test1);
				wait(driver, WaitForDisplay_Time); // Wait for the inbox to load
			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver, "Unable to click on " + passwordNext[0] + "  " + e.getLocalizedMessage(), test,
						test1);
			}
		}
		try {
			// Step 4: Verify if the inbox is loaded
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inbox[1])));

			WebElement inboxElement = driver.findElement(By.xpath(inbox[1]));
			if (inboxElement != null) {
				System.out.println("Inbox loaded successfully!");
				Extent_pass(driver, "Inbox loaded successfully!", test, test1);
			} else {
				System.out.println("Failed to load inbox.");
				Extent_fail(driver, "Failed to load inbox.", test, test1);
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inbox[1])));
			inboxElement = driver.findElement(By.xpath(inbox[1]));
			inboxElement.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(refresh[1])));
			WebElement refreshElement = driver.findElement(By.xpath(refresh[1]));
			refreshElement.click();
			// Step 5: Optionally, check for a specific email in the inbox (e.g., by
			// subject)
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span//span[contains(text(), '" + subjectText + "')]")));
			WebElement emailElement = driver
					.findElement(By.xpath("//span//span[contains(text(), '" + subjectText + "')]"));
			if (emailElement != null) {
				emailElement.click();
				System.out.println("Email received Succesfully The Mail Subject is : " + subjectText);
				Extent_pass(driver, "Email received Succesfully The Mail Subject is : " + subjectText, test, test1);
			} else {
				System.out.println("Email not found.");
				Extent_fail(driver, "Email not found.", test, test1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to find the element " + inbox[0] + "  " + e.getLocalizedMessage(), test, test1);
		}
		closeTab(driver);
	}

	public void mailinator_Verification(WebDriver driver, String mailinatorInboxUrl, String MailId, String subjectText)
			throws InterruptedException {
		try {
			// Extract just the mailbox part (before '@')
			String mailinatorEmailId = MailId.split("@")[0];
			mailinatorInboxUrl = mailinatorInboxUrl + mailinatorEmailId;

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			newTab(driver);
			NavigateUrl(driver, mailinatorInboxUrl);

			Extent_pass(driver, "📬 Navigated to Mailinator inbox URL: <b>" + mailinatorInboxUrl
					+ "</b><br>For the email ID: <b>" + MailId + "</b>", test, test1);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//tbody//tr[contains(.,'" + subjectText + "')]")));

			WebElement emailRow = driver.findElement(By.xpath("//tbody//tr[contains(.,'" + subjectText + "')]"));
			if (emailRow != null) {
				emailRow.click();
				Extent_pass(driver, "📨 Email with subject <b>'" + subjectText
						+ "'</b> found and clicked successfully in Mailinator inbox.", test, test1);
				wait(driver, WaitForDisplay_Time); // Wait for email content to load

				driver.switchTo().frame("html_msg_body");
				WebElement bodyContent = driver.findElement(By.tagName("body"));

				if (bodyContent != null) {
					String mailContent = bodyContent.getText();
					System.out.println("Email Content:\n" + mailContent);

					if (mailContent.trim().length() > 0) {
						Extent_pass(driver, "✅ Email content loaded successfully.<br><b>Mail Preview:</b><br><pre>"
								+ mailContent + "</pre>", test, test1);
					} else {
						Extent_fail(driver,
								"⚠️ Email frame loaded but the content appears empty. Please verify the email content.",
								test, test1);
					}
				} else {
					Extent_fail(driver,
							"❌ Email content frame loaded, but no <body> element found. Possible rendering issue.",
							test, test1);
				}
			} else {
				Extent_fail(driver, "❌ Could not find any email with subject <b>'" + subjectText
						+ "'</b> in inbox of <b>" + MailId + "</b>.<br>Make sure the email was sent.", test, test1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "💥 Exception occurred while verifying Mailinator for <b>" + MailId + "</b>:<br><pre>"
					+ e.getLocalizedMessage() + "</pre>", test, test1);
		} finally {
			closeTab(driver);
		}
	}

	/*
	 * Used to get the Last row value by given column header
	 */
	public String getLastRowValueByHeader(List<Map<String, String>> tableData, String headerName) {
		if (tableData == null || tableData.isEmpty()) {
			return null; // Return null if no data is available
		}
		Map<String, String> lastRow = tableData.get(tableData.size() - 1);
		return lastRow.get(headerName);
	}

	public static boolean isSecondDateBeforeFirst(String firstDateStr, String secondDateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date firstDate = sdf.parse(firstDateStr);
			Date secondDate = sdf.parse(secondDateStr);
			if (secondDate.before(firstDate)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false; // Return false if parsing fails
		}
	}

	/*
	 * Used to perform the doubleClick action on the element in the page by passing
	 * the WebElement as argument proving the WebElement and perform the Double
	 * Click action on the element
	 */
	public void doubleClick1(WebDriver driver, WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			Actions action = new Actions(driver).doubleClick(element);
			action.build().perform();
			Extent_pass(driver, "Able to click on element" + "- ", test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to click on element- " + e.getLocalizedMessage(), test, test1);

			verifyServerStatus(driver);
			Assert.fail();
		}
	}

	public Map<String, List<String>> extractTableData(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			// Wait until the table is present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			// Locate the parent div containing the table data
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
			// Get all header cells
			List<WebElement> headers = tableContainer
					.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));
			// Create a map to store column data
			Map<String, List<String>> tableData = new HashMap<>();
			// Initialize map with headers
			for (WebElement header : headers) {
				tableData.put(header.getText(), new ArrayList<>());
			}
			// Get all rows from the container
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eCenterContainer']//div[@role='row']"));
			// Iterate through the rows
			for (WebElement row : rows) {
				// Get all cells (or items) within each row
				List<WebElement> cells = row.findElements(By.tagName("div"));
				// Fill map with row data
				for (int i = 0; i < cells.size(); i++) {
					String columnHeader = headers.get(headers.size() - 1 - i).getText(); // Reverse the index
					tableData.get(columnHeader).add(cells.get(i).getText());
				}
			}
			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return null;
		}
	}

	public static String printTable(WebDriver driver, Map<String, List<String>> tableData, List<String> headers) {
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<table style='width:100%; border-collapse: collapse;'>");
		tableBuilder.append("<thead><tr>");

		// Print headers
		for (String header : headers) {
			tableBuilder.append("<th style='border: 1px solid #ddd; padding: 8px;'>").append(header).append("</th>");
		}
		tableBuilder.append("</tr></thead><tbody>");

		// Retrieve and print values for the headers
		List<List<String>> valuesByHeader = new ArrayList<>();
		for (String header : headers) {
			List<String> values = tableData.getOrDefault(header, Collections.emptyList());
			valuesByHeader.add(values);
		}

		// Find the maximum number of rows for alignment
		int maxRows = valuesByHeader.stream().mapToInt(List::size).max().orElse(0);

		// Print the values in a table format
		for (int i = 0; i < maxRows; i++) {
			tableBuilder.append("<tr>");
			for (List<String> values : valuesByHeader) {
				if (i < values.size()) {
					tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>").append(values.get(i))
							.append("</td>");
				} else {
					tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'></td>"); // Empty cell
				}
			}
			tableBuilder.append("</tr>");
		}
		tableBuilder.append("</tbody></table>");
		return tableBuilder.toString();
		// Add the table to the Extent Report
		// Extent_pass(driver, "<div style='overflow-x:auto;'>" +
		// tableBuilder.toString() + "</div>", test, test1);
	}

	/*
	 * Used to scroll the page to vertically
	 */
	public void verticalScroll(WebDriver driver, String xpath, int input) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop += " + input + ";", element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to send(Type) the value in the particular element This method created by
	 * using Selenium WebDriver
	 */
	public void sendKeys(WebDriver driver, String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.sendKeys(keysToSend);
			Extent_pass(driver, "Type on " + values[0] + " -> The Typing Value is : " + keysToSend, test, test1);
			wait(driver, "1");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to type on " + values[0] + "  " + e.getLocalizedMessage() + "  "
					+ "The Typing Value is : " + keysToSend, test, test1);
			global.add("Unable to type on - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}

	}

	/*
	 * Used to send(Type) the value in the particular element This method created by
	 * using Actions class in the selenium
	 */
	public void Actionsendkeys(WebDriver driver, String xpath, String text) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Actions act = new Actions(driver);
			act.moveToElement(webElement).perform();
			act.sendKeys(text).build().perform();
			Extent_pass(driver, "Able to Send Keys on " + values[0] + " -> The Typing Value is : " + text, test, test1);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}

	}

	/*
	 * Used to get the current text color for the particular element
	 */
	public String getTextColor(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		String hexcolor = "";
		try {
			WebElement eleSearch = driver.findElement(By.xpath(values[1]));
			String rgbFormat = eleSearch.getCssValue("color");
			hexcolor = rgbToHex(rgbFormat);
			Extent_pass(driver, "Get the Text Color of " + values[0], test, test1);
			return hexcolor;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
		return hexcolor;
	}

	/*
	 * External wait, used to hold(wait) the execution for particular time
	 */
	public void wait(WebDriver driver, String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time * 1000;
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to Check weather the element is enabled or not for particular Element
	 */
	public boolean IsElementEnabled(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			return webElement.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Used to download and save the file
	 */
	public void Downloadedfile(String filename) {
		String os = System.getProperty("os.name").toLowerCase();
		String downloadPath = "";
		if (os.contains("win")) {
			// For Windows, using Shell32Util
			downloadPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		} else {
			// Defaulting to user home directory if OS is not recognized
			downloadPath = System.getProperty("user.home");
		}

		// String downloadsPath = "C:\\Users\\TRACK\\Downloads";
		String downloadDir = downloadPath;
		File dir = new File(downloadDir);
		String Downloadedfile = "";

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles((dir1, name) -> name.contains("" + filename + ".csv"));
			if (files != null && files.length > 0) {
				// Sort files by last modified timestamp in descending order
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
				// Get the first (latest) file
				File latestFile = files[0];
				Downloadedfile = latestFile.getAbsolutePath();
				System.out
						.println("Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath());
				Extent_pass(driver,
						"Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath(), test,
						test1);
			} else {
				System.out.println("Downloaded file was not present in the downloads folder ");
				Extent_fail(driver, "Downloaded file was not present in the downloads folder ", test, test1);
				global.add("Downloaded file was not present in the downloads folder ");
				Assert.fail("Downloaded file was not present in the downloads folder ");
			}
		} else {
			System.out.println("Directory does not exist or is not a directory.");
			Extent_fail(driver, "Directory does not exist or is not a directory.", test, test1);
			global.add("Directory does not exist or is not a directory.");
			Assert.fail("Directory does not exist or is not a directory.");
		}

		System.out.println("Latestdownloaded_Zipfile :" + Downloadedfile);
		Extent_pass(driver, "Latestdownloaded_Zipfile :" + Downloadedfile, test, test1);
	}

	public static int countRowsWithColumnNameForCsvFile(String csvFilePath, String columnName) throws IOException {
		// Initialize the BufferedReader to read the CSV file
		BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));

		String line;
		int rowCount = 0;
		int columnIndex = -1; // Initialize columnIndex to -1 (not found)

		// Read the file line by line
		List<String[]> rows = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			String[] values = line.split(","); // Split by comma assuming CSV format
			rows.add(values); // Add each row to the list
		}

		// Now, iterate over all the rows and check for the column name
		for (String[] values : rows) {
			// If column index is not found, search for it
			if (columnIndex == -1) {
				for (int i = 0; i < values.length; i++) {
					if (values[i].trim().equalsIgnoreCase(columnName)) {
						columnIndex = i; // Set the column index if column name is found
						break;
					}
				}
			} else {
				// If column name was found, check the value in the column
				if (values.length > columnIndex && !values[columnIndex].trim().isEmpty()) {
					rowCount++; // Increment row count if the column has a non-empty value
				}
			}
		}

		// Close the file reader
		reader.close();

		// Return the row count
		return rowCount;
	}

	/*
	 * Used to Clear the particular Element or Text Field
	 */
	public void Newclear(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		try {
			Actions actions = new Actions(driver);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.click();
			actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
			// Action class is taking some time for complete the action
			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to Tab action in the Web Page
	 */
	public void tab(WebDriver driver) {
		try {
			// Action class is taking some time for complete the action, So I gave the
			// manual wait here
			wait(driver, WaitForDisplay_Time);
			Actions actionObject = new Actions(driver);
			actionObject.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			verifyServerStatus(driver);
			Assert.fail();
		}
	}

	public static List<String> expandRange(String rangeStr) {
		List<String> result = new ArrayList<>();
		String[] parts = rangeStr.split("-");
		int start = Integer.parseInt(parts[0]);
		int end = Integer.parseInt(parts[1]);
		for (int i = start; i <= end; i++) {
			result.add(String.valueOf(i));
		}
		return result;
	}

	public static List<String> splitAndExpand(String input) {
		List<String> result = new ArrayList<>();
		if (input.contains(",") || input.contains("-")) {
			String[] parts = input.split(",");
			for (String part : parts) {
				if (part.contains("-")) {
					result.addAll(expandRange(part));
				} else {
					result.add(part);
				}
			}
		} else {
			result.add(input);
		}
		return result;
	}

	public static List<String> splitAndExpand(String input, String expression) {
		List<String> result = new ArrayList<>();
		if (input.contains(expression)) {
			String[] parts = input.split(expression);
			for (String part : parts) {
				result.add(part);
			}
		} else {
			result.add(input);
		}
		return result;
	}

	public static List<String> splitAndExpand(List<String> inputs, String expression) {
		List<String> result = new ArrayList<>();
		for (String input : inputs) {
			if (input.contains(expression)) {
				String[] parts = input.split(expression);
				for (String part : parts) {
					result.add(part);
				}
			} else {
				result.add(input);
			}
		}
		return result;

	}

	public static boolean extractstatus(String text) {
		String pattern = "\\b(active)\\b";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher matcher = compiledPattern.matcher(text);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static void datePicker(String date, StringBuilder dayOut, StringBuilder monthOut, StringBuilder yearOut) {
		if (date.contains("/")) {
			// Split the date string by "/"
			String[] parts = date.split("/");
			// Extract day, month, and year from the array
			int day = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			if (parts[2].contains(" ")) {
				String[] years = parts[2].split(" ");
				parts[2] = years[1];
			}
			int year = Integer.parseInt(parts[2]);

			// Array of month names
			String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
					"Dec" };
			// Get the month name (adjust index for zero-based array)
			String monthName = monthNames[month - 1];
			// Set the output parameters
			dayOut.setLength(0);
			dayOut.append(day);
			monthOut.setLength(0);
			monthOut.append(monthName);
			yearOut.setLength(0);
			yearOut.append(year);
		} else if (date.contains("-")) {
			// Split the date string by "/"
			String[] parts = date.split("-");
			// Extract day, month, and year from the array
			int day = Integer.parseInt(parts[1]);
			int month = Integer.parseInt(parts[0]);
			if (parts[2].contains(" ")) {
				String[] years = parts[2].split(" ");
				parts[2] = years[1];
			}
			int year = Integer.parseInt(parts[2]);
			// Array of month names
			String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
					"Dec" };
			// Get the month name (adjust index for zero-based array)
			String monthName = monthNames[month - 1];
			// Set the output parameters
			dayOut.setLength(0);
			dayOut.append(day);
			monthOut.setLength(0);
			monthOut.append(monthName);
			yearOut.setLength(0);
			yearOut.append(year);
		}
	}

	public static String getHexCode(String colorName) {
		String hexCode = "Unknown Hex Code";

		switch (colorName.toLowerCase()) {
		// Whites
		case "white":
			hexCode = "#FFFFFF";
			break;
		case "light gray":
			hexCode = "#F5F5F5"; // Can also be "#DCDCDC"
			break;
		case "gray":
			hexCode = "#808080";
			break;
		case "dark gray":
			hexCode = "#696969";
			break;

		// Blacks
		case "black":
			hexCode = "#000000";
			break;

		// Reds
		case "red":
			hexCode = "#FF0000";
			break;
		case "dark red":
			hexCode = "#8B0000";
			break;
		case "light red":
			hexCode = "#FF6666";
			break;

		// Greens
		case "green":
			hexCode = "#00FF00";
			break;
		case "dark green":
			hexCode = "#006400";
			break;
		case "light green":
			hexCode = "#90EE90";
			break;

		// Blues
		case "blue":
			hexCode = "#0000FF";
			break;
		case "dark blue":
			hexCode = "#00008B";
			break;
		case "light blue":
			hexCode = "#ADD8E6";
			break;

		// Yellows
		case "yellow":
			hexCode = "#FFFF00";
			break;
		case "golden yellow":
			hexCode = "#FFD700";
			break;
		case "light yellow":
			hexCode = "#FFFACD";
			break;

		// Purples
		case "purple":
			hexCode = "#800080";
			break;
		case "dark purple":
			hexCode = "#4B0082";
			break;
		case "light purple":
			hexCode = "#DA70D6";
			break;

		// Oranges
		case "orange":
			hexCode = "#FFA500";
			break;
		case "dark orange":
			hexCode = "#FF8C00";
			break;
		case "light orange":
			hexCode = "#FFDAB9";
			break;

		// Pinks
		case "pink":
			hexCode = "#FFC0CB";
			break;
		case "hot pink":
			hexCode = "#FF69B4";
			break;
		case "light pink":
			hexCode = "#F08080";
			break;

		default:
			hexCode = "Unknown Hex Code";
			break;
		}
		return hexCode;
	}

	/*
	 * Used to expand the data By using "," and "/"
	 */
	public static List<String> splitAndExpand1(String input) {
		List<String> result = new ArrayList<>();
		String[] parts = input.split(",");
		for (String part : parts) {
			if (part.contains("/")) {
				result.addAll(expandRange(part));
			} else {
				result.add(part);
			}
		}
		return result;
	}

	/*
	 * Used to click the particular Element using javascript executor
	 */
	public void click1(WebDriver driver, String path) {
		String[] values = splitXpath(path);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", webElement);
			System.out.println(values[0] + " clicked");
			Extent_pass(driver, "Click on " + values[0], test, test1);
		} catch (Exception e) {
			System.out.println(" Exception " + e);
			Extent_fail(driver, "Unable to click on " + values[0] + "  " + e.getLocalizedMessage(), test, test1);
			global.add("Unable to click on - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
	}

	public static List<Map<String, String>> readCSV(String filePath) {
		List<Map<String, String>> dataList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			String[] headers = null;
			int lineNum = 0;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",", -1); // Handle empty fields
				if (lineNum == 0) {
					headers = values;
				} else {
					Map<String, String> rowData = new HashMap<>();
					for (int i = 0; i < headers.length; i++) {
						rowData.put(headers[i], i < values.length ? values[i] : "");
					}
					dataList.add(rowData);
				}
				lineNum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	/*
	 * Used to clear the existing value in the element and then send(type) the new
	 * value in that element
	 */
	public String clearAndType(WebDriver driver, String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='';", webElement);
			js.executeScript("arguments[0].click();", webElement);
			wait(driver, "1");
			js.executeScript("arguments[0].value=" + "\'" + keysToSend + "\'" + ";", webElement);
			Extent_pass(driver, "Clear and Type on " + values[0] + " -> The Typing Value is : " + keysToSend, test,
					test1);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to type on " + values[0] + "- " + e.getLocalizedMessage() + "  "
					+ "The Typing Value is : " + keysToSend, test, test1);
			global.add("Unable to type on - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		return keysToSend;
	}

	public String clearAndType1(WebDriver driver, String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths); // Assuming splitXpath extracts the element's xpath
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.clear(); // Clear the text field first
			// Send keys to the element
			webElement.sendKeys(keysToSend); // Send keys directly to the input field
			Extent_pass(driver, "Clear and Type on " + values[0] + " The Typing Value is: " + keysToSend, test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to type on " + values[0] + " - " + e.getLocalizedMessage()
					+ " The Typing Value is: " + keysToSend, test, test1);
			verifyServerStatus(driver);
			Assert.fail();
		}
		return keysToSend;
	}

	public double getWaiverPercentAmount(String NetAmountValue, String PercentValue) {

		try {
			double Amount = getNumberValue(NetAmountValue);
			double input = getNumberValue(PercentValue);

			double totalAmount = Amount * (input / 100);
			return totalAmount;

		} catch (Exception e) {
			return 0;

		}
	}

	/*
	 * Used to perform the doubleClick action on the element in the page by passing
	 * the WebElement as argument proving the WebElement and perform the Double
	 * Click action on the element
	 */
	public void doubleClick(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Actions action = new Actions(driver).doubleClick(webElement);
			action.build().perform();
			Extent_pass(driver, "Able to Double click on " + values[0] + "- ", test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to Double click on " + values[0] + "- " + e.getLocalizedMessage(), test, test1);
			global.add("Unable to Double click on - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
	}

	/*
	 * Used to clear the value on the element by using selenium WebDriver
	 */
	public void clear(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			webElement.clear();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to clear the value on the dropdown by using index value
	 */
	public void selectByIndex(WebDriver driver, String xpaths, String inputData) {
		String[] values = splitXpath(xpaths);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Integer index = Integer.parseInt(inputData);
			Select selectBox = new Select(webElement);
			selectBox.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to clear the value on the dropdown by using Text value
	 */
	public void selectByText(WebDriver driver, String xpaths, String inputData) {
		String[] values = splitXpath(xpaths);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			Select selectBox = new Select(driver.findElement(By.xpath(values[1])));
			selectBox.selectByVisibleText(inputData);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to clear the value on the drop down by using value Attribute
	 */
	public void selectByValue(WebDriver driver, String xpaths, String inputData) {
		String[] values = splitXpath(xpaths);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {

			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Select selectBox = new Select(webElement);
			selectBox.selectByValue(inputData);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	public void selectDatePickerWithTime(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		StringBuilder time = new StringBuilder();
		datePickerWithTime(DateValue, day, month, year, time);

		waitForElement(driver, Locator);
		click(driver, Locator);
		waitForElement(driver, Year_DD);
		selectByText(driver, Year_DD, year.toString());
		waitForElement(driver, Month_DD);
		selectByText(driver, Month_DD, month.toString());
		String date_Select = String.format(LoadConfirmation_Locators.date_select, day);
		waitForElement(driver, date_Select);
		jsClick(driver, date_Select);
		waitForDisplay(driver, calender_close);
		if (isdisplayed(driver, calender_close)) {
			waitForElement(driver, calender_close);
			click(driver, calender_close);
		}
		waitForElement(driver, Locator);
		click(driver, Locator);
		waitForElement(driver, timeInput);
		doubleClick(driver, timeInput);
		waitForElement(driver, timeInput);
		clearAndType(driver, timeInput, time.toString());
		waitForElement(driver, timeInput);
		click(driver, timeInput);
		waitForDisplay(driver, calender_close);
		if (isdisplayed(driver, calender_close)) {
			waitForElement(driver, calender_close);
			click(driver, calender_close);
		}
	}

	public void selectDatePickerWithTime_CS(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		StringBuilder time = new StringBuilder();
		datePickerWithTime(DateValue, day, month, year, time);
		waitForElement(driver, Locator);
		click(driver, Locator);
		waitForElement(driver, Year_DD);
		selectByText(driver, Year_DD, year.toString());
		waitForElement(driver, Month_DD);
		selectByText(driver, Month_DD, month.toString());
		waitForElement(driver, timeInput);
		doubleClick(driver, timeInput);
		Newclear(driver, timeInput);
		Actionsendkeys(driver, timeInput, time.toString());
		waitForElement(driver, timeInput);
		click(driver, timeInput);
		String date_Select = String.format(LoadConfirmation_Locators.date_select, day);
		waitForElement(driver, date_Select);
		jsClick(driver, date_Select);
		waitForDisplay(driver, calender_close);
		if (isdisplayed(driver, calender_close)) {
			waitForElement(driver, calender_close);
			click(driver, calender_close);
		}
	}

	public void selectDatePickerWithTime_DC(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		StringBuilder time = new StringBuilder();
		datePickerWithTime(DateValue, day, month, year, time);
		waitForElement(driver, Locator);
		click(driver, Locator);
		// Newclear(driver, timeInput);
		// click(driver, timeInput);
		waitForElement(driver, Year_DD);
		selectByText(driver, Year_DD, year.toString());
		waitForElement(driver, Month_DD);
		selectByText(driver, Month_DD, month.toString());
		String date_Select = String.format(LoadConfirmation_Locators.date_select, day);
		waitForElement(driver, date_Select);
		jsClick(driver, date_Select);
		waitForElement(driver, Locator);
		click(driver, Locator);
		waitForElement(driver, timeInput);
		doubleClick(driver, timeInput);
		waitForElement(driver, timeInput);
		Actionsendkeys(driver, timeInput, time.toString());
		click(driver, timeInput);
		waitForElement(driver, timeInput);
		doubleClick(driver, timeInput);
//		enter(driver);
		// waitForDisplay(driver, calender_close);
		// if (isdisplayed(driver, calender_close)) {
		// waitForElement(driver, calender_close);
		// click(driver, calender_close);
		// }
	}

	public int[] getBlCount(String countValue) {
		int[] bl_Count = new int[2];
		try {
			String[] blCountDisplayed = countValue.split("/");
			int first = Integer.parseInt(blCountDisplayed[0]);
			int Second = Integer.parseInt(blCountDisplayed[1]);
			bl_Count[0] = first;
			bl_Count[1] = Second;
			return bl_Count;
		} catch (Exception e) {
			return null;
		}

	}

	public void deleteSavedBL(WebDriver driver, String House_BL_Status_Exp, String dropdownCondition1,
			String bl_Number) {
		waitForDisplay(driver, BL_status_IMP_DOC);
		String HouseBl_Status = getText(driver, BL_status_IMP_DOC);
		if (!House_BL_Status_Exp.equals(HouseBl_Status)) {
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, cancel_Common_btn);
			click(driver, cancel_Common_btn);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			waitForElement(driver, globalSearch_Condition_Dropdown1);
			click(driver, globalSearch_Condition_Dropdown1);
			selectByText(driver, globalSearch_Condition_Dropdown1, dropdownCondition1);
			click(driver, globalSearch_InputTextfield1);
			sendKeys(driver, globalSearch_InputTextfield1, bl_Number);
			click(driver, globalSearch_Frame_SearchButton);
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			waitForDisplay(driver, BL_status_IMP_DOC);
			String HouseBl_StatusAfter = getText(driver, BL_status_IMP_DOC);
			if (House_BL_Status_Exp.equals(HouseBl_StatusAfter)) {
				Extent_pass(driver, "House BL status Changed to NEW after deleted that BL ", test, test1);
			} else {
				Extent_fail(driver, "House BL status Not Changed to NEW after deleted that BL", test, test1);
			}
		}
	}

	public List<List<String>> getValuesByColumnAndHeaders(List<Map<String, String>> tableData, String firstColumnHeader,
			String firstColumnValue, List<String> columnHeaders) {

		List<List<String>> matchingValues = new ArrayList<>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader) && row.get(firstColumnHeader).equals(firstColumnValue)) {
				List<String> rowValues = new ArrayList<>();
				for (String header : columnHeaders) {
					// Add the value for the current header or null if the header is not present
					rowValues.add(row.getOrDefault(header, null));
				}
				matchingValues.add(rowValues);
			}
		}

		return matchingValues; // Return the list of lists
	}

	public static List<String> splitAndExpand2(String input) {
		List<String> result = new ArrayList<>();
		String[] parts = input.split(",");
		for (String part : parts) {
			if (part.contains("/")) {
				String[] parts1 = part.split("/");
				for (String part1 : parts1) {
					result.add(part1);
				}
			} else {
				result.add(part);
			}
		}
		return result;
	}

	public Map<String, List<String>> getColumnValuesByHeaders(List<Map<String, String>> tableData,
			List<String> columnHeaders) {
		Map<String, List<String>> resultMap = new HashMap<>();

		// Initialize map with empty lists for each header
		for (String header : columnHeaders) {
			resultMap.put(header, new ArrayList<>());
		}

		// Iterate through each row
		for (Map<String, String> row : tableData) {
			for (String header : columnHeaders) {
				if (row.containsKey(header)) {
					resultMap.get(header).add(row.get(header)); // Add value to corresponding list
				}
			}
		}

		return resultMap;
	}

	public void selectSpecificContainers(WebDriver driver, List<String> containerNumbers) {
		Actions action = new Actions(driver);
		for (String containerNo : containerNumbers) {
			String containerSelection = String.format(ImportDocumentation_Locators.Container_Select, containerNo);
			String[] containerXpath = splitXpath(containerSelection);
			WebElement containerCheckbox = driver.findElement(By.xpath(containerXpath[1]));
			// if (!containerCheckbox.isSelected()) {
			action.moveToElement(containerCheckbox).click(containerCheckbox).build().perform();
			// containerCheckbox.click();
			// }
		}
	}

	/*
	 * Used to get the column values from table by using column header
	 */
	public static List<String> getColumnValuesByHeader(String excelFilePath, String headerName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<String> columnValues = new ArrayList<>();
		try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0); // Assuming first sheet

			// Find the header row (first row)
			Row headerRow = sheet.getRow(0);
			if (headerRow == null)
				return columnValues;

			// Find the column index for the header
			int columnIndex = -1;
			for (Cell cell : headerRow) {
				if (cell != null && cell.getCellType() == CellType.STRING.getCode()) {
					if (cell.getStringCellValue().equalsIgnoreCase(headerName)) {
						columnIndex = cell.getColumnIndex();
						break;
					}
				}
			}

			// If the column header is found
			if (columnIndex != -1) {
				// Iterate through the rows (starting from the second row)
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					if (row != null) {
						Cell cell = row.getCell(columnIndex);
						if (cell != null && cell.getCellType() == CellType.STRING.getCode()) {
							columnValues.add(cell.getStringCellValue());
						}
					}
				}
			}
		}
		return columnValues;
	}

	/*
	 * Used to Download and extract PDF value
	 */
	public String downloadPDFAndExtract(WebDriver driver, String pdfLinkXPath) throws IOException {
		// Get default download folder path based on the operating system
		String downloadFolder = getDefaultDownloadFolderPath();
		String[] values = splitXpath(pdfLinkXPath);
		String downloadedFilePath = null; // Variable to store the downloaded file path
		try {
			// Locate the PDF download link
			WebElement pdfLink = driver.findElement(By.xpath(values[1]));
			pdfLink.click(); // Click the link to download the PDF (assuming the link directly opens the PDF)
			// Wait for the PDF to be downloaded (adjust the sleep time as needed)
			wait(driver, ScrollWaitTime); // This time can be adjusted based on your internet speed and PDF size
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "PDF is Not Downloaded " + e.getLocalizedMessage(), test, test);
		}
		// Check if the PDF has been downloaded to the expected location
		File downloadDir = new File(downloadFolder);
		if (downloadDir.exists() && downloadDir.isDirectory()) {
			// Filter for .pdf files in the download folder (if there are multiple, you can
			// pick the latest)
			File[] files = downloadDir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".pdf"); // Only consider .pdf files
				}
			});
			if (files != null && files.length > 0) {
				// Sort files by the last modified date, with the most recent file first
				Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));
				// Get the most recent downloaded PDF file
				File downloadedPDF = files[0];
				downloadedFilePath = downloadedPDF.getAbsolutePath(); // Get the full file path
				System.out.println("PDF downloaded successfully at: " + downloadedFilePath);
				Extent_pass(driver, "PDF downloaded successfully at: " + downloadedFilePath, test, test);
			} else {
				System.out.println("PDF download failed. No PDF found in the download folder.");
				Extent_fail(driver, "PDF download failed. No PDF found in the download folder.", test, test);
			}
		} else {
			System.out.println("Download folder does not exist or is not a directory.");
			Extent_fail(driver, "Download folder does not exist or is not a directory.", test, test);
		}
		PDDocument document = PDDocument.load(new File(downloadedFilePath)); // Load the PDF document
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(document); // Extract the text from the PDF
		document.close(); // Close the document to release resources
		return text;
	}

	// Method to get the default system download folder based on the operating
	// system
	private String getDefaultDownloadFolderPath() {
		String os = System.getProperty("os.name").toLowerCase();
		String downloadFolder = System.getProperty("user.home") + File.separator + "Downloads";
		// Customize for different OS if needed
		if (os.contains("win")) {
			// On Windows, we use "Downloads" under the user's home directory
			downloadFolder = System.getProperty("user.home") + File.separator + "Downloads";
		} else if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
			// For Mac/Linux, also use "Downloads" under the user's home directory
			downloadFolder = System.getProperty("user.home") + File.separator + "Downloads";
		}
		return downloadFolder;
	}

	/*
	 * Method to retrieve value by first column Partial value and header
	 */
	public String getValueByFirstColumnPartialValueAndHeader(List<Map<String, String>> tableData,
			String FirstColumnHeader, String firstColumnValue, String columnHeader) {
		for (Map<String, String> row : tableData) {
			if (row.containsKey(FirstColumnHeader) && row.get(FirstColumnHeader).contains(firstColumnValue)) {
				// Checking for partial match using contains() on the first column value
				return row.get(columnHeader); // Return the value for the specified column header
			}
		}
		return "Value not found"; // Return message if not found
	}

	/*
	 * Used to wait for the Visibility of the Element in the page (30 seconds)
	 */
	public void waitForVisibilty(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			Extent_pass(driver, "Waiting for the " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Element is not present " + values[0] + e.getLocalizedMessage(), test, test1);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + values[0] + e.getLocalizedMessage());
		}
	}

	public static boolean CompareListvalues(List<String> list1, List<String> list2) {
		// Check if the sizes of the lists are different
		if (list1 == null || list2 == null || list1.size() != list2.size()) {
			return false;
		}

		// Loop through every element in list1
		for (String item1 : list1) {
			boolean found = false; // Flag to check if the current item exists in list2

			// Compare with every element in list2
			for (String item2 : list2) {
				if (item1.equals(item2)) {
					found = true; // Mark as found
					break; // Exit inner loop as we found a match
				}
			}

			// If any element from list1 is not found in list2, return false
			if (!found) {
				return false;
			}
		}

		// Perform a similar check for elements in list2 (to ensure no extra elements
		// exist)
		for (String item2 : list2) {
			boolean found = false;

			for (String item1 : list1) {
				if (item2.equals(item1)) {
					found = true; // Mark as found
					break;
				}
			}

			// If any element from list2 is not found in list1, return false
			if (!found) {
				return false;
			}
		}

		// If all elements match, return true
		return true;
	}

	public String TableDataForReport1(WebDriver driver, List<List<String>> tableData, String tableName,
			List<String> excelHeaders) {
		// Determine maximum column widths
		int[] columnWidths = new int[excelHeaders.size()];

		// Initialize widths based on header lengths
		for (int i = 0; i < excelHeaders.size(); i++) {
			columnWidths[i] = excelHeaders.get(i).length();
		}

		// Update widths based on data
		for (List<String> row : tableData) {
			for (int i = 0; i < excelHeaders.size(); i++) {
				if (i < row.size()) {
					String value = row.get(i);
					if (value != null) {
						columnWidths[i] = Math.max(columnWidths[i], value.length());
					}
				}
			}
		}

		// StringBuilder for constructing the HTML table
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<h3>").append(tableName).append("</h3>");
		tableBuilder.append("<table style='width:100%; border-collapse: collapse;'>");
		tableBuilder.append("<thead><tr>");

		// Add headers to HTML and print to console
		StringBuilder headerRow = new StringBuilder();
		for (String header : excelHeaders) {
			tableBuilder.append("<th style='border: 1px solid #ddd; padding: 8px;'>").append(header).append("</th>");
			headerRow.append(String.format("%-" + (columnWidths[excelHeaders.indexOf(header)] + 2) + "s", header));
		}
		tableBuilder.append("</tr></thead><tbody>");

		int lineLength = Arrays.stream(columnWidths).sum() + 2 * columnWidths.length;
		String separator = repeatChar('-', lineLength);

		// Print header row to console
		System.out.println(separator);
		System.out.println(tableName + " : ");
		System.out.println(separator);
		System.out.println(headerRow.toString());
		System.out.println(separator); // separator after headers

		// Add rows to HTML and print to console
		for (List<String> row : tableData) {
			tableBuilder.append("<tr>");
			StringBuilder rowOutput = new StringBuilder();
			for (int i = 0; i < excelHeaders.size(); i++) {
				if (i < row.size() && row.get(i) != null) {
					String value = row.get(i);
					tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>").append(value)
							.append("</td>");
					rowOutput.append(String.format("%-" + (columnWidths[i] + 2) + "s", value));
				} else {
					tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>N/A</td>");
					rowOutput.append(String.format("%-" + (columnWidths[i] + 2) + "s", "N/A"));
				}
			}
			tableBuilder.append("</tr>");
			System.out.println(rowOutput.toString());
		}

		System.out.println(separator); // final bottom border
		tableBuilder.append("</tbody></table>");
		return tableBuilder.toString();
	}

	public Map<String, String> getCommodityValue(List<Map<String, String>> tableData, String keyHeader,
			String valueHeader) {
		Map<String, String> resultMap = new HashMap<>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(keyHeader) && row.containsKey(valueHeader)) {
				resultMap.put(row.get(keyHeader), row.get(valueHeader));
			}
		}
		return resultMap;
	}

	public static String getTableCellValue(List<Map<String, String>> tableData, String Header, String containerNo,
			String header) {
		// Iterate through each row in the table data
		for (Map<String, String> row : tableData) {
			// Check if the row contains the given "Container NO"
			if (row.containsKey(Header) && row.get(Header).equals(containerNo)) {
				// Return the value under the specified header if present
				return row.getOrDefault(header, "Header not found");
			}
		}
		return "Container NO not found";
	}

	public Map<String, String> getCellValuesByFirstCellValue(List<Map<String, String>> tableData, String Header,
			String FirstCellValue, String keyHeader, String valueHeader) {
		Map<String, String> resultMap = new HashMap<>();
		for (Map<String, String> row : tableData) {
			if (row.containsKey(Header) && row.get(Header).equals(FirstCellValue)) {
				resultMap.put(row.get(keyHeader), row.get(valueHeader));
			}
		}
		return resultMap;
	}

	public String compareBeforeAndAfter(String before_adding, String after_adding) {
		// Assuming before_adding and after_adding are in String format with table rows
		// and columns as HTML-like structure.

		// Split before and after data into rows (assumes data is in HTML-like structure
		// with <tr> for rows and <td> for columns)
		String[] beforeRows = before_adding.split("</tr>");
		String[] afterRows = after_adding.split("</tr>");

		// Initialize the result to store the final comparison
		StringBuilder comparisonResult = new StringBuilder();

		// Loop through each row (assuming the rows are identical)
		int maxRows = Math.max(beforeRows.length, afterRows.length); // Make sure we handle different row counts
		for (int i = 0; i < maxRows; i++) {
			String beforeRow = i < beforeRows.length ? beforeRows[i] : "";
			String afterRow = i < afterRows.length ? afterRows[i] : "";

			// Compare each row and highlight the differences
			if (!beforeRow.equals(afterRow)) {
				// If rows are different, add bold formatting around differences
				comparisonResult.append("<tr><td colspan='100%' style='color:red; font-weight:bold;'>");
				comparisonResult.append("Difference Found in Row " + (i + 1) + ":");
				comparisonResult.append("</td></tr>");

				comparisonResult.append("<tr><td><strong>Before:</strong></td><td>" + beforeRow + "</td></tr>");
				comparisonResult.append("<tr><td><strong>After:</strong></td><td>" + afterRow + "</td></tr>");
			} else {
				// If rows are identical, add them normally
				comparisonResult.append("<tr><td>" + beforeRow + "</td></tr>");
			}
		}

		// Return the formatted result
		return comparisonResult.toString();
	}

	public Map<String, List<String>> getValuesByID(List<Map<String, String>> tableData, String firstColumnHeader,
			List<String> specifiedContainerIDs, List<String> columnHeaders) {

		Map<String, List<String>> filteredData = new HashMap<>();

		for (Map<String, String> row : tableData) {
			String containerID = row.get(firstColumnHeader);
			// Only store values if the Container ID is in the specified list
			if (containerID != null && specifiedContainerIDs.contains(containerID)) {
				List<String> matchingValues = new ArrayList<>();
				// Extract values for the specified column headers (excluding the
				// firstColumnHeader)
				for (String header : columnHeaders) {
					if (!header.equals(firstColumnHeader)) {
						String headerValue = row.get(header);
						matchingValues.add(headerValue != null ? headerValue : ""); // Avoid null values
					}
				}
				filteredData.put(containerID, matchingValues);
			}
		}
		return filteredData; // Return the filtered map
	}

	/*
	 * Used to get the count of unique value in column value
	 */

	public static boolean CompareMapListValues2(Map<String, List<String>> exp, Map<String, List<String>> act) {
		// Check if both maps are null or have different sizes
		if (exp == null || act == null || exp.size() != act.size()) {
			return false;
		}

		// Iterate through each key-value pair in the expected map
		for (Map.Entry<String, List<String>> entry : exp.entrySet()) {
			String key = entry.getKey();
			List<String> expectedList = entry.getValue();

			// Check if the key exists in the actual map
			if (!act.containsKey(key)) {
				return false;
			}

			List<String> actualList = act.get(key);

			// Check if both lists are null or have different sizes
			if (expectedList == null || actualList == null || expectedList.size() != actualList.size()) {
				return false;
			}

			// Sort both lists (to handle order differences)
			List<String> sortedExpList = new ArrayList<>(expectedList);
			List<String> sortedActList = new ArrayList<>(actualList);
			Collections.sort(sortedExpList);
			Collections.sort(sortedActList);

			// Compare each element, treating numbers properly
			for (int i = 0; i < sortedExpList.size(); i++) {
				String expValue = sortedExpList.get(i);
				String actValue = sortedActList.get(i);

				if (isNumeric(expValue) && isNumeric(actValue)) {
					BigDecimal expNum = new BigDecimal(expValue);
					BigDecimal actNum = new BigDecimal(actValue);
					if (expNum.compareTo(actNum) != 0) {
						return false;
					}
				} else {
					if (!expValue.equals(actValue)) {
						return false;
					}
				}
			}
		}

		// If all key-value pairs match, return true
		return true;
	}

	/*
	 * Used to get the text from the particular element in the page using Xpath as
	 * input argument
	 */
	public String getText(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			String text = webElement.getText();
			return text;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
			return null;
		}
	}

	/*
	 * Used to upload the file
	 */

//	public static int countNonEmptyRowsFromCSV(String csvFilePath) {
//        int rowCount = 0;
// 
//        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
//            String[] line;
//            while ((line = reader.readNext()) != null) {
//                boolean hasValue = false;
//                for (String cell : line) {
//                    if (cell != null && !cell.trim().isEmpty()) {
//                        hasValue = true;
//                        break;
//                    }
//                }
//                if (hasValue) {
//                    rowCount++;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
// 
//        return rowCount;
//    }
//	

	public static int countNonEmptyRowsFromCSV(String csvFilePath) {
		int rowCount = 0;

		try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
			String[] line;
			while ((line = reader.readNext()) != null) {
				boolean hasValue = false;
				for (String cell : line) {
					if (cell != null && !cell.trim().isEmpty()) {
						hasValue = true;
						break;
					}
				}
				if (hasValue) {
					rowCount++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	public void uploadfile1(WebDriver driver, String path) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			Extent_pass(driver, "uploaded the file " + path, test, test);

			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			extent_fail(driver, "upload is falied - " + path + e, test, test);

			e.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Used to upload the file
	 */
	public void uploadfile(WebDriver driver, String xpath, String excelpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = driver.findElement(By.xpath(values[1]));
			File file = new File(excelpath);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			Extent_pass(driver, values[0] + "Scucessfully uploaded the " + excelpath, test, test);

			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, values[0] + "Failed to upload the " + excelpath + e, test, test);
		}
	}

	/*
	 * Used to gat the table value
	 */
	public Map<String, List<String>> extractTableDataDirect(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			// Wait until the table is present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate the parent div containing the table data
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));

			// Get all header cells
			List<WebElement> headers = tableContainer
					.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));

			// Create a map to store column data
			Map<String, List<String>> tableData = new HashMap<>();

			// Initialize map with headers (no reversing of the order)
			for (WebElement header : headers) {
				tableData.put(header.getText(), new ArrayList<>());
			}

			// Get all rows from the container
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eCenterContainer']//div[@role='row']"));

			// Iterate through the rows
			for (WebElement row : rows) {
				// Get all cells (or items) within each row
				List<WebElement> cells = row.findElements(By.tagName("div"));

				// Ensure that the number of cells matches the number of headers
				if (cells.size() == headers.size()) {
					for (int i = 0; i < cells.size(); i++) {
						// Directly use the header as the key, without reversing
						String columnHeader = headers.get(i).getText();
						tableData.get(columnHeader).add(cells.get(i).getText());
					}
				} else {
					// Log or handle case where row's cells don't match header count
					System.out.println("Row cell count mismatch with header count.");
				}
			}

			return tableData;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return null;
		}
	}

	/*
	 * Used to get the text value for a particular element without failing
	 */
	public String getTextwithoutfail(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			String text = webElement.getText();
			return text;
		} catch (Exception e) {
			return "null";
		}
	}

	/*
	 * Used to wait for the particular time
	 */
	public static void waitTime(WebDriver driver, String waitSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(waitSeconds)));
	}

	/*
	 * Used to scroll the web age top to bottom
	 */
	// public void scrollBottom(WebDriver driver) {
	// try {
	//
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	// wait(driver, ScrollWaitTime);
	// // add(driver, "Scrolled to the bottom ", LogAs.PASSED, true, "Not");
	// } catch (Exception e) {
	// e.printStackTrace();
	// Extent_fail(driver, "Unable to scroll " + e.getLocalizedMessage(), test,
	// test1);
	// global.add("Unable to scroll");
	// verifyServerStatus(driver);
	// Assert.fail("Unable to scroll " + e.getLocalizedMessage());
	// }
	// }
	public void scrollBottom(WebDriver driver) {
		waitForElement(driver, Version_Field);
		String[] values = splitXpath(Version_Field);

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(values[1]));

			for (int i = 0; i < 3; i++) {
				try {
					// Scroll the element into view, aligning to the bottom of the viewport
					js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'auto'});", element);

					// Small additional scroll to ensure full visibility (in case it's cut off)
					js.executeScript("window.scrollBy(0, 100);");

					wait(driver, ScrollWaitTime);

					if (element.isDisplayed()) {
						System.out.println(values[0] + " is displayed");
						break;
					}
				} catch (Exception e) {
					if (i == 2)
						throw e;
				}
			}
			mouseOverToElement(driver, Version_Field);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to scroll to element at bottom: " + e.getLocalizedMessage(), test, test1);
			global.add("Unable to scroll to element at bottom");
			verifyServerStatus(driver);
			Assert.fail("Unable to scroll to element at bottom: " + e.getLocalizedMessage());
		}
	}

	public void moduleNavigate(WebDriver driver, String ModuleName) {
		String Select_Module = String.format(Module_Select, ModuleName, ModuleName);
		waitForElement(driver, Search_Input);
		sendKeys(driver, Search_Input, ModuleName);
		waitForElement(driver, Select_Module);
		click(driver, Select_Module);
	}

	public void newButton(WebDriver driver) {
		scrollTop(driver);
		waitForDisplay(driver, NewButton_ToolBar);
		if (isdisplayed(driver, NewButton_ToolBar) && isElementEnabled(driver, NewButton_ToolBar)) {
			jsClick(driver, NewButton_ToolBar);
			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
		}
	}

	public List<Boolean> setAgencyConfiguration(WebDriver driver, String moduleName, String agencyColumn_Header,
			String attributeColumn_Header, String condition, String AgencyUser, String attribute,
			String agencyConfig_Description, String value) {
		List<Boolean> booleanList = new ArrayList<>();
		boolean temp = false;
		String expression = "<";
		Step_Start(2, "Open agency configuration screen", test, test1);
		moduleNavigate(driver, moduleName);
		Step_End(2, "Open agency configuration screen", test, test1);
		newButton(driver);
		Step_Start(3, "Select the agency ", test, test1);
		waitForElement(driver, AC_Search_Button);
		click(driver, AC_Search_Button);
		twoColumnSearchWindow(driver, agencyColumn_Header, condition, AgencyUser);
		waitForElement(driver, AC_Show_Button);
		click(driver, AC_Show_Button);
		Step_End(3, "Select the agency ", test, test1);
		List<String> attributes = splitAndExpand(attribute, expression);
		List<String> agencyConfig_Descriptions = splitAndExpand(agencyConfig_Description, expression);
		List<String> values = splitAndExpand(value, expression);
		for (int i = 0; i < agencyConfig_Descriptions.size(); i++) {
			Step_Start(4, "make the attribute ( " + attributes.get(i) + " - " + agencyConfig_Descriptions.get(i)
					+ ") set as " + values.get(i), test, test1);
			waitForElement(driver, AC_description_Grid_Filter);
			wait(driver, WaitForDisplay_Time);
			click(driver, AC_description_Grid_Filter);
			waitForDisplay(driver, AC_description_Grid_Filter);
			sendKeys(driver, AC_description_Grid_Filter, agencyConfig_Descriptions.get(i));
			waitForPresenceOfElement(driver, AC_first_Description_Select);
			String actualDescription = getTextwithoutfail(driver, AC_first_Description_Select);
			if (actualDescription.equalsIgnoreCase(agencyConfig_Descriptions.get(i))) {
				click(driver, AC_first_Description_Select);
				waitForElement(driver, AC_value_Textfield);
				click(driver, AC_value_Textfield);
				clearAndType(driver, AC_value_Textfield, values.get(i));
				waitForElement(driver, AC_Plus_Button);
				click(driver, AC_Plus_Button);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				Step_End(4, "make the attribute ( " + attributes.get(i) + " - " + agencyConfig_Descriptions.get(i)
						+ " ) set as " + values.get(i), test, test1);
				temp = false;
			} else {
				waitForElement(driver, AC_Plus_Button);
				click(driver, AC_Plus_Button);
				List<String> headers = splitAndExpand(attributeColumn_Header, ",");
				String attributevalue = attributes.get(i);
				if (headers.size() > 1) {
					attributevalue = attributes.get(i) + "," + agencyConfig_Descriptions.get(i);
				}
				twoColumnMultipleSearchWindow(driver, attributeColumn_Header, condition, attributevalue);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, AC_description_Grid_Filter);
				click(driver, AC_description_Grid_Filter);
				waitForDisplay(driver, AC_description_Grid_Filter);
				sendKeys(driver, AC_description_Grid_Filter, agencyConfig_Descriptions.get(i));
				waitForElement(driver, AC_first_Description_Select);
				click(driver, AC_first_Description_Select);
				waitForElement(driver, AC_value_Textfield);
				click(driver, AC_value_Textfield);
				clearAndType(driver, AC_value_Textfield, values.get(i));
				waitForElement(driver, AC_Plus_Button);
				click(driver, AC_Plus_Button);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				Step_End(4, "make the attribute ( " + attributes.get(i) + " - " + agencyConfig_Descriptions.get(i)
						+ " ) set as " + values.get(i), test, test1);
				temp = true;
			}
			booleanList.add(temp);
		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		return booleanList;
	}

	public void reSetAgencyConfiguration(WebDriver driver, String moduleName, String agencyColumn_Header,
			String attributeColumn_Header, String condition, String AgencyUser, String agencyConfig_Description,
			String resetValue, List<Boolean> newlyAdded_List, String reset) {
		String expression = "<";
		// Split values
		List<String> agencyConfig_Descriptions = splitAndExpand(agencyConfig_Description, expression);
		List<String> resetValues = splitAndExpand(resetValue, expression);
		List<String> resets = splitAndExpand(reset, expression);
		// Check if any reset = "Yes"
		boolean shouldProceed = resets.stream().anyMatch(val -> val.equalsIgnoreCase("Yes"));
		if (!shouldProceed) {
			// Skip entire method
			return;
		}
		// Proceed only if "Yes" present
		Step_Start(2, "Open agency configuration screen", test, test1);
		moduleNavigate(driver, moduleName);
		Step_End(2, "Open agency configuration screen", test, test1);
		newButton(driver);
		Step_Start(3, "Select the agency ", test, test1);
		waitForElement(driver, agencySearch_Button);
		click(driver, agencySearch_Button);
		twoColumnSearchWindow(driver, agencyColumn_Header, condition, AgencyUser);
		waitForElement(driver, AC_Show_Button);
		click(driver, AC_Show_Button);
		Step_End(3, "Select the agency ", test, test1);
		for (int i = 0; i < newlyAdded_List.size(); i++) {
			if (resets.get(i).equalsIgnoreCase("Yes")) {
				Step_Start(4, "Make (" + agencyConfig_Descriptions.get(i) + ") set as " + resetValues.get(i), test,
						test1);
				waitForElement(driver, AC_description_Grid_Filter);
				click(driver, AC_description_Grid_Filter);
				waitForDisplay(driver, AC_description_Grid_Filter);
				sendKeys(driver, AC_description_Grid_Filter, agencyConfig_Descriptions.get(i));
				waitForElement(driver, AC_first_Description_Select);
				click(driver, AC_first_Description_Select);
				if (newlyAdded_List.get(i)) {
					waitForElement(driver, AC_Remove_Button);
					click(driver, AC_Remove_Button);
					waitForElement(driver, popup_Message_Yes_Button);
					click(driver, popup_Message_Yes_Button);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					Step_End(4,
							"(" + agencyConfig_Descriptions.get(i) + ") is newly added so we removed that via script",
							test, test1);
				} else {
					waitForElement(driver, AC_value_Textfield);
					click(driver, AC_value_Textfield);
					clearAndType(driver, AC_value_Textfield, resetValues.get(i));
					waitForElement(driver, AC_Plus_Button);
					click(driver, AC_Plus_Button);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					Step_End(4, "Make (" + agencyConfig_Descriptions.get(i) + ") set as " + resetValues.get(i), test,
							test1);
				}
			}
		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
	}

	public Map<String, String> setAccountingConfiguration(WebDriver driver, String moduleName,
			String agencyColumn_Header, String attributeColumn_Header, String condition, String AgencyUser,
			String ConfigAttribute, String UD_ConfigAttribute, String ChargesColumn_Header, String AC_ChargeCode_Values,
			String Value_checkbox_perform) {
		Map<String, String> originalCheckBoxStates = new HashMap<>();
		String newadded = "No";
		Extent_call(test, test1, moduleName);
		moduleNavigate(driver, moduleName);
		Step_End(1, ".1.Open the accounting configuration Configuration Module.", test, test1);
		newButton(driver);
		Step_Start(2, ".go to the agency search field and select the import agency .", test, test1);
		Step_Start(4,
				"click the Add button then 1.RPL\" -Invoice - Restrict Agency Local charge calculation for Part-lot BL set as Y.",
				test, test1);

		waitForElement(driver, acc_config_agency);
		click(driver, acc_config_agency);
		twoColumnSearchWindow(driver, agencyColumn_Header, condition, AgencyUser);
		waitForElement(driver, Attributr_show);
		click(driver, Attributr_show);
		Step_End(2, ".go to the agency search field and select the import agency .", test, test1);
		if (!ConfigAttribute.equals("")) {
			Step_Start(3, ".go to the configuration table.", test, test1);
			waitForElement(driver, acc_config_filter);
			click(driver, acc_config_filter);
			waitForElement(driver, condition_filter);
			click(driver, condition_filter);
			waitForElement(driver, Attributr_search);
			sendKeys(driver, Attributr_search, ConfigAttribute);

			Step_Start(4,
					"click the Add button then 1.RPL\" -Invoice - Restrict Agency Local charge calculation for Part-lot BL set as Y.",
					test, test1);
			waitForDisplay(driver, acc_Config_First_Value);
			if (isdisplayed(driver, acc_Config_First_Value)) {
				waitForElement(driver, acc_Config_First_Value);
				doubleClick(driver, acc_Config_First_Value);
				newadded = "No";
			} else {
				Step_Start(12, "if attribute is Not Available,", test, test1);
				Step_Start(13, "Click on (+) Plus Button,", test, test1);
				waitForElement(driver, Att_add_btn_Account_Config);
				click(driver, Att_add_btn_Account_Config);
				Step_End(12, "if attribute is Not Available,", test, test1);
				Step_End(13, "Click on (+) Plus Button,", test, test1);
				Step_Start(14, ".Enter the attribute in attribute column", test, test1);
				twoColumnSearchWindow(driver, attributeColumn_Header, condition, ConfigAttribute);
				Step_End(14, ".Enter the attribute in attribute column", test, test1);
				Step_Start(15,
						"select the check box based on attribute,\n"
								+ "system has validate-Accounting configuration property(s) saved -click ok",
						test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				Step_End(15,
						"select the check box based on attribute,\n"
								+ "system has validate-Accounting configuration property(s) saved -click ok",
						test, test1);
				waitForElement(driver, acc_config_filter);
				click(driver, acc_config_filter);
				waitForElement(driver, condition_filter);
				click(driver, condition_filter);
				waitForElement(driver, Attributr_search);
				sendKeys(driver, Attributr_search, ConfigAttribute);
				waitForElement(driver, acc_Config_First_Value);
				doubleClick(driver, acc_Config_First_Value);
				newadded = "Yes";
			}
			originalCheckBoxStates.put(ConfigAttribute, newadded);
			waitForElement(driver, Value_checkbox);
			String originalState = checkBox(driver, Value_checkbox, Value_checkbox_perform);
			originalCheckBoxStates.put(ConfigAttribute + "CheckBox", originalState);
			waitForElement(driver, Value_checkbox_edit);
			click(driver, Value_checkbox_edit);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(4,
					"click the Add button then 1.RPL\" -Invoice - Restrict Agency Local charge calculation for Part-lot BL set as Y.",
					test, test1);
		}
		newadded = "No";
		if (!UD_ConfigAttribute.equals("")) {
			Step_Start(5,
					"'ACP -Invoice - Apply corresponding Agency charges for Part-lot BL' Set as  IDO Fee charge code",
					test, test1);
			waitForElement(driver, acc_config_filter1);
			click(driver, acc_config_filter1);
			waitForElement(driver, condition_filter1);
			click(driver, condition_filter1);
			waitForElement(driver, Attributr_search);
			sendKeys(driver, Attributr_search, UD_ConfigAttribute);
			waitForDisplay(driver, acc_UD_Config_First_Value);
			if (isdisplayed(driver, acc_UD_Config_First_Value)) {
				waitForElement(driver, acc_UD_Config_First_Value);
				newadded = "No";
				doubleClick(driver, acc_UD_Config_First_Value);
				List<String> chargeCodes = splitAndExpand(AC_ChargeCode_Values);
				List<String> chargeCodesForAdd = new ArrayList<String>();
				for (int i = 0; i < chargeCodes.size(); i++) {
					waitForElement(driver, acc_Value_List_Add_Button);
					if (!formatLocatorIsDisplayed(driver, acc_Value_List, chargeCodes.get(i))) {
						chargeCodesForAdd.add(chargeCodes.get(i));
					}
				}
				String actualCharegeCodes = String.join(",", chargeCodesForAdd);
				waitForElement(driver, acc_Value_List_Add_Button);
				click(driver, acc_Value_List_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, ChargesColumn_Header, condition, actualCharegeCodes);
			} else {
				Step_Start(12, "if attribute is Not Available,", test, test1);
				Step_Start(13, "Click on (+) Plus Button,", test, test1);
				waitForElement(driver, acc_UD_Config_Add_Button);
				click(driver, acc_UD_Config_Add_Button);
				Step_End(12, "if attribute is Not Available,", test, test1);
				Step_End(13, "Click on (+) Plus Button,", test, test1);
				Step_Start(14, ".Enter the attribute in attribute column", test, test1);
				twoColumnSearchWindow(driver, attributeColumn_Header, condition, UD_ConfigAttribute);
				Step_End(14, ".Enter the attribute in attribute column", test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, acc_config_filter1);
				click(driver, acc_config_filter1);
				waitForElement(driver, condition_filter1);
				click(driver, condition_filter1);
				waitForElement(driver, Attributr_search);
				sendKeys(driver, Attributr_search, UD_ConfigAttribute);
				waitForElement(driver, acc_UD_Config_First_Value);
				doubleClick(driver, acc_UD_Config_First_Value);
				waitForDisplay(driver, acc_Value_List_Add_Button);
				if (isdisplayed(driver, acc_Value_List_Add_Button)) {
					List<String> chargeCodes = splitAndExpand(AC_ChargeCode_Values);
					List<String> chargeCodesForAdd = new ArrayList<String>();
					for (int i = 0; i < chargeCodes.size(); i++) {
						waitForElement(driver, acc_Value_List_Add_Button);
						if (!formatLocatorIsDisplayed(driver, acc_Value_List, chargeCodes.get(i))) {
							chargeCodesForAdd.add(chargeCodes.get(i));
						}
					}
					String actualCharegeCodes = String.join(",", chargeCodesForAdd);
					waitForElement(driver, acc_Value_List_Add_Button);
					click(driver, acc_Value_List_Add_Button);
					twoColumnSearchWindowMultipleValue(driver, ChargesColumn_Header, condition, actualCharegeCodes);
				}
				waitForDisplay(driver, acc_Value_Field);
				if (isdisplayed(driver, acc_Value_Field)) {
					String dafaultValue = getAttribute(driver, acc_Value_Field, "value");
					originalCheckBoxStates.put(UD_ConfigAttribute + "_Default_Field_Value", dafaultValue);
					waitForDisplay(driver, acc_Value_Add_Button);
					if (isdisplayed(driver, acc_Value_Add_Button)) {
						waitForElement(driver, acc_Value_Add_Button);
						click(driver, acc_Value_Add_Button);
						twoColumnSearchWindowMultipleValue(driver, ChargesColumn_Header, condition,
								AC_ChargeCode_Values);
					} else {
						waitForElement(driver, acc_Value_Field);
						clear(driver, acc_Value_Field);
						sendKeys(driver, acc_Value_Field, AC_ChargeCode_Values);
					}
				}
				newadded = "Yes";
			}
			originalCheckBoxStates.put(UD_ConfigAttribute, newadded);
		}

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		return originalCheckBoxStates;
	}

	public void reSetAccountingConfiguration(WebDriver driver, String resetOption, Map<String, String> newladded,
			String moduleName, String agencyColumn_Header, String condition, String AgencyUser, String ConfigAttribute,
			String UD_ConfigAttribute) {
		if (resetOption.equalsIgnoreCase("Yes")) {
			moduleNavigate(driver, moduleName);
			Step_End(1, ".1.Open the accounting configuration Configuration Module.", test, test1);
			newButton(driver);
			Step_Start(2, ".go to the agency search field and select the import agency .", test, test1);
			Step_Start(4,
					"click the Add button then 1.RPL\" -Invoice - Restrict Agency Local charge calculation for Part-lot BL set as Y.",
					test, test1);
			waitForElement(driver, acc_config_agency);
			click(driver, acc_config_agency);
			twoColumnSearchWindow(driver, agencyColumn_Header, condition, AgencyUser);
			waitForElement(driver, Attributr_show);
			click(driver, Attributr_show);
			Step_End(2, ".go to the agency search field and select the import agency .", test, test1);
			if (!ConfigAttribute.equals(""))
				Step_Start(3, ".go to the configuration table.", test, test1);
			waitForElement(driver, acc_config_filter);
			click(driver, acc_config_filter);
			waitForElement(driver, condition_filter);
			click(driver, condition_filter);
			waitForElement(driver, Attributr_search);
			sendKeys(driver, Attributr_search, ConfigAttribute);
			if (newladded.get(ConfigAttribute).equalsIgnoreCase("Yes")) {
				waitForElement(driver, acc_Config_First_Value);
				doubleClick(driver, acc_Config_First_Value);
				waitForElement(driver, Att_remove_btn_Account_Config);
				click(driver, Att_remove_btn_Account_Config);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			} else {
				waitForDisplay(driver, Attribute_Select);
				if (isdisplayed(driver, Attribute_Select)) {
					waitForElement(driver, acc_Config_First_Value);
					doubleClick(driver, acc_Config_First_Value);
					waitForElement(driver, Value_checkbox);
					checkBox(driver, Value_checkbox, newladded.get(ConfigAttribute + "CheckBox"));
					waitForElement(driver, Value_checkbox_edit);
					click(driver, Value_checkbox_edit);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}
			}
		}
		if (!UD_ConfigAttribute.equals("")) {
			waitForElement(driver, acc_config_filter1);
			click(driver, acc_config_filter1);
			waitForElement(driver, condition_filter1);
			click(driver, condition_filter1);
			waitForElement(driver, Attributr_search);
			sendKeys(driver, Attributr_search, UD_ConfigAttribute);
			if (newladded.get(UD_ConfigAttribute).equalsIgnoreCase("Yes")) {
				waitForElement(driver, acc_UD_Config_First_Value);
				doubleClick(driver, acc_UD_Config_First_Value);
				waitForElement(driver, attribute_remove);
				click(driver, attribute_remove);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			} else {

			}
		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
	}

	// 11/06/2025 modified by arunthathi

	public static Map<String, String> extractConsigneeDetails(String pdfText, String value) {
		Map<String, String> result = new HashMap<>();
		String[] lines = pdfText.split("\\r?\\n");
		List<String> values = new ArrayList<>();

		for (int i = 0; i < lines.length; i++) {
			if (lines[i].trim().equalsIgnoreCase(value)) {
				int j = i + 1;
				while (j < lines.length && values.size() < 4) {
					String line = lines[j].trim();
					if (!line.isEmpty()) {
						values.add(line);
					}
					j++;
				}
				break;
			}
		}

		result.put("Name", values.size() > 0 ? values.get(0) : "");
		result.put("Address", values.size() > 1 ? values.get(1) : "");
		result.put("City", values.size() > 2 ? values.get(2) : "");
		result.put("Country", values.size() > 3 ? values.get(3) : "");
		return result;
	}

	public void reArrangeAG_Grid_Outer_Column_CS(WebDriver driver, String Select_Columns) {
		waitForElement(driver, AG_Grid_Columns_Button_DW);
		safeclick(driver, AG_Grid_Columns_Button_DW);
		waitForElement(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		safeclick(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		List<String> columns = splitAndExpand(Select_Columns);
		for (String column : columns) {
			waitForElement(driver, AG_Grid_Column_Searchbox_DW);
			clear(driver, AG_Grid_Column_Searchbox_DW);
			waitForElement(driver, AG_Grid_Column_Searchbox_DW);
			sendKeys(driver, AG_Grid_Column_Searchbox_DW, column);
			String check_box = String.format(column + AG_Grid_Column_Checkboxs_DW, column, column);
			click(driver, check_box);
		}
		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver, AG_Grid_Columns_Button_DW);
	}

	public void selectDatePickerWithTime_Proforma(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		StringBuilder time = new StringBuilder();

		waitForElement(driver, Locator);
		click(driver, Locator);
		datePickerWithTime(DateValue, day, month, year, time);
		waitForElement(driver, Year_DD);
		selectByText(driver, Year_DD, year.toString());
		waitForElement(driver, Month_DD);
		selectByText(driver, Month_DD, month.toString());
		waitForElement(driver, timeInput);
		click(driver, timeInput);
		waitForElement(driver, timeInput);
		doubleClick(driver, timeInput);
		clearAndType(driver, timeInput, time.toString());
		String date_Select = String.format(LoadConfirmation_Locators.date_select, day);
		waitForElement(driver, date_Select);
		click(driver, date_Select);
		waitForDisplay(driver, calender_close);
		if (isdisplayed(driver, calender_close)) {
			waitForElement(driver, calender_close);
			click(driver, calender_close);
		}

		waitForElement(driver, Locator);
		click(driver, Locator);

		waitForElement(driver, date_Select);
		click(driver, date_Select);
		waitForDisplay(driver, calender_close);
		if (isdisplayed(driver, calender_close)) {
			waitForElement(driver, calender_close);
			click(driver, calender_close);
		}
	}

	// 11/06/2025 Modify by Abinaya
	public void setGlobalConfiguration(WebDriver driver, String GlobalConfigurationModule, String GlobalID,
			String GlobalValue) {
		String expression = "<";
		Extent_cal(test, test1, "Open Global configuration screen");
		moduleNavigate(driver, GlobalConfigurationModule);
		List<String> Ids = splitAndExpand(GlobalID, expression);
		List<String> values = splitAndExpand(GlobalValue, expression);
		for (int i = 0; i < Ids.size(); i++) {
			String currentID = Ids.get(i);
			String currentValue = values.get(i);
			Step_Start(i + 1, "Set Global Config for ID: '" + currentID + "'", test, test1);

			waitForElement(driver, Attribute_Filter);
			sendKeys(driver, Attribute_Filter, currentID);
			formatLocatorDoubleClick(driver, Global_FilterRow, currentID);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, valueTextfield);
			clear(driver, valueTextfield);
			sendKeys(driver, valueTextfield, currentValue);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForElement(driver, Attribute_Filter);
			sendKeys(driver, Attribute_Filter, currentID);
			formatLocatorDoubleClick(driver, Global_FilterRow, currentID);
			waitForElement(driver, valueTextfield);
			String actualValue = getAttribute(driver, valueTextfield, "value");
			if (currentValue.equals(actualValue)) {
				System.out.println("Matched || Expected: " + currentValue + " || Actual: " + actualValue);
				Extent_pass(driver, "Matched || Expected: " + currentValue + " || Actual: " + actualValue, test, test1);
			} else {
				System.out.println("NotMatched || Expected: " + currentValue + " || Actual: " + actualValue);
				Extent_fail(driver, "NotMatched || Expected: " + currentValue + " || Actual: " + actualValue, test,
						test1);
			}

			Step_End(i + 1, "Global ID '" + currentID + "' set to value '" + currentValue + "'", test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
	}

	public void reSetGlobalConfiguration(WebDriver driver, String Reset_Option, String GlobalConfigurationModule,
			String GlobalID, String GlobalValue) {
		String expression = "<";
		List<String> ids = splitAndExpand(GlobalID, expression);
		List<String> values = splitAndExpand(GlobalValue, expression);
		List<String> resetList = splitAndExpand(Reset_Option, expression); // 🔁 Added

		// 🔍 Check if there's at least one "Yes"
		boolean hasAtLeastOneYes = resetList.stream().anyMatch(val -> val.equalsIgnoreCase("Yes"));
		if (!hasAtLeastOneYes) {
			System.out.println("No 'Yes' in reset list. Skipping reSetGlobalConfiguration.");
			return;
		}

		moduleNavigate(driver, GlobalConfigurationModule);

		for (int i = 0; i < resetList.size(); i++) {
			if (!resetList.get(i).equalsIgnoreCase("Yes")) {
				continue; // ⏩ Skip "No"
			}

			String id = ids.get(i);
			String value = values.get(i);

			scrollTop(driver);

			waitForElement(driver, Attribute_Filter);
			sendKeys(driver, Attribute_Filter, id);
			formatLocatorDoubleClick(driver, Global_FilterRow, id);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, valueTextfield);
			clear(driver, valueTextfield);
			sendKeys(driver, valueTextfield, value);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
		}
	}

	public void bookingRatesSelect(WebDriver driver, String rate_no, String No_Schedule_Popup,
			String first_service_data, String Voyagenumber, String Boundinput) {
		waitForDisplay(driver, Rate_Grid);
		if (isdisplayed(driver, Rate_Grid)) {
			System.out.println(
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");
			Extent_pass(driver,
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed",
					test, test1);
		} else {
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		}
		System.out.println("********** Select the Columns in Rates Grid **********");
		Extent_call(test, test1, "********** Select the Columns in Rates Grid **********");

		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		Step_Start(3, "Select the Routing ", test, test1);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber, Boundinput);
	}

	public void selectRatesRouting(WebDriver driver, String No_Schedule_Popup, String first_service_data,
			String Voyagenumber, String Boundinput) {
		waitForElement(driver, FirstserviceInput);
		String service_Value = getAttribute(driver, FirstserviceInput, "value");
		if (service_Value.equals("")) {
			Step_Start(4, "Select the Schedule", test, test1);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String Popup_Text = getText(driver, popup_Message);
				if (Popup_Text.equals(No_Schedule_Popup)) {
					click(driver, popup_Message_Ok_Button);
					System.out.println("NoSchedule available, Entering data in first service input");
					editSchedule(driver, first_service_data);
				}
			} else if (isdisplayed(driver, Invalid_date_popup)) {
				waitForDisplay(driver, Invalid_date_popup);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - Start ********");
				safeclick(driver, Invalid_date_popup_Close);
				editSchedule(driver, first_service_data);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - End ********");
				Step_End(4, "Select the Schedule", test, test1);
			}
		}
		waitForElement(driver, FirstserviceInput);
		service_Value = getAttribute(driver, FirstserviceInput, "value");
		if (service_Value.equals("")) {
			Step_Start(4, "Select the Schedule", test, test1);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String Popup_Text = getText(driver, popup_Message);
				if (Popup_Text.equals(No_Schedule_Popup)) {
					click(driver, popup_Message_Ok_Button);
					System.out.println("NoSchedule available, Entering data in first service input");
					waitForElement(driver, FirstserviceInput);
					clearAndType(driver, FirstserviceInput, first_service_data);
					click(driver, FirstserviceInput);
					keyDown(driver);
					waitForElement(driver, BKG_VoyageInput);
					sendKeys(driver, BKG_VoyageInput, Voyagenumber);
					waitForElement(driver, BKG_Boundinpiut);
					sendKeys(driver, BKG_Boundinpiut, Boundinput);
					waitForElement(driver, routing);
					click(driver, routing);
					waitForElement(driver, routing_Select_Button);
					click(driver, routing_Select_Button);
				}
			} else if (isdisplayed(driver, Invalid_date_popup)) {
				waitForDisplay(driver, Invalid_date_popup);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - Start ********");
				safeclick(driver, Invalid_date_popup_Close);
				waitForElement(driver, FirstserviceInput);
				clearAndType(driver, FirstserviceInput, first_service_data);
				click(driver, FirstserviceInput);
				keyDown(driver);
				waitForElement(driver, BKG_VoyageInput);
				sendKeys(driver, BKG_VoyageInput, Voyagenumber);
				waitForElement(driver, BKG_Boundinpiut);
				sendKeys(driver, BKG_Boundinpiut, Boundinput);
				waitForElement(driver, routing);
				click(driver, routing);
				waitForElement(driver, routing_Select_Button);
				click(driver, routing_Select_Button);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - End ********");
				Step_End(4, "Select the Schedule", test, test1);
			} else {
				waitForElement(driver, FirstserviceInput);
				clearAndType(driver, FirstserviceInput, first_service_data);
				click(driver, FirstserviceInput);
				keyDown(driver);
				waitForElement(driver, BKG_VoyageInput);
				sendKeys(driver, BKG_VoyageInput, Voyagenumber);
				waitForElement(driver, BKG_Boundinpiut);
				sendKeys(driver, BKG_Boundinpiut, Boundinput);
				waitForElement(driver, routing);
				click(driver, routing);
				waitForElement(driver, routing_Select_Button);
				click(driver, routing_Select_Button);
			}
		}
	}
	// method used to merge the locator with Inputvalue dynamically, and then
	// perform click action

	public String formatLocatorClick(WebDriver driver, String Locator, String value) {
		String element = "";
		try {
			element = String.format(Locator, value);
			waitForElement(driver, element);
			click(driver, element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
		}
		return element;
	}
	// method used to merge the locator with Inputvalue dynamically, and then
	// perform is displayed condition

	public boolean formatLocatorIsDisplayed(WebDriver driver, String Locator, String value) {
		String element = String.format(Locator, value);
		try {
			waitForDisplay(driver, element);
			return isdisplayed(driver, element);
		} catch (Exception e) {
			return false;
		}
	}

	public static List<Map<String, String>> readSpreadsheet(String filePath) {
		if (filePath.endsWith(".csv")) {
			return readCSV(filePath); // CSV reader
		} else if (filePath.endsWith(".xls") || filePath.endsWith(".xlsx")) {
			return readExcel(filePath); // Excel reader
		} else {
			throw new IllegalArgumentException("Unsupported file type: " + filePath);
		}
	}

	public static List<Map<String, String>> readExcel(String filePath) {
		List<Map<String, String>> dataList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0); // First sheet
			Iterator<Row> rowIterator = sheet.iterator();

			if (!rowIterator.hasNext()) {
				throw new RuntimeException("Excel sheet is empty.");
			}

			// First row → header
			Row headerRow = rowIterator.next();
			List<String> headers = new ArrayList<>();
			for (Cell cell : headerRow) {
				headers.add(cell.getStringCellValue().trim());
			}

			// Remaining rows → data
			while (rowIterator.hasNext()) {
				Row dataRow = rowIterator.next();
				Map<String, String> rowData = new LinkedHashMap<>();

				for (int i = 0; i < headers.size(); i++) {
					Cell cell = dataRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					rowData.put(headers.get(i), getCellValueAsString(cell));
				}

				dataList.add(rowData);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	public static boolean compareCleanedListOfMaps(List<Map<String, String>> expected,
			List<Map<String, String>> actual) {
		if (expected == null || actual == null || expected.size() > actual.size()) {
			return false;
		}

		List<Map<String, String>> cleanedExpected = cleanMapList(expected);
		List<Map<String, String>> cleanedActual = cleanMapList(actual);

		List<Map<String, String>> unmatchedActual = new ArrayList<>(cleanedActual);

		for (Map<String, String> expMap : cleanedExpected) {
			boolean matchFound = false;

			Iterator<Map<String, String>> iterator = unmatchedActual.iterator();
			while (iterator.hasNext()) {
				Map<String, String> actMap = iterator.next();
				if (CompareMapValues1(expMap, actMap)) {
					matchFound = true;
					iterator.remove();
					break;
				}
			}

			if (!matchFound) {
				System.out.println("❌ No match found for row: " + expMap);
				return false;
			}
		}

		return true;
	}

	private static List<Map<String, String>> cleanMapList(List<Map<String, String>> mapList) {
		List<Map<String, String>> cleanedList = new ArrayList<>();

		for (Map<String, String> originalMap : mapList) {
			Map<String, String> cleanedMap = new LinkedHashMap<>();

			for (Map.Entry<String, String> entry : originalMap.entrySet()) {
				String rawKey = entry.getKey();
				String cleanKey = clean(rawKey);
				String cleanValue = clean(entry.getValue());

				if (!rawKey.equals(cleanKey)) {
					System.out.println("🔍 Key cleaned: [" + rawKey + "] → [" + cleanKey + "]");
				}

				cleanedMap.put(cleanKey, cleanValue); // Key inserted after cleaning!
			}

			cleanedList.add(cleanedMap);
		}

		return cleanedList;
	}

	public static String clean(String s) {
		if (s == null)
			return "";
		return s.replace("\uFEFF", "") // BOM
				.replaceAll("[\\u200E\\u200F]", "") // LRM/RLM
				.replaceAll("\\p{C}", "") // Control characters
				.trim();
	}

	public void scrollGridToTop(WebDriver driver, String gridRootXpath) {
		String[] values = splitXpath(gridRootXpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		WebElement viewport = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(values[1] + "//div[contains(@class,'ag-body-viewport')]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = 0;", viewport);
	}

	public boolean isColumnPinnedLeft(WebDriver driver, String headerLocator, String headerText) {
		String[] values = splitXpath(headerLocator);
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));

			String locator = String.format(values[1], headerText);
			WebElement header = driver.findElement(By.xpath(locator));

			boolean pinnedLeft = header.findElements(By.xpath("./ancestor::div[contains(@class,'ag-pinned-left')]"))
					.size() > 0;

			return pinnedLeft; // TRUE if pinned left, otherwise FALSE
		} catch (NoSuchElementException e) {
			return false; // header not found = not pinned
		}
	}

	// method used to merge the locator with Inputvalue dynamically, and then
	// perform Double click
	public static List<Map<String, String>> getAllExcelDatas(String filePath) {
		List<Map<String, String>> dataList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0); // Get first sheet by index (0)
			Iterator<Row> rowIterator = sheet.iterator();

			if (!rowIterator.hasNext())
				return dataList;

			// Read header row
			Row headerRow = rowIterator.next();
			List<String> headers = new ArrayList<>();
			for (Cell cell : headerRow) {
				headers.add(cell.getStringCellValue());
			}

			// Read data rows
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Map<String, String> rowData = new HashMap<>();

				for (int i = 0; i < headers.size(); i++) {
					Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					rowData.put(headers.get(i), cell.getStringCellValue());
				}

				dataList.add(rowData);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	public static List<Map<String, String>> getAllExcelDatas1(String filePath) {
		List<Map<String, String>> dataList = new ArrayList<>();
		DataFormatter formatter = new DataFormatter();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			if (!rowIterator.hasNext())
				return dataList;

			// Header row
			Row headerRow = rowIterator.next();
			List<String> headers = new ArrayList<>();
			for (Cell cell : headerRow) {
				String header = formatter.formatCellValue(cell).trim();
				headers.add(header);
			}

			// Data rows
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Map<String, String> rowData = new LinkedHashMap<>();
				boolean isRowCompletelyBlank = true;

				for (int i = 0; i < headers.size(); i++) {
					Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

					String value = "";
					try {
						if (cell != null) {
							value = formatter.formatCellValue(cell).trim();
						}
					} catch (Exception e) {
						value = ""; // Safe fallback
						System.out.println("Warning: Failed to read cell at row " + row.getRowNum() + ", col " + i);
					}

					if (!value.isEmpty())
						isRowCompletelyBlank = false;

					rowData.put(headers.get(i), value);
				}

				if (!isRowCompletelyBlank) {
					dataList.add(rowData);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	public String formatLocatorDoubleClick(WebDriver driver, String Locator, String value) {
		String element = "";
		try {
			element = String.format(Locator, value);
			waitForElement(driver, element);
			doubleClick(driver, element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
		}
		return element;
	}

	// method used to merge the locator with Inputvalue dynamically, and then
	// perform right click
	// Vignesh 03-04-2024
	public String formatRightClick(WebDriver driver, String Locator, String value) {
		String element = "";
		try {
			element = String.format(Locator, value);
			waitForElement(driver, element);
			RightClick(driver, element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
		}
		return element;
	}

	// method used to merge the locator with Inputvalue dynamically, and then
	// perform sendkeys
	// Vignesh 03-04-2024

	public String formatLocatorSendKeys(WebDriver driver, String Locator, String value, String inputValue) {
		String element = "";
		try {
			element = String.format(Locator, value);
			waitForElement(driver, element);
			Newclear(driver, element);
			sendKeys(driver, element, inputValue);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
		}
		return element;
	}

	/*
	 * Used to get the attribute value of the element for the particular element
	 */
	public String getAttributeForElement(WebDriver driver, WebElement element, String attribute) {
		try {
			String textInsideInputBox = element.getDomAttribute(attribute);
			Extent_pass(driver, "Get the Attribute value of element ", test, test1);
			if (textInsideInputBox.equals(null)) {
				textInsideInputBox = "";
			}
			return textInsideInputBox;
		} catch (NoSuchElementException e) {
			return "";
		}
	}

	/*
	 * Used to verify the particular element is present or not
	 */
	public boolean verifyElementIsPresent(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
			return false;
		}
	}

	/*
	 * Used to verify the particular Element is displayed in the page
	 */
	public boolean isDisplayed(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Method to generate Extent Report with table format
	public static StringBuilder generateExtentReport(Map<String, Map<String, String>> blData) {
		// Create an HTML table
		StringBuilder table = new StringBuilder();
		table.append("<table border='1' style='border-collapse:collapse;width:100%;text-align:center;'>");
		// Table Header
		table.append("<tr style='background-color:#f2f2f2;font-weight:bold;'>").append(
				"<th>BL Number</th><th>Service</th><th>Vessel</th><th>Voyage</th><th>Bound</th><th>Port</th><th>Terminal</th></tr>");
		// Table Rows (Data)
		for (Map.Entry<String, Map<String, String>> entry : blData.entrySet()) {
			Map<String, String> values = entry.getValue();
			table.append("<tr>").append("<td>").append(entry.getKey()).append("</td>").append("<td>")
					.append(values.get("Service")).append("</td>").append("<td>").append(values.get("Vessel"))
					.append("</td>").append("<td>").append(values.get("Voyage")).append("</td>").append("<td>")
					.append(values.get("Bound")).append("</td>").append("<td>").append(values.get("Port"))
					.append("</td>").append("<td>").append(values.get("Terminal")).append("</td>").append("</tr>");
		}
		return table.append("</table>"); // Close table
	}

	/*
	 * Helper method to create BL details
	 */
	public static Map<String, String> createBLDetails(String service, String vessel, String voyage, String bound,
			String port, String terminal) {
		Map<String, String> details = new LinkedHashMap<>();
		details.put("Service", service);
		details.put("Vessel", vessel);
		details.put("Voyage", voyage);
		details.put("Bound", bound);
		details.put("Port", port);
		details.put("Terminal", terminal);
		return details;
	}

	/*
	 * Used to verify the particular Element is displayed in the page for 3 seconds
	 */
	public boolean isdisplayed(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Display_WaitTime));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Used to get the table value
	 */
	public List<Map<String, String>> extractTableDataCountMissMatch(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			// Wait until the table is present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate the parent div containing the table data
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));

			// Get all header cells
			List<WebElement> headers = tableContainer
					.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));

			// Store headers in a list
			List<String> columnHeaders = new ArrayList<>();
			for (WebElement header : headers) {
				columnHeaders.add(header.getText().trim());
			}

			// Get all rows from the container
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));

			// List to store each row as a map
			List<Map<String, String>> tableData = new ArrayList<>();

			// Iterate through the rows
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-value')]"));

				if (cells.size() == columnHeaders.size() - 1) {
					Map<String, String> rowData = new HashMap<>();
					for (int i = 0; i < cells.size(); i++) {
						rowData.put(columnHeaders.get(i + 1), cells.get(i).getText().trim());
					}
					tableData.add(rowData);
				} else {
					System.out.println("⚠️ Row cell count mismatch. Headers: " + columnHeaders.size() + ", Cells: "
							+ cells.size());
				}
			}

			return tableData;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	public static List<Double> sumDoubleLists(List<Double> list1, List<Double> list2) {
		List<Double> result = new ArrayList<>();
		int size = Math.min(list1.size(), list2.size());

		for (int i = 0; i < size; i++) {
			result.add(list1.get(i) + list2.get(i));
		}

		return result;
	}

	/*
	 * Used to close the current tab
	 */
	public void closetab(WebDriver driver) {
		try {
			Robot r = new Robot();
			// Robot might take some times to perform the actions so we gave manual wait
			// from the test configuration file
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_W);
			wait(driver, WaitForDisplay_Time);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_W);
			wait(driver, WaitForDisplay_Time);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			wait(driver, ScrollWaitTime);
		} catch (Exception e) {
		}
	}

	/*
	 * Used to Scroll the particular element
	 */
	public void scrollUsingElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to Scroll the particular element
	 */
	public void scrollToElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds)); // 10 seconds wait
		try {
			// Wait for the element to be visible
			wait.until(ExpectedConditions.visibilityOf(element));

			// Attempt to scroll to the element with retries
			for (int i = 0; i < 3; i++) { // Retry up to 3 times
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					break; // Break if successful
				} catch (Exception e) {
					System.err.println("Scroll attempt " + (i + 1) + " failed: " + e.getMessage());
					if (i == 2) { // On the last attempt, fail
						verifyServerStatus(driver); // Assuming this method checks the server status
						Assert.fail("Scrolling failed after multiple attempts.");
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Element not visible or other issue: " + e.getMessage());
			verifyServerStatus(driver); // Check server status in case of failure
			Assert.fail("Scrolling failed due to an exception: " + e.getMessage());
		}
	}

	/*
	 * Used to get the table data from application
	 */
	public List<Map<String, String>> getTableDatawithscroll(WebDriver driver, String Header, String Row, String Scroll,
			int scrollfront, int scrollback) {
		String[] columnheader = splitXpath(Header);
		String[] row = splitXpath(Row);
		List<WebElement> headers = driver.findElements(By.xpath(columnheader[1]));
		List<String> headerTexts = new ArrayList<>();
		wait(driver, WaitForDisplay_Time);
		for (WebElement header : headers) {
			String headername = header.getDomAttribute("aria-label");
			try {
				if (headername.contains(":")) {
					String[] headerName = headername.split(":");
					headerTexts.add(headerName[0]);
				} else {
					headerTexts.add(headername);
				}
			} catch (NullPointerException e) {
				headerTexts.add(header.getText());
				horizontalscroll(driver, Scroll, scrollfront);
				continue;
			}
			horizontalscroll(driver, Scroll, scrollfront);
		}
		horizontalscroll(driver, Scroll, scrollback);
		// Locate the values table
		List<WebElement> rows = driver.findElements(By.xpath(row[1]));
		// List to hold all row data as a list of maps
		List<Map<String, String>> tableData = new ArrayList<>();
		// Iterate through each row (starting from 1 to skip the header row)
		int k = 1;
		for (WebElement tableRow : rows) {
			try {
				List<WebElement> cells = tableRow.findElements(By.tagName("td"));
				// Create a map for each row
				Map<String, String> rowData = new HashMap<>();

				for (int j = 0; j < cells.size(); j++) {
					if (j < headerTexts.size()) {
						rowData.put(headerTexts.get(j), cells.get(j).getText());
					}
				}
				// Add the row map to the list
				tableData.add(rowData);
			} catch (Exception e) {
				System.err.println("Error processing row " + k + ": " + e.getMessage());
				e.printStackTrace();
				Extent_fail(driver, "Error processing row " + k + ": " + e.getMessage(), test, test1);
				global.add("Error processing row " + k + ": " + e.getMessage());
				verifyServerStatus(driver);
				Assert.fail("Element is not present " + e.getLocalizedMessage());
			}
			k++;
		}
		// Fetch values by header
		return tableData;
	}

	/*
	 * Used to get the table data from application
	 */
	// importdoc
	public List<String> getValuesByFirstColumnAndHeader(List<Map<String, String>> tableData, String firstColumnHeader,
			List<String> firstColumnValues, String columnHeader) {

		List<String> matchingValues = new ArrayList<>();

		// Iterate through each row in the table
		for (Map<String, String> row : tableData) {
			// Check if the row matches any of the first column values
			if (row.containsKey(firstColumnHeader) && firstColumnValues.contains(row.get(firstColumnHeader))) {
				// If there's a match, add the value from the specified column header to the
				// list
				if (row.containsKey(columnHeader)) {
					matchingValues.add(row.get(columnHeader));
				}
			}
		}

		return matchingValues; // Return the list of matching values
	}

	public void reArrangeAG_GridColumnsNewfeeder(WebDriver driver, String Locator, String Select_Columns) {
		waitForElement(driver, Locator);
		safeclick(driver, Locator);
		if (isdisplayed(driver, Column_Search_Input_feeder)) {
			waitForElement(driver, Column_Search_Input_feeder);
			safeclick(driver, SelectAll_Column_CheckBox_Feeder);
			List<String> columns = splitAndExpand(Select_Columns);
			for (String column : columns) {
				waitForElement(driver, Column_Search_Input_feeder);
				Newclear(driver, Column_Search_Input_feeder);
				waitForElement(driver, Column_Search_Input_feeder);
				sendKeys(driver, Column_Search_Input_feeder, column);

				String check_box = String.format(Select_Column_tableHead, column, column);
				waitForDisplay(driver, check_box);
				jsClick(driver, check_box);
			}
		} else {
			waitForElement(driver, Column_Search_Input_feeder1);
			safeclick(driver, SelectAll_Column_CheckBox_Feeder1);
			List<String> columns = splitAndExpand(Select_Columns);
			for (String column : columns) {
				waitForElement(driver, Column_Search_Input_feeder1);
				Newclear(driver, Column_Search_Input_feeder1);
				waitForElement(driver, Column_Search_Input_feeder1);
				sendKeys(driver, Column_Search_Input_feeder1, column);

				String check_box = String.format(Select_Column_tableHead, column, column);
				waitForDisplay(driver, check_box);
				jsClick(driver, check_box);
			}
		}
		waitForElement(driver, Locator);
		click(driver, Locator);
	}

	public boolean ChecklistOfElements(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		boolean flag = true;
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/*
	 * Used to get the table format for report
	 */
	public String TableDataForReport(WebDriver driver, List<Map<String, String>> tableData, String tableName,
			List<String> excelHeaders) {
		// Determine maximum column widths
		int[] columnWidths = new int[excelHeaders.size()];

		// Initialize widths based on header lengths
		for (int i = 0; i < excelHeaders.size(); i++) {
			columnWidths[i] = excelHeaders.get(i).length();
		}

		// Update widths based on data (Case-Insensitive Check)
		for (Map<String, String> row : tableData) {
			for (int i = 0; i < excelHeaders.size(); i++) {
				String header = excelHeaders.get(i);
				String value = getCaseInsensitiveValue(row, header); // Case-Insensitive Retrieval
				if (value != null) {
					columnWidths[i] = Math.max(columnWidths[i], value.length());
				}
			}
		}

		// StringBuilder for constructing the HTML table
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<h3>").append(tableName).append("</h3>");
		tableBuilder.append("<table style='width:100%; border-collapse: collapse;'>");
		tableBuilder.append("<thead><tr>");

		// Add headers to HTML and print to console
		StringBuilder headerRow = new StringBuilder();
		for (String header : excelHeaders) {
			tableBuilder.append("<th style='border: 1px solid #ddd; padding: 8px;'>").append(header).append("</th>");
			headerRow.append(String.format("%-" + (columnWidths[excelHeaders.indexOf(header)] + 2) + "s", header));
		}
		tableBuilder.append("</tr></thead><tbody>");

		int lineLength = Arrays.stream(columnWidths).sum() + 2 * columnWidths.length;
		String separator = repeatChar('-', lineLength);

		System.out.println(separator);
		System.out.println(tableName + " : ");
		System.out.println(separator);
		System.out.println(headerRow.toString());
		System.out.println(separator);

		// Add rows to HTML and print to console
		for (Map<String, String> row : tableData) {
			tableBuilder.append("<tr>");
			StringBuilder rowOutput = new StringBuilder();
			for (String header : excelHeaders) {
				String value = getCaseInsensitiveValue(row, header); // Case-Insensitive Retrieval
				if (value != null) {
					tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>").append(value)
							.append("</td>");
					rowOutput.append(
							String.format("%-" + (columnWidths[excelHeaders.indexOf(header)] + 2) + "s", value));
				} else {
					tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>N/A</td>");
					rowOutput.append(
							String.format("%-" + (columnWidths[excelHeaders.indexOf(header)] + 2) + "s", "N/A"));
				}
			}
			tableBuilder.append("</tr>");
			System.out.println(rowOutput.toString()); // Print each row to console
		}

		System.out.println(separator);
		tableBuilder.append("</tbody></table>");
		return tableBuilder.toString(); // Return the generated HTML for further use if needed
	}

	// Helper method to repeat a character
	String repeatChar(char ch, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(ch);
		}
		return sb.toString();
	}

	// Helper method to retrieve value in a case-insensitive manner
	private String getCaseInsensitiveValue(Map<String, String> row, String header) {
		for (Map.Entry<String, String> entry : row.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(header)) {
				return entry.getValue();
			}
		}
		return null; // Return null if no matching key is found
	}

	public boolean compareTableDataContainsValues(List<List<String>> table1, List<List<String>> table2) {
		// Iterate through each row in table2 and check if it exists in table1
		for (List<String> row2 : table2) {
			boolean rowFound = false; // Flag to check if row2 is found in table1

			// Iterate through each row in table1
			for (List<String> row1 : table1) {
				// Check if the values in row2 are contained in row1
				boolean rowMatch = true;
				for (int j = 0; j < row2.size(); j++) {
					String value1 = row1.get(j).replace(",", "").trim(); // Clean up values in row1
					String value2 = row2.get(j).replace(",", "").trim(); // Clean up values in row2

					// If value2 is not contained in value1, this row doesn't match
					if (!value1.contains(value2) && !value2.contains(value1)) {
						rowMatch = false;
						break; // No need to check further if this row doesn't match
					}
				}

				// If we found a matching row, set rowFound to true and break out of the loop
				if (rowMatch) {
					rowFound = true;
					break;
				}
			}

			// If any row from table2 isn't found in table1, return false
			if (!rowFound) {
				System.out.println("Row not found in Table1: " + row2);
				return false;
			}
		}

		// If all rows from table2 are found in table1, return true
		System.out.println("All rows in Table2 are present in Table1.");
		return true;
	}

	/*
	 * Used to get the string value from the table
	 */
	public String getFirstValueByHeader(List<Map<String, String>> tableData, String header) {
		for (Map<String, String> row : tableData) {
			// Check if the row contains the specified header
			if (row.containsKey(header)) {
				return row.get(header); // Return the first value found in that column
			}
		}
		return null; // Return null if the header is not found
	}

	public static double getSumOfListValues(WebDriver driver, List<String> values) {
		double sum = 0.0; // Initialize sum
		for (String value : values) {
			try {
				// Remove commas and trim spaces
				String cleanedValue = "";
				if (value.contains(",")) {
					cleanedValue = value.replace(",", "").trim();
				} else {
					cleanedValue = value;
				}
				// Convert to double and add to sum
				sum += Double.parseDouble(cleanedValue);
			} catch (NumberFormatException e) {
				System.err.println("Skipping invalid number: " + value);
				Extent_fail(driver, "Skipping invalid number: " + value, test, test);
			}
		}
		return sum;
	}

	/*
	 * Used to get the List of string value from the table
	 */
	public List<String> getValuesByFirstColumnAndHeader(List<Map<String, String>> tableData, String firstColumnHeader,
			String firstColumnValue, String columnHeader) {
		List<String> matchingValues = new ArrayList<>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader) && row.get(firstColumnHeader).equals(firstColumnValue)) {
				// If there's a match, add the value from the specified column header to the
				// list
				if (row.containsKey(columnHeader)) {
					matchingValues.add(row.get(columnHeader));
				}
			}
		}
		return matchingValues; // Return the list of matching values
	}

	/*
	 * Converts a List<String> to a List<Double>, removing commas only if present.
	 * 
	 * @param stringList The input list of strings to convert.
	 * 
	 * @return A list of doubles parsed from the input list.
	 * 
	 * @throws NumberFormatException If any string is not a valid double.
	 */
	public static List<Double> convertStringListToDoubleList(WebDriver driver, List<String> stringList) {
		if (stringList == null) {
			Extent_fail(driver, "Input list cannot be null.", test, test1);
			return Collections.emptyList(); // return empty list to avoid null return
		}
		return stringList.stream().filter(str -> str != null && !str.trim().isEmpty()) // skip null or empty values
				.map(str -> str.contains(",") ? str.replace(",", "") : str) // remove commas
				.map(Double::parseDouble) // convert to double
				.collect(Collectors.toList());
	}

	/*
	 * Used to get the string value from the table
	 */
	public List<String> getValuesByColumnHeaders(List<Map<String, String>> tableData, String matchColumnHeader,
			String matchColumnValue, List<String> columnHeaders) {
		List<String> matchingValues = new ArrayList<>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(matchColumnHeader) && row.get(matchColumnHeader).equals(matchColumnValue)) {
				// If there's a match, add values from the specified column headers to the list
				for (String columnHeader : columnHeaders) {
					if (row.containsKey(columnHeader)) {
						matchingValues.add(row.get(columnHeader));
					}
				}
			}
		}
		return matchingValues; // Return the list of matching values
	}

	/*
	 * Method to retrieve value by first column value and header
	 */
	public String getValueByFirstColumnAndHeader(List<Map<String, String>> tableData, String FirstColumnHeader,
			String firstColumnValue, String columnHeader) {
		for (Map<String, String> row : tableData) {
			if (row.containsKey(FirstColumnHeader) && row.get(FirstColumnHeader).equals(firstColumnValue)) { // Adjust
				// "Equipment
				// Id"
				// as
				// needed
				return row.get(columnHeader); // Return the value for the specified column header
			}
		}
		return "Value not found"; // Return message if not found
	}

	/*
	 * Method to fetch values by header
	 */
	public static List<String> getValuesByHeader(List<Map<String, String>> tableData, String header) {
		List<String> values = new ArrayList<>();
		for (Map<String, String> row : tableData) {
			if (row.containsKey(header)) {
				values.add(row.get(header));
			}
		}
		return values;
	}

	public static List<Double> addStringValueToList(List<String> values, String extraValue) {
		double extra = 0.0;
		try {
			extra = Double.parseDouble(extraValue); // Convert string to double
		} catch (Exception e) {
		}
		List<Double> result = new ArrayList<>();
		try {
			for (String val : values) {
				double number = Double.parseDouble(val); // Convert each value to double
				result.add(number + extra); // Sum and add to result list
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static int convertStringToInteger(String data) {
		int value = 0;
		try {
			value = Integer.parseInt(data);
		} catch (Exception e) {
		}
		return value;
	}

	public List<Map<String, String>> extractTableDataDirect3(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			// Wait until the table is present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate the parent div containing the table data
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));

			// Get all header cells
			List<WebElement> headers = tableContainer
					.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));

			// Store headers in a list
			List<String> columnHeaders = new ArrayList<>();
			for (WebElement header : headers) {
				columnHeaders.add(header.getText().trim());
			}

			// Get all rows from the container
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));

			System.out.println("Total rows found: " + rows.size());

			// List to store each row as a map
			List<Map<String, String>> tableData = new ArrayList<>();

			// Iterate through the rows
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.xpath(".//div[@role='gridcell']"));

				// Ensure the number of cells matches the number of headers
				if (cells.size() == columnHeaders.size()) {
					Map<String, String> rowData = new HashMap<>();
					for (int i = 0; i < cells.size(); i++) {
						rowData.put(columnHeaders.get(i), cells.get(i).getText().trim());
					}
					tableData.add(rowData);
				} else {
					System.out.println("Row cell count mismatch with header count.");
				}
			}

			return tableData;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	public static String multiplyCurrencyValue(String currencyCode, String amount, String exchangeRate) {
		try {
			// Convert string inputs to double
			double amountValue =0.0;
			if(amount.contains(",")) {
			 amountValue = Double.parseDouble(amount.replace(",",""));
			}else {
				 amountValue = Double.parseDouble(amount);
				
			}
			double exchangeRateValue =0.0;
			if(exchangeRate.contains(",")) {
			 exchangeRateValue = Double.parseDouble(exchangeRate.replace(",",""));
			}else {
				 exchangeRateValue = Double.parseDouble(exchangeRate);
				
			}
			// Perform multiplication
			double convertedAmount = amountValue * exchangeRateValue;
			// Format result to 3 decimal places
			return formatToThreeDecimalPlaces(convertedAmount);
		} catch (NumberFormatException e) {
			return "Invalid input: Please provide valid numeric values.";
		}
	}

	public static boolean areEqualIgnoringSign(int num1, int num2) {
		// Compare the absolute values of the numbers
		return Math.abs(num1) == Math.abs(num2);
	}

	public static Map<String, String> getValueByRowAndHeaders(List<Map<String, String>> tableData, int rowIndex,
			List<String> headers) {
		Map<String, String> result = new HashMap<>();
		if (rowIndex >= 0 && rowIndex < tableData.size()) {
			Map<String, String> row = tableData.get(rowIndex);
			for (String header : headers) {
				result.put(header, row.getOrDefault(header, "N/A"));
			}
		}
		return result;
	}

	/*
	 * Method to fetch values from a specific column while excluding rows with
	 * specific values in another column
	 */
	public static List<String> getFilteredValuesByHeader(List<Map<String, String>> tableData, String targetHeader,
			String conditionHeader, List<String> excludedValues) {
		List<String> values = new ArrayList<>();
		for (Map<String, String> row : tableData) {
			// Exclude rows that contain any value in the excludedValues list
			if (row.containsKey(conditionHeader) && !excludedValues.contains(row.get(conditionHeader))) {
				if (row.containsKey(targetHeader)) {
					values.add(row.get(targetHeader));
				}
			}
		}
		return values;
	}

	/*
	 * Used to Scroll the particular element to center of the page
	 */
	public void scrollElementToCenter(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			// wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			((JavascriptExecutor) driver).executeScript(
					"const element = arguments[0];" + "const elementRect = element.getBoundingClientRect();"
							+ "const absoluteElementTop = elementRect.top + window.pageYOffset;"
							+ "const middle = absoluteElementTop - (window.innerHeight / 2) + (elementRect.height / 2);"
							+ "window.scrollTo({ top: middle, behavior: 'smooth' });",
					element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to verify the column headers values are present or not from the table
	 */
	public static void verifyColumnHeaders(List<Map<String, String>> tableData, List<String> expectedColumns) {
		if (tableData.isEmpty()) {
			System.err.println("Table data is empty. No headers to verify.");
			return;
		}
		// Extract actual header names from the first row of the table data
		List<String> actualHeaders = new ArrayList<>(tableData.get(0).keySet());
		// Verify expected columns
		for (String expectedColumn : expectedColumns) {
			if (!actualHeaders.contains(expectedColumn)) {
				System.err.println("Missing expected column: " + expectedColumn);
				// Optionally, log or throw an exception
			}
		}
	}

	/*
	 * Used to Scroll the page in the horizontal direction
	 */
	public void horizontalscroll(WebDriver driver, String xpath, int input) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollLeft += " + input + ";", element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	public void VerticalScroll_Bottom(WebDriver driver, String xpath) {
		String value[] = splitXpath(xpath);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean elementFound = false;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Scroll_WaitTime));

		while (!elementFound) {
			try {
				WebElement element = driver.findElement(By.xpath(value[1]));

				if (element.isDisplayed()) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Scroll_WaitTime));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					elementFound = true;
					System.out.println("Element is visible!");
				} else {
					js.executeScript("arguments[0].scrollIntoView(true);", element);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver, e.getLocalizedMessage(), test, test);
			}
		}
	}

	public void VerticalScroll_Visible(WebDriver driver, String xpath, String scroll) {
		String value[] = splitXpath(xpath);
		String scrollpath[] = splitXpath(scroll);

		WebElement scroller = driver.findElement(By.xpath(scrollpath[1]));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean elementFound = false;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Scroll_WaitTime));

		while (!elementFound) {
			try {
				WebElement element = driver.findElement(By.xpath(value[1]));

				if (element.isDisplayed()) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Scroll_WaitTime));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					elementFound = true;
					System.out.println("Element is visible!");
				} else {
					js.executeScript("arguments[0].scrollIntoView(true);", element);
				}
			} catch (Exception e) {
				Long currentScroll = ((Number) js.executeScript("return arguments[0].scrollTop;", scroller))
						.longValue();
				Long maxScroll = ((Number) js
						.executeScript("return arguments[0].scrollHeight - arguments[0].clientHeight;", scroller))
						.longValue();

				if (currentScroll >= maxScroll) {
					System.out.println("Reached the end of the scroll area. Element not found.");
					break;
				}

				js.executeScript("arguments[0].scrollTop += 100;", scroller);
			}
		}
	}

	/*
	 * Used to convert the currency value
	 */
	public static String convertToCurrency(List<String> currencyCodes, List<String> amounts,
			List<String> roeCurrencyCodes, List<String> roeValues, String targetCurrency) {
		// Step 1: Create a map for currency amounts
		Map<String, Double> currencyAmounts = new HashMap<>();
		// Step 2: Populate the currency amounts map
		for (int i = 0; i < currencyCodes.size(); i++) {
			String currency = currencyCodes.get(i);
			double amount = parseAmount(amounts.get(i));
			currencyAmounts.put(currency, currencyAmounts.getOrDefault(currency, 0.0) + amount);
		}
		// Step 3: Create a map for the exchange rates to USD
		Map<String, Double> exchangeRates = new HashMap<>();
		// Step 4: Populate the exchange rates map
		for (int i = 0; i < roeCurrencyCodes.size(); i++) {
			String currency = roeCurrencyCodes.get(i);
			double rate = parseAmount(roeValues.get(i));
			exchangeRates.put(currency, 1.0 / rate); // Store 1 / ROE for conversion to USD
		}
		// Step 5: Calculate total in USD
		double totalUSD = 0.0;
		for (Map.Entry<String, Double> entry : currencyAmounts.entrySet()) {
			String currency = entry.getKey();
			double totalAmount = entry.getValue();
			double exchangeRate = exchangeRates.getOrDefault(currency, 1.0); // Default to 1.0 for USD
			totalUSD += totalAmount * exchangeRate; // Convert and accumulate
		}
		// Step 6: Get exchange rate for the target currency
		double targetCurrencyExchangeRate = exchangeRates.getOrDefault(targetCurrency, 1.0); // Default to 1.0 if not
		// found
		// Step 7: Convert total USD to the target currency
		double totalTargetCurrency = totalUSD / targetCurrencyExchangeRate;
		return formatToThreeDecimalPlaces(totalTargetCurrency);
	}

	private static String formatToThreeDecimalPlaces(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(3, RoundingMode.HALF_UP); // Round to 3 decimal places
		return bd.toString(); // Convert to String
	}

	private static double parseAmount(String amountStr) {
		if (amountStr.contains(",")) {
			amountStr = amountStr.replace(",", "");
		}
		return Double.parseDouble(amountStr);
	}

	/*
	 * Used to Verify the Element is Enabled or not in that page
	 */
	public boolean isElementEnabled(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.isEnabled();
			Extent_pass(driver, "Element ' " + values[0] + " 'is  enabled ", test, test1);
			return webElement.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Used to Verify the Element is Selected or not in that page
	 */
	public boolean isElementSelected(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.isSelected();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Used to Verify the Element is Clickable or not
	 */
	public void isElementClickable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			waits.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to Verify the Element is Selectable or not
	 */
	public void isElementSelectable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			waits.until(ExpectedConditions.elementToBeSelected(webElement));
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to refresh the web page
	 */
	public void refreshPage(WebDriver driver) {
		try {
			wait(driver, ScrollWaitTime);
			driver.navigate().refresh();
			wait(driver, ScrollWaitTime);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail(e.getLocalizedMessage());
		}
	}

	/*
	 * Used to Verify the Element is Clickable or not
	 */
	public void maximize(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail(e.getLocalizedMessage());
		}
	}

	/*
	 * Used to Perform the Enter Action on that page
	 */
	public void enter(WebDriver driver) {
		try {
			// Action class take some time performing action, So we have gave the manual
			// wait here
			wait(driver, ScrollWaitTime);
			Actions actionObject = new Actions(driver);
			actionObject.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail(e.getLocalizedMessage());
		}
	}

	/*
	 * Used to accept the alert on that web page
	 */
	public String alertAccept(WebDriver driver, String path) {
		String[] values = splitXpath(path);

		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.click();
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			return alertText;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail(e.getLocalizedMessage());
			return null;
		}
	}

	/*
	 * Used to dismiss the alert on the web page
	 */
	public void dismissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/*
	 * Used to switch the driver focus current page to the frame
	 */
	public void switchToFrame(WebDriver driver, String frameName) {
		String[] values = splitXpath(frameName);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
		}
	}

	/*
	 * Used to switch the driver focus frame in to current page
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail(e.getLocalizedMessage());
		}
	}

	public static void verifyBalance(WebDriver driver, List<String> amounts, List<String> expectedBalances) {
		// Convert string list to double array, handling commas
		double[] values = amounts.stream().map(s -> s.replace(",", "")) // Remove commas
				.mapToDouble(Double::parseDouble).toArray();

		double[] expectedValues = expectedBalances.stream().map(s -> s.replace(",", "")) // Remove commas
				.mapToDouble(Double::parseDouble).toArray();

		if (values.length != 2 || expectedValues.length != 2) {
			Extent_fail(driver, "Exactly two input values and two expected values are required.", test, test1);
			throw new IllegalArgumentException("Exactly two input values and two expected values are required.");
		}

		// Calculate balance values
		double totalBalance = values[0] + values[1];
		double[] balances = { 0, totalBalance };

		// Loop to verify each invoice separately
		for (int i = 0; i < 2; i++) {
			String iterationLog = "Iteration " + (i + 1) + ":";
			String invoiceAmtLog = "Invoice " + (i + 1) + " AMT: " + values[i];
			String calculatedBalanceLog = "Calculated Balance: " + balances[i];
			String expectedBalanceLog = "Expected Balance: " + expectedValues[i];

			// Logging to console
			System.out.println(iterationLog);
			System.out.println(invoiceAmtLog);
			System.out.println(calculatedBalanceLog);
			System.out.println(expectedBalanceLog);

			// Logging to Extent report
			Extent_pass(driver, iterationLog, test, test1);
			Extent_pass(driver, invoiceAmtLog, test, test1);
			Extent_pass(driver, calculatedBalanceLog, test, test1);
			Extent_pass(driver, expectedBalanceLog, test, test1);

			// Verify correctness
			try {
				Assert.assertEquals(balances[i], expectedValues[i], "Mismatch in Invoice " + (i + 1) + " balance!");
				String successLog = "✅ Verification passed for Invoice " + (i + 1) + " || Expected Balance: "
						+ expectedValues[i] + " || Calculated Balance: " + balances[i];
				System.out.println(successLog);
				Extent_pass(driver, successLog, test, test1);
			} catch (AssertionError e) {
				String failureLog = "❌ Verification FAILED for Invoice " + (i + 1) + " || Expected: "
						+ expectedValues[i] + " || Actual: " + balances[i];
				System.out.println(failureLog);
				Extent_fail(driver, failureLog, test, test1);
				throw e; // Re-throw exception to mark test as failed
			}
		}
	}

	public boolean verifyElementHasNoValue(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		boolean temp = false;
		try {
			// Retrieve the value attribute of the element
			WebElement element = driver.findElement(By.xpath(values[1]));
			String value = element.getDomAttribute("value");

			// Check if the value is empty or null
			if (value == null || value.isEmpty()) {
				temp = true;
			} else {
				temp = false;
				verifyServerStatus(driver);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
		return temp;
	}

	public static void verifyBalance(WebDriver driver, List<String> amounts, List<String> expectedBalances,
			List<String> multipliers) {
		// Convert amounts to double and handle commas
		double[] values = amounts.stream().map(s -> s.replace(",", "")) // Remove commas
				.mapToDouble(Double::parseDouble).toArray();

		// Convert expected balances to double
		double[] expectedValues = expectedBalances.stream().map(s -> s.replace(",", "")) // Remove commas
				.mapToDouble(Double::parseDouble).toArray();

		// Convert multipliers to double
		double[] factors = multipliers.stream().map(s -> s.replace(",", "")) // Remove commas
				.mapToDouble(Double::parseDouble).toArray();

		if (values.length != 2 || expectedValues.length != 2 || factors.length != 2) {
			Extent_fail(driver, "Exactly two input values, two expected values, and two multipliers are required.",
					test, test1);
			throw new IllegalArgumentException(
					"Exactly two input values, two expected values, and two multipliers are required.");
		}

		// Multiply values by their respective multipliers
		values[0] *= factors[0];
		values[1] *= factors[1];

		// Calculate total balance
		double totalBalance = values[0] + values[1];

		// Determine smaller absolute value
		double absValue1 = Math.abs(values[0]);
		double absValue2 = Math.abs(values[1]);

		// Assign new balances based on adjusted values
		double[] balances = new double[2];

		if (absValue1 == absValue2) {
			balances[0] = 0;
			balances[1] = 0;
		} else if (absValue1 > absValue2) {
			balances[0] = totalBalance;
			balances[1] = 0;
		} else {
			balances[0] = 0;
			balances[1] = totalBalance;
		}

		// Loop through invoices and verify
		for (int i = 0; i < 2; i++) {
			String iterationLog = "Iteration " + (i + 1) + ":";
			String invoiceAmtLog = "Invoice " + (i + 1) + " AMT: " + values[i];
			String calculatedBalanceLog = "Calculated Balance: " + balances[i];
			String expectedBalanceLog = "Expected Balance: " + expectedValues[i];

			// Logging to console
			System.out.println(iterationLog);
			System.out.println(invoiceAmtLog);
			System.out.println(calculatedBalanceLog);
			System.out.println(expectedBalanceLog);

			// Logging to Extent report
			Extent_pass(driver, iterationLog, test, test1);
			Extent_pass(driver, invoiceAmtLog, test, test1);
			Extent_pass(driver, calculatedBalanceLog, test, test1);
			Extent_pass(driver, expectedBalanceLog, test, test1);

			// Verify correctness
			try {
				Assert.assertEquals(balances[i], expectedValues[i], "Mismatch in Invoice " + (i + 1) + " balance!");
				String successLog = "✅ Verification passed for Invoice " + (i + 1) + " || Expected Balance: "
						+ expectedValues[i] + " || Calculated Balance: " + balances[i];
				System.out.println(successLog);
				Extent_pass(driver, successLog, test, test1);
			} catch (AssertionError e) {
				String failureLog = "❌ Verification FAILED for Invoice " + (i + 1) + " || Expected: "
						+ expectedValues[i] + " || Actual: " + balances[i];
				System.out.println(failureLog);
				Extent_fail(driver, failureLog, test, test1);
				throw e; // Re-throw exception to mark test as failed
			}
		}
	}

	/*
	 * Used to Perform the KeyDown Action on that page
	 */
	public void keyDown(WebDriver driver) {
		// Action class take some time for performing the action, We gave manual wait
		// here
		wait(driver, ScrollWaitTime);
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.ARROW_DOWN);
		actionObject.perform();
	}

	/*
	 * Used to Perform the KeyUp Action on that page
	 */
	public void keyUp(WebDriver driver) {
		// Action class take some time for performing the action, We gave manual wait
		// here
		wait(driver, ScrollWaitTime);
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.ARROW_UP);
		actionObject.perform();
	}

	/*
	 * Used to Perform the PageUp Action on that page
	 */
	public void keyboardPageUp(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();
	}

	/*
	 * Used to Perform the refresh Action on that page
	 */
	public void refreshUsingKeys(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.sendKeys(Keys.F5).perform();
	}

	/*
	 * Used to Perform the PageDown Action on that page
	 */
	public void keyboardPageDown(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
		// Action class take some time for performing the action, We gave manual wait
		// here
		wait(driver, ScrollWaitTime);
	}

	/*
	 * Used to Perform the End Action on that page
	 */
	public void keyboardEnd(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		// Action class take some time for performing the action, We gave manual wait
		// here
		wait(driver, ScrollWaitTime);
	}

	/*
	 * Used to Perform the Home Action on that page
	 */
	public void keyboardHome(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		// Action class take some time for performing the action, We gave manual wait
		// here
		wait(driver, ScrollWaitTime);
	}

	/*
	 * Used to Perform the ArrowUp Action on that page
	 */
	public void keyboardArrowUp(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_UP).perform();
	}

	/*
	 * Used to Perform the ArraowDown Action on that page
	 */
	public void keyboardArrowDown(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
	}

	/*
	 * Used to Perform the ArrowLeft Action on that page
	 */
	public void keyboardArrowLeft(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_LEFT).perform();
	}

	public void keyboardArrowRight(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_RIGHT).perform();
	}

	/*
	 * Used to Perform the Maximize Action on that page
	 */
	public void pageMaximizeUsingKey(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.F11);
		actionObject.perform();
	}

	/*
	 * Used to get scroll the web page
	 */
	// public void scrollTop(WebDriver driver) {
	// try {
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	// } catch (Exception e) {
	// ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
	// e.printStackTrace();
	// Extent_fail(driver, e.getLocalizedMessage(), test, test1);
	// global.add(e.getLocalizedMessage());
	// verifyServerStatus(driver);
	// Assert.fail(e.getLocalizedMessage());
	// }
	// }
	public void scrollTop(WebDriver driver) {
		waitForElement(driver, home_Btn_IN);
		String[] values = splitXpath(home_Btn_IN);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(values[1]));

			for (int i = 0; i < 3; i++) {
				try {
					// Get element Y location
					int elementY = element.getLocation().getY();

					// Add extra space above the element for full visibility
					int scrollTo = elementY - 100; // 100px above the element

					// Prevent negative scroll
					if (scrollTo < 0)
						scrollTo = 0;

					js.executeScript("window.scrollTo(0, arguments[0]);", scrollTo);

					wait(driver, ScrollWaitTime);

					if (element.isDisplayed()) {
						System.out.println(values[0] + " is displayed");
						break;
					}
				} catch (Exception e) {
					if (i == 2)
						throw e;
				}
			}
			mouseOverToElement(driver, home_Btn_IN);
			scrollElementToView(driver, home_Btn_IN);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to scroll to element at top: " + e.getLocalizedMessage(), test, test1);
			global.add("Unable to scroll to element at top");
			verifyServerStatus(driver);
			Assert.fail("Unable to scroll to element at top: " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to Scroll the particular element to View port of the page
	 */
	public void scrollElementToView(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			((JavascriptExecutor) driver).executeScript(
					"const element = arguments[0];"
							+ "element.scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });",
					element);

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to verify the element having the text value
	 */
	public void verifyElementText(WebDriver driver, String xpath, String expectedtext) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			String text = driver.findElement(By.xpath(values[1])).getText();
			if (text.equals(expectedtext)) {
				Extent_pass(driver, "Exepected text is present " + values[0] + " " + text, test, test);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to get the values for extent report
	 */
	public static void ActionTest(ExtentTest extentTest, ExtentTest extentTest1) {
		test = extentTest;
		test1 = extentTest1;
	}

	/*
	 * Used to color code value
	 */
	public static String rgbToHex(String rgb) {
		String[] rgbValues = rgb.replace("rgba(", "").replace(")", "").split(", ");
		int red = Integer.parseInt(rgbValues[0]);
		int green = Integer.parseInt(rgbValues[1]);
		int blue = Integer.parseInt(rgbValues[2]);
		return String.format("#%02X%02X%02X", red, green, blue);
	}

	/*
	 * Used to get the background colour of the text
	 */
	public String getTextBackgroundColor(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement eleSearch = driver.findElement(By.xpath(values[1]));
			String rgbFormat = eleSearch.getCssValue("background-color");
			String hexcolor = rgbToHex(rgbFormat);
			Extent_pass(driver, "Get the Text Background Color of " + values[0], test, test1);
			return hexcolor;
		} catch (Exception e) {
			Extent_fail(driver, "Unable to Get the Text Background Color of " + values[0], test, test1);
			e.printStackTrace();
			global.add("Unable to Get the Text Background Color of " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Unable to Get the Text Background Color of " + values[0]);
			return "";
		}
	}

	/*
	 * Used to get the attribute value of the element for the particular element
	 */
	public String getAttribute(WebDriver driver, String xpath, String attribute) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			WebElement inputBox = driver.findElement(By.xpath(values[1]));
			String textInsideInputBox = inputBox.getDomAttribute(attribute);
			Extent_pass(driver, "Get the Attribute value of " + values[0], test, test1);
			return textInsideInputBox;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to Get the Attribute value of " + values[0], test, test1);
			global.add("Unable to Get the Attribute value of " + values[0]);
			Assert.fail("Unable to Get the Attribute value of " + values[0]);
			return null;

		}
	}

	/*
	 * Used to verify the table the given column headers are present
	 */
	public static void verifyColumnHeadersIsPresent(WebDriver driver, List<Map<String, String>> tableData,
			List<String> expectedColumns) {
		if (tableData.isEmpty()) {
			System.err.println("❌ Table data is empty . No headers to verify .");
			Extent_fail(driver, "❌ Table data is empty . No headers to verify .", test, test1);
			return;
		}
		// Extract actual header names from the first row of the table data
		List<String> actualHeaders = new ArrayList<>(tableData.get(0).keySet());
		List<String> columnsNotPresent = new ArrayList<>();
		// Verify expected columns
		for (String expectedColumn : expectedColumns) {
			if (actualHeaders.contains(expectedColumn)) {
				System.out.println("✅ Column present: " + expectedColumn);
				Extent_pass(driver, "✅ Matched : Expected column '" + expectedColumn + "' is present .", test, test1);
			} else {
				columnsNotPresent.add(expectedColumn);
				System.out.println("❌ Column missing: " + expectedColumn);
				Extent_fail(driver,
						"❌ Not Matched : Expected column '" + expectedColumn + "' is Not present in actual headers .",
						test, test1);
			}
		}
		if (!columnsNotPresent.isEmpty()) {
			System.err.println("❌ Columns not found in table: " + columnsNotPresent);
			Extent_fail(driver, "❌ Columns not found in table: " + columnsNotPresent, test, test1);
		}
	}

	/*
	 * Used to get the web element list
	 */
	public List<WebElement> listOfElements(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		List<WebElement> elements = new ArrayList<WebElement>();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			elements = driver.findElements(By.xpath(values[1]));
		} catch (Exception e) {
			Extent_fail(driver, values[0] + " List of WebElement is not present " + e.getLocalizedMessage(), test,
					test1);
			global.add(values[0] + " List of WebElement is not present " + e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail();
		}
		return elements;
	}

	/*
	 * Used to verify the table the given column headers are not present
	 */
	public static void verifyColumnHeadersNotPresent(WebDriver driver, List<Map<String, String>> tableData,
			List<String> expectedColumns) {
		if (tableData.isEmpty()) {
			System.err.println("Table data is empty. No headers to verify.");
			return;
		}
		// Extract actual header names from the first row of the table data
		List<String> actualHeaders = new ArrayList<>(tableData.get(0).keySet());
		List<String> columns_Present = new ArrayList<String>();
		// Verify expected columns
		for (String expectedColumn : expectedColumns) {
			if (actualHeaders.contains(expectedColumn)) {
				columns_Present.add(expectedColumn);
				System.out.println("Matched || Expected columns Should not present || The Actual value is "
						+ expectedColumn + " Column is Present");
				Extent_fail(driver, "Matched || Expected columns Should not present || The Actual value is "
						+ expectedColumn + " Column is Present", test, test);
				// Optionally, log or throw an exception
			} else if (!actualHeaders.contains(expectedColumn)) {
				System.out.println("Matched || Expected columns Should not present || The Actual value is "
						+ expectedColumn + " Column is Not Present");
				Extent_pass(driver, "Matched || Expected columns Should not present || The Actual value is "
						+ expectedColumn + " Column is Not Present", test, test);
			}
		}
	}

	/*
	 * used to verify the element is not editable
	 */
	public boolean elementNotEditable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath); // Assuming you have a method to split the XPath
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			// Check if the element is enabled
			if (webElement.isEnabled()) {
				// Check the aria-readonly and aria-disabled attributes
				String ariaReadOnly = webElement.getDomAttribute("aria-readonly");
				String ariaDisabled = webElement.getDomAttribute("aria-disabled");

				// The field is considered not editable if it is read-only or disabled
				return "true".equals(ariaReadOnly) || "true".equals(ariaDisabled);
			}
			return false; // Not enabled
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Used to verify the element is accessible or not
	 */
	public boolean isElementAccessible(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebElement Autscroll = driver.findElement(By.xpath(values[1]));
			boolean isAccessible = Autscroll.isEnabled();

			if (isAccessible) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;

		}
	}

	/*
	 * Used to move the mouse hover to the particular element
	 */
	public void mouseOverToElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebElement webElement = driver.findElement(By.xpath(values[1]));
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).build().perform();
		} catch (Exception e) {

		}
	}

	/*
	 * Used to move the mouse hover to the particular element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver, "Element not clickable or not found within the timeout period: " + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - ");
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver, "An unexpected error occurred while waiting for the element:  " + e.getMessage(), test,
					test1);
			global.add("Error occurred while waiting for element - ");
			verifyServerStatus(driver);
			Assert.fail();
		}
		// WebElement webElement = driver.findElement(By.xpath(values[1]));
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {

		}
	}

	/*
	 * Used to verify the element is clickable or not for the particular element
	 */
	public boolean isClickable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Display_WaitTime));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
			return webElement.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Used to calculate the time for the particular element
	 */
	public String calculatedtime(String value1, int value2) {

		// Input date and time string
		String inputDateTimeString = value1;

		// Define the input date time format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		// Parse the input string into LocalDateTime
		LocalDateTime dateTime = LocalDateTime.parse(inputDateTimeString, formatter);

		// Add 1 hour
		LocalDateTime newDateTime = dateTime.plusHours(value2);

		// Format the result back to desired format
		String outputDateTimeString = newDateTime.format(formatter);

		// Print the result
		System.out.println("Original Date Time: " + inputDateTimeString);
		System.out.println("New Date Time (+1 hour): " + outputDateTimeString);

		return outputDateTimeString;

	}

	public String Convertedtime(String value1, int value2, int value3) {

		String inputDateTimeString = value1;

		// Define the input date time format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		// Parse the input string into LocalDateTime
		LocalDateTime dateTime = LocalDateTime.parse(inputDateTimeString, formatter);

		// Add 1 hour
		LocalDateTime newDateTime = dateTime.plusHours(value2).plusMinutes(value3);

		// Format the result back to desired format
		String outputDateTimeString = newDateTime.format(formatter);

		// Print the result
		System.out.println("Original Date Time: " + inputDateTimeString);
		System.out.println("New Date Time (+1 hour): " + outputDateTimeString);

		return outputDateTimeString;
	}

	public double time(double doubleValue, double doubleValue1) {
		return doubleValue / doubleValue1;
	}

	/*
	 * Used to download and save the file
	 */
	public String Downloadedfile(WebDriver driver, String filename) {
		wait(driver, WaitForDisplay_Time);
		String os = System.getProperty("os.name").toLowerCase();
		String downloadPath = "";
		if (os.contains("win")) {
			downloadPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		} else {
			downloadPath = System.getProperty("user.home");
		}
		String downloadDir = downloadPath;
		File dir = new File(downloadDir);
		String Downloadedfile = "";

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles((dir1, name) -> name.contains("" + filename + ".csv"));
			if (files != null && files.length > 0) {
				// Sort files by last modified timestamp in descending order
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
				// Get the first (latest) file
				File latestFile = files[0];
				Downloadedfile = latestFile.getAbsolutePath();
				System.out
						.println("Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath());
				Extent_pass(driver,
						"Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath(), test,
						test1);
			} else {
				System.out.println("Downloaded file was not present in the downloads folder ");
				Extent_fail(driver, "Downloaded file was present Not in the downloads folder ", test, test1);
			}
		} else {
			System.out.println("Directory does not exist or is not a directory.");
			Extent_fail(driver, "Directory does not exist or is not a directory.", test, test1);
		}

		System.out.println("Latestdownloaded_Zipfile :" + Downloadedfile);
		Extent_pass(driver, "Latestdownloaded_Zipfile :" + Downloadedfile, test, test1);
		return Downloadedfile;
	}

	public static String startdate(String dateString) {

		// Format the new date to the same format as the input date
		String startOfYearString = "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			// Parse the input string to a Date object
			Date date = dateFormat.parse(dateString);

			// Get the Calendar instance and set the parsed date
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			// Set the calendar to the first day of the year
			calendar.set(Calendar.MONTH, Calendar.JANUARY);
			calendar.set(Calendar.DAY_OF_MONTH, 1);

			// Get the new date
			Date startOfYear = calendar.getTime();

			startOfYearString = dateFormat.format(startOfYear);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startOfYearString;

	}
	/*
	 * Used to generate random date Future date
	 */

	public void elementnotvisible1(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			if (webElement.isDisplayed()) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(values[1])));
			} else {
			}
		} catch (Exception e) {
		}
	}

	public static List<String> validatePasswordErrors(String password) {

		// List to track expected popups
		List<String> expectedPopups = new ArrayList<>();

		// Identify validation failures
		if (password.length() < 8) {
			expectedPopups.add(InValid_Password_Popup1_UM); // Length error
		}
		if (!password.matches(".*\\d.*")) {
			expectedPopups.add(InValid_Password_Popup2_UM); // Missing number
		}
		if (!password.matches(".*[a-z].*")) {
			expectedPopups.add(InValid_Password_Popup3_UM); // Missing lowercase letter
		}
		if (!password.matches(".*[^a-zA-Z0-9].*")) {
			expectedPopups.add(InValid_Password_Popup4_UM); // Missing special character
		}

		return expectedPopups;
	}

	public List<Map<String, String>> extractCompleteTableData2(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement scrollbar = tableContainer
					.findElement(By.xpath(".//div[@class='ag-body-horizontal-scroll']//div[@ref='eViewport']"));

			// Step 1: Extract Headers Before Scrolling
			Map<Integer, String> columnIndexToHeader = new LinkedHashMap<>();
			extractHeaders(tableContainer, columnIndexToHeader);

			// Step 2: Scroll Right Gradually & Extract Headers
			long lastScroll = -1, currentScroll = 0;
			long maxScroll = ((Number) js.executeScript("return arguments[0].scrollWidth;", scrollbar)).longValue();

			while (lastScroll != currentScroll) {
				Thread.sleep(1000);
				tableContainer = driver.findElement(By.xpath(values[1]));
				lastScroll = currentScroll;
				js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
				Thread.sleep(1000);
				extractHeaders(tableContainer, columnIndexToHeader);
				currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar)).longValue();
				if (currentScroll >= maxScroll)
					break;
			}

			// Critical Fix: Force Last Header Extraction After Full Scroll
			js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollbar);
			Thread.sleep(1000);
			tableContainer = driver.findElement(By.xpath(values[1]));
			extractHeaders(tableContainer, columnIndexToHeader); // Final Extraction

			// Step 3: Scroll Back to Start
			js.executeScript("arguments[0].scrollLeft = 0;", scrollbar);

			// Step 4: Extract Row Data
			List<Map<String, String>> tableData = new ArrayList<>();
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eCenterContainer']//div[@role='row']"));

			for (WebElement row : rows) {
				Map<String, String> rowData = new LinkedHashMap<>();

				// Extract Cells Before Scrolling
				extractCells(row, rowData, columnIndexToHeader);

				// Scroll Right Gradually & Extract Cells
				lastScroll = -1;
				currentScroll = 0;
				while (lastScroll != currentScroll) {
					lastScroll = currentScroll;
					js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
					Thread.sleep(300);
					extractCells(row, rowData, columnIndexToHeader);
					currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar))
							.longValue();
					if (currentScroll >= maxScroll)
						break;
				}

				// Reset Scroll Position
				js.executeScript("arguments[0].scrollLeft = 0;", scrollbar);

				if (!rowData.isEmpty()) {
					tableData.add(rowData);
				}
			}

			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	public static List<String> getTableHeaderCellList(List<Map<String, String>> tableData, String Header) {
		// Iterate through each row in the table data
		List<String> expectedList = new ArrayList<String>();
		for (Map<String, String> row : tableData) {
			// Check if the row contains the given "Container NO"
			if (row.containsKey(Header)) {
				// Return the value under the specified header if present
				String cellValue = row.getOrDefault(Header, "");
				expectedList.add(cellValue);
			}
		}
		return expectedList;
	}

	public static List<Map<String, String>> getAllExcelData(String filePath, String sheetName) {
		List<Map<String, String>> dataList = new ArrayList<>();
		Fillo fillo = new Fillo();
		Connection connection = null;
		Recordset recordset = null;

		try {
			connection = fillo.getConnection(filePath);
			System.out.println("sheetName : " + sheetName);
			String query = "SELECT * FROM " + sheetName;
			recordset = connection.executeQuery(query);

			List<String> columnNames = recordset.getFieldNames();

			while (recordset.next()) {
				Map<String, String> rowData = new HashMap<>();

				for (String column : columnNames) {
					rowData.put(column, recordset.getField(column));
				}

				dataList.add(rowData);
			}
		} catch (FilloException e) {
			// e.printStackTrace();
		} finally {
			if (recordset != null) {
				recordset.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return dataList;
	}

	public static boolean compareListOfMaps(List<Map<String, String>> expected, List<Map<String, String>> actual) {
		if (expected == null || actual == null || expected.size() > actual.size()) {
			return false; // Ensure expected size is not greater than actual
		}

		List<Map<String, String>> unmatchedActual = new ArrayList<>(actual); // Copy to track unmatched elements

		for (Map<String, String> expMap : expected) {
			boolean matchFound = false;

			Iterator<Map<String, String>> iterator = unmatchedActual.iterator();
			while (iterator.hasNext()) {
				Map<String, String> actMap = iterator.next();
				if (CompareMapValues(expMap, actMap)) {
					matchFound = true;
					iterator.remove(); // Remove matched actual map to avoid duplicate matches
					break;
				}
			}

			if (!matchFound) {
				return false; // If any expected map is not found, return false
			}
		}
		return true;
	}

	/*
	 * Used to expand the data set
	 */
	public static String formatValues(String input) {
		// Split the input by commas
		String[] values = input.split(",");

		// StringBuilder to build the output
		StringBuilder formattedOutput = new StringBuilder();

		// Loop through the values array, and add values in pairs (2 values per line)
		for (int i = 0; i < values.length; i += 2) {
			// Add the first value and the second value with a tab separator
			formattedOutput.append(values[i]).append("\t").append(values[i + 1]);

			// If it's not the last pair, add a newline
			if (i + 2 < values.length) {
				formattedOutput.append("\n");
			}
		}

		// Return the formatted string
		return formattedOutput.toString();
	}

	public static String formatEveryValues(String input) {
		// Split the input by commas
		String[] values = input.split(",");

		// StringBuilder to build the output
		StringBuilder formattedOutput = new StringBuilder();

		// Loop through each value and add it to a new line
		for (int i = 0; i < values.length; i++) {
			formattedOutput.append(values[i].trim());

			// Add newline after each value, except the last one
			if (i < values.length - 1) {
				formattedOutput.append("\n");
			}
		}

		// Return the formatted string
		return formattedOutput.toString();
	}

	public void uploadfileNew(WebDriver driver, String Xpath, String path) {
		String[] values = splitXpath(Xpath);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = driver.findElement(By.xpath(values[1]));
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			Extent_pass(driver, "uploaded the file " + path, test, test);
			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			Extent_fail(driver, "upload is falied - " + path + e, test, test);
			e.printStackTrace();
			Assert.fail();
		}
	}

	// Vignesh_New
	public static String generateRandomString(int length) {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
		}
		return sb.toString();
	}
	/*
	 * Used to generate random string
	 */

	public static int generateRandomNumber(int length) {
		int min = (int) Math.pow(10, length - 1); // Smallest number with given length
		int max = (int) Math.pow(10, length) - 1; // Largest number with given length
		return RANDOM.nextInt((max - min) + 1) + min;
	}
	/*
	 * Used to generate random Number
	 */

	public static String getFutureDate(int daysToAdd) {
		LocalDate currentDate = LocalDate.now(); // Get today's date
		LocalDate futureDate = currentDate.plusDays(daysToAdd); // Add specified days
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return futureDate.format(formatter); // Format the date
	}

	public void selectDatePickerWithTime1(WebDriver driver, String Locator, String DateValue) {
		StringBuilder day = new StringBuilder();
		StringBuilder month = new StringBuilder();
		StringBuilder year = new StringBuilder();
		StringBuilder hour = new StringBuilder();
		StringBuilder minute = new StringBuilder();
		waitForElement(driver, Locator);
		click(driver, Locator);
		datePickerWithTime(DateValue, day, month, year, hour, minute);
		waitForElement(driver, Month_DD);
		selectByText(driver, Month_DD, month.toString());
		waitForElement(driver, Year_DD);
		selectByText(driver, Year_DD, year.toString());
		String select_Date = String.format(date_select, day);
		waitForElement(driver, select_Date);
		click(driver, select_Date);
		selectByValue(driver, hour_DD, hour.toString());
		selectByValue(driver, minute_DD, minute.toString());
	}

	public static String Enddate(String dateString) {

		String endOfYearString = "";
		try {
			// Define the date format used in the input
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			// Parse the input string to a Date object
			Date date = dateFormat.parse(dateString);

			// Get the Calendar instance and set the parsed date
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			// Set the calendar to December 31st of the same year
			calendar.set(Calendar.MONTH, Calendar.DECEMBER);
			calendar.set(Calendar.DAY_OF_MONTH, 31);

			// Get the new date (December 31st)
			Date endOfYear = calendar.getTime();

			// Format the new date to the same format as the input date
			endOfYearString = dateFormat.format(endOfYear);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endOfYearString;

	}

	public static void sendKeysUsingActions(WebDriver driver, String Xpath, String text) {
		String[] values = splitXpath(Xpath);

		Actions actions = new Actions(driver);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			element.click(); // Focus on input field

			for (char c : text.toCharArray()) {
				boolean isUpperCase = Character.isUpperCase(c);

				if (isUpperCase) {
					actions.keyDown(Keys.SHIFT).build().perform(); // Hold Shift
				}

				actions.keyDown(String.valueOf(c)).build().perform(); // Press Key
				actions.keyUp(String.valueOf(c)).build().perform(); // Release Key

				if (isUpperCase) {
					actions.keyUp(Keys.SHIFT).build().perform(); // Release Shift
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to Send Keys on " + values[0] + " -> The Typing Value is : " + text, test,
					test1);
		}
	}

	public static boolean CompareMapValues(Map<String, String> exp, Map<String, String> act) {
		// Check if both maps are null or have different sizes
		if (exp == null || act == null || exp.size() != act.size()) {
			return false;
		}

		// Iterate through each entry in the expected map
		for (Map.Entry<String, String> entry : exp.entrySet()) {
			String key = entry.getKey();
			String expectedValue = entry.getValue();

			// Check if the key exists in the actual map
			if (!act.containsKey(key)) {
				return false;
			}

			// Check if values are equal
			String actualValue = act.get(key);
			if (!expectedValue.equals(actualValue)) {
				return false;
			}
		}
		// If all key-value pairs match, return true
		return true;
	}

//	public List<Map<String, String>> extractTableDataByRowIndex(WebDriver driver, String xpath, int row_count) {
//		String[] values = splitXpath(xpath);
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
// 
//			// Locate table container
//			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
// 
//			// Set to track extracted headers (avoids duplicates)
//			Set<String> extractedHeaders = new LinkedHashSet<>();
//			List<String> columnHeaders = new ArrayList<>();
//			List<Map<String, String>> tableData = new ArrayList<>();
// 
//			// Step 1: Extract headers & column values
//			List<WebElement> headerElements = tableContainer
//					.findElements(By.xpath(".//div[@role='rowgroup']//div[contains(@class,'ag-header-row')]//span[@ref='eText']"));
//			// List<WebElement> rows =
//			// tableContainer.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));
// 
//			// Extract column headers
//			for (WebElement headerElement : headerElements) {
//				String headerText = headerElement.getText().trim();
//				if (!headerText.isEmpty() && !extractedHeaders.contains(headerText)) {
//					extractedHeaders.add(headerText);
//					columnHeaders.add(headerText);
//				}
//			}
// 

//	public List<Map<String, String>> extractTableDataByRowIndex(WebDriver driver, String xpath, int row_count) {
//		String[] values = splitXpath(xpath);
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
//
//			// Locate table container
//			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
//
//			// Set to track extracted headers (avoids duplicates)
//			Set<String> extractedHeaders = new LinkedHashSet<>();
//			List<String> columnHeaders = new ArrayList<>();
//			List<Map<String, String>> tableData = new ArrayList<>();
//
//			// Step 1: Extract headers & column values
//			List<WebElement> headerElements = tableContainer.findElements(
//					By.xpath(".//div[@role='rowgroup']//div[contains(@class,'ag-header-row')]//span[@ref='eText']"));
//			// List<WebElement> rows =
//			// tableContainer.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));
//
//			// Extract column headers
//			for (WebElement headerElement : headerElements) {
//				String headerText = headerElement.getText().trim();
//				if (!headerText.isEmpty() && !extractedHeaders.contains(headerText)) {
//					extractedHeaders.add(headerText);
//					columnHeaders.add(headerText);
//				}
//			}
//
//			// Step 2: Extract values row by row
//			for (int rowIndex = 0; rowIndex < row_count; rowIndex++) {
//				WebElement row = tableContainer.findElement(
//						By.xpath(".//div[@ref='eContainer']//div[@role='row' and @row-index='" + rowIndex + "']"));
//				moveToElement(driver, row);
//				List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-value')]"));
//
//				// Create a new map to hold the row data
//				Map<String, String> rowData = new LinkedHashMap<>();
//
//				for (int columnIndex = 0; columnIndex < columnHeaders.size(); columnIndex++) {
//					// Ensure the cell exists for the column
//					if (columnIndex < cells.size()) {
//						String cellValue = cells.get(columnIndex).getText().trim();
//						rowData.put(columnHeaders.get(columnIndex), cellValue);
//					}
//				}
//
//				// Add the row data to the table data list
//				tableData.add(rowData);
//			}
//
//			return tableData;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			Extent_fail(driver,
//					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
//					test1);
//			return Collections.emptyList();
//		}
//	}

	public List<String> getColumnValues(List<Map<String, String>> tableData, String targetColumnHeader) {
		List<String> columnValues = new ArrayList<>();

		for (Map<String, String> row : tableData) {
			String columnValue = row.get(targetColumnHeader); // Get value for the target column
			columnValues.add(columnValue != null ? columnValue : ""); // Avoid null values
		}
		return columnValues; // Return the list of values
	}

	/*
	 * Used to Check Element displayed
	 */

	public boolean IsElementSelected(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			return webElement.isSelected();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static String getCurrentDateNew() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return currentDate.format(formatter);
	}

	public void addToMap(Map<String, List<String>> map, String key, String value) {
		map.putIfAbsent(key, new ArrayList<>()); // Ensure the key exists
		map.get(key).add(value); // Add value to the list
	}

	public List<String> getValuesByFirstAndSecondColumn(List<Map<String, String>> tableData, String firstColumnHeader,
			String firstColumnValue, String secondColumnHeader, String secondColumnValue, String targetColumnHeader) {
		List<String> result = new ArrayList<>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader) && row.containsKey(secondColumnHeader)
					&& row.get(firstColumnHeader).equals(firstColumnValue)
					&& row.get(secondColumnHeader).equals(secondColumnValue)) {

				result.add(row.getOrDefault(targetColumnHeader, "Value not found")); // Collect values
			}
		}

		return result.isEmpty() ? Collections.singletonList("Value not found") : result; // Return collected values
	}

	public static String[] splitAmount(String path, String splitBy) {
		String[] a = path.split(splitBy);
		return a;
	}

	public Map<String, String> getValuesByHeaderMap(List<Map<String, String>> tableData, String firstColumnHeader,
			String SecondColumnHeader) {
		Map<String, String> valuesMap = new HashMap<String, String>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader)) {
				String firstCellvaue = row.get(firstColumnHeader);
				if (row.containsKey(SecondColumnHeader)) {
					String SecondCellvaue = row.get(SecondColumnHeader);
					valuesMap.put(firstCellvaue, SecondCellvaue);
				}
			}
		}
		return valuesMap;
	}

	public static boolean containsAllMaps(Map<String, String> expected, Map<String, String> actual) {
		if (expected == null || actual == null) {
			return false; // If either map is null, return false
		}

		for (Map.Entry<String, String> entry : expected.entrySet()) {
			String expKey = entry.getKey();
			String expValue = entry.getValue();

			// Check if the key exists in actual map
			if (!actual.containsKey(expKey)) {
				return false;
			}

			String actValue = actual.get(expKey);

			// Validate values with numeric handling
			if (!areEqual(expValue, actValue)) {
				return false;
			}
		}
		return true;
	}
	/*
	 * Used to wait untill element not visible
	 */

	public boolean VerifyElementDisplayed(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Display_WaitTime));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
		}
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			if (webElement.isDisplayed()) {
				System.out.println(values[0] + "  Displayed");
				Extent_pass(driver, values[0] + "  Displayed", test, test1);
				return true;
			} else {
				System.out.println(values[0] + "  not Displayed");
				Extent_fail(driver, values[0] + "  not Displayed", test, test1);
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isNewFileDownloaded(Set<String> oldFiles, String baseFilename) {

		Set<String> newFiles = getDirectoryFiles();
		newFiles.removeAll(oldFiles); // Get only new files

		for (String file : newFiles) {
			if (file.contains(baseFilename)) {
				System.out.println("Found new downloaded file: " + file);
				return true;
			}
		}
		System.out.println("No new matching file found for base filename: " + baseFilename);
		return false;
	}

	public String Verify_FileDownloaded1(WebDriver driver, String baseFilename, String Xpath) {
		String value[] = splitXpath(Xpath);
		String downloads = downloadspath();
		String pathOfTheFile = null;
		File dir = new File(downloads);
		Set<String> files = new HashSet<>();
		if (dir.isDirectory()) {
			files.addAll(Arrays.asList(dir.list()));
		}

		try {
			driver.manage().timeouts().implicitlyWait(WaitElementSeconds, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

			// Wait for the element to be present and clickable
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value[1])));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((value[1]))));

			WebElement element = driver.findElement(By.xpath(value[1]));
			element.click();

			Extent_pass(driver, "Click on the element " + baseFilename, test1, test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, "Click on the element " + baseFilename, test1, test);
		}

		wait(driver, ScrollWaitTime);

		Set<String> newFiles = getDirectoryFiles();
		newFiles.removeAll(files); // Get only new files

		boolean flag = false;

		for (String file : newFiles) {
			pathOfTheFile = downloads + "/" + file;
		}
		for (String file : newFiles) {

			if (file.contains(baseFilename)) {
				System.out.println("New file was downloaded in the download firectoy with the name of : " + file);
				Extent_pass(driver, "New file was downloaded in the download firectoy with the name of : " + file,
						test1, test);
				flag = true;
			}
		}

		if (flag == false) {
			System.out.println(
					"New file was not  downloaded in the download firectoy with the name of : " + baseFilename);
			Extent_fail(driver,
					"New file was not downloaded in the download firectoy with the name of : " + baseFilename, test1,
					test);
		}
		return pathOfTheFile;
	}

	public List<List<String>> allColumnData(String filepath) {
		List<List<String>> columnDataList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filepath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0); // Reading the first sheet
			int headerRowIndex = 1;
			Row headerRow = sheet.getRow(headerRowIndex);

			if (headerRow == null) {
				System.out.println("Header row is empty!");
				return columnDataList; // Return empty list instead of null
			}

			int columnCount = headerRow.getLastCellNum();

			// Initialize lists for each column
			for (int col = 0; col < columnCount; col++) {
				columnDataList.add(new ArrayList<>());
			}

			// Read column values (starting from row index 2)
			for (int rowIndex = headerRowIndex + 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row == null)
					continue;

				for (int col = 0; col < columnCount; col++) {
					Cell cell = row.getCell(col);
					String cellValue = (cell != null) ? getCellValueAsString1(cell) : "";
					columnDataList.get(col).add(cellValue);
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
		}

		return columnDataList;
	}

	private String getCellValueAsString1(Cell cell) {
		switch (cell.getCellTypeEnum()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			}
			return String.valueOf(cell.getNumericCellValue());
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

	public static List<String> readColumnDataFromCSV(String filePath, String columnName)
			throws IOException, CsvException {
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> rows = reader.readAll(); // Read entire CSV

			if (rows.size() < 2) {
				throw new IllegalArgumentException("CSV must have at least two rows.");
			}

			// Treat row 2 (index 1) as the header
			String[] headerRow = rows.get(1);
			int columnIndex = Arrays.asList(headerRow).indexOf(columnName);

			if (columnIndex == -1) {
				throw new IllegalArgumentException("Column '" + columnName + "' not found in row 2.");
			}

			// Extract data starting from row 3 (index 2)
			List<String> columnData = new java.util.ArrayList<>();
			for (int i = 2; i < rows.size(); i++) {
				if (rows.get(i).length > columnIndex) {
					columnData.add(rows.get(i)[columnIndex]);
				}
			}

			return columnData;
		}
	}

	public static List<String> readColumnDataFromExcel1(String excelFilePath, String columnName, String sheetName)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		List<String> dataList = new ArrayList<>();

		try (FileInputStream file = new FileInputStream(new File(excelFilePath));
				Workbook workbook = WorkbookFactory.create(file)) { // Auto-detects .xls or .xlsx

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet '" + sheetName + "' not found.");
			}

			// Get the column index based on row 2 (index 1)
			int columnIndex = getColumnIndexByName3(sheet, columnName);
			if (columnIndex == -1) {
				throw new IllegalArgumentException("Column '" + columnName + "' not found in row 2.");
			}

			// Iterate from row 3 (index 2) to get column data
			for (int i = 4; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell cell = row.getCell(columnIndex);
					if (cell != null) {
						dataList.add(getCellValueAsString2(cell)); // Use helper method
					}
				}
			}
		} catch (OLE2NotOfficeXmlFileException e) {
			System.err.println(
					"Error: The file appears to be an OLE2 (Excel 97-2003) format. Ensure it is a valid Excel file.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	public static int getColumnIndexByName3(Sheet sheet, String columnName) {
		Row headerRow = sheet.getRow(3); // Row 2 in Excel -> Index 1 in POI
		if (headerRow == null)
			return -1;

		for (Cell cell : headerRow) {
			if (cell.getCellTypeEnum() == CellType.STRING
					&& cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
				return cell.getColumnIndex();
			}
		}
		return -1; // Return -1 if column not found
	}

	public static String getCellValueAsString2(Cell cell) {
		switch (cell.getCellTypeEnum()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue()); // Convert numeric to string
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

	public static boolean compareMaps(Map<String, String> singleValueMap, Map<String, List<String>> listValueMap) {
		for (Map.Entry<String, String> entry : singleValueMap.entrySet()) {
			String currency = entry.getKey();
			String expectedValueStr = entry.getValue().trim();

			if (!listValueMap.containsKey(currency)) {
				System.err.println("❌ Mismatch: Currency " + currency + " not found in listValueMap.");
				return false;
			}

			// Convert expected value to double
			double expectedValue;
			try {
				expectedValue = Double.parseDouble(expectedValueStr);
			} catch (NumberFormatException e) {
				System.err.println(
						"❌ Error: Invalid number format in singleValueMap for " + currency + ": " + expectedValueStr);
				return false;
			}

			// Sum the values in the List<String>
			double totalValue = 0.0;
			for (String amountStr : listValueMap.get(currency)) {
				try {
					totalValue += Double.parseDouble(amountStr.trim());
				} catch (NumberFormatException e) {
					System.err.println(
							"❌ Error: Invalid number format in listValueMap for " + currency + ": " + amountStr);
					return false;
				}
			}

			// Compare expected value with total summed value
			if (Double.compare(expectedValue, totalValue) != 0) {
				System.err.println(
						"❌ Mismatch: Currency " + currency + " expected " + expectedValue + " but found " + totalValue);
				return false;
			}
		}

		return true;
	}

	public static String sumAndConvertToString(List<String> values) {
		double total = 0.0;

		for (String value : values) {
			try {
				total += Double.parseDouble(value.trim()); // Convert & add
			} catch (NumberFormatException e) {
				System.err.println("❌ Error: Invalid number format - " + value);
			}
		}

		return String.format("%.2f", total); // Ensure 2 decimal places
	}

	public static Map<String, String> sumCurrencyValues(List<String> currencies, List<String> amounts) {
		Map<String, Double> currencySumMap = new HashMap<>();

		for (int i = 0; i < currencies.size(); i++) {
			String currency = currencies.get(i);
			String amountStr = amounts.get(i).trim();

			try {
				double amount = Double.parseDouble(amountStr); // Convert string to double
				currencySumMap.put(currency, currencySumMap.getOrDefault(currency, 0.0) + amount); // Sum values
			} catch (NumberFormatException e) {
				System.err.println("❌ Error: Invalid number format for currency '" + currency + "': " + amountStr);
			}
		}

		// Convert summed values back to Map<String, String>
		Map<String, String> result = new HashMap<>();
		for (Map.Entry<String, Double> entry : currencySumMap.entrySet()) {
			result.put(entry.getKey(), String.format("%.2f", entry.getValue())); // Convert to string with 2 decimal
			// places
		}

		return result;
	}

	public static String unzip(String zipFilePath, String destDir) throws IOException {
		File dir = new File(destDir);
		if (!dir.exists())
			dir.mkdirs(); // Create destination directory if it doesn't exist

		String recentFilePath = null; // Store the most recent unzipped file

		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				File newFile = new File(destDir, entry.getName());

				if (entry.isDirectory()) {
					newFile.mkdirs();
				} else {
					new File(newFile.getParent()).mkdirs();
					try (FileOutputStream fos = new FileOutputStream(newFile)) {
						byte[] buffer = new byte[1024];
						int len;
						while ((len = zis.read(buffer)) > 0) {
							fos.write(buffer, 0, len);
						}
					}
					recentFilePath = newFile.getAbsolutePath(); // Update recent file path
				}
				zis.closeEntry();
			}
		}
		return recentFilePath; // Return the most recent extracted file path
	}

	public List<List<String>> getValuesByHeaders(List<Map<String, String>> tableData, List<String> headers) {
		// Initialize the result list
		List<List<String>> result = new ArrayList<>();

		// Iterate over each row in the table data
		for (Map<String, String> rowData : tableData) {
			// Initialize a list to store the values for the current row
			List<String> rowValues = new ArrayList<>();

			// Iterate over the headers to maintain the order
			for (String header : headers) {
				String value = null;

				// Check if the key exists in a case-insensitive manner
				for (Map.Entry<String, String> entry : rowData.entrySet()) {
					if (entry.getKey().equalsIgnoreCase(header)) {
						value = entry.getValue();
						break;
					}
				}

				// Add the value or null if not found
				rowValues.add(value);
			}

			// Add the row values to the result
			result.add(rowValues);
		}

		// Return the list of values grouped by headers
		return result;
	}

	public static double getNumberValue1(String value) {

		double numberValue = 0;
		try {
			if (value.contains(",")) {
				value = value.replace(",", "");
			}
			numberValue = Double.parseDouble(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return numberValue;

	}

	// 25-03-25 added by vignesh
	public static String unzipwithname(String zipFilePath, String destDir, String name) throws IOException {
		File dir = new File(destDir);
		if (!dir.exists())
			dir.mkdirs(); // Create destination directory if it doesn't exist

		String pdfFilePath = null; // Store the path of the file containing 'PDF' in the name
		name = name.toLowerCase(); // Convert input name to lowercase

		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println("Extracting: " + entry.getName()); // Debugging log

				File newFile = new File(destDir, entry.getName());
				new File(newFile.getParent()).mkdirs(); // Ensure parent directories exist

				if (!entry.isDirectory()) {
					try (FileOutputStream fos = new FileOutputStream(newFile)) {
						byte[] buffer = new byte[1024];
						int len;
						while ((len = zis.read(buffer)) > 0) {
							fos.write(buffer, 0, len);
						}
					}
					// Check if the extracted file name contains the specified name
					// (case-insensitive)
					if (newFile.getName().toLowerCase().contains(name)) {
						pdfFilePath = newFile.getAbsolutePath();
						System.out.println("Matched file: " + pdfFilePath); // Debugging log
					}
				}
				zis.closeEntry();
			}
		}

		if (pdfFilePath == null) {
			System.out.println("No matching file found with name: " + name);
		}

		return pdfFilePath;// Return the most recent extracted file path
	}

	// 25-03-35 modified by vignesh
	public static void compareListHeaders(WebDriver driver, List<List<String>> opl_header,
			List<List<String>> load_header) {
		// Convert both lists into sets to disregard order and duplicate entries
		Set<List<String>> oplSet = new HashSet<>(opl_header);
		Set<List<String>> loadSet = new HashSet<>(load_header);

		// Compare the sets
		if (oplSet.equals(loadSet)) {
			System.out.println("Both lists contain the same elements, regardless of order.");
			// Log the success with WebDriver
			Extent_pass(driver, "Both lists are equal", test, test1);
		} else {
			System.out.println("The lists contain different elements.");
			// Log the failure with WebDriver
			Extent_fail(driver, "Both lists are not equal", test, test1);
		}
	}

	// 25-03-25 modified by vignesh
	public boolean checkpdf(String filepath, String text) {

		String pdfPath = filepath;
		String searchText = text.toLowerCase().replaceAll("\\s+", " "); // Normalize input text

		try {
			File file = new File(pdfPath);
			PDDocument document = PDDocument.load(file);

			// Extract text from PDF
			PDFTextStripper stripper = new PDFTextStripper();
			String pdfText = stripper.getText(document);

			// Close the document
			document.close();

			// Normalize the extracted text: Remove new lines and multiple spaces
			String normalizedPdfText = pdfText.toLowerCase().replaceAll("\\s+", " ");

			// Check if the text exists in the normalized PDF text
			if (normalizedPdfText.contains(searchText)) {
				System.out.println("Text found: " + searchText);
				return true;
			} else {
				System.out.println("Text not found: " + searchText);
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Used to get the text color for the particular element
	 */
	public String getTextColor1(WebDriver driver, WebElement element) {
		try {
			String rgbFormat = element.getCssValue("color");
			String hexcolor = rgbToHex(rgbFormat);
			Extent_pass(driver, "Get the Text Color of " + element.getText(), test, test1);
			return hexcolor;
		} catch (Exception e) {
			System.out.println("Unable to get color of the element..!");
			Extent_fail(driver, "Unable to Get the Text Color of " + element.getText(), test, test1);
			global.add("Unable to Get the Text Color of " + element.getText());
			Assert.fail("Unable to Get the Text Color of " + element.getText());
			return "";
		}

	}

	public boolean IsElementAccessible(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			if (webElement.getDomAttribute("aria-disabled").equalsIgnoreCase("true")) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
	}

	/*
	 * Used to Check the server status
	 */
	public static int responseCode = 0;

	public static boolean isServerUp(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			responseCode = connection.getResponseCode();
			System.out.println("response code: " + responseCode);
			// global.add("response code: "+responseCode;
			if (responseCode == 200) {
				return (responseCode == 200);
			} else {
				serverStatus = false;
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public List<Map<String, String>> extractCompleteTableData(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			// Wait for table visibility
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Locate the horizontal scrollbar
			WebElement scrollbar = tableContainer.findElement(By.xpath(".//div[@ref='eBodyHorizontalScrollViewport']"));

			// Step 1: Extract All Headers with aria-colindex
			Map<Integer, String> columnIndexToHeader = new LinkedHashMap<>();
			long lastScroll = -1, currentScroll = 0;

			// Scroll fully to the right to capture all headers
			while (lastScroll != currentScroll) {
				lastScroll = currentScroll;
				js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
				Thread.sleep(300);
				currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar)).longValue();
			}

			// Extract headers after full scroll
			List<WebElement> headerElements = tableContainer
					.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));
			for (WebElement header : headerElements) {
				String colIndex = header.getDomAttribute("aria-colindex");
				if (colIndex != null) {
					int index = Integer.parseInt(colIndex);
					columnIndexToHeader.put(index, header.getText().trim());
				}
			}
			// Ensure the last column header is added if missing
			int maxIndex = columnIndexToHeader.keySet().stream().max(Integer::compareTo).orElse(0);
			if (!columnIndexToHeader.containsKey(maxIndex)) {
				columnIndexToHeader.put(maxIndex, "Unknown Column " + maxIndex);
				System.out.println("⚠ Manually added missing header for column index: " + maxIndex);
			}

			js.executeScript("arguments[0].scrollLeft = 0;", scrollbar); // Reset scroll

			// Step 2: Extract Row Data
			List<Map<String, String>> tableData = new ArrayList<>();
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eCenterContainer']//div[@role='row']"));

			for (WebElement row : rows) {
				Map<String, String> rowData = new LinkedHashMap<>();
				lastScroll = -1;
				currentScroll = 0;

				// Scroll fully to the right to capture all cell values
				while (lastScroll != currentScroll) {
					lastScroll = currentScroll;
					js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
					Thread.sleep(300);
					currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar))
							.longValue();
				}

				List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-auto')]"));
				for (WebElement cell : cells) {
					String colIndex = cell.getDomAttribute("aria-colindex");
					if (colIndex != null) {
						int index = Integer.parseInt(colIndex);
						String header = columnIndexToHeader.getOrDefault(index, "Unknown Column " + index);
						rowData.put(header, cell.getText().trim());
					}
				}

				js.executeScript("arguments[0].scrollLeft = 0;", scrollbar); // Reset scroll

				if (!rowData.isEmpty()) {
					tableData.add(rowData);
				}
			}

			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	// 24-03-25 Modified by Muthuram
	public List<Map<String, String>> extractCompleteTableData1(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement scrollbar = tableContainer
					.findElement(By.xpath(".//div[@class='ag-body-horizontal-scroll-viewport']"));

			// Step 1: Extract Headers Before Scrolling
			Map<Integer, String> columnIndexToHeader = new LinkedHashMap<>();
			extractHeaders(tableContainer, columnIndexToHeader);

			// Step 2: Scroll Right Gradually & Extract Headers
			long lastScroll = -1, currentScroll = 0;
			long maxScroll = ((Number) js.executeScript("return arguments[0].scrollWidth;", scrollbar)).longValue();

			while (lastScroll != currentScroll) {
				wait(driver, WaitForDisplay_Time);
				tableContainer = driver.findElement(By.xpath(values[1]));
				lastScroll = currentScroll;
				js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
				wait(driver, WaitForDisplay_Time);
				extractHeaders(tableContainer, columnIndexToHeader);
				currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar)).longValue();
				if (currentScroll >= maxScroll)
					break;
			}

			// Critical Fix: Force Last Header Extraction After Full Scroll
			js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollbar);
			wait(driver, WaitForDisplay_Time);
			tableContainer = driver.findElement(By.xpath(values[1]));
			extractHeaders(tableContainer, columnIndexToHeader); // Final Extraction

			// Step 3: Scroll Back to Start
			js.executeScript("arguments[0].scrollLeft = 0;", scrollbar);

			// Step 4: Extract Row Data
			List<Map<String, String>> tableData = new ArrayList<>();
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eCenterContainer']//div[@role='row']"));

			for (WebElement row : rows) {
				Map<String, String> rowData = new LinkedHashMap<>();

				// Extract Cells Before Scrolling
				extractCells(row, rowData, columnIndexToHeader);

				// Scroll Right Gradually & Extract Cells
				lastScroll = -1;
				currentScroll = 0;
				while (lastScroll != currentScroll) {
					lastScroll = currentScroll;
					js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
					Thread.sleep(300);
					extractCells(row, rowData, columnIndexToHeader);
					currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar))
							.longValue();
					if (currentScroll >= maxScroll)
						break;
				}

				// Reset Scroll Position
				js.executeScript("arguments[0].scrollLeft = 0;", scrollbar);

				if (!rowData.isEmpty()) {
					tableData.add(rowData);
				}
			}

			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	private void extractHeaders(WebElement tableContainer, Map<Integer, String> columnIndexToHeader) {
		List<WebElement> headerElements = tableContainer
				.findElements(By.xpath(".//span[@ref='eText' and contains(@class,'cell')]"));
		for (WebElement header : headerElements) {
			String colIndex = header.getDomAttribute("aria-colindex");
			if (colIndex != null) {
				int index = Integer.parseInt(colIndex);
				String headerText = header.getText().trim();

				if (!headerText.isEmpty()) {
					// Fix: Always update the latest non-empty header value
					columnIndexToHeader.put(index, headerText);
				}
			}
		}
	}

	// Extracts all visible cell values
	private void extractCells(WebElement row, Map<String, String> rowData, Map<Integer, String> columnIndexToHeader) {
		List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-auto')]"));
		for (WebElement cell : cells) {
			String colIndex = cell.getDomAttribute("aria-colindex");
			if (colIndex != null) {
				int index = Integer.parseInt(colIndex);
				String header = columnIndexToHeader.getOrDefault(index, "Unknown Column " + index);
				rowData.put(header, cell.getText().trim());
			}
		}
	}

	private static boolean isChromeOrEdge(WebDriver driver) {
		// Simple check for Chrome or Edge by browser name or other means
		return driver instanceof ChromeDriver || driver instanceof EdgeDriver;
	}

	public static boolean checkServerStatusViaDevTools(WebDriver driver) {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Checking server status for: " + currentUrl);
		if (driver instanceof HasDevTools && isChromeOrEdge(driver)) {// Chrome & Edge support DevTools
			// Suppress DevTools logs
			Logger seleniumLogger = Logger.getLogger("org.openqa.selenium.devtools.Connection");
			seleniumLogger.setLevel(Level.WARNING);

			// Start DevTools session
			DevTools devTools = ((HasDevTools) driver).getDevTools();
			devTools.createSession();
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

			final int[] statusCode = { -1 };

			// Listen for network responses
			devTools.addListener(Network.responseReceived(), response -> {
				Response res = response.getResponse();
				if (res.getUrl().equals(currentUrl)) {
					statusCode[0] = res.getStatus();
				}
			});

			// Wait for page load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.navigate().to(currentUrl);
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
					.equals("complete"));
			responseCode = statusCode[0];
			return (statusCode[0] == 200);
		} else {
			// For Firefox, use an HTTP Request to check status
			return checkServerStatusViaHttp(currentUrl);
		}
	}

	// HTTP method for checking server status (Works for all browsers)
	public static boolean checkServerStatusViaHttp(String url) {
		HttpURLConnection connection = null;
		try {
			URL serverUrl = new URL(url);
			connection = (HttpURLConnection) serverUrl.openConnection();
			connection.setRequestMethod("GET"); // Ensure it's GET for compatibility
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			connection.setRequestProperty("Connection", "close"); // Ensure proper closing
			connection.setInstanceFollowRedirects(true); // Follow HTTP → HTTPS redirects
			connection.setConnectTimeout(7000); // Increase timeout
			connection.setReadTimeout(7000);
			int responseCode = connection.getResponseCode();
			System.out.println("Server Response Code: " + responseCode);
			return (responseCode == 200);
		} catch (IOException e) {
			return false;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static boolean getHttpResponseCodeFromBrowser(WebDriver driver, String url) {
		try {
			String script = "" + "return fetch('" + url + "', {" + "    method: 'GET',"
					+ "    credentials: 'same-origin'" + "}).then(response => response.status)"
					+ "  .catch(error => 0);";

			Object status = ((JavascriptExecutor) driver)
					.executeAsyncScript("var callback = arguments[arguments.length - 1];" + script + "then(callback);");

			int statusCode = Integer.parseInt(status.toString());
			System.out.println("🎯 Actual HTTP response code from browser context: " + statusCode);
			if (statusCode == 200) {
				responseCode = statusCode;
				return true;
			} else {
				System.out.println("❌ Server down or blocked. Code: " + statusCode);
				responseCode = statusCode;
				return false;
			}
		} catch (Exception e) {
			return false; // Indicate error
		}
	}

	public static boolean checkServerStatus(WebDriver driver) {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Checking server status for: " + currentUrl);

		disableSslVerification();
		// Always use HTTP method instead of DevTools
		return checkServerStatusViaHttp(currentUrl);
	}

	public static void disableSslVerification() {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			HostnameVerifier allHostsValid = (hostname, session) -> true;
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Used to Verify the server status and it makes the execution to fail when the
	 * server is down
	 */
	public void verifyServerStatus(WebDriver driver) {
		System.out.println("verify server status");
		String url = driver.getCurrentUrl();
		if (checkServerStatus(driver) == true) {
			System.out.println("server is up " + responseCode);
			Extent_cal(test, test1, "Server is up and running (success code : ) " + responseCode + "**" + url + "**");
		} else if (getHttpResponseCodeFromBrowser(driver, url)) {
			System.out.println("server is up " + responseCode);
			Extent_cal(test, test1, "Server is up and running (success code : ) " + responseCode + "**" + url + "**");

		} else {
			System.out.println("server is down");
			refreshPage(driver);
			url = driver.getCurrentUrl();
			System.out.println("Refresh page done");
			Extent_cal(test, test1, "Page was refreshed after getting code" + responseCode);
			if (checkServerStatus(driver) == true) {
				System.out.println("Server is up and running (success code : ) " + responseCode + "**" + url + "**");
				Extent_cal(test, test1,
						"Server is up and running (success code : ) " + responseCode + "**" + url + "**");
			} else if (getHttpResponseCodeFromBrowser(driver, url)) {
				System.out.println("server is up " + responseCode);
				Extent_cal(test, test1,
						"Server is up and running (success code : ) " + responseCode + "**" + url + "**");
			} else {
				System.out.println("server is down");
				ITestResult result1 = convertToITestResult1(1);
				serverStatus = false;
				result1.setStatus(2);
				Extent_fail(driver, "Refresh  Is Done Still Server Is Down [ERROR CODE : " + responseCode + "]", test,
						test1);
			}
		}
	}

	/*
	 * Used to Handle the Check boxes
	 */
	public String checkBox(WebDriver driver, String Xpath, String Status) {
		String[] values = splitXpath(Xpath);
		String isSelected = "";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
			WebElement element = driver.findElement(By.xpath(values[1]));
			String Slab_Status = element.getDomAttribute("class");
			if (Status.equalsIgnoreCase("YES")) {
				if (extractstatus(Slab_Status)) {
					isSelected = "Yes";
					Extent_pass(driver, values[0] + " is Already Selected", test, test1);
				} else {
					isSelected = "No";
					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
					element.click();
					Extent_pass(driver, values[0] + " is Selected", test, test1);
				}
			} else if (Status.equalsIgnoreCase("NO")) {
				if (extractstatus(Slab_Status)) {
					isSelected = "Yes";
					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
					element.click();
					Extent_pass(driver, values[0] + " is Unselected", test, test1);
				} else {
					isSelected = "No";
					Extent_pass(driver, values[0] + " is Already Unselected", test, test1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, values[0] + " is Not Available", test, test1);
			verifyServerStatus(driver);
			global.add(values[0] + " is Not Available");
			Assert.fail();
		}
		return isSelected;
	}

	public String portModule(WebDriver driver, String Port_Location, String Ports_Module, String dropdownCondition,
			String Ports_Search_Type_Select) {
		String port_Agency = "";
		try {
			Extent_cal(test, test1, Ports_Module);
			moduleNavigate(driver, Ports_Module);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition, Ports_Search_Type_Select, Port_Location, "", "", "", "");
			waitForElement(driver, Ports_Agency_text_Field);
			port_Agency = getAttribute(driver, Ports_Agency_text_Field, "value");
		} catch (Exception e) {
			return "";
		}
		return port_Agency;
	}

	public void acceptMCN(WebDriver driver, String Accepted_Popup) {
		waitForElement(driver, Accept_Button_MCN);
		waitForElement(driver, Accept_Button_MCN);
		click(driver, Accept_Button_MCN);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		waitForElement(driver, Remarks_Field);
		sendKeys(driver, Remarks_Field, "Testing");

		waitForElement(driver, Remarks_OK_Button);
		click(driver, Remarks_OK_Button);
		waitForPopup(driver, popup_Message, Accepted_Popup);
		String actual_Popup = getText(driver, popup_Message);
		if (actual_Popup.trim().equals(Accepted_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : " + Accepted_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : " + Accepted_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up Message is : " + Accepted_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : " + Accepted_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
		}

		if (isdisplayed(driver, Mail_Cancel_button)) {
			waitForElement(driver, Mail_Cancel_button);
			click(driver, Mail_Cancel_button);
		}

	}

	public void approveMCN(WebDriver driver, String Want_To_Apporove_Popup, String MCN_Approval_Remarks_Input,
			String Approved_Popup) {
		waitForElement(driver, Manifest_Approval_Button);
		click(driver, Manifest_Approval_Button);
		waitForPopup(driver, popup_Message, Want_To_Apporove_Popup);
		String actual_Popup = getText(driver, popup_Message);
		if (actual_Popup.trim().equals(Want_To_Apporove_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : " + Want_To_Apporove_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : " + Want_To_Apporove_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up Message is : " + Want_To_Apporove_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : " + Want_To_Apporove_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
		}
		click(driver, popup_Message_Yes_Button);
		waitForElement(driver, Remarks_Field);
		sendKeys(driver, Remarks_Field, MCN_Approval_Remarks_Input);
		Step_End(36, "click Yes, system will popup to enter MCN approval remarks", test, test1);
		Step_Start(37, "Enter remarks and click ok", test, test1);
		click(driver, Remarks_OK_Button);
		waitForPopup(driver, popup_Message, Approved_Popup);
		actual_Popup = getText(driver, popup_Message);
		if (actual_Popup.trim().equals(Approved_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : " + Approved_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : " + Approved_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up Message is : " + Approved_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : " + Approved_Popup
					+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
		}

		if (isdisplayed(driver, Mail_Cancel_button)) {
			waitForElement(driver, Mail_Cancel_button);
			click(driver, Mail_Cancel_button);
		}

	}

	public List<Map<String, String>> extractTableDataByColumnWithoutScroll(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate table container
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));

			// Set to track extracted headers (avoids duplicates)
			Set<String> extractedHeaders = new LinkedHashSet<>();
			List<String> columnHeaders = new ArrayList<>();
			List<Map<String, String>> tableData = new ArrayList<>();

			// Step 1: Extract headers & column values
			List<WebElement> headerElements = tableContainer
					.findElements(By.xpath(".//div[contains(@class,'ag-header-row')]//span[@ref='eText']"));
			List<WebElement> rows = tableContainer
					.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));

			for (int i = 0; i < headerElements.size(); i++) {
				WebElement headerElement = headerElements.get(i);

				String headerText = headerElement.getText().trim();
				if (!headerText.isEmpty() && !extractedHeaders.contains(headerText)) {
					extractedHeaders.add(headerText);
					columnHeaders.add(headerText);

					// Step 2: Extract all row values for this column
					for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
						if (tableData.size() <= rowIndex) {
							tableData.add(new LinkedHashMap<>());
						}

						WebElement row = rows.get(rowIndex);
						List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-value')]"));

						if (i < cells.size()) {
							String cellValue = cells.get(i).getText().trim();
							tableData.get(rowIndex).put(headerText, cellValue);
						}
					}
				}
			}

			return tableData;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	private static boolean isNumeric(String str) {
		try {
			new BigDecimal(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/*
	 * Used to get the attribute value of the element for the particular hidden
	 * element
	 */
	public String getAttribute1(WebDriver driver, String xpath, String attribute) {
		String[] values = splitXpath(xpath);

		try {
			WebElement inputBox = driver.findElement(By.xpath(values[1]));
			String textInsideInputBox = inputBox.getDomAttribute(attribute);
			Extent_pass(driver, "Get the Attribute value of " + values[0], test, test1);
			return textInsideInputBox;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to Get the Attribute value of " + values[0], test, test1);
			global.add("Unable to Get the Attribute value of " + values[0]);
			Assert.fail("Unable to Get the Attribute value of " + values[0]);
			return null;

		}
	}

	public void jsClick(WebDriver driver, String path) {
		String[] values = splitXpath(path);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
		} catch (TimeoutException e) {
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", webElement);
			System.out.println(values[0] + " clicked");
			Extent_pass(driver, "Click on " + values[0], test, test1);
		} catch (Exception e) {
			System.out.println(" Exception " + e);
			Extent_fail(driver, "Unable to click on " + values[0] + "  " + e.getLocalizedMessage(), test, test1);
			global.add("Unable to click on - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
	}

	public boolean verifyElementHasValueAttribute(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		boolean temp = false;
		try {
			// Retrieve the value attribute of the element
			String value = driver.findElement(By.xpath(values[1])).getDomAttribute("value");

			// If the value is empty, fail the test and verify the server status
			if (value == null || value.equals("")) {
				temp = false;
				Extent_fail(driver, values[0] + " is Not Available", test, test1);
			} else {
				temp = true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, values[0] + " is Not Available", test, test1);
			verifyServerStatus(driver);
			global.add(values[0] + " is Not Available");
			Assert.fail();
		}
		return temp;
	}

	/*
	 * Used to Close the tab
	 */
	public void closeTab(WebDriver driver) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
		// tabs.remove(tabs.get(0));
		driver.switchTo().defaultContent();
		try {
			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(0));
	}

	/*
	 * Used to Close the tab
	 */
	public void closeTab1(WebDriver driver, int input) {
		driver.findElement(By.xpath("body")).sendKeys(Keys.CONTROL + "w");
		driver.switchTo().defaultContent();
		try {
			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(input));
	}

	/*
	 * Used to switch one tab to another tab
	 */
	public void switchtotab(WebDriver driver, int inputData) {
		Capabilities localCapabilities = ((RemoteWebDriver) driver).getCapabilities();
		String BROWSER_NAME = localCapabilities.getBrowserName().toLowerCase();
		if (BROWSER_NAME.equalsIgnoreCase("firefox")) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
			driver.switchTo().defaultContent();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(inputData));
		}
		if (BROWSER_NAME.equalsIgnoreCase("chrome")) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
			driver.switchTo().defaultContent();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(inputData));
			wait(driver, WaitForDisplay_Time);
		}
	}

	/*
	 * Used to Navigate the URL
	 */

	public void navigateUrl(WebDriver driver, String inputData) {
		try {
			if (inputData == null) {
				Assert.fail(inputData);
			} else {
				driver.navigate().to(inputData);
				verifyServerStatus(driver);
				Extent_pass(driver, "Navigated to " + inputData, test, test1);
			}
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			e.printStackTrace();
			Assert.fail();
		}

	}

	public static List<String> splitAndExpandNew(String input, String expression) {
		List<String> result = new ArrayList<>();
		String[] parts = input.split(Pattern.quote(expression));
		Collections.addAll(result, parts);
		return result;
	}

	public List<WebElement> listOfElements1(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		List<WebElement> elements = new ArrayList<WebElement>();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			elements = driver.findElements(By.xpath(values[1]));
		} catch (Exception e) {
		}
		return elements;
	}

	/*
	 * Used to click for the particular element
	 */
	public void safeclick(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		int retries = 30; // Number of retries
		int attempt = 0; // To track retry attempts

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(values[1]))));

			while (attempt < retries) {
				try {
					WebElement element = driver.findElement(By.xpath(values[1]));
					element.click(); // Attempt to click the element
					// Log success
					Extent_pass(driver, "Element " + values[0] + " is clicked", test, test1);
					// System.out.println("Element " + values[0] + " is clicked");
					break; // Break the loop if click is successful
				} catch (ElementClickInterceptedException e) {
					attempt++;
					// System.out.println("Attempt " + attempt + " failed due to
					// ElementClickInterceptedException. Retrying...");
					if (attempt == retries) {
						throw e; // Rethrow the exception after retries are exhausted
					}
					// Optional: Add a small wait between retries
					wait(driver, WaitForDisplay_Time);
				} catch (StaleElementReferenceException e) {
					attempt++;
					// System.out.println("Attempt " + attempt + " failed due to
					// ElementClickInterceptedException. Retrying...");
					if (attempt == retries) {
						throw e; // Rethrow the exception after retries are exhausted
					}
					// Optional: Add a small wait between retries
					wait(driver, WaitForDisplay_Time);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to click on " + values[0] + " || " + e.getLocalizedMessage(), test, test1);
			System.out.println("Unable to click on " + values[0] + " || " + e.getLocalizedMessage());
			global.add("Unable to click on " + values[0] + " || " + e.getLocalizedMessage());
			Assert.fail("Unable to click on " + values[0] + " || " + e.getLocalizedMessage());
		}
	}

	/*
	 * Used to get the download file path
	 */
	public static String downloadspath() {
		String os = System.getProperty("os.name").toLowerCase();
		String downloadsPath = "";
		if (os.contains("win")) {
			// For Windows, using Shell32Util
			downloadsPath = Shell32Util.getKnownFolderPath(KnownFolders.FOLDERID_Downloads);
		} else if (os.contains("mac")) {
			// For macOS, using user home directory and "Downloads" folder
			downloadsPath = System.getProperty("user.home") + "/Downloads";
		}
		String downloadDir = downloadsPath;

		System.out.println("downloadDir :" + downloadDir);

		return downloadDir;

	}

	/*
	 * Used to get the newly downloded file path
	 */
	public static Set<String> getDirectoryFiles() {
		String downloads = downloadspath();

		File dir = new File(downloads);
		Set<String> files = new HashSet<>();
		if (dir.isDirectory()) {
			files.addAll(Arrays.asList(dir.list()));
		}
		return files;
	}

	public static boolean CompareDateValues1(String dateStr1, String dateStr2) {
		List<DateTimeFormatter> formatters = Arrays.asList(DateTimeFormatter.ofPattern("dd/MM/yyyy"),
				DateTimeFormatter.ofPattern("MM/dd/yyyy"), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
				DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));

		Set<LocalDate> date1ParsedSet = parseToAllPossibleDates(dateStr1, formatters);
		Set<LocalDate> date2ParsedSet = parseToAllPossibleDates(dateStr2, formatters);

		for (LocalDate d1 : date1ParsedSet) {
			if (date2ParsedSet.contains(d1)) {
				return true;
			}
		}

		return false;
	}

	private static Set<LocalDate> parseToAllPossibleDates(String dateStr, List<DateTimeFormatter> formatters) {
		Set<LocalDate> parsedDates = new HashSet<>();
		for (DateTimeFormatter formatter : formatters) {
			try {
				parsedDates.add(LocalDate.parse(dateStr, formatter));
			} catch (DateTimeParseException ignored) {
			}

			try {
				parsedDates.add(LocalDateTime.parse(dateStr, formatter).toLocalDate());
			} catch (DateTimeParseException ignored) {
			}
		}
		return parsedDates;
	}

	public static Set<String> extractVariableNames(String formula) {
		Set<String> variables = new HashSet<>();
		Pattern pattern = Pattern.compile("#(\\w+)#");
		Matcher matcher = pattern.matcher(formula);
		while (matcher.find()) {
			variables.add(matcher.group(1)); // e.g., LOA, DAYS
		}
		return variables;
	}

	public static String replaceVariables(String formula, Map<String, Double> variableValues) {
		for (Map.Entry<String, Double> entry : variableValues.entrySet()) {
			formula = formula.replaceAll("#" + entry.getKey() + "#", entry.getValue().toString());
		}
		return formula;
	}

	public static double evaluateFormula(String formula) {
		License.iConfirmNonCommercialUse("YourName or Organization");
		Expression e = new Expression(formula);
		return e.calculate();
	}

	public static boolean compareMapDoubleValues(Map<String, Double> map1, Map<String, Double> map2) {
		// Check for null or size mismatch
		if (map1 == null || map2 == null || map1.size() != map2.size()) {
			return false;
		}

		// Loop through every entry in map1
		for (Map.Entry<String, Double> entry : map1.entrySet()) {
			String key = entry.getKey();
			Double value1 = entry.getValue();

			// Check if map2 contains the key
			if (!map2.containsKey(key)) {
				return false;
			}

			Double value2 = map2.get(key);

			// Use Double.compare to avoid issues with floating point precision
			if (Double.compare(value1, value2) != 0) {
				return false;
			}
		}

		// All keys and values match
		return true;
	}

	/*
	 * Used to get the downloaded file path
	 */
	public String downloadFile(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		String downloads = downloadspath();
		String pathOfTheFile = null;
		File dir = new File(downloads);
		Set<String> files = new HashSet<>();
		if (dir.isDirectory()) {
			files.addAll(Arrays.asList(dir.list()));
		}

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			WebElement element = driver.findElement(By.xpath(values[1]));

			wait.until(ExpectedConditions.elementToBeClickable(element));
			try {
				click(driver, xpaths);
			} catch (ElementClickInterceptedException e) {
				click(driver, xpaths);
			}

			// Extent_pass(driver, "Click on the element " + name, test);
		} catch (Exception e) {
			// e.printStackTrace();
			// Extent_fail(driver, "Click on the element " + name, LogAs.FAILED, test);
		}

		wait(driver, ScrollWaitTime);

		Set<String> newFiles = getDirectoryFiles();
		newFiles.removeAll(files); // Get only new files

		for (String file : newFiles) {
			pathOfTheFile = downloads + "\\" + file;
		}

		return pathOfTheFile;
	}

	/*
	 * Used to get the row count from excel which is having the values
	 */
	public static int countNonEmptyRows(String excelFilePath)
			throws EncryptedDocumentException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		int nonEmptyRowsCount = 0;
		try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {
			// Create a Workbook instance
			Workbook workbook = WorkbookFactory.create(file);
			// Assuming you want to check the first sheet (index 0)
			Sheet sheet = workbook.getSheetAt(0);
			// Iterate through all the rows
			for (Row row : sheet) {
				boolean rowHasData = false;
				// Iterate through each cell in the row
				for (Cell cell : row) {
					if (cell != null && cell.getCellType() == CellType.STRING.getCode()) {
						rowHasData = true; // If any cell has data, count the row
						break;
					}
				}
				// If row has data, increment the count
				if (rowHasData) {
					nonEmptyRowsCount++;
				}
			}
			// Close the workbook (handled automatically by the try-with-resources)
			workbook.close();
		} catch (IOException e) {
			// e.printStackTrace();
		}
		return nonEmptyRowsCount;
	}

	/*
	 * Used to update the excel sheet
	 */
	public void updateCellsWithLimitedValues(WebDriver driver, String filePath, String sheetName, String[] values) {
		try (FileInputStream fis = new FileInputStream(new File(filePath)); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				System.out.println("Sheet not found!");
				return;
			}

			Row headerRow = null;
			int headerRowIndex = -1;

			// Search for the header row
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null && containsHeader(row, "Actual Container No")) {
					headerRow = row;
					headerRowIndex = i;
					break;
				}
			}

			if (headerRow == null) {
				System.out.println("Header row not found!");
				return;
			}

			int columnIndex = -1;

			// Find the column index for "Actual Container No"
			for (Cell cell : headerRow) {
				if (cell != null && cell.getCellType() == CellType.STRING.getCode()
						&& "Actual Container No".equals(cell.getStringCellValue())) {
					columnIndex = cell.getColumnIndex();
					break;
				}
			}

			if (columnIndex == -1) {
				System.out.println("Column 'Actual Container No' not found!");
				return;
			}

			int valueIndex = 0;

			// Iterate through the rows in the specified column and update empty cells
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell cell = row.getCell(columnIndex);

					// If the cell is null, create it
					if (cell == null) {
						cell = row.createCell(columnIndex);
					}

					// Check if the cell is blank
					if (cell.getCellType() == CellType.BLANK.getCode()) {
						// Update the cell only if there are values left to assign
						if (valueIndex < values.length) {
							cell.setCellValue(values[valueIndex]); // Update the cell with the value
							System.out.println("updated value: " + values[valueIndex]);
							valueIndex++; // Move to the next value
						} else {
							break; // Exit if no more values are left to assign
						}
					}
				}
			}

			// Write the changes to the file
			try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
				workbook.write(fos);
			}

			System.out.println("Empty cells under 'Actual Container No' updated successfully!");

		} catch (IOException e) {
			// e.printStackTrace();
			// Extent_fail(driver, e.getLocalizedMessage(), LogAs.FAILED, test);
		}
	}

	/*
	 * Used to get the background color of the element
	 */
	public String getTextBackgroundColor1(WebDriver driver, WebElement element) {
		// String[] values=splitXpath(Xpath);
		try {
			// WebElement eleSearch = driver.findElement(By.xpath(values[1]));

			String rgbFormat = element.getCssValue("background-color");

			// System.out.println(rgbFormat); //In RGB Format the value will be print =>
			// rgba(254, 189, 105, 1)

			String hexcolor = rgbToHex(rgbFormat);
			// System.out.println(hexcolor);

			return hexcolor;
		} catch (Exception e) {
			verifyServerStatus(driver);
			System.out.println("Unable to get color of the element..!");
			return "";
		}
	}

	/*
	 * Used to get the background color of the element
	 */
	public void write_data(String columnName, String str) throws FileNotFoundException, IOException {

		String filePath = System.getProperty("user.dir") + "\\uploads\\Script_Data's.xlsx";

		// Specify the sheet name
		String sheetName = "Sheet1";

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			// Get the sheet
			Sheet sheet = workbook.getSheet(sheetName);

			// Get the row index (assuming you want to write to the first available row)
			int rowIndex = 1; // Row index

			// Get the row, create if it doesn't exist
			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				row = sheet.createRow(rowIndex);
			}
		}
	}

	// Method to check if a row contains the header you're looking for
	private boolean containsHeader(Row row, String header) {
		for (Cell cell : row) {
			if (cell != null && cell.getCellType() == CellType.STRING.getCode()
					&& header.equals(cell.getStringCellValue())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Used to update the values in excel sheet
	 */
	public void updateActContainer(WebDriver driver, String FilePath, String sheetName, int RowNum, String columnName,
			List<String> abc) {
		int b = 0;

		// System.out.println("sheetName :" + sheetName);
		try (FileInputStream fis = new FileInputStream(new File(FilePath)); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				System.out.println("Sheet not found!");
				return;
			}

			Row headerRow = sheet.getRow(RowNum); // Assuming headers are in the first row
			if (headerRow == null) {
				System.out.println("Header row not found!");
				return;
			}

			int columnIndex = -1;

			// Find the column index based on the column name
			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equals(columnName)) {
					columnIndex = cell.getColumnIndex();
					break;
				}
			}

			if (columnIndex == -1) {
				System.out.println("Column not found!");
				return;
			}

			int lastRowNum = sheet.getLastRowNum();
			System.out.println("lastRowNum : " + lastRowNum);

			for (int i = 14; i < lastRowNum; i++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(columnIndex);
				String cellValueAct = getCellValueAsString(cell);
				if ((cell == null || cellValueAct.isEmpty() || cellValueAct.equals("")) && b < abc.size()) {
					cell.setCellValue(abc.get(b));
					b++;
				}
			}

			// Write the changes to the file
			try (FileOutputStream fos = new FileOutputStream(new File(FilePath))) {
				workbook.write(fos);
			}

			System.out.println("Value updated successfully!");

		} catch (IOException e) {
			// e.printStackTrace();
			// Extent_fail(driver, e.getLocalizedMessage(), LogAs.FAILED, test);
		}

	}

	/*
	 * Used to get cell values from excel
	 */
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

	/*
	 * Used to Perform the backspace Action on that page
	 */
	public void backspace(WebDriver driver) {
		try {
			// Action class take some time for performing the action, We gave manual wait
			// here
			wait(driver, WaitForDisplay_Time);
			Actions actionObject = new Actions(driver);
			actionObject.sendKeys(Keys.BACK_SPACE).build().perform();
		} catch (Exception e) {
			// Assert.fail();
		}
	}

	/*
	 * Used to Perform the controll Action on that page
	 */
	public void selectall(WebDriver driver) {
		try {
			// Action class take some time for performing the action, We gave manual wait
			// here
			wait(driver, WaitForDisplay_Time);
			Actions actionObject = new Actions(driver);
			actionObject.sendKeys(Keys.CONTROL).build().perform();
		} catch (Exception e) {
			// Assert.fail();
		}
	}

	/*
	 * Used to Report purpose
	 */
	public static ITestResult convertToITestResult1(int value) {
		ITestResult result = new CustomTestResult();
		result.setStatus(value);
		return result;
	}

	/*
	 * Used to split and get the date from excel data
	 */
	public static void datePickerWithTime(String date, StringBuilder dayOut, StringBuilder monthOut,
			StringBuilder yearOut, StringBuilder timeOut) {
		if (date.contains("/")) {
			// Split the date string by "/"

			String[] parts = date.split("/");
			String[] Time = parts[2].split(" ");
			// String[] hour = time[1].split(":");

			// Extract day, month, and year from the array
			int day = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int year = Integer.parseInt(Time[0]);
			// int time = Integer.parseInt(Time[1]);

			// Array of month names
			String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
					"Dec" };
			// Get the month name (adjust index for zero-based array)
			String monthName = monthNames[month - 1];
			// Set the output parameters
			dayOut.setLength(0);
			dayOut.append(day);
			monthOut.setLength(0);
			monthOut.append(monthName);
			yearOut.setLength(0);
			yearOut.append(year);
			timeOut.setLength(0);
			timeOut.append(Time[1]);

		} else if (date.contains("-")) {
			// Split the date string by "/"
			String[] parts = date.split("-");
			String[] Time = parts[2].split(" ");

			// Extract day, month, and year from the array
			int day = Integer.parseInt(parts[1]);
			int month = Integer.parseInt(parts[0]);
			int year = Integer.parseInt(Time[0]);

			// Array of month names
			String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
					"Dec" };
			// Get the month name (adjust index for zero-based array)
			String monthName = monthNames[month - 1];
			// Set the output parameters
			dayOut.setLength(0);
			dayOut.append(day);
			monthOut.setLength(0);
			monthOut.append(monthName);
			yearOut.setLength(0);
			yearOut.append(year);
			timeOut.setLength(0);
			timeOut.append(Time[1]);

		}
	}

	public static String generateChecksumForService(String value) {
		LocalDateTime now = LocalDateTime.now();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();

		// Combine values
		int rawSum = (month * 10000) + (day * 100) + hour + minute + second;

		// Get 3-digit checksum
		int checksum = rawSum % 1000;

		// Convert to string with leading zeros (e.g., 004, 078, 999)
		return value + String.format("%03d", checksum);
	}

	/*
	 * Used to split and get the date from excel data
	 */
	public static void datePickerWithTime(String date, StringBuilder dayOut, StringBuilder monthOut,
			StringBuilder yearOut, StringBuilder hourOut, StringBuilder minitOut) {
		if (date.contains("/")) {
			// Split the date string by "/"

			String[] parts = date.split("/");
			String[] Time = parts[2].split(" ");
			String[] hour = Time[1].split(":");

			// Extract day, month, and year from the array
			int day = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int year = Integer.parseInt(Time[0]);
			int Hour = Integer.parseInt(hour[0]);
			int minite = Integer.parseInt(hour[1]);

			// Array of month names
			String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
					"Dec" };
			// Get the month name (adjust index for zero-based array)
			String monthName = monthNames[month - 1];
			// Set the output parameters
			dayOut.setLength(0);
			dayOut.append(day);
			monthOut.setLength(0);
			monthOut.append(monthName);
			yearOut.setLength(0);
			yearOut.append(year);
			hourOut.setLength(0);
			hourOut.append(Hour);
			minitOut.setLength(0);
			minitOut.append(minite);

		} else if (date.contains("-")) {
			// Split the date string by "/"
			String[] parts = date.split("-");
			String[] Time = parts[2].split(" ");
			String[] hour = Time[1].split(":");
			// Extract day, month, and year from the array
			int day = Integer.parseInt(parts[1]);
			int month = Integer.parseInt(parts[0]);
			int year = Integer.parseInt(Time[0]);
			int Hour = Integer.parseInt(hour[0]);
			int minite = Integer.parseInt(hour[1]);

			// Array of month names
			String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
					"Dec" };
			// Get the month name (adjust index for zero-based array)
			String monthName = monthNames[month - 1];
			// Set the output parameters
			dayOut.setLength(0);
			dayOut.append(day);
			monthOut.setLength(0);
			monthOut.append(monthName);
			yearOut.setLength(0);
			yearOut.append(year);
			hourOut.setLength(0);
			hourOut.append(Hour);
			minitOut.setLength(0);
			minitOut.append(minite);
		}
	}

	public List<List<String>> CSVallColumnData(String filepath) {

		List<List<String>> columnDataList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String line;
			int lineIndex = 0;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(","); // Assuming CSV is comma-separated

				// Initialize lists for each column based on the first row (header row)
				if (lineIndex == 1) { // Skip first row (header row)
					for (int i = 0; i < values.length; i++) {
						columnDataList.add(new ArrayList<>());
					}
				} else if (lineIndex > 1) { // Start adding data from second row onwards
					for (int i = 0; i < values.length; i++) {
						String cleanedValue = values[i].trim().replaceAll("^\"|\"$", ""); // Remove surrounding quotes
						columnDataList.get(i).add(cleanedValue);
					}
				}
				lineIndex++;
			}
		} catch (IOException e) {
			System.err.println("Error reading CSV file: " + e.getMessage());
		}

		return columnDataList;
	}

	public List<List<String>> xls_allColumnData(String filepath, String sheetname)
			throws EncryptedDocumentException, InvalidFormatException {
		List<List<String>> columnDataList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filepath); Workbook workbook = WorkbookFactory.create(fis)) {

			Sheet sheet = workbook.getSheet(sheetname); // Reading the first sheet
			int headerRowIndex = 3;
			Row headerRow = sheet.getRow(headerRowIndex);

			if (headerRow == null) {
				System.out.println("Header row is empty!");
				return columnDataList; // Return empty list instead of null
			}

			int columnCount = headerRow.getLastCellNum();

			// Initialize lists for each column
			for (int col = 0; col < columnCount; col++) {
				columnDataList.add(new ArrayList<>());
			}

			// Read column values (starting from row index 2)
			for (int rowIndex = headerRowIndex + 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);

				for (int col = 0; col < columnCount; col++) {
					Cell cell = (row != null) ? row.getCell(col) : null;

					// Ensure even empty cells have ""
					String cellValue = (cell != null && cell.getCellTypeEnum() != CellType.BLANK)
							? getCellValueAsString1(cell)
							: "";

					columnDataList.get(col).add(cellValue);
				}
			}
		} catch (OLE2NotOfficeXmlFileException e) {
			System.err.println("Invalid file format: Please use an Excel file (.xls or .xlsx).");
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
		}

		return columnDataList;
	}

	public void horizontalscrollFull(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Element not clickable or not found within the timeout period: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Element not clickable or not found - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
			Extent_fail(driver,
					"An unexpected error occurred while waiting for the element: " + values[0] + " " + e.getMessage(),
					test, test1);
			global.add("Error occurred while waiting for element - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail();
		}
		try {

			wait(driver, WaitForDisplay_Time);

			WebElement element = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollLeft = 0;", element);

			wait(driver, WaitForDisplay_Time);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
	}

	public String TableDataForReportNew(WebDriver driver, List<List<String>> tableData, String tableName,
			List<String> excelHeaders) {
		// Determine maximum column widths
		int[] columnWidths = new int[excelHeaders.size()];

		// Initialize widths based on header lengths
		for (int i = 0; i < excelHeaders.size(); i++) {
			columnWidths[i] = excelHeaders.get(i).length();
		}

		// Update widths based on data
		for (List<String> row : tableData) {
			for (int i = 0; i < excelHeaders.size(); i++) {
				if (i < row.size()) {
					String value = row.get(i);
					if (value != null) {
						columnWidths[i] = Math.max(columnWidths[i], value.length());
					}
				}
			}
		}

		// StringBuilder for constructing the HTML table
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<h3>").append(tableName).append("</h3>");
		tableBuilder.append("<table style='width:100%; border-collapse: collapse;'>");
		tableBuilder.append("<thead><tr>");

		// Add headers to HTML and print to console
		StringBuilder headerRow = new StringBuilder();
		for (int i = 0; i < excelHeaders.size(); i++) {
			String header = excelHeaders.get(i);
			tableBuilder.append("<th style='border: 1px solid #ddd; padding: 8px;'>").append(header).append("</th>");
			headerRow.append(String.format("%-" + (columnWidths[i] + 2) + "s", header));
		}
		tableBuilder.append("</tr></thead><tbody>");

		int lineLength = Arrays.stream(columnWidths).sum() + 2 * columnWidths.length;
		String separator = repeatChar('-', lineLength);

		System.out.println(separator);
		System.out.println(tableName + " : ");
		System.out.println(separator);
		System.out.println(headerRow.toString());
		System.out.println(separator);

		// Add rows to HTML and print to console
		for (List<String> row : tableData) {
			tableBuilder.append("<tr>");
			StringBuilder rowOutput = new StringBuilder();
			for (int i = 0; i < excelHeaders.size(); i++) {
				String value = (i < row.size() && row.get(i) != null) ? row.get(i) : "N/A";
				tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>").append(value).append("</td>");
				rowOutput.append(String.format("%-" + (columnWidths[i] + 2) + "s", value));
			}
			tableBuilder.append("</tr>");
			System.out.println(rowOutput.toString());
		}

		System.out.println(separator);
		tableBuilder.append("</tbody></table>");
		return tableBuilder.toString();
	}

	public static boolean CompareListNotPresent(List<String> ExpectedList, List<String> ActualLists) {
		try {
			boolean found = true;
			for (String Code_Removed : ExpectedList) {
				// Compare with every element in list2
				for (String Charge_Code : ActualLists) {
					if (Charge_Code.equals(Code_Removed)) {
						found = false;
						break;
					}
				}
				if (found == false) {
					break;
				}
			}
			if (found) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Compare_Table_ListsValue(List<List<String>> table1, List<List<String>> table2) {
		// Ensure both tables have the same number of rows
		if (table1.size() != table2.size()) {
			System.out.println("Mismatch in the number of rows.");
			return false;
		}
		// Iterate through each row and compare the values
		for (int i = 0; i < table1.size(); i++) {
			List<String> row1 = table1.get(i);
			boolean validation = false;
			for (int k = 0; k < table2.size(); k++) {
				List<String> row2 = table2.get(k);
				if (row1.size() != row2.size()) {
					System.out.println("Mismatch in the number of columns at row " + (i + 1));
					return false;
				}
				for (int j = 0; j < row1.size(); j++) {
					String value1 = row1.get(j).replace(",", "").trim(); // Remove commas and trim
					String value2 = row2.get(j).replace(",", "").trim(); // Remove commas and trim
					if (!Objects.equals(value1, value2)) {
						if (k == table2.size() - 1) {
							return false;
						}
					} else {
						if (j == row1.size() - 1) {
							validation = true;
							break;
						}
					}
				}
				if (validation) {
					break;
				}
			}
		}
		// If all rows and columns match
		return true;
	}

// 11/06/2025 Modify by Abinaya	
	public void RemoveBLfromInvoice(WebDriver driver, String BL_Number_input, String Tab_Locator, String Tab_Rows,
			String Tab_Table_Row, String BL_Select) {

		List<String> BL_Numbers = splitAndExpand(BL_Number_input);

		for (String BL_number : BL_Numbers) {
			scrollBottom(driver);
			waitForElement(driver, Tab_Locator);
			click(driver, Tab_Locator);

			List<WebElement> BL_Details_Rows = listOfElements(driver, Tab_Rows);

			// Skip this iteration if only one row is present
			if (BL_Details_Rows.size() <= 1) {
				continue;
			}

			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).build().perform();
			scrollBottom(driver);

			for (int k = 1; k <= BL_Details_Rows.size(); k++) {
				String row_Select = String.format(Tab_Table_Row, k);
				waitForElement(driver, row_Select);
				click(driver, row_Select);
			}

			String BL_select = String.format(BL_Details_BL_Select, BL_number);
			waitForElement(driver, BL_select);
			click(driver, BL_select);

			action.keyUp(Keys.CONTROL).build().perform();

			waitForElement(driver, Remove_BL);
			click(driver, Remove_BL);

			waitForElement(driver, popup_Message);
			click(driver, popup_Message_Yes_Button);
		}
	}

	public static List<String> readPdfData(String filePath) throws IOException {
		File file = new File(filePath);
		PDDocument document = PDDocument.load(file);

		PDFTextStripper pdfStripper = new PDFTextStripper();
		String pdfText = pdfStripper.getText(document);

		document.close(); // Close document to avoid memory leaks

		// Split text into list (line-by-line or space-separated)
		return Arrays.asList(pdfText.split("\n")); // Split by new line
	}

	public void navigateUrl_NewTab(WebDriver driver, String inputData) {
		try {
			if (inputData == null) {
				Assert.fail("Input data is null");
			} else {
				// Open a new tab
				driver.switchTo().newWindow(WindowType.TAB);

				// Switch to the new tab
				String newTab = driver.getWindowHandle();
				driver.switchTo().window(newTab);

				// Navigate to the URL
				driver.navigate().to(inputData);
				// verifyServerStatus(driver);
				Extent_pass(driver, "Navigated to " + inputData, test, test1);
			}
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void Email_login(WebDriver driver, String Website, String EmailURL, String EmailID, String EmailPassword) {

		if (Website.equals("Outlook")) {

			navigateUrl_NewTab(driver, EmailURL);

			waitForElement(driver, Outlook_EmailInput);
			sendKeys(driver, Outlook_EmailInput, EmailID);

			waitForElement(driver, Outlook_ClickNext);
			click(driver, Outlook_ClickNext);

			waitForElement(driver, Outlook_PasswordInput);
			sendKeys(driver, Outlook_PasswordInput, EmailPassword);

			waitForElement(driver, Outlook_ClickNext);
			click(driver, Outlook_ClickNext);

			try {
				if (isdisplayed(driver, Outlook_ClickNext)) {

					click(driver, Outlook_ClickNext);
				}
			} catch (Exception e) {
				System.out.println("Stay signed in prompt not displayed.");
			}

		} else if (Website.equals("Gmail")) {

			navigateUrl_NewTab(driver, EmailURL);

			waitForElement(driver, Gmail_EmailInput);
			sendKeys(driver, Gmail_EmailInput, EmailID);

			waitForElement(driver, Gmail_ClickNext);
			click(driver, Gmail_ClickNext);

			waitForElement(driver, Gmail_PasswordInput);
			sendKeys(driver, Gmail_PasswordInput, EmailPassword);

			waitForElement(driver, Gmail_ClickNext);
			click(driver, Gmail_ClickNext);

		}

	}

	public void switchToNextTab(WebDriver driver) {
		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);

		// Get current window handle
		String currentWindow = driver.getWindowHandle();

		// Find the index of the current tab and switch to the next one
		int currentIndex = windowList.indexOf(currentWindow);
		int nextIndex = (currentIndex + 1) % windowList.size(); // Loop back if last tab

		// Switch to the next tab
		driver.switchTo().window(windowList.get(nextIndex));
	}

	public static boolean isDateBetween(String givenDateStr, String fromDateStr, String toDateStr) {
		// Define date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Parse string dates to LocalDate
		LocalDate givenDate = LocalDate.parse(givenDateStr, formatter);
		LocalDate fromDate = LocalDate.parse(fromDateStr, formatter);
		LocalDate toDate = LocalDate.parse(toDateStr, formatter);

		// Check if the given date is within range
		return (givenDate.isEqual(fromDate) || givenDate.isAfter(fromDate))
				&& (givenDate.isEqual(toDate) || givenDate.isBefore(toDate));
	}

	public static String extractCode(String value) {
		Pattern pattern = Pattern.compile("\\((\\w+)\\)");
		Matcher matcher = pattern.matcher(value);

		if (matcher.find()) {
			return matcher.group(1); // Return extracted code
		}
		return ""; // Return empty string if no match found
	}

	public void NewscrollBottom(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public void Newscrolltop(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");

	}

	public String activityTypeRadioButtons_VIR(WebDriver driver, String activityType, String RadioButtonDescription) {
		String actual_description = "Expected Radio button is not available";
		String actualDescription = "";

		switch (activityType) {
		case "CAR":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "ACR":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "FDR":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "HCN":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "STC":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "STP":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "BNK":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "CHP":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "EMB":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "CMR":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "AGY":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "SOR":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;
		case "SLO":
			actualDescription = String.format(activityType_Radiobutton_VIR, RadioButtonDescription);
			actual_description = getText(driver, actualDescription);
			break;

		}

		return actual_description;
	}

	public void SetCostConfiguration(WebDriver driver, String Attribute, String Value) {
		waitForElement(driver, cost_Attribute_Filter_CSO);
		sendKeys(driver, cost_Attribute_Filter_CSO, Attribute);

		waitForElement(driver, retrieved_Attribute_Value_CSO);
		doubleClick(driver, retrieved_Attribute_Value_CSO);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, value_Textfield_CSO);
		clearAndType(driver, value_Textfield_CSO, Value);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
	}

	public static String getFullMonthName(String shortMonth) {
		if (shortMonth == null || shortMonth.length() < 3) {
			throw new IllegalArgumentException("Invalid month abbreviation: " + shortMonth);
		}

		// Capitalize first letter and make rest lowercase to handle inputs like "apr",
		// "APR", etc.
		String formatted = shortMonth.substring(0, 1).toUpperCase() + shortMonth.substring(1, 3).toLowerCase();

		for (Month month : Month.values()) {
			String shortName = month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
			if (shortName.equalsIgnoreCase(formatted)) {
				return month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			}
		}

		throw new IllegalArgumentException("Unknown month abbreviation: " + shortMonth);
	}

	public void Reversewaiver(WebDriver driver, String BookingSearch_Condition, String Wiver_number_option,
			String waiverValue, String DW_Remarks_Input_value, String status, String AgencyName,
			String Detention_Module) {

		if (status.contains("Pending")) {

			waitForElement(driver, cancel_Common_btn);
			jsClick(driver, cancel_Common_btn);
			waitForElement(driver, SearchButton_Toolbar);
			jsClick(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BookingSearch_Condition, Wiver_number_option, waiverValue, "", "", "", "");

			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
			waitForElement(driver, DW_Cancelled_Btn);
			jsClick(driver, DW_Cancelled_Btn);
			waitForElement(driver, DW_Remarks_Input);
			clearAndType(driver, DW_Remarks_Input, DW_Remarks_Input_value);

			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

		} else if (status.contains("OPEN")) {

			SwitchProfile(driver, AgencyName);

			verifyMainMenu(driver);

			moduleNavigate(driver, Detention_Module);
			waitForElement(driver, cancel_Common_btn);
			jsClick(driver, cancel_Common_btn);
			waitForElement(driver, SearchButton_Toolbar);
			jsClick(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BookingSearch_Condition, Wiver_number_option, waiverValue, "", "", "", "");

			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
			waitForElement(driver, DW_Cancelled_Btn);
			jsClick(driver, DW_Cancelled_Btn);
			waitForElement(driver, DW_Remarks_Input);
			clearAndType(driver, DW_Remarks_Input, DW_Remarks_Input_value);

			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

		} else if (status.contains("Submitted")) {

			SwitchProfile(driver, AgencyName);

			verifyMainMenu(driver);

			moduleNavigate(driver, Detention_Module);
			waitForElement(driver, cancel_Common_btn);
			jsClick(driver, cancel_Common_btn);
			waitForElement(driver, SearchButton_Toolbar);
			jsClick(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BookingSearch_Condition, Wiver_number_option, waiverValue, "", "", "", "");

			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
			waitForElement(driver, DW_Cancelled_Btn);
			jsClick(driver, DW_Cancelled_Btn);
			waitForElement(driver, DW_Remarks_Input);
			clearAndType(driver, DW_Remarks_Input, DW_Remarks_Input_value);

			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

		} else if (status.contains("Approved")) {

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForElement(driver, DW_Remarks_Input);
			clearAndType(driver, DW_Remarks_Input, DW_Remarks_Input_value);

			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

		}

	}

	public void Import_Invoice_Draft_Delete(WebDriver driver, String Import_invoice_delete) {
		if (Import_invoice_delete.equalsIgnoreCase("YES")) {

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
	}

	public void Invoice_Reversal(WebDriver driver, String Module_name, String BL_Condition, String Reversal_Filter_Type,
			String BL_Number_input, String Invoice_Reversal_Remark, String Invoice_Reversal_Success) {
		moduleNavigate(driver, Module_name);

		newButton(driver);

		waitForElement(driver, invoiceNo_SearchButton);
		click(driver, invoiceNo_SearchButton);

		globalValueSearchWindow(driver, BL_Condition, Reversal_Filter_Type, BL_Number_input, "", "", "", "");

		waitForElement(driver, invoiceReversal_Show_Button);
		click(driver, invoiceReversal_Show_Button);

		waitForElement(driver, inv_Reversal_Table_Header);
		List<Map<String, String>> invoice_Details_Table = getTableData(driver, inv_Reversal_Table_Header,
				invoiceReversal_Table_Rows);

		List<String> invoice_Numbers = getValuesByHeader(invoice_Details_Table, "Invoice No");

		System.out.println("INVOICE NUMBERS SHOWN IN THE GRID ARE :" + invoice_Numbers);

		waitForElement(driver, invoiceReversal_Table_Rows);
		formatLocatorClick(driver, Invoice_No_Column_IR, BL_Number_input);
		
		click(driver, invoiceReversal_Remarks_TextArea);
		sendKeys(driver, invoiceReversal_Remarks_TextArea, Invoice_Reversal_Remark);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForDisplay(driver, popup_Message_Yes_Button);

		if (isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		waitForPopup(driver, popup_Message, Invoice_Reversal_Success);
		String ReversalSuccessMessage = getText(driver, popup_Message);
		if (ReversalSuccessMessage.contains(Invoice_Reversal_Success)) {
			System.out.println(
					"Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : " + ReversalSuccessMessage);
			Extent_pass_New(driver,
					"Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : " + ReversalSuccessMessage,
					test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : "
					+ ReversalSuccessMessage);
			Extent_fail(driver,
					"Not Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : " + ReversalSuccessMessage,
					test, test1);
		}
	}

	public void twoColumnSearchWindow1(WebDriver driver, String Column_Header, String Condition_Filter, String value) {
		String columnHeader = String.format(two_Column_Search_Column_Header, Column_Header);
		waitForElement(driver, columnHeader);
		String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
		String filter_Field = String.format(Filter_Input_Field, columnIndex);
		String filter_Btn = String.format(Filter_Button, columnIndex);
		String column_Values = String.format(column_Value, columnIndex);
		boolean flag = true;
		if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
			waitForElement(driver, filter_Field);
			clear(driver, filter_Field);
			sendKeys(driver, filter_Field, value);
			waitForElement(driver, filter_Btn);
			click(driver, filter_Btn);
			waitForElement(driver, Filter_Operator);
			click(driver, Filter_Operator);
			waitForElement(driver, Equals_Option);
			click(driver, Equals_Option);
			waitForElement(driver, columnHeader);
			click(driver, columnHeader);
			waitForElement(driver, column_Values);
			click(driver, column_Values);
		} else {
			waitForElement(driver, filter_Field);
			clear(driver, filter_Field);
			sendKeys(driver, filter_Field, value);
			List<WebElement> cloumns_Values = listOfElements(driver, column_Values);
			for (WebElement cloumns_Value : cloumns_Values) {
				String column_Text = cloumns_Value.getText();
				if (column_Text.contains(value)) {
					cloumns_Value.click();
					flag = false;
					break;
				}
			}
			if (flag) {
				Extent_fail(driver, value + " The value is Not found in the current window", test, test1);
			}
		}
	}

	public String Datetimeformatter(String input) {

		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate date = LocalDate.parse(input, inputFormat);
		String formattedDate = date.format(outputFormat);
		return formattedDate;

	}

	public static List<String> splitAndExpandwithsymbol(String input) {

		List<String> result = new ArrayList<>();

		// Split by both "," and "/"
		String[] parts = input.split("[,/]");

		for (String part : parts) {
			result.add(part.trim());
		}

		return result;
	}

	public static void verifyBalanceImport_Invoice(WebDriver driver, List<String> amounts,
			List<String> expectedBalances) {
		// Convert amounts to double and handle commas
		double[] values = amounts.stream().map(s -> s.replace(",", "")) // Remove commas
				.mapToDouble(Double::parseDouble).toArray();

		// Convert expected balances to double
		double[] expectedValues = expectedBalances.stream().map(s -> s.replace(",", "")) // Remove commas
				.mapToDouble(Double::parseDouble).toArray();

		// Convert multipliers to double
		// double[] factors = multipliers.stream().map(s -> s.replace(",", "")) //
		// Remove commas
		// .mapToDouble(Double::parseDouble).toArray();

		if (values.length != 2 || expectedValues.length != 2) {
			Extent_fail(driver, "Exactly two input values, two expected values, and two multipliers are required.",
					test, test1);
			throw new IllegalArgumentException(
					"Exactly two input values, two expected values, and two multipliers are required.");
		}

		// Multiply values by their respective multipliers
		// values[0] *= factors[0];
		// values[1] *= factors[1];

		// Calculate total balance
		double totalBalance = values[0] + values[1];

		// Determine smaller absolute value
		double absValue1 = Math.abs(values[0]);
		double absValue2 = Math.abs(values[1]);

		// Assign new balances based on adjusted values
		double[] balances = new double[2];

		if (absValue1 == absValue2) {
			balances[0] = 0;
			balances[1] = 0;
		} else if (absValue1 > absValue2) {
			balances[0] = totalBalance;
			balances[1] = 0;
		} else {
			balances[0] = 0;
			balances[1] = totalBalance;
		}

		// Loop through invoices and verify
		for (int i = 0; i < 2; i++) {
			String iterationLog = "Iteration " + (i + 1) + ":";
			String invoiceAmtLog = "Invoice " + (i + 1) + " AMT: " + values[i];
			String calculatedBalanceLog = "Calculated Balance: " + balances[i];
			String expectedBalanceLog = "Expected Balance: " + expectedValues[i];

			// Logging to console
			System.out.println(iterationLog);
			System.out.println(invoiceAmtLog);
			System.out.println(calculatedBalanceLog);
			System.out.println(expectedBalanceLog);

			// Logging to Extent report
			Extent_pass(driver, iterationLog, test, test1);
			Extent_pass(driver, invoiceAmtLog, test, test1);
			Extent_pass(driver, calculatedBalanceLog, test, test1);
			Extent_pass(driver, expectedBalanceLog, test, test1);

			// Verify correctness
			try {
				Assert.assertEquals(balances[i], expectedValues[i], "Mismatch in Invoice " + (i + 1) + " balance!");
				String successLog = "✅ Verification passed for Invoice " + (i + 1) + " || Expected Balance: "
						+ expectedValues[i] + " || Calculated Balance: " + balances[i];
				System.out.println(successLog);
				Extent_pass(driver, successLog, test, test1);
			} catch (AssertionError e) {
				String failureLog = "❌ Verification FAILED for Invoice " + (i + 1) + " || Expected: "
						+ expectedValues[i] + " || Actual: " + balances[i];
				System.out.println(failureLog);
				Extent_fail(driver, failureLog, test, test1);
				throw e; // Re-throw exception to mark test as failed
			}
		}
	}

	// This method used to delete the Import Document
	public void deleteImportDocument(WebDriver driver, String ConfirmationPopup, String DeleteSuccessPopup) {

		scrollTop(driver);
		waitForElement(driver, Delete_button_toolBar);
		jsClick(driver, Delete_button_toolBar);

		waitForPopup(driver, popup_Message, ConfirmationPopup);
		String ConfirmPopupAct = getText(driver, popup_Message);
		if (ConfirmationPopup.equalsIgnoreCase(ConfirmPopupAct)) {
			System.out.println("Delete Confirmation Popup Matched || Expected : " + ConfirmationPopup + " || Actual : "
					+ ConfirmPopupAct);
			Extent_pass(driver, "Delete Confirmation Popup Matched || Expected : " + ConfirmationPopup + " || Actual : "
					+ ConfirmPopupAct, test, test);
		} else {
			System.out.println("Delete Confirmation Popup Not Matched || Expected : " + ConfirmationPopup
					+ " || Actual : " + ConfirmPopupAct);
			Extent_fail(driver, "Delete Confirmation Popup Not Matched || Expected : " + ConfirmationPopup
					+ " || Actual : " + ConfirmPopupAct, test, test);
		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		waitForPopup(driver, popup_Message, DeleteSuccessPopup);
		String Delete_SuccessPopupAct = getText(driver, popup_Message);

		if (DeleteSuccessPopup.equalsIgnoreCase(Delete_SuccessPopupAct)) {
			System.out.println("Delete Success Popup Matched || Expected : " + DeleteSuccessPopup + " || Actual : "
					+ Delete_SuccessPopupAct);
			Extent_pass(driver, "Delete Success Popup Matched || Expected : " + DeleteSuccessPopup + " || Actual : "
					+ Delete_SuccessPopupAct, test, test);
		} else {
			System.out.println("Delete Success Popup Not Matched || Expected : " + DeleteSuccessPopup + " || Actual : "
					+ Delete_SuccessPopupAct);
			Extent_fail(driver, "Delete Success Popup Not Matched || Expected : " + DeleteSuccessPopup + " || Actual : "
					+ Delete_SuccessPopupAct, test, test);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

	}

	public Map<String, Map<String, String>> getRowValuesByHeaders1(List<Map<String, String>> tableData,
			List<String> headers, String rowCount) {
		// Initialize the result list
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		int k = 1;
		int row = Integer.parseInt(rowCount);
		// Iterate over each row in the table data
		for (Map<String, String> rowData : tableData) {
			Map<String, String> headvalues = new HashMap<String, String>();
			// Iterate over the headers to maintain the order
			for (String header : headers) {
				// If the header does not exist, add null
				String value = rowData.get(header);
				// System.out.println("value : "+value);
				headvalues.put(header, value);
			}
			if (row == k) {
				result.put(rowCount, headvalues);
				break;
			}
			k++;
		}
		// System.out.println("headvalues : "+headvalues);
		// Return the list of values grouped by headers
		return result;
	}

	// this methos used to Select the Routing in the Vendor Invoice creation
	public void Select_Routing_VendorInvoice(WebDriver driver, String TwoColumnSearchCondition, String Service_Header,
			String Service, String Vessel_Header, String Vessel, String Voyage_Bound_Header, String Voayage,
			String Port_Header, String PortValue, String Terminal_Header, String Terminal) {

		waitForDisplay(driver, Service_SearchBtn_All_VIR);
		if (IsElementEnabled(driver, Service_SearchBtn_All_VIR)) {
			waitForElement(driver, Service_SearchBtn_All_VIR);
			click(driver, Service_SearchBtn_All_VIR);
			twoColumnSearchWindow(driver, Service_Header, TwoColumnSearchCondition, Service);
		}

		waitForDisplay(driver, Vessel_SearchBtn_All_VIR);
		if (IsElementEnabled(driver, Vessel_SearchBtn_All_VIR)) {
			waitForElement(driver, Vessel_SearchBtn_All_VIR);
			click(driver, Vessel_SearchBtn_All_VIR);
			twoColumnSearchWindow(driver, Vessel_Header, TwoColumnSearchCondition, Vessel);
		}

		waitForDisplay(driver, Voyage_Search_Btn_AII_VIR);
		if (IsElementEnabled(driver, Voyage_Search_Btn_AII_VIR)) {
			waitForElement(driver, Voyage_Search_Btn_AII_VIR);
			click(driver, Voyage_Search_Btn_AII_VIR);
			twoColumnMultipleSearchWindow(driver, Voyage_Bound_Header, TwoColumnSearchCondition, Voayage);
		}

		waitForDisplay(driver, Port_Code_Search_Btn_All_VIR);
		if (IsElementEnabled(driver, Port_Code_Search_Btn_All_VIR)) {
			waitForElement(driver, Port_Code_Search_Btn_All_VIR);
			click(driver, Port_Code_Search_Btn_All_VIR);
			twoColumnSearchWindow(driver, Port_Header, TwoColumnSearchCondition, PortValue);
		}

		waitForDisplay(driver, Terminal_SearchBtn_All_VIR);
		if (IsElementEnabled(driver, Terminal_SearchBtn_All_VIR)) {
			waitForElement(driver, Terminal_SearchBtn_All_VIR);
			click(driver, Terminal_SearchBtn_All_VIR);
			twoColumnSearchWindow(driver, Terminal_Header, TwoColumnSearchCondition, Terminal);
		}
	}

	// this method used to select the Manual Activity in the Vendor Invoice
	// registratio
	public void Select_Manual_Activity_VIR(WebDriver driver, String TwoColumnCondition, String MainActivity_Header,
			String MainActivity, String SubActivityHeader, String SubActivity, String EqpTypeHeader,
			String EquipmentType, String EqpStatus, String PortHeader, String PortCode) {

		if (IsElementEnabled(driver, mainActivity_Searchbutton_VIR)) {
			waitForElement(driver, mainActivity_Searchbutton_VIR);
			click(driver, mainActivity_Searchbutton_VIR);
			twoColumnSearchWindow(driver, MainActivity_Header, TwoColumnCondition, MainActivity);
		}

		if (IsElementEnabled(driver, subActivity_Addbutton_VIR)) {
			waitForElement(driver, subActivity_Addbutton_VIR);
			click(driver, subActivity_Addbutton_VIR);
			twoColumnSearchWindowMultipleValue(driver, SubActivityHeader, TwoColumnCondition, SubActivity);
		}

		if (IsElementEnabled(driver, eqp_Type_SearchButton_VIR)) {
			waitForElement(driver, eqp_Type_SearchButton_VIR);
			click(driver, eqp_Type_SearchButton_VIR);
			twoColumnSearchWindow(driver, EqpTypeHeader, TwoColumnCondition, EquipmentType);
		}

		if (IsElementEnabled(driver, Vendor_eqp_status)) {
			waitForElement(driver, Vendor_eqp_status);
			Newclear(driver, Vendor_eqp_status);
			sendKeys(driver, Vendor_eqp_status, EqpStatus);
		}

		if (IsElementEnabled(driver, port_SearchButton_Manual_VIR)) {
			waitForElement(driver, port_SearchButton_Manual_VIR);
			click(driver, port_SearchButton_Manual_VIR);
			twoColumnSearchWindow(driver, PortHeader, TwoColumnCondition, PortCode);
		}
	}

	// This Method used to Store the packageAmount for the HouseBL
	public Map<String, Map<String, List<String>>> getHousBLPackageList(String House_BL_Number,
			String House_BL_Container_Number, String package_Input) {
		Map<String, Map<String, List<String>>> HBL_PackageList = new HashMap<String, Map<String, List<String>>>();

		try {
			// Storing HouseBl List, Commodity list, and Split Charges List
			List<String> HouseBL_NewNumbers = splitAndExpand(House_BL_Number);
			List<String> HBL_ContainerList = splitAndExpand(House_BL_Container_Number, "/");
			List<String> HBL_package_Lists_TestData = splitAndExpand(package_Input, "/");

			// Storing the package Value for each Commodity for the Respective House BL
			int count = 0;
			for (int h = 0; h < HouseBL_NewNumbers.size(); h++) {
				String HouseBL = HouseBL_NewNumbers.get(h);
				Map<String, List<String>> Commodity_package = new HashMap<String, List<String>>();
				List<String> Commodity_ID = splitAndExpand(HBL_ContainerList.get(h));
				for (int Cont = 0; Cont < Commodity_ID.size(); Cont++) {
					String Commodity = Commodity_ID.get(Cont);
					List<String> ActPackage = splitAndExpand(HBL_package_Lists_TestData.get(count));
					Commodity_package.put(Commodity, ActPackage);
					HBL_PackageList.put(HouseBL, Commodity_package);
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return HBL_PackageList;
	}

	public boolean compareTableData(List<List<String>> table1, List<List<String>> table2) {
		// Ensure both tables have the same number of rows
		if (table1.size() != table2.size()) {
			System.out.println("Mismatch in the number of rows.");
			return false;
		}

		// Iterate through each row and compare the values
		for (int i = 0; i < table1.size(); i++) {
			List<String> row1 = table1.get(i);

			for (int k = 0; k < table2.size(); k++) {
				List<String> row2 = table2.get(k);

				// Compare each value in the row
				String value_1 = row1.get(0).replace(",", "").trim(); // Remove commas and trim
				String value_2 = row2.get(0).replace(",", "").trim(); // Remove commas and trim

				if (!value_1.equals(value_2)) {
					if (k == (table2.size() - 1)) {
						return false;
					}
					continue;
				}

				boolean match = false;
				for (int j = 0; j < row1.size(); j++) {
					String value1 = row1.get(j).replace(",", "").trim(); // Remove commas and trim
					String value2 = row2.get(j).replace(",", "").trim(); // Remove commas and trim
					if (isNumeric(value1) && isNumeric(value2)) {
						double d1 = Double.parseDouble(value1);
						double d2 = Double.parseDouble(value2);

						if (Double.compare(d1, d2) != 0) {
							System.out.println("Mismatch at row " + (i + 1) + ", column " + (j + 1));
							System.out.println("Table1: " + d1 + " | Table2: " + d2);
							return false;
						}
					} else {
						if (!Objects.equals(value1, value2)) {
							System.out.println("Mismatch at row " + (i + 1) + ", column " + (j + 1));
							System.out.println("Table1: " + value1 + " | Table2: " + value2);
							return false;
						}
					}

					if (j == (row1.size() - 1)) {
						match = true;
					}
				}

				if (match) {
					break;
				}
			}
		}
		return true;
	}

	public List<List<String>> getValuesExceptColumnAndHeaders(List<Map<String, String>> tableData,
			String firstColumnHeader, String firstColumnValue, List<String> columnHeaders) {

		List<List<String>> matchingValues = new ArrayList<>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader) && !row.get(firstColumnHeader).equals(firstColumnValue)) {
				List<String> rowValues = new ArrayList<>();
				for (String header : columnHeaders) {
					// Add the value for the current header or null if the header is not present
					rowValues.add(row.getOrDefault(header, null));
				}
				matchingValues.add(rowValues);
			}
		}

		return matchingValues; // Return the list of lists
	}

	/*
	 * Used to wait for the Visibility of the Element in the page
	 */
	public void waitForElementLoading(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		String[] process = splitXpath(Loading_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			Extent_pass(driver, "Waiting for the " + values[0], test, test1);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + values[0] + " -> " + e.getLocalizedMessage(), test, test1);
			global.add("Element is not present - " + values[0]);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + values[0] + e.getLocalizedMessage());
		}
	}

	private static boolean areEqual(String str1, String str2) {
		if (isNumeric(str1) && isNumeric(str2)) {
			return new BigDecimal(str1).compareTo(new BigDecimal(str2)) == 0;
		}
		return str1.equals(str2);
	}

	public static String beforeDaysToDate(String inputDate, String daysToAdd) {
		int subtractDays = Integer.parseInt(daysToAdd);

		DateTimeFormatter formatter;
		LocalDate date;

		if (inputDate.contains("/")) {
			// dd/MM/yyyy
			formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			date = LocalDate.parse(inputDate, formatter);
		} else if (inputDate.contains("-")) {
			// MM-dd-yyyy
			formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			date = LocalDate.parse(inputDate, formatter);
		} else {
			throw new IllegalArgumentException("Unsupported date format. Use dd/MM/yyyy or MM-dd-yyyy");
		}

		LocalDate resultDate = date.minusDays(subtractDays);
		return resultDate.format(formatter); // Return in same format as input
	}

	public static List<Map<String, String>> getAllExcelData1(String filePath, String sheetName) {
		List<Map<String, String>> dataList = new ArrayList<>();
		Fillo fillo = new Fillo();
		String filepath = ".\\uploads\\" + filePath;
		Connection connection = null;
		Recordset recordset = null;

		try {
			connection = fillo.getConnection(filepath);

			// Debug print: show all available sheets
			List<String> sheetNames = connection.getMetaData().getTableNames();
			System.out.println("Available sheets in the file:");
			for (String name : sheetNames) {
				System.out.println("- " + name);
			}

			System.out.println("Requested sheet name: " + sheetName);
			System.out.println("File path: " + filepath);

			// Match actual sheet name (case-sensitive from Fillo's view)
			String actualSheetName = null;
			for (String name : sheetNames) {
				if (name.equalsIgnoreCase(sheetName)) {
					actualSheetName = name; // this must be used in query
					break;
				}
			}

			if (actualSheetName == null) {
				throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
			}

			// ✅ Use only actualSheetName from metadata (correct casing)
			String query = "SELECT * FROM " + actualSheetName;
			System.out.println("Executing query: " + query);

			recordset = connection.executeQuery(query);

			List<String> columnNames = recordset.getFieldNames();

			while (recordset.next()) {
				Map<String, String> rowData = new HashMap<>();
				for (String column : columnNames) {
					rowData.put(column, recordset.getField(column));
				}
				dataList.add(rowData);
			}

			// Optional: print if no data found
			if (dataList.isEmpty()) {
				System.out.println("No rows found in sheet: " + actualSheetName);
			}

		} catch (Exception e) {
			System.err.println("Error while reading Excel sheet:");
			e.printStackTrace();
		} finally {
			try {
				if (recordset != null)
					recordset.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return dataList;
	}

	// ascending and descending sorting
	public static boolean isSortedAscending(List<String> list) {
		List<String> sorted = new ArrayList<>(list);
		Collections.sort(sorted);
		return list.equals(sorted);
	}

	public static boolean isSortedDescending(List<String> list) {
		List<String> sorted = new ArrayList<>(list);
		sorted.sort(Collections.reverseOrder());
		return list.equals(sorted);
	}

	public static List<String> getExcelHeaders(String filePath, String sheetName) {
		List<String> headers = new ArrayList<>();
		Fillo fillo = new Fillo();
		Connection connection = null;
		Recordset recordset = null;

		try {
			connection = fillo.getConnection(filePath);

			String query = "SELECT * FROM `" + sheetName + "`";
			recordset = connection.executeQuery(query);

			headers = recordset.getFieldNames();

		} catch (FilloException e) {
			System.out.println("Error reading from sheet: " + sheetName);
			e.printStackTrace();
		} finally {
			try {
				if (recordset != null)
					recordset.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return headers;

	}

	public static int getColumnCount(String excelFilePath)
			throws EncryptedDocumentException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		int columnCount = 0;
		try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = sheet.getRow(0); // Usually the header is in the first row
			if (headerRow != null) {
				columnCount = headerRow.getLastCellNum(); // Total number of columns (including empty)
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return columnCount;
	}

	public String formatLocatorjsClick(WebDriver driver, String Locator, String value) {
		String element = "";
		try {
			element = String.format(Locator, value);
			waitForDisplay(driver, element);
			jsClick(driver, element);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
		}
		return element;
	}

	public void AGGridBlankSearchFilter(WebDriver driver, String Column_Header) {
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);
		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		List<String> headers = splitAndExpand(Column_Header, ",");
		for (int i = 0; i < headers.size(); i++) {
			String givenHeader = headers.get(i);
			String columnHeader = String.format(AG_Grid_Headers, givenHeader, givenHeader);
			waitForElement(driver, columnHeader);
			String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
			String filterButton = String.format(AG_Grid_Filter_Button, columnIndex, columnIndex);
			waitForElement(driver, filterButton);
			click(driver, filterButton);
			waitForElement(driver, Filter_Operator);
			click(driver, Filter_Operator);
			waitForElement(driver, AG_Grid_Blank_Filter_Option);
			click(driver, AG_Grid_Blank_Filter_Option);
		}
	}

	public void AGGridValueFilterMultipleValue(WebDriver driver, String Column_Header, String Condition_Filter,
			String value) {
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);
		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		String columnHeader = String.format(AG_Grid_Headers, Column_Header, Column_Header);
		waitForElement(driver, columnHeader);
		String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
		String filterField = String.format(AG_Grid_Filter_Field, columnIndex, columnIndex);
		String filterButton = String.format(AG_Grid_Filter_Button, columnIndex, columnIndex);
		List<String> inputValues = splitAndExpand(value, ",");
		for (int i = 0; i < inputValues.size(); i++) {
			String inputValue = inputValues.get(i);
			waitForElement(driver, filterField);
			clear(driver, filterField);
			waitForElement(driver, filterField);
			sendKeys(driver, filterField, inputValue);
			if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {
				waitForElement(driver, filterButton);
				click(driver, filterButton);
				waitForElement(driver, Filter_Operator);
				click(driver, Filter_Operator);
				waitForElement(driver, Equals_Option);
				click(driver, Equals_Option);
				waitForElement(driver, columnHeader);
				click(driver, columnHeader);
			}
			waitForDisplay(driver, AG_Grid_Row_CheckBox);
			if (isdisplayed(driver, AG_Grid_Row_CheckBox)) {
				click(driver, AG_Grid_Row_CheckBox);
			}
		}
	}

	public void reArrangeAG_GridColumnsWithoutCheckbox(WebDriver driver, String Select_Columns) {
		waitForElement(driver, AG_Grid_Columns_Button_DW);
		jsClick(driver, AG_Grid_Columns_Button_DW);
		waitForElement(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		safeclick(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		waitForElement(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		String actualStatus = getAttribute(driver, AG_Grid_Column_All_Select_Checkbox_DW, "class");
		if (actualStatus.contains("checked")) {
			safeclick(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		}
		List<String> columns = splitAndExpand(Select_Columns);
		for (String column : columns) {
			waitForElement(driver, AG_Grid_Column_Searchbox_DW);
			clear(driver, AG_Grid_Column_Searchbox_DW);
			waitForElement(driver, AG_Grid_Column_Searchbox_DW);
			sendKeys(driver, AG_Grid_Column_Searchbox_DW, column);
			enter(driver);
		}
		waitForElement(driver, AG_Grid_Columns_Button_DW);
		jsClick(driver, AG_Grid_Columns_Button_DW);
	}

	// 10-06

	public boolean IsEmpty(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Display_WaitTime));

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			return true; // Element not present or visible
		}

		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			String text = webElement.getText().trim();
			String value = webElement.getAttribute("value");

			// Return true if both text and value are empty or null
			if (text.isEmpty() && (value == null || value.trim().isEmpty())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return true; // Error accessing the element
		}
	}

	public List<Map<String, String>> extractTableDataByRowIndexMissMatchColumn(WebDriver driver, String xpath,
			int row_count) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate table container
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));

			// Set to track extracted headers (avoids duplicates)
			Set<String> extractedHeaders = new LinkedHashSet<>();
			List<String> columnHeaders = new ArrayList<>();
			List<Map<String, String>> tableData = new ArrayList<>();

			// Step 1: Extract headers & column values
			List<WebElement> headerElements = tableContainer
					.findElements(By.xpath(".//div[contains(@class,'ag-header-row')]//span[@ref='eText']"));
			// List<WebElement> rows =
			// tableContainer.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));
			// Extract column headers
			for (WebElement headerElement : headerElements) {
				String headerText = headerElement.getText().trim();
				if (!headerText.isEmpty() && !extractedHeaders.contains(headerText)) {
					extractedHeaders.add(headerText);
					columnHeaders.add(headerText);
				}
			}
			// Step 2: Extract values row by row
			for (int rowIndex = 0; rowIndex < row_count; rowIndex++) {
				WebElement row = tableContainer.findElement(
						By.xpath(".//div[@ref='eContainer']//div[@role='row' and @row-index='" + rowIndex + "']"));
				moveToElement(driver, row);
				List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-value')]"));

				// Create a new map to hold the row data
				Map<String, String> rowData = new LinkedHashMap<>();
				for (int columnIndex = 0; columnIndex < columnHeaders.size(); columnIndex++) {
					// Ensure the cell exists for the column
					if (columnIndex < cells.size() - 1) {
						String cellValue = cells.get(columnIndex).getText().trim();
						rowData.put(columnHeaders.get(columnIndex + 1), cellValue);
					}
				}
				// Add the row data to the table data list
				tableData.add(rowData);
			}

			return tableData;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test1);
			return Collections.emptyList();
		}
	}

	public String FindGridrowcount(WebDriver driver, String excelpath, String sheetName, String headerName) {

		int dataRows = 0;
		int headerRowIndex = -1;

		try (FileInputStream file = new FileInputStream(new File(excelpath));
				Workbook workbook = WorkbookFactory.create(file)) {

			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				System.out.println("Sheet with name '" + sheetName + "' not found.");
			} else {
				int totalRows = sheet.getLastRowNum();

				// Step 1: Find the header row
				for (int i = 0; i <= totalRows; i++) {
					Row row = sheet.getRow(i);
					if (row == null)
						continue;

					for (Cell cell : row) {
						if (cell.getCellTypeEnum() == CellType.STRING
								&& cell.getStringCellValue().trim().equalsIgnoreCase(headerName)) {
							headerRowIndex = i;
							break;
						}
					}
					if (headerRowIndex != -1)
						break; // Stop if header is found
				}

				if (headerRowIndex == -1) {
					System.out.println("Header '" + headerName + "' not found.");
				} else {
					// Step 2: Count rows after header
					for (int i = headerRowIndex + 1; i <= totalRows; i++) {
						Row row = sheet.getRow(i);
						if (row == null)
							continue;

						Cell firstCell = row.getCell(0);
						if (firstCell == null || firstCell.toString().trim().isEmpty()) {
							continue;
						}

						String cellValue = firstCell.toString().trim().toLowerCase();
						if (cellValue.contains("summary") || cellValue.contains("total")) {
							continue;
						}

						dataRows++;
					}

					System.out.println("Grid data row count (after header '" + headerName + "'): " + dataRows);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(dataRows); // Convert int to String as return type is String
	}

	public static List<String> readExcelFromDefineRow(String excelFilePath, String columnName, String sheetName,
			String row) {
		int num = Integer.parseInt(row);
		int indexnum = num - 1;
		List<String> data = new ArrayList<String>();
		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new HSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);

			// Header is in row 12 (13th row, 0-based index)
			Row headerRow = sheet.getRow(indexnum);

			// Map to store header name -> column index
			Map<String, Integer> headerMap = new HashMap<>();
			for (Cell cell : headerRow) {
				headerMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
			}

			// Example: get data from rows below header
			for (int i = num; i <= sheet.getLastRowNum(); i++) {
				Row row1 = sheet.getRow(i);
				if (row1 == null)
					continue; // Skip empty rows

				// Example: get value under column "Item Name"
				String headerName = columnName; // change this to the actual header you need
				int colIndex = headerMap.get(headerName);

				Cell cell = row1.getCell(colIndex);
				System.out.println(cell);
				String value = Utils.getCellValueAsString(cell);
				if (value != null && !value.trim().equals("")) {
					data.add(value);
				}
			}

			workbook.close();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static Map<String, List<String>> convertRowAmountValues(Map<String, Map<String, String>> rowAmountValues) {
		Map<String, List<String>> result = new HashMap<>();

		for (Map<String, String> innerMap : rowAmountValues.values()) {
			for (Map.Entry<String, String> entry : innerMap.entrySet()) {
				String outerKey = entry.getKey(); // e.g., "BLF"
				String value = entry.getValue(); // e.g., "0.00"

				result.computeIfAbsent(outerKey, k -> new ArrayList<>()).add(value);
			}
		}

		return result;
	}

	public boolean checkspecial(WebDriver driver, String values) {

		boolean flag = true;

		// Regex: Matches any character that is NOT a letter or digit
		if (values.matches(".*[^a-zA-Z0-9 ].*")) {
			System.out.println("String contains special characters.");
			flag = true;
		} else {
			System.out.println("String does not contain special characters.");
			flag = false;
		}

		return flag;
	}

	public void removeColumns(String filePath, String sheetName, String columnsToRemove) {

		List<String> columnsremove = splitAndExpand(columnsToRemove);

		try {
			if (filePath.endsWith(".csv")) {
				removeColumnsFromCSV(filePath, columnsremove);
			} else if (filePath.endsWith(".xlsx") || filePath.endsWith(".xls")) {
				removeColumnsFromExcel(filePath, sheetName, columnsremove);
			} else {
				System.out.println("Unsupported file type.");
				Extent_fail(driver, "Unsupported file type.", test, test);
			}
		} catch (IOException e) {
			System.out.println("Error processing file: " + e.getMessage());
		}
	}

	private static void removeColumnsFromCSV(String filePath, List<String> columnsToRemove) throws IOException {
		File inputFile = new File(filePath);
		File tempFile = new File(filePath + ".tmp");

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

			String headerLine = reader.readLine();
			if (headerLine == null)
				return;

			String[] headers = headerLine.split(",");
			List<Integer> removeIndexes = new ArrayList<>();

			for (int i = 0; i < headers.length; i++) {
				if (columnsToRemove.contains(headers[i].trim())) {
					removeIndexes.add(i);
				}
			}

			// Write filtered header
			writer.write(filterColumns(headers, removeIndexes));
			writer.newLine();

			// Write data rows
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				writer.write(filterColumns(values, removeIndexes));
				writer.newLine();
			}
		}

		// Replace original file with modified one
		if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
			throw new IOException("Failed to replace original CSV file.");
		}
	}

	private static String filterColumns(String[] data, List<Integer> removeIndexes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			if (!removeIndexes.contains(i)) {
				sb.append(data[i]);
				if (i < data.length - 1)
					sb.append(",");
			}
		}
		return sb.toString().replaceAll(",$", ""); // Remove trailing comma
	}

	private static void removeColumnsFromExcel(String filePath, String sheetName, List<String> columnsToRemove)
			throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = filePath.endsWith(".xlsx") ? new XSSFWorkbook(fis) : new HSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null)
			throw new IOException("Sheet not found: " + sheetName);

		// Get header row
		Row headerRow = sheet.getRow(0);
		if (headerRow == null)
			return;

		List<Integer> removeIndexes = new ArrayList<>();
		for (Cell cell : headerRow) {
			if (columnsToRemove.contains(cell.getStringCellValue().trim())) {
				removeIndexes.add(cell.getColumnIndex());
			}
		}

		// Remove cells from all rows
		for (Row row : sheet) {
			List<Cell> cellsToRemove = new ArrayList<>();
			for (int index : removeIndexes) {
				Cell cell = row.getCell(index);
				if (cell != null)
					cellsToRemove.add(cell);
			}
			for (Cell cell : cellsToRemove) {
				row.removeCell(cell);
			}
		}

		// Write back to file
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	private boolean hasAtLeastNNonEmptyRows(Sheet sheet, int n) {
		int count = 0;
		for (Row row : sheet) {
			boolean hasData = false;
			for (Cell cell : row) {
				if (cell != null && cell.getCellTypeEnum() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
					hasData = true;
					break;
				}
			}
			if (hasData) {
				count++;
				if (count >= n)
					return true;
			}
		}
		return false;
	}

	public String Findrowcount(WebDriver driver, String excelpath, String sheetName) {

		int dataRows = 0; // Declare variable outside try block

		try {
			FileInputStream file = new FileInputStream(new File(excelpath));
			Workbook workbook = WorkbookFactory.create(file); // Auto-detect .xls or .xlsx
			Sheet sheet = workbook.getSheet(sheetName); // Get sheet by name

			if (sheet == null) {
				System.out.println("Sheet with name '" + sheetName + "' not found.");
			} else {
				int totalRows = sheet.getPhysicalNumberOfRows(); // Counts non-empty rows
				dataRows = (totalRows > 1) ? totalRows - 1 : 0; // Exclude header row
				System.out.println("Total rows (excluding header): " + dataRows);
			}

			workbook.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(dataRows); // Convert int to String as return type is String
	}

	public String formatLocatorGetText(WebDriver driver, String locator, String value) {
		String elementXpath = "";
		String text = "";

		try {
			elementXpath = String.format(locator, value); // Format the locator with the provided value
			String[] xpath = splitXpath(elementXpath);
			WebElement element = driver.findElement(By.xpath(xpath[1])); // Find the element
			text = element.getText(); // Get the text
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to get text from element: " + e.getLocalizedMessage(), test, test1);
		}
		return text; // Return the text instead of clicking
	}

	public void twoColumnSearchWindowMultipleValue_multipleheader(WebDriver driver, String Column_Header,
			String Condition_Filter, String value, String Column_Header2, String value2) {

		String columnHeader1 = String.format(two_Column_Search_Column_Header, Column_Header);
		String columnHeader2 = String.format(two_Column_Search_Column_Header, Column_Header2);

		waitForElement(driver, columnHeader1);
		waitForElement(driver, columnHeader2);

		String columnIndex1 = getAttribute(driver, columnHeader1, "aria-colindex");
		String columnIndex2 = getAttribute(driver, columnHeader2, "aria-colindex");

		String filterField1 = String.format(Filter_Input_Field, columnIndex1);
		String filterField2 = String.format(Filter_Input_Field, columnIndex2);

		String filterBtn1 = String.format(Filter_Button, columnIndex1);
		String filterBtn2 = String.format(Filter_Button, columnIndex2);

		String columnValuesLocator1 = String.format(column_Value, columnIndex1);
		String columnValuesLocator2 = String.format(column_Value, columnIndex2);

		List<String> columnValues1 = splitAndExpand(value);
		List<String> columnValues2 = splitAndExpand(value2, "/");

		if (columnValues1.size() != columnValues2.size()) {
			throw new IllegalArgumentException("Mismatch between number of values for both columns");
		}

		for (int i = 0; i < columnValues1.size(); i++) {
			String val1 = columnValues1.get(i);
			String val2 = columnValues2.get(i);

			if (Condition_Filter.equalsIgnoreCase("Equals") || Condition_Filter.equalsIgnoreCase("Equal To")) {

				waitForElement(driver, filterField1);
				clear(driver, filterField1);
				sendKeys(driver, filterField1, val1);
				waitForElement(driver, filterBtn1);
				click(driver, filterBtn1);
				waitForElement(driver, Filter_Operator);
				click(driver, Filter_Operator);
				waitForElement(driver, Equals_Option);
				click(driver, Equals_Option);
				waitForElement(driver, columnHeader1);
				click(driver, columnHeader1);

				waitForElement(driver, filterField2);
				clear(driver, filterField2);
				sendKeys(driver, filterField2, val2);
				waitForElement(driver, filterBtn2);
				click(driver, filterBtn2);
				waitForElement(driver, Filter_Operator);
				click(driver, Filter_Operator);
				waitForElement(driver, Equals_Option);
				click(driver, Equals_Option);
				waitForElement(driver, columnHeader2);
				click(driver, columnHeader2);
				waitForElement(driver, columnValuesLocator2);
				click(driver, columnValuesLocator2);

			} else {
				boolean flag1 = false;
				boolean flag2 = false;

				waitForElement(driver, filterField1);
				clear(driver, filterField1);
				sendKeys(driver, filterField1, val1);

				waitForElement(driver, filterField2);
				clear(driver, filterField2);
				sendKeys(driver, filterField2, val2);

				List<WebElement> values1 = listOfElements(driver, columnValuesLocator1);
				for (WebElement el : values1) {
					if (el.getText().contains(val1)) {
						flag1 = true;
						break;
					}
				}

				List<WebElement> values2 = listOfElements(driver, columnValuesLocator2);
				for (WebElement el : values2) {
					if (el.getText().contains(val2)) {
						el.click();
						flag2 = true;
						break;
					}
				}

				if (!flag1 || !flag2) {
					Extent_fail(driver, "Values not found: " + val1 + " or " + val2, test, test1);
				}
			}
		}

		waitForElement(driver, select_Button);
		click(driver, select_Button);
	}

	public void Tab(WebDriver driver) {
		try {
			// Action class take some time performing action, So we have gave the manual
			// wait here
			wait(driver, ScrollWaitTime);
			Actions actionObject = new Actions(driver);
			actionObject.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			global.add(e.getLocalizedMessage());
			verifyServerStatus(driver);
			Assert.fail(e.getLocalizedMessage());
		}
	}

	private static void removeFirstNLinesFromCSV(String filePath, int lineCount) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filePath));
		if (lines.size() > lineCount) {
			List<String> newLines = lines.subList(lineCount, lines.size());
			Files.write(Paths.get(filePath), newLines);
			System.out.println("Removed first " + lineCount + " lines from CSV.");
		} else {
			System.out.println("CSV has <= " + lineCount + " lines. No changes made.");
		}
	}

	private static void removeFirstNRowsFromExcel(String filePath, String sheetName, int lineCount) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook;
		if (filePath.endsWith(".xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else { // .xls
			workbook = new HSSFWorkbook(fis);
		}

		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			System.out.println("Sheet '" + sheetName + "' not found.");
			workbook.close();
			fis.close();
			return;
		}

		int lastRowNum = sheet.getLastRowNum();

		if (lastRowNum >= lineCount) {
			sheet.shiftRows(lineCount, lastRowNum, -lineCount);

			// Remove leftover rows at bottom after shift
			for (int i = lastRowNum; i > lastRowNum - lineCount; i--) {
				Row row = sheet.getRow(i);
				if (row != null)
					sheet.removeRow(row);
			}

			fis.close();

			FileOutputStream fos = new FileOutputStream(filePath);
			workbook.write(fos);
			fos.close();
			workbook.close();

			System.out.println("Removed first " + lineCount + " rows from Excel file.");
		} else {
			System.out.println("Sheet has <= " + (lastRowNum + 1) + " rows. No changes made.");
			workbook.close();
			fis.close();
		}
	}

	public static String removeFirstNLines(String filePath, String sheetName, String lineCountStr) {
		int lineCount;
		try {
			lineCount = Integer.parseInt(lineCountStr);
		} catch (NumberFormatException e) {
			System.out.println("Invalid line count: " + lineCountStr + ". Using default 3.");
			lineCount = 3;
		}

		try {
			if (filePath.endsWith(".csv")) {
				removeFirstNLinesFromCSV(filePath, lineCount);
				return filePath;
			} else if (filePath.endsWith(".xlsx") || filePath.endsWith(".xls")) {
				removeFirstNRowsFromExcel(filePath, sheetName, lineCount);
				return filePath;
			} else {
				System.out.println("Unsupported file type.");
				return null;
			}
		} catch (IOException e) {
			System.out.println("Error processing file: " + e.getMessage());
			return null;
		}
	}

	public String extractDate(String dateTime) {
		if (dateTime == null || !dateTime.contains(" ")) {
			return dateTime; // or return ""; based on your requirement
		}
		return dateTime.split(" ")[0];
	}

	public String ReportTable(Map<String, String> tableData, String tableName) {
		// Extract headers (keys from the map)
		List<String> headers = new ArrayList<>(tableData.keySet());

		// Calculate column widths based on headers and values
		int[] columnWidths = new int[headers.size()];
		for (int i = 0; i < headers.size(); i++) {
			String header = headers.get(i);
			String value = tableData.get(header);
			int headerLength = header.length();
			int valueLength = value != null ? value.length() : 3; // for "N/A"
			columnWidths[i] = Math.max(headerLength, valueLength);
		}

		// StringBuilder for HTML table
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<h3>").append(tableName).append("</h3>");
		tableBuilder.append("<table style='width:100%; border-collapse: collapse;'>");
		tableBuilder.append("<thead><tr>");

		// Build header row
		StringBuilder headerRow = new StringBuilder();
		for (int i = 0; i < headers.size(); i++) {
			String header = headers.get(i);
			tableBuilder.append("<th style='border: 1px solid #ddd; padding: 8px;'>").append(header).append("</th>");
			headerRow.append(String.format("%-" + (columnWidths[i] + 2) + "s", header));
		}
		tableBuilder.append("</tr></thead><tbody>");

		// Build data row
		tableBuilder.append("<tr>");
		StringBuilder rowOutput = new StringBuilder();
		for (int i = 0; i < headers.size(); i++) {
			String header = headers.get(i);
			String value = getCaseInsensitiveValue(tableData, header);
			if (value != null) {
				tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>").append(value).append("</td>");
				rowOutput.append(String.format("%-" + (columnWidths[i] + 2) + "s", value));
			} else {
				tableBuilder.append("<td style='border: 1px solid #ddd; padding: 8px;'>N/A</td>");
				rowOutput.append(String.format("%-" + (columnWidths[i] + 2) + "s", "N/A"));
			}
		}
		tableBuilder.append("</tr>");
		tableBuilder.append("</tbody></table>");

		// Console output
		int lineLength = Arrays.stream(columnWidths).sum() + 2 * headers.size();
		String separator = repeatChar('-', lineLength);

		System.out.println(separator);
		System.out.println(tableName + " : ");
		System.out.println(separator);
		System.out.println(headerRow.toString());
		System.out.println(separator);
		System.out.println(rowOutput.toString());
		System.out.println(separator);

		return tableBuilder.toString();
	}


	public boolean compareTableDataNew(List<List<String>> table1, List<List<String>> table2) {
		if (table1.size() != table2.size()) {
			System.out.println("Mismatch in number of rows.");
			return false;
		}

		for (int i = 0; i < table1.size(); i++) {
			List<String> row1 = table1.get(i);
			List<String> row2 = table2.get(i);

			if (row1.size() != row2.size()) {
				System.out.println("Mismatch in number of columns at row " + (i + 1));
				return false;
			}

			for (int j = 0; j < row1.size(); j++) {
				String value1 = row1.get(j).replace(",", "").trim();
				String value2 = row2.get(j).replace(",", "").trim();

				if (isNumeric(value1) && isNumeric(value2)) {
					double d1 = Double.parseDouble(value1);
					double d2 = Double.parseDouble(value2);
					if (Math.abs(d1 - d2) > 0.001) {
						System.out.println("Mismatch at row " + (i + 1) + ", column " + (j + 1));
						System.out.println("Table1: " + d1 + " | Table2: " + d2);
						return false;
					}
				} else {
					if (!value1.equalsIgnoreCase(value2)) {
						System.out.println("Mismatch at row " + (i + 1) + ", column " + (j + 1));
						System.out.println("Table1: " + value1 + " | Table2: " + value2);
						return false;
					}
				}
			}
		}

		return true;
	}

	public static int countNonEmptyCsvRows(String csvFilePath) throws IOException {
		int nonEmptyRowsCount = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					nonEmptyRowsCount++;
				}
			}
		}
		return nonEmptyRowsCount;
	}

	public void bookingRatesSelect_Updated(WebDriver driver, String rate_no, String No_Schedule_Popup,
			String first_service_data, String Voyagenumber, String Boundinput) {
		waitForDisplay(driver, rate_reference_tab);
		waitForDisplay(driver, Rate_Grid);
		if (isdisplayed(driver, Rate_Grid)) {
			System.out.println(
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");
			Extent_pass(driver,
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed",
					test, test1);
		} else {
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		}
		System.out.println("********** Select the Columns in Rates Grid **********");
		Extent_call(test, test1, "********** Select the Columns in Rates Grid **********");

		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		Step_Start(3, "Select the Routing ", test, test1);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		selectRatesRouting_Updated(driver, No_Schedule_Popup, first_service_data, Voyagenumber, Boundinput);
	}

	public void selectRatesRouting_Updated(WebDriver driver, String No_Schedule_Popup, String first_service_data,
			String Voyagenumber, String Boundinput) {
		waitForElement(driver, FirstserviceInput);
		String service_Value = getAttribute(driver, FirstserviceInput, "value");
		if (service_Value.equals("")) {
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String Popup_Text = getText(driver, popup_Message);
				if (Popup_Text.equals(No_Schedule_Popup)) {
					click(driver, popup_Message_Ok_Button);
					System.out.println("NoSchedule available, Entering data in first service input");
					editSchedule(driver, first_service_data);
				}
			} else if (isdisplayed(driver, Invalid_date_popup)) {
				waitForDisplay(driver, Invalid_date_popup);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - Start ********");
				safeclick(driver, Invalid_date_popup_Close);
				editSchedule(driver, first_service_data);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - End ********");
			}
		}
		waitForElement(driver, FirstserviceInput);
		service_Value = getAttribute(driver, FirstserviceInput, "value");
		if (service_Value.equals("")) {
			Step_Start(4, "Select the Schedule", test, test1);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String Popup_Text = getText(driver, popup_Message);
				if (Popup_Text.equals(No_Schedule_Popup)) {
					click(driver, popup_Message_Ok_Button);
					System.out.println("NoSchedule available, Entering data in first service input");
					waitForElement(driver, FirstserviceInput);
					clearAndType(driver, FirstserviceInput, first_service_data);
					click(driver, FirstserviceInput);
					keyDown(driver);
					waitForElement(driver, BKG_VoyageInput);
					sendKeys(driver, BKG_VoyageInput, Voyagenumber);
					waitForElement(driver, BKG_Boundinpiut);
					sendKeys(driver, BKG_Boundinpiut, Boundinput);
					waitForElement(driver, routing);
					click(driver, routing);
					waitForElement(driver, routing_Select_Button);
					click(driver, routing_Select_Button);
				}
			} else if (isdisplayed(driver, Invalid_date_popup)) {
				waitForDisplay(driver, Invalid_date_popup);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - Start ********");
				safeclick(driver, Invalid_date_popup_Close);
				waitForElement(driver, FirstserviceInput);
				clearAndType(driver, FirstserviceInput, first_service_data);
				click(driver, FirstserviceInput);
				keyDown(driver);
				waitForElement(driver, BKG_VoyageInput);
				sendKeys(driver, BKG_VoyageInput, Voyagenumber);
				waitForElement(driver, BKG_Boundinpiut);
				sendKeys(driver, BKG_Boundinpiut, Boundinput);
				waitForElement(driver, routing);
				click(driver, routing);
				waitForElement(driver, routing_Select_Button);
				click(driver, routing_Select_Button);
				Extent_call(test, test1,
						"******** If There is Invalid ETA date popup showed Select the Rout Manually - End ********");
			} else {
				waitForElement(driver, FirstserviceInput);
				clearAndType(driver, FirstserviceInput, first_service_data);
				click(driver, FirstserviceInput);
				keyDown(driver);
				waitForElement(driver, BKG_VoyageInput);
				sendKeys(driver, BKG_VoyageInput, Voyagenumber);
				waitForElement(driver, BKG_Boundinpiut);
				sendKeys(driver, BKG_Boundinpiut, Boundinput);
				waitForElement(driver, routing);
				click(driver, routing);
				waitForElement(driver, routing_Select_Button);
				click(driver, routing_Select_Button);
			}
		}
		waitForDisplay(driver, Error_Popup_Booking_Close_Button);
		if (isdisplayed(driver, Error_Popup_Booking_Close_Button)) {
			waitForDisplay(driver, Error_Popup_Booking_Close_Button);
			Extent_call(test, test1, "******** If There is Error popup shown Select the Rout Manually  ********");
			safeclick(driver, Error_Popup_Booking_Close_Button);

		}
	}
//	public List<Map<String, String>> extractTableDataByColumn(WebDriver driver, String xpath) {
//		String[] values = splitXpath(xpath);
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
// 
//			// Locate table container and scrollbar
//			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebElement scrollbar = tableContainer
//					.findElement(By.xpath(".//div[@class='ag-body-horizontal-scroll-viewport']"));
// 
//			// Set to track extracted headers (avoids duplicates)
//			Set<String> extractedHeaders = new LinkedHashSet<>();
//			List<String> columnHeaders = new ArrayList<>();
//			List<Map<String, String>> tableData = new ArrayList<>();
// 
//			// Keep scrolling right until no new columns appear
//			long lastScroll = -1, currentScroll = 0;
//			long maxScroll = ((Number) js.executeScript("return arguments[0].scrollWidth;", scrollbar)).longValue();
// 
//			String[] Headers = splitXpath(AG_Grid_Table_Data_Headers);
//			String[] Rows_ = splitXpath(AG_Grid_Table_Data_Rows);
// 
//			while (lastScroll != currentScroll) {
//				lastScroll = currentScroll;
//				// Step 1: Extract headers & column values
//				List<WebElement> headerElements = tableContainer.findElements(By.xpath("." + Headers[1]));
//				List<WebElement> rows = tableContainer.findElements(By.xpath("." + Rows_[1]));
//				
//				List<WebElement> HeaderColumns = tableContainer.findElements(By.xpath(".//div[@role='columnheader']"));
// 
//				for (int i = 0; i < headerElements.size(); i++) {
//					WebElement headerElement = headerElements.get(i);
//					Actions act = new Actions(driver);
//					act.moveToElement(headerElement).build().perform();
// 
//					String headerText = headerElement.getText().trim();
//					String ColumnId=HeaderColumns.get(i).getDomAttribute("col-id");
//					
//					if (!headerText.isEmpty() && !extractedHeaders.contains(headerText)) {
//						extractedHeaders.add(headerText);
//						columnHeaders.add(headerText);
//						// Step 2: Extract all row values for this column
//						for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
//							if (tableData.size() <= rowIndex) {
//								tableData.add(new LinkedHashMap<>());
//							}
// 
//							WebElement row = rows.get(rowIndex);
//							List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell')]"));
// 
//							for(int k=0;k<cells.size();k++) {
//								String cell_Col_Id= cells.get(k).getDomAttribute("col-id");
//								if(cell_Col_Id.equals(ColumnId)) {
//									String cellValue = cells.get(k).getText().trim();
//									tableData.get(rowIndex).put(headerText, cellValue);
//									break;
//								}
//								
//								if(k==cells.size()-1) {
//									tableData.get(rowIndex).put(headerText, "");
//								}
//							}
//							
//						}
//					}
//				}
// 
//				// Step 3: Scroll right to expose more columns
//				js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
//				Thread.sleep(500);
//				// Step 4: Check new scroll position
//				currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar)).longValue();
//				if (currentScroll >= maxScroll)
//					break; // Stop if reached end
//			}
//			// Reset Scroll Position
//			js.executeScript("arguments[0].scrollLeft = 0;", scrollbar);
//			return tableData;
// 
//		} catch (Exception e) {
//			e.printStackTrace();
//			Extent_fail(driver,
//					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
//					test);
//			return Collections.emptyList();
//		}
//	}

	public List<Map<String, String>> extractTableDataByColumn(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			// Locate table container and scrollbar
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement scrollbar = tableContainer
					.findElement(By.xpath(".//div[@class='ag-body-horizontal-scroll-viewport']"));

			// Set to track extracted headers (avoids duplicates)
			Set<String> extractedHeaders = new LinkedHashSet<>();
			List<String> columnHeaders = new ArrayList<>();
			List<Map<String, String>> tableData = new ArrayList<>();

			// Keep scrolling right until no new columns appear
			long lastScroll = -1, currentScroll = 0;
			long maxScroll = ((Number) js.executeScript("return arguments[0].scrollWidth;", scrollbar)).longValue();

			String[] Headers = splitXpath(AG_Grid_Table_Data_Headers);
			String[] Rows_ = splitXpath(AG_Grid_Table_Data_Rows);

			while (lastScroll != currentScroll) {
				lastScroll = currentScroll;
				// Step 1: Extract headers & column values
				List<WebElement> headerElements = tableContainer.findElements(By.xpath("." + Headers[1]));
				List<WebElement> rows = tableContainer.findElements(By.xpath("." + Rows_[1]));

				List<WebElement> HeaderColumns = tableContainer.findElements(By.xpath(".//div[@role='columnheader']"));

				for (int i = 0; i < headerElements.size(); i++) {
					WebElement headerElement = headerElements.get(i);
					Actions act = new Actions(driver);
					act.moveToElement(headerElement).build().perform();

					String headerText = headerElement.getText().trim();
					String ColumnId = HeaderColumns.get(i).getAttribute("col-id");

					if (!headerText.isEmpty() && !extractedHeaders.contains(headerText)) {
						extractedHeaders.add(headerText);
						columnHeaders.add(headerText);
						// Step 2: Extract all row values for this column
						for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
							if (tableData.size() <= rowIndex) {
								tableData.add(new LinkedHashMap<>());
							}

							WebElement row = rows.get(rowIndex);
							List<WebElement> cells = row
									.findElements(By.xpath(".//div[contains(@class,'ag-cell') and @col-id]"));

							for (int k = 0; k < cells.size(); k++) {
								String cell_Col_Id = cells.get(k).getAttribute("col-id");
								if (cell_Col_Id.equals(ColumnId)) {
									String cellValue = cells.get(k).getText().trim();
									tableData.get(rowIndex).put(headerText, cellValue);
									break;
								}

								if (k == cells.size() - 1) {
									tableData.get(rowIndex).put(headerText, "");
								}
							}

						}
					}
				}

				// Step 3: Scroll right to expose more columns
				js.executeScript("arguments[0].scrollLeft += 200;", scrollbar);
				Thread.sleep(500);
				// Step 4: Check new scroll position
				currentScroll = ((Number) js.executeScript("return arguments[0].scrollLeft;", scrollbar)).longValue();
				if (currentScroll >= maxScroll)
					break; // Stop if reached end
			}
			// Reset Scroll Position
			js.executeScript("arguments[0].scrollLeft = 0;", scrollbar);
			return tableData;

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test);
			return Collections.emptyList();
		}
	}

	public Map<String, List<String>> getTableValuesExpectColumnValue(List<Map<String, String>> tableData,
			String firstColumnHeader, List<String> Columnvalues, List<String> columnHeaders) {
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();

		for (String header : columnHeaders) {
			resultMap.put(header, new ArrayList<>());
		}

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader)) {
				String rowValue = row.get(firstColumnHeader);
				boolean columnpresent = false;
				for (String val : Columnvalues) {
					if (val.equals(rowValue)) {
						columnpresent = true;
						break;
					}
				}
				if (columnpresent) {
					continue;
				}

				// Iterate through each row
				for (String header : columnHeaders) {
					if (row.containsKey(header)) {
						resultMap.get(header).add(row.get(header)); // Add value to corresponding list
					}
				}
			}
		}

		return resultMap;
	}

	public List<String> getValuesByExceptFirstColumnAndHeader(List<Map<String, String>> tableData,
			String firstColumnHeader, String firstColumnValue, String columnHeader) {
		List<String> matchingValues = new ArrayList<>();

		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader) && !row.get(firstColumnHeader).equals(firstColumnValue)) {
				// If there's a match, add the value from the specified column header to the
				// list
				if (row.containsKey(columnHeader)) {
					matchingValues.add(row.get(columnHeader));
				}
			}
		}
		return matchingValues; // Return the list of matching values
	}

	public boolean verifyElementHasNoText(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		boolean temp = false;
		try {
			String text = driver.findElement(By.xpath(values[1])).getText();
			if (text.equals("")) {
				temp = true;
			} else {
				temp = false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Extent_fail(driver, "Element is not present " + e.getLocalizedMessage(), test, test1);
			verifyServerStatus(driver);
			Assert.fail("Element is not present " + e.getLocalizedMessage());
		}
		return temp;
	}

	public List<Map<String, String>> getTableData_PartBL(WebDriver driver, String Header, String Row) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
		String[] columnheader = splitXpath(Header);
		String[] row = splitXpath(Row);
		List<WebElement> headers = driver.findElements(By.xpath(columnheader[1]));
		List<String> headerTexts = new ArrayList<>();
		for (WebElement header : headers) {
			try {
				String headername = header.getDomAttribute("aria-label");

				if (headername.equalsIgnoreCase("Packages/Weight")) {

					headername = "Quantity";
				}

				if (headername.contains(":")) {
					String[] headerName = headername.split(":");
					headerTexts.add(headerName[0]);
				} else {
					headerTexts.add(headername);
				}
			} catch (NullPointerException e) {
				headerTexts.add(header.getText());
				continue;
			}
		}

		// Locate the values table
		List<WebElement> rows = driver.findElements(By.xpath(row[1]));
		// List to hold all row data as a list of maps
		List<Map<String, String>> tableData = new ArrayList<>();
		// Iterate through each row (starting from 1 to skip the header row)
		int k = 1;
		for (WebElement tableRow : rows) {
			try {
				List<WebElement> cells = tableRow.findElements(By.tagName("td"));
				// Create a map for each row
				Map<String, String> rowData = new HashMap<>();

				for (int j = 0; j < cells.size(); j++) {
					if (j < headerTexts.size()) {
						rowData.put(headerTexts.get(j), cells.get(j).getText());
					}
				}
				// Add the row map to the list
				tableData.add(rowData);
			} catch (Exception e) {
				System.err.println("Error processing row " + k + ": " + e.getMessage());
				e.printStackTrace();
				Extent_fail(driver, "Error processing row " + k + ": " + e.getMessage(), test, test1);
				global.add("Error processing row " + k + ": " + e.getMessage());
				verifyServerStatus(driver);
				Assert.fail("Element is not present " + e.getLocalizedMessage());
			}
			k++;
		}
		// Fetch values by header
		return tableData;
	}

	public static boolean areEqualIgnoringSign1(double num1, double num2) {
		// Compare the absolute values of the numbers
		return Math.abs(num1) == Math.abs(num2);
	}

	public void AG_Grid_FilterInputs(WebDriver driver, String Header, String Value) {

		if (!Value.equals("")) {
			String headerColumn = String.format(AG_Grid_Inputs_HeaderColumn, Header);
			String columnId = getAttribute(driver, headerColumn, "aria-colindex");

			String InputField = String.format(Grid_Filter_InputField, columnId);
			waitForElement(driver, InputField);
			Newclear(driver, InputField);
			sendKeys(driver, InputField, Value);
		}

	}

	public void waitForDisplay(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		String[] process = splitXpath(Processing_Locator);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Processing_WaitTime));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(process[1])));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Display_WaitTime));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Display_WaitTime));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
		} catch (Exception e) {
		}
	}

	public void selectDateInCalender(WebDriver driver, String dateInput, String DateXpath, String MonthXpath,
			String YearXpath, String PrevButtonXpath, String NextButtonXpath) throws InterruptedException {
		String[] DateXpathvalues = splitXpath(DateXpath);
		String[] MonthXpathvalues = splitXpath(MonthXpath);
		String[] YearXpathvalues = splitXpath(YearXpath);
		String[] PrevButtonXpathvalues = splitXpath(PrevButtonXpath);
		String[] NextButtonXpathvalues = splitXpath(NextButtonXpath);

		int targetDay = 0;
		int targetMonth = 0;
		int targetYear = 0;

		String[] parts;
//		String delimiter;

		// Detect delimiter and split accordingly
		if (dateInput.contains("/")) {
//			delimiter = "/";
			parts = dateInput.split("/");
			// Format: dd/MM/yyyy
			targetDay = Integer.parseInt(parts[0]);
			targetMonth = Integer.parseInt(parts[1]);
			targetYear = Integer.parseInt(parts[2]);
		} else if (dateInput.contains("-")) {
//			delimiter = "-";
			parts = dateInput.split("-");
			// Format: MM-dd-yyyy
			targetMonth = Integer.parseInt(parts[0]);
			targetDay = Integer.parseInt(parts[1]);
			targetYear = Integer.parseInt(parts[2]);
		} else {
			throw new IllegalArgumentException("Invalid date format. Use either dd/MM/yyyy or MM-dd-yyyy");
		}

		String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		// Loop until calendar displays the expected month & year
		while (true) {
			String displayedMonth = driver.findElement(By.xpath(MonthXpathvalues[1])).getText().trim();
			String displayedYear = driver.findElement(By.xpath(YearXpathvalues[1])).getText().trim();

			int displayedMonthIndex = Arrays.asList(monthNames).indexOf(displayedMonth) + 1;
			int displayedYearInt = Integer.parseInt(displayedYear);

			if (displayedMonthIndex == targetMonth && displayedYearInt == targetYear) {
				break;
			}

			if (displayedYearInt > targetYear
					|| (displayedYearInt == targetYear && displayedMonthIndex > targetMonth)) {
				driver.findElement(By.xpath(PrevButtonXpathvalues[1])).click();
			} else {
				driver.findElement(By.xpath(NextButtonXpathvalues[1])).click();
			}

			Thread.sleep(300); // Small delay to allow calendar UI to update
		}

		// Select the correct date
		List<WebElement> allDates = driver.findElements(By.xpath(DateXpathvalues[1]));
		for (WebElement dateElement : allDates) {
			if (dateElement.getText().equals(String.valueOf(targetDay))) {
				dateElement.click();
				break;
			}
		}
	}
	public Map<String, List<String>> getColumnValuesByHeaders1(List<Map<String, String>> tableData,
			String firstColumnHeader, String firstColumnValue, List<String> columnHeaders) {
		Map<String, List<String>> resultMap = new HashMap<>();
		
		for (String header : columnHeaders) {
			resultMap.put(header, new ArrayList<>());
		}
		
		for (Map<String, String> row : tableData) {
			if (row.containsKey(firstColumnHeader) && row.get(firstColumnHeader).equals(firstColumnValue)) {
				// Initialize map with empty lists for each header
				
				// Iterate through each row
				for (String header : columnHeaders) {
					if (row.containsKey(header)) {
						resultMap.get(header).add(row.get(header)); // Add value to corresponding list
					}
				}
			}
		}
 
		return resultMap;
	}
	public static double ConvertNumberValue(String value) {
		double numberValue = 0;
		try {
			if (value != null && !value.trim().isEmpty()) {
				value = value.replace(",", "").trim(); // Remove commas and trim spaces
				numberValue = Double.parseDouble(value);
			}
		} catch (Exception e) {
			System.out.println("Error parsing number from value: " + value);
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test);
		}
		return numberValue;
	}

	// Decimal values convertion
	public static double roundToSameDecimals(double value1, double value2) {
		BigDecimal bd = new BigDecimal(value2);
		try {

			int decimalPlaces = getDecimalPlaces(value1);

			bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test);
		}

		return bd.doubleValue();
	}

	public static int getDecimalPlaces(double value) {
		String text = "";
		int index = 0;
		try {
			text = BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
			index = text.indexOf(".");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test);
		}

		return (index < 0) ? 0 : text.length() - index - 1;
	}

	public void setPluginConfig(WebDriver driver, String ModuleName, String Column_Header, String Condition_Filter,
			String value, String EnableStatus) {

		moduleNavigate(driver, ModuleName);
//		List<String> expheaders = splitAndExpand(Column_Header, "/");
		List<String> expinputValues = splitAndExpand(value, "/");
		List<String> EnableStatusValues = splitAndExpand(EnableStatus, "/");

		for (int j = 0; j < expinputValues.size(); j++) {
			String DRopDownSelect = String.format(PluginTrue, EnableStatusValues.get(j));
			List<String> headers = splitAndExpand(Column_Header, ",");
			List<String> inputValues = splitAndExpand(expinputValues.get(j), ",");
			for (int i = 0; i < headers.size(); i++) {
				String givenHeader = headers.get(i);
				String inputValue = inputValues.get(i);
				String columnHeader = String.format(AG_Grid_Headers, givenHeader, givenHeader);
				waitForElement(driver, columnHeader);
				String columnIndex = getAttribute(driver, columnHeader, "aria-colindex");
				String filterField = String.format(AG_Grid_Filter_Field, columnIndex, columnIndex);
				String filterButton = String.format(AG_Grid_Filter_Button, columnIndex, columnIndex);
				waitForElement(driver, filterField);
				clear(driver, filterField);
				waitForElement(driver, filterField);
				sendKeys(driver, filterField, inputValue);
				if (Condition_Filter.equals("Equals")) {
					waitForElement(driver, filterButton);
					click(driver, filterButton);
					waitForElement(driver, Filter_Operator);
					click(driver, Filter_Operator);
					waitForElement(driver, Equals_Option);
					click(driver, Equals_Option);
					waitForElement(driver, columnHeader);
					click(driver, columnHeader);
				}
			}
			waitForElement(driver, first_Plugin_Row);
			doubleClick(driver, first_Plugin_Row);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			safeclick(driver, enable_Status_Dropdown);

			waitForElement(driver, DRopDownSelect);
			safeclick(driver, DRopDownSelect);

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			waitForPopup(driver, Popup_Message, "Updated Successfully");
			String ExceptedPop = getText(driver, Popup_Message);
			if (ExceptedPop.equals("Updated Successfully")) {
				System.out.println(
						"Matched || Excepted : After Click on Save button The Status should be : Updated Successfully || Actual : After Click on Save Button The Satus is : "
								+ ExceptedPop);
				Extent_pass_New(driver,
						"Matched || Excepted : After Click on Save button The Status should be : Updated Successfully || Actual : After Click on Save Button The Satus is  : "
								+ ExceptedPop,
						test, test);
			} else {
				System.out.println(
						" Not Matched || Excepted : After Click on Save button The Status should be : Updated Successfully || Actual : After Click on Save Button The Satus is  : "
								+ ExceptedPop);
				Extent_fail(driver,
						" Not Matched || Excepted : After Click on Save button The Status should be : Updated Successfully || Actual : After Click on Save Button The Satus is  : "
								+ ExceptedPop,
						test, test);

			}
		}
		waitForElement(driver, Module_Close);
		safeclick(driver, Module_Close);

	}
	public static boolean compareMapsNew(Map<String, String> exp, Map<String, String> act,
			Map<String, String> headerMapping) {
		for (Map.Entry<String, String> entry : exp.entrySet()) {
			String expKey = entry.getKey();
			String expValue = entry.getValue();
 
			// Get the corresponding actual key from the header mapping
			String actKey = headerMapping.get(expKey);
 
			// Handle missing mappings
			if (actKey == null) {
				System.out.println("Header mapping missing for expected key: " + expKey);
				return false;
			}
 
			// Check if actual map contains the key and values match
			String actValue = act.get(actKey);
			if (actValue == null) {
				System.out.println("Missing key in actual data: " + actKey);
				return false;
			}
 
			if (expValue.contains(",")) {
				expValue = expValue.replace(",", "");
			}
			if (actValue.contains(",")) {
				actValue = actValue.replace(",", "");
			}
			// Compare values as BigDecimal if they are numeric
			if (isNumeric(expValue) && isNumeric(actValue)) {
				double expNum = getNumberValue(expValue);
				double actNum = getNumberValue(actValue);
				if (expNum!=actNum) {
					return false;
				}
			} else {
				// Compare as regular strings for non-numeric values
				if (!expValue.equals(actValue)) {
					return false;
				}
			}
		}
		return true;
	}
	public String getHeaderValueByRow(List<Map<String, String>> tableData,
			String Header, String rowCount) {
		// Initialize the result list

	 String result="";
	 int k = 1;
		int row = Integer.parseInt(rowCount);
		// Iterate over each row in the table data
		for (Map<String, String> rowData : tableData) {
			if(row==k) {
				if (rowData.containsKey(Header)) {
					result=rowData.get(Header);
					return result;
				}
			}
			
			k++;
		}
		// System.out.println("headvalues : "+headvalues);
		// Return the list of values grouped by headers
		return result;
 }
	public List<Map<String, String>> extractTableDataByRowIndex(WebDriver driver, String xpath, int row_count) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitElementSeconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
 
			// Locate table container
			WebElement tableContainer = driver.findElement(By.xpath(values[1]));
 
			// Set to track extracted headers (avoids duplicates)
			Set<String> extractedHeaders = new LinkedHashSet<>();
			List<String> columnHeaders = new ArrayList<>();
			List<Map<String, String>> tableData = new ArrayList<>();
 
			String[] heads = splitXpath(Table_Headers_AgGrid);
			String[] Rows = splitXpath(Table_Headers_AgGrid_Values);
			
			// Step 1: Extract headers & column values
			List<WebElement> headerElements = tableContainer.findElements(
					By.xpath("."+heads[1]));
			// List<WebElement> rows =
			// tableContainer.findElements(By.xpath(".//div[@ref='eContainer']//div[@role='row']"));
 
			// Extract column headers
			for (WebElement headerElement : headerElements) {
				String headerText = headerElement.getText().trim();
				if (!headerText.isEmpty() && !extractedHeaders.contains(headerText)) {
					extractedHeaders.add(headerText);
					columnHeaders.add(headerText);
				}
			}
 
			// Step 2: Extract values row by row
			for (int rowIndex = 0; rowIndex < row_count; rowIndex++) {
				
				String rowpath=String.format(Rows[1], rowIndex);
				WebElement row = tableContainer.findElement(
						By.xpath("."+rowpath));
				moveToElement(driver, row);
				List<WebElement> cells = row.findElements(By.xpath(".//div[contains(@class,'ag-cell-value')]"));
 
				// Create a new map to hold the row data
				Map<String, String> rowData = new LinkedHashMap<>();
 
				for (int columnIndex = 0; columnIndex < columnHeaders.size(); columnIndex++) {
					// Ensure the cell exists for the column
					if (columnIndex < cells.size()) {
						String cellValue = cells.get(columnIndex).getText().trim();
						rowData.put(columnHeaders.get(columnIndex), cellValue);
					}
				}
 
				// Add the row data to the table data list
				tableData.add(rowData);
			}
 
			return tableData;
 
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,
					"Unable to get the Table Value from Element - " + values[0] + " " + e.getLocalizedMessage(), test,
					test1);
			return Collections.emptyList();
		}
	}
	/*
	 * Used to get the table data from application
	 */
	public List<Map<String, String>> getTableData(WebDriver driver, String Header, String Row) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
		String[] columnheader = splitXpath(Header);
		String[] row = splitXpath(Row);
		List<WebElement> headers = driver.findElements(By.xpath(columnheader[1]));
		List<String> headerTexts = new ArrayList<>();
		for (WebElement header : headers) {
			try {
				String headername = header.getDomAttribute("aria-label");
				if (headername.contains(":")) {
					String[] headerName = headername.split(":");
					headerTexts.add(headerName[0]);
				} else {
					headerTexts.add(headername);
				}
			} catch (NullPointerException e) {
				headerTexts.add(header.getText());
				continue;
			}
		}
		// Locate the values table
		List<WebElement> rows = driver.findElements(By.xpath(row[1]));
		// List to hold all row data as a list of maps
		List<Map<String, String>> tableData = new ArrayList<>();
		// Iterate through each row (starting from 1 to skip the header row)
		int k = 1;
		for (WebElement tableRow : rows) {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitElementSeconds));
				List<WebElement> cells = tableRow.findElements(By.tagName("td"));
				// Create a map for each row
				Map<String, String> rowData = new HashMap<>();
 
				for (int j = 0; j < cells.size(); j++) {
					if (j < headerTexts.size()) {
						if (!cells.get(j).getText().equals("")) {
							rowData.put(headerTexts.get(j), cells.get(j).getText());
						} else {
							try {
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
								WebElement cell = cells.get(j).findElement(By.tagName("input"));
							rowData.put(headerTexts.get(j), cell.getDomAttribute("value"));
							}catch (Exception e) {
								rowData.put(headerTexts.get(j), "");
							}
						}
					}
				}
				// Add the row map to the list
				tableData.add(rowData);
			} catch (Exception e) {
				System.err.println("Error processing row " + k + ": " + e.getMessage());
				e.printStackTrace();
				Extent_fail(driver, "Error processing row " + k + ": " + e.getMessage(), test, test1);
				global.add("Error processing row " + k + ": " + e.getMessage());
				verifyServerStatus(driver);
				Assert.fail("Element is not present " + e.getLocalizedMessage());
			}
			k++;
		}
		// Fetch values by header
		return tableData;
	}
	public List<List<String>> getValuesByHeaders_RemoveMinus(List<Map<String, String>> tableData, List<String> headers) {
	    // Initialize the result list
	    List<List<String>> result = new ArrayList<>();
 
	    // Iterate over each row in the table data
	    for (Map<String, String> rowData : tableData) {
	        List<String> rowValues = new ArrayList<>();
 
	        // Iterate over the headers to maintain the order
	        for (String header : headers) {
	            String value = null;
 
	            // Case-insensitive match for header key
	            for (Map.Entry<String, String> entry : rowData.entrySet()) {
	                if (entry.getKey().equalsIgnoreCase(header)) {
	                    value = entry.getValue();
	                    break;
	                }
	            }
 
	            // If value starts with "-", remove the minus sign
	            if (value != null && value.trim().startsWith("-")) {
	                value = value.replaceFirst("-", ""); // Remove only the leading minus
	            }
 
	            // Add the final value to the row list
	            rowValues.add(value);
	        }
 
	        // Add this row to the result
	        result.add(rowValues);
	    }
 
	    return result;
	}
	
	
	public void DeleteReceiptInCashDeposit(WebDriver driver,String Cheque_module,String BL_Condition, String Global_search_value_Receipt_No,String ReceiptNumber,String reset_Popup_Expected,String reversed_successful_Expected) {

	 	moduleNavigate(driver, Cheque_module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, BL_Condition, Global_search_value_Receipt_No, ReceiptNumber,
				"", "", "", "");
		waitForDisplay(driver, retrivedGlobalValue);
		if (isdisplayed(driver, retrivedGlobalValue)) {
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);


			formatLocatorClick(driver, Receipt_Cell_CashDeposit, ReceiptNumber);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, reset_Popup_Expected);
			String reset_Popup_Actual = getText(driver, popup_Message).trim();

			if (reset_Popup_Actual.equals(reset_Popup_Expected)) {

				System.out.println("MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ "ACTUAL RESET POPUP IS :" + reset_Popup_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ "ACTUAL RESET POPUP IS :" + reset_Popup_Actual, test, test1);
			} else {
				System.out.println("NOT MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ " ACTUAL RESET POPUP IS :" + reset_Popup_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ " ACTUAL RESET POPUP IS :" + reset_Popup_Actual, test, test1);

			}

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForPopup(driver, popup_Message, reversed_successful_Expected);
			String reversed_Success_Actual = getText(driver, popup_Message).trim();

			if (reversed_Success_Actual.equals(reversed_successful_Expected)) {

				System.out.println("MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
						+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual);
				Extent_pass_New(driver,
						"MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual,
						test, test1);
			} else {
				System.out.println(
						"Not MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual);
				Extent_fail(driver,
						"Not MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual,
						test, test1);

			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		} else {
			Extent_fail(driver, "Expected : Receipt Number should be displayed || Actual : Receipt number not displayed in the Globalsearch", test, test);
		}
	
	
	waitForElement(driver, Close_Current_tab);
	click(driver, Close_Current_tab);
		
 }
 
 
 public void DeleteReceiptInDD_Deposit(WebDriver driver,String Cheque_module,String BL_Condition, String Global_search_value_Receipt_No,String ReceiptNumber,String reset_Popup_Expected,String reversed_successful_Expected) {

	 	moduleNavigate(driver, Cheque_module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, BL_Condition, Global_search_value_Receipt_No, ReceiptNumber,
				"", "", "", "");
		waitForDisplay(driver, retrivedGlobalValue);
		if (isdisplayed(driver, retrivedGlobalValue)) {
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);


			formatLocatorClick(driver, Receipt_Column_DD_Deposit, ReceiptNumber);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, reset_Popup_Expected);
			String reset_Popup_Actual = getText(driver, popup_Message).trim();

			if (reset_Popup_Actual.equals(reset_Popup_Expected)) {

				System.out.println("MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ "ACTUAL RESET POPUP IS :" + reset_Popup_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ "ACTUAL RESET POPUP IS :" + reset_Popup_Actual, test, test1);
			} else {
				System.out.println("NOT MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ " ACTUAL RESET POPUP IS :" + reset_Popup_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ " ACTUAL RESET POPUP IS :" + reset_Popup_Actual, test, test1);

			}

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForPopup(driver, popup_Message, reversed_successful_Expected);
			String reversed_Success_Actual = getText(driver, popup_Message).trim();

			if (reversed_Success_Actual.equals(reversed_successful_Expected)) {

				System.out.println("MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
						+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual);
				Extent_pass_New(driver,
						"MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual,
						test, test1);
			} else {
				System.out.println(
						"Not MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual);
				Extent_fail(driver,
						"Not MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual,
						test, test1);

			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		} else {
			Extent_fail(driver, "Expected : Receipt Number should be displayed || Actual : Receipt number not displayed in the Globalsearch", test, test);
		}
	
	
	waitForElement(driver, Close_Current_tab);
	click(driver, Close_Current_tab);
		
 }
 public void DeleteReceiptInChequeRealization(WebDriver driver,String Cheque_module,String BL_Condition, String Global_search_value_Receipt_No,String ReceiptNumber,String reset_Popup_Expected,String reversed_successful_Expected) {

	 	moduleNavigate(driver, Cheque_module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, BL_Condition, Global_search_value_Receipt_No, ReceiptNumber,
				"", "", "", "");
		waitForDisplay(driver, retrivedGlobalValue);
		if (isdisplayed(driver, retrivedGlobalValue)) {
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);


			formatLocatorClick(driver, CR_click_Checkbox_With_Receipt_Number, ReceiptNumber);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, reset_Popup_Expected);
			String reset_Popup_Actual = getText(driver, popup_Message).trim();

			if (reset_Popup_Actual.equals(reset_Popup_Expected)) {

				System.out.println("MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ "ACTUAL RESET POPUP IS :" + reset_Popup_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ "ACTUAL RESET POPUP IS :" + reset_Popup_Actual, test, test1);
			} else {
				System.out.println("NOT MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ " ACTUAL RESET POPUP IS :" + reset_Popup_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED RESET POPUP IS : " + reset_Popup_Expected
						+ " ACTUAL RESET POPUP IS :" + reset_Popup_Actual, test, test1);

			}

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForPopup(driver, popup_Message, reversed_successful_Expected);
			String reversed_Success_Actual = getText(driver, popup_Message).trim();

			if (reversed_Success_Actual.equals(reversed_successful_Expected)) {

				System.out.println("MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
						+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual);
				Extent_pass_New(driver,
						"MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual,
						test, test1);
			} else {
				System.out.println(
						"Not MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual);
				Extent_fail(driver,
						"Not MATCHED || EXPECTED REVERSED SUCCESS POPUP " + reversed_successful_Expected
								+ " ACTUAL REVERSED SUCCESS POPUP " + reversed_Success_Actual,
						test, test1);

			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		} else {
			Extent_fail(driver, "Expected : Receipt Number should be displayed || Actual : Receipt number not displayed in the Globalsearch", test, test);
		}
	
	
	waitForElement(driver, Close_Current_tab);
	click(driver, Close_Current_tab);
		
}
 
   public static double getNumberValue_roundOff(String value) {
	    double numberValue = 0;
	    try {
         if (value.contains(",")) {
             value = value.replace(",", "");
         }

         BigDecimal bd = new BigDecimal(value.trim());

         // Step 1: Count decimal digits
         String[] parts = value.trim().split("\\.");
         int decimalDigits = (parts.length > 1) ? parts[1].length() : 0;

         System.out.println("Original Value        : " + bd);
         System.out.println("Decimal digits count  : " + decimalDigits);

         // Step 2: Loop to round step-by-step down to 1 decimal place
         for (int i = decimalDigits; i > 1; i--) {
             bd = bd.setScale(i - 1, RoundingMode.HALF_UP);
             System.out.println("Rounded to " + (i - 1) + " digits: " + bd);
         }

         // Step 3: Final round to whole number
         bd = bd.setScale(0, RoundingMode.HALF_UP);
         System.out.println("Rounded to whole      : " + bd);

         numberValue = bd.doubleValue();

     } catch (Exception e) {
	    }
	    return numberValue;
	}

	// Custom implementation of ITestResult for simplicity
	static class CustomTestResult implements ITestResult {
		private int status;

		@Override
		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		@Override
		public Object getAttribute(String name) {
			return name;
		}

		@Override
		public void setAttribute(String name, Object value) {
		}

		@Override
		public Set<String> getAttributeNames() {
			return null;
		}

		@Override
		public Object removeAttribute(String name) {
			return null;
		}

		@Override
		public int compareTo(ITestResult o) {
			return 0;
		}

		@Override
		public ITestNGMethod getMethod() {
			return null;
		}

		@Override
		public Object[] getParameters() {
			return null;
		}

		@Override
		public void setParameters(Object[] parameters) {
		}

		@Override
		public IClass getTestClass() {
			return null;
		}

		@Override
		public Throwable getThrowable() {
			return null;
		}

		@Override
		public void setThrowable(Throwable throwable) {
		}

		@Override
		public long getStartMillis() {
			return 0;
		}

		@Override
		public long getEndMillis() {
			return 0;
		}

		@Override
		public void setEndMillis(long millis) {
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public boolean isSuccess() {
			return false;
		}

		@Override
		public String getHost() {
			return null;
		}

		@Override
		public Object getInstance() {
			return null;
		}

		@Override
		public String getTestName() {
			return null;
		}

		@Override
		public String getInstanceName() {
			return null;
		}

		@Override
		public ITestContext getTestContext() {
			return null;
		}
	}

	private static Object parse() {
		return null;
	}

}
