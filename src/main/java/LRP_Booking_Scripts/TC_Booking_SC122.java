package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

import locators.Booking_Locators;

public class TC_Booking_SC122 extends Keywords {

	public void Booking_SC122(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String tc_Name = "TC_Booking_SC122";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String BL_saved_msg = Excel_data.get("BL_saved_msg");
		String shipper_seal = Excel_data.get("shipper_seal");
		String carrier_seal = Excel_data.get("carrier_seal");
		String Select_Options = Excel_data.get("Select_Options");
		String equipment_Id = Excel_data.get("equipment_Id");
		String Package_Input = Excel_data.get("Package_Input");
		String HS_Code_Input = Excel_data.get("HS_Code_Input");
		String cargo_Weight = Excel_data.get("cargo_Weight");
		String Volume = Excel_data.get("Volume");
		String Marks_No = Excel_data.get("Marks_No");
		String BL_Updated_msg = Excel_data.get("BL_Updated_msg");
		String dummy_value = Excel_data.get("dummy_value");
		String BL_available_msg = Excel_data.get("BL_available_msg");
		String condition = Excel_data.get("condition");
		String select_by_book_number = Excel_data.get("select_by_book_number");
		String dd1_condition = Excel_data.get("dd1_condition");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Terminal_Code_Column_Header = Excel_data.get("Terminal_Code_Column_Header");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String Commodity_Select_Type = Excel_data.get("Commodity_Select_Type");
		String BOL_Commodity_Desc_Field = Excel_data.get("BOL_Commodity_Desc_Field");

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Extent_call(test, test1, "**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1, "** Enter Booking Module **");

		moduleNavigate(driver, search_module);
		Step_Start(1, "Enter the Agr Party Input", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(1, "Enter the Agr Party Input", test, test1);

		Step_Start(2, "Enter the Orgin and delivery", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		keyDown(driver);
		enter(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the Orgin and delivery", test, test1);

		Step_Start(3, "Enter the Rates", test, test1);

		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		Step_End(5, "Enter the schedule details", test, test1);

		Step_Start(6, "Save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

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

		Step_End(6, "Save the booking in Draft", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(7, "Save the booking in Confirmed", test, test1);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String submit_bookingColor1 = getTextBackgroundColor(driver, booking_no);
		String submit_bookingColor = getColorName(submit_bookingColor1);
		if (submit_bookingColor.equals(submit_bookingColor)) {
			System.out.println(
					"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor
							+ " [ Booking number input field  changed to green colour ]");
			Extent_pass_New(driver,
					"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor
							+ " [ Booking number input field  changed to green colour ]",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor
							+ " [ Booking number input field  Not changed to green colour ]");
			Extent_fail(driver,
					"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor
							+ " [ Booking number input field  Not changed to green colour ]",
					test, test1);
		}

		Step_End(7, "Save the booking in Confirmed", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		Step_Start(8, "Create CRO", test, test1);

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value = getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		waitForElement(driver, terminal_searchfield);
		twoColumnSearchWindow(driver, Terminal_Code_Column_Header, condition, acc_term_value);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, "", "", "", "");
		Step_End(8, "Create CRO", test, test1);

		Step_Start(9, "Create BL", test, test1);
//		waitForElement(driver, Close_Current_tab);
//		safeclick(driver, Close_Current_tab);
		waitForElement(driver, BL_btn);
		safeclick(driver, BL_btn);

		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);
		waitForElement(driver, customer_Grid);
		safeclick(driver, customer_Grid);
		waitForElement(driver, customer_Grid);
		RightClick(driver, customer_Grid);
		waitForElement(driver, customer_Grid_Copy);
		safeclick(driver, customer_Grid_Copy);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		List<String> options = splitAndExpand(Select_Options);
		for (String option : options) {
			String select_Paste = String.format(Booking_Locators.select_Paste, option);
			waitForElement(driver, select_Paste);
			click(driver, select_Paste);
		}
		action.keyUp(Keys.CONTROL).build().perform();
		waitForElement(driver, customer_Paste);
		safeclick(driver, customer_Paste);

		waitForElement(driver, BL_containertab);
		safeclick(driver, BL_containertab);
		waitForElement(driver, smart_Import);
		safeclick(driver, smart_Import);

		waitForElement(driver, act_Equip_Id);
		doubleClick(driver, act_Equip_Id);
		waitForElement(driver, act_Equip_Id);
		Actionsendkeys(driver, act_Equip_Id, equipment_Id);

		waitForElement(driver, career_Seal);
		doubleClick(driver, career_Seal);
		waitForElement(driver, career_Seal);
		Actionsendkeys(driver, career_Seal, carrier_seal);

		waitForElement(driver, BL_Shipper_Seal);
		doubleClick(driver, BL_Shipper_Seal);
		Actionsendkeys(driver, BL_Shipper_Seal, shipper_seal);
		tab(driver);

		waitForElement(driver, import_Paste);
		safeclick(driver, import_Paste);

		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Ok_Button);
		}

		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);
		waitForElement(driver, bl_package_txtfld);
		safeclick(driver, bl_package_txtfld);
		sendKeys(driver, bl_package_txtfld, Package_Input);
		enter(driver);
		waitForElement(driver, hs_search);
		safeclick(driver, hs_search);
		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Commodity_Select_Type, HS_Code_Input, "", "", "",
				"");
		waitForElement(driver, MCN_CargoWeight);
		safeclick(driver, MCN_CargoWeight);
		clearAndType(driver, MCN_CargoWeight, cargo_Weight);
		waitForElement(driver, billoflading_volume);
		safeclick(driver, billoflading_volume);
		clearAndType(driver, billoflading_volume, Volume);
		waitForElement(driver, mark_number);
		safeclick(driver, mark_number);
		sendKeys(driver, mark_number, Marks_No);
		waitForElement(driver, BOL_Commodity_Desc_TextField);
		safeclick(driver, BOL_Commodity_Desc_TextField);
		sendKeys(driver, BOL_Commodity_Desc_TextField, BOL_Commodity_Desc_Field);
		waitForElement(driver, bl_commodity_add_button);
		safeclick(driver, bl_commodity_add_button);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		waitForElement(driver, Charges_First);
		safeclick(driver, Charges_First);
		action.keyDown(Keys.SHIFT).build().perform();
		waitForElement(driver, charges_Last);
		safeclick(driver, charges_Last);
		action.keyUp(Keys.SHIFT).build().perform();
		waitForElement(driver, Charges_First);
		mouseOverToElement(driver, Charges_First);
		RightClick(driver, Charges_First);
		waitForElement(driver, payBy_Charges);
		mouseOverToElement(driver, payBy_Charges);
		waitForElement(driver, payBy_Agreement_Party);
		safeclick(driver, payBy_Agreement_Party);
		waitForDisplay(driver, OFR_Popup);
		if (isDisplayed(driver, OFR_Popup)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}

		waitForElement(driver, body_Tab_BL);
		safeclick(driver, body_Tab_BL);
		waitForElement(driver, BL_body);
		RightClick(driver, BL_body);
		waitForElement(driver, refresh_all);
		safeclick(driver, refresh_all);
		waitForElement(driver, BL_Master);
		safeclick(driver, BL_Master);
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		String saved_popup = getText(driver, popup_Message);
		if (saved_popup.contains(BL_saved_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			Extent_pass_New(driver, "Matched ||Excepted popup should be shown:" + BL_saved_msg
					+ " Actual popup  been shown:" + saved_popup, test, test1);
			System.out.println("Matched ||Excepted popup should be shown:" + BL_saved_msg + " Actual popup  been shown:"
					+ saved_popup);
		} else {
			System.out.println("Not matched ||Excepted popup should be shown:" + BL_saved_msg
					+ " Actual popup  been shown:" + saved_popup);

			Extent_fail(driver, "Not matched ||Excepted popup should be shown:" + BL_saved_msg
					+ " Actual popup  been shown:" + saved_popup, test, test1);
		}
		waitForElement(driver, BL_no);
		String draftBL_bookingColor1 = getTextBackgroundColor(driver, BL_no);
		String draftBL_bookingColor = getColorName(draftBL_bookingColor1);
		if (draftBL_bookingColor.equals(booking_draft_Color)) {
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

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, BL_Confirmed);
		safeclick(driver, BL_Confirmed);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, BL_Updated_msg);
		String updated_popup = getText(driver, popup_Message);
		if (updated_popup.contains(BL_Updated_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			Extent_pass_New(driver, "Matched ||Excepted popup should be shown:" + BL_Updated_msg
					+ " Actual popup  be shown:" + updated_popup, test, test1);
			System.out.println("Matched ||Excepted popup should be shown:" + BL_Updated_msg + " Actual popup  be shown:"
					+ updated_popup);
		} else {
			System.out.println("Not matched ||Excepted popup should be shown:" + BL_Updated_msg
					+ " Actual popup  be shown:" + updated_popup);

			Extent_fail(driver, "Not matched ||Excepted popup should be shown:" + BL_Updated_msg
					+ " Actual popup  be shown:" + updated_popup, test, test1);
		}
		waitForElement(driver, BL_no);
		String confirmBL_bookingColor1 = getTextBackgroundColor(driver, BL_no);
		String confirmBL_bookingColor = getColorName(confirmBL_bookingColor1);
		if (confirmBL_bookingColor.equals(booking_confirmed_Color)) {
			System.out.println(
					"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + confirmBL_bookingColor
							+ " [ Booking number input field  changed to green colour ]");
			Extent_pass_New(driver,
					"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + confirmBL_bookingColor
							+ " [ Booking number input field  changed to green colour ]",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + confirmBL_bookingColor
							+ " [ Booking number input field  Not changed to green colour ]");
			Extent_fail(driver,
					"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
							+ booking_confirmed_Color + " || The Actual Report Activity is : " + confirmBL_bookingColor
							+ " [ Booking number input field  Not changed to green colour ]",
					test, test1);
		}

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		// Instead of clicking the first module dropdown , this method select the module
		// name by using excel test data
		moduleNavigate(driver, search_module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, "", "", "", "");

		waitForPopup(driver, popup_Message, BL_available_msg);
		String delete_popup = getText(driver, popup_Message);
		if (delete_popup.contains(BL_available_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			Extent_pass_New(driver, "Matched ||Excepted popup should be shown:" + BL_available_msg
					+ " Actual popup  be shown:" + delete_popup, test, test1);
			System.out.println("Matched ||Excepted popup should be shown:" + BL_available_msg
					+ " Actual popup  be shown:" + delete_popup);
		} else {
			System.out.println("Not matched ||Excepted popup should be shown:" + BL_available_msg
					+ " Actual popup  be shown:" + delete_popup);

			Extent_fail(driver, "Not matched ||Excepted popup should be shown:" + BL_available_msg
					+ " Actual popup  be shown:" + delete_popup, test, test1);
		}

		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);

		scrollBottom(driver);

		waitForElement(driver, con_grid_equipid);
		String updated_con_equipid = getText(driver, con_grid_equipid);
		if (updated_con_equipid.equals(equipment_Id)) {
			System.out.println("Matched || " + " Expected  equipmenet isd shown : " + equipment_Id
					+ " || Actual equipmenet isd shown : " + updated_con_equipid);
			Extent_pass_New(driver, "Matched || " + " Expected  equipmenet isd shown: " + equipment_Id
					+ " || Actual equipmenet isd shown : " + updated_con_equipid, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected equipmenet isd shown: " + equipment_Id
					+ " || Actual  equipmenet isd shown: " + updated_con_equipid);
			Extent_fail(driver, "Not Matched || " + " Expected  equipmenet isd shown: " + equipment_Id
					+ " || Actual equipmenet isd shown : " + updated_con_equipid, test, test1);
		}
		waitForElement(driver, con_grid_dummy);
		String con_dummy_value = getText(driver, con_grid_dummy);
		if (con_dummy_value.equals(dummy_value)) {
			System.out.println("Matched || " + " Expected  dummy value shown: " + dummy_value
					+ " || Actual dummy value shown : " + con_dummy_value);
			Extent_pass_New(driver, "Matched || " + " Expected  dummy value shown: " + dummy_value
					+ " || Actual dummy value shown : " + con_dummy_value, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected dummy value shown: " + dummy_value
					+ " || Actual  dummy value shown: " + con_dummy_value);
			Extent_fail(driver, "Not Matched || " + " Expected  dummy value shown: " + dummy_value
					+ " || Actual dummy value shown : " + con_dummy_value, test, test1);

		}
		Extent_completed(tc_Name, test, test1);
	}

}
