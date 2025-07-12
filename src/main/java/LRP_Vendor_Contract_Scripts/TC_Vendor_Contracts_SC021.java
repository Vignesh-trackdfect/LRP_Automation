package LRP_Vendor_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Contracts_SC021 extends Keywords {

	public void Vendor_Contracts_SC021(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Vendor_Contracts_SC021";

		
		
		




		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Global_Search_Option = Excel_data.get("Global_Search_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Mapped_Contract = Excel_data.get("Mapped_Contract");

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

		Step_Start(9, "Click the mapped ports tab", test, test1);

		waitForElement(driver, VC_Mapped_Contracts);
		click(driver, VC_Mapped_Contracts);

		Step_End(9, "Click the mapped ports tab", test, test1);

		Step_Start(10, "Double click that mapping number", test, test1);

		formatLocatorDoubleClick(driver, VC_MappedContracts_select, Mapped_Contract);

		Step_End(10, "Double click that mapping number", test, test1);

		Step_Start(11, "System will move to the contract mapping module with that contract mapping number", test,
				test1);

		waitForDisplay(driver, CM_VendorCode);

		if (isdisplayed(driver, CM_VendorCode)) {

			System.out.println(
					"Expected result is : After double click the Mapped contract, system should move to Contract Mapping module || Actual result is : After double click the Mapped contract, system is moved to Contract Mapping module");
			Extent_pass_New(driver,
					"Expected result is : After double click the Mapped contract, system should move to Contract Mapping module || Actual result is : After double click the Mapped contract, system is moved to Contract Mapping module  ",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : After double click the Mapped contract, system should move to Contract Mapping module || Actual result is : After double click the Mapped contract, system is not moved to Contract Mapping module");
			Extent_fail(driver,
					"Expected result is : After double click the Mapped contract, system should move to Contract Mapping module || Actual result is : After double click the Mapped contract, system is not moved to Contract Mapping module  ",
					test, test1);

		}

		String displayed_Contract_number = getAttribute(driver, CM_ContractNo, "value");

		if (displayed_Contract_number.equals(Contract_Number)) {

			System.out.println("Selected serivice tax details are showing || Expected Mapped contract : "
					+ Contract_Number + " || actual Mapped contract : " + displayed_Contract_number);
			Extent_pass_New(driver, "Selected serivice tax details are showing || Expected Mapped contract : "
					+ Contract_Number + " || actual Mapped contract : " + displayed_Contract_number, test, test1);

		} else {
			System.out.println("Selected serivice tax details are not showing || Expected Mapped contract : "
					+ Contract_Number + " || actual Mapped contract : " + displayed_Contract_number);
			Extent_fail(
					driver, "Selected serivice tax details are not showing || Expected Mapped contract : "
							+ Contract_Number + " || actual Mapped contract : " + displayed_Contract_number,
					test, test1);

		}

		Step_End(11, "System will move to the contract mapping module with that contract mapping number", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
