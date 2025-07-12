package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC010 extends Keywords {

	public void CRO_SC010(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC010";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String releaseDepTerminal = Excel_data.get("releaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("terminalDetails_Filter");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");
		String AcceptedDepTerminal = Excel_data.get("AcceptedDepTerminal");		

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);


		//		Booking module

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);

	
		//	Create CRO
		Step_Start(1, "Navigate to CRO from Booking screen", test, test1);


		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(1, "Navigate to CRO from Booking screen", test, test1);

		Step_Start(2, "Click 'Edit' button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(2, "Click 'Edit' button", test, test1);

		Step_Start(3, "Select 'Release Depot/Terminal'", test, test1);
		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
		Step_End(3, "Select 'Release Depot/Terminal'", test, test1);

		Step_Start(4, "Select 'Acceptance Terminal'", test, test1);
		waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
		click(driver, acceptance_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, AcceptedDepTerminal);
		Step_End(4, "Select 'Acceptance Terminal'", test, test1);

		
		Step_Start(5, "Click 'Save' button", test, test1);


		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(5, "Click 'Save' button", test, test1);
		Step_Start(6, "Validate 'CRO is saved' message is shown", test, test1);


		String CRO_Popup_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Popup_Act);
		if(CRO_Popup_Exp.equals(CRO_Popup_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}
		
		Step_End(6, "Validate 'CRO is saved' message is shown", test, test1);
		Step_Start(7, "Click 'Print' button", test, test1);

		
		waitForElement(driver, print_Common_btn);
		click(driver, print_Common_btn);
		Step_End(7, "Click 'Print' button", test, test1);

		Step_Start(8, "Validate system allows printing correctly", test, test1);
		Step_End(8, "Validate system allows printing correctly", test, test1);


		Extent_completed(testCaseName, test, test1);
	}

}
