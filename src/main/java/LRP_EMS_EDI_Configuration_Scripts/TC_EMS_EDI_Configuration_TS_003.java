package LRP_EMS_EDI_Configuration_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_003 extends Keywords {

	public void EMS_EDI_Configuration_TS_003(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_003";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Select_Format = Excel_data.get("Select_Format");
		String Select_MovementCode = Excel_data.get("Select_MovementCode");
		String Confirm_popup = Excel_data.get("Confirm_popup");
		String Removed_popup = Excel_data.get("Removed_popup");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module_Name);

		Step_Start(1, "By default 'By Format' tab opened first", test, test1);

		if (isdisplayed(driver, EEC_Format_Dropdown)) {

			System.out.println(
					"Pass || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is opened");
			Extent_pass_New(driver,
					"Pass || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is opened",
					test, test1);

		} else {

			System.out.println(
					"Fail || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is not opened");
			Extent_fail(driver,
					"Fail || Expected result is : By Default 'By Fomat' Tab should be opened || Actual result is : By Default 'By Fomat' Tab is not opened",
					test, test1);

		}

		if (!isElementEnabled(driver, NewButton_ToolBar)) {

			System.out.println(
					"Pass || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is enabled",
					test, test1);

		} else {

			System.out.println(
					"Fail || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : By Default 'New button' should be enabled || Actual result is : By Default 'New button' is disabled",
					test, test1);

		}


		Step_End(1, "By default 'By Format' tab opened first", test, test1);

		Step_Start(2, "Click the 'Format' dropdown and select the type of EDI you want to edit", test, test1);

		waitForElement(driver, EEC_Format_Dropdown);
		click(driver, EEC_Format_Dropdown);

		waitForElement(driver, EEC_Format_Dropdown);
		formatLocatorClick(driver, EEC_SelectFormat_Option, Select_Format);

		Step_End(2, "Click the 'Format' dropdown and select the type of EDI you want to edit", test, test1);

		Step_Start(3, "Double-click the record you want to remove in the AG grid", test, test1);

		formatLocatorDoubleClick(driver, EEC_MovementSelect, Select_MovementCode);

		Step_End(3, "Double-click the record you want to remove in the AG grid", test, test1);

		Step_Start(5, "Click the 'remove' button", test, test1);

		waitForElement(driver, EEC_Remove_button);
		click(driver, EEC_Remove_button);

		Step_End(5, "Click the 'remove' button", test, test1);

		Step_Start(6,
				"The system will display 'Selected Movement Code is used in By EDI. Please confirm to remove the record",
				test, test1);

		waitForPopup(driver, popup_Message, Confirm_popup);

		String ActualPopup = getText(driver, popup_Message);

		if (Confirm_popup.equals(ActualPopup)) {

			System.out.println("System displayed the expected popup || Expected : " + Confirm_popup + " || Actual : "
					+ ActualPopup);
			Extent_pass_New(driver, "System displayed the expected popup || Expected : " + Confirm_popup + " || Actual : "
					+ ActualPopup, test, test1);

		} else {

			System.out.println("System displayed the different popup || Expected : " + Confirm_popup + " || Actual : "
					+ ActualPopup);
			Extent_fail(driver, "System displayed the different popup || Expected : " + Confirm_popup + " || Actual : "
					+ ActualPopup, test, test1);
		}

		Step_End(6,
				"The system will display 'Selected Movement Code is used in By EDI. Please confirm to remove the record",
				test, test1);

		Step_Start(7, "Click the 'Yes' option to permanently remove it", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(7, "Click the 'Yes' option to permanently remove it", test, test1);

		Step_Start(8, "The system will show 'Movement Code Configuration removed' once confirmed", test, test1);

		waitForPopup(driver, Popup_Message, Removed_popup);
		String removed_popup_Message = getText(driver, Popup_Message);

		if (Removed_popup.equals(removed_popup_Message)) {

			System.out.println("System displayed the expected popup || Expected : " + Removed_popup + " || Actual : "
					+ removed_popup_Message);
			Extent_pass_New(driver, "System displayed the expected popup || Expected : " + Removed_popup + " || Actual : "
					+ removed_popup_Message, test, test1);

		} else {

			System.out.println("System displayed the different popup || Expected : " + Removed_popup + " || Actual : "
					+ removed_popup_Message);
			Extent_fail(driver, "System displayed the different popup || Expected : " + Removed_popup + " || Actual : "
					+ removed_popup_Message, test, test1);
		}

		Step_End(8, "The system will show 'Movement Code Configuration removed' once confirmed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
