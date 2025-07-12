package LRP_NFR_User_Management_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_User_Management_TS007 extends Keywords {

	public void User_Management_TS007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_User_Management_TS007";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Module = Excel_data.get("User_Management_Module");
		String Select_User_Type = Excel_data.get("Select_User_Type");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Module);

		Step_Start(1, "Click the new button and select the user type as Local agency.", test, test1);

		newButton(driver);

		waitForElement(driver, UserType_Input_UM);
		click(driver, UserType_Input_UM);

		formatLocatorClick(driver, Select_UserOption_UM, Select_User_Type);
	
		waitForElement(driver, UserType_Input_UM);
		Step_End(1, "Click the new button and select the user type as Local agency.", test, test1);

		Step_Start(2, "Branch office dropdown will be enabled below Date format field.", test, test1);

		waitForDisplay(driver, Branch_Input_UM);
		if (isDisplayed(driver, Branch_Input_UM)) {
			System.out.println(
					"Matched || Expected result is : Branch Code Input should be displayed When Select the 'Local Agency' in the User Type input || Actual result is : Branch Code Input is displayed When Select the 'Local Agency' in the User Type input");
			Extent_pass_New(driver,
					"Matched || Expected result is : Branch Code Input should be displayed When Select the 'Local Agency' in the User Type input || Actual result is : Branch Code Input is displayed When Select the 'Local Agency' in the User Type input",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is : Branch Code Input should be displayed When Select the 'Local Agency' in the User Type input || Actual result is : Branch Code Input is not displayed When Select the 'Local Agency' in the User Type input");
			Extent_fail(driver,
					"Not Matched || Expected result is : Branch Code Input should be displayed When Select the 'Local Agency' in the User Type input || Actual result is : Branch Code Input is not displayed When Select the 'Local Agency' in the User Type input",
					test, test1);
		}
		Step_End(2, "Branch office dropdown will be enabled below Date format field.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
