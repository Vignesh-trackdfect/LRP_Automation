package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC21 extends Keywords {

	public void EDI_Code_Mapping_SC21(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC21";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Mapping_Popup");
		String Terminal_Code_Header = Excel_data.get("Terminal_Code_Header");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Terminal_Code_Change = Excel_data.get("Terminal_Code_Change");
		String EDI_Dep_Code = Excel_data.get("EDI_Dep_Code");
		String EDI_Dep_Code_Change = Excel_data.get("EDI_Dep_Code_Change");
		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click Depot tab", test, test1);

		waitForElement(driver, Depot_Tab_ECM);
		click(driver, Depot_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);

		Step_End(1, "Select the partner Id and click Depot tab", test, test1);

		Step_Start(2, "And click the show button and select any one data in the AG grid", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn_ECM);
		click(driver, EDI_Code_Show_Btn_ECM);

		waitForElement(driver, Filter_btn_Depot_ECM);
		click(driver, Filter_btn_Depot_ECM);

		waitForElement(driver, Terminal_Code_Filter_Input_ECM);
		safeclick(driver, Terminal_Code_Filter_Input_ECM);
		sendKeys(driver, Terminal_Code_Filter_Input_ECM, Terminal_Code);

		waitForElement(driver, EDI_Dep_Code_Filter_Input_ECM);
		safeclick(driver, EDI_Dep_Code_Filter_Input_ECM);
		sendKeys(driver, EDI_Dep_Code_Filter_Input_ECM, EDI_Dep_Code);

		formatLocatorClick(driver, Select_Filter_First_Row_ECM, Terminal_Code);

		formatLocatorDoubleClick(driver, Double_Click_Terminal_Code_ECM, Terminal_Code);

		Step_End(2, "And click the show button and select any one data in the AG grid", test, test1);

		Step_Start(3, "Click Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click Edit button", test, test1);

		Step_Start(4, "Change the Depot/Terminal  code", test, test1);

		waitForElement(driver, Depot_Terminal_Search_ECM);
		click(driver, Depot_Terminal_Search_ECM);

		twoColumnSearchWindow(driver, Terminal_Code_Header, Filter_Condition, Terminal_Code_Change);

		Step_End(4, " Change the Depot/Terminal  code", test, test1);

		Step_Start(5, "Change the EDI.dep.code", test, test1);

		waitForElement(driver, Eqp_Dep_Code_Input_ECM);
		safeclick(driver, Eqp_Dep_Code_Input_ECM);
		clear(driver, Eqp_Dep_Code_Input_ECM);
		sendKeys(driver, Eqp_Dep_Code_Input_ECM, EDI_Dep_Code_Change);

		Step_End(5, "Change the EDI.dep.code", test, test1);

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

		waitForElement(driver, Filter_btn_Depot_ECM);
		click(driver, Filter_btn_Depot_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, Terminal_Code_Filter_Input_ECM);
		safeclick(driver, Terminal_Code_Filter_Input_ECM);
		sendKeys(driver, Terminal_Code_Filter_Input_ECM, Terminal_Code_Change);

		waitForElement(driver, EDI_Dep_Code_Filter_Input_ECM);
		safeclick(driver, EDI_Dep_Code_Filter_Input_ECM);
		sendKeys(driver, EDI_Dep_Code_Filter_Input_ECM, EDI_Dep_Code_Change);

		waitForDisplay(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (isdisplayed(driver, EDI_Code_Mapping_EDI_ID_Value)) {

			System.out.println("Expected result: The given Terminal code : " + Terminal_Code_Change
					+ " and the given EDI Dep Code : " + EDI_Dep_Code_Change
					+ " Should be updated in the grid || Actual result : The given Terminal code : "
					+ Terminal_Code_Change + " and the given EDI Dep Code : " + EDI_Dep_Code_Change
					+ " Should be updated in the grid");
			Extent_pass_New(driver,
					"Expected result: The given Terminal code : " + Terminal_Code_Change
							+ " and the given EDI_Dep_Code : " + EDI_Dep_Code_Change
							+ " Should be updated in the grid || Actual result : The given Terminal code : "
							+ Terminal_Code_Change + " and the given EDI Dep Code : " + EDI_Dep_Code_Change
							+ " was updated in the grid",
					test, test1);

		} else {

			System.out.println("Expected result: The given Terminal_code : " + Terminal_Code_Change
					+ " and the given EDI Dep Code : " + EDI_Dep_Code_Change
					+ " Should be updated in the grid || Actual result : The given Terminal code : "
					+ Terminal_Code_Change + " and the given EDI Dep Code : " + EDI_Dep_Code_Change
					+ " was not updated in the grid");
			Extent_fail(driver,
					"Expected result: The given Terminal code : " + Terminal_Code_Change
							+ " and the given EDI Dep Code : " + EDI_Dep_Code_Change
							+ " Should be updated in the grid || Actual result : The given Terminal code : "
							+ Terminal_Code_Change + " and the given EDI Dep Code : " + EDI_Dep_Code_Change
							+ " was not updated in the grid",
					test, test1);

		}
		
		Step_End(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
}
