package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_024 extends Keywords {
	public void Delivery_Order_TS_024(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_024";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String description_Data = Excel_data.get("description_Data");
		String value = Excel_data.get("value");
		String Do_Module = Excel_data.get("Do_Module");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String bl_Number = Excel_data.get("bl_Number");
		String final_popup_expected = Excel_data.get("final_popup_expected");
		String Global_search_value_Bl_Number = Excel_data.get("Global_search_value_Bl_Number");
		String empty_Message = Excel_data.get("empty_Message");
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
		Step_Start(5, "Open Delivery Order module", test, test1);
		moduleNavigate(driver, Do_Module);
		Step_End(5, "Open Delivery Order module", test, test1);
		Step_Start(6, "Click new button", test, test1);
		newButton(driver);
		Step_End(6, "Click new button", test, test1);
		Step_Start(7, "Click the 'ADD' button", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the 'ADD' button", test, test1);
		Step_Start(8, "Paste the BL number and click search", test, test1);
		Step_Start(9, "Fetch the BL details", test, test1);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_search_value_Bl_Number, bl_Number, "", "", "", "");
		Step_End(9, "Fetch the BL details", test, test1);
		Step_End(8, "Paste the BL number and click search", test, test1);
		Step_Start(10, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(10, "Click the SHOW button", test, test1);
		Step_Start(11, "In Delivery Order screen \"Inv/Rec No\" should not be available ", test, test1);
		waitForDisplay(driver, receipt_Invoice_Details_Table_Do);
		String invoice_Table_Rows = getAttribute(driver, receipt_Invoice_Details_Table_Do, "class");
		if(invoice_Table_Rows.contains(empty_Message)) {
			System.out.println("Expected Result is : RECEIPT AND INVOICE DETAILS TABLE SHOULD NOT DISPLAY THE INVOICE DETAILS || The Actual Result is : RECEIPT AND INVOICE DETAILS TABLE IS NOT DISPLAYING THE INVOICE DETAILS");
			Extent_pass_New(driver,"Expected Result is : RECEIPT AND INVOICE DETAILS TABLE SHOULD NOT DISPLAYING THE INVOICE DETAILS || The Actual Result is : RECEIPT AND INVOICE DETAILS TABLE IS NOT DISPLAYING THE INVOICE DETAILS", test, test1);
		}else {
			System.out.println("Expected Result is : RECEIPT AND INVOICE DETAILS TABLE SHOULD NOT DISPLAYING THE INVOICE DETAILS || The Actual Result is : RECEIPT AND INVOICE DETAILS TABLE IS DISPLAYING THE INVOICE DETAILS");
			Extent_fail(driver, "Expected Result is : RECEIPT AND INVOICE DETAILS TABLE SHOULD NOT DISPLAYING THE INVOICE DETAILS || The Actual Result is : RECEIPT AND INVOICE DETAILS TABLE IS DISPLAYING THE INVOICE DETAILS", test, test1);
		}
		Step_End(11, "In Delivery Order screen \"Inv/Rec No\" should not be available ", test, test1);
		Step_Start(12, "Select the container details in the below grid", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(12, "Select the container details in the below grid", test, test1);
		Step_Start(13, "Click the Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(13, "Click the Save button", test, test1);
		Step_Start(14, "Ensure system validates 'Invoice/receipt details not found'", test, test1);
		waitForPopup(driver,Popup_Message,final_popup_expected);
		String final_popup_Actual = getText(driver, Popup_Message);
		if(final_popup_Actual.equals(final_popup_expected)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is AFTER CLICKING SAVE IS : "+final_popup_expected+" ACTUAL Pop-up value is AFTER CLICKING SAVE IS : "+ final_popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER CLICKING SAVE IS : "+final_popup_expected+" ACTUAL Pop-up value is AFTER CLICKING SAVE IS : "+ final_popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER CLICKING SAVE IS : "+final_popup_expected+" ACTUAL Pop-up value is AFTER CLICKING SAVE IS : "+ final_popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER CLICKING SAVE IS : "+final_popup_expected+" ACTUAL Pop-up value is AFTER CLICKING SAVE IS : "+ final_popup_Actual, test, test1);
		}
		Step_End(14, "Ensure system validates 'Invoice/receipt details not found'", test, test1);
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description_Data, default_Value, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}
