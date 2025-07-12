package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC26 extends Keywords {

	public void Feeder_Contract_SC26(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC26";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Basis_Option = Excel_data.get("Basis_Option");

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

		if (isdisplayed(driver, FC_BasisDropdown)) {
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

		Step_Start(5, "Select the basis by click the Drop down", test, test1);

		waitForElement(driver, FC_BasisDropdown);
		click(driver, FC_BasisDropdown);

		formatLocatorClick(driver, DropDown_Select, Basis_Option);

		waitForElement(driver, FC_BasisDropdown);

		String selected_option = getText(driver, FC_BasisDropdown);

		if (Basis_Option.equals(selected_option)) {

			System.out.println("Expected result : The given Basis option " + Basis_Option
					+ " should be selected || Actual result :  The given Basis option " + selected_option
					+ " was selected");
			Extent_pass_New(driver,
					"Expected result : The given Basis option " + Basis_Option
							+ " should be selected || Actual result :  The given Basis option " + selected_option
							+ " was selected",
					test, test1);

		} else {

			System.out.println("Expected result : The given Basis option " + Basis_Option
					+ " should be selected || Actual result :  The given Basis option " + selected_option
					+ " was not selected");
			Extent_fail(driver,
					"Expected result : The given Basis option " + Basis_Option
							+ " should be selected || Actual result :  The given Basis option " + selected_option
							+ " was not selected",
					test, test1);

		}

		Step_End(5, "Select the basis by click the Drop down", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
