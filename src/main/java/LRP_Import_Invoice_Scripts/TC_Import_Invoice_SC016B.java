package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC016B extends Keywords {

	public void Import_Invoice_SC016B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC016B";
		
		
 
 
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
		String columnHeaders_BL_Details = Excel_data.get("ColumnHeaders_BL_Details");
		String BL_Details_table_Name_In = Excel_data.get("BL_Details_table_Name_In");
		String manifest_Number_Header = Excel_data.get("Manifest_Number_Header");
		String module_BillOfLading = Excel_data.get("Module_BillOfLading");
		String MCN_Module = Excel_data.get("MCN_Module");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String Select_Search_Type_BOL = Excel_data.get("Select_Search_Type_BOL");
		String Book_No = Excel_data.get("Book_No");
		String BL_Number = Excel_data.get("BL_Number");
		String Status = Excel_data.get("Status");
		String no_Of_20s = Excel_data.get("No_Of_20s");
		String no_Of_40s = Excel_data.get("No_Of_40s");
		String ID_container_Table_Headers = Excel_data.get("IMD_container_Table_Headers");
		String eqpuipmentType_Header = Excel_data.get("EqpuipmentType_Header");
		String ID_container_Table = Excel_data.get("IMD_container_Table");
		String discharge_Code = Excel_data.get("Discharge_Code");
		String condition_TwoCol = Excel_data.get("Condition_TwoCol");
		String discharge_Status_Verify = Excel_data.get("Discharge_Status_Verify");
		String Discharge_Search = Excel_data.get("Discharge_Search");
		String reverse_option = Excel_data.get("reverse_option");
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
			Step_End(8, "before click the customer field ", test, test1);
			waitForElement(driver, customer_code_copy);
			String CustomerCode = getText(driver, customer_code_copy);
			

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


			Step_End(10, "click the customer field and put the CN code or name", test, test1);
			Step_End(11, "load the same Customer and click on SHow BL button, ", test, test1);

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


// Invoice Table 

		waitForElement(driver, importInvoice_Table_Row);
		List<Map<String, String>> invoice_Tabledata = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);

		List<String> columnheaders_Invoice = splitAndExpand(Invoice_Table_Headers);
		List<String> invoiceNumbers = getValuesByHeader(invoice_Tabledata, columnheaders_Invoice.get(0));

		ArrayList<String> inv_Numbers = new ArrayList<String>();
		for (int i = 0; i < invoiceNumbers.size(); i++) {
			inv_Numbers.add(invoiceNumbers.get(i));
		}

		System.out.println("inv_Numbers : " + inv_Numbers);

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
		List<String> bl_Details_Book_No = getValuesByHeader(bl_Details_Tabledata, Book_No);
		String actual_Book_No_INV = bl_Details_Book_No.get(0);

		List<String> bl_Details_BL_Number = getValuesByHeader(bl_Details_Tabledata, BL_Number);
		String actual_bl_Details_BL_Number_INV = bl_Details_BL_Number.get(0);

		List<String> BL_Type_Value = getValuesByHeader(bl_Details_Tabledata, "BL Type");
		System.out.println("Import Invoice BL Type : "+ BL_Type_Value);
		


		List<String> bl_Details_Status = getValuesByHeader(bl_Details_Tabledata, Status);
		String actual_bl_Details_Status_INV = bl_Details_Status.get(0);

		System.out.println("bl_Details : " + bl_Details);

//		Get manifest number		
		List<String> manifestNumber_Header = getValuesByHeader(bl_Details_Tabledata, manifest_Number_Header);
		String manifestNumber = manifestNumber_Header.get(0);

		if (isDisplayed(driver, bl_Details_Table_Rows_IN)) {
			System.out.println(
					"Matched || Expected result is : BL Details Table should be displayed || Actual result is :BL Details Table is displayed ");
			Extent_pass_New(driver,
					"Matched || Expected result is : BL Details Table should be displayed || Actual result is : BL Details Table is displayed ",
					test, test1);
			Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" + BL_Details_Tabledata + "</pre>", test, test1);
		} else {
			System.out.println(
					"Matched || Expected result is : BL Details Table should be displayed || Actual result is :BL Details Table is displayed ");
			Extent_fail(driver,
					"Matched || Expected result is : BL Details Table should be displayed || Actual result is : BL Details Table is displayed ",
					test, test1);
		}

//		No of 20s and 40s
		List<String> noOF_20s = getValuesByHeader(bl_Details_Tabledata, no_Of_20s);
		List<String> noOF_40s = getValuesByHeader(bl_Details_Tabledata, no_Of_40s);

		System.out.println("noOF_20s : " + noOF_20s);
		System.out.println("noOF_40s : " + noOF_40s);

		int no_Of_20s_Count = Integer.parseInt(noOF_20s.get(0));
		int no_Of_40s_Count = Integer.parseInt(noOF_40s.get(0));

//  Discharge status

		List<String> discharge_Status_INV = getValuesByHeader(bl_Details_Tabledata, discharge_Status_Verify);
		String actual_discharge_Status_INV = discharge_Status_INV.get(0);
		System.out.println("actual_discharge_Status_INV : " + actual_discharge_Status_INV);
scrollTop(driver);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		if (manifestNumber.equals("")) {
			scrollTop(driver);
			Extent_cal(test, test1, module_BillOfLading);
			moduleNavigate(driver, module_BillOfLading);

			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, Condition, Select_Search_Type_BOL, actual_bl_Details_BL_Number_INV, "", "",
					"", "");

			waitForElement(driver, blNo_Textfield_BOL);
			String actual_BL_Number_BOL = getAttribute(driver, blNo_Textfield_BOL, "value");
			System.out.println("actual_BL_Number_BOL : " + actual_BL_Number_BOL);

			waitForElement(driver, bookNo_Textfield_BOL);
			String actual_Book_Number_BOL = getAttribute(driver, bookNo_Textfield_BOL, "value");
			System.out.println("actual_Book_Number_BOL : " + actual_Book_Number_BOL);
			
			waitForElement(driver, System_BL_Type_Field);
			String act_bl_Type = getAttribute(driver, System_BL_Type_Field, "value");
			System.out.println("act_bl_Type : " + act_bl_Type);
			
			if(BL_Type_Value.contains(act_bl_Type)) {
				
				System.out.println("Expected Result is : BL Type in Import Invoice Module  :"+ BL_Type_Value +" Actual Result is : BL Type in Import Invoice Module  :" +act_bl_Type);
				Extent_pass_New(driver, "Expected Result is : BL Type in Import Invoice Module  :"+ BL_Type_Value +" Actual Result is : BL Type in Import Invoice Module  :" +act_bl_Type, test, test1);
			}else {
				System.out.println("Expected Result is : BL Type in Import Invoice Module  :"+ BL_Type_Value +" Actual Result is : BL Type in Import Invoice Module  :" +act_bl_Type);
                Extent_fail(driver, "Expected Result is : BL Type in Import Invoice Module  :"+ BL_Type_Value +" Actual Result is : BL Type in Import Invoice Module  :" +act_bl_Type, test, test1);
			}
				

			if (actual_BL_Number_BOL.equals(actual_bl_Details_BL_Number_INV)) {
				System.out.println("Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_BL_Number_BOL);
				Extent_pass_New(driver, "Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_BL_Number_BOL, test, test1);
			} else {
				System.out.println("Not Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_BL_Number_BOL);
				Extent_fail(driver, "Not Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_BL_Number_BOL, test, test1);
			}

			if (actual_Book_Number_BOL.equals(actual_Book_No_INV)) {
				System.out.println("Matched || Book Number in import Invoice : " + actual_Book_No_INV
						+ " || Book Number in Bill of Lading : " + actual_Book_Number_BOL);
				Extent_pass_New(driver, "Matched || Book Number in import Invoice : " + actual_Book_No_INV
						+ " || Book Number in Bill of Lading : " + actual_Book_Number_BOL, test, test1);
			} else {
				System.out.println("Not Matched || Book Number in import Invoice : " + actual_Book_No_INV
						+ " || Book Number in Bill of Lading : " + actual_Book_Number_BOL);
				Extent_fail(driver, "Not Matched || Book Number in import Invoice : " + actual_Book_No_INV
						+ " || Book Number in Bill of Lading : " + actual_Book_Number_BOL, test, test1);
			}
			scrollTop(driver);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		} else {
			scrollTop(driver);
			Extent_cal(test, test1, MCN_Module);
			moduleNavigate(driver, MCN_Module);

			waitForElement(driver, SearchButton_Toolbar);

			click(driver, SearchButton_Toolbar);
			waitForElement(driver, globalSearch_Condition_Dropdown1);

			globalValueSearchWindow(driver, Condition, Select_Search_Type_MCN, manifestNumber, "", "", "", "");

			waitForElement(driver, SearchButton_Toolbar);
			waitForElement(driver, MCN_No_Textfield_MCN);
			String actual_MCN_Number_MCN = getAttribute(driver, MCN_No_Textfield_MCN, "value");
			System.out.println("actual_MCN_Number_MCN : " + actual_MCN_Number_MCN);

			waitForElement(driver, blNo_Textfield_MCN);
			String actual_BLNo_Number_MCN = getAttribute(driver, blNo_Textfield_MCN, "value");
			System.out.println("actual_BLNo_Number_MCN : " + actual_BLNo_Number_MCN);

			waitForElement(driver, bookNo_Textfield_MCN);
			String actual_Book_Number_MCN = getAttribute(driver, bookNo_Textfield_MCN, "value");
			System.out.println("actual_Book_Number_MCN : " + actual_Book_Number_MCN);

			waitForElement(driver, ID_MCN_Status);
			String actual_MCN_Status = getText(driver, ID_MCN_Status);
			System.out.println("actual_MCN_Status : " + actual_MCN_Status);

		
			if (actual_MCN_Status.equalsIgnoreCase(actual_bl_Details_Status_INV)) {
				System.out.println("Matched || MCN Status in import Invoice : " + actual_bl_Details_Status_INV
						+ " || MCN Status in MCN  : " + actual_MCN_Status);
				Extent_pass_New(driver, "Matched || MCN Status in import Invoice : " + actual_bl_Details_Status_INV
						+ " || MCN Status in MCN : " + actual_MCN_Status, test, test1);
			} else {
				System.out.println("Not Matched || MCN Status in import Invoice : " + actual_bl_Details_Status_INV
						+ " || MCN Status in MCN : " + actual_MCN_Status);
				Extent_fail(driver, "Not Matched || MCN Status in import Invoice : " + actual_bl_Details_Status_INV
						+ " || BL Status in MCN : " + actual_MCN_Status, test, test1);
			}
			if (actual_bl_Details_BL_Number_INV.equals(actual_bl_Details_BL_Number_INV)) {
				System.out.println("Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV);
				Extent_pass_New(driver, "Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV, test, test1);
			} else {
				System.out.println("Not Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV);
				Extent_fail(driver, "Not Matched || BL Number in import Invoice : " + actual_bl_Details_BL_Number_INV
						+ " || BL Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV, test, test1);
			}
			if (actual_Book_No_INV.equals(actual_Book_Number_MCN)) {
				System.out.println("Matched || Book Number in import Invoice : " + actual_Book_No_INV
						+ " || Book Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV);
				Extent_pass_New(driver,
						"Matched || Book Number in import Invoice : " + actual_Book_No_INV
								+ " || Book Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV,
						test, test1);
			} else {
				System.out.println("Not Matched || Book Number in import Invoice : " + actual_Book_No_INV
						+ " || Book Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV);
				Extent_fail(driver,
						"Not Matched || Book Number in import Invoice : " + actual_Book_No_INV
								+ " || Book Number in Bill of Lading : " + actual_bl_Details_BL_Number_INV,
						test, test1);
			}
			scrollTop(driver);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

//		Import Documentation

		Extent_cal(test, test1, ImportDocumentaion_Module);
		moduleNavigate(driver, ImportDocumentaion_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, BL_Filter_Type_Import_Doc, BL_Num, "", "", "", "");

		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);

		scrollBottom(driver);

		List<String> container_headers = splitAndExpand(ID_container_Table_Headers);
		waitForElement(driver, Container_Table_Row);
		List<Map<String, String>> container_data = getTableDatawithscroll(driver, Container_Table_Header,
				Container_Table_Row, Container_Table_Scroll, 80, -3600);
		String container_Tabledata = TableDataForReport(driver, container_data, ID_container_Table, container_headers);

		if (isDisplayed(driver, Container_Table_Row)) {
			System.out.println(
					"Matched || Expected result is : Container details should show in the Import documentation module || Actual result is : Container details has shown in Import Documentation Tab");
			Extent_pass_New(driver,
					"Matched || Expected result is : Container details should show in the Import documentation module || Actual result is : Container details has shown in Import Documentation Tab",
					test, test1);
			Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" + container_Tabledata + "</pre>", test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is : Container details should show in the Import documentation module || Actual result is : Container details are not shown in Import Documentation Tab");
			Extent_fail(driver,
					"Not Matched || Expected result is : Container details should show in the Import documentation module || Actual result is : Container details are not shown in Import Documentation Tab",
					test, test1);
		}

		List<String> importDocumentation_EquipmentType = getValuesByHeader(container_data, eqpuipmentType_Header);

		int count_DV20 = 0;
		int count_DV40 = 0;

		for (int i = 0; i < importDocumentation_EquipmentType.size(); i++) {

			String actualEqpType = importDocumentation_EquipmentType.get(i);

			if (actualEqpType.contains("20")||actualEqpType.contains("25")) {
				count_DV20++;
			} else if (actualEqpType.contains("40")||actualEqpType.contains("45")) {
				count_DV40++;
			}

		}
		System.out.println("count_DV20:" + count_DV20);

		System.out.println("count_DV40:" + count_DV40);

		if (count_DV20 == no_Of_20s_Count) {
			System.out.println("Matched || No of DV20 in Import Invoice BL Details Tab : " + no_Of_20s_Count
					+ " || Total DV20 in Import Documentation Container Tab : " + count_DV20);
			Extent_pass_New(driver, "Matched || No of DV20 in Import Invoice BL Details Tab : " + no_Of_20s_Count
					+ " || Total DV20 in Import Documentation Container Tab : " + count_DV20, test, test1);

		} else {
			System.out.println("Not Matched || No of DV20 in Import Invoice BL Details Tab : " + no_Of_20s_Count
					+ " || Total DV20 in Import Documentation Container Tab : " + count_DV20);
			Extent_fail(driver, "Not Matched || No of DV20 in Import Invoice BL Details Tab : " + no_Of_20s_Count
					+ " || Total DV20 in Import Documentation Container Tab : " + count_DV20, test, test1);

		}

		if (count_DV40 == no_Of_40s_Count) {
			System.out.println("Matched || No of DV40 in Import Invoice BL Details Tab : " + no_Of_40s_Count
					+ " || Total DV40 in Import Documentation Container Tab : " + count_DV40);
			Extent_pass_New(driver, "Matched || No of DV40 in Import Invoice BL Details Tab : " + no_Of_40s_Count
					+ " || Total DV40 in Import Documentation Container Tab : " + count_DV40, test, test1);

		} else {
			System.out.println("Not Matched || No of DV40 in Import Invoice BL Details Tab : " + no_Of_40s_Count
					+ " || Total DV40 in Import Documentation Container Tab : " + count_DV40);
			Extent_fail(driver, "Not Matched || No of DV40 in Import Invoice BL Details Tab : " + no_Of_40s_Count
					+ " || Total DV40 in Import Documentation Container Tab : " + count_DV40, test, test1);

		}
		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver, BL_HBL_Summary_Tab);

		waitForElement(driver, dischargeName_Textfield_IMD);
		String actual_Discharge_Name_IMD = getAttribute(driver, dischargeName_Textfield_IMD, "value");

		if (actual_Discharge_Name_IMD.equals("")) {
			waitForElement(driver, Discharge_status_search_button);
			click(driver, Discharge_status_search_button);

			twoColumnSearchWindow(driver, Discharge_Search, condition_TwoCol, discharge_Code);

			waitForElement(driver, dischargeName_Textfield_IMD);
			actual_Discharge_Name_IMD = getAttribute(driver, dischargeName_Textfield_IMD, "value");
			System.out.println("actual_Discharge_Name_IMD : " + actual_Discharge_Name_IMD);

			if (actual_discharge_Status_INV.equals(actual_Discharge_Name_IMD)) {
				System.out.println(
						"Matched || Discharge Status in Import Invoice BL Details Tab : " + actual_discharge_Status_INV
								+ " || Discharge Status in Import Documentation : " + actual_Discharge_Name_IMD);
				Extent_pass_New(driver,
						"Matched || Discharge Status in Import Invoice BL Details Tab : " + actual_discharge_Status_INV
								+ " || Discharge Status in Import Documentation : " + actual_Discharge_Name_IMD,
						test, test1);

			} else {
				System.out.println("Not Matched || Discharge Status in Import Invoice BL Details Tab : "
						+ actual_discharge_Status_INV + " || Discharge Status in Import Documentation  : "
						+ actual_Discharge_Name_IMD);
				Extent_fail(driver,
						"Not Matched || Discharge Status in Import Invoice BL Details Tab : "
								+ actual_discharge_Status_INV + " || Discharge Status in Import Documentation  : "
								+ actual_Discharge_Name_IMD,
						test, test1);

			}
		}
		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Ok_Button);
		}
		
scrollTop(driver);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		
		if(reverse_option.equalsIgnoreCase("Yes")) {

			Step_Start(18, "once saved the import issued invoice.open the invoice reversal module", test, test1);

			moduleNavigate(driver, InvoiceReversal_Module);

			scrollTop(driver);

			Step_End(18, "once saved the import issued invoice.open the invoice reversal module", test, test1);
			Step_Start(19, "click the new button", test, test1);

			newButton(driver);

			Step_End(19, "click the new button", test, test1);

			Step_Start(20, "load the same bl no or invoice no from import invoice in invoice reversal module.", test,
					test1);

			Step_Start(21, "select the bl no and click the show button", test, test1);

			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);

			globalValueSearchWindow(driver, Condition, Global_search_value_Bl_No, BL_Num, "", "", "", "");

			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);

			Step_End(20, "load the same bl no or invoice no from import invoice in invoice reversal module", test, test1);

			Step_End(21, "select the bl no and click the show button", test, test1);

			Step_Start(22, "in below grid invoice details has to be shown ", test, test1);

			waitForElement(driver, inv_Reversal_Table_Header);
			List<Map<String, String>> invoice_Details_Table = getTableData(driver, inv_Reversal_Table_Header,
					invoiceReversal_Table_Rows);

			List<String> invoice_Numbers = getValuesByHeader(invoice_Details_Table, "Invoice No");

			System.out.println("INVOICE NUMBERS SHOWN IN THE GRID ARE :" + invoice_Numbers);

			Step_End(22, "in below grid invoice details has to be shown ", test, test1);

			Step_Start(23, "select the invoice no and enter the reversal reason in below grid.", test, test1);

			waitForElement(driver, invoice_Num_Txtfield);
			String invoice_Number = getAttribute(driver, invoice_Num_Txtfield, "value");

			String select_Row = String.format(import_Reversal_Confirmed_Row, invoice_Number);

			waitForElement(driver, select_Row);
			click(driver, select_Row);

			click(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);

			System.out.println("invoice number is: " + invoice_Number);
			Step_End(23, "select the invoice no and enter the reversal reason in below grid.", test, test1);

			Step_Start(24, "click the save button ", test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(24, "click the save button", test, test1);

			Step_Start(25, "click yes", test, test1);

			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}

			Step_End(25, "click yes", test, test1);

			Step_Start(26, "system has validate the invoice reversed. and Capture the Invoice NO", test, test1);

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

			Step_End(26, "system has validate the invoice reversed. and Capture the Invoice NO", test, test1);

			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
			Extent_completed(testcase_Name, test, test1);
		
		
	}

}
