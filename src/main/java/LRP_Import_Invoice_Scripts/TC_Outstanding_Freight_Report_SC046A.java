package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Outstanding_Freight_Report_SC046A extends Keywords {

	public void Outstanding_Freight_ReportSC46A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Outstanding_Freight_Report_SC046A";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Module_Name = Excel_data.get("Module_Name");
		String Invoice_Mode_Option = Excel_data.get("Invoice_Mode_Option");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Condition = Excel_data.get("BL_Condition");
		String customer_Code = Excel_data.get("customer_Code");
		String customer_Code_Input = Excel_data.get("customer_Code_Input");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Expected_Popup = Excel_data.get("Expected_Popup");
		String OFR_Module_Name = Excel_data.get("OFR_Module_Name");
		String OFR_Table_Headers = Excel_data.get("OFR_Table_Headers");
		String reverse_Invoice = Excel_data.get("reverse_Invoice");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		//
		String select_Option = String.format(DropDown_Select, Invoice_Mode_Option);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		moduleNavigate(driver, Module_Name);
		waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);
		waitForElement(driver, select_Option);
		click(driver, select_Option);
		newButton(driver);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL") || BL_Retrive_Option.equalsIgnoreCase("By_Book")) {

			if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
				waitForElement(driver, By_BL_NumberBtn_All);
				click(driver, By_BL_NumberBtn_All);
			} else {
				waitForElement(driver, By_Book_Button_All);
				click(driver, By_Book_Button_All);
			}
			
			waitForElement(driver, In_bl_Search_Button);
			click(driver, In_bl_Search_Button);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			waitForElement(driver, Actual_Cust_All);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);

				globalValueSearchWindow(driver, BL_Condition, customer_Code, customer_Code_Input, "", "", "", "");

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

			globalValueSearchWindow(driver, BL_Condition, customer_Code, customer_Code_Input, "", "", "", "");

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Customer")) {
			waitForElement(driver, In_customer_Search_Button);
			click(driver, In_customer_Search_Button);

			globalValueSearchWindow(driver, BL_Condition, customer_Code, customer_Code_Input, "", "", "", "");

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
		}

		waitForElement(driver, In_Issued_Button);
		click(driver, In_Issued_Button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Expected_Popup);
		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);
		if (Expected_Popup.equals(import_saved_act)) {
			System.out.println(
					"Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act);

			Extent_fail(driver,
					"Not Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act,
					test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Invoice_Table_Header_All);
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String inv_number = getFirstValueByHeader(TabledataFull, "Inv Number");
		String inv_Date = getFirstValueByHeader(TabledataFull, "Inv Date");
		String inv_Custmer_Code = getFirstValueByHeader(TabledataFull, "System Code");
		String inv_Custmer_Name = getFirstValueByHeader(TabledataFull, "Customer Name");
		String inv_Catogary = getFirstValueByHeader(TabledataFull, "Category");
		String VesselValue;
			
		String ServiceValue = "";	
		String VoyageValue = "";

		if (Module_Name.equals("Export Invoice")) {
			waitForElement(driver, Service_Field_Export);
			ServiceValue = getAttribute(driver, Service_Field_Export, "value");
		} else {
			waitForElement(driver, service_Txtfield_All);
			ServiceValue = getAttribute(driver, service_Txtfield_All, "value");
		}

		if (Module_Name.equals("Invoice")) {
			waitForElement(driver, Vessel_TxtField_Invoice);
			VesselValue = getAttribute(driver, Vessel_TxtField_Invoice, "value");
		} else {
			waitForElement(driver, vessel_Txtfield_All);
			VesselValue = getAttribute(driver, vessel_Txtfield_All, "value");
		}

		if (Module_Name.equals("Invoice")) {
			VoyageValue = getAttribute(driver, voyage_Txtfield_Invoice, "value");
		} else {
			VoyageValue = getAttribute(driver, voyage_Txtfield_All, "value");
		}

		
		String BoundValue = getText(driver, BoundInput_All);
		
		BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");
		
		moduleNavigate(driver, OFR_Module_Name);

		waitForElement(driver, OFR_Date_Select_Input);
		selectDatePicker(driver, OFR_Date_Select_Input, inv_Date);

		waitForElement(driver, OFR_Show_Button);
		click(driver, OFR_Show_Button);

		List<String> OFR_Headers = splitAndExpand(OFR_Table_Headers);

		waitForElement(driver, OFR_GridTable);

		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver, AG_Grid_Columns_Button_DW);
		waitForElement(driver, Column_Search_Input);
		click(driver, AG_Grid_Column_All_Select_Checkbox_DW);

		for (String FilterHeader : OFR_Headers) {
			waitForElement(driver, Column_Search_Input);
			clear(driver, Column_Search_Input);
			waitForElement(driver, Column_Search_Input);
			sendKeys(driver, Column_Search_Input, FilterHeader);

			String checkbox = String.format(Select_Column_tableHead, FilterHeader);
			waitForElement(driver, checkbox);
			jsClick(driver, checkbox);
		}

		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver, AG_Grid_Columns_Button_DW);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		waitForElement(driver, ofr_Invoice_No_Filter);
		sendKeys(driver, ofr_Invoice_No_Filter, inv_number);
		waitForElement(driver, OFR_GridTable);
		waitForElement(driver, OFR_Grid_Row);
		click(driver, OFR_GridTable);
		List<Map<String, String>> StatusReport_TableData = extractTableDataByColumn(driver, OFR_GridTable);

		if(OFR_Table_Headers.contains("Customer Code")) {
			String act_Customer_Code = getFirstValueByHeader(StatusReport_TableData, "Customer Code");

			if (inv_Custmer_Code.equals(act_Customer_Code)) {
				System.out.println("Matched || The Excpected Customer Code is : " + inv_Custmer_Code
						+ " || The Actual Customer Code Value From the Outstanding Freight Report is Table is : "
						+ act_Customer_Code);
				Extent_pass_New(driver,
						"Matched || The Excpected Customer Code is : " + inv_Custmer_Code
								+ " || The Actual Customer Code Value From the Outstanding Freight Report is Table is : "
								+ act_Customer_Code,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Customer Code is : " + inv_Custmer_Code
						+ " || The Actual Customer Code Value From the Outstanding Freight Report is Table is : "
						+ act_Customer_Code);
				Extent_fail(driver,
						"Not Matched || The Excpected Customer Code is : " + inv_Custmer_Code
								+ " || The Actual Customer Code Value From the Outstanding Freight Report is Table is : "
								+ act_Customer_Code,
						test, test1);
			}
		}
		
		if(OFR_Table_Headers.contains("Customer Name")) {
			String act_Customer_Name = getFirstValueByHeader(StatusReport_TableData, "Customer Name");

			if (inv_Custmer_Name.equals(act_Customer_Name)) {
				System.out.println("Matched || The Excpected Customer Name is : " + inv_Custmer_Name
						+ " || The Actual Customer Name Value From the Outstanding Freight Report is Table is : "
						+ act_Customer_Name);
				Extent_pass_New(driver,
						"Matched || The Excpected Customer Name is : " + inv_Custmer_Name
								+ " || The Actual Customer Name Value From the Outstanding Freight Report is Table is : "
								+ act_Customer_Name,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Customer Name is : " + inv_Custmer_Name
						+ " || The Actual Customer Name Value From the Outstanding Freight Report is Table is : "
						+ act_Customer_Name);
				Extent_fail(driver,
						"Not Matched || The Excpected Customer Name is : " + inv_Custmer_Name
								+ " || The Actual Customer Name Value From the Outstanding Freight Report is Table is : "
								+ act_Customer_Name,
						test, test1);
			}
		}
		
		if(OFR_Table_Headers.contains("Invoice No")) {
			String act_Invoice_No = getFirstValueByHeader(StatusReport_TableData, "Invoice No");

			if (inv_number.equals(act_Invoice_No)) {
				System.out.println("Matched || The Excpected Invoice Number is : " + inv_number
						+ " || The Actual Invoice Number Value From the Outstanding Freight Report is Table is : "
						+ act_Invoice_No);
				Extent_pass_New(driver,
						"Matched || The Excpected Invoice Number is : " + inv_number
								+ " || The Actual Invoice Number Value From the Outstanding Freight Report is Table is : "
								+ act_Invoice_No,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Invoice Number is : " + inv_number
						+ " || The Actual Invoice Number Value From the Outstanding Freight Report is Table is : "
						+ act_Invoice_No);
				Extent_fail(driver,
						"Not Matched || The Excpected Invoice Number is : " + inv_number
								+ " || The Actual Invoice Number Value From the Outstanding Freight Report is Table is : "
								+ act_Invoice_No,
						test, test1);
			}
		}
		
		if(OFR_Table_Headers.contains("Invoice Date")) {
			String act_Invoice_Date = getFirstValueByHeader(StatusReport_TableData, "Invoice Date");

			if (inv_Date.equals(act_Invoice_Date)) {
				System.out.println("Matched || The Excpected Invoice Date is : " + inv_Date
						+ " || The Actual Invoice Date Value From the Outstanding Freight Report is Table is : "
						+ act_Invoice_Date);
				Extent_pass_New(driver,
						"Matched || The Excpected Invoice Date is : " + inv_Date
								+ " || The Actual Invoice Date Value From the Outstanding Freight Report is Table is : "
								+ act_Invoice_Date,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Invoice Date is : " + inv_Date
						+ " || The Actual Invoice Date Value From the Outstanding Freight Report is Table is : "
						+ act_Invoice_Date);
				Extent_fail(driver,
						"Not Matched || The Excpected Invoice Date is : " + inv_Date
								+ " || The Actual Invoice Date Value From the Outstanding Freight Report is Table is : "
								+ act_Invoice_Date,
						test, test1);
			}
		}
		
		if(OFR_Table_Headers.contains("Invoice Category")) {
			String act_Invoice_Category = getFirstValueByHeader(StatusReport_TableData, "Invoice Category");

			if (inv_Catogary.equals(act_Invoice_Category)) {
				System.out.println("Matched || The Excpected Invoice Catagory is : " + inv_Catogary
						+ " || The Actual Invoice Catagory Value From the Outstanding Freight Report is Table is : "
						+ act_Invoice_Category);
				Extent_pass_New(driver,
						"Matched || The Excpected Invoice Catagory is : " + inv_Catogary
								+ " || The Actual Invoice Catagory Value From the Outstanding Freight Report is Table is : "
								+ act_Invoice_Category,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Invoice Catagory is : " + inv_Catogary
						+ " || The Actual Invoice Catagory Value From the Outstanding Freight Report is Table is : "
						+ act_Invoice_Category);
				Extent_fail(driver,
						"Not Matched || The Excpected Invoice Catagory is : " + inv_Catogary
								+ " || The Actual Invoice Catagory Value From the Outstanding Freight Report is Table is : "
								+ act_Invoice_Category,
						test, test1);
			}
			
		}
		
		if(OFR_Table_Headers.contains("Service")) {
			String act_Service = getFirstValueByHeader(StatusReport_TableData, "Service");

			if (ServiceValue.equals(act_Service)) {
				System.out.println("Matched || The Excpected Service Value is : " + ServiceValue
						+ " || The Actual Service Value From the Outstanding Freight Report is Table is : " + act_Service);
				Extent_pass_New(driver, "Matched || The Excpected Service Value is : " + ServiceValue
						+ " || The Actual Service Value From the Outstanding Freight Report is Table is : " + act_Service,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Service Value is : " + ServiceValue
						+ " || The Actual Service Value From the Outstanding Freight Report is Table is : " + act_Service);
				Extent_fail(driver, "Not Matched || The Excpected Service Value is : " + ServiceValue
						+ " || The Actual Service Value From the Outstanding Freight Report is Table is : " + act_Service,
						test, test1);
			}
			
		}
		
		if(OFR_Table_Headers.contains("Vessel")) {
			String act_Vessel = getFirstValueByHeader(StatusReport_TableData, "Vessel");

			if (VesselValue.equals(act_Vessel)) {
				System.out.println("Matched || The Excpected Vessel Value is : " + VesselValue
						+ " || The Actual Vessel Value From the Outstanding Freight Report is Table is : " + act_Vessel);
				Extent_pass_New(driver, "Matched || The Excpected Vessel Value is : " + VesselValue
						+ " || The Actual Vessel Value From the Outstanding Freight Report is Table is : " + act_Vessel,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Vessel Value is : " + VesselValue
						+ " || The Actual Vessel Value Value From the Outstanding Freight Report is Table is : "
						+ act_Vessel);
				Extent_fail(driver,
						"Not Matched || The Excpected Vessel Value is : " + VesselValue
								+ " || The Actual Vessel Value Value From the Outstanding Freight Report is Table is : "
								+ act_Vessel,
						test, test1);
			}
		}
		
		if(OFR_Table_Headers.contains("Voyage")) {
			String act_Voyage = getFirstValueByHeader(StatusReport_TableData, "Voyage");
			if (VoyageValue.equals(act_Voyage)) {
				System.out.println("Matched || The Excpected Voyage Value is : " + VoyageValue
						+ " || The Actual Voyage Value From the Outstanding Freight Report is Table is : " + act_Voyage);
				Extent_pass_New(driver, "Matched || The Excpected Voyage Value is : " + VoyageValue
						+ " || The Actual Voyage Value From the Outstanding Freight Report is Table is : " + act_Voyage,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Voyage Value is : " + VoyageValue
						+ " || The Actual Voyage Value From the Outstanding Freight Report is Table is : " + act_Voyage);
				Extent_fail(driver, "Not Matched || The Excpected Voyage Value is : " + VoyageValue
						+ " || The Actual Voyage Value From the Outstanding Freight Report is Table is : " + act_Voyage,
						test, test1);
			}
			
		}
		
		if(OFR_Table_Headers.contains("Voyage")) {
			String act_Bound = getFirstValueByHeader(StatusReport_TableData, "Bound");

			if (BoundValue.equals(act_Bound)) {
				System.out.println("Matched || The Excpected Bound Value is : " + BoundValue
						+ " || The Actual Bound Value From the Outstanding Freight Report is Table is : " + act_Bound);
				Extent_pass_New(driver, "Matched || The Excpected Bound Value is : " + BoundValue
						+ " || The Actual Bound Value From the Outstanding Freight Report is Table is : " + act_Bound, test,
						test1);
			} else {
				System.out.println("Not Matched || The Excpected Bound Value is : " + BoundValue
						+ " || The Actual Bound Value From the Outstanding Freight Report is Table is : " + act_Bound);
				Extent_fail(driver, "Not Matched || The Excpected Bound Value is : " + BoundValue
						+ " || The Actual Bound Value From the Outstanding Freight Report is Table is : " + act_Bound, test,
						test1);
			}
			
		}
		
		if (reverse_Invoice.equalsIgnoreCase("Yes")) {
			
			Extent_call(test, test1, "Reverse the Invoice");
			
			Invoice_Reversal(driver, InvoiceReversal_Module, BL_Condition, search_Type_Invoice_Reversal, inv_number, invoiceReversalRemarks, invoiceReversedPopup);
			
			Extent_call(test, test1, "Reverse the Invoice");

		}

		Step_End(24, "system has validate the invoice reversed", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
		
	}
}
