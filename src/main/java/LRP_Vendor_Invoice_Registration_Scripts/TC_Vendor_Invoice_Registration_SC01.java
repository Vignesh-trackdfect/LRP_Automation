package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC01 extends Keywords {
	public void Vendor_Invoice_Registration_SC01(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Vendor_Invoice_Registration_SC01";
		// Get data from excel sheet
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String vendorCode = Excel_data.get("VendorCode");
		String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
		String Vendor_Code_header=Excel_data.get("Vendor_Code_header");
		String Condition_Filter=Excel_data.get("Condition_Filter");
		String Vendor_Code_value =Excel_data.get("Vendor_Code_value");
		String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
		String cost_Attribute = Excel_data.get("cost_Attribute");
		String Open_Value = Excel_data.get("Open_Value");
		String Approved_Value = Excel_data.get("Approved_Value");
		String Exp_pop = Excel_data.get("Exp_pop");
		
		String Value_Yes = Excel_data.get("Value_Yes");
		String Value_No = Excel_data.get("Value_No");
		String Vendor_Invoice_Registration_Module = Excel_data.get("Vendor_Invoice_Registration_Module");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		
		moduleNavigate(driver, costConfiguration_Module);

		Step_Start(1, "Go to Cost Configuration Module and Se the 'VES' attriubte as 'Y' ", test, test1);
		SetCostConfiguration(driver, cost_Attribute, Value_Yes);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		Step_End(1, "Go to Cost Configuration Module and Se the 'VES' attriubte as 'Y' ", test, test1);
		
		Step_Start(2, "Go to Vendor Master module ", test, test1);
		moduleNavigate(driver, Vendor_Master_Module);
		Step_End(2, "Go to Vendor Master module ", test, test1);

		Step_Start(3, "Select the Vendor Code Eye Icon and its navigate to Vendor master screen", test, test1);
		AGGridValueFilter(driver,Vendor_Code_header,Condition_Filter,Vendor_Code_value);

		waitForElement(driver, Vendor_Master_Eye_icon);
		click(driver,Vendor_Master_Eye_icon);
		Step_End(3, "Select the Vendor Code Eye Icon and its navigate to Vendor master screen", test, test1);

		Step_Start(4, "Check the Open and Approved Status box is available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion ", test, test1);
	
		waitForDisplay(driver, Vendor_Master_Status_Box);
		if(isdisplayed(driver, Vendor_Master_Status_Box)) {
			System.out.println("Matched || Expected : Open and Approved Status box Should be available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion || Actual : Open and Approved Status box is available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion");
			Extent_pass(driver, "Matched || Expected : Open and Approved Status box Should be available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion || Actual : Open and Approved Status box is available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion", test, test1);
		}else {
			System.out.println("Not Matched || Expected : Open and Approved Status box Should be available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion || Actual : Open and Approved Status box is not available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion");
			Extent_fail(driver, "Not Matched || Expected : Open and Approved Status box Should be available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion || Actual : Open and Approved Status box is not available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion", test, test1);
		}
		Step_End(4, "Check the Open and Approved Status box is available in the Vendor Master when 'VES' is 'Y' in the Cost Configurtion ", test, test1);

		Step_Start(5, "Get the Status Selected in the Vendor Master screen ", test, test1);
		waitForElement(driver, Vendor_Master_Status);
		String status_value= getText(driver, Vendor_Master_Status);
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		Step_End(5, "Get the Status Selected in the Vendor Master screen ", test, test1);
		
		Step_Start(6, "Open the Vendor Invoice Registration moduole", test, test1);
		moduleNavigate(driver, Vendor_Invoice_Registration_Module);
		Step_End(6, "Open the Vendor Invoice Registration moduole", test, test1);

		Step_Start(7, "Click the Vendor code Search button and Search the Vendor code", test, test1);

		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver,Vedor_Code_Search_Button_VIR);
		
		globalValueSearchWindow1(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

		Step_End(7, "Click the Vendor code Search button and Search the Vendor code", test, test1);

		Step_Start(8, "Check Whether  the Vendor code is retrived or not Based on the Vendor master screen Status Value", test, test1);

		if(status_value.equalsIgnoreCase(Approved_Value)) {
			waitForDisplay(driver, retrivedGlobalValue);
			if(isdisplayed(driver, retrivedGlobalValue)) {
				System.out.println("Matched || Expected : Vendor code should be display in the Global search When the Vendor Master status is 'Approved' || Actual : Vendor code displayed in the Global search When the Vendor Master status is 'Approved'");
				Extent_pass(driver, "Matched || Expected : Vendor code should be display in the Global search When the Vendor Master status is 'Approved' || Actual : Vendor code displayed in the Global search When the Vendor Master status is 'Approved'", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Vendor code should be display in the Global search When the Vendor Master status is 'Approved' || Actual : Vendor code is not displayed in the Global search When the Vendor Master status is 'Approved'");
				Extent_fail(driver,"Not Matched || Expected : Vendor code should be display in the Global search When the Vendor Master status is 'Approved' || Actual : Vendor code is not displayed in the Global search When the Vendor Master status is 'Approved'", test, test1);
			}
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
		}else if(status_value.equalsIgnoreCase(Open_Value)){

			waitForPopup(driver, Popup_Message, Exp_pop);
			String Act_pop =getText(driver, Popup_Message);
			if(Exp_pop.equals(Act_pop)) {
				System.out.println("Matched || Expected : 'No records Found' message should display While the Vendor Code Search When the Vendor Master status is 'Open' || Actual : 'No records Found' message is displayed  While the Vendor Code Search When the Vendor Master status is 'Open', Act popup : "+Act_pop );
				Extent_pass(driver,"Matched || Expected : 'No records Found' message should display While the Vendor Code Search When the Vendor Master status is 'Open' || Actual : 'No records Found' message is displayed  While the Vendor Code Search When the Vendor Master status is 'Open', Act popup : "+Act_pop ,test, test1 );
			}else {
				System.out.println("Not Matched || Expected : 'No records Found' message should display While the Vendor Code Search When the Vendor Master status is 'Open' || Actual : 'No records Found' message is not displayed  While the Vendor Code Search When the Vendor Master status is 'Open', Act popup : "+Act_pop );
				Extent_fail(driver,"Not Matched || Expected : 'No records Found' message should display While the Vendor Code Search When the Vendor Master status is 'Open' || Actual : 'No records Found' message is not displayed  While the Vendor Code Search When the Vendor Master status is 'Open', Act popup : "+Act_pop ,test, test1 );
			}
		}
		
		waitForDisplay(driver, globalSearchCloseIcon_L);
		if(isdisplayed(driver, globalSearchCloseIcon_L)) {
			click(driver,globalSearchCloseIcon_L);
		}
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);		
		Step_End(8, "Check Whether  the Vendor code is retrived or not Based on the Vendor master screen Status Value", test, test1);

		
		moduleNavigate(driver, costConfiguration_Module);

		Step_Start(9, "Go to Cost Configuration Module and Se the 'VES' attriubte as 'N' ", test, test1);
		SetCostConfiguration(driver, cost_Attribute, Value_No);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		Step_End(9, "Go to Cost Configuration Module and Se the 'VES' attriubte as 'N' ", test, test1);
		
		Step_Start(10, "Go to Vendor Master module, select the Vendor Code and Check the Status Box should not display", test, test1);
		moduleNavigate(driver, Vendor_Master_Module);

		AGGridValueFilter(driver,Vendor_Code_header,Condition_Filter,Vendor_Code_value);

		waitForElement(driver, Vendor_Master_Eye_icon);
		click(driver,Vendor_Master_Eye_icon);
	
		waitForDisplay(driver, Vendor_Master_Status_Box);
		if(!isdisplayed(driver, Vendor_Master_Status_Box)) {
			System.out.println("Matched || Expected : Open and Approved Status box Should not be available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion || Actual : Open and Approved Status box is not available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion");
			Extent_pass(driver, "Matched || Expected : Open and Approved Status box Should not be available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion || Actual : Open and Approved Status box is not available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion", test, test1);
		}else {
			System.out.println("Not Matched || Expected : Open and Approved Status box Should not be available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion || Actual : Open and Approved Status box is available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion");
			Extent_fail(driver, "Not Matched || Expected : Open and Approved Status box Should not be available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion || Actual : Open and Approved Status box is available in the Vendor Master when 'VES' is 'N' in the Cost Configurtion", test, test1);
		}

		Step_End(10, "Go to Vendor Master module, select the Vendor Code and Check the Status Box should not display", test, test1);


		//As discussed with Pradeep on 05.06.2024 the below codes for step No 11 has been removed from the execution. This one not required.
		
//		Step_Start(11, "Go to Vendor Invoice Registration Module And Search the Vendor Code, validate the vendor code should be retrived successfully when the 'VES' is 'N' ", test, test1);
//		moduleNavigate(driver, Vendor_Invoice_Registration_Module);
//		waitForElement(driver, Vedor_Code_Search_Button_VIR);
//		click(driver,Vedor_Code_Search_Button_VIR);
//		globalValueSearchWindow1(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");
//		waitForDisplay(driver, retrivedGlobalValue);
//		if(isDisplayed(driver, retrivedGlobalValue)) {
//			System.out.println("Matched || Expected : Vendor code should be display in the Global search When the 'VES' value is 'N' in the Cost Configuration Module || Actual : Vendor code is display in the Global search When the 'VES' value is 'N' in the Cost Configuration Module ");
//			Extent_pass(driver, "Matched || Expected : Vendor code should be display in the Global search When the 'VES' value is 'N' in the Cost Configuration Module || Actual : Vendor code is display in the Global search When the 'VES' value is 'N' in the Cost Configuration Module ", test, test1);
//		}else {
//			System.out.println("Not Matched || Expected : Vendor code should be display in the Global search When the 'VES' value is 'N' in the Cost Configuration Module || Actual : Vendor code is not displayed in the Global search When the 'VES' value is 'N' in the Cost Configuration Module ");
//			Extent_fail(driver, "Not Matched || Expected : Vendor code should be display in the Global search When the 'VES' value is 'N' in the Cost Configuration Module || Actual : Vendor code is not displayed in the Global search When the 'VES' value is 'N' in the Cost Configuration Module ", test, test1);
//		}
//		waitForElement(driver, retrivedGlobalValue);
//		click(driver, retrivedGlobalValue);
//		waitForElement(driver, SelectButton);
//		click(driver, SelectButton);
//		Step_End(11, "Go to Vendor Invoice Registration Module And Search the Vendor Code, validate the vendor code should be retrived successfully when the 'VES' is 'N' ", test, test1);
//	
		Extent_completed(testCaseName, test, test1);

	}
}