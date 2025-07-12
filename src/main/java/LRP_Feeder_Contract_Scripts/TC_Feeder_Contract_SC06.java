package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC06 extends Keywords {
	public void Feeder_Contract_SC06(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testcase_Name = "TC_Feeder_Contract_SC06";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Limit_Of_POL_Input_size_Input = Excel_data.get("Limit_Of_POL_Input_size_Input");
		String POL_Value_Special = Excel_data.get("POL_Value_Special");
		String POL_Input_Value = Excel_data.get("POL_Input_Value");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, ".Enter the  screen name as 'Feeder contracts' in module search field", test, test1);

		moduleNavigate(driver, Feeder_Contract_Module_Name);

		Step_End(1, ".Enter the  screen name as 'Feeder contracts' in module search field", test, test1);
		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master.",
				test, test1);

		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);

		twoColumnMultipleSearchWindow(driver, Vendor_Code_Header, condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master.",
				test, test1);
		Step_Start(3, "Click on the \"+\" Button to add the all details ", test, test1);
		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);

		Step_End(3, "Click on the \"+\" Button to add the all details ", test, test1);
		Step_Start(4, "It show the Feeder Contract input details page.", test, test1);
		waitForDisplay(driver, FC_Feeder_Contract_Input_Page);
		if (isdisplayed(driver, FC_Feeder_Contract_Input_Page)) {
			System.out.println(
					"Expected Result is : Feeder Contract-Input Details Page should be opened || Actual Result is : Feeder Contract-Input Details page is opened ");
			Extent_pass_New(driver,
					"Expected Result is : Feeder Contract-Input Details Page should be opened || Actual Result is : Feeder Contract-Input Details page is opened ",
					test, test1);
		} else {
			System.out.println(
					"Expected Result is : Feeder Contract-Input Details Page should be opened || Actual Result is : Feeder Contract-Input Details page is not opened ");
			Extent_fail(driver,
					"Expected Result is : Feeder Contract-Input Details Page should be opened || Actual Result is : Feeder Contract-Input Details page is not opened ",
					test, test1);
		}
		Step_End(4, "It show the Feeder Contract input details page.", test, test1);
		Step_Start(5, "Click the POL field and enter the value.", test, test1);

		click(driver, FC_POL_Input);
		sendKeys(driver, FC_POL_Input, POL_Value_Special);

		Tab(driver);

		waitForElement(driver, FC_POL_Input);
		String act_Specialtext = getAttribute(driver, FC_POL_Input, "value");

		if (isdisplayed(driver, popup_Message)) {

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			System.out.println(
					"Expected result : The POL field should only allow Alphanumeric letters || Actual result : The POL field only allows Alphanumeric letters");

			Extent_pass_New(driver,
					"Expected result : The POL field should only allow Alphanumeric letters || Actual result : The POL field only allows Alphanumeric letters",
					test, test1);

		} else {

			if (checkspecial(driver, act_Specialtext) == false) {

				System.out.println(
						"Expected result : The POL field should only allow Alphanumeric letters || Actual result : The POL field only allows Alphanumeric letters");

				Extent_pass_New(driver,
						"Expected result : The POL field should only allow Alphanumeric letters || Actual result : The POL field only allows Alphanumeric letters",
						test, test1);
			} else {
				System.out.println(
						"Expected result : The POL field should only allow Alphanumeric letters || Actual result : The POL allows special characters as well");

				Extent_fail(driver,
						"Expected result : The POL field should only allow Alphanumeric letters || Actual result : The POL allows special characters as well",
						test, test1);

			}
		}

		waitForElement(driver, FC_POL_Input);
		sendKeys(driver, FC_POL_Input, POL_Input_Value);
		tab(driver);

		waitForElement(driver, FC_POL_Input);
		String pickup_Loc = getAttribute(driver, FC_POL_Input, "value");
		int total_pickup_Loc_Size = pickup_Loc.length();

		int exp_pickup_Location_Size = Integer.parseInt(Limit_Of_POL_Input_size_Input);
		if (exp_pickup_Location_Size <= total_pickup_Loc_Size) {
			System.out.println(
					"Matched || The Expected Number of Characters Accept In  POL Field : " + exp_pickup_Location_Size
							+ " || Actual Number of Characters Accept In  POL Field : " + total_pickup_Loc_Size);
			Extent_pass_New(driver,
					"Matched || The Expected Number of Characters Accept In  POL Field : " + exp_pickup_Location_Size
							+ " || Actual Number of Characters Accept In  POL Field : " + total_pickup_Loc_Size,
					test, test1);
		} else {
			System.out.println("Not Matched || The Expected Number of Characters Accept In  POL Field : "
					+ exp_pickup_Location_Size + " || Actual Number of Characters Accept In  POL Field : "
					+ total_pickup_Loc_Size);
			Extent_fail(driver,
					"Not Matched || The Expected Number of Characters Accept In POL  Field : "
							+ exp_pickup_Location_Size + " || Actual Number of Characters Accept In POL Field : "
							+ total_pickup_Loc_Size,
					test, test1);
		}

		Step_End(5, "Click the POL field and enter the value.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
