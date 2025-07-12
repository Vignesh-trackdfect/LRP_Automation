package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC07 extends Keywords {
	public void EDI_Code_Mapping_SC07(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC07";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String Size_Type_Header = Excel_data.get("Size_Type_Header");
		String Size_Type_value = Excel_data.get("Size_Type");
		String EDI_Eqp_Type = Excel_data.get("EDI_Eqp_Type_Input");
		String EDI_Code_Saved_Popup = Excel_data.get("EDI_Code_Saved_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Click the ISO tab", test, test1);

		waitForElement(driver, Click_ISO_Tab);
		click(driver, Click_ISO_Tab);

		Step_End(1, "Click the ISO tab", test, test1);
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
		Step_Start(4, "Select the any data in Liner Eqp.Type ", test, test1);

		waitForElement(driver, Liner_Eqp_Type);
		click(driver, Liner_Eqp_Type);

		twoColumnSearchWindow(driver, Size_Type_Header, Filter_Condition, Size_Type_value);

		Step_End(4, "Select the any data in Liner Eqp.Type ", test, test1);

		Step_Start(5, "Enter any data in EDI Eqp.Type text filed  ", test, test1);

		waitForElement(driver, EDI_Eqp_Type_Input);
		safeclick(driver, EDI_Eqp_Type_Input);
		sendKeys(driver, EDI_Eqp_Type_Input, EDI_Eqp_Type);

		Step_End(5, "Enter any data in EDI Eqp.Type text filed  ", test, test1);
		Step_Start(6, "Click save button ", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Click save button ", test, test1);

		Step_Start(7, "Notification popup \"Edi Code Mapping Saved Successfully\" Should able to show ", test, test1);

		waitForPopup(driver, Popup_Message, EDI_Code_Saved_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(EDI_Code_Saved_Popup)) {
			System.out.println("Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + EDI_Code_Saved_Popup
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);

		}

		else {
			System.out.println("Not Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual Expected saved poup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved poup: " + EDI_Code_Saved_Popup
					+ " || Actual Expected saved poup : " + Applied_Popup, test, test1);

		}

		waitForElement(driver, Filter_Button_ECM);
		click(driver, Filter_Button_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, EDI_ID_Field_ECM);
		safeclick(driver, EDI_ID_Field_ECM);
		sendKeys(driver, EDI_ID_Field_ECM, EDI_ID);

		waitForElement(driver, EDI_eqp_Type_field_ECM);
		safeclick(driver, EDI_eqp_Type_field_ECM);
		sendKeys(driver, EDI_eqp_Type_field_ECM, EDI_Eqp_Type);

		waitForElement(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);
		String Act_partner_id = getText(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);

		if (Act_partner_id.equals(Partner_ID)) {
			System.out.println("Matched || Expected Partner Id : " + Partner_ID
					+ " || Actually addedly added Partner Id : " + Act_partner_id);
			Extent_pass_New(driver, "Matched || Expected Partner Id: " + Partner_ID
					+ " || Actually added Partner Id is : " + Act_partner_id, test, test1);

		} else {
			System.out.println("Not Matched || Expected Partner Id : " + Partner_ID
					+ " || Actually added Expected Partner Id : " + Act_partner_id);
			Extent_fail(driver, "Not Matched || Expected Partner Id: " + Partner_ID
					+ " || Actually added Expected Partner Id: " + Act_partner_id, test, test1);
		}

		waitForElement(driver, EDI_Code_Mapping_EDI_ID_Value);
		String Act_EDI_ID = getText(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (Act_EDI_ID.equals(EDI_ID)) {
			System.out.println("Matched || Expected EDI ID verify : " + EDI_ID + " || Actually added EDI ID verify : : "
					+ Act_EDI_ID);
			Extent_pass_New(driver, "Matched || Expected EDI ID verify: " + EDI_ID
					+ " || Actually added EDI ID verify : is : " + Act_EDI_ID, test, test1);

		} else {
			System.out.println("Not Matched || Expected EDI ID verify : : " + EDI_ID
					+ " || Actually added Expected EDI ID verify : : " + Act_EDI_ID);
			Extent_fail(driver, "Not Matched || " + " Expected EDI ID verify :: " + EDI_ID
					+ " || Actually added Expected EDI ID verify :: " + Act_EDI_ID, test, test1);
		}

		waitForElement(driver, EDI_Code_Mapping_EDI_Eqp_Type_Value);
		String Act_EDI_Eqp_Type = getText(driver, EDI_Code_Mapping_EDI_Eqp_Type_Value);

		if (Act_EDI_Eqp_Type.equals(EDI_Eqp_Type)) {
			System.out.println("Matched || Expected EDI_Eqp_Type : " + EDI_Eqp_Type
					+ " || Actually added EDI ID verify : " + Act_EDI_Eqp_Type);
			Extent_pass_New(driver, "Matched || Expected EDI_Eqp_Type : " + EDI_Eqp_Type
					+ " || Actually added EDI ID verify : is : " + Act_EDI_Eqp_Type, test, test1);

		} else {
			System.out.println("Not Matched || Expected EDI_Eqp_Type : : " + EDI_Eqp_Type
					+ " || Actually added Expected EDI_Eqp_Type : " + Act_EDI_Eqp_Type);
			Extent_fail(driver, "Not Matched || Expected EDI_Eqp_Type : " + EDI_Eqp_Type
					+ " || Actually added Expected EDI_Eqp_Type : " + Act_EDI_Eqp_Type, test, test1);
		}

		Step_End(7, "Notification popup \"Edi Code Mapping Saved Successfully\" Should able to show ", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}