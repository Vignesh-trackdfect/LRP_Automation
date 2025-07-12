package LRP_EMS_Movement_Entry_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_TS_021 extends Keywords {

//	To retrieve data from Multiple movement entry
	
	public void retrieveDataFromMulitpleMovementEntry(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Movement_Entry_TS_021";
//		Get data from excel sheet
		
		
		
		

		String username = Excel_data.get("Username");

		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String retrieveEqpNo = Excel_data.get("RetrieveEqpNo");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String dropdownCondition = Excel_data.get("DropdownCondition");
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
		
		Step_Start(1, "Select Multiple Equipment Entry option", test, test1);
		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);

			Step_End(1, "Select Multiple Equipment Entry option", test, test1);
			Step_Start(2, "Click on global search icon option from toolbar", test, test1);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			Step_End(2, "Click on global search icon option from toolbar", test, test1);
			Step_Start(3, "Enter required container no on required field", test, test1);
		
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, retrieveEqpNo, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

			waitForElement(driver, eqpNoInEqpDetails_L);
			String actualRetNo2 = getText(driver, eqpNoInEqpDetails_L);
			System.out.println("Actual Eqp No:" + actualRetNo2);
			System.out.println("Expected Eqp No:" + retrieveEqpNo);

			if (actualRetNo2.equals(retrieveEqpNo)) {
				System.out.println("Matched || " + " Expected Value is : " + retrieveEqpNo + " || Actual Value is : "
						+ actualRetNo2);

				Extent_pass_New(driver, "Matched || " + " Expected Value is : " + retrieveEqpNo + " || Actual Value is : "
						+ actualRetNo2+"<br>"+"Multiple Movement Entry retrieved", test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Value is : " + retrieveEqpNo
						+ " || Actual Value  is : " + actualRetNo2);

				Extent_fail(driver, "Not matched || " + " Expected Value is : " + retrieveEqpNo
						+ " || Actual Value is : " + actualRetNo2+"<br>"+"Multiple Movement Entry not retrieved", test, test1);
			}

		Step_End(4, "click search & select the required container to retrieve", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
