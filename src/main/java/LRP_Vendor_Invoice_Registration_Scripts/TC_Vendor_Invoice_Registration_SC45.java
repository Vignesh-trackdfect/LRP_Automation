package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC45 extends Keywords{

	public void Vendor_Invoice_Registration_SC45(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Vendor_Invoice_Registration_SC45";
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
		String Activity_Input = Excel_data.get("Activity_Input");
		String DA_Month_Input = Excel_data.get("DA_Month_Input");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String Main_Activity_Code_Value = Excel_data.get("Main_Activity_Code_Value");
		String Main_Activity_code_Header = Excel_data.get("Main_Activity_code_Header");
		String Sub_Activity_Code_Value = Excel_data.get("Sub_Activity_Code_Value");
		String Sub_Activity_Code_Header = Excel_data.get("Sub_Activity_Code_Header");
		String Equipment_Type_Value = Excel_data.get("Equipment_Type_Value");
		String Equipment_Type_Header = Excel_data.get("Equipment_Type_Header");
		String Port_Code_Value = Excel_data.get("Port_Code_Value");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String AG_Grid_Column_Headers = Excel_data.get("AG_Grid_Column_Headers");
		String invoiceAmount = Excel_data.get("invoiceAmount");
		String invoiceQuantity = Excel_data.get("invoiceQuantity");


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

		Step_Start(11, "In the Activity details, Click Activity type dropdown and select the activity type as a CMR", test, test1);
		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		formatLocatorClick(driver, DropDown_Select, activityType);
		
		Step_End(11, "In the Activity details, Click Activity type dropdown and select the activity type as a CMR", test, test1);

		Step_Start(12, "Click the Manual activity", test, test1);
		waitForElement(driver, cmr_Manual_Activity_Button);
		click(driver, cmr_Manual_Activity_Button);
		
		Step_End(12, "Click the Manual activity", test, test1);
		
		Step_Start(13, "Click the Main activity search and select the Activity", test, test1);
		waitForElement(driver, cmr_Main_Activity_Search_Button);
		click(driver, cmr_Main_Activity_Search_Button);
		twoColumnSearchWindow(driver, Main_Activity_code_Header, condition, Main_Activity_Code_Value);
		
		Step_End(13, "Click the Main activity search and select the Activity", test, test1);
		
		Step_Start(14, "Click the Sub activity \"+\" and select the require activity.", test, test1);
		waitForElement(driver, cmr_Sub_Activity_Plus_Button);
		click(driver, cmr_Sub_Activity_Plus_Button);
		twoColumnSearchWindow(driver, Sub_Activity_Code_Header, condition, Sub_Activity_Code_Value);
		
		
		Step_End(14, "Click the Sub activity \"+\" and select the require activity.", test, test1);
		
		Step_Start(15, "Click eqp type search and select the Equipment type", test, test1);
		
		waitForElement(driver, cmr_eqp_Type_Search_Button);
		click(driver, cmr_eqp_Type_Search_Button);
		twoColumnSearchWindow(driver, Equipment_Type_Header, condition, Equipment_Type_Value);
		
		Step_End(15, "Click eqp type search and select the Equipment type", test, test1);
		
		Step_Start(16, "Click the Port search and select the required Port", test, test1);
		
		waitForElement(driver, cmr_ports_Search_Button);
		click(driver, cmr_ports_Search_Button);
		
		twoColumnSearchWindow(driver, Port_Code_Header, condition, Port_Code_Value);
		Step_End(16, "Click the Port search and select the required Port", test, test1);
		
		Step_Start(17, "Select the DA month ,It based on the DA master setup", test, test1);
		if(!DA_Month_Input.trim().equals("")) {
			waitForElement(driver, cmr_manual_Activity_Month_Dropdown);
			click(driver, cmr_manual_Activity_Month_Dropdown);
			formatLocatorClick(driver, DropDown_Select, DA_Month_Input);
		}
		Step_End(17, "Select the DA month ,It based on the DA master setup", test, test1);
		
		Step_Start(18, "Select the Activity Month", test, test1);
		if(!Activity_Input.trim().equals("")) {
			waitForElement(driver, cmr_manual_DA_Month_Dropdown);
			click(driver, cmr_manual_DA_Month_Dropdown);
			formatLocatorClick(driver, DropDown_Select, Activity_Input);
		}
		
		Step_End(18, "Select the Activity Month", test, test1);
		
		
		Step_Start(19, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		waitForElement(driver, cmr_Manual_Activity_Plus_Button);
		click(driver, cmr_Manual_Activity_Plus_Button);
		
		Step_End(19, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		
		scrollBottom(driver);
		reArrangeAG_GridColumns(driver, AG_Grid_Column_Headers);
		
		waitForDisplay(driver, manualActivity_Table_Gridcell_VIR);
		if(isdisplayed(driver, manualActivity_Table_Gridcell_VIR)) {
			System.out.println("Matched || Expected Result is : Records should be added into the AG grid || Actual Result is  : Records are added into the AG grid");
			Extent_pass_New(driver, "Matched || Expected Result is  : Records should be added into the AG grid || Actual Result is  : Records are added into the AG grid", test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is  : Records should be added into the AG grid || Actual Result is  : Records are added not into the AG grid");
			Extent_fail(driver, "Not Matched || Expected Result is  : Records should be added into the AG grid || Actual Result is  : Records are added not into the AG grid", test, test1);
		}
		
		Step_End(20, "Here the invoice quantity and invoice amount based on Main activity code and Sub activity code.", test, test1);

		waitForElement(driver, invoiceQuantity_Gridcell_VIR);
		doubleClick(driver, invoiceQuantity_Gridcell_VIR);
		
		waitForElement(driver, invoiceQuantity_Input_Gridcell_VIR);
		clearAndType(driver, invoiceQuantity_Input_Gridcell_VIR, invoiceQuantity);
		enter(driver);
		
		waitForElement(driver, invoiceAmount_Gridcell_VIR);
		doubleClick(driver, invoiceAmount_Gridcell_VIR);
		
		waitForElement(driver, invoiceAmount_Input_Gridcell_VIR);
		clearAndType(driver, invoiceAmount_Input_Gridcell_VIR, invoiceAmount);
		enter(driver);
		
		scrollTop(driver);

		Step_End(20, "Here the invoice quantity and invoice amount based on Main activity code and Sub activity code.", test, test1);
		Step_Start(21, "Click the save", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		
		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
		
		
		waitForPopup(driver, popup_Message, invoiceSaved_Popup);
		String actualPopup=getText(driver, popup_Message);
		
		if(actualPopup.trim().equals(invoiceSaved_Popup)) {
			System.out.println("Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}
		
		click(driver, popup_Message_Ok_Button);
		
		
		Step_End(22, "It auto generate the Invoice Reg No", test, test1);
		
		waitForElement(driver, invoice_Reg_No_Textfield_VIR);
		String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
		System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
		if(!actual_Vendor_Reg_No.trim().equals("")) {
			System.out.println("Passed || Expected Result is : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_pass_New(driver, "Passed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No, test, test1);
		}else {
			System.out.println("Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_fail(driver, "Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No  is : "+actual_Vendor_Reg_No, test, test1);
		}
		
		Step_End(22, "It auto generate the Invoice Reg No", test, test1);
		Extent_completed(testCaseName, test, test1);
		
		
		
		
	}

}
