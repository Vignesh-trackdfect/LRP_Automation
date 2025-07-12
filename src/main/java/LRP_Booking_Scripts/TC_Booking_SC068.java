package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC068 extends Keywords {
	public void Booking_SC068(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		// Getting Data from excel sheet for sendkeys values 
		String test_Case_Name01 = "TC_Booking_SC068";


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String agencyUser = Excel_data.get("AgencyUser");
		String allAgencySearch = Excel_data.get("allAgencySearch");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");

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

		// searching the module of booking

		moduleNavigate(driver, Search);

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");


		// searching contract number in global search 

		Step_Start(1, "Retrive the booking",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
	
		
		Step_End(1, "Retrive the booking ",test, test1);

		// navigate to the reference tab
		Step_Start(2, "Navigate to refrence tab and check the sale refernece is there ",test, test1);
		waitForElement(driver, referencetab);
		safeclick(driver, referencetab);
		waitForElement(driver, referencetabtext);

		// getting text of reference name

		System.out.println("********** Pinting the Reference name in reference tab  **********");
		Extent_call(test, test1,"********** Pinting the Reference name in reference tab ******");

		String referencevalue=getText(driver, referencetabtext);
		System.out.println(referencevalue);
		Extent_pass_New(driver, "****reference name shown as****"+referencevalue, test, test1);
		Step_End(2, "Navigate to refrence tab and check the sale refernece is there ",test, test1);
		//switch to the master

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		Step_Start(3, "Navigate to Bl tab and check sale refernece is present",test, test1);
		// safeclick on Bl Button

		waitForElement(driver, BLClick);
		safeclick(driver, BLClick);

		// navigate to the reference tab

		waitForElement(driver, Regstatus);
		safeclick(driver, Regstatus);
		waitForElement(driver, Regstatustext);

		// getting text from reference name

		String referencevalueinBL=getText(driver, Regstatustext);
		System.out.println(referencevalueinBL);
		Step_End(3, "Navigate to Bl tab and check sale refernece is present ",test, test1);

		//   verifying the both reference name in Booking Tab and Bl tab

		System.out.println("********** Validation the refrence tab anf bill of lading tab of reference name  **********");
		Extent_call(test, test1,"**********Validation the refrence tab anf bill of lading tab of reference name   ******");
		if(referencevalue.equals(referencevalueinBL)) {
			Extent_pass_New(driver,"Matched [*** Ref name shown in booking Tab***] || Excepted : "+ referencevalue+" || Actual [***Ref name shown in BL Tab***] : "+referencevalueinBL, test,test1);
			System.out.println("Matched [*** Ref name shown in booking Tab***] || Excepted : "+ referencevalue+" || Actual [***Ref name shown in BL Tab***] : "+referencevalueinBL);
			Extent_pass_New(driver, "The Refrerence name was same in both booking tab and Bl tab ", test,test1);
			System.out.println("The Refrerence name was same in both booking tab and Bl tab");
		}else {
			System.out.println("Not matched [*** Ref name shown in booking Tab***] || Excepted : "+ referencevalue+" || Actual [***Ref name shown in BL Tab***] : "+referencevalueinBL);
			Extent_fail(driver,"Not matched [*** Ref name shown in booking Tab***] || Excepted : "+ referencevalue+" || Actual [***Ref name shown in BL Tab***] : "+referencevalueinBL, test,test1);
		}


		Extent_completed(test_Case_Name01, test, test1);
	}



}
