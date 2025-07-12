package LRP_Vendor_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Contracts_SC012 extends Keywords {

	public void Vendor_Contracts_SC012(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Contracts_SC012";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String agencyCode = Excel_data.get("AgencyCode");
		String Global_Search_Option = Excel_data.get("Global_Search_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Confirm_Delete_PopupMessage = Excel_data.get("Confirm_Delete_PopupMessage");
		String Delete_PopupMessage = Excel_data.get("Delete_PopupMessage");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_Start(1, "Enter the screen name as 'Vendor Contracts' in module search field", test, test1);

		SwitchProfile(driver, agencyCode);

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

		Step_Start(9, "Click on the tool bar delete option", test, test1);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		Step_End(9, "Click on the tool bar delete option", test, test1);

		Step_Start(10,
				".Check whether the system populates the validation message as 'Do you want to delete the Vendor contract?'",
				test, test1);

		waitForPopup(driver, popup_Message, Confirm_Delete_PopupMessage);

		String delete_Confirm_Popup = getText(driver, popup_Message);

		if (Confirm_Delete_PopupMessage.equals(delete_Confirm_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Confirm_Delete_PopupMessage
					+ " || Actual popup message was : " + delete_Confirm_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Confirm_Delete_PopupMessage
					+ " || Actual popup message was : " + delete_Confirm_Popup, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + Confirm_Delete_PopupMessage
					+ " || Actual popup message was : " + delete_Confirm_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Confirm_Delete_PopupMessage
					+ " || Actual popup message was : " + delete_Confirm_Popup, test, test1);

		}

		Step_End(10,
				".Check whether the system populates the validation message as 'Do you want to delete the Vendor contract?'",
				test, test1);

		Step_Start(13, "Click on 'No' for the validation message", test, test1);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		Step_End(13, "Click on 'No' for the validation message", test, test1);

		Step_Start(14, "Ensure that contract number will not be deleted", test, test1);

		waitForDisplay(driver, Delete_button_toolBar);
		if (isElementEnabled(driver, Delete_button_toolBar)) {

			System.out.println(
					"Expected result is : The contract number should not be deleted || Actual result is : Contract number is not deleted");
			Extent_pass_New(driver,
					"Expected result is : The contract number should not be deleted || Actual result is : Contract number is not deleted",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The contract number should not be deleted || Actual result is : Contract number is deleted");
			Extent_fail(driver,
					"Expected result is : The contract number should not be deleted || Actual result is : Contract number is deleted",
					test, test1);
		}

		Step_End(14, "Ensure that contract number will not be deleted", test, test1);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);

		Step_Start(11, "Click on 'Yes'", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(11, "Click on 'Yes'", test, test1);

		Step_Start(12,
				"Check whether the system shows the validation message like 'This contract is mapped to some ports cannot be delete.Check Mapped ports'",
				test, test1);

		waitForPopup(driver, popup_Message, Confirm_Delete_PopupMessage);

		String Warning_Popup = getText(driver, popup_Message);

		if (Delete_PopupMessage.equals(Warning_Popup)) {

			System.out.println("Matched || Expected popup message was : " + Delete_PopupMessage
					+ " || Actual popup message was : " + Warning_Popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Delete_PopupMessage
					+ " || Actual popup message was : " + Warning_Popup, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + Delete_PopupMessage
					+ " || Actual popup message was : " + Warning_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Delete_PopupMessage
					+ " || Actual popup message was : " + Warning_Popup, test, test1);

		}

		Step_End(12, "Click on 'No' for the validation message", test, test1);

		Step_Start(13, "Click on 'No' for the validation message", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(13, "Click on 'No' for the validation message", test, test1);

		Step_Start(14, "Ensure that contract number will not be deleted", test, test1);

		if (!isElementEnabled(driver, Delete_button_toolBar)) {

			System.out.println(
					"Expected result is : The contract number should be deleted || Actual result is : Contract number is deleted");
			Extent_pass_New(driver,
					"Expected result is : The contract number should be deleted || Actual result is : Contract number is deleted",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The contract number should be deleted || Actual result is : Contract number is not deleted");
			Extent_fail(driver,
					"Expected result is : The contract number should be deleted || Actual result is : Contract number is not deleted",
					test, test1);
		}

		Step_End(14, "Ensure that contract number will not be deleted", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
