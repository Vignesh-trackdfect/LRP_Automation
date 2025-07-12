package LRP_Arrival_Notice_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_020 extends Keywords {

	public void Arrival_Notice_TS_020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Arrival_Notice_TS_020";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String arrival_Module_Search = Excel_data.get("Arrival_Module_Search");
		String discharge_Service_Data = Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		String bl_Numbers_To_Select = Excel_data.get("Bl_Number's_To_Select");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String delete_Popup_Expected = Excel_data.get("Delete_Popup_Expected");
		String expected_Notification = Excel_data.get("Expected_Notification");
	
	

		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);


		// Switch the Profile
		Extent_call(test, test1, "**Switch the Profile Start**");

		Step_Start(1, " Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency ", test, test1);

		Step_Start(2, "Open the module name   Arrival Notice / Freight Memo in module search", test, test1);

		
		moduleNavigate(driver, arrival_Module_Search);

		Step_End(2, "Open the module name   Arrival Notice / Freight Memo in module search", test, test1);

		newButton(driver);
		Step_Start(3, "Enter service, vessel voyage details in search option and click search", test, test1);
		waitForElement(driver, by_Vessel_AN);
		click(driver, by_Vessel_AN);
		waitForElement(driver, discharge_Srvce_Txtfld_AN);
		sendKeys(driver, discharge_Srvce_Txtfld_AN, discharge_Service_Data);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);
		Step_End(3, "Enter service, vessel voyage details in search option and click search", test, test1);

		Step_Start(4, "Click Show and select the below mentioned BLs and click the Print icon on tool bar ", test, test1);

		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);

		Step_End(4, "Click Show and select the below mentioned BLs and click the Print icon on tool bar ", test, test1);
		List<String> bl_Number_To_Select = splitAndExpand(bl_Numbers_To_Select);
		int size = bl_Number_To_Select.size();

		for (int i = 0; i < size; i++) {
			String bl_checkbox_click = bl_Number_To_Select.get(i);
			String first_Checkbox_Click_1 = String.format(Arrival_Notice_Locators.bl_select_box,
					bl_checkbox_click);
			
			waitForElement(driver, condition_Filter_AN);
			click(driver, condition_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			clear(driver, blNumber_Filter_AN);
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN, bl_checkbox_click);
			waitForElement(driver, blNumber_Filter_AN);
			
			
			waitForElement(driver, first_Checkbox_Click_1);
			click(driver, first_Checkbox_Click_1);

		}
		
		Step_Start(5, "Click the delete button on tool bar", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		click(driver, Delete_button_toolBar);
		
		Step_End(5, "Click the delete button on tool bar", test, test1);

		Step_Start(6, "Ensure that system shows the validation message 'Do you want to delete the selected BL Number(s)?'", test, test1);

		waitForPopup(driver, popup_Message, delete_Popup_Expected);      
		String actual_Popup = getText(driver, popup_Message);
		if (actual_Popup.equals(delete_Popup_Expected)) {

			Extent_pass(driver, "Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup, test, test1);
			System.out.println("Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup);

			Step_Start(7, "Click yes", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(7, "Click yes", test, test1);

		} else {
			
			System.out.println("Not Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup);


			Extent_fail(driver, "Not Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup, test, test1);
		
		}
		Step_End(6, "Ensure that system shows the validation message 'Do you want to delete the selected BL Number(s)?'", test, test1);

		Step_Start(8, "Ensure system validated as 'Arrival notice deleted'", test, test1);
		Extent_call(test, test1, "Verifying the delete message popup");
		waitForPopup(driver, arrival_Notice_Dltd_Notification, expected_Notification);      
		String actual_notification = getText(driver, arrival_Notice_Dltd_Notification);
		if (actual_notification.equals(expected_Notification)) {
			Extent_pass(driver, "Matched || Expected noti after delete -> " + delete_Popup_Expected
					+ " Actual noti after delete -> " + actual_Popup, test, test1);
			System.out.println("Matched || Expected noti after delete -> " + delete_Popup_Expected
					+ " Actual noti after delete -> " + actual_Popup);

		} else {
			
			System.out.println("Not Matched || Expected noti after delete -> " + delete_Popup_Expected
					+ " Actual noti after delete -> " + actual_Popup);
		

			Extent_fail(driver, "Not Matched || Expected noti after delete -> " + delete_Popup_Expected
					+ " Actual noti after delete -> " + actual_Popup, test, test1);
			
		}}
		Step_End(8, "Ensure system validated as 'Arrival notice deleted'", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
