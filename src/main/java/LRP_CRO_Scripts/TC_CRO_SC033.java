package LRP_CRO_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


public class TC_CRO_SC033 extends Keywords {

	public void CRO_SC033(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC033";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String PrintOutConfiguration_Module_Name = Excel_data.get("PrintOutConfiguration_Module_Name");
		String Band_Name = Excel_data.get("Band_Name");
		String ModuleName_Search = Excel_data.get("ModuleName_Search");
		String Updated_Popup_PC = Excel_data.get("Updated_Popup_PC");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String Global_Search_Type = Excel_data.get("Global_Search_Type");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String referenceType = Excel_data.get("ReferenceType");
		String referenceNumber = Excel_data.get("ReferenceNumber");
		String Acceptance_Terminal = Excel_data.get("Acceptance_Terminal");
		String Acceptance_TerminalDetails_Filter = Excel_data.get("Acceptance_TerminalDetails_Filter");

		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Enter the test URL", test, test1);
		Step_Start(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);
		
		LRP_Login(driver, Username, Password);

		Step_End(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_End(4, "Click on Login Button", test, test1);
		Step_Start(5, "Switch the agency", test, test1);
		
		SwitchProfile(driver, agencyUser);

		Step_End(5, "Switch the agency", test, test1);
		Step_Start(6, "Enter 'Booking' in 'Search Module' search box & select the module", test, test1);
		
		moduleNavigate(driver, Booking_Module_Name);

		Step_End(6, "Enter 'Booking' in 'Search Module' search box & select the module", test, test1);
		
//		Booking module
			Extent_cal(test, test1, Booking_Module_Name);

			Step_Start(7, "Enter the agr party", test, test1);
			
			waitForElement(driver, AgrPartyInput);
			sendKeys(driver, AgrPartyInput, arg_party);
			tab(driver);

			Step_End(7, "Enter the agr party", test, test1);
			Step_Start(8, "Enter the origin", test, test1);

			waitForElement(driver, OrginInput);
			sendKeys(driver, OrginInput, origin);
			tab(driver);

			Step_End(8, "Enter the origin", test, test1);
			Step_Start(9, "Enter the Delivery", test, test1);

			waitForElement(driver, DeliveryInput);
			sendKeys(driver, DeliveryInput, delivery);
			tab(driver);

			Step_End(9, "Enter the Delivery", test, test1);
			Step_Start(10, "Click the Rates", test, test1);
			Step_Start(11, "Select the rates", test, test1);

			// Rates 	
			bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

			Step_End(10, "Click the Rates", test, test1);
			Step_End(11, "Select the rates", test, test1);
			Step_Start(12, "Click the draft button and save", test, test1);

			waitForElement(driver, Draft_Button);
			click(driver, Draft_Button);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			Step_End(12, "Click the draft button and save", test, test1);
			Step_Start(13, "Validate the popup after save [BOOKING SAVED]", test, test1);

			waitForPopup(driver, popup_Message,savedpopEXP);
			String savepopACT = getText(driver, popup_Message);
			System.out.println(savepopACT);

			// Verify saved pop up of draft

			if (savepopACT.contains(savedpopEXP)) {
				System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is  :" + savepopACT);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is :" + savepopACT, test,test1);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP + "|| Actual Popup value is :" + savepopACT);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP + "|| Actual Popup value is:" + savepopACT, test,test1);
			}
			
			Step_End(13, "Validate the popup after save [BOOKING SAVED]", test, test1);
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
			Step_Start(15, "Click the edit Button", test, test1);

	//		Master tab		
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			System.out.println(" Printing the Booking number ");
			Extent_call(test, test1, " Printing the Booking number ");
			
			waitForElement(driver, booking_no);
			String booknum = getAttribute(driver, booking_no, "value");
			System.out.println(booknum);


				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
			
			Step_End(15, "Click the edit Button", test, test1);
			Step_Start(16, "Click Reference tab", test, test1);
			
			waitForElement(driver, Reference_Tab);
			click(driver, Reference_Tab);
			
			Step_End(16, "Click Reference tab", test, test1);
			Step_Start(17, "Select 3RD PARTY BKG REF NO. reference type", test, test1);
			
			List<String> refTypes = splitAndExpand(referenceType);

			waitForElement(driver, referencetyprselect);
			click(driver, referencetyprselect);
			
			formatLocatorClick(driver, DropDown_Select, refTypes.get(0));
			
			Step_End(17, "Select 3RD PARTY BKG REF NO. reference type", test, test1);
			Step_Start(18, "Enter Reference number", test, test1);
			
			List<String> refNumbers = splitAndExpand(referenceNumber);
			waitForElement(driver, referencenum);
			sendKeys(driver, referencenum, refNumbers.get(0));
			
			Step_End(18, "Enter Reference number", test, test1);
			Step_Start(19, "Click add button", test, test1);
			
			waitForElement(driver, referenceadd);
			click(driver, referenceadd);
			
			Step_End(19, "Click add button", test, test1);
			Step_Start(20, "Select SHIPPING ORDER NO.", test, test1);
			
			waitForElement(driver, referencetyprselect);
			click(driver, referencetyprselect);
			
			formatLocatorClick(driver, DropDown_Select, refTypes.get(1));
			
			Step_End(20, "Select SHIPPING ORDER NO.", test, test1);
			Step_Start(21, "Enter Reference number", test, test1);

			waitForElement(driver, referencenum);
			sendKeys(driver, referencenum, refNumbers.get(0));
			
			waitForElement(driver, referenceadd);
			click(driver, referenceadd);
			
			Step_End(21, "Enter Reference number", test, test1);
			Step_Start(22, "Autorates the charges", test, test1);
			
			
//		Charges tab
			
			waitForElement(driver, Charges_tab);
			mouseOverToElement(driver, Charges_tab);
			safeclick(driver, Charges_tab);
			
			waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);

			Step_End(22, "Autorates the charges", test, test1);


			Step_Start(23, "Click on save button", test, test1);
			Step_Start(24, "Switch to the master tab and click on confirm button", test, test1);
//		Master tab		
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			
			
			waitForElement(driver, Confirmed_Button);
			click(driver, Confirmed_Button);
		
			Step_End(24, "Switch to the master tab and click on confirm button", test, test1);
			Step_Start(25, "Click on Save Button", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

			Step_End(23, "Click on save button", test, test1);
			Step_End(25, "Click on Save Button", test, test1);
			Step_Start(26, "Validate the popup after clicking save button [BOOKING SAVED]", test, test1);
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
			
			Step_End(26, "Validate the popup after clicking save button [BOOKING SAVED]", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver,popup_Message_Ok_Button);
			Step_Start(27, "Validate the colour of Booking number field [Green colour]", test, test1);
			// validate the colour of booking number field after conform
			Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
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
		
			Step_End(27, "Validate the colour of Booking number field [Green colour]", test, test1);
			Step_Start(28, "Navigate to CRO module", test, test1);
			
//			Create CRO

			waitForElement(driver, CRO_btn);
			click(driver, CRO_btn);

			Step_End(28, "Navigate to CRO module", test, test1);
			Step_Start(29, "Select Release Depot/Terminal", test, test1);
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

			Step_End(29, "Select Release Depot/Terminal", test, test1);
			Step_Start(30, "Select Acceptance Terminal", test, test1);
			
			if(!Acceptance_Terminal.equals("")) {
				waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
				click(driver, acceptance_Terminal_SearchButton_CRO);
				twoColumnSearchWindow(driver, Acceptance_TerminalDetails_Filter, condition_Filter, Acceptance_Terminal);
			}
			
			
			Step_End(30, "Select Acceptance Terminal", test, test1);
			Step_Start(31, "Click save button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(31, "Click save button", test, test1);
			Step_Start(32, "CRO saved successfully message shown", test, test1);
			waitForElement(driver, Release_number_Input);
			String CRO_Release_Number = getAttribute(driver, Release_number_Input, "value");
			System.out.println("CRO_Release_NumberBefore :"+CRO_Release_Number);

			String actualpopup=getText(driver, Popup_Message);
			System.out.println("actualpopup : "+actualpopup);
			
			Step_End(32, "CRO saved successfully message shown", test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			Step_Start(33, "Go to printout configuration module", test, test1);

		moduleNavigate(driver, PrintOutConfiguration_Module_Name);

		Step_End(33, "Go to printout configuration module", test, test1);
		Step_Start(34, "Search CRO module.", test, test1);

		newButton(driver);

		waitForElement(driver, moduleName_Search_Dropdown);
		click(driver, moduleName_Search_Dropdown);
		
		formatLocatorClick(driver, DropDown_Select, ModuleName_Search);
		
		Step_End(34, "Search CRO module.", test, test1);
		Step_Start(35, "Click edit button.", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(35, "Click edit button.", test, test1);
		Step_Start(36, "Select ShpFwdBand checkbox", test, test1);

		String selectBand=String.format(band_Select, Band_Name);
		
		scrollElementToView(driver, selectBand);
		waitForElement(driver, selectBand);
		click(driver, selectBand);
			
		Step_End(36, "Select ShpFwdBand checkbox", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Updated_Popup_PC);
		String actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Updated_Popup_PC)) {
			System.out.println("Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup, test,test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Updated_Popup_PC + "|| Actual Popup :" + actualPopup, test,test1);
		}

		click(driver, popup_Message_Ok_Button);

//  CRO 
		Step_Start(37, "Go to Container release order module.", test, test1);

		moduleNavigate(driver, CRO_Module_Name);
		

		Step_End(37, "Go to Container release order module.", test, test1);
		Step_Start(38, "Click print button.", test, test1);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, Global_Search_Type, CRO_Release_Number, "", "", "", "");
		
		scrollTop(driver);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		
		Step_End(38, "Click print button.", test, test1);
		Step_Start(39, "Check shipper reference and forwarder reference no. in print", test, test1);

		
		Step_End(39, "Check shipper reference and forwarder reference no. in print", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
	}
