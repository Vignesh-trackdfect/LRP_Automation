package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC017A extends Keywords {

	public void Import_Invoice_SC017A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC017A";
		
		 
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
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String Port_Code = Excel_data.get("Port_Code");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String ImportDocumentaion_Module = Excel_data.get("ImportDocumentaion_Module");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String importInvoiceUpdatedPopup = Excel_data.get("ImportInvoiceUpdatedPopup");
		String tax_ChargeCode = Excel_data.get("Tax_ChargeCode");
		String reverse_Option = Excel_data.get("reverse_Option");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup"); 
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");

		String ManifiesChargesTable_Headers_ImpInv = Excel_data.get("ManifiesChargesTable_Headers_ImpInv");
		String ChargesTable_Headers_ImpDoc = Excel_data.get("ChargesTable_Headers_ImpDoc");


		
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

		if (BL_Retrive_from_Import_invoice.equals("By Vessel")) {

			Step_Start(4, "click the by vessel option", test, test1);

			waitForElement(driver, by_vessels_select);
			click(driver, by_vessels_select);

			Step_End(4, "click the by vessel option", test, test1);
			Step_Start(5, "enter the service in service field", test, test1);

			waitForElement(driver, service_text);
			sendKeys(driver, service_text, service_input);

			Step_End(5, "enter the service in service field", test, test1);
			Step_Start(6, "automatically service details has to be populated based on the given service", test, test1);

			waitForElement(driver, vessels_code_input);

			Step_End(6, "automatically service details has to be populated based on the given service", test, test1);
			Step_Start(7, "select the serive ,vessel and voyage details for that bl", test, test1);

			sendKeys(driver, vessels_code_input, vessel_code_input);
			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, voyage_code);
			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_code_input);
			horizontalscroll(driver, By_Vessel_Scroll, 500); 
			if(!Terminal_Code_Input.equals("")) {
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

			Step_Start(9,
					"go the import documentation module retrieve the same bl and go to the customer tab --copy the consignee customer code or name ",
					test, test1);

			moduleNavigate(driver, ImportDocumentaion_Module);
			if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_BL")) {

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, Condition, BL_Filter_Type_Import_Doc, BL_Num, "", "", "", "");

			} else if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_Service")) {

				newButton(driver);
				waitForElement(driver, ID_servicename);
				sendKeys(driver, ID_servicename, service_input);

				waitForElement(driver, ID_grid_vesselcode);
				sendKeys(driver, ID_grid_vesselcode, vessel_code_input);
				waitForElement(driver, ID_grid_voyagecode);
				sendKeys(driver, ID_grid_voyagecode, voyage_code);
				
				waitForElement(driver, ID_grid_bound);
				sendKeys(driver, ID_grid_bound, Bound_code_input);
				
				waitForElement(driver, ID_grid_portcode);
				sendKeys(driver, ID_grid_portcode, Port_Code);

				horizontalscroll(driver, grid_scroll, 300);
				click(driver, ID_grid_terminal);
				sendKeys(driver, ID_grid_terminal, Terminal_Code_Input);
				waitForElement(driver, service_grid_first_row);
				click(driver, service_grid_first_row);

				waitForElement(driver, service_select_btn);
				click(driver, service_select_btn);

				waitForElement(driver, ID_Show_Button);
				click(driver, ID_Show_Button);
			}

			scrollBottom(driver);
			waitForElement(driver, Customer_Tab);
			click(driver, Customer_Tab);

			waitForElement(driver, Customer_Table_Header);

			waitForElement(driver, customer_code_copy);
			String CustomerCode = getText(driver, customer_code_copy);
			
			scrollTop(driver);

			Step_End(9,
					"go the import documentation module retrieve the same bl and go to the customer tab --copy the consignee customer code or name ",
					test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			Step_Start(10, ".click the customer field and put the CN code or name", test, test1);

			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, CustomerCode, "", "", "",
					"");

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
			
		
			RemoveBLfromInvoice(driver, BL_Num, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);
			waitForElement(driver, Import_Invoice_BL_Details_Table_Row);

			if (verifyElementHasText(driver, Import_Invoice_BL_Details_Table_Row)) {

				System.out.println(
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab");
				Extent_pass_New(driver,
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab",
						test, test1);

			} else {
				System.out.println(
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab");
				Extent_fail(driver,
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab",
						test, test1);
			}

			Step_End(11, "load the same Customer and click on SHow BL button", test, test1);

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

		waitForElement(driver, importInvoice_Table_Header);
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
		List<Map<String, String>> manifestCharges_Tabledata = getTableData(driver, manifestCharges_Table_Columns_IN,
				manifestCharges_Table_Rows_IN);

		List<String> chargesHeaders_inv=splitAndExpand(ManifiesChargesTable_Headers_ImpInv,",");
		
		Map<String, List<String>> ManifiesValues_ImportInvoice=getColumnValuesByHeaders(manifestCharges_Tabledata,chargesHeaders_inv);
		String chargesTable_Imp_Invoice=printTable(driver,ManifiesValues_ImportInvoice,chargesHeaders_inv);
		
		

		waitForElement(driver, nonManifestCharges_Tab_IN);
		click(driver, nonManifestCharges_Tab_IN);
		
		waitForElement(driver, nonManifestCharges_Table_Rows_IN);
		List<Map<String, String>> nonManifestCharges_Tabledata = getTableData(driver,
				nonManifestCharges_Table_Columns_IN, nonManifestCharges_Table_Rows_IN);

		List<String> nonMandatoryVal=splitAndExpand(tax_ChargeCode,",");			
		Map<String, List<String>> NonManifiestValues_ImportInvoice=getTableValuesExpectColumnValue(nonManifestCharges_Tabledata,"Charge Code",nonMandatoryVal,chargesHeaders_inv);

		String Non_ManifieschargesTable_Imp_Invoice=printTable(driver,NonManifiestValues_ImportInvoice,chargesHeaders_inv);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		

		Step_Start(20, "Open Import Doc and load the same BL,", test, test1);
//		Import Documentation
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

		List<String> ChargesTableHeaders_ImpDoc=splitAndExpand(ChargesTable_Headers_ImpDoc,",");
//		String chargesTableImportDoc=TableDataForReport(driver, collect_Chareges_Tabledata, "Collect charges Tab ImportDoc", ChargesTableHeaders_ImpDoc);
		
		Map<String, List<String>> ManifiestValues_ImpDoc=new HashMap<String, List<String>>();
		Map<String, List<String>> NonManifiestValues_ImpDoc=new HashMap<String, List<String>>();

		for(String Val:ChargesTableHeaders_ImpDoc) {
			
			String firstcolumnHeader = "Type";
			String firstColumnValue = "Manifest";
			List<String> chargeCode_IMD = getValuesByFirstColumnAndHeader(collect_Chareges_Tabledata, firstcolumnHeader,
					firstColumnValue, Val);
			
			List<String> NonManifiestchargeCode_IMD = getValuesByExceptFirstColumnAndHeader(collect_Chareges_Tabledata, firstcolumnHeader,
					firstColumnValue, Val);
			
			ManifiestValues_ImpDoc.put(Val, chargeCode_IMD);
			NonManifiestValues_ImpDoc.put(Val, NonManifiestchargeCode_IMD);			
		}
		
		
		String Manifiest_TableImportDoc=printTable(driver,ManifiestValues_ImpDoc,ChargesTableHeaders_ImpDoc);
		String NonManifiest_TableImportDoc=printTable(driver,NonManifiestValues_ImpDoc,ChargesTableHeaders_ImpDoc);		

		Extent_pass_New(driver, "Manifiest Charges Import Invoice : "+chargesTable_Imp_Invoice +" Import Document Table : "+Manifiest_TableImportDoc , test, test1);
				
		Extent_call(test, test1, "Manifiest Values Comparision Start");
		for(int k=0;k<chargesHeaders_inv.size();k++) {
			
			String CompareVale=chargesHeaders_inv.get(k);
			List<String>  Expected_Manifiest=ManifiesValues_ImportInvoice.get(CompareVale);
			List<String> Actual_Manifiest=ManifiestValues_ImpDoc.get(ChargesTableHeaders_ImpDoc.get(k));
			
			if(compareLists(Expected_Manifiest,Actual_Manifiest)) {
				System.out.println(CompareVale+" Values Matched in Import Document And Import Invoice (Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest);
				Extent_pass_New(driver, CompareVale+" Values Matched in Import Document And Import Invoice (Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest, test, test1);
			}else {
				System.out.println(CompareVale+" Values Not Matched in Import Document And Import Invoice (Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest);
				Extent_fail(driver, CompareVale+" Values Not Matched in Import Document And Import Invoice (Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest, test, test1);
			}
		}
		Extent_call(test, test1, "Manifiest Values Comparision End ");
		
		
		Extent_pass_New(driver, "Non Manifiest Charges Import Invoice : "+Non_ManifieschargesTable_Imp_Invoice +"Non ManifiestValues Import Document Table : "+NonManifiest_TableImportDoc , test, test1);

		Extent_call(test, test1, "Non Manifiest Values Comparision Start");
		for(int k=0;k<chargesHeaders_inv.size();k++) {
			
			String CompareVale=chargesHeaders_inv.get(k);
			List<String>  Expected_Manifiest=NonManifiestValues_ImportInvoice.get(CompareVale);
			List<String> Actual_Manifiest=NonManifiestValues_ImpDoc.get(ChargesTableHeaders_ImpDoc.get(k));
			
			if(compareLists(Expected_Manifiest,Actual_Manifiest)) {
				System.out.println(CompareVale+" Values Matched in Import Document And Import Invoice (Non Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest);
				Extent_pass_New(driver, CompareVale+" Values Matched in Import Document And Import Invoice (Non Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest, test, test1);
			}else {
				System.out.println(CompareVale+" Values Not Matched in Import Document And Import Invoice (Non Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest);
				Extent_fail(driver, CompareVale+" Values Not Matched in Import Document And Import Invoice (Non Manifiest) || Import Invoice : "+Expected_Manifiest+"  || Import Document : "+Actual_Manifiest, test, test1);
			}
		}
		Extent_call(test, test1, "Non Manifiest Values Comparision End ");
		
		scrollTop(driver);

		
		Extent_pass_New(driver, "Expected : charge code defined in import Invoice && Import Documentation are matched || Actual : charge code defined in import Invoice && Import Documentation are matched", test, test1);
		if(reverse_Option.equalsIgnoreCase("Yes")) {
			
			Invoice_Reversal(driver, InvoiceReversal_Module, Condition, Global_search_value_Bl_No, invNumber, invoiceReversalRemarks, invoiceReversedPopup);
		

		}
		Extent_completed(testcase_Name, test, test1);
		
		
		
	}

}
