package LRP_Booking_Scripts;

import commonMethods.Keywords;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;




import locators.Booking_Locators;

public class TC_Booking_SC077  extends Keywords{


	public void Booking_SC077(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String test_Case_Name01 = "TC_Booking_SC077";



		// Values are taken from data sheet


		String Username = Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String orgin =Excel_data.get("Orgin");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String agencyUser =Excel_data.get("AgencyUser");
		String bluename =Excel_data.get("BLUE_NAME");
		String Voyagenumber =Excel_data.get("Voyagenumber");
		String Boundinput =Excel_data.get("Boundinput");
		String Rates_click =Excel_data.get("Rates_click");
		String Validdaysgird_Input =Excel_data.get("Validdaysgird_Input");
		String saved_draft_pop_exp =Excel_data.get("saved_draft_pop");
		String saved_conformed_pop_exp =Excel_data.get("saved_conformed_pop");
		String Green_colour_exp =Excel_data.get("Green_colour");
		String Rate_No =Excel_data.get("Rate_No");
		String Shipment_type =Excel_data.get("Shipment_type");
		String No_Schedule_Popup =Excel_data.get("No_Schedule_Popup");
		String Select_Columns = Excel_data.get("Select_Columns");

		String Shipment_type_select =  String.format(Booking_Locators.shipment_typee,Shipment_type);

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
		Step_Start(1, "Enter the Agreement Party",test, test1);
		// entering the AGR party

		// selecting the Shipment type

		waitForElement(driver, BKG_Shipment_type_input);
		safeclick(driver, BKG_Shipment_type_input);

		waitForElement(driver, Shipment_type_select);
		safeclick(driver, Shipment_type_select);
		Extent_pass_New(driver, "***Shipment type was selected as***:"+Shipment_type, test, test1);


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
		waitForElement(driver,Valid_Days);
		clearAndType(driver, Valid_Days, Validdaysgird_Input);	

		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
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
		safeclick(driver, ok_btn);
		selectRatesRouting(driver, No_Schedule_Popup, bluename, Voyagenumber, Boundinput);

		// saving the booking in draft
		Step_Start(5, "save the booking in Draft",test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,saved_draft_pop_exp);
		//Validate the saved popup
		System.out.println("**********Verifting the saved popup **********");
		Extent_call(test, test1,"**********Verifting the saved popup**********");
		String saved_draft_pop_act = getText(driver, popup_Message);
		System.out.println(saved_draft_pop_act);
		if (saved_draft_pop_exp.equals(saved_draft_pop_act)) {
			System.out.println(
					"Matched || " + " Expected Activity is : " + saved_draft_pop_exp + " || Actual Activity is : " + saved_draft_pop_act);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity is : " + saved_draft_pop_exp + " || Actual Activity is : " + saved_draft_pop_act, test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity is : " + saved_draft_pop_exp + " || Actual Activity is : " + saved_draft_pop_act);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity is : " + saved_draft_pop_exp + " || Actual Activity is : " + saved_draft_pop_act,
					test,test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		Step_End(5, "save the booking in Draft",test, test1);
		System.out.println("********** Pinting the Booking number **********");
		Extent_call(test, test1,"********** Pinting the Booking number*******");
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);
		Extent_pass_New(driver, "***Booking number was generated as***"+booknum, test, test1);

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


		waitForElement(driver, popup_Message);
		String saved_conformed_pop_act = getText(driver, popup_Message);
		System.out.println(saved_conformed_pop_act);
		// validate the saved conform popup
		System.out.println("**********Verifting the saved popup **********");
		Extent_call(test, test1,"**********Verifting the saved popup**********");
		if (saved_conformed_pop_act.contains(saved_conformed_pop_exp)) {
			System.out.println(
					"Matched || Expected  Pop-up value is  : " + saved_conformed_pop_exp + " || Actual Popup value is : " + saved_conformed_pop_act);
			Extent_pass_New(driver,
					"Matched ||Expected  Pop-up value is  : " + saved_conformed_pop_exp + " || Actual Popup is : " + saved_conformed_pop_act, test,test1);
		} else {
			System.out.println(
					"Not matched || Expected  Pop-up value is : " + saved_conformed_pop_exp + " || Actual Popup is : " + saved_conformed_pop_act);
			Extent_fail(driver,
					"Not matched || Expected  Pop-up value is  : " + saved_conformed_pop_exp + " || Actual Popup is : " + saved_conformed_pop_act,
					test,test1);
		}



		Step_End(8, "Click conform and save the booking ",test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		String submit_bookingColorCode=getTextBackgroundColor(driver,booking_no);
		String submit_bookingColor=getColorName(submit_bookingColorCode);
		// validate the colour of booking number field after conform

		System.out.println("**********Verifting the saved booking number colour **********");
		Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
		if (Green_colour_exp.equalsIgnoreCase(submit_bookingColor)) {
			System.out.println(
					"Matched || " + " Expected Activity is : " + Green_colour_exp + " || Actual Activity is : " + submit_bookingColor);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity is [** booking field Want to change green colour**]: " + Green_colour_exp + " || Actual Activity is[**booking field was changed into green colour**] : " + submit_bookingColor, test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity is : " + Green_colour_exp + " || Actual Activity is : " + submit_bookingColor);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity is : " + Green_colour_exp + " || Actual Activity is : " + submit_bookingColor,
					test,test1);
		}



		Extent_completed(test_Case_Name01, test, test1);

	}}
