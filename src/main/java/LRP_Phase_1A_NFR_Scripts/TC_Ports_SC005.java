package LRP_Phase_1A_NFR_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC005 extends Keywords {

	public void Ports_SC005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Ports_SC005";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Port_ModuleName = Excel_data.get("Port_ModuleName");
		String GlobalSearch_option = Excel_data.get("GlobalSearch_option");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String GlobalSearch_value = Excel_data.get("GlobalSearch_value");
		String RTM_ModuleName = Excel_data.get("RTM_ModuleName");
		String Regioncode_Header = Excel_data.get("Regioncode_Header");
		String Twocolumn_Condition = Excel_data.get("Twocolumn_Condition");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application", test, test1);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		Step_End(1, "Login the application", test, test1);

		Step_Start(2, "Navigate to ports screen", test, test1);

		moduleNavigate(driver, Port_ModuleName);

		Step_End(2, "Navigate to ports screen", test, test1);

		Step_Start(3, "Retrieve ports from the global search", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_option, GlobalSearch_value, "", "", "",
				"");

		Step_End(3, "Retrieve ports from the global search", test, test1);

		Step_Start(4, "Verify the Region Code", test, test1);

		String regioncode = getAttribute(driver, PS_Region_Input, "value");

		if (!regioncode.isEmpty()) {

			System.out.println(
					"Expected result : The selected location should have region code || Actual result : The selected Location code has region code"
							+ regioncode);
			Extent_pass_New(driver,
					"Expected result : The selected location should have region code || Actual result : The selected Location code has region code"
							+ regioncode,
					test, test1);

		} else {

			System.out.println(
					"Expected result : The selected location should have region code || Actual result : The selected Location code don't have region code");
			Extent_fail(driver,
					"Expected result : The selected location should have region code || Actual result : The selected Location code don't have region code",
					test, test1);

		}

		Step_End(4, "Verify the Region Code", test, test1);

		Step_Start(5, "Open Regional Trade Mapping Screen", test, test1);

		moduleNavigate(driver, RTM_ModuleName);

		Step_End(5, "Open Regional Trade Mapping Screen", test, test1);

		Step_Start(6, "Search the region which is mapped for the port code", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		twoColumnSearchWindow(driver, Regioncode_Header, Twocolumn_Condition, regioncode);

		Step_End(6, "Search the region which is mapped for the port code", test, test1);

		Step_Start(7, "To verify the result whether port code is showing in regional trade mapping screen", test,
				test1);

		waitForElement(driver, RTM_LocationCode_Filter);
		sendKeys(driver, RTM_LocationCode_Filter, GlobalSearch_value);

		waitForElement(driver, RTM_TableHeader);

		List<Map<String, String>> gridvalues = getTableData(driver, RTM_TableHeader, RTM_TableRowValues);

		String Location_Codes = "";

		for (Map<String, String> locations : gridvalues) {

			Location_Codes = locations.get(GlobalSearch_option);

		}

		if (Location_Codes.equals(GlobalSearch_value)) {

			System.out.println(
					"Expected result : The selected Location code Should show in the Regional trade mappin screen || Actual result : The selected Location code was showing in the Regional trade mappin screen");
			Extent_pass_New(driver,
					"Expected result : The selected Location code Should show in the Regional trade mappin screen || Actual result : The selected Location code was showing in the Regional trade mappin screen",
					test, test1);
		} else {

			System.out.println(
					"Expected result : The selected Location code Should show in the Regional trade mappin screen || Actual result : The selected Location code was not showing in the Regional trade mappin screen");
			Extent_fail(driver,
					"Expected result : The selected Location code Should show in the Regional trade mappin screen || Actual result : The selected Location code was not showing in the Regional trade mappin screen",
					test, test1);

		}

		Step_Start(7, "To verify the result whether port code is showing in regional trade mapping screen", test,
				test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
