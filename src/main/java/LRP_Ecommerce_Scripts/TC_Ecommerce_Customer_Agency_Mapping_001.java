package LRP_Ecommerce_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import commonMethods.Keywords;



public class TC_Ecommerce_Customer_Agency_Mapping_001 extends Keywords {
	public void Customer_Agency_Mapping_001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Ecommerce_Customer_Agency_Mapping_001";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, "Line and Agency users can access the Ecom Customer Agency Mapping module", test, test1);
		SwitchProfile(driver, AgencyName);
		Step_End(1, "Line and Agency users can access the Ecom Customer Agency Mapping module", test, test1);

		Step_Start(2, "Enter \"Ecom Customer Agency Mapping\" in the Module Search to access the module", test, test1);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, Current_Module_Name);
		String Module_NameAct = getText(driver, Current_Module_Name);
		if (Module_Name.equals(Module_NameAct)) {
			System.out.println("Matched  || Expected value :" + Module_Name + "|| Actual value :" + Module_NameAct);
			Extent_pass_New(driver, "Matched  || Expected value :" + Module_Name + "|| Actual value :" + Module_NameAct,
					test, test1);
		} else {
			System.out.println("Not Matched  || Expected value :" + Module_Name + "|| Actual value :" + Module_NameAct);
			Extent_fail(driver, "Not Matched  || Expected value :" + Module_Name + "|| Actual value :" + Module_NameAct,
					test, test1);
		}

		Step_End(2, "Enter \"Ecom Customer Agency Mapping\" in the Module Search to access the module", test, test1);

		if (isElementEnabled(driver, customer_Code_Search_Button_CAM)) {
			System.out.println(
					"Expected : Customer code search button Should be enabled || Actual : Customer code search button is enabled");
			Extent_pass_New(driver,
					"Expected : Customer code search button Should be enabled || Actual : Customer code search button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Expected : Customer code search button Should be enabled || Actual : Customer code search button is not enabled");
			Extent_fail(driver,
					"Expected : Customer code search button Should be enabled || Actual : Customer code search button is not enabled",
					test, test1);
		}

		if (isElementEnabled(driver, Agency_Code_Search_button_CAM)) {
			System.out.println(
					"Expected : Agency Code Search button Should be Enabled || Actual : Agency code search button is enabled");
			Extent_pass_New(driver,
					"Expected : Agency Code Search button Should be Enabled || Actual : Agency code search button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Expected : Agency Code Search button Should be Enabled || Actual : Agency code search button is not enabled");
			Extent_fail(driver,
					"Expected : Agency Code Search button Should be Enabled || Actual : Agency code search button is not enabled",
					test, test1);
		}

		Extent_completed(testcase_Name, test, test1);

	}

}
