package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC05 extends Keywords {
	public void Feeder_Contract_SC05(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC05";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String Conditon = Excel_data.get("Conditon");
		String FC_Input_details_Port_Header = Excel_data.get("FC_Input_details_Port_Header");

		String FC_Input_details_Port_Value = Excel_data.get("FC_Input_details_Port_Value");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field ", test, test1);
		moduleNavigate(driver, Feeder_Contract_Module_Name);
		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master ",
				test, test1);
		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);
		twoColumnSearchWindow(driver, Vendor_Code_Header, Conditon, Vendor_Code_Value);
		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master ",
				test, test1);

		Step_Start(3, "Click on the '+'Button to add the all details", test, test1);
		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);
		Step_End(3, "Click on the '+'Button to add the all details", test, test1);

		Step_Start(4, "It show the Feeder Contract input details page", test, test1);
		waitForDisplay(driver, FC_Feeder_Contract_Input_Page);
		if (isdisplayed(driver, FC_Feeder_Contract_Input_Page)) {
			System.out.println(
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is opened ");
			Extent_pass_New(driver,
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is opened ",
					test, test1);
		} else {
			System.out.println(
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is not opened ");
			Extent_fail(driver,
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is not opened ",
					test, test1);
		}
		Step_Start(4, "It show the Feeder Contract input details page", test, test1);

		Step_Start(5, "Click the POL field and enter the value", test, test1);
		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);

		twoColumnSearchWindow(driver, FC_Input_details_Port_Header, Conditon, FC_Input_details_Port_Value);

		waitForElement(driver, FC_POL_Input);
		String Actual_Pol_Value = getAttribute(driver, FC_POL_Input, "value");

		if (FC_Input_details_Port_Value.equals(Actual_Pol_Value)) {
			System.out.println(" Matched || The Expected value of POL should be : " + FC_Input_details_Port_Value
					+ " || The Actual value of POL is : " + Actual_Pol_Value);
			Extent_pass_New(driver, " Matched || The Expected value of POL should be : " + FC_Input_details_Port_Value
					+ " || The Actual value of POL is : " + Actual_Pol_Value, test, test1);
		} else {
			System.out.println(" Not Matched || The Expected value of POL should be : " + FC_Input_details_Port_Value
					+ " || The Actual value of POL is : " + Actual_Pol_Value);
			Extent_fail(driver, " Not Matched || The Expected value of POL should be : " + FC_Input_details_Port_Value
					+ " || The Actual value of POL is : " + Actual_Pol_Value, test, test1);
		}

		Step_End(5, "Click the POL field and enter the value", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}