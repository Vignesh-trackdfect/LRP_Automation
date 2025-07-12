package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC019 extends Keywords {
	///// Check whether while click Autorate button system capture the charges based on Attached Rates
	public void Booking_SC019(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)throws Exception {
		String test_Case_Name="TC_Booking_SC019";
		//		Get data from excel sheet
		

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
		String gridStatus = Excel_data.get("GridStatus");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
		// Login
	LRP_Login(driver, Username, Password);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);
		// Module search
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, search_module);
		//		Booking module
		Step_Start(1, "Enter The Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter The Agreement Party", test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(4, "Select the Schedule ", test, test1);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		Step_Start(5, "Save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// Verification of saved popup of draft
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		Extent_cal(test, test1,"**********Verifting the saved popup**********");
		if(savepopACT.contains(savedpopEXP)) {                                                                                                                  
			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

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
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println("Pinting the Booking number");
		Extent_call(test, test1," Pinting the Booking number ");
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);

		if(!booknum.equals("")) {
			System.out.println("Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number Generated Successfully. The Newly Generated Booking number is : " + booknum);
			Extent_pass_New(driver,"Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number Generated Successfully. The Newly Generated Booking number is : " + booknum, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number is Not Generated");
			Extent_fail(driver,"Not Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number is Not Generated", test, test1);
		}
		Step_End(5, "Save the booking in Draft", test, test1);
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, chargesTab_Rows);
		String beforeGrid=getAttribute(driver, chargesTab_Rows,"class");
		if(beforeGrid.contains(gridStatus)) {
			System.out.println("Matched || Expected Result is Charges grids Should Empty || The Actual Result is Charges grids are Empty");
			Extent_pass_New(driver,"Matched || Expected Result is Charges grids Should Empty || The Actual Result is Charges grids are Empty", test,test1);
		}else {
			System.out.println("Not Matched || Expected Result is Charges grids Should Empty || The Actual Result is Charges grids are Not Empty");
			Extent_fail(driver,"Not Matched || Expected Result is Charges grids Should Empty || The Actual Result is Charges grids are Not Empty", test,test1);
		}
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		waitForElement(driver, chargesTab_Rows);
		String afterGrid=getAttribute(driver, chargesTab_Rows,"class");
		scrollBottom(driver);
		if(!afterGrid.contains(gridStatus)) {
			Extent_call(test, test1, " System Capture The Charges Based On Attached Rates");
			Extent_pass_New(driver, "Matched || Expected Result is : System Should capture the charges based on Attached Rates || Actual Result is : System captured the charges based on Attached Rates", test,test1);
			System.out.println("Matched || Expected Result is : System Should capture the charges based on Attached Rates || Actual Result is : System captured the charges based on Attached Rates");
		}else {
			Extent_fail(driver,"Not Matched || Expected Result is : System Should capture the charges based on Attached Rates || Actual Result is : System Not captured the charges based on Attached Rates", test,test1);
			System.out.println("Not Matched || Expected Result is : System Should capture the charges based on Attached Rates || Actual Result is : System Not captured the charges based on Attached Rates");
		}
		waitForElement(driver, chargesGrid);
		scrollTop(driver);
		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "Select confirm button and click Save button(Confirm the Booking)", test, test1);
		//		Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);	
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// verify the popup for booking saved
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup=getText(driver, popup_Message);
		if(actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || Actual Pop-up value is : "+actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || Actual Pop-up value is : "+actualUpdatedPopup);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || But Actual Pop-up value is : "+actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || But Actual Pop-up value is : "+actualUpdatedPopup, test,test1);
		}		
		waitForElement(driver, booking_no);	
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String submit_bookingColor=getColorName(actualConfirmedColorCode);
		if(submit_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  

		Step_End(7, "Select confirm button and click Save button(Confirm the Booking)", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
