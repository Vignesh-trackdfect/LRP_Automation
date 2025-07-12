package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_004C extends Keywords {
	public void Detention_Waiver_TS_004C(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_004C";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String Bill_of_landing = Excel_data.get("Bill_Module");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String BL_Number_Search_Type_DET = Excel_data.get("BL_Number_Search_Type");
		String B_Number_DET = Excel_data.get("BL_Number");
		String BL_No = Excel_data.get("BL_No");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String WaiverOption = Excel_data.get("Weiver_For");
		
		String DW_Container_Headers = Excel_data.get("DW_Container_Headers");
		String BL_Container_Headers = Excel_data.get("BL_Container_Headers");

		List<String> detentionwaiver_ContainerHeaders = splitAndExpand(DW_Container_Headers, ",");

		List<String> Bill_Of_Lading_ContainerHeaders = splitAndExpand(BL_Container_Headers, ",");

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

		Step_End(3, "Input your Confirm BL No", test, test1);
		Step_End(4, "Click on show Button", test, test1);
		Step_Start(5, "Verify that Container List filed system shows Container list match with bl/mcn module", test,
				test1);
		
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		waitForElement(driver, DW_Customer_details_heading);


		scrollBottom(driver);
		waitForElement(driver, DW_Container_Table);
		List<Map<String, String>> Table_ContainerValue_Det = extractTableDataCountMissMatch(driver, DW_Container_Table);

		List<List<String>> DW_ContainerTable = getValuesByHeaders(Table_ContainerValue_Det,
				detentionwaiver_ContainerHeaders);
		String Actual_DW_ContainerTable = TableDataForReport(driver, Table_ContainerValue_Det,
				"Detention Waiver Container Table", detentionwaiver_ContainerHeaders);
		
		Extent_pass_New(driver,
				"Matched || The Expected Detention waiver Module Table <pre>" + Actual_DW_ContainerTable
						+ "</pre>",
				test, test1);
		
		Step_Start(1, "open billof lading module", test, test1);

		moduleNavigate(driver, Bill_of_landing);

		Step_End(1, "open billof lading module", test, test1);

		newButton(driver);


		Step_Start(2, ". Click on BL No Search Field ", test, test1);

		waitForDisplay(driver, BL_search_btn);
		if (isElementEnabled(driver, BL_search_btn)) {
			System.out.println(
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : BL Number search button should be enabled || Actual result is : BL Number search button is enabled",
					test, test1);
			mouseOverToElement(driver, BL_search_btn);
			click(driver, BL_search_btn);
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
			waitForElement(driver, Manifest_Container_Tab);
			click(driver, Manifest_Container_Tab);
			cantainerTable_value_bill = getTableData(driver, MCN_Container_Table_Headers, MCN_Container_Table_Rows);
			waitForElement(driver, Manifest_Container_Tab);
			click(driver, Manifest_Container_Tab);
		} else {
			waitForElement(driver, bl_Container_Tab);
			click(driver, bl_Container_Tab);
			scrollBottom(driver);
			waitForElement(driver, bl_container_header_value);
			cantainerTable_value_bill = getTableData(driver, bl_container_header_value, bl_container_details_value);
			waitForElement(driver, bl_Container_Tab);
			click(driver, bl_Container_Tab);
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

//		List<List<String>> Bl_Table = getValuesByHeaders(TableValueBill, Bill_Of_Lading_Headers);
//		String Actual_BL_Table = TableDataForReport(driver, TableValueBill, "Bill Of Lading (or) MCN Customer Table",
//				Bill_Of_Lading_Headers);

		
		List<List<String>> Bl_ContainerTable = getValuesByHeaders(cantainerTable_value_bill,
				Bill_Of_Lading_ContainerHeaders);
		String Actual_BL_ContainerTable = TableDataForReport(driver, cantainerTable_value_bill,
				"Bill Of Lading (or) MCN Container Table", Bill_Of_Lading_ContainerHeaders);

		scrollTop(driver);

		Step_End(5, "Verify that customer detail tab shows customer information match with bl/mcn module", test, test1);
		Step_End(6, "Verify that Container List filed system shows Container list match with bl/mcn module", test,
				test1);

	
		if (compareTableDataContains(Bl_ContainerTable, DW_ContainerTable)) {
			Extent_pass_New(driver,
					"Matched || The Expected Bill of Lading Module Container Table <pre>" + Actual_BL_ContainerTable
							+ "</pre> || Actual Detention waiver Container Table : <pre>" + Actual_DW_ContainerTable
							+ "</pre>",
					test, test1);
		} else {
			Extent_fail(driver,
					"Not Matched || The Expected Bill of Lading Module Container Table <pre>" + Actual_BL_ContainerTable
							+ "</pre> || Actual Detention waiver Container Table : <pre>" + Actual_DW_ContainerTable
							+ "</pre>",
					test, test1);
		}

		Step_End(5, "Verify that Container List filed system shows Container list match with bl/mcn module", test,
				test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
