package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;

//Check whetherin Booking,BOP Plugin true and ARL configuration Y System not allow to do edit the booking leg if load confirmed and transhipment load plan done
public class TC_Booking_SC066 extends Keywords {

	public void Booking_SC066(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String test_Case_Name = "TC_Booking_SC066";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String first_service_data = Excel_data.get("first_service_data");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber = Excel_data.get("Voyagenumber");
		String rate_no = Excel_data.get("rate_no");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String PluginDescription = Excel_data.get("PluginDescription");
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("pluginID");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String loadConfirmedPopup = Excel_data.get("loadConfirmedPopup");
		String actualContainerNo = Excel_data.get("actualContainerNo");
		String activityDatePopup = Excel_data.get("activityDatePopup");
		String loadConfirmationModule = Excel_data.get("loadConfirmationModule");
		String pluginID1 = Excel_data.get("pluginID1");
		String AgencyConfiguration = Excel_data.get("AgencyConfiguration");
		String description = Excel_data.get("AgencyDescription");
		String value = Excel_data.get("value");
		String GlobalValue = Excel_data.get("GlobalValue");
		String Edit_Status = Excel_data.get("Edit_Status");
		String DefaultValue = Excel_data.get("DefaultValue");
		String date_Picker = Excel_data.get("date_Picker");
		String CurrentDate = Excel_data.get("CurrentDate");
		String conditionFilter = Excel_data.get("ConditionFilter");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String GlobalSearchFilterOption = Excel_data.get("GlobalSearchFilterOption");
		String booking_confirmed_Color = Excel_data.get("Confirm_colour");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String booking_draft_Color = Excel_data.get("Draft_Colour");
		String terminalDetails_Filter = Excel_data.get("terminalDetails_Filter");
		String Agency_Code_Header = Excel_data.get("Agency_Code_Header");
		String Customer_Name_Input = Excel_data.get("Customer_Name_Input");
		String Customer_Name_Search = Excel_data.get("Customer_Name_Search");
		String Booking_Date_Input = Excel_data.get("Booking_Date_Input");
		String Booking_Date_Search = Excel_data.get("Booking_Date_Search");

		String Priority = String.format(Booking_Locators.Priority, Priority_Value);
		String TOS = String.format(Booking_Locators.TOS, TOS_Value);
		String Code_Val = String.format(Booking_Locators.Code_Val, Operator_Code_value);
		String PluginTrue = String.format(Plugin_Configuration_Locators.PluginTrue, pluginStatusTrue);
		String description_Select = String.format(Plugin_Configuration_Locators.description_Select, description);

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
		if (Operator_Code_value.equalsIgnoreCase("YES")) {
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
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber, Boundinput);
		Step_Start(5, "save the booking in Draft ", test, test1);
		waitForElement(driver, FirstserviceInput);
		String service_Value = getAttribute(driver, FirstserviceInput, "value");
		String vessle_Value = getText(driver, vessleValue);
		String voyage_Value = getText(driver, voyageValue);
		String Bound_Value = getText(driver, BKG_Bound_Value);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// Verification of saved popup of draft
		waitForPopup(driver, popup_Message, savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		Extent_cal(test, test1, "**********Verifting the saved popup**********");
		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP
					+ " || The Actual Pop-up Value is : " + savepopACT);
			Extent_pass_New(driver, "Matched || The Expected Pop-up Value is : " + savedpopEXP
					+ " || The Actual Pop-up Value is : " + savepopACT, test, test1);
		} else {
			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP
					+ " || But The Actual Pop-up Value is : " + savepopACT);
			Extent_fail(driver, "Not Matched || The Expected Pop-up Value is : " + savedpopEXP
					+ " || But The Actual Pop-up Value is : " + savepopACT, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println("Book number generated is: " + booknum);
		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor = getColorName(draft_bookingColorCode);
		if (draft_bookingColor.equals(booking_draft_Color)) {
			System.out.println(
					"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
							+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
							+ " [Booking number input field is changed to yellow colour] ");
			Extent_pass_New(driver,
					"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
							+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
							+ " [Booking number input field is changed to yellow colour] ",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
							+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
							+ " [Booking number input field is Not changed to yellow colour] ");
			Extent_fail(driver,
					"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
							+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
							+ " [Booking number input field is Not changed to yellow colour] ",
					test, test1);
		}
		Step_End(5, "save the booking in Draft ", test, test1);
		Step_Start(6, "select confirm button and safeclick Save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		waitForElement(driver, Charges_tab);
		click1(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click1(driver, AutoRated);
		waitForElement(driver, master_tab);
		click1(driver, master_tab);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message, bookingUpdatedPopup);
		String UpdatedpopACT = getText(driver, popup_Message);
		System.out.println(UpdatedpopACT);
		if (UpdatedpopACT.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
					+ " || The Actual Pop-up Value is : " + UpdatedpopACT);
			Extent_pass_New(driver, "Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
					+ " || The Actual Pop-up Value is : " + UpdatedpopACT, test, test1);
		} else {
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
					+ " || But The Actual Pop-up Value is : " + UpdatedpopACT);
			Extent_fail(driver, "Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
					+ " || But The Actual Pop-up Value is : " + UpdatedpopACT, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor = getColorName(Confirm_bookingColorCode);
		if (Confirm_bookingColor.equalsIgnoreCase(booking_confirmed_Color)) {
			System.out.println(
					"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor
							+ " [ Booking number input field  changed to green colour ]");
			Extent_pass_New(driver,
					"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor
							+ " [ Booking number input field  changed to green colour ]",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor
							+ " [ Booking number input field  Not changed to green colour ]");
			Extent_fail(driver,
					"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor
							+ " [ Booking number input field  Not changed to green colour ]",
					test, test1);
		}
		Step_End(7, "select confirm button and safeclick Save button ", test, test1);

		Step_Start(8, "Release CRO", test, test1);
		waitForElement(driver, CRO_btn);
		safeclick(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value = getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		twoColumnSearchWindow(driver, terminalDetails_Filter, conditionFilter, acc_term_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, GlobalSearchFilterOption, booknum,
				Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

		Step_End(8, "Release CRO", test, test1);

		waitForElement(driver, Module_Close);
		safeclick(driver, Module_Close);
		Step_Start(9, "APB,BOP configuration set as True in Plugin configuration ", test, test1);

		moduleNavigate(driver, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

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
		waitForElement(driver, Userinfo_checkbox);
		safeclick(driver, Userinfo_checkbox);
		waitForElement(driver, Plugin_description);
		sendKeys(driver, Plugin_description, PluginDescription);
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
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID1);

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
		Step_End(9, "APB,BOP configuration set as True in Plugin configuration ", test, test1);

		waitForElement(driver, Module_Close);
		safeclick(driver, Module_Close);

		Step_Start(10, "ARL configuration set as Y in global configuration", test, test1);

		moduleNavigate(driver, GlobalConfigurationModule);
		if (isdisplayed(driver, Filter_Menu)) {
			waitForElement(driver, Filter_Menu);
			safeclick(driver, Filter_Menu);
			waitForElement(driver, Condition_Filter_Button);
			safeclick(driver, Condition_Filter_Button);

		}
		

		waitForElement(driver, Attribute_Filter);
		sendKeys(driver, Attribute_Filter, GlobalID);

		formatLocatorDoubleClick(driver, Attribute_Select, GlobalID);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, valueTextfield);
		clear(driver, valueTextfield);
		sendKeys(driver, valueTextfield, GlobalValue);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Step_End(10, "ARL configuration set as Y in global configuration", test, test1);

		Step_Start(11, "set 'Booking – CRO should not be Mandatory\" as N in Agency Configuration", test, test1);
		Extent_call(test, test1, "Agency Configuration");

		moduleNavigate(driver, AgencyConfiguration);

		newButton(driver);

		waitForElement(driver, agencySearch_Button);
		click(driver, agencySearch_Button);

		twoColumnSearchWindow(driver, Agency_Code_Header, conditionFilter, AgencyUser);

		waitForElement(driver, AC_Show_Button);
		click(driver, AC_Show_Button);

		waitForElement(driver, AC_description_Grid_Filter);
		click(driver, AC_description_Grid_Filter);
		sendKeys(driver, AC_description_Grid_Filter, description);

		waitForElement(driver, description_Select);
		click(driver, description_Select);

		waitForElement(driver, AC_value_Textfield);
		click(driver, AC_value_Textfield);
		clearAndType(driver, AC_value_Textfield, value);

		waitForElement(driver, plus_Button_ACG);
		click(driver, plus_Button_ACG);

		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			String actualPopup = getText(driver, popup_Message);
			Extent_pass_New(driver, actualPopup + " popup is displayed", test, test1);
			System.out.println(actualPopup + " popup is displayed");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(11, "set 'Booking – CRO should not be Mandatory\" as N in Agency Configuration", test, test1);

		Step_Start(12, "Load confirm done ", test, test1);

		moduleNavigate(driver, loadConfirmationModule);

		waitForElement(driver, service_Searchfield);
		sendKeys(driver, service_Searchfield, service_Value);

		waitForElement(driver, L_vessel_Input);
		sendKeys(driver, L_vessel_Input, vessle_Value);

		waitForElement(driver, L_VoyageInput);
		sendKeys(driver, L_VoyageInput, voyage_Value);

		waitForElement(driver, L_Boundinpiut);
		sendKeys(driver, L_Boundinpiut, Bound_Value);

		waitForElement(driver, LC_select_Service);
		click(driver, LC_select_Service);
		waitForElement(driver, routing_Select_Button);
		click(driver, routing_Select_Button);
		waitForElement(driver, LC_show_Button);
		click(driver, LC_show_Button);

		waitForElement(driver, LC_bookingNo_filter);
		click(driver, LC_bookingNo_filter);
		waitForElement(driver, LC_bookingNo_filter);
		Actionsendkeys(driver, LC_bookingNo_filter, booknum);

		waitForElement(driver, LC_gridBookingNo);
		String retrivedBookNo = getText(driver, LC_gridBookingNo);
		System.out.println(retrivedBookNo);
		if (retrivedBookNo.equals(booknum)) {
			Extent_pass_New(driver,
					"Matched || Expected Booking Number : " + booknum + " || Actual Booking Number : " + retrivedBookNo,
					test, test1);
			System.out.println("Matched || Expected Booking Number : " + booknum + " || Actual Booking Number : "
					+ retrivedBookNo);
			Extent_pass_New(driver, booknum + " is retrieved", test, test1);
			System.out.println(booknum + " is retrieved");

			waitForElement(driver, LC_actualContainerNo_Editable);
			doubleClick(driver, LC_actualContainerNo_Editable);
			waitForElement(driver, LC_actualContainerNo_Inputfield);
			click(driver, LC_actualContainerNo_Inputfield);
			sendKeys(driver, LC_actualContainerNo_Inputfield, actualContainerNo);
			waitForElement(driver, select_All_Load);
			click(driver, select_All_Load);
			waitForDisplay(driver, popup_Message);
			if (isDisplayed(driver, popup_Message)) {
				String actualActivityDatePopup = getText(driver, popup_Message);
				if (actualActivityDatePopup.contains(activityDatePopup)) {
					click(driver, popup_Message_Ok_Button);

					if (date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activityDate_LoadConfirm, CurrentDate);
					} else {
						waitForElement(driver, activityDate_LoadConfirm);
						clearAndType(driver, activityDate_LoadConfirm, CurrentDate);
					}
					waitForElement(driver, select_All_Load);
					click(driver, select_All_Load);
					waitForElement(driver, LC_loadConfirmation_Button);
					click(driver, LC_loadConfirmation_Button);

				}

			}

		} else {
			System.out.println("Not Matched || Expected Booking Number : " + booknum + " || Actual Booking Number : "
					+ retrivedBookNo);
			Extent_fail(driver, "Not Matched || Expected Booking Number : " + booknum + " || Actual Booking Number : "
					+ retrivedBookNo, test, test1);
		}

		waitForPopup(driver, popup_Message, loadConfirmedPopup);
		String actualConfirmed_Popup = getText(driver, popup_Message);
		if (actualConfirmed_Popup.contains(loadConfirmedPopup)) {
			Extent_pass_New(driver, "Matched || Expected  Pop-up value is  : " + loadConfirmedPopup
					+ " || Actual  Pop-up value is  : " + actualConfirmed_Popup, test, test1);
			System.out.println("Matched || Expected  Pop-up value is  : " + loadConfirmedPopup
					+ " || Actual  Pop-up value is  : " + actualConfirmed_Popup);
			Extent_pass_New(driver, loadConfirmedPopup + " popup is displayed", test, test1);
			System.out.println(loadConfirmedPopup + " popup is displayed");

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected  Pop-up value is  : " + loadConfirmedPopup
					+ " || Actual  Pop-up value is  : " + actualConfirmed_Popup);
			Extent_fail(driver, "Not Matched || Expected  Pop-up value is  : " + loadConfirmedPopup
					+ " || Actual  Pop-up value is  : " + actualConfirmed_Popup, test, test1);
		}

		waitForElement(driver, Module_Close);
		safeclick(driver, Module_Close);
		Step_End(12, "Load confirm done ", test, test1);

		moduleNavigate(driver, BookingMoudleSearch);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, GlobalSearchFilterOption, booknum,
				Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

		Step_Start(13, "System not allow to edit the booking", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, Leg_tab);
		safeclick(driver, Leg_tab);
		waitForElement(driver, Leg_grid_Editbtn);
		String leg_Grid_Edit_Status = getAttribute(driver, Leg_grid_Editbtn, "class");
		if (leg_Grid_Edit_Status.contains(Edit_Status)) {
			System.out.println(
					"Expected Result is : Grid button in Leg Tab Should not clickable || Actual Result is : Grid button in Leg Tab is not clickable");
			Extent_pass_New(driver,
					"Expected Result is : Grid button in Leg Tab Should not clickable || Actual Result is : Grid button in Leg Tab is not clickable",
					test, test1);
		} else {
			System.out.println(
					"Expected Result is : Grid button in Leg Tab Should not clickable || Actual Result is : Grid button in Leg Tab is clickable");
			Extent_fail(driver,
					"Expected Result is : Grid button in Leg Tab Should not clickable || Actual Result is : Grid button in Leg Tab is clickable",
					test, test1);
		}

		Step_End(13, "System not allow to edit the booking", test, test1);

		moduleNavigate(driver, AgencyConfiguration);
		newButton(driver);

		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			String agcPopup = getText(driver, popup_Message);
			Extent_pass_New(driver, agcPopup + " popup is displayed", test, test1);
			System.out.println(agcPopup + " popup is displayed");
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}

		waitForElement(driver, agencySearch_Button);
		click(driver, agencySearch_Button);

		twoColumnSearchWindow(driver, Agency_Code_Header, conditionFilter, AgencyUser);

		waitForElement(driver, AC_Show_Button);
		click(driver, AC_Show_Button);

		waitForElement(driver, AC_description_Grid_Filter);
		click(driver, AC_description_Grid_Filter);
		sendKeys(driver, AC_description_Grid_Filter, description);

		waitForElement(driver, description_Select);
		click(driver, description_Select);

		waitForElement(driver, AC_value_Textfield);
		click(driver, AC_value_Textfield);
		clearAndType(driver, AC_value_Textfield, DefaultValue);

		waitForElement(driver, plus_Button_ACG);
		click(driver, plus_Button_ACG);

		waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			String actualPopup = getText(driver, popup_Message);
			Extent_pass_New(driver, actualPopup + " popup is displayed", test, test1);
			System.out.println(actualPopup + " popup is displayed");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Extent_completed(test_Case_Name, test, test1);
	}
}
