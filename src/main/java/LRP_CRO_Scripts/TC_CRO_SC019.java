package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC019 extends Keywords {
	public void CRO_SC019(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC019";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
	
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String AcceptanceTerminal = Excel_data.get("AcceptanceTerminal");		
		String condition_Filter = Excel_data.get("condition_Filter");
		String ReleaseTerminal_Header = Excel_data.get("ReleaseTerminal_Header");
		String AcceptanceTerminal_Header = Excel_data.get("AcceptanceTerminal_Header");
		String CRO_Saved_Popup = Excel_data.get("CRO_Saved_Popup");
		String CRO_Delete_Validation = Excel_data.get("CRO_Delete_Validation");
		
		String Plugin_Configuration_Module = Excel_data.get("Plugin_Configuration_Module");
		String Config_Change_Headers = Excel_data.get("Config_Change_Headers");
		String Config_Change_IDs = Excel_data.get("Config_Change_IDs");
		String Config_Change_Value = Excel_data.get("Config_Change_Value");
		String Default_Config_Value = Excel_data.get("Default_Config_Value");
		String Config_Filter_Condition = Excel_data.get("Config_Filter_Condition");
		
		
		Extent_Start(testCaseName, test, test1);
		
		navigateUrl(driver, url);

		// Login
		LRP_Login(driver, Username, Password);


		//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		Step_Start(1, "Open plugin configuration.", test, test1);
		Step_Start(2, "Search APP plugin and Double click the record.", test, test1);
		Step_Start(3, "Set the plugin as False.", test, test1);

		setPluginConfig(driver, Plugin_Configuration_Module, Config_Change_Headers, Config_Filter_Condition, Config_Change_IDs, Config_Change_Value);
		Step_End(3, "Set the plugin as False.", test, test1);
		Step_End(2, "Search APP plugin and Double click the record.", test, test1);
		Step_End(1, "Open plugin configuration.", test, test1);

		Step_Start(4, "Go to booking module.", test, test1);
		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		Step_End(4, "Go to booking module.", test, test1);

		Step_Start(5, "Navigate CRO from booking screen.", test, test1);
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(5, "Navigate CRO from booking screen.", test, test1);

		Step_Start(6, ".Click \"edit\" button.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(6, ".Click \"edit\" button.", test, test1);

		Step_Start(7, "Select \"Release Depot/Terminal\"", test, test1);
		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		if(!releaseDepTerminal.trim().equals("")) {
			waitForElement(driver, rel_terminal_searchicon);
			click(driver, rel_terminal_searchicon);
			twoColumnSearchWindow(driver, ReleaseTerminal_Header, condition_Filter, releaseDepTerminal);
		}
		Step_End(7, "Select \"Release Depot/Terminal\"", test, test1);

		Step_Start(8, "Select \"Acceptance Terminal\". ", test, test1);

		if(!AcceptanceTerminal.trim().equals("")) {
			waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
			click(driver, acceptance_Terminal_SearchButton_CRO);
			twoColumnSearchWindow(driver, AcceptanceTerminal_Header, condition_Filter, AcceptanceTerminal);
		}
		Step_End(8, "Select \"Acceptance Terminal\". ", test, test1);

		Step_Start(9, "Click \"save\" button.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver,SaveButton_ToolBar);
		Step_End(9, "Click \"save\" button.", test, test1);

		Step_Start(10, "CRO is saved message shown.", test, test1);
		String Act_ETA_Popup=getText(driver, Popup_Message);
		if(CRO_Saved_Popup.equalsIgnoreCase(Act_ETA_Popup)) {
			System.out.println("Popup Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup);
			Extent_pass_New(driver, "Popup Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup, test, test1);
		}else {
			System.out.println("Popup Not Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup);
			Extent_fail(driver, "Popup Not Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup, test, test1);
		}
		Step_End(10, "CRO is saved message shown.", test, test1);

		Step_Start(11, "Click delete button", test, test1);
		waitForElement(driver, Delete_button_toolBar);
		jsClick(driver,Delete_button_toolBar);
		
		Step_End(11, "Click delete button", test, test1);

		Step_Start(12, "\"Load Planned CRO Container(s) cannot be removed\" message shown.", test, test1);
		waitForPopup(driver, popup_Message, CRO_Delete_Validation);
		String Act_DeletePopup=getText(driver, popup_Message);
		if(Act_DeletePopup.equalsIgnoreCase(CRO_Delete_Validation)) {
			System.out.println("Popup Matched || Expected : "+CRO_Delete_Validation+" || Actual : "+Act_DeletePopup);
			Extent_pass_New(driver, "Popup Matched || Expected : "+CRO_Delete_Validation+" || Actual : "+Act_DeletePopup, test, test1);
		}else {
			System.out.println("Popup Not Matched || Expected : "+CRO_Delete_Validation+" || Actual : "+Act_DeletePopup);
			Extent_fail(driver, "Popup Not Matched || Expected : "+CRO_Delete_Validation+" || Actual : "+Act_DeletePopup, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(12, "\"Load Planned CRO Container(s) cannot be removed\" message shown.", test, test1);

		if(!Default_Config_Value.trim().equals("")) {
			setPluginConfig(driver, Plugin_Configuration_Module, Config_Change_Headers, Config_Filter_Condition, Config_Change_IDs, Default_Config_Value);
		}
		
		Extent_completed(testCaseName, test, test1);
	}
}
