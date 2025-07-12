package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS11 extends Keywords {

	public void Endpoint_Configuration_TS11(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS11";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String SharePath_TabName = Excel_data.get("SharePath_TabName");
		String Partner_Id = Excel_data.get("Partner_Id");
		String ProfileName = Excel_data.get("ProfileName");
		String New_ProfileId = Excel_data.get("New_ProfileId");
		String Path_Value = Excel_data.get("Path_Value");
		String Select_Drive = Excel_data.get("Select_Drive");
		String SP_Username_value = Excel_data.get("SP_Username_value");
		String SP_Password_value = Excel_data.get("SP_Password_value");
		String Updated_popup = Excel_data.get("Updated_popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the FTP tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, SharePath_TabName);

		Step_End(1, "Click the FTP tab", test, test1);

		Step_Start(2, "dobule click any one of the record from the AG gird", test, test1);

		waitForElement(driver, SP_ConditionFilter);
		click(driver, SP_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, Partner_Id);

		waitForElement(driver, SP_ProfileName_Filter);
		sendKeys(driver, SP_ProfileName_Filter, ProfileName);

		waitForElement(driver, SP_GridRow1);
		doubleClick(driver, SP_GridRow1);

		Step_End(2, "dobule click any one of the record from the AG gird", test, test1);

		Step_Start(3, "Click the edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click the edit button", test, test1);

		Step_Start(4, "Change the profile id", test, test1);

		waitForElement(driver, SP_ProfileId);
		clear(driver, SP_ProfileId);
		sendKeys(driver, SP_ProfileId, New_ProfileId);

		Step_End(4, "Change the profile id", test, test1);

		Step_Start(5, "Change the path", test, test1);

		waitForElement(driver, SP_Path_Input);
		clear(driver, SP_Path_Input);
		sendKeys(driver, SP_Path_Input, Path_Value);

		Step_End(5, "Change the path", test, test1);

		Step_Start(6, "Click the network drive check box", test, test1);

		if (Select_Drive.equals("Local Drive")) {

			checkBox(driver, SP_LocalDrive, "Yes");

		} else {

			checkBox(driver, SP_NetworkDrive, "Yes");
		}

		Step_End(6, "Click the network drive check box", test, test1);

		Step_Start(7, "Enter the username and password", test, test1);

		waitForElement(driver, SP_Username);
		clear(driver, SP_Username);
		sendKeys(driver, SP_Username, SP_Username_value);

		waitForElement(driver, SP_Password);
		clear(driver, SP_Password);
		sendKeys(driver, SP_Password, SP_Password_value);

		Step_End(7, "Enter the username and password", test, test1);

		Step_Start(8, "click the save button now the popup should show like EDI Transmission profiler details updated ",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Updated_popup);

		String Actsaved_popup = getText(driver, Popup_Message);

		if (Updated_popup.equals(Actsaved_popup)) {

			System.out.println("Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		}

		waitForElement(driver, SP_ConditionFilter);
		click(driver, SP_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, Partner_Id);

		waitForElement(driver, SP_ProfileName_Filter);
		sendKeys(driver, SP_ProfileName_Filter, New_ProfileId);

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

		waitForElement(driver, EDI_Sharepathgrid);
		String Gridpathname = getText(driver, EDI_Sharepathgrid);

		if (Path_Value.equals(Gridpathname)) {

			System.out.println("The given path value was updated in the grid ||Expected path value " + Path_Value
					+ " || Actual path value : " + Gridpathname);
			Extent_pass_New(driver, "The given path value was updated in the grid ||Expected path value " + Path_Value
					+ " || Actual path value : " + Gridpathname, test, test1);

		} else {

			System.out.println("The given path value was not updated in the grid ||Expected path value " + Path_Value
					+ " || Actual path value : " + Gridpathname);
			Extent_fail(driver, "The given path value was not updated in the grid ||Expected path value " + Path_Value
					+ " || Actual path value : " + Gridpathname, test, test1);

		}

		waitForElement(driver, EDI_DriveGrid);
		String GridDriveName = getText(driver, EDI_DriveGrid);

		if (Select_Drive.equals(GridDriveName)) {

			System.out.println("The selected drive name was updated in the grid ||Expected Drive name " + Select_Drive
					+ " || Actual Drive name : " + GridDriveName);
			Extent_pass_New(driver, "The given path value was updated in the grid ||Expected Drive name " + Select_Drive
					+ " || Actual Drive name : " + GridDriveName, test, test1);

		} else {

			System.out.println("The selected drive name was not updated in the grid ||Expected Drive name "
					+ Select_Drive + " || Actual Drive name : " + GridDriveName);
			Extent_fail(driver, "The selected drive name was not updated in the grid ||Expected Drive name "
					+ Select_Drive + " || Actual Drive name : " + GridDriveName, test, test1);

		}

		waitForElement(driver, EDI_Usernamegrid);
		String GridUsername = getText(driver, EDI_Usernamegrid);

		if (SP_Username_value.equals(GridUsername)) {

			System.out.println("The selected User name was updated in the grid ||Expected User name "
					+ SP_Username_value + " || Actual User name : " + GridUsername);
			Extent_pass_New(driver, "The given path value was updated in the grid ||Expected User name "
					+ SP_Username_value + " || Actual User name : " + GridUsername, test, test1);

		} else {

			System.out.println("The selected User name was not updated in the grid ||Expected User name "
					+ SP_Username_value + " || Actual User name : " + GridUsername);
			Extent_fail(driver, "The selected User name was not updated in the grid ||Expected User name "
					+ SP_Username_value + " || Actual User name : " + GridUsername, test, test1);

		}

		Step_End(8, "click the save button now the popup should show like EDI Transmission profiler details updated ",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
