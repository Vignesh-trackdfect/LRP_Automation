package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC03 extends Keywords {

	public void Feeder_Contract_SC03(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC03";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String FC_Pop_Message = Excel_data.get("FC_Pop_Message");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);
		moduleNavigate(driver, Feeder_Contract_Module_Name);
		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the + Button to add the all details ", test, test1);
		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);
		Step_End(2, "Click on the + Button to add the all details ", test, test1);

		Step_Start(3, "Check whether the Pop up is shown ", test, test1);

		waitForPopup(driver, popup_Message, FC_Pop_Message);

		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(FC_Pop_Message)) {
			System.out.println("Matched || " + " Expected saved poup : " + FC_Pop_Message + " || Actual saved popup : "
					+ Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + FC_Pop_Message
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + FC_Pop_Message
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + FC_Pop_Message
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);

		}

		Step_End(3, "Check whether the Pop up is shown ", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}