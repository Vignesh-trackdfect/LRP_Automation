package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC20 extends Keywords {

	public void EDI_Code_Mapping_SC20(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC20";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Mapping_Popup");
		String Liner_Port_Code_Header = Excel_data.get("Liner_Port_Code_Header");
		String Liner_Port_Code = Excel_data.get("Liner_Port_Code");
		String Liner_Port_code_Change = Excel_data.get("Liner_Port_Code_Change");
		String EDI_Port_Code_Input = Excel_data.get("EDI_Port_Code_Input");
		String EDI_Port_Code_Input_Change = Excel_data.get("EDI_Port_Code_Input_Change");
		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click Port tab", test, test1);

		waitForElement(driver, Port_Tab_ECM);
		click(driver, Port_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);

		Step_End(1, "Select the partner Id and click Port tab", test, test1);

		Step_Start(2, "And click the show button and select any one data in the AG grid", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn_ECM);
		click(driver, EDI_Code_Show_Btn_ECM);

		waitForElement(driver, Filter_btn_Port_ECM);
		click(driver, Filter_btn_Port_ECM);

		waitForElement(driver, Liner_Port_Code_Filter_Input_ECM);
		safeclick(driver, Liner_Port_Code_Filter_Input_ECM);
		sendKeys(driver, Liner_Port_Code_Filter_Input_ECM, Liner_Port_Code);

		waitForElement(driver, EDI_Port_Code_Filter_Input_ECM);
		safeclick(driver, EDI_Port_Code_Filter_Input_ECM);
		sendKeys(driver, EDI_Port_Code_Filter_Input_ECM, EDI_Port_Code_Input);

		formatLocatorClick(driver, Select_Filter_First_Row_ECM, Liner_Port_Code);

		formatLocatorDoubleClick(driver, Double_Click_Liner_Code_ECM, Liner_Port_Code);

		Step_End(2, "And click the show button and select any one data in the AG grid", test, test1);

		Step_Start(3, "Click Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click Edit button", test, test1);

		Step_Start(4, "Change the Liner port code ", test, test1);

		waitForElement(driver, Port_Search_ECM);
		click(driver, Port_Search_ECM);

		twoColumnSearchWindow(driver, Liner_Port_Code_Header, Filter_Condition, Liner_Port_code_Change);

		Step_End(4, " Change the Liner port code ", test, test1);

		Step_Start(5, "Change Change the EDI port code", test, test1);

		waitForElement(driver, EDI_Port_Code_Input_Port_Tab_ECM);
		safeclick(driver, EDI_Port_Code_Input_Port_Tab_ECM);
		clear(driver, EDI_Port_Code_Input_Port_Tab_ECM);
		sendKeys(driver, EDI_Port_Code_Input_Port_Tab_ECM, EDI_Port_Code_Input_Change);

		Step_End(5, "Change Change the EDI port code", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_Start(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test,
				test1);

		waitForPopup(driver, Popup_Message, EDI_Code_Mapping_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (EDI_Code_Mapping_Popup.equals(Applied_Popup)) {
			System.out.println("Matched || " + " Expected saved popup : " + EDI_Code_Mapping_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + EDI_Code_Mapping_Popup
					+ " || Actual saved popup : " + Applied_Popup, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + EDI_Code_Mapping_Popup
					+ " || Actual saved poup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved poup : " + EDI_Code_Mapping_Popup
					+ " || Actual saved poup : " + Applied_Popup, test, test1);

		}

		waitForElement(driver, Filter_btn_Port_ECM);
		click(driver, Filter_btn_Port_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, Liner_Port_Code_Filter_Input_ECM);
		safeclick(driver, Liner_Port_Code_Filter_Input_ECM);
		sendKeys(driver, Liner_Port_Code_Filter_Input_ECM, Liner_Port_code_Change);

		waitForElement(driver, EDI_Port_Code_Filter_Input_ECM);
		safeclick(driver, EDI_Port_Code_Filter_Input_ECM);
		sendKeys(driver, EDI_Port_Code_Filter_Input_ECM, EDI_Port_Code_Input_Change);
		
		waitForDisplay(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (isdisplayed(driver, EDI_Code_Mapping_EDI_ID_Value)) {

			System.out.println("Expected result: The given Liner_Port_code : " + Liner_Port_code_Change
					+ " and the given EDI_Port_Code : " + EDI_Port_Code_Input_Change
					+ " Should be updated in the grid || Actual result : The given Liner_Port_code : "
					+ Liner_Port_code_Change + " and the given Liner_Port_code : " + EDI_Port_Code_Input_Change
					+ " Should be updated in the grid");
			Extent_pass_New(driver,
					"Expected result: The given Liner_Port_code : " + Liner_Port_code_Change
							+ " and the given EDI_Port_Code : " + EDI_Port_Code_Input_Change
							+ " Should be updated in the grid || Actual result : The given Liner_Port_code : "
							+ Liner_Port_code_Change + " and the given EDI_Port_Code : " + EDI_Port_Code_Input_Change
							+ " was updated in the grid",
					test, test1);

		} else {

			System.out.println("Expected result: The given Liner_Port_code : " + Liner_Port_code_Change
					+ " and the given EDI_Port_Code : " + EDI_Port_Code_Input_Change
					+ " Should be updated in the grid || Actual result : The given Liner_Port_code : "
					+ Liner_Port_code_Change + " and the given EDI_Port_Code : " + EDI_Port_Code_Input_Change
					+ " was not updated in the grid");
			Extent_fail(driver,
					"Expected result: The given Liner_Port_code : " + Liner_Port_code_Change
							+ " and the given EDI_Port_Code : " + EDI_Port_Code_Input_Change
							+ " Should be updated in the grid || Actual result : The given Liner_Port_code : "
							+ Liner_Port_code_Change + " and the given EDI_Port_Code : " + EDI_Port_Code_Input_Change
							+ " was not updated in the grid",
					test, test1);

		}

		Step_End(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
}
