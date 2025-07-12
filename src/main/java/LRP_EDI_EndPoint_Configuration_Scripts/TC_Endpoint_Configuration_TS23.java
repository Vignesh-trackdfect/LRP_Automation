package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS23 extends Keywords {

	public void Endpoint_Configuration_TS23(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS23";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String WebService_TabName = Excel_data.get("WebService_TabName");
		String PartnerId_Header = Excel_data.get("PartnerId_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileID = Excel_data.get("ProfileID");
		String Attribute = Excel_data.get("Attribute");
		String Value = Excel_data.get("Value");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the Web service tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, WebService_TabName);

		Step_End(1, "Click the Web service tab", test, test1);

		Step_Start(2, "Enter the profile id", test, test1);

		waitForElement(driver, WS_PartnerID);
		click(driver, WS_PartnerID);

		twoColumnSearchWindow(driver, PartnerId_Header, Search_Condition, PartnerId);

		Step_End(2, "Enter the partner id ", test, test1);

		Step_Start(3, "Enter the partner id ", test, test1);

		waitForElement(driver, WS_ProfileID);
		sendKeys(driver, WS_ProfileID, ProfileID);

		Step_End(3, "Enter the profile id", test, test1);

		Step_Start(4, "Select the attribute", test, test1);

		waitForElement(driver, WS_Attribute);
		click(driver, WS_Attribute);

		String locator = String.format(DropDown_Select, Attribute);
		jsClick(driver, locator);

		Step_End(4, "Select the attribute", test, test1);

		Step_Start(5, "Enter the value ", test, test1);

		waitForElement(driver, WS_Value);
		sendKeys(driver, WS_Value, Value);
		
		Step_End(5, "Enter the value ", test, test1);
		
		Step_Start(6, "Click the add button now new record added to the AG grid", test, test1);

		waitForElement(driver, WS_Addallocation);
		click(driver, WS_Addallocation);

		waitForElement(driver, WS_ConditionFilter);
		click(driver, WS_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		waitForElement(driver, WS_ProfileID_Filter);
		sendKeys(driver, WS_ProfileID_Filter, ProfileID);

		waitForElement(driver, WS_Attribute_Filter);
		sendKeys(driver, WS_Attribute_Filter, Attribute);

		waitForElement(driver, WS_Value_Filter);
		sendKeys(driver, WS_Value_Filter, Value);

		if (isdisplayed(driver, WS_Row1)) {

			System.out.println("Expected result : The given Partner Id : " + PartnerId + " , Profile Id : " + ProfileID
					+ " , Attribute : " + Attribute + " and value : " + Value
					+ " should be added in the grid || Actual result : The given Partner Id : " + PartnerId
					+ " , Profile Id : " + ProfileID + " , Attribute : " + Attribute + " and value : " + Value
					+ " was added in the grid");
			Extent_pass_New(driver,
					"Expected result : The given Partner Id : " + PartnerId + " , Profile Id : " + ProfileID
							+ " , Attribute : " + Attribute + " and value : " + Value
							+ " should be added in the grid || Actual result : The given Partner Id : " + PartnerId
							+ " , Profile Id : " + ProfileID + " , Attribute : " + Attribute + " and value : " + Value
							+ " was added in the grid",
					test, test1);

		} else {

			System.out.println("Expected result : The given Partner Id : " + PartnerId + " , Profile Id : " + ProfileID
					+ " , Attribute : " + Attribute + " and value : " + Value
					+ " should be added in the grid || Actual result : The given Partner Id : " + PartnerId
					+ " , Profile Id : " + ProfileID + " , Attribute : " + Attribute + " and value : " + Value
					+ " was not added in the grid");
			Extent_fail(driver,
					"Expected result : The given Partner Id : " + PartnerId + " , Profile Id : " + ProfileID
							+ " , Attribute : " + Attribute + " and value : " + Value
							+ " should be added in the grid || Actual result : The given Partner Id : " + PartnerId
							+ " , Profile Id : " + ProfileID + " , Attribute : " + Attribute + " and value : " + Value
							+ " was not added in the grid",
					test, test1);

		}

		Step_End(6, "Click the add button now new record added to the AG grid", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
