package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC44 extends Keywords{

	public void Vendor_Invoice_Registration_SC44(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Vendor_Invoice_Registration_SC44";
		//  Get data from excel sheet	
		
		
		

				

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String agencyCode = Excel_data.get("AgencyCode");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String vendorCode = Excel_data.get("VendorCode");
		String Vendor_Invoice_No_Char = Excel_data.get("Vendor_Invoice_No_Char");
		String activityType = Excel_data.get("ActivityType");
		String condition = Excel_data.get("Condition");
		String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
		String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
		String Inv_Date = Excel_data.get("Inv_Date");
		String datePicker = Excel_data.get("datePicker");
		String Factor_payee_search = Excel_data.get("Factor_payee_search");
		String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String Disbusse_currency = Excel_data.get("Disbusse_currency");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Payment_method = Excel_data.get("Payment_method");
		String invoice_currency = Excel_data.get("Invoice_currency");
		String DA_Month_Select = Excel_data.get("DA_Month_Select");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String Home_ROE = Excel_data.get("Home_ROE");
		String DA_Month_Value = Excel_data.get("DA_Month_Value");
		String DA_Master_Setup_Module = Excel_data.get("DA_Master_Setup_Module");
		String Agency_Code_DA_Header = Excel_data.get("Agency_Code_DA_Header");
		String Agency_code_DA_Value = Excel_data.get("Agency_code_DA_Value");
		String DA_Year_Value = Excel_data.get("DA_Year_Value");
		String DA_Saved_Popup = Excel_data.get("DA_Saved_Popup");
		String Activity_Month_Select = Excel_data.get("Activity_Month_Select");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login

		LRP_Login(driver, username, password);
		SwitchProfile(driver, agencyCode);


		moduleNavigate(driver, DA_Master_Setup_Module);
		
		waitForElement(driver, Agency_Code_DA);
		click(driver, Agency_Code_DA);
		
		twoColumnSearchWindow(driver, Agency_Code_DA_Header, condition, Agency_code_DA_Value);
		
		waitForElement(driver, DA_Month_Dropdown_DA);
		click(driver, DA_Month_Dropdown_DA);
		formatLocatorClick(driver, DropDown_Select, DA_Month_Select);
		
		
		waitForElement(driver, Activity_Month_Dropdown_DA);
		click(driver, Activity_Month_Dropdown_DA);
		formatLocatorClick(driver, DropDown_Select, Activity_Month_Select);
		
		waitForElement(driver, Year_Dropdown_DA);
		click(driver, Year_Dropdown_DA);
		formatLocatorClick(driver, DropDown_Select, DA_Year_Value);
		
		
		waitForElement(driver, Month_Dropdown_DA);
		click(driver, Month_Dropdown_DA);
		formatLocatorClick(driver, DropDown_Select, DA_Month_Value);
	
		
		waitForElement(driver, DA_Month_Dropdown_DA_Text);
		String DA_Month_Text=getText(driver, DA_Month_Dropdown_DA_Text);
		System.out.println("DA_Month_Text : "+DA_Month_Text);
		
	
		waitForElement(driver, Activity_Month_Dropdown_DA_Text);
		String Activity_Month_Text=getText(driver, Activity_Month_Dropdown_DA_Text);
		System.out.println("Activity_Month_Text : "+Activity_Month_Text);
		
		waitForElement(driver, Year_Dropdown_DA);
		String Year_Text=getText(driver, Year_Dropdown_DA);
		System.out.println("Year_Text : "+Year_Text);
		
		waitForElement(driver, Month_Dropdown_DA);
		String Month_Text=getText(driver, Month_Dropdown_DA);
		System.out.println("Month_Text : "+Month_Text);
		
		String DA_Month_And_Year = Month_Text + "-" + Year_Text;
		System.out.println("DA_Month_And_Year :"+ DA_Month_And_Year);
		
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, Popup_Message, DA_Saved_Popup);
		String DA_Popup_Act=getText(driver, Popup_Message);
		if(DA_Saved_Popup.trim().equals(DA_Popup_Act)) {
			
			System.out.println("Matched || Expected Popup : "+DA_Saved_Popup +" || Actual Popup :" +DA_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+DA_Saved_Popup +" || Actual Popup :" +DA_Popup_Act, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+DA_Saved_Popup +" || Actual Popup :" +DA_Popup_Act);
			Extent_fail(driver, "Not Matched || Expected Popup : "+DA_Saved_Popup +" || Actual Popup :" +DA_Popup_Act, test, test1);
		}
		
		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);
		
		Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

		moduleNavigate(driver, moduleName);

		Step_End(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
		Step_Start(2, "Click the Vendor code search button", test, test1);

		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);
		Step_End(2, "Click the Vendor code search button", test, test1);
		Step_Start(3, "It shows the approved vendor based on the vendor master", test, test1);
		Step_Start(4, "Select the Required vendor code and name", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");
		Step_End(4, "Select the Required vendor code and name", test, test1);

		Step_End(3, "It shows the approved vendor based on the vendor master", test, test1);


		if(!Inv_Registration_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Registration_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Registration_Date_VIR);
				selectDatePicker(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);

			} else {
				waitForElement(driver, Inv_Registration_Date_VIR);
				clearAndType(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);
			}
		}
		if(!Inv_Receiving_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Receiving_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				selectDatePicker(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			} else {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				clearAndType(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			}}
		if(!Inv_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, vendor_Inv_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, vendor_Inv_Date_VIR);
				selectDatePicker(driver, vendor_Inv_Date_VIR, Inv_Date);

			} else {
				waitForElement(driver, vendor_Inv_Date_VIR);
				clearAndType(driver, vendor_Inv_Date_VIR, Inv_Date);

			}
		}
		
		if(!Factor_payee_Input.trim().equals("")) {
			waitForElement(driver, factor_Payee_SearchButton_VIR);
			click(driver, factor_Payee_SearchButton_VIR);
			twoColumnSearchWindow(driver, Factor_payee_search, condition, Factor_payee_Input);
		}
		
		// Vendor invoice number
		Step_Start(5, "Click the Vendor invoice field", test, test1);

		waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
		Step_End(5, "Click the Vendor invoice field", test, test1);
		Step_Start(6, "Enter the value up to 25 characters", test, test1);
		sendKeys(driver, Vendor_Invoice_Number_Input_VIR, Vendor_Invoice_No_Char);
		Step_End(6, "Enter the value up to 25 characters", test, test1);




		if(!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
		}

		if(!invoice_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, invoiceCurrency_Dropdown_VIR);
			click(driver, invoiceCurrency_Dropdown_VIR);
			formatLocatorClick(driver, DropDown_Select, invoice_currency);


		}


		if(!invoice_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
		}

		Step_Start(7, "Click the Disburse currency dropdown", test, test1);

		if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			Step_End(7, "Click the Disburse currency dropdown", test, test1);

			Step_Start(8, "Select the Require currency", test, test1);
			formatLocatorClick(driver, DropDown_Select, Disbusse_currency);

			Step_End(8, "Select the Require currency", test, test1);

		}
		Step_Start(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
		Step_Start(10, "Payment method is auto fetch from vendor master based on the Payment method", test, test1);

		if(!Payment_method.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
			click(driver, Vendorinvoice_Payment_method_dd_VIR);
			formatLocatorClick(driver, DropDown_Select, Payment_method);


		}
		Step_End(10, "Payment method is auto fetch from vendor master based on the Payment method", test, test1);

		Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);



		if(!Home_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, home_ROE_Textfield_VIR);
			clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
		}		

		Step_Start(11, "In the Activity details, Click Activity type dropdown and select the activity type as a CMR", test, test1);
		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		formatLocatorClick(driver, DropDown_Select, activityType);
		
		Step_End(11, "In the Activity details, Click Activity type dropdown and select the activity type as a CMR", test, test1);

		Step_Start(12, "Save record should be present in the Vendor Invoice Registration screen based on the Agency", test, test1);
		if(DA_Month_Select.trim().equalsIgnoreCase("Yes")) {
		waitForElement(driver, cmr_manual_DA_Month_Dropdown);
		click(driver, cmr_manual_DA_Month_Dropdown);
		formatLocatorClick(driver, DA_Month_Select_1, DA_Month_And_Year);

		waitForElement(driver, VIR_DA_Month);
		String DA_Month_Act=getText(driver, VIR_DA_Month);
		System.out.println("DA_Month_Act :" +DA_Month_Act);
		
		
		if(DA_Month_And_Year.trim().equalsIgnoreCase(DA_Month_Act)) {
			System.out.println("Matched || Expected DA Month Value is "+ DA_Month_And_Year + " || Actual DA Month Value is : " +DA_Month_Act);
			Extent_pass_New(driver, "Matched || Expected DA Month Value is "+ DA_Month_And_Year + " || Actual DA Month Value is : " +DA_Month_Act, test, test1);
			
		}else {
			System.out.println("Not Matched || Expected DA Month Value is "+ DA_Month_And_Year + " || Actual DA Month Value is : " +DA_Month_Act);
             Extent_fail(driver, "Not Matched || Expected DA Month Value is "+ DA_Month_And_Year + " || Actual DA Month Value is : " +DA_Month_Act, test, test1);
			
		}
		
		}
		
		
		if(Activity_Month_Select.trim().equalsIgnoreCase("Yes")) {
			waitForElement(driver, cmr_manual_Activity_Month_Dropdown);
			click(driver, cmr_manual_Activity_Month_Dropdown);
			formatLocatorClick(driver, Activity_Month_Select_1, DA_Month_And_Year);

			waitForElement(driver, VIR_Activity_Month);
			String Activity_Month_Act=getText(driver, VIR_Activity_Month);
			System.out.println("Activity_Month_Act :" +Activity_Month_Act);
			
			
			if(DA_Month_And_Year.trim().equalsIgnoreCase(Activity_Month_Act)) {
				System.out.println("Matched || Expected Activity Month Value is "+ DA_Month_And_Year + " || Actual Activity Month Value is : " +Activity_Month_Act);
				Extent_pass_New(driver, "Matched || Expected Activity Month Value is "+ DA_Month_And_Year + " || Actual Activity Month Value is : " +Activity_Month_Act, test, test1);
			}else {
				System.out.println("Not Matched || Expected Activity Month Value is "+ DA_Month_And_Year + " || Actual Activity Month Value is : " +Activity_Month_Act);
	             Extent_fail(driver, "Not Matched || Expected Activity Month Value is "+ DA_Month_And_Year + " || Actual Activity Month Value is : " +Activity_Month_Act, test, test1);
				
			}
			
			}
		
		Step_End(12, "Save record should be present in the Vendor Invoice Registration screen based on the Agency", test, test1);
              Extent_completed(testCaseName, test, test1);		
		
		
		
	}
}
