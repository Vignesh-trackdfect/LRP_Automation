package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Outstanding_Freight_Report_SC046B extends Keywords {

	public void Outstanding_Freight_ReportSC46B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Outstanding_Freight_Report_SC046B";
		

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
		String module_BillOfLading = Excel_data.get("Module_BillOfLading");
		String Select_Search_Type_BOL = Excel_data.get("Select_Search_Type_BOL");
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

		scrollTop(driver);

		waitForElement(driver, In_Issued_Button);
		click(driver, In_Issued_Button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Expected_Popup);
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
		String exp_AP_Code = getFirstValueByHeader(StatusReport_TableData, "AP Code");
		String exp_AP_Name = getFirstValueByHeader(StatusReport_TableData, "AP Name");
		String exp_BP_Code = getFirstValueByHeader(StatusReport_TableData, "BP Code");
		String exp_BP_Name = getFirstValueByHeader(StatusReport_TableData, "BP Name");
		String exp_Port_of_Origin = getFirstValueByHeader(StatusReport_TableData, "Port of Origin");
		String exp_Port_of_Load = getFirstValueByHeader(StatusReport_TableData, "Port of Load");
		String exp_Port_of_Discharge = getFirstValueByHeader(StatusReport_TableData, "Port of Discharge");
		String exp_Destination = getFirstValueByHeader(StatusReport_TableData, "Destination");
		moduleNavigate(driver, module_BillOfLading);

		Step_End(7, "Open Bill of Lading module", test, test1);
		Step_Start(8, "Load the same BL Number", test, test1);

		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_BOL, BL_Number_input, "", "", "", "");

		List<String> AP_Customer_Code = null;
		List<String> BP_Customer_Code = null;
		List<String> AP_Customer_Name = null;
		List<String> BP_Customer_Name = null;
		String bl_PLA_Value = null;
		String bl_POL_Value = null;
		String bl_POD_Value = null;
		String bl_PLD_Value = null;
		waitForDisplay(driver, bl_MCN_Approved_Value);
		
		
		if (!module_BillOfLading.equalsIgnoreCase("Bill of Lading")) {
			waitForElement(driver, mcn_PLA);
			bl_PLA_Value = getText(driver, mcn_PLA);
			bl_POL_Value = getText(driver, mcn_POL);
			bl_POD_Value = getText(driver, mcn_POD);
			bl_PLD_Value = getText(driver, mcn_PLD);
		} else {
			waitForElement(driver, bl_PLA);
			bl_PLA_Value = getText(driver, bl_PLA);
			bl_POL_Value = getText(driver, bl_POL);
			bl_POD_Value = getText(driver, bl_POD);
			bl_PLD_Value = getText(driver, bl_PLD);
		}
		
		
		
		if (exp_Port_of_Origin.equals(bl_PLA_Value)) {
			System.out.println("Matched || The Excpected Port of Origin is : " + exp_Port_of_Origin
					+ " || The Actual Port of Origin From the Bill of Lading OR MCN Module Table value is : "
					+ bl_PLA_Value);
			Extent_pass_New(driver,
					"Matched || The Excpected Port of Origin is : " + exp_Port_of_Origin
							+ " || The Actual Port of Origin From the Bill of Lading OR MCN Module Table value is : "
							+ bl_PLA_Value,
					test, test1);
		} else {
			System.out.println("Not Matched || The Excpected Port of Origin is : " + exp_Port_of_Origin
					+ " || The Actual Port of Origin Value From the Bill of Lading OR MCN Module Table value is : "
					+ bl_PLA_Value);
			Extent_fail(driver, "Not Matched || The Excpected Port of Origin is : " + exp_Port_of_Origin
					+ " || The Actual Port of Origin Value From the Bill of Lading OR MCN Module Table value is : "
					+ bl_PLA_Value, test, test1);
		}
		if (exp_Port_of_Load.equals(bl_POL_Value)) {
			System.out.println("Matched || The Excpected Port of Load Value is : " + exp_Port_of_Load
					+ " || The Actual Port of Load From the Bill of Lading OR MCN Module Table value is : "
					+ bl_POL_Value);
			Extent_pass_New(driver,
					"Matched || The Excpected Port of Load Value is : " + exp_Port_of_Load
							+ " || The Actual Port of Load From the Bill of Lading OR MCN Module Table value is : "
							+ bl_POL_Value,
					test, test1);
		} else {
			System.out.println("Not Matched || The Excpected Port of Load Value is : " + exp_Port_of_Load
					+ " || The Actual Port of Load From the Bill of Lading OR MCN Module Table value is : "
					+ bl_POL_Value);
			Extent_fail(driver,
					"Not Matched || The Excpected Port of Load Value is : " + exp_Port_of_Load
							+ " || The Actual Port of Load From the Bill of Lading OR MCN Module Table value is : "
							+ bl_POL_Value,
					test, test1);
		}
		if (exp_Port_of_Discharge.equals(bl_POD_Value)) {
			System.out.println("Matched || The Excpected Port of Discharge Value is : " + exp_Port_of_Discharge
					+ " || The Actual Port of Discharge From the Bill of Lading OR MCN Module Table value is : "
					+ bl_POD_Value);
			Extent_pass_New(driver,
					"Matched || The Excpected Port of Discharge Value is : " + exp_Port_of_Discharge
							+ " || The Actual Port of Discharge From the Bill of Lading OR MCN Module Table value is : "
							+ bl_POD_Value,
					test, test1);
		} else {
			System.out.println("Not Matched || The Excpected Port of Discharge Value is : " + exp_Port_of_Discharge
					+ " || The Actual Port of Discharge Value From the Bill of Lading OR MCN Module Table value is : "
					+ bl_POD_Value);
			Extent_fail(driver, "Not Matched || The Excpected Port of Discharge Value is : " + exp_Port_of_Discharge
					+ " || The Actual Port of Discharge Value From the Bill of Lading OR MCN Module Table value is : "
					+ bl_POD_Value, test, test1);
		}
		if (exp_Destination.equals(bl_PLD_Value)) {
			System.out.println("Matched || The Excpected Destination Value is : " + exp_Destination
					+ " || The Actual Destination From the Bill of Lading OR MCN Module Table value is : "
					+ bl_PLD_Value);
			Extent_pass_New(driver,
					"Matched || The Excpected Destination Value is : " + exp_Destination
							+ " || The Actual Destination From the Bill of Lading OR MCN Module Table value is : "
							+ bl_PLD_Value,
					test, test1);
		} else {
			System.out.println("Not Matched || The Excpected Destination Value is : " + exp_Destination
					+ " || The Actual Destination From the Bill of Lading OR MCN Module Table value is : "
					+ bl_PLD_Value);
			Extent_fail(driver,
					"Not Matched || The Excpected Destination Value is : " + exp_Destination
							+ " || The Actual Destination From the Bill of Lading OR MCN Module Table value is : "
							+ bl_PLD_Value,
					test, test1);
		}
		
		if (!module_BillOfLading.equalsIgnoreCase("Bill of Lading")) {
			waitForElement(driver, customer_Tab_MCN);
			click(driver, customer_Tab_MCN);
			waitForElement(driver, MCN_Customer_Table_Headers);
			List<Map<String, String>> MCN_Customer_Tabledata = getTableData(driver, MCN_Customer_Table_Headers,
					MCN_Customer_Table_Rows);
			AP_Customer_Code = getValuesByFirstColumnAndHeader(MCN_Customer_Tabledata, "Customer Type", "AP",
					"Customer Code");
			BP_Customer_Code = getValuesByFirstColumnAndHeader(MCN_Customer_Tabledata, "Customer Type", "BP",
					"Customer Code");
			AP_Customer_Name = getValuesByFirstColumnAndHeader(MCN_Customer_Tabledata, "Customer Type", "AP", "Name");
			BP_Customer_Name = getValuesByFirstColumnAndHeader(MCN_Customer_Tabledata, "Customer Type", "BP", "Name");
		} else {
			waitForElement(driver, BL_customerTab);
			click1(driver, BL_customerTab);

			Step_End(9, "Go to Customer Tab,", test, test1);
			Step_Start(10, "Compare Values Customer Code Code of AP. and uninvoiced BL Report", test, test1);

			waitForElement(driver, BL_Customer_Table_Row);

			List<Map<String, String>> BL_Customer_Tabledata = getTableData(driver, BL_Customer_Table_Header,
					BL_Customer_Table_Row);
			System.out.println(BL_Customer_Tabledata);
			AP_Customer_Code = getValuesByFirstColumnAndHeader(BL_Customer_Tabledata, "Customer Type", "AP",
					"Customer code");
			BP_Customer_Code = getValuesByFirstColumnAndHeader(BL_Customer_Tabledata, "Customer Type", "BP",
					"Customer code");
			AP_Customer_Name = getValuesByFirstColumnAndHeader(BL_Customer_Tabledata, "Customer Type", "AP", "Name");
			BP_Customer_Name = getValuesByFirstColumnAndHeader(BL_Customer_Tabledata, "Customer Type", "BP", "Name");

		}
		if (exp_AP_Code.equals(AP_Customer_Code.get(0))) {
			System.out.println("Matched || The Excpected AP Customer Code is : " + exp_AP_Code
					+ " || The Actual AP Customer Code Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Code);
			Extent_pass_New(driver, "Matched || The Excpected AP Customer Code is : " + exp_AP_Code
					+ " || The Actual AP Customer Code Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Code, test, test1);
		} else {
			System.out.println("Not Matched || The Excpected AP Customer Code is : " + exp_AP_Code
					+ " || The Actual AP Customer Code Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Code);
			Extent_fail(driver, "Not Matched || The Excpected AP Customer Code is : " + exp_AP_Code
					+ " || The Actual AP Customer Code Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Code, test, test1);
		}
		if (exp_AP_Name.equals(AP_Customer_Name.get(0))) {
			System.out.println("Matched || The Excpected AP Customer Name is : " + exp_AP_Name
					+ " || The Actual AP Customer Name Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Name);
			Extent_pass_New(driver, "Matched || The Excpected AP Customer Name is : " + exp_AP_Name
					+ " || The Actual AP Customer Name Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Name, test, test1);
		} else {
			System.out.println("Not Matched || The Excpected AP Customer Name is : " + exp_AP_Name
					+ " || The Actual AP Customer Name Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Name);
			Extent_fail(driver, "Not Matched || The Excpected AP Customer Name is : " + exp_AP_Name
					+ " || The Actual AP Customer Name Value From the Bill of Lading OR MCN Module Table value is : "
					+ AP_Customer_Name, test, test1);
		}
		if (exp_BP_Code.equals(BP_Customer_Code.get(0))) {
			System.out.println("Matched || The Excpected BP Customer Code is : " + exp_BP_Code
					+ " || The Actual BP Customer Code From the Bill of Lading OR MCN Module Table value is : "
					+ BP_Customer_Code);
			Extent_pass_New(driver,
					"Matched || The Excpected BP Customer Code is : " + exp_BP_Code
							+ " || The Actual BP Customer Code From the Bill of Lading OR MCN Module Table value is : "
							+ BP_Customer_Code,
					test, test1);
		} else {
			System.out.println("Not Matched || The Excpected BP Customer Code is : " + exp_BP_Code
					+ " || The Actual BP Customer Code From the Bill of Lading OR MCN Module Table value is : "
					+ BP_Customer_Code);
			Extent_fail(driver,
					"Not Matched || The Excpected BP Customer Code is : " + exp_BP_Code
							+ " || The Actual BP Customer Code From the Bill of Lading OR MCN Module Table value is : "
							+ BP_Customer_Code,
					test, test1);
		}
		if (exp_BP_Name.equals(BP_Customer_Name.get(0))) {
			System.out.println("Matched || The Excpected BP Customer Name is : " + exp_BP_Name
					+ " || The Actual BP Customer Name From the Bill of Lading OR MCN Module Table value is : "
					+ BP_Customer_Name);
			Extent_pass_New(driver,
					"Matched || The Excpected BP Customer Name is : " + exp_BP_Name
							+ " || The Actual BP Customer Name From the Bill of Lading OR MCN Module Table value is : "
							+ BP_Customer_Name,
					test, test1);
		} else {
			System.out.println("Not Matched || The Excpected BP Customer Name is : " + exp_BP_Name
					+ " || The Actual BP Customer Name From the Bill of Lading OR MCN Module Table value is : "
					+ BP_Customer_Name);
			Extent_fail(driver,
					"Not Matched || The Excpected BP Customer Name is : " + exp_BP_Name
							+ " || The Actual BP Customer Name From the Bill of Lading OR MCN Module Table value is : "
							+ BP_Customer_Name,
					test, test1);
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