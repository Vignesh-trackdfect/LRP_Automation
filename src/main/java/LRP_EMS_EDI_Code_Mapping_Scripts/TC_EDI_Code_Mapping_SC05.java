package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC05 extends Keywords {
	public void EDI_Code_Mapping_SC05(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC05";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String Terminal_Code_Header = Excel_data.get("Terminal_Code_Header");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Sender_ID_Input = Excel_data.get("Sender_ID_Input");
		String EDI_Dep_Code = Excel_data.get("EDI_Dep_Code");
		String Depot_Type_Header = Excel_data.get("Depot_Type_Header");
		String Activity_Depot_Input = Excel_data.get("Activity_Depot_Input");
		String Vendorcode_Input = Excel_data.get("Vendorcode_Input");
		String Referenceid_Input = Excel_data.get("Referenceid_Input");
		String EDI_Code_Saved_Popup = Excel_data.get("EDI_Code_Saved_Popup");
		String Filter_Columns = Excel_data.get("Filter_Columns");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Click the Depot tab", test, test1);

		waitForElement(driver, Depot_Tab_ECM);
		click(driver, Depot_Tab_ECM);

		Step_End(1, "Click the Depot tab", test, test1);
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
		Step_Start(4, "Select the depot /terminal ", test, test1);

		waitForElement(driver, Depot_Terminal_Search_ECM);
		click(driver, Depot_Terminal_Search_ECM);

		twoColumnSearchWindow(driver, Terminal_Code_Header, Filter_Condition, Terminal_Code);

		Step_End(4, "Select the depot /terminal ", test, test1);

		Step_Start(5, "Enter any data in EDI Dep.Code text filed  ", test, test1);
		waitForElement(driver, Eqp_Dep_Code_Input_ECM);
		safeclick(driver, Eqp_Dep_Code_Input_ECM);
		sendKeys(driver, Eqp_Dep_Code_Input_ECM, EDI_Dep_Code);

		Step_End(5, "Enter any data in EDI Dep.Code text filed  ", test, test1);

		waitForElement(driver, Depot_Tab_ECM_Sender_ID_Input);
		click(driver, Depot_Tab_ECM_Sender_ID_Input);
		sendKeys(driver, Depot_Tab_ECM_Sender_ID_Input, Sender_ID_Input);

		waitForElement(driver, Depot_Type_Search_Btn);
		click(driver, Depot_Type_Search_Btn);

		twoColumnSearchWindow(driver, Depot_Type_Header, Filter_Condition, Activity_Depot_Input);

		waitForElement(driver, Depot_Tab_ECM_Vendorcode_Input);
		click(driver, Depot_Tab_ECM_Vendorcode_Input);
		sendKeys(driver, Depot_Tab_ECM_Vendorcode_Input, Vendorcode_Input);

		waitForElement(driver, Depot_Tab_ECM_Referenceid);
		click(driver, Depot_Tab_ECM_Referenceid);
		sendKeys(driver, Depot_Tab_ECM_Referenceid, Referenceid_Input);

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
					+ " || Actual saved poup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved poup: " + EDI_Code_Saved_Popup
					+ " || Actual saved poup : " + Applied_Popup, test, test1);

		}
		
		reArrangeAG_GridColumns(driver, Filter_Columns);

		waitForElement(driver, Filter_btn_Depot_ECM);
		click(driver, Filter_btn_Depot_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, Terminal_Code_Filter_Input_ECM);
		safeclick(driver, Terminal_Code_Filter_Input_ECM);
		sendKeys(driver, Terminal_Code_Filter_Input_ECM, Terminal_Code);

		waitForElement(driver, EDI_Dep_Code_Filter_Input_ECM);
		safeclick(driver, EDI_Dep_Code_Filter_Input_ECM);
		sendKeys(driver, EDI_Dep_Code_Filter_Input_ECM, EDI_Dep_Code);
		
		waitForElement(driver, Ref_FilterInput_ECM);
		safeclick(driver, Ref_FilterInput_ECM);
		sendKeys(driver, Ref_FilterInput_ECM, Referenceid_Input);

		waitForElement(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);
		String Act_partner_id = getText(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);

		if (Act_partner_id.equals(Partner_ID)) {
			System.out.println("Matched || " + " Expected Partner Id : " + Partner_ID
					+ " || Actually addedly added Partner Id : " + Act_partner_id);
			Extent_pass_New(driver, "Matched || " + " Expected Partner Id: " + Partner_ID
					+ " || Actually added Partner Id is : " + Act_partner_id, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Partner Id : " + Partner_ID
					+ " || Actually added Expected Partner Id : " + Act_partner_id);
			Extent_fail(driver, "Not Matched || " + " Expected Partner Id: " + Partner_ID
					+ " || Actually added Expected Partner Id: " + Act_partner_id, test, test1);
		}

		waitForElement(driver, EDI_Code_Mapping_EDI_Terminal_Code_Value);
		String Act_Terminal_Code = getText(driver, EDI_Code_Mapping_EDI_Terminal_Code_Value);

		if (Act_Terminal_Code.equals(Terminal_Code)) {
			System.out.println("Matched || " + " Expected Terminal_Code verify : " + Terminal_Code
					+ " || Actually added Terminal_Code verify : " + Act_Terminal_Code);
			Extent_pass_New(driver, "Matched || " + " Expected Terminal_Code verify: " + Terminal_Code
					+ " || Actually added Terminal_Code  verify : is : " + Act_Terminal_Code, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Terminal_Code verify : : " + Terminal_Code
					+ " || Actually added Expected Terminal_Code : " + Act_Terminal_Code);
			Extent_fail(driver, "Not Matched || " + " Expected Terminal_Code : " + Terminal_Code
					+ " || Actually added Expected Terminal_Code verify : " + Act_Terminal_Code, test, test1);
		}

		waitForElement(driver, EDI_Code_Mapping_EDI_Dep_Code_Value);
		String Act_EDI_Dep_Code = getText(driver, EDI_Code_Mapping_EDI_Dep_Code_Value);

		if (Act_EDI_Dep_Code.equals(EDI_Dep_Code)) {
			System.out.println("Matched || " + " Expected EDI_Dep_Code : " + EDI_Dep_Code
					+ " || Actually added EDI_Dep_Code : " + Act_EDI_Dep_Code);
			Extent_pass_New(driver, "Matched || " + " Expected EDI_Dep_Code : " + EDI_Dep_Code
					+ " || Actually added EDI_Dep_Code : " + Act_EDI_Dep_Code, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI_Dep_Code verify : " + EDI_Dep_Code
					+ " || Actually added Expected EDI_Dep_Code : " + Act_EDI_Dep_Code);
			Extent_fail(driver, "Not Matched || " + " Expected Terminal_Code verify : " + EDI_Dep_Code
					+ " || Actually added Expected EDI_Dep_Code : " + Act_EDI_Dep_Code, test, test1);
		}

		Step_End(7, "Notification popup \"Edi Code Mapping Saved Successfully\" Should able to show ", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}