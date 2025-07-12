package LRP_Booking_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC067  extends Keywords{
	public void Booking_SC067(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String test_Case_Name01 = "TC_Booking_SC067";
		String Username = Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String orgin =Excel_data.get("Orgin");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String agencyUser =Excel_data.get("AgencyUser");
		String first_service_data =Excel_data.get("BLUE_NAME");
		String Voyagenumber1 =Excel_data.get("Voyagenumber");
		String Boundinput =Excel_data.get("Boundinput");
		String Shipment_type =Excel_data.get("Shipment_type");
		String Rates_click =Excel_data.get("Rates_click");
		String saved_draft_pop_exp =Excel_data.get("saved_draft_pop");
		String saved_conformed_pop_exp =Excel_data.get("saved_conformed_pop");
		String Green_colour_exp =Excel_data.get("Green_colour");
		String booking_draft_Color =Excel_data.get("booking_draft_Color");
		String Rate_No =Excel_data.get("Rate_No");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Select_Columns = Excel_data.get("Select_Columns");

		String Shipment_type_select =  String.format(Booking_Locators.shipment_typee,Shipment_type);
		Extent_Start(test_Case_Name01, test, test1);



		// Login

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1,"********** Switch the Profile Start **********");
		// switching the profile

		SwitchProfile(driver, agencyUser);

		System.out.println("********** Switch the Profile End **********");
		Extent_call(test, test1,"********** Switch the Profile End **********");

		// Searching the module name
		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");


		moduleNavigate(driver, Search);
		// selecting the Shipment type

		waitForElement(driver, BKG_Shipment_type_input);
		safeclick(driver, BKG_Shipment_type_input);


		waitForElement(driver, Shipment_type_select);
		safeclick(driver, Shipment_type_select);
		Extent_pass_New(driver, "***Shipment type was selected as***:"+Shipment_type, test, test1);


		Step_Start(1, "Enter the Agreement Party",test, test1);
		// entering the AGR party
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);

		// entering the delivery

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
		//selecting the Rates
		Step_Start(3, "Select the Routing ",test, test1);
		waitForDisplay(driver, Rate_Grid);
		if(isdisplayed(driver, Rate_Grid)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		} 
		Step_End(3, "Select the Routing",test, test1);
		Step_Start(4, "Select the Schedule ",test, test1);
		reArrangeAG_GridColumns(driver, Select_Columns);
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, Rate_No);
		waitForElement(driver, Eqp_Type_Field);
		sendKeys(driver, Eqp_Type_Field, Rates_click);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		Extent_pass_New(driver, "***Rates was selected as***"+Rates_click, test, test1);
		waitForElement(driver, ok_btn);
		click(driver, ok_btn);
		// validate the no schedulepopup
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		// saving the booking in draft
		Step_Start(5, "save the booking in Draft",test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// Verification of saved popup of draft
		waitForPopup(driver, popup_Message,saved_draft_pop_exp);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		Extent_cal(test, test1,"**********Verifting the saved popup**********");
		if(savepopACT.contains(saved_draft_pop_exp)) {                                                                                                                  
			System.out.println("Matched || The Expected Pop-up Value is : " + saved_draft_pop_exp + " || The Actual Pop-up Value is : " + savepopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + saved_draft_pop_exp + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + saved_draft_pop_exp + " || But The Actual Pop-up Value is : " + savepopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + saved_draft_pop_exp + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println("Book number generated is: "+booknum);
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
		// switch to non_containear tab
		Step_Start(6, "Navigate to Non con_Tab and check thd cargo type ",test, test1);

		waitForElement(driver, Non_con_tab);
		safeclick(driver, Non_con_tab);
		waitForElement(driver, Cargo_type);
		String Cargo_type_value = getText(driver, Cargo_type);
		System.out.println(Cargo_type_value);
		Extent_pass_New(driver,"*****Cargo typr was shown as****"+ Cargo_type_value, test, test1);
		Step_End(6, "Navigate to Non con_Tab and check thd cargo type",test, test1);
		//switch to charges tab
		Step_Start(7, "Navigate to charges tab and auto rate  ",test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		// switch to master tab
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		Step_End(7, "Navigate to charges tab and auto rate ",test, test1);
		Step_Start(8, "Click conform and save the booking ",test, test1);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		//booking saved in conform 
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,saved_conformed_pop_exp);
		String saved_conformed_pop_act = getText(driver, popup_Message);
		System.out.println(saved_conformed_pop_act);
		// validate the saved conform popup
		System.out.println("**********Verifting the saved popup **********");
		Extent_call(test, test1,"**********Verifting the saved popup**********");
		if (saved_conformed_pop_act.contains(saved_conformed_pop_exp)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + saved_conformed_pop_exp + " || The Actual Pop-up Value is : " + saved_conformed_pop_act);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + saved_conformed_pop_exp + " || The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + saved_conformed_pop_exp + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + saved_conformed_pop_exp + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1); 
		} 
		Step_End(8, "Click conform and save the booking ",test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);
		// validate the colour of booking number field after conform
		Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);
		if (Confirm_bookingColor.equalsIgnoreCase(Green_colour_exp)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Green_colour_exp + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Green_colour_exp + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Green_colour_exp + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Green_colour_exp + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
	} 

		Extent_completed(test_Case_Name01, test, test1);

	}
}
