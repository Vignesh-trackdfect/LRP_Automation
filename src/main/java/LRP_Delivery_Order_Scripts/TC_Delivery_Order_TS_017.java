package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_017 extends Keywords{

	public void Delivery_Order_TS_017(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_017";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Import_Invoice_Module = Excel_data.get("Import_Invoice_Module");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String DO_Saved = Excel_data.get("DO_Saved");
		String Condition = Excel_data.get("Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String Issued_saved_pop = Excel_data.get("Issued_saved_pop");
		String Issued_colour = Excel_data.get("Issued_colour");
		String Mode_Select = Excel_data.get("Mode_Select");
		String Receipt_Save_Popup_Msg = Excel_data.get("Receipt_Save_Popup_Msg");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String Receipt_Module = Excel_data.get("Receipt_Module");
		String Receipt_Remarks_Popup_Msg = Excel_data.get("Receipt_Remarks_Popup_Msg");
		String Receipt_Delete_Yes_No_Popup_Msg = Excel_data.get("Receipt_Delete_Yes_No_Popup_Msg");
		String Receipt_Delete_Popup_Msg = Excel_data.get("Receipt_Delete_Popup_Msg");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String GlobalSearchFilterOption_Receipt = Excel_data.get("GlobalSearchFilterOption_Receipt");
		String GlobalSearchFilterOption_ID = Excel_data.get("GlobalSearchFilterOption_ID");
		String GlobalSearchFilterOption_IN = Excel_data.get("GlobalSearchFilterOption_IN");
		String Invoice_Reversed_Value = Excel_data.get("Invoice_Reversed_Value");
		String Currency_Details_Column_Header = Excel_data.get("Currency_Details_Column_Header");
		String GlobalSearchFilterOption_Receipt1 = Excel_data.get("GlobalSearchFilterOption_Receipt1");
		String GlobalSearchFilterOption_Invoice_reversal = Excel_data.get("GlobalSearchFilterOption_Invoice_reversal");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		Step_Start(2, "Open Import documentation Module", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(2, "Open Import documentation Module", test, test1);
		Step_Start(3, "Click the search icon in Tool bar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click the search icon in Tool bar", test, test1);
		Step_Start(4, "Paste the BL number and Click search ", test, test1);
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_ID, BL_Num, "", "", "", "");
		Step_End(4, "Paste the BL number and Click search ", test, test1);
		Step_Start(5, "Ensure BL has different Pod and Do issue location ", test, test1);	
		waitForElement(driver, POD_Value);
		String POD=getText(driver, POD_Value);
		System.out.println("POD:"+POD);
		waitForElement(driver, DO_Issue_Value);
		String DO_Issue_Location=getAttribute(driver, DO_Issue_Value, "Value");
		System.out.println("DO_Issue_Location:"+DO_Issue_Location);
		if(!POD.equals(DO_Issue_Location)) {
			System.out.println("Matched || Expected POD value was : " + POD + " || Actual DO Issue Location value was : " + DO_Issue_Location);
			Extent_pass_New(driver,"Matched || Expected POD value was : " + POD + " || Actual DO Issue Location value was : " + DO_Issue_Location, test,test1);
		} else {
			System.out.println("Not Matched || Expected POD value was : " + POD + " || Actual DO Issue Location value was : " + DO_Issue_Location);
			Extent_fail(driver,"Not Matched || Expected POD value was : " + POD + " || Actual DO Issue Location value was  : " + DO_Issue_Location,test, test1);
		}
		Step_End(5, "Ensure BL has different Pod and Do issue location ", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(6, "Open import invoice screen", test, test1);
		moduleNavigate(driver, Import_Invoice_Module);
		Step_End(6, "Open import invoice screen", test, test1);
		Step_Start(7, "Click new button", test, test1);
		newButton(driver);
		Step_End(7, "Click new button", test, test1);
		Step_Start(8, "Click the BL number search icon", test, test1);
		waitForElement(driver, import_invoice_bl_search);
		click(driver,import_invoice_bl_search);
		Step_End(8, "Click the BL number search icon", test, test1);
		Step_Start(9, "Paste the BL number", test, test1);
		Step_Start(10, "Click search and fetch the record", test, test1);
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_IN, BL_Num, "", "", "", "");
		Step_End(10, "Click search and fetch the record", test, test1);
		Step_End(9, "Paste the BL number", test, test1);
		Step_Start(11, "Select the issued button and  Click save", test, test1);
		waitForElement(driver, issued_Button);
		click(driver, issued_Button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		Step_End(11, "Select the issued button and  Click save", test, test1);
		Step_Start(12, "Make sure System validated as \"Import invoice saved \"", test, test1);
		waitForPopup(driver, popup_Message,Issued_saved_pop);
		String import_issued_act=getText(driver, popup_Message);
		System.out.println(import_issued_act);
		if(Issued_saved_pop.equals(import_issued_act)) {
			Extent_pass_New(driver, "Matched || Expected Issued Pop-up value is : "+Issued_saved_pop+" || Actual Issued Pop-up value is : "+import_issued_act, test, test1);
			System.out.println("Matched || Expected Issued Pop-up value is : "+Issued_saved_pop+" || Actual Issued Pop-up value is : "+import_issued_act);
		}else {
			System.out.println("Not Matched || Expected Issued Pop-up value is : "+Issued_saved_pop+" || Actual Issued Pop-up value is : "+import_issued_act);
			Extent_fail(driver, "Not Matched || Expected Issued Pop-up value is : "+Issued_saved_pop+" || Actual Issued Pop-up value is : "+import_issued_act, test, test1);
		}
		Step_End(12, "Make sure System validated as \"Import invoice saved \"", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		waitForElement(driver, import_invoice_first_row);
		String issuedcolouractCode=getTextBackgroundColor(driver, import_invoice_first_row);
		String issuedcolouract = getColorName(issuedcolouractCode);
		System.out.println(issuedcolouract);
		if(Issued_colour.equals(issuedcolouract)) {
			Extent_pass_New(driver, "Matched || Expected Issued colour : "+Issued_colour+" || Actual Issued colour : "+issuedcolouract, test, test1);
			System.out.println("Matched || Expected Issued colour : "+Issued_colour+" || Actual Issued colour : "+issuedcolouract);
		}else {
			System.out.println("Not Matched || Expected Issued colour : "+Issued_colour+" || Actual Issued colour : "+issuedcolouract);
			Extent_fail(driver, "Not Matched || Expected Issued colour : "+Issued_colour+" || Actual Issued colour : "+issuedcolouract, test, test1);
		}
		List<String> Receipt_Number = new ArrayList<String>();
		List<Map<String, String>> Table_Data = getTableData(driver,Import_Invoice_Grid_Header , Import_Invoice_Grid_Row);
		List<String> Currency_Values = getValuesByHeader(Table_Data, "Inv Currency");
		System.out.println("Currency_Value" +Currency_Values);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		int Currency_Size=Currency_Values.size();
		System.out.println(Currency_Size);
		for(String Currency_Value : Currency_Values) {
			Step_Start(13, "Open the receipt screen", test, test1);
			moduleNavigate(driver, Receipt_Module);
			Step_End(13, "Open the receipt screen", test, test1);
			Step_Start(14, "Click new button", test, test1);
			newButton(driver);
			Step_End(14, "Click new button", test, test1);
			boolean flag=false;
			waitForDisplay(driver, Invoice_currency_search_Button);
			if(isdisplayed(driver, Invoice_currency_search_Button)) {
			click(driver, Invoice_currency_search_Button);
			twoColumnSearchWindow(driver, Currency_Details_Column_Header, TwoColumn_Condition, Currency_Value);
			flag=true;
			}
			Step_Start(15, "Click the Customer name search option", test, test1);
			waitForElement(driver, receipt_Customer_Name_SearchBtn);
			click(driver, receipt_Customer_Name_SearchBtn);
			Step_End(15, "Click the Customer name search option", test, test1);
			Step_Start(16, "Click the Drop down and select the BL number option", test, test1);
			Step_Start(17, "Paste the BL  number ", test, test1);
			Step_Start(18, "Click search and fetch the BL", test, test1);
			globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_Receipt, BL_Num, "", "", "", "");
			Step_End(18, "Click search and fetch the BL", test, test1);
			Step_End(17, "Paste the BL  number ", test, test1);
			Step_End(16, "Click the Drop down and select the BL number option", test, test1);
			Step_Start(19, "Select the Payment mode as CASH  in payment details tab", test, test1);
			scrollBottom(driver);
			waitForElement(driver, receipt_Payment_Details_Tab);
			click(driver, receipt_Payment_Details_Tab);
			waitForElement(driver, receipt_Mode_dropdown);
			click(driver, receipt_Mode_dropdown);
			formatLocatorClick(driver, DropDown_Select, Mode_Select);
			Step_End(19, "Select the Payment mode as CASH  in payment details tab", test, test1);
			Step_Start(20, "Click add button", test, test1);
			waitForElement(driver, receipt_Add_Button);
			click(driver, receipt_Add_Button);
			Step_End(20, "Click add button", test, test1);
			Step_Start(21, "Make sure amount details added to the grid", test, test1);
			if(formatLocatorIsDisplayed(driver, Receipt_Grid,Mode_Select)) {
				System.out.println("Expected Result is : The Amount details Should be added to the grid || The Actual Result is : Amount details added to the grid");
				Extent_pass_New(driver, "Expected Result is : The Amount details Should be added to the grid || The Actual Result is : Amount details added to the grid", test, test1);
			}else {
				System.out.println("Expected Result is : The Amount details Should be added to the grid || The Actual Result is : Amount details Not added to the grid");
				extent_fail(driver, "Expected Result is : The Amount details Should be added to the grid || The Actual Result is : Amount details Not added to the grid", test, test1);
			}
			Step_End(21, "Make sure amount details added to the grid", test, test1);
			Step_Start(22, "Go to Invoices and receipts tab", test, test1);
			waitForElement(driver, invoiceAndReceipt_Tab);
			click(driver, invoiceAndReceipt_Tab);
			Step_End(22, "Go to Invoices and receipts tab", test, test1);
			Step_Start(23, "Select the invoice details and click allocate button", test, test1);
			waitForElement(driver, allocate_Btn);
			click(driver, allocate_Btn);
			Step_End(23, "Select the invoice details and click allocate button", test, test1);	
			Step_Start(24, "Click the save button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(24, "Click the save button", test, test1);
			Step_Start(25, "Ensure receipt saved for AED currency and  receipt number generated (Follow the same process for USD currency)", test, test1);
			waitForPopup(driver, popup_Message,Receipt_Save_Popup_Msg);
			String save_Popup=getText(driver, popup_Message);
			if(Receipt_Save_Popup_Msg.equals(save_Popup)) {

				Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+Receipt_Save_Popup_Msg+" || Actual Pop-up value is : "+save_Popup, test, test1);
				System.out.println("Matched || Expected Pop-up value is : "+Receipt_Save_Popup_Msg+" || Actual Pop-up value is : "+save_Popup);

			}else {
				System.out.println("Not Matched || Expected Pop-up value is : "+Receipt_Save_Popup_Msg+" || Actual Pop-up value is : "+save_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+Receipt_Save_Popup_Msg+" || Actual Pop-up value is : "+save_Popup, test, test1);
			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, receipt_Num_field);
			String Generated_Receipt_No=getAttribute(driver, receipt_Num_field, "value");
			System.out.println("New receipt number generated :"+Generated_Receipt_No);
			Receipt_Number.add(Generated_Receipt_No);
			waitForElement(driver, receipt_Num_field);
			Step_End(25, "Ensure receipt saved for AED currency and  receipt number generated (Follow the same process for USD currency)", test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			if(!flag) {
				break;
			}
		}
		moduleNavigate(driver, Import_Invoice_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, Condition, GlobalSearchFilterOption_IN, BL_Num, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver,Invoice_Reversed_TF,Invoice_Reversed_Value);
		waitForElement(driver, Import_Invoice_Grid_Header);
		List<Map<String, String>> Table_Data1 = getTableData(driver,Import_Invoice_Grid_Header , Import_Invoice_Grid_Row);
		List<String> Balance = getValuesByHeader(Table_Data1, "Balance");
		System.out.println("Balance Value after receipt created " +Balance);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(26, "Again search the BL in  Import documentation and fetch the BL", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_ID, BL_Num, "", "", "", "");
		Step_End(26, "Again search the BL in  Import documentation and fetch the BL", test, test1);
		Step_Start(27, "Navigate to Delivery order screen", test, test1);
		waitForElement(driver, DO_Button);
		click(driver, DO_Button);
		Step_End(27, "Navigate to Delivery order screen", test, test1);
		Step_Start(28, "Select the containers", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(28, "Select the containers", test, test1);
		Step_Start(29, "Click the Save button  on Tool bar", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(29, "Click the Save button  on Tool bar", test, test1);
		Step_Start(30, "Ensure \" Delivery order saved \" validation done after Do saved", test, test1);
		waitForPopup(driver,Popup_Message,DO_Saved);
		String DO_Saved_Popup=getText(driver, Popup_Message);
		if (DO_Saved_Popup.equals(DO_Saved)) {
			System.out.println("Matched || Expected value was : " + DO_Saved_Popup + " || Actual value was : " + DO_Saved);
			Extent_pass_New(driver,"Matched || Expected value was : " + DO_Saved_Popup + " || Actual value was : " + DO_Saved, test,test1);
		} else {
			System.out.println("Not Matched || Expected value was : " + DO_Saved_Popup + " || Actual value was : " + DO_Saved);
			Extent_fail(driver,"Not Matched || Expected value was : " + DO_Saved_Popup + " || Actual value was  : " + DO_Saved,test, test1);
		}
		Step_End(30, "Ensure \" Delivery order saved \" validation done after Do saved", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			scrollTop(driver);
			Step_Start(31, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(31, "Click the Delete button", test, test1);
			Step_Start(32, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual, test, test1);
			}
			Step_End(32, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(33, "Click Yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(33, "Click Yes", test, test1);
			Step_Start(34, "Ensure system validated as 'Delivery order deleted'", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if(do_Deleted_Actual.equals(deleted_expected)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+"ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}
			Step_End(34, "Ensure system validated as 'Delivery order deleted'", test, test1);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			Step_Start(35, "Open receipt screen and fetch the receipt in search option", test, test1);
			for(String Receipt_Num:Receipt_Number) {
				moduleNavigate(driver, Receipt_Module);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_Receipt1, Receipt_Num, "", "", "", "");
				Step_End(35, "Open receipt screen and fetch the receipt in search option", test, test1);
				Step_Start(36, "Enter the remarks and Click the delete button (receipt deleted)", test, test1);
				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
				waitForPopup(driver, popup_Message,Receipt_Remarks_Popup_Msg);
				String Remarks_Popup=getText(driver, popup_Message);
				if(Receipt_Remarks_Popup_Msg.equals(Remarks_Popup)) {
					Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+Receipt_Remarks_Popup_Msg+" || Actual Pop-up value is : "+Remarks_Popup, test, test1);
					System.out.println("Matched || Expected Pop-up value is : "+Receipt_Remarks_Popup_Msg+" || Actual Pop-up value is : "+Remarks_Popup);
				}else {
					System.out.println("Not Matched || Expected Pop-up value is : "+Receipt_Remarks_Popup_Msg+" || Actual Pop-up value is : "+Remarks_Popup);
					Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+Receipt_Remarks_Popup_Msg+" || Actual Pop-up value is : "+Remarks_Popup, test, test1);
				}
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, receipt_Remarks_Field);
				sendKeys(driver, receipt_Remarks_Field, Receipt_Num);
				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
				waitForPopup(driver, popup_Message,Receipt_Delete_Yes_No_Popup_Msg);
				String Delete_Popup=getText(driver, popup_Message);
				if(Receipt_Delete_Yes_No_Popup_Msg.equals(Delete_Popup)) {
					Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+Receipt_Delete_Yes_No_Popup_Msg+" || Actual Pop-up value is : "+Delete_Popup, test, test1);
					System.out.println("Matched || Expected Pop-up value is : "+Receipt_Delete_Yes_No_Popup_Msg+" || Actual Pop-up value is : "+Delete_Popup);
				}else {
					System.out.println("Not Matched || Expected Pop-up value is : "+Receipt_Delete_Yes_No_Popup_Msg+" || Actual Pop-up value is : "+Delete_Popup);
					Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+Receipt_Delete_Yes_No_Popup_Msg+" || Actual Pop-up value is : "+Delete_Popup, test, test1);
				}
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
				waitForPopup(driver, popup_Message,Receipt_Delete_Popup_Msg);
				String Receipt_Cancel_Popup=getText(driver, popup_Message);
				if(Receipt_Delete_Popup_Msg.equals(Receipt_Cancel_Popup)) {
					Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+Receipt_Delete_Popup_Msg+" || Actual Pop-up value is : "+Receipt_Cancel_Popup, test, test1);
					System.out.println("Matched || Expected Pop-up value is : "+Receipt_Delete_Popup_Msg+" || Actual Pop-up value is : "+Receipt_Cancel_Popup);
				}else {
					System.out.println("Not Matched || Expected Pop-up value is : "+Receipt_Delete_Popup_Msg+" || Actual Pop-up value is : "+Receipt_Cancel_Popup);
					Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+Receipt_Delete_Popup_Msg+" || Actual Pop-up value is : "+Receipt_Cancel_Popup, test, test1);
				}
				waitForElement(driver,popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				waitForElement(driver, receipt_Num_field);
				scrollTop(driver);
				Step_End(36, "Enter the remarks and Click the delete button (receipt deleted)", test, test1);
				waitForElement(driver, Module_Close);
				click(driver, Module_Close);
			}
			Extent_cal(test, test1, "(Make sure both receipt deleted)");
			Step_Start(37, "Open invoice reversal screen", test, test1);
			moduleNavigate(driver, InvoiceReversal_Module);
			Step_End(38, "Open invoice reversal screen", test, test1);
			Step_Start(39, "Click new and select the invoice in search option", test, test1);
			newButton(driver);
			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);
			globalValueSearchWindow(driver,Condition, GlobalSearchFilterOption_Invoice_reversal, BL_Num, "", "", "", "");
			Step_End(39, "Click new and select the invoice in search option", test, test1);
			Step_Start(40, "Fetch the invoice ,select the invoice", test, test1);
			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);
			waitForElement(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Table_Rows);
			Step_End(40, "Fetch the invoice ,select the invoice", test, test1);
			Step_Start(41, "Enter the reason and click save button", test, test1);
			click(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);
			click(driver, SaveButton_ToolBar);
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			Step_End(41, "Enter the reason and click save button", test, test1);
			Step_Start(42, "Make sure invoice reversed", test, test1);
			waitForPopup(driver, popup_Message,invoiceReversedPopup);
			String actualReversedPopup=getText(driver, popup_Message);
			if(actualReversedPopup.equals(invoiceReversedPopup)) {
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+invoiceReversedPopup + "|| Actual Pop-up value is : "+actualReversedPopup, test, test1);
				System.out.println("Matched || Expected Pop-up value is : "+invoiceReversedPopup + " ||Actual Pop-up value is : "+actualReversedPopup);
				click(driver,popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up value is : "+invoiceReversedPopup + " ||Actual Pop-up value is : "+actualReversedPopup);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+invoiceReversedPopup + " ||Actual Pop-up value is : "+actualReversedPopup, test, test1);
			}
			scrollTop(driver);
			Step_End(42, "Make sure invoice reversed", test, test1);
		}
		Extent_completed(testcase_Name, test, test1);

	}

}
