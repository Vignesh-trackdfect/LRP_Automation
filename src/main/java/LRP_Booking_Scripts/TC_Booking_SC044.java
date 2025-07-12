package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC044 extends Keywords {

	public void Booking_SC044 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name01 = "TC_Booking_SC044";
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String rate_no = Excel_data.get("rate_no");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");


		//locators

		Extent_Start(test_Case_Name01, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Extent_call(test, test1,"**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);
		Extent_cal(test, test1,"** Enter Booking Module **");

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
		tab(driver);
		Step_End(2, "Enter the Orgin and delivery", test, test1);

		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(4, "routing and and schedule terminal should be same", test, test1);

		waitForElement(driver, schedule_details);
		String schedule_POL = getAttribute(driver, schedule_details, "value");

		waitForElement(driver, routing_details);
		String routing=getText(driver, routing_details);

		if(schedule_POL.contains(routing)) {
			System.out.println("Matched || Expected value was : "+routing+" || Actual value was : "+schedule_POL);
			Extent_pass_New(driver, "Matched || Expected value was : "+routing+" || Actual value was : "+schedule_POL, test, test1);
		}
		else {
			System.out.println("NotMatched || Expected value was : "+routing+" || Actual value was : "+schedule_POL);
			Extent_fail(driver,  "NotMatched || Expected value was : "+routing+" || Actual value was : "+schedule_POL, test, test1);
		}
		Step_End(4, "routing and and schedule terminal should be same", test, test1);

		Extent_completed(test_Case_Name01, test, test1);

	}		
}
