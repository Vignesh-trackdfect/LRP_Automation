package LRP_Ecommerce_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import commonMethods.Keywords;



public class TC_Email_To_Customers_002 extends Keywords {
	public void Email_To_Customers_002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Email_To_Customers_002";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		waitForElement(driver, Search_Input);
		sendKeys(driver, Search_Input, Module_Name);
		waitForElement(driver, ETC_Module_Click);
		click(driver, ETC_Module_Click);
		Step_Start(1,
				" The Email to Customer module contains the following options *All Customers option,By Country option,By Customer option,By Email option,Subject field, Content box, and Send button",
				test, test1);

		waitForElement(driver, ETC_All_Customers_radioButton);
		if (isElementEnabled(driver, ETC_All_Customers_radioButton)) {
			System.out.println(
					"Expected : All Customer  radio button should be enabled || Actual : All Customer  radio button is enabled");
			Extent_pass_New(driver,
					"Expected : All Customer  radio button should be enabled || Actual : All Customer  radio button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Expected : All Customer  radio button should be enabled || Actual : All Customer  radio button is not enabled");
			Extent_fail(driver,
					"Expected : All Customer  radio button should be enabled || Actual : All Customer  radio button is not enabled",
					test, test1);
		}

		waitForElement(driver, ETC_By_Country_RadioButton);
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

		waitForElement(driver, ETc_By_Customer_RadioButton);
		if (isElementEnabled(driver, ETc_By_Customer_RadioButton)) {
			System.out.println(
					"Expected : By Customer  radio button Should be enabled || Actual : By Customer  radio button is enabled");
			Extent_pass_New(driver,
					"Expected : By Customer  radio button Should be enabled || Actual : By Customer  radio button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Expected : By Customer  radio button Should be enabled || Actual : By Customer  radio button is not enabled");
			Extent_fail(driver,
					"Expected : By Customer  radio button Should be enabled || Actual : By Customer  radio button is not enabled",
					test, test1);
		}

		waitForElement(driver, ETC_By_Mail_RadioButton);
		if (isElementEnabled(driver, ETC_By_Mail_RadioButton)) {
			System.out.println(
					"Expected : By Mail radio button should be enabled || Actual : By Mail radio button is enabled");
			Extent_pass_New(driver,
					"Expected : By Mail radio button should be enabled || Actual : By Mail radio button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Expected : By Mail radio button should be enabled || Actual : By Mail radio button is not enabled");
			Extent_fail(driver,
					"Expected : By Mail radio button should be enabled || Actual : By Mail radio button is not enabled",
					test, test1);
		}

		waitForElement(driver, ETC_subject_TextField);
		if (isClickable(driver, ETC_subject_TextField)) {
			System.out.println(
					"Expected : subject Textfield should be clickable || Actual : subject Textfield is clickable");
			Extent_pass_New(driver,
					"Expected : subject Textfield should be clickable || Actual : subject Textfield is clickable", test,
					test1);
		} else {
			System.out.println(
					"Expected : subject Textfield should be clickable || Actual : subject Textfield is not clickable");
			Extent_fail(driver,
					"Expected : subject Textfield should be clickable || Actual : subject Textfield is not clickable",
					test, test1);
		}

		waitForElement(driver, ETC_Send_Button);
		if (isClickable(driver, ETC_Send_Button)) {
			System.out.println("Expected : send button should be clickable || Actual : send button is clickable");
			Extent_pass_New(driver, "Expected : send button should be clickable || Actual : send button is clickable", test,
					test1);
		} else {
			System.out.println("Expected : send button should be clickable || Actual : send button is not clickable");
			Extent_fail(driver, "Expected : send button should be clickable || Actual : send button is not clickable",
					test, test1);
		}

		Step_End(1,
				" The Email to Customer module contains the following options *All Customers option,By Country option,By Customer option,By Email option,Subject field, Content box, and Send button",
				test, test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
