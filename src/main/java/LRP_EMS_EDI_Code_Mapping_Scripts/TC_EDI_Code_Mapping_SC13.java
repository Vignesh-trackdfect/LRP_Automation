package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC13 extends Keywords {
	public void EDI_Code_Mapping_SC13(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC13";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Sender_ID = Excel_data.get("Sender_ID");
		String EDI_Code_Saved_Popup = Excel_data.get("EDI_Code__Sender_Id_Mapping_Popup");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Receiver_Id_Mapping_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click sender and recevier tab", test, test1);

		waitForElement(driver, Sender_Receiver_Tab_ECM);
		click(driver, Sender_Receiver_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(1, "Select the partner Id and click sender and recevier tab", test, test1);

		Step_Start(2, "click the save button now\"Enter The Sender Id\" popup should show", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Code_Saved_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(EDI_Code_Saved_Popup);
		if (Saved_Popup.equals(EDI_Code_Saved_Popup)) {
			System.out.println("Matched || " + " Expected sender id verification popup  : " + EDI_Code_Saved_Popup
					+ " || Actual sender id verification popup  : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected sender id verification popup : " + EDI_Code_Saved_Popup
					+ " || Actual sender id verification popup  : " + Saved_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected sender id verification popup  : " + EDI_Code_Saved_Popup
					+ " || Actual sender id verification popup  : " + Saved_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected sender id verification popup  : " + EDI_Code_Saved_Popup
					+ " || Actual sender id verification popup  : " + Saved_Popup, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(2, "click the save button now\"Enter The Sender Id\" popup should show", test, test1);

		Step_Start(3, "Enter any data in the sender id", test, test1);

		waitForElement(driver, Sender_ID_Input_ECM);
		safeclick(driver, Sender_ID_Input_ECM);
		sendKeys(driver, Sender_ID_Input_ECM, Sender_ID);

		Step_End(3, "Enter any data in the sender id", test, test1);

		Step_Start(4, "And click the save button now\"Enter The EDI Port Code\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Code_Mapping_Popup);
		String Saved_Popup1 = getText(driver, popup_Message);
		System.out.println(EDI_Code_Mapping_Popup);
		if (Saved_Popup1.equals(EDI_Code_Mapping_Popup)) {
			System.out.println("Matched || " + " Expected EDI Port Code verifification popup : "
					+ EDI_Code_Mapping_Popup + " || Actual EDI Port Code verifification popup : " + Saved_Popup1);
			Extent_pass_New(driver, "Matched || " + " Expected EDI Port Code verifification popup: "
					+ EDI_Code_Mapping_Popup + " || Actual EDI Port Code verifification popup : " + Saved_Popup1, test,
					test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI Port Code verifification popup : "
					+ EDI_Code_Mapping_Popup + " || Actual EDI Port Code verifification popup : " + Saved_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected EDI Port Code verifification popup : "
					+ EDI_Code_Mapping_Popup + " || Actual EDI Port Code verifification popup : " + Saved_Popup1, test,
					test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "And click the save button now\"Enter The EDI Port Code\" popup should show", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}