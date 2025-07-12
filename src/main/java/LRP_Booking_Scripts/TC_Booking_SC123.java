package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC123  extends  Keywords{
	public void Booking_SC123(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		// Values are taken from data sheet

		String test_Case_Name01 = "TC_Booking_SC123";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String agencyUser = Excel_data.get("AgencyUser");
		String allAgencySearch = Excel_data.get("allAgencySearch");
		String Ecomexp = Excel_data.get("Ecomexp");
		String Lrpexp = Excel_data.get("Lrpexp");
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


		moduleNavigate(driver, Search);

		// searching contract number in global search 
		Step_Start(1, "Retrive the ECom Booking ",test, test1);	
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
	
		
		
		Step_End(1, "Retrive the ECom Booking ",test, test1);


		waitForElement(driver, Booksource);
		String Booksourcenumact = getText(driver, Booksource);


		if(Ecomexp.equals(Booksourcenumact)) {
			System.out.println("Matched || " + " Expected Report Activity is [Booking source was shown before save as]: " + Ecomexp + " || Actual Report Activity is [Booking source was shown before save as] : " + Booksourcenumact);
			Extent_pass_New(driver,"Matched || " + " Expected Report Activity is  [Booking source was shown before save as]: " + Ecomexp + " || Actual Report Activity is  [Booking source was shown before save as]: " + Booksourcenumact,test,test1);
			Extent_pass_New(driver, "***Booking source was show as***"+ Ecomexp, test,test1);
		}else{
			System.out.println("Not Matched || " + " Expected Report Activity is [Booking source was shown before save as] : " + Ecomexp + " || Actual Report Activity is [Booking source was shown before save as] : " + Booksourcenumact);
			Extent_fail(driver,"Not Matched || " + " Expected Report Activity is [Booking source was shown before save as] : " + Ecomexp + " || Actual Report Activity is  [Booking source was shown before save as]: " + Booksourcenumact,test,test1);
		}


		Step_Start(2, "Click Save As button",test, test1);		

		System.out.println(Booksourcenumact);
		waitForElement(driver, SaveAs_button_toolBar);
		safeclick(driver, SaveAs_button_toolBar);
		Step_End(2, "Click Save As button",test, test1);

		waitForElement(driver, SaveAsno);
		safeclick(driver, SaveAsno);


		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		

		waitForElement(driver, Booksource);
		Step_Start(3, "System not carryforward the Booksource value",test, test1);		
		String Booksourcenumaftersaveasact = getText(driver, Booksource);
		System.out.println(Booksourcenumaftersaveasact);
		if(Lrpexp.equals(Booksourcenumaftersaveasact)) {
			System.out.println("Matched || " + " Expected Report Activity is [Booking source was shown after save as]: " + Lrpexp + " || Actual Report Activity is [Booking source was shown after save as] : " + Booksourcenumaftersaveasact);
			Extent_pass_New(driver,"Matched || " + " Expected Report Activity is  [Booking source was shown after save as]: " + Lrpexp + " || Actual Report Activity is  [Booking source was shown after save as]: " + Booksourcenumaftersaveasact,test,test1);
			Extent_pass_New(driver, "***Booking source was show as after save as****"+ Booksourcenumaftersaveasact, test,test1);
		}else{
			System.out.println("Not Matched || " + " Expected Report Activity is [Booking source was shown after save as] : " + Lrpexp + " || Actual Report Activity is [Booking source was shown after save as] : " + Booksourcenumaftersaveasact);
			Extent_fail(driver,"Not Matched || " + " Expected Report Activity is [Booking source was shown after save as] : " + Lrpexp + " || Actual Report Activity is  [Booking source was shown after save as]: " + Booksourcenumaftersaveasact,test,test1);
		}
		Step_End(3, "System not carryforward the Booksource value",test, test1);

		Extent_completed(test_Case_Name01, test, test1);

	}

}

