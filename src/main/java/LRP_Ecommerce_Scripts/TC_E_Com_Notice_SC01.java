package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_E_Com_Notice_SC01 extends Keywords {

	public void E_Com_Notice_SC01(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_E_Com_Notice_SC01";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_Start(1, "Enter \"Ecom notice.\" in the Module Search to access the module.", test, test1);

		moduleNavigate(driver, Module_Name);

		Step_Start(2, " Line and Agency users can access the  Ecom notice", test, test1);

		Extent_call(test, test1, "Access in Line");

		waitForElement(driver, EN_Title_Textfield);
		if (isElementAccessible(driver, EN_Title_Textfield)) {
			System.out.println(
					"Passed || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency user is able to access the Ecom notice");
			Extent_pass_New(driver,
					"Passed || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency user is able to access the Ecom notice",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency  user can't able to access the Ecom notice");
			Extent_fail(driver,
					"Fail || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency user can't able to access the Ecom notice",
					test, test1);
		}

		waitForElement(driver, EN_Browse_Button);
		if (isElementAccessible(driver, EN_Browse_Button)) {
			System.out.println(
					"Passed || Expected result is : Browse button should be enabled || Actual result is : Browse button is enabled");
			Extent_pass_New(driver,
					"Passed || Expected result is : Browse button should be enabled || Actual result is : Browse button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Browse button should be enabled || Actual result is : Browse button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : Browse button should be enabled || Actual result is : Browse button is not enabled",
					test, test1);
		}

//	Agency
		Extent_call(test, test1, "Access in Agency");

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

		Step_End(1, "Enter 'Ecom notice' in the Module Search to access the module.", test, test1);

		waitForElement(driver, EN_Title_Textfield);
		if (isElementAccessible(driver, EN_Title_Textfield)) {
			System.out.println(
					"Passed || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency user is able to access the Ecom notice");
			Extent_pass_New(driver,
					"Passed || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency user is able to access the Ecom notice",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency  user can't able to access the Ecom notice");
			Extent_fail(driver,
					"Fail || Expected result is : Agency user should able to access Ecom Notice || Actual result is : Agency user can't able to access the Ecom notice",
					test, test1);
		}

		waitForElement(driver, EN_Browse_Button);
		if (isElementAccessible(driver, EN_Browse_Button)) {
			System.out.println(
					"Passed || Expected result is : Browse button should be enabled || Actual result is : Browse button is enabled");
			Extent_pass_New(driver,
					"Passed || Expected result is : Browse button should be enabled || Actual result is : Browse button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Browse button should be enabled || Actual result is : Browse button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : Browse button should be enabled || Actual result is : Browse button is not enabled",
					test, test1);
		}

		Step_End(2, " Line and Agency users can access the  Ecom notice", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
