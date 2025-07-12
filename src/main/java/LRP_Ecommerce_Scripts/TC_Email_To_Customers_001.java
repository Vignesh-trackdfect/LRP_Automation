package LRP_Ecommerce_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import commonMethods.Keywords;



public class TC_Email_To_Customers_001 extends Keywords {
	public void Email_To_Customers_001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Email_To_Customers_001";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, " Line and Agency users can access the Email to Customer module", test, test1);

		SwitchProfile(driver, AgencyName);
		Step_End(1, " Line and Agency users can access the Email to Customer module", test, test1);

		waitForElement(driver, Search_Input);
		sendKeys(driver, Search_Input, Module_Name);
		waitForElement(driver, ETC_Module_Click);
		click(driver, ETC_Module_Click);

		Step_Start(2, "Enter \"Email to Customer\" in the Module Search to access the module", test, test1);
		waitForElement(driver, ETC_Module_title);
		String Module_NameAct = getText(driver, ETC_Module_title);
		if (Module_Name.equals(Module_NameAct)) {
			System.out.println("Matched  || Expected module name was :" + Module_Name + "|| Actual module name was :"
					+ Module_NameAct);
			Extent_pass_New(driver, "Matched  || Expected module name was :" + Module_Name + "|| Actual module name was :"
					+ Module_NameAct, test, test1);
		} else {
			System.out.println("Not Matched  || Expected module name was :" + Module_Name
					+ "|| Actual module name was :" + Module_NameAct);
			Extent_fail(driver, "Not Matched  || Expected module name was :" + Module_Name
					+ "|| Actual module name was :" + Module_NameAct, test, test1);
		}
	
		Step_End(2, "Enter Email to Customer in the Module Search to access the module", test, test1);

		if (isElementEnabled(driver, ETC_All_Customers_radioButton)) {
			System.out.println(
					"Expected : Customer code radio button should be enabled || Actual : Customer code radio button is enabled");
			Extent_pass_New(driver,
					"Expected : Customer code radio button should be enabled || Actual : Customer code radio button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Expected : Customer code radio button should be enabled || Actual : Customer code radio button is not enabled");
			Extent_fail(driver,
					"Expected : Customer code radio button should be enabled || Actual : Customer code radio button is not enabled",
					test, test1);
		}

		if (isElementEnabled(driver, ETC_By_Country_RadioButton)) {
			System.out.println(
					"Expected : By country radio button should be enabled || Actual : By country radio button is enabled");
			Extent_pass_New(driver,
					"Expected : By country radio button should be enabled || Actual : By country radio button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Expected : By country radio button should be enabled || Actual : By country radio button is not enabled");
			Extent_fail(driver,
					"Expected : By country radio button should be enabled || Actual : By country radio button is not enabled",
					test, test1);
		}
		
		Extent_completed(testcase_Name, test, test1);

	}

}
