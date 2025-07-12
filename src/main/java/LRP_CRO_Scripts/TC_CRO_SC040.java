package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC040 extends Keywords {

	public void CRO_SC040(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC040";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String savedpopEXP_draft = Excel_data.get("savedpopEXP_draft");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String first_service_data = Excel_data.get("first_service_data");
		String rate_no = Excel_data.get("rate_no");
		String Updated_Popup_PC = Excel_data.get("Updated_Popup_PC");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String delivery = Excel_data.get("delivery");
		String origin = Excel_data.get("origin");
		String arg_party = Excel_data.get("arg_party");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String Band_Name = Excel_data.get("Band_Name");
		String ModuleName_Search = Excel_data.get("ModuleName_Search");
		String PrintOutConfiguration_Module_Name = Excel_data.get("PrintOutConfiguration_Module_Name");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");
		String releaseDepTerminal = Excel_data.get("releaseDepTerminal");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String terminalDetails_Filter = Excel_data.get("terminalDetails_Filter");
		String Release_Terminal_Value = Excel_data.get("Release_Terminal_Value");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String Release_Terminal_Code_Header = Excel_data.get("Release_Terminal_Code_Header");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Ref_Input = Excel_data.get("Ref_Input");
		String Ref_Type = Excel_data.get("Ref_Type");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String CRO_Filter_Type = Excel_data.get("CRO_Filter_Type");
		String Global_Condition = Excel_data.get("Global_Condition");


		
		
		
		
		Extent_Start(testCaseName, test, test1);
		
		
		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);
		navigateUrl(driver, url);
		Step_End(2, "Enter the test URL", test, test1);
		Step_End(1, "Open the browser", test, test1);


		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Step_End(4, "Click on Login Button", test, test1);
		Step_End(3, "Enter valid Username & Password in respective text fields", test, test1);


		Step_Start(5, "Switch the agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(5, "Switch the agency", test, test1);

		Step_Start(6, "Enter 'Booking' in 'Search Module' search box & select the module", test, test1);
		moduleNavigate(driver, Booking_Module_Name);
		Step_End(6, "Enter 'Booking' in 'Search Module' search box & select the module", test, test1);

		
		Step_Start(7, "Enter the AGR Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(7, "Enter the AGR Party", test, test1);

		Step_Start(8, "Enter the Origin", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		Step_End(8, "Enter the Origin", test, test1);

		Step_Start(9, "Enter the Delivery", test, test1);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		Step_End(9, "Enter the Delivery", test, test1);

		Step_Start(10, "Click the Rates", test, test1);
		Step_Start(11, "Select the Rates", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		Step_End(11, "Select the Rates", test, test1);
		Step_End(10, "Click the Rates", test, test1);


		Step_Start(12, "Click the Draft button and Save", test, test1);
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		
		Step_End(12, "Click the Draft button and Save", test, test1);

		Step_Start(13, "Validate the popup after saving [BOOKING SAVED]", test, test1);
		waitForPopup(driver, popup_Message,savedpopEXP_draft);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savedpopEXP_draft.contains(savepopACT)) {
			System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP_draft + "|| Actual Popup value is  :" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP_draft + "|| Actual Popup value is :" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP_draft + "|| Actual Popup value is :" + savepopACT);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP_draft + "|| Actual Popup value is:" + savepopACT, test,test1);
		}
		Step_End(13, "Validate the popup after saving [BOOKING SAVED]", test, test1);

		Step_Start(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);
		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		}
		Step_End(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);

		Step_Start(15, "Switch to the Container tab", test, test1);
		
		waitForElement(driver, container_tab);
		click(driver, container_tab);
		Step_End(15, "Switch to the Container tab", test, test1);

		Step_Start(16, "Click the Edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(16, "Click the Edit button", test, test1);

		Step_Start(17, "Click References tab", test, test1);
		waitForElement(driver, referencetab);
		click(driver, referencetab);
		Step_End(17, "Click References tab", test, test1);

		Step_Start(18, "Select reference type as EMPTY PICK UP REFERENCE NO.", test, test1);
		waitForElement(driver, Reference_Type_Dropdown);
		click(driver, Reference_Type_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Ref_Type);
		
		Step_End(18, "Select reference type as EMPTY PICK UP REFERENCE NO.", test, test1);

		Step_Start(19, "Enter the Reference No.", test, test1);
		waitForElement(driver, Reference_No_TF);
		click(driver, Reference_No_TF);
		sendKeys(driver, Reference_No_TF, Ref_Input);

		Step_End(19, "Enter the Reference No.", test, test1);

		Step_Start(20, "Auto-rate the charges", test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		

		
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		Step_End(20, "Auto-rate the charges", test, test1);

		Step_Start(21, "Click on Save button", test, test1);
		waitForElement(driver, master_tab);

		Step_End(21, "Click on Save button", test, test1);

		Step_Start(22, "Switch to the Master tab and click on Confirm button", test, test1);
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		
		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
	
		
		Step_End(22, "Switch to the Master tab and click on Confirm button", test, test1);

		Step_Start(23, "Click on Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		Step_End(23, "Click on Save button", test, test1);

		Step_Start(24, "Validate the popup after clicking save button [BOOKING SAVED]", test, test1);
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String saved_conformed_pop_act = getText(driver, popup_Message);
		System.out.println(saved_conformed_pop_act);
		// validate the saved conform popup
		System.out.println("**********Verifting the saved popup **********");
		Extent_call(test, test1,"**********Verifting the saved popup**********");
		if (saved_conformed_pop_act.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1); 
		} 
		
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);
		Step_End(24, "Validate the popup after clicking save button [BOOKING SAVED]", test, test1);

		Step_Start(25, "Validate the colour of Booking number field [Green Colour]", test, test1);
		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);
		if (Confirm_bookingColor.equalsIgnoreCase(booking_confirmed_Color)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		} 
		Step_End(25, "Validate the colour of Booking number field [Green Colour]", test, test1);

		Step_Start(26, "Navigate to CRO button", test, test1);
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		Step_End(26, "Navigate to CRO button", test, test1);

		Step_Start(27, "Click Edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(27, "Click Edit button", test, test1);

		Step_Start(28, "Select Release Depot/Terminal", test, test1);
		waitForElement(driver, Release_Terminal_SearchButton_CRO);
		click(driver, Release_Terminal_SearchButton_CRO);
		twoColumnSearchWindow(driver, Release_Terminal_Code_Header, Condition_Filter, Release_Terminal_Value);
		Step_End(28, "Select Release Depot/Terminal", test, test1);

		Step_Start(29, "Select Acceptance Terminal", test, test1);
		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		twoColumnSearchWindow(driver, terminalDetails_Filter, Condition_Filter, releaseDepTerminal);
		Step_End(29, "Select Acceptance Terminal", test, test1);

		Step_Start(30, "Click Save button", test, test1);
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
		System.out.println("CRO_Release_Number :"+CRO_Release_Number);
		
		
		Step_End(30, "Click Save button", test, test1);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_Start(31, "Open Printout Configuration module", test, test1);
		moduleNavigate(driver, PrintOutConfiguration_Module_Name);

		Step_End(31, "Open Printout Configuration module", test, test1);

		Step_Start(32, "Search CRO module", test, test1);

		newButton(driver);

		waitForElement(driver, moduleName_Search_Dropdown);
		click(driver, moduleName_Search_Dropdown);
		formatLocatorClick(driver, DropDown_Select, ModuleName_Search);

		Step_End(32, "Search CRO module", test, test1);

		Step_Start(33, "Click Edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(33, "Click Edit button", test, test1);

		Step_Start(34, "Click TransoptBand checkbox", test, test1);
		String selectBand=String.format(band_Select, Band_Name);
		
		
		scrollElementToView(driver, selectBand);
		
	if (isElementEnabled(driver, selectBand)) {
		waitForElement(driver, selectBand);
		click(driver, selectBand);
	}	
		Step_End(34, "Click TransoptBand checkbox", test, test1);

		Step_Start(35, "Click Save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(35, "Click Save button", test, test1);

		Step_Start(36, "Validate 'Printout Configuration updated' message is shown", test, test1);
		waitForPopup(driver, popup_Message, Updated_Popup_PC);
		String actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Updated_Popup_PC)) {
			System.out.println("Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup, test,test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Updated_Popup_PC + "|| Actual Popup :" + actualPopup, test,test1);
		}
		Step_End(36, "Validate 'Printout Configuration updated' message is shown", test, test1);

		Step_Start(37, "Click OK button", test, test1);
		click(driver, popup_Message_Ok_Button);

		Step_End(37, "Click OK button", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_Start(38, "Go to Container Release Order module", test, test1);
		moduleNavigate(driver, CRO_Module_Name);
		Step_End(38, "Go to Container Release Order module", test, test1);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Global_Condition, CRO_Filter_Type, CRO_Release_Number, "", "", "", "");
		Step_Start(39, "Click Print button", test, test1);
		waitForElement(driver, print_Common_btn);
		click(driver, print_Common_btn);
		Step_End(39, "Click Print button", test, test1);

		Step_Start(40, "Check the Empty Pickup Reference No. details in the print", test, test1);
		Step_End(40, "Check the Empty Pickup Reference No. details in the print", test, test1);

		
		Extent_completed(testCaseName, test, test1);
	}

}
