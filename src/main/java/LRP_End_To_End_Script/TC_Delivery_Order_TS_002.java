package LRP_End_To_End_Script;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_002 extends Keywords{
	public void Delivery_Order_TS_002(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_002";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("Export_Agency_Code");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String module_ImoportDocumetation = Excel_data.get("Module_ImoportDocumetation");
		String master_BL_Status = Excel_data.get("Master_BL_Status");
		String checkbox_Status = Excel_data.get("Checkbox_Status");
		String module_ImoportInvoice = Excel_data.get("Module_ImoportInvoice");
		String importInvoiceSavedPopup = Excel_data.get("ImportInvoiceSavedPopup");
		String greenColorCode = Excel_data.get("GreenColorCode");
		String module_Receipt = Excel_data.get("Module_Receipt");
		String payment_Mode = Excel_data.get("Payment_Mode");
		String save_Popup_Expected = Excel_data.get("Save_Popup_Expected");
		String wantToDelete_Popup = Excel_data.get("WantToDelete_Popup");
		String DO_Deleted_Popup = Excel_data.get("DO_Deleted_Popup");
		String receiptRemark = Excel_data.get("ReceiptRemark");
		String module_InvoiceReversal = Excel_data.get("Module_InvoiceReversal");
		String invoiceReversalRemarks = Excel_data.get("InvoiceReversalRemarks");
		String issuedInvoiceColor = Excel_data.get("IssuedInvoiceColor");
		String globalSearchFilterOption_IMD = Excel_data.get("GlobalSearchFilterOption_IMD");
		String globalSearchFilterOption_Invoice = Excel_data.get("GlobalSearchFilterOption_Invoice");
		String globalSearchFilterOption_Receipt = Excel_data.get("GlobalSearchFilterOption_Receipt");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearchFilterOption_ChequeRealization = Excel_data.get("GlobalSearchFilterOption_ChequeRealization");
		String globalSearchFilterOption_InvoiceReversal = Excel_data.get("GlobalSearchFilterOption_InvoiceReversal");
		String globalSearchFilterOption_Receipt2 = Excel_data.get("GlobalSearchFilterOption_Receipt2");
		String globalSearch_Number = Excel_data.get("New_BL_Number");
		String dropdownCondition = Excel_data.get("dropdown_Condition");
		String module_ChequeRealization = Excel_data.get("Module_ChequeRealization");
		String receipt_Status_Filer_Data = Excel_data.get("Receipt_Status_Filer_Data");
		String number_data = Excel_data.get("Number_data");
		String bankname = Excel_data.get("Bankname");
		String deposit_bank = Excel_data.get("Deposit_bank");
		String receiptSavedPopup = Excel_data.get("ReceiptSavedPopup");
		String doStatus = Excel_data.get("DO_Status");
		String invoiceReversedPopup = Excel_data.get("InvoiceReversedPopup");
		String wantToReverse_Popup = Excel_data.get("WantToReverse_Popup");
		String receiptCancelled_Popup = Excel_data.get("ReceiptCancelled_Popup");
		String redColorCode = Excel_data.get("RedColorCode");
		String reversedPopup = Excel_data.get("ReversedPopup");
		String wantToRest_Popup_ChequeRealization = Excel_data.get("WantToRest_Popup_ChequeRealization");
		String wantToDeleteReceipt_Popup = Excel_data.get("WantToDeleteReceipt_Popup");
		String De_Stuff_Dock_Check_Box_Option = Excel_data.get("De_Stuff_Dock_Check_Box_Option");
		String De_Stuff_Dock_Factory_Box_Option = Excel_data.get("De_Stuff_Dock_Factory_Box_Option");
		String Search_Bank_Name_Column_Header = Excel_data.get("Search_Bank_Name_Column_Header");
		String Deposite_Bank_Name_Column_Header = Excel_data.get("Deposite_Bank_Name_Column_Header");
		String delete_Option = Excel_data.get("delete_Option");
		String Condition = Excel_data.get("Condition");

//		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
//		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
//		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "Open Import documentation Module", test, test1);
		//	Import Documentation
		moduleNavigate(driver, module_ImoportDocumetation);
		Extent_cal(test, test1, module_ImoportDocumetation);
		Step_End(2, "Open Import documentation Module", test, test1);
		Step_Start(3, "Click the search icon in Tool bar.", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click the search icon in Tool bar.", test, test1);
		Step_Start(4, "Paste the BL number and Click search ", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		Step_End(4, "Paste the BL number and Click search ", test, test1);
		Step_Start(5, "Make sure Import documentation saved.", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(actual_Master_BL_Status.equalsIgnoreCase(master_BL_Status)) {
			newButton(driver);
		}else {
			System.out.println("Matched || Import documentation saved");
			Extent_pass_New(driver, "Matched || Import documentation saved", test, test1);
		}
		Step_End(5, "Make sure Import documentation saved.", test, test1);

		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		scrollBottom(driver);

		//checking the import invoice checkbox
		String imp_Inv_Status=getAttribute(driver, import_Invoice_Checkbox_IMD, "class");
		if(imp_Inv_Status.contains(checkbox_Status)) {
			Extent_pass_New(driver, "import invoice Checkbox is selected", test, test1);
			System.out.println("import invoice Checkbox is selected");

		}else {

			Step_Start(6, "Open import invoice screen", test, test1);

			System.out.println("import invoice Checkbox is unselected");
			scrollTop(driver);
			//saving import invoice
			moduleNavigate(driver, module_ImoportInvoice);
			Extent_cal(test, test1, module_ImoportInvoice);
			Step_End(6, "Open import invoice screen", test, test1);
			Step_Start(7, "Click new button", test, test1);
			scrollTop(driver);
			newButton(driver);
			Step_End(7, "Click new button", test, test1);
			Step_Start(8, "Click the BL number search icon", test, test1);

			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			Step_End(8, "Click the BL number search icon", test, test1);
			Step_Start(9, "Paste the BL number ", test, test1);
			Step_Start(10, "Click search and fetch the record (Make sure invoice grid details will be shown)", test, test1);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Invoice, globalSearch_Number, "", "", "", "");
			Step_End(10, "Click search and fetch the record (Make sure invoice grid details will be shown)", test, test1);
			Step_End(9, "Paste the BL number ", test, test1);
			Step_Start(11, "Select the issued button and  Click save", test, test1);

			waitForElement(driver, issued_Button);
			click(driver, issued_Button);
			waitForElement(driver, De_Stuff_Dock_Check_Box);
			checkBox(driver, De_Stuff_Dock_Check_Box, De_Stuff_Dock_Check_Box_Option);
			checkBox(driver, De_Stuff_Dock_Factory_Box, De_Stuff_Dock_Factory_Box_Option);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

			Step_End(11, "Select the issued button and  Click save", test, test1);
			Step_Start(12, "Make sure System validated as \"\"Import invoice saved \"(Invoice grid will be shown as green colour)", test, test1);

			waitForPopup(driver, popup_Message,importInvoiceSavedPopup);
			String actualSavedDraft=getText(driver,  popup_Message);
			if(actualSavedDraft.equals(importInvoiceSavedPopup)) {
				System.out.println("Matched || Expected Pop-up value is : "+importInvoiceSavedPopup+ " || Actual Pop-up value is : "+actualSavedDraft);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+importInvoiceSavedPopup+ " || Actual Pop-up value is : "+actualSavedDraft, test, test1);
				click(driver,  popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up value is : "+importInvoiceSavedPopup+ " || Actual Pop-up value is : "+actualSavedDraft);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+importInvoiceSavedPopup+ " || Actual Pop-up value is : "+actualSavedDraft, test, test1);
			}

			waitForElement(driver, importInvoice_Table_Row);
			String actualInvoiceRowColorCode=getTextBackgroundColor(driver, importInvoice_Table_Row);
			String actualInvoiceRowColor = getColorName(actualInvoiceRowColorCode);
			if(actualInvoiceRowColor.equalsIgnoreCase(greenColorCode)) {
				System.out.println("Matched || Expected Result is : Invoice grid Should changed to green colour || Expected Colour : "+greenColorCode+ " || Actual Result is : Invoice grid changed to green colour || Actual Colour : "+actualInvoiceRowColor);
				Extent_pass_New(driver, "Matched || Expected Result is : Invoice grid Should changed to green colour || Expected Colour : "+greenColorCode+ " || Actual Result is : Invoice grid changed to green colour || Actual Colour : "+actualInvoiceRowColor, test, test1);
			}else {
				System.out.println("Not Matched || Expected Result is : Invoice grid Should changed to green colour || Expected Colour : "+greenColorCode+ " || Actual Result is : Invoice grid Not changed to green colour || Actual Colour : "+actualInvoiceRowColor);
				Extent_fail(driver, "Not Matched || Expected Result is : Invoice grid Should changed to green colour || Expected Colour : "+greenColorCode+ " || Actual Result is : Invoice grid Not changed to green colour || Actual Colour : "+actualInvoiceRowColor, test, test1);
			}

			Step_End(12, "Make sure System validated as \"\"Import invoice saved \"(Invoice grid will be shown as green colour)", test, test1);
			scrollTop(driver);
			waitForElement(driver, importDocumentation_Tab);
			click(driver, importDocumentation_Tab);
		}

		//checking the receipt checkbox
		waitForElement(driver, reciept_CheckBox);
		String actualStatus=getAttribute(driver, reciept_CheckBox, "class");
		if(actualStatus.contains(checkbox_Status)) {
			Extent_pass_New(driver, "Receipt Checkbox is selected", test, test1);
			System.out.println("Receipt Checkbox is selected");
		}else {
			System.out.println("Receipt Checkbox is unselected");
			Step_Start(13, "Open the receipt screen", test, test1);
			scrollTop(driver);
			moduleNavigate(driver, module_Receipt);
			//			Receipt
			Extent_cal(test, test1, module_Receipt);

			Step_End(13, "Open the receipt screen", test, test1);
			Step_Start(14, "Click new button ", test, test1);
			scrollTop(driver);
			newButton(driver);
			Step_End(14, "Click new button ", test, test1);
			Step_Start(15, "Click the Customer name search option", test, test1);
			waitForElement(driver, receipt_Customer_Name_SearchBtn);
			click(driver, receipt_Customer_Name_SearchBtn);
			Step_End(15, "Click the Customer name search option", test, test1);
			Step_Start(16, "Click the Drop down and select the BL number option", test, test1);
			Step_Start(17, "Paste the BL  number  ", test, test1);
			Step_Start(18, "Click search and fetch the BL", test, test1);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Receipt, globalSearch_Number, "", "", "", "");
			Step_End(16, "Click the Drop down and select the BL number option", test, test1);
			Step_End(17, "Paste the BL  number  ", test, test1);
			Step_End(18, "Click search and fetch the BL", test, test1);
			Step_Start(19, "Select the Payment mode as \"\"Wire transfer \"\" in payment details tab", test, test1);
			waitForElement(driver, paymentMode_Dropdown);
			click(driver, paymentMode_Dropdown);
			formatLocatorClick(driver, DropDown_Select, payment_Mode);

			Step_End(19, "Select the Payment mode as \"\"Wire transfer \"\" in payment details tab", test, test1);
			Step_Start(20, "Enter the ref.number,Select the bank name and deposit bank details", test, test1);

			waitForElement(driver, number_Txtfield);
			sendKeys(driver, number_Txtfield, number_data);

			waitForElement(driver, bank_Search_Icon);
			click(driver, bank_Search_Icon);
			twoColumnSearchWindow(driver, Search_Bank_Name_Column_Header, Condition, bankname);

			//deposit bank
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);
			twoColumnSearchWindow(driver, Deposite_Bank_Name_Column_Header, Condition, deposit_bank);

			Step_End(20, "Enter the ref.number,Select the bank name and deposit bank details", test, test1);
			Step_Start(21, "Click add button", test, test1);

			waitForElement(driver, add_Payment_Details);
			click(driver, add_Payment_Details);

			Step_End(21, "Click add button", test, test1);
			Step_Start(22, "Go to Invoices and receipts tab", test, test1);

			waitForElement(driver, InvoiceAndReceipt_Tab);
			click(driver, InvoiceAndReceipt_Tab);

			Step_End(22, "Go to Invoices and receipts tab", test, test1);
			Step_Start(23, "Select the invoice details and click allocate button", test, test1);

			waitForElement(driver, invoicesAndReceipts_SelectAll_Checkbox);
			checkBox(driver, invoicesAndReceipts_SelectAll_Checkbox, "Yes");

			waitForElement(driver, allocate_Button);
			click(driver, allocate_Button);

			Step_End(23, "Select the invoice details and click allocate button", test, test1);
			Step_Start(24, "Click the save button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

			Step_End(24, "Click the save button", test, test1);
			Step_Start(25, "Ensure receipt saved and  receipt number generated", test, test1);

			waitForPopup(driver, popup_Message,receiptSavedPopup);
			String actualSavedPopup=getText(driver, reciept_Popup);
			if(actualSavedPopup.equals(receiptSavedPopup)) {
				System.out.println("Matched || Expected Popup : "+receiptSavedPopup+" || Actual Popup : "+actualSavedPopup);
				Extent_pass_New(driver, "Matched || Expected Popup : "+receiptSavedPopup+" || Actual Popup : "+actualSavedPopup, test, test1);
				click(driver, reciept_Popup_Ok);
			}else{
				System.out.println("Not Matched || Expected Popup : "+receiptSavedPopup+" || Actual Popup : "+actualSavedPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+receiptSavedPopup+" || Actual Popup : "+actualSavedPopup, test, test1);
			}

			waitForElement(driver, recieptNo_Textfield);
			String actual_Receipt=getAttribute(driver, recieptNo_Textfield, "value");
			if(!actual_Receipt.equals("")) {
				System.out.println("Matched || Receipt number generated || Generated Receipt Number : "+actual_Receipt);
				Extent_pass_New(driver, "Matched || Receipt number generated || Generated Receipt Number : "+actual_Receipt, test, test1);
			}else {
				System.out.println("Not Matched || Receipt number not generated || Generated Receipt Number : "+actual_Receipt);
				Extent_fail(driver, "Not Matched || Receipt number not generated || Generated Receipt Number : "+actual_Receipt, test, test1);
			}
			waitForElement(driver, reciept_Module);
			click(driver, reciept_Module);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			Step_End(25, "Ensure receipt saved and  receipt number generated", test, test1);
		}


		Step_Start(26, "Open delivery order module", test, test1);

		//	Delivery Order
		Extent_cal(test, test1, module_Delivery_Order);
		moduleNavigate(driver, module_Delivery_Order);
		scrollTop(driver);
		Step_End(26, "Open delivery order module", test, test1);
		Step_Start(27, "Click new and click add button", test, test1);
		scrollTop(driver);
		newButton(driver);

		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);

		Step_End(27, "Click new and click add button", test, test1);
		Step_Start(28, "Paste the Bl number and fetch the BL", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);

		Step_End(28, "Paste the Bl number and fetch the BL", test, test1);
		Step_Start(29, "Select the containers", test, test1);

		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);

		Step_End(29, "Select the containers", test, test1);

		Step_Start(30, "Click the Save button  on Tool bar", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(30, "Click the Save button  on Tool bar", test, test1);

		Step_Start(31, "Ensure \"\" Delivery order saved \"\" validation done after Do saved", test, test1);

		waitForPopup(driver,Popup_Message,save_Popup_Expected);
		String save_Popup_Actual = getText(driver, Popup_Message);

		if(save_Popup_Actual.equals(save_Popup_Expected)) {
			System.out.println("MATCHED || EXPECTED POPUP AFTER SAVE : "+save_Popup_Expected+" ACTUAL POPUP AFTER SAVE : "+ save_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED POPUP AFTER SAVE : "+save_Popup_Expected+" ACTUAL POPUP AFTER SAVE : "+ save_Popup_Actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED POPUP AFTER SAVE : "+save_Popup_Expected+" ACTUAL POPUP AFTER SAVE : "+ save_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED POPUP AFTER SAVE : "+save_Popup_Expected+" ACTUAL POPUP AFTER SAVE : "+ save_Popup_Actual, test, test1);
		}

		waitForElement(driver, DO_Status);
		String actual_Do_Status=getText(driver, DO_Status);
		if(actual_Do_Status.contains(doStatus)) {
			Extent_pass_New(driver, "Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status, test, test1);
			System.out.println("Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status);
		}else {
			System.out.println("Not Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status);
			Extent_fail(driver, "Not Matched || Expected Status : "+doStatus +" || Actual Status : "+actual_Do_Status, test, test1);
		}

		Step_End(31, "Ensure \"\" Delivery order saved \"\" validation done after Do saved", test, test1);
//		if(delete_Option.equalsIgnoreCase("Yes")) {
//			Extent_call(test, test1, "No need verify below but script must be there.");	
//			Step_Start(1, "Click the Delete button", test, test1);
//
//			waitForElement(driver, Delete_button_toolBar);
//			click(driver, Delete_button_toolBar);
//
//			Step_End(1, "Click the Delete button", test, test1);
//			Step_Start(2, "system validated as \"\"Are you sure want to delete the Delivery Order? \"\"", test, test1);
//
//			waitForPopup(driver, popup_Message,wantToDelete_Popup);
//			String actualWantToDelete_Popup = getText(driver, popup_Message);
//			if (actualWantToDelete_Popup.equals(wantToDelete_Popup)) {
//				System.out.println("Matched || Expected Delivery Order Popup : " + wantToDelete_Popup + " || Actual Delivery Order Popup : " + actualWantToDelete_Popup);
//				Extent_pass_New(driver,"Matched || Expected Delivery Order Popup : " + wantToDelete_Popup + " || Actual Delivery Order Popup : " + actualWantToDelete_Popup, test,test1);
//
//				Step_Start(3, "Click Yes", test, test1);
//
//				click(driver,popup_Message_Yes_Button);
//
//				Step_End(3, "Click Yes", test, test1);
//
//			} else {
//				System.out.println("Not Matched || Expected Delivery Order Popup : " + wantToDelete_Popup + " || Actual Delivery Order Popup : " + actualWantToDelete_Popup);
//				Extent_fail(driver,"Not Matched || Expected Delivery Order Popup : " + wantToDelete_Popup + " || Actual Delivery Order Popup : " + actualWantToDelete_Popup,test, test1);
//			}
//
//			Step_End(2, "system validated as \"\"Are you sure want to delete the Delivery Order? \"\"", test, test1);
//			Step_Start(4, "Ensure system validated as Delivery order deleted \"", test, test1);
//
//			waitForPopup(driver,Popup_Message,DO_Deleted_Popup);
//			String actual_Deleted_Popup = getText(driver, Popup_Message);
//			if (actual_Deleted_Popup.equals(DO_Deleted_Popup)) {
//				System.out.println("Matched || Expected Delivery Order Popup : " + DO_Deleted_Popup + " || Actual Delivery Order Popup : " + actual_Deleted_Popup);
//				Extent_pass_New(driver,"Matched || Expected Delivery Order Popup : " + DO_Deleted_Popup + " || Actual Delivery Order Popup : " + actual_Deleted_Popup, test,test1);
//			} else {
//				System.out.println("Not Matched || Expected Delivery Order Popup : " + DO_Deleted_Popup + " || Actual Delivery Order Popup : " + actual_Deleted_Popup);
//				Extent_fail(driver,"Not Matched || Expected Delivery Order Popup : " + DO_Deleted_Popup + " || Actual Delivery Order Popup : " + actual_Deleted_Popup,test, test1);
//			}
//
//			Step_End(4, "Ensure system validated as Delivery order deleted \"", test, test1);
//
//			//	Receipt
//
//			Extent_cal(test, test1, module_Receipt);
//			moduleNavigate(driver, module_Receipt);
//			scrollTop(driver);
//			waitForElement(driver, SearchButton_Toolbar);
//			click(driver, SearchButton_Toolbar);
//			globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_Receipt, globalSearch_Number, "", "", "", "");
//			globalValueSearchWindowScrollAndSelect(driver,receipt_Status_Filter,receipt_Status_Filer_Data);
//			waitForElement(driver, recieptNo_Textfield);
//			String actual_Receipt_No=getAttribute(driver, recieptNo_Textfield, "value");
//
//			//	Cheque Realization
//
//			Extent_cal(test, test1, module_ChequeRealization);
//			Step_Start(5, "Open Cheque realization screen", test, test1);
//			moduleNavigate(driver, module_ChequeRealization);
//
//			Step_End(5, "Open Cheque realization screen", test, test1);
//			Step_Start(6, "Click search icon", test, test1);
//
//			waitForElement(driver, SearchButton_Toolbar);
//			click(driver, SearchButton_Toolbar);
//
//			Step_End(6, "Click search icon", test, test1);
//			Step_Start(7, "Paste the receipt no and fetch the record", test, test1);
//			globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_ChequeRealization, actual_Receipt_No, "", "", "", "");
//
//			Step_End(7, "Paste the receipt no and fetch the record", test, test1);
//			Step_Start(8, "select the record and click delete button", test, test1);
//
//			waitForDisplay(driver, retrivedGlobalValue);
//			if(isdisplayed(driver, retrivedGlobalValue)) {
//				waitForElement(driver, retrivedGlobalValue);
//				click(driver, retrivedGlobalValue);
//				waitForElement(driver, SelectButton);
//				click(driver, SelectButton);
//
//				waitForElement(driver, CR_CheckBox);
//				click(driver, CR_CheckBox);
//
//				waitForElement(driver, Delete_button_toolBar);
//				click(driver, Delete_button_toolBar);
//
//				Step_End(8, "select the record and click delete button", test, test1);
//				Step_Start(9, "system validated as \"\"Do you want to Reset \"\"", test, test1);
//
//				waitForPopup(driver, popup_Message,wantToRest_Popup_ChequeRealization);
//				String actualConfirmation_Popup=getText(driver, popup_Message);
//				if(actualConfirmation_Popup.contains(wantToRest_Popup_ChequeRealization)) {
//					Extent_pass_New(driver, "Matched || Expected Popup : "+wantToRest_Popup_ChequeRealization + " || Actual Popup : "+actualConfirmation_Popup, test, test1);
//					System.out.println("Matched || Expected Popup : "+wantToRest_Popup_ChequeRealization + " || Actual Popup : "+actualConfirmation_Popup);
//					click(driver, popup_Message_Yes_Button);
//				}else {
//					System.out.println("Not Matched || Expected Popup : "+wantToRest_Popup_ChequeRealization + " || Actual Popup : "+actualConfirmation_Popup);
//					Extent_fail(driver, "Not Matched || Expected Popup : "+wantToRest_Popup_ChequeRealization + " || Actual Popup : "+actualConfirmation_Popup, test, test1);
//				}
//
//				Step_Start(10, "Click yes (Make sure reversed)", test, test1);
//
//				waitForPopup(driver, popup_Message,reversedPopup);
//				String actualCquRlzPopup=getText(driver, popup_Message);
//
//				if(actualCquRlzPopup.equals(reversedPopup)) {
//					Extent_pass_New(driver, "Matched || Expected Popup : "+reversedPopup + " || Actual Popup : "+actualCquRlzPopup, test, test1);
//					System.out.println("Matched || Expected Popup : "+reversedPopup + " || Actual Popup : "+actualCquRlzPopup);
//					click(driver, popup_Message_Ok_Button);
//				}else {
//					System.out.println("Not Matched || Expected Popup : "+reversedPopup + " || Actual Popup : "+actualCquRlzPopup);
//					Extent_fail(driver, "Not Matched || Expected Popup : "+reversedPopup + " || Actual Popup : "+actualCquRlzPopup, test, test1);
//				}
//			}else {
//				click(driver, globalSearchCloseIcon_L);
//			}
//
//			Step_End(9, "system validated as \"\"Do you want to Reset \"\"", test, test1);
//			Step_End(10, "Click yes (Make sure reversed)", test, test1);
//
//			//	Receipt
//
//			Extent_cal(test, test1, module_Receipt);
//
//			waitForElement(driver, reciept_Module);
//			click(driver, reciept_Module);
//			waitForElement(driver, Module_Close);
//			click(driver, Module_Close);
//
//			Step_Start(11, "Open receipt screen", test, test1);
//
//			moduleNavigate(driver, module_Receipt);
//
//			Step_End(11, "Open receipt screen", test, test1);
//			Step_Start(12, "Click the search in tool bar", test, test1);
//			waitForElement(driver, SearchButton_Toolbar);
//			click(driver, SearchButton_Toolbar);
//
//			Step_End(12, "Click the search in tool bar", test, test1);
//			Step_Start(13, "Paste the BL/customer code/invoice number and search", test, test1);
//			globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_Receipt2, actual_Receipt_No, "", "", "", "");
//			globalValueSearchWindowScrollAndSelect(driver,receipt_Status_Filter,receipt_Status_Filer_Data);
//
//
//			Step_End(13, "Paste the BL/customer code/invoice number and search", test, test1);
//			Step_Start(14, "After fetching the record enter remarks", test, test1);
//
//			waitForElement(driver, reciept_remarks_TextArea);
//			sendKeys(driver, reciept_remarks_TextArea, receiptRemark);
//
//			Step_End(14, "After fetching the record enter remarks", test, test1);
//			Step_Start(15, "Click delete button", test, test1);
//
//			click(driver, Delete_button_toolBar);
//
//			Step_End(15, "Click delete button", test, test1);
//			Step_Start(16, "System validated \"\"  Are you sure you want to delete ? \"\"", test, test1);
//
//			waitForPopup(driver, popup_Message,wantToDeleteReceipt_Popup);
//			String actualConfirmationPopup=getText(driver, popup_Message);
//
//			if(actualConfirmationPopup.equals(wantToDeleteReceipt_Popup)) {
//				Extent_pass_New(driver, "Matched || Expected Popup : "+wantToDeleteReceipt_Popup + " || Actual Popup : "+actualConfirmationPopup, test, test1);
//				System.out.println("Matched || Expected Popup : "+wantToDeleteReceipt_Popup + " || Actual Popup : "+actualConfirmationPopup);
//
//			}else {
//				System.out.println("Not Matched || Expected Popup : "+wantToDeleteReceipt_Popup + " || Actual Popup : "+actualConfirmationPopup);
//				Extent_fail(driver, "Not Matched || Expected Popup : "+wantToDeleteReceipt_Popup + " || Actual Popup : "+actualConfirmationPopup, test, test1);
//			}
//
//			Step_End(16, "System validated \"\"  Are you sure you want to delete ? \"\"", test, test1);
//			Step_Start(17, "Click yes", test, test1);
//
//			click(driver, popup_Message_Yes_Button);
//
//			Step_End(17, "Click yes", test, test1);
//			Step_Start(18, "Make sure receipt deleted (All receipts belongs to that bl should be deleted)", test, test1);
//
//			waitForPopup(driver, popup_Message,receiptCancelled_Popup);
//			String actualDeletedPopup=getText(driver, popup_Message);
//			if(actualDeletedPopup.equals(receiptCancelled_Popup)) {
//				Extent_pass_New(driver, "Matched || Expected Popup : "+receiptCancelled_Popup + " || Actual Popup : "+actualDeletedPopup, test, test1);
//				System.out.println("Matched || Expected Popup : "+receiptCancelled_Popup + " || Actual Popup : "+actualDeletedPopup);
//				click(driver, popup_Message_Ok_Button);
//			}else {
//				System.out.println("Not Matched || Expected Popup : "+receiptCancelled_Popup + " || Actual Popup : "+actualDeletedPopup);
//				Extent_fail(driver, "Not Matched || Expected Popup : "+receiptCancelled_Popup + " || Actual Popup : "+actualDeletedPopup, test, test1);
//			}
//
//			waitForElement(driver, recieptNo_Textfield);
//			String actualDeletedColorCode=getTextBackgroundColor(driver, recieptNo_Textfield);
//			String actualDeletedColor = getColorName(actualDeletedColorCode);
//			if(actualDeletedColor.equalsIgnoreCase(redColorCode)) {
//				Extent_pass_New(driver, "Matched || Expected Result is : Receipt Number Textfield color Should changed to Red || Expected Color : "+redColorCode + " || Actual Result is : Receipt Number Textfield color changed to Red || Actual Color : "+actualDeletedColor, test, test1);
//				System.out.println("Matched || Expected Result is : Receipt Number Textfield color Should changed to Red || Expected Color : "+redColorCode + " || Actual Result is : Receipt Number Textfield color changed to Red || Actual Color : "+actualDeletedColor);
//			}else {
//				System.out.println("Not Matched || Expected Result is : Receipt Number Textfield color Should changed to Red || Expected Color : "+redColorCode + " || Actual Result is : Receipt Number Textfield color Not changed to Red || Actual Color : "+actualDeletedColor);
//				Extent_fail(driver, "Not Matched || Expected Result is : Receipt Number Textfield color Should changed to Red || Expected Color : "+redColorCode + " || Actual Result is : Receipt Number Textfield color Not changed to Red || Actual Color : "+actualDeletedColor, test, test1);
//			}
//
//			Step_End(18, "Make sure receipt deleted (All receipts belongs to that bl should be deleted)", test, test1);
//			Step_Start(19, "open invoice reversal screen", test, test1);
//
//			//Invoice Reversal
//			Extent_cal(test, test1, module_InvoiceReversal);
//			moduleNavigate(driver, module_InvoiceReversal);
//
//			newButton(driver);
//			Step_End(19, "open invoice reversal screen", test, test1);
//			Step_Start(20, "Click the invoice no search button", test, test1);
//
//			waitForElement(driver, invoiceNo_SearchButton);
//			click(driver, invoiceNo_SearchButton);
//
//			Step_End(20, "Click the invoice no search button", test, test1);
//			Step_Start(21, "Paste the invoice number and fetch the record", test, test1);
//			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_InvoiceReversal, globalSearch_Number, "", "", "", "");
//
//			Step_End(21, "Paste the invoice number and fetch the record", test, test1);
//			Step_Start(22, "Click show and enter the remarks", test, test1);
//
//			waitForElement(driver, invoiceReversal_Show_Button);
//			click(driver, invoiceReversal_Show_Button);
//
//			waitForElement(driver, invoiceReversal_Remarks_TextArea);
//			click(driver, invoiceReversal_Remarks_TextArea);
//			sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);
//
//			Step_End(22, "Click show and enter the remarks", test, test1);
//			Step_Start(23, "Select row from grid and click save", test, test1);
//
//			formatLocatorClick(driver, issuedInvoice_Row, issuedInvoiceColor);
//			waitForElement(driver, SaveButton_ToolBar);
//			click(driver, SaveButton_ToolBar);
//
//			Step_End(23, "Select row from grid and click save", test, test1);
//			Step_Start(24, "system validated as \"\"Do you want to reverse the selected Invoice?\"\"", test, test1);
//
//			waitForPopup(driver, popup_Message,wantToReverse_Popup);
//			String actualConfirmationPopup1=getText(driver, popup_Message);
//			if(actualConfirmationPopup1.contains(wantToReverse_Popup)) {
//				Extent_pass_New(driver, "Matched || Expected Popup : "+wantToReverse_Popup + " || Actual Popup : "+actualConfirmationPopup1, test, test1);
//				System.out.println("Matched || Expected Popup : "+wantToReverse_Popup + " || Actual Popup : "+actualConfirmationPopup1);
//			}else {
//				System.out.println("Not Matched || Expected Popup : "+wantToReverse_Popup + " || Actual Popup : "+actualConfirmationPopup1);
//				Extent_fail(driver, "Not Matched || Expected Popup : "+wantToReverse_Popup + " || Actual Popup : "+actualConfirmationPopup1, test, test1);
//			}
//			Step_End(24, "system validated as \"\"Do you want to reverse the selected Invoice?\"\"", test, test1);
//			Step_Start(25, "Click yes", test, test1);
//			click(driver, popup_Message_Yes_Button);
//			Step_End(25, "Click yes", test, test1);
//			Step_Start(26, "Make sure invoice reversed", test, test1);
//			waitForPopup(driver, popup_Message,invoiceReversedPopup);
//			String actualReversedPopup=getText(driver, popup_Message);
//			if(actualReversedPopup.equals(invoiceReversedPopup)) {
//				Extent_pass_New(driver, "Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup, test, test1);
//				System.out.println("Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup);
//				click(driver, popup_Message_Ok_Button);
//			}else {
//				System.out.println("Not Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup);
//				Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceReversedPopup + " Actual Popup : "+actualReversedPopup, test, test1);
//			}
//			Step_End(26, "Make sure invoice reversed", test, test1);
//		}
		Extent_completed(testcase_Name, test, test1);
	}

}
