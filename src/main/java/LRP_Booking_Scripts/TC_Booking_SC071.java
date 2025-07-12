package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC071 extends Keywords {

	///// check whether in Booking , based on ADB plugin configuration (True) CRO,OPERATION Done then  system allow to  delete the Booking
	public void Booking_SC071(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC071";

		//		Get data from excel sheet
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search");
		String agencyUser = Excel_data.get("agencyUser");
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
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginStatusTrue = Excel_data.get("PluginStatusTrue");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String wantToCancelPopup = Excel_data.get("WantToCancelPopup");		
		String remarks = Excel_data.get("Remarks");
		String bookingCancelledPopup = Excel_data.get("BookingCancelledPopup");		
		String cancelledBookingColor = Excel_data.get("RedColor");
		String cancelReason = Excel_data.get("CancelReason");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");

		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

// Login
	LRP_Login(driver, Username, Password);

//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		// Module search

		//Plugin Configuration module
		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, pluginConfigurationModule);

		Extent_cal(test, test1, pluginConfigurationModule);

		//Plugin Configuration True

		Step_Start(1, "ADB plugin configuration (True)", test, test1);	

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);
		
		waitForElement(driver, searched_pluginId);
		String actualPluginID=getText(driver, searched_pluginId);
		if(actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");
			
			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);
			
			formatLocatorClick(driver, pluginValue_Select, pluginStatusTrue);
			scrollTop(driver);
			waitForElement(driver,SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
	//   Verify Plugin Updated popup
			
			waitForElement(driver,Popup_Message);
			String actualUpdatedPopup=getText(driver, Popup_Message);
			System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
			if(actualUpdatedPopup.contains(pluginUpdatedPopup)){
				System.out.println("Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_pass_New(driver, "Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}
		
		waitForElement(driver, pluginConfiguration_Tab);
		click(driver, pluginConfiguration_Tab);
		
		waitForDisplay(driver, Module_Close);
		click(driver, Module_Close);
		
		Step_End(1, "ADB plugin configuration (True)", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, search_module);

//	Booking module
		Extent_cal(test, test1, search_module);

		Step_Start(2, "Enter The Agreement Party", test, test1);
		
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(2, "Enter The Agreement Party", test, test1);
		Step_Start(3, "Enter the POL and POD and select the Rates using Rates window", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(4, ".Select the Schedule ",test, test1);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		
		Step_End(4, "Select the Routing & Select the Schedule", test, test1);
		Step_Start(5, "Save the booking in Draft", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
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
		
//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");
		
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		Step_End(5, "Save the booking in Draft", test, test1);
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "select confirm button and click Save button(Confirm the Booking)", test, test1);
//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		
		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);


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
		Step_End(8, "Click conform and save the booking ",test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);
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
		
		Step_End(7, "select confirm button and click Save button(Confirm the Booking)", test, test1);

		Step_Start(8, "Release CRO", test, test1);

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

		Step_End(8, "Release CRO", test, test1);

		//		Delete Booking
		Step_Start(9, "Delete Booking", test, test1);

		waitForElement(driver, booking_Tab);
		click(driver,booking_Tab);

		scrollTop(driver);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		waitForPopup(driver, popup_Message,wantToCancelPopup);
			String actualWantToCancelPopup=getText(driver, popup_Message);
			if(actualWantToCancelPopup.equals(wantToCancelPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup, test,test1);
				System.out.println("Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup);

				click(driver, popup_Message_Yes_Button);
			}else {
				System.out.println("Not Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup, test,test1);
			}

		waitForDisplay(driver, bookingCancelRemarks_Frame);		
		if(isdisplayed(driver, bookingCancelRemarks_Frame)) {
			if(isdisplayed(driver, cancelledreason)) {
				waitForElement(driver, cancelledreason)	;
				click(driver, cancelledreason);
				String remarks_reason=String.format(remarks_Reason, cancelReason);
				waitForElement(driver, remarks_reason);
				click(driver, remarks_reason);
				waitForElement(driver, remarksTextBox);

				sendKeys(driver, remarksTextBox, remarks);
				waitForElement(driver, remarks_Ok_Button);
				click(driver, remarks_Ok_Button);
			}
		}
		
		waitForPopup(driver, popup_Message,bookingCancelledPopup);
			String actualCancelledPopup=getText(driver, popup_Message);
			if(actualCancelledPopup.equals(bookingCancelledPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup, test,test1);
				System.out.println("Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup);

				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup, test,test1);
			}

		waitForElement(driver, Booking_No_Field);
		String actualCancelledColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String actualCancelledColor=getColorName(actualCancelledColorCode);
		if(actualCancelledColor.equalsIgnoreCase(cancelledBookingColor)) {
			Extent_pass_New(driver,"Matched || The background color of Cancelled Booking number textfield is red || Expected color code : " +cancelledBookingColor+" || Actual color code : "+actualCancelledColor, test,test1);
			System.out.println("Matched || The background color of Cancelled Booking number textfield is red");
			Extent_pass_New(driver, "Booking Cancelled  based on ADB plugin configuration (True) CRO Done", test,test1);
		}else {
			System.out.println("Not Matched || The background color of Cancelled Booking number textfield is not red");
			Extent_fail(driver,"Not Matched || The background color of Cancelled Booking number textfield is not red|| Expected color code : " +cancelledBookingColor+" || Actual color code : "+actualCancelledColor +"<br>"+"Booking Cancelled  based on ADB plugin configuration (True) CRO Done", test,test1);
		}	
		
		Step_End(9, "Delete Booking", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
	}
