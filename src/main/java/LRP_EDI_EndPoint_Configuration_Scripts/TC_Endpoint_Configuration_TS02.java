package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS02 extends Keywords {

	public void Endpoint_Configuration_TS02(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS02";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String PartnerID_Header = Excel_data.get("PartnerID_Header");
		String Partner_Id = Excel_data.get("Partner_Id");
		String Twocolumnsearch_Condition = Excel_data.get("Twocolumnsearch_Condition");
		String Profile_Id = Excel_data.get("Profile_Id");
		String SFTP = Excel_data.get("SFTP");
		String Mode_Option = Excel_data.get("Mode_Option");
		String API_Option = Excel_data.get("API_Option");
		String Type_Option = Excel_data.get("Type_Option");
		String Status_Option = Excel_data.get("Status_Option");
		String FTPUrl = Excel_data.get("FTPUrl");
		String FTPUserId = Excel_data.get("FTPUserId");
		String FTP_Password = Excel_data.get("FTP_Password");
		String Port_Count = Excel_data.get("Port_Count");
		String Directory = Excel_data.get("Directory");
		String DSA = Excel_data.get("DSA");
		String RSA = Excel_data.get("RSA");
		String Login_Type = Excel_data.get("Login_Type");
		String Account_value = Excel_data.get("Account_value");
		String Encryption = Excel_data.get("Encryption");
		String JSCH = Excel_data.get("JSCH");
		String Key = Excel_data.get("Key");
		String Filepath = Excel_data.get("Filepath");
		String Pass_Phrase = Excel_data.get("Pass_Phrase");
		String NoOfFiles = Excel_data.get("NoOfFiles");
		String IntervalTime = Excel_data.get("IntervalTime");
		String ScheduleTime1 = Excel_data.get("ScheduleTime1");
		String ScheduleTime2 = Excel_data.get("ScheduleTime2");
		String Schedule_Days = Excel_data.get("Schedule_Days");
		String Temp_Writing = Excel_data.get("Temp_Writing");
		String Archive = Excel_data.get("Archive");
		String Archive_Option = Excel_data.get("Archive_Option");
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

		if (SFTP.equals("Yes")) {

			waitForElement(driver, EC_SFTP_Checkbox);
			click(driver, EC_SFTP_Checkbox);

		}

		Step_End(3, "Click the SFTP check button", test, test1);

		Step_Start(4, "Select the mode into Passive", test, test1);

		if (!Mode_Option.equals("")) {

			waitForElement(driver, EC_Mode_Dropdown);
			click(driver, EC_Mode_Dropdown);

			formatLocatorClick(driver, DropDown_Select, Mode_Option);

		}

		Step_End(4, "Select the mode into Passive", test, test1);

		Step_Start(5, "Select the type into Binary", test, test1);

		if (!Type_Option.equals("")) {

			waitForElement(driver, EC_Type_Dropdown);
			click(driver, EC_Type_Dropdown);

			formatLocatorClick(driver, DropDown_Select, Type_Option);

		}

		Step_End(5, "Select the type into Binary", test, test1);

		Step_Start(6, "Select the API into 'Apache'", test, test1);

		if (!API_Option.equals("")) {

			waitForElement(driver, EC_API_Dropdown);
			click(driver, EC_API_Dropdown);

			formatLocatorClick(driver, DropDown_Select, API_Option);

		}

		Step_End(6, "Select the API into 'Apache'", test, test1);

		Step_Start(7, "Select the Status as 'Inactive'", test, test1);

		if (!Status_Option.equals("")) {

			waitForElement(driver, EC_Status_Dropdown);
			click(driver, EC_Status_Dropdown);

			formatLocatorClick(driver, DropDown_Select, Status_Option);

		}

		Step_End(7, "Select the Status as 'Inactive'", test, test1);

		Step_Start(8, "Enter any URL in text field", test, test1);

		waitForElement(driver, EC_FTP_Url_input);
		sendKeys(driver, EC_FTP_Url_input, FTPUrl);

		Step_End(8, "Enter any URL in text field", test, test1);

		Step_Start(9, "Enter the user id text field", test, test1);

		waitForElement(driver, EC_FTP_UserId_input);
		sendKeys(driver, EC_FTP_UserId_input, FTPUserId);

		Step_End(9, "Enter the user id text field", test, test1);

		Step_Start(10, "Enter the password text field ", test, test1);

		waitForElement(driver, EC_FTP_Password_input);
		sendKeys(driver, EC_FTP_Password_input, FTP_Password);

		Step_End(10, "Enter the password text field ", test, test1);

		Step_Start(11, "Enter the Port in text field", test, test1);

		if (!Port_Count.equals("")) {

			waitForElement(driver, EC_Port_Input);
			clear(driver, EC_Port_Input);
			sendKeys(driver, EC_Port_Input, Port_Count);

		}

		Step_End(11, "Enter the Port in text field", test, test1);

		Step_Start(12, "Enter the directory text field", test, test1);

		if (!Directory.equals("")) {

			waitForElement(driver, EC_Directory_Input);
			sendKeys(driver, EC_Directory_Input, Directory);

		}

		Step_End(12, "Enter the directory text field", test, test1);

		Step_Start(13, "elect the RSA check box", test, test1);

		if (RSA.equals("Yes")) {

			waitForElement(driver, EC_RSA_Checkbox);
			click(driver, EC_RSA_Checkbox);

		}

		Step_End(13, "Select the RSA check box", test, test1);

		Step_Start(14, "Select the DSA check box", test, test1);

		if (DSA.equals("Yes")) {

			waitForElement(driver, EC_DSA_Checkbox);
			click(driver, EC_DSA_Checkbox);

		}

		Step_End(14, "Select the DSA check box", test, test1);

		Step_Start(15, "Select the Login type as Account", test, test1);

		if (!Login_Type.equals("")) {

			waitForElement(driver, EC_LoginType_Dropdown);
			click(driver, EC_LoginType_Dropdown);

			formatLocatorClick(driver, DropDown_Select, Login_Type);

			if (Login_Type.equals("Account")) {

				waitForElement(driver, EC_AccountInput);
				sendKeys(driver, EC_AccountInput, Account_value);
			}

			waitForElement(driver, EC_Encryption_Dropdown);
			click(driver, EC_Encryption_Dropdown);

			formatLocatorClick(driver, DropDown_Select, Encryption);

		}

		Step_End(15, "Select the Login type as Account", test, test1);

		Step_Start(16, "Select the JSCH check box", test, test1);

		if (JSCH.equals("Yes")) {

			waitForElement(driver, EC_JSCH_Checkbox);
			click(driver, EC_JSCH_Checkbox);

		}

		Step_End(16, "Select the JSCH check box", test, test1);

		Step_Start(17, "Select the Key check box", test, test1);

		if (Key.equals("Yes")) {

			waitForElement(driver, EC_Key_Checkbox);
			click(driver, EC_Key_Checkbox);

		}

		Step_End(17, "Select the Key check box", test, test1);

		Step_Start(18, "Enter the file path text field", test, test1);

		if (!Filepath.equals("")) {

			waitForElement(driver, EC_Filepath_Input);
			sendKeys(driver, EC_Filepath_Input, Filepath);

		}

		Step_End(18, "Enter the file path text field", test, test1);

		Step_Start(19, "Enter the pass pharse text field", test, test1);

		if (!Pass_Phrase.equals("")) {

			waitForElement(driver, EC_PassPhrase_Input);
			sendKeys(driver, EC_PassPhrase_Input, Pass_Phrase);

		}

		Step_End(19, "Enter the pass pharse text field", test, test1);

		Step_Start(20, "Enter the No.of file text field", test, test1);

		if (!NoOfFiles.equals("")) {

			waitForElement(driver, EC_Numoffiles_Input);
			clear(driver, EC_Numoffiles_Input);
			sendKeys(driver, EC_Numoffiles_Input, NoOfFiles);

		}

		Step_End(20, "Enter the No.of file text field", test, test1);

		Step_Start(21, "Enter the Interval(Mins) text field", test, test1);

		if (!IntervalTime.equals("")) {

			waitForElement(driver, EC_Interval_Input);
			sendKeys(driver, EC_Interval_Input, IntervalTime);

		}

		Step_End(21, "Enter the Interval(Mins) text field", test, test1);

		Step_Start(22, "Select the schedule time and Select the second schedule time", test, test1);

		if (!ScheduleTime1.equals("")) {

			waitForElement(driver, EC_ScheduleTime_Input);
			Newclear(driver, EC_ScheduleTime_Input);
			sendKeys(driver, EC_ScheduleTime_Input, ScheduleTime1);

		}

		if (!ScheduleTime2.equals("")) {

			waitForElement(driver, EC_ScheduleTime_Input2);
			Newclear(driver, EC_ScheduleTime_Input2);
			sendKeys(driver, EC_ScheduleTime_Input2, ScheduleTime2);

		}

		Step_End(22, "Select the schedule time and Select the second schedule time", test, test1);

		Step_Start(23, "Select the schedule date", test, test1);

		waitForElement(driver, EC_ScheduleDays_drodown);
		click(driver, EC_ScheduleDays_drodown);

		formatLocatorClick(driver, DropDown_Select, Schedule_Days);

		Step_End(23, "Select the schedule date", test, test1);

		Step_Start(24, "Select the temp writing", test, test1);

		if (Temp_Writing.equals("Yes")) {

			waitForElement(driver, EC_Temp_Checkbox);
			click(driver, EC_Temp_Checkbox);

		}

		Step_End(24, "Select the temp writing", test, test1);

		Step_Start(25, "Select the Archive (NO Action)", test, test1);

		if (Archive.equals("Yes")) {

			waitForElement(driver, EC_Archieve_Dropdown);
			click(driver, EC_Archieve_Dropdown);

			formatLocatorClick(driver, DropDown_Select, Archive_Option);

		}

		Step_End(25, "Select the Archive (NO Action)", test, test1);

		Step_Start(26, " enter the job code text field", test, test1);

		waitForElement(driver, EC_FTP_JobCode_input);
		sendKeys(driver, EC_FTP_JobCode_input, FTP_Jobcode);

		Step_End(26, "Enter the job code text field", test, test1);

		Step_Start(14,
				"Enter the job code and click the save button and popup show like this 'EDI Transmission profiler details saved'",
				test, test1);

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

		Step_End(14,
				"Enter the job code and click the save button and popup show like this 'EDI Transmission profiler details saved'",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
