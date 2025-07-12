package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC085 extends Keywords {

	///// check whether Based on BWC plugin configuration false   same service,vessel,voyage and bound ,group call id and container number in work order created and  then  we use same combination in booking then system not validate

	public void Booking_SC085(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC085";


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
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginEnableStatus = Excel_data.get("PluginEnableStatus");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String workOrderCreationModule = Excel_data.get("WorkOrderCreationModule");
		String loadPort = Excel_data.get("LoadPort");
		String dischPort = Excel_data.get("DischPort");
		String vesselCode = Excel_data.get("VesselCode");
		String quantity = Excel_data.get("Quantity");		
		String workOrderSavedPopup = Excel_data.get("WorkOrderSavedPopup");
		String workOrderApprovedPopup = Excel_data.get("WorkOrderApprovedPopup");
		String actualContainer1 = Excel_data.get("ActualContainer1");
		String condition_Filter = Excel_data.get("condition_Filter");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String POL_Terminal_WOC = Excel_data.get("POL_Terminal_WOC");
		String POD_Terminal_WOC = Excel_data.get("POD_Terminal_WOC");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String vessel_Search_Header = Excel_data.get("vessel_Search_Header");
		String voy_Bound_Search_Header = Excel_data.get("voy_Bound_Search_Header");
		String voy_Bound = Excel_data.get("voy_Bound");
		String vendor_Search_Header = Excel_data.get("vendor_Search_Header");
		String iso_EqpType_Search_Header = Excel_data.get("iso_EqpType_Search_Header");
		String iso_EqpType = Excel_data.get("iso_EqpType");
		String POL_Terminal_Search_Header = Excel_data.get("POL_Terminal_Search_Header");
		String POD_Terminal_Search_Header = Excel_data.get("POD_Terminal_Search_Header");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);


		// Login
		LRP_Login(driver, Username, Password);

		//		Switch the Profile
		SwitchProfile(driver, agencyUser);


		//Plugin Configuration module

		Extent_cal(test, test1, pluginConfigurationModule);


		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, pluginConfigurationModule);
				
		// BWC Plugin Configuration False

		Step_Start(1, "Set BWC Plugin Configuration False", test, test1);


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

			formatLocatorClick(driver, pluginValue_Select, pluginEnableStatus);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			//   Verify Plugin Updated popup

			waitForPopup(driver, Popup_Message, actualPluginID);
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
		Step_End(1, "Set BWC Plugin Configuration False", test, test1);
//
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		
		//	Work Order Creation module
		Extent_cal(test, test1, workOrderCreationModule);
		Step_Start(2, "Create Work Order", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, workOrderCreationModule);
				
		//	Create Work Order

		waitForElement(driver, feederRadio_Button);
		click(driver, feederRadio_Button);

		waitForElement(driver, loadPort_Searchfield);
		sendKeys(driver, loadPort_Searchfield, loadPort);
		tab(driver);

		waitForElement(driver, dischPort_Searchfield);
		sendKeys(driver, dischPort_Searchfield, dischPort);
		tab(driver);

		waitForElement(driver, routing_Button);
		click(driver, routing_Button);

		waitForElement(driver, routingDetailsSearch_Frame);
		if(isDisplayed(driver, routingDetailsSearch_Frame)) {
			String actualText=getText(driver, routingDetailsSearch_Frame);
			Extent_pass_New(driver, actualText+" frame is Displayed", test,test1);
			System.out.println(actualText+" frame is Displayed");
			waitForElement(driver, service_Filter);

			sendKeys(driver, service_Filter, first_service_data);
			waitForElement(driver, select_FirstRouting);
			click(driver, select_FirstRouting);
			waitForDisplay(driver, servic_Search_Ok_Btn_WOC);
			click(driver, servic_Search_Ok_Btn_WOC);

		}

		waitForElement(driver, vesselSearch_Button);
		waitForElement(driver, vesselSearch_Button);
		click(driver, vesselSearch_Button);
		
		twoColumnSearchWindow(driver, vessel_Search_Header, condition_Filter, vesselCode);

		waitForElement(driver, voyageSearch_Button);
		click(driver, voyageSearch_Button);
		
		twoColumnMultipleSearchWindow(driver, voy_Bound_Search_Header, condition_Filter, voy_Bound);


		waitForElement(driver, polTerminal_SearchButton);
		click(driver, polTerminal_SearchButton);
		
		twoColumnSearchWindow(driver, POL_Terminal_Search_Header, condition_Filter, POL_Terminal_WOC);


		waitForElement(driver, podTerminal_SearchButton);
		click(driver, podTerminal_SearchButton);
		
		twoColumnSearchWindow(driver, POD_Terminal_Search_Header, condition_Filter, POD_Terminal_WOC);

		waitForElement(driver, vendor_SearchButton);
		click(driver, vendor_SearchButton);
		
		twoColumnSearchWindow(driver, vendor_Search_Header, condition_Filter, Vendor_Code);

		waitForElement(driver, eqpType_SearchButton);
		click(driver, eqpType_SearchButton);
		
		twoColumnMultipleSearchWindow(driver, iso_EqpType_Search_Header, condition_Filter, iso_EqpType);

		waitForElement(driver, quantity_Textfield);
		clearAndType(driver, quantity_Textfield, quantity);
		waitForElement(driver, plus_Icon);
		click(driver, plus_Icon);

		waitForElement(driver, container_WOC);
		click(driver, container_WOC);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message,workOrderSavedPopup);
		String actualSavedPopup=getText(driver, Popup_Message);
		System.out.println("actualSavedPopup;"+actualSavedPopup);
		if(actualSavedPopup.equals(workOrderSavedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup : "+ workOrderSavedPopup+ " || Actual popup :"+actualSavedPopup, test,test1);
			System.out.println("Matched || Expected popup : "+ workOrderSavedPopup+ " || Actual popup :"+actualSavedPopup);
		}else {
			System.out.println("Not Matched || Expected popup : "+ workOrderSavedPopup+ " || Actual popup :"+actualSavedPopup);
			Extent_fail(driver,"Not Matched || Expected popup : "+ workOrderSavedPopup+ " || Actual popup :"+actualSavedPopup, test,test1);
		}

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		//	Add actual containers
		Extent_call(test, test1, "Add Actual Containers");
		waitForElement(driver, container_WOC);
		click(driver, container_WOC);

		waitForElement(driver, containerGrid_Edit);
		click(driver, containerGrid_Edit);

		waitForElement(driver, smartImport_Button);
		click(driver,smartImport_Button);

		int i=Integer.parseInt(quantity);

		System.out.println("i="+i);
		int k=1;

		String actualEqpId=String.format(actualContainer_ID, 0);
		waitForElement(driver, actualEqpId);
		doubleClick(driver, actualEqpId);

		String actualEqpIdInput1=String.format(actualEqp_ID, 0);
		waitForElement(driver, actualEqpIdInput1);
		sendKeys(driver, actualEqpIdInput1, actualContainer1);



		for(int j=1;j<i;j++) {
			k++;
			String actualContainers = Excel_data.get("ActualContainer"+k);

			String actualEqpId1=String.format(actualContainer_ID, j);
			waitForElement(driver, actualEqpId1);
			doubleClick(driver, actualEqpId1);

			String actualEqpIdInput2=String.format(actualEqp_ID2, j,j);
			waitForElement(driver, actualEqpIdInput2);
			sendKeys(driver, actualEqpIdInput2, actualContainers);

		}

		waitForElement(driver, actualEqpId);
		click(driver,actualEqpId);

		waitForElement(driver, paste_Button);
		click(driver, paste_Button);

		waitForElement(driver, approved_RadioButton);
		click(driver, approved_RadioButton);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message,workOrderApprovedPopup);
		String actualApprovedPopup=getText(driver, Popup_Message);
		System.out.println("actualApprovedPopup;"+actualApprovedPopup);
		if(actualApprovedPopup.equals(workOrderApprovedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup : "+ workOrderApprovedPopup+ " || Actual popup :"+actualApprovedPopup, test,test1);
			System.out.println("Matched || Expected popup : "+ workOrderApprovedPopup+ " || Actual popup :"+actualApprovedPopup);
		}else {
			System.out.println("Not Matched || Expected popup : "+ workOrderApprovedPopup+ " || Actual popup :"+actualApprovedPopup);
			Extent_fail(driver,"Not Matched || Expected popup : "+ workOrderApprovedPopup+ " || Actual popup :"+actualApprovedPopup, test,test1);
		}

		Step_End(2, "Create Work Order", test, test1);

		// Module search

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, search_module);

		//		Booking module

		Extent_cal(test, test1, "Booking");

		Step_Start(3, " Enter The Agreement Party", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(3, " Enter The Agreement Party", test, test1);				
		Step_Start(4, "Enter the POL and POD and select the Rates using Rates window", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(6, "Select the Schedule ", test, test1);

		Step_Start(7, "Save the booking in Draft", test, test1);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Booking Saved In Book Agency || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_pass_New(driver, "Matched || Booking Saved In Book Agency || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_fail(driver, "Not Matched || Booking Not Saved In Book Agency || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
		}

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		
		if (draft_bookingColor.equals(booking_draft_Color)) {
			System.out.println("Matched || "+ " Expected Report Activity is[Booking number input field want to change yellow colour] : "+ booking_confirmed_Color+ " || Actual Report Activity is [Booking number input field  changed yellow colour] : "+ draft_bookingColor);
			Extent_pass_New(driver,"Matched || "+ " Expected Report Activity is[Booking number input field want to change yellow colour] : "+ booking_confirmed_Color+ " || Actual Report Activity is [Booking number input field  changed yellow colour] : "+ draft_bookingColor,test, test1);
		} else {
			System.out.println("Not Matched || "+ " Expected Report Activity is[Booking number input field not  changed to yellow colour] : "+ booking_draft_Color+ " || Actual Report Activity is[Booking number input field not changed to yellow colour] : "+ draft_bookingColor);
			Extent_fail(driver,"Not Matched || "+ " Expected Report Activity is[Booking number input field not  changed to yellow colour] : "+ booking_draft_Color+ " || Actual Report Activity is[Booking number input field not changed to yellow colour] : "+ draft_bookingColor,test, test1);
		}


		//		Master tab		

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

		Step_End(7, "Save the booking in Draft", test, test1);

		Step_Start(8, " AutoRate the charges in Charge tab", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		//	charges tab		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);
		Step_End(8, " AutoRate the charges in Charge tab", test, test1);
		Step_Start(9, "Select Confirm Button And Click Save Button(Confirm the Booking)", test, test1);

		//	Container tab

		waitForElement(driver, container_Tab);
		click(driver, container_Tab);

		waitForElement(driver, con_editicon);
		click(driver, con_editicon);

		waitForElement(driver, con_eqp_id);
		click(driver, con_eqp_id);
		waitForElement(driver, con_eqp_id);
		clearAndType(driver, con_eqp_id, actualContainer1);

		waitForElement(driver, con_add_btn);
		click(driver, con_add_btn);

		waitForElement(driver, con_add_btn);
		scrollTop(driver);


		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		//		Verify booking Updated popup

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup = getText(driver, popup_Message);
		if (actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup,test, test1);
		}


		//		Draft to Confirmed_Button & Save
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		//	Verify booking Updated popup

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup1 = getText(driver, popup_Message);
		if (actualUpdatedPopup1.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup1, test,test1);
			System.out.println("Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup1);
			Extent_fail(driver,"Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup1,test, test1);
		}

		//	Verify background color of confirmed booking number textfield
		waitForElement(driver, Booking_No_Field);
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String actualConfirmedColor=getColorName(actualConfirmedColorCode);

		if(actualConfirmedColor.equalsIgnoreCase(booking_confirmed_Color)) {
			Extent_pass_New(driver,"Matched || The background color of confirmed Booking number textfield is green|| Expected color :" +booking_confirmed_Color+" || Actual color :"+actualConfirmedColor, test,test1);
			System.out.println("Matched || The background color of confirmed Booking number textfield is green|| Expected color :" +booking_confirmed_Color+" || Actual color :"+actualConfirmedColor);
		}else {
			System.out.println("Not Matched || The background color of confirmed Booking number textfield is not green || Expected color :" +booking_confirmed_Color+" || Actual color :"+actualConfirmedColor);
			Extent_fail(driver,"Not Matched || The background color of confirmed Booking number textfield is not green || Expected color :" +booking_confirmed_Color+" || Actual color :"+actualConfirmedColor, test,test1);
		}
		Step_End(9, "Select Confirm Button And Click Save Button(Confirm the Booking)", test, test1);

		// BWC Plugin Configuration True

		Extent_cal(test, test1, "Plugin Configuration");
		Step_Start(10, "Set BWC Plugin Configuration True", test, test1);
		
		moduleNavigate(driver, pluginConfigurationModule);
		
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

			String select_Status=String.format(pluginValue_Select, pluginEnableStatus);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		}
		Step_End(10, "Set BWC Plugin Configuration True", test, test1);
		Extent_completed(testCaseName, test, test1);	


	}
}
