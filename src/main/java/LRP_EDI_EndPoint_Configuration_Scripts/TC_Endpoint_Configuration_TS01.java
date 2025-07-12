package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS01 extends Keywords {

	public void Endpoint_Configuration_TS01(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS01";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String TradingPartner_Popup = Excel_data.get("TradingPartner_Popup");
		String PartnerID_Header = Excel_data.get("PartnerID_Header");
		String Partner_Id = Excel_data.get("Partner_Id");
		String Twocolumnsearch_Condition = Excel_data.get("Twocolumnsearch_Condition");
		String ProfileId_Popup = Excel_data.get("ProfileId_Popup");
		String Profile_Id = Excel_data.get("Profile_Id");
		String FTPUrl_Popup = Excel_data.get("FTPUrl_Popup");
		String FTPUrl = Excel_data.get("FTPUrl");
		String FTPUserId_Popup = Excel_data.get("FTPUserId_Popup");
		String FTPUserId = Excel_data.get("FTPUserId");
		String FTPPassword_Popup = Excel_data.get("FTPPassword_Popup");
		String FTP_Password = Excel_data.get("FTP_Password");
		String FTP_Jobcode_Popup = Excel_data.get("FTP_Jobcode_Popup");
		String FTP_Jobcode = Excel_data.get("FTP_Jobcode");
		String Saved_Popup = Excel_data.get("Saved_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, ModuleName);

		Step_Start(1, "Click on save button", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(1, "Click on save button", test, test1);

		Step_Start(2, "Please enter the Trading partner pop should be show", test, test1);

		waitForPopup(driver, Popup_Message, TradingPartner_Popup);

		String actualpopup = getText(driver, Popup_Message);

		if (TradingPartner_Popup.equals(actualpopup)) {

			System.out.println("Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + actualpopup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + actualpopup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + actualpopup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + actualpopup, test, test1);

		}

		Step_End(2, "Please enter the Trading partner pop should be show", test, test1);

		Step_Start(3, "Select the partner id and Click the save button", test, test1);

		waitForElement(driver, EC_PartnerID_Search);
		click(driver, EC_PartnerID_Search);

		twoColumnSearchWindow(driver, PartnerID_Header, Twocolumnsearch_Condition, Partner_Id);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(3, "Select the partner id and Click the save button", test, test1);

		Step_Start(4, "Select the partner id and Click the save button", test, test1);

		waitForPopup(driver, Popup_Message, ProfileId_Popup);

		String ProfId_popup = getText(driver, Popup_Message);

		if (ProfileId_Popup.equals(ProfId_popup)) {

			System.out.println("Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + ProfId_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + ProfId_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + ProfId_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + ProfId_popup, test, test1);

		}

		Step_End(4, "Select the partner id and Click the save button", test, test1);

		Step_Start(5, "Enter any data in profile id text filed", test, test1);

		waitForElement(driver, EC_ProfileId_Input);
		sendKeys(driver, EC_ProfileId_Input, Profile_Id);

		Step_End(5, "Enter any data in profile id text filed", test, test1);

		Step_Start(6, "Click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Click the save button", test, test1);

		Step_Start(7, "popup should show like this Please enter the ftp url", test, test1);

		waitForPopup(driver, Popup_Message, FTPUrl_Popup);

		String ActUrl_popup = getText(driver, Popup_Message);

		if (FTPUrl_Popup.equals(ActUrl_popup)) {

			System.out.println("Matched || Expected popup message was : " + FTPUrl_Popup
					+ " || Actual popup message was : " + ActUrl_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + FTPUrl_Popup
					+ " || Actual popup message was : " + ActUrl_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + FTPUrl_Popup
					+ " || Actual popup message was : " + ActUrl_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + FTPUrl_Popup
					+ " || Actual popup message was : " + ActUrl_popup, test, test1);

		}

		Step_End(7, "popup should show like this Please enter the ftp url", test, test1);

		Step_Start(8, "Enter any url and Click the save button", test, test1);

		waitForElement(driver, EC_FTP_Url_input);
		sendKeys(driver, EC_FTP_Url_input, FTPUrl);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Enter any url and Click the save button", test, test1);

		Step_Start(9, "popup should show like this 'Please enter the FTP User Id'", test, test1);

		waitForPopup(driver, Popup_Message, FTPUserId_Popup);

		String ActUser_popup = getText(driver, Popup_Message);

		if (FTPUserId_Popup.equals(ActUser_popup)) {

			System.out.println("Matched || Expected popup message was : " + FTPUserId_Popup
					+ " || Actual popup message was : " + ActUser_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + FTPUserId_Popup
					+ " || Actual popup message was : " + ActUser_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + FTPUserId_Popup
					+ " || Actual popup message was : " + ActUser_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + FTPUserId_Popup
					+ " || Actual popup message was : " + ActUser_popup, test, test1);

		}

		Step_End(9, "popup should show like this 'Please enter the FTP User Id'", test, test1);

		Step_Start(10, "Enter the user id and Click the save button", test, test1);

		waitForElement(driver, EC_FTP_UserId_input);
		sendKeys(driver, EC_FTP_UserId_input, FTPUserId);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(10, "Enter the user id and Click the save button", test, test1);

		Step_Start(11, "popup should show like this Please enter the ftp password", test, test1);

		waitForPopup(driver, Popup_Message, FTPPassword_Popup);

		String ActPass_popup = getText(driver, Popup_Message);

		if (FTPPassword_Popup.equals(ActPass_popup)) {

			System.out.println("Matched || Expected popup message was : " + FTPPassword_Popup
					+ " || Actual popup message was : " + ActPass_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + FTPPassword_Popup
					+ " || Actual popup message was : " + ActPass_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + FTPPassword_Popup
					+ " || Actual popup message was : " + ActPass_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + FTPPassword_Popup
					+ " || Actual popup message was : " + ActPass_popup, test, test1);

		}

		Step_End(11, "popup should show like this Please enter the ftp password", test, test1);

		Step_Start(12, "Enter the password and click save button", test, test1);

		waitForElement(driver, EC_FTP_Password_input);
		sendKeys(driver, EC_FTP_Password_input, FTP_Password);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(12, "Enter the password and click save button", test, test1);

		Step_Start(13, "Entpup should show like Please enter the Job Code", test, test1);

		waitForPopup(driver, Popup_Message, FTP_Jobcode_Popup);

		String ActJobCode_popup = getText(driver, Popup_Message);

		if (FTP_Jobcode_Popup.equals(ActJobCode_popup)) {

			System.out.println("Matched || Expected popup message was : " + FTP_Jobcode_Popup
					+ " || Actual popup message was : " + ActJobCode_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + FTP_Jobcode_Popup
					+ " || Actual popup message was : " + ActJobCode_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + FTP_Jobcode_Popup
					+ " || Actual popup message was : " + ActJobCode_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + FTP_Jobcode_Popup
					+ " || Actual popup message was : " + ActJobCode_popup, test, test1);

		}

		Step_End(13, "Entpup should show like Please enter the Job Code", test, test1);

		Step_Start(14,
				"Enter the job code and click the save button and popup show like this 'EDI Transmission profiler details saved'",
				test, test1);

		waitForElement(driver, EC_FTP_JobCode_input);
		sendKeys(driver, EC_FTP_JobCode_input, FTP_Jobcode);

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

		Step_End(14,
				"Enter the job code and click the save button and popup show like this 'EDI Transmission profiler details saved'",
				test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
	}

}
