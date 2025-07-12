package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC069 extends Keywords {
	public void Booking_SC069(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String test_Case_Name01 = "TC_Booking_SC069";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Search_input");
		String agencyUser = Excel_data.get("AgencyUser");
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
		String Referencevalue = Excel_data.get("Referencevalue");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String TerminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String condition_Filter = Excel_data.get("condition_Filter");
		String globalSearchFilterOption = Excel_data.get("globalSearchFilterOption");
		String dropdownCondition = Excel_data.get("dropdownCondition");

		Extent_Start(test_Case_Name01, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1, "********** Switch the Profile Start **********");

		SwitchProfile(driver, agencyUser);

		System.out.println("********** Switch the Profile End **********");
		Extent_call(test, test1, "********** Switch the Profile End **********");

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1, "********** Enter Booking Module **********");

		moduleNavigate(driver, search_module);

		Step_Start(1, "Enter the Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter the Agreement Party", test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);

		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		Step_End(2, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
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
		Step_End(3, "Select the Routing", test, test1);
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);

		Step_Start(5, "save the booking in Draft", test, test1);
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
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		System.out.println("********** Pinting the Booking number **********");
		Extent_call(test, test1, "********** Pinting the Booking number*******");
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		Extent_pass_New(driver, "****Booking number was generated as****" + booknum, test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, master_tab);
		click1(driver, master_tab);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);

		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		waitForElement(driver, Charges_tab);
		click1(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click1(driver, AutoRated);

		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "select confirm button and click Save button", test, test1);
		;
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
		Step_End(7, "select confirm button and click Save button", test, test1);

		Step_Start(8, "Reset the AP System will clear Saleas Ref values", test, test1);

		waitForElement(driver, referencetab);
		safeclick(driver, referencetab);

		waitForDisplay(driver, sales_rep);
		if (!isDisplayed(driver, sales_rep)) {
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, referencetyprselect);
			safeclick(driver, referencetyprselect);

			waitForElement(driver, referencetyprselectvalue);
			safeclick(driver, referencetyprselectvalue);

			waitForElement(driver, referencenum);
			sendKeys(driver, referencenum, Referencevalue);
			waitForElement(driver, referenceadd);
			safeclick(driver, referenceadd);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}
		// getting text of reference name
		waitForDisplay(driver, sales_rep_norecords);
		if (isDisplayed(driver, sales_rep_norecords)) {
			Extent_pass_New(driver, "**reference type was empty**", test, test1);
			Extent_call(test, test1, "**reference type was empty**");
		}
		String referencevalue = getText(driver, referencetabtext);
		System.out.println(referencevalue);

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value = getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, acc_term_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption, booknum, "", "", "", "");

		// navigate to the reference tab

		waitForElement(driver, referencetab);
		safeclick(driver, referencetab);
		waitForElement(driver, referencetabtext);

		// getting text from reference name

		String referencevalueinBL = getText(driver, referencetabtext);
		System.out.println(referencevalueinBL);

		// verifying the both reference name in Booking Tab and Bl tab
		if (referencevalue.equals(referencevalueinBL)) {
			Extent_pass_New(driver, "Matched  ||Excepted[*** Ref name shown in booking Tab***]:" + referencevalue
					+ " Actual[***Ref name shown in BL Tab***]:" + referencevalueinBL, test, test1);
			System.out.println("Matched  ||Excepted[*** Ref name shown in booking Tab***]:" + referencevalue
					+ " Actual[***Ref name shown in BL Tab***]:" + referencevalueinBL);
			Extent_pass_New(driver, "The Refrerence name was same in both booking tab and Bl tab ", test, test1);
			System.out.println("The Refrerence name was same in both booking tab and Bl tab");

		} else {
			System.out.println("Not matched[*** Ref name shown in booking Tab***]||Excepted:" + referencevalue
					+ " Actual[***Ref name shown in BL Tab***]:" + referencevalueinBL);
			Extent_fail(driver, "Not matched[*** Ref name shown in booking Tab***]||Excepted:" + referencevalue
					+ " Actual[***Ref name shown in BL Tab***]:" + referencevalueinBL, test, test1);
		}

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, referencetabtext);
		doubleClick(driver, referencetabtext);
		waitForElement(driver, removereference);
		safeclick(driver, removereference);

		waitForElement(driver, Reset_button);
		safeclick(driver, Reset_button);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForDisplay(driver, sales_rep_norecords);
		if (!isDisplayed(driver, sales_rep_norecords)) {
			System.out.println("Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was cleared after remove and referesh");
			Extent_pass_New(driver, "Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was cleared after remove and referesh", test, test1);

		} else {
			System.out.println("Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was Not cleared after remove and referesh");
			Extent_fail(driver, "Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was Not cleared after remove and referesh", test, test1);

		}

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		// safeclick on Bl Button

		waitForElement(driver, BLClick);
		safeclick(driver, BLClick);

		// navigate to the reference tab

		waitForElement(driver, Regstatus);
		safeclick(driver, Regstatus);

		waitForDisplay(driver, sales_rep_norecords_bl);
		if (!isDisplayed(driver, sales_rep_norecords_bl)) {
			System.out.println("Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was cleared after remove and referesh");
			Extent_pass_New(driver, "Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was cleared after remove and referesh", test, test1);

		} else {
			System.out.println("Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was Not cleared after remove and referesh");
			Extent_fail(driver, "Expected Result is : Reference type Should clear after remove and referesh || The Actual Result is : Reference type was Not cleared after remove and referesh", test, test1);

		}
		Step_End(8, "Reset the AP System will clear Saleas Ref values", test, test1);

		Extent_completed(test_Case_Name01, test, test1);

	}
}
