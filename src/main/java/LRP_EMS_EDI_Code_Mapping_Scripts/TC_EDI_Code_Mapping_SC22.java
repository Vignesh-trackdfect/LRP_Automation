package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC22 extends Keywords {
	public void EDI_Code_Mapping_SC22(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC22";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Mapping_Popup");
		String EDI_Eqp_Type = Excel_data.get("EDI_Eqp_Type_Input");
		String Size_Type_Header = Excel_data.get("Size_Type_Header");
		String Size_Type_value = Excel_data.get("Size_Type");
		String Size_Type_Input_Change = Excel_data.get("Size_Type_Input_Change");
		String EDI_Eqp_Type_Input_Change = Excel_data.get("EDI_Eqp_Type_Input_Change");

		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click ISO tab", test, test1);

		waitForElement(driver, Click_ISO_Tab);
		click(driver, Click_ISO_Tab);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);

		Step_End(1, "Select the partner Id and click ISO tab", test, test1);

		Step_Start(2, "And click the show button and select any one data in the AG grid", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn_ECM);
		click(driver, EDI_Code_Show_Btn_ECM);

		waitForElement(driver, Filter_btn_ISO_ECM);
		click(driver, Filter_btn_ISO_ECM);

		waitForElement(driver, Liner_Eqp_Type_Field_ECM);
		safeclick(driver, Liner_Eqp_Type_Field_ECM);
		sendKeys(driver, Liner_Eqp_Type_Field_ECM, Size_Type_value);

		waitForElement(driver, EDI_eqp_Type_field_ECM);
		safeclick(driver, EDI_eqp_Type_field_ECM);
		sendKeys(driver, EDI_eqp_Type_field_ECM, EDI_Eqp_Type);

		formatLocatorClick(driver, Select_Row_ISO_ECM, Size_Type_value);

		formatLocatorDoubleClick(driver, Double_click_Liner_Eqp_Type_ECM, Size_Type_value);

		Step_End(2, "And click the show button and select any one data in the AG grid", test, test1);

		Step_Start(3, "Click Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click Edit button", test, test1);

		Step_Start(4, "Change the Liner_Eqp_Type code", test, test1);

		waitForElement(driver, Liner_Eqp_Type);
		click(driver, Liner_Eqp_Type);

		twoColumnSearchWindow(driver, Size_Type_Header, Filter_Condition, Size_Type_Input_Change);

		Step_End(4, "Change the Liner_Eqp_Type code", test, test1);

		Step_Start(5, "Change the EDI_eqp_Type", test, test1);

		waitForElement(driver, EDI_Eqp_Type_Input);
		safeclick(driver, EDI_Eqp_Type_Input);
		clear(driver, EDI_Eqp_Type_Input);
		sendKeys(driver, EDI_Eqp_Type_Input, EDI_Eqp_Type_Input_Change);

		Step_End(5, "Change the EDI_eqp_Type", test, test1);

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

		Step_End(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test, test1);

		waitForElement(driver, Filter_btn_ISO_ECM);
		click(driver, Filter_btn_ISO_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, Liner_Eqp_Type_Field_ISO_ECM);
		safeclick(driver, Liner_Eqp_Type_Field_ISO_ECM);
		sendKeys(driver, Liner_Eqp_Type_Field_ISO_ECM, Size_Type_Input_Change);

		waitForElement(driver, EDI_eqp_Type_field_ECM);
		safeclick(driver, EDI_eqp_Type_field_ECM);
		sendKeys(driver, EDI_eqp_Type_field_ECM, EDI_Eqp_Type_Input_Change);

		waitForDisplay(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (isdisplayed(driver, EDI_Code_Mapping_EDI_ID_Value)) {

			System.out.println("Expected result: The given Liner_Eqp_Type : " + Size_Type_Input_Change
					+ " and the given EDI_eqp_Type : " + EDI_Eqp_Type_Input_Change
					+ " Should be updated in the grid || Actual result : The given Liner_Eqp_Type : "
					+ Size_Type_Input_Change + " and the given Liner_Eqp_Type : " + EDI_Eqp_Type_Input_Change
					+ " Should be updated in the grid");
			Extent_pass_New(driver,
					"Expected result: The given Liner_Eqp_Type : " + Size_Type_Input_Change
							+ " and the given EDI_eqp_Type : " + EDI_Eqp_Type_Input_Change
							+ " Should be updated in the grid || Actual result : The given Liner_Eqp_Type : "
							+ Size_Type_Input_Change + " and the given EDI_eqp_Type : " + EDI_Eqp_Type_Input_Change
							+ " was updated in the grid",
					test, test1);

		} else {

			System.out.println("Expected result: The given Liner_Eqp_Type : " + Size_Type_Input_Change
					+ " and the given EDI_eqp_Type : " + EDI_Eqp_Type_Input_Change
					+ " Should be updated in the grid || Actual result : The given Liner_Eqp_Type : "
					+ Size_Type_Input_Change + " and the given EDI_eqp_Type : " + EDI_Eqp_Type_Input_Change
					+ " was not updated in the grid");
			Extent_fail(driver,
					"Expected result: The given Liner_Eqp_Type : " + Size_Type_Input_Change
							+ " and the given EDI_eqp_Type : " + EDI_Eqp_Type_Input_Change
							+ " Should be updated in the grid || Actual result : The given Liner_Eqp_Type : "
							+ Size_Type_Input_Change + " and the given EDI_eqp_Type : " + EDI_Eqp_Type_Input_Change
							+ " was not updated in the grid",
					test, test1);

		}

		Extent_completed(testCaseName, test, test1);
	}
}
