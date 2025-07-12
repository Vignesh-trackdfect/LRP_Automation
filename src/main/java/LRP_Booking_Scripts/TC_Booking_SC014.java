package LRP_Booking_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC014 extends Keywords {

	//// Check whether system doesn't allow to save the Booking in Line Agency
	public void Booking_SC014(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String test_Case_Name="TC_Booking_SC014";

		//		Get data from excel sheet

		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String lineUser = Excel_data.get("LineUser");
		String switchToAgencyPopup = Excel_data.get("SwitchToAgencyPopup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
		// Login
		LRP_Login(driver, Username, Password);
		//				Verify Line agency				
		waitForElement(driver, type_Of_User);
		String actualUser=getText(driver, type_Of_User);
		if(actualUser.contains(lineUser)) {
			Extent_pass_New(driver,"Matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser, test,test1);
			System.out.println("Matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser);
		}else {
			System.out.println("Not matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser);
			Extent_fail(driver,"Not matched || Excepted Agency User : "+ lineUser+" || Actual Agency User : "+actualUser, test,test1);
		}
		// Module search
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, search_module);
		//				Booking module
		Step_Start(1, " Enter The Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, " Enter The Agreement Party", test, test1);				
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);


		Step_Start(5, "Save the booking in Draft", test, test1);


		System.out.println(" System Not Allow To Create Booking In Line Agency ");
		Extent_call(test, test1," System Not Allow To Create Booking In Line Agency ");

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,switchToAgencyPopup);
		String actSwitchToAgencyPopup = getText(driver, popup_Message);
		if (actSwitchToAgencyPopup.contains(switchToAgencyPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup : "+switchToAgencyPopup+" || Actual Popup :"+actSwitchToAgencyPopup , test,test1);
			System.out.println("Matched || Expected popup : "+switchToAgencyPopup+" || Actual Popup :"+actSwitchToAgencyPopup);
			Extent_pass_New(driver, "Matched || Expected: Unable To Create Booking In Line Agency ||  Actual: Unable to create Booking In Line Agency ", test,test1);
			System.out.println("Matched || Unable To Create Booking In Line Agency ||  Actual: Unable to create Booking In Line Agency");
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup : "+switchToAgencyPopup+" || Actual Popup :"+actSwitchToAgencyPopup);
			Extent_fail(driver, "Not Matched || Expected popup : "+switchToAgencyPopup+" || Actual Popup :"+actSwitchToAgencyPopup , test,test1);
		}
		Step_End(5, "Save the booking in Draft", test, test1);

		Extent_completed(test_Case_Name, test, test1);

	}
}
