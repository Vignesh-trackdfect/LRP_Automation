package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC050 extends Keywords {

	public void Booking_SC050 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name="TC_Booking_SC050";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser=Excel_data.get("agencyUser");
		String arg_party=Excel_data.get("arg_party");
		String origin=Excel_data.get("origin");
		String delivery=Excel_data.get("delivery");
		String booking_draft_Color= Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color= Excel_data.get("booking_confirmed_Color");
		String select_haulage_popup_msg=Excel_data.get("select_haulage_popup_msg");
		String changing_haulage_msg=Excel_data.get("changing_haulage_msg");
		String add_charges_msg=Excel_data.get("add_charges_msg");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String rate_no = Excel_data.get("rate_no");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String merchant_data = Excel_data.get("merchant_data");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		
		//locators
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
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,select_haulage_popup_msg);
		String select_haulage=getText(driver,popup_Message);
		if(select_haulage.equals(select_haulage_popup_msg)) {        
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || The Actual Popup Value is :"+select_haulage, test, test1);
			System.out.println("Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || The Actual Popup Value is :"+select_haulage);  
		}else {     
			System.out.println("Not Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || The Actual Popup Value is :"+select_haulage);
			Extent_fail(driver,"Not Matched || Excepted Pop-up value is : "+ select_haulage_popup_msg+" || The Actual Popup Value is :"+select_haulage, test, test1);
		} 

		Step_Start(6, "Select the Merchant", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		formatLocatorClick(driver, Orig_merchant_btn, merchant_data);
		waitForPopup(driver, popup_Message,changing_haulage_msg);
		String haulage_popup_msg=getText(driver, popup_Message);
		if(haulage_popup_msg.equals(changing_haulage_msg)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Extent_pass_New(driver,"Matched || Excepted Pop-up value is : "+ changing_haulage_msg+" || The Actual Popup Value is : "+haulage_popup_msg, test, test1);
			System.out.println("Matched || Excepted Pop-up value is : "+ changing_haulage_msg+" || The Actual Popup Value is : "+haulage_popup_msg);  
		}else {     
			System.out.println("Not Matched || Excepted Pop-up value is : "+ changing_haulage_msg+" || The Actual Popup Value is : "+haulage_popup_msg);
			Extent_fail(driver,"Not Matched || Excepted Pop-up value is : "+ changing_haulage_msg+" || The Actual Popup Value is : "+haulage_popup_msg, test, test1);
		} 

		waitForElement(driver, Dest_merchant_btn);
		click(driver, Dest_merchant_btn);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Select the Merchant", test, test1);

		waitForPopup(driver, popup_Message,add_charges_msg);
		String charges_popup_msg=getText(driver, popup_Message);
		if(charges_popup_msg.equals(add_charges_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || Excepted Pop-up value is : "+ add_charges_msg+" || The Actual Popup Value is : "+charges_popup_msg, test, test1);
			System.out.println("Matched || Excepted Pop-up value is : "+ add_charges_msg+" || The Actual Popup Value is : "+charges_popup_msg);  
		}else {     
			System.out.println("Not Matched || Excepted Pop-up value is : "+ add_charges_msg+" || The Actual Popup Value is : "+charges_popup_msg);
			Extent_fail(driver,"Not Matched || Excepted Pop-up value is : "+ add_charges_msg+" || The Actual Popup Value is : "+charges_popup_msg, test, test1);
		} 
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		Step_Start(7, "Save the booking in Confirmed_Button", test, test1);
scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForDisplay(driver, missing_inland_popup);
		if(isdisplayed(driver, missing_inland_popup)) {
			System.out.println("system validates Precarriage and On Carriage charges");
			Extent_pass_New(driver, "system validates Precarriage and On Carriage charges", test, test1);
		}

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String UpdatedpopACT = getText(driver, popup_Message);
		System.out.println(UpdatedpopACT);
		if(UpdatedpopACT.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + UpdatedpopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + UpdatedpopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + UpdatedpopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + UpdatedpopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);
		if (Confirm_bookingColor.equalsIgnoreCase(booking_confirmed_Color)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  
		Step_End(7, "Save the booking in Confirmed_Button", test, test1);

		Extent_completed(tc_Name, test, test1);

	}
}