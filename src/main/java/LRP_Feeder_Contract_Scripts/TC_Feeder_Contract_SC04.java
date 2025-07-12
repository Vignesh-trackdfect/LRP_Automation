package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC04 extends Keywords {
	public void Feeder_Contract_SC04(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC04";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String Conditon = Excel_data.get("Conditon");
		String FC_Feeder_Contract_Input_Pagename = Excel_data.get("FC_Feeder_Contract_Input_Pagename");

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

		Step_Start(3, "Click on the '+' Button to add the all details", test, test1);
		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);
		Step_End(3, "Click on the '+' Button to add the all details", test, test1);

		Step_Start(4, "It show the Feeder Contract Input Details page", test, test1);
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

		waitForElement(driver, FC_Feeder_Contract_Input_Page);
		String FC_Input_Page = getText(driver, FC_Feeder_Contract_Input_Page);

		if (FC_Feeder_Contract_Input_Pagename.equals(FC_Input_Page)) {
			System.out.println("Expetced Result is  :" + FC_Feeder_Contract_Input_Pagename + "||  Actual Result is : "
					+ FC_Input_Page);
			Extent_pass_New(driver, "Expetced Result is  :" + FC_Feeder_Contract_Input_Pagename
					+ "||  Actual Result is : " + FC_Input_Page, test, test1);
		} else {
			System.out.println("Expetced Result is  :" + FC_Feeder_Contract_Input_Pagename + "||  Actual Result is : "
					+ FC_Input_Page);
			Extent_fail(driver, "Expetced Result is  :" + FC_Feeder_Contract_Input_Pagename + "||  Actual Result is : "
					+ FC_Input_Page, test, test1);
		}

		Step_End(4, "It show the Feeder Contract Input Details page", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}