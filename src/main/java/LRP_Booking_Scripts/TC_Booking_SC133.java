package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;
//Check whether in booking, based on BVA and VST plugin configuration if vessel allocation not done system not allow to save the booking VSA true system check port allocation otherwise system agency allocation
public class TC_Booking_SC133 extends Keywords {

	public void Booking_SC133(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String test_Case_Name = "TC_Booking_SC133";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String first_service_data = Excel_data.get("first_service_data");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String rate_no = Excel_data.get("rate_no");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("pluginID");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String pluginStatusFalse = Excel_data.get("pluginStatusFalse");
		String PluginID1 = Excel_data.get("PluginID1");
		String GlobalValue = Excel_data.get("GlobalValue");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String Allocation_Popup = Excel_data.get("Allocation_Popup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String GlobalValue1 = Excel_data.get("GlobalValue1");
		
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
		String PluginTrue =  String.format(Plugin_Configuration_Locators.PluginTrue,  pluginStatusTrue); 
		String PluginFalse =  String.format(Plugin_Configuration_Locators.PluginFalse,  pluginStatusFalse); 


		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");
		
		
          Step_Start(1, "Set VSA ,VST plugin True", test, test1);
		
		moduleNavigate(driver, pluginConfigurationModule);
		
	
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		
		waitForElement(driver, first_Plugin_Row);
		click(driver, first_Plugin_Row);
		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		
		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginTrue);
		safeclick(driver, PluginTrue);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);


		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		Step_End(1, "Set VSA ,VST plugin True", test, test1);

		Step_Start(2, "Set BVS Global Value 2", test, test1);

		
	setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
		
	
		
		Step_End(2, "Set BVS Global Value 2", test, test1);

		Step_Start(3, "Open Booking Module", test, test1);
		
		moduleNavigate(driver, BookingMoudleSearch);
		
		Step_End(3, "Open Booking Module", test, test1);

		
		Step_Start(4, "Enter The Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
       Step_End(4, "Enter The Agreement Party", test, test1);
		
       Step_Start(5, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Extent_call(test, test1, "*****Enter Origin*****");
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);
		System.out.println("Origin:" + orgin);
		Extent_call(test, test1, "*****Enter Delivery*****");

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		System.out.println("delivery:" + delivery);
		if (!SCAC_Code_Value.equals("")) {
			waitForElement(driver, SCAC_code_TF);
			sendKeys(driver, SCAC_code_TF, SCAC_Code_Value);
		}

		if (!Priority_Value.equals("")) {
			safeclick(driver, Priority);
		}
		if (!Agency_RefNo_Value.equals("")) {
			waitForElement(driver, Agency_RefNo_TF);
			sendKeys(driver, Agency_RefNo_TF, Agency_RefNo_Value);
		}
		if (!TOS_Value.equals("")) {
			safeclick(driver, TOS);
			if (Checkbox_Select_3PL.equals("YES")) {
				checkBox(driver, CheckBox_3PL, Checkbox_Select_3PL);
				waitForElement(driver, Operator_Code_3PL_searchBtn);
				safeclick(driver, Operator_Code_3PL_searchBtn);
				waitForElement(driver, Operator_Code_TF);
				sendKeys(driver, Operator_Code_TF, Operator_Code_value);
				waitForElement(driver, Code_Val);
				safeclick(driver, Code_Val);
				waitForElement(driver, Popup_selectBtn);
				safeclick(driver, Popup_selectBtn);
			}
		}
	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		
		if(isdisplayed(driver, popup_Message)){
			click(driver, popup_Message_Ok_Button);
		}
		
			editSchedule(driver, first_service_data);
			selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		
		
	
		
		
		Step_End(5, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Step_Start(6, "Save the booking in Draft", test, test1);
		

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		//Verify Booking Saved pop up
		
		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		String booknum = getAttribute(driver, Booking_No_Field, "value");
		System.out.println(booknum);
		
		Step_End(6, "Save the booking in Draft", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		//		charges tab		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		//			Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);

		Step_Start(7, "system check capacity Allocation for Port Allocation", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		// verify the pop up for booking saved

		waitForPopup(driver, popup_Message,Allocation_Popup);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		click(driver, popup_Message_Ok_Button);

		
		if (savepopACT.contains(Allocation_Popup)) {
			Extent_pass_New(driver, "Matched || Expected popup: "+ Allocation_Popup +"|| Actual Popup:"+ savepopACT , test,test1);
			System.out.println("Matched || Expected popup: "+ Allocation_Popup +"|| Actual Popup:"+ savepopACT);
		}else {
			System.out.println("Not Matched || Expected popup: "+ Allocation_Popup +"|| Actual Popup:"+ savepopACT);
			Extent_fail(driver, "Not Matched || Expected popup: "+ Allocation_Popup +"|| Actual Popup:"+ savepopACT , test,test1);
		}
		
		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);

       Step_End(7, "system check capacity Allocation for Port Allocation", test, test1);

       Step_Start(8, "Global configuration set as default", test, test1);
       
       
		moduleNavigate(driver, pluginConfigurationModule);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		click(driver, first_Plugin_Row);
		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		
		
		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginFalse);
		safeclick(driver, PluginFalse);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID1);

		waitForElement(driver, first_Plugin_Row);
		click(driver, first_Plugin_Row);
		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginFalse);
		safeclick(driver, PluginFalse);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		
		
		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);

		Step_End(8, "Global configuration set as default", test, test1);
		
		Step_Start(9, "Set VSA,VST plugin False", test, test1);
		
		
	setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue1);
		

       Step_End(9, "Set VSA,VST plugin False", test, test1);
		
		Extent_completed(test_Case_Name, test, test1);
	}
}


