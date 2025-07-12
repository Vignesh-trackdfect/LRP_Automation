package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements_2;
import commonMethods.Keywords;



public class TC_Booking_SC074 extends Keywords{

	/////check whether in Booking , based on ADB plugin configuration (True/ ) except Empty move system not allow to delete the Booking

	public void  Booking_SC074(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC074";

		//Get data from Excel sheet


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
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginEnableStatus = Excel_data.get("PluginEnableStatus");
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String movementEntryModule = Excel_data.get("MovementEntryModule");
		String equipmentNumber = Excel_data.get("EquipmentNumber");
		String cannotCancelPopup = Excel_data.get("CannotCancelPopup");
		String savedPopupText = Excel_data.get("SavedPopup");
		String datePicker=Excel_data.get("DatePicker");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		String activityEqpEntry_1 = Excel_data.get("Activity1");
		String activityEqpEntry_2 = Excel_data.get("Activity2");

		String activityDateSingle = Excel_data.get("ActivityDate");
		String activityHourSingle = Excel_data.get("ActivityHour");
		String activityDateSingle_2 = Excel_data.get("ActivityDate_2");
		String activityHourSingle_2 = Excel_data.get("ActivityHour_2");
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		//Plugin Configuration module
		Extent_cal(test, test1, "Plugin Configuration");

		Step_Start(1, "Set ADB plugin (True/False)", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, pluginConfigurationModule);
		
		Extent_cal(test, test1, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID=getText(driver, searched_pluginId);
		if(actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			String select_Status=String.format(pluginValue_Select, pluginEnableStatus);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			//   Verify Plugin Updated popup

			waitForPopup(driver, Popup_Message, pluginUpdatedPopup);
			String actualUpdatedPopup=getText(driver, Popup_Message);
			System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
			if(actualUpdatedPopup.contains(pluginUpdatedPopup)){
				System.out.println("Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_pass_New(driver, "Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}
		Step_End(1, "Set ADB plugin (True/False)", test, test1);

		//Booking module

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, search_module);
		
		Step_Start(2, "Enter The Agreement Party", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(2, "Enter The Agreement Party", test, test1);
		Step_Start(3, "Enter the POL and POD and select the Rates using Rates window", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
Step_End(4, "Select the Routing & Select the Schedule", test, test1);
		Step_Start(5, " Save The Booking in Draft ", test, test1);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_fail(driver, "Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
		}

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
		//		Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");

		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		if(!booknum.equals("")) {
			System.out.println("Generated Booking number is " + booknum);
			Extent_pass_New(driver, "Generated Booking number is " + booknum, test, test1);
		}else {
			System.out.println("Booking number is not generarted");
			Extent_fail(driver, "Booking number is not generarted", test, test1);
		}

		Step_End(5, "Save the booking in Draft", test, test1);
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		//	charges tab		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "select confirm button and click Save button(Confirm the Booking)", test, test1);

		//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String saved_conformed_pop_act = getText(driver, popup_Message);
		System.out.println(saved_conformed_pop_act);
		// validate the saved conform popup
		System.out.println("**********Verifting the saved popup **********");
		Extent_call(test, test1,"**********Verifting the saved popup**********");
		if (saved_conformed_pop_act.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1); 
		} 
		Step_End(8, "Click conform and save the booking ",test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);
		// validate the colour of booking number field after conform
		Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
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
		Step_End(7, "Select Confirm button and Click Save button(Confirm the Booking)", test, test1);

		// Movement Entry
		Extent_call(test, test1, movementEntryModule);

		moduleNavigate(driver, movementEntryModule);

		// Single Entry Equipment
		waitForElement(driver, equipmentNoSearchField_L);
		sendKeys(driver, equipmentNoSearchField_L, equipmentNumber);

		waitForElement(driver, activitySearchFieldInSingle_L);
		sendKeys(driver, activitySearchFieldInSingle_L, activityEqpEntry_1);
		waitForElement(driver, autoCompleteValue_ME);
		enter(driver);
		
		waitForElement(driver, activeDateInSingle_L);

		if(datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateInSingle_L, activityDateSingle);
		}else {
			if(activityDateSingle.contains("-")) {
				click(driver, activeDateInSingle_L);
				String activityDateSingle_1=activityDateSingle.replace("-", "/");
				clearAndType(driver, activeDateInSingle_L, activityDateSingle_1);

			}else {
				click(driver, activeDateInSingle_L);
				clearAndType(driver, activeDateInSingle_L, activityDateSingle);
			}		
		}

		if (!activityHourSingle.equals("")) {

			click(driver, activityTime);

			if (isDisplayed(driver, Calender)) {
				click(driver, activityTime_Input);
				waitForElement(driver, activity_Time);
				clearAndType(driver, activity_Time, activityHourSingle);
				waitForElement(driver, activityTime_Close);
				click(driver, activityTime_Close);
			}				

		}
		
		waitForElement(driver, showInputSin_L);
		click(driver, showInputSin_L);

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
			
		}
		
		
		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);
		
		scrollTop(driver);
		waitForElement(driver, equipmentNoSearchField_L);
		String ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
		System.out.println("ActualEqNo:" + ActualEqNo);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, savedPopupText);
			String actText = getText(driver, popup_Message);
			if (actText.equals(savedPopupText)) {
				System.out.println("Matched || " + " Expected popup is : " + savedPopupText
						+ " || Actual popup is : " + actText);
				Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedPopupText
						+ " || Actualpopup is : " + actText+"\r\n"+savedPopupText + " popup is displayed", test, test1);
				System.out.println(savedPopupText + " popup is displayed");
				click(driver, popup_Message_Ok_Button);

			} else {
				System.out.println("Not matched || " + " Expected popup is : " + savedPopupText
						+ " || Actual popup  is : " + actText);
				System.out.println(savedPopupText + " popup is not displayed");
				Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedPopupText
						+ " || Actual popup is : " + actText+"\r\n"+savedPopupText + " popup is not displayed", test, test1);
			}

		//Create SNTS Move
			Step_Start(8, "Create SNTS Move", test, test1);

		Extent_call(test, test1, "Create Movement Entry");
		
		waitForElement(driver, equipmentNoSearchField_L);
		clearAndType(driver, equipmentNoSearchField_L, equipmentNumber);

		waitForElement(driver, activitySearchFieldInSingle_L);
		sendKeys(driver, activitySearchFieldInSingle_L, activityEqpEntry_2);
		waitForElement(driver, autoCompleteValue_ME);
		enter(driver);
		
		waitForElement(driver, activeDateInSingle_L);

		if(datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateInSingle_L, activityDateSingle_2);
		}else {
			if(activityDateSingle_2.contains("-")) {
				click(driver, activeDateInSingle_L);
				String activityDateSingle_2_1=activityDateSingle_2.replace("-", "/");
				clearAndType(driver, activeDateInSingle_L, activityDateSingle_2_1);

			}else {
				click(driver, activeDateInSingle_L);
				clearAndType(driver, activeDateInSingle_L, activityDateSingle_2);
			}		
		}

		if (!activityHourSingle_2.equals("")) {

			click(driver, activityTime);

			if (isDisplayed(driver, Calender)) {
				click(driver, activityTime_Input);
				waitForElement(driver, activity_Time);
				clearAndType(driver, activity_Time, activityHourSingle_2);
				waitForElement(driver, activityTime_Close);
				click(driver, activityTime_Close);
			}				

		}
		
		waitForElement(driver, showInputSin_L);
		click(driver, showInputSin_L);

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
			
		}

		Movement_Entry_All_Elements_2 allElements_SNTS=new Movement_Entry_All_Elements_2();
		allElements_SNTS.movementEntryAllElements(driver, Excel_data, test, test1);		

		waitForElement(driver, booking_No_Textfield_ME);
		Newclear(driver, booking_No_Textfield_ME);
		waitForElement(driver, booking_No_Textfield_ME);
		sendKeys(driver, booking_No_Textfield_ME, booknum);
		
		scrollTop(driver);
		waitForElement(driver, equipmentNoSearchField_L);
		 ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
		System.out.println("ActualEqNo:" + ActualEqNo);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message, savedPopupText);
			actText = getText(driver, popup_Message);
			if (actText.equals(savedPopupText)) {
				System.out.println("Matched || " + " Expected popup is : " + savedPopupText
						+ " || Actual popup is : " + actText);
				Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedPopupText
						+ " || Actualpopup is : " + actText+"\r\n"+savedPopupText + " popup is displayed", test, test1);
				System.out.println(savedPopupText + " popup is displayed");
				click(driver, popup_Message_Ok_Button);

			} else {
				System.out.println("Not matched || " + " Expected popup is : " + savedPopupText
						+ " || Actual popup  is : " + actText);
				System.out.println(savedPopupText + " popup is not displayed");
				Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedPopupText
						+ " || Actual popup is : " + actText+"\r\n"+savedPopupText + " popup is not displayed", test, test1);
			}
		Step_End(8, "Create SNTS Move", test, test1);

		//Delete Booking
		Extent_cal(test, test1, "Booking");
		Step_Start(9, "Delete Booking", test, test1);

		waitForElement(driver, booking_Tab);	
		click(driver,booking_Tab);

//		waitForDisplay(driver, NewButton_ToolBar);	
//		if(isdisplayed(driver, NewButton_ToolBar)&& isElementAccessible(driver, NewButton_ToolBar)) {
//		click(driver, NewButton_ToolBar);
//		waitForElement(driver, Cancletopbtn);
//		click(driver, Cancletopbtn);
//		}

		waitForElement(driver, local_Search_Inputfield);
		clearAndType(driver, local_Search_Inputfield,booknum);
		waitForElement(driver, local_SearchButton);
		click(driver, local_SearchButton);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		//Verify Booking popup

		waitForElement(driver, containerMovement_Frame);
			String actualCannotCancelPopup=getText(driver, cannotCancel_Text);   //CRO and following Container already Sent to Shipper. You cannot cancel this booking
			if(actualCannotCancelPopup.equals(cannotCancelPopup)) {
				Extent_pass_New(driver, "Matched || Expected Result is : "+cannotCancelPopup+" || Actual Result is "+actualCannotCancelPopup, test,test1);
				System.out.println("Matched || Expected Result is : "+cannotCancelPopup+" || Actual Result is "+actualCannotCancelPopup);
				Extent_pass_New(driver, "Unable to delete the booking", test,test1);
				System.out.println("Unable to delete the booking");
			}else {
				System.out.println(" Not Matched || Expected Result is : "+cannotCancelPopup+" || Actual Result is "+actualCannotCancelPopup);
				Extent_fail(driver, "Not Matched || Expected Result is : "+cannotCancelPopup+" || Actual Result is "+actualCannotCancelPopup, test,test1);
			}

		Step_End(9, "Delete Booking", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}
