package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC149 extends Keywords {
	public void Booking_SC149(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String test_Case_Name01 = "TC_Booking_SC149";

		String Username = Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String agencyUser =Excel_data.get("agencyUser");
		String allAgencySearch =Excel_data.get("allAgencySearch");
		String pop_msg_exp =Excel_data.get("pop_msg_exp");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition1");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");
		Extent_Start(test_Case_Name01, test, test1);

		//Open Url
		navigateUrl(driver, url);

		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1,"********** Switch the Profile Start **********");

		//Switch profile
		SwitchProfile(driver, agencyUser);


		System.out.println("********** Switch the Profile End **********");
		Extent_call(test, test1,"********** Switch the Profile End **********");

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");

		// searching the module of booking

		moduleNavigate(driver, Search);
		Step_Start(1, "Retrive the booking ",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
		
		Step_End(1, "Retrive the booking ",test, test1);

		Step_Start(2, "safeclick on edit button",test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		System.out.println("********** Pinting the Booking number **********");
		Extent_call(test, test1,"********** Pinting the Booking number*******");
		String bookingnum=getAttribute(driver, booking_no, "value");
		System.out.println(bookingnum);
		Step_End(2, "safeclick on edit button ",test, test1);
		Step_Start(3, "Again reteive the same booking number in new booking tab",test, test1);

		moduleNavigate(driver, Search);
		waitForElement(driver, Newtabyes);
		safeclick(driver, Newtabyes);

		switchtotab(driver, 1);
		scrollTop(driver);
		waitForElement(driver, Globalsearch);
		click(driver, Globalsearch);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
	
		System.out.println("********** Pinting the Booking number **********");
		Extent_call(test, test1,"********** Pinting the Booking number*******");
		waitForElement(driver, booking_no);
		String bookingnum1=getAttribute(driver, booking_no, "value");
		System.out.println(bookingnum1);
		Step_End(3, "Again reteive the same booking number in new booking tab",test, test1);
		Step_Start(4, "safeclick on edit button in new retrived tab",test, test1);
		waitForElement(driver, global_Editbtn);
		safeclick(driver, global_Editbtn);

		Step_End(4, "safeclick on edit button in new retrived tab",test, test1);
		Step_Start(5, "Validate the popup  of  The BOOKING ** is already locked by **. ",test, test1);
		waitForPopup(driver, popup_Message,pop_msg_exp);


		String pop_msg_act=getText(driver,popup_Message);
		System.out.println(pop_msg_act);


		if (pop_msg_exp.equals(pop_msg_act)) {
			System.out.println(
					"Matched || " + " Expected Activity popup is : " + pop_msg_exp + " || Actual Activity popup is : " + pop_msg_act);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity popup is : " + pop_msg_exp + " || Actual Activity popup is : " + pop_msg_act, test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity popup is : " + pop_msg_exp + " || Actual Activity popup is : " + pop_msg_act);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity popup is : " + pop_msg_exp + " || Actual Activity popup is : " + pop_msg_act,
					test,test1);
		}


		System.out.println("********** verifying the booking number in two tab are same  **********");
		Extent_call(test, test1,"**********verifying the booking number in two tab are same  *******");
		if (bookingnum.equals(bookingnum1)) {
			System.out.println(
					"Matched || " + " Expected Activity booking number is  : " + bookingnum + " || Actual Activity booking number is : " + bookingnum1);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity booking number is : " + bookingnum + " || Actual Activity booking number is : " + bookingnum1, test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity booking number is : " + bookingnum + " || Actual Activity booking number is : " + bookingnum1);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity booking number is : " + bookingnum + " || Actual Activity booking number is : " + bookingnum1,

					test,test1);
		}

		Step_End(5, "Validate the popup  of  The BOOKING ** is already locked by **.",test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);


		switchtotab(driver, 0);
scrollTop(driver);
		waitForElement(driver, Cancletopbtn);
		safeclick(driver, Cancletopbtn);



		Extent_completed(test_Case_Name01, test, test1);

	}

}
