package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
public class TC_Import_Documentation_SC109 extends Keywords{

	public void Import_Documentation_SC109(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		// Get data from test data
		String testcase_Name="TC_Import_Documentation_SC109";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String ID_Table_Name = Excel_data.get("ID_Table_Name");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String Invoice_Table_Name = Excel_data.get("Invoice_Table_Name");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String mode=Excel_data.get("PaymentMode");
		String receiptSavedPopup=Excel_data.get("ReceiptSavedPopup");
		String receipt_Table_Headers=Excel_data.get("Receipt_Table_Headers");
		String receipt_Table_Name=Excel_data.get("Receipt_Table_Name");
		String checkBoxStatus=Excel_data.get("CheckBoxStatus");
		String receipt_Module=Excel_data.get("Receipt_Module");
		String receiptRemark=Excel_data.get("ReceiptRemark");
		String wantToDeletePopup=Excel_data.get("WantToDeletePopup");
		String cancelledPopup=Excel_data.get("CancelledPopup");
		String module_InvoiceReversal=Excel_data.get("Module_InvoiceReversal");
		String invoiceReversalRemarks=Excel_data.get("InvoiceReversalRemarks");
		String invoiceReversedPopup=Excel_data.get("InvoiceReversedPopup");
		String referenceType=Excel_data.get("ReferenceType");
		String ID_Remarks_Table_Headers_Verify=Excel_data.get("ID_Remarks_Table_Headers_Verify");
		String ID_Remarks_Table_Headers = Excel_data.get("ID_Remarks_Table_Headers");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Terminal = Excel_data.get("Terminal");
		String Port = Excel_data.get("Port");
		String all_Dropdown_1 = Excel_data.get("All_Dropdown_1");
		String all_Dropdown_2 = Excel_data.get("All_Dropdown_2");
		String POL_Loction = Excel_data.get("POL_Loction");
		String BL_Retrieve_Option = Excel_data.get("BL_Retrieve_Option");
		String wantToDelete = Excel_data.get("WantToDelete");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String number_data=Excel_data.get("number_data");
		String BankName=Excel_data.get("BankName");
		String Search_Bank_Name_Column_Header=Excel_data.get("Search_Bank_Name_Column_Header");
		String Deposite_Bank_Name_Column_Header=Excel_data.get("Deposite_Bank_Name_Column_Header");
		String deposit_bank=Excel_data.get("deposit_bank");		
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String globalSearchFilterOption_Rev=Excel_data.get("GlobalSearchFilterOption_Reversal");
		String globalSearchFilterOption_Receipt=Excel_data.get("GlobalSearchFilterOption_Receipt");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Pol_Header = Excel_data.get("Pol_Header");
		String Delet_Receipt = Excel_data.get("Delet_Receipt");

		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		// Switch User
		SwitchProfile(driver, agencyUser);

		// Import Documentation 
		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(1, "save the import documentation for that Bl.", test, test1);

		moduleNavigate(driver, module_ImportDocumentation);

		if(BL_Retrieve_Option.equals("By Service")) {
		
			newButton(driver);
			
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);
	
			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			scrollTop(driver);
			if(!POL_Loction.trim().equals("")) {
				waitForElement(driver, POLSearch);
				safeclick(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, conditionFilter, POL_Loction);
			}
			
			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_1);
		
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_2);
			
			waitForElement(driver, show_BL_Button_IMD);
			safeclick(driver, show_BL_Button_IMD);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
	
			twoColumnSearchWindow(driver, BLNumber_Header, conditionFilter, globalSearch_Number);

		}else if(BL_Retrieve_Option.equals("By BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		}

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(actual_Master_BL_Status.equals(master_BL_Status)) {
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message);
			if(isDisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Ok_Button);
			}
		}

		Step_End(1, "save the import documentation for that Bl.", test, test1);
		Step_Start(2, "Open the import invoice or navigate the import invoice in import documentation", test, test1);

		waitForElement(driver, Import_Invoice_Button);
		click(driver, Import_Invoice_Button);

		//Import Invoice		
		waitForElement(driver, Import_Invoice_Tab);

		Step_End(2, "Open the import invoice or navigate the import invoice in import documentation", test, test1);
		Step_Start(3, "in import invoice is saved in Issued Status", test, test1);
		
		waitForElement(driver, issued_Button_IMP_INV);
		click(driver, issued_Button_IMP_INV);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message, importInvoiceSavedPopup);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(importInvoiceSavedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup : "+importInvoiceSavedPopup +" || Actual popup : "+actualPopup, test, test1);
			System.out.println("Matched || Expected popup : "+importInvoiceSavedPopup +" || Actual popup : "+actualPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup : "+importInvoiceSavedPopup +" || Actual popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected popup : "+importInvoiceSavedPopup +" || Actual popup : "+actualPopup, test, test1);
		}
		
		waitForElement(driver, Import_Invoice_Tab);
		Step_End(3, "in import invoice is saved in Issued Status", test, test1);

		ArrayList<String> importInvoice_invoiceNo=new ArrayList<String>();
		List<WebElement> table_InvoiceNumbers = listOfElements(driver, importInvoice_Table_InvoiceNumbers);
		for(WebElement invoice_Num:table_InvoiceNumbers) {
			String invoiceNum=invoice_Num.getText();
			importInvoice_invoiceNo.add(invoiceNum);	
		}
		String invNumber=importInvoice_invoiceNo.get(0);
		List<Map<String, String>> invoice_Tabledata = getTableData(driver, Import_Invoice_Table_Header, Import_Invoice_Table_Row);

		List<String> columnheaders_Invoice = splitAndExpand(Invoice_Table_Headers);
		String import_Invoice_Tabledata = TableDataForReport(driver, invoice_Tabledata,Invoice_Table_Name,columnheaders_Invoice);

		if(isDisplayed(driver, Import_Invoice_Table_Row)) {
			System.out.println("Expected : Import Invoice Table should display in Import Documentation Remarks Tab || Actual : Import Invoice Table is displayed  ");
			Extent_pass_New(driver, "Matched || Expected : \n"+ "<pre>" +import_Invoice_Tabledata + "</pre>" , test, test1);
		}else {
			System.out.println("Expected : Import Invoice Table should display in Import Documentation Remarks Tab || Actual : Import Invoice Table is not displayed  ");
			Extent_fail(driver, "Expected : Import Invoice Table should display in Import Documentation Remarks Tab || Actual : Import Invoice Table is not displayed  ", test, test1);
		}
		Step_Start(4, "once issued the import invoice -receipt button has enable", test, test1);

		waitForElement(driver, reciept_Button);
		if(isElementAccessible(driver, reciept_Button)) {
			System.out.println("Expected : Receipt Button Should be Enabled || Actual : Receipt Button is Enabled");
			Extent_pass_New(driver, "Expected : Receipt Button Should be Enabled || Actual : Receipt Button is Enabled", test, test1);
		}else {
			System.out.println("Expected : Receipt Button Should be Enabled || Actual : Receipt Button is not Enabled");
			Extent_fail(driver, "Expected : Receipt Button Should be Enabled || Actual : Receipt Button is not Enabled", test, test1);
		}

		Step_End(4, "once issued the import invoice -receipt button has enable", test, test1);
		Step_Start(5, "select the invoice and click the receipt button in import invoice module.", test, test1);

		click(driver, importInvoice_Table_FirstRow_number);

		waitForElement(driver, reciept_Button);
		click(driver, reciept_Button);
		Step_End(5, "select the invoice and click the receipt button in import invoice module.", test, test1);

		Step_Start(6, "system has navigate to the receipt module and fetched details for that customer ,bl and invoice based", test, test1);

		//		Receipt
		Extent_cal(test, test1, receipt_Module);

		waitForElement(driver, customerName_Textfield_IMP);
		String cutomerName=getAttribute(driver, customerName_Textfield_IMP, "value");
		if(!cutomerName.equals("")) {
			System.out.println("Expected : Customer details Should be fetched || Actual : Customer details are fetched");
			Extent_pass_New(driver, "Expected : Customer details Should be fetched || Actual : Customer details are fetched", test, test1);
		}else {
			System.out.println("Expected : Customer details Should be fetched || Actual : Customer details are not fetched");
			Extent_fail(driver, "Expected : Customer details Should be fetched || Actual : Customer details are not fetched", test, test1);
		}
		Step_End(6, "system has navigate to the receipt module and fetched details for that customer ,bl and invoice based", test, test1);
		Step_Start(7, "go to   the Payment Details Tab", test, test1);
		waitForElement(driver, paymentDetails_Tab_IMP);
		click(driver, paymentDetails_Tab_IMP);

		Step_End(7, "go to   the Payment Details Tab", test, test1);
		Step_Start(8, "add the Mode as Cash ", test, test1);

		click(driver, paymentMode_Dropdown_IMP_DOC);
		String select_Mode=String.format(paymentMode_Dropdown_IMP_DOC, mode);
		click(driver, select_Mode);
		Step_End(8, "add the Mode as Cash ", test, test1);

		if(IsElementEnabled(driver, number_Txtfield)) {
			waitForElement(driver, number_Txtfield);
			Newclear(driver, number_Txtfield);
			sendKeys(driver, number_Txtfield, number_data);
		}
		
		Step_Start(9, "Select the Deposit Bank,", test, test1);
		if(IsElementEnabled(driver, bank_Search_Icon)) {
			waitForElement(driver, bank_Search_Icon);
			click(driver, bank_Search_Icon);
			twoColumnSearchWindow(driver, Search_Bank_Name_Column_Header, conditionFilter, BankName);
		}
		Step_End(9, "Select the Deposit Bank,", test, test1);

		if(IsElementEnabled(driver, deposit_Bank_Search_Icon)) {
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);
			twoColumnSearchWindow(driver, Deposite_Bank_Name_Column_Header, conditionFilter, deposit_bank);
		}
		
		Step_Start(10, "Click on add Button", test, test1);

		waitForElement(driver, paymentMode_Add_Button_IMP);
		click(driver, paymentMode_Add_Button_IMP);

		Step_End(10, "Click on add Button", test, test1);
		Step_Start(11, "Move to Invoices and Receipt tab", test, test1);

		waitForElement(driver, InvoiceAndReceipt_Tab_IMP_Doc);
		click(driver, InvoiceAndReceipt_Tab_IMP_Doc);

		waitForDisplay(driver, invoice_And_Receipt_Tab_Rows);
		List<WebElement> rows = listOfElements(driver, invoice_And_Receipt_Tab_Rows);
		
		int totalRows=rows.size();
		
		Step_End(11, "Move to Invoices and Receipt tab", test, test1);
		Step_Start(12, "Click on allocate Button", test, test1);

		if(totalRows>1) {
			String select_Checkbox=String.format(receipt_Row_Select_Checkbox, globalSearch_Number);
			List<WebElement> checkboxSelect=listOfElements(driver, select_Checkbox);
			for(WebElement Ele:checkboxSelect) {
				waitForElement(driver, select_Checkbox);
				Ele.click();
			}
			
			waitForElement(driver, receipt_Row_Remove_Button);
			click(driver, receipt_Row_Remove_Button);
			
			waitForDisplay(driver, popup_Message);
			while(isdisplayed(driver, popup_Message_Yes_Button)) {
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			}
			checkboxSelect=listOfElements(driver, select_Checkbox);
			for(WebElement Ele:checkboxSelect) {
				waitForElement(driver, select_Checkbox);
				Ele.click();
			}
		}
		
		waitForDisplay(driver, allocate_Button_IMP_DOC);
		click(driver, allocate_Button_IMP_DOC);

		Step_End(12, "Click on allocate Button", test, test1);

		Step_Start(13, "Click on save Button", test, test1);
		scrollTop(driver);
		waitForElement(driver,SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		
		Step_End(13, "Click on save Button", test, test1);
		Step_Start(14, "Received Msg like Receipt saved in that Click on ok", test, test1);

		waitForPopup(driver, popup_Message, receiptSavedPopup);
		String actualSavedPopup=getText(driver, popup_Message);

		if(actualSavedPopup.equals(receiptSavedPopup)||actualSavedPopup.contains("Receipt Successfully saved")) {
			Extent_pass_New(driver, "Matched || Expected Popup : "+receiptSavedPopup+" || Actual popup : "+actualSavedPopup, test, test1);
			System.out.println("Matched || Expected Popup : "+receiptSavedPopup+" || Actual popup : "+actualSavedPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup : "+receiptSavedPopup+" || Actual popup : "+actualSavedPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+receiptSavedPopup+" || Actual popup : "+actualSavedPopup, test, test1);
		}
		Step_End(14, "Received Msg like Receipt saved in that Click on ok", test, test1);

		Step_Start(15, "Capture the Receipt Number and Receipt Date", test, test1);

		waitForElement(driver, InvoiceAndReceipt_Tab_IMP_Doc);
		click(driver, InvoiceAndReceipt_Tab_IMP_Doc);
		waitForElement(driver, reciept_Table_Column);

		List<String> columnheaders_Receipt = splitAndExpand(receipt_Table_Headers);

		List<Map<String, String>> receipt_Tabledata = getTableData(driver, reciept_Table_Column, reciept_Table_Row);
		String firstColumn_Header2="Invoice No";
		String firstColumn_Value2=invNumber;
		String recptNumber = getValueByFirstColumnAndHeader(receipt_Tabledata, firstColumn_Header2, firstColumn_Value2, columnheaders_Receipt.get(0));
		String recptDate = getValueByFirstColumnAndHeader(receipt_Tabledata, firstColumn_Header2, firstColumn_Value2, columnheaders_Receipt.get(1));

		String receipt_Table_data = TableDataForReport(driver, receipt_Tabledata,receipt_Table_Name,columnheaders_Receipt);

		if(isDisplayed(driver, reciept_Table_Row)) {
			System.out.println("Expected : Receipt Table should be display || Actual : Receipt Table is displayed");
			Extent_pass_New(driver, "Expected : Receipt Table should be display || Actual : Receipt Table is displayed", test, test1);
			Extent_pass_New(driver, "Matched || Expected : \n"+ "<pre>" +receipt_Table_data + "</pre>" , test, test1);
		}else {
			System.out.println("Expected : Receipt Table should be display || Actual : Receipt Table is not displayed");
			Extent_fail(driver, "Expected : Receipt Table should be display || Actual : Receipt Table is not displayed", test, test1);
		}


		Step_End(15, "Capture the Receipt Number and Receipt Date", test, test1);
		Step_Start(16, "Open the bl in import documentation", test, test1);
		waitForElement(driver, importDocumentation_Tab_IMP);
		click(driver, importDocumentation_Tab_IMP);
		waitForElement(driver, importDocClose);
		click(driver, importDocClose);
		//		Import Documentation	
		Extent_cal(test, test1, module_ImportDocumentation);
		moduleNavigate(driver, module_ImportDocumentation);

		Step_End(16, "Open the bl in import documentation", test, test1);
		Step_Start(17, "Load the same BL no", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");

		Step_End(17, "Load the same BL no", test, test1);

		Step_Start(18, "go to the remarks tab \r\n"
				+ "-------------Verify------- receipt check box is marked.and receipt number and date has shown", test, test1);
		//		Remarks Tab		

		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		scrollBottom(driver);
		waitForElement(driver, importDoc_RemarksTab);

		String actualStatus=getAttribute(driver, reciept_CheckBox, "class");
		if(actualStatus.contains(checkBoxStatus)) {
			System.out.println("Expected : Receipt Checkbox should be selected || Actual : Receipt Checkbox is selected");
			Extent_pass_New(driver, "Expected : Receipt Checkbox should be selected || Actual : Receipt Checkbox is selected", test, test1);

		}else {
			System.out.println("Expected : Receipt Checkbox should be selected || Actual : Receipt Checkbox is not selected");
			Extent_fail(driver, "Expected : Receipt Checkbox should be selected || Actual : Receipt Checkbox is not selected", test, test1);
		}
		List<Map<String, String>> importDoc_RemarksTabledata = getTableData(driver, remarksTab_Table_Header_IMP_DOC, remarksTab_Table_Row_IMP_DOC);
		List<String> columnheaders = splitAndExpand(ID_Remarks_Table_Headers_Verify);
		List<String> columnheaders2 = splitAndExpand(ID_Remarks_Table_Headers);

		String remarksTab_Tabledata = TableDataForReport(driver, importDoc_RemarksTabledata,ID_Table_Name,columnheaders2);
		String firstColumn_Header ="Reference Type";
		String firstColumn_Value = referenceType;

		String remarksTab_Ref_Value = getValueByFirstColumnAndHeader(importDoc_RemarksTabledata, firstColumn_Header, firstColumn_Value, columnheaders.get(0));
		String remarksTab_Ref_Date = getValueByFirstColumnAndHeader(importDoc_RemarksTabledata, firstColumn_Header, firstColumn_Value, columnheaders.get(1));

		if(isDisplayed(driver, remarksTab_Table_Row_IMP_DOC)) {
			System.out.println("Expected : Import Invoice Table should be displayed in Import Documentation Remarks Tab || Actual : Import Invoice Table is displayed in Import Documentation Remarks Tab");
			Extent_pass_New(driver, "Expected : Import Invoice Table should be displayed in Import Documentation Remarks Tab || Actual : Import Invoice Table is displayed in Import Documentation Remarks Tab", test, test1);
			Extent_pass_New(driver, "Matched || Expected : \n"+ "<pre>" +remarksTab_Tabledata + "</pre>" , test, test1);
		}else {
			System.out.println("Expected : Import Invoice Table should be displayed in Import Documentation Remarks Tab || Actual : Import Invoice Table is not displayed in Import Documentation Remarks Tab");
			Extent_fail(driver, "Expected : Import Invoice Table should be displayed in Import Documentation Remarks Tab || Actual : Import Invoice Table is not displayed in Import Documentation Remarks Tab", test, test1);
		}

		if(remarksTab_Ref_Value.equals(recptNumber) && recptDate.equals(remarksTab_Ref_Date))	{
			Extent_pass_New(driver, "Receipt No in Import documentation Remarks tab is matched || Expected : "+recptNumber+" || Actual : "+remarksTab_Ref_Value , test, test1);
			Extent_pass_New(driver,"Matched || Import Documentation Remarks table: \n"+ "<pre>" +remarksTab_Tabledata + "</pre>" +"|| Receipt table : \n"+ "<pre>" +receipt_Table_data+ "</pre>"  , test, test1);
		}else {
			System.out.println("Receipt No in Import documentation Remarks tab is not matched || Expected : "+recptNumber+" || Actual : "+remarksTab_Ref_Value);
			Extent_fail(driver, "Receipt No in Import documentation Remarks tab is not matched || Expected : "+recptNumber+" || Actual : "+remarksTab_Ref_Value, test, test1);
		}	

		Step_End(18, "go to the remarks tab \r\n"
				+ "-------------Verify------- receipt check box is marked.and receipt number and date has shown", test, test1);

		//Receipt	
		Step_Start(19, "Open receipt module and click on search button then enter the receipt number and load it", test, test1);
		Extent_cal(test, test1, receipt_Module);

		scrollTop(driver);
		waitForElement(driver, reciept_Module);
		jsClick(driver, reciept_Module);
		waitForElement(driver, recieptNo_Textfield);
		String receiptNumber=getAttribute(driver, recieptNo_Textfield, "value");

		scrollTop(driver);
		waitForElement(driver, recieptNo_Textfield);
		click(driver, reciept_Module_Close);
		
		if(Delet_Receipt.equalsIgnoreCase("Yes")) {
			
			moduleNavigate(driver, receipt_Module);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_Receipt, receiptNumber, "", "", "", "");

			Step_End(19, "Open receipt module and click on search button then enter the receipt number and load it", test, test1);
			Step_Start(20, "enter the remarks in remark section", test, test1);

			waitForElement(driver, reciept_remarks_TextArea);
			sendKeys(driver, reciept_remarks_TextArea, receiptRemark);

			Step_End(20, "enter the remarks in remark section", test, test1);
			Step_Start(21, "CLick on delete button, system shows the mgs as \"  Are you sure you want to delete ?\" in that Click on Yes,", test, test1);
			Step_Start(22, "received msg  like \" Receipt cancelled\", and close the module", test, test1);

			scrollTop(driver);
			deleteImportDocument(driver, wantToDeletePopup, cancelledPopup);
			
			Step_End(21, "CLick on delete button, system shows the mgs as \"  Are you sure you want to delete ?\" in that Click on Yes,", test, test1);
			Step_End(22, "received msg  like \" Receipt cancelled\", and close the module", test, test1);

			//Invoice Reversal
			Extent_cal(test, test1, module_InvoiceReversal);
			Step_Start(23, "Open Invoice reversal Module", test, test1);
			
			moduleNavigate(driver, module_InvoiceReversal);

			Step_End(23, "Open Invoice reversal Module", test, test1);
			Step_Start(24, "click on new button", test, test1);
			
			newButton(driver);
			Step_End(24, "click on new button", test, test1);
			Step_Start(25, "Click the Invoice No search button and enter the BLNO finally load the BL No", test, test1);
			
			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);

			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_Rev, globalSearch_Number, "", "", "", "");

			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);
			
			Step_End(25, "Click the Invoice No search button and enter the BLNO finally load the BL No", test, test1);
			Step_Start(26, "Verify the Invoice number should be there in the Grid and select the Rows Invoice number which we provided", test, test1);
		
			waitForElement(driver, invoiceReversal_Table_Rows);
			ArrayList<String> invoiceNo_Grid=new ArrayList<String>();
			List<WebElement> table_InvoiceNo = listOfElements(driver, invoiceReversal_Table_Rows);
			for(WebElement invoice_No:table_InvoiceNo) {
				String invoiceNo=invoice_No.getDomAttribute("data-rk");
				invoiceNo_Grid.add(invoiceNo);	
			}

			System.out.println("invoiceNo_Grid:"+invoiceNo_Grid);
			if(invoiceNo_Grid.equals(importInvoice_invoiceNo)) {
				Extent_pass_New(driver, "Matched || Expected  : "+importInvoice_invoiceNo + " Actual  : "+invoiceNo_Grid, test, test1);
				System.out.println("Matched || Expected  : "+importInvoice_invoiceNo + " Actual  : "+invoiceNo_Grid);
			}else {
				System.out.println("Not Matched || Expected  : "+importInvoice_invoiceNo + " Actual  : "+invoiceNo_Grid);
				Extent_fail(driver, "Not Matched || Expected  : "+importInvoice_invoiceNo + " Actual  : "+invoiceNo_Grid, test, test1);
			}

			Step_End(26, "Verify the Invoice number should be there in the Grid and select the Rows Invoice number which we provided", test, test1);
			Step_Start(27, "Enter the Invoice reversal reason and click on save Button", test, test1);

			waitForElement(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Table_Rows);
			waitForDisplay(driver, invoiceReversal_Remarks_TextArea);
			click(driver, invoiceReversal_Remarks_TextArea);
			waitForDisplay(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);

			waitForDisplay(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
		
			Step_End(27, "Enter the Invoice reversal reason and click on save Button", test, test1);
			Step_Start(28, "System shows the Msg in that click on Yes button", test, test1) ;
			
			waitForPopup(driver, popup_Message, "Invoice Reversal 'Yes' ");
			if(isDisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			Step_End(28, "System shows the Msg in that click on Yes button", test, test1);

			Step_Start(29, "system shows Msg as \"Invoice reversed\"", test, test1);

			waitForPopup(driver, popup_Message, invoiceReversedPopup);
			String actualReversedPopup=getText(driver, popup_Message);

			if(actualReversedPopup.equals(invoiceReversedPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup, test, test1);
				System.out.println("Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup, test, test1);
			}

			Step_End(29, "system shows Msg as \"Invoice reversed\"", test, test1);
			Extent_cal(test, test1, module_ImportDocumentation);

			waitForElement(driver, importDocumentation_Tab_IMP);
			click(driver, importDocumentation_Tab_IMP);
			waitForDisplay(driver, importDocClose);
			click(driver, importDocClose);
			
			//		Import Documentation	
			if(wantToDelete.equalsIgnoreCase("Yes")){
				moduleNavigate(driver, module_ImportDocumentation);
				click(driver, SearchButton_Toolbar);
				waitForElement(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
				deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);			
			}
			
		}
		
		Extent_completed(testcase_Name, test, test1);
	}

}
