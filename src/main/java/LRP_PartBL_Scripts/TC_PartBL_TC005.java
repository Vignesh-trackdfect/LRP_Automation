package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_PartBL_TC005 extends Keywords {

	public void PartBL_TC005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC005";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String ModuleName = Excel_data.get("ModuleName");
		String Column_Header = Excel_data.get("Column_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String value = Excel_data.get("value");
		String EnableStatus = Excel_data.get("EnableStatus");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Bl_number = Excel_data.get("Bl_number");
		String Select_field = Excel_data.get("Select_field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String EnableStatus1 = Excel_data.get("EnableStatus1");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		Step_Start(1, "Set PLTw plugin is false", test, test1);

		setPluginConfig(driver, ModuleName, Column_Header, Condition_Filter, value, EnableStatus);

		Step_End(1, "Set PLTw plugin is false", test, test1);

		Step_Start(2, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		newButton(driver);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, Search_Condition, Select_field, Bl_number, "", "", "", "");

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, No_Of_parts_TextField);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(2, "Open the Part BL module", test, test1);

		Step_Start(3, "Package and Weight part option disabled", test, test1);

		waitForDisplay(driver, PBL_Package_radiobutton);

		if (!isDisplayed(driver, PBL_Package_radiobutton)) {

			System.out.println(
					"Expected result : After set the PLTW pluggin as false, package button should be disabled || Actual result : After set the PLTW pluggin as false, package button is disabled");
			Extent_pass_New(driver,
					"Expected result : After set the PLTW pluggin as false, package button should be disabled || Actual result : After set the PLTW pluggin as false, package button is disabled",
					test, test1);
		} else {

			System.out.println(
					"Expected result : After set the PLTW pluggin as false, package button should be disabled || Actual result :  After set the PLTW pluggin as false, package button is not disabled");
			Extent_fail(driver,
					"Expected result : After set the PLTW pluggin as false, package button should be disabled || Actual result :  After set the PLTW pluggin as false, package button is not disabled",
					test, test1);

		}

		if (!isDisplayed(driver, PBL_Weight_radiobutton)) {

			System.out.println(
					"Expected result : After set the PLTW pluggin as false, weight button should be disabled || Actual result : After set the PLTW pluggin as false, weight button is disabled");
			Extent_pass_New(driver,
					"Expected result : After set the PLTW pluggin as false, weight button should be disabled || Actual result : After set the PLTW pluggin as false, weight button is disabled",
					test, test1);
		} else {

			System.out.println(
					"Expected result : After set the PLC pluggin as false, weight button should be disabled || Actual result :  After set the PLC pluggin as false, weight button is not disabled");
			Extent_fail(driver,
					"Expected result : After set the PLC pluggin as false, weight button should be disabled || Actual result :  After set the PLC pluggin as false, weight button is not disabled",
					test, test1);

		}

		Step_End(3, "Package and Weight part option disabled", test, test1);

		Step_Start(4, "Again set the PLTW plugin true.", test, test1);

		setPluginConfig(driver, ModuleName, Column_Header, Condition_Filter, value, EnableStatus1);

		Step_End(4, "Again set the PLTW plugin true.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
