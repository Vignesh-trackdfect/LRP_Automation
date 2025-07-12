package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//check whether In Booking, while rate reset done and Rates Clear option system not clear manual charges
public class TC_Booking_SC097 extends Keywords {

	public void Booking_SC097(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC097";
		
		
		



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
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String Base_Rate = Excel_data.get("Base_Rate");
		String Clear_Reference_Popup = Excel_data.get("Clear_Reference_Popup");
		String PinkColour = Excel_data.get("PinkColour");
		String charge_Input = Excel_data.get("charge_Input");
		String Unit_Code_Input = Excel_data.get("Unit_Code_Input");
		String Currency_Code_Input = Excel_data.get("Currency_Code_Input");
		String EquipmentType = Excel_data.get("EquipmentType");
		String Pay_By_Input = Excel_data.get("Pay_By_Input");
		String conditionFilter=Excel_data.get("conditionFilter");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");
		String Unit_code_Header = Excel_data.get("Unit_code_Header");
		String Charge_code_Header = Excel_data.get("Charge_code_Header");

		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
		String Eqp_typ =  String.format(Booking_Locators.Eqp_typ,  EquipmentType); 
		String Pay_By =  String.format(Booking_Locators.Pay_By,  Pay_By_Input); 

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
		Step_End(1, "Enter the Agreement Party", test, test1);

		Step_Start(2, "Enter the POL and POD ", test, test1);
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
		Step_End(2, "Enter the POL and POD", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
		
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Step_Start(5, "save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
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


		if (draft_bookingColor.equalsIgnoreCase(Draft_Colour)) {
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 
		Step_End(5, "save the booking in Draft ", test, test1);
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		
		
		
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "select confirm button and safeclick Save button ", test, test1);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup2=getText(driver, popup_Message);
		if(actualUpdatedPopup2.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + actualUpdatedPopup2);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + actualUpdatedPopup2, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + actualUpdatedPopup2);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + actualUpdatedPopup2, test,test1); 

		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);


		if (Confirm_bookingColor.equalsIgnoreCase(Confirm_colour)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_bookingColor + " || The Actual Report Activity is : " + Confirm_colour+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_bookingColor + " || The Actual Report Activity is : " + Confirm_colour+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_bookingColor + " || The Actual Report Activity is : " + Confirm_colour+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_bookingColor + " || The Actual Report Activity is : " + Confirm_colour+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}
		Step_End(7, "select confirm button and click Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		Extent_call(test, test1, "*****Add charges manually*******");
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, charges_search_Button);
		safeclick(driver, charges_search_Button);
		
		twoColumnSearchWindow(driver, Charge_code_Header, conditionFilter, charge_Input);

		waitForElement(driver, Charges_TF);
		String Charge = getAttribute(driver, Charges_TF, "value");
		System.out.println("Charge:"+Charge);
		
		waitForElement(driver, Base_Rate_Unit_Search_Button);
		safeclick(driver, Base_Rate_Unit_Search_Button);

		twoColumnSearchWindow(driver, Unit_code_Header, conditionFilter, Unit_Code_Input);

		
		waitForElement(driver, currency_Search_Button);
		safeclick(driver, currency_Search_Button);
		
		twoColumnSearchWindow(driver, Currency_Code_Header, conditionFilter, Currency_Code_Input);


		waitForElement(driver, EquipmentType_Dropdown);
		safeclick(driver, EquipmentType_Dropdown);
		waitForElement(driver, Eqp_typ);
		safeclick(driver, Eqp_typ);

		waitForElement(driver, Base_Rate_TF);
		safeclick(driver, Base_Rate_TF);
		Newclear_Type(driver);
		sendKeys(driver, Base_Rate_TF, Base_Rate);

		waitForElement(driver, Pay_By_Dropdown);
		safeclick(driver, Pay_By_Dropdown);
		waitForElement(driver, Pay_By);
		safeclick(driver, Pay_By);

		waitForElement(driver, Charges_Add_Btn);
		safeclick(driver, Charges_Add_Btn);
		Step_Start(8, "click Rate Reset button system not clear the charges", test, test1);
		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);
		waitForElement(driver, Rate_No_Grid);
		String RateNo1 = getText(driver, Rate_No_Grid);
		System.out.println(RateNo1);
		waitForElement(driver, Container_Grid);
		RightClick(driver, Container_Grid);
		waitForElement(driver, clear_referenceBtn);
		safeclick(driver, clear_referenceBtn);

		waitForPopup(driver, popup_Message,Clear_Reference_Popup);
		String ClearRef_Popup = getText(driver, popup_Message);
		if (Clear_Reference_Popup.equals(ClearRef_Popup)) {
			System.out.println("Matched || Expected value popup was : " + Clear_Reference_Popup + " || Actual value popup was : "
					+ ClearRef_Popup);
			Extent_pass_New(driver, "Matched || Expected value popup was : " + Clear_Reference_Popup + " || Actual value popup was : "
					+ ClearRef_Popup, test, test1);

		} else {
			System.out.println("NotMatched || Expected value popup was : " + Clear_Reference_Popup + " || Actual value popup was : "
					+ ClearRef_Popup);
			Extent_fail(driver, "NotMatched || Expected value popup was : " + Clear_Reference_Popup
					+ " || Actual value popup was : " + ClearRef_Popup, test, test1);

		}
		
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		waitForElement(driver, Container_RatesBtn);
		safeclick(driver, Container_RatesBtn);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, Rates_Okbtn);
		safeclick(driver, Rates_Okbtn);
		waitForDisplay(driver, Invalid_date_popup);		
		if(isDisplayed(driver,Invalid_date_popup)) {
			safeclick(driver, Invalid_date_popup_Close);
		}
        
		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, Container_Added_Grid);
		safeclick(driver, Container_Added_Grid);
		
		waitForElement(driver, Container_Color);
		String Background_Colour1 = getTextBackgroundColor(driver, Container_Color);
		String Background_Colour=getColorName(Background_Colour1);

		System.out.println(Background_Colour);

		if (PinkColour.equalsIgnoreCase(Background_Colour)) {
			Extent_pass_New(driver, "Matched || Expected color code:"
					+ PinkColour + " || Actual color code:" + Background_Colour, test, test1);
			System.out.println( "Matched || Expected color code:"
					+ PinkColour + " || Actual color code:" + Background_Colour);

		} else {
			
			System.out.println("Not Matched || The background color of Container grid field is not Pink|| Expected color code:"+ PinkColour + " || Actual color code:" + Background_Colour);
			Extent_fail(driver,"Not Matched || The background color of Container grid field is not Pink|| Expected color code:"+ PinkColour + " || Actual color code:" + Background_Colour,test, test1);
		}
		waitForElement(driver, Rate_No_Grid);
		String RateNo2 = getText(driver, Rate_No_Grid);
		System.out.println(RateNo2);
		if (RateNo1.equals(RateNo2)) {
			System.out.println("Matched || Expected value rateno was : " + RateNo1 + " || Actual value rateno was : " + RateNo2);
			Extent_fail(driver, "Matched || Expected value rateno was : " + RateNo1 + " || Actual value rateno was : " + RateNo2,
					test, test1);

		} else {
			System.out.println("NotMatched || Expected value rateno was : " + RateNo1 + " || Actual value rateno was : " + RateNo2);
			Extent_pass_New(driver, "NotMatched || Expected value rateno was : " + RateNo1 + " || Actual value rateno was : " + RateNo2,
					test, test1);
		}

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		if (isDisplayed(driver, Charge_Grid)) {
			
			
			System.out.println("*The Expected Result is : Manually added Charges is Displayed after clearing Rates || The Actual Result is : Manually added Charges is Displayed after clearing Rates");            
			Extent_pass_New(driver,"*The Expected Result is : Manually added Charges is Displayed after clearing Rates || The Actual Result is : Manually added Charges is Displayed after clearing Rates", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Manually added Charges is Displayed after clearing Rates || The Actual Result is : Manually added Charges is not Displayed after clearing Rates");        
			Extent_fail(driver, "*The Expected Result is : Manually added Charges is Displayed after clearing Rates || The Actual Result is : Manually added Charges is not Displayed after clearing Rates", test,test1); 
		
		}
			
		
		waitForElement(driver, Charge_Grid_Value);
		String Charge_GridValue = getText(driver, Charge_Grid_Value);

		if (Charge.contains(Charge_GridValue)) {
			System.out.println(
					"Matched || Expected value in charge gird  was : " + Charge_GridValue + " || Actual valuein charge was : " + Charge);
			Extent_pass_New(driver,
					"Matched || Expected value in charge girdwas : " + Charge_GridValue + " || Actual value charge was : " + Charge, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Expected value in charge girdwas : " + Charge_GridValue + " || Actual value not equal charge was : " + Charge);
			Extent_fail(driver,
					"NotMatched || Expected value in charge girdwas : " + Charge_GridValue + " || Actual value not equal charge was : " + Charge, test,
					test1);

		}
		Step_End(8, "click Rate Reset button system not clear the charges", test, test1);
		Extent_completed(test_Case_Name, test, test1);

	}
}