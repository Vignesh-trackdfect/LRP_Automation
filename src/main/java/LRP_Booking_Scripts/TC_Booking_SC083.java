package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//check whether in booking, based on BIC plugin configuration and ICB global configuration false in customer tab mentioned ap customer Intercompany then while autorate system not set the pay location as DEHAM AND PAYMODE as PAYAT & Pay By as AP (follow the normal process)
import locators.Plugin_Configuration_Locators;

public class TC_Booking_SC083 extends Keywords {

	public void Booking_SC083(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String test_Case_Name = "TC_Booking_SC083";
		
		
		




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
		String pluginID = Excel_data.get("pluginID");
		String pluginStatusFalse = Excel_data.get("pluginStatusFalse");
		String GlobalValue = Excel_data.get("GlobalValue");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String CustomerMasterModule = Excel_data.get("CustomerMasterModule");
		String CutomerValue1 = Excel_data.get("CutomerValue1");
		String MappedPopup = Excel_data.get("MappedPopup");
		String CustomerValue2 = Excel_data.get("CustomerValue2");
		String CustomerUpdate = Excel_data.get("CustomerUpdate");
		String Customer_Checkbox = Excel_data.get("Customer_Checkbox");
		String conditionFilter = Excel_data.get("conditionFilter");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");

		
		
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
		String PluginFalse =  String.format(Plugin_Configuration_Locators.PluginFalse,  pluginStatusFalse); 


		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");
	
		Step_Start(1, "BIC plugin true and ICB Global config Y", test, test1);

		moduleNavigate(driver, pluginConfigurationModule);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginFalse);
		safeclick(driver, PluginFalse);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForElement(driver, Module_Close);
		safeclick(driver, Module_Close);

		moduleNavigate(driver, GlobalConfigurationModule);

//		waitForElement(driver, Filter_Menu);
//		click(driver, Filter_Menu);
//		waitForElement(driver, Condition_Filter_Button);
//		click(driver, Condition_Filter_Button);

		waitForElement(driver, Attribute_Filter);
		sendKeys(driver, Attribute_Filter, GlobalID);

		waitForElement(driver, global_row_Select);
		doubleClick(driver, global_row_Select);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, valueTextfield);
		clear(driver, valueTextfield);
		sendKeys(driver, valueTextfield, GlobalValue);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_End(1, "BIC plugin true and ICB Global config Y", test, test1);

		moduleNavigate(driver, CustomerMasterModule);

		waitForElement(driver, Customer_Tf);
		sendKeys(driver, Customer_Tf, CutomerValue1);

		waitForElement(driver, Cutomer_SearchBtn);
		click(driver, Cutomer_SearchBtn);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		MappedPopup=String.format(MappedPopup, CustomerValue2);
		waitForPopup(driver, popup_Message,MappedPopup);
		String Popup = getText(driver, popup_Message);
		if (MappedPopup.equals(Popup)) {
			System.out.println("Matched || Expected value was : " + MappedPopup + " || Actual value was : " + Popup);
			Extent_pass_New(driver, "Matched || Expected value was : " + MappedPopup + " || Actual value was : " + Popup,	test, test1);

		} else {
			System.out.println("NotMatched || Expected value was : " + MappedPopup + " || Actual value was : " + Popup);
			Extent_fail(driver, "NotMatched || Expected value was : " + MappedPopup + " || Actual value was : " + Popup,  test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, Customer_Tf);
		sendKeys(driver, Customer_Tf, CustomerValue2);

		waitForElement(driver, Cutomer_SearchBtn);
		click(driver, Cutomer_SearchBtn);
		waitForElement(driver, Customer_EditBtn);
		click(driver, Customer_EditBtn);
		waitForElement(driver, customer_Master_CheckBox);
		checkBox(driver, customer_Master_CheckBox, Customer_Checkbox);
		waitForElement(driver, Customer_SaveBtn);
		click(driver, Customer_SaveBtn);
		waitForPopup(driver, popup_Message,CustomerUpdate);
		String CustomerUpdated = getText(driver, popup_Message);
		if (CustomerUpdate.equals(CustomerUpdated)) {
			System.out.println(
					"Matched || Expected value was : " + CustomerUpdate + " || Actual value was : " + CustomerUpdated);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + CustomerUpdate + " || Actual value was : " + CustomerUpdated,
					test, test1);

		} else {
			System.out.println("Not Matched || Expected value was : " + CustomerUpdate + " || Actual value was : "
					+ CustomerUpdated);
			Extent_fail(driver, "Not Matched || Expected value was : " + CustomerUpdate + " || Actual value was : "
					+ CustomerUpdated, test, test1);

		}
		waitForElement(driver,popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		moduleNavigate(driver, BookingMoudleSearch);

		Step_Start(2, "Enter the Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(2, "Enter the Agreement Party", test, test1);

		Step_Start(3, "Enter the POL and POD ", test, test1);
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
		Step_End(3, "Enter the POL and POD", test, test1);
		Step_Start(4, "Select the Routing ", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		Step_Start(6, "save the booking in Draft", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		if(savepopACT.contains(savedpopEXP)) {
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
		Step_End(6, "save the booking in Draft", test, test1);
		Step_Start(7, "AutoRate the charges in Charge tab start", test, test1);
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
		Step_Start(7, "AutoRate the charges in Charge tab start", test, test1);

		Step_Start(8, "select confirm button and click Save button", test, test1);
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
					"Matched || The background color of Confirm Booking number textfield is green|| Expected color :"
							+ Confirm_bookingColor + " || Actual color :" + Confirm_colour,
					test, test1);
			System.out.println("Matched || The background color of Confirm Booking number textfield is green|| Expected color :"
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

		Step_End(8, "select confirm button and click Save button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_Start(9, "charge tab allin Y those charges reduced from OFR", test, test1);

		waitForElement(driver, Pay_Loc);
		RightClick(driver, Pay_Loc);
		waitForElement(driver, Pay_Mode);
		click1(driver, Pay_Mode);
		waitForElement(driver, Prepaid);
		safeclick(driver, Prepaid);
		
		twoColumnSearchWindow(driver, Port_Code_Header, conditionFilter, orgin);
		
		
		
		waitForElement(driver, Pay_Loc);
		String PayLocation = getText(driver, Pay_Loc);
		if (orgin.contains(PayLocation)) {
			System.out
			.println("Matched || Expected value was : " + orgin + " || Actual value was : " + PayLocation);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + orgin + " || Actual value was : " + PayLocation, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Expected value was : " + orgin + " || Actual value was : " + PayLocation);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + orgin + " || Actual value was : " + PayLocation, test,
					test1);

		}
		Step_End(9, ".charge tab allin Y those charges reduced from OFR", test, test1);

		Extent_completed(test_Case_Name, test, test1);

	}
}