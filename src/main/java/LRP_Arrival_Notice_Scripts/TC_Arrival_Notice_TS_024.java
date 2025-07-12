package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_024 extends Keywords{

	public void Arrival_Notice_TS_024(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String tc_Name="TC_Arrival_Notice_TS_024";

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String BL_Condition =Excel_data.get("BL_Condition");
		String HBL_search =Excel_data.get("HBL_search");
		String house_Bl_Number =Excel_data.get("House_Bl_Number");
		String saved_Popup_Expected =Excel_data.get("Saved_Popup_Expected");
		String Delete_Perform =Excel_data.get("Delete_Perform");
		
		
		String first_Checkbox_Click_1 = String.format(Arrival_Notice_Locators.hbl_Checkbox_Click, house_Bl_Number);
		
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
	globalValueSearchWindow(driver, BL_Condition, HBL_search, house_Bl_Number, "","", "","");
	Step_Start(4, "paste the house Bl number click search and select the record in grid", test, test1);
		
		Step_End(4, "paste the house Bl number click search and select the record in grid", test, test1);
	
		Step_Start(5, "click \"Show\" and click on \"Edit\" from toolbar", test, test1);

		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		
		
		waitForDisplay(driver, first_Checkbox_Click_1);
		click(driver, first_Checkbox_Click_1);
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(5, "click \"Show\" and click on \"Edit\" from toolbar", test, test1);

		Step_Start(6, ".Select the record and click save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(6, ".Select the record and click save button", test, test1);
		waitForPopup(driver, Popup_Message, saved_Popup_Expected);      
		String actual_Saved_Popup = getText(driver, Popup_Message);
		if(actual_Saved_Popup.equals(saved_Popup_Expected)) {
			System.out.println("Matched || Expected saved popup -> "+saved_Popup_Expected+" || Actual saved popup -> "+actual_Saved_Popup);
			Extent_pass(driver, "Matched || Expected saved popup -> "+saved_Popup_Expected+" || Actual saved popup -> "+actual_Saved_Popup, test, test1);
		}else {
			System.out.println("Not Matched ||  Expected saved popup -> "+saved_Popup_Expected +" || Actual popup message -> "+ actual_Saved_Popup);
			Extent_fail(driver,"Not Matched ||  Expected saved popup -> "+saved_Popup_Expected +" || Actual popup message -> "+ actual_Saved_Popup , test, test1);
		}
		Step_Start(7, "Click the saved Arrival notice bl and click Delete button", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(7, "Click the saved Arrival notice bl and click Delete button", test, test1);

		Step_Start(8, "Click Yes and system validates Arrival notice deleted.", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(8, "Click Yes and system validates Arrival notice deleted.", test, test1);
		}
		Extent_completed(tc_Name, test, test1);

	}
	
}
