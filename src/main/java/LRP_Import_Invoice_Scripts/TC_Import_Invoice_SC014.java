package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC014 extends Keywords {

	public void Import_Invoice_SC014(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC014";
		
		

 
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password"); 
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String Import_Invoice_Module = Excel_data.get("Import_Invoice_Module");
		String BL_Num = Excel_data.get("BL_Num");
		String Condition = Excel_data.get("Condition");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String Global_search_value_Bl_No = Excel_data.get("Global_search_value_Bl_No").trim();
		String Global_search_value_Bl_Number = Excel_data.get("Global_search_value_Bl_Number");
		String BL_Retrive_from_Import_invoice = Excel_data.get("BL_Retrive_from_Import_invoice");
		String service_input = Excel_data.get("service_input");
		String vessel_code_input = Excel_data.get("vessel_code_input");
		String voyage_code = Excel_data.get("voyage_code_input");
		String Bound_code_input = Excel_data.get("Bound_code_input");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String issued_Colour = Excel_data.get("Issued_Colour");
		String ImportDocumentaion_Module = Excel_data.get("ImportDocumentaion_Module");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String Invoice_Table_Name = Excel_data.get("Invoice_Table_Name");
		String reverse_Option = Excel_data.get("reverse_Option");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input"); 
		String Call_ID = Excel_data.get("Call_ID");
		String Amount_Header = Excel_data.get("Amount_Header");
		String Global_search_Invoice_Number = Excel_data.get("Global_search_Invoice_Number");
		String after_Reversal_Colour = Excel_data.get("after_Reversal_Colour");
		String Invoice_Number_Header = Excel_data.get("Invoice_Number_Header");


//		String Import_Doc_Customer_Type_Header = Excel_data.get("Import_Doc_Customer_Type_Header");
//		String Import_Doc_Customer_TypeValue = Excel_data.get("Import_Doc_Customer_TypeValue");
//		String Import_Doc_Customer_CodeHeader = Excel_data.get("Import_Doc_Customer_CodeHeader");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

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

			if (BL_Num.equals(BL_Numberact)) {
				System.out.println("Given BL Number is retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact);

				Extent_pass_New(driver, "Given BL Number is retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact, test, test1);

			} else {
				System.out.println("Given BL Number is not retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact);
				Extent_fail(driver, "Given BL Number is not retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact, test, test1);

			}

			Step_End(4, " Click on BL NO Search and Paste the BL in the search and then load the BL.", test, test1);

		}

		if (BL_Retrive_from_Import_invoice.equals("By Vessel")) {

			Extent_call(test, test1, "If like to Go By Vessel follow below steps");

			newButton(driver);

			Step_Start(4, "click the by vessel option", test, test1);

			waitForElement(driver, by_vessels_select);
			click(driver, by_vessels_select);

			Step_End(4, " click the by vessel option", test, test1);

			Step_Start(5, " enter the service in service field", test, test1);

			waitForElement(driver, service_text);
			sendKeys(driver, service_text, service_input);

			Step_End(5, " enter the service in service field", test, test1);

			Step_Start(6, " automatically service details has to be populated based on the given service ", test,
					test1);

			Step_Start(7, "select the serive ,vessel and voyage details for that bl ", test, test1);

			waitForElement(driver, vessels_code_input);
            click(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, vessel_code_input);

			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, voyage_code);

			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_code_input);
			horizontalscroll(driver, By_Vessel_Scroll, 600);

			horizontalscroll(driver, By_Vessel_Scroll, 500);  if(!Terminal_Code_Input.equals("")) {
				sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
				}
				
				if(!Call_ID.equals("")) {

				waitForElement(driver, By_Vessel_Call_Id);
				sendKeys(driver, By_Vessel_Call_Id, Call_ID);
				}
			Step_Start(7, "select the serive ,vessel and voyage details for that bl ", test, test1);

			Step_End(6, " automatically service details has to be populated based on the given service ", test, test1);

			Step_Start(8, "before click the customer field ", test, test1);

			waitForElement(driver, Select_grid);
			click(driver, Select_grid);

			Step_End(8, "before click the customer field ", test, test1);

			Step_Start(9,
					"go the import documentation module retrieve the same bl and go to the customer tab --copy the consignee customer code or name",
					test, test1);

			moduleNavigate(driver, ImportDocumentaion_Module);

			scrollTop(driver);

			newButton(driver);

			waitForDisplay(driver, cancel_Common_btn);
			if (isClickable(driver, cancel_Common_btn)) {
				click(driver, cancel_Common_btn);
			}

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, Condition, BL_Filter_Type_Import_Doc, BL_Num, "", "", "", "");

			waitForElement(driver, Customer_Tab);
			click(driver, Customer_Tab);

			waitForElement(driver, customer_code_copy);
			String customer_code_paste = getText(driver, customer_code_copy);
			System.out.println(customer_code_paste);
			Step_End(9,
					"go the import documentation module retrieve the same bl and go to the customer tab --copy the consignee customer code or name",
					test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			Step_Start(10, "click the customer field and put the CN code or name", test, test1);

			waitForElement(driver, customer_search);
			click(driver, customer_search);

			globalValueSearchWindow(driver, Condition, Customer_Filter_Type, customer_code_paste, "", "", "", "");

			Step_End(10, "click the customer field and put the CN code or name", test, test1);

			Step_Start(11, "load the same Customer and click on SHow BL button,", test, test1);

			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);

			Step_End(11, "load the same Customer and click on SHow BL button,", test, test1);
		
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

		Step_Start(12, "Click on Issue Button and then click on save button", test, test1);

		scrollTop(driver);
		waitForElement(driver, issued_Button);
		click(driver, issued_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(12, "Click on Issue Button and then click on save button", test, test1);
		Step_Start(13, "Import Invoice saved Msg click on ok Button", test, test1);

		waitForPopup(driver, popup_Message, importInvoiceSavedPopup);

		String actualPopup = getText(driver, popup_Message);

		if (actualPopup.equals(importInvoiceSavedPopup)) {
			System.out.println(
					"Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup,
					test, test1);
			click(driver, popup_Message_Ok_Button);

		} else {
			System.out.println(
					"Not Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup);
			Extent_fail(driver,
					"Not Matched || Expected popup : " + importInvoiceSavedPopup + " || Actual popup : " + actualPopup,
					test, test1);
		}

		Step_End(13, "Import Invoice saved Msg click on ok Button", test, test1);
		Step_Start(14, "Verify that Green Color Available", test, test1);

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
		Step_End(14, "Verify that Green Color Available", test, test1);
		
		List<Map<String, String>> invoice_Tabledata = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);

		List<String> columnheaders_Invoice = splitAndExpand(Invoice_Table_Headers);

		List<String> invoiceNumbers = getValuesByHeader(invoice_Tabledata, columnheaders_Invoice.get(0));

		ArrayList<String> inv_Numbers = new ArrayList<String>();
		for (int i = 0; i < invoiceNumbers.size(); i++) {
			inv_Numbers.add(invoiceNumbers.get(i));
		}

		System.out.println("inv_Numbers : " + inv_Numbers);

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

		String import_Invoice_Tabledata = TableDataForReport(driver, invoice_Tabledata, Invoice_Table_Name,
				columnheaders_Invoice);

		if (isDisplayed(driver, importInvoice_Table_Row)) {

			System.out.println(
					"Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is displayed ");
			Extent_pass(driver,
					"Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is displayed ",
					test, test1);
			Extent_pass(driver, "Matched || Expected : \n" + "<pre>" + import_Invoice_Tabledata + "</pre>", test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is not displayed ");
			Extent_fail(driver,
					"Not Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is not displayed ",
					test, test1);
		}

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		 if(reverse_Option.equalsIgnoreCase("Yes")) {
		Step_Start(15, "open the invoice reversal module ", test, test1);
		for(int i = 0;i<1;i++) {

		moduleNavigate(driver, InvoiceReversal_Module);

		Step_End(15, "open the invoice reversal module ", test, test1);

		Step_Start(16, "click the new button", test, test1);

		newButton(driver);

		Step_End(16, "click the new button", test, test1);

		Step_Start(17, "load the same bl no or invoice no from import invoice in invoice reversal module", test, test1);

		Step_Start(18, "select the bl no and click the show button", test, test1);

		waitForElement(driver, invoiceNo_SearchButton);
		click(driver, invoiceNo_SearchButton);

		globalValueSearchWindow(driver, Condition, Global_search_value_Bl_No, inv_Numbers.get(i), "", "", "", "");

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

		Step_Start(23, "system has validate the invoice reversed. and Capture the Invoice NO", test, test1);

		waitForPopup(driver, popup_Message, invoiceReversedPopup);

		String actualReversedPopup = getText(driver, popup_Message);

		if (actualReversedPopup.equals(invoiceReversedPopup)) {
			Extent_pass(driver,
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
		
		List<Map<String, String>> reversal_Tabledata = getTableData(driver, import_Reversal_Columns,
				import_Reversal_Rows);

		String firstColumn_Header = "Invoice No";
		String firstColumn_Value = invoice_Number;

		String reversal_Number = getValueByFirstColumnAndHeader(reversal_Tabledata, firstColumn_Header,
				firstColumn_Value, "Invoice Reversal No");
		System.out.println("reversal_Number : " + reversal_Number);

		Step_End(23, "system has validate the invoice reversed. and Capture the Invoice NO", test, test1);

		Step_Start(24, "open the import invoice.", test, test1);

		moduleNavigate(driver, Import_Invoice_Module);

		Step_End(24, "open the import invoice.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_Start(25, "Click on search Button and put the reversed invoice no in Search fields,", test, test1);

		globalValueSearchWindow(driver, Condition, Global_search_Invoice_Number, reversal_Number, "", "", "", "");

		Step_End(25, "Click on search Button and put the reversed invoice no in Search fields,", test, test1);

		waitForElement(driver, import_invoice_first_row);
		String after_Reversal_ColourCode = getTextBackgroundColor(driver, import_invoice_first_row);

		Step_Start(26, "Load the Invoice NO", test, test1);
		System.out.println(after_Reversal_ColourCode);

		String after_Reversal = getColorName(after_Reversal_ColourCode);

		if (after_Reversal.equalsIgnoreCase(after_Reversal_Colour)) {

			System.out.println("MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal);
			Extent_pass(driver, "MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal, test, test1);
		} else {

			System.out.println("NOT MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal);
			Extent_fail(driver, "NOT MATCHED || EXPECTED COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal_Colour
					+ " ACTUAL COLOUR OF THE ROW AFTER REVERSAL " + after_Reversal, test, test1);

		}

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
		for (int j = 0; j < invoiceNumbers_After_Reverse.size(); j++) {
			inv_Numbers_After_Reverse.add(invoiceNumbers_After_Reverse.get(j));
		}

		System.out.println("inv_Numbers : " + inv_Numbers_After_Reverse);

		List<String> amount_All_After_Reverse = getValuesByHeader(invoice_Tabledata_After_Reverse, Amount_Header);

		ArrayList<String> amount_After_Reverse = new ArrayList<String>();
		for (int k = 0; k < amount_All_After_Reverse.size(); k++) {
			amount_After_Reverse.add(amount_All_After_Reverse.get(k));
		}
		System.out.println("Amount : " + amount_After_Reverse);

		String import_Invoice_Tabledata_After_Reverse = TableDataForReport(driver, invoice_Tabledata_After_Reverse,
				Invoice_Table_Name, columnheaders_Invoice_After_Reverse);

		if (!inv_Numbers.equals(inv_Numbers_After_Reverse) && amount_Neg.equals(amount_After_Reverse)) {
			System.out.println(
					"Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is displayed ");
			Extent_pass(driver,
					"Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is displayed ",
					test, test1);
			Extent_pass(driver, "Passed || Before Reversal: \n" + "<pre>" + import_Invoice_Tabledata + "</pre>"
					+ "\r\n || After Reversal : \r\n" + "<pre>" + import_Invoice_Tabledata_After_Reverse + "</pre>",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is not displayed ");
			Extent_fail(driver,
					"Not Matched || Expected result is : Import Invoice Table should be displayed || Actual result is : Import Invoice Table is not displayed ",
					test, test1);

		}
		 }

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		 }
		Step_End(26, "Load the Invoice NO", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
