package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS13 extends Keywords {

	public void Endpoint_Configuration_TS13(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS13";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String AS2_TabName = Excel_data.get("AS2_TabName");
		String PartnerId_Header = Excel_data.get("PartnerId_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileID = Excel_data.get("ProfileID");
		String AS2_Id = Excel_data.get("AS2_Id");
		String KeystoreValue = Excel_data.get("KeystoreValue");
		String AS2_PasswordValue = Excel_data.get("AS2_PasswordValue");
		String Alias_Value = Excel_data.get("Alias_Value");
		String Gateway_URL = Excel_data.get("Gateway_URL");
		String Saved_popup = Excel_data.get("Saved_popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the AS2 tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, AS2_TabName);

		Step_End(1, "Click the AS2 tab", test, test1);

		Step_Start(2, "Select the partner id", test, test1);

		waitForElement(driver, AS2_PartnerID);
		click(driver, AS2_PartnerID);

		twoColumnSearchWindow(driver, PartnerId_Header, Search_Condition, PartnerId);

		Step_End(2, "Select the partner id", test, test1);

		Step_Start(3, "Enter the profile id", test, test1);

		waitForElement(driver, AS2_ProfileID);
		sendKeys(driver, AS2_ProfileID, ProfileID);

		Step_End(3, "Enter the profile id", test, test1);

		Step_Start(4, "Enter the AS2 id", test, test1);

		waitForElement(driver, AS2_AS2Id);
		sendKeys(driver, AS2_AS2Id, AS2_Id);

		Step_End(4, "Enter the AS2 id", test, test1);

		Step_Start(5, "Enter the keystore", test, test1);

		waitForElement(driver, AS2_Keystore);
		sendKeys(driver, AS2_Keystore, KeystoreValue);

		Step_End(5, "Enter the keystore", test, test1);

		Step_Start(6, "Enter the password", test, test1);

		waitForElement(driver, AS2_Password);
		sendKeys(driver, AS2_Password, AS2_PasswordValue);

		Step_End(6, "Enter the password", test, test1);

		Step_Start(7, "Enter the Alias", test, test1);

		waitForElement(driver, AS2_Alias);
		sendKeys(driver, AS2_Alias, Alias_Value);

		Step_End(7, "Enter the Alias", test, test1);

		Step_Start(8, "Enter the gateway URL", test, test1);

		waitForElement(driver, AS2_GatewayURL);
		sendKeys(driver, AS2_GatewayURL, Gateway_URL);

		Step_End(8, "Enter the gateway URL", test, test1);

		Step_Start(9, "Click the save button now the popup should like this EDI Transmission profiler details saved",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Saved_popup);

		String ActSaved_Popup = getText(driver, Popup_Message);

		if (Saved_popup.equals(ActSaved_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActSaved_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActSaved_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActSaved_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + ActSaved_Popup, test, test1);

		}

		waitForElement(driver, AS2_ConditionFilter);
		click(driver, AS2_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		waitForElement(driver, AS2_ProfilenameFilterInput);
		sendKeys(driver, AS2_ProfilenameFilterInput, ProfileID);

		waitForElement(driver, AS2_PartnerAS2FilterInput);
		sendKeys(driver, AS2_PartnerAS2FilterInput, AS2_Id);

		waitForElement(driver, AS2_KeystoreFilterInput);
		sendKeys(driver, AS2_KeystoreFilterInput, KeystoreValue);

		waitForElement(driver, AS2_AliasFilterInput);
		sendKeys(driver, AS2_AliasFilterInput, Alias_Value);

		waitForElement(driver, AS2_GatewayFilter);
		sendKeys(driver, AS2_GatewayFilter, Gateway_URL);

		waitForDisplay(driver, AS2_Row1);

		if (isdisplayed(driver, AS2_Row1)) {

			System.out.println(
					"Expected result : The given details should be added in the grid || Actual result : The given details are added in the grid");

			Extent_pass_New(driver,
					"Expected result : The given details should be added in the grid || Actual result : The given details are added in the grid",
					test, test1);
		} else {

			System.out.println(
					"Expected result : The given details should be added in the grid || Actual result : The given details are not added in the grid");

			Extent_fail(driver,
					"Expected result : The given details should be added in the grid || Actual result : The given details are not added in the grid",
					test, test1);

		}

		Step_End(9, "Click the save button now the popup should like this EDI Transmission profiler details saved",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
