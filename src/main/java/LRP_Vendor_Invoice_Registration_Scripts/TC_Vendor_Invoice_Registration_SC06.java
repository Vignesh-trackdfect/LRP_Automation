package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC06  extends Keywords {

	public void Vendor_Invoice_Registration_SC06(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testcase_Name = "TC_Vendor_Invoice_Registration_SC06";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyCode = Excel_data.get("AgencyCode");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String vendorCode = Excel_data.get("VendorCode");
		String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
		String cost_Attribute = Excel_data.get("Cost_Attribute");
		String value = Excel_data.get("Value");
		String default_Value = Excel_data.get("Default_Value");
		String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, agencyCode);


		//		Cost Configuration

		//	Set value as N
		Step_Start(1, "While the PYM, Value is \"Y\" Payment method will show and we can able to select in Vendor master", test, test1);
		moduleNavigate(driver, costConfiguration_Module);

		waitForElement(driver, cost_Attribute_Filter_CSO);
		sendKeys(driver, cost_Attribute_Filter_CSO, cost_Attribute);

		waitForElement(driver, retrieved_Attribute_Value_CSO);
		doubleClick(driver, retrieved_Attribute_Value_CSO);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, value_Textfield_CSO);
		clearAndType(driver, value_Textfield_CSO, default_Value);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(1, "While the PYM, Value is \"Y\" Payment method will show and we can able to select in Vendor master", test, test1);


		Step_Start(2, "Enter the screen name as a \"Vendor Master\" in the Search", test, test1);
		moduleNavigate(driver, Vendor_Master_Module);
		Step_End(2, "Enter the screen name as a \"Vendor Master\" in the Search", test, test1);


		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		Step_Start(3, "Based on the Vendor, Payment Method auto fetch from the Vendor master(Payment Methods)", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

		waitForElement(driver, payment_Methods_Field_VM);
		if(isdisplayed(driver, payment_Methods_Field_VM)) {
			System.out.println("Expected Result is : Payment method field should be displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is  displayed after changing cost configuration attribute as 'Y' ");
			Extent_pass_New(driver, "Expected Result is : Payment method field should be displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is  displayed after changing cost configuration attribute as 'Y' ", test, test1);
		}else {
			System.out.println("Expected Result is : Payment method field should be displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is not  displayed after changing cost configuration attribute as 'Y' ");
			Extent_fail(driver, "Expected Result is : Payment method field should be displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is  not displayed after changing cost configuration attribute as 'Y' ", test, test1);
		}
		Step_End(3, "Based on the Vendor, Payment Method auto fetch from the Vendor master(Payment Methods)", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);


		Step_Start(1, "While the PYM, Value is \"N\" Payment method will show and we can able to select in Vendor master", test, test1);

		moduleNavigate(driver, costConfiguration_Module);

		waitForElement(driver, cost_Attribute_Filter_CSO);
		sendKeys(driver, cost_Attribute_Filter_CSO, cost_Attribute);

		waitForElement(driver, retrieved_Attribute_Value_CSO);
		doubleClick(driver, retrieved_Attribute_Value_CSO);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, value_Textfield_CSO);
		clearAndType(driver, value_Textfield_CSO, value);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(1, "While the PYM, Value is \"N\" Payment method will show and we can able to select in Vendor master", test, test1);


		moduleNavigate(driver, Vendor_Master_Module);

		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_Start(4, "Based on the Vendor, Payment Method auto fetch from the Vendor master(Payment Methods)", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

		waitForDisplay(driver, payment_Methods_Field_VM);
		if(!isdisplayed(driver, payment_Methods_Field_VM)) {
			System.out.println("Expected Result is : Payment method field should not  displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is  not displayed after changing cost configuration attribute as 'Y' ");
			Extent_pass_New(driver, "Expected Result is : Payment method field should not  displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is  not displayed after changing cost configuration attribute as 'Y' ", test, test1);
		}else {
			System.out.println("Expected Result is : Payment method field should be displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is   displayed after changing cost configuration attribute as 'Y' ");
			Extent_fail(driver, "Expected Result is : Payment method field should be displayed after changing cost configuration attribute as 'Y'  || Actual Result is : Payment method field is  displayed after changing cost configuration attribute as 'Y' ", test, test1);
		}

		Step_End(4, "Based on the Vendor, Payment Method auto fetch from the Vendor master(Payment Methods)", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Extent_completed(testcase_Name, test, test1);


	}
}
