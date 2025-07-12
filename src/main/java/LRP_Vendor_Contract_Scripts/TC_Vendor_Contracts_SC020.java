package LRP_Vendor_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Contracts_SC020 extends Keywords {

	public void Vendor_Contracts_SC020(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Vendor_Contracts_SC020";

		
		
		




		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Global_Search_Option = Excel_data.get("Global_Search_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Service_Tax = Excel_data.get("Service_Tax");

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

		Step_Start(9, "Click the service tax tab", test, test1);

		waitForElement(driver, VC_ServiceTax);
		click(driver, VC_ServiceTax);

		Step_End(9, "Click the service tax tab", test, test1);

		Step_Start(10, "Double click that service number", test, test1);

		formatLocatorDoubleClick(driver, VC_ServiceTax_select, Service_Tax);

		Step_End(10, "Double click that service number", test, test1);

		Step_Start(11, "System will move to the service tax module with that service tax number", test, test1);

		waitForDisplay(driver, VC_ServiceTax_Input);

		if (isdisplayed(driver, VC_ServiceTax_Input)) {

			System.out.println(
					"Expected result is : After double click the service tax, system should move to serive tax module || Actual result is : After double click the service tax, system is moved to serive tax module");
			Extent_pass_New(driver,
					"Expected result is : After double click the service tax, system should move to serive tax module || Actual result is : After double click the service tax, system is moved to serive tax module  ",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : After double click the service tax, system should move to serive tax module || Actual result is : After double click the service tax, system is not moved to serive tax module");
			Extent_fail(driver,
					"Expected result is : After double click the service tax, system should move to serive tax module || Actual result is : After double click the service tax, system is not moved to serive tax module  ",
					test, test1);

		}

		String displayed_ServiceTax = getAttribute(driver, VC_ServiceTax_Input, "value");

		if (displayed_ServiceTax.equals(Service_Tax)) {

			System.out.println("Selected serivice tax details are showing || Expected service tax : " + Service_Tax
					+ " || actual service tax : " + displayed_ServiceTax);
			Extent_pass_New(driver, "Selected serivice tax details are showing || Expected service tax : " + Service_Tax
					+ " || actual service tax : " + displayed_ServiceTax, test, test1);

		} else {
			System.out.println("Selected serivice tax details are not showing || Expected service tax : " + Service_Tax
					+ " || actual service tax : " + displayed_ServiceTax);
			Extent_fail(driver, "Selected serivice tax details are not showing || Expected service tax : " + Service_Tax
					+ " || actual service tax : " + displayed_ServiceTax, test, test1);

		}

		Step_End(11, "System will move to the service tax module with that service tax number", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
