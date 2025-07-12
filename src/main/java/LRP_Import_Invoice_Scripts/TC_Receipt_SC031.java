package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Receipt_SC031 extends Keywords {

	public void Receipt_SC031(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Receipt_SC031";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Receipt_Module = Excel_data.get("Receipt_Module");
		String Condition = Excel_data.get("Condition");
		String customer_Code_Input = Excel_data.get("customer_Code_Input");
		String customer_Code = Excel_data.get("customer_Code");
		String Payable_At_Select = Excel_data.get("Payable_At_Select");
		String Receipt_Save_Popup_Msg = Excel_data.get("Receipt_Save_Popup_Msg");
		String buttonStatus = Excel_data.get("buttonStatus");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String charges_to_add = Excel_data.get("charges_to_add");
		String currencies = Excel_data.get("currencies");
		String base_rate_unit = Excel_data.get("base_rate_unit_data");
		String containers = Excel_data.get("containers_to_add");
		String rates = Excel_data.get("rate_data");
		String quantity = Excel_data.get("quantity_data");
		String remarks_data = Excel_data.get("remarks_data");
		String saved_pop = Excel_data.get("saved_pop");
		String condition = Excel_data.get("condition");
		String bankname = Excel_data.get("bankname");
		String cheque_Number = Excel_data.get("cheque_Number");
		String payment_Mode = Excel_data.get("PaymentMode");
		String currencyCode = Excel_data.get("CurrencyCode");
		String amount = Excel_data.get("Amount");
		String globalSearch_Value_1 = Excel_data.get("receipt_GlobalSearch_Value_1");
		String globalSearchFilterOption_1 = Excel_data.get("receipt_GlobalSearchFilterOption_1");
		String globalSearchFilterOption_2 = Excel_data.get("receipt_GlobalSearchFilterOption_2");
		String globalSearchFilterOption_3 = Excel_data.get("receipt_GlobalSearchFilterOption_3");
		String Invoice_Module = Excel_data.get("Invoice_Module");
		String Invoice_Mode_Option = Excel_data.get("Invoice_Mode_Option");
		String Invoice_Numbers = Excel_data.get("Invoice_Numbers");
		String OutStanding_Popup = Excel_data.get("OutStanding_Popup");
		String matched_Popup = Excel_data.get("matched_Popup");
		String Remove_Popup = Excel_data.get("Remove_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");

		
		List<String> numbers = new ArrayList<String>();
		List<String> amounts = new ArrayList<String>();
		List<String> balances = new ArrayList<String>();
		List<String> quantities = new ArrayList<String>();
		int number_Of_Invoices = Integer.parseInt(Invoice_Numbers);

		String Charge_Header = Excel_data.get("Charge_Header");
		String ROE_Header = Excel_data.get("ROE_Header");
		String BaseRateUnit_Header = Excel_data.get("BaseRateUnit_Header");
		String Container_Header = Excel_data.get("Container_Header");

		String Currency_Header = Excel_data.get("Currency_Header");
		String Bank_Header = Excel_data.get("Bank_Header");
		String Deposit_Bank_Header = Excel_data.get("Deposit_Bank_Header");
		String Deposit_Bank_Value = Excel_data.get("Deposit_Bank_Value");
		
		String Receipt_Remarks = Excel_data.get("Receipt_Remarks");
		String Excess_Invo_No = Excel_data.get("Excess_Invo_No");
		String Payer_Code_SearchType = Excel_data.get("Payer_Code_SearchType");
		String Payer_Code_Value = Excel_data.get("Payer_Code_Value");
		String Date_Value_Receipt = Excel_data.get("Date_Value_Receipt");
		String Proposed_Date_Receipt = Excel_data.get("Proposed_Date_Receipt");
		
		
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
		waitForElement(driver, invoice_Mode);
		click(driver, invoice_Mode);
		String invoice_Option = String.format(DropDown_Select, Invoice_Mode_Option);
		waitForElement(driver, invoice_Option);
		click(driver, invoice_Option);

		Step_End(1,
				"Select Agency Corrector Invoice/Cross/Manifest Corrector Invoice/Miscellaneous Invoice/Slot Invoice",
				test, test1);
		for (int j = 0; j < number_Of_Invoices; j++) {
			Extent_call(test, test1, "If New button Not Available Skip 2nd Step");

			newButton(driver);

			if (BL_Retrive_Option.equalsIgnoreCase("By Customer")) {

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, Condition, customer_Code, customer_Code_Input, "", "", "", "");

				waitForElement(driver, In_Show_BL_Button);
				click(driver, In_Show_BL_Button);
			} else {
				if (BL_Retrive_Option.equalsIgnoreCase("By BL Number")) {
					String retrival_Option = String.format(In_by_Select_Option, BL_Retrive_Option);
					waitForElement(driver, retrival_Option);
					click(driver, retrival_Option);
					Extent_call(test, test1,
							"If Agency Corrector Invoice/Cross/Manifest Corrector Invoice option Selected  user Can Able to select BY Vessel/ By BL option");
					Extent_call(test, test1, "If Selected BY Vessel Follow Below Steps");
					waitForElement(driver, In_bl_Search_Button);
					click(driver, In_bl_Search_Button);

					globalValueSearchWindow(driver, Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

				} else if (BL_Retrive_Option.equalsIgnoreCase("By Vessel")) {
					Extent_call(test, test1,
							"If Agency Corrector Invoice/Cross/Manifest Corrector Invoice option Selected  user Can Able to select BY Vessel/ By BL option");
					Step_Start(3, "click the by vessel option", test, test1);
					String retrival_Option = String.format(In_by_Select_Option, BL_Retrive_Option);
					waitForElement(driver, retrival_Option);
					click(driver, retrival_Option);
					Step_End(3, "click the by vessel option", test, test1);
					Step_Start(4, "enter the service in service field", test, test1);
					waitForElement(driver, invoice_Service_Text_Field);
					sendKeys(driver, invoice_Service_Text_Field, Service_Code);
					Step_End(4, "enter the service in service field", test, test1);
					Step_Start(5, "automatically service details has to be populated based on the given service", test,
							test1);
					waitForElement(driver, vessels_code_input);
					sendKeys(driver, vessels_code_input, Vessel_Code);
					sendKeys(driver, voyage_code_input, Voyage_Number);
					sendKeys(driver, bounnd_code_input, Bound_Input);
					sendKeys(driver, POL_PortCode_Input, Port_Code);
					horizontalscroll(driver, By_Vessel_Scroll, 500);
					if (!Terminal_Code_Input.trim().equals("")) {
						waitForElement(driver, By_Vessel_Terminal);
						sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
					}

					if (!Call_ID.trim().equals("")) {
						waitForElement(driver, By_Vessel_Call_Id);
						sendKeys(driver, By_Vessel_Call_Id, Call_ID);
					}
					Step_End(5, "automatically service details has to be populated based on the given service", test,
							test1);
					Step_Start(6, "select the service ,vessel and voyage details for that bl", test, test1);
					waitForElement(driver, service_grid_first_row);
					click(driver, service_grid_first_row);

					waitForElement(driver, service_select_btn);
					click(driver, service_select_btn);
					Step_End(6, "select the service ,vessel and voyage details for that bl", test, test1);
					Step_Start(7, "before click the customer field", test, test1);

					waitForElement(driver, In_customer_Search_Button);
					click(driver, In_customer_Search_Button);
					Step_End(7, "before click the customer field", test, test1);
					Step_Start(8, "Enter the Customer From Test Data and Load It", test, test1);

					globalValueSearchWindow(driver, Condition, customer_Code, customer_Code_Input, "", "", "",
							"");

					Step_End(8, "Enter the Customer From Test Data and Load It", test, test1);
					Step_Start(9, "Click on show BL Button", test, test1);

					waitForElement(driver, In_Show_BL_Button);
					click(driver, In_Show_BL_Button);
					Step_End(9, "Click on show BL Button", test, test1);

				} else if (BL_Retrive_Option.equalsIgnoreCase("By BL")
						|| BL_Retrive_Option.equalsIgnoreCase("By Book")) {
					Extent_call(test, test1,
							"Miscellaneous Invoice/Slot Invoice. selected user Can go by BOOK NO or By BL NO or Customer Options,(Provide these option From Test data)");
					String retrival_Option = String.format(In_by_Select_Option, BL_Retrive_Option);
					waitForElement(driver, retrival_Option);
					click(driver, retrival_Option);
					Step_Start(1, "Click on BL NO Search and Paste the BL in the search and then load the BL", test,
							test1);
					waitForElement(driver, In_bl_Search_Button);
					click(driver, In_bl_Search_Button);

					globalValueSearchWindow(driver, Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

					Step_End(1, "Click on BL NO Search and Paste the BL in the search and then load the BL", test,
							test1);

					Extent_call(test, test1, "If the Customer Details loaded in the Grid go and follow Common Steps");

					waitForElement(driver, invoice_Customer_Text_Field);
					String customer_Value = getAttribute(driver, invoice_Customer_Text_Field, "value");

					if (customer_Value.equals("")) {
						Extent_call(test, test1, "If the customer Details not loade");
						Step_Start(1, "Click on Customer Search Fields", test, test1);
						waitForElement(driver, In_customer_Search_Button);
						click(driver, In_customer_Search_Button);
						Step_End(1, "Click on Customer Search Fields", test, test1);
						Step_Start(2, "Enter the Customer via test Data and load it", test, test1);

						globalValueSearchWindow(driver, Condition, customer_Code, customer_Code_Input, "", "", "", "");

						Step_End(2, "Enter the Customer via test Data and load it", test, test1);
						Step_Start(3, "Click on SHOW BL button", test, test1);
						waitForElement(driver, In_Show_BL_Button);
						click(driver, In_Show_BL_Button);
						Step_Start(3, "Click on SHOW BL button", test, test1);

					}
				}

			}

			Extent_call(test, test1, "Common Steps : ");

			Step_Start(1, "Go to charges tab", test, test1);
			waitForElement(driver, invoice_Addtional_Charges_Tab);
			click(driver, invoice_Addtional_Charges_Tab);

			Step_End(1, "Go to charges tab", test, test1);
			List<String> charges = splitAndExpand(charges_to_add, "/");
			List<String> currencys = splitAndExpand(currencies, "/");
			List<String> base_rate_datas = splitAndExpand(base_rate_unit, "/");
			List<String> remark_datas = splitAndExpand(remarks_data, "/");
			List<String> quantity_datas = splitAndExpand(quantity, "/");
			List<String> rates_value = splitAndExpand(rates, "/");
			List<String> containers_Value = splitAndExpand(containers, "/");
			List<String> charges_to_select = splitAndExpand(charges.get(j), "/");

			for (int i = 0; i < charges_to_select.size(); i++) {
				List<String> currency = splitAndExpand(currencys.get(j), ",");
				List<String> base_rate_data = splitAndExpand(base_rate_datas.get(j), ",");
				List<String> remarks_datas = splitAndExpand(remark_datas.get(j), ",");
				List<String> quantity_data = splitAndExpand(quantity_datas.get(j), ",");
				List<String> rate = splitAndExpand(rates_value.get(j), ",");

				String charges_value = charges_to_select.get(i);
				String currency_data = currency.get(i);
				String base_rate = base_rate_data.get(i);
				String remarks = remarks_datas.get(i);
				String quantity_add = quantity_data.get(i);
				String rate_select = rate.get(i);

				quantities.add(quantity_add);
				// 2
				Step_Start(2,
						"Enter the Charge Code Currency, Base Rate, Rate(Rate Can be a Positive /Negative), QTY and Container NO (Optional)",
						test, test1);

				waitForDisplay(driver, invoice_Container_Search_Button);
				if (isdisplayed(driver, invoice_Container_Search_Button)) {
					System.out.println("Charges tab fields displayed");
				} else {
					waitForElement(driver, edit_input_fields);
					click(driver, edit_input_fields);
				}

				if(!charges_value.trim().equals("")) {
					waitForElement(driver, invoice_Charge_Search_Button);
					click(driver, invoice_Charge_Search_Button);

					twoColumnSearchWindow(driver, Charge_Header, condition, charges_value);
				}
				
				// 3
				if(!currency_data.trim().equals("")) {
					
					waitForElement(driver, invoice_Currency_Roe_Search_Button);
					click(driver, invoice_Currency_Roe_Search_Button);

					twoColumnSearchWindow(driver, ROE_Header, condition, currency_data);
				}
				

				// 4
				if(!base_rate.trim().equals("")) {
					
					waitForElement(driver, invoice_Base_Rate_Search_Button);
					click(driver, invoice_Base_Rate_Search_Button);

					twoColumnSearchWindow(driver, BaseRateUnit_Header, condition, base_rate);
				}
				
				// 5
				if(!quantity_add.trim().equals("")) {
					waitForElement(driver, invoice_Quantity_Text_Field);
					Newclear(driver, invoice_Quantity_Text_Field);
					sendKeys(driver, invoice_Quantity_Text_Field, quantity_add);
				}
				
				// 6
				waitForElement(driver, invoice_Rate_Text_Field);
				doubleClick(driver, invoice_Rate_Text_Field);
				waitForElement(driver, invoice_Rate_Text_Field);
				click(driver, invoice_Rate_Text_Field);
				waitForElement(driver, invoice_Rate_Text_Field);
				clearAndType(driver, invoice_Rate_Text_Field, rate_select);
				if (!containers_Value.get(i).equals("")) {
					List<String> container = splitAndExpand(containers_Value.get(j), ",");
					String container_add = container.get(i);
					waitForElement(driver, invoice_Container_Search_Button);
					click(driver, invoice_Container_Search_Button);

					twoColumnSearchWindow(driver, Container_Header, condition, container_add);
				}

				waitForElement(driver, invoice_Remarks_Text_Field);
				click(driver, invoice_Remarks_Text_Field);
				sendKeys(driver, invoice_Remarks_Text_Field, remarks);
				Step_End(2,
						"Enter the Charge Code Currency, Base Rate, Rate(Rate Can be a Positive /Negative), QTY and Container NO (Optional)",
						test, test1);

				Step_Start(3, "Click on Add Button", test, test1);
				waitForElement(driver, invoice_Addtinal_Charges_Add_Button);
				click(driver, invoice_Addtinal_Charges_Add_Button);
				Step_End(3, "Click on Add Button", test, test1);

			}

			Step_Start(4, "Click on Issue Button", test, test1);

			scrollTop(driver);

			waitForElement(driver, import_Invoice_Issued_Button);
			click1(driver, import_Invoice_Issued_Button);

			Step_End(4, "Click on Issue Button", test, test1);

			Step_Start(5, "Click on save Button", test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

			Step_End(5, "Click on save Button", test, test1);

			Step_Start(6, "Msg 'Invoice saved' then Click on ok", test, test1);

			waitForPopup(driver, popup_Message, saved_pop);

			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			if (saved_pop.equals(import_saved_act)) {
				Extent_pass_New(driver, "Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
						+ import_saved_act, test, test1);
				System.out.println("Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
						+ import_saved_act);
			} else {
				System.out.println("Not Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
						+ import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
						+ import_saved_act, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(6, "Msg 'Invoice saved' then Click on ok", test, test1);
			List<Map<String, String>> invoice_Table_Data = getTableData(driver, invoice_Table_Headers,
					invoice_Table_Rows);
			String inv_number = getFirstValueByHeader(invoice_Table_Data, "Inv Number");
			numbers.add(inv_number);
			String inv_Amount = getFirstValueByHeader(invoice_Table_Data, "Amount");
			amounts.add(inv_Amount);
		}

		Extent_call(test, test1, "Then Follow All Steps again with Different BLs");
		// Receipt
		Step_Start(1, "open the receipt module", test, test1);
		moduleNavigate(driver, Receipt_Module);
		Step_End(1, "open the receipt module", test, test1);

		Step_Start(3, "If New button not Enable move to step 6(Customer search fields)", test, test1);
		scrollTop(driver);
		waitForDisplay(driver, NewButton_ToolBar);
		if (isdisplayed(driver, NewButton_ToolBar)) {
			Step_Start(2, "click the new button", test, test1);
			click(driver, NewButton_ToolBar);
			Step_End(2, "click the new button", test, test1);
			Step_Start(4, "receipt mode automatically selected Against invoice option", test, test1);
			waitForElement(driver, againstInvoice_Button);
			String actualStatus = getAttribute(driver, againstInvoice_Button, "class");

			if (actualStatus.contains(buttonStatus)) {
				System.out.println(
						"Pass || Expected result is : Receipt mode automatically should select against Import invoice option || Actual result is : Receipt mode automatically selected against invoice option");
				Extent_pass_New(driver,
						"Pass || Expected result is : Receipt mode automatically should select against Import invoice option || Actual result is : Receipt mode automatically selected against invoice option",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is : Receipt mode automatically should select against Import invoice option || Actual result is : Receipt mode not automatically selected against invoice option");
				Extent_fail(driver,
						"Fail || Expected result is : Receipt mode automatically should select against Import invoice option || Actual result is : Receipt mode not automatically selected against invoice option",
						test, test1);
			}
			Step_End(4, "receipt mode automatically selected Against invoice option", test, test1);
			Step_Start(5, "receipt by automatically selected show all outstanding option", test, test1);
			Step_End(5, "receipt by automatically selected show all outstanding option", test, test1);

		}
		Step_End(3, "If New button not Enable move to step 6(Customer search fields)", test, test1);

		Step_Start(6, "select the customer Code /Name /invoice No /BL Number in customer name field", test, test1);

		Step_Start(7, "load the Details", test, test1);

		waitForElement(driver, receipt_Customer_Name_SearchBtn);
		click(driver, receipt_Customer_Name_SearchBtn);

		globalValueSearchWindow(driver, Condition, globalSearchFilterOption_1, globalSearch_Value_1,
				globalSearchFilterOption_2, customer_Code_Input, globalSearchFilterOption_3, numbers.get(0));

		Step_End(6, "select the customer Code /Name /invoice No /BL Number in customer name field", test, test1);

		Step_End(7, "load the Details", test, test1);
		Extent_call(test, test1,
				"If System shows This Message 'The total outstanding balance is a matching amount. Do you want to do matching?' click on Yes");

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			String actual_Value = getText(driver, popup_Message);
			System.out.println("Matched || Expected Pop-up value is : " + OutStanding_Popup
					+ " || Actual Pop-up value is : " + actual_Value);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + OutStanding_Popup
					+ " || Actual Pop-up value is : " + actual_Value, test, test1);
			waitForElement(driver, popup_Message_No_Button);
			click(driver, popup_Message_No_Button);

		}
		
		if(!Payer_Code_Value.trim().equals("")) {
			waitForElement(driver, Payer_Search_Btn_Receipt);
			click(driver,Payer_Search_Btn_Receipt);
			
			globalValueSearchWindow(driver, Condition, Payer_Code_SearchType, Payer_Code_Value,
					"", "", "", "");
			
		}
		
		waitForElement(driver, InvoiceAndReceipt_Tab);
		click(driver, InvoiceAndReceipt_Tab);
		waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
		checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");
		
		for(String inv:numbers) {
			waitForElement(driver, Receipt_Number_Filter);
			click(driver, Receipt_Number_Filter);
			Newclear(driver, Receipt_Number_Filter);
			sendKeys(driver, Receipt_Number_Filter, inv);
			
			formatLocatorClick(driver, Receipt_InvoiceNo_checkbox, inv);
		}


		waitForElement(driver, remove_Button);
		click(driver, remove_Button);

		waitForDisplay(driver, popup_Message_Ok_Button);
		if (isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		} 

			waitForPopup(driver, popup_Message,Remove_Popup);
			String actual_Value = getText(driver, popup_Message);
			if(Remove_Popup.equalsIgnoreCase(actual_Value)) {
				System.out.println("Matched || Expected Pop-up value is : " + Remove_Popup + " || Actual Pop-up value is : "
						+ actual_Value);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + Remove_Popup
						+ " || Actual Pop-up value is : " + actual_Value, test, test1);
			}else {
				System.out.println("Not Matched || Expected Pop-up value is : " + Remove_Popup + " || Actual Pop-up value is : "
						+ actual_Value);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + Remove_Popup
						+ " || Actual Pop-up value is : " + actual_Value, test, test1);
			}
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		

		waitForDisplay(driver, popup_Message);
		String act_Message;
		if (isdisplayed(driver, popup_Message)) {
			String actual_Value1 = getText(driver, popup_Message);
			System.out.println("Matched || Expected Pop-up value is : " + OutStanding_Popup
					+ " || Actual Pop-up value is : " + actual_Value1);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + OutStanding_Popup
					+ " || Actual Pop-up value is : " + actual_Value1, test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForElement(driver, match_Button);
			click(driver, match_Button);

			waitForPopup(driver, popup_Message, matched_Popup);

			act_Message = getText(driver, popup_Message);

			if (matched_Popup.equals(act_Message)) {
				System.out.println("Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message, test, test1);
			}
		} else {

			waitForElement(driver, paymentDetails_Tab);
			click(driver, paymentDetails_Tab);
			Step_End(7, "go to the payment details", test, test1);
			Step_Start(8, "select the cheque mode in mode dropdownfield", test, test1);

			if(!payment_Mode.trim().equals("")) {
				waitForElement(driver, paymentMode_Dropdown);
				click(driver, paymentMode_Dropdown);
				String select_Mode = String.format(paymentMode, payment_Mode);
				waitForDisplay(driver, select_Mode);
				click(driver, select_Mode);
			}
			
			Step_End(8, "select the cheque mode in mode dropdownfield", test, test1);
			if(!Excess_Invo_No.trim().equals("")) {
				waitForElement(driver, Excess_Invoice_Number_Receipt);
				click(driver,Excess_Invoice_Number_Receipt);
				formatLocatorClick(driver, DropDown_Select, Excess_Invo_No);
			}
			Step_Start(9, "enter the number in number field", test, test1);
			if (!cheque_Number.equals("")) {
				waitForElement(driver, number_Txtfield);
				sendKeys(driver, number_Txtfield, cheque_Number);
			}
			
			
			if(!Date_Value_Receipt.trim().equals("")) {
				waitForElement(driver, Date_Input_Receipt);
				click(driver, Date_Input_Receipt);
				try {
					selectDateInCalender(driver,Date_Value_Receipt,Date_Text_Value,Month_Text_Value,Year_Text_Value,previous_Button_DatePicker,next_Button_DatePicker);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(!Proposed_Date_Receipt.trim().equals("")) {
				waitForElement(driver, Proposal_Date_Input_Receipt);
				click(driver, Proposal_Date_Input_Receipt);
				try {
					selectDateInCalender(driver,Proposed_Date_Receipt,Date_Text_Value,Month_Text_Value,Year_Text_Value,previous_Button_DatePicker,next_Button_DatePicker);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			if (!bankname.equals("")) {
				waitForElement(driver, bank_Search_Icon);
				click(driver, bank_Search_Icon);
				twoColumnSearchWindow(driver, Bank_Header, condition, bankname);
			}
			if (!Payable_At_Select.equals("")) {
				waitForElement(driver, receipt_Payable_At_Dropdown);
				click(driver, receipt_Payable_At_Dropdown);
				String payable_at_select = String.format(receipt_Payable_At_Select, Payable_At_Select);
				waitForElement(driver, payable_at_select);
				click(driver, payable_at_select);
			}
			if (!currencyCode.equals("")) {
				waitForElement(driver, currency_SearchButton);
				click(driver, currency_SearchButton);
				twoColumnSearchWindow(driver, Currency_Header, condition, currencyCode);
			}
			if (!amount.equals("")) {
				waitForElement(driver, amount_Textfield);
				clearAndType(driver, amount_Textfield, amount);
				waitForElement(driver, amount_Textfield);
				click(driver, amount_Textfield);
			}
			
			if(!Deposit_Bank_Value.trim().equals("")) {
				waitForElement(driver, deposit_Bank_Search_Icon);
				click(driver, deposit_Bank_Search_Icon);
				twoColumnSearchWindow(driver, Deposit_Bank_Header, condition, Deposit_Bank_Value);
			}
			
			if(!Receipt_Remarks.trim().equals("")) {
				
				waitForElement(driver, Remarks_Input_Receipt);
				sendKeys(driver, Remarks_Input_Receipt, Receipt_Remarks);
				
			}
			
			

			waitForElement(driver, paymentDetails_Add_Button);
			click(driver, paymentDetails_Add_Button);
			waitForElement(driver, InvoiceAndReceipt_Tab);
			click(driver, InvoiceAndReceipt_Tab);
			waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
			checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");
			waitForElement(driver, allocate_Button);
			click(driver, allocate_Button);

			waitForPopup(driver, popup_Message, matched_Popup);

			act_Message = getText(driver, popup_Message);

			if (matched_Popup.equals(act_Message)) {
				System.out.println("Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message, test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + matched_Popup
						+ " || Actual Pop-up value is : " + act_Message, test, test1);
			}
		}

		Step_End(17, "once added the payment,below grid value has shown", test, test1);
		scrollTop(driver);
		Step_Start(18, "click the save button in tool bar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		Step_End(18, "click the save button in tool bar", test, test1);

		Step_Start(19, "system has validate -Receipt saved", test, test1);

		waitForPopup(driver, popup_Message, Receipt_Save_Popup_Msg);
		String save_Popup = getText(driver, popup_Message);

		if (Receipt_Save_Popup_Msg.equals(save_Popup)) {

			Extent_pass_New(driver, "Matched || Expected saved Popup : " + Receipt_Save_Popup_Msg
					+ " || Actual saved Popup : " + save_Popup, test, test1);
			System.out.println("Matched || Expected saved Popup : " + Receipt_Save_Popup_Msg
					+ " || Actual saved  Popup : " + save_Popup);

		} else {
			System.out.println("Not Matched || Expected saved Popup : " + Receipt_Save_Popup_Msg
					+ " || Actual saved Popup : " + save_Popup);
			Extent_fail(driver, "Not Matched || Expected saved Popup : " + Receipt_Save_Popup_Msg
					+ " || Actual saved Popup : " + save_Popup, test, test1);
		}
		waitForElement(driver, receipt_Popup_Ok_Button);
		click(driver, receipt_Popup_Ok_Button);
		Step_End(19, "system has validate -Receipt saved", test, test1);
		scrollTop(driver);
		waitForElement(driver, II_first_tab_inside_click);
		click1(driver, II_first_tab_inside_click);
		
		for (int i = 0; i < numbers.size(); i++) {
			scrollTop(driver);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, Condition, "Invoice Number", numbers.get(i), "", "", "", "");

			waitForElement(driver, invoice_Table_Headers);
			List<Map<String, String>> invoice_Table_Data = getTableData(driver, invoice_Table_Headers,
					invoice_Table_Rows);
			String inv_Balance = getFirstValueByHeader(invoice_Table_Data, "Balance");

			balances.add(inv_Balance);
		}
		
		verifyBalanceImport_Invoice(driver, amounts, balances);
		
		
		
		Extent_completed(testcase_Name, test, test1);
	}

}
