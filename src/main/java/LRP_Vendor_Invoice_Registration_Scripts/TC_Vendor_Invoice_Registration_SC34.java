package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC34 extends Keywords {

	public void Vendor_Invoice_Registration_SC34(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Vendor_Invoice_Registration_SC34";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String agencyCode = Excel_data.get("AgencyCode");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
		String vendorCode = Excel_data.get("VendorCode");
		String vendorInvoiceNumber = Excel_data.get("VendorInvoiceNumber");
		String condition = Excel_data.get("Condition");
		String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
		String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
		String Inv_Date = Excel_data.get("Inv_Date");
		String datePicker = Excel_data.get("datePicker");
		String Factor_payee_search = Excel_data.get("Factor_payee_search");
		String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String Disburse_currency = Excel_data.get("Disburse_currency");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Payment_method = Excel_data.get("Payment_method");
		String invoice_currency = Excel_data.get("Invoice_currency");
		String Home_ROE = Excel_data.get("Home_ROE");
		String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String paymentMode_RadioButton_Status = Excel_data.get("PaymentMode_RadioButton_Status");
		String PaymentModes_VIR = Excel_data.get("PaymentModes_VIR");
		String PaymentModes_VM = Excel_data.get("PaymentModes_VM");
		String ActivityType = Excel_data.get("ActivityType");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String InvoiceSaved_Popup = Excel_data.get("InvoiceSaved_Popup");
		String Search_condition = Excel_data.get("Search_condition");
		String MainActivty_Header = Excel_data.get("MainActivty_Header");
		String Mainactivity_Code = Excel_data.get("Mainactivity_Code");
		String SubActivty_Header = Excel_data.get("SubActivty_Header");
		String Subactivity_Code = Excel_data.get("Subactivity_Code");
		String Eqp_Header = Excel_data.get("Eqp_Header");
		String Eqp_type = Excel_data.get("Eqp_type");
		String POL_Header = Excel_data.get("POL_Header");
		String POL_PortCode = Excel_data.get("POL_PortCode");
		String POD_Header = Excel_data.get("POD_Header");
		String POD_PortCode = Excel_data.get("POD_PortCode");
		String Invoice_qty_input = Excel_data.get("Invoice_qty_input");
		String Invoice_Amount_input = Excel_data.get("Invoice_Amount_input");


		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_Start(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);

		SwitchProfile(driver, agencyCode);

		moduleNavigate(driver, Vendor_Master_Module);

		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

		List<String> paymentModes_VM = splitAndExpand(PaymentModes_VM);
		List<String> paymentModes_VIR = splitAndExpand(PaymentModes_VIR);

		waitForElement(driver, HQ_RadioButton_VM);
		String status_Of_HQ_RadioButton_VM = getAttribute(driver, HQ_RadioButton_VM, "class");
		String status_Of_Disbursement_RadioButton_VM = getAttribute(driver, Disbursement_RadioButton_VM, "class");

		if (status_Of_HQ_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
			status_Of_HQ_RadioButton_VM = paymentMode_RadioButton_Status;
		} else if (status_Of_Disbursement_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
			status_Of_Disbursement_RadioButton_VM = paymentMode_RadioButton_Status;

		}

		waitForElement(driver, Paymemnt_Method_VM);
		String Payment_Method_Value = getText(driver, Paymemnt_Method_VM);
		System.out.println("Payment_Method_Value VM :" + Payment_Method_Value);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, moduleName);

		Step_End(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);

		Step_Start(2, "Click the Vendor code search button", test, test1);

		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);

		Step_End(2, "Click the Vendor code search button", test, test1);
		Step_Start(3, "It shows the approved vendor based on the vendor master.", test, test1);
		Step_Start(4, "Select the Required vendor code and name.", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");

		Step_End(3, "It shows the approved vendor based on the vendor master.", test, test1);
		Step_End(4, "Select the Required vendor code and name.", test, test1);

		if (!Inv_Registration_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Registration_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Registration_Date_VIR);
				selectDatePicker(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);

			} else {
				waitForElement(driver, Inv_Registration_Date_VIR);
				clearAndType(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);
			}
		}
		if (!Inv_Receiving_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Receiving_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				selectDatePicker(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			} else {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				clearAndType(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			}
		}
		if (!Inv_Date.trim().equalsIgnoreCase("")) {
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
		
		Step_Start(5, "Click the Vendor invoice field.", test, test1);

		waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
		click(driver, Vendor_Invoice_Number_Input_VIR);

		Step_End(5, "Click the Vendor invoice field.", test, test1);
		Step_Start(6, "Enter the value up to 25 characters.", test, test1);

		sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);

		Step_End(6, "Enter the value up to 25 characters.", test, test1);

		if (!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
		}

		if (!invoice_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, invoiceCurrency_Dropdown_VIR);
			click(driver, invoiceCurrency_Dropdown_VIR);

			String invoiceCurrency_select = String.format(DropDown_Select, invoice_currency);
			click(driver, invoiceCurrency_select);

		}

		if (!invoice_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
		}

		Step_Start(7, "Click the Disburse currency dropdown", test, test1);

		if (!Disburse_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);

			Step_End(7, "Click the Disburse currency dropdown", test, test1);
			Step_Start(8, "Select the Require currency.", test, test1);

			String currency_select = String.format(DropDown_Select, Disburse_currency);
			waitForElement(driver, currency_select);
			click(driver, currency_select);

			Step_End(8, "Select the Require currency.", test, test1);

		}

		Step_Start(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);

		waitForElement(driver, direct_Payment_Mode_Button_VIR);
		String status_Of_direct_Payment_Mode_Button_VIR = getAttribute(driver, direct_Payment_Mode_Button_VIR, "class");
		String status_Of_disbursment_Payement_Mode_Button_VIR = getAttribute(driver,
				disbursment_Payement_Mode_Button_VIR, "class");

		if (status_Of_direct_Payment_Mode_Button_VIR.contains(status_Of_HQ_RadioButton_VM)) {

			System.out.println(
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(0)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(0));
			Extent_pass(driver,
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(0)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(0),
					test, test1);
		} else if (status_Of_disbursment_Payement_Mode_Button_VIR.contains(status_Of_Disbursement_RadioButton_VM)) {
			System.out.println(
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(1)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(1));
			Extent_pass(driver,
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(1)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(1),
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is : expected radio button should be selected || Actual result is : Expected Radio Button is not selected");
			Extent_fail(driver,
					"Not Matched || Expected result is : expected radio button should be selected || Actual result is : Expected Radio Button is not selected",
					test, test1);
		}

		Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
		Step_Start(10,
				"Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.",
				test, test1);

		waitForElement(driver, Payment_Method_VIR);
		String Payment_Method_Value_VIR = getText(driver, Payment_Method_VIR);
		System.out.println("Payment_Method_Value_VIR :" + Payment_Method_Value_VIR);

		if (Payment_Method_Value.trim().equalsIgnoreCase(Payment_Method_Value_VIR)) {
			System.out.println("Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_Method_Value
					+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
					+ Payment_Method_Value_VIR);
			Extent_pass(driver,
					"Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_Method_Value
							+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
							+ Payment_Method_Value_VIR,
					test, test1);

			Step_End(10,
					"Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.",
					test, test1);

		} else {
			Step_Start(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

			waitForElement(driver, Payment_Method_VIR);
			click(driver, Payment_Method_VIR);
			formatLocatorClick(driver, DropDown_Select, Payment_method);
			Step_End(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

		}

		if (!Payment_method.isEmpty()) {

			waitForElement(driver, Payment_Method_VIR);
			click(driver, Payment_Method_VIR);
			formatLocatorClick(driver, DropDown_Select, Payment_method);
		}

		if (!Home_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, home_ROE_Textfield_VIR);
			clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
		}

		Step_Start(12, "In the Activity details, Click Activity type dropdown and select the activity type as a 'FDR'",
				test, test1);

		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);

		formatLocatorClick(driver, DropDown_Select, ActivityType);

		Step_End(12, "In the Activity details, Click Activity type dropdown and select the activity type as a 'FDR'",
				test, test1);

		Step_Start(13, "Default system select the FDR sum no", test, test1);

		waitForElement(driver, FDR_Grid_SumNo);
		
		String FDR_Status = getAttribute(driver, FDR_Grid_SumNo, "class");

		if (extractstatus(FDR_Status)) {

			System.out.println(
					"Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is selected as default ");
			Extent_pass(driver,
					"Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is selected as default",
					test, test1);

		} else {

			System.out.println(
					"Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is not selected as default ");
			Extent_fail(driver,
					"Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is not selected as default",
					test, test1);

		}

		Step_End(13, "Default system select the FDR sum no", test, test1);

		Step_Start(14, "Select the Manual activity", test, test1);

		waitForElement(driver, FDR_ManulaActivity);
		click(driver, FDR_ManulaActivity);

		Step_End(14, "Click the Fdr sum no search and select the Required no", test, test1);

		Step_Start(15, "Click the Main activity and select the Required activity", test, test1);

		waitForElement(driver, FDR_Mainactivity);
		click(driver, FDR_Mainactivity);

		twoColumnSearchWindow(driver, MainActivty_Header, Search_condition, Mainactivity_Code);

		Step_End(15, "Click the Main activity and select the Required activity", test, test1);

		Step_Start(16, "Click the 'Sub activity' and select the Required Activity.", test, test1);

		waitForElement(driver, FDR_Subactivity);
		click(driver, FDR_Subactivity);

		twoColumnSearchWindow(driver, SubActivty_Header, Search_condition, Subactivity_Code);

		Step_End(16, "Click the 'Sub activity' and select the Required Activity.", test, test1);

		Step_Start(17, "Click the Eqp Type search and select the Required Eqp Type", test, test1);

		waitForElement(driver, FDR_Eqptype);
		click(driver, FDR_Eqptype);

		twoColumnSearchWindow(driver, Eqp_Header, Search_condition, Eqp_type);

		Step_End(17, "Click the Eqp Type search and select the Required Eqp Type", test, test1);

		Step_Start(18, "Click the POL Port code search and select the Required POL Port code", test, test1);

		if (!POL_PortCode.isEmpty()) {

			waitForElement(driver, FDR_POL);
			click(driver, FDR_POL);

			twoColumnSearchWindow(driver, POL_Header, Search_condition, POL_PortCode);

		}

		Step_End(18, "Click the POL Port code search and select the Required POL Port code", test, test1);

		Step_Start(19, "Click the POD Port code search and select the Required POL Port code", test, test1);

		if (!POD_PortCode.isEmpty()) {

			waitForElement(driver, FDR_POD);
			click(driver, FDR_POD);

			twoColumnSearchWindow(driver, POD_Header, Search_condition, POD_PortCode);

		}

		Step_End(19, "Click the POD Port code search and select the Required POL Port code", test, test1);

		Step_Start(19, "Click the POD Port code search and select the Required POL Port code", test, test1);

		Step_Start(20, "Click the 'ADD' button, Details added in the Grid", test, test1);

		waitForElement(driver, FDR_Manual_Add);
		click(driver, FDR_Manual_Add);

		waitForElement(driver, VIR_Grid_Table);

		reArrangeAG_GridColumns(driver, Filter_Headers);

		waitForDisplay(driver, FDR_Grid1);
		
		if (isdisplayed(driver, FDR_Grid1)) {

			System.out.println(
					"Expected result is : Given details should be added in the grid || Actual result is : Given details are added in the grid");
			Extent_pass(driver,
					"Expected result is : Given details should be added in the grid || Actual result is : Given details are added in the grid",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : Given details should be added in the grid || Actual result is : Given details are not added in the grid");
			Extent_fail(driver,
					"Expected result is : Given details should be added in the grid || Actual result is : Given details are not added in the grid",
					test, test1);
		}

		Step_End(20, "Click the 'ADD' button, Details added in the Grid", test, test1);

		waitForElement(driver, FDR_InvoiceQty);
		doubleClick(driver, FDR_InvoiceQty);
		Newclear(driver, FDR_InvoiceQty);
		Actionsendkeys(driver, FDR_InvoiceQty, Invoice_qty_input);

		waitForElement(driver, FDR_InvoiceAmount);
		doubleClick(driver, FDR_InvoiceAmount);
		Newclear(driver, FDR_InvoiceAmount);
		Actionsendkeys(driver, FDR_InvoiceAmount, Invoice_Amount_input);

		waitForElement(driver, FDR_InvoiceAmount_Homecurrency);
		click(driver, FDR_InvoiceAmount_Homecurrency);

		String Homcurrency_Amount = getText(driver, FDR_InvoiceAmount_Homecurrency);

		if (Invoice_Amount_input.trim().equals(Homcurrency_Amount)) {

			System.out.println("Home currecny amount was updated || Expected value was : " + Invoice_Amount_input
					+ " Actual value was : " + Homcurrency_Amount);
			Extent_pass(driver, "Home currecny amount was updated || Expected value was : " + Invoice_Amount_input
					+ " Actual value was : " + Homcurrency_Amount, test, test1);
		} else {

			System.out.println("Home currecny amount was not updated || Expected value was : " + Invoice_Amount_input
					+ " Actual value was : " + Homcurrency_Amount);
			Extent_fail(driver, "Home currecny amount was not updated || Expected value was : " + Invoice_Amount_input
					+ " Actual value was : " + Homcurrency_Amount, test, test1);
		}

		scrollTop(driver);

		Step_Start(21, "Click the save while in draft", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
		
		
		
		waitForPopup(driver, popup_Message, InvoiceSaved_Popup);

		String actual_popupmessage = getText(driver, popup_Message);

		if (actual_popupmessage.trim().equals(InvoiceSaved_Popup)) {

			System.out.println("Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage);
			Extent_pass(driver, "Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage);
			Extent_fail(driver, "Not Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(21, "Click the save while in draft", test, test1);

		Step_Start(22, "It auto generate the Invoice Reg No", test, test1);

		waitForElement(driver, Vendor_Register_Number_VIR);
		
		String invoice_register_no = getAttribute(driver, Vendor_Register_Number_VIR, "value");

		if (!invoice_register_no.isEmpty()) {

			System.out.println(
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No is autogenerated and the generated no was : "
							+ invoice_register_no);
			Extent_pass(driver,
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No is autogenerated and the generated no was : "
							+ invoice_register_no,
					test, test1);
		} else {
			System.out.println(
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No was not autogenerated");
			Extent_fail(driver,
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No was not autogenerated ",
					test, test1);

		}

		Step_End(22, "It auto generate the Invoice Reg No", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
