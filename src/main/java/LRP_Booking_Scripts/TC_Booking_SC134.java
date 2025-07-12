package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;
//Check whether in booking, based on BVA and VST plugin configuration if vessel allocation not done system not allow to save the booking VSA true system check port allocation otherwise system agency allocation
public class TC_Booking_SC134 extends Keywords {

	public void Booking_SC134(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String test_Case_Name = "TC_Booking_SC134";
		
		
		
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
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String PluginID_BVA = Excel_data.get("PluginID_BVA");
		String PluginEnableStatusTrue = Excel_data.get("PluginEnableStatusTrue");
		String moduleID = Excel_data.get("ModuleID");
		String pluginEnableStatus = Excel_data.get("PluginEnableStatus");
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String globalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String globalAttribute = Excel_data.get("GlobalAttribute");
		String globalValue = Excel_data.get("GlobalValue");
		String Confirmedstatus = Excel_data.get("Confirmedstatus");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String  Capacity_Allocation_Module = Excel_data.get("Capacity_Allocation_Module");
		String  Capacity_Allocation_Header = Excel_data.get("Capacity_Allocation_Header");
		String  Capacity_Allocation_Condition = Excel_data.get("Capacity_Allocation_Condition");
		String  Capacity_Allocation_Value = Excel_data.get("Capacity_Allocation_Value");
        String  Capacity_Allocation_From_date= Excel_data.get("Capacity_Allocation_From_date");
        String  Capacity_Allocation_To_date= Excel_data.get("Capacity_Allocation_To_date");
        String  EXP_POPUP= Excel_data.get("EXP_POPUP");
		
		Extent_Start(test_Case_Name, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);

		navigateUrl(driver, url);

		Step_End(2, "Open the browser", test, test1);
		Step_End(1, "Enter the test URL", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);
		// Login
		LRP_Login(driver, Username, Password);

		Step_End(4, "Enter valid Username & Password in respective text fields", test, test1);
		Step_End(3, "Click on Login Button", test, test1);

		Step_Start(5, "Click on Switch profile button in home page", test, test1);
		Step_Start(6, "Enter Agency code in code search field & Click on Select button", test, test1);

//		Switch the Profile
		SwitchProfile(driver, agencyUser);

		Step_End(6, "Enter Agency code in code search field & Click on Select button", test, test1);
		Step_End(5, "Click on Switch profile button in home page", test, test1);

		Step_Start(7, "Enter \"Global Configuration\" in 'Search Module' Search search box & Select the module", test,
				test1);
setGlobalConfiguration(driver, globalConfigurationModule, globalAttribute, globalValue);
		moduleNavigate(driver, globalConfigurationModule);

		Step_End(7, "Enter \"Global Configuration\" in 'Search Module' Search search box & Select the module", test,
				test1);

//		waitForElement(driver, globalConfiguration_Tab);
//
//		waitForElement(driver, Filter_Menu);
//		click(driver, Filter_Menu);
//		waitForElement(driver, Condition_Filter_Button);
//		click(driver, Condition_Filter_Button);
//
//		Step_Start(8, "Click on Attribute filter & Select the \"BAV\" Attribute", test, test1);
//
//		waitForElement(driver, Attribute_Filter);
//		sendKeys(driver, Attribute_Filter, globalAttribute);
//
//		Step_End(8, "Click on Attribute filter & Select the \"BAV\" Attribute", test, test1);
//
//		Step_Start(9, "Click on Edit button & Change the value as \"2\"", test, test1);
//
//		waitForElement(driver, Global_FilterRow);
//		doubleClick(driver, Global_FilterRow);
//		waitForElement(driver, Edit_Button_toolBar);
//		click(driver, Edit_Button_toolBar);
//
//		Step_End(9, "Click on Edit button & Change the value as \"2\"", test, test1);
//
//		Step_Start(10, "Click on Save button", test, test1);
//
//		waitForElement(driver, valueTextfield);
//		clearAndType(driver, valueTextfield, globalValue);
//		
//		waitForElement(driver, SaveButton_ToolBar);
//		click(driver, SaveButton_ToolBar);
//
//		Step_End(10, "Click on Save button", test, test1);
//		
//		waitForElement(driver, Close_Current_tab);
//		click(driver, Close_Current_tab);
//		
		Step_Start(11, "Enter \"Plugin Configuration\" in 'Search Module' Search box & Select the module", test, test1);

		moduleNavigate(driver, pluginConfigurationModule);

		Step_End(11, "Enter \"Plugin Configuration\" in 'Search Module' Search box & Select the module", test, test1);

		Step_Start(12, "Verify the Plugin Configuration page should be displayed", test, test1);

		waitForElement(driver, pluginConfiguration_Tab);
		if (isDisplayed(driver, pluginConfiguration_Tab)) {
			System.out.println(
					"*The Expected Result is : Plugin Configuration page should be display  || The Actual Result is : Plugin Configuration page is displayed ");
			Extent_pass_New(driver,
					"*The Expected Result is : Plugin Configuration page should be display || The Actual Result is : Plugin Configuration page is displayed ",
					test, test1);
		} else {
			System.out.println(
					"*The Expected Result is : Plugin Configuration page should be display || The Actual Result is : Plugin Configuration page is not displayed");
			Extent_fail(driver,
					"*The Expected Result is : Plugin Configuration page should be display || The Actual Result is : Plugin Configuration page is not displayed",
					test, test1);

		}

		Step_End(12, "Verify the Plugin Configuration page should be displayed", test, test1);

		Step_Start(13, "Enter the Plugin ID (BVA) in Plugin ID search box", test, test1);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID_BVA);

		Step_End(13, "Enter the Plugin ID (BVA) in Plugin ID search box", test, test1);
		

		waitForElement(driver, BKGmoduleIdFilter_Searchbox);
		sendKeys(driver, BKGmoduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID_BAV = getText(driver, searched_pluginId);
		if (actualPluginID_BAV.equals(PluginID_BVA)) {
			Extent_pass_New(driver, PluginID_BVA + " plugin ID is available", test, test1);
			System.out.println(PluginID_BVA + " plugin ID is available");

			Step_Start(14, "Verify the Plugin ID & Double click on the Plugin ID in the grid", test, test1);	
			
			doubleClick(driver, searched_pluginId);
			
			Step_End(14, "Verify the Plugin ID & Double click on the Plugin ID in the grid", test, test1);	
			
			Step_Start(15, "Click on Edit button in toolbar", test, test1);	
			
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(15, "Click on Edit button in toolbar", test, test1);	
			
			Step_Start(16, "Click on condition dropdown & Select True condition", test, test1);	
			
			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			String select_Status = String.format(pluginValue_Select, PluginEnableStatusTrue);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			Step_End(16, "Click on condition dropdown & Select True condition", test, test1);	
			
			Step_Start(17, "Click on Save button in toolbar", test, test1);	
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(17, "Click on Save button in toolbar", test, test1);	
			
			// Verify Plugin Updated popup

			waitForPopup(driver, popup_Message, pluginUpdatedPopup);
			String actualUpdatedPopupTrue = getText(driver, popup_Message);
			System.out.println("actualUpdatedPopup:" + actualUpdatedPopupTrue);
			if (actualUpdatedPopupTrue.contains(pluginUpdatedPopup)) {
				System.out.println("Matched || Expected popup value is : " + pluginUpdatedPopup + "|| Actual Popup value is : "+ actualUpdatedPopupTrue);
				Extent_pass_New(driver, "Matched || Expected  popup value is : " + pluginUpdatedPopup + "|| Actual Popup value is : "+ actualUpdatedPopupTrue, test, test1);
			} else {
				System.out.println("Not Matched || Expected popup value is : " + pluginUpdatedPopup + "|| Actual Popup value is : "+ actualUpdatedPopupTrue);
				Extent_fail(driver, "Not Matched || Expected popup value is : " + pluginUpdatedPopup + "|| Actual Popup value is :"+ actualUpdatedPopupTrue, test, test1);
			}
		} else {
			System.out.println(pluginID + " plugin ID is unavailable");
			Extent_fail(driver, pluginID + " plugin ID is unavailable", test, test1);
		}
		
		
		Step_Start(18, "Enter the Plugin ID (VST) in Plugin ID search box for Port allocation", test, test1);	
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		
		waitForElement(driver, BKGmoduleIdFilter_Searchbox);
		sendKeys(driver, BKGmoduleIdFilter_Searchbox, moduleID);
		
		Step_End(18, "Enter the Plugin ID (VST) in Plugin ID search box for Port allocation", test, test1);
		
		waitForElement(driver, searched_pluginId);
		String actualPluginID = getText(driver, searched_pluginId);
		if (actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID + " plugin ID is available", test, test1);
			System.out.println(pluginID + " plugin ID is available");

			Step_Start(19, "Verify the Plugin ID & Double click on the Plugin ID in the grid", test, test1);	
			
			doubleClick(driver, searched_pluginId);
			
			Step_End(19, "Verify the Plugin ID & Double click on the Plugin ID in the grid", test, test1);	
				
			Step_Start(20, "Click on Edit button in toolbar", test, test1);	
			
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(20, "Click on Edit button in toolbar", test, test1);	
			
			Step_Start(21, "Click on condition dropdown & Select false condition", test, test1);	
			
			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			String select_Status = String.format(pluginValue_Select, pluginEnableStatus);
			waitForElement(driver, select_Status);
			click(driver, select_Status);

			Step_End(21, "Click on condition dropdown & Select false condition", test, test1);	
			
			Step_Start(22, "Click on Save button in toolbar", test, test1);	
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);


			// Verify Plugin Updated popup

			waitForPopup(driver, popup_Message, pluginUpdatedPopup);
			String actualUpdatedPopupTrue = getText(driver, popup_Message);
			System.out.println("actualUpdatedPopup:" + actualUpdatedPopupTrue);
			if (actualUpdatedPopupTrue.contains(pluginUpdatedPopup)) {
				System.out.println("Matched || Expected popup message is : " + pluginUpdatedPopup + "|| Actual Popup message is :"+ actualUpdatedPopupTrue);
				Extent_pass_New(driver, "Matched || Expected popup message is : " + pluginUpdatedPopup + "|| Actual Popup message is :"+ actualUpdatedPopupTrue, test, test1);
			} else {
				System.out.println("Not Matched || Expected popup message is : " + pluginUpdatedPopup + "|| Actual Popup message is :"+ actualUpdatedPopupTrue);
				Extent_fail(driver, "Not Matched || Expected popup message is : " + pluginUpdatedPopup + "|| Actual Popup message is :"+ actualUpdatedPopupTrue, test, test1);
			}
		} else {
			System.out.println(pluginID + " plugin ID is unavailable");
			Extent_fail(driver, pluginID + " plugin ID is unavailable", test, test1);
		}
		
		Step_End(22, "Click on Save button in toolbar", test, test1);		
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(23, "Enter \"Capacity allocation\" in 'Search Module' Search box & Select the module", test, test1);	
		

		moduleNavigate(driver, Capacity_Allocation_Module);
		
		Step_End(23, "Enter \"Capacity allocation\" in 'Search Module' Search box & Select the module", test, test1);	
		
		Step_Start(24, "Ender the service and date range", test, test1);	

		waitForElement(driver, CA_Service);
		click(driver, CA_Service);
		
		twoColumnSearchWindow(driver, Capacity_Allocation_Header, Capacity_Allocation_Condition, Capacity_Allocation_Value);
		
		waitForElement(driver, CA_From_Date);
        selectDatePicker(driver, CA_From_Date, Capacity_Allocation_From_date);
      
        waitForElement(driver, CA_To_Date);
        selectDatePicker(driver, CA_To_Date, Capacity_Allocation_To_date);
        
        Step_End(24, "Ender the service and date range", test, test1);
        
        Step_Start(25, "Click show button", test, test1);	
        
    	waitForElement(driver, CA_Show_Button);
		click(driver, CA_Show_Button);
		
		Step_End(25, "Click show button", test, test1);	
		
		Step_Start(26, "Check the agency allocation for the service.", test, test1);	
		
		waitForElement(driver, CA_Allocated_Last_option);
		click(driver, CA_Allocated_Last_option);
		
		
		
		waitForElement(driver, CA_Vessel_Name);
		doubleClick(driver, CA_Vessel_Name);
		
		
		waitForElement(driver, CA_Ports_Capacity);
		click(driver, CA_Ports_Capacity);
			
		waitForElement(driver, CA_SVM_Amount);
		String svm_amount =getText(driver, CA_SVM_Amount);
		System.out.println("svm_amount :"+svm_amount);
		
		waitForElement(driver, CA_SSL_Amount);
		String ssl_amount =getText(driver, CA_SSL_Amount);	
		System.out.println("ssl_amount :"+ssl_amount);
		
		waitForElement(driver, CA_SVM_Tues);
		String svm_Tens_va =getText(driver, CA_SVM_Tues);
		System.out.println("svm_Tens_va :"+svm_Tens_va);
		
		waitForElement(driver, CA_SSL_Tues);
		String ssl_Tens=getText(driver, CA_SSL_Tues);	
		System.out.println("ssl_Tens :"+ssl_Tens);
		
		double value1 =getNumberValue1(svm_amount);
		double value2 = getNumberValue1(ssl_amount);
		
		// Add the values
		double EXP_tens = value1 + value2;
		System.out.println("EXP_tens :"+EXP_tens);
		
		
		double value3 = getNumberValue1(ssl_Tens);
		double value4 = getNumberValue1(svm_Tens_va);
		
		// Add the values
		double EXP_w_value = value3 + value4;
		System.out.println("EXP_w_value :"+EXP_w_value);
		
		scrollTop(driver);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		
		Step_End(26, "Check the agency allocation for the service.", test, test1);	
		
		//Booking module
		  Step_Start(27, "Enter \"Booking\" in 'Search Module' Search box & Select the module", test, test1);	
 
	
//	
	
	moduleNavigate(driver, search_module);
	
	Step_End(27, "Enter \"Booking\" in 'Search Module' Search box & Select the module", test, test1);
	Extent_cal(test, test1,"Booking");
	
	 Step_Start(28, "Enter Origin in Origin search field & Click on tab button in keyboard", test, test1);
	
	
	waitForElement(driver, OrginInput);
	sendKeys(driver, OrginInput, origin);
	tab(driver);
	
	Step_End(28, "Enter Origin in Origin search field & Click on tab button in keyboard", test, test1);
	 
	Step_Start(29, "Enter Delivery in Delivery search field & Click on tab button in keyboard", test, test1); 

	waitForElement(driver, DeliveryInput);
	sendKeys(driver, DeliveryInput, delivery);
	tab(driver);
	
	Step_End(29, "Enter Delivery in Delivery search field & Click on tab button in keyboard", test, test1); 
	
	Step_Start(30, "Enter Agreement party in Agr party search field & Click on tab button in keyboard", test, test1); 
	waitForElement(driver, AgrPartyInput);
	sendKeys(driver, AgrPartyInput, arg_party);
	tab(driver);
	
	Step_End(30, "Enter Agreement party in Agr party search field & Click on tab button in keyboard", test, test1); 
	
	Step_Start(31, "Click on Rates dropdown & Click on Rates option in the menu", test, test1); 
	

//Rates 
	bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

	
	Step_Start(34, "Click cancel.", test, test1); 
	Step_Start(35, "Click cancel.", test, test1); 
	Step_Start(36, "If No Schedule popup displayed, Click on OK button.", test, test1); 
	waitForDisplay(driver, popup_Message);
	if(isdisplayed(driver, popup_Message)) {
		click(driver, popup_Message_Ok_Button);
	}
	editSchedule(driver, first_service_data);
	Step_End(36, "If No Schedule popup displayed, Click on OK button.", test, test1); 
	Step_End(35, "Click cancel.", test, test1); 
	Step_End(34, "Click cancel.", test, test1); 
	
	
	Step_Start(37, "Enter Service in Service search field", test, test1); 
	
	selectRatesRouting(driver,No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

	Step_End(37, "Enter Service in Service search field", test, test1);
	
	
	waitForElement(driver, booking_status_field);
	String conf_status =String.format(booking_Status_Button, Confirmedstatus);
	click(driver, conf_status);

	scrollTop(driver);
	waitForElement(driver, SaveButton_ToolBar);
	click1(driver, SaveButton_ToolBar);
	
	
	waitForElement(driver, popup_Message);
	click(driver, popup_Message_Ok_Button);

	
	Step_End(38, "Auto rate the charges", test, test1); 
	
	waitForElement(driver, BK_plus_Button);
	click(driver, BK_plus_Button);
	
	//		charges tab		
	waitForElement(driver, Charges_tab);
	click(driver, Charges_tab);

	waitForElement(driver, AutoRated);
	click(driver, AutoRated);
	
	
	Step_Start(39, "Click on save button.", test, test1); 
	
	scrollTop(driver);
	waitForElement(driver, SaveButton_ToolBar);
	click1(driver, SaveButton_ToolBar);
	
	Step_End(39, "Click on save button.", test, test1); 
		
	Step_Start(40, "Verify the popup Message.", test, test1); 
	
	waitForElement(driver, Booking_Vessel_Allocation_Table);
	List<Map<String, String>> allocated_details = getTableData(driver, Booking_Vessel_Allocation_Table,Booking_Vessel_Row_Vessel);
	
	
	String act_Tens =getValueByFirstColumnAndHeader(allocated_details, "Service", "NRSS", "Allocated Tues");
	double Actual_teus = getNumberValue1(act_Tens);
	 System.out.println("Actual_teus :"+Actual_teus);
  
    
    String act_amount =getValueByFirstColumnAndHeader(allocated_details, "Service", "NRSS", "Allocated Weight");
    double Actual_amount = getNumberValue1(act_amount);
    System.out.println("act_amount :"+act_amount);
    
    String act_status =getValueByFirstColumnAndHeader(allocated_details, "Service", "NRSS", "Status");
    System.out.println("act_status :"+act_status);
    
    
    if(EXP_tens==Actual_amount) {
    	
    	System.out.println("Matched || Expected : The Capacity Allocation module Voyage value is : "+EXP_tens +"|| Actual : The booking module Voyage value is same : "+Actual_amount);
    	Extent_pass_New(driver,"Matched || Expected : The Capacity Allocation module Voyage value is : "+EXP_tens +"|| Actual : The booking module Voyage value is same : "+Actual_amount, test,test1);     
    }else {
    	
    	System.out.println("Matched || Expected : The Capacity Allocation module Voyage value is : "+EXP_tens +"|| Actual : The booking module Voyage value is Not same : "+Actual_amount);
    	Extent_fail(driver,"Matched || Expected : The Capacity Allocation module Voyage value is : "+EXP_tens +"|| Actual : The booking module Voyage value is Not same : "+Actual_amount, test,test1);     
    }
    
     if(EXP_w_value==Actual_teus) {
    	
    	System.out.println("Matched || Expected : The Capacity Allocation module Bound value is : "+EXP_w_value +"|| Actual : The booking module Bound value is same : "+Actual_teus);
    	Extent_pass_New(driver,"Matched || Expected : The Capacity Allocation module Bound value is : "+EXP_w_value +"|| Actual : The booking module Bound value is same : "+Actual_teus, test,test1);     
    }else {
    	
    	System.out.println("Matched || Expected : The Capacity Allocation module Bound value is : "+EXP_w_value +"|| Actual : The booking module Bound value is Not same : "+Actual_teus);
    	Extent_fail(driver,"Matched || Expected : The Capacity Allocation module Bound value is : "+EXP_w_value +"|| Actual : The booking module Bound value is Not same : "+Actual_teus, test,test1);     
    }
	
     if (EXP_POPUP.contains(act_status)) {
			System.out.println("Matched || Expected popup message is : " + EXP_POPUP + "|| Actual Popup message is :"+ act_status);
			Extent_pass_New(driver, "Matched || Expected popup message is : " + EXP_POPUP + "|| Actual Popup message is:"+ act_status, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message is : " + EXP_POPUP + "|| Actual Popup message is :"+ act_status);
			Extent_fail(driver, "Not Matched || Expected popup message is : " + EXP_POPUP + "|| Actual Popup message is :"+ act_status, test, test1);
		}  
    
     Extent_completed(test_Case_Name, test, test1);
    

	
}
}


