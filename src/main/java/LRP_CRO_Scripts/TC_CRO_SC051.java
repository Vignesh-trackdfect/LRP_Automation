package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC051 extends Keywords {

	public void CRO_SC051(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC051";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Plugin_configuration_Module = Excel_data.get("Plugin_configuration_Module");
		String Plugin_column_Header = Excel_data.get("Plugin_column_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Status = Excel_data.get("Status");
		String Plugin_ID_Value = Excel_data.get("Plugin_ID_Value");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String Port_Value = Excel_data.get("Port_Value");
		String Ports_Header = Excel_data.get("Ports_Header");
		String Release_Terminal_Code_Header = Excel_data.get("Release_Terminal_Code_Header");
		String Release_Terminal_Value = Excel_data.get("Release_Terminal_Value");
		String releaseDepTerminal = Excel_data.get("releaseDepTerminal");
		String terminalDetails_Filter = Excel_data.get("terminalDetails_Filter");
		String Equipment_Type_Header = Excel_data.get("Equipment_Type_Header");
		String Equipment_Type_Value = Excel_data.get("Equipment_Type_Value");
		String Quantity_Value = Excel_data.get("Quantity_Value");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");



		



		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

	
	
		
		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);

		navigateUrl(driver, url);
		Step_End(2, "Enter the test URL", test, test1);
		Step_End(1, "Open the browser", test, test1);


		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Step_End(4, "Click on Login Button", test, test1);
		Step_End(3, "Enter valid Username & Password in respective text fields", test, test1);


		Step_Start(5, "Click on Switch Profile button on Home page", test, test1);
		Step_Start(6, "Enter Agency code in code search field & click on Select button", test, test1);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);
		Step_End(6, "Enter Agency code in code search field & click on Select button", test, test1);
		Step_End(5, "Click on Switch Profile button on Home page", test, test1);


		Step_Start(7, "Enter 'Plugin Configuration' in 'Search Module' search box & select the module", test, test1);
		Step_Start(8, "Search CBL plugin and double-click the record", test, test1);
		Step_Start(9, "Click Edit button", test, test1);
		Step_Start(10, "Change status to true and click Save button", test, test1);
		Step_Start(11, "Validate 'Updated successfully' message is shown", test, test1);

		setPluginConfig(driver, Plugin_configuration_Module, Plugin_column_Header, Condition_Filter, Plugin_ID_Value, Status);
		Step_End(11, "Validate 'Updated successfully' message is shown", test, test1);
		Step_End(10, "Change status to true and click Save button", test, test1);
		Step_End(9, "Click Edit button", test, test1);
		Step_End(8, "Search CBL plugin and double-click the record", test, test1);
		Step_End(7, "Enter 'Plugin Configuration' in 'Search Module' search box & select the module", test, test1);





		Step_Start(12, "Open the Container Release Order module", test, test1);
		moduleNavigate(driver, CRO_Module_Name);
		Step_End(12, "Open the Container Release Order module", test, test1);

		Step_Start(13, "Check 'CRO without Booking' option", test, test1);
		waitForElement(driver, CRO_Without_Booking_Radio_Button);
		click(driver, CRO_Without_Booking_Radio_Button);
		Step_End(13, "Check 'CRO without Booking' option", test, test1);

		Step_Start(14, "Select PORT in Port option", test, test1);
		waitForElement(driver, Ports_Search_Button_CRO);
		click(driver, Ports_Search_Button_CRO);
		twoColumnSearchWindow(driver, Ports_Header, Condition_Filter, Port_Value);
		Step_End(14, "Select PORT in Port option", test, test1);

		Step_Start(15, "Select Release Depot/Terminal", test, test1);
		waitForElement(driver, Release_Terminal_SearchButton_CRO);
		click(driver, Release_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Release_Terminal_Code_Header, Condition_Filter, Release_Terminal_Value);
		Step_End(15, "Select Release Depot/Terminal", test, test1);

		Step_Start(16, "Select Acceptance Terminal", test, test1);
		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		twoColumnSearchWindow(driver, terminalDetails_Filter, Condition_Filter, releaseDepTerminal);
		Step_End(16, "Select Acceptance Terminal", test, test1);

		
		scrollBottom(driver);
		Step_Start(17, "Select Equipment Profile using 'By Type' option", test, test1);
		waitForElement(driver, By_Type_Search_Button_CRO);
		click(driver, By_Type_Search_Button_CRO);
		twoColumnSearchWindow(driver, Equipment_Type_Header, Condition_Filter, Equipment_Type_Value);
		Step_End(17, "Select Equipment Profile using 'By Type' option", test, test1);

		Step_Start(18, "Enter Quantity", test, test1);
		waitForElement(driver, Quantity_TF_CRO);
		click(driver, Quantity_TF_CRO);
		sendKeys(driver, Quantity_TF_CRO, Quantity_Value);
		Step_End(18, "Enter Quantity", test, test1);

		Step_Start(19, "Click Add button", test, test1);
		waitForElement(driver, Add_Button_CRO);
		click(driver, Add_Button_CRO);
		Step_End(19, "Click Add button", test, test1);

		scrollTop(driver);
		Step_Start(20, "Click Save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(20, "Click Save button", test, test1);

		Step_Start(21, "Validate 'CRO is saved' message is shown", test, test1);

		
		String CRO_Popup_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Popup_Act);
		if(CRO_Popup_Exp.equals(CRO_Popup_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}

		Step_End(21, "Validate 'CRO is saved' message is shown", test, test1);

		Step_Start(22, "Click Print button", test, test1);
		
		waitForElement(driver, print_Common_btn);
		click(driver, print_Common_btn);
		Step_End(22, "Click Print button", test, test1);

		Step_Start(23, "Validate CRO number is displayed in Booking Number field", test, test1);
		Step_End(23, "Validate CRO number is displayed in Booking Number field", test, test1);

		
		
		
		
	}

}
