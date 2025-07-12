package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_041 extends Keywords{
	public void Delivery_Order_TS_041(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_041";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String description = Excel_data.get("Description");
		String value = Excel_data.get("value");
		String attribute = Excel_data.get("Attribute");
		String Configuration_Reset = Excel_data.get("Configuration_Reset");
		String bl_Number=Excel_data.get("BL_Number");
		String WantToDelete_Popup=Excel_data.get("WantToDelete_Popup");
		String doStatus=Excel_data.get("DO_Status");
		String delete_Option = Excel_data.get("delete_Option");
		String DO_Deleted_Popup=Excel_data.get("DO_Deleted_Popup");
		String Customer_Status = Excel_data.get("Customer_Status");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String module_Customer_Master = Excel_data.get("module_Customer_Master");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String Popup_Expected = Excel_data.get("Popup_Msg");
		String Saved_popup = Excel_data.get("Saved_popup");
		String globalSearchFilterOption_IMD = Excel_data.get("globalSearchFilterOption_IMD");
		String globalSearchFilterOption_Customer_Master = Excel_data.get("globalSearchFilterOption_Customer_Master");
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("set_As_Default");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		moduleNavigate(driver, module_ImportDocumentation);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, bl_Number, "", "", "", "");
		waitForElement(driver, Customer_Tab);
		click(driver, Customer_Tab);
		scrollBottom(driver);
		List<Map<String, String>> customer_Tabledata = getTableData(driver, Customer_Table_Header, Customer_Table_Row);
		String customer_Code_Value = getValueByFirstColumnAndHeader(customer_Tabledata, "Customer Type", "CN", "System Code");
		System.out.println("customer_Code_Value : "+customer_Code_Value);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		moduleNavigate(driver, module_Customer_Master);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Customer_Master, customer_Code_Value, "", "", "", "");
		waitForElement(driver, Customer_Master_Status);
		String customer_Status_Value = getText(driver, Customer_Master_Status);
		System.out.println("customer_Status_Value : "+customer_Status_Value);
		if(Customer_Status.equals(customer_Status_Value)) {
			Extent_pass_New(driver, "Matched || Expected Customer Status : "+Customer_Status+" || Actual Customer Status : "+customer_Status_Value, test, test1);
			System.out.println("Matched || Expected Customer Status : "+Customer_Status+" || Actual Customer Status : "+customer_Status_Value);
		}else {
			System.out.println("Not Matched || Expected Customer Status : "+Customer_Status+" || Actual Customer Status : "+customer_Status_Value);
			Extent_fail(driver, "Not Matched || Expected Customer Status : "+Customer_Status+" || Actual Customer Status : "+customer_Status_Value, test, test1);
		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(5, "Open Delivery order module", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, "Click new button ", test, test1);
		newButton(driver);
		Step_End(6, "Click new button ", test, test1);
		Step_Start(7, "Click the ' ADD ' Button ", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the ' ADD ' Button ", test, test1);
		Step_Start(8, "Paste the BL  ", test, test1);
		Step_Start(9, "fetch record in below grid", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, bl_Number, "", "", "", "");
		Step_End(9, "fetch record in below grid", test, test1);
		Step_End(8, "Paste the BL  ", test, test1);
		Step_Start(10, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(10, "Click the SHOW button", test, test1);
		Step_Start(11, "Select the container details in below grid", test, test1);		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(11, "Select the container details in below grid", test, test1);
		Step_Start(12, "Click the Save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		Step_End(12, "Click the Save button ", test, test1);
		Step_Start(13, "Ensure Delivery order saved and DO number generated", test, test1);
		waitForPopup(driver,Popup_Message,Saved_popup);
		String save_Popup_Actual = getText(driver,Popup_Message);
		if(save_Popup_Actual.equals(Saved_popup)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is AFTER SAVE : "+Saved_popup+" || ACTUAL Pop-up value is AFTER SAVE : "+ save_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER SAVE : "+Saved_popup+" || ACTUAL Pop-up value is AFTER SAVE : "+ save_Popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER SAVE : "+Saved_popup+" || ACTUAL Pop-up value is AFTER SAVE : "+ save_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER SAVE : "+Saved_popup+" || ACTUAL Pop-up value is AFTER SAVE : "+ save_Popup_Actual, test, test1);
		}
		waitForElement(driver, DO_Status);
		String actual_Do_Status=getText(driver, DO_Status);
		if(actual_Do_Status.contains(doStatus)) {
			Extent_pass_New(driver, "Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status, test, test1);
			System.out.println("Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status);
		}else {
			System.out.println("Not Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status);
			Extent_fail(driver, "Not Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status, test, test1);
		}
		waitForElement(driver, deliveryOrderNumber_Textfield);
		String actualDO_Number=getAttribute(driver, deliveryOrderNumber_Textfield,"value");
		System.out.println("Generated DO Number is : "+actualDO_Number);
		Extent_pass_New(driver, "Generated DO Number is : "+actualDO_Number, test, test1);
		Step_End(13, "Ensure Delivery order saved and DO number generated", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(14, "Click delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(14, "Click delete button", test, test1);
			Step_Start(15, "system validated as  'Are you sure want to delete the Delivery Order? '", test, test1);
			waitForPopup(driver, popup_Message,WantToDelete_Popup);
			String actualWantToDelete_Popup = getText(driver, popup_Message);
			if (actualWantToDelete_Popup.equals(WantToDelete_Popup)) {
				System.out.println("Matched || Expected Delivery Order Pop-up value is : " + WantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
				Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + WantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup, test,test1);
			} else {
				System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + WantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
				Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + WantToDelete_Popup + " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup,test, test1);
			}
			Step_End(15, "system validated as  'Are you sure want to delete the Delivery Order? '", test, test1);
			Step_Start(16, "Click Yes ( make sure Delivery order deleted )", test, test1);
			click(driver, popup_Message_Yes_Button);
			waitForPopup(driver,Popup_Message,DO_Deleted_Popup);
			String actual_Deleted_Popup = getText(driver,Popup_Message);
			if (actual_Deleted_Popup.equals(DO_Deleted_Popup)) {
				System.out.println("Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
				Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup, test,test1);
			} else {
				System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
				Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup + " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup,test, test1);
			}
			Step_End(16, "Click Yes ( make sure Delivery order deleted )", test, test1);
		}
		waitForElement(driver,Module_Close);
		click(driver,Module_Close);
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, Configuration_Reset, newlyadded, set_As_Default);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(20, "Open delivery order module", test, test1);
		Step_Start(21, "Click new and add button", test, test1);
		newButton(driver);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(21, "Click new and add button", test, test1);
		Step_Start(22, "Paste the Bl number and  fetch the record", test, test1);
		globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_DO,bl_Number, "", "", "", "");
		Step_End(22, "Paste the Bl number and  fetch the record", test, test1);
		Step_Start(23, "click show and select the containers", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(23, "click show and select the containers", test, test1);
		Step_Start(24, "Click the save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(24, "Click the save button", test, test1);
		Step_Start(25, "Ensure that system validates ' Selected customer is yet to be validated. Delivery order can be created only for validated customer.'", test, test1);
		waitForPopup(driver,Popup_Message,Popup_Expected);
		save_Popup_Actual = getText(driver, Popup_Message);
		if(save_Popup_Actual.equals(Popup_Expected)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is  : "+Popup_Expected+" || ACTUAL Pop-up value is : "+ save_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is : "+Popup_Expected+" || ACTUAL Pop-up value is : "+ save_Popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is : "+Popup_Expected+" || ACTUAL Pop-up value is : "+ save_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is : "+Popup_Expected+" || ACTUAL Pop-up value is : "+ save_Popup_Actual, test, test1);
		}
		Step_End(25, "Ensure that system validates ' Selected customer is yet to be validated. Delivery order can be created only for validated customer.'", test, test1);
		scrollTop(driver);
		waitForElement(driver,Module_Close);
		click(driver,Module_Close);
		Extent_completed(testcase_Name, test, test1);
	}
}
