package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC03 extends Keywords {
	public void EDI_Code_Mapping_SC03(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC03";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID_Input = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Value = Excel_data.get("EDI_ID_Value");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_Code_Saved_Popup = Excel_data.get("EDI_Code_Saved_Popup");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String Port_Code_Value = Excel_data.get("Port_Code_Value");
		String EDI_Port_Code_Value = Excel_data.get("EDI_Port_Code_Value");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, moduleName);

		Step_Start(1, "Click the port tab", test, test1);
		waitForElement(driver, Port_Tab_ECM);
		click(driver, Port_Tab_ECM);
		Step_End(1, "Click the port tab", test, test1);

		Step_Start(2, "Select the partner id", test, test1);
		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);
		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID_Input);
		Step_End(2, "Select the partner id", test, test1);

		Step_Start(3, "Select the EDI ID", test, test1);
		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);
		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID_Value);
		Step_End(3, "Select the EDI ID", test, test1);

		Step_Start(4, "Select any  data in the Liner Port Code", test, test1);
		waitForElement(driver, LinerPortCode_Searchbtn_ECM);
		click(driver, LinerPortCode_Searchbtn_ECM);
		twoColumnSearchWindow(driver, Port_Code_Header, Filter_Condition, Port_Code_Value);
		Step_End(4, "Select any  data in the Liner Port Code", test, test1);

		Step_Start(5, "Enter data in the EDI Port Code text field", test, test1);
		waitForElement(driver, EDI_Port_Code_ECM);
		sendKeys(driver, EDI_Port_Code_ECM, EDI_Port_Code_Value);
		Step_Start(5, "Enter data in the EDI Port Code text field", test, test1);

		Step_Start(6, "Click the save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(6, "Click the save button", test, test1);

		Step_Start(7, "Notification popup Edi Code Mapping Saved Successfully Should able to show ", test, test1);

		waitForPopup(driver, Popup_Message, EDI_Code_Saved_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(EDI_Code_Saved_Popup)) {
			System.out.println("Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + EDI_Code_Saved_Popup
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + EDI_Code_Saved_Popup
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);

		}

		waitForElement(driver, Filter_btn_Port);
		click(driver, Filter_btn_Port);

		waitForElement(driver, EDI_Port_Code_Filter_Input);
		safeclick(driver, EDI_Port_Code_Filter_Input);
		sendKeys(driver, EDI_Port_Code_Filter_Input, EDI_Port_Code_Value);

		waitForElement(driver, Liner_Port_Code_Filter_Input);
		safeclick(driver, Liner_Port_Code_Filter_Input);
		sendKeys(driver, Liner_Port_Code_Filter_Input, Port_Code_Value);

		if (isdisplayed(driver, Port_firstrow_ECM)) {

			System.out.println("Expected result : The given sender ID : " + EDI_Port_Code_Value
					+ " and the given receiver id : " + Port_Code_Value
					+ " should be added in the grid || Actual result : The given sender ID : " + EDI_Port_Code_Value
					+ " and the given receiver id : " + Port_Code_Value + " was added in the grid");

			Extent_pass_New(driver,
					"Expected result : The given sender ID : " + EDI_Port_Code_Value + " and the given receiver id : "
							+ Port_Code_Value + " should be added in the grid || Actual result : The given sender ID : "
							+ EDI_Port_Code_Value + " and the given receiver id : " + Port_Code_Value
							+ " was added in the grid",
					test, test1);
		} else {
			System.out.println("Expected result : The given sender ID : " + EDI_Port_Code_Value
					+ " and the given receiver id : " + Port_Code_Value
					+ " should be added in the grid || Actual result : The given sender ID : " + EDI_Port_Code_Value
					+ " and the given receiver id : " + Port_Code_Value + " was not added in the grid");

			Extent_fail(driver,
					"Expected result : The given sender ID : " + EDI_Port_Code_Value + " and the given receiver id : "
							+ Port_Code_Value + " should be added in the grid || Actual result : The given sender ID : "
							+ EDI_Port_Code_Value + " and the given receiver id : " + Port_Code_Value
							+ " was not added in the grid",
					test, test1);
		}

		Step_End(7, "Notification popup Edi Code Mapping Saved Successfully Should able to show ", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}