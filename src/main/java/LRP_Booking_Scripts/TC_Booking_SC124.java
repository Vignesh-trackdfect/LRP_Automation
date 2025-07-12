package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC124  extends Keywords{
	public void Booking_SC124(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		// Values are taken from data sheet

		String test_Case_Name01 = "TC_Booking_SC124";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String Search1 = Excel_data.get("Search1");
		String agencyUser = Excel_data.get("AgencyUser");
		String allAgencySearch = Excel_data.get("allAgencySearch");
		String pluginID = Excel_data.get("pluginID");
		String Remarkspopexp = Excel_data.get("Remarkspopexp");
		String Moduleidinput = Excel_data.get("Module_id");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition1");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");

		Extent_Start(test_Case_Name01, test, test1);


		//Open Url
		navigateUrl(driver, url);

		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//Switch profile
		SwitchProfile(driver, agencyUser);


		// searching the module of booking

		moduleNavigate(driver, Search1);
		Extent_pass_New(driver, "*** changing the plugin*", test,test1);
		waitForElement(driver, pluginConfiguration_Tab);
	
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, Moduleid);
		sendKeys(driver, Moduleid, Moduleidinput);

		doubleClick(driver, first_PluginID_Row2);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);


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

		// searching the module of booking

		moduleNavigate(driver, Search);

		// searching contract number in global search 
		Step_Start(1, "Retrive the booking",test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
	
		Step_End(1, "Retrive the booking ",test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_Start(2, "click on cancelle button",test, test1);
		waitForElement(driver, Cancelled_BTN);
		safeclick(driver, Cancelled_BTN);
		Step_End(2, "click on cancelle button",test, test1);
		Step_Start(3, "Click on save button",test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		Step_End(3, "Click on save button",test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);

		waitForElement(driver, CancelledremarksOK);
		safeclick(driver, CancelledremarksOK);
		Step_Start(4, "System shown Booking Cancell Reason",test, test1);
		waitForPopup(driver, popup_Message,Remarkspopexp);
		String cancelledpop=getText(driver, popup_Message);
		System.out.println(cancelledpop);
		//
		if(Remarkspopexp.equals(cancelledpop)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity popup shown is : " + Remarkspopexp + " || Actual Report Activity popup shown is : " + cancelledpop);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup shown is : " + Remarkspopexp + " || Actual Report Activity  popup shown is : " + cancelledpop, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity popup shown is : " + Remarkspopexp + " || Actual Report Activity popup shown  is : " + cancelledpop);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity  popup shown is : " + Remarkspopexp + " || Actual Report Activity  popup shown is : " + cancelledpop, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
		Step_End(4, "System shown Booking Cancell Reason",test, test1);


		waitForElement(driver, remarkscanclebutton);
		safeclick(driver, remarkscanclebutton);

		waitForElement(driver, cancel_Common_btn);
		safeclick(driver, cancel_Common_btn);
	newButton(driver);

		Extent_completed(test_Case_Name01, test, test1);


	}	

}

