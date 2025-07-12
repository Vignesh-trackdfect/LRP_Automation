package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC044 extends Keywords {

	public void CRO_SC044(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC044";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Status = Excel_data.get("Status");
		String Plugin_ID_Value = Excel_data.get("Plugin_ID_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Plugin_column_Header = Excel_data.get("Plugin_column_Header");
		String Plugin_configuration_Module = Excel_data.get("Plugin_configuration_Module");
		String Release_Terminal_Value = Excel_data.get("Release_Terminal_Value");
		String releaseDepTerminal = Excel_data.get("releaseDepTerminal");
		String Release_Terminal_Code_Header = Excel_data.get("Release_Terminal_Code_Header");
		String terminalDetails_Filter = Excel_data.get("terminalDetails_Filter");
		String Condition = Excel_data.get("Condition");
		String Vendor_Name_Filter = Excel_data.get("Vendor_Name_Filter");
		String Vendor_Value = Excel_data.get("Vendor_Value");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");


		
		
		
		
		
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		
		Step_Start(1, "Open Plugin Configuration module", test, test1);
		Step_Start(2, "Search HAJ plugin", test, test1);
		Step_Start(3, "Set HAJ plugin to True", test, test1);
		Step_Start(4, "Click Save button", test, test1);
		Step_Start(5, "Validate 'Updated successfully' message is shown", test, test1);

		setPluginConfig(driver, Plugin_configuration_Module, Plugin_column_Header, Condition_Filter, Plugin_ID_Value, Status);

		Step_End(5, "Validate 'Updated successfully' message is shown", test, test1);
		Step_End(4, "Click Save button", test, test1);
		Step_End(3, "Set HAJ plugin to True", test, test1);
		Step_End(2, "Search HAJ plugin", test, test1);
		Step_End(1, "Open Plugin Configuration module", test, test1);


		Step_Start(6, "Go to Booking module", test, test1);
		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		
		Step_End(6, "Go to Booking module", test, test1);

		Step_Start(7, "Navigate to CRO module", test, test1);
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(7, "Navigate to CRO module", test, test1);

		Step_Start(8, "Click Edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(8, "Click Edit button", test, test1);

		Step_Start(9, "Select Release Depot/Terminal", test, test1);
		waitForElement(driver, Release_Terminal_SearchButton_CRO);
		click(driver, Release_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Release_Terminal_Code_Header, Condition_Filter, Release_Terminal_Value);
		Step_End(9, "Select Release Depot/Terminal", test, test1);

		Step_Start(10, "Select Acceptance Terminal", test, test1);
		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		twoColumnSearchWindow(driver, terminalDetails_Filter, Condition_Filter, releaseDepTerminal);
		Step_End(10, "Select Acceptance Terminal", test, test1);

		Step_Start(11, "Select Haulier", test, test1);
		waitForElement(driver, Haulier_Search_Button_CRO);
		click(driver, Haulier_Search_Button_CRO);
		globalValueSearchWindow(driver, Condition, Vendor_Name_Filter, Vendor_Value, "", "", "", "");
		Step_End(11, "Select Haulier", test, test1);

		Step_Start(12, "Click Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(12, "Click Save button", test, test1);

		Step_Start(13, "Validate 'CRO is saved' message is shown", test, test1);
		
		String CRO_Popup_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Popup_Act);
		if(CRO_Popup_Exp.equals(CRO_Popup_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}
		Step_End(13, "Validate 'CRO is saved' message is shown", test, test1);

		Step_Start(14, "Click Print button", test, test1);
		
		waitForElement(driver, print_Common_btn);
		click(driver, print_Common_btn);
		Step_End(14, "Click Print button", test, test1);

		Step_Start(15, "Check Haulier address in the print", test, test1);
		Step_End(15, "Check Haulier address in the print", test, test1);

		
		
	}

}
