package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Receipt_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Receipt",
			"Reference_Name", Testcases.environmentName);

	public static String Customer_Search_button_Receipt = ExcelData.get("Customer_Search_button_Receipt");
	public static String ReceiptDate_Input = ExcelData.get("ReceiptDate_Input");
	public static String Receipt_Filter_Input = ExcelData.get("Receipt_Filter_Input");
	public static String customerName_Textfield = ExcelData.get("customerName_Textfield");
	public static String paymentDetails_Tab = ExcelData.get("paymentDetails_Tab");
	public static String allocate_Button = ExcelData.get("allocate_Button");
	public static String paymentMode_Dropdown = ExcelData.get("paymentMode_Dropdown");
	public static String paymentMode = ExcelData.get("paymentMode");
	public static String paymentMode_Add_Button = ExcelData.get("paymentMode_Add_Button");
	public static String mode_Select = ExcelData.get("mode_Select");
	public static String wire_Transfer_Option = ExcelData.get("wire_Transfer_Option");
	public static String number_Txtfield = ExcelData.get("number_Txtfield");
	public static String bank_Search_Icon = ExcelData.get("bank_Search_Icon");
	public static String bank_Name_Txtfield = ExcelData.get("bank_Name_Txtfield");
	public static String panel_First_Row_Click = ExcelData.get("panel_First_Row_Click");
	public static String deposit_Bank_Search_Icon = ExcelData.get("deposit_Bank_Search_Icon");
	public static String deposit_Bank_Txtfield = ExcelData.get("deposit_Bank_Txtfield");
	public static String add_Payment_Details = ExcelData.get("add_Payment_Details");
	public static String invoiceAndReceipt_Tab = ExcelData.get("invoiceAndReceipt_Tab");
	public static String allocate_Btn = ExcelData.get("allocate_Btn");
	public static String save_btn_Receipt = ExcelData.get("save_btn_Receipt");
	public static String auto_Realise_save_Popup = ExcelData.get("auto_Realise_save_Popup");
	public static String payer_Txtfield = ExcelData.get("payer_Txtfield");
	public static String cust_Name_Txtfield = ExcelData.get("cust_Name_Txtfield");
	public static String payer_Name = ExcelData.get("payer_Name");
	public static String payer_Address = ExcelData.get("payer_Address");
	public static String total_Outstanding_Balance = ExcelData.get("total_Outstanding_Balance");
	public static String invoice_Num_Cell = ExcelData.get("invoice_Num_Cell");
	public static String payment_Details_Tab = ExcelData.get("payment_Details_Tab");
	public static String receipt_Num_Txtfield = ExcelData.get("receipt_Num_Txtfield");
	public static String search_Icon_Cheque_Real = ExcelData.get("search_Icon_Cheque_Real");
	public static String click_Checkbox_With_Receipt_Number = ExcelData.get("click_Checkbox_With_Receipt_Number");
	public static String delete_Btn_Cheque_Real = ExcelData.get("delete_Btn_Cheque_Real");
	public static String reverse_Success_Popup = ExcelData.get("reverse_Success_Popup");
	public static String receipt_Popup = ExcelData.get("receipt_Popup");
	public static String receipt_Remarks_Textarea = ExcelData.get("receipt_Remarks_Textarea");
	public static String receipt_Tab = ExcelData.get("receipt_Tab");
	public static String receipt_Row_CD = ExcelData.get("receipt_Row_CD");
	public static String show_All_Outstanding_Btn = ExcelData.get("show_All_Outstanding_Btn");
	public static String Receipt = ExcelData.get("Receipt");
	public static String receipt_Advance_Button = ExcelData.get("receipt_Advance_Button");
	public static String receipt_Customer_Name = ExcelData.get("receipt_Customer_Name");
	public static String receipt_Address_Field = ExcelData.get("receipt_Address_Field");
	public static String receipt_Payer_Code = ExcelData.get("receipt_Payer_Code");
	public static String receipt_Payer_Name = ExcelData.get("receipt_Payer_Name");
	public static String receipt_Payment_Details_Tab = ExcelData.get("receipt_Payment_Details_Tab");
	public static String receipt_Mode_dropdown = ExcelData.get("receipt_Mode_dropdown");
	public static String receipt_Mode_Select = ExcelData.get("receipt_Mode_Select");
	public static String receipt_Number_TF = ExcelData.get("receipt_Number_TF");
	public static String receipt_Payable_At_Dropdown = ExcelData.get("receipt_Payable_At_Dropdown");
	public static String receipt_Payable_At_Select = ExcelData.get("receipt_Payable_At_Select");
	public static String receipt_Currency_Search_Button = ExcelData.get("receipt_Currency_Search_Button");
	public static String receipt_Currency_Input_Tf = ExcelData.get("receipt_Currency_Input_Tf");
	public static String receipt_Bank_Search_Button = ExcelData.get("receipt_Bank_Search_Button");
	public static String receipt_Bank_Name_TF = ExcelData.get("receipt_Bank_Name_TF");
	public static String value_Select = ExcelData.get("value_Select");
	public static String receipt_Amount_TF = ExcelData.get("receipt_Amount_TF");
	public static String receipt_Roe_TF = ExcelData.get("receipt_Roe_TF");
	public static String receipt_Amount_Fetched_TF = ExcelData.get("receipt_Amount_Fetched_TF");
	public static String receipt_Add_Button = ExcelData.get("receipt_Add_Button");
	public static String receipt_Popup_Ok_Button = ExcelData.get("receipt_Popup_Ok_Button");
	public static String receipt_Num_field = ExcelData.get("receipt_Num_field");
	public static String receipt_Remarks_Field = ExcelData.get("receipt_Remarks_Field");
	public static String receipt_Popup_Yes_Button = ExcelData.get("receipt_Popup_Yes_Button");
	public static String reciept_Button = ExcelData.get("reciept_Button");
	public static String reciept_Popup_Ok = ExcelData.get("reciept_Popup_Ok");
	public static String reciept_Popup_Yes = ExcelData.get("reciept_Popup_Yes");
	public static String reciept_Popup = ExcelData.get("reciept_Popup");
	public static String reciept_Table_Row = ExcelData.get("reciept_Table_Row");
	public static String reciept_Table_Column = ExcelData.get("reciept_Table_Column");
	public static String recieptNo_Textfield = ExcelData.get("recieptNo_Textfield");
	public static String reciept_remarks_TextArea = ExcelData.get("reciept_remarks_TextArea");
	public static String againstInvoice_Button = ExcelData.get("againstInvoice_Button");
	public static String selectedInvoice_Button = ExcelData.get("selectedInvoice_Button");
	public static String selectedInvoice_Add_Button = ExcelData.get("selectedInvoice_Add_Button");
	public static String selectedInvoice_Remove_Button = ExcelData.get("selectedInvoice_Remove_Button");
	public static String selectedInvoice_Show_Button = ExcelData.get("selectedInvoice_Show_Button");
	public static String receipt_Customer_Select = ExcelData.get("receipt_Customer_Select");
	public static String invoiceNumber_InputField = ExcelData.get("invoiceNumber_InputField");
	public static String payer_InputField = ExcelData.get("payer_InputField");
	public static String payerName_InputField = ExcelData.get("payerName_InputField");
	public static String customer_InputField = ExcelData.get("customer_InputField");
	public static String payerAddress_InputField = ExcelData.get("payerAddress_InputField");
	public static String totalOutstandingBalance_InputField = ExcelData.get("totalOutstandingBalance_InputField");
	public static String currency_SearchButton = ExcelData.get("currency_SearchButton");
	public static String currencyCode_Filter = ExcelData.get("currencyCode_Filter");
	public static String amountAED_Textfield = ExcelData.get("amountAED_Textfield");
	public static String roe_Textfield = ExcelData.get("roe_Textfield");
	public static String paymentDetails_Add_Button = ExcelData.get("paymentDetails_Add_Button");
	public static String paymentDetails_Table_Columns = ExcelData.get("paymentDetails_Table_Columns");
	public static String paymentDetails_Table_Rows = ExcelData.get("paymentDetails_Table_Rows");
	public static String import_Invoice = ExcelData.get("import_Invoice");
	public static String DO_Guarantor_Search_Button = ExcelData.get("DO_Guarantor_Search_Button");
	public static String Receipt_Grid = ExcelData.get("Receipt_Grid");
	public static String customerName_Textfield_IMP = ExcelData.get("customerName_Textfield_IMP");
	public static String paymentDetails_Tab_IMP = ExcelData.get("paymentDetails_Tab_IMP");
	public static String paymentMode_Add_Button_IMP = ExcelData.get("paymentMode_Add_Button_IMP");
	public static String CR_click_Checkbox_With_Receipt_Number = ExcelData.get("CR_click_Checkbox_With_Receipt_Number");
	public static String InvoiceAndReceipt_Tab = ExcelData.get("InvoiceAndReceipt_Tab");
	public static String SelectAll_CheckBox_Receipt = ExcelData.get("SelectAll_CheckBox_Receipt");
	public static String OR_Number_Input_Receipt = ExcelData.get("OR_Number_Input_Receipt");
	public static String Invoice_And_Receipt_Grid = ExcelData.get("Invoice_And_Receipt_Grid");
	public static String show_All_Outstanding_Button = ExcelData.get("show_All_Outstanding_Button");
	public static String Receipt_Select_checkbox = ExcelData.get("Receipt_Select_checkbox");
	public static String Receipt_Row = ExcelData.get("Receipt_Row");
	
	public static String Payer_Search_Btn_Receipt = ExcelData.get("Payer_Search_Btn_Receipt");
	public static String Date_Input_Receipt = ExcelData.get("Date_Input_Receipt");
	public static String Proposal_Date_Input_Receipt = ExcelData.get("Proposal_Date_Input_Receipt");
	public static String Remarks_Input_Receipt = ExcelData.get("Remarks_Input_Receipt");
	public static String Excess_Invoice_Number_Receipt = ExcelData.get("Excess_Invoice_Number_Receipt");
	public static String Receipt_Number_Filter = ExcelData.get("Receipt_Number_Filter");
	public static String Receipt_InvoiceNo_checkbox = ExcelData.get("Receipt_InvoiceNo_checkbox");
	
	
	
	public static String Mode_of_Payment_Receipt = ExcelData.get("Mode_of_Payment_Receipt");
	public static String Receipt_Cell_CashDeposit = ExcelData.get("Receipt_Cell_CashDeposit");
	public static String Receipt_Column_DD_Deposit = ExcelData.get("Receipt_Column_DD_Deposit");	
	public static String Invoice_Currency_Receipt = ExcelData.get("Invoice_Currency_Receipt");		
	
	
	
}
