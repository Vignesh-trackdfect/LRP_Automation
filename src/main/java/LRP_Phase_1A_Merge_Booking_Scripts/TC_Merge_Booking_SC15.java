package LRP_Phase_1A_Merge_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Merge_Booking_SC15 extends Keywords {

	public void Merge_Booking_SC15(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_Merge_Booking_SC15";

//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Shipment_Type = Excel_data.get("Shipment_Type");
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
		String Merge_Booking_Module_Name = Excel_data.get("Merge_Booking_Module_Name");
		String Vessel_code_Header = Excel_data.get("Vessel_code_Header");
		String Condition = Excel_data.get("Condition");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Origin_Header = Excel_data.get("Origin_Header");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String PLD_Header = Excel_data.get("PLD_Header");
		String MB_Agr_Party_Value = Excel_data.get("MB_Agr_Party_Value");
		String MB_Booking_Status_Select = Excel_data.get("MB_Booking_Status_Select");
		String Container_rows = Excel_data.get("Container_rows");
		String Merge_Booking_Error_msg = Excel_data.get("Merge_Booking_Error_msg");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);


		Step_Start(1, " Create a only one booking with multiple containers", test, test1);

		SwitchProfile(driver, agencyUser);
		moduleNavigate(driver, Booking_Module_Name);

//		Booking module
		Extent_cal(test, test1, Booking_Module_Name);

		if (!Shipment_Type.equals("")) {

			waitForElement(driver, shiptype_field);
			click(driver, shiptype_field);
			formatLocatorClick(driver, DropDown_Select, Shipment_Type);

		}

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
		bookingRatesSelect_Updated(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is  :"
					+ savepopACT);
			Extent_pass_New(driver,
					"Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is :" + savepopACT,
					test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP + "|| Actual Popup value is :"
					+ savepopACT);
			Extent_fail(driver,
					"Not Matched || Expected Pop-up value is:" + savedpopEXP + "|| Actual Popup value is:" + savepopACT,
					test, test1);
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

		waitForElement(driver, container_tab);
		click(driver, container_tab);

		// to update
		List<WebElement> initial_Columns = listOfElements(driver, Container_columns);
		int count_Before_Copy = initial_Columns.size();

		System.out.println("count of rows before copy is: " + count_Before_Copy);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Container_Grid_editBt);
		RightClick(driver, Container_Grid_editBt);
		waitForElement(driver, Container_copy);
		click(driver, Container_copy);

		waitForElement(driver, Copy_Rows_Value);
		sendKeys(driver, Copy_Rows_Value, Container_rows);
		int CopuNum = Integer.parseInt(Container_rows);

		waitForElement(driver, Copy_OkBtn);
		click(driver, Copy_OkBtn);

		System.out.println("the passing value: " + CopuNum);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

//		Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

//		Charges tab

		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

//		Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

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

		waitForElement(driver, booking_no);
		String Conrfirmed_booknum = getAttribute(driver, booking_no, "value");
		System.out.println("Confirmed booking number  is : " + Conrfirmed_booknum);

		Step_End(1, "Create a only one booking with multiple containers", test, test1);

		waitForElement(driver, MD_Service_input);
		String Service_Value = getAttribute(driver, MD_Service_input, "value");
		System.out.println(Service_Value);

		waitForElement(driver, vessleValue);
		String Vessel_Value = getText(driver, vessleValue);
		System.out.println(Vessel_Value);

		waitForElement(driver, voyageValue);
		String Voyage_Value = getText(driver, voyageValue);
		System.out.println(Voyage_Value);

		waitForElement(driver, BKG_Bound_Value);
		String Bound_Value = getText(driver, BKG_Bound_Value);
		System.out.println(Bound_Value);

		waitForElement(driver, Booking_POL);
		String Act_Booking_POL = getAttribute(driver, Booking_POL, "value");
		System.out.println("view Booking POL :" + Act_Booking_POL);

		waitForElement(driver, Booking_POD);
		String Act_Booking_POD = getAttribute(driver, Booking_POD, "value");
		System.out.println("view Booking_POD :" + Act_Booking_POD);

		int start = Act_Booking_POD.indexOf('(');
		int end = Act_Booking_POD.indexOf(')');

		String Booking_POD1 = "";
		if (start != -1 && end != -1 && start < end) {
			Booking_POD1 = Act_Booking_POD.substring(start + 1, end);
		}

		System.out.println("POD Value: " + Booking_POD1);

		int start1 = Act_Booking_POL.indexOf('(');
		int end1 = Act_Booking_POL.indexOf(')');

		String Booking_POL1 = "";
		if (start1 != -1 && end1 != -1 && start1 < end) {
			Booking_POL1 = Act_Booking_POL.substring(start1 + 1, end);
		}

		System.out.println("POL Value: " + Booking_POL1);

		Step_Start(2,
				" Open merge booking and Enter input values for service,vessel,voyage,bound,PLA,POL,POD,PLD and agreement party.",
				test, test1);

		moduleNavigate(driver, Merge_Booking_Module_Name);

		waitForElement(driver, MB_Vessel_Search_Button);
		click(driver, MB_Vessel_Search_Button);
		twoColumnSearchWindow(driver, Vessel_code_Header, Condition, Vessel_Value);

		waitForElement(driver, MB_Service_search_Button);
		click(driver, MB_Service_search_Button);
		twoColumnSearchWindow(driver, Service_Code_Header, Condition, Service_Value);

		waitForElement(driver, MB_Voyage_Search_Button);
		click(driver, MB_Voyage_Search_Button);
		twoColumnSearchWindow(driver, Voyage_Header, Condition, Voyage_Value);

		waitForElement(driver, MB_PLA_Search_Button);
		click(driver, MB_PLA_Search_Button);
		twoColumnSearchWindow(driver, Origin_Header, Condition, Booking_POL1);

		waitForElement(driver, MB_POL_Search_Button);
		click(driver, MB_POL_Search_Button);
		twoColumnSearchWindow(driver, POL_Header, Condition, Booking_POL1);

		waitForElement(driver, MB_POD_Search_Button);
		click(driver, MB_POD_Search_Button);
		twoColumnSearchWindow(driver, POD_Header, Condition, Booking_POD1);

		waitForElement(driver, MB_PLD_Search_Button);
		click(driver, MB_PLD_Search_Button);
		twoColumnSearchWindow(driver, PLD_Header, Condition, Booking_POD1);

		waitForElement(driver, MB_Agr_Party_Text);
		sendKeys(driver, MB_Agr_Party_Text, MB_Agr_Party_Value);

		formatLocatorClick(driver, MB_Panel_Select, MB_Agr_Party_Value);

		String Booking_Status = String.format(MB_Booking_status, MB_Booking_Status_Select);
		waitForElement(driver, Booking_Status);
		click(driver, Booking_Status);

		waitForElement(driver, MB_Show_btn);
		click(driver, MB_Show_btn);
		Step_End(2,
				"Open merge booking and Enter input values for service,vessel,voyage,bound,PLA,POL,POD,PLD and agreement party.",
				test, test1);

		Step_Start(3,
				"first select one booking from available booking tab and move the book no to booking to merge tab by clicking on right side button in between the two tabs",
				test, test1);

		waitForElement(driver, Available_Bookings_NO);

		List<WebElement> Booking = listOfElements(driver, Available_Bookings_NO);

		for (WebElement book : Booking) {
			try {
				scrollToElement(driver, book);
				String Booking_Number = getText1(driver, book).trim();

				if (Conrfirmed_booknum.contains(Booking_Number)) {
					System.out.println("Matching booking number found: " + Booking_Number);
					book.click();

					waitForElement(driver, MB_ADD_Btn);
					click(driver, MB_ADD_Btn);

					scrollTop(driver); // Scroll to top if needed

					break; // Break inner loop to re-fetch elements
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught, retrying...");
				break; // Re-fetch list in next loop
			}
		}

		Step_End(3,"first select one booking from available booking tab and move the book no to booking to merge tab by clicking on right side button in between the two tabs",
				test, test1);

		Step_Start(4, "Click merge button then system will validate to add one more booking to merge.", test, test1);

		waitForElement(driver, MB_Merged_Btn);
		click(driver, MB_Merged_Btn);

		waitForElement(driver, popup_Message);
		String Act_Popup_Error_Msg = getText(driver, popup_Message);
		System.out.println("Popup_Text : " + Act_Popup_Error_Msg);

		if (Act_Popup_Error_Msg.equals(Merge_Booking_Error_msg)) {
			System.out.println("Matched || Expected Error Popup Msg : " + Merge_Booking_Error_msg
					+ " || Actual Error popup msg : " + Act_Popup_Error_Msg);
			Extent_pass_New(driver, "Matched || Expected Error Popup Msg : " + Merge_Booking_Error_msg
					+ " || Actual Error popup msg : " + Act_Popup_Error_Msg, test, test1);
		} else {
			System.out.println("Not Matched || Expected Error Popup Msg : " + Merge_Booking_Error_msg
					+ " || Actual Error popup msg : " + Act_Popup_Error_Msg);
			Extent_fail(driver, "Not Matched || Expected Error Popup Msg : " + Merge_Booking_Error_msg
					+ " || Actual Error popup msg : " + Act_Popup_Error_Msg, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		Step_End(4, "Click merge button then system will validate to add one more booking to merge.", test, test1);
		

		

		Extent_completed(testCaseName, test, test1);

	}
}
