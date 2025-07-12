package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_016 extends Keywords {

	public void Arrival_Notice_TS_016(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Arrival_Notice_TS_016";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String arrival_Module_Search = Excel_data.get("Arrival_Module_Search");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number = Excel_data.get("Bl_Number");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String first_Checkbox_Click = String.format(Arrival_Notice_Locators.checkbox_Click_With_bl_Num, bl_Number);
		String take_Arrival_Notice_Number1 = String.format(Arrival_Notice_Locators.take_Arrival_Notice_Number, bl_Number);

		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);


		LRP_Login(driver, username, password);


		// Switch the Profile
		Extent_call(test, test1, "**Switch the Profile Start**");
		Step_Start(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);

		SwitchProfile(driver, agencyUser);


		
		moduleNavigate(driver, arrival_Module_Search);


		Step_End(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);

		Step_Start(2, "Click on New Button", test, test1);
	newButton(driver);
		Step_End(2, "Click on New Button", test, test1);

		Step_Start(3, "Click BL number option", test, test1);
		click(driver, BL_Search_button_AN);
		Step_End(3, "Click BL number option", test, test1);

		Step_Start(4, "paste the Bl", test, test1);
		globalValueSearchWindow(driver, BL_Condition, Search_Number, bl_Number, "", "", "", "");
		
		Step_End(4, "paste the Bl", test, test1);

		Step_Start(5, "click Show and click on \"Edit\" button from toolbar", test, test1);
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);

		Step_Start(6, "Select the record and click save button and copy the Arrival notice number", test, test1);
			waitForElement(driver, first_Checkbox_Click);
			click(driver, first_Checkbox_Click);
			scrollTop(driver);

			click(driver, Edit_Button_toolBar);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

		Step_End(6, "Select the record and click save button and copy the Arrival notice number", test, test1);
		Step_End(5, "click Show and click on Edit button from toolbar", test, test1);

		Extent_call(test, test1, "Getting the arrival notice number ");
		waitForElement(driver, take_Arrival_Notice_Number1);
		String arrvl_Num_In_Screen = getText(driver, take_Arrival_Notice_Number1);

		Step_Start(7, ".Click the Print button verify the Arrival notice number should be match with PDF.", test,
				test1);
		click(driver, print_Btn_Toolbar_AN);
		waitForElement(driver, print_Form_Bl_Check);
		waitForPopup(driver, print_Form_Bl_Check, arrvl_Num_In_Screen);      
		String bl_Number_In_Form = getText(driver, print_Form_Bl_Check);

		if (bl_Number_In_Form.equals(arrvl_Num_In_Screen)) {

			System.out.println("Matched ||Expected bl number -> " + arrvl_Num_In_Screen + " Actual bl number -> "
					+ bl_Number_In_Form);
			Extent_pass(driver, "Matched ||Expected bl number -> " + arrvl_Num_In_Screen + " Actual bl number -> "
					+ bl_Number_In_Form, test, test1);

		} else {
			System.out.println("Not Matched Expected bl number -> " + arrvl_Num_In_Screen + " Actual bl number -> "
					+ bl_Number_In_Form);
			Extent_fail(driver, "Not Matched Expected bl number -> " + arrvl_Num_In_Screen + " Actual bl number -> "
					+ bl_Number_In_Form, test, test1);
		}
		Step_End(7, ".Click the Print button verify the Arrival notice number should be match with PDF.", test, test1);

		//write delete script here		
				waitForElement(driver, x_Option1);
				click(driver, x_Option1);
				scrollTop(driver);

				click(driver, Edit_Button_toolBar);
				
				waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_Start(8, "Click the saved Arrival notice BL and click Delete button", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(8, "Click the saved Arrival notice BL and click Delete button", test, test1);


		Step_Start(9, "Click Yes and system validates 'Arrival notice deleted'", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		}
		Step_End(9, "Click Yes and system validates 'Arrival notice deleted'", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
