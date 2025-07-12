package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC132 extends Keywords {


public void Booking_SC132 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
	
	String tc_Name="TC_Booking_SC132";

	
	
	
	

	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String agencyUser = Excel_data.get("agencyUser");
	String search_module = Excel_data.get("search_module");
	String arg_party = Excel_data.get("arg_party");
	String origin = Excel_data.get("origin");
	String delivery = Excel_data.get("delivery");
	String rate_no = Excel_data.get("rate_no");
	String first_service_data = Excel_data.get("first_service_data");
	String Voyagenumber1 = Excel_data.get("Voyagenumber1");
	String Boundinput = Excel_data.get("Boundinput");
	String search_moduleGC = Excel_data.get("search_moduleGC");
	String search_moduleFS = Excel_data.get("search_moduleFS");
	String globalValue1 = Excel_data.get("globalValue1");
	String globalValue2 = Excel_data.get("globalValue2");
	String globalValue3 = Excel_data.get("globalValue3");
	String attribute1 = Excel_data.get("attribute1");
	String attribute2 = Excel_data.get("attribute2");
	String attribute3 = Excel_data.get("attribute3");
	String service_code_value = Excel_data.get("service_code_value");
	String vessel_code_value = Excel_data.get("vessel_code_value");
	String feeder_voyage_value = Excel_data.get("feeder_voyage_value");
	String terminal_value = Excel_data.get("terminal_value");
	String Voyage = Excel_data.get("Voyage");
	String Bound = Excel_data.get("Bound");
	String service = Excel_data.get("service");
	String booking_draft_Color = Excel_data.get("booking_draft_Color");
	String terminal_value1 = Excel_data.get("terminal_value1");
	String globalValue2_Value = Excel_data.get("globalValue2_Value");
	String search_by_condition = Excel_data.get("search_by_condition");	
	String select_by_service_code = Excel_data.get("select_by_service_code");	
	String select_by_vesselcode = Excel_data.get("select_by_vesselcode");	
	String select_by_voyage = Excel_data.get("select_by_voyage");	
	String condition = Excel_data.get("condition");	
	String terminal_Search_Header = Excel_data.get("terminal_Search_Header");	
	String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
	
	//Locator	  
		
			Extent_Start(tc_Name, test, test1);
			
		  navigateUrl(driver, url);

		  LRP_Login(driver, Username, Password);
		  
			Extent_call(test, test1,"**Switch the Profile Start**");
			SwitchProfile(driver, agencyUser);
			// Global configuration
			Step_Start(1, "Set BTT Global Value Y ", test, test1);

			//Instead of clicking the first module dropdown , this method select the module name by using excel test data
			
			setGlobalConfiguration(driver, search_moduleGC, attribute1, globalValue1);
			setGlobalConfiguration(driver, search_moduleGC, attribute2, globalValue2);
			setGlobalConfiguration(driver, search_moduleGC, attribute3, globalValue3);
			

			Step_Start(4, "Change the terminal feeder", test, test1);

			//Instead of clicking the first module dropdown , this method select the module name by using excel test data
			moduleNavigate(driver, search_moduleFS);

			//1
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, search_by_condition, select_by_service_code, service_code_value, select_by_vesselcode, vessel_code_value, select_by_voyage, feeder_voyage_value);


			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, feeder_terminal_searchicon);
			click(driver, feeder_terminal_searchicon);
			
			twoColumnSearchWindow(driver, terminal_Search_Header, condition, terminal_value);
scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(4, "Change the terminal feeder", test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			moduleNavigate(driver, search_module);

			Step_Start(5, "Enter the Agr Party Input", test, test1);

			waitForElement(driver, AgrPartyInput);
			sendKeys(driver, AgrPartyInput, arg_party);
			tab(driver);

			Step_End(5, "Enter the Agr Party Input", test, test1);

			Step_Start(6, "Enter the Orgin and delivery", test, test1);
			waitForElement(driver, OrginInput);
			sendKeys(driver, OrginInput, origin);
			tab(driver);

			waitForElement(driver, DeliveryInput);
			sendKeys(driver, DeliveryInput, delivery);
			tab(driver);
			Step_End(6, "Enter the Orgin and delivery", test, test1);

			Step_Start(7, "Enter the Rates", test, test1);
		
			bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
			

			
			Step_End(9, "Enter the schedule details", test, test1);

			Step_Start(10, "system will not check valid  POD Terminal details", test, test1);

			waitForDisplay(driver, Popup_Message);
			if (!isDisplayed(driver, Popup_Message)) {
				
				
				System.out.println("*The Expected Result is : system Should check valid  POD Terminal details || The Actual Result is : system  check valid  POD Terminal details");            
				Extent_pass_New(driver,"*The Expected Result is : Tsystem Should check valid  POD Terminal details|| The Actual Result is : system  check valid  POD Terminal details", test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("*The Expected Result is : system Should check valid  POD Terminal details || The Actual Result is : system not check valid  POD Terminal details");        
				Extent_fail(driver, "*The Expected Result is : system Should check valid  POD Terminal details || The Actual Result is : system not check valid  POD Terminal details", test,test1); 
			
			}
				
			

			Step_End(10, "system will not check valid  POD Terminal details", test, test1);

			waitForElement(driver, Draft_Button);
			safeclick(driver, Draft_Button);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			waitForElement(driver, booking_no);
			String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
			String draft_bookingColor=getColorName(draft_bookingColorCode);
			
			if (draft_bookingColor.equals(booking_draft_Color)) {
				System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
				Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
			}else {                                                                                                                                                                   
				System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
				Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
			} 

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			//Instead of clicking the first module dropdown , this method select the module name by using excel test data
			moduleNavigate(driver, search_moduleFS);

			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, search_by_condition, select_by_service_code, service_code_value, select_by_vesselcode, vessel_code_value, select_by_voyage, feeder_voyage_value);


			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, feeder_terminal_searchicon);
			click(driver, feeder_terminal_searchicon);
			
			twoColumnSearchWindow(driver, terminal_Search_Header, condition, terminal_value1);


			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			
			setGlobalConfiguration(driver, search_moduleGC, attribute2, globalValue2_Value);
		
			

		
			Extent_completed(tc_Name, test, test1);
}
}