package LRP_EMS_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Ems_Contract_Registration_Locators;

public class EMS_Contract_Registration_IP004 extends Keywords {

	public void emscontractregistrationip004(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String tc_Name="EMS_Contract_Registration_IP004";

		
		
		
		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_input = Excel_data.get("Search_input");
		String Contractno4 = Excel_data.get("contract_no4");
		String ContractType4 = Excel_data.get("ContractType4");
		String leasekind = Excel_data.get("leasekind");
		String lessor_code = Excel_data.get("lessor_code");
		String Condition = Excel_data.get("Condition");

		String lease_code_header = Excel_data.get("lease_code_header");
		String lessor_code_header = Excel_data.get("lessor_code_header");
		
		 String contype_opt =String.format(Ems_Contract_Registration_Locators.contype_opt, ContractType4);


		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

		moduleNavigate(driver, Search_input);

		Step_End(1, "Enter module name in searchbox & click the module", test, test1);
		
		Step_Start(2, "  Ensure system should allow user to enter contract no & contract type", test, test1);
		waitForElement(driver, Econtractno_field);
		sendKeys(driver, Econtractno_field, Contractno4);
		Step_End(2, "  Ensure system should allow user to enter contract no & contract type", test, test1);

		
		Step_Start(3, "Ensure that system should enable size/type field only if lessor code is selected from the list", test, test1);
		waitForElement(driver, Econtracttype_field);
		click(driver, Econtracttype_field);
		
		waitForDisplay(driver, contract_types);
		if (!isDisplayed(driver, contract_types)) {
			waitForElement(driver, Econtracttype_field);
			click(driver, Econtracttype_field);
		}
			
			waitForElement(driver, contype_opt);
			click(driver, contype_opt);
			
		waitForElement(driver, Eleasekind_searchicon);
		click(driver, Eleasekind_searchicon);
		twoColumnSearchWindow(driver, lease_code_header, Condition, leasekind);

		waitForElement(driver, Elessorcode_searchicon);
		click(driver, Elessorcode_searchicon);
		twoColumnSearchWindow(driver, lessor_code_header, Condition, lessor_code);
		
		Extent_call(test, test1, "Ensure that system should enable size/type field only if lessor code is selected from the list");
	 	
		waitForElement(driver, Esizeandtype_tab);
		if (IsElementEnabled(driver, Esizeandtype_tab)) {
			System.out.println("Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is enabled ");
			Extent_pass_New(driver, "Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is enabled ", test, test1);
		} else {
			System.out.println("Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is not enabled ");
			Extent_fail(driver, "Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is not enabled ", test, test1);
		}
		
		Step_End(3, "Ensure that system should enable size/type field only if lessor code is selected from the list", test, test1);

		Extent_completed(tc_Name, test, test1);
	}
}
