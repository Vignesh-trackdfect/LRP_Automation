package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC073 extends Keywords {

	///// check whether in Booking , based on ADB plugin configuration (True/false ) CRO, Load confirmation done then system not allow to delete the Booking

	public void Booking_SC073(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC073";

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
		String Voyagenumber1 = Excel_data.get("Voyagenumber");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginStatusTrue = Excel_data.get("PluginStatusTrue");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String agencyConfiguration = Excel_data.get("AgencyConfiguration");
		String value = Excel_data.get("Value");
		String defaultValue = Excel_data.get("DefaultValue");
		String loadConfirmationModule = Excel_data.get("LoadConfirmationModule");
		String actualContainerNo = Excel_data.get("ActualContainerNo");
		String loadConfirmedPopup = Excel_data.get("LoadConfirmedPopup");
		String activityDatePopup = Excel_data.get("ActivityDatePopup");
		String loadPlannedPopup = Excel_data.get("LoadPlannedPopup");
		String vesselCode = Excel_data.get("VesselCode");
		String portCode = Excel_data.get("PortCode");
		String terminalCode = Excel_data.get("TerminalCode");
		String description = Excel_data.get("AgencyDescription");
		String pluginID_APB = Excel_data.get("PluginID_APB");
		String pluginStatus_ADB = Excel_data.get("PluginStatus_ADB");
		String datePicker = Excel_data.get("DatePicker");
		String activityDate = Excel_data.get("ActivityDate");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String condition_Filter = Excel_data.get("condition_Filter");
		String agencyCode_Search = Excel_data.get("AgencyCode_Search");


		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);

		//	Plugin Configuration
		Extent_cal(test, test1, "Plugin Configuration");
		Step_Start(1, "Set APB plugin Configuration True", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, pluginConfigurationModule);
				
		Extent_cal(test, test1, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID_APB);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID=getText(driver, searched_pluginId);

		if(actualPluginID.equals(pluginID_APB)){
			Extent_pass_New(driver, pluginID_APB+" plugin ID is available", test,test1);
			System.out.println(pluginID_APB+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, pluginStatusTrue);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			//   Verify Plugin Updated popup

			waitForElement(driver, Popup_Message);
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
			System.out.println(pluginID_APB+" plugin ID is unavailable");
			Extent_fail(driver, pluginID_APB+" plugin ID is unavailable", test,test1);
		}
		Step_End(1, "Set APB plugin Configuration True", test, test1);

		waitForElement(driver, pluginConfiguration_Tab);
		click(driver, pluginConfiguration_Tab);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		// Agency Configuration
		Extent_cal(test, test1, agencyConfiguration);
		Step_Start(2, "Set Booking – CRO should not be Mandatory as Y ", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, agencyConfiguration);
				


		newButton(driver);
		waitForElement(driver, agencySearch_Button);
		click(driver, agencySearch_Button);

		twoColumnSearchWindow(driver, agencyCode_Search, condition_Filter, agencyUser);

		waitForElement(driver, AC_Show_Button);
		click(driver, AC_Show_Button);

		waitForElement(driver,  AC_description_Grid_Filter);
		click(driver,  AC_description_Grid_Filter);
		sendKeys(driver,  AC_description_Grid_Filter, description);

formatLocatorClick(driver, agency_Description, description);
		waitForElement(driver,  AC_value_Textfield);
		click(driver,  AC_value_Textfield);
		waitForElement(driver,  AC_value_Textfield);

		clearAndType(driver,  AC_value_Textfield, value);

		waitForElement(driver, plus_Button_ACG);
		click(driver, plus_Button_ACG);

		waitForDisplay(driver,popup_Message);
		if(isDisplayed(driver, popup_Message)) {
			String actualPopup=getText(driver, popup_Message);
			Extent_pass_New(driver, actualPopup+" popup is displayed", test, test1);
			System.out.println(actualPopup+" popup is displayed");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}
		Step_End(2, "Set Booking – CRO should not be Mandatory as Y ", test, test1);

		waitForElement(driver, agencyConfiguration_Tab);
		click(driver, agencyConfiguration_Tab);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);


		//		Switch the Profile
		SwitchProfile(driver, agencyUser);

		// Module search

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, pluginConfigurationModule);
				
		Extent_cal(test, test1, pluginConfigurationModule);
		//Plugin Configuration module


		Step_Start(3, "Set ADB plugin (True/False)", test, test1);


		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID1=getText(driver, searched_pluginId);
		if(actualPluginID1.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, pluginStatus_ADB);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			//   Verify Plugin Updated popup

			waitForElement(driver, Popup_Message);
			String actualUpdatedPopup=getText(driver, Popup_Message);
			System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
			if(actualUpdatedPopup.contains(pluginUpdatedPopup)){
				System.out.println("Matched || Expected popup : " + pluginUpdatedPopup + "|| Actual Popup : " + actualUpdatedPopup);
				Extent_pass_New(driver, "Matched || Expected popup : " + pluginUpdatedPopup + "|| Actual Popup : " + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup : " + pluginUpdatedPopup + "|| Actual Popup : " + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup : " + pluginUpdatedPopup + "|| Actual Popup : " + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}
		Step_End(3, "Set ADB plugin (True/False)", test, test1);

		//Booking module
		Extent_cal(test, test1, search_module);
		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
			moduleNavigate(driver, search_module);
				
		//			Booking module
		Step_Start(4, "Enter The Agreement Party", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(4, "Enter The Agreement Party", test, test1);
		Step_Start(5, "Enter the POL and POD and select the Rates using Rates window", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		Step_End(6, "Select the Routing & Select the Schedule", test, test1);
		Step_Start(7, " Save The Booking in Draft ", test, test1);
		waitForElement(driver, FirstserviceInput);
		String service_Value = getAttribute(driver, FirstserviceInput, "value");
		String vessle_Value = getText(driver, vessleValue);
		String voyage_Value = getText(driver, voyageValue);
		String Bound_Value = getText(driver, BKG_Bound_Value);
		
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
			System.out.println( "Matched || Expected  Pop-up value is : " + savedpopEXP + "|| Actual Popup value is:" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected  Pop-up value is  : " + savedpopEXP + "|| Actual Popup value is:" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected  Pop-up value is  : " + savedpopEXP + "|| Actual Popup value is:" + savepopACT);
			Extent_fail(driver, "Not Matched ||Expected  Pop-up value is  : " + savedpopEXP + "|| Actual Popup value is:" + savepopACT, test,test1);
		}

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		if(draft_bookingColor.equalsIgnoreCase(booking_draft_Color)) {                                                                                                                  
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
		waitForElement(driver, Booking_No_Field);
		String actualBookingNo=getAttribute(driver, Booking_No_Field, "value");
		Step_End(9, "Select Confirm button and Click Save button(Confirm the Booking)", test, test1);

		//			Load Confirmation module
		Extent_cal(test, test1, loadConfirmationModule);
		Step_Start(10, "Retrieve Confirmed_Button booking number & Load confirm", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, loadConfirmationModule);
		//		Select service

		  
				waitForElement(driver, service_Searchfield);
				sendKeys(driver, service_Searchfield, service_Value);

				waitForElement(driver, L_vessel_Input);
				sendKeys(driver, L_vessel_Input,vessle_Value );

				waitForElement(driver, L_VoyageInput);
				sendKeys(driver, L_VoyageInput, voyage_Value);

				waitForElement(driver, L_Boundinpiut);
				sendKeys(driver, L_Boundinpiut, Bound_Value);

//waitForElement(driver, LC_portCode_Inputfield);
//		sendKeys(driver, LC_portCode_Inputfield, portCode);
//
//		waitForElement(driver, LC_terminalCode_Inputfield);
//		sendKeys(driver,LC_terminalCode_Inputfield, terminalCode);

		waitForElement(driver, LC_select_Service);
		doubleClick(driver, LC_select_Service);
		
		waitForElement(driver, LC_show_Button);
		click(driver, LC_show_Button);

		//		Retrieve Confirmed_Button booking number & Verify

		waitForElement(driver, LC_bookingNo_filter);
		click(driver, LC_bookingNo_filter);
		waitForElement(driver, LC_bookingNo_filter);
		Actionsendkeys(driver, LC_bookingNo_filter, actualBookingNo);

		waitForElement(driver, LC_gridBookingNo);
		String retrivedBookNo=getText(driver, LC_gridBookingNo);
		if(retrivedBookNo.equals(actualBookingNo)) {
			Extent_pass_New(driver, "Matched || Expected Booking Number : "+actualBookingNo+" || Actual Booking Number : "+retrivedBookNo, test,test1);
			System.out.println( "Matched || Expected Booking Number : "+actualBookingNo+" || Actual Booking Number : "+retrivedBookNo);

			waitForElement(driver, LC_actualContainerNo_Editable);
			doubleClick(driver, LC_actualContainerNo_Editable);
			waitForElement(driver, LC_actualContainerNo_Inputfield);
			click(driver, LC_actualContainerNo_Inputfield);
			waitForElement(driver, LC_actualContainerNo_Inputfield);
			sendKeys(driver, LC_actualContainerNo_Inputfield, actualContainerNo);
			waitForElement(driver, LC_select_Checkbox);
			click(driver, LC_select_Checkbox);

			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
				String actualActivityDatePopup=getText(driver, popup_Message);
				if(actualActivityDatePopup.contains(activityDatePopup)) {
					click(driver, popup_Message_Ok_Button);
					waitForElement(driver, activityDate_LoadConfirm);
					click(driver, activityDate_LoadConfirm);
					

					if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activityDate_LoadConfirm, activityDate);

						}else {
							clearAndType(driver, activeDateInSingle_L, activityDate);

						}		
					waitForElement(driver, LC_select_Checkbox);
					click(driver, LC_select_Checkbox);
				}
			}

			waitForElement(driver, LC_loadConfirmation_Button);
			click(driver, LC_loadConfirmation_Button);					
		}else {
			System.out.println( "Not Matched || Expected Booking Number : "+actualBookingNo+" || Actual Booking Number : "+retrivedBookNo);
			Extent_fail(driver, "Not Matched || Expected Booking Number : "+actualBookingNo+" || Actual Booking Number : "+retrivedBookNo, test,test1);
		}

		//		Verify Load confirmed popup

		waitForPopup(driver, popup_Message,loadConfirmedPopup);
		String actualConfirmed_Popup=getText(driver, popup_Message);
		if(actualConfirmed_Popup.contains(loadConfirmedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup : "+loadConfirmedPopup+" || Actual Popup : "+actualConfirmed_Popup, test,test1);
			System.out.println( "Matched || Expected popup : "+loadConfirmedPopup+" || Actual Popup : "+actualConfirmed_Popup);

			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println( "Not Matched || Expected popup : "+loadConfirmedPopup+" || Actual Popup : "+actualConfirmed_Popup);
			Extent_fail(driver, "Not Matched || Expected popup : "+loadConfirmedPopup+" || Actual Popup : "+actualConfirmed_Popup, test,test1);
		}

		Step_End(10, "Retrieve Confirmed_Button booking number & Load confirm", test, test1);


		Extent_call(test, test1, "Delete Booking- Started");
		System.out.println("Delete Booking- Started");


		//		Booking module
		Extent_cal(test, test1, "Booking");

		Step_Start(11, "Delete Booking", test, test1);
		waitForElement(driver, booking_Tab);	
		click(driver, booking_Tab);

		waitForDisplay(driver, NewButton_ToolBar);	
		if(isdisplayed(driver, NewButton_ToolBar)&& isElementAccessible(driver, NewButton_ToolBar)) {
		click(driver, NewButton_ToolBar);
		waitForElement(driver, Cancletopbtn);
		click(driver, Cancletopbtn);
		}
		
		waitForElement(driver, condition_Filter_Local);
		click(driver, condition_Filter_Local);
		waitForElement(driver, local_Equal_To);
		click(driver, local_Equal_To);
		waitForElement(driver, local_Search_Inputfield);
		sendKeys(driver, local_Search_Inputfield,actualBookingNo);
		waitForElement(driver, local_SearchButton);
		click(driver, local_SearchButton);


		//		Delete Booking		
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		//		Verify Booking popup

		waitForPopup(driver, popup_Message,loadPlannedPopup);
		String actualLoadPlannedPopup=getText(driver, popup_Message);
		if(actualLoadPlannedPopup.equals(loadPlannedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup : "+loadPlannedPopup+" || Actual Popup : "+actualLoadPlannedPopup, test,test1);
			System.out.println("Matched || Expected popup : "+loadPlannedPopup+" || Actual Popup : "+actualLoadPlannedPopup);
			System.out.println("Unable to delete the booking");
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup : "+loadPlannedPopup+" || Actual Popup : "+actualLoadPlannedPopup);
			System.out.println("Able to delete the booking");
			Extent_fail(driver, "Not Matched || Expected popup : "+loadPlannedPopup+" || Actual Popup : "+actualLoadPlannedPopup, test,test1);

		}

		Step_End(11, "Delete Booking", test, test1);

		// Plugin Configuration switch back to True	
		Extent_cal(test, test1, "Plugin Configuration");

		Step_Start(12, "Set ADB plugin True", test, test1);

		waitForElement(driver, pluginConfiguration_Tab);
		click(driver, pluginConfiguration_Tab);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID11=getText(driver, searched_pluginId);
		if(actualPluginID11.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, pluginStatusTrue);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}
		Step_End(12, "Set ADB plugin True", test, test1);

		//			Switch the Profile
		
		ResetProfile(driver);

		//			Plugin Configuration
		Extent_cal(test, test1, "Plugin Configuration");
		Step_Start(13, "Set APB plugin Configuration False", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, pluginConfigurationModule);
		
		Extent_cal(test, test1, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID_APB);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID111=getText(driver, searched_pluginId);

		if(actualPluginID111.equals(pluginID_APB)){
			Extent_pass_New(driver, pluginID_APB+" plugin ID is available", test,test1);
			System.out.println(pluginID_APB+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, pluginStatusTrue);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		}	else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}
		Step_End(13, "Set APB plugin Configuration False", test, test1);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		// Agency Configuration
		Extent_cal(test, test1, agencyConfiguration);
		Step_Start(14, "Set Booking – CRO should not be Mandatory as N ", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
			moduleNavigate(driver, agencyConfiguration);
				
			newButton(driver);
		waitForElement(driver, agencySearch_Button);
		click(driver, agencySearch_Button);

		twoColumnSearchWindow(driver, agencyCode_Search, condition_Filter, agencyUser);

		waitForElement(driver, AC_Show_Button);
		click(driver,AC_Show_Button);

		waitForElement(driver, AC_description_Grid_Filter);
		click(driver, AC_description_Grid_Filter);
		sendKeys(driver, AC_description_Grid_Filter, description);

		String description_Select1=String.format(agency_Description, description);
		waitForElement(driver, description_Select1);
		click(driver, description_Select1);

		waitForElement(driver, AC_value_Textfield);
		click(driver, AC_value_Textfield);
		clearAndType(driver, AC_value_Textfield, defaultValue);

		waitForElement(driver, plus_Button_ACG);
		click(driver, plus_Button_ACG);

		waitForDisplay(driver, popup_Message);
		if(isDisplayed(driver, popup_Message)) {
			String actualPopup=getText(driver, popup_Message);
			Extent_pass_New(driver, actualPopup+" popup is displayed", test, test1);
			System.out.println(actualPopup+" popup is displayed");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}
		click(driver, Module_Close);
		Step_End(14, "Set Booking – CRO should not be Mandatory as N ", test, test1);


		Extent_completed(testCaseName, test, test1);
	}
}
