package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC088 extends Keywords {

	public void Booking_SC088(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC088";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String first_service_data = Excel_data.get("first_service_data");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber = Excel_data.get("Voyagenumber");
		String first_service_data1 = Excel_data.get("first_service_data1");
		String Boundinput1 = Excel_data.get("Boundinput1");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String rate_no = Excel_data.get("rate_no");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String random_no = Excel_data.get("random_no");
		String BL_saved_msg = Excel_data.get("BL_saved_msg");
		String Operational_Reset_Module = Excel_data.get("Operational_Reset_Module");
		String Container_Select = Excel_data.get("Container_Select");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearchFilterOption=Excel_data.get("GlobalSearchFilterOption");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String terminalDetails_Filter = Excel_data.get("terminalDetails_Filter");
		String Customer_Name_Input=Excel_data.get("Customer_Name_Input");
		String Customer_Name_Search = Excel_data.get("Customer_Name_Search");
		String Booking_Date_Input = Excel_data.get("Booking_Date_Input");
		String Booking_Date_Search = Excel_data.get("Booking_Date_Search");
		String Container_Number_Header = Excel_data.get("Container_Number_Header");
		String Container = Excel_data.get("Container");
		

		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
		String Container_Non_Container =  String.format(Booking_Locators.Container_Non_Container,  Container_Select); 

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
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber, Boundinput);

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
			Extent_fail(driver, "Not Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT , test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);


		if (draft_bookingColor.equalsIgnoreCase(Draft_Colour)) {
			Extent_pass_New(driver,
					"Matched || The background color of draft Booking number textfield is yellow || Expected color  :"
							+ draft_bookingColor + " || Actual color :" + Draft_Colour,
					test, test1);
			System.out.println("Matched || The background color of draft Booking number textfield is yellow || Expected color  :"
					+ draft_bookingColor + " || Actual color :" + Draft_Colour);
			Extent_pass_New(driver, "Booking drafted", test, test1);

		} else {
			System.out.println("Not Matched || The background color of draft Booking number textfield is not yellow || Expected color :"
					+ draft_bookingColor + " || Actual color :" + Draft_Colour);
			Extent_fail(driver,
					"Not Matched || The background color of draft Booking number textfield is not yellow || Expected color :"
							+ draft_bookingColor + " || Actual color :" + Draft_Colour,
					test, test1);
			
		}
		Step_End(5, "save the booking in Draft ", test, test1);
		Step_Start(6, "select confirm button and safeclick Save button ", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String UpdatedpopACT = getText(driver, popup_Message);
		System.out.println(UpdatedpopACT);
		if(UpdatedpopACT.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup );
			Extent_pass_New(driver, "Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup , test, test1);
		}else {
			System.out.println("Not Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup );
			Extent_fail(driver, "Not Matched || Expected saved Popup :"+UpdatedpopACT +"|| Actual Saved Popup :"+bookingUpdatedPopup , test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);


		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);


		if (Confirm_bookingColor.equalsIgnoreCase(Confirm_colour)) {
			Extent_pass_New(driver,
					"Matched || The background color of Confirm Booking number textfield is green|| Expected color code:"
							+ Confirm_bookingColor + " || Actual color :" + Confirm_colour,
					test, test1);
			System.out.println("Matched || The background color of Confirm Booking number textfield is green|| Expected color code:"
					+ Confirm_bookingColor + " || Actual color :" + Confirm_colour);
			Extent_pass_New(driver, "Booking drafted", test, test1);

		} else {
			System.out.println("Not Matched || The background color of Confirm Booking number textfield is not green|| Expected color :"
					+ Confirm_bookingColor + " || Actual color :" + Confirm_colour);
			Extent_fail(driver,
					"Not Matched || The background color of Confirm Booking number textfield is not green|| Expected color :"
							+ Confirm_bookingColor + " || Actual color :" + Confirm_colour,
					test, test1);
			
		}
		Step_End(6, "select confirm button and safeclick Save button ", test, test1);

		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);


		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value = getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		
		twoColumnSearchWindow(driver, terminalDetails_Filter, conditionFilter, acc_term_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

	
//		
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		moduleNavigate(driver, Operational_Reset_Module);

		waitForElement(driver, Container_Non_Container);
		click(driver, Container_Non_Container);

		waitForElement(driver, BookingNo_TF);
		sendKeys(driver, BookingNo_TF, booknum);
		waitForElement(driver, Container_No_SearchBtn);
		click(driver, Container_No_SearchBtn);
		
		twoColumnSearchWindow(driver, Container_Number_Header, conditionFilter, Container);

		waitForElement(driver, Operational_Research_loadBtn);
		click(driver, Operational_Research_loadBtn);
		waitForElement(driver, Load_Grid_Select);
		click(driver, Load_Grid_Select);

		waitForElement(driver, Operational_Reset_select);
		click(driver, Operational_Reset_select);
		waitForElement(driver, Revert_Plan_btn);
		click(driver, Revert_Plan_btn);
		waitForElement(driver, operational_Reset_Yes_Btn);
		click(driver, operational_Reset_Yes_Btn);
		waitForElement(driver, operational_Reset_Ok_Btn);
		click(driver, operational_Reset_Ok_Btn);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		moduleNavigate(driver, BookingMoudleSearch);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

		
		
		
		waitForElement(driver, BL_btn);
		click(driver, BL_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, BL_containertab);
		click(driver, BL_containertab);

		waitForElement(driver, BL_containertab);
		waitForElement(driver, BL_container_editicon);
		click(driver, BL_container_editicon);

		waitForElement(driver, BL_equip_field);
		sendKeys(driver, BL_equip_field, random_no);

		waitForElement(driver, BL_editbtn);
		click(driver, BL_editbtn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, BL_BodyTab);
		click(driver, BL_BodyTab);
		waitForElement(driver, BL_body);
		RightClick(driver, BL_body);
		waitForElement(driver, refresh_all);
		click(driver, refresh_all);

		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message);
		String error_popup=getText(driver, popup_Message);
		if(error_popup.contains(BL_saved_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || Excepted Popup value is : "+ BL_saved_msg+" || Actual Popup value is : "+error_popup, test,test1);
			System.out.println("Matched || Excepted Popup value is : "+ BL_saved_msg+" || Actual Popup value is : "+error_popup);
		}
		else {
			System.out.println("BL not saved");
			System.out.println("Not matched || Excepted Popup value is : "+ BL_saved_msg+" || Actual Popup value is : "+error_popup);
			Extent_fail(driver,"Not matched || Excepted Popup value is : "+ BL_saved_msg+" || Actual Popup value is : "+error_popup, test,test1);
		}

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

	

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, Rate_Validity);
		String Rate_Validity_Before = getAttribute(driver, Rate_Validity, "value");
		System.out.println("RateValidityBefore:" + Rate_Validity_Before);
		waitForElement(driver, FirstserviceInput);
		click(driver, FirstserviceInput);
		waitForElement(driver, FirstserviceInput);
		clear(driver, FirstserviceInput);
		waitForElement(driver, FirstserviceInput);
		sendKeys(driver, FirstserviceInput, first_service_data1);
//
		waitForElement(driver, BKG_VoyageInput);
		sendKeys(driver, BKG_VoyageInput, Voyagenumber1);

		waitForElement(driver, BKG_Boundinpiut);
		sendKeys(driver, BKG_Boundinpiut, Boundinput1);

		waitForElement(driver, routing);
		doubleClick(driver, routing);

		waitForElement(driver, Rate_Validity);
		String Rate_Validity_After = getAttribute(driver, Rate_Validity, "value");
		System.out.println("RateValidityAfter:" + Rate_Validity_After);

		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForDisplay(driver, Charges_Data);
		if (!isDisplayed(driver, Charges_Data)) {
			System.out.println("Matched || Expected Result is : Charges Details Should Not display || The Actual Result is : Charges Details Not Displayed");
			Extent_pass_New(driver,"Matched || Expected Result is : Charges Details Should Not display || The Actual Result is : Charges Details Not Displayed", test, test1);
		} else {
			System.out.println("Matched || Expected Result is : Charges Details Should Not display || The Actual Result is : Charges Details Displayed");
			Extent_fail(driver,"Matched || Expected Result is : Charges Details Should Not display || The Actual Result is : Charges Details Displayed", test, test1);
		}
		Extent_completed(test_Case_Name, test, test1);
	}
}
