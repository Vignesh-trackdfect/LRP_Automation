package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS005 extends Keywords {

	public void Agency_Master_TS005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS005";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Saved_popup = Excel_data.get("Saved_popup");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String AgencyCode_Search = Excel_data.get("AgencyCode_Search");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Retrive the existing records", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, Select_search_value, AgencyCode_Search, "", "", "", "");

		Step_End(1, "Retrive the existing records", test, test1);

		Step_Start(2, "Click the EDIT buton in the  above tool bar", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(2, "Click the EDIT buton in the  above tool bar", test, test1);

		Step_Start(3, "Click the IN-ACTIVE checkbox and click the save button in the tool bar", test, test1);

		waitForElement(driver, InActive);
		jsClick(driver, InActive);

		Step_End(3, "Click the IN-ACTIVE checkbox and click the save button in the tool bar", test, test1);

		Step_Start(4, "The message of 'Corporate Agency Details Updated\" will be displayed'", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Saved_popup);
		String Save_popup = getText(driver, popup_Message);

		if (Save_popup.equals(Saved_popup)) {

			System.out.println(
					"Matched || Expected :Agency code is Inactive and user should get the expected popup message :"
							+ Saved_popup
							+ "Actual Message :Agency code is Inactive and details are updated and user got the expected popup message "
							+ Save_popup);
			Extent_pass_New(driver,
					"Matched || Expected :Agency code is Inactive and details are updated and user should get the expected popup message : "
							+ Saved_popup
							+ "Actual Message :Agency code is Inactive and details are updated and user got the expected popup message "
							+ Save_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected :Agency code is still active and details are not updated and user should get the error message, Expected Message: "
							+ Saved_popup
							+ "Actual Message :Agency code is Inactive and details are updated and user didn't get the expected popup message "
							+ Save_popup);
			Extent_fail(driver,
					"Not Matched || Expected :Agency code is still active and details are not updated and user should get the error message, Expected Message: "
							+ Saved_popup
							+ "Actual Message : Agency code is Inactive and details are updated and user didn't get the expected popup message"
							+ Save_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "The message of 'Corporate Agency Details Updated will be displayed'", test, test1);

		Step_Start(5, "If the agency Is IN-ACTIVE the records wont be visible in BOOKING and BILL OF LADING modules",
				test, test1);

		moduleNavigate(driver, Booking_Module_Name);

		waitForElement(driver, Booking_Number_Input);
		clear(driver, Booking_Number_Input);
		sendKeys(driver, Booking_Number_Input, AgencyCode_Search);

		String Select_AgencyType = String.format(BookingActiveCheck, AgencyCode_Search);

		if (isDisplayed(driver, Select_AgencyType)) {
			System.out.println("Expected result is : " + AgencyCode_Search
					+ " 'Agency code should not be displayed in the Booking after InActive that Value'  || Actual result is : "
					+ AgencyCode_Search + "  'Agency code is displayed in the Booking after InActive that Value'");
			Extent_fail(driver, "Expected result is : " + AgencyCode_Search
					+ " 'Agency code should not be displayed in the Booking after InActive that Value'  || Actual result is : "
					+ AgencyCode_Search + "  'Agency code is displayed in the Booking after InActive that Value'", test,
					test1);
		} else {
			System.out.println("Expected result is : " + AgencyCode_Search
					+ " 'Agency code should not be displayed in the Booking after InActive that Value'  || Actual result is : "
					+ AgencyCode_Search + "  'Agency code is not displayed in the Booking after InActive that Value'");
			Extent_pass_New(driver, "Expected result is : " + AgencyCode_Search
					+ " 'Agency code should not be displayed in the Booking after InActive that Value'  || Actual result is : "
					+ AgencyCode_Search + "  'Agency code is not displayed in the Booking after InActive that Value'",
					test, test1);
		}

		Step_End(5, "If the agency Is IN-ACTIVE the records wont be visible in BOOKING and BILL OF LADING modules",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
