package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_050 extends Keywords{
	public void Delivery_Order_TS_050(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_050";




		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String configuration_Reset = Excel_data.get("configuration_Reset");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String DO_POP_EXP = Excel_data.get("DO_POP_EXP");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String status_exp = Excel_data.get("status_exp");
		String Import_checkbox_status = Excel_data.get("Import_checkbox_status");
		String payment_Mode = Excel_data.get("Payment_Mode");
		String number_data = Excel_data.get("number_data");
		String globalSearchFilterdelivery = Excel_data.get("globalSearchFilterdelivery");
		String globalSearchFilterimport = Excel_data.get("globalSearchFilterimport");
		String module_Receipt = Excel_data.get("Module_Receipt");
		String receiptRemark = Excel_data.get("ReceiptRemark");
		String module_InvoiceReversal = Excel_data.get("Module_InvoiceReversal");
		String invoiceReversalRemarks = Excel_data.get("InvoiceReversalRemarks");
		String issuedInvoiceColor = Excel_data.get("IssuedInvoiceColor");
		String Import_Invoice_Search_Type1 = Excel_data.get("Import_Invoice_Search_Type1");
		String globalSearchFilterOption_ChequeRealization = Excel_data.get("GlobalSearchFilterOption_ChequeRealization");
		String globalSearchFilterOption_InvoiceReversal = Excel_data.get("GlobalSearchFilterOption_InvoiceReversal");
		String globalSearchFilterOption_Receipt2 = Excel_data.get("GlobalSearchFilterOption_Receipt2");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String module_ChequeRealization = Excel_data.get("Module_ChequeRealization");
		String receipt_Status_Filer_Data = Excel_data.get("Receipt_Status_Filer_Data");
		String De_Stuff_Dock_Check_Box_Option = Excel_data.get("De_Stuff_Dock_Check_Box_Option");
		String De_Stuff_Dock_Factory_Box_Option = Excel_data.get("De_Stuff_Dock_Factory_Box_Option");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String HBL_Number = Excel_data.get("HBL_Number");
		String Module_Import_Invoice = Excel_data.get("Module_Import_Invoice");
		String Reciept_Search_Type = Excel_data.get("Reciept_Search_Type");
		String Invoice_Reversed_Value = Excel_data.get("Invoice_Reversed_Value");
		String Reciept_Search_Currency_Code_Column_Header = Excel_data.get("Reciept_Search_Currency_Code_Column_Header");
		String delete_Option = Excel_data.get("delete_Option");
		String Condition = Excel_data.get("Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		Step_Start(2, "Open agency configuration module ", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		// Import documentation
		List<String> BL_Numbers = splitAndExpand(globalSearch_Number, ",");
		List<String> HBL_Numbers = splitAndExpand(HBL_Number, "/");
		List<String> Reciept_Numbers = new ArrayList<>();
		List<String> Invoice_Numbers = new ArrayList<>();
		List<String> Inv_Currencys = new ArrayList<>();
		List<String> Inv_Balances = new ArrayList<>();
		for(int i = 0;i<BL_Numbers.size();i++) {
			List<String> BL_Invoice_Numbers= new ArrayList<>();
			List<String> BL_Recipt_Numbers = new ArrayList<>();
			Step_Start(5, "Open import documentation module ", test, test1);
			moduleNavigate(driver, ImportDocumentationModule);
			Step_End(5, "Open import documentation module ", test, test1);
			Step_Start(6, "Make sure both house bl having manifest charges in collect charges tab", test, test1);
			List<String> act_HBL_Numbers = splitAndExpand(HBL_Numbers.get(i), ",");
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterimport, BL_Numbers.get(i), "", "", "", "");
			waitForElement(driver, BL_Status_Value_IMP_DOC);
			String status_act = getText(driver, BL_Status_Value_IMP_DOC);
			if (status_exp.equals(status_act)) {
				System.out.println("Matched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act);
				Extent_pass_New(driver,"Matched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act, test,test1);
			} else {
				System.out.println("NotMatched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act);
				Extent_fail(driver,"NotMatched || Expected Status value was : " + status_exp + " || Actual Status value was : " + status_act,test, test1);
			}
			if(act_HBL_Numbers.size()>1) {
				waitForElement(driver, HBL_Num_click);
				click(driver, HBL_Num_click);
				String HBL_Option = String.format(HBL_Select, act_HBL_Numbers.get(0));
				waitForElement(driver, HBL_Option);
				click(driver, HBL_Option);
			}
			waitForElement(driver, Collect_Charges_Tab);
			click(driver, Collect_Charges_Tab);
			waitForDisplay(driver, Manifest_check);
			if(isdisplayed(driver, Manifest_check)) {
				Extent_pass_New(driver, "Expected Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges are pressent", test, test1);
				System.out.println("Expected Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges are pressent");
			}else { 
				System.out.println("Expected Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges are Not pressent");
				Extent_fail(driver,"Expected Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(0)+" Manifeast charges are Not pressent", test, test1);
			}
			waitForElement(driver, importDoc_RemarksTab);
			click(driver, importDoc_RemarksTab);
			Step_End(6, "Make sure both house bl having manifest charges in collect charges tab", test, test1);
			waitForElement(driver, Import_Invoice_Checkbox);
			String status_check_import = getAttribute(driver, Import_Invoice_Checkbox,"class");
			List<Map<String, String>> remarksTableData = getTableData(driver, Remarks_Tab_Column_Header,Remarks_Tab_Column_Row);
			BL_Invoice_Numbers.addAll(getValuesByFirstColumnAndHeader(remarksTableData, "Reference Type", "Import Invoice", "Reference Value"));
			BL_Recipt_Numbers.addAll(getValuesByFirstColumnAndHeader(remarksTableData, "Reference Type", "Import Invoice Receipt", "Reference Value"));
			scrollTop(driver);
			waitForElement(driver, Module_Close);
			jsClick(driver, Module_Close);
			if (status_check_import.contains(Import_checkbox_status)) {
				Extent_call(test, test1, "****Import checkbox was  active for***"+act_HBL_Numbers.get(0));
				Step_Start(7, "Open import invoice screen", test, test1);
				moduleNavigate(driver, Module_Import_Invoice);
				Step_End(7, "Open import invoice screen", test, test1);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow1(driver, dropdownCondition, Import_Invoice_Search_Type1, act_HBL_Numbers.get(0), "", "", "", "");
				globalValueSearchWindowScrollAndSelect(driver, Invoice_Reversed_TF, Invoice_Reversed_Value);
				waitForElement(driver, importInvoice_Table_Header);
				List<Map<String, String>> invoice_Table_Data = getTableData(driver, importInvoice_Table_Header, importInvoice_Table_Row);
				Inv_Currencys = getValuesByHeader(invoice_Table_Data, "Inv Currency");
				Inv_Balances = getValuesByHeader(invoice_Table_Data, "Balance");
				scrollTop(driver);
				waitForElement(driver, Module_Close);
				jsClick(driver, Module_Close);
			} else {
				Step_Start(7, "Open import invoice screen", test, test1);
				moduleNavigate(driver, Module_Import_Invoice);
				Step_End(7, "Open import invoice screen", test, test1);
				Step_Start(8, "Click new then click Bl number search field", test, test1);
				newButton(driver);
				waitForElement(driver, bl_Search_Button_IN);
				click(driver, bl_Search_Button_IN);
				Step_End(8, "Click new then click Bl number search field", test, test1);
				Step_Start(9, "Paste the BL Number/HBL number", test, test1);
				globalValueSearchWindow(driver, dropdownCondition, Import_Invoice_Search_Type1, act_HBL_Numbers.get(0), "", "", "", "");
				Step_End(9, "Paste the BL Number/HBL number", test, test1);
				Step_Start(10, "Click search and fetch the record in grid", test, test1);
				waitForElement(driver, De_Stuff_Dock_Check_Box);
				checkBox(driver, De_Stuff_Dock_Check_Box, De_Stuff_Dock_Check_Box_Option);
				checkBox(driver, De_Stuff_Dock_Factory_Box, De_Stuff_Dock_Factory_Box_Option);
				Step_End(10, "Click search and fetch the record in grid", test, test1);
				Step_Start(11, "Make sure charges available in manifest charges tab", test, test1);
				waitForElement(driver, import_Invoice_Issued_Button);
				Step_End(11, "Make sure charges available in manifest charges tab", test, test1);
				Step_Start(12, "Click the issued button and save button ", test, test1);
				click(driver,import_Invoice_Issued_Button);
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver,SaveButton_ToolBar);
				Step_End(12, "Click the issued button and save button ", test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				Step_Start(13, "Make sure invoice issued (Invoice saved validation shown and invoice number generated)", test, test1);
				List<Map<String, String>> invoice_Table_Data = getTableData(driver, importInvoice_Table_Header, importInvoice_Table_Row);
				BL_Invoice_Numbers.addAll(getValuesByHeader(invoice_Table_Data, "Inv Number"));
				Inv_Currencys = getValuesByHeader(invoice_Table_Data, "Inv Currency");
				Inv_Balances = getValuesByHeader(invoice_Table_Data, "Balance");
				Step_End(13, "Make sure invoice issued (Invoice saved validation shown and invoice number generated)", test, test1);
				scrollTop(driver);
				waitForElement(driver, Module_Close);
				jsClick(driver, Module_Close);
			}
			List<Double> doubleList = convertStringListToDoubleList(driver,Inv_Balances);
			Step_Start(14, "Open receipt screen", test, test1);
			moduleNavigate(driver, module_Receipt);
			Step_End(14, "Open receipt screen", test, test1);
			for(int j = 0;j<doubleList.size();j++) {
				if (doubleList.get(j)!=0.0) {
					Step_Start(15, "Click new and click customer search field ", test, test1);
					newButton(driver);
					waitForElement(driver, Invoice_currency_search_Button);
					click(driver, Invoice_currency_search_Button);
					twoColumnSearchWindow(driver, Reciept_Search_Currency_Code_Column_Header, Condition, Inv_Currencys.get(j));
					waitForElement(driver, receipt_Customer_Name_SearchBtn);
					click(driver, receipt_Customer_Name_SearchBtn);
					Step_End(15, "Click new and click customer search field ", test, test1);
					Step_Start(16, "Paste the invoice number ", test, test1);
					Step_Start(17, "click search and fetch the record", test, test1);
					globalValueSearchWindow1(driver, dropdownCondition, Reciept_Search_Type, BL_Invoice_Numbers.get(j), "", "", "", "");
					Step_End(16, "Paste the invoice number ", test, test1);
					Step_End(17, "click search and fetch the record", test, test1);
					waitForDisplay(driver, retrivedGlobalValue);
					if(isdisplayed(driver, retrivedGlobalValue)) {
						click(driver, retrivedGlobalValue);
						waitForElement(driver, SelectButton);
						click(driver, SelectButton);
						Step_Start(18, "Select the payment mode dropdown ", test, test1);
						waitForElement(driver, paymentMode_Dropdown);
						click(driver, paymentMode_Dropdown);
						Step_End(18, "Select the payment mode dropdown ", test, test1);
						Step_Start(19, "Select Wire transfer option", test, test1);
						formatLocatorClick(driver, paymentMode, payment_Mode);
						Step_End(19, "Select Wire transfer option", test, test1);
						Step_Start(20, "Enter the reference number ", test, test1);
						waitForElement(driver, number_Txtfield);
						sendKeys(driver, number_Txtfield, number_data);
						Step_End(20, "Enter the reference number ", test, test1);
						Step_Start(21, "click the bank name search field and select the bank ", test, test1);
//						waitForElement(driver, bank_Search_Icon);
//						click(driver, bank_Search_Icon);
//						twoColumnSearchWindow(driver, Search_Bank_Name_Column_Header, Condition, Bank.get(j));
						Step_End(21, "click the bank name search field and select the bank ", test, test1);
						Step_Start(22, "click the deposit bank name search field and select the bank ", test, test1);
						//deposit bank
//						waitForElement(driver, deposit_Bank_Search_Icon);
//						click(driver, deposit_Bank_Search_Icon);
//						twoColumnSearchWindow(driver, Deposite_Bank_Name_Column_Header, Condition,Inv_Currencys.get(j));
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
						checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox,"No");
						String checkBox = String.format(invoicesAndReceipts_Checkbox, BL_Invoice_Numbers.get(j));
						waitForElement(driver, checkBox);
						checkBox(driver, checkBox,"Yes");
						Step_End(25, "Select  the row (same invoice number)", test, test1);
						Step_Start(26, "Click allocate button", test, test1);
						waitForElement(driver, allocate_Button);
						click(driver, allocate_Button);
						Step_End(26, "Click allocate button", test, test1);
						Step_Start(27, "Click Saved button", test, test1);
						waitForElement(driver, SaveButton_ToolBar);
						click(driver, SaveButton_ToolBar);
						waitForDisplay(driver, popup_Message_Yes_Button);
						if(isdisplayed(driver, popup_Message_Yes_Button)) {
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
						System.out.println("The Newly Generated Reciept Number is : "+actual_Receipt_No);
						Extent_pass_New(driver, "The Newly Generated Reciept Number is : "+actual_Receipt_No, test, test1);
						Step_End(28, "Make sure receipt saved (Receipt number generated)", test, test1);
					}else {
						click(driver, globalSearchCloseIcon_L);
					}
				}
			}
			Invoice_Numbers.addAll(BL_Invoice_Numbers);
			Reciept_Numbers.addAll(BL_Recipt_Numbers);
			scrollTop(driver);
			waitForElement(driver, Module_Close);
			jsClick(driver, Module_Close);
		}
		List<String> invoice_Balances = new ArrayList<>();
		List<String> inv_Currencys = new ArrayList<>();
		List<String> afterBL_Invoice_Numbers= new ArrayList<>();
		List<String> afterBL_Recipt_Numbers = new ArrayList<>();
		for(int i = 0;i<BL_Numbers.size();i++) {
			List<String> act_HBL_Numbers = splitAndExpand(HBL_Numbers.get(i), ",");
			for( int j = 1;j<act_HBL_Numbers.size();j++) {
				if(act_HBL_Numbers.size()>1) {
					Step_Start(37, "Go to import documentation screen", test, test1);
					moduleNavigate(driver, ImportDocumentationModule);
					Step_End(37, "Go to import documentation screen", test, test1);
					Step_Start(38, "Click search and Fetch the BL", test, test1);
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterimport, BL_Numbers.get(i), "", "", "", "");
					waitForElement(driver, BL_Status_Value_IMP_DOC);
					String status_act = getText(driver, BL_Status_Value_IMP_DOC);
					if (status_exp.equals(status_act)) {
						System.out.println("Matched || Expected Status value is : " + status_exp + " || Actual Status value is : " + status_act);
						Extent_pass_New(driver,"Matched || Expected Status value is : " + status_exp + " || Actual Status value is : " + status_act, test,test1);
					} else {
						System.out.println("NotMatched || Expected Status value is: " + status_exp + " || Actual Status value is : " + status_act);
						Extent_fail(driver,"NotMatched || Expected Status value is : " + status_exp + " || Actual Status value is : " + status_act,test, test1);
					}
					Step_End(38, "Click search and Fetch the BL", test, test1);
					Step_Start(39, "Click house bl dropdown ", test, test1);
					waitForElement(driver, HBL_Num_click);
					click(driver, HBL_Num_click);
					Step_End(39, "Click house bl dropdown ", test, test1);
					Step_Start(40, "Select the house bl (yet to be invoiced - Remarks tab receipt and invoice check box unticked )", test, test1);
					String HBL_Option = String.format(HBL_Select, act_HBL_Numbers.get(j));
					waitForElement(driver, HBL_Option);
					click(driver, HBL_Option);
					Step_End(40, "Select the house bl (yet to be invoiced - Remarks tab receipt and invoice check box unticked )", test, test1);
					Step_Start(41, "Follow the step no 7 to 35", test, test1);
					waitForElement(driver, Collect_Charges_Tab);
					click(driver, Collect_Charges_Tab);
					waitForDisplay(driver, Manifest_check);
					if(isdisplayed(driver, Manifest_check)) {
						Extent_pass_New(driver, "Expected Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges are pressent", test, test1);
						System.out.println("Expected Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges are pressent");
					}else {
						System.out.println("Expected Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges are Not pressent");
						Extent_fail(driver,"Expected Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges Should be pressent || Actual Result is : "+act_HBL_Numbers.get(j)+" Manifeast charges are Not pressent", test, test1);
					}
					waitForElement(driver, importDoc_RemarksTab);
					click(driver, importDoc_RemarksTab);
					waitForElement(driver, Import_Invoice_Checkbox);
					String status_check_import = getAttribute(driver, Import_Invoice_Checkbox,"class");
					List<Map<String, String>> remarksTableData = getTableData(driver, Remarks_Tab_Column_Header, Remarks_Tab_Column_Row);
					afterBL_Invoice_Numbers.addAll(getValuesByFirstColumnAndHeader(remarksTableData, "Reference Type", "Import Invoice", "Reference Value"));
					afterBL_Recipt_Numbers.addAll(getValuesByFirstColumnAndHeader(remarksTableData, "Reference Type", "Import Invoice Receipt", "Reference Value"));
					waitForElement(driver, Module_Close);
					click(driver, Module_Close);
					if (status_check_import.contains(Import_checkbox_status)) {
						Extent_call(test, test1, "****Import checkbox was  active for***"+act_HBL_Numbers.get(j));
						moduleNavigate(driver, Module_Import_Invoice);
						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						globalValueSearchWindow1(driver, dropdownCondition, Import_Invoice_Search_Type1, act_HBL_Numbers.get(j), "", "", "", "");
						waitForElement(driver, DO_horizontal_Scroll);
						horizontalscroll(driver, DO_horizontal_Scroll, 2000);
						waitForElement(driver, Invoice_Reversed_TF);
						sendKeys(driver, Invoice_Reversed_TF, Invoice_Reversed_Value);
						waitForElement(driver, retrivedGlobalValue);
						click(driver, retrivedGlobalValue);
						waitForElement(driver, SelectButton);
						click(driver, SelectButton);
						waitForElement(driver, importInvoice_Table_Header);
						List<Map<String, String>> invoice_Table_Data = getTableData(driver, importInvoice_Table_Header, importInvoice_Table_Row);
						inv_Currencys.addAll(getValuesByHeader(invoice_Table_Data, "Inv Currency"));
						invoice_Balances.addAll(getValuesByHeader(invoice_Table_Data, "Balance"));
						scrollTop(driver);
						waitForElement(driver, Module_Close);
						jsClick(driver, Module_Close);
					} else {
						moduleNavigate(driver, Module_Import_Invoice);
						newButton(driver);
						waitForElement(driver, bl_Search_Button_IN);
						click(driver, bl_Search_Button_IN);
						globalValueSearchWindow(driver, dropdownCondition, Import_Invoice_Search_Type1, act_HBL_Numbers.get(j), "", "", "", "");
						waitForElement(driver, De_Stuff_Dock_Check_Box);
						checkBox(driver, De_Stuff_Dock_Check_Box, De_Stuff_Dock_Check_Box_Option);
						checkBox(driver, De_Stuff_Dock_Factory_Box, De_Stuff_Dock_Factory_Box_Option);
						waitForElement(driver, import_Invoice_Issued_Button);
						click(driver,import_Invoice_Issued_Button);
						scrollTop(driver);
						waitForElement(driver, SaveButton_ToolBar);
						jsClick(driver,SaveButton_ToolBar);
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver,popup_Message_Ok_Button);
						List<Map<String, String>> invoice_Table_Data = getTableData(driver, importInvoice_Table_Header, importInvoice_Table_Row);
						afterBL_Invoice_Numbers.addAll(getValuesByHeader(invoice_Table_Data, "Inv Number"));
						inv_Currencys.addAll(getValuesByHeader(invoice_Table_Data, "Inv Currency"));
						invoice_Balances.addAll(getValuesByHeader(invoice_Table_Data, "Balance"));
						waitForElement(driver, Module_Close);
						click(driver, Module_Close);
					}
				}
				List<Double> doubleList = convertStringListToDoubleList(driver,invoice_Balances);
				moduleNavigate(driver, module_Receipt);
				for(int k = 0;k<doubleList.size();k++) {
					if (doubleList.get(k)!=0.0) {
						newButton(driver);
						waitForElement(driver, Invoice_currency_search_Button);
						click(driver, Invoice_currency_search_Button);
						twoColumnSearchWindow(driver, Reciept_Search_Currency_Code_Column_Header, Condition, inv_Currencys.get(k));
						waitForElement(driver, receipt_Customer_Name_SearchBtn);
						click(driver, receipt_Customer_Name_SearchBtn);
						globalValueSearchWindow1(driver, dropdownCondition, Reciept_Search_Type, afterBL_Invoice_Numbers.get(k), "", "", "", "");
						waitForDisplay(driver, retrivedGlobalValue);
						if(isdisplayed(driver, retrivedGlobalValue)) {
							click(driver, retrivedGlobalValue);
							waitForElement(driver, SelectButton);
							click(driver, SelectButton);
							Step_Start(11, "Select the payment mode as \"Wire transfer \"", test, test1);
							waitForElement(driver, paymentMode_Dropdown);
							click(driver, paymentMode_Dropdown);
							String select_Mode=String.format(paymentMode, payment_Mode);
							waitForDisplay(driver, select_Mode);
							click(driver, select_Mode);
							waitForElement(driver, receipt_Amount_TF);
							String amountvalue = getAttribute(driver, receipt_Amount_TF, "value");
							double actualAmount = getNumberValue1(amountvalue);
							double actualAmountValue = actualAmount/2;
							String amountAsString = String.valueOf(actualAmountValue);
							click(driver, receipt_Amount_TF);
							Newclear(driver, receipt_Amount_TF);
							Actionsendkeys(driver, receipt_Amount_TF, amountAsString);
							click(driver, receipt_Amount_TF);
							//							//deposit bank
//							waitForElement(driver, deposit_Bank_Search_Icon);
//							click(driver, deposit_Bank_Search_Icon);
//							twoColumnSearchWindow(driver, Deposite_Bank_Name_Column_Header, Condition, inv_Currencys.get(k));
							waitForElement(driver, add_Payment_Details);
							click(driver, add_Payment_Details);
							waitForElement(driver, InvoiceAndReceipt_Tab);
							click(driver, InvoiceAndReceipt_Tab);
							waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
							checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox,"No");
							String checkBox = String.format(invoicesAndReceipts_Checkbox,afterBL_Invoice_Numbers.get(k));
							waitForElement(driver, checkBox);
							checkBox(driver, checkBox,"Yes");
							waitForElement(driver, allocate_Button);
							click(driver, allocate_Button);
							waitForElement(driver, SaveButton_ToolBar);
							click(driver, SaveButton_ToolBar);
							waitForDisplay(driver, popup_Message_Yes_Button);
							if(isdisplayed(driver, popup_Message_Yes_Button)) {
								click(driver, popup_Message_Yes_Button);
								//								waitForElement(driver, SaveButton_ToolBar);
								//								click(driver, SaveButton_ToolBar);
							}
							waitForElement(driver, popup_Message_Ok_Button);
							click(driver, popup_Message_Ok_Button);
							waitForElement(driver, recieptNo_Textfield);
							String actual_Receipt_No = getAttribute(driver, recieptNo_Textfield, "value");
							afterBL_Recipt_Numbers.add(actual_Receipt_No);
							System.out.println("The Newly Generated Reciept Number is : "+actual_Receipt_No);
							Extent_pass_New(driver, "The Newly Generated Reciept Number is : "+actual_Receipt_No, test, test1);
						}else {
							click(driver, globalSearchCloseIcon_L);
						}
					}
				}
				Invoice_Numbers.addAll(afterBL_Invoice_Numbers);
				Reciept_Numbers.addAll(afterBL_Recipt_Numbers);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
			}
		}
		Step_Start(29, "Open delivery order module and follow the steps for single or multiple BLs as mentioned in \"DO with multiple Bls- 04-03-25\" sheet", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_Start(30, "Click new button ", test, test1);
		newButton(driver);
		Step_End(30, "Click new button ", test, test1);
		List<String> act_HBL_Numbers =  splitAndExpand(HBL_Numbers, ",");
		for(int i = 0;i<act_HBL_Numbers.size();i++) {
			Step_Start(31, "Click the \" ADD \" Button", test, test1);
			waitForElement(driver, DO_Add_Button);
			click(driver, DO_Add_Button);
			Step_End(31, "Click the \" ADD \" Button", test, test1);
			Step_Start(32, "Paste the  BL number, click search  and fetch the record", test, test1);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterdelivery, act_HBL_Numbers.get(i), "", "", "", "");
			Step_End(32, "Paste the  BL number, click search  and fetch the record", test, test1);
		}
		Step_Start(33, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_show);
		doubleClick(driver, DO_show);
		Step_End(33, "Click the SHOW button", test, test1);
		Step_Start(34, "Select the container details in below grid", test, test1);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(34, "Select the container details in below grid", test, test1);
		Step_Start(35, "Click the Save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(35, "Click the Save button", test, test1);
		Step_Start(36, "Ensure system validated as ' Master/House BL Invoice(s) is not fully collected '", test, test1);
		waitForPopup(driver,Popup_Message,DO_POP_EXP);
		String DO_POP_ACT = getText(driver, Popup_Message);
		if (DO_POP_EXP.equals(DO_POP_ACT)) {
			System.out.println("Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT, test,test1);
			Extent_call(test, test1, DO_POP_ACT);
		} else {
			System.out.println("NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_fail(driver,"NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT,test, test1);
		}
		Step_End(36, "Ensure system validated as 'Master/House BL Invoice(s) is not fully collected'", test, test1);
		scrollTop(driver);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			waitForElement(driver, Module_Close);
			jsClick(driver, Module_Close);
			//		Cheque Realization
			List<String> actualReciept = removeDuplicateStrings(Reciept_Numbers);
			Extent_cal(test, test1, module_ChequeRealization);
			moduleNavigate(driver, module_ChequeRealization);
			scrollTop(driver);
			waitForElement(driver, SearchButton_Toolbar);
			for(int i = 0;i<Reciept_Numbers.size();i++) {
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_ChequeRealization,actualReciept.get(i), "", "", "", "");
				waitForDisplay(driver, retrivedGlobalValue);
				if(isDisplayed(driver, retrivedGlobalValue)) {
					click(driver, retrivedGlobalValue);
					waitForElement(driver, SelectButton);
					click(driver, SelectButton);
					formatLocatorClick(driver, receipt_Row_CD, Reciept_Numbers.get(i));
					waitForElement(driver, Delete_button_toolBar);
					click(driver, Delete_button_toolBar);
					waitForElement(driver, popup_Message_Yes_Button);
					click(driver,popup_Message_Yes_Button);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}else {
					click(driver, globalSearchCloseIcon_L);
				}
			}
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			for(int i = 0;i<Reciept_Numbers.size();i++) {
				//	Receipt
				moduleNavigate(driver, module_Receipt);
				Extent_cal(test, test1, module_Receipt);
				scrollTop(driver);
				waitForElement(driver, SearchButton_Toolbar);
				jsClick(driver, SearchButton_Toolbar);
				globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_Receipt2, actualReciept.get(i), "", "", "", "");
				waitForDisplay(driver, DO_horizontal_Scroll);
				if(isdisplayed(driver, DO_horizontal_Scroll)) {
					waitForElement(driver, DO_horizontal_Scroll);
					horizontalscroll(driver, DO_horizontal_Scroll, 2500);
					waitForElement(driver, receipt_Status_Filter);
					sendKeys(driver, receipt_Status_Filter, receipt_Status_Filer_Data);
					if(isdisplayed(driver, retrivedGlobalValue)) {
						waitForElement(driver, retrivedGlobalValue);
						click(driver, retrivedGlobalValue);
						waitForElement(driver, SelectButton);
						click(driver, SelectButton);
						scrollTop(driver);
						waitForDisplay(driver, Delete_button_toolBar);
						if(isdisplayed(driver, Delete_button_toolBar)) {
							waitForElement(driver, reciept_remarks_TextArea);
							sendKeys(driver, reciept_remarks_TextArea, receiptRemark);
							click(driver, Delete_button_toolBar);
							waitForElement(driver, popup_Message_Yes_Button);
							click(driver, popup_Message_Yes_Button);
							waitForElement(driver, popup_Message_Ok_Button);
							click(driver, popup_Message_Ok_Button);
						}else {
							waitForElement(driver, globalSearchCloseIcon_L);
							click(driver, globalSearchCloseIcon_L);
						}
					}else {
						waitForElement(driver, globalSearchCloseIcon_L);
						click(driver, globalSearchCloseIcon_L);
					}
				}else {
					waitForElement(driver, globalSearchCloseIcon_L);
					click(driver, globalSearchCloseIcon_L);
				}
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
			}
			//Invoice Reversal
			Extent_cal(test, test1, module_InvoiceReversal);
			List<String> actualInvoice_Numbers= removeDuplicateStrings(Invoice_Numbers);
			moduleNavigate(driver, module_InvoiceReversal);
			for(int i = 0;i<Invoice_Numbers.size();i++) {
				newButton(driver);
				waitForElement(driver, invoiceNo_SearchButton);
				click(driver, invoiceNo_SearchButton);
				globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_InvoiceReversal, actualInvoice_Numbers.get(i), "", "", "", "");
				if(isdisplayed(driver, retrivedGlobalValue)) {
					waitForElement(driver, retrivedGlobalValue);
					click(driver, retrivedGlobalValue);
					waitForElement(driver, SelectButton);
					click(driver, SelectButton);
					waitForElement(driver, invoiceReversal_Show_Button);
					click(driver, invoiceReversal_Show_Button);
					formatLocatorClick(driver, issuedInvoice_Row, issuedInvoiceColor);
					waitForElement(driver, invoiceReversal_Remarks_TextArea);
					click(driver, invoiceReversal_Remarks_TextArea);
					sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);
					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
					waitForDisplay(driver, popup_Message_Yes_Button);
					if(isdisplayed(driver, popup_Message_Yes_Button)) {
						click(driver, popup_Message_Yes_Button);
					}
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					waitForElement(driver, cancel_Common_btn);
					click(driver, cancel_Common_btn);
				}else {
					waitForElement(driver, globalSearchCloseIcon_L);
					click(driver, globalSearchCloseIcon_L);
				}
			}
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
		}
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, configuration_Reset, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}