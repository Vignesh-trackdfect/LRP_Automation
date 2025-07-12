package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC110 extends Keywords {

	public void Booking_SC110(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC110";
		
		
		



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
		String Service = Excel_data.get("Service");
		String Container_Select = Excel_data.get("Container_Select");
		String Operational_Reset_Module = Excel_data.get("Operational_Reset_Module");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Container_Number_Header = Excel_data.get("Container_Number_Header");
		String ConditionFilter = Excel_data.get("ConditionFilter");
		String terminalDetails_Filter = Excel_data.get("terminalDetails_Filter");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Customer_Name_Search = Excel_data.get("Customer_Name_Search");
		String Customer_Name_Input=Excel_data.get("Customer_Name_Input");
		String Booking_Date_Input = Excel_data.get("Booking_Date_Input");
		String Booking_Date_Search = Excel_data.get("Booking_Date_Search");
		String globalSearchFilterOption = Excel_data.get("globalSearchFilterOption");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Container = Excel_data.get("Container");


		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String Container_Non_Container =  String.format(Booking_Locators.Container_Non_Container,  Container_Select); 
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
		safeclick(driver, ok_btn);
		Step_End(3, "Select the Routing ", test, test1);
		
	
		
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(5, "save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
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
		Step_End(5, "save the booking in Draft", test, test1);
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

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
		
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
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

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		Step_Start(8, "Release CRO", test, test1);
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value = getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		
		twoColumnSearchWindow(driver, terminalDetails_Filter, ConditionFilter, acc_term_value);


		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(8, "Release CRO", test, test1);
		Step_Start(9, "revert operation load plan", test, test1);

		moduleNavigate(driver, Operational_Reset_Module);
		
		waitForElement(driver, Container_Non_Container);
		click(driver, Container_Non_Container);
		
		waitForElement(driver, BookingNo_TF);
		sendKeys(driver, BookingNo_TF, booknum);
		waitForElement(driver, Container_No_SearchBtn);
		click(driver, Container_No_SearchBtn);
		twoColumnSearchWindow(driver, Container_Number_Header, ConditionFilter, Container);

		waitForElement(driver, Operational_Research_loadBtn);
		click(driver, Operational_Research_loadBtn);
		waitForElement(driver, Load_Grid_Select);
		click(driver, Load_Grid_Select);
		
		waitForElement(driver, Operational_Reset_select);
		click(driver, Operational_Reset_select);
		waitForElement(driver, Revert_Plan_btn);
		click(driver, Revert_Plan_btn);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(9, "revert operation load plan", test, test1);
	
		moduleNavigate(driver, BookingMoudleSearch);
				
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);
		scrollTop(driver);
		
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		
		Step_Start(10, "Edit the Schedule", test, test1);
		waitForElement(driver, FirstserviceInput);
		if (isElementAccessible(driver, FirstserviceInput)) {
			waitForElement(driver, FirstserviceInput);
			click(driver, FirstserviceInput);
			waitForElement(driver, FirstserviceInput);
			clear(driver, FirstserviceInput);
			waitForElement(driver, FirstserviceInput);
			sendKeys(driver, FirstserviceInput, Service);
			
			Extent_pass_New(driver, "Matched || Expected Result is : *After auto load plan done system allow to edit the scedule details || Actual Result is :*After auto load plan done system allow to edit the scedule details", test, test1);
			System.out.println("Matched || Expected Result is :*After auto load plan done system allow to edit the scedule details || Actual Result is :*After auto load plan done system allow to edit the scedule details");
		}else {
			System.out.println("Not Matched || Expected Result is : *After auto load plan done system allow to edit the scedule details || Actual Result is : *After auto load plan done system not allow to edit the scedule details");
			Extent_fail(driver,"Not Matched || Expected Result is : *After auto load plan done system allow to edit the scedule details || Actual Result is : *After auto load plan done system not allow to edit the scedule details", test, test1);
		}
		
			
		
		Step_End(10, "Edit the Schedule", test, test1);
        Extent_completed(test_Case_Name, test, test1);
	}
}
