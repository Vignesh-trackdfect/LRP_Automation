package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_019 extends Keywords {

	public void Arrival_Notice_TS_019(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name="TC_Arrival_Notice_TS_019";
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String arrival_Module_Search = Excel_data.get("Arrival_Module_Search");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number = Excel_data.get("Bl_Number");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String delete_Popup_Expected = Excel_data.get("Delete_Popup_Expected");
		String expected_Notification = Excel_data.get("Expected_Notification");
		String expected_No_Record_Notification = Excel_data.get("Expected_No_Record_Notification");
	
		
		
		
		
		String first_Checkbox_Click_1 = String.format(Arrival_Notice_Locators.first_Checkbox_Click_1, bl_Number);
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);


		LRP_Login(driver, username, password);


		// Switch the Profile
		Extent_call(test, test1, "**Switch the Profile Start**");
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch the agency", test, test1);

		Step_Start(2, "Open the module name   Arrival Notice / Freight Memo in module search", test, test1);
	

		moduleNavigate(driver, arrival_Module_Search);

		Step_End(2, "Open the module name   Arrival Notice / Freight Memo in module search", test, test1);

		Step_Start(3, "select the Bl number search icon", test, test1);
		waitForElement(driver,SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "select the Bl number search icon", test, test1);

		Step_Start(4, "Paste the BL number ( Arrival Notice / Freight Memo already saved )", test, test1);
		globalValueSearchWindow(driver, BL_Condition, Search_Number, bl_Number, "", "", "", "");
		
		Step_End(4, "Paste the BL number ( Arrival Notice / Freight Memo already saved )", test, test1);

		Step_Start(5, "Select the Bl number checkbox", test, test1);
		waitForElement(driver, first_Checkbox_Click_1);
		click(driver, first_Checkbox_Click_1);
		Step_End(5, "Select the Bl number checkbox", test, test1);

		Step_Start(6, "Click the delete button on tool bar ", test, test1);
		scrollTop(driver);
		if(Delete_Perform.equalsIgnoreCase("YES")) {
		click(driver, Delete_button_toolBar);
		Step_End(6, "Click the delete button on tool bar ", test, test1);

		Step_Start(7, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? \"", test, test1);
		waitForPopup(driver, popup_Message, delete_Popup_Expected);      
		String actual_Popup = getText(driver, popup_Message);
		if (actual_Popup.equals(delete_Popup_Expected)) {
			Extent_pass(driver, "Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup, test, test1);
			System.out.println("Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup);
			Step_Start(8, "Click yes  (Ensure arrival notice deleted)", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(8,"Click yes  (Ensure arrival notice deleted)", test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message -> " + delete_Popup_Expected
					+ " Actual popup message -> " + actual_Popup, test, test1);

		}
		Step_End(7, "Ensure that system shows the validation message \"  Do you want to delete the selected BL Number(s) ? \"", test, test1);

		waitForPopup(driver, arrival_Notice_Dltd_Notification, expected_Notification);      
		String actual_notification = getText(driver, arrival_Notice_Dltd_Notification);

		if (actual_notification.equals(expected_Notification)) {
			Extent_pass(driver, "Matched || Expected notification after delete -> " + delete_Popup_Expected
					+ " Actual notification  after delete -> " + actual_Popup, test, test1);
			System.out.println("Matched || Expected notification  after delete -> " + delete_Popup_Expected
					+ " Actual notification  after delete -> " + actual_Popup);

		} else {

			System.out.println("Not Matched || Expected noti after delete -> " + delete_Popup_Expected
					+ " Actual noti after delete -> " + actual_Popup);


			Extent_fail(driver, "Not Matched || Expected noti after delete -> " + delete_Popup_Expected
					+ " Actual noti after delete -> " + actual_Popup, test, test1);

		}
		}

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		Step_Start(9, "Click search button the paste the deleted bl number in  search option ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(9, "Click search button the paste the deleted bl number in  search option ", test, test1);
		globalValueSearchWindow1(driver, BL_Condition, Search_Number, bl_Number, "", "", "", "");
	
		Extent_call(test, test1, "No records popup validation");

		Step_Start(10, "Ensure system displays \" No records found \"", test, test1);
		waitForPopup(driver, Popup_Message, expected_No_Record_Notification);      
		String actual_No_Record_Popup = getText(driver, Popup_Message);

		if (actual_No_Record_Popup.equals(expected_No_Record_Notification)) {

			Extent_pass(driver, "Matched || Expected no records noti after delete -> " + expected_No_Record_Notification
					+ " Actual no records  noti after delete -> " + actual_No_Record_Popup, test, test1);
			System.out.println("Matched || Expected no records  noti after delete -> " + expected_No_Record_Notification
					+ " Actual no records noti after delete -> " + actual_No_Record_Popup);
		} else {

			System.out.println(
					"Not Matched || Expected no records noti after delete -> " + expected_No_Record_Notification
					+ " Actual no records noti after delete -> " + actual_No_Record_Popup);

			Extent_fail(driver,
					"Not Matched || Expected no records noti after delete -> " + expected_No_Record_Notification
					+ " Actual no records noti after delete -> " + actual_No_Record_Popup,
					test, test1);

		}
		Step_End(10, "Ensure system displays \" No records found \"", test, test1);

		Extent_completed(tc_Name, test, test1);


	}
}
