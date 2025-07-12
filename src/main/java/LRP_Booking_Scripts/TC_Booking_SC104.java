package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;
//check whetherIn Booking, Charge tab spl plugin configuration true and PPA plugin true /false system setcollect location as Pld Agency location
public class TC_Booking_SC104 extends Keywords {

	public void Booking_SC104(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String test_Case_Name = "TC_Booking_SC104";
		
		
		


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
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String pluginStatusFalse = Excel_data.get("pluginStatusFalse");
		String PluginID1 = Excel_data.get("PluginID1");
		String Data3 = Excel_data.get("Data3");
		String Data2 = Excel_data.get("Data2");
		String Data4 = Excel_data.get("Data4");
		String Data1 = Excel_data.get("Data1");
		String ModuleID = Excel_data.get("ModuleID");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearchFilterOption=Excel_data.get("GlobalSearchFilterOption");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Customer_Name_Input=Excel_data.get("Customer_Name_Input");
		String Customer_Name_Search = Excel_data.get("Customer_Name_Search");
		String Booking_Date_Input = Excel_data.get("Booking_Date_Input");
		String Booking_Date_Search = Excel_data.get("Booking_Date_Search");
		String Header_scroll_number = Excel_data.get("Header_scroll_number");
		
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
		String PluginTrue =  String.format(Plugin_Configuration_Locators.PluginTrue,  pluginStatusTrue); 
		String PluginFalse =  String.format(Plugin_Configuration_Locators.PluginFalse,  pluginStatusFalse); 
		
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
		Step_End(3, "Select the Routing ", test, test1);
	
		
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
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

		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		Step_Start(7, "SET SPl and PPA plugin true ", test, test1);

		moduleNavigate(driver, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, ModuleID_Filterbox);
		sendKeys(driver, ModuleID_Filterbox, ModuleID);
		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginTrue);
		safeclick(driver, PluginTrue);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID1);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		click(driver, enable_Status_Dropdown);
		waitForElement(driver, PluginFalse);
		safeclick(driver, PluginFalse);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		Step_End(7, "SET SPl and PPA plugin true ", test, test1);
		
		moduleNavigate(driver, BookingMoudleSearch);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

		
		
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);
		Step_Start(8, "system set collect location as  PLD location", test, test1);
		waitForElement(driver, Pay_Location);
		RightClick(driver, Pay_Location);
		waitForElement(driver, PayMode_Option);
		mouseOverToElement(driver, PayMode_Option);
		waitForElement(driver, Collect);
		click(driver, Collect);

		waitForElement(driver, PortCode1);
		String value_1 = getText(driver, PortCode1);
		System.out.println(value_1);
		if (Data1.equals(value_1)) {

			System.out.println("Matched || Expected value portcode was : " + Data1 + " || Actual value portcode was : " + value_1);
			Extent_pass_New(driver, "Matched || Expected value portcode was : " + Data1 + " || Actual value portcode was : " + value_1, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected value  portcodewas : " + Data1 + " || Actual value portcode was : " + value_1);
			Extent_fail(driver, "NotMatched || Expected value portcode was : " + Data1 + " || Actual value portcode was : " + value_1,
					test, test1);

		}

		waitForElement(driver, PortCode2);
		String value_2 = getText(driver, PortCode2);
		System.out.println(value_2);
		if (Data2.equals(value_2)) {

			System.out.println("Matched || Expected value portcode was : " + Data2 + " || Actual value portcode was : " + value_2);
			Extent_pass_New(driver, "Matched || Expected value portcode was : " + Data2 + " || Actual value portcode was : " + value_2, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected value portcode was : " + Data2 + " || Actual value portcode was : " + value_2);
			Extent_fail(driver, "NotMatched || Expected value portcode was : " + Data2 + " || Actual value portcode was : " + value_2,
					test, test1);

		}

		waitForElement(driver, PortCode3);
		String value_3 = getText(driver, PortCode3);
		System.out.println(value_3);
		if (Data3.equals(value_3)) {

			System.out.println("Matched || Expected value portcode was : " + Data3 + " || Actual value was : " + value_3);
			Extent_pass_New(driver, "Matched || Expected value portcode was : " + Data3 + " || Actual value was : " + value_3, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected value portcode was : " + Data3 + " || Actual value portcode was : " + value_3);
			Extent_fail(driver, "NotMatched || Expected value portcod ewas : " + Data3 + " || Actual value portcode was : " + value_3,
					test, test1);
			

		}

		waitForElement(driver, PortCode4);
		String value_4 = getText(driver, PortCode4);
		System.out.println(value_4);
		if (Data4.equals(value_4)) {

			System.out.println("Matched || Expected value portcode was : " + Data4 + " || Actual value portcode was : " + value_4);
			Extent_pass_New(driver, "Matched || Expected value portcode was : " + Data4 + " || Actual value portcode was : " + value_4, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected value portcode was : " + Data4 + " || Actual value portcode was : " + value_4);
			Extent_fail(driver, "NotMatched || Expected value portcode  was : " + Data4 + " || Actual value portcode was : " + value_4,
					test, test1);

		}

		Step_Start(8, "system set collect location as  PLD location", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}

