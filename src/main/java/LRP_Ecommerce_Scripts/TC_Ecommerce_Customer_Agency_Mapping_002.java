package LRP_Ecommerce_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import commonMethods.Keywords;



public class TC_Ecommerce_Customer_Agency_Mapping_002 extends Keywords {
	public void Customer_Agency_Mapping_002(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Ecommerce_Customer_Agency_Mapping_002";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Customer_Code_Header = Excel_data.get("Customer_Code_Header");
		String condition_Filter = Excel_data.get("condition_Filter");
		String Customer_Code = Excel_data.get("Customer_Code");
		String Agency_Code_Header = Excel_data.get("Agency_Code_Header");
		String Agency_Code = Excel_data.get("Agency_Code");
		String Saved_Popup_Exp = Excel_data.get("Saved_Popup_Exp");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, "Click on the \"Agency Search\" option and select the agency code", test, test1);
		SwitchProfile(driver, AgencyName);
		Step_End(1, "Click on the \"Agency Search\" option and select the agency code", test, test1);
		moduleNavigate(driver, Module_Name);

		Step_Start(2, "Enter the customer code in the customer search field and select it", test, test1);

		waitForElement(driver, customer_Code_Search_Button_CAM);
		click(driver, customer_Code_Search_Button_CAM);
		twoColumnSearchWindow(driver, Customer_Code_Header, condition_Filter, Customer_Code);
		Step_End(2, "Enter the customer code in the customer search field and select it", test, test1);

		waitForElement(driver, Agency_Code_Search_button_CAM);
		click(driver, Agency_Code_Search_button_CAM);
		twoColumnSearchWindow(driver, Agency_Code_Header, condition_Filter, Agency_Code);

		Step_Start(3, " Click on the \"Save\" button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(3, " Click on the \"Save\" button", test, test1);

		Step_Start(4, "The system should successfully save the valid details", test, test1);
		waitForPopup(driver, Popup_Message, Saved_Popup_Exp);
		String Saved_Popup_Act = getText(driver, Popup_Message);
		if (Saved_Popup_Exp.trim().equals(Saved_Popup_Act)) {
			System.out.println(
					"Matched  || Expected Mail Popup :" + Saved_Popup_Exp + "|| Actual Mail Popup :" + Saved_Popup_Act);
			Extent_pass_New(driver,
					"Matched  || Expected Mail Popup :" + Saved_Popup_Exp + "|| Actual Mail Popup :" + Saved_Popup_Act,
					test, test1);
		} else {
			System.out.println("Not Matched  || Expected Mail Popup :" + Saved_Popup_Exp + "|| Actual Mail Popup :"
					+ Saved_Popup_Act);
			Extent_fail(driver, "Not Matched  || Expected Mail Popup :" + Saved_Popup_Exp + "|| Actual Mail Popup :"
					+ Saved_Popup_Act, test, test1);
		}
		Step_End(4, "The system should successfully save the valid details", test, test1);

		Step_Start(5, "The saved details should be displayed in the list below", test, test1);
		Step_Start(6, "Click the \"Refresh\" button to update and view the latest details", test, test1);
		waitForElement(driver, Refresh_Button_CAM);
		click(driver, Refresh_Button_CAM);

		waitForElement(driver, agency_Code_filter_CAM);
		sendKeys(driver, agency_Code_filter_CAM, Agency_Code);

		waitForElement(driver, customer_Code_Filter_CAM);
		sendKeys(driver, customer_Code_Filter_CAM, Customer_Code);

		waitForElement(driver, agency_Grid_Value);
		String Agency_Value = getText(driver, agency_Grid_Value);
		System.out.println("Agency_Value :" + Agency_Value);

		waitForElement(driver, Customer_Grid_Value);
		String Customer_Value = getText(driver, Customer_Grid_Value);
		System.out.println("Customer_Value :" + Customer_Value);

		if (Customer_Code.equals(Customer_Value)) {
			System.out.println("Matched  || Expected customer code :" + Customer_Code + "|| Actual customer code :"
					+ Customer_Value);
			Extent_pass_New(driver, "Matched  || Expected customer code :" + Customer_Code + "|| Actual customer code :"
					+ Customer_Value, test, test1);
		} else {
			System.out.println("Not Matched  || Expected customer code :" + Customer_Code + "|| Actual customer code :"
					+ Customer_Value);
			Extent_fail(driver, "Not Matched  || Expected customer code :" + Customer_Code + "|| Actual customer code :"
					+ Customer_Value, test, test1);
		}

		if (Agency_Code.equals(Agency_Value)) {
			System.out.println(
					"Matched  || Expected customer code :" + Agency_Code + "|| Actual customer code :" + Agency_Value);
			Extent_pass_New(driver,
					"Matched  || Expected customer code :" + Agency_Code + "|| Actual customer code :" + Agency_Value,
					test, test1);
		} else {
			System.out.println("Not Matched  || Expected customer code :" + Agency_Code + "|| Actual customer code :"
					+ Agency_Value);
			Extent_fail(driver, "Not Matched  || Expected customer code :" + Agency_Code + "|| Actual customer code :"
					+ Agency_Value, test, test1);
		}
		
		Step_End(5, "The saved details should be displayed in the list below", test, test1);

		Step_End(6, "Click the \"Refresh\" button to update and view the latest details", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
