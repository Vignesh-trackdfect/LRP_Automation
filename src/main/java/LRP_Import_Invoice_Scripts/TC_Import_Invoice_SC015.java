package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC015 extends Keywords {

	public void Import_Invoice_SC015(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC015";
		
		


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
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Import_Doc_Customer_Type_Header = Excel_data.get("Import_Doc_Customer_Type_Header");
		String Import_Doc_Customer_TypeValue = Excel_data.get("Import_Doc_Customer_TypeValue");
		String Import_Doc_Customer_CodeHeader = Excel_data.get("Import_Doc_Customer_CodeHeader");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String ImportDocumentaion_Module = Excel_data.get("ImportDocumentaion_Module");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String Invoice_Table_Name = Excel_data.get("Invoice_Table_Name");
		String importInvoiceUpdatedPopup = Excel_data.get("ImportInvoiceUpdatedPopup");
		String Import_Doc_Customer_CodeHeader_Verify = Excel_data.get("Import_Doc_Customer_CodeHeader_Verify");
		String ID_Invoice_Table_Headers_Verify = Excel_data.get("ID_Invoice_Table_Headers_Verify");
		String ImportDocumentation_Table_Name = Excel_data.get("ImportDocumentation_Table_Name");
		String reverse_Option = Excel_data.get("reverse_Option");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");

		 
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

			scrollTop(driver);

			if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_BL")) {

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, Condition, BL_Filter_Type_Import_Doc, BL_Num, "", "", "", "");

			} else if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_Service")) {

				newButton(driver);
				waitForElement(driver, ID_servicename);
				sendKeys(driver, ID_servicename, service_input);

				sendKeys(driver, ID_grid_vesselcode, vessel_code_input);
				sendKeys(driver, ID_grid_voyagecode, voyage_code);
				sendKeys(driver, ID_grid_bound, Bound_code_input);
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

			scrollBottom(driver);

			waitForElement(driver, Customer_Tab);
			click(driver, Customer_Tab);

			
//			waitForElement(driver, customer_code_copy);
//			String CustomerCode = getText(driver, customer_code_copy);
			
			waitForElement(driver, Customer_Table_Header);
			Step_End(8, "before click the customer field ", test, test1);

			List<Map<String, String>> ImportDoc_Customer_Tabledata = getTableData(driver, Customer_Table_Header,
					Customer_Table_Row);
			String CustomerCode = getValueByFirstColumnAndHeader(ImportDoc_Customer_Tabledata,
					Import_Doc_Customer_Type_Header, Import_Doc_Customer_TypeValue, Import_Doc_Customer_CodeHeader);
			scrollTop(driver);

			Step_End(9,
					"go the import documentation module retrieve the same bl and go to the customer tab --copy the consignee customer code or name ",
					test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			Step_Start(10, "click the customer field and put the CN code or name", test, test1);
			Step_Start(11, "load the same Customer and click on SHow BL button, ", test, test1);

			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, CustomerCode, "", "", "",
					"");

			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);

			Step_End(10, "click the customer field and put the CN code or name", test, test1);
			Step_End(11, "load the same Customer and click on SHow BL button, ", test, test1);
			
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

		Step_Start(12, "select the draft and click the save button in tool bar", test, test1);

		scrollTop(driver);
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
		Step_Start(18, "Actual customer and above grid showing customer details ", test, test1);

		List<Map<String, String>> invoice_Tabledata = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);

		List<String> columnheaders_Invoice = splitAndExpand(Invoice_Table_Headers);
		List<String> invoiceNumbers = getValuesByHeader(invoice_Tabledata, columnheaders_Invoice.get(0));

		ArrayList<String> inv_Numbers = new ArrayList<String>();
		for (int i = 0; i < invoiceNumbers.size(); i++) {
			inv_Numbers.add(invoiceNumbers.get(i));
		}

		System.out.println("inv_Numbers : " + inv_Numbers);

		List<String> customerVerify_Inv = splitAndExpand(ID_Invoice_Table_Headers_Verify);
		String import_Invoice_Tabledata_Report = TableDataForReport(driver, invoice_Tabledata, Invoice_Table_Name,
				customerVerify_Inv);

		ArrayList<String> CustomerDetails_INV = new ArrayList<String>();
		for (int i = 0; i < customerVerify_Inv.size(); i++) {
			List<String> customerDetails_INV = getValuesByHeader(invoice_Tabledata, customerVerify_Inv.get(i));
			for (int j = 0; j < customerDetails_INV.size(); j++) {

				CustomerDetails_INV.add(customerDetails_INV.get(j));
			}
		}
		System.out.println("CustomerCode : " + CustomerDetails_INV);

		Step_End(18, "Actual customer and above grid showing customer details ", test, test1);
		Step_Start(19, "open the import documentation", test, test1);

		Extent_cal(test, test1, ImportDocumentaion_Module);

		moduleNavigate(driver, ImportDocumentaion_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, BL_Filter_Type_Import_Doc, BL_Num, "", "", "", "");

		Step_End(19, "open the import documentation", test, test1);

		Step_Start(20, "retrieve the same bill", test, test1);

		Step_Start(21, "Go to the customer customer --Consignee details showing ", test, test1);

		scrollBottom(driver);

		waitForElement(driver, Customer_Tab_IMD);
		click(driver, Customer_Tab_IMD);

		waitForElement(driver, Customer_Table_Header);

		List<String> customerVerify_IMD = splitAndExpand(Import_Doc_Customer_CodeHeader_Verify);
		List<Map<String, String>> ImportDoc_Customer_Tabledata = getTableData(driver, Customer_Table_Header,
				Customer_Table_Row);

		ArrayList<String> customerDetails = new ArrayList<String>();

		for (int i = 0; i < customerVerify_IMD.size(); i++) {
			String CustomerDetails = getValueByFirstColumnAndHeader(ImportDoc_Customer_Tabledata,
					Import_Doc_Customer_Type_Header, Import_Doc_Customer_TypeValue, customerVerify_IMD.get(i));

			
			String customer_tab_details=CustomerDetails.toUpperCase();

			customerDetails.add(customer_tab_details);
		}
		System.out.println("CustomerCode : " + customerDetails);
		String import_Doc_Tabledata = TableDataForMatchingRow(driver, ImportDoc_Customer_Tabledata, ImportDocumentation_Table_Name, customerVerify_IMD,"Customer Type" , "CN");
		


		String Import_Documentation_customer_tab_details=import_Doc_Tabledata.toUpperCase();
				
		Step_End(20, "retrieve the same bill", test, test1);

		Extent_call(test, test1, "---------------verify-------------\r\n"
				+ "17 customer details Actual customer Code , Name , address should be match with import invoice and import documentation.");

		for (int i = 0; i < CustomerDetails_INV.size(); i++) {
			if (customerDetails.contains(CustomerDetails_INV.get(i))) {
				if (i == CustomerDetails_INV.size() - 1) {
					System.out.println("Passed || Customer details in Import Invoice : \n" + "<pre>"
							+ import_Invoice_Tabledata_Report + "</pre>"
							+ "\r\n ||  Customer details in Import Documentation : \r\n" + "<pre>"
							+ Import_Documentation_customer_tab_details + "</pre>");
					Extent_pass_New(driver,
							"Passed || Customer details in Import Invoice : \n" + "<pre>"
									+ import_Invoice_Tabledata_Report + "</pre>"
									+ "\r\n ||  Customer details in Import Documentation : \r\n" + "<pre>"
									+ Import_Documentation_customer_tab_details + "</pre>",
							test, test1);
				}
			} else {
				System.out.println(
						"Fail || Expected result is : Customer details should be match with import invoice and import documentation || Actual result is : Customer details are not matched with import invoice and import documentation");
				Extent_fail(driver,
						"Fail || Expected result is : Customer details should be match with import invoice and import documentation || Actual result is : Customer details are not matched with import invoice and import documentation",
						test, test1);

			}
		}

		Step_End(21, "Go to the customer customer --Consignee details showing ", test, test1);
		Step_Start(22, "once saved the import issued invoice.", test, test1);
		 if(reverse_Option.equalsIgnoreCase("Yes")) {
			 
			 Invoice_Reversal(driver, InvoiceReversal_Module, Condition, Global_search_value_Bl_No, BL_Num, invoiceReversalRemarks, invoiceReversedPopup);
			 
			 
		 }
		Extent_completed(testcase_Name, test, test1);

	}

}
