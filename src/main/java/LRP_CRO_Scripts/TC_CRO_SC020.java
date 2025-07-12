package LRP_CRO_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.LoadConfirmation_Locators;

public class TC_CRO_SC020 extends Keywords {

	public void CRO_SC020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC020";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
	
		
		String CRO_ModuleName = Excel_data.get("CRO_ModuleName");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String CRO_Global_Search_Type = Excel_data.get("CRO_Global_Search_Type");
		
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
		
		String Load_Confirmation_Module = Excel_data.get("Load_Confirmation_Module");
		String Activity_Date = Excel_data.get("Activity_Date");
		String Actual_Container_Numbers = Excel_data.get("Actual_Container_Numbers");
		String Load_Cofirmed_Popup = Excel_data.get("Load_Cofirmed_Popup");

		
		
		
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
		
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		
		waitForElement(driver, FirstserviceInput);
		String Servicevalue=getAttribute(driver, FirstserviceInput, "value");
		String Vessel_Value=getText(driver, vessleValue);
		String VoyageValue=getText(driver, voyageValue);
		String Bound_Value=getText(driver, BKG_Bound_Value);
		
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
		
		waitForElement(driver, Release_No_CRO);
		String  CRO_Number=getAttribute(driver, Release_No_CRO, "value");
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		Step_Start(11, "Opon Load confirmation module.", test, test1);
		//Load Confirmation
		moduleNavigate(driver, Load_Confirmation_Module);	
		Step_End(11, "Opon Load confirmation module.", test, test1);

		Step_Start(12, "Select booking service.", test, test1);
		Step_Start(13, "Select booking vessel.", test, test1);
		Step_Start(14, "Select booking voyage.", test, test1);
		Step_Start(15, "Select Bound.", test, test1);
		Step_Start(16, "Select port code.", test, test1);
		Step_Start(17, "Select terminal.", test, test1);

		waitForElement(driver, L_load_servicecode);
		selectservice(driver, Servicevalue, Vessel_Value, VoyageValue, Bound_Value, "", "");
		Step_End(17, "Select terminal.", test, test1);
		Step_End(16, "Select port code.", test, test1);
		Step_End(15, "Select Bound.", test, test1);
		Step_End(14, "Select booking voyage.", test, test1);
		Step_End(13, "Select booking vessel.", test, test1);
		Step_End(12, "Select booking service.", test, test1);

		Step_Start(18, "Click show button.", test, test1);

		waitForElement(driver, L_show_Button);
		click(driver, L_show_Button);
		Step_End(18, "Click show button.", test, test1);

		Step_Start(19, "Select the book number.", test, test1);

		if(!Activity_Date.trim().equals("")) {
			waitForElement(driver, activity_date);
			selectDatePicker(driver, activity_date, Activity_Date);
		}
		
		waitForElement(driver, bookingnumber);
		click(driver, bookingnumber);
		sendKeys(driver, bookingnumber, booknum);

		List<String> number = splitAndExpand(Actual_Container_Numbers);
		for(int i=1; i<=number.size(); i++) {
			String actual_container=String.format(LoadConfirmation_Locators.actual_containerr, i);
			doubleClick(driver, actual_container);
			Actionsendkeys(driver, actual_container, number.get(i-1));
		}
		
		waitForElement(driver, selectall);
		click(driver, selectall);
		Step_End(19, "Select the book number.", test, test1);

		Step_Start(20, "Click load confirmation button.", test, test1);

		waitForElement(driver, L_loadConfirmation_Button);
		click(driver, L_loadConfirmation_Button);
		Step_End(20, "Click load confirmation button.", test, test1);

		Step_Start(21, "Load confirmed message shown and click ok button.", test, test1);
		waitForPopup(driver, popup_Message, Load_Cofirmed_Popup);
		String Load_ConfirmPopupAct=getText(driver, popup_Message);
		if(Load_ConfirmPopupAct.contains(Load_Cofirmed_Popup)) {
			System.out.println("Popup Matched ||  Expected : "+Load_Cofirmed_Popup+" || Actual : "+Load_ConfirmPopupAct);
			Extent_pass_New(driver, "Popup Matched ||  Expected : "+Load_Cofirmed_Popup+" || Actual : "+Load_ConfirmPopupAct, test, test1);
		}else {
			System.out.println("Popup Not Matched ||  Expected : "+Load_Cofirmed_Popup+" || Actual : "+Load_ConfirmPopupAct);
			Extent_fail(driver, "Popup Not Matched ||  Expected : "+Load_Cofirmed_Popup+" || Actual : "+Load_ConfirmPopupAct, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(21, "Load confirmed message shown and click ok button.", test, test1);

		Step_Start(22, "Go to CRO module.", test, test1);
		moduleNavigate(driver, CRO_ModuleName);
		Step_End(22, "Go to CRO module.", test, test1);

		Step_Start(23, "Retrive the CRO number", test, test1);

		waitForDisplay(driver, cancel_Common_btn);
		if(IsElementEnabled(driver, cancel_Common_btn)) {
			waitForElement(driver, cancel_Common_btn);
			click(driver,cancel_Common_btn);
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, Global_Search_Condition, CRO_Global_Search_Type, CRO_Number, "", "", "", "");
		Step_End(23, "Retrive the CRO number", test, test1);

		Step_Start(24, ".Click delete button.", test, test1);
		waitForElement(driver, Delete_button_toolBar);
		jsClick(driver,Delete_button_toolBar);
		Step_End(24, ".Click delete button.", test, test1);

		Step_Start(25, "\"Load confirmed CRO Container(s) cannot be removed\" message shown", test, test1);

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
		Step_End(25, "\"Load confirmed CRO Container(s) cannot be removed\" message shown", test, test1);

		if(!Default_Config_Value.trim().equals("")) {
			setPluginConfig(driver, Plugin_Configuration_Module, Config_Change_Headers, Config_Filter_Condition, Config_Change_IDs, Default_Config_Value);
		}
		
		Extent_completed(testCaseName, test, test1);
	}
}
