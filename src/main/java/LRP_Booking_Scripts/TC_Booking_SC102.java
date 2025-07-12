package LRP_Booking_Scripts;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC102  extends  Keywords{



	public void Booking_SC102(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {


		String test_Case_Name01 = "TC_Booking_SC102";


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("search_module");
		String Search1 = Excel_data.get("Search1");
		String agencyUser = Excel_data.get("AgencyUser");
		String allAgencySearch = Excel_data.get("allAgencySearch");
		String pluginID = Excel_data.get("pluginID");
		String Search2 = Excel_data.get("Search2");
		String Before_Paylocation = Excel_data.get("Before_Paylocation");
		String Agencyupdatedexp = Excel_data.get("Agencyupdated");
		String After_Paylocation = Excel_data.get("After_Paylocation");
		String spl = Excel_data.get("Plug_in_id");
		String Bkg = Excel_data.get("Module_id");
		String Payment_mode = Excel_data.get("Payment_mode");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition1");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");
		String Agency_Search =  Excel_data.get("Agency_Search");


		String First_code =  String.format(Booking_Locators.First_codee,Before_Paylocation);

		Extent_Start(test_Case_Name01, test, test1);

		//Open Url
		navigateUrl(driver, url);

		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		//Switch profile
		SwitchProfile(driver, agencyUser);



		// searching the module of booking

		moduleNavigate(driver, Search);

		Step_Start(1, "Retrive the booking",test, test1);
		// searching contract number in global search 
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
	
		
		
		Step_End(1, "Retrive the booking ",test, test1);
		// Navigate to the Charges Tab
		Step_Start(2, "Navigate charges tab and validate the pay location",test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		// Taking value of prepaid location before change the location
		waitForElement(driver,Search_Input);
		String paylocations_select =  String.format(Booking_Locators.paylocationss,Payment_mode);
		waitForElement(driver, paylocations_select);
		List<WebElement> paylocations = listOfElements(driver, paylocations_select);

		for (WebElement location : paylocations) {
			String payloc1 = getText1(driver, location);
			System.out.println(payloc1);
			Extent_pass_New(driver, "**Before changing the agency master pay location shows**"+payloc1, test, test1);


		}
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Step_End(2, "Navigate charges tab and validate the pay location",test, test1);
		Step_Start(3, "Navigate to plugin configration and change as true",test, test1);
		// searching the module of booking

		moduleNavigate(driver, Search1);

		waitForElement(driver, pluginConfiguration_Tab);
	
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_PluginID_Row2);
		String actualPluginID=getText(driver, first_PluginID_Row2);
		if(actualPluginID.equals(pluginID)) {
			Extent_pass_New(driver, pluginID+" plugin ID is available", test,test1);
			System.out.println(pluginID+" plugin ID is available");

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
		}else {
			System.out.println(pluginID+" plugin ID is unavailable");
			Extent_fail(driver, pluginID+" plugin ID is unavailable", test,test1);

		}



		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, spl);

		waitForElement(driver, Moduleid);
		sendKeys(driver, Moduleid, Bkg);

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


		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Step_End(3, "Navigate to plugin configration and change as true",test, test1);
		// searching the module of booking
		moduleNavigate(driver, Search2);
		
		Step_Start(4, "Navigate to agency master and changde the location",test, test1);
		waitForElement(driver, Agenctmastersearch);
		safeclick(driver, Agenctmastersearch);

		globalValueSearchWindow(driver, dropdownCondition1, Agency_Search, agencyUser, "", "", "", "");
		
	


		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		if(isDisplayed(driver, First_code)) {
			waitForElement(driver, Agencymastersearch);
			safeclick(driver, Agencymastersearch);
			waitForElement(driver, Agencymastersearchgird);
			sendKeys(driver, Agencymastersearchgird, After_Paylocation);

			waitForElement(driver, rel_terminal_select);
			safeclick(driver, rel_terminal_select);
			waitForElement(driver, Agenctmasteresave);
			safeclick(driver, Agenctmasteresave);

		}else {

			waitForElement(driver, Agencymastersearch);
			safeclick(driver, Agencymastersearch);
			waitForElement(driver, Agencymastersearchgird);
			sendKeys(driver, Agencymastersearchgird, Before_Paylocation);

			waitForElement(driver, rel_terminal_select);
			safeclick(driver, rel_terminal_select);
			waitForElement(driver, Agenctmasteresave);
			safeclick(driver, Agenctmasteresave);
		}
		Step_End(4, "Navigate to agency master and changde the location",test, test1);
		waitForElement(driver, popup_Message);
		String updatedpopact = getText(driver, popup_Message);
		System.out.println(updatedpopact);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		waitForPopup(driver, Agenymasteragency,Agencyupdatedexp);
		String agencycode = getAttribute(driver, Agenymasteragency,"value");
		System.out.println(agencycode);


	

		if (Agencyupdatedexp.equals(updatedpopact)) {
			System.out.println(
					"Matched || " + " Expected Activity POPUP  is : " + Agencyupdatedexp + " || Actual Activity POPUP is : " + updatedpopact);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity POPUP is : " + Agencyupdatedexp + " || Actual Activity POPUP is : " + updatedpopact,
					test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity POPUP is : " + Agencyupdatedexp + " || Actual Activity POPUP is : " + updatedpopact);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity POPUP is : " + Agencyupdatedexp + " || Actual Activity POPUP is : " + updatedpopact,
					test,test1);
		}




		Step_Start(5, "Navigate booking and check whether location as changed as per agency updated",test, test1);

		//searching the module of booking

		moduleNavigate(driver, Search);

		// searching contract number in global search 

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
	


		// Navigate to the Charges Tab

		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, Editbtn);
		safeclick(driver, Editbtn);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		scrollBottom(driver);
		waitForElement(driver,Search_Input);
		String paylocations_select1 =  String.format(Booking_Locators.paylocationss,Payment_mode);
		waitForElement(driver, paylocations_select1);
		List<WebElement> paylocations1 = listOfElements(driver, paylocations_select1);

		for (WebElement location : paylocations1) {
			String payloc = getText1(driver, location);
			System.out.println(payloc);

			Extent_pass_New(driver,"**after changing the agency master pay location shows**"+payloc, test, test1);

			if(payloc.equals(agencycode)) {
				
				System.out.println(
				"Matched || " + " Expected Activity Both agency master tab and booking tab want to change changed into : " + payloc + " || Actual Activity Both agency master tab and booking tab was changed into : " + agencycode);
				Extent_pass_New(driver,
						"Matched || " + " Expected Activity Both agency master tab and booking tab want to change changed into : " + payloc + " || Actual Activity Both agency master tab and booking tab was changed into : " + agencycode,
						test,test1);
			} else {
				System.out.println(
						"Not matched || " + " Expected Activity Both agency master tab and booking tab want to change changed into : " + payloc + " || Actual Activity Both agency master tab and booking tab was changed into : " + agencycode);
				Extent_fail(driver,
						"Not matched || " + " Expected Activity Both agency master tab and booking tab want to change changed into : " + payloc + " || Actual Activity Both agency master tab and booking tab was changed into : " + agencycode,
						test,test1);
			}


				
			
			Step_End(5, "Navigate booking and check whether location as changed as per agency updated",test, test1);




		}

		Extent_completed(test_Case_Name01, test, test1);

	}
}


