package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_033  extends Keywords{
	public void Delivery_Order_TS_033(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_033";
		
		


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
		String value_Back = Excel_data.get("value_Back");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String Select_search_value_delivery = Excel_data.get("Select_search_value_delivery");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Condition = Excel_data.get("Condition");
		String checkbox_Status = Excel_data.get("Checkbox_Status");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		Step_Start(5, "Open Delivery order module", test, test1);
		// DELIVERY MODULE
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, "Click new button ", test, test1);
		newButton(driver);
		Step_End(6, "Click new button ", test, test1);
		Step_Start(7, "Click the \" ADD \" Button ", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the \" ADD \" Button ", test, test1);
		Step_Start(8, "Paste the BL number and click search", test, test1);
		Step_Start(9, "Fetch the BL details", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, Select_search_value_delivery, bl_Number, "", "", "", "");
		Step_End(9, "Fetch the BL details", test, test1);
		Step_End(8, "Paste the BL number and click search", test, test1);
		Step_Start(10, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_show);
		doubleClick(driver, DO_show);
		Step_End(10, "Click the SHOW button", test, test1);
		Step_Start(12, "Select the container details in below grid", test, test1);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(12, "Select the container details in below grid", test, test1);
		Step_Start(13, "Click the Save button ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(13, "Click the Save button ", test, test1);
		Step_Start(14, "Ensure system validates Invoice /receipt details not found  ", test, test1);
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
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_End(14, "Ensure system validates Invoice /receipt details not found  ", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, Select_search_value_import, bl_Number, "", "", "", "");
		Step_Start(15, "Go to remarks tab", test, test1);
		waitForElement(driver, importDoc_RemarksTab);
		click(driver,importDoc_RemarksTab);
		Step_Start(15, "Go to remarks tab", test, test1);
		scrollBottom(driver);
		Step_Start(16, "Make sure invoice and receipt check box not ticked (Hence Import invoice and receipt not available)", test, test1);
		waitForElement(driver, import_Invoice_Checkbox_IMD);
		String imp_Inv_Status=getAttribute(driver, import_Invoice_Checkbox_IMD, "class");
		if (!imp_Inv_Status.contains(checkbox_Status)) {
			System.out.println("Expected Result is : Import Invoice checkbox Should Not be active || Actual Result is : Import Invoice checkbox was Not active");
			Extent_pass_New(driver, "Expected Result is : Import Invoice checkbox Should Not be active || Actual Result is : Import Invoice checkbox was Not active", test, test1);
		}else {
			System.out.println("Expected Result is : Import Invoice checkbox Should Not be active || Actual Result is : Import Invoice checkbox was active");
			Extent_fail(driver, "Expected Result is : Import Invoice checkbox Should Not be active || Actual Result is : Import Invoice checkbox was active", test, test1);
		}
		String actualStatus=getAttribute(driver, reciept_CheckBox_IMD, "class");
		if (!actualStatus.contains(checkbox_Status)) {
			System.out.println("Expected Result is : Receipt checkbox Should Not be active || Actual Result is : Receipt checkbox was Not active");
			Extent_pass_New(driver, "Expected Result is : Receipt checkbox Should Not be active || Actual Result is : Receipt checkbox was Not active", test, test1);
			}
		else {
			System.out.println("Expected Result is : Receipt checkbox Should Not be active || Actual Result is : Receipt checkbox was active");
			Extent_fail(driver, "Expected Result is : Receipt checkbox Should Not be active || Actual Result is : Receipt checkbox was active", test, test1);
		
		}
		Step_Start(16, "Make sure invoice and receipt check box not ticked (Hence Import invoice and receipt not available)", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// Agency Configuration
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, value_Back, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}