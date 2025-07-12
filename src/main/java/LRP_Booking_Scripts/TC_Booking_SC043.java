package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC043 extends Keywords{

	public void Booking_SC043 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC043";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Extent_call(test, test1,"********** Switch the Profile Start **********");

		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Switch the Profile End **********");

		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, search_module);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);
		
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		
		waitForElement(driver, Booking_Rate_Close_Btn);
		safeclick(driver, Booking_Rate_Close_Btn);
		//select the shipment type
		waitForElement(driver, RatedBtn);
		safeclick(driver, RatedBtn);
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
		waitForElement(driver, $Rates);
		safeclick(driver, $Rates);

		System.out.println("********** Select the Columns in Rates Grid **********");
		Extent_call(test, test1,"********** Select the Columns in Rates Grid **********");

		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);

		Step_Start(3, "Select the Routing ",test, test1);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
		}
		scrollBottom(driver);
		String port_gird_up = getText(driver, gird_value);
		System.out.println(port_gird_up);
		waitForElement(driver, FirstserviceInput);
		clear(driver, FirstserviceInput);
		sendKeys(driver, FirstserviceInput, first_service_data);
		waitForElement(driver, Scrollbuttonservice);
		horizontalscroll(driver, Scrollbuttonservice, 500);
		waitForElement(driver, port_click);
		String port_gird = getText(driver, port_click);
		System.out.println(port_gird);
		if(port_gird_up.equals(port_gird)) {
			System.out.println("Matched || expected value : "+port_gird_up+" || actual value : "+port_gird);
			Extent_pass_New(driver, "Matched || expected value : "+port_gird_up+" || actual value : "+port_gird, test, test1);
		}else {
			System.out.println("Not Matched || expected value : "+port_gird_up+" || actual value : "+port_gird);
			Extent_fail(driver, "Not Matched || expected value : "+port_gird_up+" || actual value : "+port_gird, test, test1);
		}
		Extent_completed(test_Case_Name, test, test1);
	}
}