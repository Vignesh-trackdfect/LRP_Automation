package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC041 extends Keywords{

	public void Booking_SC041 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name01 = "TC_Booking_SC041";
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
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
		String random_no = Excel_data.get("random_no");
		String con_cargo_wt_value = Excel_data.get("con_cargo_wt_value");
		String cont_pos_value = Excel_data.get("cont_pos_value");
		String cargograde_value = Excel_data.get("cargograde_value");
		String tare_unit_value = Excel_data.get("tare_unit_value");
		String carrier_seal = Excel_data.get("carrier_seal");
		String shipper_seal = Excel_data.get("shipper_seal");
		String other_seal = Excel_data.get("other_seal");
		String chassis = Excel_data.get("chassis");
		String laden_status = Excel_data.get("laden_status");
		String shipper_owned_status = Excel_data.get("shipper_owned_status");
		String dg_status = Excel_data.get("dg_status");
		String oneway_status = Excel_data.get("oneway_status");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		
		//locators

		String tare_unit =  String.format(Booking_Locators.tare_unitt,tare_unit_value);
		String cargo_grade =  String.format(Booking_Locators.cargo_gradee,cargograde_value);
		String cont_position =  String.format(Booking_Locators.cont_positionn,cont_pos_value);



		Extent_Start(test_Case_Name01, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);


		
		Extent_call(test, test1,"**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);


		Extent_cal(test, test1,"** Enter Booking Module **");
		moduleNavigate(driver, search_module);
		
		Step_Start(1, "Enter the Agr Party Input", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(1, "Enter the Agr Party Input", test, test1);

		Step_Start(2, "Enter the Orgin and delivery", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the Orgin and delivery", test, test1);

		Step_Start(3, "Select the Routing ", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
Step_Start(5, "Save the booking in Draft", test, test1);

		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);

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
		Step_End(5, "save the booking in Draft ", test, test1);
		Step_Start(6, "select confirm button and safeclick Save button ", test, test1);

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, Charges_tab);
		click1(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click1(driver, AutoRated);

		waitForElement(driver, master_tab);
		click1(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String UpdatedpopACT = getText(driver, popup_Message);
		System.out.println(UpdatedpopACT);
		if(UpdatedpopACT.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + UpdatedpopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + UpdatedpopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + UpdatedpopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + UpdatedpopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
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

		Step_End(6, "select confirm button and safeclick Save button ", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		//enters container tab
		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);

		//click edit button in container grid
		waitForElement(driver, con_editicon);
		safeclick(driver, con_editicon);

		//dummy epquipment id
		waitForElement(driver, con_eqp_id);
		sendKeys(driver, con_eqp_id, random_no);

		String eqp_id=getAttribute(driver, con_eqp_id, "value");
		System.out.println(eqp_id);

		if(!carrier_seal.equals("")) {
			waitForElement(driver, carrierseal_field);
			sendKeys(driver, carrierseal_field, carrier_seal);
		}else {
			System.out.println("carrier_seal "+"Input Not Available in Test data");
		}

		if(!shipper_seal.equals("")) {
			waitForElement(driver, shipperseal_field);
			sendKeys(driver, shipperseal_field, shipper_seal);
		}else {
			System.out.println("shipper_seal "+"Input Not Available in Test data");
		}

		if(!other_seal.equals("")) {
			waitForElement(driver, otherseal_field);
			sendKeys(driver, otherseal_field, other_seal);
		}else {
			System.out.println("other_seal "+"Input Not Available in Test data");
		}

		if(!cont_pos_value.equals("")) {
			waitForElement(driver, con_load_field);
			click(driver, con_load_field);
			waitForElement(driver, cont_position);
			click(driver, cont_position);
		}else {
			System.out.println("cont_pos_value "+"Input Not Available in Test data");
		}

		if(!chassis.equals("")) {
			waitForElement(driver, chassis_field);
			sendKeys(driver, chassis_field, chassis);
		}else {
			System.out.println("chassis "+"Input Not Available in Test data");
		}
		waitForElement(driver, laden_checkbox);
		checkBox(driver, laden_checkbox, laden_status);

		waitForElement(driver, shipper_owned_checkbox);
		checkBox(driver, shipper_owned_checkbox, shipper_owned_status);

		waitForElement(driver, dg_checkbox);
		checkBox(driver, dg_checkbox, dg_status);

		waitForElement(driver, oneway_checkbox);
		checkBox(driver, oneway_checkbox, oneway_status);


		if(!cargograde_value.equals("")) {
			waitForElement(driver, cargograde_field);
			click(driver, cargograde_field);
			waitForElement(driver, cargo_grade);
			click(driver, cargo_grade);
		}else {
			System.out.println("cargograde_value "+"Input Not Available in Test data");
		}

		if(!tare_unit_value.equals("")) {
			waitForElement(driver, tarewt_unit_field);
			click(driver, tarewt_unit_field);
			waitForElement(driver, tare_unit);
			click(driver, tare_unit);
		}else {
			System.out.println("tare_unit_value "+"Input Not Available in Test data");
		}

		Step_Start(7, "Enter the cargo weight in container tab", test, test1);

		waitForElement(driver, con_cargo_wt);
		clearAndType(driver, con_cargo_wt, con_cargo_wt_value);
		click(driver, con_cargo_wt);
		tab(driver);
		click(driver, con_eqp_id);

		waitForElement(driver, con_add_btn);
		click(driver, con_add_btn);

		waitForElement(driver, dummy_container_yes);
		click(driver, dummy_container_yes);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		String con_cargowt=getText(driver, con_wt_grid);
		if(con_cargowt.contains(con_cargo_wt_value)) {
			System.out.println("Matched || Expected value was : "+con_cargo_wt_value+" || Actual value was : "+con_cargowt);
			Extent_pass_New(driver, "Matched || Expected value from test data : "+con_cargo_wt_value+" || Actual value was in application entered: "+con_cargowt, test, test1);
		}
		else {
			System.out.println("NotMatched || Expected value was : "+con_cargo_wt_value+" || Actual value was : "+con_cargowt);
			Extent_fail(driver,  "NotMatched || Expected value was : "+con_cargo_wt_value+" || Actual value was : "+con_cargowt, test, test1);
		}
	
		Step_End(7, "Enter the cargo weight in container tab", test, test1);
		Extent_completed(test_Case_Name01, test, test1);
	}
}