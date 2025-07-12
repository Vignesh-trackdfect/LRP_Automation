package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC144 extends Keywords {

	public void Booking_SC144(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {


		String test_Case_Name = "TC_Booking_SC144";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String rate_no = Excel_data.get("rate_no");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String Commodity_Code = Excel_data.get("Commodity_Code");
		String restricted_pop = Excel_data.get("restricted_pop");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String first_service_data = Excel_data.get("Service");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String condition = Excel_data.get("condition");
		String Operator_Code_Header = Excel_data.get("Operator_Code_Header");
		String Header_scroll_number = Excel_data.get("Header_scroll_number");

// locators

		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		
		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");
		Extent_call(test, test1, "********** Enter Booking Module **********");
		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
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

// Non-Mandatory field
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
		if (Checkbox_Select_3PL.equals("YES")) {
			checkBox(driver, CheckBox_3PL, Checkbox_Select_3PL);
			waitForElement(driver, Operator_Code_3PL_searchBtn);
			safeclick(driver, Operator_Code_3PL_searchBtn);
			
			twoColumnSearchWindow(driver, Operator_Code_Header, condition, Operator_Code_value);
			

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
		
		editSchedule(driver, first_service_data);
		
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		

		Step_End(4, "Select the Schedule ", test, test1);
		Step_Start(5, "save the booking in Draft", test, test1);
		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);
scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);


		Step_End(5, "save the booking in Draft", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);

		
	Step_Start(6, "SYSTEM Validate commodity based on commodity type", test, test1);
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Grid_EditBtn);
		safeclick(driver, Commodity_Grid_EditBtn);
		
		waitForElement(driver, HS_Code_Input);
		sendKeys(driver, HS_Code_Input, Commodity_Code);
		waitForElement(driver, HS_Code_Select);
		click(driver, HS_Code_Select);
		
		
		
		waitForElement(driver, Commodity_Add_Btn);
		safeclick(driver, Commodity_Add_Btn);
		
		
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		
//		waitForPopup(driver, popup_Message,savedpopEXP);
//		String savepopACT = getText(driver, popup_Message);
//		System.out.println(savepopACT);
//		if(savepopACT.contains(savedpopEXP)) {                                                                                                                  
//			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT);            
//			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
//		}else {                                                                                                                                                                   
//			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT);        
//			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
//		} 
//
//
//
//		waitForElement(driver, popup_Message_Ok_Button);
//		safeclick(driver, popup_Message_Ok_Button);
		
		waitForPopup(driver, savedpop,restricted_pop);
		String Restricted_Popup = getText(driver, savedpop);
		System.out.println(Restricted_Popup);
		if(Restricted_Popup.contains(restricted_pop)) {                                                                                                                  
			System.out.println("Matched || " + " Actual Report Activity  popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop);            
			Extent_pass_New(driver, "Matched || " + " Actual Report Activity popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Actual Report Activity popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop);        
			Extent_fail(driver, "Not Matched || " + " Actual Report Activity popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop, test,test1); 
		} 
		
		Step_Start(6, "SYSTEM Validate commodity based on commodity type", test, test1);
		Extent_completed(test_Case_Name, test, test1);

	}
}
