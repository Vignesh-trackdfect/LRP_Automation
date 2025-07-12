package LRP_Booking_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC100  extends Keywords{

	public void Booking_SC100(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String test_Case_Name01 = "TC_Booking_SC100";


		String Username = Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String Search1 =Excel_data.get("Search1");
		String agencyUser =Excel_data.get("AgencyUser");
		String BLNumber =Excel_data.get("BLNumber");
		String allAgencySearch =Excel_data.get("allAgencySearch");
		String Splitblpop =Excel_data.get("Splitblpop");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition1");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");
		String globalSearchFilterOption_split =  Excel_data.get("globalSearchFilterOption_split");

		Extent_Start(test_Case_Name01, test, test1);


		//Open Url
		navigateUrl(driver, url);

		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1,"********** Switch the Profile Start **********");
		//Switch profile
		SwitchProfile(driver, agencyUser);

		System.out.println("***Switch the Profile end ***");
		Extent_call(test, test1,"********** Switch the Profile end **********");
		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		// searching the module of booking

		moduleNavigate(driver, Search);

		// searching contract number in global search 
		Step_Start(1, "Retrive the booking",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
		
		
		
		Step_End(1, "Retrive the booking ",test, test1);

		waitForElement(driver, Blvalueclick);
		String Blnuminbltab=getText(driver, Blvalueclick);
		System.out.println(Blnuminbltab);
		String[] a = Blnuminbltab.split("\\-");
		System.out.println("Splitted string" + a[0]);
		waitForElement(driver, Blvalueclick);
		doubleClick(driver, Blvalueclick);

		// searching the module of booking
		Step_Start(2, "retreive the SPlit bl done booking in Book search window",test, test1);
		moduleNavigate(driver, Search1);
newButton(driver);
		waitForElement(driver, searchbuttonsplittab);
		safeclick(driver, searchbuttonsplittab);

		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_split, BLNumber, "", "", "", "");
	
		
		
		

		waitForElement(driver, Blnumberinbltab);
		String Blnum=getAttribute(driver, Blnumberinbltab,"value");
		System.out.println(Blnum);

	

		if (a[0].equals(Blnum)) {
			System.out.println(
					"Matched || " + " Expected Activity  number should be shown is : " + a[0] + " || Actual Activity number is : " + Blnum);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity number should be shown is : " + a[0] + " || Actual Activity number is : " + Blnum, test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity number should be shown is : " + a[0] + " || Actual Activity number is : " + Blnum);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity number should be shown is : " + a[0] + " || Actual Activity number is : " + Blnum,
					test,test1);
		}


		Step_Start(3, "Navigate to master tab and edit",test, test1);
		waitForElement(driver, Switchtobooking);
		safeclick(driver, Switchtobooking);




		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_End(3, "Navigate to master tab and edit",test, test1);

		Step_Start(4, "system display validation msg",test, test1);
		waitForElement(driver, popup_Message);
		String splitpopact=getText(driver, popup_Message);
		System.out.println(splitpopact);



		if (Splitblpop.equals(splitpopact)) {
			System.out.println(
					"Matched || " + " Expected Activity popup is : " + Splitblpop + " || Actual Activity popup is : " + splitpopact);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity popup is : " + Splitblpop + " || Actual Activity popup is : " + splitpopact, test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Activity popup is : " + Splitblpop + " || Actual Activity popup is : " + splitpopact);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity popup is : " + Splitblpop + " || Actual Activity popup is : " + splitpopact,
					test,test1);
		}

		Step_End(4, "system display validation msg",test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		newButton(driver);
		Extent_completed(test_Case_Name01, test, test1);

	}
}
