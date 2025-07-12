package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC09 extends Keywords {
	public void EDI_Code_Mapping_SC09(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC09";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String Package_Code_Header = Excel_data.get("Package_Code_Header");
		String Package_Code = Excel_data.get("Package_Code");
		String EDI_Package_Input1 = Excel_data.get("EDI_Package_Input");
		String EDI_Code_Saved_Popup = Excel_data.get("EDI_Code_Saved_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Click the Package tab", test, test1);

		waitForElement(driver, Click_Package_Tab_ECM);
		click(driver, Click_Package_Tab_ECM);

		Step_End(1, "Click the package tab", test, test1);
		Step_Start(2, "Select the partner id ", test, test1);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(2, "Select the partner id ", test, test1);

		Step_Start(3, "Select the EDI ID ", test, test1);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);
		Step_End(3, "Select the EDI ID ", test, test1);
		Step_Start(4, "Select the any data in LinerpageType ", test, test1);

		waitForElement(driver, Liner_Package_Search_ECM);
		click(driver, Liner_Package_Search_ECM);

		twoColumnSearchWindow(driver, Package_Code_Header, Filter_Condition, Package_Code);

		Step_End(4, "Select the any data in Liner package Type ", test, test1);

		Step_Start(5, "Enter any data in EDI Package text filed  ", test, test1);

		waitForElement(driver, EDI_Package_Input_Field);
		safeclick(driver, EDI_Package_Input_Field);
		sendKeys(driver, EDI_Package_Input_Field, EDI_Package_Input1);

		Step_End(5, "Enter any data in EDI package filed  ", test, test1);
		Step_Start(6, "Click save button ", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Click save button ", test, test1);

		Step_Start(7, "Notification popup \"Edi Code Mapping Saved Successfully\" Should able to show ", test, test1);

		waitForPopup(driver, Popup_Message, EDI_Code_Saved_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(EDI_Code_Saved_Popup)) {
			System.out.println("Matched || " + " Expected saved popup : " + EDI_Code_Saved_Popup
					+ " || Actual saved popup is : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup is: " + EDI_Code_Saved_Popup
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved poup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved poup : " + Applied_Popup, test, test1);

		}

		waitForElement(driver, Filter_btn_Package_ECM);
		click(driver, Filter_btn_Package_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, Liner_Package_Filter_Input_ECM);
		safeclick(driver, Liner_Package_Filter_Input_ECM);
		sendKeys(driver, Liner_Package_Filter_Input_ECM, Package_Code);

		waitForElement(driver, EDI_Code_Mapping_EDI_Package_Field);
		safeclick(driver, EDI_Code_Mapping_EDI_Package_Field);
		sendKeys(driver, EDI_Code_Mapping_EDI_Package_Field, EDI_Package_Input1);

		waitForElement(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);
		String Act_partner_id = getText(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);

		if (Act_partner_id.equals(Partner_ID)) {
			System.out.println("Matched || " + " Expected Partner Id  : " + Partner_ID
					+ " || Actually added Partner Id  : " + Act_partner_id);
			Extent_pass_New(driver, "Matched || " + " Expected Partner Id : " + Partner_ID
					+ " || Actually added Partner Id  is : " + Act_partner_id, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Partner Id  : " + Partner_ID
					+ " || Actually added Expected Partner Id  : " + Act_partner_id);
			Extent_fail(driver, "Not Matched || " + " Expected Partner Id : " + Partner_ID
					+ " || Actually added Expected Partner Id : " + Act_partner_id, test, test1);
		}

		waitForElement(driver, EDI_Code_Mapping_EDI_ID_Value);
		String Act_EDI_ID = getText(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (Act_EDI_ID.equals(EDI_ID)) {
			System.out.println(
					"Matched || " + " Expected EDI ID  : " + EDI_ID + " || Actually added EDI ID  : : " + Act_EDI_ID);
			Extent_pass_New(driver,
					"Matched || " + " Expected EDI ID : " + EDI_ID + " || Actually added EDI ID  : is : " + Act_EDI_ID,
					test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI ID  : : " + EDI_ID
					+ " || Actually added Expected EDI ID  : : " + Act_EDI_ID);
			Extent_fail(driver, "Not Matched || " + " Expected EDI ID  :: " + EDI_ID
					+ " || Actually added Expected EDI ID  :: " + Act_EDI_ID, test, test1);
		}

		waitForElement(driver, EDI_Code_Mapping_EDI_package_Input_Value);
		String Act_EDI_Package_Input1 = getText(driver, EDI_Code_Mapping_EDI_package_Input_Value);

		if (Act_EDI_Package_Input1.equalsIgnoreCase(EDI_Package_Input1)) {
			System.out.println("Matched || " + " Expected EDI_Package  : " + EDI_Package_Input1
					+ " || Actually added  EDI_Package  : : " + EDI_Package_Input1);
			Extent_pass_New(driver, "Matched || " + " Expected EDI_Package : " + EDI_Package_Input1
					+ " || Actually added EDI_Package  : is : " + EDI_Package_Input1, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI_Package  : : " + EDI_Package_Input1
					+ " || Actually added Expected EDI_Package  : : " + EDI_Package_Input1);
			Extent_fail(driver, "Not Matched || " + " Expected EDI_Package_ :: " + EDI_Package_Input1
					+ " || Actual Expected EDI_Package  :: " + EDI_Package_Input1, test, test1);
		}

		Step_End(7, "Click the save button now thw popup should like \"Edi Code Mapping Details Updated\" ", test,
				test1);

		Extent_completed(testCaseName, test, test1);

	}
}
