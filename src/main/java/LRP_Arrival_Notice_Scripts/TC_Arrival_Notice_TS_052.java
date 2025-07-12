package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_052 extends Keywords {
	public void  Arrival_Notice_TS_052(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Arrival_Notice_TS_052";
		// Get data from test data

		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_GlobalConfiguration=Excel_data.get("Module_GlobalConfiguration");
		String attribute=Excel_data.get("Attribute");
		String value1=Excel_data.get("Value");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number=Excel_data.get("Search_Number");
		String bl_Number=Excel_data.get("BL_Number");
		String valueRESET=Excel_data.get("Value1");
		
	

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);


		SwitchProfile(driver, agencyUser);


		setGlobalConfiguration(driver, module_GlobalConfiguration, attribute, value1);

		

		Step_End(2, "Set the Attribute \"ARF\" set as 'N'", test, test1);


		// Switch Agency
		Step_Start(3, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);


		//		Arrival Notice 


		moduleNavigate(driver, module_ArrivalNotice);


		Extent_cal(test, test1, module_ArrivalNotice);

		Step_End(3, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);


		Step_Start(4, "Verify FAX button has to be Disabled ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "", "", "", "");

		waitForDisplay(driver, bl_NO_Searchfield);

		if(!isDisplayed(driver, fax_Button)) {

			System.out.println(" Matched || Expected Result is :System should not showing  FAX button in Arrival Notice / Freight Memo screen correctly || Actual Result is:System is not showing  FAX button in Arrival Notice / Freight Memo screen correctly");
			Extent_pass(driver," Matched || Expected Result is :System should not showing  FAX button in Arrival Notice / Freight Memo screen correctly|| Actual Result is System is not showing  FAX button in Arrival Notice / Freight Memo screen correctly", test, test1);
		}else {
			Extent_fail(driver, "NOTMatched || Expected Result is :System should not  showing  FAX button in Arrival Notice / Freight Memo screen correctly. || Actual Result is :System  showing  FAX button in Arrival Notice / Freight Memo screen correctly", test, test1);
			System.out.println("NOTMatched || Expected Result is :System should  not showing  FAX button in Arrival Notice / Freight Memo screen correctly|| Actual Result is  :System  showing  FAX button in Arrival Notice / Freight Memo screen correctly");

		}

		Step_End(4, "Verify FAX button has to be Disabled ", test, test1);

		// Global configuration
		Extent_cal(test, test1,"Global Configuration");

		Extent_call(test, test1, "Set the Attribute \"ARB\"  as 'Y'");
		setGlobalConfiguration(driver, module_GlobalConfiguration, attribute, valueRESET);

		

		Extent_completed(testCaseName, test, test1);

	}
}
