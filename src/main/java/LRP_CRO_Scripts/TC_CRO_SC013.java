package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC013 extends Keywords {
	public void CRO_SC013(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_CRO_SC013";

		// Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String pluginConfiguration_Module_Name = Excel_data.get("pluginConfiguration_Module_Name");
		String pluginID = Excel_data.get("pluginID");
		String plugin_Header = Excel_data.get("plugin_Header");
		String Serach_Condition = Excel_data.get("Serach_Condition");
		String PluginStatus = Excel_data.get("PluginStatus");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String ResetPluginStatus = Excel_data.get("ResetPluginStatus");
		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Enter the test URL", test, test1);
		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);
// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Step_End(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_End(4, "Click on Login Button", test, test1);
		Step_Start(5, "Click on Switch profile button in home page", test, test1);
		Step_Start(6, "Enter Agency code in code search field & Click on Select button", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(5, "Click on Switch profile button in home page", test, test1);
		Step_End(6, "Enter Agency code in code search field & Click on Select button", test, test1);
		Step_Start(7, "Enter plugin configurationin 'Search Module' Search search box & Select the module", test,
				test1);
		Step_Start(8, "Search API plugin and double click the record", test, test1);
		Step_Start(9, "Click edit button", test, test1);
		Step_Start(10, "Change status to false and click save button.", test, test1);
		Step_Start(11, "Updated successfully message shown", test, test1);

		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				PluginStatus);

		Step_End(7, "Enter plugin configurationin 'Search Module' Search search box & Select the module", test, test1);
		Step_End(8, "Search API plugin and double click the record", test, test1);
		Step_End(9, "Click edit button", test, test1);
		Step_End(10, "Change status to false and click save button.", test, test1);
		Step_End(11, "Updated successfully message shown", test, test1);

// CroModule		
		Step_Start(12, "Open the Container release order module", test, test1);
		moduleNavigate(driver, CRO_Module_Name);

		Step_End(12, "Open the Container release order module", test, test1);
		Step_Start(13, "Check Valid from date option disabled", test, test1);
		waitForDisplay(driver, Valid_From_CRO);
		if (!isdisplayed(driver, Valid_From_CRO)) {
			System.out.println(
					"Matched || Excepted : After Change the API plugin AS false the VALID FROM date should not be Displayed    || Actual : After Change the API plugin AS false the VALID FROM date is  not Displayed ");
			Extent_pass_New(driver,
					"Matched || Excepted : After Change the API plugin AS false the VALID FROM date should not be Displayed    || Actual : After Change the API plugin AS false the VALID FROM date is  not Displayed ",
					test, test);

		} else {
			System.out.println(
					"Not Matched || Excepted : After Change the API plugin AS false the VALID FROM date should not be Displayed    || Actual : After Change the API plugin AS false the VALID FROM date is  Displayed ");
			Extent_fail(driver,
					" Not Matched || Excepted : After Change the API plugin AS false the VALID FROM date should not be Displayed    || Actual : After Change the API plugin AS false the VALID FROM date is  Displayed ",
					test, test);

		}
		Step_End(13, "Check Valid from date option disabled", test, test1);

		Step_Start(14, "Close CRO module.", test, test1);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(14, "Close CRO module.", test, test1);
		
		
		
		
		
		Step_Start(15, "Go to plugin configuration", test,
				test1);
		Step_Start(16, "Search API plugin and double click the record", test, test1);
		Step_Start(17, "Click edit button", test, test1);
		Step_Start(18, "Change status to true and click save button", test, test1);
		Step_Start(19, "Updated successfully message shown and click ok", test, test1);

		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				ResetPluginStatus);

		Step_End(15, "Go to plugin configuration", test,
				test1);
		Step_End(16, "Search API plugin and double click the record", test, test1);
		Step_End(17, "Click edit button", test, test1);
		Step_End(18, "Change status to true and click save button", test, test1);
		Step_End(19, "Updated successfully message shown and click ok", test, test1);

// CroModule		
		Step_Start(20, "Open the Container release order module", test, test1);
		moduleNavigate(driver, CRO_Module_Name);

		Step_End(20, "Open the Container release order module", test, test1);
		
		
		Step_Start(21, "Check Valid from date option enabled", test, test1);
		waitForDisplay(driver, Valid_From_CRO);
		if (isdisplayed(driver, Valid_From_CRO)) {
			System.out.println(
					"Matched || Excepted : After Change the API plugin AS True the VALID FROM date should  be Displayed    || Actual : After Change the API plugin AS True the VALID FROM date is Displayed ");
			Extent_pass_New(driver,
					"Matched || Excepted : After Change the API plugin AS True the VALID FROM date should be Displayed    || Actual : After Change the API plugin AS True the VALID FROM date is Displayed ",
					test, test);

		} else {
			System.out.println(
					"Not Matched || Excepted : After Change the API plugin AS True the VALID FROM date should  be Displayed    || Actual : After Change the API plugin AS True the VALID FROM date is not  Displayed ");
			Extent_fail(driver,
					" Not Matched || Excepted : After Change the API plugin AS True the VALID FROM date should  be Displayed    || Actual : After Change the API plugin AS True the VALID FROM date is  not  Displayed ",
					test, test);

		}
		Step_End(21, "Check Valid from date option enabled", test, test1);
	Extent_completed(testCaseName, test, test1);
		
		
		
		
		

	}

}
