package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_032  extends Keywords{
	public void Delivery_Order_TS_032(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_032";
		
		




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
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String status_exp = Excel_data.get("status_exp");
		String Import_checkbox_status = Excel_data.get("Import_checkbox_status");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String value_Return = Excel_data.get("value_Return");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		moduleNavigate(driver, ImportDocumentationModule);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, Select_search_value_import, bl_Number, "", "", "", "");
		waitForElement(driver, BL_Status_Value_IMP_DOC);
		String status_act = getText(driver, BL_Status_Value_IMP_DOC);
		if (status_exp.equals(status_act)) {
			System.out.println("Matched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act);
			Extent_pass_New(driver,"Matched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act, test,test1);
		} else {
			System.out.println("NotMatched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act);
			Extent_fail(driver,"NotMatched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act,test, test1);
		}
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		String status_check_receipt = getAttribute(driver, Import_receipt_Checkbox,"class");
		System.out.println(status_check_receipt);
		String status_check_import = getAttribute(driver, Import_Invoice_Checkbox,"class");
		System.out.println(status_check_import);
		if (status_check_receipt.contains(Import_checkbox_status)) {
			System.out.println("Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_receipt);
			Extent_pass_New(driver,"Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_receipt, test,test1);
			Extent_call(test, test1, "****receipt checkbox was  active***");
		} else {
			System.out.println("Not Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_receipt);
			Extent_pass_New(driver,"Not Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_receipt, test,test1);
		}
		if (status_check_import.contains(Import_checkbox_status)) {
			System.out.println(
					"Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_import);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_import, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_import);
			Extent_fail(driver,
					"Not Matched || Expected value was : " + Import_checkbox_status + " || Actual value was : " + status_check_import, test,
					test1);
		}
		Step_Start(5, "Open Delivery order module", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// DELIVERY MODULE
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, "Click new button ", test, test1);
		
		newButton(driver);
		Step_End(6, "Click new button ", test, test1);
		Step_Start(7, "Click the \" ADD \" Button  ", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the \" ADD \" Button  ", test, test1);
		Step_Start(8, "paste the BL number and click search ", test, test1);
		waitForElement(driver, globalSearch_Frame_SearchButton);
		click(driver, globalSearch_Frame_SearchButton);
		Step_End(8, "paste the BL number and click search ", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, Select_search_value, bl_Number, "", "", "", "");
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
		Step_Start(12, "Ensure delivery order saved. ", test, test1);
		waitForPopup(driver,Popup_Message,DO_POP_EXP);
		String DO_POP_ACT = getText(driver, Popup_Message);
		if (DO_POP_EXP.equals(DO_POP_ACT)) {
			System.out.println(
					"Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_pass_New(driver,
					"Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT, test,
					test1);
			Extent_call(test, test1, DO_POP_ACT);
		} else {
			System.out.println(
					"NotMatched || Expected Pop-up value is: " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_fail(driver,
					"NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT,
					test, test1);
		}
		Step_End(12, "Ensure delivery order saved. ", test, test1);
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
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}
			Step_End(16, "Ensure system validated as 'Delivery order deleted'", test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// Agency Configuration
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, value_Return, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}