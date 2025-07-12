package LRP_Vendor_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Contracts_SC019 extends Keywords {

	public void Vendor_Contracts_SC019(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Vendor_Contracts_SC019";

		
		
		




		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Global_Search_Option = Excel_data.get("Global_Search_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Rejected_popup = Excel_data.get("Rejected_popup");
		String Expected_Status = Excel_data.get("Expected_Status");
		String Expected_Mapped_Popup = Excel_data.get("Expected_Mapped_Popup");

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

		Step_Start(9, "Click on Reject option when contract mapping is not done", test, test1);

		waitForElement(driver, VC_Mapped_Contracts);
		click(driver, VC_Mapped_Contracts);

		if (ChecklistOfElements(driver, VC_Mapped_Contracts_List) == false) {

			System.out.println("Contract mapping is not done");
			Extent_cal(test, test1, "Contract mapping is not done");

			waitForElement(driver, VC_Reject);
			click(driver, VC_Reject);

			Step_End(9, "Click on Reject option when contract mapping is not done", test, test1);

			Step_Start(10, "System validates as contracts rejected", test, test1);

			waitForPopup(driver, popup_Message, Rejected_popup);

			String Actual_rejected_popup = getText(driver, popup_Message);

			if (Actual_rejected_popup.equals(Rejected_popup)) {

				System.out.println("Matched || Expected rejected popup : " + Rejected_popup
						+ " || Actual rejected popup : " + Actual_rejected_popup);
				Extent_pass_New(driver, "Matched || Expected rejected popup : " + Rejected_popup
						+ " || Actual rejected popup : " + Actual_rejected_popup, test, test1);
			} else {

				System.out.println("Not Matched || Expected rejected popup : " + Rejected_popup
						+ " || Actual rejected popup : " + Actual_rejected_popup);
				Extent_fail(driver, "Not Matched || Expected rejected popup : " + Rejected_popup
						+ " || Actual rejected popup : " + Actual_rejected_popup, test, test1);

			}

			Step_End(10, "System validates as contracts rejected", test, test1);

			Step_Start(11, "Click on 'ok' option", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(11, "Click on 'ok' option", test, test1);

			Step_Start(12, "Ensure that system has changed the status as reject", test, test1);

			waitForElement(driver, VC_Contract_Status);

			String changed_status = getText(driver, VC_Contract_Status);

			if (Expected_Status.equals(changed_status)) {

				System.out.println("Matched || Expected status was : " + Expected_Status + " || Actual status was : "
						+ changed_status);
				Extent_pass_New(driver, "Matched || Expected status was : " + Expected_Status + " || Actual status was : "
						+ changed_status, test, test1);

			} else {

				System.out.println("Not Matched || Expected status was : " + Expected_Status
						+ " || Actual status was : " + changed_status);
				Extent_fail(driver, "Not Matched || Expected status was : " + Expected_Status
						+ " || Actual status was : " + changed_status, test, test1);

			}

			Step_End(12, "Ensure that system has changed the status as reject", test, test1);

		} else {

			Step_Start(13, "Click on Reject option when contract mapping is done", test, test1);

			waitForElement(driver, VC_Mapped_Contracts);
			click(driver, VC_Mapped_Contracts);

			waitForElement(driver, VC_Reject);
			click(driver, VC_Reject);

			Step_End(13, "Click on Reject option when contract mapping is done", test, test1);

			Step_Start(14, "The system validates as 'Contract mapping is created,You cannot reject this contract'",
					test, test1);

			waitForPopup(driver, popup_Message, Rejected_popup);

			String Actual_rejected_popup2 = getText(driver, popup_Message);

			if (Actual_rejected_popup2.equals(Expected_Mapped_Popup)) {

				System.out.println("Matched || Expected rejected popup : " + Expected_Mapped_Popup
						+ " || Actual rejected popup : " + Actual_rejected_popup2);
				Extent_pass_New(driver, "Matched || Expected rejected popup : " + Expected_Mapped_Popup
						+ " || Actual rejected popup : " + Actual_rejected_popup2, test, test1);
			} else {

				System.out.println("Not Matched || Expected rejected popup : " + Expected_Mapped_Popup
						+ " || Actual rejected popup : " + Actual_rejected_popup2);
				Extent_fail(driver, "Not Matched || Expected rejected popup : " + Expected_Mapped_Popup
						+ " || Actual rejected popup : " + Actual_rejected_popup2, test, test1);

			}

			Step_End(14, "The system validates as 'Contract mapping is created,You cannot reject this contract'", test,
					test1);

			Step_Start(15, " Click on ok option", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(15, " Click on ok option", test, test1);

		}

		Extent_completed(testCaseName, test, test1);
	}

}
