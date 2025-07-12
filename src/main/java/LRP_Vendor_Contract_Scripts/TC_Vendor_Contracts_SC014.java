package LRP_Vendor_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Contracts_SC014 extends Keywords {

	public void Vendor_Contracts_SC014(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Contracts_SC014";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Global_Search_Option = Excel_data.get("Global_Search_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String From_Date = Excel_data.get("From_Date");
		String To_Date = Excel_data.get("To_Date");
		String Renegotiate_popup = Excel_data.get("Renegotiate_popup");
		String Confirmation_popup = Excel_data.get("Confirmation_popup");

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

		Step_Start(10, "Change the valid to details by extending the validity", test, test1);
		
		
		String Existing_Fromdate = getAttribute(driver, valid_from_date_Vc, "value");
		
		String Existing_Todate = getAttribute(driver, VC_ToDate, "value");

		waitForElement(driver, valid_from_date_Vc);
		selectDatePicker(driver, valid_from_date_Vc, From_Date);
		
		selectDatePicker(driver, VC_ToDate, To_Date);

		Step_End(10, "Change the valid to details by extending the validity", test, test1);

		Step_Start(11, "Click on Save option in the toolbar", test, test1);

		waitForElement(driver, SaveAs_button_toolBar);
		click(driver, SaveAs_button_toolBar);

		Step_End(11, "Click on Save option in the toolbar", test, test1);

		Step_Start(12, ".Check whether the system populates the confirmation message as Do you want to renegotiate?",
				test, test1);

		waitForPopup(driver, popup_Message, Renegotiate_popup);

		String Actual_negotiate = getText(driver, popup_Message);

		if (Actual_negotiate.equals(Renegotiate_popup)) {

			System.out.println(
					"Matched || Expected popup : " + Renegotiate_popup + " || Actual popup : " + Actual_negotiate);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + Renegotiate_popup + " || Actual popup : " + Actual_negotiate, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup : " + Renegotiate_popup + " || Actual popup : " + Actual_negotiate);
			Extent_fail(driver,
					"Not Matched || Expected popup : " + Renegotiate_popup + " || Actual popup : " + Actual_negotiate,
					test, test1);

		}

		Step_End(12, ".Check whether the system populates the confirmation message as Do you want to renegotiate?",
				test, test1);

		Step_Start(13, "Click on 'No' for the validation message", test, test1);

		waitForElement(driver, popup_Message_No_Button);
		click(driver, popup_Message_No_Button);

		Step_End(13, "Click on 'No' for the validation message", test, test1);

		Step_Start(15, "The system validates if the contract already exists and click ok option", test, test1);

		Step_Start(16, "The system gets updated when the contract is not present for the extended validity", test,
				test1);
		
		waitForPopup(driver, popup_Message, Confirmation_popup);

		String Actual_Updated = getText(driver, popup_Message);
		
		String convertedfromdate = Datetimeformatter(Existing_Fromdate);
		String convertedtodate = Datetimeformatter(Existing_Todate);
		
		String Expected_popup = Contract_Number +" "+convertedfromdate+" "+convertedtodate+" "+Confirmation_popup;
		

		if (Expected_popup.equals(Actual_Updated)) {

			System.out.println("Matched || Expected popup message was : " + Expected_popup
					+ " || Actual popup message was : " + Actual_Updated);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Expected_popup
					+ " || Actual popup message was : " + Actual_Updated, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup message was : " + Expected_popup
					+ " || Actual popup message was : " + Actual_Updated);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Expected_popup
					+ " || Actual popup message was : " + Actual_Updated, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(15, "The system validates if the contract already exists and click ok option", test, test1);

		Step_End(16, "The system gets updated when the contract is not present for the extended validity", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
