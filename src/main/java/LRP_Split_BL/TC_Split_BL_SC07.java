package LRP_Split_BL;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Split_BL_SC07 extends Keywords {

	public void Split_BL_SC07(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Split_BL_SC07";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Plugin_Modulename = Excel_data.get("Plugin_Modulename");
		String SPLW_Plugin = Excel_data.get("SPLW_Plugin");
		String Plugin_Status = Excel_data.get("Plugin_Status");
		String SplitBL_ModuleName = Excel_data.get("SplitBL_ModuleName");
		String SPCN_Plugin = Excel_data.get("SPCN_Plugin");

		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);

		Step_Start(2, "Enter the test URL", test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Open the browser", test, test1);

		Step_End(2, "Enter the test URL", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);

		Step_Start(4, "Click on Login Button", test, test1);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		Step_End(3, "Enter valid Username & Password in respective text fields", test, test1);

		Step_End(4, "Click on Login Button", test, test1);

		Step_Start(5, "Switch the agency and open plugin configuration module", test, test1);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Plugin_Modulename);

		Step_End(5, "Switch the agency and open plugin configuration module", test, test1);

		Step_Start(6, "Set SPLW plugin true and SPCN plugin true", test, test1);

		waitForElement(driver, PC_PluginID_input);
		sendKeys(driver, PC_PluginID_input, SPLW_Plugin);

		waitForElement(driver, AG_Grid_First_Row);
		doubleClick(driver, AG_Grid_First_Row);

		waitForElement(driver, PC_Plugin_Status);
		String status = getText(driver, PC_Plugin_Status);

		if (status.equalsIgnoreCase(Plugin_Status)) {

			System.out.println("The SPLW Plugin is already is in True status");
			Extent_cal(test, test1, "The SPLW Plugin is already is in True status");

		} else {

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, PC_Plugin_Status);
			click(driver, PC_Plugin_Status);

			formatLocatorClick(driver, DropDown_Select, Plugin_Status);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

		}
		
		waitForElement(driver, PC_PluginID_input);
		clear(driver, PC_PluginID_input);
		sendKeys(driver, PC_PluginID_input, SPCN_Plugin);

		waitForElement(driver, AG_Grid_First_Row);
		doubleClick(driver, AG_Grid_First_Row);

		waitForElement(driver, PC_Plugin_Status);
		String status2 = getText(driver, PC_Plugin_Status);

		if (status2.equalsIgnoreCase(Plugin_Status)) {

			System.out.println("The SPCN Plugin is already is in True status");
			Extent_cal(test, test1, "The SPCN Plugin is already is in True status");

		} else {

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, PC_Plugin_Status);
			click(driver, PC_Plugin_Status);

			formatLocatorClick(driver, DropDown_Select, Plugin_Status);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

		}
		
		Step_End(6, "Set SPLW plugin true and SPCN plugin true", test, test1);

		Step_Start(7, "Open the split BL module", test, test1);

		moduleNavigate(driver, SplitBL_ModuleName);

		Step_End(7, "Open the split BL module", test, test1);

		Step_Start(8, "Containerized and Non-Containerized options enabled", test, test1);

		if (isElementEnabled(driver, SB_Containerised)) {

			System.out.println(
					"Expected result : After Enable the SPTW and SPCN plugins Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Containerised button was enabled");
			Extent_pass_New(driver,
					"Expected result : After Enable the SPTW and SPCN plugins Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Containerised button was enabled",
					test, test1);
		} else {

			System.out.println(
					"Expected result : After Enable the SPTW and SPCN plugins Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Containerised button was not enabled");
			Extent_fail(driver,
					"Expected result : After Enable the SPTW and SPCN plugins Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Containerised button was not enabled",
					test, test1);

		}

		if (isElementEnabled(driver, SB_NonContainerised)) {

			System.out.println(
					"Expected result : After Enable the SPTW and SPCN plugins Non Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Non Containerised button was enabled");
			Extent_pass_New(driver,
					"Expected result : After Enable the SPTW and SPCN plugins Non Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Non Containerised button was enabled",
					test, test1);
		} else {

			System.out.println(
					"Expected result : After Enable the SPTW and SPCN plugins Non Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Non Containerised button was not enabled");
			Extent_fail(driver,
					"Expected result : After Enable the SPTW and SPCN plugins Non Containerised button should be enabled || Actual result : After Enable the SPTW and SPCN plugins Non Containerised button was not enabled",
					test, test1);

		}

		Step_End(8, "Containerized and Non-Containerized options enabled", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
