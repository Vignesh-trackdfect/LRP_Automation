package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS12 extends Keywords {

	public void Endpoint_Configuration_TS12(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS12";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String AS2_TabName = Excel_data.get("AS2_TabName");
		String TradingPartner_Popup = Excel_data.get("TradingPartner_Popup");
		String PartnerId_Header = Excel_data.get("PartnerId_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileID_Popup = Excel_data.get("ProfileID_Popup");
		String ProfileID = Excel_data.get("ProfileID");
		String AS2Id_Popup = Excel_data.get("AS2Id_Popup");
		String AS2_Id = Excel_data.get("AS2_Id");
		String Keystore_Popup = Excel_data.get("Keystore_Popup");
		String KeystoreValue = Excel_data.get("KeystoreValue");
		String Password_Popup = Excel_data.get("Password_Popup");
		String AS2_PasswordValue = Excel_data.get("AS2_PasswordValue");
		String Alias_Popup = Excel_data.get("Alias_Popup");
		String Alias_Value = Excel_data.get("Alias_Value");
		String Gateway_Popup = Excel_data.get("Gateway_Popup");
		String Gateway_URL = Excel_data.get("Gateway_URL");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the AS2 tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, AS2_TabName);

		Step_End(1, "Click the AS2 tab", test, test1);

		Step_Start(2, "Click on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(2, "Click on save button", test, test1);

		Step_Start(3, "Please enter the Trading partner pop should be show", test, test1);

		waitForPopup(driver, Popup_Message, TradingPartner_Popup);

		String ActTradingPartner_Popup = getText(driver, Popup_Message);

		if (TradingPartner_Popup.equals(ActTradingPartner_Popup)) {

			System.out.println("Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + ActTradingPartner_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + ActTradingPartner_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + ActTradingPartner_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + TradingPartner_Popup
					+ " || Actual popup message was : " + ActTradingPartner_Popup, test, test1);

		}

		Step_End(3, "Please enter the Trading partner pop should be show", test, test1);

		Step_Start(4, "Select the partner id and Click the save button", test, test1);

		waitForElement(driver, AS2_PartnerID);
		click(driver, AS2_PartnerID);

		twoColumnSearchWindow(driver, PartnerId_Header, Search_Condition, PartnerId);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(4, "Select the partner id and Click the save button", test, test1);

		Step_Start(5, "popup should show like this 'Please enter the AS2 profile id'", test, test1);

		waitForPopup(driver, Popup_Message, ProfileID_Popup);

		String ActProfileID_Popup = getText(driver, Popup_Message);

		if (ProfileID_Popup.equals(ActProfileID_Popup)) {

			System.out.println("Matched || Expected popup message was : " + ProfileID_Popup
					+ " || Actual popup message was : " + ActProfileID_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + ProfileID_Popup
					+ " || Actual popup message was : " + ActProfileID_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + ProfileID_Popup
					+ " || Actual popup message was : " + ActProfileID_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + ProfileID_Popup
					+ " || Actual popup message was : " + ActProfileID_Popup, test, test1);

		}

		Step_End(5, "popup should show like this 'Please enter the AS2 profile id'", test, test1);

		Step_Start(6, "Enter the profile id and click save button", test, test1);

		waitForElement(driver, AS2_ProfileID);
		sendKeys(driver, AS2_ProfileID, ProfileID);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Enter the profile id and click save button", test, test1);

		Step_Start(7, "popup should show like this 'Please enter the AS2 profile id'", test, test1);

		waitForPopup(driver, Popup_Message, AS2Id_Popup);

		String ActAS2Id_Popup = getText(driver, Popup_Message);

		if (AS2Id_Popup.equals(ActAS2Id_Popup)) {

			System.out.println("Matched || Expected popup message was : " + AS2Id_Popup
					+ " || Actual popup message was : " + ActAS2Id_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + AS2Id_Popup
					+ " || Actual popup message was : " + ActAS2Id_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + AS2Id_Popup
					+ " || Actual popup message was : " + ActAS2Id_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + AS2Id_Popup
					+ " || Actual popup message was : " + ActAS2Id_Popup, test, test1);

		}

		Step_End(7, "popup should show like this 'Please enter the AS2 profile id'", test, test1);

		Step_Start(8, "Enter the AS2 id and click the save button", test, test1);

		waitForElement(driver, AS2_AS2Id);
		sendKeys(driver, AS2_AS2Id, AS2_Id);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Enter the AS2 id and click the save button", test, test1);

		Step_Start(9, "popup should show this Please enter the Partner Keystore", test, test1);

		waitForPopup(driver, Popup_Message, Keystore_Popup);

		String ActKeystore_Popup = getText(driver, Popup_Message);

		if (Keystore_Popup.equals(ActKeystore_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Keystore_Popup
					+ " || Actual popup message was : " + ActKeystore_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Keystore_Popup
					+ " || Actual popup message was : " + ActKeystore_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Keystore_Popup
					+ " || Actual popup message was : " + ActKeystore_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Keystore_Popup
					+ " || Actual popup message was : " + ActKeystore_Popup, test, test1);

		}

		Step_End(9, "popup should show this Please enter the Partner Keystore", test, test1);

		Step_Start(10, "Enter the keystore and click the save button", test, test1);

		waitForElement(driver, AS2_Keystore);
		sendKeys(driver, AS2_Keystore, KeystoreValue);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(10, "Enter the keystore and click the save button", test, test1);

		Step_Start(11, "popup should show like this Please enter the Partner Password", test, test1);

		waitForPopup(driver, Popup_Message, Password_Popup);

		String ActPassword_Popup = getText(driver, Popup_Message);

		if (Password_Popup.equals(ActPassword_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Password_Popup
					+ " || Actual popup message was : " + ActPassword_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Password_Popup
					+ " || Actual popup message was : " + ActPassword_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Password_Popup
					+ " || Actual popup message was : " + ActPassword_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Password_Popup
					+ " || Actual popup message was : " + ActPassword_Popup, test, test1);

		}

		Step_End(11, "popup should show like this Please enter the Partner Password", test, test1);

		Step_Start(12, "Enter the password and click the save button", test, test1);

		waitForElement(driver, AS2_Password);
		sendKeys(driver, AS2_Password, AS2_PasswordValue);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(12, "Enter the password and click the save button", test, test1);

		Step_Start(13, "popup should show like this Please enter the Partner Alias", test, test1);

		waitForPopup(driver, Popup_Message, Alias_Popup);

		String ActAlias_Popup = getText(driver, Popup_Message);

		if (Alias_Popup.equals(ActAlias_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Alias_Popup
					+ " || Actual popup message was : " + ActAlias_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Alias_Popup
					+ " || Actual popup message was : " + ActAlias_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Alias_Popup
					+ " || Actual popup message was : " + ActAlias_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Alias_Popup
					+ " || Actual popup message was : " + ActAlias_Popup, test, test1);

		}

		Step_End(13, "popup should show like this Please enter the Partner Alias", test, test1);

		Step_Start(14, "Enter the Alias and click save button", test, test1);

		waitForElement(driver, AS2_Alias);
		sendKeys(driver, AS2_Alias, Alias_Value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(14, "Enter the Alias and click save button", test, test1);

		Step_Start(15, "popup should show like this Please enter the Partner Gateway URL", test, test1);

		waitForPopup(driver, Popup_Message, Gateway_Popup);

		String ActGateway_Popup = getText(driver, Popup_Message);

		if (Gateway_Popup.equals(ActGateway_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Gateway_Popup
					+ " || Actual popup message was : " + ActGateway_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Gateway_Popup
					+ " || Actual popup message was : " + ActGateway_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Gateway_Popup
					+ " || Actual popup message was : " + ActGateway_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Gateway_Popup
					+ " || Actual popup message was : " + ActGateway_Popup, test, test1);

		}

		Step_End(15, "popup should show like this Please enter the Partner Gateway URL", test, test1);

		Step_Start(16, "Enter the gateway URL", test, test1);

		waitForElement(driver, AS2_GatewayURL);
		sendKeys(driver, AS2_GatewayURL, Gateway_URL);

		Step_End(16, "Enter the gateway URL", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
