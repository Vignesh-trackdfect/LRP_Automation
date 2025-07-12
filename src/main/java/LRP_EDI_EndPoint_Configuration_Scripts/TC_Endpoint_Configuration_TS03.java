package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS03 extends Keywords {

	public void Endpoint_Configuration_TS03(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS03";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String PartnerID_Search = Excel_data.get("PartnerID_Search");
		String ProfileName_Search = Excel_data.get("ProfileName_Search");
		String Status_Option = Excel_data.get("Status_Option");
		String Profile_Id = Excel_data.get("Profile_Id");
		String FTPUserId = Excel_data.get("FTPUserId");
		String FTP_Password = Excel_data.get("FTP_Password");
		String Saved_Popup = Excel_data.get("Saved_Popup");
		String Inactive_Color = Excel_data.get("Inactive_Color");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, ModuleName);

		Step_Start(1, "Double Click any one record on the AG grid", test, test1);

		waitForElement(driver, EC_ConditionFilter);
		click(driver, EC_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, PartnerID_Search);

		waitForElement(driver, EC_ProfileName_Filter);
		sendKeys(driver, EC_ProfileName_Filter, ProfileName_Search);

		waitForElement(driver, FTP_GridRow1);
		doubleClick(driver, FTP_GridRow1);

		Step_End(1, "Double Click any one record on the AG grid", test, test1);

		Step_Start(2, " click the edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(2, " click the edit button", test, test1);

		Step_Start(3, "Change the status into Inactive", test, test1);

		waitForElement(driver, EC_Status_Dropdown);
		click(driver, EC_Status_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Status_Option);

		Step_End(3, "Change the status into Inactive", test, test1);

		Step_Start(4, "Change the profile id", test, test1);

		waitForElement(driver, EC_ProfileId_Input);
		clear(driver, EC_ProfileId_Input);
		sendKeys(driver, EC_ProfileId_Input, Profile_Id);

		Step_End(4, "Change the profile id", test, test1);

		Step_Start(5, "Change the user id", test, test1);

		waitForElement(driver, EC_FTP_UserId_input);
		clear(driver, EC_FTP_UserId_input);
		sendKeys(driver, EC_FTP_UserId_input, FTPUserId);

		Step_End(5, "Change the user id", test, test1);

		Step_Start(6, "Change the password", test, test1);

		waitForElement(driver, EC_FTP_Password_input);
		sendKeys(driver, EC_FTP_Password_input, FTP_Password);

		Step_End(6, "Change the password", test, test1);

		Step_Start(7, "Click the RSA and DSA", test, test1);

		waitForElement(driver, EC_RSA_Checkbox);
		click(driver, EC_RSA_Checkbox);

		waitForElement(driver, EC_DSA_Checkbox);
		click(driver, EC_DSA_Checkbox);

		Step_End(7, "Click the RSA and DSA", test, test1);

		Step_Start(8,
				"click the save button and now the popup should show like \"EDI Transmission profiler details updated\"",
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
		sendKeys(driver, EC_PartnerID_Filter, PartnerID_Search);

		waitForElement(driver, EC_ProfileName_Filter);
		sendKeys(driver, EC_ProfileName_Filter, Profile_Id);

		waitForElement(driver, FTP_GridRow1);
		String colorcode = getTextBackgroundColor(driver, FTP_GridRow1);

		String colorname = getColorName(colorcode);

		if (Inactive_Color.equals(colorname)) {

			System.out
					.println("After inactive the given data, the row color was changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname);
			Extent_pass_New(driver,
					"After inactive the given data, the row color was changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname,
					test, test1);
		} else {

			System.out.println(
					"After inactive the given data, the row color was not changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname);
			Extent_fail(driver,
					"After inactive the given data, the row color was not changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname,
					test, test1);
		}

		Step_End(8,
				"click the save button and now the popup should show like \"EDI Transmission profiler details updated\"",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
