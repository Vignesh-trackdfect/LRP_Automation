package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC002 extends Keywords {

	public void Import_Invoice_SC002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Import_Invoice_SC002";
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String import_Invoice_Module = Excel_data.get("import_Invoice_Module");

		Extent_Start(tc_Name, test, test1);

		Step_Start(1, "Open the import invoice module .", test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, import_Invoice_Module);

		Step_End(1, "Open the import invoice module .", test, test1);

		Step_Start(2, "in tool bar home button,search field,navigate , search field  and invoice mode only enable",
				test, test1);

		waitForElement(driver, home_Btn_IN);
		if (isElementEnabled(driver, home_Btn_IN)) {

			System.out.println(
					"Pass || Expected result is : Home button should be in enable status || Actual result is : Home button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Home button should be in enable status || Actual result is : Home button is enabled",
					test, test1);
		} else {

			System.out.println(
					"Fail || Expected result is : Home button should be in enable status || Actual result is : Home button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : Home button should be in enable status || Actual result is : Home button is not enabled",
					test, test1);
		}

		if (isElementEnabled(driver, SearchButton_Toolbar)) {

			System.out.println(
					"Pass || Expected result is : Search button should be in enable status || Actual result is : Search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Search button should be in enable status || Actual result is : Search button is enabled",
					test, test1);
		} else {

			System.out.println(
					"Fail || Expected result is : Search button should be in enable status || Actual result is : Search button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : Search button should be in enable status || Actual result is : Search button is not enabled",
					test, test1);
		}

		if (isElementEnabled(driver, first_Common_btn)) {

			System.out.println(
					"Pass || Expected result is : Previous button should be in enable status || Actual result is : Previous button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Previous button should be in enable status || Actual result is : Previous button is enabled",
					test, test1);
		} else {

			System.out.println(
					"Fail || Expected result is : Previous button should be in enable status || Actual result is : Previous button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : Previous button should be in enable status || Actual result is : Previous button is not enabled",
					test, test1);
		}

		if (isElementEnabled(driver, last_Common_btn)) {

			System.out.println(
					"Pass || Expected result is : Last button should be in enable status || Actual result is : Last button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Last button should be in enable status || Actual result is : Last button is enabled",
					test, test1);
		} else {

			System.out.println(
					"Fail || Expected result is : Last button should be in enable status || Actual result is : Last button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : Last button should be in enable status || Actual result is : Last button is not enabled",
					test, test1);
		}

		Step_End(2, "in tool bar home button,search field,navigate , search field  and invoice mode only enable", test,
				test1);

		Step_Start(3, "click the new button ", test, test1);

		newButton(driver);

		Step_End(3, "click the new button ", test, test1);

		Step_Start(4, "verify that system has automatically select the BY BLNumber option", test, test1);

		waitForElement(driver, by_Bl_Number_IN);

		if (isElementSelected(driver, by_Bl_Number_IN)) {

			System.out.println(
					"Pass || Expected result is : System should select the By BL Number autometically || Actual result is : After click the New button, By BL Number automatically selected");
			Extent_pass_New(driver,
					"Pass || Expected result is : System should select the By BL Number autometically || Actual result is : After click the New button, By BL Number automatically selected",
					test, test1);
		} else {

			System.out.println(
					"Fail || Expected result is : System should select the By BL Number autometically || Actual result is : After click the New button, By BL Number not automatically selected");
			Extent_fail(driver,
					"Fail || Expected result is : System should select the By BL Number autometically || Actual result is : After click the New button, By BL Number not automatically selected",
					test, test1); 
		}

		Step_End(4, "verify that system has automatically select the BY BLNumber option", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
