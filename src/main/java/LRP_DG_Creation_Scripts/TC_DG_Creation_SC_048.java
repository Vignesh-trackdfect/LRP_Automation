package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_DG_Creation_SC_048 extends Keywords {


	public void DG_Creation_SC_048(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_048";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus = Excel_data.get("PluginStatus");	
		
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

		
		//	Plugin Configuration
		Extent_cal(test, test1, "Plugin Configuration");
		
		moduleNavigate(driver, pluginConfigurationModule);
				
		Extent_cal(test, test1, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);


			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, PluginStatus);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		
			Extent_cal(test, test1, DG_Creation_Module);

		//		Module Search
		Step_Start(1, "Open the DG module", test, test1);

		moduleNavigate(driver, DG_Creation_Module);
		
		Step_End(1, "Open the DG module", test, test1);

		
		newButton(driver);
		Step_Start(2, "make sure remove button enable/disable.", test, test1);

		
		scrollElementToView(driver, remove_Button_DG);
		if(isElementAccessible(driver , remove_Button_DG)) {
			System.out.println("Matched || Expected : Remove button should be enabled || Actual :  Remove button is enabled");
			Extent_pass_New(driver, "Matched || Expected : Remove button should be enabled || Actual :  Remove button is enabled", test, test1);
		}else {
			System.out.println("Not Matched || Expected : Remove button should be enabled || Actual :  Remove button is disabled");
			Extent_pass(driver, "Not Matched || Expected : Remove button should be enabled || Actual :  Remove button is disabled", test, test1);
		}
		Step_End(2, "make sure remove button enable/disable.", test, test1);

		
		Extent_completed(testCaseName, test, test1);
	}

}
