package LRP_Cost_Scripts;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS045 extends Keywords {

	public void Cost_Activity_Report_TS045(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS045";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Export_Filename = Excel_data.get("Export_Filename");
		String Agency = Excel_data.get("Agency");

		Extent_Start(tc_Name, test, test1);

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
		SwitchProfile(driver, Agency);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
			
		}else {
			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
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

		String columcount = getAttribute(driver, OverviewColumncount, "aria-colcount");

		List<String> Grid_Headers = new ArrayList<String>();

		List<String> Grid_values = new ArrayList<String>();

		for (int i = 1; i <= Integer.parseInt(columcount); i++) {

			String Gridheader = String.format(CAR_Overview_headers, i);

			Grid_Headers.add(getText(driver, Gridheader));

			String Gridvalue = String.format(CAR_Overview_Cells, i);

			mouseOverToElement(driver, Gridvalue);

			Grid_values.add(getText(driver, Gridvalue));

		}

		waitForElement(driver, CAR_TreeTable);
		click(driver, CAR_TreeTable);

		Step_End(9, "Click on the click for more options which is available at the right corner of AG Grid", test,
				test1);

		Step_Start(10, "Click on the excel option", test, test1);

		String Excelpath = Verify_FileDownloaded1(driver, Export_Filename, CAR_TreeTable_Excel);

		List<List<String>> ExcelDatas = allColumnData(Excelpath);

		System.out.println("ExcelDatas : " + ExcelDatas);

		DecimalFormat df = new DecimalFormat("#.########");

		for (int i = 0; i < Integer.parseInt(columcount); i++) {

			String headername = Grid_Headers.get(i);
			System.out.println("headername : " + headername);

			String value = Grid_values.get(i); // Expected value from grid
			List<String> Gridcolumnvalue = ExcelDatas.get(i); // Values from Excel

			for (String columns : Gridcolumnvalue) {

				String Expectedvalue = columns; // Preserve original column value

				// Convert numeric values properly without truncation
				if (columns.matches("-?\\d+(\\.\\d+)?")) {
					double num = Double.parseDouble(columns);
					Expectedvalue = df.format(num); // Format correctly to avoid ".0"
				}

				// Compare values
				if (Expectedvalue.equals(value)) {
					System.out
							.println(headername + " values are correctly showing in the downloaded Excel || Expected: "
									+ value + " || Actual: " + Expectedvalue);
					Extent_pass_New(driver,
							headername + " values are correctly showing in the downloaded Excel || Expected: " + value
									+ " || Actual: " + Expectedvalue,
							test, test1);
				} else {
					System.out.println(
							headername + " values are not correctly showing in the downloaded Excel || Expected: "
									+ value + " || Actual: " + Expectedvalue);
					Extent_fail(driver,
							headername + " values are not correctly showing in the downloaded Excel || Expected: "
									+ value + " || Actual: " + Expectedvalue,
							test, test1);
				}
			}
		}

		Extent_completed(tc_Name, test, test1);

	}

}
