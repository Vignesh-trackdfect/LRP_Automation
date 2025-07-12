package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS07 extends Keywords {

	public void Endpoint_Configuration_TS07(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS07";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String SharePath_TabName = Excel_data.get("SharePath_TabName");
		String PartnerId_popup = Excel_data.get("PartnerId_popup");
		String PartnerId_Header = Excel_data.get("PartnerId_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileId_Popup = Excel_data.get("ProfileId_Popup");
		String ProfileId = Excel_data.get("ProfileId");
		String Path_Popup = Excel_data.get("Path_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the share path tab ", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, SharePath_TabName);

		Step_End(1, "Click the share path tab ", test, test1);

		Step_Start(2, "Click on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(2, "Click on save button", test, test1);

		Step_Start(3, "Please enter the Trading partner pop should be show", test, test1);

		waitForPopup(driver, Popup_Message, PartnerId_popup);

		String Actsaved_popup = getText(driver, Popup_Message);

		if (PartnerId_popup.equals(Actsaved_popup)) {

			System.out.println("Matched || Expected popup message was : " + PartnerId_popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + PartnerId_popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + PartnerId_popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + PartnerId_popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		}

		Step_End(3, "Please enter the Trading partner pop should be show", test, test1);

		Step_Start(4, "Select the partner id and Click the save button", test, test1);

		waitForElement(driver, SP_PartnerId_Search);
		click(driver, SP_PartnerId_Search);

		twoColumnSearchWindow(driver, PartnerId_Header, Search_Condition, PartnerId);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(4, "Select the partner id and Click the save button", test, test1);

		Step_Start(5, "The popup should show like this 'Please enter the Local(Server) Share profile id'", test, test1);

		waitForPopup(driver, Popup_Message, ProfileId_Popup);

		String Actprof_popup = getText(driver, Popup_Message);

		if (ProfileId_Popup.equals(Actprof_popup)) {

			System.out.println("Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actprof_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actprof_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actprof_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actprof_popup, test, test1);

		}

		Step_End(5, "The popup should show like this 'Please enter the Local(Server) Share profile id'", test, test1);

		Step_Start(6, "Enter any data in profile id text filed", test, test1);

		waitForElement(driver, SP_ProfileId);
		sendKeys(driver, SP_ProfileId, ProfileId);

		Step_End(6, "Enter any data in profile id text filed", test, test1);

		Step_Start(7, "Click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(7, "Click the save button", test, test1);

		Step_Start(8, "popup should show like this 'Please enter the path'", test, test1);

		waitForPopup(driver, Popup_Message, ProfileId_Popup);

		String Actpath_popup = getText(driver, Popup_Message);

		if (Path_Popup.equals(Actpath_popup)) {

			System.out.println("Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actpath_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actpath_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actpath_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + ProfileId_Popup
					+ " || Actual popup message was : " + Actpath_popup, test, test1);

		}

		Step_End(8, "popup should show like this 'Please enter the path'", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
