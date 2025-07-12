package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC015 extends Keywords {
	///// check whether when Retrieve the Record in Global Search system should list the ALL Agency Records
	public void Booking_SC015(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)throws Exception {
		String test_Case_Name="TC_Booking_SC015";
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
		String allAgencySearch = Excel_data.get("AllAgencySearch");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearchFilterOption1=Excel_data.get("GlobalSearchFilterOption1");
		String globalSearchFilterOption2=Excel_data.get("GlobalSearchFilterOption2");
		String globalSearchFilterOption3=Excel_data.get("GlobalSearchFilterOption3");
		String searchValue2=Excel_data.get("searchValue2");
		String searchValue3=Excel_data.get("searchValue3");
		
		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
		// Login
		LRP_Login(driver, Username, Password);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);
		// Module search
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, search_module);
		//		Booking module
		Step_Start(1, " Enter The Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, " Enter The Agreement Party", test, test1);				
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(4, "Select the Schedule ", test, test1);
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		Step_Start(5, "Save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// Verification of saved popup of draft
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		Extent_cal(test, test1,"**********Verifting the saved popup**********");
		if(savepopACT.contains(savedpopEXP)) {                                                                                                                  
			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_End(5, "save the booking in Draft",test, test1);
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
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		Extent_call(test, test1,"********** Pinting the Booking number*******");
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);
		Extent_pass_New(driver, "****Booking number was generated as****"+booknum, test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		waitForElement(driver, booking_status_field);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		Step_Start(6, "AutoRate the charges in Charge tab",test, test1);
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(6, "AutoRate the charges in Charge tab",test, test1);
		Step_Start(7, "Select Confirm Button And Click Save Button(Confirm the Booking)",test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// verify the popup for booking saved
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup=getText(driver, popup_Message);
		if(actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || Actual Pop-up value is : "+actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || Actual Pop-up value is : "+actualUpdatedPopup);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || But Actual Pop-up value is : "+actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || But Actual Pop-up value is : "+actualUpdatedPopup, test,test1);
		}		
		waitForElement(driver, booking_no);	
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String submit_bookingColor=getColorName(actualConfirmedColorCode);
		if(submit_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		Step_End(7, "Select Confirm Button And Click Save Button(Confirm the Booking)", test, test1);
		Step_Start(8, "Retrieve The Record In Global Search", test, test1);
		// Global search
		scrollTop(driver);
		waitForDisplay(driver, NewButton_ToolBar);	
		if(isDisplayed(driver, NewButton_ToolBar) && isElementAccessible(driver, NewButton_ToolBar)) {
		click(driver, NewButton_ToolBar);
		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);			
		}
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		waitForElement(driver, globalSearch_Frame);
		if (isDisplayed(driver, globalSearch_Frame)) {
			Extent_pass_New(driver, getText(driver, globalSearch_Frame) + " frame is displayed", test, test1);
			System.out.println(getText(driver, globalSearch_Frame) + " frame is displayed");
			waitForElement(driver, globalSearch_InputTextfield1);
			clearAndType(driver, globalSearch_InputTextfield1, allAgencySearch);
			waitForElement(driver, globalSearch_Frame_SearchButton);
			click(driver, globalSearch_Frame_SearchButton);
			waitForElement(driver, retrieved_Value_Select);
			if (isDisplayed(driver, retrieved_Value_Select)) {
				Extent_pass_New(driver, "Matched ||Expected: System listed the ALL Agency Records || Actual: System listed the ALL Agency Records", test, test1);
				System.out.println("Matched ||Expected: System listed the ALL Agency Records ||Actual: System listed the ALL Agency Records");
			} else {
				System.out.println("Matched || System does not listed the ALL Agency Records ||Actual: System didn't listed the ALL Agency Records");
				Extent_fail(driver, "Matched || System does not listed the ALL Agency Records ||Actual: System didn't listed the ALL Agency Records", test, test1);
			}
			clear(driver, globalSearch_InputTextfield1);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption1, booknum, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);
		}
		//	Verify the retrieved book number
		waitForElement(driver, Booking_No_Field);
		String retrievedBookingNoGlobal = getAttribute(driver, Booking_No_Field, "value");
		if (retrievedBookingNoGlobal.equals(booknum)) {
			Extent_pass_New(driver,"Matched || booking number is retrieved by Global Search || Expected Booking Number is :" + booknum + " || Actual Booking Number is :" + retrievedBookingNoGlobal, test,test1);
			System.out.println("Matched || booking number is retrieved by Global Search || Expected Booking Number is :" + booknum + " || Actual Booking Number is :" + retrievedBookingNoGlobal);
		} else {
			System.out.println("Not Matched || booking number is retrieved by Global Search || Expected Booking Number is :" + booknum + " ||But The Actual Booking Number is :" + retrievedBookingNoGlobal);
			Extent_fail(driver,"Not Matched || booking number is retrieved by Global Search || Expected Booking Number is :" + booknum + " ||But The Actual Booking Number is :" + retrievedBookingNoGlobal, test,test1);
		}
		Step_End(8, "Retrieve The Record In Global Search", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}