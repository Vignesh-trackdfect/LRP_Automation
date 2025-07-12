package LRP_Import_Invoice_Scripts;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Import_Invoice_Locators;

public class TC_Collection_Report_In_Detail_SC043 extends Keywords {

	public void Collection_Report_In_DetailSC43(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws AWTException {

		String testcase_Name = "TC_Collection_Report_In_Detail_SC043";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Receipt_Module = Excel_data.get("Receipt_Module");
		String customer_Code_Input = Excel_data.get("customer_Code_Input");
		String customer_Code = Excel_data.get("customer_Code");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String saved_pop = Excel_data.get("saved_pop");
		String bankname = Excel_data.get("bankname");
		String payment_Mode = Excel_data.get("PaymentMode");
		String currencyCode = Excel_data.get("CurrencyCode");
		String Amount_Value_Receipt = Excel_data.get("Amount_Value_Receipt");
		String Receipt_Global_SearchType = Excel_data.get("Receipt_Global_SearchType");
		String Invoice_Module = Excel_data.get("Invoice_Module");
		String Invoice_Mode_Option = Excel_data.get("Invoice_Mode_Option");
		String receiptSavedPopup = Excel_data.get("ReceiptSavedPopup");
		String deposit_bank = Excel_data.get("deposit_bank");
		String Number_Value_Receipt = Excel_data.get("Number_Value_Receipt");
		String roe_diff_data = Excel_data.get("roe_diff_data");
		String roe_cny_data = Excel_data.get("roe_cny_data");
		String date_Picker = Excel_data.get("date_Picker");
		String Collection_Report_Module = Excel_data.get("Collection_Report_Module");
		String Report_By_Select_Input = Excel_data.get("Report_By_Select_Input");
		String Report_Charge_Type_Select = Excel_data.get("Report_Charge_Type_Select");
		String scope_Select = Excel_data.get("scope_Select");
		String Report_Charge_Category_Type_Select = Excel_data.get("Report_Charge_Category_Type_Select");
		String exclude_Adv_Receipt_CheckBox = Excel_data.get("exclude_Adv_Receipt_CheckBox");
		String Agency_Master_Filter_type = Excel_data.get("Agency_Master_Filter_type");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String collection_report_headers = Excel_data.get("collection_report_headers");
		String Bank_Name_Header = Excel_data.get("Bank_Name_Header");
		String Deposit_Bank_Name_Header = Excel_data.get("Deposit_Bank_Name_Header");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");

		
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String GlobalSearch_Type1_Invoice = Excel_data.get("GlobalSearch_Type1_Invoice");
		String GlobalSearch_Value1_Invoice = Excel_data.get("GlobalSearch_Value1_Invoice");
		String GlobalSearch_Type2_Invoice = Excel_data.get("GlobalSearch_Type2_Invoice");
		String GlobalSearch_Value2_Invoice = Excel_data.get("GlobalSearch_Value2_Invoice");
		String GlobalSearch_Type3_Invoice = Excel_data.get("GlobalSearch_Type3_Invoice");
		String GlobalSearch_Value3_Invoice = Excel_data.get("GlobalSearch_Value3_Invoice");
		String Invoice_Already_Exist = Excel_data.get("Invoice_Already_Exist");
		
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");
		String OR_Number_Value = Excel_data.get("OR_Number_Value");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Region_Header = Excel_data.get("Region_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");
		String Charge_Detail_Report_StartDate = Excel_data.get("Charge_Detail_Report_StartDate");
		String Charge_Detail_Report_EndDate = Excel_data.get("Charge_Detail_Report_EndDate");		
		String Voyage_ROE_Module = Excel_data.get("Voyage_ROE_Module");
		String Voyage_ROE_Filter_type = Excel_data.get("Voyage_ROE_Filter_type");
		String Voyage_Currency_Header = Excel_data.get("Voyage_Currency_Header");
		String Voyage_ROE_Header = Excel_data.get("Voyage_ROE_Header");
		String Agency_ROE_Module = Excel_data.get("Agency_ROE_Module");
		String Agency_ROE_Filter_Type = Excel_data.get("Agency_ROE_Filter_Type");
		String Agency_ROE_Currency_Header = Excel_data.get("Agency_ROE_Currency_Header");
		String Agency_ROE_Header = Excel_data.get("Agency_ROE_Header");

		String Receipt_Delete = Excel_data.get("Receipt_Delete");
		String Invoice_Reverse = Excel_data.get("Invoice_Reverse");
		String Invoice_Reversal_Module = Excel_data.get("Invoice_Reversal_Module");
		String Reversal_Filter_Type = Excel_data.get("Reversal_Filter_Type");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");


		String Cannot_Cancel_Receipt_Popup = Excel_data.get("Cannot_Cancel_Receipt_Popup");
		String Cash_Deposit_Module = Excel_data.get("Cash_Deposit_Module");
		String Cash_Deposit_delete_Popup1 = Excel_data.get("Cash_Deposit_delete_Popup1");
		String Cash_Deposit_Delete_Popup2 = Excel_data.get("Cash_Deposit_Delete_Popup2");

		String Cheque_DD_Deposit_Module = Excel_data.get("Cheque_DD_Deposit_Module");
		String DD_Deposit_delete_Popup1 = Excel_data.get("DD_Deposit_delete_Popup1");
		String DD_Deposit_Delete_Popup2 = Excel_data.get("DD_Deposit_Delete_Popup2");
		
		String Cheque_module = Excel_data.get("Cheque_module");
		String Global_search_value_Receipt_No = Excel_data.get("Global_search_value_Receipt_No");
		String reset_Popup_Expected = Excel_data.get("Reset_Popup").trim();
		String reversed_successful_Expected = Excel_data.get("reversed_successful_Popup").trim();
		
		String enterRemarksPopup = Excel_data.get("EnterRemarksPopup");
		String receiptRemark = Excel_data.get("ReceiptRemark");
		String wantToDeletePopup = Excel_data.get("WantToDeletePopup");
		String cancelledPopup = Excel_data.get("CancelledPopup");
		
		String CurrencyHeader_InvCurrency = Excel_data.get("CurrencyHeader_InvCurrency");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to Agency", test, test1);

		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "Open Invoice Module");
		moduleNavigate(driver, Invoice_Module);

		Step_End(1, "Switch to Agency", test, test1);

		Step_Start(1,"Select Agency Corrector Invoice/Cross/Manifest Corrector Invoice/Miscellaneous Invoice/Slot Invoice",
				test, test1);

		waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);
		formatLocatorClick(driver, DropDown_Select, Invoice_Mode_Option);

		Step_End(1,	"Select Agency Corrector Invoice/Cross/Manifest Corrector Invoice/Miscellaneous Invoice/Slot Invoice",
				test, test1);

		Extent_call(test, test1, "If New button Not Available Skip 2nd Step");
		Step_Start(2, "Click on New Button", test, test1);

		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);
		
		if (BL_Retrive_Option.equalsIgnoreCase("By_BL") || BL_Retrive_Option.equalsIgnoreCase("By_Book")) {
			// button click
			if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) { 
				waitForElement(driver, By_BL_NumberBtn_All);
				click(driver, By_BL_NumberBtn_All);
			} else {
				waitForElement(driver, By_Book_Button_All);
				click(driver, By_Book_Button_All);
			}
			waitForElement(driver, In_bl_Search_Button);
			click(driver, In_bl_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_Type1_Invoice, GlobalSearch_Value1_Invoice, GlobalSearch_Type2_Invoice, GlobalSearch_Value2_Invoice, GlobalSearch_Type3_Invoice, GlobalSearch_Value3_Invoice);
			
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
				
			if (isdisplayed(driver, popup_Message)) {
				String poputext_Act = getText(driver, popup_Message);
				if (poputext_Act.equals(Invoice_Already_Exist)) {
					System.out.println(	"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act);
					Extent_FailNew(driver,	"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				} else {
					System.out.println("Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act);
					Extent_fail(driver,"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				}
			}

			waitForElement(driver, invoice_Customer_Text_Field);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.trim().equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);

				globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Code, customer_Code_Input, "", "", "", "");

				waitForElement(driver, In_Show_BL_Button);
				click(driver, In_Show_BL_Button);
			}
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
			waitForElement(driver, By_Vessel_Button_All);
			click(driver, By_Vessel_Button_All);
			waitForElement(driver, invoice_Service_Text_Field);
			sendKeys(driver, invoice_Service_Text_Field, Service_Code);

			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, Vessel_Code);

			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, Voyage_Number);

			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_Input);

			waitForElement(driver, POL_PortCode_Input);
			sendKeys(driver, POL_PortCode_Input, Port_Code);

			horizontalscroll(driver, InvoiceGridScroll, 300);
			click(driver, POL_PortTerminal_Input);

			sendKeys(driver, POL_PortTerminal_Input, Terminal_Code);
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);
			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);

			waitForElement(driver, In_customer_Search_Button);
			click(driver, In_customer_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Code, customer_Code_Input, "", "", "", "");

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
			
			
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
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Customer")) {
			waitForElement(driver, In_customer_Search_Button);
			click(driver, In_customer_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_Type1_Invoice, GlobalSearch_Value1_Invoice, GlobalSearch_Type2_Invoice, GlobalSearch_Value2_Invoice, GlobalSearch_Type3_Invoice, GlobalSearch_Value3_Invoice);

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
		}

		scrollTop(driver);

		Extent_call(test, test1, "Common Steps : ");


		Step_Start(4, "Click on Issue Button", test, test1);

		scrollTop(driver);
		waitForElement(driver, import_Invoice_Issued_Button);
		click1(driver, import_Invoice_Issued_Button);

		Step_End(4, "Click on Issue Button", test, test1);

		Step_Start(5, "Click on save Button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(5, "Click on save Button", test, test1);

		Step_Start(6, "Msg 'Invoice saved' then Click on ok", test, test1);

		waitForPopup(driver, popup_Message, saved_pop);

		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);

		if (saved_pop.equals(import_saved_act)) {
			Extent_pass_New(driver,	"Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : " + import_saved_act,
					test, test1);
			System.out.println("Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : " + import_saved_act);
		} else {
			System.out.println("Not Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
					+ import_saved_act);
			Extent_fail(driver, "Not Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
					+ import_saved_act, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(6, "Msg 'Invoice saved' then Click on ok", test, test1);
		
		String VesselValue;
		if (Invoice_Module.equals("Invoice")) {
			waitForElement(driver, Vessel_TxtField_Invoice);
			VesselValue = getAttribute(driver, Vessel_TxtField_Invoice, "value");
		} else {
			waitForElement(driver, vessel_Txtfield_All);
			VesselValue = getAttribute(driver, vessel_Txtfield_All, "value");
		}
		
		waitForElement(driver, Invoice_Table_Row_All);
		List<Map<String, String>> invoice_Table_Data = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String inv_number = getFirstValueByHeader(invoice_Table_Data, "Inv Number");
		String ROE_Value = getFirstValueByHeader(invoice_Table_Data, "ROE Type");
		String Invoice_Date = getFirstValueByHeader(invoice_Table_Data, "Inv Date");
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");
		String ETAValue = getText(driver, ETA_Date_Input_All);
		String inv_Currency = getFirstValueByHeader(invoice_Table_Data, "Inv Currency");
		
		Extent_call(test, test1, "Then Follow All Steps again with Different BLs");

		// Receipt
		Step_Start(1, "open the receipt module", test, test1);
		moduleNavigate(driver, Receipt_Module);
		Step_End(1, "open the receipt module", test, test1);

		newButton(driver);
	
		waitForDisplay(driver, selectedInvoice_Button);
		click(driver, selectedInvoice_Button);

		waitForDisplay(driver, Invoice_Currency_Receipt);
		if(isdisplayed(driver, Invoice_Currency_Receipt)) {
			waitForElement(driver, Invoice_Currency_Receipt);
			String cur_Receipt=getAttribute(driver, Invoice_Currency_Receipt, "value");
			if(!cur_Receipt.equals(inv_Currency)) {
				waitForElement(driver, Invoice_currency_search_Button);
				click(driver,Invoice_currency_search_Button);
				twoColumnSearchWindow(driver, CurrencyHeader_InvCurrency, Two_Column_Search_Condition, inv_Currency);
			}
		}
		
		waitForElement(driver, receipt_Customer_Name_SearchBtn);
		click(driver, receipt_Customer_Name_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearch_Condition, Receipt_Global_SearchType, inv_number, "", "", "", "");

		waitForElement(driver, selectedInvoice_Show_Button);
		click(driver, selectedInvoice_Show_Button);

		waitForElement(driver, InvoiceAndReceipt_Tab);
		click(driver, InvoiceAndReceipt_Tab);

		waitForElement(driver, reciept_Table_Row);
		if (isdisplayed(driver, reciept_Table_Row)) {
			System.out.println(	"Pass : Expected result is : Receipt data's should displayed in the grid|| Actual result is : Receipt data's are displayed in the grid");
			Extent_pass_New(driver,	"Pass : Expected result is : Receipt data's should displayed in the grid|| Actual result is : Receipt data's are displayed in the grid",
					test, test1);
		} else {
			System.out.println(	"Fail : Expected result is : Receipt data's should displayed in the grid|| Actual result is : Receipt data's are not displayed in the grid");
			Extent_fail(driver,	"Fail : Expected result is : Receipt data's should displayed in the grid|| Actual result is : Receipt data's are not displayed in the grid",
					test, test1);
		}

		waitForElement(driver, paymentDetails_Tab);
		click(driver, paymentDetails_Tab);
		if(!payment_Mode.equals("")) {
				waitForElement(driver, paymentMode_Dropdown);
				click(driver, paymentMode_Dropdown);
				String select_Mode = String.format(paymentMode, payment_Mode);
				waitForDisplay(driver, select_Mode);
				click(driver, select_Mode);
		}
		Step_Start(3, "Input All The Entry from Test Data", test, test1);

		// currency
		waitForDisplay(driver, currency_SearchButton);
		if (!currencyCode.trim().equals("")&&IsElementEnabled(driver, currency_SearchButton)) {
			click(driver, currency_SearchButton);
			twoColumnSearchWindow(driver, Currency_Code_Header, Two_Column_Search_Condition, currencyCode);
		}

		// number data
		if (!Number_Value_Receipt.trim().equals("")) {
			waitForElement(driver, number_data_txtfld);
			Newclear(driver, number_data_txtfld);
			sendKeys(driver, number_data_txtfld, Number_Value_Receipt);
		}
		
		if (!Amount_Value_Receipt.trim().equals("")) {
			waitForElement(driver, amount_Textfield);
			Newclear(driver, amount_Textfield);
			sendKeys(driver, amount_Textfield, Amount_Value_Receipt);
			click(driver, payerAddress_InputField);
		}		
		
		// bank
		if (!bankname.trim().equals("")&&IsElementEnabled(driver, bank_Search_Icon)) {
			waitForElement(driver, bank_Search_Icon);
			click(driver, bank_Search_Icon);
			twoColumnSearchWindow(driver, Bank_Name_Header, Two_Column_Search_Condition, bankname);
		}

		// deposit bank
		if (!deposit_bank.trim().equals("")&&IsElementEnabled(driver, deposit_Bank_Search_Icon)) {
			// deposit bank
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);
			twoColumnSearchWindow(driver, Deposit_Bank_Name_Header, Two_Column_Search_Condition, deposit_bank);
		}
		
		// roe diff
		if (!roe_diff_data.trim().equals("")&&IsElementEnabled(driver, roe_diff_txtfld)) {
			waitForElement(driver, roe_diff_txtfld);
			Newclear(driver, roe_diff_txtfld);
			sendKeys(driver, roe_diff_txtfld, roe_diff_data);
		}

		// roe cny
		if (!roe_cny_data.trim().equals("")&&IsElementEnabled(driver, roe_charges_in_cny)) {
			waitForElement(driver, roe_charges_in_cny);
			Newclear(driver, roe_charges_in_cny);
			sendKeys(driver, roe_charges_in_cny, roe_cny_data);
		}
		
		// OR Number
		if (!OR_Number_Value.trim().equals("")&&IsElementEnabled(driver, OR_Number_Input_Receipt)) {
			waitForElement(driver, OR_Number_Input_Receipt);
			Newclear(driver, OR_Number_Input_Receipt);
			sendKeys(driver, OR_Number_Input_Receipt, OR_Number_Value);
		}

		Step_End(3, "Input All The Entry from Test Data", test, test1);

		waitForElement(driver, paymentDetails_Add_Button);
		click(driver, paymentDetails_Add_Button);

		waitForElement(driver, InvoiceAndReceipt_Tab);
		click(driver, InvoiceAndReceipt_Tab);

		waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
		checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");

		waitForElement(driver, allocate_Button);
		click(driver, allocate_Button);

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForDisplay(driver, popup_Message_Yes_Button);
		if (isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			String actualSavedPopup = getText(driver, popup_Message);
			if (actualSavedPopup.equals(receiptSavedPopup)) {
				System.out.println(	"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
				Extent_pass_New(driver,"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup,
						test, test1);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : "
						+ actualSavedPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : "
						+ actualSavedPopup, test, test1);
			}
		}

		String retrieved_Receipt_Number = getAttribute(driver, receipt_Num_Txtfield, "value");
		Extent_cal(test, test1, retrieved_Receipt_Number);
		String amount_In_Receipt = getText(driver, total_Amount_In_Receipt);

		double Exp_receiptAmount=getNumberValue(amount_In_Receipt);
		System.out.println("the retrieved receipt number is : " + retrieved_Receipt_Number);
		System.out.println("amount created in receipt is :" + amount_In_Receipt);
		waitForElement(driver, Mode_of_Payment_Receipt);
		String ReceiptMode=getText(driver, Mode_of_Payment_Receipt);

		// navigate to agency master module
		moduleNavigate(driver, Agency_Master_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, GlobalSearch_Condition, Agency_Master_Filter_type, AgencyUser, "", "", "", "");

		waitForElement(driver, CurrencyCode_AgencyMaster);
		String Agency_ROE_ValueExp = getAttribute(driver, CurrencyCode_AgencyMaster, "value");

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		// navigating to collection report in detail

		Step_Start(2, "Open Collection Report in Details module", test, test1);

		moduleNavigate(driver, Collection_Report_Module);

		Step_End(2, "Open Collection Report in Details module", test, test1);

		newButton(driver);

		waitForElement(driver, collection_Report_By_Dropdown);
		if (!Report_By_Select_Input.trim().equals("")) {
			click(driver, collection_Report_By_Dropdown);
			formatLocatorClick(driver, DropDown_Select, Report_By_Select_Input);

		}
		
		if(AgencyUser.trim().equals("")) {
			if(!scope_Select.trim().equals("")) {
				waitForElement(driver, collection_Report_Scope_Dropdown);
				click(driver, collection_Report_Scope_Dropdown);
				formatLocatorClick(driver, DropDown_Select, scope_Select);
			}
			
			if (scope_Select.equalsIgnoreCase("Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}
			if (scope_Select.equalsIgnoreCase("Region")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, Region_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}
			if (scope_Select.equalsIgnoreCase("Corporate Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}
		}

		if (Report_By_Select_Input.equalsIgnoreCase("Charges")) {

			if (!Report_Charge_Type_Select.trim().equals("")) {
				waitForElement(driver, collection_Report_Charge_Type_Dropdown);
				click(driver, collection_Report_Charge_Type_Dropdown);
				String Report_Charge_Select = String.format(Import_Invoice_Locators.collection_Report_Charge_Select,
						Report_Charge_Type_Select);
				waitForElement(driver, Report_Charge_Select);
				click(driver, Report_Charge_Select);
			}

			if (!Report_Charge_Category_Type_Select.trim().equals("")) {
				waitForElement(driver, collection_Report_Charge_Category_Dropdown);
				click(driver, collection_Report_Charge_Category_Dropdown);
				String Report_Charge_Category_Select = String.format(Import_Invoice_Locators.collection_Report_Charge_Category_Select,
						Report_Charge_Category_Type_Select);
				waitForElement(driver, Report_Charge_Category_Select);
				click(driver, Report_Charge_Category_Select);
			}

			checkBox(driver, Exclude_Advance_Receipt_CheckBox, exclude_Adv_Receipt_CheckBox);
		}
		
		 String From_date=beforeDaysToDate(Invoice_Date, Charge_Detail_Report_StartDate);
	     String To_date=addDaysToDate(Invoice_Date, Charge_Detail_Report_EndDate);
				
		if(!From_date.trim().equals("")) {
			waitForElement(driver, collection_Report_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, collection_Report_From_Date, From_date);
			} else {
				waitForElement(driver, collection_Report_From_Date);
				clearAndType(driver, collection_Report_From_Date, From_date);
			}
		}
		
		if(!To_date.trim().equals("")) {
			waitForElement(driver, collection_Report_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, collection_Report_To_Date, To_date);
			} else {
				waitForElement(driver, collection_Report_To_Date);
				clearAndType(driver, collection_Report_To_Date, To_date);
			}
		}

		Step_Start(4, "Click on Show Button", test, test1);

		waitForElement(driver, collection_Report_Show_Button);
		click(driver, collection_Report_Show_Button);

		Step_End(4, "Click on Show Button", test, test1);

		Step_Start(5, "Filter the same BL Number/Receipt number Wise", test, test1);


		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, collection_report_headers);


		Step_End(5, "Filter the same BL Number/Receipt number Wise", test, test1);

		Step_Start(6, "And verify that below Values", test, test1);
		if(BL_Number_input!=null&&!BL_Number_input.equals("-")) {
			waitForElement(driver, bl_Number_Filter_Collection_report);
			sendKeys(driver, bl_Number_Filter_Collection_report, BL_Number_input);
		}
		
		waitForElement(driver, Invoice_Number_FilterInput_CRD);
		sendKeys(driver, Invoice_Number_FilterInput_CRD, inv_number);
		
		waitForElement(driver, Receipt_No_FilterInput_CRD);
		sendKeys(driver, Receipt_No_FilterInput_CRD, retrieved_Receipt_Number);
	
		waitForElement(driver, collection_module_table);
		List<Map<String, String>> collection_report_table = extractTableDataByColumn(driver,
				collection_module_table);

		String receipt_currency = getFirstValueByHeader(collection_report_table, "Receipt Currency");
		String receipt_amount_in_CRD =getFirstValueByHeader(collection_report_table, "Receipt Amount");       // getValueByFirstColumnAndHeader(collection_report_table, "BL Number",BL_Number_input, "Receipt Amount");
		String receipt_amount_home_in_CRD = getFirstValueByHeader(collection_report_table, "Receipt Amount In Home");    //getValueByFirstColumnAndHeader(collection_report_table, "BL Number",	BL_Number_input, "Receipt Amount In Home");
		String receipt_amount_USD_in_CRD = getFirstValueByHeader(collection_report_table, "Receipt Amount In USD");     //getValueByFirstColumnAndHeader(collection_report_table, "BL Number",	BL_Number_input, "Receipt Amount In Home");
		
		double USD_AmountValue;
		double AgencyMaster_Amount;
		double Agency_Amount;
		if (ROE_Value.equalsIgnoreCase("V")) {
			moduleNavigate(driver, Voyage_ROE_Module);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, GlobalSearch_Condition, Voyage_ROE_Filter_type, VesselValue,
					"", "", "", "");

			waitForElement(driver, MoreOption_Grid);
			click(driver,MoreOption_Grid);
			
			waitForElement(driver, FilterOption_Menu);
			click(driver,FilterOption_Menu);
			
			AG_Grid_FilterInputs(driver,Voyage_Currency_Header,"USD");
			
			waitForElement(driver, Voyage_Roe_Table);
			List<Map<String, String>> VoyageROE_TableFul = extractTableDataDirect2(driver, Voyage_Roe_Table);
			String USD_Value = getValueByFirstColumnAndHeader(VoyageROE_TableFul, Voyage_Currency_Header, "USD",
					Voyage_ROE_Header);
			USD_AmountValue = getNumberValue1(USD_Value);
			
			AG_Grid_FilterInputs(driver,Voyage_Currency_Header,Agency_ROE_ValueExp);
			waitForElement(driver, Voyage_Roe_Table);
			List<Map<String, String>> VoyageROE_TableFul1 = extractTableDataDirect2(driver, Voyage_Roe_Table);
			String AgencyMasterValues = getValueByFirstColumnAndHeader(VoyageROE_TableFul1,Voyage_Currency_Header, Agency_ROE_ValueExp, Voyage_ROE_Header);
			AgencyMaster_Amount = getNumberValue1(AgencyMasterValues);

			AG_Grid_FilterInputs(driver,Voyage_Currency_Header,receipt_currency);
			waitForElement(driver, Voyage_Roe_Table);
			waitForElement(driver, Voyage_Roe_Table);
			List<Map<String, String>> VoyageROE_TableFul2 = extractTableDataDirect2(driver, Voyage_Roe_Table);
			
			String AgencyValues = getValueByFirstColumnAndHeader(VoyageROE_TableFul2, Voyage_Currency_Header,
					receipt_currency, Voyage_ROE_Header);
			Agency_Amount = getNumberValue1(AgencyValues);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		} else {

			moduleNavigate(driver, Agency_ROE_Module);
			waitForElement(driver, SearchButton_Toolbar);
			while(isdisplayed(driver, popup_Message_Ok_Button)) {
				waitForDisplay(driver, popup_Message_Ok_Button);
				jsClick(driver, popup_Message_Ok_Button);
				waitForElement(driver, SearchButton_Toolbar);
			}
			
			waitForElement(driver, Corporate_Option_AgencyROE);
			click(driver,Corporate_Option_AgencyROE);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			String DateValue;
			if (ROE_Value.equalsIgnoreCase("S")) {
				DateValue = ETAValue;
			} else {
				DateValue = Invoice_Date;
			}

			waitForElement(driver, type_Select1);
			click(driver, type_Select1);
			waitForElement(driver, type_Select1);
			selectByText(driver, type_Select1, Agency_ROE_Filter_Type);
			if (Agency_ROE_Filter_Type.equalsIgnoreCase("Roe date")) {
				waitForElement(driver, Date_Condition);
				selectByText(driver, Date_Condition, GlobalSearch_Condition);
				waitForElement(driver, Date_Input_);
				sendKeys(driver, Date_Input_, DateValue);
			} else {
				waitForElement(driver, globalSearch_Condition_Dropdown1);
				selectByText(driver, globalSearch_Condition_Dropdown1, GlobalSearch_Condition);
				waitForElement(driver, globalSearch_InputTextfield1);
				click(driver, globalSearch_InputTextfield1);
				sendKeys(driver, globalSearch_InputTextfield1, DateValue);
			}

			waitForElement(driver, globalSearch_Frame_SearchButton);
			click(driver, globalSearch_Frame_SearchButton);
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);

			waitForElement(driver, Corporate_Option_AgencyROE);
			click(driver,Corporate_Option_AgencyROE);
			
			waitForElement(driver, AgencyRoe_TableRow);
			List<Map<String, String>> AgencyROE_TableFul = getTableData(driver, AgencyRoe_TableHeader,
					AgencyRoe_TableRow);

			String USD_Value = getValueByFirstColumnAndHeader(AgencyROE_TableFul, Agency_ROE_Currency_Header,
					"USD", Agency_ROE_Header);
			USD_AmountValue = getNumberValue1(USD_Value);
			String AgencyMasterValues = getValueByFirstColumnAndHeader(AgencyROE_TableFul,
					Agency_ROE_Currency_Header, Agency_ROE_ValueExp, Agency_ROE_Header);
			AgencyMaster_Amount = getNumberValue1(AgencyMasterValues);

			String AgencyValues = getValueByFirstColumnAndHeader(AgencyROE_TableFul, Agency_ROE_Currency_Header,
					receipt_currency, Agency_ROE_Header);
			Agency_Amount = getNumberValue1(AgencyValues);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		double Act_ReciptAmount_CRD=getNumberValue(receipt_amount_in_CRD);
		double Act_HomeAmount_CRD=getNumberValue(receipt_amount_home_in_CRD);
		double Act_USDAmount_CRD=getNumberValue(receipt_amount_USD_in_CRD);
		
		double toleranceAmounut=0.03;
		List<String> FilterHeadersName = splitAndExpand(collection_report_headers);
		for (String col : FilterHeadersName) {
			
			if (col.equals("Receipt Amount")) {
				
				if (Exp_receiptAmount == Act_ReciptAmount_CRD) {
					System.out.println("Receipt Amount Matched || Expected Amount in Receipt Module : "+Exp_receiptAmount+" || Actual Receipt Amount in Collection Report Module : "+Act_ReciptAmount_CRD );
					Extent_pass_New(driver, "Receipt Amount Matched || Expected Amount in Receipt Module : "+Exp_receiptAmount+" || Actual Receipt Amount in Collection Report Module : "+Act_ReciptAmount_CRD , test, test1);
				}else {
					System.out.println("Receipt Amount Not Matched || Expected Amount in Receipt Module : "+Exp_receiptAmount+" || Actual Receipt Amount in Collection Report Module : "+Act_ReciptAmount_CRD );
					Extent_fail(driver, "Receipt Amount Not Matched || Expected Amount in Receipt Module : "+Exp_receiptAmount+" || Actual Receipt Amount in Collection Report Module : "+Act_ReciptAmount_CRD , test, test1);
				}
			}else if (col.equals("Receipt Amount In Home")) {
				
				if (receipt_currency.equals(Agency_ROE_ValueExp)) {
					
					if (Exp_receiptAmount == Act_ReciptAmount_CRD) {
						System.out.println("Receipt Amount In Home Matched  for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+Exp_receiptAmount+" || Actual Amount : "+Act_ReciptAmount_CRD );
						Extent_pass_New(driver, "Receipt Amount In Home Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+Exp_receiptAmount+" || Actual Amount : "+Act_ReciptAmount_CRD , test, test1);
					}else {
						System.out.println("Receipt Amount In Home Not Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+Exp_receiptAmount+" || Actual Amount : "+Act_ReciptAmount_CRD );
						Extent_fail(driver, "Receipt Amount In Home Not Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+Exp_receiptAmount+" || Actual Amount : "+Act_ReciptAmount_CRD , test, test1);
					}
				}else if (receipt_currency.equalsIgnoreCase("USD")) {
				
					double expHomeAmount = Exp_receiptAmount * AgencyMaster_Amount;
					expHomeAmount = Double.parseDouble(String.format("%.2f", expHomeAmount));
					if (compareAmounts(expHomeAmount, Act_HomeAmount_CRD, toleranceAmounut)) {
						System.out.println("Receipt Amount In Home Matched  for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD );
						Extent_pass_New(driver, "Receipt Amount In Home Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD , test, test1);
					}else {
						System.out.println("Receipt Amount In Home Not Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD );
						Extent_fail(driver, "Receipt Amount In Home Not Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD , test, test1);
					}
				}else {
					
					double expHomeAmount = Exp_receiptAmount * (AgencyMaster_Amount / Agency_Amount);
					expHomeAmount = Double.parseDouble(String.format("%.2f", expHomeAmount));
					if (compareAmounts(expHomeAmount, Act_HomeAmount_CRD, toleranceAmounut)) {
						System.out.println("Receipt Amount In Home Matched  for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD );
						Extent_pass_New(driver, "Receipt Amount In Home Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD , test, test1);
					}else {
						System.out.println("Receipt Amount In Home Not Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD );
						Extent_fail(driver, "Receipt Amount In Home Not Matched for  Receipt Currency '"+receipt_currency+"' || Expected Amount : "+expHomeAmount+" || Actual Amount : "+Act_HomeAmount_CRD , test, test1);
					}
				}
			}else if (col.equals("Receipt Amount In USD")) {
				
				double usdAmountExp = Exp_receiptAmount * (USD_AmountValue / Agency_Amount);
				usdAmountExp = Double.parseDouble(String.format("%.2f", usdAmountExp));
				
				if (compareAmounts(usdAmountExp, Act_USDAmount_CRD, toleranceAmounut)) {
					System.out.println("Receipt Amount In USD Matched || Expected Amount : "+usdAmountExp+" || Actual  Amount : "+Act_USDAmount_CRD );
					Extent_pass_New(driver, "Receipt In USD Amount Matched || Expected Amount : "+usdAmountExp+" || Actual Amount : "+Act_USDAmount_CRD , test, test1);
				}else {
					System.out.println("Receipt Amount In USD Not Matched || Expected Amount : "+usdAmountExp+" || Actual Amount : "+Act_USDAmount_CRD );
					Extent_fail(driver, "Receipt Amount In USD Not Matched || Expected Amount : "+usdAmountExp+" || Actual Amount : "+Act_USDAmount_CRD , test, test1);
				}
			}
		}
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
if(Receipt_Delete.equalsIgnoreCase("Yes")) {
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			waitForElement(driver, popup_Message);
			String PoupValue=getText(driver, popup_Message);			
			if(PoupValue.contains(Cannot_Cancel_Receipt_Popup)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				if(ReceiptMode.equalsIgnoreCase("Cash")) {
					DeleteReceiptInCashDeposit(driver,Cash_Deposit_Module,GlobalSearch_Condition,Global_search_value_Receipt_No,retrieved_Receipt_Number,Cash_Deposit_delete_Popup1,Cash_Deposit_Delete_Popup2);
				}else if (ReceiptMode.equalsIgnoreCase("Wire Transfer")) {
					DeleteReceiptInChequeRealization(driver,Cheque_module,GlobalSearch_Condition,Global_search_value_Receipt_No,retrieved_Receipt_Number,reset_Popup_Expected,reversed_successful_Expected);
				}else if(ReceiptMode.equalsIgnoreCase("Cheque")) {
					DeleteReceiptInDD_Deposit(driver,Cheque_DD_Deposit_Module,GlobalSearch_Condition,Global_search_value_Receipt_No,retrieved_Receipt_Number,DD_Deposit_delete_Popup1,DD_Deposit_Delete_Popup2);
				}				
			}else {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
			}
			
			waitForElement(driver, Delete_button_toolBar);
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

			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, enterRemarksPopup);

			String actEnterRemarks_popup = getText(driver, popup_Message);

			if (actEnterRemarks_popup.equals(enterRemarksPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);


				click(driver, reciept_Popup_Ok);

			} else {
				System.out.println("Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);

			}

			waitForElement(driver, reciept_remarks_TextArea);
			sendKeys(driver, reciept_remarks_TextArea, receiptRemark);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, wantToDeletePopup);
			String actWantToDelete_popup = getText(driver, popup_Message);
			if (actWantToDelete_popup.equals(wantToDeletePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "	+ actWantToDelete_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "+ actWantToDelete_popup);

				click(driver, reciept_Popup_Yes);

			} else {
				System.out.println("Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);

			}

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
			
			
			
			if(Invoice_Reverse.equalsIgnoreCase("Yes")) {
				Extent_cal(test, test1, "Delete / Reverse Invoice - Start");
				Invoice_Reversal(driver,Invoice_Reversal_Module,GlobalSearch_Condition,Reversal_Filter_Type,inv_number,Invoice_Reversal_Remark,Invoice_Reversal_Success);
				Extent_cal(test, test1, "Delete / Reverse Invoice - End");
			}
			
		}


		Extent_completed(testcase_Name, test, test1);

	}
}
