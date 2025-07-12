package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_025 extends Keywords{

	public void Arrival_Notice_TS_025(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name="TC_Arrival_Notice_TS_025";

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String BL_Condition =Excel_data.get("BL_Condition");
		String Search_Number =Excel_data.get("Search_Number");
		String bl_Number =Excel_data.get("Bl_Number");
		String house_Bl_Number =Excel_data.get("House_Bl_Number");
		String Delete_Perform =Excel_data.get("Delete_Perform");

		
	
	

		String house_Bl_Arr_Notice_Cell = String.format(Arrival_Notice_Locators.house_Bl_Arr_Notice_Cell, house_Bl_Number);



		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);

		//	Switch the Profile
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, " Switch the agency ", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency ", test, test1);


		

		moduleNavigate(driver, arrival_Module_Search);


		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);

		Step_Start(3, "Click BL number option", test, test1);

		waitForElement(driver, by_Bl_Number_Button_AN);
		click(driver, by_Bl_Number_Button_AN);
		waitForElement(driver, BL_Search_button_AN);
		click(driver, BL_Search_button_AN);

		Step_End(3, "Click BL number option", test, test1);

		Step_Start(4, "paste the Bl", test, test1);
		globalValueSearchWindow(driver, BL_Condition, Search_Number, bl_Number, "","", "","");
	
		Step_End(4, "paste the Bl", test, test1);

		Step_Start(5, "click \"Show\" and click on \"Edit\" button from toolbar", test, test1);

		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);

		String click_Chckbox_By_Bl_Number=String.format(Arrival_Notice_Locators.hbl_Checkbox_Click,house_Bl_Number );
		waitForElement(driver, click_Chckbox_By_Bl_Number);
		click(driver, click_Chckbox_By_Bl_Number);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(5, "click \"Show\" and click on \"Edit\" button from toolbar", test, test1);

		Step_Start(6, "Select the record and click save button and copy the Arrival notice number", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, house_Bl_Arr_Notice_Cell);
		String value_Present_In_Screen = getText(driver, house_Bl_Arr_Notice_Cell);
		Step_End(6, "Select the record and click save button and copy the Arrival notice number", test, test1);

		Step_Start(7, "Click the Print button verify the Arrival notice number should be match with PDF.", test, test1);
		waitForElement(driver, print_Btn_Toolbar_AN);
		safeclick(driver, print_Btn_Toolbar_AN);
		waitForElement(driver, print_Form_Bl_Check);
		waitForPopup(driver, print_Form_Bl_Check, value_Present_In_Screen);      
		String value_Present_In_Form = getText(driver, print_Form_Bl_Check);

		if(value_Present_In_Form.equals(value_Present_In_Screen)) {

			System.out.println("Matched || Expected Arrival notice number in screen -> "+value_Present_In_Screen+" Actual number present in form -> "+value_Present_In_Form);
			Extent_pass(driver, "Matched || Expected Arrival notice number in screen -> "+value_Present_In_Screen+" Actual number present in form -> "+value_Present_In_Form, test, test1);
		}else {

			System.out.println("Not Matched || Expected Arrival notice number in screen -> "+value_Present_In_Screen+" Actual number present in form -> "+value_Present_In_Form);
			Extent_fail(driver, "Not Matched || Expected Arrival notice number in screen -> "+value_Present_In_Screen+" Actual number present in form -> "+value_Present_In_Form, test, test1);
		}

		Step_End(7, "Click the Print button verify the Arrival notice number should be match with PDF.", test, test1);


		//write delete script here		
		waitForElement(driver, x_Option1);
		click(driver, x_Option1);
		scrollTop(driver);

		click(driver, Edit_Button_toolBar);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_Start(8, "Click the saved Arrival notice bl and click Delete button", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);


		Step_End(8, "Click the saved Arrival notice bl and click Delete button", test, test1);

		Step_Start(9, "Click Yes and system validates Arrival notice deleted.", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_Start(9, "Click Yes and system validates Arrival notice deleted.", test, test1);
		}
		Extent_completed(tc_Name, test, test1);

	}	

}
