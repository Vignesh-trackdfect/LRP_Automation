package commonMethods;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import locators.Booking_Locators;

public class PartBL_Common_Creation extends Keywords {

	public Map<String, String> Common_PartBL(WebDriver driver, ExtentTest test, ExtentTest test1,
			Map<String, String> Excel_data) throws Exception {

		String testCaseName = "PartBL_Common_Creation";

		// Get data from excel sheet

		String Agency_Name = Excel_data.get("Agency_Name");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Package_Input = Excel_data.get("Package_Input");
		String HS_Code_Input = Excel_data.get("HS_Code_Input");
		String cargo_Weight = Excel_data.get("cargo_Weight");
		String Volume = Excel_data.get("Volume");
		String Marks_No = Excel_data.get("Marks_No");
		String select_by_commodity_code = Excel_data.get("select_by_commodity_code");
		String commodity_Desc_Input = Excel_data.get("commodity_Desc_Input");
		String CommodityQty = Excel_data.get("CommodityQty");
		String commodity_MarksNo_Input = Excel_data.get("commodity_MarksNo_Input");
		String random_no = Excel_data.get("random_no");
		String CarrieaSeal = Excel_data.get("CarrieaSeal");
		String ShipperSeal = Excel_data.get("ShipperSeal");
		String DummyContainer = Excel_data.get("DummyContainer");
		String Select_Options_MCV = Excel_data.get("Select_Options_MCV");
		String Manifest_GS_option = Excel_data.get("Manifest_GS_option");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String Remarks_MCF = Excel_data.get("Remarks_MCF");

		String TerminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String ReleaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String MCN_Module = Excel_data.get("MCN_Module");
		String eqpNo = Excel_data.get("eqpNo");
		String BookingCreation = Excel_data.get("BookingCreation");
		String MCN_Creation = Excel_data.get("MCN_Creation");
		String ManifestClosure = Excel_data.get("ManifestClosure");
		String Bill_Of_Lading_Creation = Excel_data.get("Bill_Of_Lading_Creation");
		String ManifestClosureForce_Module = Excel_data.get("ManifestClosureForce_Module");

		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String Continue_Popup = Excel_data.get("Continue_Popup");
		String MCN_Submit_Remarks_Input = Excel_data.get("MCN_Submit_Remarks_Input");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String BL_Type = Excel_data.get("BL_Type");
		String Customer_Type = Excel_data.get("Customer_Type");
		String Customer_Type_Add = Excel_data.get("Customer_Type_Add");
		String Customer_Select_Type1 = Excel_data.get("Customer_Select_Type1");
		String Customer_System_Code = Excel_data.get("Customer_System_Code");

		String Cargo_Weigt_Input = Excel_data.get("Cargo_Weigt_Input_MCN");
		String MCN_Remarks_Input = Excel_data.get("MCN_Remarks_Input");
		String MCN_Popup_Msg = Excel_data.get("MCN_Popup_Msg");
		String MCN_Approved_msg = Excel_data.get("MCN_Approved_msg");

		String Ports_Module = Excel_data.get("Ports_Module");
		String Ports_Search_Type_Select = Excel_data.get("Ports_Search_Type_Select");
		String MCN_Retrive_Type = Excel_data.get("MCN_Retrive_Type");
		String Accepted_Popup = Excel_data.get("Accepted_Popup");
		String Status_Tab_Table_Headers = Excel_data.get("Status_Tab_Table_Headers");

		Extent_Start(testCaseName, test, test1);

		String Equipment_No = eqpNo;

//	Booking module

		if (BookingCreation.equalsIgnoreCase("Yes")) {

			Extent_cal(test, test1, Booking_Module_Name);

			moduleNavigate(driver, Booking_Module_Name);

			waitForElement(driver, AgrPartyInput);
			sendKeys(driver, AgrPartyInput, arg_party);
			tab(driver);

			waitForElement(driver, OrginInput);
			sendKeys(driver, OrginInput, origin);
			tab(driver);

			waitForElement(driver, DeliveryInput);
			sendKeys(driver, DeliveryInput, delivery);
			tab(driver);

			// Rates
			waitForDisplay(driver, Draft_Button);
			waitForDisplay(driver, Rate_Grid);
			if (isdisplayed(driver, Rate_Grid)) {
				System.out.println(
						"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");
				Extent_pass(driver,
						"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed",
						test, test1);
			} else {
				waitForElement(driver, RatedBtn);
				safeclick(driver, RatedBtn);
				waitForElement(driver, $Rates);
				safeclick(driver, $Rates);
			}
			System.out.println("********** Select the Columns in Rates Grid **********");
			Extent_call(test, test1, "********** Select the Columns in Rates Grid **********");

			waitForElement(driver, rateref_toolbtn);
			safeclick(driver, rateref_toolbtn);

			waitForElement(driver, rateref_cond_filter);
			safeclick(driver, rateref_cond_filter);

			waitForElement(driver, rate_filter_inp);
			sendKeys(driver, rate_filter_inp, rate_no);
			Step_Start(3, "Select the Routing ", test, test1);
			waitForElement(driver, Rate_No_Select);
			safeclick(driver, Rate_No_Select);
			waitForElement(driver, ok_btn);
			safeclick(driver, ok_btn);

//		Routing add

			waitForElement(driver, FirstserviceInput);
			String service_Value = getAttribute(driver, FirstserviceInput, "value");
			if (service_Value.equals("")) {
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					String Popup_Text = getText(driver, popup_Message);
					if (Popup_Text.equals(No_Schedule_Popup)) {
						click(driver, popup_Message_Ok_Button);
						System.out.println("NoSchedule available, Entering data in first service input");
						editSchedule(driver, first_service_data);
					}
				} else if (isdisplayed(driver, Invalid_date_popup)) {
					waitForDisplay(driver, Invalid_date_popup);
					Extent_call(test, test1,
							"******** If There is Invalid ETA date popup showed Select the Rout Manually - Start ********");
					safeclick(driver, Invalid_date_popup_Close);
					editSchedule(driver, first_service_data);
					Extent_call(test, test1,
							"******** If There is Invalid ETA date popup showed Select the Rout Manually - End ********");
				}
			}
			waitForElement(driver, FirstserviceInput);
			service_Value = getAttribute(driver, FirstserviceInput, "value");
			if (service_Value.equals("")) {
				Step_Start(4, "Select the Schedule", test, test1);
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					String Popup_Text = getText(driver, popup_Message);
					if (Popup_Text.equals(No_Schedule_Popup)) {
						click(driver, popup_Message_Ok_Button);
						System.out.println("NoSchedule available, Entering data in first service input");
						waitForElement(driver, FirstserviceInput);
						clearAndType(driver, FirstserviceInput, first_service_data);
						click(driver, FirstserviceInput);
						keyDown(driver);
						waitForElement(driver, BKG_VoyageInput);
						sendKeys(driver, BKG_VoyageInput, Voyagenumber1);
						waitForElement(driver, BKG_Boundinpiut);
						sendKeys(driver, BKG_Boundinpiut, Boundinput);
						waitForElement(driver, routing);
						click(driver, routing);
						waitForElement(driver, routing_Select_Button);
						click(driver, routing_Select_Button);
					}
				} else if (isdisplayed(driver, Invalid_date_popup)) {
					waitForDisplay(driver, Invalid_date_popup);
					Extent_call(test, test1,
							"******** If There is Invalid ETA date popup showed Select the Rout Manually - Start ********");
					safeclick(driver, Invalid_date_popup_Close);
					waitForElement(driver, FirstserviceInput);
					clearAndType(driver, FirstserviceInput, first_service_data);
					click(driver, FirstserviceInput);
					keyDown(driver);
					waitForElement(driver, BKG_VoyageInput);
					sendKeys(driver, BKG_VoyageInput, Voyagenumber1);
					waitForElement(driver, BKG_Boundinpiut);
					sendKeys(driver, BKG_Boundinpiut, Boundinput);
					waitForElement(driver, routing);
					click(driver, routing);
					waitForElement(driver, routing_Select_Button);
					click(driver, routing_Select_Button);
					Extent_call(test, test1,
							"******** If There is Invalid ETA date popup showed Select the Rout Manually - End ********");
				} else {
					waitForElement(driver, FirstserviceInput);
					clearAndType(driver, FirstserviceInput, first_service_data);
					click(driver, FirstserviceInput);
					keyDown(driver);
					waitForElement(driver, BKG_VoyageInput);
					sendKeys(driver, BKG_VoyageInput, Voyagenumber1);
					waitForElement(driver, BKG_Boundinpiut);
					sendKeys(driver, BKG_Boundinpiut, Boundinput);
					waitForElement(driver, routing);
					click(driver, routing);
					waitForElement(driver, routing_Select_Button);
					click(driver, routing_Select_Button);
				}
			}
			waitForDisplay(driver, Error_Popup_Booking_Close_Button);
			if (isdisplayed(driver, Error_Popup_Booking_Close_Button)) {
				waitForDisplay(driver, Error_Popup_Booking_Close_Button);
				Extent_call(test, test1, "******** If There is Error popup shown Select the Rout Manually  ********");
				safeclick(driver, Error_Popup_Booking_Close_Button);

			}

//			bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

			waitForElement(driver, Draft_Button);
			click(driver, Draft_Button);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, savedpopEXP);
			String savepopACT = getText(driver, popup_Message);
			System.out.println(savepopACT);

			if (savepopACT.contains(savedpopEXP)) {
				System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP
						+ "|| Actual Popup value is  :" + savepopACT);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP
						+ "|| Actual Popup value is :" + savepopACT, test, test1);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP
						+ "|| Actual Popup value is :" + savepopACT);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP
						+ "|| Actual Popup value is:" + savepopACT, test, test1);
			}

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

//	Master tab		
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			System.out.println(" Printing the Booking number ");
			Extent_call(test, test1, " Printing the Booking number ");

			waitForElement(driver, booking_no);
			String booknum = getAttribute(driver, booking_no, "value");
			System.out.println(booknum);

//		Container tab

			waitForElement(driver, Container_Tab);
			safeclick(driver, Container_Tab);
			scrollTop(driver);
			waitForElement(driver, toolbar_Edit_Button);
			click1(driver, toolbar_Edit_Button);
			waitForElement(driver, con_editicon);
			safeclick(driver, con_editicon);

			waitForElement(driver, con_eqp_id);
			safeclick(driver, con_eqp_id);
			Actionsendkeys(driver, con_eqp_id, random_no);

			String eqp_id = getAttribute(driver, con_eqp_id, "value");
			System.out.println(eqp_id);

			waitForElement(driver, Carrier_SealTF);
			safeclick(driver, Carrier_SealTF);
			sendKeys(driver, Carrier_SealTF, CarrieaSeal);

			waitForElement(driver, Shipper_SealTF);
			safeclick(driver, Shipper_SealTF);
			sendKeys(driver, Shipper_SealTF, ShipperSeal);

			waitForElement(driver, Container_Edit_Btn);
			safeclick(driver, Container_Edit_Btn);

			String Value3 = getText(driver, Dummy_container_Popup);

			if (DummyContainer.contains(Value3)) {
				System.out.println(
						"Matched || Expected value was : " + DummyContainer + " || Actual value was : " + Value3);
				Extent_pass_New(driver,
						"Matched || Expected value was : " + DummyContainer + " || Actual value was : " + Value3, test,
						test1);
			} else {
				System.out.println(
						"NotMatched || Expected value was : " + DummyContainer + " || Actual value was : " + Value3);
				Extent_fail(driver,
						"NotMatched || Expected value was : " + DummyContainer + " || Actual value was : " + Value3,
						test, test1);

			}

			waitForElement(driver, dummy_container_yes);
			safeclick(driver, dummy_container_yes);

			if (isdisplayed(driver, popup_Message_Yes_Button)) {

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);

			}

//	Commodity tab

			waitForElement(driver, commodity_tab);
			safeclick(driver, commodity_tab);

			waitForElement(driver, Commodity_Edit);
			safeclick(driver, Commodity_Edit);

			waitForElement(driver, commodity_Package);
			safeclick(driver, commodity_Package);
			sendKeys(driver, commodity_Package, Package_Input);
			enter(driver);

			waitForElement(driver, HS_Code_Search);
			safeclick(driver, HS_Code_Search);
			globalValueSearchWindow(driver, GlobalSearchDropdownCondition, select_by_commodity_code, HS_Code_Input, "",
					"", "", "");

			waitForElement(driver, commodity_Cargo_Weight);
			safeclick(driver, commodity_Cargo_Weight);
			clearAndType(driver, commodity_Cargo_Weight, cargo_Weight);

			waitForElement(driver, commodity_Volume);
			safeclick(driver, commodity_Volume);
			clearAndType(driver, commodity_Volume, Volume);

			waitForElement(driver, commodity_MarksNo);
			safeclick(driver, commodity_MarksNo);
			sendKeys(driver, commodity_MarksNo, Marks_No);

			waitForElement(driver, commodity_MarksNo);
			click(driver, commodity_MarksNo);
			Actionsendkeys(driver, commodity_MarksNo, commodity_MarksNo_Input);

			waitForElement(driver, commodity_Desc);
			click(driver, commodity_Desc);
			Actionsendkeys(driver, commodity_Desc, commodity_Desc_Input);

			waitForElement(driver, BL_CommodityQty);
			click(driver, BL_CommodityQty);
			clearAndType(driver, BL_CommodityQty, CommodityQty);

			waitForElement(driver, commodity_Add);
			safeclick(driver, commodity_Add);

			if (isdisplayed(driver, popup_Message_Ok_Button)) {
				click(driver, popup_Message_Ok_Button);

			}

//	Charges tab

			waitForElement(driver, Charges_tab);
			mouseOverToElement(driver, Charges_tab);
			safeclick(driver, Charges_tab);

			waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);

//	Master tab		
			waitForElement(driver, master_tab);
			click(driver, master_tab);

			waitForElement(driver, Confirmed_Button);
			click(driver, Confirmed_Button);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, bookingUpdatedPopup);
			String saved_conformed_pop_act = getText(driver, popup_Message);
			System.out.println(saved_conformed_pop_act);
			// validate the saved conform popup
			System.out.println("**********Verifting the saved popup **********");
			Extent_call(test, test1, "**********Verifting the saved popup**********");
			if (saved_conformed_pop_act.contains(bookingUpdatedPopup)) {
				System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || The Actual Pop-up Value is : " + saved_conformed_pop_act);
				Extent_pass_New(driver, "Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || The Actual Pop-up Value is : " + saved_conformed_pop_act, test, test1);
			} else {
				System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || But The Actual Pop-up Value is : " + saved_conformed_pop_act);
				Extent_fail(driver, "Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || But The Actual Pop-up Value is : " + saved_conformed_pop_act, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			// validate the colour of booking number field after conform
			Extent_call(test, test1, "**********Verifting the saved booking number colour **********");
			waitForElement(driver, booking_no);
			String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
			String Confirm_bookingColor = getColorName(Confirm_bookingColorCode);
			if (Confirm_bookingColor.equalsIgnoreCase(booking_confirmed_Color)) {
				System.out.println(
						"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor + " [ Booking number input field  changed to green colour ]");
				Extent_pass_New(driver,
						"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor + " [ Booking number input field  changed to green colour ]",
						test, test1);
			} else {
				System.out.println(
						"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor
								+ " [ Booking number input field  Not changed to green colour ]");
				Extent_fail(driver,
						"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor + " [ Booking number input field  Not changed to green colour ]",
						test, test1);
			}

			// CRO

			waitForElement(driver, CRO_btn);
			click(driver, CRO_btn);

			Extent_cal(test, test1, "CRO");

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, acc_terminal);
			String acc_term_value = getAttribute(driver, acc_terminal, "value");
			System.out.println(acc_term_value);

			waitForElement(driver, rel_terminal_searchicon);
			click(driver, rel_terminal_searchicon);

			if (!ReleaseDepTerminal.equals("")) {
				twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, ReleaseDepTerminal);
			} else {
				twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, acc_term_value);
			}

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForElement(driver, Close_Current_tab);
			safeclick(driver, Close_Current_tab);

		}

		String BLNumber = "";
// Bill of Lading

		if (Bill_Of_Lading_Creation.equalsIgnoreCase("Confirm") || Bill_Of_Lading_Creation.equalsIgnoreCase("Draft")) {

			// BL MCN

			waitForElement(driver, BL_btn);
			safeclick(driver, BL_btn);
			waitForElement(driver, first_tab_inside_click);
			safeclick(driver, first_tab_inside_click);
			waitForElement(driver, Close_Current_tab);
			safeclick(driver, Close_Current_tab);

			Extent_cal(test, test1, "Bill of Lading");
			waitForElement(driver, Customer_Tab);
			safeclick(driver, Customer_Tab);
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
			List<String> options = splitAndExpand(Select_Options_MCV);
			for (String option : options) {
				formatLocatorClick(driver, Booking_Locators.select_Paste_Option, option);
			}
			action.keyUp(Keys.CONTROL).build().perform();
			waitForElement(driver, customer_Paste);
			safeclick(driver, customer_Paste);

			if (!Equipment_No.equalsIgnoreCase("Dummy")) {
				waitForElement(driver, BL_containertab);
				safeclick(driver, BL_containertab);
				waitForElement(driver, gird_edit);
				safeclick(driver, gird_edit);

				waitForElement(driver, BOL_Equipment_ID_Textfield);
				waitForElement(driver, BOL_Equipment_ID_Textfield);
				clearAndType(driver, BOL_Equipment_ID_Textfield, Equipment_No);
				waitForElement(driver, BOL_ContainerTab_Edit_Button);
				safeclick(driver, BOL_ContainerTab_Edit_Button);

				waitForDisplay(driver, popup_Message_Ok_Button);
				if (isdisplayed(driver, popup_Message_Ok_Button)) {

					safeclick(driver, popup_Message_Ok_Button);
				}
			}
			waitForElement(driver, bl_charges_Tab);
			mouseOverToElement(driver, bl_charges_Tab);
			safeclick(driver, bl_charges_Tab);
			waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);

			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {

				safeclick(driver, popup_Message_Yes_Button);
			}

			waitForElement(driver, BL_BodyTab);
			click(driver, BL_BodyTab);

			waitForElement(driver, BL_body);
			waitForElement(driver, BL_body);

			RightClick(driver, BL_body);
			waitForElement(driver, refresh_all);
			safeclick(driver, refresh_all);

			waitForDisplay(driver, popup_Message_Ok_Button);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

//	Confirm BL
			if (Bill_Of_Lading_Creation.equalsIgnoreCase("Confirm")) {
				waitForElement(driver, Edit_Button_toolBar);
				click1(driver, Edit_Button_toolBar);

				waitForElement(driver, BL_Master);
				safeclick(driver, BL_Master);
				scrollTop(driver);

				waitForElement(driver, BL_Confirmed);
				safeclick(driver, BL_Confirmed);
				scrollTop(driver);

				waitForElement(driver, SaveButton_ToolBar);
				click1(driver, SaveButton_ToolBar);

				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);
			}

			BLNumber = getAttribute(driver, bl_No_TextField_Btn, "value");

			Extent_cal(test, test1, "BLNumber : " + BLNumber);

			System.out.println("BLNumber : " + BLNumber);

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			safeclick(driver, Close_Current_tab);

		}
		Excel_data.put("BL_Number", BLNumber);

//	Maniferst closure

		if (ManifestClosure.equals("Yes")) {

			Extent_cal(test, test1, ManifestClosureForce_Module);

			moduleNavigate(driver, ManifestClosureForce_Module);

			newButton(driver);

			waitForElement(driver, MCF_By_Bl_No_radio_Button);
			click(driver, MCF_By_Bl_No_radio_Button);

			waitForElement(driver, MCF_By_Bl_No_Search_Button);
			click(driver, MCF_By_Bl_No_Search_Button);

			globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Manifest_GS_option, BLNumber, "", "", "",
					"");

			waitForElement(driver, MCF_Show_Button);
			click(driver, MCF_Show_Button);

			waitForElement(driver, MCF_Remarks_Area);
			sendKeys(driver, MCF_Remarks_Area, Remarks_MCF);

			String select_CheckBox = String.format(MCF_Select_Checkbox, BLNumber);

			waitForElement(driver, select_CheckBox);
			click(driver, select_CheckBox);

			waitForElement(driver, MCF_Force_Close_Button);
			click(driver, MCF_Force_Close_Button);

			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {

				safeclick(driver, popup_Message_Yes_Button);
			}
			waitForDisplay(driver, popup_Message_Ok_Button);
			if (isdisplayed(driver, popup_Message_Ok_Button)) {

				safeclick(driver, popup_Message_Ok_Button);
			}

			scrollTop(driver);
			
			waitForElement(driver, cancel_Common_btn);
			click(driver, cancel_Common_btn);
			
			waitForElement(driver, Close_Current_tab);
			safeclick(driver, Close_Current_tab);
		}

		if (MCN_Creation.equalsIgnoreCase("Pending") || MCN_Creation.equalsIgnoreCase("Submit")
				|| MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

			String correctionType = String.format(DropDown_Select, Corection_Type_Option);

			moduleNavigate(driver, MCN_Module);

			waitForElement(driver, Corection_Type_DropDown);
			click(driver, Corection_Type_DropDown);
			waitForElement(driver, correctionType);
			click(driver, correctionType);

			waitForElement(driver, BL_Search_Button_MCN);
			click(driver, BL_Search_Button_MCN);
			globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Select_Search_Type_MCN, BLNumber, "", "", "",
					"");
			if (isdisplayed(driver, popup_Message)) {
				waitForPopup(driver, popup_Message, Continue_Popup);
				String actual_Continue_Popup = getText(driver, popup_Message);
				if (actual_Continue_Popup.trim().equals(Continue_Popup.trim())) {
					System.out.println("Matched || Expected Pop-up Message is : " + Continue_Popup
							+ " || Actual Pop-up Message is : " + actual_Continue_Popup);
					Extent_pass_New(driver, "Matched || Expected Pop-up Message is : " + Continue_Popup
							+ " || Actual Pop-up Message is : " + actual_Continue_Popup, test, test1);
					click(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("Not Matched || Expected Pop-up Message is : " + Continue_Popup
							+ " || Actual Pop-up Message is : " + actual_Continue_Popup);
					Extent_fail(driver, "Not Matched || Expected Pop-up Message is : " + Continue_Popup
							+ " || Actual Pop-up Message is : " + actual_Continue_Popup, test, test1);
				}
			}

			scrollTop(driver);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

			waitForElement(driver, Manifest_Pending_Button);
			click(driver, Manifest_Pending_Button);

			waitForElement(driver, popup_Message_Ok_Button);
			if (isdisplayed(driver, popup_Message_Ok_Button)) {

				safeclick(driver, popup_Message_Ok_Button);
			}

			if (MCN_Creation.equalsIgnoreCase("Submit") || MCN_Creation.equalsIgnoreCase("Accept")
					|| MCN_Creation.equalsIgnoreCase("Approve")) {
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);

				waitForElement(driver, BL_Type_Input_MCN);
				click(driver, BL_Type_Input_MCN);

				formatLocatorClick(driver, DropDown_Select, BL_Type);

				waitForElement(driver, Manifest_Customer_Tab);
				click(driver, Manifest_Customer_Tab);

				List<String> datas = splitAndExpand(Customer_Type);
				for (int i = 0; i < datas.size(); i++) {

					String Customer_Selectva = String.format(Select_Customer_Row_MCN, datas.get(i));
					waitForElement(driver, Customer_Selectva);
					click(driver, Customer_Selectva);
					waitForElement(driver, Customer_Remove);
					click(driver, Customer_Remove);
				}

				List<String> data_Customer = splitAndExpand(Customer_Type_Add);
				List<String> datas1 = splitAndExpand(Customer_System_Code);

				for (int i = 0; i < data_Customer.size(); i++) {

					waitForElement(driver, Customer_Type_Dropdown);
					click(driver, Customer_Type_Dropdown);

					String Customer_Type_Select = String.format(DropDown_Select, data_Customer.get(i));
					waitForElement(driver, Customer_Type_Select);
					click(driver, Customer_Type_Select);

					if (IsElementEnabled(driver, Manifest_Customer_Search)) {
						waitForElement(driver, Manifest_Customer_Search);
						click(driver, Manifest_Customer_Search);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Customer_Select_Type1,
								datas1.get(i), "", "", "", "");
					} else {
						waitForElement(driver, Customer_Search_Input_MCN);
						Newclear(driver, Customer_Search_Input_MCN);
						sendKeys(driver, Customer_Search_Input_MCN, datas1.get(i));
						formatLocatorClick(driver, Customer_Search_Value_MCN, datas1.get(i));
					}

					waitForElement(driver, Customer_Add_Button_MCN);
					click(driver, Customer_Add_Button_MCN);
				}

				// commodity

				waitForElement(driver, Manifest_Commodity_Tab);
				click(driver, Manifest_Commodity_Tab);

				waitForElement(driver, MCN_Commodity_Table_Headers);

				String Commodity_Edit_Selectnew = String.format(Commodity_Edit_Select, eqpNo);

				waitForElement(driver, Commodity_Edit_Selectnew);
				click(driver, Commodity_Edit_Selectnew);
				if (Cargo_Weigt_Input != null && !Cargo_Weigt_Input.equals("")) {
					waitForElement(driver, Cargo_Weigt_Field);
					click(driver, Cargo_Weigt_Field);
					clear(driver, Cargo_Weigt_Field);
					sendKeys(driver, Cargo_Weigt_Field, Cargo_Weigt_Input);
				}

				waitForElement(driver, Commodity_Edit_Button);
				click(driver, Commodity_Edit_Button);

//				Charges

				waitForElement(driver, Manifest_Charges_Tab);
				click(driver, Manifest_Charges_Tab);

				waitForElement(driver, autoCharges_Button_MCN);
				click(driver, autoCharges_Button_MCN);

				waitForElement(driver, Body_Tab_MCN);
				click(driver, Body_Tab_MCN);
				waitForElement(driver, Body_Edit_Button);
				click(driver, Body_Edit_Button);

				waitForDisplay(driver, popup_Message);
				if (isDisplayed(driver, popup_Message)) {
					String act_text = getText(driver, popup_Message);
					System.out.println("Matched || the actual popup value was : " + act_text);
					Extent_pass_New(driver, "Matched || the actual popup value was : " + act_text, test, test1);
					click(driver, popup_Message_Yes_Button);
				}
				waitForElement(driver, Text_Area);
				RightClick(driver, Text_Area);
				waitForElement(driver, Refresh_All_Button);
				click(driver, Refresh_All_Button);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForElement(driver, Manifest_Submit_Button);
				click(driver, Manifest_Submit_Button);

				waitForElement(driver, Remarks_Field);
				sendKeys(driver, Remarks_Field, MCN_Submit_Remarks_Input);
				click(driver, Remarks_OK_Button);
				waitForPopup(driver, popup_Message, Submitted_Popup);
				String actual_Popup = getText(driver, popup_Message);
				if (Submitted_Popup.trim().equals(actual_Popup.trim())) {
					System.out.println("Matched || Expected Pop-up Message is : " + Submitted_Popup
							+ " || Actual Pop-up Message is : " + actual_Popup);
					Extent_pass_New(driver, "Matched || Expected Pop-up Message is : " + Submitted_Popup
							+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
					click(driver, popup_Message_Ok_Button);
				} else {
					System.out.println("Not Matched || Expected Pop-up Message is : " + Submitted_Popup
							+ " || Actual Pop-up Message is : " + actual_Popup);
					Extent_fail(driver, "Not Matched || Expected Pop-up Message is : " + Submitted_Popup
							+ " || Actual Pop-up Message is : " + actual_Popup, test, test1);
				}

				waitForElement(driver, MCN_Mail_Window_Cancel_Button);
				click(driver, MCN_Mail_Window_Cancel_Button);
			}

			waitForElement(driver, MCN_Number_Textfield_MCN_Module);
			String actual_MCN_Number = getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
			System.out.println("Generarted MCN Number : " + actual_MCN_Number);
			Extent_pass_New(driver, "Generarted MCN Number : " + actual_MCN_Number, test, test1);
			// Approve
			if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

				waitForElement(driver, status_Tab_MCN);
				click(driver, status_Tab_MCN);
				waitForElement(driver, status_Tab_TableRow_MCN);
				List<Map<String, String>> statusTable_Data = getTableData(driver, status_Tab_TableColumn_MCN,
						status_Tab_TableRow_MCN);
				List<String> statusTableHeader = splitAndExpand(Status_Tab_Table_Headers);
				List<String> entity = getValuesByHeader(statusTable_Data, statusTableHeader.get(0));
				List<String> status = getValuesByHeader(statusTable_Data, statusTableHeader.get(1));
				waitForElement(driver, Master_Tab_MCN);
				click(driver, Master_Tab_MCN);
				waitForElement(driver, POL_Value);
				String origin_Port = getText(driver, POL_Value);
				String final_Port = getText(driver, PLD_Location_MCN);
				String discharge_Port = getText(driver, pod_Port_MCN);
				String DOC_Port = getAttribute(driver, Doc_Agency, "value");
				String Issue_Agency = getAttribute(driver, BL_Issue_Agency_MCN, "value");

				actual_MCN_Number = getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
				System.out.println("Generarted MCN Number : " + actual_MCN_Number);

				waitForElement(driver, Manifest_Charges_Tab);
				click(driver, Manifest_Charges_Tab);
				waitForElement(driver, MCN_Charges_Table_Headers);
				List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Charges_Table_Headers,
						MCN_Charges_Table_Rows);
				String elseWhere_Agency = getValueByFirstColumnPartialValueAndHeader(MCN_Chareges_Tabledata,
						"Payment Mode", "PayAt", "Pay Location");
				waitForElement(driver, cancel_Button_MCN);
				click(driver, cancel_Button_MCN);
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				jsClick(driver, Close_Current_tab);
				int no_Of_Rows = entity.size();
				for (int i = 1; i < no_Of_Rows; i++) {
					switch (entity.get(i)) {
					case "ORIGIN PORT AGENCY":

						String agency = portModule(driver, origin_Port, Ports_Module, GlobalSearchDropdownCondition,
								Ports_Search_Type_Select);
						SwitchProfile(driver, agency);

						moduleNavigate(driver, MCN_Module);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, MCN_Retrive_Type,
								actual_MCN_Number, "", "", "", "");

						if (IsElementEnabled(driver, Edit_Button_toolBar)) {
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
						}

						switch (status.get(i)) {
						case "<<Awaiting For Accept>>":
							if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {
								acceptMCN(driver, Accepted_Popup);
							}
							break;
						case "<<Awaiting For Approval>>":
							if (MCN_Creation.equalsIgnoreCase("Approve")) {
								approveMCN(driver, MCN_Popup_Msg, MCN_Remarks_Input, MCN_Approved_msg);
							}
							break;
						}
						break;
					case "FINAL PORT AGENCY":

						agency = portModule(driver, final_Port, Ports_Module, GlobalSearchDropdownCondition,
								Ports_Search_Type_Select);
						SwitchProfile(driver, agency);

						moduleNavigate(driver, MCN_Module);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, MCN_Retrive_Type,
								actual_MCN_Number, "", "", "", "");

						if (IsElementEnabled(driver, Edit_Button_toolBar)) {
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
						}

						switch (status.get(i)) {
						case "<<Awaiting For Accept>>":
							if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

								acceptMCN(driver, Accepted_Popup);
							}
							break;
						case "<<Awaiting For Approval>>":
							if (MCN_Creation.equalsIgnoreCase("Approve")) {

								approveMCN(driver, MCN_Popup_Msg, MCN_Remarks_Input, MCN_Approved_msg);
							}
							break;
						}
						break;
					case "DISCHARGE PORT AGENCY":

						agency = portModule(driver, discharge_Port, Ports_Module, GlobalSearchDropdownCondition,
								Ports_Search_Type_Select);
						SwitchProfile(driver, agency);

						moduleNavigate(driver, MCN_Module);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, MCN_Retrive_Type,
								actual_MCN_Number, "", "", "", "");

						if (IsElementEnabled(driver, Edit_Button_toolBar)) {
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
						}

						switch (status.get(i)) {
						case "<<Awaiting For Accept>>":
							if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

								acceptMCN(driver, Accepted_Popup);
							}
							break;
						case "<<Awaiting For Approval>>":
							if (MCN_Creation.equalsIgnoreCase("Approve")) {

								approveMCN(driver, MCN_Popup_Msg, MCN_Remarks_Input, MCN_Approved_msg);
							}
							break;
						}
						break;
					case "DOCUMENTATION AGENCY":

						SwitchProfile(driver, DOC_Port);
						moduleNavigate(driver, MCN_Module);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, MCN_Retrive_Type,
								actual_MCN_Number, "", "", "", "");

						if (IsElementEnabled(driver, Edit_Button_toolBar)) {
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
						}

						switch (status.get(i)) {
						case "<<Awaiting For Accept>>":
							if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

								acceptMCN(driver, Accepted_Popup);
							}
							break;
						case "<<Awaiting For Approval>>":
							if (MCN_Creation.equalsIgnoreCase("Approve")) {

								approveMCN(driver, MCN_Popup_Msg, MCN_Remarks_Input, MCN_Approved_msg);
							}
							break;
						}
						break;
					case "BL ISSUE AGENCY":

						SwitchProfile(driver, Issue_Agency);
						moduleNavigate(driver, MCN_Module);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, MCN_Retrive_Type,
								actual_MCN_Number, "", "", "", "");
						if (IsElementEnabled(driver, Edit_Button_toolBar)) {
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
						}

						switch (status.get(i)) {
						case "<<Awaiting For Accept>>":
							if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

								acceptMCN(driver, Accepted_Popup);
							}
							break;
						case "<<Awaiting For Approval>>":
							if (MCN_Creation.equalsIgnoreCase("Approve")) {

								approveMCN(driver, MCN_Popup_Msg, MCN_Remarks_Input, MCN_Approved_msg);
							}
							break;
						}
						break;

					case "ELSE WHERE AGENCY":

						agency = portModule(driver, elseWhere_Agency, Ports_Module, GlobalSearchDropdownCondition,
								Ports_Search_Type_Select);
						SwitchProfile(driver, agency);

						moduleNavigate(driver, MCN_Module);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, MCN_Retrive_Type,
								actual_MCN_Number, "", "", "", "");
						if (IsElementEnabled(driver, Edit_Button_toolBar)) {
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
						}
						switch (status.get(i)) {
						case "<<Awaiting For Accept>>":
							if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

								acceptMCN(driver, Accepted_Popup);
							}
							break;
						case "<<Awaiting For Approval>>":
							if (MCN_Creation.equalsIgnoreCase("Approve")) {

								approveMCN(driver, MCN_Popup_Msg, MCN_Remarks_Input, MCN_Approved_msg);
							}
							break;
						}
						break;
					case "LINE COMMERCIAL":
						ResetProfile(driver);
						moduleNavigate(driver, MCN_Module);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow(driver, GlobalSearchDropdownCondition, MCN_Retrive_Type,
								actual_MCN_Number, "", "", "", "");

						if (IsElementEnabled(driver, Edit_Button_toolBar)) {
							waitForElement(driver, Edit_Button_toolBar);
							click(driver, Edit_Button_toolBar);
						}

						switch (status.get(i)) {
						case "<<Awaiting For Accept>>":
							if (MCN_Creation.equalsIgnoreCase("Accept") || MCN_Creation.equalsIgnoreCase("Approve")) {

								acceptMCN(driver, Accepted_Popup);
							}
							break;
						case "<<Awaiting For Approval>>":
							if (MCN_Creation.equalsIgnoreCase("Approve")) {

								approveMCN(driver, MCN_Popup_Msg, MCN_Remarks_Input, MCN_Approved_msg);
							}
							break;
						}
						break;
					}
				}
				SwitchProfile(driver, Agency_Name);
			}
			Excel_data.put("MCN_Number", actual_MCN_Number);

		}
		Extent_completed(testCaseName, test, test1);

		return Excel_data;

	}

}
