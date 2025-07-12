package LRP_CRO_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


public class TC_CRO_SC002 extends Keywords {

	public void CRO_SC002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC002";

		//		Get data from excel sheet

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
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String No_Records_Popup = Excel_data.get("No_Records_Popup");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Search_By = Excel_data.get("Search_By");

		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Open the browser", test, test1);

		navigateUrl(driver, url);
		
		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Open the browser", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_Start(4, " Click on Login Button", test, test1);

		LRP_Login(driver, Username, Password);
		
		Step_End(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_End(4, " Click on Login Button", test, test1);
		Step_Start(5, "Switch the agency", test, test1);

		SwitchProfile(driver, agencyUser);
		
		Step_End(5, "Switch the agency", test, test1);
		Step_Start(6, "Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);

		moduleNavigate(driver, Booking_Module_Name);

		Step_End(6, "Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);
		Step_Start(7, "Enter the agr party", test, test1);

//	Booking module
		Extent_cal(test, test1, Booking_Module_Name);

		
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
		Step_Start(12, "Click the draft button and save ", test, test1);

		
//		Master tab		
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		
		Step_End(12, "Click the draft button and save ", test, test1);
		Step_Start(13, "Validate the pop up  after  saved  [BOOKING SAVED]", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is  :" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is :" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP + "|| Actual Popup value is :" + savepopACT);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP + "|| Actual Popup value is:" + savepopACT, test,test1);
		}


		Step_End(13, "Validate the pop up  after  saved  [BOOKING SAVED]", test, test1);
		Step_Start(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		}
		Step_End(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);

//	Master tab		
		
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");
		
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		

		
//  CRO 
		Step_Start(15, "Open \"Container release order\" module.", test, test1);

		moduleNavigate(driver, CRO_Module_Name);
		
		Step_End(15, "Open \"Container release order\" module.", test, test1);
		Step_Start(16, "Search booking No.", test, test1);

		scrollTop(driver);
		waitForElement(driver, booking_No_SearchButton_CRO);
		click(driver, booking_No_SearchButton_CRO);
		
		Step_Start(17, "Enter the draft book number in search", test, test1);
		Step_Start(18, "Click search button.", test, test1);

		globalValueSearchWindow1(driver, Global_Search_Condition, Search_By, booknum, "", "", "", "");
		
		
		Step_End(16, "Search booking No.", test, test1);
		Step_End(17, "Enter the draft book number in search", test, test1);
		Step_End(18, "Click search button.", test, test1);
		Step_Start(19, "\"No records\" message shown.", test, test1);

		waitForPopup(driver, Popup_Message, No_Records_Popup);
		String actualPopup=getText(driver, Popup_Message);
		
		if (actualPopup.contains(No_Records_Popup)) {
			System.out.println("Matched || Expected Popup  : " + No_Records_Popup + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + No_Records_Popup + "|| Actual Popup  :" + actualPopup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Popup : " + No_Records_Popup + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + No_Records_Popup + "|| Actual Popup :" + actualPopup, test,test1);
		}
		
		Step_End(19, "\"No records\" message shown.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
	}
