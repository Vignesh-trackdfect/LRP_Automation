package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_025 extends Keywords {
	public void Delivery_Order_TS_025(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_025";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String description_Data = Excel_data.get("description_Data");
		String value = Excel_data.get("value");
		String Do_Module = Excel_data.get("Do_Module");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String select_Option_Cust_Code = Excel_data.get("select_Option_Cust_Code");
		String customer_Code = Excel_data.get("customer_Code");
		String bl_to_select = Excel_data.get("bl_to_select");
		String save_Popup_Expected = Excel_data.get("save_Popup_Expected");
		String delete_Option = Excel_data.get("delete_Option");
		String deleted_expected = Excel_data.get("deleted expected");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String BL_Number_Search_Column_Header = Excel_data.get("BL_Number_Search_Column_Header");
		String default_Value = Excel_data.get("default_Value");
		String attribute = Excel_data.get("attribute");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String globalSearchFilterOption_IMD = Excel_data.get("GlobalSearchFilterOption_IMD");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description_Data, value);
		Step_Start(5, "Open Delivery order module", test, test1);
		moduleNavigate(driver, Do_Module);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, "Click new button", test, test1);
		newButton(driver);
		Step_End(6, "Click new button", test, test1);
		Step_Start(7, "Click the 'Customer search icon' Button", test, test1);
		waitForElement(driver, customer_Code_Searchicon_DO);
		click(driver, customer_Code_Searchicon_DO);
		Step_End(7, "Click the 'Customer search icon' Button", test, test1);
		Step_Start(8, "Paste the customer code then select the BL (which has Different voyages) and click search", test, test1);
		globalValueSearchWindow(driver, Dropdown_Condition, select_Option_Cust_Code, customer_Code, "", "", "", "");
		Step_End(8, "Paste the customer code then select the BL (which has Different voyages) and click search", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_Start(9, "Select the multiple records", test, test1);
		twoColumnSearchWindowMultipleValue(driver, BL_Number_Search_Column_Header, Dropdown_Condition, bl_to_select);
		Step_End(9, "Select the multiple records", test, test1);
		Step_Start(10, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(10, "Click the SHOW button", test, test1);
		Step_Start(11, "Select the container details in below grid", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(11, "Select the container details in below grid", test, test1);
		Step_Start(12, "Click the Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(12, "Click the Save button", test, test1);
		Step_Start(13, "Ensure 'Delivery order saved' validation done after Do saved", test, test1);
		waitForPopup(driver,Popup_Message,save_Popup_Expected);
		String save_Popup_Actual = getText(driver, Popup_Message);
		if(save_Popup_Actual.equals(save_Popup_Expected)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual, test, test1);
		}
		Step_End(13, "Ensure 'Delivery order saved' validation done after Do saved", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(14, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(14, "Click the Delete button", test, test1);
			Step_Start(15, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is : "+delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is : "+delete_Msg_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is : "+delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is : "+delete_Msg_Actual, test, test1);
			}
			Step_End(15, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(16, "Click Yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(16, "Click Yes", test, test1);
			Step_Start(17, "Ensure system validated as 'Delivery order deleted'", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if(deleted_expected.equals(do_Deleted_Actual)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE : "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE : "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE : "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE : "+do_Deleted_Actual, test, test1);
			}
			Step_End(17, "Ensure system validated as 'Delivery order deleted'", test, test1);
		}
		//		Import Documentation
		moduleNavigate(driver, module_ImportDocumentation);
		List<String> bl_Numbers = splitAndExpand(bl_to_select);
		Map<String, Map<String, String>> blData = new LinkedHashMap<>();
		for(String bl_Number : bl_Numbers) {
			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, Dropdown_Condition, globalSearchFilterOption_IMD, bl_Number, "", "", "", "");
			waitForElement(driver, servicenameImportDoc);
			String service_IMD=getAttribute(driver, servicenameImportDoc, "value");
			String vessel_IMD=getText(driver, vesselCode_ImportDoc);
			String voyage_IMD=getText(driver, voyage_ImportDoc);
			String bound_IMD=getText(driver, bound_ImportDoc);
			String port_IMD=getText(driver, portCode_ImportDoc);
			String terminal_IMD=getText(driver, terminalCode_ImportDoc);
			blData.put(bl_Number, createBLDetails(service_IMD, vessel_IMD, voyage_IMD, bound_IMD, port_IMD, terminal_IMD));
		}
		StringBuilder blDataTable = generateExtentReport(blData);
		Extent_pass_New(driver, "The Actual BL Details :  <pre>"+blDataTable+"</pre>", test, test1);
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description_Data, default_Value, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}
