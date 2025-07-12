package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC029 extends Keywords {

	public void Import_Invoice_SC029(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name = "TC_Import_Invoice_SC029";
		
		

	
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Field_Names = Excel_data.get("Field_Names");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String Attribute_value = Excel_data.get("Attribute_value");
		String Value_checkbox_perform = Excel_data.get("Value_checkbox_perform");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String attribute_Header = Excel_data.get("attribute_Header");
		String AC_ChargeCode_Values = Excel_data.get("AC_ChargeCode_Values");
		String ChargesColumn_Header = Excel_data.get("ChargesColumn_Header");
		String UD_ConfigAttribute = Excel_data.get("UD_ConfigAttribute");
		String resetOption = Excel_data.get("resetOption");


	
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
 
		verifyMainMenu(driver);

		Step_Start(1, "Switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);
 
		Step_End(1, "Switch to import agency", test, test1);
		Map<String, String> newlyadded = setAccountingConfiguration(driver, AgencyConfigurationModule, AgencyCode_Header,attribute_Header,Search_Condition,AgencyUser,Attribute_value,UD_ConfigAttribute,ChargesColumn_Header,AC_ChargeCode_Values,Value_checkbox_perform);



		Step_Start(16, "open the import invoice", test, test1);

		moduleNavigate(driver, Field_Names);

		waitForDisplay(driver, NewButton_ToolBar);
		if(isdisplayed(driver, NewButton_ToolBar)) {
			System.out.println("Expected Result is : New button should be enabled || Actual Result is : New Button is Enabled");
			Extent_pass_New(driver, "Expected Result is : New button should be enabled || Actual Result is : New Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result is : New button should be enabled || Actual Result is : New Button is not Enabled");
			Extent_FailNew(driver, "Expected Result is : New button should be enabled || Actual Result is : New Button is not Enabled", test, test1);
		}

		Step_End(16, "open the import invoice", test, test1);

		Step_Start(17, "Receipt button should be displayed in Import invoice", test, test1);

		waitForDisplay(driver, II_receipt_button);
		if (isdisplayed(driver, II_receipt_button)) {
			System.out.println(
					"Matched || Expected result is : Receipt button  available in Import invoice || Actual result is : Receipt button  available in Import invoice");
			Extent_pass_New(driver,
					"Matched || Expected result is : Receipt button  available in Import invoice || Actual result is : Receipt button  available in Import invoice",
					test, test1);
		} else {

			System.out.println(
					"Not Matched || Expected result is : Receipt button  available in Import invoice || Actual result is : Receipt button not available in Import invoice");
			Extent_fail(driver,
					"Not Matched || Expected result is : Receipt button  available in Import invoice || Actual result is : Receipt button not available in Import invoice",
					test, test1);
		}

		Step_End(17, "Receipt button should be displayed in Import invoice", test, test1);

		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Extent_call(test, test1, "Need to replace the Configuration as per the existing level.");
		reSetAccountingConfiguration(driver, resetOption, newlyadded, AgencyConfigurationModule, AgencyCode_Header, Search_Condition, AgencyUser, Attribute_value, UD_ConfigAttribute);

		Extent_completed(testcase_Name, test, test1);

	}

}
