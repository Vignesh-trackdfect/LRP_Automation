package LRP_Vendor_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Contracts_SC008 extends Keywords{

	public void Vendor_Contracts_SC008(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Vendor_Contracts_SC008";
		// Get data from excel sheet
		
		
		



		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_User = Excel_data.get("Agency_User");
		String Vendor_Contract_Module = Excel_data.get("Vendor_Contract_Module");

		String Global_Search_Type1_VC = Excel_data.get("Global_Search_Type1_VC");
		String Global_Search_Condition_VC = Excel_data.get("Global_Search_Condition_VC");
		String Global_Search_Value1_VC = Excel_data.get("Global_Search_Value1_VC");
		String Global_Search_Type2_VC = Excel_data.get("Global_Search_Type2_VC");
		String Global_Search_Value2_VC = Excel_data.get("Global_Search_Value2_VC");
		String Global_Search_Type3_VC = Excel_data.get("Global_Search_Type3_VC");
		String Global_Search_Value3_VC = Excel_data.get("Global_Search_Value3_VC");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		
		// Login
		LRP_Login(driver, username, password);
		SwitchProfile(driver, Agency_User);
		//	Vendor Contract
		Step_Start(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);
		moduleNavigate(driver, Vendor_Contract_Module);
		Step_End(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar. ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(2, "Click on the global search option which is available in the tool bar. ", test, test1);

		
		Step_Start(3, "Check whether the system opens the contract details search window. ", test, test1);
		waitForDisplay(driver, type_Select1);
		if(isDisplayed(driver, type_Select1)) {
			System.out.println("Expected : system should opens the contract details search window after click the global search button||  Actual : system opens the contract details search window after click the global search button");
			Extent_pass_New(driver, "Expected : system should opens the contract details search window after click the global search button||  Actual : system opens the contract details search window after click the global search button", test, test1);
		}else {
			System.out.println("Expected : system should opens the contract details search window after click the global search button||  Actual : system not opens the contract details search window after click the global search button");
			Extent_fail(driver, "Expected : system should opens the contract details search window after click the global search button||  Actual : system not opens the contract details search window after click the global search button", test, test1);
		}
		
		Step_End(3, "Check whether the system opens the contract details search window. ", test, test1);

		
		Step_Start(4, "Enter the saved contract number in the contract number search field", test, test1);
		Step_Start(5, "Click on the search button. ", test, test1);
		Step_Start(6, "System will show the contract number", test, test1);
		Step_Start(7, "Click on the select button.", test, test1);

		globalValueSearchWindow(driver, Global_Search_Condition_VC, Global_Search_Type1_VC, Global_Search_Value1_VC, Global_Search_Type2_VC, Global_Search_Value2_VC, Global_Search_Type3_VC, Global_Search_Value3_VC);
		
		Step_End(7, "Click on the select button.", test, test1);
		Step_End(6, "System will show the contract number", test, test1);
		Step_End(5, "Click on the search button. ", test, test1);
		Step_End(4, "Enter the saved contract number in the contract number search field", test, test1);

		Step_Start(8, "Check whether the system retrieves the saved contract number.", test, test1);
		waitForElement(driver, contract_No_VC);
		String Act_VendorContractNum=getAttribute(driver, contract_No_VC, "value");
		if(Global_Search_Value1_VC.equals(Act_VendorContractNum)) {
			System.out.println("Expected : System Should retrieves the saved contract number, exp num : "+Global_Search_Value1_VC+"  || Actaul : system retrieves the saved contract number, Act num : "+Act_VendorContractNum);
			Extent_pass_New(driver, "Expected : System Should retrieves the saved contract number, exp num : "+Global_Search_Value1_VC+"  || Actaul : system retrieves the saved contract number, Act num : "+Act_VendorContractNum, test, test1);
		}else {
			System.out.println("Expected : System Should retrieves the saved contract number, exp num : "+Global_Search_Value1_VC+"  || Actaul : system not retrieves the saved contract number, Act num : "+Act_VendorContractNum);
			Extent_fail(driver, "Expected : System Should retrieves the saved contract number, exp num : "+Global_Search_Value1_VC+"  || Actaul : system not retrieves the saved contract number, Act num : "+Act_VendorContractNum, test, test1);
		}
		Step_End(8, "Check whether the system retrieves the saved contract number.", test, test1);

		Extent_completed(testCaseName, test, test1);
		
	}
}
