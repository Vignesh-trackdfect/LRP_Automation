package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS17 extends Keywords {

	public void Endpoint_Configuration_TS17(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS17";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String WebService_TabName = Excel_data.get("WebService_TabName");
		String TradingPartner_Popup = Excel_data.get("TradingPartner_Popup");
		String PartnerId_Header = Excel_data.get("PartnerId_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileID_Popup = Excel_data.get("ProfileID_Popup");
		String ProfileID = Excel_data.get("ProfileID");
		String Attribute_Popup = Excel_data.get("Attribute_Popup");
		String Attribute = Excel_data.get("Attribute");
		String Value_Popup = Excel_data.get("Value_Popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the Web service tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, WebService_TabName);

		Step_End(1, "Click the Web service tab", test, test1);

		Step_Start(2, "Click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(2, "Click the save button", test, test1);

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

		waitForElement(driver, WS_PartnerID);
		click(driver, WS_PartnerID);

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

		Step_Start(6, "Enter the profile id and click the save button", test, test1);

		waitForElement(driver, WS_ProfileID);
		sendKeys(driver, WS_ProfileID, ProfileID);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Enter the profile id and click the save button", test, test1);

		Step_Start(7, "popup should show like Please select Attribute", test, test1);

		waitForPopup(driver, Popup_Message, Attribute_Popup);

		String ActAttribute_Popup = getText(driver, Popup_Message);

		if (Attribute_Popup.equals(ActAttribute_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Attribute_Popup
					+ " || Actual popup message was : " + ActAttribute_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Attribute_Popup
					+ " || Actual popup message was : " + ActAttribute_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Attribute_Popup
					+ " || Actual popup message was : " + ActAttribute_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Attribute_Popup
					+ " || Actual popup message was : " + ActAttribute_Popup, test, test1);

		}

		Step_End(7, "popup should show like Please select Attribute", test, test1);

		Step_Start(8, "Select the attribute and click save button", test, test1);

		waitForElement(driver, WS_Attribute);
		click(driver, WS_Attribute);

		String locator = String.format(DropDown_Select, Attribute);

		VerticalScroll_Visible(driver, locator, verticalscroll);
		jsClick(driver, locator);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Select the attribute and click save button", test, test1);

		Step_Start(9, "popup should show like this Please enter the Value", test, test1);

		waitForPopup(driver, Popup_Message, Value_Popup);

		String ActValue_Popup = getText(driver, Popup_Message);

		if (Value_Popup.equals(ActValue_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Value_Popup
					+ " || Actual popup message was : " + ActValue_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Value_Popup
					+ " || Actual popup message was : " + ActValue_Popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Value_Popup
					+ " || Actual popup message was : " + ActValue_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Value_Popup
					+ " || Actual popup message was : " + ActValue_Popup, test, test1);

		}

		Step_End(9, "popup should show like this Please enter the Value", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
