package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//Check whether system doesn't allow to delete the Agreement party in Customer tab
public class TC_Booking_SC037 extends Keywords {

	public void Booking_SC037(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC037";
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String first_service_data = Excel_data.get("first_service_data");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String rate_no = Excel_data.get("rate_no");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String RemovePopup = Excel_data.get("RemovePopup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Draft_Colour = Excel_data.get("Draft_Colour");

		
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");
		
		Extent_call(test, test1, "********** Enter Booking Module **********");

		moduleNavigate(driver, BookingMoudleSearch);

		Step_Start(1, "Enter the Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		waitForElement(driver, Agr_Party_TF);
		String value1 = getAttribute(driver, Agr_Party_TF, "value");
		System.out.println(value1);
		Step_End(1, "Enter the Agreement Party", test, test1);

		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Extent_call(test, test1, "*****Enter Origin*****");

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);
		System.out.println("Origin:" + orgin);

		Extent_call(test, test1, "*****Enter Delivery*****");

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		System.out.println("delivery:" + delivery);

		if (!SCAC_Code_Value.equals("")) {
			waitForElement(driver, SCAC_code_TF);
			sendKeys(driver, SCAC_code_TF, SCAC_Code_Value);
		}

		if (!Priority_Value.equals("")) {
			waitForElement(driver, Priority);
			safeclick(driver, Priority);
		}

		if (!Agency_RefNo_Value.equals("")) {
			waitForElement(driver, Agency_RefNo_TF);
			sendKeys(driver, Agency_RefNo_TF, Agency_RefNo_Value);
		}
		if (!TOS_Value.equals("")) {
			waitForElement(driver, TOS);
			safeclick(driver, TOS);
		}
		if (Operator_Code_value.equals("YES")) {
			checkBox(driver, CheckBox_3PL, Checkbox_Select_3PL);
			waitForElement(driver, Operator_Code_3PL_searchBtn);
			safeclick(driver, Operator_Code_3PL_searchBtn);
			waitForElement(driver, Operator_Code_TF);
			sendKeys(driver, Operator_Code_TF, Operator_Code_value);
			waitForElement(driver, Code_Val);
			safeclick(driver, Code_Val);
			waitForElement(driver, Popup_selectBtn);
			safeclick(driver, Popup_selectBtn);

		}
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(5, "save the booking in Draft ", test, test1);
		

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
		if(draft_bookingColor.equals(Draft_Colour)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
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
		if (Confirm_bookingColor.equalsIgnoreCase(Confirm_colour)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  

		Step_End(6, "select confirm button and safeclick Save button ", test, test1);
		Step_Start(7, "Select the AP Customer and click remove button system will remove the AP Details start", test,
				test1);

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, Customer_Tab);
		click(driver, Customer_Tab);

		waitForElement(driver, Customer_Grid);
		click(driver, Customer_Grid);
		Extent_call(test, test1, "**Remove AP Details**");
		waitForElement(driver, Customer_RemoveBtn);
		click(driver, Customer_RemoveBtn);

		waitForElement(driver, popup_Message);
		String value4 = getText(driver, popup_Message);
		if (RemovePopup.equals(value4)) {
			System.out.println("Matched || Expected value was : " + RemovePopup + " || Actual value was : " + value4);
			Extent_pass_New(driver, "Matched || Expected value was : " + RemovePopup + " || Actual value was : " + value4,
					test, test1);

		} else {
			System.out
			.println("NotMatched || Expected value was : " + RemovePopup + " || Actual value was : " + value4);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + RemovePopup + " || Actual value was : " + value4, test,
					test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(7, "Select the AP Customer and click remove button system will remove the AP Details start", test,
				test1);

		Extent_completed(test_Case_Name, test, test1);

	}
}