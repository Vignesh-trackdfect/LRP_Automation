package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC050 extends Keywords {

	public void CRO_SC050(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC050";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Plugin_configuration_Module = Excel_data.get("Plugin_configuration_Module");
		String Plugin_column_Header = Excel_data.get("Plugin_column_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Status = Excel_data.get("Status");
		String Plugin_ID_Value = Excel_data.get("Plugin_ID_Value");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		



		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);


		//		Booking module
		
		Step_Start(1, "Open Plugin Configuration", test, test1);
		Step_Start(2, "Search STO Plugin", test, test1);
		Step_Start(3, "Set STO Plugin to true", test, test1);
		Step_Start(4, "Click Save button", test, test1);
		Step_Start(5, "Validate 'Plugin updated' message is shown", test, test1);
		setPluginConfig(driver, Plugin_configuration_Module, Plugin_column_Header, Condition_Filter, Plugin_ID_Value, Status);
		Step_End(5, "Validate 'Plugin updated' message is shown", test, test1);
		Step_End(4, "Click Save button", test, test1);
		Step_End(3, "Set STO Plugin to true", test, test1);
		Step_End(2, "Search STO Plugin", test, test1);
		Step_End(1, "Open Plugin Configuration", test, test1);
		
		
		Step_Start(6, "Go to Container Release Order module", test, test1);
	        moduleNavigate(driver, CRO_Module_Name);
	        Step_End(6, "Go to Container Release Order module", test, test1);
	        
	        
		scrollBottom(driver);
		Step_Start(7, "Check Stock button visibility", test, test1);
		if(isdisplayed(driver, Stock_Button_CRO)) {
			System.out.println("Expected Result is : Stock button should be Enabled  || Actual Result is : Stock button is Enabled ");
			Extent_pass_New(driver, "Expected Result is : Stock button should be Enabled  || Actual Result is : Stock button is Enabled ", test, test1);
		}else {
			System.out.println("Expected Result is : Stock button should be Enabled  || Actual Result is : Stock button is Not Enabled ");
			Extent_fail(driver, "Expected Result is : Stock button should be Enabled  || Actual Result is : Stock button is Not Enabled ", test, test1);
		}
		Step_End(7, "Check Stock button visibility", test, test1);
		
		Extent_completed(testCaseName, test, test1);
		

		
	}

}
