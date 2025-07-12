package LRP_Cost_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS057 extends Keywords {

	public void Cost_Activity_Report_TS057(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS057";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Header_value = Excel_data.get("Header");
		String AgencyUser = Excel_data.get("AgencyUser");
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		
		
		Extent_Start(tc_Name, test, test1);

		Step_Start(1,"Once login to the application and click on switch profile option and select the required agency.",test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Once login to the application and click on switch profile option and select the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		LRP_Login(driver, username, password);

		SwitchProfile(driver, AgencyUser);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		verifyMainMenu(driver);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		waitForElement(driver, seach_Filed);
		click(driver, seach_Filed);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);
		
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_Start(8, "System will retrieve the CAR", test, test1);
	

		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);

		Step_Start(8, "System will retrieve the CAR", test, test1);

		waitForElement(driver, car_Number_val);
		String Carvalue = getAttribute(driver, car_Number_val, "value");

		System.out.println("Carvalue :" + Carvalue);

		Step_End(8, "System will retrieve the CAR", test, test1);

		Step_Start(9, "Click on the edit option", test, test1);

		waitForElement(driver, Car_Edit_Option);
		click(driver, Car_Edit_Option);

		Step_End(9, "Click on the edit option", test, test1);

		Step_Start(10, "Click the show total summary option.", test, test1);

		waitForElement(driver, Show_Total_Summary);
		click(driver, Show_Total_Summary);

		Step_End(10, "Click the show total summary option.", test, test1);

		Step_Start(11, "Select the required summary by. like Currency,Vendor and Main Activity", test, test1);

		waitForElement(driver, vendor_Raido_Button);
		click(driver, vendor_Raido_Button);
		waitForElement(driver, Show_Total_rows);
		click(driver, Show_Total_rows);
		waitForElement(driver, Show_Total_rows);
		List<WebElement> rows = listOfElements(driver, Show_Total_rows);
		List<Map<String, String>> vendor_Tabel = getTableData(driver, Show_Total_Headers, Show_Total_rows);
		Map<String, List<String>> Vendor_Map = new HashMap<>();
		int rowcount = rows.size();
		for (int i = 1; i <= rowcount; i++) {
			String Currncy_Column = String.format(Show_Total_Second_Column, i);
			String Amount_value = String.format(Show_Total_Amount_value, i);
			addToMap(Vendor_Map, getText(driver, Currncy_Column), getAttribute(driver, Amount_value, "value"));

		}

		waitForElement(driver, Show_Total_Main_Activity);
		click(driver, Show_Total_Main_Activity);
		waitForElement(driver, Show_Total_rows);
		click(driver, Show_Total_rows);
		waitForElement(driver, Show_Total_rows);
		List<WebElement> rows1 = listOfElements(driver, Show_Total_rows);
		List<Map<String, String>> Activity_Table = getTableData(driver, Show_Total_Headers, Show_Total_rows);
		int rowcount1 = rows1.size();
		Map<String, List<String>> Main_Activity_Map = new HashMap<>();
		for (int i = 1; i <= rowcount1; i++) {
			String Currncy_Column = String.format(Show_Total_Second_Column, i);
			String Amount_value = String.format(Show_Total_Amount_value, i);
			addToMap(Main_Activity_Map, getText(driver, Currncy_Column), getAttribute(driver, Amount_value, "value"));
		}
		waitForElement(driver, Currency_option);
		click(driver, Currency_option);
		waitForElement(driver, Show_Total_rows);
		click(driver, Show_Total_rows);
		waitForElement(driver, Show_Total_rows);
		List<WebElement> rows2 = listOfElements(driver, Show_Total_rows);
		Map<String, List<String>> currency_Map = new HashMap<>();
		int rowcount2 = rows2.size();
		for (int i = 1; i <= rowcount2; i++) {
			String Currncy_Column = String.format(Show_Total_First_Column, i);
			String Amount_value = String.format(Show_Total_Amount_value, i);
			addToMap(currency_Map, getText(driver, Currncy_Column), getAttribute(driver, Amount_value, "value"));
		}

		Step_End(11, "Select the required summary by. like Currency,Vendor and Main Activity", test, test1);

		Step_Start(12, "Click on the ok option.", test, test1);

		waitForElement(driver, Show_Total_Summary_Ok);
		click(driver, Show_Total_Summary_Ok);

		Step_End(12, "Click on the ok option.", test, test1);

		Step_Start(13,
				"Ensure that the amount are shown based on the selected summary by option and compare the data with the AG grid amount which is available in the AG grid.",
				test, test1);

		waitForElement(driver, MSC_Column_Filt_CAR);
		click(driver, MSC_Column_Filt_CAR);

		waitForElement(driver, MSC_Filter_input_CAR);
		jsClick(driver, MSC_SelectAll_Checkbox_CAR);

		List<String> ExpensiveTable_Headers = splitAndExpand(Header_value);
		for (String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, MSC_Filter_input_CAR);
			clear(driver, MSC_Filter_input_CAR);
			waitForElement(driver, MSC_Filter_input_CAR);
			sendKeys(driver, MSC_Filter_input_CAR, FilterHeader);

			String checkbox = String.format(Select_Column_MSC_CAR, FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}

		waitForElement(driver, MSC_Column_Filt_CAR);
		jsClick(driver, MSC_Column_Filt_CAR);
		waitForDisplay(driver, Misc_Total_Records);
		String totalrecords = getText(driver, Misc_Total_Records);
		int row_count = Integer.parseInt(totalrecords);

		waitForElement(driver, Misc_Table);
		List<Map<String, String>> table_Data = extractTableDataByRowIndex(driver, Misc_Table, row_count);
		List<String> currency_Values = getValuesByHeader(table_Data, "Currency");
		List<String> Amount_Values = getValuesByHeader(table_Data, "Amount with STX");
		System.out.println("table_Data : " + table_Data);
		Map<String, String> actualvalues = sumCurrencyValues(currency_Values, Amount_Values);
		System.out.println("actualvalues : " + actualvalues);
		if (compareMaps(actualvalues, currency_Map)) {

			System.out.println("Extected : " + currency_Map + " Actual : " + actualvalues);
			Extent_pass_New(driver,
					"Matched || " + " Expected Value is : " + currency_Map + " || Actual Value is : " + actualvalues,
					test, test1);
		} else {
			System.out.println("Not Extected : " + currency_Map + " Actual : " + actualvalues);
			Extent_fail(driver,
					"Matched || " + " Expected Value is : " + currency_Map + " || Actual Value is : " + actualvalues,
					test, test1);
		}
		

		List<String> vendor_Values = getValuesByHeader(vendor_Tabel, "Vendor");
		for (int i = 0; i < vendor_Values.size(); i++) {
			String curencu_Value = getValueByFirstColumnAndHeader(vendor_Tabel, "Vendor", vendor_Values.get(i),
					"Currency");
			List<String> actualAmount = getValuesByFirstAndSecondColumn(table_Data, "Vendor Name", vendor_Values.get(i),
					"Currency", curencu_Value, "Amount with STX");

			List<String> vendorTotalAmounts = Vendor_Map.get(curencu_Value);
			String actualSumAMount = sumAndConvertToString(actualAmount
					);
			System.out.println("actualSumAMount :"+actualSumAMount);
			
			if (vendorTotalAmounts.get(i).equals(actualSumAMount)) {
				System.out.println("Extected : " + vendorTotalAmounts.get(i) + " Actual : " + actualSumAMount);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + vendorTotalAmounts
						+ " || Actual Value is : " + actualSumAMount, test, test1);
			} else {
				System.out.println("Not Extected : " + vendorTotalAmounts.get(i) + " Actual : " + actualSumAMount);
				Extent_fail(driver, "Matched || " + " Expected Value is : " + vendorTotalAmounts
						+ " || Actual Value is : " + actualSumAMount, test, test1);

			}
		}
		
		List<String> activity_Values = getValuesByHeader(Activity_Table, "Activity");
		for (int i = 0; i < activity_Values.size(); i++) {
			String curencu_Value = getValueByFirstColumnAndHeader(Activity_Table, "Activity", activity_Values.get(i),
					"Currency");
			List<String> actualAmount = getValuesByFirstAndSecondColumn(table_Data, "Activity", activity_Values.get(i),
					"Currency", curencu_Value, "Amount with STX");

			List<String> activityTotalAmounts = Main_Activity_Map.get(curencu_Value);
			String actualSumAMount = sumAndConvertToString(actualAmount);
			if (activityTotalAmounts.get(i).equals(actualSumAMount)) {
				System.out.println("Extected : " + activityTotalAmounts.get(i) + " Actual : " + actualSumAMount);
				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + activityTotalAmounts
						+ " || Actual Value is : " + actualSumAMount, test, test1);
			} else {
				Extent_fail(driver, "Matched || " + " Expected Value is : " + activityTotalAmounts
						+ " || Actual Value is : " + actualSumAMount, test, test1);
				System.out.println("Not Extected : " + activityTotalAmounts.get(i) + " Actual : " + actualSumAMount);

			}
		}

		Step_End(13,
				"Ensure that the amount are shown based on the selected summary by option and compare the data with the AG grid amount which is available in the AG grid.",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}
}
