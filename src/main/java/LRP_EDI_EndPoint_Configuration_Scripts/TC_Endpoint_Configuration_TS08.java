package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS08 extends Keywords {

	public void Endpoint_Configuration_TS08(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS08";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String SharePath_TabName = Excel_data.get("SharePath_TabName");
		String PartnerId_Header = Excel_data.get("PartnerId_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileId = Excel_data.get("ProfileId");
		String Path_Value = Excel_data.get("Path_Value");
		String Select_Drive = Excel_data.get("Select_Drive");
		String Select_Status = Excel_data.get("Select_Status");
		String SP_Username_value = Excel_data.get("SP_Username_value");
		String SP_Password_value = Excel_data.get("SP_Password_value");
		String Saved_Popup = Excel_data.get("Saved_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the share path tab ", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, SharePath_TabName);

		Step_End(1, "Click the share path tab ", test, test1);

		Step_Start(2, "Select the partner id ", test, test1);

		waitForElement(driver, SP_PartnerId_Search);
		click(driver, SP_PartnerId_Search);

		twoColumnSearchWindow(driver, PartnerId_Header, Search_Condition, PartnerId);

		Step_End(2, "Select the partner id ", test, test1);

		Step_Start(3, "Enter any data in profile id text filed", test, test1);

		waitForElement(driver, SP_ProfileId);
		sendKeys(driver, SP_ProfileId, ProfileId);

		Step_Start(4, "Enter the path in text field", test, test1);

		waitForElement(driver, SP_Path_Input);
		sendKeys(driver, SP_Path_Input, Path_Value);

		Step_End(4, "Enter the path in text field", test, test1);

		Step_Start(5, "Click any one of the drive (Local Drive or Network Drive)", test, test1);

		if (Select_Drive.equals("Local Drive")) {

			checkBox(driver, SP_LocalDrive, "Yes");

		} else {

			checkBox(driver, SP_NetworkDrive, "Yes");
		}

		Step_End(5, "Click any one of the drive (Local Drive or Network Drive)", test, test1);

		Step_Start(6, "Enter the user name", test, test1);

		if (!Select_Status.equals("")) {

			waitForElement(driver, SP_StatusDrodown);
			click(driver, SP_StatusDrodown);

			formatLocatorClick(driver, DropDown_Select, Select_Status);

		}

		if (!SP_Username_value.equals("")) {

			waitForElement(driver, SP_Username);
			sendKeys(driver, SP_Username, SP_Username_value);

		}

		Step_End(6, "Enter the user name", test, test1);

		Step_Start(7, "Enter the password", test, test1);

		if (!SP_Password_value.equals("")) {

			waitForElement(driver, SP_Password);
			sendKeys(driver, SP_Password, SP_Password_value);

		}

		Step_End(7, "Enter the password", test, test1);

		Step_Start(8, "Click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Click the save button", test, test1);

		Step_Start(9, "Now the popup should show like 'EDI Transmission profiler details saved'", test, test1);

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

		waitForElement(driver, SP_ConditionFilter);
		click(driver, SP_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		waitForElement(driver, SP_ProfileName_Filter);
		sendKeys(driver, SP_ProfileName_Filter, ProfileId);

		waitForDisplay(driver, SP_GridRow1);

		if (isdisplayed(driver, SP_GridRow1)) {

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
		

		Step_End(9, "Now the popup should show like 'EDI Transmission profiler details saved'", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
