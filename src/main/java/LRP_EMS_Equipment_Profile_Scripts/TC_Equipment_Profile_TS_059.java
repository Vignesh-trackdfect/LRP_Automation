package LRP_EMS_Equipment_Profile_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Equipment_Profile_TS_059 extends Keywords {
	
//	Check system allows to retrieve the saved record using global search Tool bar
	
	public void retrieveSavedRecords(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Equipment_Profile_TS_059";
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleEquipmentProfile");
		String retrieveRecord = Excel_data.get("RetrieveRecord");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
		String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");
		
		navigateUrl(driver, url);

	Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, username, password);
		
//		Module Search
		moduleNavigate(driver, moduleName);
		

		Step_Start(1, "Click the Global search button in the toolbar", test, test1);
		
		waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
		if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
			click(driver,  newButton_EquipmentProfile_Homepage);
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(1, "Click the Global search button in the toolbar", test, test1);
		
		Step_Start(2, "Enter the saved Equipment Number in the search list", test, test1);
		Step_Start(3, "Click the search button once a valid Equipment number is entered", test, test1);
		Step_Start(4, "Double-click on the saved record from the AgGrid table.", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, retrieveRecord, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);


			Step_End(2, "Enter the saved Equipment Number in the search list", test, test1);
			Step_End(3, "Click the search button once a valid Equipment number is entered", test, test1);
			Step_End(4, "Double-click on the saved record from the AgGrid table.", test, test1);
			Step_Start(5, "Verify The Retrieved Equipment Number", test, test1);
		
			waitForElement(driver, eqpNoTextField_L);

		String actEqNo = getAttribute(driver, eqpNoTextField_L, "value");
		System.out.println("Actual:" + actEqNo);
		System.out.println("Expected:" + retrieveRecord);
		if (actEqNo.equals(retrieveRecord)) {
			System.out.println("Matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo);
			Extent_pass_New(driver, "Matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo, test,test1);
			Extent_pass_New(driver, "The saved record is retrieved by using global search and it is verified", test, test1);
			System.out.println("The saved record is retrieved by using global search and it is verified");
		} else {
			System.out.println("Not matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo);
			System.out.println("The saved record is not retrieved by using global search and it is verified");
			Extent_fail(driver, "Not matched || " + " Expected  : " + retrieveRecord + " || Actual  : " + actEqNo+"<br>"+"The saved record is not retrieved by using global search and it is verified", test,test1);
		}
		String tareWeightAfter = getAttribute(driver, tareWeightTextField_L, "value");
		String payLoadAfter = getAttribute(driver, payLoadTextField_L, "value");
		String afterGross = getAttribute(driver, maxGrossWeightTextField_L, "value");

		if (!tareWeightAfter.equals("")) {
			System.out.println("Tare weight :" + tareWeightAfter);
			Extent_pass_New(driver, "Tare weight "  + tareWeightAfter, test, test1);
		}
		if (!payLoadAfter.equals("")) {
			System.out.println("Payload :" + payLoadAfter);
			Extent_pass_New(driver, "Payload  " + payLoadAfter, test, test1);
		}
		if (!afterGross.equals("")) {
			System.out.println(" max gross Weight:" + afterGross);
			Extent_pass_New(driver, "Gross weight  " + afterGross, test, test1);
		}

		
		Step_End(5, "Verify The Retrieved Equipment Number", test, test1);
		Extent_completed(testCaseName, test, test1);

	}

}
