package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC016 extends Keywords {

	
	public void CRO_SC016(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		
		String testCaseName="TC_CRO_SC016";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String AcceptanceTerminal = Excel_data.get("AcceptanceTerminal");		
		String condition_Filter = Excel_data.get("condition_Filter");
		String ReleaseTerminal_Header = Excel_data.get("ReleaseTerminal_Header");
		String AcceptanceTerminal_Header = Excel_data.get("AcceptanceTerminal_Header");
		String ETD_Date_ValidationPopup = Excel_data.get("ETD_Date_ValidationPopup");
		String Add_ETD_Date = Excel_data.get("Add_ETD_Date");		
		
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
		String Attribute_Select = Excel_data.get("Attribute_Select");
		String ChangeAttribute_Value = Excel_data.get("ChangeAttribute_Value");
		String defaultAttribute_Value = Excel_data.get("defaultAttribute_Value");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login
		LRP_Login(driver, Username, Password);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);
		
		//Global Configuration
		Step_Start(1, "Open Global configuration module.", test, test1);
		Step_Start(2, "Search CTD config and double click the record.", test, test1);
		Step_Start(3, "Click edit button.", test, test1);
		Step_Start(4, "Set the value N.", test, test1);

		setGlobalConfiguration(driver, Global_Configuration_Module, Attribute_Select, ChangeAttribute_Value);
		
		Step_End(4, "Set the value N.", test, test1);
		Step_End(3, "Click edit button.", test, test1);
		Step_End(2, "Search CTD config and double click the record.", test, test1);
		Step_End(1, "Open Global configuration module.", test, test1);

		//Booking module
		Step_Start(5, "Go to Booking module.", test, test1);

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		Step_End(5, "Go to Booking module.", test, test1);

		Step_Start(6, "Navigate CRO module.", test, test1);
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(6, "Navigate CRO module.", test, test1);

		Step_Start(7, "Click edit button.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(7, "Click edit button.", test, test1);

		Step_Start(8, "Select Release Depot/Terminal.", test, test1);
		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		if(!releaseDepTerminal.trim().equals("")) {
			waitForElement(driver, rel_terminal_searchicon);
			click(driver, rel_terminal_searchicon);
			twoColumnSearchWindow(driver, ReleaseTerminal_Header, condition_Filter, releaseDepTerminal);
		}
		Step_End(8, "Select Release Depot/Terminal.", test, test1);

		Step_Start(9, "Select Acceptance Terminal.", test, test1);
		if(!AcceptanceTerminal.trim().equals("")) {
			waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
			click(driver, acceptance_Terminal_SearchButton_CRO);
			twoColumnSearchWindow(driver, AcceptanceTerminal_Header, condition_Filter, AcceptanceTerminal);
		}
		Step_End(9, "Select Acceptance Terminal.", test, test1);

		Step_Start(10, "Change valid upto date greater then terminal ETA date.", test, test1);
		waitForElement(driver, Terminal_ETD_Date_CRO);
		String ETD_Date_value=getText(driver, Terminal_ETD_Date_CRO);
		String Actual_ETD_Date=extractDate(ETD_Date_value);
		
		String uptoDate=addDaysToDate(Actual_ETD_Date,Add_ETD_Date);
		
		waitForElement(driver, Valid_To_CRO);
		selectDatePicker(driver, Valid_To_CRO, uptoDate);
		Step_End(10, "Change valid upto date greater then terminal ETA date.", test, test1);

		Step_Start(11, "Click save button.", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver,SaveButton_ToolBar);
		Step_End(11, "Click save button.", test, test1);

		Step_Start(12, "\"CRO Validity Date should not exceed ETA date\" validation shown.", test, test1);
		waitForPopup(driver, popup_Message, ETD_Date_ValidationPopup);
		String Act_ETD_Popup=getText(driver, popup_Message);
		if(ETD_Date_ValidationPopup.equals(Act_ETD_Popup)) {
			System.out.println("Popup Matched || Expected : "+ETD_Date_ValidationPopup+" || Actual : "+Act_ETD_Popup);
			Extent_pass_New(driver, "Popup Matched || Expected : "+ETD_Date_ValidationPopup+" || Actual : "+Act_ETD_Popup, test, test1);
		}else {
			System.out.println("Popup Not Matched || Expected : "+ETD_Date_ValidationPopup+" || Actual : "+Act_ETD_Popup);
			Extent_fail(driver, "Popup Not Matched || Expected : "+ETD_Date_ValidationPopup+" || Actual : "+Act_ETD_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(12, "\"CRO Validity Date should not exceed ETA date\" validation shown.", test, test1);

		Step_Start(13, "Go to global configuration module.", test, test1);
		Step_Start(14, "Search CTD config and double click the record.", test, test1);
		Step_Start(15, "Click edit button.", test, test1);
		Step_Start(16, "Set the value -.", test, test1);

		reSetGlobalConfiguration(driver,"Yes" ,Global_Configuration_Module, Attribute_Select, defaultAttribute_Value);
		Step_End(16, "Set the value -.", test, test1);
		Step_End(15, "Click edit button.", test, test1);
		Step_End(14, "Search CTD config and double click the record.", test, test1);
		Step_End(13, "Go to global configuration module.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
