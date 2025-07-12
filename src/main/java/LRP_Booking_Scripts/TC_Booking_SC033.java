package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

//Check whether while select the Rates based on that system will insert the contianer in container tab

public class TC_Booking_SC033 extends Keywords {

	public void Booking_SC033(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC033";
		

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
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String Draft_Save_Popup = Excel_data.get("Draft_Save_Popup");
		String Select_Columns = Excel_data.get("Select_Columns");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
	 
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
	
		String Eqp_Type_Select =  String.format(Booking_Locators.Eqp_Type_Select,  rate_no); 

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

		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		
		reArrangeAG_GridColumns(driver, Select_Columns);
		waitForElement(driver, Eqp_Type_Select);

		String Eqp_Type_Value = getText(driver, Eqp_Type_Select);
		System.out.println("Rates Eqp Value:" + Eqp_Type_Value);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);

		safeclick(driver, ok_btn);
		Step_End(3, "Select the Routing ", test, test1);
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(5, "System set the container details   in container tab", test, test1);

		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);
		waitForElement(driver, con_editicon);
		if (isDisplayed(driver, con_editicon)) {
			System.out.println("Matched || Expected Result is : Container grid Should be display || Actual Result is : Container grid is displayed");
			Extent_pass_New(driver, "Matched || Expected Result is : Container grid Should be display || Actual Result is : Container grid is displayed", test, test1);
		} else {
			System.out.println("Not Matched || Expected Result is : Container grid Should be display || Actual Result is : Container grid is Not displayed");
			Extent_fail(driver, "Not Matched || Expected Result is : Container grid Should be display || Actual Result is : Container grid is Not displayed", test, test1);

		}
		
		List<Map<String, String>> Container_Data = getTableData(driver, Container_Tab_grid_Header, Container_Tab_Grid_Row);
		String Equipment_Type = getFirstRowValueByHeaderFromTableData(Container_Data, "Equipment Type");
		System.out.println("Equipment_Type :"+Equipment_Type);

		if (Eqp_Type_Value.equals(Equipment_Type)) {
			System.out
					.println("Matched || Expected value was : " + Eqp_Type_Value + " || Actual value was : " + Equipment_Type);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + Eqp_Type_Value + " || Actual value was : " + Equipment_Type, test,
					test1);
		} else {
			System.out.println(
					"NotMatched || Expected value was : " + Eqp_Type_Value + " || Actual value was : " + Equipment_Type);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + Eqp_Type_Value + " || Actual value was : " + Equipment_Type, test,
					test1);
		}
		Step_End(5, "System set the container details   in container tab", test, test1);
		Step_Start(6, "save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		waitForDisplay(driver, Container_Add_PopupClose);
		if (isdisplayed(driver, Container_Add_PopupClose)) {
			safeclick(driver, Container_Add_PopupClose);
		}
		// Verification of saved popup of draft
		waitForPopup(driver, popup_Message,Draft_Save_Popup);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		Extent_cal(test, test1,"**********Verifting the saved popup**********");
		if(savepopACT.contains(Draft_Save_Popup)) {                                                                                                                  
			System.out.println("Matched || The Expected Pop-up Value is : " + Draft_Save_Popup + " || The Actual Pop-up Value is : " + savepopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + Draft_Save_Popup + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + Draft_Save_Popup + " || But The Actual Pop-up Value is : " + savepopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + Draft_Save_Popup + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
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

		Step_End(6, "save the booking in Draft", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}

	
	
}
