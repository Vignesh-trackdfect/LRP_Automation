package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC045 extends Keywords {

	public void CRO_SC045(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_CRO_SC045";

		// Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String pluginConfiguration_Module_Name = Excel_data.get("pluginConfiguration_Module_Name");
		String pluginID = Excel_data.get("pluginID");
		String plugin_Header = Excel_data.get("plugin_Header");
		String Serach_Condition = Excel_data.get("Serach_Condition");
		String PluginStatus = Excel_data.get("PluginStatus");
		String Release_Terminal_Header = Excel_data.get("Release_Terminal_Header");
		String Acceptance_Terminal_Header = Excel_data.get("Acceptance_Terminal_Header");
		String Release_Terminal_Input = Excel_data.get("Release_Terminal_Input");
		String Acceptance_Terminal_Input = Excel_data.get("Acceptance_Terminal_Input");
		String Valid_Upto_Date = Excel_data.get("Valid_Upto_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Valid_Date_Excepted_PopUp = Excel_data.get("Valid_Date_Excepted_PopUp");
		String ResetPluginStatus = Excel_data.get("ResetPluginStatus");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

//	Switch the ProfilepluginConfigurationModule
		SwitchProfile(driver, agencyUser);

		Step_Start(1, "Open plugin configuration module", test, test1);
		Step_Start(2, "Search EVC plugin", test, test1);
		Step_Start(3, "Set to False", test, test1);
		Step_Start(4, "Click save button", test, test1);
		Step_Start(5, " Updatted successfully message shown", test, test1);
		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				PluginStatus);
		Step_End(1, "Open plugin configuration module", test, test1);
		Step_End(2, "Search EVC plugin", test, test1);
		Step_End(3, "Set to False", test, test1);
		Step_End(4, "Click save button", test, test1);
		Step_End(5, " Updatted successfully message shown", test, test1);
		// booking

		Step_Start(6, "Go to Booking", test, test1);

		Confirmed_Booking_Creation createBooking = new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		Step_End(6, "Go to Booking", test, test1);

		Step_Start(7, "Navigate CRO module", test, test1);
		// Create CRO

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(7, "Navigate CRO module", test, test1);
		Step_Start(8, "Click edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(8, "Click edit button", test, test1);
		Step_Start(9, "Select Release Depot/Terminal", test, test1);

		waitForElement(driver, Release_Terminal_SearchButton_CRO);
		click(driver, Release_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Release_Terminal_Header, Serach_Condition, Release_Terminal_Input);

		Step_End(9, "Select Release Depot/Terminal", test, test1);
		Step_Start(10, "Select Acceptance Terminal", test, test1);

		waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
		click(driver, acceptance_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Acceptance_Terminal_Header, Serach_Condition, Acceptance_Terminal_Input);
		Step_End(10, "Select Acceptance Terminal", test, test1);

		Step_Start(11, "Change valid upto date before CRO date (Date)", test, test1);
		if (!Valid_Upto_Date.equals("")) {
			if (DatePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Valid_To_CRO);
				click(driver, Valid_To_CRO);
				selectDatePicker(driver, Valid_Upto_Date);
			} else {
				waitForElement(driver, Valid_To_CRO);
				clearAndType(driver, Valid_To_CRO, Valid_Upto_Date);
			}
		}

		Step_End(11, "Change valid upto date before CRO date (Date)", test, test1);
		Step_Start(12, "Click save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(12, "Click save button", test, test1);
		Step_Start(13, "Valid Upto date should be later than or equal to CRO Date message shown", test, test1);
		waitForPopup(driver, popup_Message, Valid_Date_Excepted_PopUp);
		String Actual_Saved_Popup = getText(driver, popup_Message);

		if (Valid_Date_Excepted_PopUp.equals(Actual_Saved_Popup)) {
			System.out.println("Matched || Excepted : After Click on Save button The Status should be : "
					+ Valid_Date_Excepted_PopUp + " || Actual : After Click on Save Button The Satus is : "
					+ Actual_Saved_Popup);
			Extent_pass_New(driver,
					"Matched || Excepted : After Click on Save button The Status should be : "
							+ Valid_Date_Excepted_PopUp + " || Actual : After Click on Save Button The Satus is : "
							+ Actual_Saved_Popup,
					test, test);
		} else {
			System.out.println(" Not Matched || Excepted : After Click on Save button The Status should be : "
					+ Valid_Date_Excepted_PopUp + " || Actual : After Click on Save Button The Satus is : "
					+ Actual_Saved_Popup);
			Extent_fail(driver,
					" Not Matched ||  Excepted : After Click on Save button The Status should be : "
							+ Valid_Date_Excepted_PopUp + " || Actual : After Click on Save Button The Satus is : "
							+ Actual_Saved_Popup,
					test, test);

		}
		Step_End(13, "Valid Upto date should be later than or equal to CRO Date message shown", test, test1);
		Step_Start(14, "Open plugin configuration module", test, test1);
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		
		Step_End(14, "Open plugin configuration module", test, test1);
		
		Step_Start(15, "Open plugin configuration module", test, test1);
		Step_Start(16, "Search EVC plugin", test, test1);
		Step_Start(17, "set to True", test, test1);
		Step_Start(18, "Click save button", test, test1);
		
		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				ResetPluginStatus);
		
		Step_End(15, "Open plugin configuration module", test, test1);
		Step_End(16, "Search EVC plugin", test, test1);
		Step_End(17, "set to True", test, test1);
		Step_End(18, "Click save button", test, test1);
		Extent_completed(testCaseName, test, test1);

	}



}
