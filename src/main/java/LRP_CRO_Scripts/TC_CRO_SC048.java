package LRP_CRO_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC048 extends Keywords {

	public void CRO_SC048(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_CRO_SC048";

		// Get data from excel sheet
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
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
		String Cus_type = Excel_data.get("Cus_type");
		String Booking_Customer_Types = Excel_data.get("Booking_Customer_Types");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Global_Search_Header = Excel_data.get("Global_Search_Header");
		String Global_Search_Values = Excel_data.get("Global_Search_Values");
		String Global_Seach_Module_Name = Excel_data.get("Global_Seach_Module_Name");
		String Global_Id = Excel_data.get("Global_Id");
		String Global_Value = Excel_data.get("Global_Value");
		String CUSTYPE = Excel_data.get("CUSTYPE");
		String Rset_Option = Excel_data.get("Rset_Option");
		String Reset_Global_Values = Excel_data.get("Reset_Global_Values");
		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);
		navigateUrl(driver, url);

		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Enter the test URL", test, test1);
		Step_Start(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);
		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_End(3, "Enter valid Username & Password in respective textfields", test, test1);
		
		Step_End(4, "Click on Login Button", test, test1);
		
		Step_Start(5, "Switch the agency", test, test1);
		// Switch the Profile
		SwitchProfile(driver, agencyUser);

		Step_End(5, "Switch the agency", test, test1);
		
		Step_Start(6, "Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);
		
		moduleNavigate(driver, Booking_Module_Name);
		
		Step_End(6, "Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);

//	Booking module
		Extent_cal(test, test1, Booking_Module_Name);
		Step_Start(7, "Enter the agr party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		
		Step_End(7, "Enter the agr party", test, test1);
		Step_Start(8, "Enter the orgin", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		Step_End(8, "Enter the orgin", test, test1);
		Step_Start(9, "Enter the Delivery", test, test1);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(9, "Enter the Delivery", test, test1);
		Step_Start(10, "Click the Rates", test, test1);
		Step_Start(11, "Select the rates", test, test1);
		// Rates
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(10, "Click the Rates", test, test1);
		Step_End(11, "Select the rates", test, test1);
		
		Step_Start(12, "Click the draft button and save", test, test1);
		
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		
		
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(12, "Click the draft button and save", test, test1);
		Step_Start(13, "Validate the pop up after saved [BOOKING SAVED]", test, test1);
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
		Step_End(13, "Validate the pop up after saved [BOOKING SAVED]", test, test1);
		Step_Start(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);
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
		Step_End(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);
//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");

		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		

Step_Start(15, "Swift to the container tab", test, test1);
////		Container tab

		waitForElement(driver, container_Tab);
		click(driver, container_Tab);

		Step_End(15, "Swift to the container tab", test, test1);
		Step_Start(16, "Click the edit Button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(16, "Click the edit Button", test, test1);
		Step_Start(17, "Click customer tab", test, test1);
		waitForElement(driver, Customer_Tab);
		click(driver, Customer_Tab);
		Step_End(17, "Click customer tab", test, test1);
		Step_Start(18, "Remove BP customer in grid", test, test1);
		String Booking_Cus_type = String.format(Booking_Cus_type_Select, Cus_type);

		waitForElement(driver, Booking_Cus_type);
		click(driver, Booking_Cus_type);

		waitForElement(driver, Booking_Customer_Remove_Btn);
		click(driver, Booking_Customer_Remove_Btn);
		Step_End(18, "Remove BP customer in grid", test, test1);
		
		Step_Start(19, "Select Booking Party type", test, test1);
		Step_Start(20, "Enter customer code", test, test1);
        Step_Start(21, "Click add button", test, test1);
        Step_Start(22, "Select consignee type", test, test1);
        Step_Start(23, "Enter customer code", test, test1);
        Step_Start(24, "Click add button", test, test1);
        Step_Start(25, "Select notify type", test, test1);
        Step_Start(26, "Enter customer code", test, test1);
        Step_Start(27, "Click add button", test, test1);
Step_Start(28, "Select shipper type", test, test1);
Step_Start(29, "Enter customer code", test, test1);
Step_Start(30, "Click add button", test, test1);
		List<String> Booking_Customer_Type = splitAndExpand(Booking_Customer_Types, ",");
		List<String> Global_Search_Value = splitAndExpand(Global_Search_Values, ",");
		String Bookng_Customer_Name="" ;

		for (int i = 0; i < Booking_Customer_Type.size(); i++) {
			String Booking_Customer_Type_Select = String.format(DropDown_Select, Booking_Customer_Type.get(i));
			waitForElement(driver, Customer_type_dropdown);
			click(driver, Customer_type_dropdown);
			waitForElement(driver, Booking_Customer_Type_Select);
			click(driver, Booking_Customer_Type_Select);
			waitForElement(driver, Customer_Code_SearchBtn);
			click(driver, Customer_Code_SearchBtn);
			globalValueSearchWindow(driver, Global_Search_Condition, Global_Search_Header, Global_Search_Value.get(i),
					"", "", "", "");
			waitForElement(driver, Booking_Customer_Add_Btn);
			click(driver, Booking_Customer_Add_Btn);
		}
		

		String Bookng_Customer_Name_CUSTYPE = String.format(Bookng_Customer_Name_By_CUS_Type,
				CUSTYPE);
waitForElement(driver, Bookng_Customer_Name_CUSTYPE);
		Bookng_Customer_Name = getText(driver, Bookng_Customer_Name_CUSTYPE);
		System.out.println("Bookng_Customer_Name is :" + Bookng_Customer_Name);
		Step_End(19, "Select Booking Party type", test, test1);
		Step_End(20, "Enter customer code", test, test1);
		Step_End(21, "Click add button", test, test1);
		Step_End(22, "Select consignee type", test, test1);
		Step_End(23, "Enter customer code", test, test1);
		Step_End(24, "Click add button", test, test1);
		Step_End(25, "Select notify type", test, test1);
		Step_End(26, "Enter customer code", test, test1);
		Step_End(27, "Click add button", test, test1);
		Step_End(28, "Select shipper type", test, test1);
		Step_End(29, "Enter customer code", test, test1);
		Step_End(30, "Click add button", test, test1);
//	Charges tab
Step_Start(31, "Autorates the charges", test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(31, "Autorates the charges", test, test1);
		Step_Start(32, "Click on save button", test, test1);
		Step_Start(33, "Swift to the master tab and click on confirm button", test, test1);
//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		Step_End(33, "Swift to the master tab and click on confirm button", test, test1);
		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
		Step_Start(34, "Click on Save Button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		Step_End(32, "Click on save button", test, test1);
		Step_End(34, "Click on Save Button", test, test1);
		Step_Start(35, "Validate the popup After clicking save button [BOOKING SAVED]", test, test1);
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
		Step_End(35, "Validate the popup After clicking save button [BOOKING SAVED]", test, test1);
		Step_Start(36, "Validate the colour of Booking number field [Green colour]", test, test1);
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
		Step_End(36, "Validate the colour of Booking number field [Green colour]", test, test1);
		Step_Start(37, "Open global configuration module", test, test1);
		Step_Start(38, "Search ABS config", test, test1);
		Step_Start(39, "Set to SH,AP,BP", test, test1);
		Step_Start(40, "Click save button", test, test1);
		setGlobalConfiguration(driver, Global_Seach_Module_Name, Global_Id, Global_Value);
		Step_End(37, "Open global configuration module", test, test1);
		Step_End(38, "Search ABS config", test, test1);
		Step_End(39, "Set to SH,AP,BP", test, test1);
		Step_End(40, "Click save button", test, test1);
		
		Step_Start(41, "Go to booking module", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End (41, "Go to booking module", test, test1);
Step_Start(42, "Navigate CRO module", test, test1);
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		Step_End(42, "Navigate CRO module", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
		}
		Step_Start(43, "Check SH customer details in customer search", test, test1);
		waitForElement(driver, CRO_Customer);
		String Cro_CustomerName = getText(driver, CRO_Customer);

		if (Bookng_Customer_Name.equalsIgnoreCase(Cro_CustomerName)) {
			System.out.println(
					"Matched || The Customer Name From the Booking Module  In SH  Cus.Type is : "
							+ Bookng_Customer_Name + " ||  The Customer Name From the CRO  Module  In SH  Cus.Type is : " + Cro_CustomerName);
			Extent_pass_New(driver,
					"Matched || The Customer Name From the Booking Module  In SH  Cus.Type is : "
							+ Bookng_Customer_Name + " ||  The Customer Name From the CRO  Module  In SH  Cus.Type is : " + Cro_CustomerName,
					test, test1);
		} else {
			System.out.println(
					" Not Matched || The Customer Name From the Booking Module  In SH  Cus.Type is : "
							+ Bookng_Customer_Name + " ||  The Customer Name From the CRO  Module  In SH  Cus.Type is : " + Cro_CustomerName);
			Extent_fail(driver,
					" Not Matched || The Customer Name From the Booking Module  In SH  Cus.Type is : "
							+ Bookng_Customer_Name + " ||  The Customer Name From the CRO  Module  In SH  Cus.Type is : " + Cro_CustomerName,
					test, test1);
		}
		Step_End(43, "Check SH customer details in customer search", test, test1);
		Step_Start(44, "Go to global configuration module", test, test1);	
		Step_Start(45, "Search ABS config", test, test1);
		Step_Start(46, "Set to AP,BP,SH", test, test1);
		
		reSetGlobalConfiguration(driver, Rset_Option, Global_Seach_Module_Name, Global_Id, Reset_Global_Values);
		
	
		Step_End(44, "Go to global configuration module", test, test1);	
		Step_End(45, "Search ABS config", test, test1);
		Step_End(46, "Set to AP,BP,SH", test, test1);
		Extent_completed(testCaseName, test, test1);

	}

}
