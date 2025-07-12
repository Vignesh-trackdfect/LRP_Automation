package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//Check whether Attached Origin as inland port then system will enable the POL search correctly.
public class TC_Booking_SC031 extends Keywords {

	public void Booking_SC031(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC031";


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String POL_InputValue = Excel_data.get("POL_InputValue");
		String AgencyUser = Excel_data.get("AgencyUser");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Pol_Code_Header = Excel_data.get("Pol_Code_Header");
		String conditionFilter=Excel_data.get("ConditionFilter");
		
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
		
		Step_Start(3, "safeclick Route button (EDIT)", test, test1);
		
		waitForElement(driver, Booking_Rate_Close_Btn);
		safeclick(driver, Booking_Rate_Close_Btn);
		
		
		waitForElement(driver, Routingedit);
		safeclick(driver, Routingedit);
		Step_End(3, "safeclick Route button (EDIT)", test, test1);
		Step_Start(4, "System display the pol search", test, test1);
		Extent_cal(test, test1, "verify POL search button Enabled or not");
		waitForElement(driver, POL_Search_Btn);
		if (IsElementEnabled(driver, POL_Search_Btn)) {
			System.out.println("Matched || Expected Result is : ' POL Search Button Should be Enable ' || Actual Result is : ' POL Search Button is Enabled '");
			Extent_pass_New(driver,"Matched || Expected Result is : ' POL Search Button Should be Enable ' || Actual Result is : ' POL Search Button is Enabled '", test, test1);
		} else {
			System.out.println("Not Matched || Expected Result is : ' POL Search Button Should be Enable ' || Actual Result is : ' POL Search Button is Disabled '");
			Extent_fail(driver,"Not Matched || Expected Result is : ' POL Search Button Should be Enable ' || Actual Result is : ' POL Search Button is Disabled '", test, test1);
		}
		waitForElement(driver, POL_Input);
		Newclear_Type(driver);
		sendKeys(driver, POL_Input, POL_InputValue);
		System.out.println("Pol Value:" + POL_InputValue);
		safeclick(driver, POL_Search_Btn);
		twoColumnSearchWindow(driver, Pol_Code_Header, conditionFilter, POL_InputValue);
		if (IsElementEnabled(driver, POL_Search_Btn)) {
			System.out.println("Matched || Expected Result is : ' POL Search Button Should be Enable and able to search value ' || Actual Result is : ' POL Search Button is Enabled and able to search the value '");
			Extent_pass_New(driver,"Matched || Expected Result is : ' POL Search Button Should be Enable and able to search value ' || Actual Result is : ' POL Search Button is Enabled and able to search the value '", test, test1);
		} else {
			System.out.println("Not Matched || Expected Result is : ' POL Search Button Should be Enable and able to search value ' || Actual Result is : ' POL Search Button is Disabled and Unable to search the value '");
			Extent_fail(driver,"Not Matched || Expected Result is : ' POL Search Button Should be Enable and able to search value ' || Actual Result is : ' POL Search Button is Disabled and Unable to search the value '", test, test1);
		}
		String POL = getAttribute(driver, POL_TF, "value");
		System.out.println(POL);
		if (POL_InputValue.equals(POL)) {
			System.out.println("Matched || Expected value was : " + POL_InputValue + " || Actual value was : " + POL);
			Extent_pass_New(driver, "Matched || Expected value was : " + POL_InputValue + " || Actual value was : " + POL,
					test, test1);
		} else {
			System.out
			.println("NotMatched || Expected value was : " + POL_InputValue + " || Actual value was : " + POL);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + POL_InputValue + " || Actual value was : " + POL, test,
					test1);
		}
		Step_End(4, "System display the pol search", test, test1);
		Extent_completed(test_Case_Name, test, test1);

	}
}