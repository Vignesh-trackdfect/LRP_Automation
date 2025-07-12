package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//Check whether while select the Rates in Rates window system will insert the Agreement party in master tab
public class TC_Booking_SC035 extends Keywords {

	public void Booking_SC035(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC035";



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String AgencyUser = Excel_data.get("AgencyUser");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Select_Columns = Excel_data.get("Select_Columns");
		
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
	
		String Customer_Name_Select =  String.format(Booking_Locators.Customer_Name_Select,  rate_no); 

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");
		Extent_call(test, test1, "********** Enter Booking Module **********");

        Step_Start(1, "Open Booking Module", test, test1);
        
		moduleNavigate(driver, BookingMoudleSearch);
        Step_End(1, "Open Booking Module", test, test1);

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
		Step_Start(3, "System set the AP in master tab", test, test1);
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
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
//	
		reArrangeAG_GridColumns(driver, Select_Columns);
		waitForElement(driver, Customer_Name_Select);
		String Customer_Name = getText(driver, Customer_Name_Select);
		System.out.println("Rates Customer Value:" + Customer_Name);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		safeclick(driver, ok_btn);
		
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		waitForElement(driver, Agr_Party_TF);
		String Agr_Party = getAttribute(driver, Agr_Party_TF, "value");
		System.out.println(Agr_Party);
		if (Agr_Party.contains(Customer_Name)) {
			System.out.println(
					"Matched || Expected value was : " + Agr_Party + " || Actual value was : " + Customer_Name);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + Agr_Party + " || Actual value was : " + Customer_Name, test,
					test1);
		} else {
			System.out.println(
					"NotMatched || Expected value was : " + Agr_Party + " || Actual value was : " + Customer_Name);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + Agr_Party + " || Actual value was : " + Customer_Name, test,
					test1);
		}
		Step_End(3, "System set the AP in master tab", test, test1);
		
		Extent_call(test, test1, "********** Customer details Verify start**********");
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);

		waitForElement(driver, Customer_Grid_EditBtn);
		safeclick(driver, Customer_Grid_EditBtn);

		waitForElement(driver, CustomerName_TF);
	
		Extent_completed(test_Case_Name, test, test1);

	}
}