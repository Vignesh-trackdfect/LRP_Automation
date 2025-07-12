package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC024 extends Keywords {

	public void CRO_SC024(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC024";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Plugin_config_Module_Name = Excel_data.get("Plugin_config_Module_Name");
		String Plugin_column_Header = Excel_data.get("Plugin_column_Header");
		String Plugin_Condition = Excel_data.get("Plugin_Condition");
		String PluginId_Input = Excel_data.get("PluginId_Input");
		String Enable_Status = Excel_data.get("Enable_Status");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String TerminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String condition_Filter = Excel_data.get("condition_Filter");
		String ReleaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Global_Search_Type = Excel_data.get("Global_Search_Type");

		Extent_Start(testCaseName, test, test1);
	
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		Step_Start(1, "Open Agency master module", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Open Agency master module", test, test1);

		Step_Start(2, "Search Agency/Branch code", test, test1);
		Step_Start(3, "Check address details", test, test1);

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if(!ReleaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, ReleaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, acc_term_value);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		String CRO_Popup_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Popup_Act);
		if(CRO_Popup_Exp.equals(CRO_Popup_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}

		
		waitForElement(driver, Release_No_CRO);
		String CRO_Release_Number = getAttribute(driver, Release_No_CRO, "value");
		System.out.println("CRO_Release_NumberBefore :"+CRO_Release_Number);
		Step_End(2, "Search Agency/Branch code", test, test1);
		Step_End(3, "Check address details", test, test1);
		
		Step_Start(4, "Open plugin configuration", test, test1);
		Step_Start(5, "Search DDL plugin and double click the record", test, test1);
		Step_Start(6, "Set the plugin as true", test, test1);
		Step_Start(7, "Clcik save button", test, test1);
		Step_Start(8, "Updated successfully message shown", test, test1);


		setPluginConfig(driver, Plugin_config_Module_Name, Plugin_column_Header, Plugin_Condition, PluginId_Input, Enable_Status);
		
		
		Step_End(4, "Open plugin configuration", test, test1);
		Step_End(5, "Search DDL plugin and double click the record", test, test1);
		Step_End(6, "Set the plugin as true", test, test1);
		Step_End(7, "Clcik save button", test, test1);
		Step_End(8, "Updated successfully message shown", test, test1);
		
		
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		waitForElement(driver,Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(9, "Go to Container release order module", test, test1);

		moduleNavigate(driver, CRO_Module_Name);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);
	
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, GlobalSearch_Condition,Global_Search_Type ,CRO_Release_Number , "", "", "", "");
		Step_End(9, "Go to Container release order module", test, test1);

		Step_Start(9, "Click print button", test, test1);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(9, "Click print button", test, test1);

		
		
}
}