package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS22 extends Keywords {

	public void Endpoint_Configuration_TS22(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS22";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String WebService_TabName = Excel_data.get("WebService_TabName");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileID = Excel_data.get("ProfileID");
		String Attribute = Excel_data.get("Attribute");
		String Value = Excel_data.get("Value");
		String Confirm_Popup = Excel_data.get("Confirm_Popup");
		String Removed_Popup = Excel_data.get("Removed_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the Web service tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, WebService_TabName);

		Step_End(1, "Click the Web service tab", test, test1);

		Step_Start(2, "Select any one record from AG grid", test, test1);

		waitForElement(driver, WS_ConditionFilter);
		click(driver, WS_ConditionFilter);

		if (!PartnerId.isEmpty()) {

			waitForElement(driver, EC_PartnerID_Filter);
			sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		}

		if (!ProfileID.isEmpty()) {

			waitForElement(driver, WS_ProfileID_Filter);
			sendKeys(driver, WS_ProfileID_Filter, ProfileID);

		}

		if (!Attribute.isEmpty()) {

			waitForElement(driver, WS_Attribute_Filter);
			sendKeys(driver, WS_Attribute_Filter, Attribute);

		}

		if (!Value.isEmpty()) {

			waitForElement(driver, WS_Value_Filter);
			sendKeys(driver, WS_Value_Filter, Value);

		}

		Step_End(2, "Select any one record from AG grid", test, test1);

		Step_Start(3, "Select any one record from AG grid", test, test1);

		waitForElement(driver, WS_Row1);
		click(driver, WS_Row1);

		Step_End(3, "Select any one record from AG grid", test, test1);

		Step_Start(4, "click the remove ", test, test1);

		waitForElement(driver, WS_Removerecord);
		click(driver, WS_Removerecord);

		Step_End(4, "click the remove ", test, test1);

		Step_Start(5, "popup should show like Please confirm to remove the record", test, test1);

		waitForPopup(driver, popup_Message, Confirm_Popup);

		String ActConfirm_Popup = getText(driver, popup_Message);

		if (Confirm_Popup.equals(ActConfirm_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Confirm_Popup
					+ " || Actual popup message was : " + ActConfirm_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Confirm_Popup
					+ " || Actual popup message was : " + ActConfirm_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Confirm_Popup
					+ " || Actual popup message was : " + ActConfirm_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Confirm_Popup
					+ " || Actual popup message was : " + ActConfirm_Popup, test, test1);

		}

		Step_End(5, "popup should show like Please confirm to remove the record", test, test1);

		Step_Start(6, "Click ok button", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(6, "Click ok button", test, test1);

		Step_Start(7, "popup should show like Record(s)removed", test, test1);

		waitForPopup(driver, Popup_Message, Removed_Popup);

		String ActRemoved_Popup = getText(driver, Popup_Message);

		if (Removed_Popup.equals(ActRemoved_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Removed_Popup
					+ " || Actual popup message was : " + ActRemoved_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Removed_Popup
					+ " || Actual popup message was : " + ActRemoved_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Removed_Popup
					+ " || Actual popup message was : " + ActRemoved_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Removed_Popup
					+ " || Actual popup message was : " + ActRemoved_Popup, test, test1);

		}

		waitForElement(driver, WS_ConditionFilter);
		click(driver, WS_ConditionFilter);

		if (!PartnerId.isEmpty()) {

			waitForElement(driver, EC_PartnerID_Filter);
			sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		}

		if (!ProfileID.isEmpty()) {

			waitForElement(driver, WS_ProfileID_Filter);
			sendKeys(driver, WS_ProfileID_Filter, ProfileID);

		}

		if (!Attribute.isEmpty()) {

			waitForElement(driver, WS_Attribute_Filter);
			sendKeys(driver, WS_Attribute_Filter, Attribute);

		}

		if (!Value.isEmpty()) {

			waitForElement(driver, WS_Value_Filter);
			sendKeys(driver, WS_Value_Filter, Value);

		}

		waitForDisplay(driver, WS_Row1);

		if (!isdisplayed(driver, WS_Row1)) {

			System.out.println("Expected result || The profile Id : " + ProfileID + " and the value : " + Value
					+ " record should be removed from the grid || Actual result : The profile Id : " + ProfileID
					+ " and the value : " + Value + " record was removed from the grid");
			Extent_pass_New(driver,
					"Expected result || The profile Id : " + ProfileID + " and the value : " + Value
							+ " record should be removed from the grid || Actual result : The profile Id : " + ProfileID
							+ " and the value : " + Value + " record was removed from the grid",
					test, test1);
		} else {

			System.out.println("Expected result || The profile Id : " + ProfileID + " and the value : " + Value
					+ " record should be removed from the grid || Actual result : The profile Id : " + ProfileID
					+ " and the value : " + Value + " record was not removed from the grid");
			Extent_fail(driver,
					"Expected result || The profile Id : " + ProfileID + " and the value : " + Value
							+ " record should be removed from the grid || Actual result : The profile Id : " + ProfileID
							+ " and the value : " + Value + " record was not removed from the grid",
					test, test1);
		}

		Step_End(7, "popup should show like Record(s)removed", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

	}

}
