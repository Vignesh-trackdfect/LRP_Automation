package LRP_Booking_Scripts;

import java.util.Map;
//check whether in booking, based on BCP plugin configuration Collapse panel Expended in Booking

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;
public class TC_Booking_SC081 extends Keywords {

	public void Booking_SC081(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC081";
		
		
		



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
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("pluginID");
		String pluginUpdatedPopup = Excel_data.get("pluginUpdatedPopup");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String pluginStatusFalse = Excel_data.get("pluginStatusFalse");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Draft_Colour = Excel_data.get("Draft_Colour");

		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
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
		// Non-Mandatory field
		if (!SCAC_Code_Value.equals("")) {
			waitForElement(driver, SCAC_code_TF);
			sendKeys(driver, SCAC_code_TF, SCAC_Code_Value);
		}

		if (!Priority_Value.equals("")) {
			click(driver, Priority);
		}
		if (!Agency_RefNo_Value.equals("")) {
			waitForElement(driver, Agency_RefNo_TF);
			sendKeys(driver, Agency_RefNo_TF, Agency_RefNo_Value);
		}
		if (!TOS_Value.equals("")) {
			click(driver, TOS);
			if (Checkbox_Select_3PL.equalsIgnoreCase("YES")) {
				checkBox(driver, CheckBox_3PL, Checkbox_Select_3PL);
				waitForElement(driver, Operator_Code_3PL_searchBtn);
				click(driver, Operator_Code_3PL_searchBtn);
				waitForElement(driver, Operator_Code_TF);
				sendKeys(driver, Operator_Code_TF, Operator_Code_value);
				waitForElement(driver, Code_Val);
				click(driver, Code_Val);
				waitForElement(driver, Popup_selectBtn);
				click(driver, Popup_selectBtn);

			}
		}
		Step_End(2, "Enter the POL and POD", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(5, "save the booking in Draft", test, test1);
		

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		if(savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected saved Popup : "+savedpopEXP +"|| Actual Saved Popup : "+savepopACT );
			Extent_pass_New(driver, "Matched || Expected saved Popup : "+savedpopEXP +"|| Actual Saved Popup : "+savepopACT , test, test1);
		}else {
			System.out.println("Not Matched || Expected saved Popup : "+savedpopEXP +"|| Actual Saved Popup : "+savepopACT );
			Extent_fail(driver, "Not Matched || Expected saved Popup : "+savedpopEXP +"|| Actual Saved Popup : "+savepopACT , test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		if (draft_bookingColor.equalsIgnoreCase(Draft_Colour)) {
			Extent_pass_New(driver,
					"Matched || The background color of draft Booking number textfield is yellow|| Expected color :"
							+ draft_bookingColor + " || Actual color :" + Draft_Colour,
					test, test1);
			System.out.println("Matched || The background color of draft Booking number textfield is yellow|| Expected color :"
					+ draft_bookingColor + " || Actual color :" + Draft_Colour);
			Extent_pass_New(driver, "Booking drafted", test, test1);

		} else {
			System.out.println("Not Matched || The background color of draft Booking number textfield is not yellow|| Expected color :"
					+ draft_bookingColor + " || Actual color :" + Draft_Colour);
			Extent_fail(driver,
					"Not Matched || The background color of draft Booking number textfield is not yellow|| Expected color :"
							+ draft_bookingColor + " || Actual color :" + Draft_Colour,
					test, test1);
			
		}

		Step_End(5, "save the booking in Draft", test, test1);
		waitForElement(driver, master_tab);
		click1(driver, master_tab);

		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);

		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);
		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "select confirm button and click Save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message);
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
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);
		if (Confirm_bookingColor.equalsIgnoreCase(Confirm_colour)) {
			Extent_pass_New(driver,
					"Matched || The background color of Confirm Booking number textfield is green|| Expected color code:"
							+ Confirm_bookingColor + " || Actual color code:" + Confirm_colour,
					test, test1);
			System.out.println("The background color of Confirm Booking number textfield is "+Confirm_bookingColor);
			Extent_pass_New(driver, "Booking drafted", test, test1);

		} else {
			System.out.println("The background color of Confirm Booking number textfield is not green");
			Extent_fail(driver,
					"Not Matched || The background color of Confirm Booking number textfield is not green|| Expected color code:"
							+ Confirm_bookingColor + " || Actual color code:" + Confirm_colour,
					test, test1);
		}
		Step_End(7, "select confirm button and click Save button", test, test1);
		Extent_cal(test, test1,
				"click Leg tab to verify control panel is expanded before plugin configuration BCP True");

		waitForElement(driver, Leg_tab);
		click(driver, Leg_tab);

		waitForDisplay(driver, Leg_tab);
		if (!isDisplayed(driver, Leg_Tab_Element)) {
			System.out.println("Matched || Expected Result is : Before BCP plugin set as true Leg Tab Control Panel is Should Not Expand || The Actual Result is : Before BCP plugin set as true Leg Tab Control Panel is Not Expanded");
			Extent_pass_New(driver, "Matched || Expected Result is : Before BCP plugin set as true Leg Tab Control Panel is Should Not Expand || The Actual Result is : Before BCP plugin set as true Leg Tab Control Panel is Not Expanded", test, test1);
		} else {
			System.out.println("Not Matched || Expected Result is : Before BCP plugin set as true Leg Tab Control Panel is Should Not Expand || The Actual Result is : Before BCP plugin set as true Leg Tab Control Panel is Expanded");
			Extent_fail(driver, "Not Matched || Expected Result is : Before BCP plugin set as true Leg Tab Control Panel is Should Not Expand || The Actual Result is : Before BCP plugin set as true Leg Tab Control Panel is Expanded", test, test1);

		}
		waitForElement(driver, Module_Close);
		click1(driver, Module_Close);
		Step_Start(8, "BCP plugin set true ", test, test1);
		// Plugin Configuration module
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, pluginConfigurationModule);
				
		// Plugin Configuration True

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		String actualPluginID = getText(driver, first_Plugin_Row);
		if (actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID + " plugin ID is available", test, test1);
			System.out.println(pluginID + " plugin ID is available");
		}
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		click(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginTrue);
		click(driver, PluginTrue);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Popup_Message);
		String actualUpdatedPopup = getText(driver, Popup_Message);
		System.out.println("actualUpdatedPopup:" + actualUpdatedPopup);
		if (actualUpdatedPopup.contains(pluginUpdatedPopup)) {
			Extent_pass_New(driver, pluginUpdatedPopup + " popup is displayed", test, test1);
			System.out.println("Matched || The Expected Pop-up value is : "+pluginUpdatedPopup+" || The Actual Pop-up value is : ");
		} else {
			Extent_fail(driver, pluginUpdatedPopup + " popup is not displayed", test, test1);
			System.out.println(pluginUpdatedPopup + " popup is not displayed");
		}
		Step_Start(8, "BCP plugin set true ", test, test1);
		waitForElement(driver, Module_Close);
		click1(driver, Module_Close);

		Step_Start(9, "click Leg tab + button collapse panel enabled", test, test1);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, BookingMoudleSearch);

		// click Leg tab to verify control panel is expand
		waitForElement(driver, Leg_tab);
		click(driver, Leg_tab);
		waitForDisplay(driver, Leg_Tab_Element);
		if (isDisplayed(driver, Leg_Tab_Element)) {
			System.out.println("Matched || Expected Result is : After BCP plugin set as true Leg Tab Control Panel Should be Expand || The Actual Result is : After BCP plugin set as true Leg Tab Control Panel is Expanded");
			Extent_pass_New(driver, "Matched || Expected Result is : After BCP plugin set as true Leg Tab Control Panel Should be Expand || The Actual Result is : After BCP plugin set as true Leg Tab Control Panel is Expanded", test, test1);
		} else {
			System.out.println("Matched || Expected Result is : After BCP plugin set as true Leg Tab Control Panel Should be Expand || The Actual Result is : After BCP plugin set as true Leg Tab Control Panel Not Expanded");
			Extent_fail(driver, "Matched || Expected Result is : After BCP plugin set as true Leg Tab Control Panel Should be Expand || The Actual Result is : After BCP plugin set as true Leg Tab Control Panel Not Expanded", test, test1);

		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_End(9, "click Leg tab + button collapse panel enabled", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		click(driver, enable_Status_Dropdown);
		waitForElement(driver, PluginFalse);
		click(driver, PluginFalse);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Extent_completed(test_Case_Name,test, test1);
	}
}
