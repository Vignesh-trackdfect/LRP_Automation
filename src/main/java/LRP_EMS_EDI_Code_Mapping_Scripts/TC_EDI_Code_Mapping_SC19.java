package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC19 extends Keywords {
	public void EDI_Code_Mapping_SC19(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC19";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Mapping_Popup");
		String Sender_ID = Excel_data.get("Sender_ID");
		String Receiver_ID = Excel_data.get("Receiver_ID");
		String Sender_ID_Input_Change = Excel_data.get("Sender_ID_Input_Change");
		String Receiver_ID_Input_Change = Excel_data.get("Receiver_ID_Input_Change");
		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click Sender receiver tab", test, test1);

		waitForElement(driver, Sender_Receiver_Tab_ECM);
		click(driver, Sender_Receiver_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);

		Step_End(1, "Select the partner Id and click Sender receiver tab", test, test1);

		Step_Start(2, "And click the show button and select any one data in the AG grid", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn_ECM);
		click(driver, EDI_Code_Show_Btn_ECM);

		waitForElement(driver, Filter_btn_Sender_Receiver_ECM);
		click(driver, Filter_btn_Sender_Receiver_ECM);

		waitForElement(driver, Sender_ID_Filter_Input_ECM);
		safeclick(driver, Sender_ID_Filter_Input_ECM);
		sendKeys(driver, Sender_ID_Filter_Input_ECM, Sender_ID);

		waitForElement(driver, Receiver_ID_Filter_Input_ECM);
		safeclick(driver, Receiver_ID_Filter_Input_ECM);
		sendKeys(driver, Receiver_ID_Filter_Input_ECM, Receiver_ID);

		waitForDisplay(driver, EDI_Code_Mapping_EDI_ID_Value);
		safeclick(driver, EDI_Code_Mapping_EDI_ID_Value);

		formatLocatorDoubleClick(driver, Double_Click_Fliter_Sender_ID_ECM, Sender_ID);

		Step_End(2, "And click the show button and select any one data in the AG grid", test, test1);

		Step_Start(3, "Click Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click Edit button", test, test1);

		Step_Start(4, "Change the Sender ID", test, test1);

		waitForElement(driver, Sender_ID_Input_ECM);
		click(driver, Sender_ID_Input_ECM);
		clear(driver, Sender_ID_Input_ECM);
		sendKeys(driver, Sender_ID_Input_ECM, Sender_ID_Input_Change);

		Step_End(4, "Change the Sender ID", test, test1);

		Step_Start(5, "Change the Receiver ID", test, test1);

		waitForElement(driver, Receiver_ID_Input_ECM);
		click(driver, Receiver_ID_Input_ECM);
		clear(driver, Receiver_ID_Input_ECM);
		sendKeys(driver, Receiver_ID_Input_ECM, Receiver_ID_Input_Change);

		Step_End(6, "Change the Receiver ID", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_Start(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test,
				test1);

		waitForPopup(driver, Popup_Message, EDI_Code_Mapping_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (EDI_Code_Mapping_Popup.equals(Applied_Popup)) {
			System.out.println("Matched || " + " Expected EDI deatils updated popup : " + EDI_Code_Mapping_Popup
					+ " || Actual EDI deatils updated popup : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected EDI deatils updated popup: " + EDI_Code_Mapping_Popup
					+ " || Actual EDI deatils updated popup : " + Applied_Popup, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI deatils updated poup : " + EDI_Code_Mapping_Popup
					+ " || Actual EDI deatils updated poup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected EDI deatils updated poup : " + EDI_Code_Mapping_Popup
					+ " || Actual  EDI deatils updated poup : " + Applied_Popup, test, test1);

		}

		waitForElement(driver, Filter_btn_Sender_Receiver_ECM);
		click(driver, Filter_btn_Sender_Receiver_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, Sender_ID_Filter_Input_ECM);
		safeclick(driver, Sender_ID_Filter_Input_ECM);
		sendKeys(driver, Sender_ID_Filter_Input_ECM, Sender_ID_Input_Change);

		waitForElement(driver, Receiver_ID_Filter_Input_ECM);
		safeclick(driver, Receiver_ID_Filter_Input_ECM);
		sendKeys(driver, Receiver_ID_Filter_Input_ECM, Receiver_ID_Input_Change);

		waitForDisplay(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (isdisplayed(driver, EDI_Code_Mapping_EDI_ID_Value)) {

			System.out.println("Expected result: The given Sender ID : " + Sender_ID_Input_Change
					+ " and the given Receiver ID : " + Receiver_ID_Input_Change
					+ " Should be updated in the grid || Actual result : The given Sender ID : "
					+ Sender_ID_Input_Change + " and the given Receiver ID  : " + Receiver_ID_Input_Change
					+ " was updated in the grid");
			Extent_pass_New(driver, "Expected result: The given Sender ID : " + Sender_ID_Input_Change
					+ " and the given Receiver ID  : " + Receiver_ID_Input_Change
					+ " should updated in the grid || Actual result : The given Sender ID : " + Sender_ID_Input_Change
					+ " and the given Receiver ID  : " + Receiver_ID_Input_Change + " was updated in the grid", test,
					test1);

		} else {

			System.out.println("Expected result: The given Sender ID : " + Sender_ID_Input_Change
					+ " and the given Receiver ID  : " + Receiver_ID_Input_Change
					+ " Should be updated in the grid || Actual result : The given Sender ID : "
					+ Sender_ID_Input_Change + " and the given Receiver ID  : " + Receiver_ID_Input_Change
					+ " was not updated in the grid");
			Extent_fail(driver,
					"Expected result: The given Sender ID : " + Sender_ID_Input_Change
							+ " and the given Receiver ID  : " + Receiver_ID_Input_Change
							+ " Should be updated in the grid || Actual result : The given Sender ID : "
							+ Sender_ID_Input_Change + " and the given Receiver ID : " + Receiver_ID_Input_Change
							+ " was not updated in the grid",
					test, test1);

		}

		Step_End(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
