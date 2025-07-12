package LRP_Detention_Waiver_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_001 extends Keywords {

	public void Detention_Waiver_TS_001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_001";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Module = Excel_data.get("Detention_Module");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		
		
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		Step_Start(1, "switch to AgencyUser ", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to AgencyUser ", test, test1);

		Step_Start(2, "switch to Detention_Waiver module  ", test, test1);

		moduleNavigate(driver, Module);

		Step_End(2, "switch to Detention_Waiver module  ", test, test1);

		Step_Start(3, "Click on new button", test, test1);

		newButton(driver);

		Step_End(3, "Click on new button", test, test1);

		Step_Start(4, "booking search button enabled", test, test1);

		waitForDisplay(driver, DW_BookingNo_Search);

		if (isElementEnabled(driver, DW_BookingNo_Search)) {

			System.out.println(
					" Expected result is : Booking search button should be enabled || Actual result is : Booking search button is enabled");
			Extent_pass_New(driver,
					" Expected result is : Booking search button should be enabled || Actual result is : Booking search button is enabled",
					test, test1);
		} else {
			System.out.println(
					" Expected result is : Booking search button should be enabled || Actual result is : Booking search button is not enabled");
			Extent_fail(driver,
					" Expected result is : Booking search button should be enabled || Actual result is : Booking search button is not enabled",
					test, test1);
		}

		Step_End(4, "Click on new button", test, test1);

		Step_Start(5, "Waiver for option is enabled", test, test1);

		waitForDisplay(driver, DW_Waiver_For_option);

		if (isElementEnabled(driver, DW_Waiver_For_option)) {

			System.out.println(
					" Expected result is : 'Waiver For' Dropdown should be enabled || Actual result is : 'Waiver For' Dropdown  is enabled");
			Extent_pass_New(driver,
					" Expected result is : 'Waiver For' Dropdown  should be enabled || Actual result is : 'Waiver For' Dropdown  is enabled",
					test, test1);
		} else {
			System.out.println(
					" Expected result is : 'Waiver For' Dropdown  should be enabled || Actual result is : 'Waiver For' Dropdown  is not enabled");
			Extent_fail(driver,
					" Expected result is : 'Waiver For' Dropdown  should be enabled || Actual result is : 'Waiver For' Dropdown  is not enabled",
					test, test1);
		}

		Step_End(5, "Waiver for option is enabled", test, test1);

		Step_Start(6, "Storage button is enabled", test, test1);

		waitForDisplay(driver, DW_Storage_Option);

		if (isElementEnabled(driver, DW_Storage_Option)) {

			System.out.println(
					" Expected result is : Storage button should be enabled || Actual result is : Storage button is enabled");
			Extent_pass_New(driver,
					" Expected result is : Storage button should be enabled || Actual result is : Storage button is enabled",
					test, test1);
		} else {
			System.out.println(
					" Expected result is : Storage button should be enabled || Actual result is : Storage button is not enabled");
			Extent_fail(driver,
					" Expected result is : Storage button should be enabled || Actual result is : Storage button is not enabled",
					test, test1);
		}

		Step_End(6, "StorageOption is enabled", test, test1);

		Step_Start(7, "DetentionOption is enabled", test, test1);

		waitForDisplay(driver, DW_Detention_Option);
		if (isElementEnabled(driver, DW_Detention_Option)) {

			System.out.println(
					" Expected result is : Detention button should be enabled || Actual result is : Detention button is enabled");
			Extent_pass_New(driver,
					" Expected result is : Detention button should be enabled || Actual result is : Detention button is enabled",
					test, test1);
		} else {
			System.out.println(
					" Expected result is : Detention button should be enabled || Actual result is : Detention button is not enabled");
			Extent_fail(driver,
					" Expected result is : Detention button should be enabled || Actual result is : Detention button is not enabled",
					test, test1);
		}

		Step_End(7, "DetentionOption is enabled", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
