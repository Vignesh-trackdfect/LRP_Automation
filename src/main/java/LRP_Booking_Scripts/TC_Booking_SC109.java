package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Booking_SC109 extends Keywords {

	public void Booking_SC109(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String tc_Name = "TC_Booking_SC109";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber = Excel_data.get("Voyagenumber");
		String Boundinput = Excel_data.get("Boundinput");
		String blocked_customer_msg = Excel_data.get("blocked_customer_msg");
		String Search_moduleCM = Excel_data.get("Search_moduleCM");
		String status = Excel_data.get("status");
		String rate_no = Excel_data.get("rate_no");
		String search_by_customer_name = Excel_data.get("search_by_customer_name");
		String search_by_condition = Excel_data.get("search_by_condition");
		String globalSearchFilterOption2 = Excel_data.get("GlobalSearchFilterOption2");
		String globalSearchFilterOption3 = Excel_data.get("GlobalSearchFilterOption3");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		// locators

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
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		keyDown(driver);
		enter(driver);
		Step_End(2, "Enter the Orgin and delivery", test, test1);

		Step_Start(3, "Enter the Rates", test, test1);

		waitForDisplay(driver, Rate_Grid);
		if (isdisplayed(driver, Rate_Grid)) {
			System.out.println(
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");
			Extent_pass_New(driver,
					"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed",
					test, test1);
		} else {
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.", test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		}
		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			waitForElement(driver, tariff_checkbox);
			click(driver, tariff_checkbox);
			waitForElement(driver, rate_showbtn);
			click(driver, rate_showbtn);
		}

		Step_Start(4, "Select the Routing", test, test1);
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		click(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		waitForElement(driver, Rate_No_Select);
		click(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		click(driver, ok_btn);
		Step_End(4, "Select the Routing", test, test1);

		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber, Boundinput);
		Step_Start(6, "Save the booking in Draft", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(6, "Save the booking in Draft", test, test1);

		Step_Start(7, "System validates Attached customer blocked in the Customer master", test, test1);
		waitForPopup(driver, popup_Message, blocked_customer_msg);
		String error_popup_msg = getText(driver, popup_Message);
		if (error_popup_msg.contains(blocked_customer_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			System.out.println("Matched || Expected value POPUP was : " + blocked_customer_msg
					+ " || Actual value POPUP was : " + error_popup_msg);
			Extent_pass_New(driver, "Matched || Expected value POPUP was : " + blocked_customer_msg
					+ " || Actual value POPUP was : " + error_popup_msg, test, test1);
		} else {
			System.out.println("NotMatched || Expected value POPUP was : " + blocked_customer_msg
					+ " || Actual value POPUP was : " + error_popup_msg);
			Extent_fail(driver, "NotMatched || Expected value POPUP was : " + blocked_customer_msg
					+ " || Actual value POPUP was : " + error_popup_msg, test, test1);
		}
		Step_End(7, "System validates Attached customer blocked in the Customer master", test, test1);
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, Search_moduleCM);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, search_by_condition, search_by_customer_name, arg_party,
				globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, block_checkbox);
		String checkbox_status = getAttribute(driver, block_checkbox, "class");
		if (checkbox_status.contains(status)) {
			Extent_pass_New(driver, "Matched || Excepted attribute Status shown value : " + status
					+ " actual attribute Status shown value : " + checkbox_status, test, test1);
			System.out.println("Matched || Excepted attribute Status shown value : " + status
					+ " actual attribute Status shown value : " + checkbox_status);
		} else {
			System.out.println("Not Matched || Excepted attribute Status shown value : " + status
					+ " actual attribute Status shown value : " + checkbox_status);
			Extent_fail(driver, "Not Matched || Excepted attribute Status shown value : " + status
					+ " actual attribute Status shown value : " + checkbox_status, test, test1);
		}
		Extent_completed(tc_Name, test, test1);
	}
}
