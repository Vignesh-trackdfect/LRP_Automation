package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS14 extends Keywords {

	public void Endpoint_Configuration_TS14(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS14";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String AS2_TabName = Excel_data.get("AS2_TabName");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileID = Excel_data.get("ProfileID");
		String AS2_Id = Excel_data.get("AS2_Id");
		String Status = Excel_data.get("Status");
		String Updated_popup = Excel_data.get("Updated_popup");
		String Inactive_Color = Excel_data.get("Inactive_Color");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the AS2 tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, AS2_TabName);

		Step_End(1, "Click the AS2 tab", test, test1);

		Step_Start(2, "dobule click any one of the record from the AG gird", test, test1);

		waitForElement(driver, AS2_ConditionFilter);
		click(driver, AS2_ConditionFilter);

		if (!PartnerId.isEmpty()) {

			waitForElement(driver, EC_PartnerID_Filter);
			sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		}

		if (!ProfileID.isEmpty()) {
			waitForElement(driver, AS2_ProfilenameFilterInput);
			sendKeys(driver, AS2_ProfilenameFilterInput, ProfileID);

		}

		if (!AS2_Id.isEmpty()) {
			waitForElement(driver, AS2_PartnerAS2FilterInput);
			sendKeys(driver, AS2_PartnerAS2FilterInput, AS2_Id);

		}

		waitForElement(driver, AS2_Row1);
		doubleClick(driver, AS2_Row1);

		Step_End(2, "dobule click any one of the record from the AG gird", test, test1);

		Step_Start(3, "Click the edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(3, "Click the edit button", test, test1);

		Step_Start(4, "Change the Status as Inactive", test, test1);

		waitForElement(driver, AS2_Status);
		click(driver, AS2_Status);

		formatLocatorClick(driver, DropDown_Select, Status);

		Step_End(4, "Change the Status as Inactive", test, test1);

		Step_Start(5,
				"Click the save button now the popup should show like EDI Transmission profiler details updated and edited record colour should be changed",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Updated_popup);

		String ActUpdated_popup = getText(driver, Popup_Message);

		if (Updated_popup.equals(ActUpdated_popup)) {

			System.out.println("Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + ActUpdated_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + ActUpdated_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + ActUpdated_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Updated_popup
					+ " || Actual popup message was : " + ActUpdated_popup, test, test1);

		}

		waitForElement(driver, AS2_ConditionFilter);
		click(driver, AS2_ConditionFilter);

		if (!PartnerId.isEmpty()) {

			waitForElement(driver, EC_PartnerID_Filter);
			sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		}

		if (!ProfileID.isEmpty()) {
			waitForElement(driver, AS2_ProfilenameFilterInput);
			sendKeys(driver, AS2_ProfilenameFilterInput, ProfileID);

		}

		if (!AS2_Id.isEmpty()) {
			waitForElement(driver, AS2_PartnerAS2FilterInput);
			sendKeys(driver, AS2_PartnerAS2FilterInput, AS2_Id);

		}

		waitForElement(driver, AS2_Row1);
		String colorcode = getTextBackgroundColor(driver, AS2_Row1);

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

		Step_End(5,
				"Click the save button now the popup should show like EDI Transmission profiler details updated and edited record colour should be changed",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
