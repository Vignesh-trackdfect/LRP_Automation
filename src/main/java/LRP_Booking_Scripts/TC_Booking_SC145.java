package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


//Check whetherin Booking, based on the BBP plugin configuration system retain the BP customer.
public class TC_Booking_SC145 extends Keywords {

	public void Booking_SC145(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Booking_SC145";

		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String first_service_data = Excel_data.get("first_service_data");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String rate_no = Excel_data.get("rate_no");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String Clear_Reset_Popup = Excel_data.get("Clear_Reset_Popup");
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String pluginID = Excel_data.get("pluginID");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String Clear_Agr_Party = Excel_data.get("Clear_Agr_Party");
		String Reset = Excel_data.get("Reset");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String Dstatus = Excel_data.get("Draftstatus");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String globalSearchFilterOption1=Excel_data.get("GlobalSearchFilterOption1");
		String globalSearchFilterOption2=Excel_data.get("GlobalSearchFilterOption2");
		String globalSearchFilterOption3=Excel_data.get("GlobalSearchFilterOption3");
		String searchValue2=Excel_data.get("searchValue2");
		String searchValue3=Excel_data.get("searchValue3");
		

navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		String Reset_Value = String.format(resetValue, Reset);
	
		
// Login
		LRP_Login(driver, Username, Password);

//	Switch the Profile
		SwitchProfile(driver, AgencyUser);
		

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, Search);
		

		Step_Start(1, "Enter the Agreement Party", test, test1);
		
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party", test, test1);

		Step_Start(2, "Enter the POL and POD ", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		Step_End(2, "Enter the POL and POD", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
		
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Step_End(4, "Select the Schedule ", test, test1);

		Step_Start(5, "save the booking in Draft", test, test1);
		
		waitForElement(driver, booking_status_field);
		String booking_status =String.format(booking_Status_Button, Dstatus);
		waitForElement(driver, booking_status);
		click(driver, booking_status);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
	
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verification of saved popup of draft
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
		waitForElement(driver, booking_no);

		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		if(!booknum.equals("")) {
			System.out.println("Generated Booking number is " + booknum);
			Extent_pass_New(driver, "Generated Booking number is " + booknum, test, test1);
		}
		Step_End(5, "save the booking in Draft", test, test1);

		Extent_cal(test, test1, "Verify AP and BP is displayed before givin plugin configuration BBP as true");
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);

		
		waitForElement(driver, BP_Customer);

		if (isDisplayed(driver, BP_Customer)) {
			
			System.out.println("*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is :Before Reseting the AP, BP  is displayed");            
			Extent_pass_New(driver,"*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is : Before Reseting the AP, BP  is displayed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is : Before Reseting the AP, BP  is not displayed");        
			Extent_fail(driver, "*The Expected Result is : Before Reseting the AP, BP  is displayed || The Actual Result is : Before Reseting the AP, BP  is not displayed", test,test1); 
		} 
			

		waitForElement(driver, AP_Customer);
		if (isDisplayed(driver, AP_Customer)) {
			System.out.println("*The Expected Result is : Before Reseting the AP, AP is displayed || The Actual Result is :Before Reseting the AP, AP  is displayed");            
			Extent_pass_New(driver,"*The Expected Result is : Before Reseting the AP, AP  is displayed || The Actual Result is : Before Reseting the AP, AP  is displayed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Before Reseting the AP, AP  is displayed || The Actual Result is : Before Reseting the AP, AP  is not displayed");        
			Extent_fail(driver, "*The Expected Result is : Before Reseting the AP, AP  is displayed || The Actual Result is : Before Reseting the AP, AP  is not displayed", test,test1); 
		} 
		
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_Start(6, "set BBP plugin true", test, test1);
		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, pluginConfigurationModule);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		
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
			
			String select_Status=String.format(pluginValue_Select, pluginStatusTrue);
			waitForElement(driver, select_Status);
			click(driver, select_Status);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		}
		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		
		Step_End(6, "set BBP plugin true", test, test1);
		Step_Start(7, "reset the AP system not retain the BP customer", test, test1);
		
		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, Search);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption1, booknum, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);


		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
	
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);
		waitForElement(driver, Master_ResetBtn);
		safeclick(driver, Master_ResetBtn);
		waitForElement(driver, Reset_Value);
		safeclick(driver, Reset_Value);
		
		waitForElement(driver, popup_Message);
		String value5 = getText(driver, popup_Message);
		if (value5.equals(Clear_Agr_Party)) {
			System.out
					.println("Matched || Expected value popup was : " + value5 + " || Actual value popup was : " + Clear_Agr_Party);
			Extent_pass_New(driver,
					"Matched || Expected value popup was : " + value5 + " || Actual value popup was : " + Clear_Agr_Party, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected value popup was : " + value5 + " || Actual value popup was : " + Clear_Agr_Party);
			Extent_fail(driver,
					"Not Matched || Expected value popup was : " + value5 + " || Actual value popup was : " + Clear_Agr_Party, test,
					test1);
		}
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		waitForPopup(driver, popup_Message,Clear_Reset_Popup);
		String Reset_Popup = getText(driver, popup_Message);
		System.out.println(Reset_Popup);
		if (Clear_Reset_Popup.equals(Reset_Popup)) {
			
			System.out.println("Matched || The Expected Pop-up Value is : " + Clear_Reset_Popup + " || The Actual Pop-up Value is : " + Reset_Popup);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + Clear_Reset_Popup + " || The Actual Pop-up Value is : " + Reset_Popup, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + Clear_Reset_Popup + " || But The Actual Pop-up Value is : " + Reset_Popup);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + Clear_Reset_Popup + " || But The Actual Pop-up Value is : " + Reset_Popup, test,test1); 
		} 


			

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		waitForDisplay(driver, BP_Customer);
		if (!isdisplayed(driver, BP_Customer)) {
			System.out.println("*The Expected Result is : After Reseting AP, both AP and BP  is removed|| The Actual Result is :After Reseting AP, both AP and BP  is removed");            
			Extent_pass_New(driver,"*The Expected Result is : After Reseting AP, both AP and BP  is removed || The Actual Result is : After Reseting AP, both AP and BP  is removed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : After Reseting AP, both AP and BP  is removed || The Actual Result is : After Reseting AP, both AP and BP  is not removed");        
			Extent_fail(driver, "*The Expected Result is : After Reseting AP, both AP and BP  is removed || The Actual Result is : After Reseting AP, both AP and BP  is not removed", test,test1); 
		} 
		
			
		
		Step_End(7, "reset the AP system not retain the BP customer", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}