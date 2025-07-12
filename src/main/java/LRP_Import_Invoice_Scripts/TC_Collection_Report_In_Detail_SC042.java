package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Import_Invoice_Locators;

public class TC_Collection_Report_In_Detail_SC042 extends Keywords {

	public void Collection_Report_In_DetailSC42(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException {

		String testcase_Name = "TC_Collection_Report_In_Detail_SC042";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Collection_Report_Module = Excel_data.get("Collection_Report_Module");
		String date_Picker = Excel_data.get("date_Picker");
		String To_date = Excel_data.get("To_date");
		String From_date = Excel_data.get("From_date");
		String Report_By_Select_Input = Excel_data.get("Report_By_Select_Input");
		String Report_Charge_Type_Select = Excel_data.get("Report_Charge_Type_Select");
		String Report_Charge_Category_Type_Select = Excel_data.get("Report_Charge_Category_Type_Select");
		String exclude_Adv_Receipt_CheckBox = Excel_data.get("exclude_Adv_Receipt_CheckBox");
		String scope_Select = Excel_data.get("scope_Select");
		String no_Record_Popup = Excel_data.get("no_Record_Popup");

		
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Region_Header = Excel_data.get("Region_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		// Login
		LRP_Login(driver, Username, Password);

		// Switch Agency
		verifyMainMenu(driver);
		if (!AgencyUser.equalsIgnoreCase("")) {
			Step_Start(1, "Switch to Agency/Line", test, test1);
			SwitchProfile(driver, AgencyUser);
			Step_End(1, "Switch to Agency/Line", test, test1);
		}

		
		Step_Start(2, "Open Collection Report in Details module", test, test1);
		moduleNavigate(driver, Collection_Report_Module);
		Step_End(2, "Open Collection Report in Details module", test, test1);

		Step_Start(3, "Input All The Entry from Test Data", test, test1);

		newButton(driver);

		waitForElement(driver, collection_Report_By_Dropdown);
		if (!Report_By_Select_Input.trim().equals("")) {
			click(driver, collection_Report_By_Dropdown);
			formatLocatorClick(driver, DropDown_Select, Report_By_Select_Input);

		}
		
		if(AgencyUser.trim().equals("")) {
			if(!scope_Select.trim().equals("")) {
				waitForElement(driver, collection_Report_Scope_Dropdown);
				click(driver, collection_Report_Scope_Dropdown);
				formatLocatorClick(driver, DropDown_Select, scope_Select);
			}
			
			if (scope_Select.equalsIgnoreCase("Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}
			if (scope_Select.equalsIgnoreCase("Region")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, Region_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}
			if (scope_Select.equalsIgnoreCase("Corporate Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}
		}

		if (Report_By_Select_Input.equalsIgnoreCase("Charges")) {

			if (!Report_Charge_Type_Select.trim().equals("")) {
				waitForElement(driver, collection_Report_Charge_Type_Dropdown);
				click(driver, collection_Report_Charge_Type_Dropdown);
				String Report_Charge_Select = String.format(Import_Invoice_Locators.collection_Report_Charge_Select,
						Report_Charge_Type_Select);
				waitForElement(driver, Report_Charge_Select);
				click(driver, Report_Charge_Select);
			}

			if (!Report_Charge_Category_Type_Select.trim().equals("")) {
				waitForElement(driver, collection_Report_Charge_Category_Dropdown);
				click(driver, collection_Report_Charge_Category_Dropdown);
				String Report_Charge_Category_Select = String.format(Import_Invoice_Locators.collection_Report_Charge_Category_Select,
						Report_Charge_Category_Type_Select);
				waitForElement(driver, Report_Charge_Category_Select);
				click(driver, Report_Charge_Category_Select);
			}

			checkBox(driver, Exclude_Advance_Receipt_CheckBox, exclude_Adv_Receipt_CheckBox);
		}
		
		if(!From_date.trim().equals("")) {
			waitForElement(driver, collection_Report_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, collection_Report_From_Date, From_date);
			} else {
				waitForElement(driver, collection_Report_From_Date);
				clearAndType(driver, collection_Report_From_Date, From_date);
			}
		}
		
		if(!To_date.trim().equals("")) {
			waitForElement(driver, collection_Report_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, collection_Report_To_Date, To_date);
			} else {
				waitForElement(driver, collection_Report_To_Date);
				clearAndType(driver, collection_Report_To_Date, To_date);
			}
		}
		
		Step_End(3, "Input All The Entry from Test Data", test, test1);

		Step_Start(4, "Click on Show Button", test, test1);
		waitForElement(driver, collection_Report_Show_Button);
		click(driver, collection_Report_Show_Button);
		Step_End(4, "Click on Show Button", test, test1);

		if (isdisplayed(driver, popup)) {
			String act_Popup = getText(driver, popup);
			if (no_Record_Popup.equals(act_Popup)) {
				System.out.println(act_Popup+ "Expected || Popup should not displayed || Actual : Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs");
				Extent_FailNew(driver,	"Expected || Popup should not displayed || Actual : " + act_Popup
								+ " Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs",
						test, test1);
			}else {
				System.out.println(act_Popup+ "Expected || Popup should not displayed || Actual : Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs");
				Extent_fail(driver,	"Expected || Popup should not displayed || Actual : " + act_Popup
								+ " Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs",
						test, test1);
			}
		}
		
		Step_Start(5, "Get the Rows Count", test, test1);
		waitForElement(driver, collection_Report_Total_Records);
		String TotalRecordValue = getText(driver, collection_Report_Total_Records);
		int TotalRecords_Application = Integer.parseInt(TotalRecordValue);
		System.out.println("TotalRecords_Application :" + TotalRecords_Application);
		Step_End(5, "Get the Rows Count", test, test1);
		if (TotalRecords_Application != 0) {

			waitForElement(driver, MoreOption_Grid);
			click(driver, MoreOption_Grid);
			Step_Start(6, "Download the Excel and Verify the same Count", test, test1);

			waitForElement(driver, II_Download_Excel_Xlsx);
			String downlaoad_Path = downloadFile(driver, II_Download_Excel_Xlsx);

			int row_Count = countNonEmptyRows(downlaoad_Path);
			int TotalRecordsCount_Excel = row_Count - 1;

			if (TotalRecords_Application == TotalRecordsCount_Excel) {
				System.out.println("Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in Excel : " + TotalRecordsCount_Excel);
				Extent_pass_New(driver, "Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in Excel : " + TotalRecordsCount_Excel, test, test1);
			} else {
				System.out.println("Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in Excel : " + TotalRecordsCount_Excel);
				Extent_fail(driver, "Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in Excel : " + TotalRecordsCount_Excel, test, test1);
			}
		} else {
			System.out.println("Expected : Records Should not be '0' in the Grid || Actual : Total Record is '0' in the Grid");
			Extent_FailNew(driver, "Expected : Records Should not be '0' in the Grid || Actual : Total Record is '0' in the Grid", test, test1);
		}
		Step_End(6, "Download the Excel and Verify the same Count", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
