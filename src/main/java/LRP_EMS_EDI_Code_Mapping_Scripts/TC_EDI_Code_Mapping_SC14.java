package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC14 extends Keywords {
	public void EDI_Code_Mapping_SC14(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC14";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Portcode_Header = Excel_data.get("Portcode_Header");
		String Portcode_Input = Excel_data.get("Portcode_Input");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_Code_Liner_Port_Code_Mapping_Popup = Excel_data.get("EDI_Code_Liner_Port_Code_Mapping_Popup");
		String EDI_PortCode_Mapping_Popup = Excel_data.get("EDI_PortCode_Mapping_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click port tab", test, test1);

		waitForElement(driver, Port_Tab_ECM);
		click(driver, Port_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(1, "Select the partner Id and click port tab", test, test1);

		Step_Start(2, "And click the save button now\" Enter The Liner Port Code\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Code_Liner_Port_Code_Mapping_Popup);
		String Saved_Popup2 = getText(driver, popup_Message);
		System.out.println(EDI_Code_Liner_Port_Code_Mapping_Popup);
		if (Saved_Popup2.equals(EDI_Code_Liner_Port_Code_Mapping_Popup)) {
			System.out.println("Matched || " + " Expected Liner Port Code popup : "
					+ EDI_Code_Liner_Port_Code_Mapping_Popup + " || Actual Liner Port Code poup : " + Saved_Popup2);
			Extent_pass_New(driver, "Matched || " + " Expected Liner Port Code poup: "
					+ EDI_Code_Liner_Port_Code_Mapping_Popup + " || Actual Liner Port Code poup : " + Saved_Popup2,
					test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Liner Port Code poup : "
					+ EDI_Code_Liner_Port_Code_Mapping_Popup + " || Actual saved poup : " + Saved_Popup2);
			Extent_fail(
					driver, "Not Matched || " + " Expected Liner Port Code poup : "
							+ EDI_Code_Liner_Port_Code_Mapping_Popup + " || Actual saved poup : " + Saved_Popup2,
					test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(2, "And click the save button now\" Enter The Liner Port Code\" popup should show", test, test1);

		Step_Start(3, "Select any data in the liner port code", test, test1);

		waitForElement(driver, Port_Search_ECM);
		click(driver, Port_Search_ECM);

		twoColumnSearchWindow(driver, Portcode_Header, Filter_Condition, Portcode_Input);

		Step_End(3, "Select any data in the liner port code", test, test1);

		Step_Start(4, "4.And click the save button now\"Enter The EDI Port Code\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_PortCode_Mapping_Popup);
		String Saved_Popup3 = getText(driver, popup_Message);
		System.out.println(EDI_PortCode_Mapping_Popup);
		if (Saved_Popup3.equals(EDI_PortCode_Mapping_Popup)) {
			System.out.println("Matched || " + " Expected EDI Port Code popup : " + EDI_PortCode_Mapping_Popup
					+ " || Actual EDI Port Code poup : " + Saved_Popup3);
			Extent_pass_New(driver, "Matched || " + " Expected EDI Port Code poup: " + EDI_PortCode_Mapping_Popup
					+ " || Actual EDI Port Code poup : " + Saved_Popup3, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI Port Code poup : " + EDI_PortCode_Mapping_Popup
					+ " || Actual EDI Port Code poup : " + Saved_Popup3);
			Extent_fail(driver, "Not Matched || " + " Expected EDI Port Code poup : " + EDI_PortCode_Mapping_Popup
					+ " || Actual EDI Port Code poup : " + Saved_Popup3, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "4.And click the save button now\"Enter The EDI Port Code\" popup should show", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
