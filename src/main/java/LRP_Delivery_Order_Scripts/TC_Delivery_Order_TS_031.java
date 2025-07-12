package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_031  extends Keywords{
	public void Delivery_Order_TS_031(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_031";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String bl_Number=Excel_data.get("BL_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String DO_POP_EXP = Excel_data.get("DO_POP_EXP");
		String status_exp = Excel_data.get("status_exp");
		String value_Back = Excel_data.get("value_Back");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Select_search_value_IMD = Excel_data.get("Select_search_value_IMD");
		String Import_checkbox_status = Excel_data.get("Import_checkbox_status");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "1.Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "1.Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description, value);
		// DELIVERY MODULE
		Step_Start(5, "Open Delivery order module ", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open Delivery order module ", test, test1);
		Step_Start(6, "Click new button ", test, test1);
		newButton(driver);
		Step_End(6, "Click new button ", test, test1);
		Step_Start(7, "Click the \" ADD \" Button ", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the \" ADD \" Button ", test, test1);
		Step_Start(8, "Paste the BL and click search  ", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, Select_search_value, bl_Number, "", "", "", "");
		Step_End(8, "Paste the BL and click search  ", test, test1);
		Step_Start(9, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_show);
		doubleClick(driver, DO_show);
		Step_End(9, "Click the SHOW button", test, test1);
		Step_Start(10, "Select the container details in below grid", test, test1);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(10, "Select the container details in below grid", test, test1);
		Step_Start(11, "Click the Save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(11, "Click the Save button ", test, test1);
		Step_Start(12, "Ensure system validated as  \"BL not issued \" ", test, test1);
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
					"NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_fail(driver,
					"NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT,
					test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_End(12, "Ensure system validated as  \"BL not issued \" ", test, test1);
		Step_Start(13, "Open import documentation module ", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(13, "Open import documentation module ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_Start(14, "Click search button and paste the Bl", test, test1);
		Step_Start(15, "Fetch the Bl", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, Select_search_value_IMD, bl_Number, "", "", "", "");
		Step_End(15, "Fetch the Bl", test, test1);
		Step_End(14, "Click search button and paste the Bl", test, test1);
		Step_Start(16, "Copy the BL status and display", test, test1);
		waitForElement(driver, BL_Status_Value_IMP_DOC);
		String status_act = getText(driver, BL_Status_Value_IMP_DOC);
		if (status_exp.equals(status_act)) {
			System.out.println(
					"Matched || Expected value was : " + status_exp + " || Actual value was : " + status_act);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + status_exp + " || Actual value was : " + status_act, test,
					test1);
		} else {
			System.out.println(
					"NotMatched || Expected value was : " + status_exp + " || Actual value was : " + status_act);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + status_exp + " || Actual value was : " + status_act,
					test, test1);
		}
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		waitForElement(driver, Import_receipt_Checkbox);
		String status_check_receipt = getAttribute(driver, Import_receipt_Checkbox,"class");
		System.out.println(status_check_receipt);
		String status_check_import = getAttribute(driver, Import_Invoice_Checkbox,"class");
		System.out.println(status_check_import);
		if (status_check_import.contains(Import_checkbox_status)) {
			System.out.println("Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox is active");
			Extent_pass_New(driver, "Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox is active", test, test1);
		} else {
			System.out.println("Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox is Not active");
			Extent_fail(driver, "Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox is Not active", test, test1);
		}
		if (status_check_receipt.contains(Import_checkbox_status)) {
			System.out.println("Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox is active");
			Extent_call(test, test1, "Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox is active");
		} else {
			System.out.println("Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox is Not active");
			Extent_fail(driver, "Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox is Not active", test, test1);
		}
		Step_End(16, "Copy the BL status and display", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// Agency Configuration
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description, value_Back, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}