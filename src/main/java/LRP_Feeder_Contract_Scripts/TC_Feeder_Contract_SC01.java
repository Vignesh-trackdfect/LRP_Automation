package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC01 extends Keywords {
	public void Feeder_Contract_SC01(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC01";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String Conditon = Excel_data.get("Conditon");

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

		waitForElement(driver, FC_Vendor_field);
		String Actual_Vendor_Values = getAttribute(driver, FC_Vendor_field, "value");

		if (Vendor_Code_Value.equals(Actual_Vendor_Values)) {
			System.out.println("Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values);
			Extent_pass_New(driver, "Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values, test, test1);
		} else {
			System.out.println("Not Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values);
			Extent_fail(driver, "Not Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values, test, test1);
		}

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master ",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}