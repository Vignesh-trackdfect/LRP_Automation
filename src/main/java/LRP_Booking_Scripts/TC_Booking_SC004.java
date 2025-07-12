package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC004 extends Keywords {
	public void Booking_SC004(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC004";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("agr_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String Payoffpopexp = Excel_data.get("Payoffpopexp");
		String Paymode_select = Excel_data.get("Paymode_select");
		String Port_code_Prepaid = Excel_data.get("Port_code_Prepaid");
		String Payatpopexp = Excel_data.get("Payatpopexp");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String booking_Pay =  String.format(Booking_Locators.booking_Payy,Paymode_select);
		String Port_select =  String.format(Booking_Locators.Port_selectt,Port_code_Prepaid);

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1,"********** Switch the Profile Start **********");
		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"********** Switch the Profile End **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, search_module);
		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Extent_call(test, test1,"********** Enter the Delivery Input End  **********");
		Extent_call(test, test1,"********** Enter the Rates **********");
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(3, "Select the Routing",test, test1);
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		Step_Start(5, "save the booking in Draft",test, test1);
		   scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
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
			Step_Start(7, "select confirm button and click Save button",test, test1);
			  scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Payoffpopexp);
		String paypop=getText(driver, popup_Message);
		System.out.	println(paypop);
		Step_End(7, "select confirm button and click Save button",test, test1);
		Step_Start(9, "System validate to change the PayAT paylocation ",test, test1);
		if(Payoffpopexp.equals(paypop)) {                                                                                                                  
			System.out.println("Matched || [ System Should validate to change the PayAT paylocation ] Expected Report Activity is : " + Payoffpopexp + " || Actual Report Activity is : " + paypop+" [ System validated to change the PayAT paylocation ]");            
			Extent_pass_New(driver,"Matched || [ System Should validate to change the PayAT paylocation ] Expected Report Activity is : " + Payoffpopexp + " || Actual Report Activity is : " + paypop+" [ System validated to change the PayAT paylocation ]", test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ System Should validate to change the PayAT paylocation ] Expected Report Activity is : " + Payoffpopexp + " || Actual Report Activity is : " + paypop+" [ System Not validated to change the PayAT paylocation ]");        
			Extent_fail(driver,"Not Matched || [ System Should validate to change the PayAT paylocation ] Expected Report Activity is : " + Payoffpopexp + " || Actual Report Activity is : " + paypop+" [ System NOt validated to change the PayAT paylocation ]", test,test1); 
		} 
		Step_End(9, "System validate to change the PayAT paylocation",test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_Start(8, "set the paylocation same as POD and PAyat ",test, test1);
		waitForElement(driver, Patat);
		safeclick(driver, Patat);
		RightClick(driver, Patat);
		waitForElement(driver, Paymode);
		mouseOverToElement(driver, Paymode);
		waitForElement(driver, booking_Pay);
		jsClick(driver, booking_Pay);
		waitForDisplay(driver, portcodefilter);
		if(isdisplayed(driver, portcodefilter)) {
			sendKeys(driver, portcodefilter, Port_code_Prepaid);
			waitForElement(driver, Port_select);
			safeclick(driver, Port_select);
			waitForElement(driver, Select_Button);
			safeclick(driver, Select_Button);
			waitForElement(driver, master_tab);
			safeclick(driver, master_tab);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);	
			waitForPopup(driver, popup_Message,Payatpopexp);
			String Payatpopact=getText(driver, popup_Message);
			System.out.println(Payatpopact);
			if(Payatpopact.contains(Payatpopexp)) {                                                                                                                  
				System.out.println("Matched || Expected Pop-up value is :  " + Payatpopexp + " || Actual Pop-up value is : " + Payatpopact);            
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + Payatpopexp + " || Actual Pop-up value is : " + Payatpopact, test,test1);     
			}else {                                                                                                                                                                   
				System.out.println("Not Matched || Expected Pop-up value is : " + Payatpopexp + " || Actual Pop-up value is : " + Payatpopact);        
				Extent_fail(driver, "Not Matched ||Expected Pop-up value is : " + Payatpopexp + " || Actual Pop-up value is : " + Payatpopact, test,test1); 
			} 
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			Step_Start(8, "set the paylocation same as POD and PAyat ",test, test1);
			Extent_completed(test_Case_Name, test, test1);
		}
	}
}