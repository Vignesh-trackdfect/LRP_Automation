package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Plugin_Configuration_Locators;

public class TC_Booking_SC130 extends Keywords {

	public void Booking_SC130(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC130";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String orgin = Excel_data.get("orgin");
		String delivery = Excel_data.get("delivery");
		String DG_CheckBox_Button = Excel_data.get("DG_CheckBox_Button");
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("pluginID");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String DG_Input = Excel_data.get("DG_Input");
		String pluginStatusFalse = Excel_data.get("pluginStatusFalse");
		String Header_scroll_number = Excel_data.get("Header_scroll_number");

		String PluginTrue =  String.format(Plugin_Configuration_Locators.PluginTrue,  pluginStatusTrue); 
		String PluginFalse =  String.format(Plugin_Configuration_Locators.PluginFalse,  pluginStatusFalse); 

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");

		Extent_call(test, test1, "********** Enter Booking Module **********");
		moduleNavigate(driver, pluginConfigurationModule);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		enter(driver);
		
		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		click(driver, enable_Status_Dropdown);

		waitForElement(driver, PluginFalse);
		safeclick(driver, PluginFalse);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, BookingMoudleSearch);
		
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

		waitForElement(driver, RatedBtn);
		safeclick(driver, RatedBtn);
		waitForElement(driver, $Rates);
		safeclick(driver, $Rates);

		waitForElement(driver, rate_reference_tab);
		if (isDisplayed(driver, rate_reference_tab)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed");        
			Extent_fail(driver, "*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed", test,test1); 
		
		}

		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);
		waitForElement(driver, rateref_cond_filter);
		click(driver, rateref_cond_filter);
		int Header_number = Integer.parseInt(Header_scroll_number);
		horizontalscroll(driver, ratesWindow_Horizontal_Scrollbar, Header_number);
		waitForElement(driver, DG_Column_Field);
		sendKeys(driver, DG_Column_Field, DG_Input);
		if (!isDisplayed(driver, UNNO_Column)) {
			
			System.out.println("*The Expected Result is :UNNO column is not displayed when RDG plugin configuration is False|| The Actual Result is : UNNO column is not displayed when RDG plugin configuration is False");            
			Extent_pass_New(driver,"*The Expected Result is : UNNO column is not displayed when RDG plugin configuration is False || The Actual Result is : UNNO column is not displayed when RDG plugin configuration is False", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : UNNO column is not displayed when RDG plugin configuration is False || The Actual Result is : UNNO column is  displayed when RDG plugin configuration is False");        
			Extent_fail(driver, "*The Expected Result is : UNNO column is not displayed when RDG plugin configuration is False || The Actual Result is : UNNO column is  displayed when RDG plugin configuration is False", test,test1); 
		
		}
		
		
	
		
		if (!isDisplayed(driver, IMDG_Name_column)) {
			
			System.out.println("*The Expected Result is :IMDG column is not displayed when RDG plugin configuration is False|| The Actual Result is : IMDG column is not displayed when RDG plugin configuration is False");            
			Extent_pass_New(driver,"*The Expected Result is : IMDG column is not displayed when RDG plugin configuration is False || The Actual Result is : IMDG column is not displayed when RDG plugin configuration is False", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : IMDG column is not displayed when RDG plugin configuration is False || The Actual Result is : IMDG column is  displayed when RDG plugin configuration is False");        
			Extent_fail(driver, "*The Expected Result is : IMDG column is not displayed when RDG plugin configuration is False || The Actual Result is : IMDG column is  displayed when RDG plugin configuration is False", test,test1); 
		
		}
		
		
		waitForElement(driver, Rate_Ref_Close_Btn);
		click(driver, Rate_Ref_Close_Btn);
		
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_Start(2, "Set RDG plugin TRUE", test, test1);
		
		moduleNavigate(driver, pluginConfigurationModule);

		waitForElement(driver, pluginConfiguration_Tab);
	

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		enter(driver);

		waitForElement(driver, first_Plugin_Row);
		String actualPluginID = getText(driver, first_Plugin_Row);
		if (actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID + " plugin ID is available", test, test1);
			System.out.println(pluginID + " plugin ID is available");
		}
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		click(driver, enable_Status_Dropdown);


		waitForElement(driver, PluginTrue);
		safeclick(driver, PluginTrue);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, close_first_Tab);
		click(driver, close_first_Tab);
		Step_End(2, "Set RDG plugin TRUE", test, test1);

		moduleNavigate(driver, BookingMoudleSearch);

		Step_Start(3, "Enter the POL and POD and select the  Rates using Rates window", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		waitForElement(driver, RatedBtn);
		click(driver, RatedBtn);
		waitForElement(driver, $Rates);
		safeclick(driver, $Rates);

		waitForElement(driver, rate_reference_tab);
		if (isDisplayed(driver, rate_reference_tab)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed");        
			Extent_fail(driver, "*The Expected Result is : The Rate Lists Should be Show || The Actual Result is : The Rate Lists are Not Showed", test,test1); 
		
		}
		Step_End(3, "Enter the POL and POD and select the  Rates using Rates window", test, test1);
		Step_Start(4, "System display DG Details in Rate Reference window", test, test1);

		waitForElement(driver, DG_CheckBox);
		checkBox(driver, DG_CheckBox, DG_CheckBox_Button);
		waitForElement(driver, rate_showbtn);
		click(driver, rate_showbtn);

		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);
		waitForElement(driver, rateref_cond_filter);
		click(driver, rateref_cond_filter);
		int Header_number1 = Integer.parseInt(Header_scroll_number);
		horizontalscroll(driver, ratesWindow_Horizontal_Scrollbar, Header_number1);
		waitForElement(driver, DG_Column_Field);
		sendKeys(driver, DG_Column_Field, DG_Input);
		if (isDisplayed(driver, UNNO_Column)) {
			System.out.println("*The Expected Result is : UNNO column is  displayed when RDG plugin configuration should be True || The Actual Result is : UNNO column is  displayed when RDG plugin configuration is True");            
			Extent_pass_New(driver,"*The Expected Result is : UNNO column is  displayed when RDG plugin configuration should be True || The Actual Result is : UNNO column is  displayed when RDG plugin configuration is True", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : UNNO column is  displayed when RDG plugin configuration should be True || The Actual Result is : UNNO column is  displayed when RDG plugin configuration is not True");        
			Extent_fail(driver, "*The Expected Result is : UNNO column is  displayed when RDG plugin configuration should be True || The Actual Result is : UNNO column is  displayed when RDG plugin configuration is not True", test,test1); 
		
		}
		

		if (isDisplayed(driver, IMDG_Name_column)) {
			System.out.println("*The Expected Result is : IMDG column is  displayed when RDG plugin configuration should be True || The Actual Result is : IMDG column is  displayed when RDG plugin configuration is True");            
			Extent_pass_New(driver,"*The Expected Result is : IMDG column is  displayed when RDG plugin configuration should be True || The Actual Result is : IMDG column is  displayed when RDG plugin configuration is True", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : IMDG column is  displayed when RDG plugin configuration should be True || The Actual Result is : IMDG column is  displayed when RDG plugin configuration is not True");        
			Extent_fail(driver, "*The Expected Result is : IMDG column is  displayed when RDG plugin configuration should be True || The Actual Result is : IMDG column is  displayed when RDG plugin configuration is not True", test,test1); 
		
		}
		

		waitForElement(driver, Rate_Ref_Close_Btn);
		click(driver, Rate_Ref_Close_Btn);
		Step_End(4, "System display DG Details in Rate Reference window", test, test1);

		Extent_completed(test_Case_Name, test, test1);

	}
}