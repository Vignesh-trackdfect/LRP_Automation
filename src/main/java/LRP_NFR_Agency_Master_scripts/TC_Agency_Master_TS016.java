package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS016 extends Keywords {

	public void Agency_Master_TS016(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Agency_Master_TS016";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Select_Agency_Type = Excel_data.get("Select_Agency_Type");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Agency_Master_Module);

		Step_Start(1, "Click the new button and change the Type as 'OFFICE'.", test, test1);

		newButton(driver);

		waitForElement(driver, Agency_Type_Input_AM);
		click(driver, Agency_Type_Input_AM);
       formatLocatorClick(driver, DropDown_Select, Select_Agency_Type);
	
		waitForElement(driver, Agency_Type_Input_AM);
		Step_End(1, "Click the new button and change the Type as 'OFFICE'.", test, test1);

		Step_Start(2, "Now the Controlling ports and Due days tabs will be enabled", test, test1);

		String controllPortStatus = getAttribute(driver, Controlling_Ports_AM, "class");

		if (controllPortStatus.contains("disabled")) {
			System.out.println(
					"Expected result : 'Controlling Ports' should be enabled When select 'Office' in the Type Input Actual result is : 'Controlling Ports' is not enabled When select 'Office' in the Type Input");
			Extent_fail(driver,
					"Expected result : 'Controlling Ports' should be enabled When select 'Office' in the Type Input Actual result is : 'Controlling Ports' is not enabled When select 'Office' in the Type Input",
					test, test1);
		} else {
			System.out.println(
					"Expected result : 'Controlling Ports' should be enabled When select 'Office' in the Type Input Actual result is : 'Controlling Ports' is enabled When select 'Office' in the Type Input");
			Extent_pass_New(driver,
					"Expected result : 'Controlling Ports' should be enabled When select 'Office' in the Type Input Actual result is : 'Controlling Ports' is enabled When select 'Office' in the Type Input",
					test, test1);
		}

		String DueDateStatus = getAttribute(driver, Due_Date_AM, "class");
		if (DueDateStatus.contains("disabled")) {
			System.out.println(
					"Expected result : 'Due Date' should be enabled When select 'Office' in the Type Input Actual result is : 'Due Date' is not enabled When select 'Office' in the Type Input");
			Extent_fail(driver,
					"Expected result : 'Due Date' should be enabled When select 'Office' in the Type Input Actual result is : 'Due Date' is not enabled When select 'Office' in the Type Input",
					test, test1);
		} else {
			System.out.println(
					"Expected result : 'Due Date' should be enabled When select 'Office' in the Type Input Actual result is : 'Due Date' is enabled When select 'Office' in the Type Input");
			Extent_pass_New(driver,
					"Expected result : 'Due Date' should be enabled When select 'Office' in the Type Input Actual result is : 'Due Date' is enabled When select 'Office' in the Type Input",
					test, test1);
		}

		Step_End(2, "Now the Controlling ports and Due days tabs will be enabled", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
