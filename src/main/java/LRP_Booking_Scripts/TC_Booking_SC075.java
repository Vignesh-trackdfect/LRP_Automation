package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC075 extends Keywords{

	///// Check whether  in Booking, Empty move done system allow to delete the booking

	public void  Booking_SC075(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC075";

		//Get data from Excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search");
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
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginEnableStatus = Excel_data.get("PluginEnableStatus");
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String wantToCancelPopup = Excel_data.get("WantToCancelPopup");		
		String remarks = Excel_data.get("Remarks");
		String bookingCancelledPopup = Excel_data.get("BookingCancelledPopup");		
		String cancelledBookingColor = Excel_data.get("RedColor");
		String cancelReason = Excel_data.get("CancelReason");
		String pluginStatusTrue = Excel_data.get("PluginStatusTrue");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		//Module search

		Step_Start(1, "Set ADB plugin", test, test1);		

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		

		moduleNavigate(driver, pluginConfigurationModule);

		Extent_cal(test, test1, pluginConfigurationModule);


		//Plugin Configuration module
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID=getText(driver, searched_pluginId);
		if(actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			String select_Status=String.format(pluginValue_Select, pluginEnableStatus);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			//   Verify Plugin Updated popup

			waitForPopup(driver, Popup_Message, pluginUpdatedPopup);
			String actualUpdatedPopup=getText(driver, Popup_Message);
			System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
			if(actualUpdatedPopup.contains(pluginUpdatedPopup)){
				System.out.println("Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_pass_New(driver, "Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}

		Step_End(1, "Set ADB plugin", test, test1);
		//Booking module
		Extent_cal(test, test1, search_module);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		

		moduleNavigate(driver, search_module);

		Step_Start(2, "Enter The Agreement Party", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(2, "Enter The Agreement Party", test, test1);
		Step_Start(3, "Enter the POL and POD and select the Rates using Rates window", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		Step_End(4, "Select the Routing & Select the Schedule", test, test1);
		Step_Start(5, " Save The Booking in Draft ", test, test1);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_fail(driver, "Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
		}

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);

		if (draft_bookingColor.equals(booking_draft_Color)) {
			System.out.println("Matched || "+ " Expected Report Activity is[Booking number input field want to change yellow colour] : "+ booking_draft_Color+ " || Actual Report Activity is [Booking number input field  changed yellow colour] : "+ draft_bookingColor);
			Extent_pass_New(driver,"Matched || "+ " Expected Report Activity is[Booking number input field want to change yellow colour] : "+ booking_draft_Color+ " || Actual Report Activity is [Booking number input field  changed yellow colour] : "+ draft_bookingColor,test, test1);
		} else {
			System.out.println("Not Matched || "+ " Expected Report Activity is[Booking number input field not  changed to yellow colour] : "+ booking_draft_Color+ " || Actual Report Activity is[Booking number input field not changed to yellow colour] : "+ draft_bookingColor);
			Extent_fail(driver,"Not Matched || "+ " Expected Report Activity is[Booking number input field not  changed to yellow colour] : "+ booking_draft_Color+ " || Actual Report Activity is[Booking number input field not changed to yellow colour] : "+ draft_bookingColor,test, test1);
		}

		//		Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");

		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		Step_End(5, " Save The Booking in Draft ", test, test1);

		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		//charges tab		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		Step_End(6, "AutoRate the charges in Charge tab", test, test1);

		Step_Start(7, "Select Confirm button and Click Save button(Confirm the Booking)", test, test1);

		//Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup = getText(driver, popup_Message);
		if (actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup,test, test1);
		}

		waitForElement(driver, Booking_No_Field);
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String actualConfirmedColor=getColorName(actualConfirmedColorCode);

		if(actualConfirmedColor.equalsIgnoreCase(booking_confirmed_Color)) {
			Extent_pass_New(driver,"Matched || The background color of confirmed Booking number textfield is green|| Expected color code:" +booking_confirmed_Color+" || Actual color code:"+actualConfirmedColor, test,test1);
			System.out.println("Matched || The background color of confirmed Booking number textfield is green");
		}else {
			System.out.println("Not Matched || The background color of confirmed Booking number textfield is not green");
			Extent_fail(driver,"Not Matched || The background color of confirmed Booking number textfield is not green|| Expected color code:" +booking_confirmed_Color+" || Actual color code:"+actualConfirmedColor, test,test1);
		}

		Step_End(7, "Select Confirm button and Click Save button(Confirm the Booking)", test, test1);


		//		Delete Booking
		Step_Start(8, "Delete Booking", test, test1);

		waitForElement(driver, booking_Tab);
		click(driver,booking_Tab);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		waitForElement(driver, popup_Message);
		String actualWantToCancelPopup=getText(driver, popup_Message);
		if(actualWantToCancelPopup.equals(wantToCancelPopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup, test,test1);
			System.out.println("Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup);

			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Not Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+wantToCancelPopup+" || Actual Popup : "+actualWantToCancelPopup, test,test1);
		}


		waitForDisplay(driver, bookingCancelRemarks_Frame);		
		if(isDisplayed(driver, bookingCancelRemarks_Frame)) {
			if(isDisplayed(driver, cancelledreason)) {
				waitForElement(driver, cancelledreason)	;
				click(driver, cancelledreason);
				formatLocatorClick(driver, remarks_Reason, cancelReason);
				waitForElement(driver, remarksTextBox);

				sendKeys(driver, remarksTextBox, remarks);
				waitForElement(driver, remarks_Ok_Button);
				click(driver, remarks_Ok_Button);
			}
		}

		waitForElement(driver, popup_Message);
		String actualCancelledPopup=getText(driver, popup_Message);
		if(actualCancelledPopup.contains(bookingCancelledPopup)) {
			Extent_pass_New(driver, "Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup, test,test1);
			System.out.println("Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup);

			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+bookingCancelledPopup+" || Actual Popup : "+actualCancelledPopup, test,test1);
		}

		waitForElement(driver, Booking_No_Field);
		String actualCancelledColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String actualCancelledColor=getColorName(actualCancelledColorCode);

		if(actualCancelledColor.equalsIgnoreCase(cancelledBookingColor)) {
			Extent_pass_New(driver,"Matched || The background color of Cancelled Booking number textfield is red || Expected color : " +cancelledBookingColor+" || Actual color : "+actualCancelledColor, test,test1);
			System.out.println("Matched || The background color of Cancelled Booking number textfield is red || Expected color : " +cancelledBookingColor+" || Actual color : "+actualCancelledColor);
			Extent_pass_New(driver, "Booking Cancelled", test,test1);
		}else {
			System.out.println("Not Matched || The background color of Cancelled Booking number textfield is not red || Expected color : " +cancelledBookingColor+" || Actual color : "+actualCancelledColor +"<br>"+"Booking Cancelled  based on ADB plugin configuration (True) CRO Done");
			Extent_fail(driver,"Not Matched || The background color of Cancelled Booking number textfield is not red || Expected color : " +cancelledBookingColor+" || Actual color : "+actualCancelledColor +"<br>"+"Booking Cancelled  based on ADB plugin configuration (True) CRO Done", test,test1);
		}	

		Step_End(8, "Delete Booking", test, test1);

		Extent_call(test, test1, "Plugin status Set as default");
		waitForElement(driver, pluginConfiguration_Tab);
		click(driver, pluginConfiguration_Tab);
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID1=getText(driver, searched_pluginId);
		if(actualPluginID1.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			String select_Status=String.format(pluginValue_Select, pluginStatusTrue);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}


		Extent_completed(testCaseName, test, test1);
	}
}
