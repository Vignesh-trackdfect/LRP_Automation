package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC048 extends Keywords{

	public void Booking_SC048 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {


		String tc_Name="TC_Booking_SC048";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String select_haulage_popup_msg = Excel_data.get("select_haulage_popup_msg");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		
		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		
		LRP_Login(driver, Username, Password);
		
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

		Step_Start(3, "Select the Routing ", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
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
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println("Book number generated is: "+booknum);

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
		Step_End(5, "save the booking in Draft ", test, test1);
		Step_Start(6, "select confirm button and safeclick Save button ", test, test1);

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, Charges_tab);
		click1(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click1(driver, AutoRated);

		waitForElement(driver, master_tab);
		click1(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		Step_Start(7, "save the booking ", test, test1);   
        waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		Step_Start(6, "select the Carrier /merchant    ", test, test1);

		waitForPopup(driver, popup_Message,select_haulage_popup_msg);
		String select_haulage=getText(driver,popup_Message);

		if(select_haulage.equals(select_haulage_popup_msg)) {        
			Extent_pass_New(driver,"Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || Actual Pop-up value is : "+select_haulage, test, test1);
			System.out.println("Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || Actual Pop-up value is : "+select_haulage);  
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || Actual Pop-up value is : "+select_haulage);
			Extent_fail(driver,"Not Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || Actual Pop-up value is : "+select_haulage, test, test1);

		} 
		Step_End(6, "select the Carrier /merchant    ", test, test1);
		Step_End(7, "save the booking ", test, test1);

		Extent_completed(tc_Name, test, test1);


	}

}

