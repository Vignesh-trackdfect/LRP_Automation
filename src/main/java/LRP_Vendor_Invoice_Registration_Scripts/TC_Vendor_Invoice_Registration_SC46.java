package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC46 extends Keywords{

	public void Vendor_Invoice_Registration_SC46(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Vendor_Invoice_Registration_SC46";
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
		String invoiceSaved_Popup = Excel_data.get("InvoiceSaved_Popup");
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
		String Home_ROE = Excel_data.get("Home_ROE");
		String SOR_No_Value = Excel_data.get("SOR_No_Value");
		String SOR_No_Header = Excel_data.get("SOR_No_Header");
		String Activity_Input = Excel_data.get("Activity_Input");
		String DA_Month_Input = Excel_data.get("DA_Month_Input");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String Approved_Exp = Excel_data.get("Approved_Exp");
		String Service_Order_Approval_Module = Excel_data.get("Service_Order_Approval_Module");
		String Reference_No_search = Excel_data.get("Reference_No_search");
		String Grid_value = Excel_data.get("Grid_value");


		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, agencyCode);
		//			Vendor Invoice Registration

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

		Step_End(2, "Select the required Vendor code.", test, test1);
		Step_End(3, "It shows the approved vendor based on the vendor master", test, test1);
		Step_End(4, "Select the Required vendor code and name", test, test1);


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

		Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);

		Step_End(10, "Payment method is auto fetch from vendor master based on the Payment method", test, test1);


		if(!Home_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, home_ROE_Textfield_VIR);
			clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
		}		

		Step_Start(11, "In the Activity details, Click Activity type dropdown and select the activity type as a \"SOR\"", test, test1);

		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		formatLocatorClick(driver, DropDown_Select, activityType);

		Step_End(11, "In the Activity details, Click Activity type dropdown and select the activity type as a \"SOR\"", test, test1);


		Step_Start(12, "Click the SOR no search and select the Required no", test, test1);

		waitForElement(driver, sor_No_Search_Button);
		click(driver, sor_No_Search_Button);
		twoColumnSearchWindow(driver, SOR_No_Header, condition, SOR_No_Value);
		Step_End(12, "Click the SOR no search and select the Required no", test, test1);

		Step_Start(13, "Select the DA month ,It based on the DA master setup", test, test1);
		if(!DA_Month_Input.trim().equals("")) {
			waitForElement(driver, sor_DA_Month_Dropdown_Select);
			click(driver, sor_DA_Month_Dropdown_Select);
			formatLocatorClick(driver, DropDown_Select, DA_Month_Input);
		}
		Step_End(13, "Select the DA month ,It based on the DA master setup", test, test1);

		Step_Start(14, "Select the Activity Month", test, test1);
		if(!Activity_Input.trim().equals("")) {
			waitForElement(driver, sor_Activity_Month);
			click(driver, sor_Activity_Month);
			formatLocatorClick(driver, DropDown_Select, Activity_Input);
		}
		Step_End(14, "Select the Activity Month", test, test1);

		Step_Start(15, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		waitForElement(driver, sor_No_Add_Button);
		click(driver, sor_No_Add_Button);
		Step_End(15, "Click the \"+ADD\" button, Details added in the Grid", test, test1);

		reArrangeAG_GridColumns(driver, Grid_value);

		waitForElement(driver, sor_No_Table);

		List<Map<String, String>> Table_Data = extractTableDataByColumnWithoutScroll(driver, sor_No_Table);	
		String Activity_Ref_No_Value = getFirstValueByHeader(Table_Data, "Activity Ref.No");              
		System.out.println("Activity_Ref_No_Value :"+ Activity_Ref_No_Value);


		String [] splittedValue=Activity_Ref_No_Value.split("-");
		System.out.println("splittedValue 1 : "+splittedValue[1]);

		scrollTop(driver);
		Step_Start(16, "Click the save", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(16, "Click the save", test, test1);

		
		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}

		waitForPopup(driver, popup_Message, invoiceSaved_Popup);
		String actualPopup=getText(driver, popup_Message);

		if(actualPopup.trim().equals(invoiceSaved_Popup)) {
			System.out.println("Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
			Extent_pass(driver, "Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}

		click(driver, popup_Message_Ok_Button);

		Step_Start(17, "It auto generate the Invoice Reg No", test, test1);
		waitForElement(driver, invoice_Reg_No_Textfield_VIR);
		String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
		System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
		if(!actual_Vendor_Reg_No.trim().equals("")) {
			System.out.println("Passed || Expected Result is : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_pass(driver, "Passed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No, test, test1);
		}else {
			System.out.println("Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_fail(driver, "Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No  is : "+actual_Vendor_Reg_No, test, test1);
		}

		Step_End(17, "It auto generate the Invoice Reg No", test, test1);


		moduleNavigate(driver, Service_Order_Approval_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, Reference_No_search, splittedValue[1], "", "", "", "");
		scrollBottom(driver);
		waitForElement(driver, Approved_field);
		String   approval_Act=   getText(driver, Approved_field);
		if(Approved_Exp.trim().equals(approval_Act)) {
			System.out.println("Matched || Expected status is : "+ Approved_Exp  +" || Actual status is : "+ approval_Act);
			Extent_pass(driver, "Matched || Expected status is : "+ Approved_Exp  +" || Actual status is : "+ approval_Act, test, test1);
			
		}else {
			System.out.println("Not Matched || Expected status is : "+ Approved_Exp  +" || Actual status is : "+ approval_Act);
		    Extent_fail(driver, "Not Matched || Expected status is : "+ Approved_Exp  +" || Actual status is : "+ approval_Act, test, test1);
		    
		}
		

		Extent_completed(testCaseName, test, test1);

	}

}
