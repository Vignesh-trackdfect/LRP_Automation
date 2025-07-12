package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC129 extends Keywords {


	/////Check whether in booking,based on P6 PLUGIN Configuration Commodity mandatory for all containers during booking confirmation

	public void Booking_SC129(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC129";

		//		Get data from excel sheet


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String bookingModule = Excel_data.get("Module_Search");
		String agencyUser = Excel_data.get("agencyUser");
		String agr_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginEnableStatus = Excel_data.get("PluginEnableStatus");		
		String pluginEnableStatus1 = Excel_data.get("PluginEnableStatus1");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String containerRows = Excel_data.get("ContainerRows");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");


		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		
		// Login
		LRP_Login(driver, Username, Password);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);

		//Plugin Configuration module

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, pluginConfigurationModule);
		
		Extent_cal(test, test1, pluginConfigurationModule);

		Step_Start(1, "Set P6 plugin True", test, test1);		

		// P6 Plugin Configuration True

		waitForElement(driver, pluginConfiguration_Tab);
		

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, BKGmoduleIdFilter_Searchbox);
		sendKeys(driver, BKGmoduleIdFilter_Searchbox, moduleID);

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
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}

		Step_End(1, "Set P6 plugin True", test, test1);			

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, bookingModule);
		
		//		Booking module
		Extent_cal(test, test1, bookingModule);
		Step_Start(2, "Enter The Agreement Party", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, agr_party);
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
		
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);

		Step_End(4, "Select the Routing & Select the Schedule", test, test1);
		Step_Start(5, " Save The Booking in Draft ", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Booking Saved In Book Agency || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_pass_New(driver, "Matched || Booking Saved In Book Agency || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_fail(driver, "Not Matched || Booking Not Saved In Book Agency || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
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

		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		if(!booknum.equals("")) {
			System.out.println("Generated Booking number is " + booknum);
			Extent_call(test, test1, "Generated Booking number is " + booknum);
	
		}

		Step_End(5, " Save The Booking in Draft ", test, test1);

		Step_Start(6, "Create Copies of the container", test, test1);

		//	Container tab

		waitForElement(driver, container_Tab);
		click(driver, container_Tab);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, Edit_Button_toolBar);

		scrollBottom(driver);
		waitForElement(driver, select_Container);
		click(driver, select_Container);
		waitForElement(driver, select_Container);
		RightClick(driver, select_Container);

		waitForElement(driver, Container_copy);
		click(driver, Container_copy);

		waitForDisplay(driver, containerCopy_Frame);
		if(isDisplayed(driver, containerCopy_Frame)) {
			sendKeys(driver, enterTheRows_Textfield, containerRows);
			waitForElement(driver, copyOk_Button);
			click(driver, copyOk_Button);

		}
		Step_End(6, "Create Copies of the container", test, test1);
		Step_Start(7, "Remove copied container's commodity ", test, test1);
		// Commodity Tab

		waitForElement(driver, commodity_tab);
		click(driver, commodity_tab);

		scrollBottom(driver);

		int noOfComm=Integer.parseInt(containerRows);
		for(int i=noOfComm+1; i>1;i--) {

			String commodity_Select=String.format(commodity, i);
			waitForElement(driver, commodity_Select);
			click(driver,commodity_Select);

			waitForElement(driver, commidityRemove_Button);
			click(driver, commidityRemove_Button);

		}
		Step_End(7, "Remove copied container's commodity ", test, test1);
		Step_Start(8, "Auto Rate charges", test, test1);
		//	Auto rate the charge
		waitForElement(driver, Charges_tab);
		scrollTop(driver);
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);
		waitForElement(driver, AutoRated);


		Step_End(8, "Auto Rate charges", test, test1);
		Step_Start(9, "Confirm the draft", test, test1);

		//		Draft to Confirmed & Save
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		//	Verify booking Updated popup

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
		Step_End(9, "Confirm the draft", test, test1);

		// P6 Plugin Configuration False

		Extent_cal(test, test1, pluginConfigurationModule);

		Extent_call(test, test1, "plugin value set as default");
		waitForElement(driver, pluginConfiguration_Tab);
		click(driver, pluginConfiguration_Tab);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, BKGmoduleIdFilter_Searchbox);
		sendKeys(driver, BKGmoduleIdFilter_Searchbox, moduleID);

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

			String select_Status=String.format(pluginValue_Select, pluginEnableStatus1);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);
		}

		Extent_completed(testCaseName, test, test1);

	}
}
