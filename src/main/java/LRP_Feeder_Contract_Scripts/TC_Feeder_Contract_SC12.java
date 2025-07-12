package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC12 extends Keywords {

	public void Feeder_Contract_SC12(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC12";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Vendor_Header = Excel_data.get("Vendor_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String POL_Header = Excel_data.get("POL_Header");
		String POL_Value = Excel_data.get("POL_Value");
		String Pickup_Value_Special = Excel_data.get("Pickup_Value_Special");
		String Pickup_Value_Invalid = Excel_data.get("Pickup_Value_Invalid");
		String Pickup_Value = Excel_data.get("Pickup_Value");

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

		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);

		twoColumnSearchWindow(driver, POL_Header, Two_Column_Condition, POL_Value);

		waitForElement(driver, FC_PickupInput);

		Step_End(4, "It show the Feeder Contract input details page.", test, test1);

		Step_Start(5, "Enter the value in the pick terminal ", test, test1);

		click(driver, FC_PickupInput);
		sendKeys(driver, FC_PickupInput, Pickup_Value_Special);

		Tab(driver);

		waitForElement(driver, FC_PickupInput);
		String act_Specialtext = getAttribute(driver, FC_PickupInput, "value");

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

		waitForElement(driver, FC_PickupInput);
		Newclear(driver, FC_PickupInput);
		sendKeys(driver, FC_PickupInput, Pickup_Value_Invalid);

		Tab(driver);

		waitForElement(driver, FC_PickupInput);
		String morecharacters = getAttribute(driver, FC_PickupInput, "value");

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

		waitForElement(driver, FC_PickupInput);
		Newclear(driver, FC_PickupInput);
		sendKeys(driver, FC_PickupInput, Pickup_Value);

		Tab(driver);

		waitForElement(driver, FC_PickupInput);
		String actual_Pickup = getAttribute(driver, FC_PickupInput, "value");

		if (Pickup_Value.equals(actual_Pickup)) {

			System.out.println(
					"Expected result : User should be able to select the pickup terminal value using entering the value || Actual result : User can able to select the pickup terminal value using entering the value");
			Extent_pass_New(driver,
					"Expected result : User should be able to select the pickup terminal value using entering the value || Actual result : User can able to select the pickup terminal value using entering the value",
					test, test1);
		} else {

			System.out.println(
					"Expected result : User should be able to select the pickup terminal value using entering the value || Actual result : User cannot able to select the pickup terminal value using entering the value");
			Extent_fail(driver,
					"Expected result : User should be able to select the pickup terminal value using entering the value || Actual result : User cannot able to select the pickup terminal value using entering the value",
					test, test1);

		}

		Step_End(5, "Enter the value in the pick terminal ", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

	}

}
