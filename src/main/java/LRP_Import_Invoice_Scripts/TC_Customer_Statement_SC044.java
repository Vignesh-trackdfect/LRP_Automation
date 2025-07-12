package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Customer_Statement_SC044 extends Keywords {

	public void Customer_Statement_SC044(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException {

		String testcase_Name = "TC_Customer_Statement_SC044";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String customer_Statement_Report_Module = Excel_data.get("customer_Statement_Report_Module");
		String Invoice_type_Input_Select = Excel_data.get("Invoice_type_Input_Select");
		String charge_type_Input_Select = Excel_data.get("charge_type_Input_Select");
		String scope_type_Input_Select = Excel_data.get("scope_type_Input_Select");
		String customer_group_Input = Excel_data.get("customer_group_Input");
		String BL_Condition = Excel_data.get("BL_Condition");
		String customer_Search_Filter = Excel_data.get("customer_Search_Filter");
		String From_date = Excel_data.get("From_date");
		String date_Picker = Excel_data.get("date_Picker");
		String To_date = Excel_data.get("To_date");
		String Input_Select_Radio_Button = Excel_data.get("Input_Select_Radio_Button");
		String checkBox_Aging_Bucket = Excel_data.get("checkBox_Aging_Bucket");
		String checkBox_Summary = Excel_data.get("checkBox_Summary");
		String no_Record_Popup = Excel_data.get("no_Record_Popup");

		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		// Login
		LRP_Login(driver, Username, Password);

		// Switch Agency
		verifyMainMenu(driver);

		Step_Start(1, "Customer statement Can be loaded in Agency/Line/Corproate", test, test1);

		if (!AgencyUser.equalsIgnoreCase("")) {
			SwitchProfile(driver, AgencyUser);
		}

		Step_End(1, "Customer statement Can be loaded in Agency/Line/Corproate", test, test1);

		Step_Start(1, "Open the Module", test, test1);
		moduleNavigate(driver, customer_Statement_Report_Module);
		Step_End(1, "Open the Module", test, test1);

		newButton(driver);

		if (!Invoice_type_Input_Select.equals("")) {
			waitForElement(driver, customer_Statement_Invoice_Type_Dropdown);
			click(driver, customer_Statement_Invoice_Type_Dropdown);
			String Invoice_Type_Select = String.format(DropDown_Select, Invoice_type_Input_Select);
			waitForElement(driver, Invoice_Type_Select);
			click(driver, Invoice_Type_Select);
		}

		if (!charge_type_Input_Select.equals("")) {
			waitForElement(driver, customer_statement_Charge_Type_Dropdown);
			click(driver, customer_statement_Charge_Type_Dropdown);
			String charge_Type_Select = String.format(DropDown_Select, charge_type_Input_Select);
			waitForElement(driver, charge_Type_Select);
			click(driver, charge_Type_Select);
		}

		
		if (AgencyUser.trim().equalsIgnoreCase("")) {
			if (!scope_type_Input_Select.equals("")) {
				waitForElement(driver, customer_statement_Scope_Select);
				click(driver, customer_statement_Scope_Select);
				String scope_Type_Select = String.format(DropDown_Select, scope_type_Input_Select);
				waitForElement(driver, scope_Type_Select);
				click(driver, scope_Type_Select);
			}
			
			if(scope_type_Input_Select.equals("Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);			
			}
			
			if(scope_type_Input_Select.equals("Corporate Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);		
			}
			
		}
		

			Step_Start(3, "Customer can be input using , By Group", test, test1);
			waitForElement(driver, By_Group_Radio_Button);
			click(driver, By_Group_Radio_Button);

			waitForElement(driver, customer_Group_Name_Search_Button);
			click(driver, customer_Group_Name_Search_Button);

			globalValueSearchWindow(driver, BL_Condition, customer_Search_Filter, customer_group_Input, "", "", "", "");

			waitForElement(driver, customer_Group_Plus_button);
			click(driver, customer_Group_Plus_button);
			Step_End(3, "Customer can be input using , By Group", test, test1);

		Step_Start(4, "Enter the From Date and To Date,/As On date", test, test1);

		String input_Radio_Btn = String.format(input_Selection_Radio_Button, Input_Select_Radio_Button);
		waitForElement(driver, input_Radio_Btn);
		click(driver, input_Radio_Btn);

		checkBox(driver, Aging_Bucket_CheckBox, checkBox_Aging_Bucket);
		checkBox(driver, summary_CheckBox, checkBox_Summary);
		
		if(!From_date.trim().equals("")) {
			waitForElement(driver, customer_Statement_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, customer_Statement_From_Date, From_date);
			} else {
				waitForElement(driver, customer_Statement_From_Date);
				clearAndType(driver, customer_Statement_From_Date, From_date);
			}
			
		}
		if(!To_date.trim().equals("")) {
			waitForElement(driver, customer_Statement_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, customer_Statement_To_Date, To_date);
			} else {
				waitForElement(driver, customer_Statement_To_Date);
				clearAndType(driver, customer_Statement_To_Date, To_date);
			}
		}
		Step_End(4, "Enter the From Date and To Date,/As On date", test, test1);
		
		Step_Start(5, "Click on show button", test, test1);
		waitForElement(driver, customer_Statement_show_Button);
		click(driver, customer_Statement_show_Button);
		Step_End(5, "Click on show button", test, test1);

		waitForDisplay(driver, popup);
		if (isdisplayed(driver, popup)) {
			String act_Popup = getText(driver, popup);
			if (no_Record_Popup.equals(act_Popup)) {
				System.out.println(act_Popup+ "Expected || Popup should not displayed || Actual :  Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs");
				Extent_FailNew(driver,"Expected || Popup should not displayed || Actual : " + act_Popup
								+ " Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs",
						test, test1);
			}else {
				System.out.println(act_Popup+ "Expected || Popup should not displayed || Actual :  Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs");
				Extent_fail(driver,"Expected || Popup should not displayed || Actual : " + act_Popup
								+ " Pop-up is Displayed. The Inputs Are Not Valid . Kindly Give the valid inputs",
						test, test1);
			}
		}
		
		Step_Start(6, "Store the Total Records Count", test, test1);
		waitForElement(driver, customer_Statement_total_Records);
		String TotalRecordValue = getText(driver, customer_Statement_total_Records);
		int TotalRecords_Application = Integer.parseInt(TotalRecordValue);
		System.out.println("TotalRecords_Application :" + TotalRecords_Application);
		Step_End(6, "Store the Total Records Count", test, test1);
		Step_Start(7, "Download the File", test, test1);
		if (TotalRecords_Application != 0) {
			waitForElement(driver, Tool_Pannel_CSR);
			click(driver, Tool_Pannel_CSR);
			waitForElement(driver, Excel_Button);
			String downlaoad_Path = downloadFile(driver, Excel_Button);
			int row_Count = countNonEmptyRows(downlaoad_Path);
			int TotalRecordsCount_Excel = row_Count - 1;
			Step_End(7, "Download the File", test, test1);

			Step_Start(8, "Verify that Total Records count matched in Application and Excel", test, test1);
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
		Step_End(8, "Verify that Total Records count matched in Application and Excel", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
