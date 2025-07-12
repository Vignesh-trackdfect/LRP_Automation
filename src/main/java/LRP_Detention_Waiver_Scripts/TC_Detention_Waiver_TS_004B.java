package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_004B extends Keywords {
	public void Detention_Waiver_TS_004B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_004B";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String Bill_of_landing = Excel_data.get("Bill_Module");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String BL_Number_Search_Type_DET = Excel_data.get("BL_Number_Search_Type");
		String B_Number_DET = Excel_data.get("BL_Number");
		String BL_No = Excel_data.get("BL_No");
		String DW_Headers = Excel_data.get("DW_Headers");
		String BL_Headers = Excel_data.get("BL_Headers");
		
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String WaiverOption = Excel_data.get("Weiver_For");

		List<String> detentionwaiver_Headers = splitAndExpand(DW_Headers, ",");

		List<String> Bill_Of_Lading_Headers = splitAndExpand(BL_Headers, ",");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);
		
		Step_Start(1, "Open Detention weiver Module", test, test1);
		
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);
		newButton(driver);

		String Waiveroption = String.format(DW_WaiverOption, WaiverOption);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);

		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);

		Step_Start(2, ". Click on BL No Search Field ", test, test1);

		waitForDisplay(driver, DW_BookingNo_Search);
		if (isElementEnabled(driver, DW_BookingNo_Search)) {
			System.out.println(
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled",
					test, test1);
			click(driver, DW_BookingNo_Search);
		} else {
			System.out.println(
					"Fail || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is not enabled",
					test, test1);
		}

		Step_End(2, ". Click on BL No Search Field ", test, test1);
		Step_Start(3, "Input your Confirm BL No", test, test1);
		Step_Start(4, "Click on show Button", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, BL_Number_Search_Type_DET, B_Number_DET, "", "", "", "");
		
		
		
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		Step_End(3, "Input your Confirm BL No", test, test1);
		Step_End(4, "Click on show Button", test, test1);
		Step_Start(5, "Verify that customer detail tab shows customer information match with bl/mcn module", test,
				test1);
		Step_Start(6, "Verify that Container List filed system shows Container list match with bl/mcn module", test,
				test1);

		// scrollBottom(driver);

		waitForElement(driver, DW_Customer_details_heading);
		List<Map<String, String>> Table_value_Det = getTableDatawithscroll(driver, DW_Customer_details_heading,
				DW_Customer_details_value, DW_Customer_details_Scroll, 190, 1500);

		List<List<String>> DW_Table = getValuesByHeaders(Table_value_Det, detentionwaiver_Headers);
		String Actual_DW_Table = TableDataForReport(driver, Table_value_Det, "Detention Waiver Customer Table",
				detentionwaiver_Headers);
	
		Extent_pass_New(driver,
				"Matched || The Expected Detention waiver Module Table <pre>" + Actual_DW_Table
						+ "</pre>",
				test, test1);
		
		
		waitForElement(driver, DW_Container_Table);

		

		Step_End(5, "Verify that customer detail tab shows customer information match with bl/mcn module", test, test1);
		Step_Start(1, "Open Bill of Lading Module", test, test1);
		
		moduleNavigate(driver, Bill_of_landing);
		Step_End(1, "Open Bill of Lading Module", test, test1);

	


		newButton(driver);
	


		Step_Start(2, ". Click on BL No Search Field ", test, test1);

		waitForDisplay(driver, SearchButton_Toolbar);
		if (isElementEnabled(driver, SearchButton_Toolbar)) {
			System.out.println(
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled",
					test, test1);
			mouseOverToElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
		} else {
			System.out.println(
					"Fail || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is not enabled",
					test, test1);
		}

		Step_End(2, ". Click on BL No Search Field ", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, BL_No, B_Number_DET, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);
		Step_End(4, "Click on show Button", test, test1);
		Step_Start(5, "Verify that customer detail tab shows customer information match with bl/mcn module", test,
				test1);
		Step_Start(6, "Verify that Container List filed system shows Container list match with bl/mcn module", test,
				test1);

		List<Map<String, String>> TableValueBill = new ArrayList<>();
		List<Map<String, String>> cantainerTable_value_bill = new ArrayList<>();

		waitForDisplay(driver, bl_MCN_Approved_Value);
		if (isdisplayed(driver, bl_MCN_Approved_Value)) {
			doubleClick(driver, bl_MCN_Approved_Value);
			waitForElement(driver, customer_Tab_MCN);
			click(driver, customer_Tab_MCN);
			TableValueBill = getTableData(driver, MCN_Customer_Table_Headers, MCN_Customer_Table_Rows);
			waitForElement(driver, customer_Tab_MCN);
			click(driver, customer_Tab_MCN);
		} else {
			click(driver, customer_tab);
			scrollBottom(driver);
			waitForElement(driver, BL_Customer_details_heading);
			TableValueBill = getTableData(driver, BL_Customer_details_heading, BL_Customer_details_value);
			waitForElement(driver, customer_tab);
			click(driver, customer_tab);
		}
		for (Map<String, String> rowData : TableValueBill) {
			// Iterate over each column in the row
			for (Map.Entry<String, String> entry : rowData.entrySet()) {
				String cellValue = entry.getValue();

				// Replace values based on the required mapping
				if (cellValue != null) {
					if (cellValue.equals("AP")) {
						entry.setValue("Agreement Party");
					} else if (cellValue.equals("CN")) {
						entry.setValue("Consignee");
					} else if (cellValue.equals("NT")) {
						entry.setValue("Notify");
					} else if (cellValue.equals("SH")) {
						entry.setValue("Shipper");
					}
				}
			}
		}

		
		List<List<String>> Bl_Table = getValuesByHeaders(TableValueBill, Bill_Of_Lading_Headers);
		String Actual_BL_Table = TableDataForReport(driver, TableValueBill, "Bill Of Lading (or) MCN Customer Table",
				Bill_Of_Lading_Headers);

		if (compareTableDataContainsValues(Bl_Table, DW_Table)) {
			Extent_pass_New(driver,
					"Matched || The Expected Bill of Lading Module Table <pre>" + Actual_BL_Table
							+ "</pre> || Actual Detention waiver Customer Table : <pre>" + Actual_DW_Table + "</pre>",
					test, test1);
		} else {
			Extent_fail(driver,
					"Not Matched || The Expected Bill of Lading Module Table <pre>" + Actual_BL_Table
							+ "</pre> || Actual Detention waiver Customer Table : <pre>" + Actual_DW_Table + "</pre>",
					test, test1);
		}

		Step_End(5, "Verify that customer detail tab shows customer information match with bl/mcn module", test, test1);
		Step_End(6, "Verify that Container List filed system shows Container list match with bl/mcn module", test,
				test1);

	

		Extent_completed(testcase_Name, test, test1);

	}

}
