package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC24 extends Keywords {
	public void EDI_Code_Mapping_SC24(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC24";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String Commodity_Code = Excel_data.get("Commodity_Code");
		String EDI_Commodity_Code_Input = Excel_data.get("EDI_Commodity_Code_Input");
		String ComdtyCode_Header = Excel_data.get("ComdtyCode_Header");
		String Commodity_Code_Change = Excel_data.get("Commodity_Code_Change");
		String EDI_Commodity_Code_Change = Excel_data.get("EDI_Commodity_Code_Change");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Mapping_Popup");

		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click commodity tab", test, test1);

		waitForElement(driver, Commodity_Code_Tab_ECM);
		click(driver, Commodity_Code_Tab_ECM);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);

		Step_End(1, "Select the partner Id and click commodity tab", test, test1);

		Step_Start(2, "And click the show button and select any one data in the AG grid", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn_ECM);
		click(driver, EDI_Code_Show_Btn_ECM);

		waitForElement(driver, Filter_Button_CommodityCode_ECM);
		click(driver, Filter_Button_CommodityCode_ECM);

		waitForElement(driver, CommodityCode_Field_ECM);
		safeclick(driver, CommodityCode_Field_ECM);
		sendKeys(driver, CommodityCode_Field_ECM, Commodity_Code);

		waitForElement(driver, EDI_CommodityCode_Field_ECM);
		safeclick(driver, EDI_CommodityCode_Field_ECM);
		sendKeys(driver, EDI_CommodityCode_Field_ECM, EDI_Commodity_Code_Input);

		formatLocatorClick(driver, Select_row_Commodity_ECM, Commodity_Code);

		formatLocatorDoubleClick(driver, Double_click_Commodity_Code_ECM, Commodity_Code);

		Step_End(2, "And click the show button and select any one data in the AG grid", test, test1);

		Step_Start(3, "Click Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click Edit button", test, test1);

		Step_Start(4, "Change the Commodity code", test, test1);

		waitForElement(driver, Commodity_Code_Search_ECM);
		click(driver, Commodity_Code_Search_ECM);

		twoColumnSearchWindow(driver, ComdtyCode_Header, Filter_Condition, Commodity_Code_Change);

		Step_End(4, "Change the Commodity code", test, test1);

		Step_Start(5, "Change the EDI_Commodity_Code_", test, test1);

		waitForElement(driver, EDI_Commodity_Code_Input_ECM);
		safeclick(driver, EDI_Commodity_Code_Input_ECM);
		clear(driver, EDI_Commodity_Code_Input_ECM);
		sendKeys(driver, EDI_Commodity_Code_Input_ECM, EDI_Commodity_Code_Change);

		Step_End(6, "Change the EDI_Commodity_Code_", test, test1);

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

		waitForElement(driver, Filter_Button_CommodityCode_ECM);
		click(driver, Filter_Button_CommodityCode_ECM);
		
		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, CommodityCode_Field_ECM);
		safeclick(driver, CommodityCode_Field_ECM);
		sendKeys(driver, CommodityCode_Field_ECM, Commodity_Code_Change);

		waitForElement(driver, EDI_CommodityCode_Field_ECM);
		safeclick(driver, EDI_CommodityCode_Field_ECM);
		sendKeys(driver, EDI_CommodityCode_Field_ECM, EDI_Commodity_Code_Change);

		waitForDisplay(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (isdisplayed(driver, EDI_Code_Mapping_EDI_ID_Value)) {

			System.out.println("Expected result: The given commodity code : " + Commodity_Code_Change
					+ " and the given Edi commodity : " + EDI_Commodity_Code_Change
					+ " Should be updated in the grid || Actual result : The given commodity code : "
					+ Commodity_Code_Change + " and the given Edi commodity : " + EDI_Commodity_Code_Change
					+ " Should be updated in the grid");
			Extent_pass_New(driver, "Expected result: The given commodity code : " + Commodity_Code_Change
					+ " and the given Edi commodity : " + EDI_Commodity_Code_Change
					+ " Should be updated in the grid || Actual result : The given commodity code : " + Commodity_Code_Change
					+ " and the given Edi commodity : " + EDI_Commodity_Code_Change + " was updated in the grid", test,
					test1);

		} else {

			System.out.println("Expected result: The given commodity code : " + Commodity_Code_Change
					+ " and the given Edi commodity : " + EDI_Commodity_Code_Change
					+ " Should be updated in the grid || Actual result : The given commodity code : "
					+ Commodity_Code_Change + " and the given Edi commodity : " + EDI_Commodity_Code_Change
					+ " was not updated in the grid");
			Extent_fail(driver,
					"Expected result: The given commodity code : " + Commodity_Code_Change
							+ " and the given Edi commodity : " + EDI_Commodity_Code_Change
							+ " Should be updated in the grid || Actual result : The given commodity code : "
							+ Commodity_Code_Change + " and the given Edi commodity : " + EDI_Commodity_Code_Change
							+ " was not updated in the grid",
					test, test1);

		}

		Step_End(6, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated", test, test1);
		
		Extent_completed(testCaseName, test, test1);

	}
}
