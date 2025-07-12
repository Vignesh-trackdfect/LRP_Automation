package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_051 extends Keywords {
public void  Arrival_Notice_TS_051(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Arrival_Notice_TS_051";
		// Get data from test data
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_GlobalConfiguration=Excel_data.get("Module_GlobalConfiguration");
		String attribute=Excel_data.get("Attribute");
		String value1=Excel_data.get("Value");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number=Excel_data.get("BL_Number");
	

		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);


		SwitchProfile(driver, agencyUser);

		setGlobalConfiguration(driver, module_GlobalConfiguration, attribute, value1);


	
				Step_End(2, "Set the Attribute \"ARF\" as 'Y' by filter option", test, test1);
				
			
			// Switch Agency
				Step_Start(3, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);

				
//		Arrival Notice 
				
				moduleNavigate(driver, module_ArrivalNotice);

								
			Extent_cal(test, test1, module_ArrivalNotice);
			
				
				Step_End(3, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);

				
				Step_Start(4, "Verify FAX button has to be enabled ", test, test1);
			
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				
				
				globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "", "", "", "");
			

				waitForDisplay(driver, fax_Button);
				if(isDisplayed(driver, fax_Button) && isElementAccessible(driver, fax_Button)) {
					Extent_pass(driver, "Matched || Expected Result is :System should showing  FAX button in Arrival Notice / Freight Memo screen correctly. || Actual Result is :System  showing  FAX button in Arrival Notice / Freight Memo screen correctly", test, test1);
					System.out.println("Matched || Expected Result is :System should showing  FAX button in Arrival Notice / Freight Memo screen correctly|| Actual Result is  :System  showing  FAX button in Arrival Notice / Freight Memo screen correctly");
				}else {
					System.out.println("Not Matched || Expected Result is :System should showing  FAX button in Arrival Notice / Freight Memo screen correctly || Actual Result is:System is not showing  FAX button in Arrival Notice / Freight Memo screen correctly");
					Extent_fail(driver,"Not Matched || Expected Result is :System should showing  FAX button in Arrival Notice / Freight Memo screen correctly|| Actual Result is System is not showing  FAX button in Arrival Notice / Freight Memo screen correctly", test, test1);
				}
					
				Step_End(4, "Verify FAX button has to be enabled ", test, test1);
				Extent_completed(testCaseName, test, test1);

}
}
