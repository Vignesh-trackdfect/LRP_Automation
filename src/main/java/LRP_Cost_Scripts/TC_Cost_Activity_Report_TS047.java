package LRP_Cost_Scripts;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS047 extends Keywords {

	public void Cost_Activity_Report_TS047(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS047";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Export_Filename = Excel_data.get("Export_Filename");
		String Sheet_Name = Excel_data.get("Sheet_Name");
		String Open_Sheet_Name = Excel_data.get("Open_Sheet_Name");

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver,
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully",
					test, test1);

		} else {
			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver,
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully",
					test, test1);
		}

		Step_End(4, "Check whether it opens a new search window", test, test1);

		Step_Start(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_Start(6, "Then click on the search button", test, test1);

		Step_Start(7, "System will show the CAR No", test, test1);

		Step_Start(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		globalValueSearchWindow(driver, Condition, Select_search_value, CAR_No, "", "", "", "");

		Step_End(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_End(6, "Then click on the search button", test, test1);

		Step_End(7, "System will show the CAR No", test, test1);

		waitForElement(driver, CAR_Input);
		String retrived_Number = getAttribute(driver, CAR_Input, "value");

		if (retrived_Number.equals(CAR_No)) {

			System.out.println("The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number);
			Extent_pass_New(driver, "The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number, test, test1);
		} else {
			System.out.println("The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number);
			Extent_fail(driver, "The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number, test, test1);
		}

		Step_End(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(9, "Click on the expense report option", test, test1);

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		Step_Start(10, "Click on the export excel option", test, test1);

		Step_Start(11, "Ensure that the excel with details of open and approve expenses gets downloaded", test, test1);

		waitForElement(driver, OpenExpense_Count);
		String columcount = getAttribute(driver, OpenExpense_Count, "aria-colcount");

		List<String> Grid_Headers = new ArrayList<>();
		List<List<String>> Grid_values = new ArrayList<>(); // Change to List of Lists

		String rowcount = getText(driver, Open_TAble_record);

		for (int j = 1; j <= Integer.parseInt(rowcount); j++) {
			List<String> rowValues = new ArrayList<>(); // Store row-wise values

			for (int i = 1; i < Integer.parseInt(columcount); i++) {
				waitForElement(driver, OpenExpense_Count);

				if (j == 1) { // Capture headers only once
					String Gridheader = String.format(CAR_overview, i);

					mouseOverToElement(driver, Gridheader);

					Grid_Headers.add(getAttribute(driver, Gridheader, "col-id"));
				}

				String Gridvalue = String.format(CAR_overviewgrid, i,j);

				mouseOverToElement(driver, Gridvalue);
				
				String getvalue = getText(driver, Gridvalue);

				if (getvalue.isEmpty()) {

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

					List<WebElement> newlist = listOfElements1(driver, CAR_checkedcount.formatted(i, j));
					List<WebElement> newlist2 = listOfElements1(driver, CAR_disabledcount.formatted(i, j));

					try {
						if (newlist.size() > 0) {
							getvalue = "true";
						} else if (newlist2.size() > 0) {
							getvalue = "false";
						}
					} catch (Exception e) {
						getvalue = "";
					}

				}

				rowValues.add(getvalue); // **Fix: Store getvalue, not Gridvalue.getText()**
			}

			horizontalscrollFull(driver, ExpenseReportScroller);

			Grid_values.add(rowValues); // Add row to main list
		}

		// Read Excel data
		String Excelpath = Verify_FileDownloaded1(driver, Export_Filename, Expense_Excel);
		List<List<String>> ExcelDatas = xls_allColumnData(Excelpath, Open_Sheet_Name);

		System.out.println("ExcelDatas : " + ExcelDatas);

		DecimalFormat df = new DecimalFormat("#.########");

		for (int i = 0; i < Grid_Headers.size(); i++) {
			String headername = Grid_Headers.get(i);
			System.out.println("headername : " + headername);

			for (int j = 0; j < Grid_values.size(); j++) {
				String value = Grid_values.get(j).get(i);
				List<String> Gridcolumnvalue = ExcelDatas.get(i);

				String Expectedvalue = Gridcolumnvalue.get(j).isEmpty() ? ""
						: Gridcolumnvalue.get(j).toString().replace("[", "").replace("]", "").trim();

				if (Expectedvalue.matches("-?\\d+(\\.\\d+)?")) {
					double num = Double.parseDouble(Expectedvalue);
					Expectedvalue = df.format(num);
				}

				String Actualvalue = value;

				if (Actualvalue.matches("-?\\d+(\\.\\d+)?")) {
					double num = Double.parseDouble(Actualvalue);
					Actualvalue = df.format(num);
				}

				if (Expectedvalue.equals(Actualvalue)) {
					System.out.println(
							headername + " values match || Expected: " + Actualvalue + " || Actual: " + Expectedvalue);
					Extent_pass_New(driver,
							headername + " values match || Expected: " + Actualvalue + " || Actual: " + Expectedvalue,
							test, test1);
				} else {
					System.out.println(headername + " values do not match || Expected: " + Actualvalue + " || Actual: "
							+ Expectedvalue);
					Extent_fail(driver, headername + " values do not match || Expected: " + Actualvalue + " || Actual: "
							+ Expectedvalue, test, test1);
				}
			}
		}

		waitForElement(driver, ApprovedExpenses);
		click(driver, ApprovedExpenses);

		List<List<String>> Approved_ExcelDatas = xls_allColumnData(Excelpath, Sheet_Name);

		waitForElement(driver, ApprovedExpense_Count);
		String Approved_columcount = getAttribute(driver, ApprovedExpense_Count, "aria-colcount");

		List<String> Approved_Grid_Headers = new ArrayList<>();
		List<List<String>> Approved_Grid_values = new ArrayList<>(); // Change to List of Lists

		String Approved_rowcount = getText(driver, Approved_Total_CAR_APP);

		for (int j = 1; j <= Integer.parseInt(Approved_rowcount); j++) {
			List<String> rowValues = new ArrayList<>(); // Store row-wise values

			for (int i = 1; i < Integer.parseInt(Approved_columcount); i++) {
				waitForElement(driver, ApprovedExpense_Count);

				if (j == 1) { // Capture headers only once
					String Gridheader = String.format(CAR_Approvedgridheader, i);
					
					mouseOverToElement(driver, Gridheader);
					
					Approved_Grid_Headers.add(getAttribute(driver, Gridheader, "col-id"));
					
				}

				String Gridvalue = String.format(CAR_Approvedgridvalue, i,j);
				
				mouseOverToElement(driver, Gridvalue);

				String getvalue = getText(driver, Gridvalue);

				if (getvalue.isEmpty()) {

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

					List<WebElement> newlist = listOfElements1(driver, CAR_ApprovedCheckedcount.formatted(i, j));
					List<WebElement> newlist2 = listOfElements1(driver, CAR_Appriveddisabledcount.formatted(i, j));

					try {
						if (newlist.size() > 0) {
							getvalue = "true";
						} else if (newlist2.size() > 0) {
							getvalue = "false";
						}
					} catch (Exception e) {
						getvalue = "";
					}

				}

				rowValues.add(getvalue); // **Fix: Store getvalue, not Gridvalue.getText()**
			}

			horizontalscrollFull(driver, Approved_Scroller);

			Approved_Grid_values.add(rowValues); // Add row to main list
		}

		for (int i = 0; i < Approved_Grid_Headers.size(); i++) {
			String headername = Approved_Grid_Headers.get(i);
			System.out.println("headername : " + headername);

			for (int j = 0; j < Approved_Grid_values.size(); j++) {
				String value = Approved_Grid_values.get(j).get(i);
				List<String> Gridcolumnvalue = Approved_ExcelDatas.get(i);

				String Expectedvalue = Gridcolumnvalue.get(j).isEmpty() ? ""
						: Gridcolumnvalue.get(j).toString().replace("[", "").replace("]", "").trim();

				if (Expectedvalue.matches("-?\\d+(\\.\\d+)?")) {
					double num = Double.parseDouble(Expectedvalue);
					Expectedvalue = df.format(num);
				}

				String Actualvalue = value;

				if (Actualvalue.matches("-?\\d+(\\.\\d+)?")) {
					double num = Double.parseDouble(Actualvalue);
					Actualvalue = df.format(num);
				}

				if (Expectedvalue.equals(Actualvalue)) {
					System.out.println(
							headername + " values match || Expected: " + Actualvalue + " || Actual: " + Expectedvalue);
					Extent_pass_New(driver,
							headername + " values match || Expected: " + Actualvalue + " || Actual: " + Expectedvalue,
							test, test1);
				} else {
					System.out.println(headername + " values do not match || Expected: " + Actualvalue + " || Actual: "
							+ Expectedvalue);
					Extent_fail(driver, headername + " values do not match || Expected: " + Actualvalue + " || Actual: "
							+ Expectedvalue, test, test1);
				}
			}
		}

		Step_End(10, "Click on the export excel option", test, test1);

		Step_End(11, "Ensure that the excel with details of open and approve expenses gets downloaded", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
