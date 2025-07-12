package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC107 extends Keywords {

	public void Booking_SC107(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC107";
		
		
		


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
		String EastDischargeBound = Excel_data.get("EastDischargeBound");
		String EastLoadBound = Excel_data.get("EastLoadBound");
		String AutoLegUpdatedPopup = Excel_data.get("AutoLegUpdatedPopup");
		String WestDischargeBound = Excel_data.get("WestDischargeBound");
		String WestLoadBound = Excel_data.get("WestLoadBound");
		String FilterType1 = Excel_data.get("FilterType1");
		String FilterCondition1 = Excel_data.get("FilterCondition1");
		String FilterValue1 = Excel_data.get("FilterValue1");
		String FilterType2 = Excel_data.get("FilterType2");
		String FilterValue2 = Excel_data.get("FilterValue2");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String AutoLegConfigurationModule = Excel_data.get("AutoLegConfigurationModule");
		String GlobalValue = Excel_data.get("GlobalValue");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String FilterType3 = Excel_data.get("FilterType3");
		String FilterValue3 = Excel_data.get("FilterValue3");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Header_scroll_number = Excel_data.get("Header_scroll_number");

		
		
		
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
		waitForElement(driver, Rates_control_Pannel);
		safeclick(driver, Rates_control_Pannel);
		waitForElement(driver, Rated_condition_Filter);
		safeclick(driver, Rated_condition_Filter);
		sendKeys(driver, RateNo_TF, rate_no);
		waitForElement(driver, ratesWindow_Horizontal_Scrollbar);
		int Header_number = Integer.parseInt(Header_scroll_number);
		horizontalscroll(driver, ratesWindow_Horizontal_Scrollbar, Header_number);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		
	
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		waitForElement(driver, Voyage_Value);
		String Voyage = getText(driver, Voyage_Value);
		System.out.println("Voyage value: " + Voyage);
		waitForElement(driver, BKG_Bound_Value);
		String Bound = getText(driver, BKG_Bound_Value);
		System.out.println("Bound value: " + Bound);

		Step_End(4, "Select the Schedule ", test, test1);
		Step_Start(5, "save the booking in Draft ", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		if(savepopACT.equals(savedpopEXP)) {
			System.out.println("Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT );
			Extent_pass_New(driver, "Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT , test, test1);
		}else {
			System.out.println("Not Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT );
			Extent_pass_New(driver, "Not Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT , test, test1);

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

		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		Step_Start(6, "AutoRate the charges in Charge tab ", test, test1);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "select confirm button and click Save button", test, test1);
scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message);
		String UpdatedpopACT = getText(driver, popup_Message);
		System.out.println(UpdatedpopACT);
		if(UpdatedpopACT.equals(bookingUpdatedPopup)) {
			System.out.println("Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup );
			Extent_pass_New(driver, "Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup , test, test1);
		}else {
			System.out.println("Not Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup );
			Extent_pass_New(driver, "Not Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup , test, test1);

		}

		waitForElement(driver, popup_Message);
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
		Step_End(7, "select confirm button and click Save button", test, test1);
		Step_Start(8, "SET BLM global configuration values as Voy-BND", test, test1);

		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);

		
		setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
		
		
		
		Step_End(8, "SET BLM global configuration values as Voy-BND", test, test1);
		Step_Start(9, "Bound mapped in auto leg configuration ", test, test1);

		moduleNavigate(driver, AutoLegConfigurationModule);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, FilterCondition1, FilterType1, FilterValue1, FilterType2, FilterValue2, FilterType3, FilterValue3);
		
	
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, Load_Bound_Grid);
		doubleClick(driver, Load_Bound_Grid);
		waitForElement(driver, Load_Dropdown);
		safeclick(driver, Load_Dropdown);
		String West1 =  String.format(Booking_Locators.West1,  WestLoadBound); 

		waitForElement(driver, West1);
		click(driver, West1);

		waitForElement(driver, Discharge_Bound_Grid);
		doubleClick(driver, Discharge_Bound_Grid);
		waitForElement(driver, Discharge_Dropdown);
		safeclick(driver, Discharge_Dropdown);
		String West2 =  String.format(Booking_Locators.West2,  WestDischargeBound); 

		waitForElement(driver, West2);
		click(driver, West2);

		waitForElement(driver, Select_CheckBox);
		safeclick(driver, Select_CheckBox);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,AutoLegUpdatedPopup);

		String Popup = getText(driver, popup_Message);
		System.out.println(Popup);
		if (AutoLegUpdatedPopup.contains(Popup)) {
			System.out.println(
					"Matched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup);
			Extent_pass_New(driver,
					"Matched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup);
			Extent_fail(driver,
					"NotMatched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		Step_End(9, "Bound mapped in auto leg configuration ", test, test1);
		Step_Start(10, "system  check exact voyage and bound for Load and Discharge Side", test, test1);

		moduleNavigate(driver, BookingMoudleSearch);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);

		waitForElement(driver, Agr_Party_TF);
		String value = getAttribute(driver, Agr_Party_TF, "value");
		System.out.println(value);
		
		
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
		waitForElement(driver, Rates_control_Pannel);
		safeclick(driver, Rates_control_Pannel);
		waitForElement(driver, Rated_condition_Filter);
		safeclick(driver, Rated_condition_Filter);
		sendKeys(driver, RateNo_TF, rate_no);
		
		
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		
		
		waitForPopup(driver, popup_Message,No_Schedule_Popup);

		String NoSchedule = getText(driver, popup_Message);
		System.out.println(NoSchedule);
		if (No_Schedule_Popup.equals(NoSchedule)) {
			System.out.println(
					"Matched || Expected value POPUP was : " + No_Schedule_Popup + " || Actual value POPUP was : " + NoSchedule);
			Extent_pass_New(driver,
					"Matched || Expected value POPUP was : " + No_Schedule_Popup + " || Actual value POPUP was : " + NoSchedule,
					test, test1);

		} else {
			System.out.println(
					"NotMatched || Expected value POPUP was : " + No_Schedule_Popup + " || Actual value POPUP was : " + NoSchedule);
			Extent_fail(driver,
					"NotMatched || Expected value POPUP  was : " + No_Schedule_Popup + " || Actual value POPUP  was : " + NoSchedule,
					test, test1);

		}

		safeclick(driver, popup_Message_Ok_Button);
		Step_End(10, "system  check exact voyage and bound for Load and Discharge Side", test, test1);
		scrollTop(driver);
		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);

		moduleNavigate(driver, AutoLegConfigurationModule);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, FilterCondition1, FilterType1, FilterValue1, FilterType2, FilterValue2, FilterType3, FilterValue3);


		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, Load_Bound_Grid);
		doubleClick(driver, Load_Bound_Grid);
		waitForElement(driver, Load_Dropdown);
		safeclick(driver, Load_Dropdown);
		String East1 =  String.format(Booking_Locators.East1,  EastLoadBound); 
		waitForElement(driver, East1);
		click(driver, East1);

		waitForElement(driver, Discharge_Bound_Grid);
		doubleClick(driver, Discharge_Bound_Grid);
		waitForElement(driver, Discharge_Dropdown);
		safeclick(driver, Discharge_Dropdown);
		String East2 =  String.format(Booking_Locators.East2,  EastDischargeBound); 
        waitForElement(driver, East2);
		click(driver, East2);

		waitForElement(driver, Select_CheckBox);
		safeclick(driver, Select_CheckBox);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,AutoLegUpdatedPopup);

		String Popup1 = getText(driver, popup_Message);
		System.out.println(Popup1);
		if (AutoLegUpdatedPopup.contains(Popup1)) {
			System.out.println(
					"Matched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup1);
			Extent_pass_New(driver,
					"Matched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup1, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup1);
			Extent_fail(driver,
					"NotMatched || Expected value popup was : " + AutoLegUpdatedPopup + " || Actual value popup was : " + Popup1,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Extent_completed(test_Case_Name, test, test1);

	}
}