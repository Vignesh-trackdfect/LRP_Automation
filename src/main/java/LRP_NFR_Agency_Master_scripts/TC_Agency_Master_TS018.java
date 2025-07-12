package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS018 extends Keywords {

	public void Agency_Master_TS018(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Agency_Master_TS018";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Select_Agency_Type = Excel_data.get("Select_Agency_Type");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Agency_Master_Module);
		newButton(driver);

		Step_Start(1, "Click the new button and change the Type as 'Corporate'.", test, test1);

		waitForElement(driver, Agency_Type_Input_AM);
		click(driver, Agency_Type_Input_AM);

		formatLocatorClick(driver, DropDown_Select, Select_Agency_Type);
	
		Step_End(1, "Click the new button and change the Type as 'Corporate'.", test, test1);

		Step_Start(2, "Now the Agency dropdown will be enabled.", test, test1);
		waitForElement(driver, Agency_Type_Input_AM);

		if (VerifyElementDisplayed(driver, NetAgency_Input_AM) == true) {

			System.out.println(
					"Expected result is : Net Agency input field should be enabled || Actual result is : Net Agency input field is enabled");
			Extent_pass_New(driver,
					"Expected result is : Net Agency input field should be enabled || Actual result is : Net Agency input field is enabled",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : Net Agency input field should be enabled || Actual result is : Net Agency input field is not enabled");
			Extent_fail(driver,
					"Expected result is : Net Agency input field should be enabled || Actual result is : Net Agency input field is not enabled",
					test, test1);

		}

		Step_End(2, "Now the Agency dropdown will be enabled.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
