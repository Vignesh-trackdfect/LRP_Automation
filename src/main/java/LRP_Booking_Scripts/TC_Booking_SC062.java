package LRP_Booking_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC062 extends Keywords{
	public void Booking_SC062(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name="TC_Booking_SC062";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input").trim();
		String Search2 = Excel_data.get("Search2").trim();
		String agencyUser = Excel_data.get("AgencyUser");
		String allAgencySearch = Excel_data.get("allAgencySearch");
		String select_by_book_number = Excel_data.get("select_by_book_number");
		String dd1_condition = Excel_data.get("dd1_condition");
		String search_by_rr = Excel_data.get("search_by_rr");

		Extent_Start(tc_Name, test, test1);

		//Open Url
		navigateUrl(driver,url);
		//Login

		LRP_Login(driver, Username, Password);

		//Switch profile

		SwitchProfile(driver, agencyUser);

		// searching the module of booking

		moduleNavigate(driver, Search);

		// searching contract number in global search 

		Step_Start(1, "searching the contract number in global search", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, allAgencySearch, "", "", "", "");

		Step_End(1, "searching the contract number in global search", test, test1);

		Step_Start(2, "clicking container tab", test, test1);
		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);

		Step_End(2, "clicking container tab", test, test1);


		waitForElement(driver, Rate_No_Value);
		mouseOverToElement(driver, Rate_No_Value);
		String rateValue = getText(driver, Rate_No_Value);
		System.out.println(rateValue);
		// Navigate to the master Tab

		Step_Start(3, "navigate to master tab", test, test1);
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		scrollTop(driver);
		Step_End(3, "navigate to master tab", test, test1);

		moduleNavigate(driver, Search2);
//		waitForElement(driver, cancel_Common_btn);
//		safeclick(driver, cancel_Common_btn);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dd1_condition, search_by_rr, rateValue, "", "", "", "");
		waitForElement(driver, Switchtobooking);
		safeclick(driver, Switchtobooking);
		Step_Start(4, "click on charges tab", test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		Step_End(4, "click on charges tab", test, test1);

		Extent_call(test, test1, "clicking the edit button");

		Step_Start(5, "click on edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_End(5, "click on edit button", test, test1);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		List<String> charge_Codes = new ArrayList<String>();
		List<WebElement> charges_Value = listOfElements(driver, charges_value);

		Step_Start(6, "Storing the charges value", test, test1);
		for(WebElement element :charges_Value) {
			String Charge_code = getText1(driver, element);
			if(!Charge_code.equalsIgnoreCase("OFR")) {
				charge_Codes.add(Charge_code);
			}
		}
		Step_End(6, "Storing the charges value", test, test1);

		Step_Start(7, "Comapring the values in the rate request module", test, test1);
		waitForElement(driver, Rate_Request_Page);
		safeclick(driver, Rate_Request_Page);
		waitForElement(driver, Rate_Request_Page);
		for (String charge_Code : charge_Codes) {
			String value1 =String.format(Booking_Locators.value1, charge_Code);
//			waitForDisplay(driver, value1);
			if(isdisplayed(driver, value1)) {
				String actual_Charges =String.format(Booking_Locators.actual_Charges, charge_Code);
				String charge = getText(driver,actual_Charges);
				System.out.println("Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" || The Actual Charege Code Tariff Value in Rate Requst Module Tab : "+charge);	
				Extent_pass_New(driver, "Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" || The Actual Charege Code Tariff Value in Rate Requst Module Tab : "+charge, test, test1);
			}else {
				System.out.println("Not Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" The Charge Code is Not Available In Rate Request");
				Extent_fail(driver, "Not Matched || The Expected Charege Code From Booking Charges Tab : "+charge_Code+" The Charge Code is Not Available In Rate Request", test, test1);
			}

		}
		Step_End(7, "Comapring the values in the rate request module", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
