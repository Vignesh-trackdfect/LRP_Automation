package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Receipt_SC034 extends Keywords {

	public void Receipt_SC034(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Receipt_SC034";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Receipt_Module = Excel_data.get("Receipt_Module");
		String Module_ImportInvoice = Excel_data.get("Module_ImportInvoice");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Invoice_Table_Headers = Excel_data.get("Invoice_Table_Headers");
		String globalSearchFilterOption_Receipt = Excel_data.get("globalSearchFilterOption_Receipt");
		String Mode_Select = Excel_data.get("Mode_Select");
		String Number_Input = Excel_data.get("Number_Input");
		String Bank_Name_Input = Excel_data.get("Bank_Name_Input");
		String conditionFilter = Excel_data.get("conditionFilter");
		String deposit_bank = Excel_data.get("deposit_bank");
		String Cheque_module = Excel_data.get("Cheque_module");
		String Global_search_value_Receipt_No = Excel_data.get("Global_search_value_Receipt_No");
		String reset_Popup_Expected = Excel_data.get("reset_Popup_Expected").trim();
		String reversed_successful_Expected = Excel_data.get("reversed_successful_Expected").trim();
		String Global_search_value_Receipt_Number = Excel_data.get("Global_search_value_Receipt_Number");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String Select_search_value_Reversal = Excel_data.get("Select_search_value_Reversal");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String BankName_Header = Excel_data.get("BankName_Header");
		String DepositBankName_Header = Excel_data.get("DepositBankName_Header");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String receipt_Status_Filer_Data = Excel_data.get("receipt_Status_Filer_Data");
		String BL_Filter_Type1 = Excel_data.get("BL_Filter_Type1");
		String currency_Value = Excel_data.get("currency_Value");
		String Currency_Header = Excel_data.get("Currency_Header");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");

		String Payer_Code_SearchType = Excel_data.get("Payer_Code_SearchType");
		String Payer_Code_Value = Excel_data.get("Payer_Code_Value");
		String Date_Value_Receipt = Excel_data.get("Date_Value_Receipt");
		String Proposed_Date_Receipt = Excel_data.get("Proposed_Date_Receipt");
		String Excess_Invo_No = Excel_data.get("Excess_Invo_No");
		String Receipt_Remarks = Excel_data.get("Receipt_Remarks");

		
		String Cannot_Cancel_Receipt_Popup = Excel_data.get("Cannot_Cancel_Receipt_Popup");
		String enter_remarks_Exp = Excel_data.get("enter_remarks_Exp");
		String Delete_Remark_Value_Receipt = Excel_data.get("Delete_Remark_Value_Receipt");
		String WantToDeletePopup = Excel_data.get("WantToDeletePopup");
		String CancelledPopup = Excel_data.get("CancelledPopup");
		
		String Cash_Deposit_Module = Excel_data.get("Cash_Deposit_Module");
		String Cash_Deposit_delete_Popup1 = Excel_data.get("Cash_Deposit_delete_Popup1");
		String Cash_Deposit_Delete_Popup2 = Excel_data.get("Cash_Deposit_Delete_Popup2");

		String Cheque_DD_Deposit_Module = Excel_data.get("Cheque_DD_Deposit_Module");
		String DD_Deposit_delete_Popup1 = Excel_data.get("DD_Deposit_delete_Popup1");
		String DD_Deposit_Delete_Popup2 = Excel_data.get("DD_Deposit_Delete_Popup2");
		
		String Currency_Header_Receipt = Excel_data.get("Currency_Header_Receipt");		
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		// Login
		LRP_Login(driver, Username, Password);

		// Switch Agency
		verifyMainMenu(driver);

		Step_Start(1, "switch to agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "switch to agency ", test, test1);
		List<String> deposit_banks = splitAndExpand(deposit_bank, ",");
		List<String> banknames = splitAndExpand(Bank_Name_Input, ",");
		List<String> currency_ValueS = splitAndExpand(currency_Value, ",");		
		List<String> BL_Recipt_Numbers = new ArrayList<>();
		List<String> Reciept_Numbers = new ArrayList<>();
		List<String> Invoice_Numbers = new ArrayList<>();
		List<String> Recipt_Modes= new ArrayList<>();
		List<String> Recipt_Modes_All= new ArrayList<>();

		moduleNavigate(driver, Module_ImportInvoice);

		newButton(driver);

		waitForDisplay(driver, By_BL_Number_Btn);
		click(driver, By_BL_Number_Btn);
		waitForElement(driver, bl_Search_Button_IN);
		click(driver, bl_Search_Button_IN);

		globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

		if (isdisplayed(driver, popup_Message)) {
			waitForDisplay(driver, popup_Message);
			String act_Popup = getText(driver, popup_Message);
			if (Part_Lot_BL_Popup.equals(act_Popup)) {
				System.out
						.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
				Extent_pass_New(driver,
						"Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test,
						test1);

				waitForElement(driver, popup_Message_Ok_Button);
				jsClick(driver, popup_Message_Ok_Button);

				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					act_Popup = getText(driver, popup_Message);
					if (Charges_Popup.equals(act_Popup)) {
						System.out.println(
								"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
						Extent_pass_New(driver,
								"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test,
								test1);
						waitForElement(driver, popup_Message_Ok_Button);
						jsClick(driver, popup_Message_Ok_Button);
						waitForDisplay(driver, popup_Up_Ok);
						if (isdisplayed(driver, popup_Up_Ok)) {
							waitForElement(driver, popup_Up_Ok);
							jsClick(driver, popup_Up_Ok);
						}
					}
				}
			} else if (Charges_Popup.equals(act_Popup)) {
				System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
				Extent_pass_New(driver,
						"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);

				if (isdisplayed(driver, Popup_Message)) {
					waitForElement(driver, popup_Up_Ok);
					click(driver, popup_Up_Ok);
				}
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					act_Popup = getText(driver, popup_Message);
					if (Part_Lot_BL_Popup.equals(act_Popup)) {
						System.out.println(
								"Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
						Extent_pass_New(driver,
								"Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup,
								test, test1);

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

		List<Map<String, String>> invoice_Tabledata = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);

		String Invoice_Number = getFirstRowValueByHeaderFromTableData(invoice_Tabledata, Invoice_Table_Headers);
		System.out.println("Invoice_Number :" + Invoice_Number);
		List<Map<String, String>> invoice_Table_Data = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);
		List<String> BL_Invoice_Numbers = getValuesByHeader(invoice_Table_Data, "Inv Number");
		List<String> Inv_Balances = getValuesByHeader(invoice_Table_Data, "Balance");
		List<String> Inv_Currencies = getValuesByHeader(invoice_Table_Data, "Inv Currency");

		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		List<Double> doubleList = convertStringListToDoubleList(driver, Inv_Balances);
		Step_Start(14, "Open receipt screen", test, test1);
		moduleNavigate(driver, Receipt_Module);
		Step_End(14, "Open receipt screen", test, test1);
		for (int j = 0; j < doubleList.size(); j++) {
			if (Double.compare(doubleList.get(j), 0.0) != 0) {
				Step_Start(15, "Click new and click customer search field ", test, test1);
				newButton(driver);
				waitForElement(driver, show_All_Outstanding_Button);
				click(driver, show_All_Outstanding_Button);

				if(isdisplayed(driver, Invoice_Currency_Receipt)) {
					waitForElement(driver, Invoice_Currency_Receipt);
					String cur_Receipt=getAttribute(driver, Invoice_Currency_Receipt, "value");
					if(!cur_Receipt.equals(Inv_Currencies.get(j))) {
						waitForElement(driver, Invoice_currency_search_Button);
						click(driver,Invoice_currency_search_Button);
						twoColumnSearchWindow(driver, Currency_Header_Receipt, conditionFilter, Inv_Currencies.get(j));
					}
				}
				
				
				waitForElement(driver, receipt_Customer_Name_SearchBtn);
				click(driver, receipt_Customer_Name_SearchBtn);
				Step_End(15, "Click new and click customer search field ", test, test1);
				Step_Start(16, "Paste the invoice number ", test, test1);
				Step_Start(17, "click search and fetch the record", test, test1);
				globalValueSearchWindow1(driver, BL_Condition, globalSearchFilterOption_Receipt,
						BL_Invoice_Numbers.get(j), "", "", "", "");

				Step_End(16, "Paste the invoice number ", test, test1);
				Step_End(17, "click search and fetch the record", test, test1);
				waitForDisplay(driver, retrivedGlobalValue);
				if (isdisplayed(driver, retrivedGlobalValue)) {
					click(driver, retrivedGlobalValue);
					waitForElement(driver, SelectButton);
					click(driver, SelectButton);

					
					if(!Payer_Code_Value.trim().equals("")) {
						waitForElement(driver, Payer_Search_Btn_Receipt);
						click(driver,Payer_Search_Btn_Receipt);
						
						globalValueSearchWindow(driver, BL_Condition, Payer_Code_SearchType, Payer_Code_Value,
								"", "", "", "");
						
					}
					
					waitForElement(driver, InvoiceAndReceipt_Tab);
					click(driver, InvoiceAndReceipt_Tab);

					waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
					checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");
					
					List<WebElement> invoice_row = listOfElements(driver, Invoice_And_Receipt_Grid);

					if (invoice_row.size() == 1) {
						System.out.println("Only one row available");
					} else {
						
							waitForElement(driver, Receipt_Number_Filter);
							click(driver, Receipt_Number_Filter);
							Newclear(driver, Receipt_Number_Filter);
							sendKeys(driver, Receipt_Number_Filter, BL_Invoice_Numbers.get(j));
							
							formatLocatorClick(driver, Receipt_InvoiceNo_checkbox, BL_Invoice_Numbers.get(j));


						waitForElement(driver, remove_Button);
						click(driver, remove_Button);

						waitForDisplay(driver, popup_Message_Ok_Button);
						if (isdisplayed(driver, popup_Message_Ok_Button)) {
							waitForElement(driver, popup_Message_Ok_Button);
							click(driver, popup_Message_Ok_Button);

						} else if (isdisplayed(driver, popup_Message_Yes_Button)) {
							waitForElement(driver, popup_Message_Yes_Button);
							click(driver, popup_Message_Yes_Button);

						}
						waitForDisplay(driver, popup_Message_Yes_Button);
						if (isdisplayed(driver, popup_Message_Yes_Button)) {
							waitForElement(driver, popup_Message_Yes_Button);
							click(driver, popup_Message_Yes_Button);
						}
					}					
					
					waitForElement(driver, receipt_Payment_Details_Tab);
					click(driver, receipt_Payment_Details_Tab);
					if (!Mode_Select.trim().equals("")) {
						Step_Start(18, "Select the payment mode dropdown ", test, test1);
						waitForElement(driver, paymentMode_Dropdown);
						click(driver, paymentMode_Dropdown);
						Step_End(18, "Select the payment mode dropdown ", test, test1);
						Step_Start(19, "Select Wire transfer option", test, test1);
						waitForElement(driver, receipt_Mode_dropdown);
						formatLocatorClick(driver, paymentMode, Mode_Select);
						Step_End(19, "Select Wire transfer option", test, test1);
					}
					if (!Number_Input.trim().equals("")) {
						Step_Start(20, "Enter the reference number ", test, test1);
						waitForElement(driver, number_Txtfield);
						sendKeys(driver, number_Txtfield, Number_Input);
						Step_End(20, "Enter the reference number ", test, test1);
					}
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
					if(currency_ValueS.size()>j) {
						if (!currency_ValueS.get(j).trim().equals("")) {
							waitForElement(driver, currency_SearchButton);
							click(driver, currency_SearchButton);

							twoColumnSearchWindow(driver, Currency_Header, conditionFilter, currency_ValueS.get(j));

						}
					}
					
					
					Step_Start(21, "click the bank name search field and select the bank ", test, test1);
					if(banknames.size()>j) {
						if (!banknames.get(j).trim().equals("")) {
							waitForElement(driver, receipt_Bank_Search_Button);
							click(driver, receipt_Bank_Search_Button);
							twoColumnSearchWindow(driver, BankName_Header, conditionFilter, banknames.get(j));
						}
					}
					
					Step_End(21, "click the bank name search field and select the bank ", test, test1);
					Step_Start(22, "click the deposit bank name search field and select the bank ", test, test1);
					// deposit bank

					if(deposit_banks.size()>j) {
						if (!deposit_banks.get(j).trim().equals("")) {
							waitForElement(driver, deposit_Bank_Search_Icon);
							click(driver, deposit_Bank_Search_Icon);
							twoColumnSearchWindow(driver, DepositBankName_Header, conditionFilter,deposit_banks.get(j));
						}
					}
					
					
					if(!Receipt_Remarks.trim().equals("")) {
						
						waitForElement(driver, Remarks_Input_Receipt);
						sendKeys(driver, Remarks_Input_Receipt, Receipt_Remarks);
						
					}
					
					Step_End(22, "click the deposit bank name search field and select the bank ", test, test1);
					Step_Start(23, "Click add button ", test, test1);
					waitForElement(driver, add_Payment_Details);
					click(driver, add_Payment_Details);
					Step_End(23, "Click add button ", test, test1);
					Step_Start(24, "Go to invoices and receipts tab", test, test1);
					waitForElement(driver, InvoiceAndReceipt_Tab);
					click(driver, InvoiceAndReceipt_Tab);
					Step_End(24, "Go to invoices and receipts tab", test, test1);
					Step_Start(25, "Select  the row (same invoice number)", test, test1);
					waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
					checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");
					Step_End(25, "Select  the row (same invoice number)", test, test1);
					Step_Start(26, "Click allocate button", test, test1);
					waitForElement(driver, allocate_Button);
					click(driver, allocate_Button);
					Step_End(26, "Click allocate button", test, test1);
					Step_Start(27, "Click Saved button", test, test1);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
					waitForDisplay(driver, popup_Message_Yes_Button);
					if (isdisplayed(driver, popup_Message_Yes_Button)) {
						click(driver, popup_Message_Yes_Button);
						waitForElement(driver, SaveButton_ToolBar);
						click(driver, SaveButton_ToolBar);
					}
					Step_End(27, "Click Saved button", test, test1);
					Step_Start(28, "Make sure receipt saved (Receipt number generated)", test, test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					waitForElement(driver, recieptNo_Textfield);
					
					waitForElement(driver, Mode_of_Payment_Receipt);
					String ReceiptMode=getText(driver, Mode_of_Payment_Receipt);
					Recipt_Modes.add(ReceiptMode);
					
					String actual_Receipt_No = getAttribute(driver, recieptNo_Textfield, "value");
					BL_Recipt_Numbers.add(actual_Receipt_No);
					System.out.println("The Newly Generated Reciept Number is : " + actual_Receipt_No);
					Extent_pass_New(driver, "The Newly Generated Reciept Number is : " + actual_Receipt_No, test,
							test1);
					Step_End(28, "Make sure receipt saved (Receipt number generated)", test, test1);

				} else {
					click(driver, globalSearchCloseIcon_L);
				}
			}
			Invoice_Numbers = BL_Invoice_Numbers;
			Reciept_Numbers = BL_Recipt_Numbers;
			Recipt_Modes_All=Recipt_Modes;
			
			scrollTop(driver);
		}
		waitForElement(driver, Module_Close);
		jsClick(driver, Module_Close);

		moduleNavigate(driver, Module_ImportInvoice);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type1, Invoice_Number, "", "", "", "");

		List<Map<String, String>> invoice_Table_Data1 = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);
		List<String> Inv_Balances1 = getValuesByHeader(invoice_Table_Data1, "Balance");
		List<Double> doubleList1 = convertStringListToDoubleList(driver, Inv_Balances1);
		List<String> Inv_Currencies1 = getValuesByHeader(invoice_Table_Data, "Inv Currency");

		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);
		
		// Validate that all balances are zero
		boolean allZero = doubleList1.stream().allMatch(value -> value == 0.0);

		if (allZero) {
			System.out.println("All invoice balances are zero: " + doubleList1);
			Extent_pass_New(driver, "All invoice balances are zero: " + doubleList1, test, test1);
		} else {
			doubleList = convertStringListToDoubleList(driver, Inv_Balances1);
			Step_Start(14, "Open receipt screen", test, test1);
			moduleNavigate(driver, Receipt_Module);
			Step_End(14, "Open receipt screen", test, test1);
			for (int j = 0; j < doubleList.size(); j++) {
				if (Double.compare(doubleList.get(j), 0.0) != 0) {
					Step_Start(15, "Click new and click customer search field ", test, test1);
					newButton(driver);
					waitForElement(driver, show_All_Outstanding_Button);
					click(driver, show_All_Outstanding_Button);

					waitForElement(driver, Invoice_Currency_Receipt);
					String cur_Receipt=getAttribute(driver, Invoice_Currency_Receipt, "value");
					if(!cur_Receipt.equals(Inv_Currencies.get(j))) {
						waitForElement(driver, Invoice_currency_search_Button);
						click(driver,Invoice_currency_search_Button);
						twoColumnSearchWindow(driver, Currency_Header_Receipt, conditionFilter, Inv_Currencies1.get(j));
					}
					
					waitForElement(driver, receipt_Customer_Name_SearchBtn);
					click(driver, receipt_Customer_Name_SearchBtn);
					Step_End(15, "Click new and click customer search field ", test, test1);
					Step_Start(16, "Paste the invoice number ", test, test1);
					Step_Start(17, "click search and fetch the record", test, test1);
					globalValueSearchWindow1(driver, BL_Condition, globalSearchFilterOption_Receipt,
							BL_Invoice_Numbers.get(j), "", "", "", "");

					Step_End(16, "Paste the invoice number ", test, test1);
					Step_End(17, "click search and fetch the record", test, test1);
					waitForDisplay(driver, retrivedGlobalValue);
					if (isdisplayed(driver, retrivedGlobalValue)) {
						click(driver, retrivedGlobalValue);
						waitForElement(driver, SelectButton);
						click(driver, SelectButton);

						waitForElement(driver, InvoiceAndReceipt_Tab);
						click(driver, InvoiceAndReceipt_Tab);

						waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
						checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");

						List<WebElement> invoice_row = listOfElements(driver, Invoice_And_Receipt_Grid);

						if (invoice_row.size() == 1) {
							System.out.println("Only one row available");
						} else {

							waitForElement(driver, Receipt_Number_Filter);
							click(driver, Receipt_Number_Filter);
							Newclear(driver, Receipt_Number_Filter);
							sendKeys(driver, Receipt_Number_Filter, BL_Invoice_Numbers.get(j));
							
							formatLocatorClick(driver, Receipt_InvoiceNo_checkbox, BL_Invoice_Numbers.get(j));
						
							waitForElement(driver, remove_Button);
							click(driver, remove_Button);

							waitForDisplay(driver, popup_Message_Ok_Button);
							if (isdisplayed(driver, popup_Message_Ok_Button)) {
								waitForElement(driver, popup_Message_Ok_Button);
								click(driver, popup_Message_Ok_Button);

							} else if (isdisplayed(driver, popup_Message_Yes_Button)) {
								waitForElement(driver, popup_Message_Yes_Button);
								click(driver, popup_Message_Yes_Button);

							}
							waitForDisplay(driver, popup_Message_Yes_Button);
							if (isdisplayed(driver, popup_Message_Yes_Button)) {
								waitForElement(driver, popup_Message_Yes_Button);
								click(driver, popup_Message_Yes_Button);
							}
						}

						waitForElement(driver, receipt_Payment_Details_Tab);
						click(driver, receipt_Payment_Details_Tab);
						if (!Mode_Select.equals("")) {
							Step_Start(18, "Select the payment mode dropdown ", test, test1);
							waitForElement(driver, paymentMode_Dropdown);
							click(driver, paymentMode_Dropdown);
							Step_End(18, "Select the payment mode dropdown ", test, test1);
							Step_Start(19, "Select Wire transfer option", test, test1);
							waitForElement(driver, receipt_Mode_dropdown);
							formatLocatorClick(driver, paymentMode, Mode_Select);
							Step_End(19, "Select Wire transfer option", test, test1);
						}
						if (!Number_Input.equals("")) {
							Step_Start(20, "Enter the reference number ", test, test1);
							waitForElement(driver, number_Txtfield);
							sendKeys(driver, number_Txtfield, Number_Input);
							Step_End(20, "Enter the reference number ", test, test1);
						}
						// currency
						// currency
						if(currency_ValueS.size()>j) {
							if (!currency_ValueS.get(j).trim().equals("")) {
								waitForElement(driver, currency_SearchButton);
								click(driver, currency_SearchButton);

								twoColumnSearchWindow(driver, Currency_Header, conditionFilter, currency_ValueS.get(j));

							}
						}
						Step_Start(21, "click the bank name search field and select the bank ", test, test1);
						if(banknames.size()>j) {
							if (!banknames.get(j).trim().equals("")) {
								waitForElement(driver, receipt_Bank_Search_Button);
								click(driver, receipt_Bank_Search_Button);
								twoColumnSearchWindow(driver, BankName_Header, conditionFilter, banknames.get(j));
							}
						}
						Step_End(21, "click the bank name search field and select the bank ", test, test1);
						Step_Start(22, "click the deposit bank name search field and select the bank ", test, test1);
						// deposit bank

						if(deposit_banks.size()>j) {
							if (!deposit_banks.get(j).trim().equals("")) {
								waitForElement(driver, deposit_Bank_Search_Icon);
								click(driver, deposit_Bank_Search_Icon);
								twoColumnSearchWindow(driver, DepositBankName_Header, conditionFilter,deposit_banks.get(j));
							}
						}
						
						Step_End(22, "click the deposit bank name search field and select the bank ", test, test1);
						Step_Start(23, "Click add button ", test, test1);
						waitForElement(driver, add_Payment_Details);
						click(driver, add_Payment_Details);
						Step_End(23, "Click add button ", test, test1);
						Step_Start(24, "Go to invoices and receipts tab", test, test1);
						waitForElement(driver, InvoiceAndReceipt_Tab);
						click(driver, InvoiceAndReceipt_Tab);
						Step_End(24, "Go to invoices and receipts tab", test, test1);
						Step_Start(25, "Select  the row (same invoice number)", test, test1);
						waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
						checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");
						Step_End(25, "Select  the row (same invoice number)", test, test1);
						Step_Start(26, "Click allocate button", test, test1);
						waitForElement(driver, allocate_Button);
						click(driver, allocate_Button);
						Step_End(26, "Click allocate button", test, test1);
						Step_Start(27, "Click Saved button", test, test1);
						waitForElement(driver, SaveButton_ToolBar);
						click(driver, SaveButton_ToolBar);
						waitForDisplay(driver, popup_Message_Yes_Button);
						if (isdisplayed(driver, popup_Message_Yes_Button)) {
							click(driver, popup_Message_Yes_Button);
							waitForElement(driver, SaveButton_ToolBar);
							click(driver, SaveButton_ToolBar);
						}
						Step_End(27, "Click Saved button", test, test1);
						Step_Start(28, "Make sure receipt saved (Receipt number generated)", test, test1);
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
						waitForElement(driver, recieptNo_Textfield);
						String actual_Receipt_No = getAttribute(driver, recieptNo_Textfield, "value");
						BL_Recipt_Numbers.add(actual_Receipt_No);
						String ReceiptMode=getText(driver, Mode_of_Payment_Receipt);
						Recipt_Modes.add(ReceiptMode);
						
						System.out.println("The Newly Generated Reciept Number is : " + actual_Receipt_No);
						Extent_pass_New(driver, "The Newly Generated Reciept Number is : " + actual_Receipt_No, test,
								test1);
						Step_End(28, "Make sure receipt saved (Receipt number generated)", test, test1);

					} else {
						click(driver, globalSearchCloseIcon_L);
					}
				}
				Invoice_Numbers = BL_Invoice_Numbers;
				Reciept_Numbers = BL_Recipt_Numbers;
				Recipt_Modes_All=Recipt_Modes;
				scrollTop(driver);
			}
			waitForElement(driver, Module_Close);
			jsClick(driver, Module_Close);
			moduleNavigate(driver, Module_ImportInvoice);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type1, Invoice_Number, "", "", "", "");

			invoice_Table_Data1 = getTableData(driver, importInvoice_Table_Header, importInvoice_Table_Row);
			Inv_Balances1 = getValuesByHeader(invoice_Table_Data1, "Balance");
			doubleList1 = convertStringListToDoubleList(driver, Inv_Balances1);

			// Validate that all balances are zero
			allZero = doubleList1.stream().allMatch(value -> value == 0.0);

			if (allZero) {
				System.out.println("All invoice balances are zero: " + doubleList1);
				Extent_pass_New(driver, "All invoice balances are zero: " + doubleList1, test, test1);
			} else {
				System.out.println("Invoice balances are not zero: " + doubleList);
				Extent_fail(driver, "Invoice balances are not zero: " + doubleList, test, test1);
			}
		}

		if(isdisplayed(driver, Close_Current_tab)) {
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		for (int i = 0; i < Reciept_Numbers.size(); i++) {
		
			moduleNavigate(driver, Receipt_Module);
			
			scrollTop(driver);
			waitForElement(driver, SearchButton_Toolbar);
			jsClick(driver, SearchButton_Toolbar);
			globalValueSearchWindow1(driver, BL_Condition, Global_search_value_Receipt_Number, Reciept_Numbers.get(i),
					"", "", "", "");
			
			waitForElement(driver, DO_horizontal_Scroll);
			horizontalscroll(driver, DO_horizontal_Scroll, 2500);
			waitForElement(driver, receipt_Status_Filter);
			click(driver, receipt_Status_Filter);
			sendKeys(driver, receipt_Status_Filter, receipt_Status_Filer_Data);
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			waitForElement(driver, popup_Message);
			String PoupValue=getText(driver, popup_Message);
			if(PoupValue.contains(Cannot_Cancel_Receipt_Popup)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				if(Recipt_Modes_All.get(i).equalsIgnoreCase("Cash")) {
					DeleteReceiptInCashDeposit(driver,Cash_Deposit_Module,BL_Condition,Global_search_value_Receipt_No,Reciept_Numbers.get(i),Cash_Deposit_delete_Popup1,Cash_Deposit_Delete_Popup2);
				}else if (Recipt_Modes_All.get(i).equalsIgnoreCase("Wire Transfer")) {
					DeleteReceiptInChequeRealization(driver,Cheque_module,BL_Condition,Global_search_value_Receipt_No,Reciept_Numbers.get(i),reset_Popup_Expected,reversed_successful_Expected);
				}else if(Recipt_Modes_All.get(i).equalsIgnoreCase("Cheque")) {
					DeleteReceiptInDD_Deposit(driver,Cheque_DD_Deposit_Module,BL_Condition,Global_search_value_Receipt_No,Reciept_Numbers.get(i),DD_Deposit_delete_Popup1,DD_Deposit_Delete_Popup2);
				}				
			}else {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
			}
			
			
			waitForElement(driver, Delete_button_toolBar);
			if (isElementAccessible(driver, Delete_button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled",
						test, test1);
			}
			Step_End(21, "once saved the receipt ,tool bar delete button has enable.", test, test1);
			Step_Start(22, "click the delete button -system has validate -enter the remarks", test, test1);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, enter_remarks_Exp);
			String actEnterRemarks_popup = getText(driver, popup_Message);
			if (actEnterRemarks_popup.equals(enter_remarks_Exp)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + enter_remarks_Exp + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + enter_remarks_Exp + " || Actual popup : "
						+ actEnterRemarks_popup);

				Step_End(22, "click the delete button -system has validate -enter the remarks", test, test1);
				Step_Start(23, "click ok", test, test1);

				click(driver, popup_Message_Ok_Button);

				Step_End(23, "click ok", test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + enter_remarks_Exp + " || Actual popup : "
						+ actEnterRemarks_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + enter_remarks_Exp + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);

			}

			Step_Start(24, "enter the remarks ", test, test1);

			waitForElement(driver, reciept_remarks_TextArea);
			sendKeys(driver, reciept_remarks_TextArea, Delete_Remark_Value_Receipt);

			Step_End(24, "enter the remarks ", test, test1);
			Step_Start(25, "click the delete buton", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			Step_End(25, "click the delete buton", test, test1);
			Step_Start(26, "system has validate - Are you sure you want to delete ? \r\n No Yes", test, test1);

			waitForPopup(driver, popup_Message, WantToDeletePopup);
			String actWantToDelete_popup = getText(driver, popup_Message);
			if (actWantToDelete_popup.equals(WantToDeletePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + WantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + WantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);

				Step_End(26, "system has validate - Are you sure you want to delete ? \r\n No Yes", test, test1);
				Step_Start(28, "click the yes button", test, test1);

				click(driver, popup_Message_Yes_Button);

				Step_End(28, "click the yes button", test, test1);

			} else {
				System.out.println("Not Matched || Expected Popup : " + WantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + WantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);

			}

			Step_Start(29, "Receipt cancelled-receipt no showing red color", test, test1);

			waitForPopup(driver, popup_Message, CancelledPopup);

			String actDeleted_popup = getText(driver, popup_Message);

			if (actDeleted_popup.equals(CancelledPopup)) {
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + CancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);
				System.out.println(
						"Matched || Expected Popup : " + CancelledPopup + " || Actual popup : " + actDeleted_popup);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + CancelledPopup + " || Actual popup : " + actDeleted_popup);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + CancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);

			}
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
		}
		
			
		Invoice_Reversal(driver,InvoiceReversal_Module,BL_Condition,Select_search_value_Reversal,Invoice_Numbers.get(0),invoiceReversalRemarks,invoiceReversedPopup);
		

		Extent_completed(testcase_Name, test, test1);

	}
}
