package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC018 extends Keywords {

	public void CRO_SC018(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC018";

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

		String Plugin_Configuration_Module = Excel_data.get("Plugin_Configuration_Module");
		String Config_Change_Headers = Excel_data.get("Config_Change_Headers");
		String Config_Change_IDs = Excel_data.get("Config_Change_IDs");
		String Config_Change_Value = Excel_data.get("Config_Change_Value");
		String Default_Config_Value = Excel_data.get("Default_Config_Value");
		String Config_Filter_Condition = Excel_data.get("Config_Filter_Condition");
		
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String Agr_Party = Excel_data.get("Agr_Party");
		String delivery = Excel_data.get("delivery");
		String origin = Excel_data.get("origin");
		String rate_no = Excel_data.get("rate_no");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");

		
				
		Extent_Start(testCaseName, test, test1);
		
		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);
		navigateUrl(driver, url);
		Step_End(2, "Enter the test URL", test, test1);
		Step_End(1, "Open the browser", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_Start(4, "Click on Login Button ", test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		Step_End(4, "Click on Login Button ", test, test1);
		Step_End(3, "Enter valid Username & Password in respective textfields", test, test1);

		Step_Start(5, "Switch the agency", test, test1);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);
		Step_End(5, "Switch the agency", test, test1);

		Step_Start(6, "Opent the Plugin Configuration Module", test, test1);
		Step_Start(7, "Search ACS plugin ", test, test1);
		Step_Start(8, "Double click the record and edit.", test, test1);
		Step_Start(9, "Set to true.", test, test1);
		Step_Start(10, "Click save button.", test, test1);
		Step_Start(11, "Updated successfully message shown and click ok button.", test, test1);
		
		setPluginConfig(driver, Plugin_Configuration_Module, Config_Change_Headers, Config_Filter_Condition, Config_Change_IDs, Config_Change_Value);
		
		Step_End(11, "Updated successfully message shown and click ok button.", test, test1);
		Step_End(10, "Click save button.", test, test1);
		Step_End(9, "Set to true.", test, test1);
		Step_End(8, "Double click the record and edit.", test, test1);
		Step_End(7, "Search ACS plugin ", test, test1);
		Step_End(6, "Opent the Plugin Configuration Module", test, test1);

		Step_Start(12, " Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);		
		moduleNavigate(driver, Booking_Module_Name);
		Step_End(12, " Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);

		Step_Start(13, "Enter the agr party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agr_Party);
		tab(driver);
		Step_End(13, "Enter the agr party", test, test1);

		Step_Start(14, "Enter the orgin", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		Step_End(14, "Enter the orgin", test, test1);

		Step_Start(15, "Enter the Delivery", test, test1);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(15, "Enter the Delivery", test, test1);

		// Rates 
		Step_Start(16, "Click the Rates", test, test1);
		Step_Start(17, "Select the SOC Y rates ", test, test1);
		
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(17, "Select the SOC Y rates ", test, test1);
		Step_End(16, "Click the Rates", test, test1);

		Step_Start(18, "Click the draft button and save ", test, test1);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(18, "Click the draft button and save ", test, test1);

		Step_Start(19, "Validate the pop up  after  saved  [BOOKING SAVED]", test, test1);
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
		Step_End(19, "Validate the pop up  after  saved  [BOOKING SAVED]", test, test1);

		Step_Start(20, "Validate the colour of Booking number field [Yellow Colour]", test, test1);

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
		Step_End(20, "Validate the colour of Booking number field [Yellow Colour]", test, test1);
       

		Step_Start(22, "Click the edit Button", test, test1);
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		Extent_call(test, test1, "Booking Number : "+booknum);
		System.out.println(booknum);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(22, "Click the edit Button", test, test1);

		Step_Start(21, "Swift to the Charges tab ", test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		Step_End(21, "Swift to the Charges tab ", test, test1);

		Step_Start(23, "Autorates the charges", test, test1);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(23, "Autorates the charges", test, test1);

		//	Master tab	
		Step_Start(24, "Click on save button", test, test1);
		Step_Start(25, "Swift to tha master tab and click on conform button", test, test1);
		Step_Start(26, "Click on Save Button", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);
		
		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		Step_End(26, "Click on Save Button", test, test1);
		Step_End(25, "Swift to tha master tab and click on conform button", test, test1);
		Step_End(24, "Click on save button", test, test1);

		Step_Start(27, "Validate the popup After clicking save button[BOOKING SAVED]", test, test1);
		
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
		Step_End(27, "Validate the popup After clicking save button[BOOKING SAVED]", test, test1);

		Step_Start(28, "Validate the colour of Booking number field [Green colour]", test, test1);
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
		Step_End(28, "Validate the colour of Booking number field [Green colour]", test, test1);

		Step_Start(29, "Go to CRO module and Search the Booking Number", test, test1);

		moduleNavigate(driver, CRO_ModuleName);
		
		waitForElement(driver, booking_No_SearchButton_CRO);
		click(driver,booking_No_SearchButton_CRO);
		
		globalValueSearchWindow(driver, Global_Search_Condition, CRO_Global_Search_Type, booknum, "", "", "", "");
		
		Step_End(29, "Go to CRO module and Search the Booking Number", test, test1);

		Step_Start(30, "Click edit button.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(30, "Click edit button.", test, test1);

		Step_Start(31, "Select Release Depot/Terminal", test, test1);
		if(!releaseDepTerminal.trim().equals("")) {
			waitForElement(driver, rel_terminal_searchicon);
			click(driver, rel_terminal_searchicon);
			twoColumnSearchWindow(driver, ReleaseTerminal_Header, condition_Filter, releaseDepTerminal);
		}
		Step_End(31, "Select Release Depot/Terminal", test, test1);

		Step_Start(32, "Select Acceptance Terminal.", test, test1);
		if(!AcceptanceTerminal.trim().equals("")) {
			waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
			click(driver, acceptance_Terminal_SearchButton_CRO);
			twoColumnSearchWindow(driver, AcceptanceTerminal_Header, condition_Filter, AcceptanceTerminal);
		}
		Step_End(32, "Select Acceptance Terminal.", test, test1);

		Step_Start(33, "Click save button.", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver,SaveButton_ToolBar);
		Step_End(33, "Click save button.", test, test1);

		Step_Start(34, "CRO is saved message shown.", test, test1);
		String Act_ETA_Popup=getText(driver, Popup_Message);
		if(CRO_Saved_Popup.equalsIgnoreCase(Act_ETA_Popup)) {
			System.out.println("Popup Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup);
			Extent_pass_New(driver, "Popup Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup, test, test1);
		}else {
			System.out.println("Popup Not Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup);
			Extent_fail(driver, "Popup Not Matched || Expected : "+CRO_Saved_Popup+" || Actual : "+Act_ETA_Popup, test, test1);
		}
		Step_End(34, "CRO is saved message shown.", test, test1);

		
		Step_Start(35, "Go to plugin configuration module.", test, test1);
		Step_Start(36, "Search ACS plugin and double click the record.", test, test1);
		Step_Start(37, "Set ACS plugin to false.", test, test1);
		Step_Start(38, "Click save button.", test, test1);
		Step_Start(39, "Updated successfully message shown and click ok button", test, test1);
		
		if(!Default_Config_Value.trim().equals("")) {
			setPluginConfig(driver, Plugin_Configuration_Module, Config_Change_Headers, Config_Filter_Condition, Config_Change_IDs, Default_Config_Value);
		}
		Step_End(39, "Updated successfully message shown and click ok button", test, test1);
		Step_End(38, "Click save button.", test, test1);
		Step_End(37, "Set ACS plugin to false.", test, test1);
		Step_End(36, "Search ACS plugin and double click the record.", test, test1);
		Step_End(35, "Go to plugin configuration module.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
}
