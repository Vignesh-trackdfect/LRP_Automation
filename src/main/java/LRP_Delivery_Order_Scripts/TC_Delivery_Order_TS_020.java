package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_020 extends Keywords{
	public void Delivery_Order_TS_020(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_020";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String value = Excel_data.get("value");
		String description = Excel_data.get("description");
		String DeliveryOrderModule = Excel_data.get("DeliveryOrderModule");
		String DO_Saved = Excel_data.get("DO_Saved");
		String Condition = Excel_data.get("Condition");
		String customer_Code = Excel_data.get("customer_Code");
		String BL_Num = Excel_data.get("BL_Num");
		String attribute = Excel_data.get("attribute");
		String Value_To_Reset = Excel_data.get("Value_To_Reset");
		String GlobalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String BL_Number_Search_Column_Header = Excel_data.get("BL_Number_Search_Column_Header");
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
		Step_Start(5, "Open Delivery order module", test, test1);	
		moduleNavigate(driver, DeliveryOrderModule);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, "Click new button", test, test1);
		newButton(driver);
		Step_End(6, "Click new button", test, test1);
		Step_Start(7, "Click the Customer search icon", test, test1);
		waitForElement(driver, DO_Customer_Code_Search_Button);
		click(driver, DO_Customer_Code_Search_Button);
		Step_End(7, "Click the  Customer search icon", test, test1);
		Step_Start(8, "Paste the Customer code or name and click search", test, test1);
		Step_Start(9, "Select record in below grid", test, test1);
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_DO, customer_Code, "", "", "", "");
		Step_End(9, "Select record in below grid", test, test1);
		Step_End(8, "Paste the Customer code or name and click search", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		twoColumnSearchWindow(driver, BL_Number_Search_Column_Header, TwoColumn_Condition, BL_Num);
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
		Step_Start(13, "Ensure \" Delivery order saved \" validation done after Do saved", test, test1);
		waitForPopup(driver,Popup_Message,DO_Saved);
		String DO_Saved_Popup=getText(driver, Popup_Message);
		if (DO_Saved_Popup.equals(DO_Saved)) {
			System.out.println("Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
			Extent_fail(driver,"Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is  : " + DO_Saved_Popup,test, test1);
		}
		Step_End(13, "Ensure \" Delivery order saved \" validation done after Do saved", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(14, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(14, "Click the Delete button", test, test1);
			Step_Start(15, "Ensure system Validates as \"  Are you sure want to delete the Delivery Order? \"", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String Delete_Yes_No_Popup=getText(driver, popup_Message);
			if (delete_popup_expected.trim() .equals(Delete_Yes_No_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up value is : " + delete_popup_expected  + " || Actual Pop-up value is : " + Delete_Yes_No_Popup);
				Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + delete_popup_expected  + " || Actual Pop-up value is : " + Delete_Yes_No_Popup, test,test1);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is : " + delete_popup_expected  + " || Actual Pop-up value is : " + Delete_Yes_No_Popup);
				Extent_fail(driver,"Not Matched || Expected Pop-up value is : " + delete_popup_expected  + " || Actual Pop-up value is  : " + Delete_Yes_No_Popup,test, test1);
			}
			Step_End(15, "Ensure system Validates as \"  Are you sure want to delete the Delivery Order? \"", test, test1);
			Step_Start(16, "Click Yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(16, "Click Yes", test, test1);
			Step_Start(17, "Ensure\" Delivery order deleted\" validation should be displayed", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String DO_Delete_Popup=getText(driver, Popup_Message);
			if (deleted_expected.trim() .equals(DO_Delete_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up value is : " + deleted_expected  + " || Actual Pop-up value is : " + DO_Delete_Popup);
				Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + deleted_expected  + " || Actual Pop-up value is : " + DO_Delete_Popup, test,test1);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is : " + deleted_expected  + " || Actual Pop-up value is : " + DO_Delete_Popup);
				Extent_fail(driver,"Not Matched || Expected Pop-up value is : " + deleted_expected  + " || Actual Pop-up value is  : " + DO_Delete_Popup,test, test1);
			}
			Step_End(17, "Ensure\" Delivery order deleted\" validation should be displayed", test, test1);
		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description, Value_To_Reset, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}