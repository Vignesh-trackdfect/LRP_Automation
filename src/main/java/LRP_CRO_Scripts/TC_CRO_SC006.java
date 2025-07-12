package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC006 extends Keywords {

	public void CRO_SC006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC006";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String Booking_Number_Filter = Excel_data.get("Booking_Number_Filter");
		String Global_Condition = Excel_data.get("Global_Condition");






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


		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if(!releaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, acc_term_value);
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


		waitForElement(driver, Booking_No_Field_CRO);
		String Booking_Number = getAttribute(driver, Booking_No_Field_CRO, "value");
		System.out.println("CRO Booking Number : "+Booking_Number);

		waitForElement(driver, Release_No_CRO);
		String CRO_Release_NumberBefore = getAttribute(driver, Release_No_CRO, "value");
		System.out.println("CRO_Release_NumberBefore :"+CRO_Release_NumberBefore);
		Step_Start(1, "Close the CRO module", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(1, "Close the CRO module", test, test1);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_Start(2, "Go to booking module", test, test1);
		moduleNavigate(driver, Booking_Module_Name);
		Step_End(2, "Go to booking module", test, test1);
		
		
		Step_Start(3, "Retrive the book number in booking module", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Global_Condition, Booking_Number_Filter, Booking_Number, "", "", "", "");
		Step_End(3, "Retrive the book number in booking module", test, test1);

		
		Step_Start(4, "Navigate CRO from booking using CRO Number", test, test1);
		formatLocatorDoubleClick(driver, CRO_Number_BKG, CRO_Release_NumberBefore);
		Step_End(4, "Navigate CRO from booking using CRO Number", test, test1);

		Step_Start(5, "CRO navigated from booking", test, test1);
		waitForElement(driver, Release_No_CRO);
		String CRO_Release_NumberAfter = getAttribute(driver, Release_No_CRO, "value");
		System.out.println("CRO_Release_NumberAfter :"+CRO_Release_NumberAfter);

		if(CRO_Release_NumberBefore.equals(CRO_Release_NumberAfter)) {
			System.out.println("Expected Result is : Clicking the CRO number in the Booking module should navigate to the CRO module. || CRO Number : "+CRO_Release_NumberBefore + "|| Actual Result is : Clicking the CRO number in the Booking module navigated  to the CRO module.|| CRO Number : "+CRO_Release_NumberAfter );
		     
			Extent_pass_New(driver, "Expected Result is : Clicking the CRO number in the Booking module should navigate to the CRO module. || CRO Number : "+CRO_Release_NumberBefore + "|| Actual Result is : Clicking the CRO number in the Booking module navigated  to the CRO module.|| CRO Number : "+CRO_Release_NumberAfter , test, test1);
		}else {
			System.out.println("Expected Result is : Clicking the CRO number in the Booking module should navigate to the CRO module. || CRO Number : "+CRO_Release_NumberBefore + "|| Actual Result is : Clicking the CRO number in the Booking module navigated  to the CRO module.|| CRO Number : "+CRO_Release_NumberAfter );
			Extent_fail(driver, "Expected Result is : Clicking the CRO number in the Booking module should navigate to the CRO module. || CRO Number : "+CRO_Release_NumberBefore + "|| Actual Result is : Clicking the CRO number in the Booking module navigated  to the CRO module.|| CRO Number : "+CRO_Release_NumberAfter , test, test1);
		}
 
		Step_End(5, "CRO navigated from bookings", test, test1);



		Extent_completed(testCaseName, test, test1);






	}

}
