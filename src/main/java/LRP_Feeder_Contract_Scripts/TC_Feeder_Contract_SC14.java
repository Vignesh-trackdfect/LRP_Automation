package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC14 extends Keywords {

	public void Feeder_Contract_SC14(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC14";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String POD_Header = Excel_data.get("POD_Header");
		String POD_Value = Excel_data.get("POD_Value");
		String Drop_Value_Special = Excel_data.get("Drop_Value_Special");
		String Drop_Value_Invalid = Excel_data.get("Drop_Value_Invalid");
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

		waitForElement(driver, FC_DropInput);

		Step_End(4, "It show the Feeder Contract input details page.", test, test1);

		Step_Start(5, "Enter the value in the Drop terminal", test, test1);

		click(driver, FC_DropInput);
		sendKeys(driver, FC_DropInput, Drop_Value_Special);

		Tab(driver);

		waitForElement(driver, FC_DropInput);
		String act_Specialtext = getAttribute(driver, FC_DropInput, "value");

		if (isdisplayed(driver, popup_Message)) {

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			System.out.println(
					"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters");

			Extent_pass_New(driver,
					"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters",
					test, test1);

		} else {

			if (checkspecial(driver, act_Specialtext) == false) {

				System.out.println(
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters");

				Extent_pass_New(driver,
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters",
						test, test1);
			} else {
				System.out.println(
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point allows special charaters");

				Extent_fail(driver,
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point allows special charaters",
						test, test1);

			}
		}

		waitForElement(driver, FC_DropInput);
		Newclear(driver, FC_DropInput);
		sendKeys(driver, FC_DropInput, Drop_Value_Invalid);

		Tab(driver);

		waitForElement(driver, FC_DropInput);
		String morecharacters = getAttribute(driver, FC_DropInput, "value");

		if (isdisplayed(driver, popup_Message)) {

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			System.out.println(
					"Expected result || The Pickup point field only should allows upto 10 characters || Actual result : The Pickup point field only allows upto 10 characters");
			Extent_pass_New(driver,
					"Expected result || The Pickup point field only should allows upto 10 characters || Actual result : The Pickup point field only allows upto 10 characters",
					test, test1);

		} else {

			if (morecharacters.length() <= 10) {

				System.out.println(
						"Expected result || The Pickup point field only should allows upto 10 characters || Actual result : The Pickup point field only allows upto 10 characters");
				Extent_pass_New(driver,
						"Expected result || The Pickup point field only should allows upto 10 characters || Actual result : The Pickup point field only allows upto 10 characters",
						test, test1);
			} else {

				System.out.println(
						"Expected result || The Pickup point field only should allows upto 10 characters || Actual result : The Pickup point field only allows more than 10 characters");
				Extent_fail(driver,
						"Expected result || The Pickup point field only should allows upto 10 characters || Actual result : The Pickup point field only allows more than 10 characters",
						test, test1);

			}

		}

		waitForElement(driver, FC_DropInput);
		Newclear(driver, FC_DropInput);
		sendKeys(driver, FC_DropInput, Drop_Value);

		Tab(driver);

		waitForElement(driver, FC_DropInput);
		String actual_Drop = getAttribute(driver, FC_DropInput, "value");

		if (Drop_Value.equals(actual_Drop)) {

			System.out.println(
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User can able to select the Drop terminal value using entering the value");
			Extent_pass_New(driver,
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User can able to select the Drop terminal value using entering the value",
					test, test1);
		} else {

			System.out.println(
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User cannot able to select the Drop terminal value using entering the value");
			Extent_fail(driver,
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User cannot able to select the Drop terminal value using entering the value",
					test, test1);

		}

		Step_End(5, "Enter the value in the Drop terminal", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
