package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_027 extends Keywords {
	public void Delivery_Order_TS_027(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_027";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String value = Excel_data.get("value");
		String description_Data = Excel_data.get("description_Data");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String Do_Module = Excel_data.get("Do_Module");
		String save_Popup_Expected = Excel_data.get("save_Popup_Expected");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String bl_Number = Excel_data.get("bl_Number");
		String expired_Popup = Excel_data.get("expired_Popup");
		String percentile = Excel_data.get("percentile");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");
		String Global_search_value_Do = Excel_data.get("Global_search_value_Do");
		String Global_search_value_Guarantor_Do = Excel_data.get("Global_search_value_Guarantor_Do");
		String default_Value = Excel_data.get("default_Value");
		String attribute = Excel_data.get("attribute");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency and Make sure Import invoice and receipt has been done", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency and Make sure Import invoice and receipt has been done", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description_Data, value);
		Step_Start(5, "Open Delivery order module and Ensure Guarantor search field is enabled", test, test1);
		moduleNavigate(driver, Do_Module);
		waitForElement(driver, SearchButton_Toolbar);
		if(isElementEnabled(driver, SearchButton_Toolbar)) {
			System.out.println("MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN ENABLE CONDITION");
			Extent_pass_New(driver, "MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN ENABLE CONDITION", test, test1);
		}else {
			System.out.println("MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN DISABLE CONDITION");
			Extent_fail(driver, "MATCHED|| Expected Result is : DO SEARCH BUTTON IS SHOULD BE IN ENABLE CONDITION || Actual Result is : DO SEARCH BUTTON IS IN DISABLE CONDITION", test, test1);
		}
		Step_End(5, "Open Delivery order module and Ensure Guarantor search field is enabled", test, test1);
		Step_Start(6, "Click new button", test, test1);
		newButton(driver);
		Step_End(6, "Click new button", test, test1);
		Step_Start(7, "Click the 'ADD' Button", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(7, "Click the 'ADD' Button", test, test1);
		Step_Start(8, "Paste the BL, click search and fetch the record", test, test1);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_search_value_Do, bl_Number, "", "", "", "");
		Step_End(8, "Paste the BL, click search and fetch the record", test, test1);
		Step_Start(9, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(9, "Click the SHOW button", test, test1);
		Step_Start(10, "Select the container details in below grid", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(10, "Select the container details in below grid", test, test1);
		Step_Start(11, "Click the Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(11, "Click the Save button", test, test1);
		Step_Start(12, "Ensure that system validated as 'Delivery order saved'", test, test1);
		waitForPopup(driver,Popup_Message,save_Popup_Expected);
		String save_Popup_Actual = getText(driver, Popup_Message);
		if(save_Popup_Actual.equals(save_Popup_Expected)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual, test, test1);
		}else if(save_Popup_Actual.equals(expired_Popup)) {
			System.out.println("MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+expired_Popup+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+expired_Popup+" || ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual, test, test1);
			waitForElement(driver, guarantor_Search_Icon);
			click(driver, guarantor_Search_Icon);
			globalValueSearchWindow(driver, "", Global_search_value_Guarantor_Do, percentile, "", "", "", "");
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			 waitForPopup(driver, Popup_Message, save_Popup_Expected);
			    String DO_Saved_Popup = getText(driver, Popup_Message);
			    if (DO_Saved_Popup.equals(save_Popup_Expected)) {
			        System.out.println("Matched || Expected Pop-up value is : " + save_Popup_Expected + " || Actual Pop-up value is : " + DO_Saved_Popup);
			        Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + save_Popup_Expected + " || Actual Pop-up value is : " + DO_Saved_Popup, test, test1);
			    } else {
			        System.out.println("Not Matched || Expected Pop-up value is : " + save_Popup_Expected + " || Actual Pop-up value is : " + DO_Saved_Popup);
			        Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + save_Popup_Expected + " || Actual Pop-up value is  : " + DO_Saved_Popup, test, test1);
			    }
		}else {
			System.out.println("NOT MATCHED || EXPECTED Pop-up value is -> "+expired_Popup+" ACTUAL Pop-up value is -> "+save_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is -> "+expired_Popup+" ACTUAL Pop-up value is -> "+save_Popup_Actual, test, test1);
		}
		
		Step_End(12, "Ensure that system validated as 'Delivery order saved'", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(13, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(13, "Click the Delete button", test, test1);
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
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			Step_End(16, "Ensure system validated as 'Delivery order deleted'", test, test1);
		}
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description_Data, default_Value, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}