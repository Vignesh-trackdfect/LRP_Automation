package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_028 extends Keywords{


	public void Delivery_Order_TS_028(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_028";
		
		
		navigateUrl(driver, url);


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String value = Excel_data.get("value");
		String description_Data = Excel_data.get("description_Data");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String Do_Module = Excel_data.get("Do_Module");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String bl_Number = Excel_data.get("bl_Number");
		String expired_Popup = Excel_data.get("expired_Popup");
		String Global_search_value_Do = Excel_data.get("Global_search_value_Do");
		String default_Value = Excel_data.get("default_Value");
		String attribute = Excel_data.get("attribute");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description_Data, value);
		Step_Start(5, "Open Delivery order module and ensure Guarantor search field is enabled", test, test1);
		moduleNavigate(driver, Do_Module);
		waitForElement(driver, SearchButton_Toolbar);
		if(isElementEnabled(driver, SearchButton_Toolbar)) {
			System.out.println("MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN ENABLE CONDITION");
			Extent_pass_New(driver, "MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN ENABLE CONDITION", test, test1);
		}else {
			System.out.println("MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN DISABLE CONDITION");
			Extent_fail(driver, "MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN DISABLE CONDITION", test, test1);
		}
		Step_End(5, "Open Delivery order module and ensure Guarantor search field is enabled", test, test1);
		Step_Start(6, "Click the 'New' button", test, test1);
		newButton(driver);
		Step_End(6, "Click the 'New' button", test, test1);
		Step_Start(7, "Click the 'ADD' button", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the 'ADD' button", test, test1);
		Step_Start(8, "Paste the BL, click search, and fetch the record (System fetched the guarantor check details for customer)", test, test1);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_search_value_Do, bl_Number, "", "", "", "");
		Step_End(8, "Paste the BL, click search, and fetch the record (System fetched the guarantor check details for customer)", test, test1);
		Step_Start(9, "Click the 'SHOW' button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(9, "Click the 'SHOW' button", test, test1);
		Step_Start(10, "Select the container details in the grid", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(10, "Select the container details in the grid", test, test1);
		Step_Start(11, "Click the Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(11, "Click the Save button", test, test1);
		Step_Start(12, "Ensure system validated as 'Guarantor’s Cheque is not available or validity of the Cheque is expired'", test, test1);
		waitForPopup(driver,Popup_Message,expired_Popup);
		String expired_Popup_Actual = getText(driver, Popup_Message).trim();
		if(expired_Popup_Actual.equals(expired_Popup.trim())) {
			System.out.println("MATCHED || EXPECTED Pop-up value is -> "+expired_Popup+" ACTUAL Pop-up value is -> "+expired_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is -> "+expired_Popup+" ACTUAL Pop-up value is -> "+expired_Popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is -> "+expired_Popup+" ACTUAL Pop-up value is -> "+expired_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is -> "+expired_Popup+" ACTUAL Pop-up value is -> "+expired_Popup_Actual, test, test1);
		}
		Step_End(12, "Ensure system validated as 'Guarantor’s Cheque is not available or validity of the Cheque is expired'", test, test1);
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description_Data, default_Value, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}