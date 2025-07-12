package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_PartBL_TC013 extends Keywords {

	public void PartBL_TC013(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC012";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String Plugin_Module = Excel_data.get("Plugin_Module");
		String pluginID = Excel_data.get("pluginID");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String Plugin_faalse = Excel_data.get("Plugin_False");
		String Plugin_True = Excel_data.get("Plugin_True");

		String Plugin_Flase = String.format(PluginFalse, Plugin_faalse);
		String Plugin_truue = String.format(PluginFalse, Plugin_True);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		Step_Start(1, "Set PLTP plugin is false", test, test1);

		moduleNavigate(driver, Plugin_Module);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, Plugin_Flase);
		safeclick(driver, Plugin_Flase);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_End(1, "Set PLTP plugin is false", test, test1);

		Step_Start(2, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(2, "Open the Part BL module", test, test1);

		Step_Start(3, "\"Move charges Package/Weight basis\" disable.", test, test1);

		waitForDisplay(driver, PBL_Movecharges_Package_radio);

		if (isElementAccessible(driver, PBL_Movecharges_Package_radio)) {

			System.out.println(
					"Expected result : If the PLTP plugin is false, Move charges Package/Weight basis radion button should be disabled || Actual result : If the PLTP plugin is false, Move charges Package/Weight basis radion button should be disabled");

			Extent_pass_New(driver,
					"Expected result : If the PLTP plugin is false, Move charges Package/Weight basis radion button should be disabled || Actual result : If the PLTP plugin is false, Move charges Package/Weight basis radion button was disabled",
					test, test1);

		} else {
			System.out.println(
					"Expected result : If the PLTP plugin is false, Move charges Package/Weight basis radion button should be disabled || Actual result : If the PLTP plugin is false, Move charges Package/Weight basis radion button should be disabled");

			Extent_fail(driver,
					"Expected result : If the PLTP plugin is false, Move charges Package/Weight basis radion button should be disabled || Actual result : If the PLTP plugin is false, Move charges Package/Weight basis radion button was enabled",
					test, test1);

		}

		Step_End(3, "\"Move charges Package/Weight basis\" disable.", test, test1);

		Step_Start(4, "Set PLTP plugin is True", test, test1);

		moduleNavigate(driver, Plugin_Module);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, Plugin_truue);
		safeclick(driver, Plugin_truue);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_End(4, "Set PLTP plugin is True", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
