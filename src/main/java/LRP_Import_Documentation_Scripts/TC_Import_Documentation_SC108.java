package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC108 extends Keywords{

	public void Import_Documentation_SC108(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		// Get data from test data
		String testcase_Name="TC_Import_Documentation_SC108";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String ID_Remarks_Table_Headers = Excel_data.get("ID_Remarks_Table_Headers");
		String ID_Table_Name = Excel_data.get("ID_Table_Name");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String Invoice_Table_Name = Excel_data.get("Invoice_Table_Name");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String module_InvoiceReversal=Excel_data.get("Module_InvoiceReversal");
		String invoiceReversalRemarks=Excel_data.get("InvoiceReversalRemarks");
		String invoiceReversedPopup=Excel_data.get("InvoiceReversedPopup");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_IMD=Excel_data.get("GlobalSearchFilterOption_IMD");
		String globalSearchFilterOption_Rev=Excel_data.get("GlobalSearchFilterOption_Reversal");
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
		String conditionFilter = Excel_data.get("ConditionFilter");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Pol_Header = Excel_data.get("Pol_Header");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		// Login

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		// Switch User
		SwitchProfile(driver, agencyUser);

		// Import Documentation 
		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(1, "Open the import documentation and load the bill  --save the import documentation for that Bl.", test, test1);

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
			if(isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Ok_Button);
			}
		}
		Step_End(1, "Open the import documentation and load the bill  --save the import documentation for that Bl.", test, test1);
		Step_Start(2, "Open the import invoice or navigate the import invoice in import documentation", test, test1);

		waitForElement(driver, Import_Invoice_Button);
		click(driver, Import_Invoice_Button);

		//			Import Invoice		

		waitForElement(driver, Import_Invoice_Tab);
		
		Step_End(2, "Open the import invoice or navigate the import invoice in import documentation", test, test1);
		Step_Start(3, "in import invoice is saved in Issued Status", test, test1);
		waitForElement(driver, issued_Button_IMP_INV);
		click(driver, issued_Button_IMP_INV);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

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
		Step_Start(3, "3A. Capture Invoice date and Invoice Number", test, test1);

		ArrayList<String> importInvoice_invoiceNo=new ArrayList<String>();
		List<WebElement> table_InvoiceNumbers = listOfElements(driver, importInvoice_Table_InvoiceNumbers);
		for(WebElement invoice_Num:table_InvoiceNumbers) {
			String invoiceNum=invoice_Num.getText();
			importInvoice_invoiceNo.add(invoiceNum);	
		}
		String invNumber=importInvoice_invoiceNo.get(0);

		ArrayList<String> importInvoice_invoiceDate=new ArrayList<String>();
		List<WebElement> table_InvoiceDates = listOfElements(driver, importInvoice_Table_InvoiceDate);
		for(WebElement invoice_Date:table_InvoiceDates) {
			String invoiceDate=invoice_Date.getText();
			importInvoice_invoiceDate.add(invoiceDate);	
		}
		String invDate=importInvoice_invoiceDate.get(0);

		waitForElement(driver, Import_Invoice_Table_Header);
		List<Map<String, String>> invoice_Tabledata = getTableData(driver, Import_Invoice_Table_Header, Import_Invoice_Table_Row);

		List<String> columnheaders_Invoice = splitAndExpand(Invoice_Table_Headers);
		String import_Invoice_Tabledata = TableDataForReport(driver, invoice_Tabledata,Invoice_Table_Name,columnheaders_Invoice);

		if(isDisplayed(driver, Import_Invoice_Table_Row)) {
			Extent_pass_New(driver, "Expected : Import Invoice Table should displayed || Actual : Import Invoice Table is displayed  ", test, test1);
			System.out.println("Expected : Import Invoice Table should displayed || Actual : Import Invoice Table is displayed  ");
			Extent_pass_New(driver, "Matched || Expected : \n"+ "<pre>" +import_Invoice_Tabledata + "</pre>" , test, test1);
		}else {
			System.out.println("Expected : Import Invoice Table should displayed || Actual : Import Invoice Table is not displayed  ");
			Extent_fail(driver, "Expected : Import Invoice Table should displayed || Actual : Import Invoice Table is not displayed  ", test, test1);
		}
		
		Step_End(3, "3A. Capture Invoice date and Invoice Number", test, test1);
	
		click(driver, importDocumentation_Tab_IMP);
		waitForDisplay(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		
		//		Import Documentation	
		Step_Start(4, "Retrieve the bl in import documentation", test, test1);

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
			click(driver, show_BL_Button_IMD);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, conditionFilter, globalSearch_Number);

		}else if(BL_Retrieve_Option.equals("By BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		}

		Step_End(4, "Retrieve the bl in import documentation", test, test1);
		Step_Start(5, "Go to the remarks tab ", test, test1);
		
		//		Remarks Tab		
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		scrollBottom(driver);
		waitForElement(driver, importDocumentation_Tab_IMP);
		Step_End(5, "Go to the remarks tab ", test, test1);
		Step_Start(6, "-----------Verify---------\r\n"
				+ " in Remarks tab below has shown invoice no and bl number and import invoice name .", test, test1);
		List<Map<String, String>> importDoc_RemarksTabledata = getTableData(driver, remarksTab_Table_Header_IMP_DOC, remarksTab_Table_Row_IMP_DOC);

		List<String> columnheaders = splitAndExpand(ID_Remarks_Table_Headers);
		String remarksTab_Tabledata = TableDataForReport(driver, importDoc_RemarksTabledata,ID_Table_Name,columnheaders);

		String firstColumn_Header ="Reference Type";
		String firstColumn_Value = "Import Invoice";

		String remarksTab_Ref_Value = getValueByFirstColumnAndHeader(importDoc_RemarksTabledata, firstColumn_Header, firstColumn_Value, "Reference Value");
		String remarksTab_Ref_Date = getValueByFirstColumnAndHeader(importDoc_RemarksTabledata, firstColumn_Header, firstColumn_Value, "Reference Date");

		if(isDisplayed(driver, remarksTab_Table_Row_IMP_DOC)) {
			Extent_pass_New(driver, "Expected : Import Invoice Table should display in Import Documentation Remarks Tab || Actual : Import Invoice Table is displayed in Import Documentation Remarks Tab ", test, test1);
			System.out.println("Expected : Import Invoice Table should display in Import Documentation Remarks Tab || Actual : Import Invoice Table is displayed in Import Documentation Remarks Tab "+importDoc_RemarksTabledata);
			Extent_pass_New(driver, "Matched || Expected : \n"+ "<pre>" +remarksTab_Tabledata + "</pre>" , test, test1);
		}else {
			System.out.println("Expected : Import Invoice Table should display in Import Documentation Remarks Tab || Actual : Import Invoice Table is not displayed in Import Documentation Remarks Tab ");
			Extent_fail(driver, "Expected : Import Invoice Table should display in Import Documentation Remarks Tab || Actual : Import Invoice Table is displayed  in Import Documentation Remarks Tab", test, test1);
		}

		if(remarksTab_Ref_Value.equals(invNumber) && remarksTab_Ref_Date.equals(invDate))	{
			Extent_pass_New(driver,"Matched || Expected : \n"+ "<pre>" +import_Invoice_Tabledata + "</pre>" +"|| Actual : \n"+ "<pre>" +remarksTab_Tabledata+ "</pre>"  , test, test1);
		}else {
			System.out.println("Not Matched || Invoice date and Invoice Number:"+invNumber+" "+invDate);
			Extent_fail(driver, "Not Matched || Invoice date and Invoice Number:"+invNumber+" "+invDate, test, test1);
		}


		Step_End(6, "-----------Verify---------\r\n"
				+ " in Remarks tab below has shown invoice no and bl number and import invoice name .", test, test1);

		
		//Invoice Reversal
		Extent_cal(test, test1, module_InvoiceReversal);
		Step_Start(7, "Open Invoice reversal Module", test, test1);
		
		moduleNavigate(driver, module_InvoiceReversal);

		Step_End(7, "Open Invoice reversal Module", test, test1);
		Step_Start(8, "click on new button", test, test1);
		
		newButton(driver);
		
		Step_End(8, "click on new button", test, test1);
		Step_Start(9, "Click the Invoice No search button and enter the BLNO finally load the BL No", test, test1);
		
		waitForElement(driver, invoiceNo_SearchButton);
		click(driver, invoiceNo_SearchButton);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_Rev, globalSearch_Number, "", "", "", "");
		
		waitForElement(driver, invoiceReversal_Show_Button);
		click(driver, invoiceReversal_Show_Button);
		
		Step_End(9, "Click the Invoice No search button and enter the BLNO finally load the BL No", test, test1);
		Step_Start(10, "Verify the Invoice number should be there in the Grid and select the Rows Invoice number which we provided", test, test1);
		
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

		Step_End(10, "Verify the Invoice number should be there in the Grid and select the Rows Invoice number which we provided", test, test1);
		Step_Start(11, "Enter the Invoice reversal reason and click on save Button", test, test1);
		click(driver, invoiceReversal_Table_Rows);

		click(driver, invoiceReversal_Remarks_TextArea);
		sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);

		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(11, "Enter the Invoice reversal reason and click on save Button", test, test1);
		Step_Start(12, "System shows the Msg in that click on Yes button", test, test1) ;
		waitForPopup(driver, popup_Message, "Invoice Reversal");
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_End(12, "System shows the Msg in that click on Yes button", test, test1);

		Step_Start(13, "system shows Msg as \"Invoice reversed\"", test, test1);

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

		Step_End(13, "system shows Msg as \"Invoice reversed\"", test, test1);

		Extent_cal(test, test1, module_ImportDocumentation);
		waitForElement(driver, importDocumentation_Tab_IMP);
		click(driver, importDocumentation_Tab_IMP);
		waitForDisplay(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		//		Import Documentation  Delete
		if(wantToDelete.equalsIgnoreCase("Yes")){
			moduleNavigate(driver, module_ImportDocumentation);
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
			scrollTop(driver);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Extent_completed(testcase_Name, test, test1);
	}
}
