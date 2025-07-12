package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC002   extends Keywords{
	public void Booking_SC002(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC002";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("agr_party");
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


		Extent_Start(test_Case_Name, test, test1);


		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1,"********** Switch the Profile Start **********");

		SwitchProfile(driver, agencyUser);

		System.out.println("********** Switch the Profile End **********");
		Extent_call(test, test1,"********** Switch the Profile End **********");

		System.out.println("********** Enter Booking Module **********");
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
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(3, "Select the Routing",test, test1);
		waitForElement(driver, Draft_Button);
		jsClick(driver, Draft_Button);

		Step_Start(5, "save the booking in Draft",test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
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
		Step_End(5, "save the booking in Draft",test, test1);
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
		safeclick(driver, master_tab);
		Extent_call(test, test1,"********** Pinting the Booking number*******");
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);
		Extent_pass_New(driver, "****Booking number was generated as****"+booknum, test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		Step_Start(6, "AutoRate the charges in Charge tab",test, test1);
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(6, "AutoRate the charges in Charge tab",test, test1);
		Step_Start(7, "select confirm button and click Save button",test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		// verify the popup for booking saved
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup=getText(driver, popup_Message);
		if(actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected Po-pup  : "+bookingUpdatedPopup+" || Actual Pop-up  : "+actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected Po-pup  : "+bookingUpdatedPopup+" || Actual Pop-up : "+actualUpdatedPopup);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Po-pup  : "+bookingUpdatedPopup+" || But Actual Pop-up : "+actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected Po-pup : "+bookingUpdatedPopup+" || But Actual Pop-up : "+actualUpdatedPopup, test,test1);
		}		
		waitForElement(driver, booking_no);	
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String submit_bookingColor=getColorName(actualConfirmedColorCode);
		if(submit_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field is Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field is Not changed to green colour ]", test, test1); 
		} 
		Step_End(7, "select confirm button and click Save button",test, test1);
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		String routingedit1 = getText(driver, Routingeditverify);
		System.out.println(routingedit1);
		Step_Start(8, "Click Edit button and change the Booking details",test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
//		editSchedule(driver, first_service_data_edit);
		System.out.println("***Verifying the service code changed before edit and after edit ***");
		Extent_call(test, test1,"***Verifying the service code changed before edit and after edit ***");
//		waitForElement(driver, Routingeditverify);
//		String routingedit = getText(driver, Routingeditverify);
//		System.out.println(routingedit);
		waitForDisplay(driver, SaveButton_ToolBar);
		if(isElementAccessible(driver, SaveButton_ToolBar)) {                                                                                                                  
			System.out.println("Matched || Expected save button should be Enabled  || Actual save button is enabled");            
			Extent_pass_New(driver,"Matched || Expected save button should be Enabled  || Actual save button is enabled", test,test1);  
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || Expected save button should be Enabled  || Actual save button is Not enabled");        
			Extent_fail(driver, "Not Matched || Expected save button should be Enabled  || Actual save button is Not enabled", test,test1); 
		} 
		Step_End(8, "Click Edit button and change the Booking details",test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}