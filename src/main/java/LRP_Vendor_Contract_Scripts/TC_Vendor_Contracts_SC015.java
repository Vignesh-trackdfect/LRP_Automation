package LRP_Vendor_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Contracts_SC015 extends Keywords {

	public void Vendor_Contracts_SC015(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Contracts_SC015";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Global_Search_Option = Excel_data.get("Global_Search_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Confirmation_popup = Excel_data.get("Confirmation_popup");
		String Saved_popup = Excel_data.get("Saved_popup");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");
		String VendorCode_Header = Excel_data.get("VendorCode_Header");
		String VendorCode = Excel_data.get("VendorCode");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_Start(1, "Enter the screen name as 'Vendor Contracts' in module search field", test, test1);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, moduleName);

		Step_End(1, "Enter the screen name as 'Vendor Contracts' in module search field", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar", test, test1);
		Step_Start(3, "Check whether it opens a Contract details search window", test, test1);
		Step_Start(4, "Enter the saved Contract number in the Contract number search field", test, test1);
		Step_Start(5, "Then click on the search button", test, test1);
		Step_Start(6, "System will show the Contract number", test, test1);
		Step_Start(7, "Click on the select button", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Global_Search_Condition, Global_Search_Option, Contract_Number, "", "", "", "");

		Step_End(2, "Click on the global search option which is available in the tool bar", test, test1);
		Step_End(3, "Check whether it opens a Contract details search window", test, test1);
		Step_End(4, "Enter the saved Contract number in the Contract number search field", test, test1);
		Step_End(5, "Then click on the search button", test, test1);
		Step_End(6, "System will show the Contract number", test, test1);
		Step_End(7, "Click on the select button", test, test1);

		Step_Start(8, "System will retrieve the contract", test, test1);

		waitForElement(driver, contract_No_VC);

		String contractNo = getAttribute(driver, contract_No_VC, "value");

		if (contractNo.equals(Contract_Number)) {

			System.out.println("Expected contract no was retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo);
			Extent_pass_New(driver, "Expected contract no was retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo, test, test1);
		} else {

			System.out.println("Expected contract no was not retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo);
			Extent_fail(driver, "Expected contract no was not retrieved || Expected no : " + Contract_Number
					+ " || Actual no : " + contractNo, test, test1);

		}

		Step_End(8, "System will retrieve the contract", test, test1);

		Step_Start(9, "Click on edit option in the toolbar", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(9, "Click on edit option in the toolbar", test, test1);

		Step_Start(10, "Click on save as option in the toolbar", test, test1);

		waitForElement(driver, VC_GridRecords_Count);
		String old_records = getText(driver, VC_GridRecords_Count);

		waitForElement(driver, SaveAs_button_toolBar);
		click(driver, SaveAs_button_toolBar);

		Step_End(10, "Click on save as option in the toolbar", test, test1);

		Step_Start(11,
				"Check whether the system populates the confirmation message as 'Do you want to change the vendor?'",
				test, test1);

		waitForPopup(driver, popup_Message, Confirmation_popup);

		String Actual_confirm = getText(driver, popup_Message);

		if (Actual_confirm.equals(Confirmation_popup)) {

			System.out.println(
					"Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm);
			Extent_fail(driver,
					"Not Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm,
					test, test1);

		}

		Step_Start(11,
				"Check whether the system populates the confirmation message as 'Do you want to change the vendor?'",
				test, test1);

		Step_Start(12, "Click on 'No' ", test, test1);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		Step_Start(12, "Click on 'No' ", test, test1);

		Step_Start(13, "System shows as Vendor contract saved and click ok option", test, test1);

		waitForPopup(driver, popup_Message, Saved_popup);

		String Actual_Saved = getText(driver, popup_Message);

		if (Saved_popup.equals(Actual_Saved)) {

			System.out.println("Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_Saved);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_Saved, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_Saved);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_Saved, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, contract_No_VC);

		String Changed_contractNo = getAttribute(driver, contract_No_VC, "value");

		if (!Changed_contractNo.equals(Contract_Number)) {

			System.out.println("After save as, Contract number got changed || Previous contract no was : "
					+ Contract_Number + " || Changed contract number was : " + Changed_contractNo);
			Extent_pass_New(driver, "After save as, Contract number got changed || Previous contract no was : "
					+ Contract_Number + " || Changed contract number was : " + Changed_contractNo, test, test1);
		} else {

			System.out.println("After save as, Contract number not changed || Previous contract no was : "
					+ Contract_Number + " || Changed contract number was : " + Changed_contractNo);
			Extent_fail(driver, "After save as, Contract number not changed || Previous contract no was : "
					+ Contract_Number + " || Changed contract number was : " + Changed_contractNo, test, test1);

		}

		waitForElement(driver, VC_GridRecords_Count);
		String saved_Contract_records = getText(driver, VC_GridRecords_Count);

		if (saved_Contract_records.equals(old_records)) {

			System.out.println("All the records are showing in the saved as contract || Expected record count was : "
					+ old_records + " || Actual record count was : " + saved_Contract_records);
			Extent_pass_New(driver,
					"All the records are showing in the saved as contract || Expected record count was : " + old_records
							+ " || Actual record count was : " + saved_Contract_records,
					test, test1);

		} else {

			System.out.println(
					"Some of the records are not showing in the saved as contract || Expected record count was : "
							+ old_records + " || Actual record count was : " + saved_Contract_records);
			Extent_fail(driver,
					"Some of the records are not showing in the saved as contract || Expected record count was : "
							+ old_records + " || Actual record count was : " + saved_Contract_records,
					test, test1);
		}

		Step_End(13, "System shows as Vendor contract saved and click ok option", test, test1);

		Step_Start(14, " Click on 'Yes' option for the confirmation message 'Do you want to change the vendor?'", test,
				test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, SaveAs_button_toolBar);
		click(driver, SaveAs_button_toolBar);

		waitForPopup(driver, popup_Message, Confirmation_popup);

		String Actual_confirm2 = getText(driver, popup_Message);

		if (Actual_confirm2.equals(Confirmation_popup)) {

			System.out.println(
					"Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm2);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm2, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm2);
			Extent_fail(driver,
					"Not Matched || Expected popup : " + Confirmation_popup + " || Actual popup : " + Actual_confirm2,
					test, test1);

		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(14, " Click on 'Yes' option for the confirmation message 'Do you want to change the vendor?'", test,
				test1);

		Step_Start(15, "Edit the vendor and click save as option in the toolbar", test, test1);

		waitForElement(driver, vendor_code_search_icon_Vc);
		click(driver, vendor_code_search_icon_Vc);

		twoColumnSearchWindow(driver, VendorCode_Header, TwoColumn_Condition, VendorCode);

		waitForElement(driver, SaveAs_button_toolBar);
		click(driver, SaveAs_button_toolBar);

		Step_End(15, "Edit the vendor and click save as option in the toolbar", test, test1);

		Step_Start(16, "The system shows the message as vendor contract saved and click 'ok'", test, test1);

		waitForPopup(driver, popup_Message, Confirmation_popup);

		String Actual_saved3 = getText(driver, popup_Message);

		if (Saved_popup.equals(Actual_saved3)) {

			System.out.println("Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_saved3);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_saved3, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_saved3);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Saved_popup
					+ " || Actual popup message was : " + Actual_saved3, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(16, "The system shows the message as vendor contract saved and click 'ok'", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
