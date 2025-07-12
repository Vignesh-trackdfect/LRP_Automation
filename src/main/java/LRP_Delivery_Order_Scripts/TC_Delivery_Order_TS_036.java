package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_036  extends Keywords{
	public void Delivery_Order_TS_036(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_036";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String bl_Number=Excel_data.get("BL_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String DO_POP_EXP = Excel_data.get("DO_POP_EXP");
		String globalSearchFilterdelivery = Excel_data.get("globalSearchFilterdelivery");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String globalSearchFilterimport = Excel_data.get("globalSearchFilterimport");
		String ID_Table_Name=Excel_data.get("ID_Table_Name");
		String ID_Table_Headers=Excel_data.get("ID_Charges_Table_Headers");
		String Import_checkbox_status = Excel_data.get("Import_checkbox_status");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("Set_As_Default");
		String configuration_Reset = Excel_data.get("configuration_Reset");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted_expected");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		// Import Documentation
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(5, "Open import documentation module ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterimport, bl_Number, "", "", "", "");
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		waitForElement(driver, Import_receipt_Checkbox);
		String status_check_receipt = getAttribute(driver, Import_receipt_Checkbox,"class");
		System.out.println(status_check_receipt);
		String status_check_import = getAttribute(driver, Import_Invoice_Checkbox,"class");
		System.out.println(status_check_import);
		if (status_check_import.contains(Import_checkbox_status)) {
			System.out.println("Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was  active");
			Extent_pass_New(driver, "Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was  active", test, test1);
		} else {
			System.out.println("Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was Not active");
			Extent_fail(driver, "Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was Not active", test, test1);
		}
		if (status_check_receipt.contains(Import_checkbox_status)) {
			System.out.println("Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was active");
			Extent_pass_New(driver, "Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was active", test, test1);
		} else {
			System.out.println("Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was Not active");
			Extent_fail(driver, "Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was Not active", test, test1);
		}
		waitForElement(driver, Prepaid_Charges_Tab);
		click(driver, Prepaid_Charges_Tab);
		scrollBottom(driver);
		waitForElement(driver, importDocumentation_PrepaidCharges_Rows);
		List<Map<String, String>> prepaid_Tabledata = getTableDatawithscroll(driver, importDocumentation_PrepaidCharges_Columns,importDocumentation_PrepaidCharges_Rows,prepaidCgarges_Tab_Scroll_IMD,80,-2000);
		List<String> columnheaders = splitAndExpand(ID_Table_Headers);
		String Charges_Tabledata = TableDataForReport(driver, prepaid_Tabledata,ID_Table_Name,columnheaders);
		Extent_pass_New(driver, "<pre>" +Charges_Tabledata + "</pre>", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// DELIVERY MODULE
		Step_Start(5, "Open Delivery order module", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, ".Click new button ", test, test1);
		newButton(driver);
		Step_End(6, ".Click new button ", test, test1);
		Step_Start(7, "Click the \" ADD \" Button ", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the \" ADD \" Button ", test, test1);
		Step_Start(8, "Paste the BL ,click search and fetch the record", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterdelivery, bl_Number, "", "", "", "");
		Step_End(8, "Paste the BL ,click search and fetch the record", test, test1);
		Step_Start(9, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_show);
		doubleClick(driver, DO_show);
		Step_End(9, "Click the SHOW button", test, test1);
		Step_Start(10, "Select the container details in below grid", test, test1);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(10, "Select the container details in below grid", test, test1);
		Step_Start(11, "Click the Save button ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(11, "Click the Save button ", test, test1);
		Step_Start(12, "Ensure that system validated as \" Delivery order saved \" ", test, test1);
		waitForPopup(driver,Popup_Message,DO_POP_EXP);
		String DO_POP_ACT = getText(driver, Popup_Message);
		if (DO_POP_EXP.equals(DO_POP_ACT)) {
			System.out.println("Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT, test,test1);
			Extent_call(test, test1, DO_POP_ACT);
		} else {
			System.out.println("NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_fail(driver,"NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT,test, test1);
		}
		Step_End(12, "Ensure that system validated as \" Delivery order saved \" ", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(13, "Click the Delete button ", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(13, "Click the Delete button ", test, test1);
			Step_Start(14, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}else {

				System.out.println("NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}
			Step_End(14, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(15, "Click Yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(15, "Click Yes", test, test1);
			Step_Start(16, "Ensure system validated as 'Delivery order deleted'", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if(deleted_expected.equals(do_Deleted_Actual)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"  || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"  || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"  || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"  || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}
			Step_End(16, "Ensure system validated as 'Delivery order deleted'", test, test1);
		}
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, configuration_Reset, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}