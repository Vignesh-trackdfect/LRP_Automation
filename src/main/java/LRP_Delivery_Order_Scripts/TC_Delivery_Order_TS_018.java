package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_018 extends Keywords{
	public void Delivery_Order_TS_018(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_018";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String value = Excel_data.get("value");
		String description = Excel_data.get("description");
		String DeliveryOrderModule = Excel_data.get("DeliveryOrderModule");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String bl_Number = Excel_data.get("bl_Number");
		String Cargo_type = Excel_data.get("Cargo_type");
		String DO_Saved = Excel_data.get("DO_Saved");
		String attribute = Excel_data.get("attribute");
		String GlobalSearchFilterOption_ID = Excel_data.get("GlobalSearchFilterOption_ID");
		String GlobalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Condition = Excel_data.get("Condition");
		String Value_To_Reset = Excel_data.get("Value_To_Reset");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Choose the transhipment agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Choose the transhipment agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description, value);
		moduleNavigate(driver, ImportDocumentationModule);
		List<String> numbers = splitAndExpand(bl_Number, ",");
		for(String number :numbers) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_ID, number, "", "", "", "");
			waitForElement(driver, Cargo_Type);
			String Cargo_Type_Value=getText(driver, Cargo_Type);
			if (Cargo_Type_Value.equals(Cargo_type)) {
				System.out.println("Matched || Expected Cargo Type Pop-up value is : " + Cargo_Type_Value + " || Actual Cargo Type Pop-up value is : " + Cargo_type);
				Extent_pass_New(driver,"Matched || Expected Cargo Type Pop-up value is : " + Cargo_Type_Value + " || Actual Cargo Type Pop-up value is : " + Cargo_type, test,test1);
			} else {
				System.out.println("Not Matched || Expected Cargo Type Pop-up value is : " + Cargo_Type_Value + " || Actual Cargo Type Pop-up value is : " + Cargo_type);
				Extent_fail(driver,"Not Matched || Expected Cargo Type Pop-up value is : " + Cargo_Type_Value + " || Actual Cargo Type Pop-up value is  : " + Cargo_type,test, test1);
			}
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(4, "Open Delivery order module", test, test1);
		moduleNavigate(driver, DeliveryOrderModule);
		Step_End(4, "Open Delivery order module", test, test1);
		Step_Start(5, "Click new button ", test, test1);
		newButton(driver);
		Step_End(5, "Click new button ", test, test1);
		for(String number :numbers) {
			Step_Start(6, "Click the \" ADD \" Button ", test, test1);
			waitForElement(driver, DO_Add_Button);
			click(driver, DO_Add_Button);
			Step_End(6, "Click the \" ADD \" Button ", test, test1);
			Step_Start(7, "Paste the BL Number and fetch the record", test, test1);
			globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_DO, number, "", "", "", "");
			Step_End(7, "Paste the BL Number and fetch the record", test, test1);
		}
		Step_Start(8, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(8, "Click the SHOW button", test, test1);
		Step_Start(9, "Select the container details in below grid", test, test1);	
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(9, "Select the container details in below grid", test, test1);
		Step_Start(10, "Click the Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(10, "Click the Save button", test, test1);
		Step_Start(11, "Ensure \" Delivery order saved \" validation done and Do number generated", test, test1);
		waitForPopup(driver,Popup_Message,DO_Saved);
		String DO_Saved_Popup=getText(driver, Popup_Message);
		if (DO_Saved_Popup.equals(DO_Saved)) {
			System.out.println("Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is : " + DO_Saved);
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is : " + DO_Saved, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is : " + DO_Saved);
			Extent_fail(driver,"Not Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is  : " + DO_Saved,test, test1);
		}
		waitForElement(driver, DO_Num_Tf);
		String actualDO_Number=getAttribute(driver, DO_Num_Tf,"value");
		System.out.println("Generated DO Number is : "+actualDO_Number);
		Extent_pass_New(driver, "Generated DO Number is : "+actualDO_Number, test, test1);
		Step_End(11, "Ensure \" Delivery order saved \" validation done and Do number generated", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(12, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(12, "Click the Delete button", test, test1);
			Step_Start(13, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}
			Step_End(13, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(14, "Click Yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(14, "Click Yes", test, test1);
			Step_Start(15, "Ensure system validated as 'Delivery order deleted'", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if(do_Deleted_Actual.equals(deleted_expected)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}
			Step_End(15, "Ensure system validated as 'Delivery order deleted'", test, test1);
		}
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser,description, Value_To_Reset, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}
