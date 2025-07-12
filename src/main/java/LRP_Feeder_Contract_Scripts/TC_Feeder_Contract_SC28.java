package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC28 extends Keywords {

	public void Feeder_Contract_SC28(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC28";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String ValidFrom = Excel_data.get("ValidFrom");
		String ValidTo = Excel_data.get("ValidTo");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);

		twoColumnSearchWindow(driver, Vendor_Header, Two_Column_Condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		Step_Start(3, "Click on the '+' Button to add the all details ", test, test1);

		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);

		Step_End(3, "Click on the '+' Button to add the all details ", test, test1);

		Step_Start(4, "It show the Feeder Contract input details page", test, test1);

		if (isdisplayed(driver, FC_DurationType)) {
			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed");
			Extent_pass_New(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is displayed",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed");
			Extent_fail(driver,
					"Expected result : Feeder contract input details page should be displayed || Actual result : Feeder contract input details page is not displayed",
					test, test1);

		}

		Step_End(4, "It show the Feeder Contract input details page", test, test1);

		Step_Start(5, "Select the Valid from and Valid to date", test, test1);

		selectDatePicker(driver, FC_ValidFrom, ValidFrom);

		waitForElement(driver, FC_ValidFrom);

		String selected_fromdate = getAttribute(driver, FC_ValidFrom, "value");

		if (ValidFrom.equals(selected_fromdate)) {

			System.out.println("Expected result : The given from date " + ValidFrom
					+ " should be updated in the Valid from field || Actual result : The given from date " + ValidFrom
					+ " was updated in the Valid from field");
			Extent_pass_New(driver,
					"Expected result : The given from date " + ValidFrom
							+ " should be updated in the Valid from field || Actual result : The given from date "
							+ ValidFrom + " was updated in the Valid from field",
					test, test1);

		} else {

			System.out.println("Expected result : The given from date " + ValidFrom
					+ " should be updated in the Valid from field || Actual result : The given from date " + ValidFrom
					+ " was not updated in the Valid from field");
			Extent_fail(driver,
					"Expected result : The given from date " + ValidFrom
							+ " should be updated in the Valid from field || Actual result : The given from date "
							+ ValidFrom + " was not updated in the Valid from field",
					test, test1);
		}

		selectDatePicker(driver, FC_ValidTo, ValidTo);

		waitForElement(driver, FC_ValidFrom);

		String selected_Todate = getAttribute(driver, FC_ValidFrom, "value");

		if (ValidTo.equals(selected_Todate)) {

			System.out.println("Expected result : The given To date " + ValidFrom
					+ " should be updated in the Valid To field || Actual result : The given To date " + ValidFrom
					+ " was updated in the Valid To field");
			Extent_pass_New(driver,
					"Expected result : The given from date " + ValidFrom
							+ " should be updated in the Valid To field || Actual result : The given from date "
							+ ValidFrom + " was updated in the Valid To field",
					test, test1);

		} else {

			System.out.println("Expected result : The given from date " + ValidFrom
					+ " should be updated in the Valid To field || Actual result : The given from date " + ValidFrom
					+ " was not updated in the Valid To field");
			Extent_fail(driver,
					"Expected result : The given from date " + ValidFrom
							+ " should be updated in the Valid To field || Actual result : The given from date "
							+ ValidFrom + " was not updated in the Valid To field",
					test, test1);
		}

		Step_End(5, "Select the Valid from and Valid to date", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
