package LRP_Import_Invoice_Scripts;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC012E extends Keywords {

	public void Import_Invoice_SC012E(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Import_Invoice_SC012E";
		// Get data from test data


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Field_Names = Excel_data.get("Field_Names");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code"); 
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");  
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Search_Import_Document = Excel_data.get("Search_Import_Document");
		String Import_Doc_Customer_Type_Header = Excel_data.get("Import_Doc_Customer_Type_Header");
		String Import_Doc_Customer_TypeValue = Excel_data.get("Import_Doc_Customer_TypeValue");
		String Import_Doc_Customer_CodeHeader = Excel_data.get("Import_Doc_Customer_CodeHeader");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String condition = Excel_data.get("condition");
		String Table_Name = Excel_data.get("Table_Name"); 
		String charges_to_add = Excel_data.get("charges_to_add");
		String currencies = Excel_data.get("currencies");
		String base_rate_unit = Excel_data.get("base_rate_unit_data");
		String containers = Excel_data.get("containers_to_add");
		String rates = Excel_data.get("rate_data");
		String quantity = Excel_data.get("quantity_data");
		String remarks_data = Excel_data.get("remarks_data");
		String col_headers = Excel_data.get("col_headers");
		String Charge_Header = Excel_data.get("Charge_Header");
		String ROE_Header = Excel_data.get("ROE_Header");
		String BaseRateUnit_Header = Excel_data.get("BaseRateUnit_Header");
		String Container_Header = Excel_data.get("Container_Header");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Invoice_Number_Header = Excel_data.get("Invoice_Number_Header");
		String Invoice_Date_Header = Excel_data.get("Invoice_Date_Header");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String after_Reversal_Colour = Excel_data.get("after_Reversal_Colour"); 
		String Global_search_Invoice_Number = Excel_data.get("Global_search_Invoice_Number");
		String Global_search_value_Bl_No = Excel_data.get("Global_search_value_Bl_No").trim();
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String issued_Colour = Excel_data.get("Issued_Colour");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String Amount_Header = Excel_data.get("Amount_Header");
		String master_Table = Excel_data.get("master_Table");
		String reverse_Option = Excel_data.get("reverse_Option"); 



		
 
		
		Extent_Start(testCaseName, test, test1);
		DecimalFormat df=new DecimalFormat("0.00");
	
		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		verifyMainMenu(driver);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, "open the import invoice module and click the new button", test, test1);

		moduleNavigate(driver, Field_Names);

		newButton(driver);

		Step_End(2, "open the import invoice module and click the new button", test, test1);

		Step_Start(3, "retrive the bl in bl number search field", test, test1);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForDisplay(driver, By_BL_Number_Btn);
			click(driver, By_BL_Number_Btn);

			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
			waitForDisplay(driver, By_Vessel_Btn);
			click(driver, By_Vessel_Btn);
			waitForElement(driver, service_Txtfield_IN);
			sendKeys(driver, service_Txtfield_IN, Service_Code);
			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, Vessel_Code);
			sendKeys(driver, voyage_code_input, Voyage_Number);
			sendKeys(driver, bounnd_code_input, Bound_Input);
			sendKeys(driver, PortCode_Input, Port_Code);

			horizontalscroll(driver, InvoiceGridScroll, 300);
			click(driver, PortTerminal_Input);
			sendKeys(driver, PortTerminal_Input, Terminal_Code);
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);

			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);
			moduleNavigate(driver, Search_Import_Document);
			waitForElement(driver, NewButton_ToolBar);

			scrollTop(driver);

			if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_BL")) {

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type_Import_Doc, BL_Number_input, "", "", "",
						"");

			} else if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_Service")) {

				newButton(driver);
				waitForElement(driver, ID_servicename);
				sendKeys(driver, ID_servicename, Service_Code);

				sendKeys(driver, ID_grid_vesselcode, Vessel_Code);
				sendKeys(driver, ID_grid_voyagecode, Voyage_Number);
				sendKeys(driver, ID_grid_bound, Bound_Input);
				sendKeys(driver, ID_grid_portcode, Port_Code);

				horizontalscroll(driver, grid_scroll, 300);
				click(driver, ID_grid_terminal);
				sendKeys(driver, ID_grid_terminal, Terminal_Code);
				waitForElement(driver, service_grid_first_row);
				click(driver, service_grid_first_row);

				waitForElement(driver, service_select_btn);
				click(driver, service_select_btn);

				waitForElement(driver, ID_Show_Button);
				click(driver, ID_Show_Button);
			}

			waitForElement(driver, Container_Tab);
			scrollBottom(driver);
			waitForElement(driver, Customer_Tab);
			click(driver, Customer_Tab);

			waitForElement(driver, Customer_Table_Header);

			List<Map<String, String>> ImportDoc_Customer_Tabledata = getTableData(driver, Customer_Table_Header,
					Customer_Table_Row);
			String CustomerCode = getValueByFirstColumnAndHeader(ImportDoc_Customer_Tabledata,
					Import_Doc_Customer_Type_Header, Import_Doc_Customer_TypeValue, Import_Doc_Customer_CodeHeader);
			scrollTop(driver);

			waitForElement(driver, II_first_tab_inside_click);
			click(driver, II_first_tab_inside_click);
			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow1(driver, BL_Condition, Customer_Filter_Type, CustomerCode, "", "", "", "");

			if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
				waitForElement(driver, SystemCode_FilterInput);
				sendKeys(driver, SystemCode_FilterInput, Import_Doc_Customer_TypeValue);
			}
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);

			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);
			
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
				
			
			
			RemoveBLfromInvoice(driver, BL_Number_input, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);
		
		}

		Step_End(4, "search  and select the bl no", test, test1);

		scrollBottom(driver);

		Step_Start(5, "go to the additional charges tab", test, test1);

		waitForElement(driver, additional_charges_tab_IN);
		click(driver, additional_charges_tab_IN);

		Step_End(5, "go to the additional charges tab", test, test1);

		
		waitForElement(driver, edit_input_fields);
		click(driver, edit_input_fields);

		
		Step_End(6,
				"following fields are available....1.bl number  2.charge 3.currency/roe 4.base rateunit 5.quantity 6.rate 7.amount 8.container no 9.remarks.",
				test, test1);
		List<String> charges_to_select = splitAndExpand(charges_to_add);
		for (int i = 0; i < charges_to_select.size(); i++) {
			List<String> currency = splitAndExpand(currencies);
		

			List<String> base_rate_data = splitAndExpand(base_rate_unit);
			List<String> remarks_datas = splitAndExpand(remarks_data);
			List<String> quantity_data = splitAndExpand(quantity);
			List<String> rate = splitAndExpand(rates, ",");
			List<String> container = splitAndExpand(containers);

			String charges_value = charges_to_select.get(i);
			String currency_data = currency.get(i);
			String base_rate = base_rate_data.get(i);
			String remarks = remarks_datas.get(i);
			String quantity_add = quantity_data.get(i);
			String rate_select = rate.get(i);
			String container_add = container.get(i);
			Step_Start(8, "select the charge code from Test data", test, test1);
			// 2

			waitForElement(driver, charge_SearchButton_IN); 
			click(driver, charge_SearchButton_IN);

			twoColumnSearchWindow(driver, Charge_Header, condition, charges_value);

			Step_End(8, "select the charge code from Test data", test, test1);

			Step_Start(9, "select the currency/roe from Test data", test, test1);

			waitForElement(driver, curreny_ROE_SearchButton_IN);
			click(driver, curreny_ROE_SearchButton_IN);

			twoColumnSearchWindow(driver, ROE_Header, condition, currency_data);

			Step_End(9, "select the currency/roe from Test data", test, test1);

			Step_Start(10, "select the base rate unit from Test data", test, test1);
			// 4
			waitForElement(driver, baseRateUnit_SearchButton_IN);
			click(driver, baseRateUnit_SearchButton_IN);

			twoColumnSearchWindow(driver, BaseRateUnit_Header, condition, base_rate);

			Step_End(10, "select the base rate unit from Test data", test, test1);

			Step_Start(11, "enter the value from Test data", test, test1);
			// 5
			waitForElement(driver, quantityTextField_IN);
			clear(driver, quantityTextField_IN);
			sendKeys(driver, quantityTextField_IN, quantity_add);
			Step_End(11, "enter the value from Test data", test, test1);
			Step_Start(12, "enter the value from Test data", test, test1);
			// 6
			waitForElement(driver, rate_TextField_IN);
			click(driver, rate_TextField_IN);
			Newclear_Type(driver);
			sendKeys(driver, rate_TextField_IN, rate_select);
			click(driver, rate_TextField_IN);
			Step_End(12, "enter the value from Test data", test, test1);

			Step_Start(13, "amount field automatically converted", test, test1);
			
			Step_Start(14, "container field - select the container from Test data", test, test1);

			// 7
			waitForElement(driver, containerNo_SearchButton_IN);
			click(driver, containerNo_SearchButton_IN);

			twoColumnSearchWindow(driver, Container_Header, condition, container_add);

			waitForElement(driver, amount_TextField_IN);
			String autoconvertedAmount = getAttribute(driver, amount_TextField_IN, "value");
			double autoConvertAmt=Double.parseDouble(autoconvertedAmount);
			String autoconverted_Amount=df.format(autoConvertAmt);
			
			
			Step_End(13, "amount field automatically converted", test, test1);
			
			Step_End(14, "container field - select the container from Test data", test, test1);

			waitForElement(driver, remarksTextArea_IN);
			click(driver, remarksTextArea_IN);
			sendKeys(driver, remarksTextArea_IN, remarks);

			Step_Start(15, "click the add button", test, test1);

			waitForElement(driver, add_button_add_tab);
			click(driver, add_button_add_tab);

			Step_End(15, "click the add button", test, test1);
			waitForElement(driver, addtnl_chrgs_table_headers);
			List<Map<String, String>> charges_table = getTableData(driver, addtnl_chrgs_table_headers,
					addtnl_chrgs_rows);
			String chargeCode_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value,
					"Charge Code");
			String currency_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value,
					"Currency");
			String quantity_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value,
					"Quantity");
			String rate_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value, "Rate");
			String amountValue = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value, "Amount");
			double gridAmt=Double.parseDouble(amountValue);
			String amount_Value=df.format(gridAmt);
			
			
			if (chargeCode_Value.equals(charges_value)) {
				System.out.println("Matched || The Expected Charge Code Value From The Excel Sheet is : "
						+ charges_value + " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
						+ chargeCode_Value);
				Extent_pass_New(driver,
						"Matched || The Expected Charge Code Value From The Excel Sheet is : " + charges_value
								+ " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
								+ chargeCode_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Charge Code Value From The Excel Sheet is : "
						+ charges_value + " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
						+ chargeCode_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Charge Code Value From The Excel Sheet is : " + charges_value
								+ " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
								+ chargeCode_Value,
						test, test1);
			}
			if (currency_data.equals(currency_Value)) {
				System.out.println("Matched || The Expected Currency Value From The Excel Sheet is : " + currency_data
						+ " || The Actual Currency Value From The Additional Charges Tab Table is : " + currency_Value);
				Extent_pass_New(driver, "Matched || The Expected Currency Value From The Excel Sheet is : " + currency_data
						+ " || The Actual Currency Value From The Additional Charges Tab Table is : " + currency_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Currency Value From The Excel Sheet is : "
						+ currency_data + " || The Actual Currency Value From The Additional Charges Tab Table is : "
						+ currency_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Currency Value From The Excel Sheet is : " + currency_data
								+ " || The Actual Currency Value From The Additional Charges Tab Table is : "
								+ currency_Value,
						test, test1);
			}
			if (quantity_add.equals(quantity_Value)) {
				System.out.println("Matched || The Expected Quantity Value From The Excel Sheet is : " + quantity_add
						+ " || The Actual Quantity Value From The Additional Charges Tab Table is : " + quantity_Value);
				Extent_pass_New(driver, "Matched || The Expected Quantity Value From The Excel Sheet is : " + quantity_add
						+ " || The Actual Quantity Value From The Additional Charges Tab Table is : " + quantity_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Quantity Value From The Excel Sheet is : "
						+ quantity_add + " || The Actual Quantity Value From The Additional Charges Tab Table is : "
						+ quantity_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Quantity Value From The Excel Sheet is : " + quantity_add
								+ " || The Actual Quantity Value From The Additional Charges Tab Table is : "
								+ quantity_Value,
						test, test1);
			}
			if (rate_select.equals(rate_Value)) {
				System.out.println("Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
						+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value);
				Extent_pass_New(driver,
						"Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
								+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
						+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
								+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value,
						test, test1);
			}
			if (autoconverted_Amount.equals(amount_Value)) {
				System.out.println("Matched || The Expected Automatically Converted Amount is : " + autoconverted_Amount
						+ " || The Actual Amount Value From The Additional Charges Tab Table is : " + amount_Value);
				Extent_pass_New(driver,
						"Matched || The Expected Automatically Converted Amount is : " + autoconverted_Amount
								+ " || The Actual Amount Value From The Additional Charges Tab Table is : "
								+ amount_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Automatically Converted Amount is : "
						+ autoconverted_Amount
						+ " || The Actual Amount Value From The Additional Charges Tab Table is : " + amount_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Automatically Converted Amount is : " + autoconverted_Amount
								+ " || The Actual Amount Value From The Additional Charges Tab Table is : "
								+ amount_Value,
						test, test1);
			}
		
		}
		
		Step_Start(16, "in below grid newly added charges has shown", test, test1);
		waitForElement(driver, addtnl_chrgs_table_headers);
		List<Map<String, String>> charges_table = getTableData(driver, addtnl_chrgs_table_headers, addtnl_chrgs_rows);
		List<String> headers = splitAndExpand(col_headers, ",");
		String table_Value = TableDataForReport(driver, charges_table, Table_Name, headers);
		List<List<String>> Exp_table = getValuesByHeaders_RemoveMinus(charges_table, headers);

		Extent_pass_New(driver, "<pre>" + table_Value + "</pre>", test, test1);
		Step_End(16, "in below grid newly added charges has shown", test, test1);
		Step_Start(17, "select the draft and click the save button in toolbar", test, test1);

		
		scrollTop(driver);
		waitForElement(driver, issued_Button);
		click(driver, issued_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(11, "Click on Issue Button and then click on save button", test, test1);
		Step_Start(12, "Import Invoice saved Msg click on ok Button", test, test1);

		waitForPopup(driver, popup_Message, importInvoiceSavedPopup);

		String actualPopup = getText(driver, popup_Message);

		if (actualPopup.equals(importInvoiceSavedPopup)) {

			Extent_pass_New(driver,
					"Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup,
					test, test1);
			System.out.println(
					"Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup);
			click(driver, popup_Message_Ok_Button);

		} else {
			System.out.println(
					"Not Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup);
			Extent_fail(driver,
					"Not Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup,
					test, test1);
		}

		Step_End(12, "Import Invoice saved Msg click on ok Button", test, test1);
		Step_Start(13, "Verify that Green Color Available", test, test1);

		waitForElement(driver, import_invoice_first_row);
		String issuedColourCode = getTextBackgroundColor(driver, import_invoice_first_row);
		System.out.println(issuedColourCode);

		String issuedColour = getColorName(issuedColourCode);

		if (issuedColour.equalsIgnoreCase(issued_Colour)) {

			System.out.println("Row colors are changed as expected || Expected colour : " + issued_Colour
					+ " || Actual colour : " + issuedColour);
			Extent_pass_New(driver, "Row colors are changed as expected || Expected colour : " + issued_Colour
					+ " || Actual colour : " + issuedColour, test, test1);

		} else {
			System.out.println("Row colors are not changed as expected || Expected colour : " + issued_Colour
					+ " || Actual colour : " + issuedColour);
			Extent_fail(driver, "Row colors are not changed as expected || Expected colour : " + issued_Colour
					+ " || Actual colour : " + issuedColour, test, test1);

		}
		Step_End(13, "Verify that Green Color Available", test, test1);
		Step_Start(14, "15A. Capture the details", test, test1);

		List<Map<String, String>> invoice_Tabledata = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);

		List<String> columnheaders_Invoice = splitAndExpand(Invoice_Table_Headers);

		List<String> invoiceNumbers = getValuesByHeader(invoice_Tabledata, columnheaders_Invoice.get(0));

		ArrayList<String> inv_Numbers = new ArrayList<String>();
		for (int i = 0; i < invoiceNumbers.size(); i++) {
			inv_Numbers.add(invoiceNumbers.get(i));
		}

		System.out.println("inv_Numbers : " + inv_Numbers);

		String invNumber = invoiceNumbers.get(0);

		List<String> amount_All = getValuesByHeader(invoice_Tabledata, Amount_Header);

		ArrayList<String> amount = new ArrayList<String>();
		ArrayList<String> amount_Neg = new ArrayList<String>();

		for (int i = 0; i < amount_All.size(); i++) {
			amount.add(amount_All.get(i));
			String negative = "-" + amount_All.get(i);
			amount_Neg.add(negative);
		}
		System.out.println("Amount : " + amount);
		System.out.println("Amount Negative : " + amount_Neg);

		LocalDate currentDate = LocalDate.now();
		System.out.println("currentDate : " + currentDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println("formattedDate : " + formattedDate);

		List<String> invoiceDates = getValuesByHeader(invoice_Tabledata, Invoice_Date_Header);

		ArrayList<String> inv_Date = new ArrayList<String>();
		for (int i = 0; i < invoiceDates.size(); i++) {
			inv_Date.add(invoiceDates.get(i));
			if (inv_Date.get(i).equals(formattedDate)) {
				if (i == invoiceDates.size() - 1) {
					System.out.println(
							"Matched || Invoice Date : " + inv_Date.get(i) + " || Current Date : " + formattedDate);
				}
			} else {
				System.out.println(
						"Not Matched || Invoice Date : " + inv_Date.get(i) + " || Current Date : " + formattedDate);

			}
		}


		
		scrollTop(driver);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		 if(reverse_Option.equalsIgnoreCase("Yes")) {
			 
		Step_Start(15, "open the invoice reversal module ", test, test1);

		moduleNavigate(driver, InvoiceReversal_Module);

		Step_End(15, "open the invoice reversal module ", test, test1);

		Step_Start(16, "click the new button", test, test1);

		newButton(driver);

		Step_End(16, "click the new button", test, test1);

		Step_Start(17, "load the same bl no or invoice no from import invoice in invoice reversal module", test, test1);

		Step_Start(18, "select the bl no and click the show button", test, test1);

		waitForElement(driver, invoiceNo_SearchButton);
		click(driver, invoiceNo_SearchButton);

		globalValueSearchWindow(driver, BL_Condition, Global_search_value_Bl_No, invNumber, "", "", "", "");

		waitForElement(driver, invoiceReversal_Show_Button);
		click(driver, invoiceReversal_Show_Button);

		Step_End(17, "load the same bl no or invoice no from import invoice in invoice reversal module", test, test1);

		Step_End(18, "select the bl no and click the show button", test, test1);

		Step_Start(19, "in below grid invoice details has to be shown ", test, test1);

		waitForElement(driver, inv_Reversal_Table_Header);
		List<Map<String, String>> invoice_Details_Table = getTableData(driver, inv_Reversal_Table_Header,
				invoiceReversal_Table_Rows);

		List<String> invoice_Numbers = getValuesByHeader(invoice_Details_Table, Invoice_Number_Header);

		System.out.println("INVOICE NUMBERS SHOWN IN THE GRID ARE :" + invoice_Numbers);

		Step_End(19, "in below grid invoice details has to be shown ", test, test1);

		Step_Start(20, "select the invoice no and enter the reversal reason in below grid", test, test1);

		waitForElement(driver, invoice_Num_Txtfield);
		String invoice_Number = getAttribute(driver, invoice_Num_Txtfield, "value");

		String select_Row = String.format(import_Reversal_Confirmed_Row, invoice_Number);

		waitForElement(driver, select_Row);
		click(driver, select_Row);

		click(driver, invoiceReversal_Remarks_TextArea);
		sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);

		System.out.println("invoice number is: " + invoice_Number);

		Step_End(20, "select the invoice no and enter the reversal reason in below grid", test, test1);

		Step_Start(21, "click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(21, "click the save button", test, test1);

		Step_Start(22, "click yes", test, test1);

		waitForDisplay(driver, popup_Message_Yes_Button);
		if (isDisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}

		Step_End(22, "click yes", test, test1);

		Step_Start(23, "system has validate the invoice reversed.", test, test1);

		waitForPopup(driver, popup_Message, invoiceReversedPopup);

		String actualReversedPopup = getText(driver, popup_Message);

		if (actualReversedPopup.equals(invoiceReversedPopup)) {
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + invoiceReversedPopup + " Actual Popup : " + actualReversedPopup,
					test, test1);
			System.out.println(
					"Matched || Expected Popup : " + invoiceReversedPopup + " Actual Popup : " + actualReversedPopup);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup : " + invoiceReversedPopup + " Actual Popup : "
					+ actualReversedPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : " + invoiceReversedPopup + " Actual Popup : "
					+ actualReversedPopup, test, test1);
		}

		Step_End(23, "system has validate the invoice reversed.", test, test1);
		Step_Start(24, "Capture Details,", test, test1);

		List<Map<String, String>> reversal_Tabledata = getTableData(driver, import_Reversal_Columns,
				import_Reversal_Rows);

		String firstColumn_Header = Invoice_Number_Header;
		String firstColumn_Value = invoice_Number;

		String reversal_Number = getValueByFirstColumnAndHeader(reversal_Tabledata, firstColumn_Header,
				firstColumn_Value, "Invoice Reversal No");
		System.out.println("reversal_Number : " + reversal_Number);

		Step_End(24, "Capture Details,", test, test1);

		Extent_cal(test, test1, Import_Invoice_Module);

		moduleNavigate(driver, Field_Names);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, BL_Condition, Global_search_Invoice_Number, reversal_Number, "", "", "", "");

		Extent_call(test, test1,
				"verify that system has allow to reverse the issued import invoice and system has automatically created credit invoice  (pink color)\r\n"
						);

		waitForElement(driver, import_invoice_first_row);
		String after_Reversal_ColourCode = getTextBackgroundColor(driver, import_invoice_first_row);

		System.out.println(after_Reversal_ColourCode);

		String after_Reversal = getColorName(after_Reversal_ColourCode);

		if (after_Reversal.equalsIgnoreCase(after_Reversal_Colour)) {

			System.out.println("MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal);
			Extent_pass_New(driver, "MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal, test, test1);
		} else {

			System.out.println("NOT MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal);
			Extent_fail(driver, "NOT MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL : " + after_Reversal, test, test1);
		}
		}
		 
		Step_Start(6, "Master tab(All the Columns)", test, test1);

		if (master_Table.equalsIgnoreCase("Yes")) {
			ArrayList<String> importInvoice_invoiceNo = new ArrayList<String>();
			List<WebElement> table_InvoiceNumbers = listOfElements(driver, importInvoice_Table_InvoiceNumbers);
			for (WebElement invoice_Num : table_InvoiceNumbers) {
				String invoiceNum = invoice_Num.getText();
				importInvoice_invoiceNo.add(invoiceNum);
			}

			List<Map<String, String>> invoice_Tabledata_After_Reverse = getTableData(driver, importInvoice_Table_Header,
					importInvoice_Table_Row);

			List<String> columnheaders_Invoice_After_Reverse = splitAndExpand(Invoice_Table_Headers);

			List<String> invoiceNumbers_After_Reverse = getValuesByHeader(invoice_Tabledata_After_Reverse,
					columnheaders_Invoice_After_Reverse.get(0));

			ArrayList<String> inv_Numbers_After_Reverse = new ArrayList<String>();
			for (int i = 0; i < invoiceNumbers_After_Reverse.size(); i++) {
				inv_Numbers_After_Reverse.add(invoiceNumbers_After_Reverse.get(i));
			}

			System.out.println("inv_Numbers : " + inv_Numbers_After_Reverse);

			List<String> amount_All_After_Reverse = getValuesByHeader(invoice_Tabledata_After_Reverse, Amount_Header);

			ArrayList<String> amount_After_Reverse = new ArrayList<String>();
			for (int i = 0; i < amount_All_After_Reverse.size(); i++) {
				amount_After_Reverse.add(amount_All_After_Reverse.get(i));
			}
			System.out.println("Amount : " + amount_After_Reverse);

		
		}
		Step_End(6, "Master tab(All the Columns).", test, test1);
		
		
		scrollBottom(driver);
		waitForElement(driver, additional_charges_tab_IN);
		click(driver, additional_charges_tab_IN);

		waitForElement(driver, addtnl_chrgs_table_headers);
		List<Map<String, String>> charges_table1 = getTableData(driver, addtnl_chrgs_table_headers, addtnl_chrgs_rows);
		List<String> headers1 = splitAndExpand(col_headers, ",");
		String table_Value1 = TableDataForReport(driver, charges_table1, Table_Name, headers1);
	List<List<String>> act_table = getValuesByHeaders_RemoveMinus(charges_table1, headers1);
		Extent_pass_New(driver, "<pre>" + table_Value1 + "</pre>", test, test1);
		
		

		if(compareTableData(Exp_table, act_table)) {
			System.out.println("Additional Details Tab table values is same ");
			Extent_pass_New(driver,
					"Matched || Before Reversal: \n" + "<pre>" + table_Value + "</pre>"
							+ "\r\n || After Reversal : \r\n" + "<pre>" + table_Value1
							+ "</pre>",
					test, test1);
		}else {
			System.out.println("Additional Details Tab Table values is not same");
			Extent_fail(driver, "Additional Details Tab Table values is not same", test, test1);
		}
			
			Extent_completed(testCaseName, test, test1);
		
		
	
	
	}
	

}
