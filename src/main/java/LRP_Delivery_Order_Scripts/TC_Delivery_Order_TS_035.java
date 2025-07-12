package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_035 extends Keywords {
	public void Delivery_Order_TS_035(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)throws Throwable {

		String testcase_Name = "TC_Delivery_Order_TS_035";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String agencyUser2 = Excel_data.get("AgencyUser_2");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String module_Delivery_Order = Excel_data.get("Module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String module_AgencyConfiguration = Excel_data.get("Module_AgencyConfiguration");
		String attribute = Excel_data.get("Attribute");
		String description = Excel_data.get("AttributeDescription");
		String set_As_Default = Excel_data.get("set_As_Default");
		String value = Excel_data.get("Value");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String globalSearchFilterOption_IMD = Excel_data.get("GlobalSearchFilterOption_IMD");
		String ID_Table_Name = Excel_data.get("ID_Table_Name");
		String ID_Table_Headers = Excel_data.get("ID_Charges_Table_Headers");
		String globalSearchFilterOption_Invoice = Excel_data.get("GlobalSearchFilterOption_Invoice");
		String DO_Saved_Popup = Excel_data.get("DO_Saved_Popup");
		String delete_Option = Excel_data.get("delete_Option");
		String wantToDelete_Popup = Excel_data.get("WantToDelete_Popup");
		String DO_Deleted_Popup = Excel_data.get("DO_Deleted_Popup");
		String invoiceModule = Excel_data.get("InvoiceModule");
		String crossCollection_Popup = Excel_data.get("CrossCollection_Popup");
		String invoice_Mode = Excel_data.get("InvoiceMode");
		String crossInvoicePopup = Excel_data.get("CrossInvoicePopup");
		String module_InvoiceReversal = Excel_data.get("Module_InvoiceReversal");
		String invoiceReversalRemarks = Excel_data.get("InvoiceReversalRemarks");
		String globalSearchFilterOption_InvoiceReversal = Excel_data.get("GlobalSearchFilterOption_InvoiceReversal");
		String issuedInvoiceColor = Excel_data.get("IssuedInvoiceColor");
		String invoiceReversedPopup = Excel_data.get("InvoiceReversedPopup");
		String wantToReverse_Popup = Excel_data.get("WantToReverse_Popup");
		String configuration_Reset = Excel_data.get("configuration_Reset");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, agencyUser, attribute, description, value);
		//				Import Documentation
		moduleNavigate(driver, module_ImportDocumentation);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		Step_End(5, "Open Import Documentation and search the BL and fetch the BL as mentioned in previous scenarios",
				test, test1);
		Step_Start(6, " Click on the prepaid charge tab and capture the Charge code, amount and charge type", test,
				test1);
		waitForElement(driver, Prepaid_Charges_Tab);
		click(driver, Prepaid_Charges_Tab);
		scrollBottom(driver);
		waitForElement(driver, importDocumentation_PrepaidCharges_Rows);
		List<Map<String, String>> prepaid_Tabledata = getTableDatawithscroll(driver,
				importDocumentation_PrepaidCharges_Columns, importDocumentation_PrepaidCharges_Rows,
				prepaidCgarges_Tab_Scroll_IMD, 80, -2000);
		List<String> columnheaders = splitAndExpand(ID_Table_Headers);
		String Charges_Tabledata = TableDataForReport(driver, prepaid_Tabledata, ID_Table_Name, columnheaders);
		Extent_pass_New(driver, "<pre>" + Charges_Tabledata + "</pre>", test, test1);
		scrollTop(driver);
		Step_End(6, " Click on the prepaid charge tab and capture the Charge code, amount and charge type", test,
				test1);
		Step_Start(7, "Open Delivery order module", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		//	Delivery Order
		Extent_cal(test, test1, module_Delivery_Order);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(7, "Open Delivery order module", test, test1);
		Step_Start(8, "Click new button ", test, test1);
		newButton(driver);
		Step_End(8, "Click new button ", test, test1);
		Step_Start(9, "Click the \" ADD \" Button", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(9, "Click the \" ADD \" Button", test, test1);
		Step_Start(10, "Paste the BL ,click search and fetch the record", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		Step_End(10, "Paste the BL ,click search and fetch the record", test, test1);
		Step_Start(11, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(11, "Click the SHOW button", test, test1);
		Step_Start(12,
				"Ensure that system validated as \" Cross Collection Charges has to be invoiced to Generate Delivery Order \"",
				test, test1);
		waitForPopup(driver, deliveryOrder_Popup_Message,crossCollection_Popup);
		String actual_Popup = getText(driver, deliveryOrder_Popup_Message);
		if (actual_Popup.equals(crossCollection_Popup)) {
			System.out.println(
					"MATCHED || EXPECTED Pop-up value is : " + crossCollection_Popup + " ACTUAL Pop-up value is : " + actual_Popup);
			Extent_pass_New(driver,
					"MATCHED || EXPECTED Pop-up value is : " + crossCollection_Popup + " ACTUAL Pop-up value is : " + actual_Popup, test,
					test1);
			click(driver, DO_Popup_Close_Button);
		} else {
			System.out.println(
					"NOT MATCHED || EXPECTED Pop-up value is : " + crossCollection_Popup + " ACTUAL Pop-up value is : " + actual_Popup);
			Extent_fail(driver,
					"NOT MATCHED || EXPECTED Pop-up value is : " + crossCollection_Popup + " ACTUAL Pop-up value is : " + actual_Popup,
					test, test1);
		}
		Step_End(12,
				"Ensure that system validated as \" Cross Collection Charges has to be invoiced to Generate Delivery Order \"",
				test, test1);
		Step_Start(13, "Switch to AEESAD Agency", test, test1);
		SwitchProfile(driver, agencyUser2);
		Step_End(13, "Switch to AEESAD Agency", test, test1);
		Step_Start(14, "open invoice screen (Select cross )", test, test1);
		scrollTop(driver);
		// Invoice
		moduleNavigate(driver, invoiceModule);
		waitForElement(driver, invoiceMode_Dropdown);
		click(driver, invoiceMode_Dropdown);
		formatLocatorClick(driver, invoiceMode, invoice_Mode);
		Step_End(14, "open invoice screen (Select cross )", test, test1);
		Extent_cal(test, test1, invoiceModule);
		Step_Start(15, "Click new and bl number search icon", test, test1);
		newButton(driver);
		waitForElement(driver, invoice_serach);
		click(driver, invoice_serach);
		Step_End(15, "Click new and bl number search icon", test, test1);
		Step_Start(16, "paste the bl and fetch the record", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Invoice, globalSearch_Number, "", "", "", "");
		Step_Start(16, "paste the bl and fetch the record", test, test1);
		Step_Start(17, "Select the issue button and click save ", test, test1);
		waitForElement(driver, INVOICE_issued);
		click(driver, INVOICE_issued);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(17, "Select the issue button and click save ", test, test1);
		Step_Start(18, "System validated as cross invoice saved", test, test1);
		waitForPopup(driver,popup_Message,crossInvoicePopup);
		String actualinvoicepop = getText(driver, popup_Message);
		if (crossInvoicePopup.equals(actualinvoicepop)) {
			Extent_pass_New(driver,
					"Matched || Expected Pop-up value is : " + crossInvoicePopup + " || Actual Pop-up value is : " + actualinvoicepop, test,
					test1);
			System.out.println(
					"Matched || Expected Pop-up value is : " + crossInvoicePopup + " || Actual Pop-up value is : " + actualinvoicepop);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println(
					"Not Matched || Expected Pop-up value is : " + crossInvoicePopup + " || Actual Pop-up value is : " + actualinvoicepop);
			Extent_fail(driver,
					"Not Matched || Expected Pop-up value is : " + crossInvoicePopup + " || Actual Pop-up value is : " + actualinvoicepop,
					test, test1);

		}
		Step_End(18, "System validated as cross invoice saved", test, test1);
		Step_Start(19, "Switch to MYPKGE agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(19, "Switch to MYPKGE agency", test, test1);
		Step_Start(20, "Follow the step no 5 to 9 ", test, test1);
		//		Import Documentation
		Extent_cal(test, test1, module_ImportDocumentation);
		moduleNavigate(driver, module_ImportDocumentation);
		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_IMD, globalSearch_Number, "", "", "", "");
		waitForElement(driver, Prepaid_Charges_Tab);
		click(driver, Prepaid_Charges_Tab);
		scrollBottom(driver);
		waitForElement(driver, importDocumentation_PrepaidCharges_Rows);
		List<Map<String, String>> prepaid_Tabledata1 = getTableDatawithscroll(driver,
				importDocumentation_PrepaidCharges_Columns, importDocumentation_PrepaidCharges_Rows,
				prepaidCgarges_Tab_Scroll_IMD, 80, -2000);
		List<String> columnheaders1 = splitAndExpand(ID_Table_Headers);
		String Charges_Tabledata1 = TableDataForReport(driver, prepaid_Tabledata1, ID_Table_Name, columnheaders1);
		Extent_pass_New(driver, "<pre>" + Charges_Tabledata1 + "</pre>", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		//Delivery Order
		moduleNavigate(driver, module_Delivery_Order);
		Extent_cal(test, test1, module_Delivery_Order);
		newButton(driver);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(20, "Follow the step no 5 to 9 ", test, test1);
		Step_Start(21, "Select the container and save", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(21, "Select the container and save", test, test1);
		Step_Start(22, "Ensure delivery order saved.", test, test1);
		waitForPopup(driver,Popup_Message,DO_Saved_Popup);
		String save_Popup_Actual = getText(driver, Popup_Message);
		if (save_Popup_Actual.equals(DO_Saved_Popup)) {
			System.out
			.println("MATCHED || EXPECTED Pop-up value is : " + DO_Saved_Popup + " || ACTUAL Pop-up value is : " + save_Popup_Actual);
			Extent_pass_New(driver,
					"MATCHED || EXPECTED Pop-up value is : " + DO_Saved_Popup + " || ACTUAL Pop-up value is : " + save_Popup_Actual, test,
					test1);
		} else {
			System.out.println(
					"NOT MATCHED || EXPECTED Pop-up value is : " + DO_Saved_Popup + " || ACTUAL Pop-up value is : " + save_Popup_Actual);
			Extent_fail(driver,
					"NOT MATCHED || EXPECTED Pop-up value is : " + DO_Saved_Popup + " || ACTUAL Pop-up value is : " + save_Popup_Actual, test,
					test1);
		}
		Step_End(22, "Ensure delivery order saved.", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Extent_call(test, test1, "No need verify below but script must be there to reuse of Bls");
			Step_Start(1, "Click the Delete button", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(1, "Click the Delete button", test, test1);
			Step_Start(2, "system validated as \"\"Are you sure want to delete the Delivery Order? \"\"", test, test1);
			waitForPopup(driver,popup_Message,wantToDelete_Popup);
			String actualWantToDelete_Popup = getText(driver, popup_Message);
			if (actualWantToDelete_Popup.equals(wantToDelete_Popup)) {
				System.out.println("Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
				Extent_pass_New(driver, "Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup, test, test1);
			} else {
				System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup);
				Extent_fail(driver, "Not Matched || Expected Delivery Order Pop-up value is : " + wantToDelete_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actualWantToDelete_Popup, test, test1);
			}
			Step_End(2, "system validated as \"\"Are you sure want to delete the Delivery Order? \"\"", test, test1);
			Step_Start(3, "Click Yes", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(3, "Click Yes", test, test1);
			Step_Start(4, "Ensure system validated as Delivery order deleted ", test, test1);
			waitForPopup(driver,Popup_Message,DO_Deleted_Popup);
			String actual_Deleted_Popup = getText(driver, Popup_Message);
			if (actual_Deleted_Popup.equals(DO_Deleted_Popup)) {
				System.out.println("Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
				Extent_pass_New(driver, "Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup, test, test1);
			} else {
				System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup);
				Extent_fail(driver, "Not Matched || Expected Delivery Order Pop-up value is : " + DO_Deleted_Popup
						+ " || Actual Delivery Order Pop-up value is : " + actual_Deleted_Popup, test, test1);
			}
			Step_End(4, "Ensure system validated as Delivery order deleted ", test, test1);
			Step_Start(5, "Go to AEESAD agency", test, test1);
			scrollTop(driver);
			waitForElement(driver, Module_Close);
			click(driver, Module_Close);
			SwitchProfile(driver, agencyUser2);
			Step_End(5, "Go to AEESAD agency", test, test1);
			Step_Start(6, "open invoice reversal screen", test, test1);
			// Invoice Reversal
			Extent_cal(test, test1, module_InvoiceReversal);
			moduleNavigate(driver, module_InvoiceReversal);
			newButton(driver);
			Step_End(6, "open invoice reversal screen", test, test1);
			Step_Start(7, "Click the invoice no search button", test, test1);
			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);
			Step_End(7, "Click the invoice no search button", test, test1);
			Step_Start(8, "Paste the invoice number and fetch the record", test, test1);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_InvoiceReversal, globalSearch_Number, "", "", "", "");
			Step_End(8, "Paste the invoice number and fetch the record", test, test1);
			Step_Start(9, "Click show and enter the remarks", test, test1);
			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);
			waitForElement(driver, invoiceReversal_Remarks_TextArea);
			click(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);
			Step_End(9, "Click show and enter the remarks", test, test1);
			Step_Start(10, "Select row from grid and click save", test, test1);
			formatLocatorClick(driver, issuedInvoice_Row, issuedInvoiceColor);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(10, "Select row from grid and click save", test, test1);
			Step_Start(11, "system validated as \"\"Do you want to reverse the selected Invoice?\"\"", test, test1);
			waitForPopup(driver,popup_Message,wantToReverse_Popup);
			String actualConfirmationPopup1 = getText(driver, popup_Message);
			if (actualConfirmationPopup1.contains(wantToReverse_Popup)) {
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + wantToReverse_Popup + " || Actual Pop-up value is : "
						+ actualConfirmationPopup1, test, test1);
				System.out.println("Matched || Expected Pop-up value is : " + wantToReverse_Popup + " || Actual Pop-up value is : "
						+ actualConfirmationPopup1);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is : " + wantToReverse_Popup + " || Actual Pop-up value is : "
						+ actualConfirmationPopup1);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + wantToReverse_Popup + " || Actual Pop-up value is : "
						+ actualConfirmationPopup1, test, test1);
			}
			Step_End(11, "system validated as \"\"Do you want to reverse the selected Invoice?\"\"", test, test1);
			Step_Start(12, "Click yes", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(12, "Click yes", test, test1);
			Step_Start(13, " Make sure cross  invoice reversed.", test, test1);
			waitForPopup(driver, popup_Message,invoiceReversedPopup);
			String actualReversedPopup = getText(driver, popup_Message);
			if (actualReversedPopup.equals(invoiceReversedPopup)) {
				Extent_pass_New(driver,
						"Matched || Expected Pop-up value is : " + invoiceReversedPopup + " Actual Pop-up value is : " + actualReversedPopup,
						test, test1);
				System.out.println(
						"Matched || Expected Pop-up value is : " + invoiceReversedPopup + " Actual Pop-up value is : " + actualReversedPopup);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is : " + invoiceReversedPopup + " Actual Pop-up value is : "
						+ actualReversedPopup);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + invoiceReversedPopup + " Actual Pop-up value is : "
						+ actualReversedPopup, test, test1);
			}
			Step_End(13, " Make sure cross  invoice reversed.", test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// Agency Configuration
		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, agencyUser, description, configuration_Reset, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}
