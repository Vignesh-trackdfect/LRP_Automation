package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC07 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC07(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC07";
		//  Get data from excel sheet	
			
	        String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String agencyCode = Excel_data.get("AgencyCode");

	        String dropdownCondition = Excel_data.get("DropdownCondition");
			String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
			String vendorCode = Excel_data.get("VendorCode");

			String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
			String cost_Attribute = Excel_data.get("Cost_Attribute");
			String Value_No = Excel_data.get("Value_No");
			String Value_Yes = Excel_data.get("Value_Yes");
			
			String activityType = Excel_data.get("ActivityType");

			Extent_Start(testCaseName, test, test1);

			navigateUrl(driver, url);
			// Login
			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			SwitchProfile(driver, agencyCode);
			
			//cost configuration
			Step_Start(1, "Open the Cost Configuration Module and set the Attribute 'MIO'  Value as 'N' ", test, test1);

			moduleNavigate(driver, costConfiguration_Module);
			SetCostConfiguration(driver, cost_Attribute, Value_No);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(1, "Open the Cost Configuration Module and set the Attribute 'MIO'  Value as 'N' ", test, test1);

			Step_Start(2, "Open the Vendor Invoice Registration Module And search the vendor code  ", test, test1);
			//Vendor Invoice Registration
			moduleNavigate(driver, moduleName);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);

			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
			Step_End(2, "Open the Vendor Invoice Registration Module And search the vendor code  ", test, test1);

			
			Step_Start(3, "Click the Activity type drop down and Select the Activity Type.", test, test1);
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);
			
			String select_ActivityType=String.format(DropDown_Select, activityType);
			waitForElement(driver, select_ActivityType);
			click(driver, select_ActivityType);
			Step_End(3, "Click the Activity type drop down and Select the Activity Type.", test, test1);

			Step_Start(4, "Check the Manual Activity button should be disabled When the 'MIO' is 'N' in the Cost Configuration Module  ", test, test1);
			waitForElement(driver, Manual_Activity_VIR);
			System.out.println("IsElementEnabled(driver, Manual_Activity_VIR) : "+IsElementEnabled(driver, Manual_Activity_VIR) );
			String ManualActivity=getAttribute(driver, Manual_Activity_VIR, "class");
			
			if(ManualActivity.contains("disabled")||ManualActivity.contains("Disabled")) {
				System.out.println("Matched || Expected : Manual Activity button should be disabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration || Actual : Manual Activity button is disabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration ");
				Extent_pass(driver, "Matched || Expected : Manual Activity button should be disabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration || Actual : Manual Activity button is disabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration ", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Manual Activity button should be disabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration || Actual : Manual Activity button is enabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration ");
				Extent_fail(driver, "Not Matched || Expected : Manual Activity button should be disabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration || Actual : Manual Activity button is enabled When the '"+cost_Attribute+"' is '"+Value_No+"' in the Cost Configuration ", test, test1);
			}
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_End(4, "Check the Manual Activity button should be disabled When the 'MIO' is 'N' in the Cost Configuration Module  ", test, test1);

			Step_Start(5, "Open the Cost Configuration Module and set the Attribute 'MIO'  Value as 'Y' ", test, test1);

			moduleNavigate(driver, costConfiguration_Module);
			SetCostConfiguration(driver, cost_Attribute, Value_Yes);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(5, "Open the Cost Configuration Module and set the Attribute 'MIO'  Value as 'Y' ", test, test1);

			Step_Start(6, "Open the Vendor Invoice Registration Module And search the vendor code  ", test, test1);

			//Vendor Invoice Registration
			moduleNavigate(driver, moduleName);
			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
			Step_End(6, "Open the Vendor Invoice Registration Module And search the vendor code  ", test, test1);

			Step_Start(7, "Check the Manual Activity button should be Enabled When the 'MIO' is 'Y' in the Cost Configuration Module  ", test, test1);

			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);
			
			waitForElement(driver, select_ActivityType);
			click(driver, select_ActivityType);
			
			waitForElement(driver, Manual_Activity_VIR);
			ManualActivity=getAttribute(driver, Manual_Activity_VIR, "class");
			if(!ManualActivity.contains("disabled")) {
				System.out.println("Matched || Expected : Manual Activity button should be Enabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration || Actual : Manual Activity button is enabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration ");
				Extent_pass(driver, "Matched || Expected : Manual Activity button should be Enabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration || Actual : Manual Activity button is enabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration ", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Manual Activity button should be Enabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration || Actual : Manual Activity button is disabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration ");
				Extent_fail(driver, "Not Matched || Expected : Manual Activity button should be Enabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration || Actual : Manual Activity button is disabled When the '"+cost_Attribute+"' is '"+Value_Yes+"' in the Cost Configuration ", test, test1);
			}
			Step_End(7, "Check the Manual Activity button should be Enabled When the 'MIO' is 'Y' in the Cost Configuration Module  ", test, test1);
			
			Extent_completed(testCaseName, test, test1);
	}

}
