package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import locators.Customer_Statement_Report_Locators;


public class TC_Customer_Statement_SC045A extends Keywords {
	public void Customer_Statement_SC045A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Customer_Statement_SC045A";
		
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
		String cheque_Number = Excel_data.get("cheque_Number");
		String payment_Mode = Excel_data.get("PaymentMode");
		String currencyCode = Excel_data.get("CurrencyCode");
		String amount = Excel_data.get("Amount");
		String Customer_Search_Filter_Type = Excel_data.get("Customer_Search_Filter_Type");
		String Invoice_Module = Excel_data.get("Invoice_Module");
		String Invoice_Mode_Option = Excel_data.get("Invoice_Mode_Option");
		String payAt_Value = Excel_data.get("payAt_Value");
		String receiptSavedPopup = Excel_data.get("receiptSavedPopup");
		String customer_Statement_Report_Module = Excel_data.get("customer_Statement_Report_Module");
		String Invoice_type_Input_Select = Excel_data.get("Invoice_type_Input_Select");
		String charge_type_Input_Select = Excel_data.get("charge_type_Input_Select");
		String scope_type_Input_Select = Excel_data.get("scope_type_Input_Select");
		String radio_Button_By_Input = Excel_data.get("radio_Button_By_Input");
		String customer_group_Input = Excel_data.get("customer_group_Input");
		String customer_Search_Filter = Excel_data.get("customer_Search_Filter");
		String Service_Code_Input = Excel_data.get("Service_Code_Input");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Voyage_Code_Input = Excel_data.get("Voyage_Code_Input");
		String port_Code_Input = Excel_data.get("port_Code_Input");
		String customer_name_Search_Filter = Excel_data.get("customer_name_Search_Filter");
		String customer_name_Input = Excel_data.get("customer_name_Input");
		String BL_Search_Filter = Excel_data.get("BL_Search_Filter");
		String date_Picker = Excel_data.get("date_Picker");
		String Input_Select_Radio_Button = Excel_data.get("Input_Select_Radio_Button");
		String checkBox_Aging_Bucket = Excel_data.get("checkBox_Aging_Bucket");
		String checkBox_Summary = Excel_data.get("checkBox_Summary");
		String no_Record_Popup = Excel_data.get("no_Record_Popup");
		String ServiceHeader = Excel_data.get("ServiceHeader");
		String VesselHeader = Excel_data.get("VesselHeader");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String PortHeader = Excel_data.get("PortHeader");
		String Bank_Name_Header = Excel_data.get("Bank_Name_Header");
		String Currency_Value_Code_Header = Excel_data.get("Currency_Value_Code_Header");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		
		String customer_statement_report_headers = Excel_data.get("customer_statement_report_headers");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String GlobalSearch_Type1_Invoice = Excel_data.get("GlobalSearch_Type1_Invoice");
		String GlobalSearch_Value1_Invoice = Excel_data.get("GlobalSearch_Value1_Invoice");
		String GlobalSearch_Type2_Invoice = Excel_data.get("GlobalSearch_Type2_Invoice");
		String GlobalSearch_Value2_Invoice = Excel_data.get("GlobalSearch_Value2_Invoice");
		String GlobalSearch_Type3_Invoice = Excel_data.get("GlobalSearch_Type3_Invoice");
		String GlobalSearch_Value3_Invoice = Excel_data.get("GlobalSearch_Value3_Invoice");
		String Invoice_Already_Exist = Excel_data.get("Invoice_Already_Exist");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Deposit_Bank_Name_Header = Excel_data.get("Deposit_Bank_Name_Header");
		String deposit_bank = Excel_data.get("deposit_bank");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");
		String Cust_Statement_Report_StartDate = Excel_data.get("Cust_Statement_Report_StartDate");
		String Cust_Statement_Report_EndDate = Excel_data.get("Cust_Statement_Report_EndDate");
		String Receipt_Delete = Excel_data.get("Receipt_Delete");
		String Invoice_Reverse = Excel_data.get("Invoice_Reverse");
		String Invoice_Reversal_Module = Excel_data.get("Invoice_Reversal_Module");
		String Reversal_Filter_Type = Excel_data.get("Reversal_Filter_Type");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");
		String CSR_Table_Invoice_No_Header = Excel_data.get("CSR_Table_Invoice_No_Header");
		String CSR_Table_Invoice_Date_Header = Excel_data.get("CSR_Table_Invoice_Date_Header");

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
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "Open Invoice Module");
		moduleNavigate(driver, Invoice_Module);

		Step_Start(1,
				"Select Agency Corrector Invoice/Cross/Manifest Corrector Invoice/Miscellaneous Invoice/Slot Invoice",
				test, test1);
		waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);
		String invoice_Option = String.format(DropDown_Select, Invoice_Mode_Option);
		waitForElement(driver, invoice_Option);
		click(driver, invoice_Option);

		Step_End(1,
				"Select Agency Corrector Invoice/Cross/Manifest Corrector Invoice/Miscellaneous Invoice/Slot Invoice",
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
		
		
		waitForElement(driver, Invoice_Table_Header_All);
		waitForElement(driver, Invoice_Table_Row_All);
		List<Map<String, String>> invoice_Table_Data = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String inv_number = getFirstValueByHeader(invoice_Table_Data, "Inv Number");
		String inv_Amount = getFirstValueByHeader(invoice_Table_Data, "Amount");
		String inv_Date = getFirstValueByHeader(invoice_Table_Data, "Inv Date");
		String inv_Currency = getFirstValueByHeader(invoice_Table_Data, "Inv Currency");
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");

		String CustomerName_Invoice=getFirstValueByHeader(invoice_Table_Data, "Customer Name");
		String CustomerCode_Invoice=getFirstValueByHeader(invoice_Table_Data, "Customer Code");
		
		
		moduleNavigate(driver, Receipt_Module);
		
		// Receipt
		Extent_cal(test, test1, Receipt_Module);

		Step_End(2, "open the receipt module", test, test1);
		Step_Start(3, "click the new button", test, test1);
		newButton(driver);
		Step_End(3, "click the new button", test, test1);

		Step_Start(4, "select the advance receipt module", test, test1);
		waitForElement(driver, againstInvoice_Button);
		
		Step_End(4, "select the advance receipt module", test, test1);
		waitForElement(driver, receipt_Customer_Name_SearchBtn);
		if(isElementAccessible(driver, Invoice_currency_search_Button)) {
		click(driver, Invoice_currency_search_Button);
		twoColumnSearchWindow(driver, "Currency Code", Two_Column_Search_Condition, inv_Currency);
		}
		Step_Start(5, "select the  customer in customer name field-------customername or code given in excel", test,
				test1);

		waitForElement(driver, receipt_Customer_Name_SearchBtn);
		click(driver, receipt_Customer_Name_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearch_Condition, Customer_Search_Filter_Type, inv_number, "", "", "", "");

		Step_End(5, "select the  customer in customer name field-------customername or code given in excel", test,
				test1);
		Step_Start(6,
				"once selected the customer ,customer name , address,payercode  and payername  has to be shown. from customer  master",
				test, test1);
		if(IsElementEnabled(driver, receipt_Show_Button)) {
			waitForElement(driver, receipt_Show_Button);
			click(driver, receipt_Show_Button);
		}
		
		waitForElement(driver, payerName_InputField);
		Step_Start(7, "go to the payment details", test, test1);
		waitForElement(driver, paymentDetails_Tab);
		click(driver, paymentDetails_Tab);

		Step_End(7, "go to the payment details", test, test1);
		if(!payment_Mode.equals("")) {
		Step_Start(8, "select the cheque mode in mode dropdownfield", test, test1);
		waitForElement(driver, paymentMode_Dropdown);
		click(driver, paymentMode_Dropdown);
		String select_Mode = String.format(paymentMode, payment_Mode);
		waitForDisplay(driver, select_Mode);
		click(driver, select_Mode);

		Step_End(8, "select the cheque mode in mode dropdownfield", test, test1);
		}
		if(!cheque_Number.equals("")) {
			Step_Start(9, "enter the number in number field", test, test1);
			waitForElement(driver, number_Txtfield);
			sendKeys(driver, number_Txtfield, cheque_Number);
		}
		Step_End(9, "enter the number in number field", test, test1);
		Step_Start(10, "select the payable at", test, test1);
		if (!payAt_Value.trim().equals("")&&IsElementEnabled(driver, payAt_Field)) {
			waitForElement(driver, payAt_Field);
			click(driver, payAt_Field);
			String select_payAt = String.format(payAt_Option, payAt_Value);
			waitForDisplay(driver, select_payAt);
			if(isdisplayed(driver, select_payAt)) {
				click(driver, select_payAt);
			}
		}
		Step_End(10, "select the payable at", test, test1);
		
		Step_Start(13, "select the currency", test, test1);

		if(!currencyCode.trim().equals("")&&IsElementEnabled(driver, currency_SearchButton)) {
			waitForElement(driver, currency_SearchButton);
			click(driver, currency_SearchButton);
			twoColumnSearchWindow(driver, Currency_Value_Code_Header, Two_Column_Search_Condition, currencyCode);
		}
		
		Step_End(13, "select the currency", test, test1);
		Step_Start(14, "once select the currency roe field roe has automatically fetched", test, test1);

		waitForElement(driver, roe_Textfield);
		String actual_ROE = getAttribute(driver, roe_Textfield, "value");
		if (!actual_ROE.equals("")) {
			System.out.println("Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was displayed || The selected ROE Was "
							+ actual_ROE);
			Extent_pass_New(driver,"Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was displayed || The selected ROE Was "
							+ actual_ROE,
					test, test1);
		} else {
			System.out.println("Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was not displayed|| The selected ROE Was "
							+ actual_ROE);
			Extent_fail(driver,"Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was not displayed || The selected ROE Was "
							+ actual_ROE,
					test, test1);
		}

		Step_End(14, "once select the currency roe field roe has automatically fetched", test, test1);

		// Amount * ROE
		Step_Start(12, "enter the amount", test, test1);

		if(!amount.trim().equals("")&&IsElementEnabled(driver, amount_Textfield)) {
			waitForElement(driver, amount_Textfield);
			click(driver,amount_Textfield);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
			sendKeys(driver, amount_Textfield, amount);
			click(driver, roe_Textfield);
		}
		Step_End(12, "enter the amount", test, test1);
		
		if(IsElementEnabled(driver, OR_Number_Input_Receipt)) {
			waitForElement(driver, OR_Number_Input_Receipt);
			Newclear(driver, OR_Number_Input_Receipt);
			sendKeys(driver, OR_Number_Input_Receipt, "234");
		}
		Step_Start(11, "select the bank name in bank name search field", test, test1);

		if(!bankname.trim().equals("")&&IsElementEnabled(driver, bank_Search_Icon)) {
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
				
		Step_End(11, "select the bank name in bank name search field", test, test1);

		Step_Start(16, "click the add button ", test, test1);

		waitForElement(driver, paymentDetails_Add_Button);
		click(driver, paymentDetails_Add_Button);

		Step_End(16, "click the add button ", test, test1);
		Step_Start(17, "once added the payment,below grid value has shown.", test, test1);

		waitForElement(driver, invoiceAndReceipt_Tab);
		click(driver, invoiceAndReceipt_Tab);
		Step_End(14, "go to the invoice and receipts column", test, test1);
		Step_Start(15, "click the select all button", test, test1);
		waitForElement(driver, invoice_and_Payment_Select_all_Checkbox);
		Step_End(15, "click the select all button", test, test1);

		Step_Start(16, "select the allocate button ", test, test1);
		waitForElement(driver, allocate_Btn);
		click(driver, allocate_Btn);
		Step_End(17, "once added the payment,below grid value has shown.", test, test1);
		Step_Start(18, "click the save button in tool bar", test, test1);
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(18, "click the save button in tool bar", test, test1);

		Step_Start(19, "system has validate --Receipt saved\r\n Ok", test, test1);

		waitForDisplay(driver, reciept_Popup_Yes);
		if (isdisplayed(driver, reciept_Popup_Yes)) {
			click(driver, reciept_Popup_Yes);
		}

		waitForPopup(driver, popup_Message, receiptSavedPopup);

		String actualSavedPopup = getText(driver, popup_Message);

		if (actualSavedPopup.equals(receiptSavedPopup)) {
			System.out.println("Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
			Extent_pass_New(driver,"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup, test,
					test1);
			click(driver, reciept_Popup_Ok);
		} else {
			System.out.println("Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
			Extent_fail(driver,"Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup,
					test, test1);
		}
		waitForElement(driver, receipt_Num_field);
		String Generated_Receipt_No = getAttribute(driver, receipt_Num_field, "value");
		System.out.println("New receipt number generated :" + Generated_Receipt_No);
		String Receipt_Date = getAttribute(driver, ReceiptDate_Input, "value");		
		String amount_in_receipt_module = getText(driver, total_amount_in_receipt);

		waitForElement(driver, Mode_of_Payment_Receipt);
		String ReceiptMode=getText(driver, Mode_of_Payment_Receipt);
		
		moduleNavigate(driver, customer_Statement_Report_Module);

		newButton(driver);

		if (!Invoice_type_Input_Select.equals("")) {
			waitForElement(driver, customer_Statement_Invoice_Type_Dropdown);
			click(driver, customer_Statement_Invoice_Type_Dropdown);
			String Invoice_Type_Select = String.format(DropDown_Select, Invoice_type_Input_Select);
			waitForElement(driver, Invoice_Type_Select);
			click(driver, Invoice_Type_Select);
		}

		if (!charge_type_Input_Select.equals("")) {
			waitForElement(driver, customer_statement_Charge_Type_Dropdown);
			click(driver, customer_statement_Charge_Type_Dropdown);
			String charge_Type_Select = String.format(DropDown_Select, charge_type_Input_Select);
			waitForElement(driver, charge_Type_Select);
			click(driver, charge_Type_Select);
		}

		
		if (AgencyUser.trim().equalsIgnoreCase("")) {
			if (!scope_type_Input_Select.equals("")) {
				waitForElement(driver, customer_statement_Scope_Select);
				click(driver, customer_statement_Scope_Select);
				String scope_Type_Select = String.format(DropDown_Select, scope_type_Input_Select);
				waitForElement(driver, scope_Type_Select);
				click(driver, scope_Type_Select);
			}
			
			if(scope_type_Input_Select.equals("Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);			
			}
			
			if(scope_type_Input_Select.equals("Corporate Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);		
			}
		}
		if (radio_Button_By_Input.equalsIgnoreCase("By Group")) {
			String by_Group_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Group_click);
			click(driver, by_Group_click);

			waitForElement(driver, customer_Group_Name_Search_Button);
			click(driver, customer_Group_Name_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Search_Filter, customer_group_Input, "", "", "", "");

			waitForElement(driver, customer_Group_Plus_button);
			click(driver, customer_Group_Plus_button);
		}

		if (radio_Button_By_Input.equalsIgnoreCase("By Customer")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);

			globalValueSearchWindow(driver, GlobalSearch_Condition, customer_name_Search_Filter, customer_name_Input, "", "", "",
					"");

			waitForElement(driver, customer_Group_Plus_button);
			click(driver, customer_Group_Plus_button);

		}
		
		if (radio_Button_By_Input.equalsIgnoreCase("By Service")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);

			if (!Service_Code_Input.equals("")) {
				waitForElement(driver, Service_Search_Button);
				click(driver, Service_Search_Button);

				twoColumnSearchWindow(driver, ServiceHeader, Two_Column_Search_Condition, Service_Code_Input);
			}

			if (!Vessel_Code_Input.equals("")) {
				waitForElement(driver, Vessel_Search_Button);
				click(driver, Vessel_Search_Button);

				twoColumnSearchWindow(driver, VesselHeader, Two_Column_Search_Condition, Vessel_Code_Input);
			}

			if (!Voyage_Code_Input.equals("")) {
				waitForElement(driver, Voyage_Search_Button);
				click(driver, Voyage_Search_Button);

				twoColumnSearchWindow(driver, Voyage_Header, Two_Column_Search_Condition, Voyage_Code_Input);
			}

			if (!port_Code_Input.equals("")) {
				waitForElement(driver, port_Search_Button);
				click(driver, port_Search_Button);

				twoColumnSearchWindow(driver, PortHeader, Two_Column_Search_Condition, port_Code_Input);

			}
		}

		if (radio_Button_By_Input.equalsIgnoreCase("By BL")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);
			waitForElement(driver, BL_Plus_Button);
			click(driver, BL_Plus_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, BL_Search_Filter, BL_Number_input, "", "", "", "");

		}

		if (radio_Button_By_Input.equalsIgnoreCase("By Date")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);
		}

		String input_Radio_Btn = String.format(input_Selection_Radio_Button, Input_Select_Radio_Button);
		waitForElement(driver, input_Radio_Btn);
		click(driver, input_Radio_Btn);

		waitForElement(driver, Aging_Bucket_CheckBox);
		checkBox(driver, Aging_Bucket_CheckBox, checkBox_Aging_Bucket);
		checkBox(driver, summary_CheckBox, checkBox_Summary);

		String From_date=beforeDaysToDate(Receipt_Date, Cust_Statement_Report_StartDate);
		String To_date=addDaysToDate(Receipt_Date, Cust_Statement_Report_EndDate);
		
		if (!From_date.trim().equals("")) {
			waitForElement(driver, customer_Statement_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, customer_Statement_From_Date, From_date);
			} else {
				waitForElement(driver, customer_Statement_From_Date);
				clearAndType(driver, customer_Statement_From_Date, From_date);
			}
		}

		if (!To_date.trim().equals("")) {
			waitForElement(driver, customer_Statement_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, customer_Statement_To_Date, To_date);
			} else {
				waitForElement(driver, customer_Statement_To_Date);
				clearAndType(driver, customer_Statement_To_Date, To_date);
			}
		}

		waitForElement(driver, customer_Statement_show_Button);
		click(driver, customer_Statement_show_Button);
		waitForDisplay(driver, popup);
		if (isdisplayed(driver, popup)) {
			String act_Popup = getText(driver, popup);
			if (no_Record_Popup.equals(act_Popup)) {
				System.out.println("Expected result : No popup message should display || Actual result is : "
						+ act_Popup + " Pop-up is Displayed. The Inputs Are Not Valid. Kindly provide valid inputs.");
				Extent_FailNew(driver,
						"Expected result : No popup message should display || Actual result is : " + act_Popup
								+ " Pop-up is Displayed. The Inputs Are Not Valid. Kindly provide valid inputs.",
						test, test1);
			}
		} else {

			waitForElement(driver, customer_statement_Table);
			waitForElement(driver, Tool_Pannel_CSR);
			click(driver,Tool_Pannel_CSR);
			
			waitForElement(driver, Customer_Statement_Report_Locators.FilterOption_Menu);
			click(driver,Customer_Statement_Report_Locators.FilterOption_Menu);
			
			waitForElement(driver, AG_Grid_Columns_CSR);
			safeclick(driver, AG_Grid_Columns_CSR);
			waitForElement(driver, AG_Headers_Filter_Input_CSR);
			safeclick(driver, SelectAll_CheckBox_CSR);
			List<String> columns = splitAndExpand(customer_statement_report_headers);
			for (String column : columns) {
				waitForElement(driver, AG_Headers_Filter_Input_CSR);
				Newclear(driver, AG_Headers_Filter_Input_CSR);
				waitForElement(driver, AG_Headers_Filter_Input_CSR);
				sendKeys(driver, AG_Headers_Filter_Input_CSR, column);

				String check_box = String.format(Select_Column_tableHead, column);
				waitForDisplay(driver, check_box);
				jsClick(driver, check_box);
			}
			waitForElement(driver, AG_Grid_Columns_CSR);
			click(driver, AG_Grid_Columns_CSR);
			
			
			waitForDisplay(driver, Receipt_No_FilterInput_CSR);
			if(isdisplayed(driver, Receipt_No_FilterInput_CSR)) {
			sendKeys(driver, Receipt_No_FilterInput_CSR, Generated_Receipt_No);
			}
			waitForElement(driver, customer_statement_Table);
			List<Map<String, String>> customer_statement_TableData = extractTableDataByColumn(driver, customer_statement_Table);
			
			String ReceiptNumber_CSR =getFirstValueByHeader(customer_statement_TableData, "Receipt No"); 
			
			for(String Col:columns) {
				
				if(Col.equals("Customer Code")) {
					String CustomerCode_CSR=getFirstValueByHeader(customer_statement_TableData, "Customer Code"); 
					if(CustomerCode_CSR.equals(CustomerCode_Invoice)) {
						System.out.println("Customer Code Matched ||  Expected Code in Invoice : "+CustomerCode_Invoice+" || Actual Code in Customer statement Report : "+ CustomerCode_CSR);
						Extent_pass(driver, "Customer Code Matched ||  Expected Code in Invoice : "+CustomerCode_Invoice+" || Actual Code in Customer statement Report : "+ CustomerCode_CSR, test, test1);
					}else {
						System.out.println("Customer Code Not Matched ||  Expected Code in Invoice : "+CustomerCode_Invoice+" || Actual Code in Customer statement Report : "+ CustomerCode_CSR);
						Extent_fail(driver, "Customer Code Not Matched ||  Expected Code in Invoice : "+CustomerCode_Invoice+" || Actual Code in Customer statement Report : "+ CustomerCode_CSR, test, test1);
					}
				}else if(Col.equals("Customer Name")) {
					
					String CustomerName_CSR = getFirstValueByHeader(customer_statement_TableData, "Customer Name");
					if(CustomerName_Invoice.equals(CustomerName_CSR)) {
						System.out.println("Customer Name Matched ||  Expected Code : "+CustomerName_Invoice+" || Actual Name in Customer statement Report : "+ CustomerName_CSR);
						Extent_pass(driver, "Customer Name Matched ||  Expected Code : "+CustomerName_Invoice+" || Actual Name in Customer statement Report : "+ CustomerName_CSR, test, test1);
					}else {
						System.out.println("Customer Name Not Matched ||  Expected Code : "+CustomerName_Invoice+" || Actual Name in Customer statement Report : "+ CustomerName_CSR);
						Extent_fail(driver, "Customer Name Not Matched ||  Expected Code : "+CustomerName_Invoice+" || Actual Name in Customer statement Report : "+ CustomerName_CSR, test, test1);
					}
				}else if(Col.equals(CSR_Table_Invoice_No_Header)) {
					String Invoice_Num_CSR = getFirstValueByHeader(customer_statement_TableData, CSR_Table_Invoice_No_Header);
					if(inv_number.equals(Invoice_Num_CSR)) {
						System.out.println("Invoice Number Matched ||  Expected Invoice Number : "+inv_number+" || Actual Invoice Number in Customer statement Report : "+ Invoice_Num_CSR);
						Extent_pass(driver, "Invoice Number Matched ||  Expected Invoice Number  : "+inv_number+" || Actual Invoice Number in Customer statement Report : "+ Invoice_Num_CSR, test, test1);
					}else {
						System.out.println("Invoice Number Not Matched ||  Expected Invoice Number : "+inv_number+" || Actual Invoice Number in Customer statement Report : "+ Invoice_Num_CSR);
						Extent_fail(driver, "Invoice Number Not Matched ||  Expected Invoice Number  : "+inv_number+" || Actual Invoice Number in Customer statement Report : "+ Invoice_Num_CSR, test, test1);
					}
				}else if (Col.equals(CSR_Table_Invoice_Date_Header)) {
					String Invoice_date_CSR = getFirstValueByHeader(customer_statement_TableData, CSR_Table_Invoice_Date_Header);
					if(inv_Date.equals(Invoice_date_CSR)) {
						System.out.println("Invoice Date Matched ||  Expected Invoice Date : "+inv_Date+" || Actual Invoice Date in Customer statement Report : "+ Invoice_date_CSR);
						Extent_pass(driver, "Invoice Date Matched ||  Expected Invoice Date  : "+inv_Date+" || Actual Invoice Date in Customer statement Report : "+ Invoice_date_CSR, test, test1);
					}else {
						System.out.println("Invoice Date Not Matched ||  Expected Invoice Date : "+inv_Date+" || Actual Invoice Date in Customer statement Report : "+ Invoice_date_CSR);
						Extent_fail(driver, "Invoice Date Not Matched ||  Expected Invoice Date  : "+inv_Date+" || Actual Invoice Date in Customer statement Report : "+ Invoice_date_CSR, test, test1);
					}
				}else if (Col.equals("Invoice Amount")) {
					
					double ExpInv_Amt=getNumberValue(inv_Amount);
					String Invoice_Amount_CSR = getFirstValueByHeader(customer_statement_TableData, "Invoice Amount");
					double Invoice_Amt_CSR=getNumberValue(Invoice_Amount_CSR);
					if(Invoice_Amt_CSR==ExpInv_Amt) {
						System.out.println("Invoice Amount Matched ||  Expected Invoice Amount : "+ExpInv_Amt+" || Actual Invoice Amount in Customer statement Report : "+ Invoice_Amt_CSR);
						Extent_pass(driver, "Invoice Amount Matched ||  Expected Invoice Amount  : "+ExpInv_Amt+" || Actual Invoice Amount in Customer statement Report : "+ Invoice_Amt_CSR, test, test1);
					}else {
						System.out.println("Invoice Amount Not Matched ||  Expected Invoice Amount : "+ExpInv_Amt+" || Actual Invoice Amount in Customer statement Report : "+ Invoice_Amt_CSR);
						Extent_fail(driver, "Invoice Amount Not Matched ||  Expected Invoice Amount  : "+ExpInv_Amt+" || Actual Invoice Amount in Customer statement Report : "+ Invoice_Amt_CSR, test, test1);
					}
				}else if (Col.equals("Receipt Amount")) {
					String ReceiptAmt_CSR =getFirstValueByHeader(customer_statement_TableData, "Receipt Amount"); 
					double ActReceiptAmt_CSR=Math.abs(getNumberValue(ReceiptAmt_CSR));
					double amountInReceipt =Math.abs(getNumberValue(amount_in_receipt_module));
					if(ActReceiptAmt_CSR==amountInReceipt) {
						System.out.println("Receipt Amount Matched ||  Expected Receipt Amount : "+amountInReceipt+" || Actual Receipt Amount in Customer statement Report : "+ ActReceiptAmt_CSR);
						Extent_pass(driver, "Receipt Amount Matched ||  Expected Receipt Amount  : "+amountInReceipt+" || Actual Receipt Amount in Customer statement Report : "+ ActReceiptAmt_CSR, test, test1);
					}else {
						System.out.println("Receipt Amount Not Matched ||  Expected Receipt Amount : "+amountInReceipt+" || Actual Receipt Amount in Customer statement Report : "+ ActReceiptAmt_CSR);
						Extent_fail(driver, "Receipt Amount Not Matched ||  Expected Receipt Amount  : "+amountInReceipt+" || Actual Receipt Amount in Customer statement Report : "+ ActReceiptAmt_CSR, test, test1);
					}
				}else if (Col.equals("Receipt No")) {
					if(ReceiptNumber_CSR.equals(Generated_Receipt_No)) {
						System.out.println("Receipt Number Matched ||  Expected Receipt Number : "+Generated_Receipt_No+" || Actual Receipt Number in Customer statement Report : "+ ReceiptNumber_CSR);
						Extent_pass(driver, "Receipt Number Matched ||  Expected Receipt Number  : "+Generated_Receipt_No+" || Actual Receipt Number in Customer statement Report : "+ ReceiptNumber_CSR, test, test1);
					}else {
						System.out.println("Receipt Number Not Matched ||  Expected Receipt Number : "+Generated_Receipt_No+" || Actual Receipt Number in Customer statement Report : "+ ReceiptNumber_CSR);
						Extent_fail(driver, "Receipt Number Not Matched ||  Expected Receipt Number  : "+Generated_Receipt_No+" || Actual Receipt Number in Customer statement Report : "+ ReceiptNumber_CSR, test, test1);
					}
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
					DeleteReceiptInCashDeposit(driver,Cash_Deposit_Module,GlobalSearch_Condition,Global_search_value_Receipt_No,Generated_Receipt_No,Cash_Deposit_delete_Popup1,Cash_Deposit_Delete_Popup2);
				}else if (ReceiptMode.equalsIgnoreCase("Wire Transfer")) {
					DeleteReceiptInChequeRealization(driver,Cheque_module,GlobalSearch_Condition,Global_search_value_Receipt_No,Generated_Receipt_No,reset_Popup_Expected,reversed_successful_Expected);
				}else if(ReceiptMode.equalsIgnoreCase("Cheque")) {
					DeleteReceiptInDD_Deposit(driver,Cheque_DD_Deposit_Module,GlobalSearch_Condition,Global_search_value_Receipt_No,Generated_Receipt_No,DD_Deposit_delete_Popup1,DD_Deposit_Delete_Popup2);
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
