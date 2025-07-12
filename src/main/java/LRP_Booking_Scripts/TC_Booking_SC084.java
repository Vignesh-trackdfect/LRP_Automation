package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;
//check whether Booking creted with same service,vessel,voyage and bound ,group call id and container number then system validate " booked for some other booking"
public class TC_Booking_SC084 extends Keywords {

	public void Booking_SC084(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC084";
		
		
		



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
		String AlreadyBooked = Excel_data.get("AlreadyBooked");
		String equipment_No = Excel_data.get("equipment_No");
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("pluginID");
		String equipment_No1 = Excel_data.get("equipment_No1");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Confirm_colour = Excel_data.get("Confirm_colour");
		String Draft_Colour = Excel_data.get("Draft_Colour");

		// Locators

		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value);
		String Already_Booked_Popup =  String.format(AlreadyBooked,equipment_No); 
		String PluginTrue =  String.format(Plugin_Configuration_Locators.PluginTrue,  pluginStatusTrue); 


		
		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");

		Extent_call(test, test1, "********** Enter Booking Module **********");

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
				moduleNavigate(driver, BookingMoudleSearch);
				

		// select the shipment type

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
		// Non-Mandatory field
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
		Step_End(4, "Select the Schedule ", test, test1);

		Step_Start(5, "save the booking in Draft", test, test1);


		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message);
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
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);


		if (draft_bookingColor.equalsIgnoreCase(Draft_Colour)) {
			Extent_pass_New(driver,
					"Matched || The background color of draft Booking number textfield is yellow|| Expected color code:"
							+ draft_bookingColor + " || Actual color code:" + Draft_Colour,
					test, test1);
			System.out.println("Matched || The background color of draft Booking number textfield is yellow|| Expected color code:"
					+ draft_bookingColor + " || Actual color code:" + Draft_Colour);
			Extent_pass_New(driver, "Booking drafted", test, test1);

		} else {
			System.out.println("Not Matched || The background color of draft Booking number textfield is not yellow|| Expected color code:"
					+ draft_bookingColor + " || Actual color code:" + Draft_Colour);
			Extent_fail(driver,
					"Not Matched || The background color of draft Booking number textfield is not yellow|| Expected color code:"
							+ draft_bookingColor + " || Actual color code:" + Draft_Colour,
					test, test1);
			
		}

		
		Step_End(5, "save the booking in Draft", test, test1);
		Step_Start(6, "AutoRate the charges in Charge tab start", test, test1);
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, Container_Tab);
		click(driver, Container_Tab);
		
		waitForElement(driver, con_editicon);
		click(driver, con_editicon);

		waitForElement(driver, con_eqp_id);
		click(driver, con_eqp_id);
		clearAndType(driver, con_eqp_id, equipment_No);

		waitForElement(driver, con_add_btn);
		safeclick(driver, con_add_btn);
		

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(6, "AutoRate the charges in Charge tab start", test, test1);

		Step_Start(7, "select confirm button and click Save button", test, test1);
		
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		
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
		click(driver,popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);


		if (Confirm_bookingColor.equalsIgnoreCase(Confirm_colour)) {
			Extent_pass_New(driver,
					"Matched || The background color of Confirm Booking number textfield Should green|| Expected color :"
							+ Confirm_bookingColor + " || Actual color :" + Confirm_colour,
					test, test1);
			System.out.println(
					"Matched || The background color of Confirm Booking number textfield Should green|| Expected color :"
							+ Confirm_bookingColor + " || Actual color :" + Confirm_colour);

		} else {
			System.out.println("Not Matched || The background color of Confirm Booking number textfield Should green|| Expected color :"
					+ Confirm_bookingColor + " || Actual color :" + Confirm_colour);
			Extent_fail(driver,
					"Not Matched || The background color of Confirm Booking number textfield Should green|| Expected color :"
							+ Confirm_bookingColor + " || Actual color :" + Confirm_colour,
					test, test1);
		}
		
		Step_End(7, "select confirm button and click Save button", test, test1);
	
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		jsClick(driver, Module_Close);
		
		moduleNavigate(driver, pluginConfigurationModule);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);


		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		click(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginTrue);
		click(driver, PluginTrue);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		
		
		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
				moduleNavigate(driver, BookingMoudleSearch);
				

		// select the shipment type

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);

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
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		String booknum1 = getAttribute(driver, booking_no, "value");
		System.out.println(booknum1);

		waitForElement(driver, toolbar_Edit_Button);
		safeclick(driver, toolbar_Edit_Button);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		
		waitForElement(driver, Container_Tab);
		click(driver, Container_Tab);

		waitForElement(driver, con_editicon);
		click(driver, con_editicon);
		
		waitForElement(driver, con_eqp_id);
		click(driver, con_eqp_id);
		clearAndType(driver, con_eqp_id, equipment_No);
		
		waitForElement(driver, con_add_btn);
		safeclick(driver, con_add_btn);
		

		waitForElement(driver, Container_Booked_Popup);
		String Container_Saved = getText(driver, Container_Booked_Popup);
		if (Already_Booked_Popup.contains(Container_Saved)) {
			System.out.println(
					"Matched || Expected value was : " + Already_Booked_Popup + " || Actual value was : " + Container_Saved);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + Already_Booked_Popup + " || Actual value was : " + Container_Saved,
					test, test1);

		} else {
			System.out.println("NotMatched || Expected value was : " + Already_Booked_Popup + " || Actual value was : "
					+ Container_Saved);
			Extent_fail(driver,
					"NotMatched || Expected value was : " + Already_Booked_Popup + " || Actual value was : " + Container_Saved,
					test, test1);
		}

		waitForElement(driver, Popup_Close);
		click(driver, Popup_Close);
		
		waitForElement(driver, con_eqp_id);
		click(driver, con_eqp_id);
		clearAndType(driver, con_eqp_id, equipment_No1);
		
		waitForElement(driver, con_add_btn);
		safeclick(driver, con_add_btn);

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Extent_completed(test_Case_Name, test, test1);
	}
}
