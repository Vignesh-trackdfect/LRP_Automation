
package LRP_Booking_Scripts;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;
//Check whether in Booking, based on the BBP plugin configuration system not retain the BP customer.
public class TC_Booking_SC146 extends Keywords {

	public void Booking_SC146(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String test_Case_Name = "TC_Booking_SC146";
		
		
		



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
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String Clear_Reset_Popup = Excel_data.get("Clear_Reset_Popup");
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("pluginID");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String pluginStatusFalse = Excel_data.get("pluginStatusFalse");
		String Clear_Agr_Party = Excel_data.get("Clear_Agr_Party");
		String data_Reset = Excel_data.get("Data reset");
		String bp_Field = Excel_data.get("Bp_Field_Check");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearchFilterOption=Excel_data.get("GlobalSearchFilterOption");
		
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
		String PluginTrue =  String.format(Plugin_Configuration_Locators.PluginTrue,  pluginStatusTrue); 
		String PluginFalse =  String.format(Plugin_Configuration_Locators.PluginFalse,  pluginStatusFalse); 
		String data_To_Reset =  String.format(Booking_Locators.data_To_Reset,  data_Reset); 

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
			safeclick(driver, Priority);
		}
		if (!Agency_RefNo_Value.equals("")) {
			waitForElement(driver, Agency_RefNo_TF);
			sendKeys(driver, Agency_RefNo_TF, Agency_RefNo_Value);
		}
		if (!TOS_Value.equals("")) {
			safeclick(driver, TOS);
			if (Checkbox_Select_3PL.equals("YES")) {
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
		}

		Step_End(2, "Enter the POL and POD", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		
		Step_Start(5, "save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 

		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		Step_End(5, "save the booking in Draft", test, test1);
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);

		waitForElement(driver, BP_Customer);
		if (isDisplayed(driver, BP_Customer)) {
			System.out.println("*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is :Before Reseting the AP, AP  is displayed");            
			Extent_pass_New(driver,"*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is : Before Reseting the AP, AP  is displayed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is : Before Reseting the AP, AP  is not displayed");        
			Extent_fail(driver, "*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is : Before Reseting the AP, AP  is not displayed", test,test1); 
		} 
			

		waitForElement(driver, AP_Customer);
		if (isDisplayed(driver, AP_Customer)) {
			System.out.println("*The Expected Result is : Before Reseting the AP, AP  is displayed || The Actual Result is :Before Reseting the AP, AP  is displayed");            
			Extent_pass_New(driver,"*The Expected Result is : Before Reseting the AP, AP  is displayed || The Actual Result is : Before Reseting the AP, AP  is displayed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Before Reseting the AP, AP  is displayed || The Actual Result is : Before Reseting the AP, AP  is not displayed");        
			Extent_fail(driver, "*The Expected Result is : Before Reseting the AP, AP  is displayed || The Actual Result is : Before Reseting the AP, AP  is not displayed", test,test1); 
		} 
			

		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		Step_Start(6, "set BBP plugin false", test, test1);

		moduleNavigate(driver, pluginConfigurationModule);

		waitForElement(driver, pluginConfiguration_Tab);
		

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, first_PluginID_Row);
		String actualPluginID = getText(driver, first_PluginID_Row);
		if (actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID + " plugin ID is available", test, test1);
			System.out.println(pluginID + " plugin ID is available");

			doubleClick(driver, first_PluginID_Row);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			safeclick(driver, enable_Status_Dropdown);

			waitForElement(driver, PluginFalse);
			safeclick(driver, PluginFalse);

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			waitForElement(driver, close_first_Tab);
			safeclick(driver, close_first_Tab);
		
		Step_End(6, "set BBP plugin false", test, test1);
		moduleNavigate(driver, BookingMoudleSearch);
		
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, "", "", "", "");
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_Start(7, "reset the AP system not retain  the BP customer", test, test1);
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);
		waitForElement(driver, Master_ResetBtn);
		safeclick(driver, Master_ResetBtn);

		waitForElement(driver, data_To_Reset);
		safeclick(driver, data_To_Reset);

		waitForPopup(driver, popup_Message, Clear_Agr_Party);

		String value5 = getText(driver, popup_Message);
		if (value5.equals(Clear_Agr_Party)) {
			System.out
					.println("Matched || Expected value POPUP was : " + value5 + " || Actual value  POPUP was : " + Clear_Agr_Party);
			Extent_pass_New(driver,
					"Matched || Expected value POPUP was : " + value5 + " || Actual value POPUP was : " + Clear_Agr_Party, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Expected value  POPUPwas : " + value5 + " || Actual value POPUP was : " + Clear_Agr_Party);
			Extent_fail(driver,
					"NotMatched || Expected value  POPUP was : " + value5 + " || Actual value POPUP  was : " + Clear_Agr_Party, test,
					test1);

		}
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		waitForPopup(driver, popup_Message, Clear_Reset_Popup);
		String Reset_Popup = getText(driver, popup_Message);
		System.out.println(Reset_Popup);
		if (Clear_Reset_Popup.equals(Reset_Popup)) {
			System.out.println(
					"Matched || Expected value POPUP was : " + Clear_Reset_Popup + " || Actual value POPUP was : " + Reset_Popup);
			Extent_pass_New(driver,
					"Matched || Expected value POPUP was : " + Clear_Reset_Popup + " || Actual value POPUP was : " + Reset_Popup,
					test, test1);
		} else {
			System.out.println("NotMatched || Expected value POPUP was : " + Clear_Reset_Popup + " || Actual value POPUP was : "
					+ Reset_Popup);
			Extent_fail(driver,
					"NotMatched || Expected value POPUP was : " + Clear_Reset_Popup + " || Actual value POPUP was : " + Reset_Popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

      waitForElement(driver, BP_Customer_New);
		String bp_Customer_Check = getText(driver, BP_Customer_New);
		System.out.println("Customer type present in the table is: " + bp_Customer_Check);
		if (bp_Field.equals(bp_Customer_Check)) {
			System.out.println("After resetting the agreement party BP is retained");
			System.out.println("Matched || " + "Expected Customer type is : " + bp_Field
					+ " || Actual Customer type is : " + bp_Customer_Check);
			Extent_pass_New(driver, "Matched || " + " Expected Customer type is : " + bp_Field
					+ " ||Actual Customer type is : " + bp_Customer_Check, test, test1);
		}

		else {
			System.out.println("After resetting the agreement party BP is retained");
			System.out.println("Not Matched || " + "Expected Customer type is : " + bp_Field
					+ " || Actual Customer type is : " + bp_Customer_Check);
			Extent_fail(driver, "Not Matched || " + " Expected Customer type is : " + bp_Field
					+ " ||Actual Customer type is : " + bp_Customer_Check, test, test1);

		}

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Step_End(7, "reset the AP system not retain  the BP customer", test, test1);
		moduleNavigate(driver, pluginConfigurationModule);
		
		waitForElement(driver, pluginConfiguration_Tab);
	

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_PluginID_Row);
		String actualPluginID1 = getText(driver, first_PluginID_Row);
		if (actualPluginID1.equals(pluginID)) {
			Extent_pass_New(driver, pluginID + " plugin ID is available", test, test1);
			System.out.println(pluginID + " plugin ID is available");

			doubleClick(driver, first_PluginID_Row);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			safeclick(driver, enable_Status_Dropdown);

			waitForElement(driver, PluginTrue);
			safeclick(driver, PluginTrue);

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

		} else {
			System.out.println(pluginID + " plugin ID is unavailable");
			Extent_fail(driver, pluginID + " plugin ID is unavailable", test, test1);
		}

		Extent_completed(test_Case_Name, test, test1);
	}
}
}
