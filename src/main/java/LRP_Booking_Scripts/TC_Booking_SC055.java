package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC055 extends Keywords {

	public void Booking_SC055 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC055";
		
		
		

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
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String search_moduleF = Excel_data.get("search_moduleF");
		String feeder_update_msg = Excel_data.get("feeder_update_msg");
		String route_invalid_msg = Excel_data.get("route_invalid_msg");
		String date_Picker = Excel_data.get("date_Picker");
		String ETA_depdate = Excel_data.get("ETA_depdate");
		String ETA_arrdate = Excel_data.get("ETA_arrdate");
		String ETD_depdate = Excel_data.get("ETD_depdate");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String select_by_service_code = Excel_data.get("select_by_service_code");
		String search_by_condition = Excel_data.get("search_by_condition");
		String select_by_vesselcode = Excel_data.get("select_by_vesselcode");
		String select_by_voyage = Excel_data.get("select_by_voyage");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		
		//locators
		String ETD_grid=String.format(Booking_Locators.ETD_Grid,origin);
		String ETA_grid=String.format(Booking_Locators.ETA_Grid,delivery);

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Switch the Profile  - End **********");

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
				moduleNavigate(driver, search_module);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD ",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		keyDown(driver);
		enter(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the POL and POD ",test, test1);
		Step_Start(3, "Enter the Rates", test, test1);

		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(5, "Enter the schedule details", test, test1);
			Step_Start(6, "Save the booking in Draft", test, test1);
			waitForElement(driver, FirstserviceInput);
			String service_Value = getAttribute(driver, FirstserviceInput, "value");
			String vessle_Value = getText(driver, vessleValue);
			String voyage_Value = getText(driver, voyageValue);

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
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String displayed_ETD=getText(driver, ETD_date);
		System.out.println("displayed_ETD: "+displayed_ETD);

		String displayed_ETA=getText(driver, ETA_date);
		System.out.println("displayed_ETA: "+displayed_ETA);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		scrollTop(driver);

				moduleNavigate(driver, search_moduleF);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, search_by_condition, select_by_service_code, service_Value, select_by_vesselcode, vessle_Value, select_by_voyage, voyage_Value);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, ETD_grid);
		waitForElement(driver, ETA_grid);
		System.out.println("ETD_grid and ETA_grid are displayed");
		Extent_pass_New(driver, "ETD_grid and ETA_grid are displayed", test, test1);

		Step_Start(8, " Routing validatiy date should be fallon sail date", test, test1);

		waitForElement(driver, ETD_grid);
		click(driver, ETD_grid);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			waitForElement(driver, ETD_dep_date);
			selectDatePickerDoubleClick(driver, ETD_dep_date, ETD_depdate);
		} else {
			waitForElement(driver, ETD_grid);
			click(driver, ETD_grid);
			doubleClick(driver, ETD_dep_date);
			waitForElement(driver, ETD_dep_input);
			clearAndType(driver, ETD_dep_input, ETD_depdate);
			enter(driver);
			System.out.println("etd entered");
		}

		
		waitForElement(driver, ETA_grid);
		click(driver, ETA_grid);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			waitForElement(driver, ETA_arr_date);
			selectDatePickerDoubleClick(driver, ETA_arr_date, ETA_arrdate);
		} else {
			waitForElement(driver, ETA_grid);
			click(driver, ETA_grid);
			doubleClick(driver, ETA_arr_date);
			waitForElement(driver, ETA_arr_input);
			clearAndType(driver, ETA_arr_input, ETA_arrdate);
			enter(driver);
		}

		waitForElement(driver, ETA_grid);
		click(driver, ETA_grid);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			waitForElement(driver, ETA_dep_date);
			selectDatePickerDoubleClick(driver, ETA_dep_date, ETA_depdate);
		} else {
			waitForElement(driver, ETA_grid);
			click(driver, ETA_grid);
			doubleClick(driver, ETA_dep_date);
			waitForElement(driver, ETA_dep_input);
			clearAndType(driver, ETA_dep_input, ETA_depdate);
			enter(driver);
		}
		Step_End(8, " Routing validatiy date should be fallon sail date", test, test1); 

		click(driver, ETD_grid);
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message);
		String feeder_update=getText(driver, popup_Message);
		if(feeder_update.equals(feeder_update_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched ||  Expected Pop-up Value is :"+ feeder_update_msg+" The Actual Pop-up Value is:"+feeder_update, test, test1);
			System.out.println("Matched ||  Expected Pop-up Value is :"+ feeder_update_msg+"  The Actual Pop-up Value is:"+feeder_update);
		}
		else {
			System.out.println("Not Matched ||  Expected Pop-up Value is :"+ feeder_update_msg+" The Actual Pop-up Value is:"+feeder_update);
			Extent_fail(driver,"Not Matched ||  Expected Pop-up Value is :"+ feeder_update_msg+" The Actual Pop-up Value is:"+feeder_update, test, test1);
		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(9, "click save button system validate", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,route_invalid_msg);
		String popup_msg=getText(driver, popup_Message);
		if(popup_msg.equals(route_invalid_msg)) {
			Extent_pass_New(driver,"Matched ||Expected Pop-up Value is:"+ route_invalid_msg+" Actual Pop-up Value is:"+popup_msg, test, test1);
			System.out.println("Matched ||Expected Pop-up Value is:"+ route_invalid_msg+" Actual Pop-up Value is:"+popup_msg);
		}
		else {
			System.out.println("Not matched ||Expected Pop-up Value is:"+ route_invalid_msg+" Actual Pop-up Value is:"+popup_msg);
			Extent_fail(driver,"Not matched ||Expected Pop-up Value is:"+ route_invalid_msg+" Actual Pop-up Value is:"+popup_msg, test, test1);
		}
		Step_End(9, "click save button system validate", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}