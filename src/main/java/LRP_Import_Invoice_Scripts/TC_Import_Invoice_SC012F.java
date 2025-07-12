package LRP_Import_Invoice_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC012F extends Keywords {
	public void Import_Invoice_SC012F(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC012F";
	
		
		


		String Username = Excel_data.get("Username");  
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String Import_Invoice_Module = Excel_data.get("Import_Invoice_Module");
		String BL_Num = Excel_data.get("BL_Num");
		String Condition = Excel_data.get("Condition");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String after_Reversal_Colour = Excel_data.get("after_Reversal_Colour");
		String Global_search_Invoice_Number = Excel_data.get("Global_search_Invoice_Number");
		String Global_search_value_Bl_No = Excel_data.get("Global_search_value_Bl_No").trim();
		String Global_search_value_Bl_Number = Excel_data.get("Global_search_value_Bl_Number");
		String BL_Retrive_from_Import_invoice = Excel_data.get("BL_Retrive_from_Import_invoice");
		String service_input = Excel_data.get("service_input");
		String vessel_code_input = Excel_data.get("vessel_code_input");
		String voyage_code = Excel_data.get("voyage_code_input");
		String Bound_code_input = Excel_data.get("Bound_code_input"); 
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String issued_Colour = Excel_data.get("Issued_Colour");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String customerCode = Excel_data.get("CustomerCode");
		String columnHeaders_BL_Details = Excel_data.get("ColumnHeaders_BL_Details");
		String BL_Details_Tab = Excel_data.get("BL_Details_Tab"); 
		String master_Table = Excel_data.get("Master_Table");
		String reverse_Option = Excel_data.get("reverse_Option");
		String Amount_Header = Excel_data.get("Amount_Header");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input"); 
		String Call_ID = Excel_data.get("Call_ID");
		String Invoice_Table_Name = Excel_data.get("Invoice_Table_Name");
		String BL_Details_table_Name_In = Excel_data.get("BL_Details_table_Name_In");
		String Invoice_Number_Header = Excel_data.get("Invoice_Number_Header");
		String Invoice_Date_Header = Excel_data.get("Invoice_Date_Header");
		String Invoice_Reversal_Number = Excel_data.get("Invoice_Reversal_Number");




 
		Extent_Start(testcase_Name, test, test1); 

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		verifyMainMenu(driver);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, ".open the import invoice module .", test, test1);

		moduleNavigate(driver, Import_Invoice_Module);

		Step_End(2, ".open the import invoice module .", test, test1);

		Step_Start(3, "click the new button", test, test1);

		newButton(driver);

		Step_End(3, "click the new button", test, test1);
		Step_Start(4, "click the by vessel/BL option", test, test1);

		if (BL_Retrive_from_Import_invoice.equals("By BL Number")) {

			Step_Start(4, " Click on BL NO Search and Paste the BL in the search and then load the BL.", test, test1);

			waitForElement(driver, import_invoice_bl_search);
			click(driver, import_invoice_bl_search);

			globalValueSearchWindow(driver, Condition, Global_search_value_Bl_Number, BL_Num, "", "", "", "");
			
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

			waitForElement(driver, import_invoice_bl);
			String BL_Numberact = getAttribute(driver, import_invoice_bl, "value");
			System.out.println(BL_Numberact);

			Step_End(4, " Click on BL NO Search and Paste the BL in the search and then load the BL.", test, test1);

		}

		if (BL_Retrive_from_Import_invoice.equals("By Vessel")) {

			Step_Start(4, "click the by vessel option", test, test1);

			waitForElement(driver, by_vessels_select);
			click(driver, by_vessels_select);

			Step_End(4, "click the by vessel option", test, test1);
			Step_Start(5, "enter the service in service field", test, test1);
//

			Step_End(5, "enter the service in service field", test, test1);
			Step_Start(6, "automatically service details has to be populated based on the given service", test, test1);


			Step_End(6, "automatically service details has to be populated based on the given service", test, test1);
			Step_Start(7, "select the serive ,vessel and voyage details for that bl", test, test1);

			waitForElement(driver, service_Txtfield_IN);
			Actionsendkeys(driver, service_Txtfield_IN, service_input);
			waitForElement(driver, vessel_Txtfield);
			sendKeys(driver, vessel_Txtfield, vessel_code_input);
			waitForElement(driver, import_invoice_print_year);
			sendKeys(driver, import_invoice_print_year, voyage_code);
			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_code_input);
			horizontalscroll(driver, By_Vessel_Scroll, 500);  if(!Terminal_Code_Input.equals("")) {
				horizontalscroll(driver, By_Vessel_Scroll, 500);
				sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
				}
				
				if(!Call_ID.equals("")) {
				waitForElement(driver, By_Vessel_Call_Id);
				sendKeys(driver, By_Vessel_Call_Id, Call_ID);
				}

			waitForElement(driver, Select_grid);
			click(driver, Select_grid);

			Step_End(7, "select the serive ,vessel and voyage details for that bl", test, test1);
			Step_Start(8, "before click the customer field ", test, test1);

			Step_Start(9, "Enter the consignee customer code or name from Test Data. ", test, test1);

			waitForElement(driver, II_first_tab_inside_click);
			click(driver, II_first_tab_inside_click);

			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, customerCode, "", "", "",
					"");

			Step_End(9, "Enter the consignee customer code or name from Test Data. ", test, test1);
			Step_Start(10, "select the customer and click the show bl button", test, test1);
			
			
			
		
			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);

			Step_End(10, "select the customer and click the show bl button", test, test1);
			
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
			
			
			RemoveBLfromInvoice(driver, BL_Num, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);
			

		}

		Step_Start(11, "Click on Issue Button and then click on save button", test, test1);

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

		String import_Invoice_Tabledata = TableDataForReport(driver, invoice_Tabledata, Invoice_Table_Name,
				columnheaders_Invoice);


//	BL Details

		waitForElement(driver, bl_Details_Tab_IN);
		click(driver, bl_Details_Tab_IN);
		scrollBottom(driver);

		waitForElement(driver, bl_Details_Table_Rows_IN);

		List<Map<String, String>> bl_Details_Tabledata = getTableData(driver, bl_Details_Table_Columns_IN,
				bl_Details_Table_Rows_IN);

		List<String> bl_Details_headers = splitAndExpand(columnHeaders_BL_Details);

		String BL_Details_Tabledata = TableDataForReport(driver, bl_Details_Tabledata, BL_Details_table_Name_In,
				bl_Details_headers);

		ArrayList<String> bl_Details = new ArrayList<String>();

		for (int i = 0; i < bl_Details_headers.size(); i++) {

			List<String> bl_Details_Values = getValuesByHeader(bl_Details_Tabledata, bl_Details_headers.get(i));
			System.out.println("bl_Details_Values : " + bl_Details_Values);
			bl_Details.add(bl_Details_Values.get(0));

		}

		System.out.println("bl_Details : " + bl_Details);
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

		globalValueSearchWindow(driver, Condition, Global_search_value_Bl_No, invNumber, "", "", "", "");

		waitForElement(driver, invoiceReversal_Show_Button);
		click(driver, invoiceReversal_Show_Button);

		Step_End(17, "load the same bl no or invoice no from import invoice in invoice reversal module", test, test1);

		Step_End(18, "select the bl no and click the show button", test, test1);

		Step_Start(19, "in below grid invoice details has to be shown ", test, test1);

		waitForElement(driver, inv_Reversal_Table_Header);
		List<Map<String, String>> invoice_Details_Table = getTableData(driver, inv_Reversal_Table_Header,
				invoiceReversal_Table_Rows);

		List<String> invoice_Numbers = getValuesByHeader(invoice_Details_Table, Invoice_Reversal_Number);

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

		moduleNavigate(driver, Import_Invoice_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, Global_search_Invoice_Number, reversal_Number, "", "", "", "");

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

			String import_Invoice_Tabledata_After_Reverse = TableDataForReport(driver, invoice_Tabledata_After_Reverse,
					Invoice_Table_Name, columnheaders_Invoice_After_Reverse);

			if (!inv_Numbers.equals(inv_Numbers_After_Reverse) && amount_Neg.equals(amount_After_Reverse)) {
				System.out.println(
						"Passed || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is displayed ");
				Extent_pass_New(driver,
						"Passed || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is displayed ",
						test, test1);
				Extent_pass_New(driver, "Passed || Before Reversal: \n" + "<pre>" + import_Invoice_Tabledata + "</pre>"
						+ "\r\n || After Reversal : \r\n" + "<pre>" + import_Invoice_Tabledata_After_Reverse + "</pre>",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is not displayed ");
				Extent_fail(driver,
						"Fail || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is not displayed ",
						test, test1);
			}
		}
		Step_End(6, "Master tab(All the Columns).", test, test1);

		Extent_cal(test, test1,
				"Step 15A and 24 Has to capture the information as per the Test data Provided.\r\n" + "Tabs,");

		Step_Start(1, "bl details,(All the Columns)", test, test1);

//	BL Details
		if (!BL_Details_Tab.equals("")) {
			waitForElement(driver, bl_Details_Tab_IN);
			click(driver, bl_Details_Tab_IN);
			scrollBottom(driver);

			waitForElement(driver, bl_Details_Table_Rows_IN);

			List<Map<String, String>> bl_Details_Tabledata1 = getTableData(driver, bl_Details_Table_Columns_IN,
					bl_Details_Table_Rows_IN);

			List<String> bl_Details_headers1 = splitAndExpand(columnHeaders_BL_Details);

			String BL_Details_Tabledata1 = TableDataForReport(driver, bl_Details_Tabledata1, BL_Details_table_Name_In,
					bl_Details_headers1);

			ArrayList<String> bl_Details1 = new ArrayList<String>();

			for (int i = 0; i < bl_Details_headers1.size(); i++) {

				List<String> bl_Details_Values = getValuesByHeader(bl_Details_Tabledata, bl_Details_headers1.get(i));

				bl_Details1.add(bl_Details_Values.get(0));

			}

			System.out.println("bl_Details : " + bl_Details1);

			if (bl_Details1.equals(bl_Details)) {

				System.out.println(
						"Matched || Expected result is : BL Details Table should be displayed in Import Invoice BL Details Tab || Actual result is : BL Details Table is displayed in Import Invoice BL Details Tab");
				
				Extent_pass_New(driver,
						"Passed || Before Reversal: \n" + "<pre>" + BL_Details_Tabledata + "</pre>"
								+ "\r\n || After Reversal : \r\n" + "<pre>" + BL_Details_Tabledata1 + "</pre>",
						test, test1);

			} else {
				System.out.println(
						"Not Matched || Expected result is : BL Details Table should be displayed in Import Invoice BL Details Tab || Actual result is : BL Details Table is not displayed in Import Invoice BL Details Tab");
			
			}
		}
    Extent_completed(testcase_Name, test, test1);

		
	}

}
