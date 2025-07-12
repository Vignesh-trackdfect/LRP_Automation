package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_037 extends Keywords{
	public void Delivery_Order_TS_037(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_037";
		
		



		String Username = Excel_data.get("Username");                                                                        
		String Password = Excel_data.get("Password");                                                                         
		String AgencyUser = Excel_data.get("AgencyUser");                                                                       
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");                                         
		String GlobalID = Excel_data.get("GlobalID");                                                                           
		String GlobalValue = Excel_data.get("GlobalValue");                                                                     
		String bl_Number=Excel_data.get("BL_Number");                                                                           
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");                                      
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");                                                
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");                                           
		String Popup_Msg = Excel_data.get("Popup_Msg");                                                                        
		String checkbox_Status = Excel_data.get("Checkbox_Status");                                                            
		String module_ImoportInvoice = Excel_data.get("Module_ImoportInvoice");                                                
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");                                            
		String greenColorCode = Excel_data.get("GreenColorCode");                                                              
		String module_Receipt = Excel_data.get("Module_Receipt");                                                              
		String payment_Mode = Excel_data.get("Payment_Mode");                                                                  
		String receiptRemark = Excel_data.get("ReceiptRemark");                                                                
		String module_InvoiceReversal = Excel_data.get("Module_InvoiceReversal");                                              
		String invoiceReversalRemarks = Excel_data.get("InvoiceReversalRemarks");                                              
		String issuedInvoiceColor = Excel_data.get("IssuedInvoiceColor");                                                      
		String module_ChequeRealization = Excel_data.get("Module_ChequeRealization");                                          
		String receipt_Status_Filer_Data = Excel_data.get("Receipt_Status_Filer_Data");                                        
		String number_data = Excel_data.get("Number_data");                                                                    
		String bankname = Excel_data.get("Bankname");                                                                          
		String deposit_bank = Excel_data.get("Deposit_bank");                                                                  
		String receiptSavedPopup = Excel_data.get("ReceiptSavedPopup");                                                        
		String Configuration_Reset = Excel_data.get("Configuration_Reset");                                                    
		String globalSearchFilterOption_IMD = Excel_data.get("globalSearchFilterOption_IMD");                                  
		String globalSearchFilterOption_Invoice = Excel_data.get("globalSearchFilterOption_Invoice");                          
		String globalSearchFilterOption_Reciept = Excel_data.get("globalSearchFilterOption_Reciept");                          
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");                                    
		String globalSearchFilterOption_Cheque_realization = Excel_data.get("globalSearchFilterOption_Cheque_realization");    
		String globalSearchFilterOption_Reciept2 = Excel_data.get("globalSearchFilterOption_Reciept2");                        
		String globalSearchFilterOption_Invoice_Reversal = Excel_data.get("globalSearchFilterOption_Invoice_Reversal");        
		String De_Stuff_Dock_Check_Box_Option = Excel_data.get("De_Stuff_Dock_Check_Box_Option");
		String De_Stuff_Dock_Factory_Box_Option = Excel_data.get("De_Stuff_Dock_Factory_Box_Option");
		String Search_Bank_Name_Column_Header = Excel_data.get("Search_Bank_Name_Column_Header");
		String Deposite_Bank_Name_Column_Header = Excel_data.get("Deposite_Bank_Name_Column_Header");
		String Reset_Option = Excel_data.get("Reset_Option");
		String Condition = Excel_data.get("Condition");
		
		Extent_Start(testcase_Name, test, test1);                                                                        
		navigateUrl(driver, url);                                                                                                  
		LRP_Login(driver, Username, Password);
		Step_Start(1,"Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);
		setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
		moduleNavigate(driver, module_ImportDocumentation);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, bl_Number, "", "", "", "");
		waitForElement(driver, master_BL_Number);
		String Partlot_Bl_Number=getText(driver, master_BL_Number);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, Partlot_Bl_Number, "", "", "", "");
		waitForElement(driver, importDoc_RemarksTab);
		click(driver,importDoc_RemarksTab);
		scrollBottom(driver);
		waitForElement(driver, import_Invoice_Checkbox_IMD);
		String imp_Inv_Status=getAttribute(driver, import_Invoice_Checkbox_IMD, "class");
		if (imp_Inv_Status.contains(checkbox_Status)) {
			System.out.println("Expected Result is : Import Invoice checkbox Should be active || Actual Result is : Import Invoice checkbox was  active");
			Extent_pass_New(driver, "Expected Result is : Import Invoice checkbox Should be active || Actual Result is : Import Invoice checkbox was  active", test, test1);
		}
		String actualStatus=getAttribute(driver, reciept_CheckBox_IMD, "class");
		if (actualStatus.contains(checkbox_Status)) {
			System.out.println("Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was active");
			Extent_pass_New(driver, "Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was active", test, test1);
			}
			scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_Start(5, "Open import documentation and fetch the Part lot bl", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, bl_Number, "", "", "", "");
		Step_End(5, "Open import documentation and fetch the Part lot bl", test, test1);
		Step_Start(6, "Do the import invoice and receipt for part lot bl", test, test1);
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		scrollBottom(driver);
		//checking the import invoice checkbox
		imp_Inv_Status=getAttribute(driver, import_Invoice_Checkbox_IMD, "class");
		if(imp_Inv_Status.contains(checkbox_Status)) {
			Extent_pass_New(driver, "import invoice Checkbox is selected", test, test1);
			System.out.println("import invoice Checkbox is selected");
		}else {
			System.out.println("import invoice Checkbox is unselected");
			//saving import invoice
			moduleNavigate(driver, module_ImoportInvoice);
			Extent_cal(test, test1, module_ImoportInvoice);
			scrollTop(driver);
			newButton(driver);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Invoice, bl_Number, "", "", "", "");
			waitForElement(driver, De_Stuff_Dock_Check_Box);
			checkBox(driver, De_Stuff_Dock_Check_Box, De_Stuff_Dock_Check_Box_Option);
			checkBox(driver, De_Stuff_Dock_Factory_Box, De_Stuff_Dock_Factory_Box_Option);
			waitForElement(driver, issued_Button);
			click(driver, issued_Button);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message,importInvoiceSavedPopup);
			String actualSavedDraft=getText(driver, popup_Message);
			if(actualSavedDraft.equals(importInvoiceSavedPopup)) {
				System.out.println("Matched || Expected Popup : "+importInvoiceSavedPopup+ " || Actual Popup : "+actualSavedDraft);
				Extent_pass_New(driver, "Matched || Expected Popup : "+importInvoiceSavedPopup+ " || Actual Popup : "+actualSavedDraft, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup : "+importInvoiceSavedPopup+ " || Actual Popup : "+actualSavedDraft);
				Extent_fail(driver, "Not Matched || Expected Popup : "+importInvoiceSavedPopup+ " || Actual Popup : "+actualSavedDraft, test, test1);
			}
			waitForElement(driver, importInvoice_Table_Row);
			String actualInvoiceRowColorCode=getTextBackgroundColor(driver, importInvoice_Table_Row);
			String actualInvoiceRowColor = getColorName(actualInvoiceRowColorCode);
			if(actualInvoiceRowColor.equalsIgnoreCase(greenColorCode)) {
				System.out.println("Matched || Invoice grid changed to green colour || Expected Colour code : "+greenColorCode+ " || Actual Colour code : "+actualInvoiceRowColor);
				Extent_pass_New(driver, "Matched || Invoice grid changed to green colour || Expected Colour code : "+greenColorCode+ " || Actual Colour code : "+actualInvoiceRowColor, test, test1);
			}else {
				System.out.println("Not Matched || Invoice grid not changed to green colour || Expected Colour code : "+greenColorCode+ " || Actual Colour code : "+actualInvoiceRowColor);
				Extent_fail(driver, "Not Matched || Invoice grid not changed to green colour || Expected Colour code : "+greenColorCode+ " || Actual Colour code : "+actualInvoiceRowColor, test, test1);
			}
			waitForElement(driver, importDocumentation_Tab);
			click(driver, importDocumentation_Tab);
		}
		//checking the receipt checkbox
		waitForElement(driver, reciept_CheckBox_IMD);
		actualStatus=getAttribute(driver, reciept_CheckBox_IMD, "class");
		if(actualStatus.contains(checkbox_Status)) {
			Extent_pass_New(driver, "Receipt Checkbox is selected", test, test1);
			System.out.println("Receipt Checkbox is selected");
		}else {
			System.out.println("Receipt Checkbox is unselected");
			moduleNavigate(driver, module_Receipt);
			//			Receipt
			Extent_cal(test, test1, module_Receipt);
			scrollTop(driver);
			newButton(driver);
			waitForElement(driver, receipt_Customer_Name_SearchBtn);
			click(driver, receipt_Customer_Name_SearchBtn);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Reciept, bl_Number, "", "", "", "");
			waitForElement(driver, paymentMode_Dropdown);
			click(driver, paymentMode_Dropdown);
			formatLocatorClick(driver, paymentMode, payment_Mode);
			waitForElement(driver, number_Txtfield);
			sendKeys(driver, number_Txtfield, number_data);
			waitForElement(driver, bank_Search_Icon);
			click(driver, bank_Search_Icon);
			twoColumnSearchWindow(driver, Search_Bank_Name_Column_Header, Condition, bankname);
			//deposit bank
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);
			twoColumnSearchWindow(driver, Deposite_Bank_Name_Column_Header, Condition, deposit_bank);
			waitForElement(driver, add_Payment_Details);
			click(driver, add_Payment_Details);
			waitForElement(driver, InvoiceAndReceipt_Tab);
			click(driver, InvoiceAndReceipt_Tab);
			waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
			checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");
			waitForElement(driver, allocate_Button);
			click(driver, allocate_Button);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message,receiptSavedPopup);
			String actualSavedPopup=getText(driver, popup_Message);
			if(actualSavedPopup.trim().equals(receiptSavedPopup.trim())) {
				System.out.println("Matched || Expected Pop-up value is : "+receiptSavedPopup+" || Actual Pop-up value is : "+actualSavedPopup);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+receiptSavedPopup+" || Actual Pop-up value is : "+actualSavedPopup, test, test1);
				click(driver,popup_Message_Ok_Button);
			}
			waitForElement(driver, recieptNo_Textfield);
			String actual_Receipt=getAttribute(driver, recieptNo_Textfield, "value");
			if(!actual_Receipt.equals("")) {
				System.out.println("Matched || Receipt number generated || Generated Receipt Number : "+actual_Receipt);
				Extent_pass_New(driver, "Matched || Receipt number generated || Generated Receipt Number : "+actual_Receipt, test, test1);
			}
			waitForElement(driver, reciept_Module);
			click(driver, reciept_Module);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
		}
		Step_End(6, "Do the import invoice and receipt for part lot bl", test, test1);
		Step_Start(7, "Open Delivery order module", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(7, "Open Delivery order module", test, test1);
		Step_Start(8, "Click new button ", test, test1);
		scrollTop(driver);
		newButton(driver);
		Step_End(8, "Click new button ", test, test1);
		Step_Start(9, "Click the \" ADD \" Button", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(9,"Click the \" ADD \" Button", test, test1);
		Step_Start(10,"Paste the BL ,click search and fetch the record", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, bl_Number, "", "", "", "");
		Step_End(10, "Paste the BL ,click search and fetch the record", test, test1);
		Step_Start(11,"Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(11, "Click the SHOW button", test, test1);
		Step_Start(12, "System validated as \"Kindly create Delivery Order for Master BL\"", test, test1);
		waitForPopup(driver,Popup_Message,Popup_Msg);
		String actual_Popup = getText(driver, Popup_Message);
		if (Popup_Msg.equals(actual_Popup)) {
			System.out.println("Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup,test, test1);
		}
		Step_End(12, "System validated as \"Kindly create Delivery Order for Master BL\"", test, test1);
		Extent_cal(test, test1, module_Receipt);
		moduleNavigate(driver, module_Receipt);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_Reciept, bl_Number, "", "", "", "");
		waitForElement(driver, DO_horizontal_Scroll);
		horizontalscroll(driver, DO_horizontal_Scroll, 2500);
		waitForElement(driver, receipt_Status_Filter);
		sendKeys(driver, receipt_Status_Filter, receipt_Status_Filer_Data);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		elementnotvisible1(driver, SelectButton);
		waitForElement(driver, recieptNo_Textfield);
		String actual_Receipt_No=getAttribute(driver, recieptNo_Textfield, "value");
		//	Cheque Realization
		Extent_cal(test, test1, module_ChequeRealization);
		moduleNavigate(driver, module_ChequeRealization);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_Cheque_realization, actual_Receipt_No, "", "", "", "");
		waitForDisplay(driver, retrivedGlobalValue);
		if(isDisplayed(driver, retrivedGlobalValue)) {
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			waitForElement(driver, CR_CheckBox);
			click(driver, CR_CheckBox);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}else {
			click(driver, globalSearchCloseIcon_L);
		}
		//	Receipt
		Extent_cal(test, test1, module_Receipt);
		waitForElement(driver, reciept_Module);
		click(driver, reciept_Module);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		moduleNavigate(driver, module_Receipt);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_Reciept2, actual_Receipt_No, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver, receipt_Status_Filter, receipt_Status_Filer_Data);

		waitForElement(driver, reciept_remarks_TextArea);
		sendKeys(driver, reciept_remarks_TextArea, receiptRemark);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver,popup_Message_Yes_Button);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		//Invoice Reversal
		Extent_cal(test, test1, module_InvoiceReversal);
		moduleNavigate(driver, module_InvoiceReversal);
		newButton(driver);
		waitForElement(driver, invoiceNo_SearchButton);
		click(driver, invoiceNo_SearchButton);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Invoice_Reversal, bl_Number, "", "", "", "");
		waitForElement(driver, invoiceReversal_Show_Button);
		click(driver, invoiceReversal_Show_Button);
		formatLocatorClick(driver, issuedInvoice_Row, issuedInvoiceColor);
		click(driver, invoiceReversal_Remarks_TextArea);
		sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		reSetGlobalConfiguration(driver,Reset_Option,GlobalConfigurationModule, GlobalID, Configuration_Reset);
		Extent_completed(testcase_Name, test, test1);
	}
}
