package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS04 extends Keywords {

	public void Endpoint_Configuration_TS04(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS04";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String PartnerID_Search = Excel_data.get("PartnerID_Search");
		String ProfileName_Search = Excel_data.get("ProfileName_Search");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, ModuleName);

		Step_Start(1, "Select the given data using profile Id", test, test1);

		waitForElement(driver, EC_ConditionFilter);
		click(driver, EC_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, PartnerID_Search);

		waitForElement(driver, EC_ProfileName_Filter);
		sendKeys(driver, EC_ProfileName_Filter, ProfileName_Search);

		Step_End(1, "Select the given data using profile Id", test, test1);

		Step_Start(2, "Double click the same record from the AG grid", test, test1);

		waitForElement(driver, FTP_GridRow1);
		doubleClick(driver, FTP_GridRow1);

		Step_End(2, "Double click the same record from the AG grid", test, test1);

		Step_Start(3, " click the edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, " click the edit button", test, test1);

		Step_Start(4, "Now we can't able to click the SFTP check box", test, test1);

		if (!isClickable(driver, EC_SFTP_Checkbox)) {

			System.out.println(
					"Expected result is : User should not be able to click the SFTP checkbox || Actual result : User can't able to click the SFTP checkbox");
			Extent_pass_New(driver,
					"Expected result is : User should not be able to click the SFTP checkbox || Actual result : User can't able to click the SFTP checkbox",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : User should not be able to click the SFTP checkbox || Actual result : User can able to click the SFTP checkbox");
			Extent_fail(driver,
					"Expected result is : User should not be able to click the SFTP checkbox || Actual result : User can able to click the SFTP checkbox",
					test, test1);

		}

		Step_End(4, "Now we can't able to click the SFTP check box", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
