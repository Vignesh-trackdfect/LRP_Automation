package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS015 extends Keywords {

	public void Agency_Master_TS015(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Agency_Master_TS015";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Agency_Filter_Type = Excel_data.get("Agency_Filter_Type");
		String Agency_Filter_Condition = Excel_data.get("Agency_Filter_Condition");
		String Agency_Filter_Value = Excel_data.get("Agency_Filter_Value");
		String Agency_updated_Popup = Excel_data.get("Agency_updated_Popup");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Agency_Master_Module);

		Step_Start(1, "Click the EDIT buton in the  above tool bar.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Agency_Filter_Condition, Agency_Filter_Type, Agency_Filter_Value, "", "", "",
				"");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(1, "Click the EDIT buton in the  above tool bar.", test, test1);

		Step_Start(2, "Click the IN-ACTIVE checkbox and click the save button in the tool bar..", test, test1);

		waitForElement(driver, InActive);
		if (IsElementSelected(driver, IN_ActiveCheckbox)) {
			Extent_FailNew(driver, Agency_Filter_Value + " Agency Already present in 'IN Active' Status", test, test1);
		}

		jsClick(driver, InActive);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(2, "Click the IN-ACTIVE checkbox and click the save button in the tool bar..", test, test1);

		Step_Start(3, "The message of 'Agency Details Updated' will be displayed", test, test1);

		waitForPopup(driver, popup_Message, Agency_updated_Popup);

		String act_Popup = getText(driver, popup_Message);

		if (act_Popup.contains(Agency_updated_Popup)) {
			System.out.println("Agency Details Updated ||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup);
			Extent_pass_New(driver, "Agency Details Updated ||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup, test, test1);
		} else {
			System.out.println("Agency Details not Updated ||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup);
			Extent_fail(driver, "Agency Details not Updated||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup, test, test1);
		}

		elementnotvisible1(driver, popup_Message);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(3, "The message of 'Agency Details Updated' will be displayed", test, test1);

		Step_Start(4, "If the agency Is IN-ACTIVE the records wont be visible in BOOKING and BILL OF LADING modules",
				test, test1);
		moduleNavigate(driver, Booking_Module_Name);

		waitForElement(driver, Booking_Number_Input);
		clear(driver, Booking_Number_Input);
		sendKeys(driver, Booking_Number_Input, Agency_Filter_Value);

		if (formatLocatorIsDisplayed(driver, BookingActiveCheck, Agency_Filter_Value)) {
			System.out.println("Expected result is " + Agency_Filter_Value
					+ " 'Agency code should not be displayed in the Booking after InActive that Value' Actual result is : "
					+ Agency_Filter_Value + " 'Agency code is displayed in the Booking after InActive that Value'");
			Extent_fail(driver, "Expected result is " + Agency_Filter_Value
					+ " 'Agency code should not be displayed in the Booking after InActive that Value' Actual result is : "
					+ Agency_Filter_Value + " 'Agency code is displayed in the Booking after InActive that Value'",
					test, test1);
		} else {
			System.out.println("Expected result is " + Agency_Filter_Value
					+ " 'Agency code should not be displayed in the Booking after InActive that Value' Actual result is : "
					+ Agency_Filter_Value + " 'Agency code is not displayed in the Booking after InActive that Value'");
			Extent_pass_New(driver, "Expected result is " + Agency_Filter_Value
					+ " 'Agency code should not be displayed in the Booking after InActive that Value' Actual result is : "
					+ Agency_Filter_Value + " 'Agency code is not displayed in the Booking after InActive that Value'",
					test, test1);
		}

		Step_End(4, "If the agency Is IN-ACTIVE the records wont be visible in BOOKING and BILL OF LADING modules",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
