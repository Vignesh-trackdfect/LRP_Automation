package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC13 extends Keywords {

	public void Feeder_Contract_SC13(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC13";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String POD_Header = Excel_data.get("POD_Header");
		String POD_Value = Excel_data.get("POD_Value");
		String Drop_Header = Excel_data.get("Drop_Header");
		String Drop_Value = Excel_data.get("Drop_Value");

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

		Step_Start(4, "It show the Feeder Contract input details page.", test, test1);
		
		if (isdisplayed(driver, FC_EquipmentDropdown)) {
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

		waitForElement(driver, FC_POD_Search);
		click(driver, FC_POD_Search);

		twoColumnSearchWindow(driver, POD_Header, Two_Column_Condition, POD_Value);

		waitForElement(driver, FC_DropTerminal);
		click(driver, FC_DropTerminal);

		twoColumnSearchWindow(driver, Drop_Header, Two_Column_Condition, Drop_Value);

		Step_End(4, "It show the Feeder Contract input details page.", test, test1);

		Step_Start(5, "Click the Drop terminal and select the terminal", test, test1);

		waitForElement(driver, FC_DropInput);
		String selectedDrop = getAttribute(driver, FC_DropInput, "value");

		if (Drop_Value.equals(selectedDrop)) {

			System.out.println(
					"Expected result : Users should be able to select the Drop Terminal by using the search functionality || Actual result : Users can able to select the Drop Terminal by using the search functionality");

			Extent_pass_New(driver,
					"Expected result : Users should be able to select the Drop Terminal by using the search functionality || Actual result : Users can able to select the Drop Terminal by using the search functionality",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Users should be able to select the Drop Terminal by using the search functionality || Actual result : Users can not able to select the Drop Terminal by using the search functionality");

			Extent_fail(driver,
					"Expected result : Users should be able to select the Drop Terminal by using the search functionality || Actual result : Users can not able to select the Drop Terminal by using the search functionality",
					test, test1);

		}

		Step_End(5, "Click the Drop terminal and select the terminal", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
