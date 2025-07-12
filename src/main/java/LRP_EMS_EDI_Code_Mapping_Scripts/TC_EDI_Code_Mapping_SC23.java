package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC23 extends Keywords {
	public void EDI_Code_Mapping_SC23(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC23";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Mapping_Popup");
		String Liner_Package_Code = Excel_data.get("Liner_Package_Code");
		String EDI_Package = Excel_data.get("EDI_Package");
		String Liner_Package_Header = Excel_data.get("Liner_Package_Header");
		String EDI_Package_Input_Change = Excel_data.get("EDI_Package_Input_Change");
		String Liner_Package_Code_Change = Excel_data.get("Liner_Package_Code_Change");

		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click Click_Package_ tab", test, test1);

		waitForElement(driver, Click_Package_Tab_ECM);
		click(driver, Click_Package_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);

		Step_End(1, "Select the partner Id and click Click_Package_ tab", test, test1);

		Step_Start(2, "And click the show button and select any one data in the AG grid", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn_ECM);
		click(driver, EDI_Code_Show_Btn_ECM);

		waitForElement(driver, Filter_btn_Package_ECM);
		click(driver, Filter_btn_Package_ECM);

		waitForElement(driver, Liner_Package_Filter_Input_ECM);
		safeclick(driver, Liner_Package_Filter_Input_ECM);
		sendKeys(driver, Liner_Package_Filter_Input_ECM, Liner_Package_Code);

		waitForElement(driver, EDI_Package_Filter_Input_ECM);
		safeclick(driver, EDI_Package_Filter_Input_ECM);
		sendKeys(driver, EDI_Package_Filter_Input_ECM, EDI_Package);

		formatLocatorClick(driver, Select_row_Package_ECM, Liner_Package_Code);

		formatLocatorDoubleClick(driver, Double_click_Liner_Package_ECM, Liner_Package_Code);

		Step_End(2, "And click the show button and select any one data in the AG grid", test, test1);

		Step_Start(3, "Click Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click Edit button", test, test1);

		Step_Start(4, "Change the Liner package", test, test1);

		waitForElement(driver, Liner_Package_Search_ECM);
		click(driver, Liner_Package_Search_ECM);

		twoColumnSearchWindow(driver, Liner_Package_Header, Filter_Condition, Liner_Package_Code_Change);

		Step_End(4, "Change the Liner package", test, test1);

		Step_Start(5, "Change the EDI Package", test, test1);

		waitForElement(driver, EDI_Package_Input_Field);
		safeclick(driver, EDI_Package_Input_Field);
		clear(driver, EDI_Package_Input_Field);
		sendKeys(driver, EDI_Package_Input_Field, EDI_Package_Input_Change);

		Step_End(6, "Change the EDI Package", test, test1);

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

		Step_End(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test, test1);

		waitForElement(driver, Filter_btn_Package_ECM);
		click(driver, Filter_btn_Package_ECM);

		waitForElement(driver, Parter_ID_Field_Package_ECM);
		safeclick(driver, Parter_ID_Field_Package_ECM);
		sendKeys(driver, Parter_ID_Field_Package_ECM, Partner_ID);

		waitForElement(driver, Liner_Package_Filter_Input_ECM);
		safeclick(driver, Liner_Package_Filter_Input_ECM);
		sendKeys(driver, Liner_Package_Filter_Input_ECM, Liner_Package_Code_Change);

		waitForElement(driver, EDI_Package_Filter_Input_ECM);
		safeclick(driver, EDI_Package_Filter_Input_ECM);
		sendKeys(driver, EDI_Package_Filter_Input_ECM, EDI_Package_Input_Change);

		waitForDisplay(driver, AG_Grid_First_Row);

		if (isdisplayed(driver, AG_Grid_First_Row)) {

			System.out.println("Expected result: The given Liner Package_Code : " + Liner_Package_Code_Change
					+ " and the given EDI Package : " + EDI_Package_Input_Change
					+ " Should be updated in the grid || Actual result : The given Liner Package_Code : "
					+ Liner_Package_Code_Change + " and the given EDI Package : " + EDI_Package_Input_Change
					+ " Should be updated in the grid");
			Extent_pass_New(driver,
					"Expected result: The given Liner Package_Code : " + Liner_Package_Code_Change
							+ " and the given EDI Package : " + EDI_Package_Input_Change
							+ " Should be updated in the grid || Actual result : The given Liner Package_Code : "
							+ Liner_Package_Code_Change + " and the given EDI Package : " + EDI_Package_Input_Change
							+ " was updated in the grid",
					test, test1);

		} else {

			System.out.println("Expected result: The given Liner Package_Code : " + Liner_Package_Code_Change
					+ " and the given EDI Package : " + EDI_Package_Input_Change
					+ " Should be updated in the grid || Actual result : The given Liner Package_Code : "
					+ Liner_Package_Code_Change + " and the given EDI Package : " + EDI_Package_Input_Change
					+ " was not updated in the grid");
			Extent_fail(driver,
					"Expected result: The given Liner Package_Code : " + Liner_Package_Code_Change
							+ " and the given EDI Package : " + EDI_Package_Input_Change
							+ " Should be updated in the grid || Actual result : The given Liner Package_Code : "
							+ Liner_Package_Code_Change + " and the given EDI Package: " + EDI_Package_Input_Change
							+ " was not updated in the grid",
					test, test1);

		}

		Extent_completed(testCaseName, test, test1);

	}
}
