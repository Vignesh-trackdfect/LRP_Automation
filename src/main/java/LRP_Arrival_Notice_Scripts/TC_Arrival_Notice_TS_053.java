package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_053 extends Keywords {
public void  Arrival_Notice_TS_053(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Arrival_Notice_TS_053";
		// Get data from test data

		

			String username = Excel_data.get("Username");
			String password = Excel_data.get("Password");
			String agencyUser = Excel_data.get("AgencyUser");
			String module_GlobalConfiguration=Excel_data.get("Module_GlobalConfiguration");
			String attribute=Excel_data.get("Attribute");
			String value1=Excel_data.get("Value");
			String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");

		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);

		// Switch Agency
		SwitchProfile(driver, agencyUser);

		


				
		// Global configuration
					Extent_cal(test, test1,"Global Configuration");
					Step_Start(1, "Open Global configuration screen", test, test1);
					
					setGlobalConfiguration(driver, module_GlobalConfiguration, attribute, value1);

				Step_End(2, "Set the Attribute \"ARB\"  as 'Y'", test, test1);
			
				Step_Start(3, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);

//		Arrival Notice 
				
			
				
				moduleNavigate(driver, module_ArrivalNotice);

								
			Extent_cal(test, test1, module_ArrivalNotice);
			
				waitForDisplay(driver, arrivalNotice_Module);
			
				Step_End(3, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);
				Step_Start(4, "Verify  BL N/N copy button has to be added ", test, test1);

				waitForDisplay(driver, bl_NO_Searchfield);
				
				if(isDisplayed(driver, BL_N_N_Copy_Button)) {
					Extent_pass(driver, "Matched || Expected Result is :System should showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly. || Actual Result is :System  showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly", test, test1);
					System.out.println("Matched || Expected Result is :System should showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly|| Actual Result is  :System  showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly");
				}else {
					System.out.println("Not Matched || Expected Result is :System should not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly || Actual Result is:System is not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly");
					Extent_fail(driver,"Not Matched || Expected Result is :System should not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly|| Actual Result is System is not showing  BL N/N copy button in Arrival Notice / Freight Memo screen correctly", test, test1);
				}
					
				
				Step_End(4, "Verify  BL N/N copy button has to be added ", test, test1);
				
				
						Extent_completed(testCaseName, test, test1);

}
}
