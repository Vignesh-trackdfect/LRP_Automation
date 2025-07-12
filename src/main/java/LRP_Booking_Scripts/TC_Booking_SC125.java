package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC125  extends Keywords{
	public void Booking_SC125(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String test_Case_Name01 = "TC_Booking_SC125";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String Search1 = Excel_data.get("Search1");
		String agencyUser = Excel_data.get("agencyUser");
		String allAgencySearch = Excel_data.get("allAgencySearch");
		String pluginID = Excel_data.get("pluginID");
		String Search2 = Excel_data.get("Search2");
		String Moduleidinput = Excel_data.get("Moduleidinput");
		String Cancel_Reason = Excel_data.get("Cancel_Reason");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition1");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");
		String Cancelselect =  String.format(Booking_Locators.remarks_reasonn,Cancel_Reason);



		Extent_Start(test_Case_Name01, test, test1);


		//Open Url
		navigateUrl(driver, url);

		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//Switch profile
		SwitchProfile(driver, agencyUser);

		Step_Start(1, "Navigate plugin configration as true in BCR ",test, test1);
		// searching the module of booking
		moduleNavigate(driver, Search1);
		waitForElement(driver, pluginConfiguration_Tab);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, Moduleid);
		sendKeys(driver, Moduleid, Moduleidinput);
		doubleClick(driver, first_PluginID_Row2);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForDisplay(driver, Truedisplay);
		if(isDisplayed(driver, Truedisplay)) {
			String status = getText(driver, truegettext);
			System.out.println("enable status shown as"+status);
			Extent_pass_New(driver, "enable status shown as"+status, test,test1);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

		}else {

			waitForElement(driver, truegettext);
			safeclick(driver, truegettext);

			waitForElement(driver, True_Condition);
			safeclick(driver, True_Condition);

			String status = getText(driver, truegettext);
			System.out.println(status);
			Extent_pass_New(driver, "enable status shown as"+status, test,test1);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
		}
		Step_End(1, "Navigate plugin configration as true in BCR ",test, test1);
		// searching the module of booking

		moduleNavigate(driver, Search);

		// searching contract number in global search 
		Step_Start(2, "Retrive the booking",test, test1);
waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
		
		Step_End(2, "Retrive the booking ",test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_Start(3, "Click on cancelled button",test, test1);
		waitForElement(driver, Cancelled_BTN);
		safeclick(driver, Cancelled_BTN);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		
		Step_End(3, "Click on cancelled button",test, test1);
		waitForElement(driver, Bookcalclereason);
		Step_Start(4, "select the cancelled reason",test, test1);
		safeclick(driver, Bookcalclereason);
		mouseOverToElement(driver, Cancelselect);
		waitForElement(driver, Cancelselect);
		safeclick(driver, Cancelselect);
		Extent_pass_New(driver, "***reason was selected for cancell***"+Cancelselect, test, test1);
		waitForElement(driver, remarkscanclebutton);
		safeclick(driver, remarkscanclebutton);
		Step_End(4, "select the cancelled reason",test, test1);
		Step_Start(5, "Check whether the reason is present in cancell reason tab",test, test1);
		moduleNavigate(driver, Search2);


		waitForElement(driver, Bookcalclereasoninput);
		sendKeys(driver, Bookcalclereasoninput, Cancel_Reason);
		String Cancelselect1 =  String.format(Booking_Locators.Surcharge_number_selectt,Cancel_Reason);
		waitForDisplay(driver, Cancelselect1);

		if(isDisplayed(driver, Cancelselect1)) {
			
			System.out.println("Matched || " + " Expected Cancel reason was listed in the Booking cancel Reason module : " + Cancel_Reason + " || Actual Cancel reason was listed in the Booking cancel Reason module: " + Cancel_Reason);            
			Extent_pass_New(driver, "Matched || " + " Expected Cancel reason was listed in the Booking cancel Reason module: " + Cancel_Reason + " || Actual Cancel reason was listed in the Booking cancel Reason module: " + Cancel_Reason, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Cancel reason was listed in the Booking cancel Reason module : " + Cancel_Reason + " || Actual Cancel reason was not listed in the Booking cancel Reason module : " + Cancel_Reason);        
			Extent_fail(driver, "Not Matched || " + " Expected Cancel reason was listed in the Booking cancel Reason module : " + Cancel_Reason + " || Actual Cancel reason was not listed in the Booking cancel Reason module: " + Cancel_Reason, test,test1); 
		} 
		
		
		
		Step_End(5, "Check whether the reason is present in cancell reason tab",test, test1);
		Extent_completed(test_Case_Name01, test, test1);
	}	

}
