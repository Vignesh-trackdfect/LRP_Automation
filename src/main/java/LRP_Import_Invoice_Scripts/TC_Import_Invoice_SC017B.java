package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC017B  extends Keywords {

	public void Import_Invoice_SC017B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC017B";
		
		


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
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String ImportDocumentaion_Module = Excel_data.get("ImportDocumentaion_Module");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String importInvoiceUpdatedPopup = Excel_data.get("ImportInvoiceUpdatedPopup");
		String tax_ChargeCode = Excel_data.get("Tax_ChargeCode");
		String reverse_Option = Excel_data.get("reverse_Option");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		
		
		
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
			System.out.println(BL_Numberact);
			if (BL_Num.equals(BL_Numberact)) {

				Extent_pass_New(driver, "Matched || Expected BL_Number : " + BL_Num + " || Actual   BL_Number: "
						+ BL_Numberact, test, test1);
				System.out.println("Matched || Expected BL_Number: " + BL_Num + " || Actual   BL_Number: "
						+ BL_Numberact);

			} else {
				System.out.println("Not Matched || Expected  BL_Number : " + BL_Num + " || Actual  BL_Number: "
						+ BL_Numberact);
				Extent_fail(driver, "Not Matched || Expected  BL_Number : " + BL_Num
						+ " || Actual  BL_Number : " + BL_Numberact, test, test1);

			}

			Step_End(4, " Click on BL NO Search and Paste the BL in the search and then load the BL.", test, test1);

		}

	

			
		Step_Start(12, "select the draft and click the save button in tool bar", test, test1);

		waitForElement(driver, importInvoice_Draft_Button);
		click(driver, importInvoice_Draft_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(12, "select the draft and click the save button in tool bar", test, test1);
		Step_Start(13, "system has validate import invoice saved...click ok", test, test1);

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

		Step_End(13, "system has validate import invoice saved...click ok", test, test1);
		Step_Start(14, "click the edit button in tool bar", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(14, "click the edit button in tool bar", test, test1);
		Step_Start(15, "select the issued", test, test1);

		waitForElement(driver, issued_Button);
		click(driver, issued_Button);

		Step_End(15, "select the issued", test, test1);
		Step_Start(16, "click the save button in tool bar", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(16, "click the save button in tool bar", test, test1);
		Step_Start(17, "system has validate import invoice updated.click ok", test, test1);

		waitForPopup(driver, popup_Message, importInvoiceUpdatedPopup);

		actualPopup = getText(driver, popup_Message);

		if (actualPopup.equals(importInvoiceUpdatedPopup)) {

			Extent_pass_New(driver,
					"Matched || Expected popup : " + importInvoiceUpdatedPopup + " || Actual popup : " + actualPopup,
					test, test1);
			System.out.println(
					"Matched || Expected popup : " + importInvoiceUpdatedPopup + " || Actual popup : " + actualPopup);
			click(driver, popup_Message_Ok_Button);

		} else {
			System.out.println("Not Matched || Expected popup : " + importInvoiceUpdatedPopup + " || Actual popup : "
					+ actualPopup);
			Extent_fail(driver, "Not Matched || Expected popup : " + importInvoiceUpdatedPopup + " || Actual popup : "
					+ actualPopup, test, test1);
		}

		Step_End(17, "system has validate import invoice updated.click ok", test, test1);

		Step_Start(18, "Go to Manifest Tab/Non Manifest Tab,Detention Tab,Storage Tab,\r\n"
				+ "If Manifest/Non Manifest follow below Steps,", test, test1);
		Step_Start(19,
				"click on Manifest/Non Manifest Tab as per Test Data and CaptureValues (system has to refer only Charge details not for the tax related rows.)",
				test, test1);

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


		waitForElement(driver, manifestCharges_Tab_IN);
		click(driver, manifestCharges_Tab_IN);

		waitForElement(driver, manifestCharges_Table_Rows_IN);
		List<WebElement> total_Rows = listOfElements(driver, manifestCharges_Table_Rows_IN);
		int manifestRows = total_Rows.size();


		List<Map<String, String>> manifestCharges_Tabledata = getTableData(driver, manifestCharges_Table_Columns_IN,
				manifestCharges_Table_Rows_IN);


		ArrayList<String> manifest_ChargeCode = new ArrayList<String>();
		List<String> manifest_Values = getValuesByHeader(manifestCharges_Tabledata, "Charge Code");

		for (int i = 0; i < manifest_Values.size(); i++) {

			System.out.println("manifest_Values : " + manifest_Values);
			manifest_ChargeCode.add(manifest_Values.get(i));

		}

		System.out.println("manifest_ChargeCode : " + manifest_ChargeCode);

		List<String> inv_Amount = getValuesByHeader(manifestCharges_Tabledata, "Invoice Amount");

		ArrayList<String> invoice_Amount = new ArrayList<String>();

		for (int i = 0; i < inv_Amount.size(); i++) {
			invoice_Amount.add(inv_Amount.get(i));
		}
		System.out.println("Invoice Amount : " + invoice_Amount);


		waitForElement(driver, nonManifestCharges_Tab_IN);
		click(driver, nonManifestCharges_Tab_IN);

		waitForElement(driver, nonManifestCharges_Table_Rows_IN);

		waitForElement(driver, nonManifestCharges_Table_Rows_IN);

		List<Map<String, String>> nonManifestCharges_Tabledata = getTableData(driver,
				nonManifestCharges_Table_Columns_IN, nonManifestCharges_Table_Rows_IN);



		ArrayList<String> non_Manifest_ChargeCode = new ArrayList<String>();
		List<String> non_Manifest_Values = getValuesByHeader(nonManifestCharges_Tabledata, "Charge Code");

		int rows_Non_Manifest = 0;
		for (int i = 0; i < non_Manifest_Values.size(); i++) {

			System.out.println("manifest_Values : " + non_Manifest_Values);

			if (!non_Manifest_Values.get(i).equals(tax_ChargeCode)) {
				non_Manifest_ChargeCode.add(non_Manifest_Values.get(i));
				rows_Non_Manifest++;
			}
		}

		System.out.println("non_Manifest_ChargeCode : " + non_Manifest_ChargeCode);

		List<String> inv_Amount_Non_Manifest = getValuesByHeader(nonManifestCharges_Tabledata, "Invoice Amount");

		ArrayList<String> invoice_Amount_Non_Manifest = new ArrayList<String>();

		for (int i = 0; i < inv_Amount_Non_Manifest.size(); i++) {
			invoice_Amount_Non_Manifest.add(inv_Amount_Non_Manifest.get(i));
		}
		System.out.println("Invoice Amount : " + invoice_Amount_Non_Manifest);
		
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		
//		Import Documentation

		Step_Start(20, "Open Import Doc and load the same BL,", test, test1);

		moduleNavigate(driver, ImportDocumentaion_Module);

		Step_End(20, "Open Import Doc and load the same BL,", test, test1);
		Step_Start(21,
				" Go to charges tab if it is Manifest system has to Capture type as Manifest charges and Compare if it is non Manifest system has to capture type as Agency tab and Compare Capture Value,",
				test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, BL_Filter_Type_Import_Doc, BL_Num, "", "", "", "");

		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);

		Extent_call(test, test1,
				"Capture the Charge Code,Currency, Qty, Rate, and Amount Import Invoice and Compare in Import Documentation Module");

		scrollBottom(driver);
		waitForElement(driver, collectChargersTab_Rows);

		List<Map<String, String>> collect_Chareges_Tabledata = getTableData(driver, collectChargersTab_Coloumns,
				collectChargersTab_Rows);

		String firstcolumnHeader = "Type";
		String firstColumnValue = "Manifest";
		List<String> chargeCode_IMD = getValuesByFirstColumnAndHeader(collect_Chareges_Tabledata, firstcolumnHeader,
				firstColumnValue, "Charge Code");
		scrollTop(driver);

		int manifestCount_IMD = 0;

		ArrayList<String> manifest_ChargeCodes_IMD = new ArrayList<String>();
		for (int i = 0; i < chargeCode_IMD.size(); i++) {
			manifest_ChargeCodes_IMD.add(chargeCode_IMD.get(i));
			manifestCount_IMD++;
		}

		System.out.println("manifest_ChargeCodes_IMD : " + manifest_ChargeCodes_IMD);

		String firstColumnValue1 = "Agency";
		List<String> agencychargeCode_IMD = getValuesByFirstColumnAndHeader(collect_Chareges_Tabledata,
				firstcolumnHeader, firstColumnValue1, "Charge Code");
		scrollTop(driver);

		int agencyCount_IMD = 0;
		ArrayList<String> agency_ChargeCodes_IMD = new ArrayList<String>();
		for (int i = 0; i < agencychargeCode_IMD.size(); i++) {
			agency_ChargeCodes_IMD.add(agencychargeCode_IMD.get(i));
			agencyCount_IMD++;
		}

		System.out.println("manifest_ChargeCodes_IMD : " + agency_ChargeCodes_IMD);

		for (int i = 0; i < manifest_ChargeCodes_IMD.size(); i++) {
			if (manifest_ChargeCodes_IMD.contains(manifest_ChargeCode.get(i))) {
				if (i == manifest_ChargeCodes_IMD.size() - 1) {
					System.out.println("Matched || Manifest Charges in Import invoice : " + manifest_ChargeCode
							+ " || Manifest Charges in Import Documentation : " + manifest_ChargeCodes_IMD);
					Extent_pass_New(driver,
							"Matched || Manifest Charges in Import invoice : " + manifest_ChargeCode
									+ " || Manifest Charges in Import Documentation : " + manifest_ChargeCodes_IMD,
							test, test1);
				}
			} else {
				System.out.println("Not Matched || Manifest Charges in Import invoice : " + manifest_ChargeCode
						+ " || Manifest Charges in Import Documentation : " + manifest_ChargeCodes_IMD);
				Extent_fail(driver,
						"Not Matched || Manifest Charges in Import invoice : " + manifest_ChargeCode
								+ " || Manifest Charges in Import Documentation : " + manifest_ChargeCodes_IMD,
						test, test1);

			}
		}
		for (int i = 0; i < agency_ChargeCodes_IMD.size(); i++) {

			if (agency_ChargeCodes_IMD.contains(non_Manifest_ChargeCode.get(i))) {
				if (i == agency_ChargeCodes_IMD.size() - 1) {
					System.out.println("Matched || Non Manifest Charges in Import invoice : " + non_Manifest_ChargeCode
							+ " || Agency Charges in Import Documentation : " + agency_ChargeCodes_IMD);
					Extent_pass_New(driver,
							"Matched || Non Manifest Charges in Import invoice : " + non_Manifest_ChargeCode
									+ " || Agency Charges in Import Documentation : " + agency_ChargeCodes_IMD,
							test, test1);
				}
			} else {
				System.out.println("Not Matched || Non Manifest Charges in Import invoice : " + non_Manifest_ChargeCode
						+ " || Agency Charges in Import Documentation : " + agency_ChargeCodes_IMD);
				Extent_fail(driver,
						"Not Matched || Non Manifest Charges in Import invoice : " + non_Manifest_ChargeCode
								+ " || Agency Charges in Import Documentation : " + agency_ChargeCodes_IMD,
						test, test1);

			}
		}
		if (manifestRows == manifestCount_IMD) {
			System.out.println("Matched || Manifest Charges in Import invoice : " + manifestRows
					+ " || Manifest Charges in Import Documentation : " + manifestCount_IMD);
			Extent_pass_New(driver, "Matched || Manifest Charges in Import invoice : " + manifestRows
					+ " || Manifest Charges in Import Documentation : " + manifestCount_IMD, test, test1);

		} else {
			System.out.println("Not Matched || Manifest Charges in Import invoice : " + manifestRows
					+ " || Manifest Charges in Import Documentation : " + manifestCount_IMD);
			Extent_fail(driver, "Not Matched || Manifest Charges in Import invoice : " + manifestRows
					+ " || Manifest Charges in Import Documentation : " + manifestCount_IMD, test, test1);

		}

		if (rows_Non_Manifest == agencyCount_IMD) {
			System.out.println("Matched || Non Manifest Charges in Import invoice : " + rows_Non_Manifest
					+ " || Agency Charges in Import Documentation : " + agencyCount_IMD);
			Extent_pass_New(driver, "Matched || Non Manifest Charges in Import invoice : " + rows_Non_Manifest
					+ " || Agency Charges in Import Documentation : " + agencyCount_IMD, test, test1);

		} else {
			System.out.println("Not Matched || Non Manifest Charges in Import invoice : " + rows_Non_Manifest
					+ " || Agency Charges in Import Documentation : " + agencyCount_IMD);
			Extent_fail(driver, "Not Matched || Non Manifest Charges in Import invoice : " + rows_Non_Manifest
					+ " || Agency Charges in Import Documentation : " + agencyCount_IMD, test, test1);

		}

		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		if(reverse_Option.equalsIgnoreCase("Yes")) {
			Invoice_Reversal(driver, InvoiceReversal_Module, Condition, Global_search_value_Bl_No, invNumber, invoiceReversalRemarks, invoiceReversedPopup);
			
		
			}
			Extent_completed(testcase_Name, test, test1);
			
		
		
	}

}
