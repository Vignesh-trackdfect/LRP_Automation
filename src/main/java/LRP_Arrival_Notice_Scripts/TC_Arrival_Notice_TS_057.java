package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_057 extends Keywords {

	public void Arrival_Notice_TS_057(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Arrival_Notice_TS_057";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String GlobalValue = Excel_data.get("GlobalValue");
		String ArrivalNotice_Module = Excel_data.get("ArrivalNotice_Module");
		String GlobalValue1 = Excel_data.get("GlobalValue1");
	
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "Open Global configuration screen", test, test1);
		setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
		

		Step_End(2, "Set the attribute \"ANO \"value as Y", test, test1);

		Step_Start(3, "Open Arrival Notice / Freight Memo screen", test, test1);
		
		moduleNavigate(driver, ArrivalNotice_Module);

		Step_End(3, "Open Arrival Notice / Freight Memo screen", test, test1);
		Step_Start(4, "Verify remainder button has to be added ", test, test1);
	newButton(driver);
waitForDisplay(driver, by_Remainder_AN);
		if(!isDisplayed(driver, by_Remainder_AN)) {
			System.out.println("Not Matched || Expected Result is :System should not showing  Remainder button in Arrival Notice / Freight Memo screen correctly || Actual Result is:System is not showing  Remainder button in Arrival Notice / Freight Memo screen correctly");
			Extent_pass(driver,"Not Matched || Expected Result is :System should not showing  Remainder button in Arrival Notice / Freight Memo screen correctly|| Actual Result is System is not showing  Remainder button in Arrival Notice / Freight Memo screen correctly", test, test1);
		}else {
			Extent_fail(driver, "Matched || Expected Result is :System should showing  Remainder button in Arrival Notice / Freight Memo screen correctly. || Actual Result is :System  showing  Remainder button in Arrival Notice / Freight Memo screen correctly", test, test1);
			System.out.println("Matched || Expected Result is :System should showing  Remainder button in Arrival Notice / Freight Memo screen correctly|| Actual Result is  :System  showing  Remainder button in Arrival Notice / Freight Memo screen correctly");
		}
		
		
		
		Step_End(4, "Verify remainder button has to be added ", test, test1);
		scrollTop(driver);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);	
		
		setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue1);
		
		
		Extent_completed(testcase_Name, test, test1);

	
	
	}

}
