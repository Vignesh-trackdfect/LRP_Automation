package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC21 extends Keywords {
	public void Feeder_Contract_SC21(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testcase_Name = "TC_Feeder_Contract_SC21";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Currency_Defalt_Value = Excel_data.get("Currency_Defalt_Value");

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

		Step_Start(5, "Currency should display default USD", test, test1);

		waitForElement(driver, FC_Currency_Input);
		String Pickup_Location_Value_Act = getAttribute(driver, FC_Currency_Input, "value");

		if (Currency_Defalt_Value.equals(Pickup_Location_Value_Act)) {
			System.out.println("Expected Result : The currency should be defaultly selected as " + Currency_Defalt_Value
					+ " || Actual Default Currency value : " + Pickup_Location_Value_Act);
			Extent_pass_New(driver, "Expected Result : The currency should be defaultly selected as "
					+ Currency_Defalt_Value + " || Actual Default Currency value : " + Pickup_Location_Value_Act, test,
					test1);
		} else {
			System.out.println("Expected Result : The currency should be defaultly selected as " + Currency_Defalt_Value
					+ " || Actual Default Currency value : " + Pickup_Location_Value_Act);
			Extent_fail(driver, "Expected Result : The currency should be defaultly selected as "
					+ Currency_Defalt_Value + " || Actual Default Currency value : " + Pickup_Location_Value_Act, test,
					test1);
		}

		Step_End(5, "Currency should display default USD.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
