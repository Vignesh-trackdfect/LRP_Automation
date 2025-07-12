package LRP_Import_Invoice_Scripts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Receipt_SC033 extends Keywords {

	public void Receipt_SC033(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Receipt_SC033";
				
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String import_invoice_module_search = Excel_data.get("import_invoice_module_search");
		String Global_search_value_Bl_Number = Excel_data.get("Global_search_value_Bl_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String Module_Receipt = Excel_data.get("Module_Receipt");
		String buttonStatus = Excel_data.get("buttonStatus");
		String globalSearchFilterOption_1 = Excel_data.get("GlobalSearchFilterOption_1");
		String globalSearchFilterOption_2 = Excel_data.get("GlobalSearchFilterOption_2");
		String globalSearchFilterOption_3 = Excel_data.get("GlobalSearchFilterOption_3");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String InvoiceColumns = Excel_data.get("InvoiceColumns");
		String Receipt_Table_Name1 = Excel_data.get("Receipt_Table_Name1");
		String payment_Mode = Excel_data.get("PaymentMode");
		String currencyCode = Excel_data.get("CurrencyCode");
		String amount = Excel_data.get("Amount");
		String paymentDetail_Columns = Excel_data.get("PaymentDetail_Columns");
		String paymentDetails_Table_Name = Excel_data.get("PaymentDetails_Table_Name");
		String receiptSavedPopup = Excel_data.get("ReceiptSavedPopup");
		String greenColorCode = Excel_data.get("GreenColorCode");
		String enterRemarksPopup = Excel_data.get("EnterRemarksPopup");
		String receiptRemark = Excel_data.get("ReceiptRemark");
		String wantToDeletePopup = Excel_data.get("WantToDeletePopup");
		String cancelledPopup = Excel_data.get("CancelledPopup");
		String redColorCode = Excel_data.get("RedColorCode");
		String Cheque_module = Excel_data.get("Cheque_module");
		String Global_search_value_Receipt_No = Excel_data.get("Global_search_value_Receipt_No");
		String Condition = Excel_data.get("Condition");
		String reset_Popup_Expected = Excel_data.get("Reset_Popup").trim();
		String reversed_successful_Expected = Excel_data.get("reversed_successful_Popup").trim();
		String deposit_bank = Excel_data.get("deposit_bank");
		String number_data = Excel_data.get("number_data");
		String bankname = Excel_data.get("bankname");
		String roe_diff_data = Excel_data.get("roe_diff_data");
		String roe_cny_data = Excel_data.get("roe_cny_data");
		String BankName_Header = Excel_data.get("BankName_Header");
		String Currency_Header = Excel_data.get("Currency_Header");
		String DepositBankName_Header = Excel_data.get("DepositBankName_Header");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");

		String Invoice_Reversel_Module = Excel_data.get("Invoice_Reversel_Module");
		String Reversal_Filter_Type = Excel_data.get("Reversal_Filter_Type");
		String Reversal_Condition = Excel_data.get("Reversal_Condition");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");
	
		String Payer_Code_SearchType = Excel_data.get("Payer_Code_SearchType");
		String Payer_Code_Value = Excel_data.get("Payer_Code_Value");
		String Date_Value_Receipt = Excel_data.get("Date_Value_Receipt");
		String Proposed_Date_Receipt = Excel_data.get("Proposed_Date_Receipt");
		String Receipt_Remarks = Excel_data.get("Receipt_Remarks");
		String Excess_Invo_No = Excel_data.get("Excess_Invo_No");

		
		String delete_Receipt = Excel_data.get("delete_Receipt");
		String Cannot_Cancel_Receipt_Popup = Excel_data.get("Cannot_Cancel_Receipt_Popup");

		String Cash_Deposit_Module = Excel_data.get("Cash_Deposit_Module");
		String Cash_Deposit_delete_Popup1 = Excel_data.get("Cash_Deposit_delete_Popup1");
		String Cash_Deposit_Delete_Popup2 = Excel_data.get("Cash_Deposit_Delete_Popup2");

		String Cheque_DD_Deposit_Module = Excel_data.get("Cheque_DD_Deposit_Module");
		String DD_Deposit_delete_Popup1 = Excel_data.get("DD_Deposit_delete_Popup1");
		String DD_Deposit_Delete_Popup2 = Excel_data.get("DD_Deposit_Delete_Popup2");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		// Switch Agency
		verifyMainMenu(driver);
		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);
		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, ".open the import invoice module .", test, test1);

		moduleNavigate(driver, import_invoice_module_search);

		Step_End(2, ".open the import invoice module .", test, test1);

		Step_Start(3, "click the new button", test, test1);

		newButton(driver);

		Step_End(3, "click the new button", test, test1);

		Extent_call(test, test1, "creating the invoice starts");
		waitForDisplay(driver, By_BL_Number_Btn);
		click(driver, By_BL_Number_Btn);
		waitForElement(driver, bl_Search_Button_IN);
		click(driver, bl_Search_Button_IN);

		globalValueSearchWindow(driver, Customer_Filter_Condition, Global_search_value_Bl_Number, BL_Num, "", "", "",
				"");
		

		if(isdisplayed(driver, popup_Message)) {
		waitForDisplay(driver, popup_Message);
		String act_Popup=getText(driver, popup_Message);
		if(Part_Lot_BL_Popup.equals(act_Popup)) {
			System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
			Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
			
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
			
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
			 act_Popup=getText(driver, popup_Message);
			if(Charges_Popup.equals(act_Popup)) {
				System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
				Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				jsClick(driver, popup_Message_Ok_Button);
				waitForDisplay(driver, popup_Up_Ok);
				if(isdisplayed(driver, popup_Up_Ok)) {
					waitForElement(driver, popup_Up_Ok);
					jsClick(driver, popup_Up_Ok);
			}
			}
		}
		}
		else if(Charges_Popup.equals(act_Popup)) {
			System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
			Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			if(isdisplayed(driver, Popup_Message)) {
				waitForElement(driver, popup_Up_Ok);
				click(driver, popup_Up_Ok);
		}
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
			 act_Popup=getText(driver, popup_Message);
		if(Part_Lot_BL_Popup.equals(act_Popup)) {
			System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
			Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
			}
		}
		
	}

		waitForElement(driver, issued_Button);
		click(driver, issued_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Invoice_Table_Header_All);
		List<Map<String, String>> invoice_Table_Data = getTableData(driver, Invoice_Table_Header_All,
				Invoice_Table_Row_All);
		String inv_number = getFirstValueByHeader(invoice_Table_Data, "Inv Number");
		
		String customer_code_imp = getFirstValueByHeader(invoice_Table_Data, "System Code");   //getAttribute(driver, cust_code_field, "value");
		String customer_name_field = getFirstValueByHeader(invoice_Table_Data, "Customer Name");  //getAttribute(driver, cust_code_name_field, "value");

		System.out.println("the customer code is: " + customer_code_imp);
		System.out.println("the customer name is: " + customer_name_field);

		moduleNavigate(driver, Module_Receipt);

//		Receipt
		Extent_cal(test, test1, Module_Receipt);
		Step_Start(3, "click the new button", test, test1);

		newButton(driver);

		Step_End(3, "click the new button", test, test1);

		Step_Start(4, "receipt mode automatically selected against invoice option", test, test1);

		waitForElement(driver, againstInvoice_Button);
		String actualStatus = getAttribute(driver, againstInvoice_Button, "class");

		if (actualStatus.contains(buttonStatus)) {
			System.out.println(
					"Matched || Expected result is : Receipt mode should be automatically selected || Actual result is : Receipt mode automatically selected against invoice option");
			Extent_pass_New(driver,
					"Matched || Expected result is : Receipt mode should be automatically selected || Actual result is : Receipt mode automatically selected against invoice option",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is : Receipt mode should be automatically selected || Actual result is : Receipt mode not automatically selected against invoice option");
			Extent_fail(driver,
					"Not Matched || Expected result is : Receipt mode should be automatically selected || Actual result is : Receipt mode not automatically selected against invoice option",
					test, test1);
		}

		Step_End(4, "receipt mode automatically selected against invoice option", test, test1);

		Step_Start(5, "select the select invoice option in receipt by", test, test1);

		waitForDisplay(driver, selectedInvoice_Button);
		click(driver, selectedInvoice_Button);

		Step_End(5, "select the select invoice option in receipt by", test, test1);
		Step_Start(6, "once selected the selected invoice option\r\n add ,remove and show button has enable ", test,
				test1);

		waitForDisplay(driver, selectedInvoice_Add_Button);
		if (isElementAccessible(driver, selectedInvoice_Add_Button)) {
			System.out.println(
					"Pass || Expected result is : Once selected the selected invoice option, Add button should be enabled || Actual result is : Once selected the selected invoice option, Add button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Once selected the selected invoice option, Add button should be enabled || Actual result is : Once selected the selected invoice option, Add button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Once selected the selected invoice option, Add button should be enabled || Actual result is : Once selected the selected invoice option, Add button is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : Once selected the selected invoice option, Add button should be enabled || Actual result is : Once selected the selected invoice option, Add button is disabled",
					test, test1);
		}

		if (isElementAccessible(driver, selectedInvoice_Remove_Button)) {
			System.out.println(
					"Pass || Expected result is : Once selected the selected invoice option, Remove button should be enabled || Actual result is : Once selected the selected invoice option, Remove button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Once selected the selected invoice option, Remove button should be enabled || Actual result is : Once selected the selected invoice option, Remove button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Once selected the selected invoice option, Remove button should be enabled || Actual result is : Once selected the selected invoice option, Remove button is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : Once selected the selected invoice option, Remove button should be enabled || Actual result is : Once selected the selected invoice option, Remove button is disabled",
					test, test1);
		}

		if (isElementAccessible(driver, selectedInvoice_Show_Button)) {
			System.out.println(
					"Pass || Expected result is : Once selected the selected invoice option, Show button should be enabled || Actual result is : Once selected the selected invoice option, Show button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : Once selected the selected invoice option, Show button should be enabled || Actual result is : Once selected the selected invoice option, Show button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Once selected the selected invoice option, Show button should be enabled || Actual result is : Once selected the selected invoice option, Show button is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : Once selected the selected invoice option, Show button should be enabled || Actual result is : Once selected the selected invoice option, Show button is disabled",
					test, test1);
		}

		Step_End(6, "once selected the selected invoice option\r\n add ,remove and show button has enable ", test,
				test1);
		Step_Start(7, "select the customer in customer name field", test, test1);

		waitForElement(driver, receipt_Customer_Name_SearchBtn);
		click(driver, receipt_Customer_Name_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, globalSearchFilterOption_1, customer_name_field,
				globalSearchFilterOption_2, customer_code_imp, globalSearchFilterOption_3, "");

		Step_End(7, "select the customer in customer name field", test, test1);

		Step_Start(8, "invoice number field automatically fetched invoice number based on customer", test, test1);

		waitForElement(driver, invoiceNumber_InputField);

		Step_End(8, "invoice number field automatically fetched invoice number based on customer", test, test1);

		Step_Start(9, "click the show button", test, test1);

		waitForElement(driver, selectedInvoice_Show_Button);
		click(driver, selectedInvoice_Show_Button);

		Step_End(9, "click the show button", test, test1);
		Step_Start(10,
				"customer details has to be shown in payer ,payername ,customer ,payer address and total outstanding balance showing in total outstanding balance.",
				test, test1);

		waitForElement(driver, payer_InputField);

		String actualPayer = getAttribute(driver, payer_InputField, "value");
		String actualPayerName = getAttribute(driver, payerName_InputField, "value");
		String actualCustomer = getAttribute(driver, customer_InputField, "value");
		String actualPayerAddress = getText(driver, payerAddress_InputField);
		String actualTotalOutstanding = getAttribute(driver, totalOutstandingBalance_InputField, "value");

		
		if(!Payer_Code_Value.trim().equals("")) {
			waitForElement(driver, Payer_Search_Btn_Receipt);
			click(driver,Payer_Search_Btn_Receipt);
			
			globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Payer_Code_SearchType, Payer_Code_Value,
					"", "", "", "");
			
		}
		
		
		if (!actualPayer.equals("")) {
			System.out.println(
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are shown || Actual Payer is : "
							+ actualPayer);
			Extent_pass_New(driver,
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are shown || Actual Payer is : "
							+ actualPayer,
					test, test1);
		} else {
			System.out.println(
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are not shown || Actual Payer is : "
							+ actualPayer);
			Extent_fail(driver,
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are not shown || Actual Payer is : "
							+ actualPayer,
					test, test1);
		}

		if (!actualPayerName.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is shown || Actual Payer Name : "
							+ actualPayerName);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is shown || Actual Payer Name : "
							+ actualPayerName,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is not shown || Actual Payer Name : "
							+ actualPayerName);
			Extent_fail(driver,
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is not shown || Actual Payer Name : "
							+ actualPayerName,
					test, test1);
		}

		if (!actualCustomer.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was shown || Actual Customer : "
							+ actualCustomer);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was shown || Actual Customer : "
							+ actualCustomer,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was not shown || Actual Customer : "
							+ actualCustomer);
			Extent_fail(driver,
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was not shown || Actual Customer : "
							+ actualCustomer,
					test, test1);
		}

		if (!actualPayerAddress.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was shown || Actual Payer Addrress : "
							+ actualPayerAddress);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was shown || Actual Payer Addrress : "
							+ actualPayerAddress,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was not shown || Actual Payer Addrress : "
							+ actualPayerAddress);
			Extent_fail(driver,
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was not shown || Actual Payer Addrress : "
							+ actualPayerAddress,
					test, test1);
		}

		if (!actualTotalOutstanding.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer,Total outstanding should be shown || Actual result is : After selected the customer, Total outstanding was shown || Actual Total outstanding : "
							+ actualTotalOutstanding);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer,Total outstanding should be shown || Actual result is : After selected the customer, Total outstanding was shown || Actual Total outstanding : "
							+ actualTotalOutstanding,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer,Total outstanding should be shown || Actual result is : After selected the customer, Total outstanding was not shown || Actual Total outstanding : "
							+ actualTotalOutstanding);
			Extent_fail(driver,
					"Expected result is :  After selected the customer,Total outstanding should be shown || Actual result is : After selected the customer, Total outstanding was not shown || Actual Total outstanding : "
							+ actualTotalOutstanding,
					test, test1);
		}

		Step_End(10,
				"customer details has to be shown in payer ,payername ,customer ,payer address and total outstanding balance showing in total outstanding balance.",
				test, test1);
		Step_Start(11, "go to the invoice and receipts column that customer based invoice details has shown", test,
				test1);

		waitForElement(driver, InvoiceAndReceipt_Tab);
		click(driver, InvoiceAndReceipt_Tab);

		waitForElement(driver, reciept_Table_Row);

		List<Map<String, String>> invoicesAndReceipt_Table = getTableData(driver, reciept_Table_Column,
				reciept_Table_Row);

		List<String> invoiceColumnHeaders = splitAndExpand(InvoiceColumns);

		String receipt_Table_data = TableDataForReport(driver, invoicesAndReceipt_Table, Receipt_Table_Name1,
				invoiceColumnHeaders);

		if (isDisplayed(driver, reciept_Table_Row)) {

			System.out.println(
					"Pass || Expected result is : Invoice details should show in the Invoice and receipts column || Actual result is : Invoice details are shown in the Invoice and receipts column");
			Extent_pass_New(driver,
					"Pass || Expected result is : Invoice details should show in the Invoice and receipts column || Actual result is : Invoice details are shown in the Invoice and receipts column",
					test, test1);
			Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" + receipt_Table_data + "</pre>", test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Invoice details should show in the Invoice and receipts column || Actual result is : Invoice details are not shown in the Invoice and receipts column");
			Extent_fail(driver,
					"Fail || Expected result is : Invoice details should show in the Invoice and receipts column || Actual result is : Invoice details are not shown in the Invoice and receipts column",
					test, test1);

		}

		Step_End(11, "go to the invoice and receipts column that customer based invoice details has shown", test,
				test1);
		Step_Start(12, "go to the payment details", test, test1);

		waitForElement(driver, paymentDetails_Tab);
		click(driver, paymentDetails_Tab);

		Step_End(12, "go to the payment details", test, test1);
		Step_Start(13, "select the cash mode in dropdownfield", test, test1);

		if(!payment_Mode.trim().equals("")) {
			waitForElement(driver, paymentMode_Dropdown);
			click(driver, paymentMode_Dropdown);
			String select_Mode = String.format(paymentMode, payment_Mode);
			waitForDisplay(driver, select_Mode);
			click(driver, select_Mode);
		}
		

		Step_End(13, "select the cash mode in dropdownfield", test, test1);
		Step_Start(14, "other field are disable except following fields", test, test1);

		waitForElement(driver, amount_Textfield);
		if (isElementAccessible(driver, amount_Textfield)) {
			System.out.println(
					"Pass || Expected result is : After select the cash mode, Amount field should be enabled || Actual result is : After select the cash mode, Amount field is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : After select the cash mode, Amount field should be enabled || Actual result is : After select the cash mode, Amount field is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : After select the cash mode, Amount field should be enabled || Actual result is : After select the cash mode, Amount field is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : After select the cash mode, Amount field should be enabled || Actual result is : After select the cash mode, Amount field is not enabled",
					test, test1);
		}

		if (isElementAccessible(driver, currency_SearchButton)) {
			System.out.println(
					"Pass || Expected result is : After select the cash mode, Currency search button should be enabled || Actual result is : After select the cash mode, Currency search button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : After select the cash mode, Currency search button should be enabled || Actual result is : After select the cash mode, Currency search button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : After select the cash mode, Currency search button should be enabled || Actual result is : After select the cash mode, Currency search button is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : After select the cash mode, Currency search button should be enabled || Actual result is : After select the cash mode, Currency search button is not enabled",
					test, test1);
		}

		Step_End(14, "other field are disable except following fields", test, test1);
		Step_Start(15, "select the currency", test, test1);
		
		if(!Excess_Invo_No.trim().equals("")) {
			waitForElement(driver, Excess_Invoice_Number_Receipt);
			click(driver,Excess_Invoice_Number_Receipt);
			formatLocatorClick(driver, DropDown_Select, Excess_Invo_No);
		}
		
		if(!Date_Value_Receipt.trim().equals("")) {
			waitForElement(driver, Date_Input_Receipt);
			click(driver,Date_Input_Receipt);
			try {
				selectDateInCalender(driver,Date_Value_Receipt,Date_Text_Value,Month_Text_Value,Year_Text_Value,previous_Button_DatePicker,next_Button_DatePicker);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(!Proposed_Date_Receipt.trim().equals("")) {
			waitForElement(driver, Proposal_Date_Input_Receipt);
			click(driver,Proposal_Date_Input_Receipt);
			try {
				selectDateInCalender(driver,Proposed_Date_Receipt,Date_Text_Value,Month_Text_Value,Year_Text_Value,previous_Button_DatePicker,next_Button_DatePicker);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// currency
		if (!currencyCode.trim().equals("")) {
			click(driver, currency_SearchButton);

			twoColumnSearchWindow(driver, Currency_Header, Condition, currencyCode);

		}
		Step_End(15, "select the currency", test, test1);

		// amount
		Step_Start(16, "enter the amount", test, test1);

		if (!amount.equals("")) {
			waitForElement(driver, amount_Textfield);
			click(driver, amount_Textfield);
			waitForElement(driver, amount_Textfield);
			clearAndType(driver, amount_Textfield, amount);
			waitForElement(driver, amount_Textfield);
			click(driver, payer_InputField);

		}

		// number data

		if (!number_data.equals("")) {
			waitForElement(driver, number_data_txtfld);
			click(driver, number_data_txtfld);
			waitForElement(driver, number_data_txtfld);
			clearAndType(driver, number_data_txtfld, number_data);

		}

		// bank
		if (!bankname.equals("")) {
			waitForElement(driver, bank_Search_Icon);
			click(driver, bank_Search_Icon);

			twoColumnSearchWindow(driver,BankName_Header , Condition, bankname);
		}

		// deposit bank
		if (!deposit_bank.equals("")) {
			// deposit bank
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);

			twoColumnSearchWindow(driver, DepositBankName_Header, Condition, deposit_bank);

		}
// roe diff
		if (!roe_diff_data.equals("")) {

			waitForElement(driver, roe_diff_txtfld);
			sendKeys(driver, roe_diff_txtfld, roe_diff_data);
		}

		if(!Receipt_Remarks.trim().equals("")) {
			
			waitForElement(driver, Remarks_Input_Receipt);
			sendKeys(driver, Remarks_Input_Receipt, Receipt_Remarks);
			
		}

		// roe cny
		if (!roe_cny_data.equals("")) {

			waitForElement(driver, roe_charges_in_cny);
			sendKeys(driver, roe_charges_in_cny, roe_cny_data);
		}

		Step_End(16, "enter the amount", test, test1);
		Step_Start(17, "once select the currency roe field roe has automatically fetched", test, test1);

		waitForElement(driver, roe_Textfield);
		String actual_ROE = getAttribute(driver, roe_Textfield, "value");
		if (!actual_ROE.equals("")) {
			System.out.println(
					"Pass || Expected result is : After select the cash mode, ROE Text field should be enabled || Actual result is : After select the cash mode, ROE Text field is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : After select the cash mode, ROE Text field should be enabled || Actual result is : After select the cash mode, ROE Text field is enabled",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : After select the cash mode, ROE Text field should be enabled || Actual result is : After select the cash mode, ROE Text field is not enabled");
			Extent_fail(driver,
					"Fail || Expected result is : After select the cash mode, ROE Text field should be enabled || Actual result is : After select the cash mode, ROE Text field is not enabled",
					test, test1);
		}

		Step_End(17, "once select the currency roe field roe has automatically fetched", test, test1);
		Step_Start(18, "amount field value has shown , automatically amount fetced based on amount * roe", test, test1);

//	Amount * ROE

		String act_Amount = getAttribute(driver, amountAED_Textfield, "value");
		String actual_Amount = act_Amount.replace(",", "");
		String actualAmount = getAttribute(driver, amount_Textfield, "value");
		String actualROE = getAttribute(driver, roe_Textfield, "value");

		double actAmount = Double.parseDouble(actualAmount);
		double actROE = Double.parseDouble(actualROE);
		System.out.println("actAmount : " + actAmount);
		System.out.println("actROE : " + actROE);

		double exp_Amount = actAmount * actROE;

		System.out.println("exp_Amount : " + exp_Amount);

		BigDecimal bigDecimal = new BigDecimal(exp_Amount).setScale(2, RoundingMode.HALF_UP);
		String expected_Amount = bigDecimal.toString();
		System.out.println(expected_Amount);

		if (actual_Amount.equals(expected_Amount)) {
			System.out.println("Matched || Automatically amount fetced based on amount * roe || Expected Amount : "
					+ expected_Amount + " || Actual Amount : " + actual_Amount);
			Extent_pass_New(driver, "Matched || Automatically amount fetced based on amount * roe || Expected Amount : "
					+ expected_Amount + " || Actual Amount : " + actual_Amount, test, test1);
		} else {
			System.out.println(
					"Not Matched || Automatically amount not fetced based on amount * roe || Expected Amount : "
							+ expected_Amount + " || Actual Amount : " + actual_Amount);
			Extent_fail(driver,
					"Not Matched || Automatically amount not fetced based on amount * roe || Expected Amount : "
							+ expected_Amount + " || Actual Amount : " + actual_Amount,
					test, test1);
		}

		Step_End(18, "amount field value has shown , automatically amount fetced based on amount * roe", test, test1);
		Step_Start(19, "click the add button ", test, test1);

		waitForElement(driver, paymentDetails_Add_Button);
		click(driver, paymentDetails_Add_Button);

		Step_End(19, "click the add button ", test, test1);
		Step_Start(20, "once added the payment,below grid value has shown.", test, test1);

		waitForElement(driver, paymentDetails_Table_Rows);

		List<Map<String, String>> paymentDetails_Table = getTableData(driver, paymentDetails_Table_Columns,
				paymentDetails_Table_Rows);

		List<String> paymentDetailsColumnHeaders = splitAndExpand(paymentDetail_Columns);

		String paymentDetails_Table_data = TableDataForReport(driver, paymentDetails_Table, paymentDetails_Table_Name,
				paymentDetailsColumnHeaders);

		if (isDisplayed(driver, paymentDetails_Table_Rows)) {
			System.out.println(
					"Pass || Expected result is : once added the payment, Payment details should show in the grid || Actual result is : once added the payment, Payment details are showing in the grid");
			Extent_pass_New(driver,
					"Pass || Expected result is : once added the payment, Payment details should show in the grid || Actual result is : once added the payment, Payment details are showing in the grid",
					test, test1);
			Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" + paymentDetails_Table_data + "</pre>", test,
					test1);
		} else {
			System.out.println(
					"Fail || Expected result is : once added the payment, Payment details should show in the grid || Actual result is : once added the payment, Payment details are not showing in the grid");
			Extent_fail(driver,
					"Fail || Expected result is : once added the payment, Payment details should show in the grid || Actual result is : once added the payment, Payment details are not showing in the grid",
					test, test1);

		}

		Step_End(20, "once added the payment,below grid value has shown.", test, test1);
		Step_Start(21, ".go to the invoice and receipts column", test, test1);

		waitForElement(driver, InvoiceAndReceipt_Tab);
		click(driver, InvoiceAndReceipt_Tab);

		Step_End(21, ".go to the invoice and receipts column", test, test1);
		Step_Start(22, "click the select all button", test, test1);

		waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
		checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");

		Step_End(22, "click the select all button", test, test1);
		Step_Start(23, "select the allocate buttton ", test, test1);

		waitForElement(driver, allocate_Button);
		click(driver, allocate_Button);

		Step_End(23, "select the allocate buttton ", test, test1);
		Step_Start(24, "click the save button in tool bar", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(24, "click the save button in tool bar", test, test1);

		Step_Start(25, "system has validate --Receipt saved\r\n Ok", test, test1);

		waitForPopup(driver, popup_Message,receiptSavedPopup);
		String actualSavedPopup = getText(driver, popup_Message);
		if (actualSavedPopup.equals(receiptSavedPopup)) {
			System.out.println(
					"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup,
					test, test1);
			click(driver, reciept_Popup_Ok);
		} else {
			System.out.println("Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : "
					+ actualSavedPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : "
					+ actualSavedPopup, test, test1);
		}
		

		Step_End(25, "system has validate --Receipt saved\r\n Ok", test, test1);

		Extent_call(test, test1, "-------------------verify------------------------");
		Step_Start(26, "Receipt number field -newly receipt number generated and showing green color", test, test1);

		waitForElement(driver, recieptNo_Textfield);
		String actual_Receipt = getAttribute(driver, recieptNo_Textfield, "value");
		String actualColor_hex = getTextBackgroundColor(driver, recieptNo_Textfield);

		if (!actual_Receipt.equals("")) {
			System.out.println(
					"Matched || Expected result is || Receipt number should be generated || Actual result is : Receipt number generated || Generated Receipt Number : "
							+ actual_Receipt);
			Extent_pass_New(driver,
					"Matched || Expected result is || Receipt number should be generated || Actual result is : Receipt number generated || Generated Receipt Number : "
							+ actual_Receipt,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is || Receipt number should be generated || Actual result is : Receipt number not generated || Generated Receipt Number : "
							+ actual_Receipt);
			Extent_fail(driver,
					"Not Matched || Expected result is || Receipt number should be generated || Actual result is : Receipt number not generated || Generated Receipt Number : "
							+ actual_Receipt,
					test, test1);
		}

		String color_actual = getColorName(actualColor_hex);

		if (color_actual.equalsIgnoreCase(greenColorCode)) {
			System.out.println("Newly generated receipt numbers showing in expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + color_actual);
			Extent_pass_New(driver, "Newly generated receipt numbers showing in expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + color_actual, test, test1);
		} else {
			System.out.println(
					"Newly generated receipt numbers are not showing in expected color || Expected color was : "
							+ greenColorCode + " || Actual color was : " + color_actual);
			Extent_fail(driver,
					"Newly generated receipt numbers are not showing in expected color || Expected color was : "
							+ greenColorCode + " || Actual color was : " + color_actual,
					test, test1);
		}

		Step_End(26, "Receipt number field -newly receipt number generated and showing green color", test, test1);
		String retrieved_Receipt_Number = getAttribute(driver, receipt_Num_Txtfield, "value");
		waitForElement(driver, Mode_of_Payment_Receipt);
		String ReceiptMode=getText(driver, Mode_of_Payment_Receipt);
		
		Step_Start(27, "once saved the receipt ,tool bar delete button has enable.", test, test1);

		
		if(delete_Receipt.equalsIgnoreCase("Yes")) {
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			waitForElement(driver, popup_Message);
			String PoupValue=getText(driver, popup_Message);
			if(PoupValue.contains(Cannot_Cancel_Receipt_Popup)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				if(ReceiptMode.equalsIgnoreCase("Cash")) {
					DeleteReceiptInCashDeposit(driver,Cash_Deposit_Module,GlobalSearchDropdownCondition,Global_search_value_Receipt_No,retrieved_Receipt_Number,Cash_Deposit_delete_Popup1,Cash_Deposit_Delete_Popup2);
				}else if (ReceiptMode.equalsIgnoreCase("Wire Transfer")) {
					DeleteReceiptInChequeRealization(driver,Cheque_module,GlobalSearchDropdownCondition,Global_search_value_Receipt_No,retrieved_Receipt_Number,reset_Popup_Expected,reversed_successful_Expected);
				}else if(ReceiptMode.equalsIgnoreCase("Cheque")) {
					DeleteReceiptInDD_Deposit(driver,Cheque_DD_Deposit_Module,GlobalSearchDropdownCondition,Global_search_value_Receipt_No,retrieved_Receipt_Number,DD_Deposit_delete_Popup1,DD_Deposit_Delete_Popup2);
				}				
			}else {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
			}
			
			waitForDisplay(driver, Delete_button_toolBar);
			if (isElementAccessible(driver, Delete_button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled",
						test, test1);
			}
			Step_End(27, "once saved the receipt ,tool bar delete button has enable.", test, test1);
			Step_Start(28, "click the delete button -system has validate -enter the remarks", test, test1);

			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, enterRemarksPopup);

			String actEnterRemarks_popup = getText(driver, popup_Message);

			if (actEnterRemarks_popup.equals(enterRemarksPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);

				Step_End(28, "click the delete button -system has validate -enter the remarks", test, test1);
				Step_Start(29, "click ok", test, test1);

				click(driver, reciept_Popup_Ok);

				Step_End(29, "click ok", test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);

			}

			Step_Start(30, "enter the remarks ", test, test1);

			waitForElement(driver, reciept_remarks_TextArea);
			sendKeys(driver, reciept_remarks_TextArea, receiptRemark);

			Step_End(30, "enter the remarks ", test, test1);
			Step_Start(31, "click the delete buton", test, test1);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			Step_End(31, "click the delete buton", test, test1);
			Step_Start(32, "system has validate - Are you sure you want to delete ? \r\n No Yes", test, test1);

			waitForPopup(driver, popup_Message, wantToDeletePopup);

			String actWantToDelete_popup = getText(driver, popup_Message);
			if (actWantToDelete_popup.equals(wantToDeletePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);

				Step_End(32, "system has validate - Are you sure you want to delete ? \r\n No Yes", test, test1);
				Step_Start(33, "click the yes button", test, test1);

				click(driver, reciept_Popup_Yes);

				Step_End(33, "click the yes button", test, test1);

			} else {
				System.out.println("Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);

			}

			Step_Start(34, "Receipt cancelled-receipt no showing red color", test, test1);

			waitForPopup(driver, popup_Message, cancelledPopup);

			String actDeleted_popup = getText(driver, popup_Message);
			if (actDeleted_popup.equals(cancelledPopup)) {
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);
				System.out.println(
						"Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup);
				click(driver, reciept_Popup_Ok);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);

			}

			waitForElement(driver, recieptNo_Textfield);
			String actualCancelledColor = getTextBackgroundColor(driver, recieptNo_Textfield);
	           System.out.println(actualCancelledColor);

			String actual_cancel_color = getColorName(actualCancelledColor);
			System.out.println(actual_cancel_color);
			if (actual_cancel_color.equalsIgnoreCase(redColorCode)) {
				System.out.println("Canceled receipt numbers showing in expected color || Expected color was : "
						+ redColorCode + " || Actual color was : " + actual_cancel_color);
				Extent_pass_New(driver, "Canceled receipt numbers showing in expected color || Expected color was : "
						+ redColorCode + " || Actual color was : " + actual_cancel_color, test, test1);
			} else {
				System.out.println("Canceled receipt numbers are not showing as expected color || Expected color was : "
						+ redColorCode + " || Actual color was : " + actual_cancel_color);
				Extent_fail(driver,
						"Canceled receipt numbers are not showing as expected color || Expected color was : "
								+ redColorCode + " || Actual color was : " + actual_cancel_color,
						test, test1);
			}

			Step_End(34, "Receipt cancelled-receipt no showing red color", test, test1);

		
			Invoice_Reversal(driver,Invoice_Reversel_Module,Reversal_Condition,Reversal_Filter_Type,inv_number,Invoice_Reversal_Remark,Invoice_Reversal_Success);

		}
		
		Extent_completed(testcase_Name, test, test1);

	}

}
