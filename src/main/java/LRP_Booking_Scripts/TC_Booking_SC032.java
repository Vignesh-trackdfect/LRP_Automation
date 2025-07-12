package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//Check whether when select the Rates system will attach the Routing based on Rates details
public class TC_Booking_SC032 extends Keywords {

	public void Booking_SC032(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC032";
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Select_Columns = Excel_data.get("Select_Columns");
		
		String rate_no = Excel_data.get("rate_no");
	
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
	
		String Origin_Select =  String.format(Booking_Locators.Origin_Select,  rate_no); 
		String Delivery_Select =  String.format(Booking_Locators.Delivery_Select,  rate_no); 

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");
		
		Extent_cal(test, test1,"** Enter Booking Module **");
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
		Step_End(2, "Enter the POL and POD", test, test1);
		Step_Start(3, "System default set the Routing  ", test, test1);
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
		System.out.println("**Routing Select**");

		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		
		reArrangeAG_GridColumns(driver, Select_Columns);

		waitForElement(driver, Origin_Select);
		String Origin_Value = getText(driver, Origin_Select);
		waitForElement(driver, Delivery_Select);
		String Delivery_Value = getText(driver, Delivery_Select);
		System.out.println("Rates Delivery Value:" + Delivery_Value);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		safeclick(driver, ok_btn);
		Step_End(3, "System default set the Routing  ", test, test1);
		
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Extent_cal(test, test1, "**Step2:Enter the POL and POD and select the Rates using Rates window End**");

		System.out.println("**Step3:System default set the Routing start**");
		Extent_cal(test, test1, "**Step3:System default set the Routing start**");
		
		String POL_Val2 = getText(driver, Routing_PolValue);
		if (Origin_Value.equals(POL_Val2)) {
			System.out
					.println("Matched || Expected value was : " + Origin_Value + " || Actual value was : " + POL_Val2);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + Origin_Value + " || Actual value was : " + POL_Val2, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Expected value was : " + Origin_Value + " || Actual value was : " + POL_Val2);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + Origin_Value + " || Actual value was : " + POL_Val2, test,
					test1);
		}

		waitForElement(driver, Routing_Delivery_Value1);
		String POL_Val4 = getText(driver, Routing_Delivery_Value1);
		if (Delivery_Value.equals(POL_Val4)) {
			System.out.println(
					"Matched || Expected value was : " + Delivery_Value + " || Actual value was : " + POL_Val4);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + Delivery_Value + " || Actual value was : " + POL_Val4, test,
					test1);
		} else {
			System.out.println(
					"NotMatched || Expected value was : " + Delivery_Value + " || Actual value was : " + POL_Val4);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + Delivery_Value + " || Actual value was : " + POL_Val4, test,
					test1);
		}
		Step_End(3, "System default set the Routing  ", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}