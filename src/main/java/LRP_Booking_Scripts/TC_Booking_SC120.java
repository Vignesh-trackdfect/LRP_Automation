package LRP_Booking_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC120  extends Keywords{
	public void Booking_SC120(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String test_Case_Name01 = "TC_Booking_SC120";

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
		String Reasonname = null;

		String Cancelselect =  String.format(Booking_Locators.remarks_reasonn,Cancel_Reason);

		Extent_Start(test_Case_Name01, test, test1);


		//Open Url
		navigateUrl(driver, url);

		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		//Switch profile
		SwitchProfile(driver, agencyUser);


		Step_Start(1, "Go to plugin configration ans make BCR as true",test, test1);
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
		Step_End(1, "Go to plugin configration ans make BCR as true",test, test1);
		Step_Start(2, "Retrive the booking and edit",test, test1);
		// searching the module of booking
		
		moduleNavigate(driver, Search);
		// searching contract number in global search 
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
	
		
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(2, "Retrive the booking and edit",test, test1);
		Step_Start(3, "Click on cancelled button",test, test1);
		waitForElement(driver, Cancelled_BTN);
		safeclick(driver, Cancelled_BTN);
		Step_End(3, "Click on cancelled button",test, test1);
		Step_Start(4, "Click on save button",test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		Step_End(4, "Click on save button",test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		waitForElement(driver, Bookcalclereason);
		safeclick(driver, Bookcalclereason);

		Step_Start(5, "check cancel list is present in both master tab and plugin configration",test, test1);
		List<WebElement> CancleReasons = listOfElements(driver, CancleReasonss);


		List<String> gh=new ArrayList<String>();
		for(WebElement CancleReason:CancleReasons) {
			String Canclereasonlist = getText1(driver, CancleReason);
			System.out.println( Canclereasonlist);
			Extent_pass_New(driver, "List of reasons present in the master tab"+Canclereasonlist, test, test1);
			gh.add(Canclereasonlist);

		}
		System.out.println(gh);
		waitForElement(driver, Cancelselect);
		safeclick(driver, Cancelselect);
		waitForElement(driver, remarkscanclebutton);
		safeclick(driver, remarkscanclebutton);



		moduleNavigate(driver, Search2);

		for(String value : gh) {

			waitForElement(driver, Bookcalclereasoninput);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.BACK_SPACE).perform();
			sendKeys(driver, Bookcalclereasoninput,value);

			try {
				String reasonsearch =  String.format(Booking_Locators.Port_selectt,value);
				Reasonname = getText(driver, reasonsearch);
				if(value.equals(Reasonname)) {
					clear(driver, Bookcalclereasoninput);
					Extent_pass_New(driver, "Matched ||Expected  The Cancel Reason in the booking Module : "+value+" || The Acutal Value Reason In Cancel Reason Module : "+Reasonname, test, test1);
					System.out.println("Matched || Expected The Cancel Reason in the booking Module : "+value+" || The Acutal Value Reason In Cancel Reason Module : "+Reasonname);
				}
			} catch (NoSuchElementException e) {
				System.out.println("Element is not present."+value);
				Extent_fail(driver, "Matched ||Expected  The Cancel Reason in the booking Module : "+value+" || The Acutal Value Reason In Cancel Reason Module : "+Reasonname, test, test1);
				System.out.println("Matched || Expected The Cancel Reason in the booking Module : "+value+" || The Acutal Value Reason In Cancel Reason Module : "+Reasonname);
				clear(driver, Bookcalclereasoninput);

			}



		}
		Step_End(5, "check cancel list is present in both master tab and plugin configration",test, test1);
		Extent_completed(test_Case_Name01, test, test1);


	}




}

