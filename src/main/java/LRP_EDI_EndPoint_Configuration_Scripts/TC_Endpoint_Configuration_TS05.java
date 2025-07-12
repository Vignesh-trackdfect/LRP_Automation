package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS05 extends Keywords {

	public void Endpoint_Configuration_TS05(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS05";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String PartnerID_Header = Excel_data.get("PartnerID_Header");
		String Partner_Id = Excel_data.get("Partner_Id");
		String Twocolumnsearch_Condition = Excel_data.get("Twocolumnsearch_Condition");
		String Profile_Id = Excel_data.get("Profile_Id");
		String Filepath = Excel_data.get("Filepath");
		String Pass_Phrase = Excel_data.get("Pass_Phrase");
		String FTPUrl = Excel_data.get("FTPUrl");
		String FTPUserId = Excel_data.get("FTPUserId");
		String FTP_Password = Excel_data.get("FTP_Password");
		String FTP_Jobcode = Excel_data.get("FTP_Jobcode");
		String Saved_Popup = Excel_data.get("Saved_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, ModuleName);

		Step_Start(1, "CSelect the partner id", test, test1);

		waitForElement(driver, EC_PartnerID_Search);
		click(driver, EC_PartnerID_Search);

		twoColumnSearchWindow(driver, PartnerID_Header, Twocolumnsearch_Condition, Partner_Id);

		Step_End(1, "CSelect the partner id", test, test1);

		Step_Start(2, "Enter any data in profile id text field", test, test1);

		waitForElement(driver, EC_ProfileId_Input);
		sendKeys(driver, EC_ProfileId_Input, Profile_Id);

		Step_End(2, "Enter any data in profile id text field", test, test1);

		Step_Start(3, "Click the SFTP check button", test, test1);

		waitForElement(driver, EC_SFTP_Checkbox);
		click(driver, EC_SFTP_Checkbox);

		Step_End(3, "Click the SFTP check button", test, test1);

		Step_Start(4, "Now the  key check box as been enable now click it", test, test1);
		
		waitForDisplay(driver, EC_Key_Checkbox);

		if (isClickable(driver, EC_Key_Checkbox)) {

			System.out.println(
					"Expected result : When the user checked the SFTP Checkbox, key checkbox should get enabled || Actual result is : The Key checkbox is enabled");
			Extent_pass_New(driver,
					"Expected result : When the user checked the SFTP Checkbox, key checkbox should get enabled || Actual result is : The Key checkbox is enabled",
					test, test1);

		} else {

			System.out.println(
					"Expected result : When the user checked the SFTP Checkbox, key checkbox should get enabled || Actual result is : The Key checkbox is not enabled");
			Extent_fail(driver,
					"Expected result : When the user checked the SFTP Checkbox, key checkbox should get enabled || Actual result is : The Key checkbox is not enabled",
					test, test1);

		}

		waitForElement(driver, EC_Key_Checkbox);
		click(driver, EC_Key_Checkbox);

		if (isClickable(driver, EC_JSCH_Checkbox)) {

			System.out.println(
					"Expected result : When the user checked the SFTP Checkbox, JSCH checkbox should get enabled || Actual result is : The JSCH checkbox is enabled");
			Extent_pass_New(driver,
					"Expected result : When the user checked the SFTP Checkbox, JSCH checkbox should get enabled || Actual result is : The JSCH checkbox is enabled",
					test, test1);

		} else {

			System.out.println(
					"Expected result : When the user checked the SFTP Checkbox, JSCH checkbox should get enabled || Actual result is : The JSCH checkbox is not enabled");
			Extent_fail(driver,
					"Expected result : When the user checked the SFTP Checkbox, JSCH checkbox should get enabled || Actual result is : The JSCH checkbox is not enabled",
					test, test1);

		}

		waitForElement(driver, EC_JSCH_Checkbox);
		click(driver, EC_JSCH_Checkbox);

		Step_End(4, "Now the  JSCH check box as been enable now click it", test, test1);

		Step_Start(5, "Now the File path text field , pass pharse  as been enable", test, test1);

		if (isElementEnabled(driver, EC_Filepath_Input)) {

			System.out.println(
					"Expected result : When the user checked the Key Checkbox, File path field should get enabled || Actual result is : The File path field is enabled");
			Extent_pass_New(driver,
					"Expected result : When the user checked the Key Checkbox, File path field should get enabled || Actual result is : The File path field is enabled",
					test, test1);

		} else {

			System.out.println(
					"Expected result : When the user checked the Key Checkbox, File path field should get enabled || Actual result is : The File path field is not enabled");
			Extent_fail(driver,
					"Expected result : When the user checked the Key Checkbox, File path field should get enabled || Actual result is : The File path field is not enabled",
					test, test1);

		}

		if (isElementEnabled(driver, EC_PassPhrase_Input)) {

			System.out.println(
					"Expected result : When the user checked the Key Checkbox, Pass Phrase field should get enabled || Actual result is : The Pass Phrase field is enabled");
			Extent_pass_New(driver,
					"Expected result : When the user checked the Key Checkbox, Pass Phrase field should get enabled || Actual result is : The Pass Phrase field is enabled",
					test, test1);

		} else {

			System.out.println(
					"Expected result : When the user checked the Key Checkbox, Pass Phrase field should get enabled || Actual result is : The Pass Phrase field is not enabled");
			Extent_fail(driver,
					"Expected result : When the user checked the Key Checkbox, Pass Phrase field should get enabled || Actual result is : The Pass Phrase field is not enabled",
					test, test1);

		}

		Step_End(5, "Now the File path text field , pass pharse  as been enable", test, test1);

		Step_Start(6, "Enter the file path", test, test1);

		waitForElement(driver, EC_Filepath_Input);
		sendKeys(driver, EC_Filepath_Input, Filepath);

		Step_End(6, "Enter the file path", test, test1);

		Step_Start(7, "Enter the pass pharse", test, test1);

		waitForElement(driver, EC_PassPhrase_Input);
		sendKeys(driver, EC_PassPhrase_Input, Pass_Phrase);

		waitForElement(driver, EC_FTP_Url_input);
		sendKeys(driver, EC_FTP_Url_input, FTPUrl);

		waitForElement(driver, EC_FTP_UserId_input);
		sendKeys(driver, EC_FTP_UserId_input, FTPUserId);

		waitForElement(driver, EC_FTP_Password_input);
		sendKeys(driver, EC_FTP_Password_input, FTP_Password);

		waitForElement(driver, EC_FTP_JobCode_input);
		sendKeys(driver, EC_FTP_JobCode_input, FTP_Jobcode);

		Step_End(7, "Enter the pass pharse", test, test1);

		Step_Start(8, "Click the save buttton", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Saved_Popup);

		String Actsaved_popup = getText(driver, Popup_Message);

		if (Saved_Popup.equals(Actsaved_popup)) {

			System.out.println("Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		}

		waitForElement(driver, EC_ConditionFilter);
		click(driver, EC_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, Partner_Id);

		waitForElement(driver, EC_ProfileName_Filter);
		sendKeys(driver, EC_ProfileName_Filter, Profile_Id);

		waitForDisplay(driver, FTP_GridRow1);

		if (isdisplayed(driver, FTP_GridRow1)) {

			System.out.println(
					"Expected result : The given data's should be added in the grid || Actual result : The given data's are added in the grid");

			Extent_pass_New(driver,
					"Expected result : The given data's should be added in the grid || Actual result : The given data's are added in the grid",
					test, test1);

		} else {

			System.out.println(
					"Expected result : The given data's should be added in the grid || Actual result : The given data's are not added in the grid");

			Extent_fail(driver,
					"Expected result : The given data's should be added in the grid || Actual result : The given data's are not added in the grid",
					test, test1);

		}

		Step_End(8, "Click the save buttton", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
