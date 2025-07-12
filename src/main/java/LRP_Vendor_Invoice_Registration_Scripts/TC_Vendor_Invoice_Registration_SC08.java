package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC08 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC08(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC08";
		//  Get data from excel sheet	
			
	        String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String agencyCode = Excel_data.get("AgencyCode");

	        String dropdownCondition = Excel_data.get("DropdownCondition");
			String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
			String vendorCode = Excel_data.get("VendorCode");
			String vendorInvoiceNumber = Excel_data.get("VendorInvoiceNumber");

			String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
			String cost_Attribute = Excel_data.get("Cost_Attribute");
			String value = Excel_data.get("Value");
			String default_Value = Excel_data.get("Default_Value");
			
			
			Extent_Start(testCaseName, test, test1);
			navigateUrl(driver, url);
			// Login
			
			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			
			SwitchProfile(driver, agencyCode);
			
			Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

//			Vendor Invoice Registration
			
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
			Step_Start(2, "Click the Vendor code search ", test, test1);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			Step_End(2, "Click the Vendor code search ", test, test1);

			Step_Start(3, "Select the required vendor", test, test1);
			Step_Start(4, "Click the Vendor invoice no", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			Step_End(3, "Select the required vendor", test, test1);
			Step_End(4, "Click the Vendor invoice no", test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			Extent_call(test, test1, "5.Type (Invoice/Advance) based on the VIA configuration in the Vendor Invoice configuration");
			
			Step_Start(5, " 5.2.While the Vale is \"N\" , It can't show the Type.", test, test1);

//			Cost Configuration
			
//		Set value as N
			
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
			
			
//			Vendor Invoice Registration
			
			moduleNavigate(driver, moduleName);
			
			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);
			
			waitForDisplay(driver, type_Buttons_VIR);
			if(!isdisplayed(driver, type_Buttons_VIR)) {
				System.out.println("Passed || Expected : Type buttons should not be displayed || Actual : Types buttons are not displayed");
				Extent_pass_New(driver, "Passed || Expected : Type buttons should not be displayed || Actual : Types buttons are not displayed", test, test1);
			}else {
				System.out.println("Failed || Expected : Type buttons should not be displayed || Actual : Types buttons are displayed");
				Extent_fail(driver, "Failed || Expected : Type buttons should not be displayed || Actual : Types buttons are displayed", test, test1);
			}
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			Step_End(5, " 5.2.While the Vale is \"N\" , It can't show the Type.", test, test1);

			Step_Start(5, "  5.1.WHile the Value is \"Y\" , It show the Type.", test, test1);

//			Cost Configuration
			
//		Set value as Y			
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
			mouseOverToElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
		
			Step_Start(6, "After the Configuration done ,Need to close and Open the Vendor Invoice registration", test, test1);

//			Vendor Invoice Registration
			
			moduleNavigate(driver, moduleName);
			
			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);
			
			waitForDisplay(driver, type_Buttons_VIR);
			if(isdisplayed(driver, type_Buttons_VIR)) {
				System.out.println("Passed || Expected : Type buttons should be displayed || Actual : Types buttons are displayed");
				Extent_pass_New(driver, "Passed || Expected : Type buttons should be displayed || Actual : Types buttons are displayed", test, test1);
			}else {
				System.out.println("Failed || Expected : Type buttons should be displayed || Actual : Types buttons are not displayed");
				Extent_fail(driver, "Failed || Expected : Type buttons should be displayed || Actual : Types buttons are not displayed", test, test1);
			}
			
			Step_End(5, "  5.1.WHile the Value is \"Y\" , It show the Type.", test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_End(6, "After the Configuration done ,Need to close and Open the Vendor Invoice registration", test, test1);

			Extent_completed(testCaseName, test, test1);
	}

}
