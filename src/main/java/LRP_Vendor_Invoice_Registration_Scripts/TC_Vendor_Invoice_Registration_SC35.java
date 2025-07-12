package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC35  extends Keywords{

	public void Vendor_Invoice_Registration_SC35(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Vendor_Invoice_Registration_SC35";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Agency = Excel_data.get("Agency");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Vendor_Code_Search = Excel_data.get("Vendor_Code_Search");
		String Condition = Excel_data.get("Condition");
		String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
		String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
		String Inv_Date = Excel_data.get("Inv_Date");
		String Factor_payee_search = Excel_data.get("Factor_payee_search");
		String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
		String Invoice_Number_Input = Excel_data.get("Invoice_Number_Input");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String Act_Expensive_amount = Excel_data.get("Act_Expensive_amount");
		String total_bal_Amount = Excel_data.get("total_bal_Amount");
		String netpaid_Amount = Excel_data.get("netpaid_Amount");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Disbusement_ROE_Input = Excel_data.get("Disbusement_ROE_Input");
		String Disbusse_currency = Excel_data.get("Disbusse_currency");
		String Disbusement_Amount_Input = Excel_data.get("Disbusement_Amount_Input");
		String Payment_method = Excel_data.get("Payment_method");
		String Home_ROE = Excel_data.get("Home_ROE");
		String total_Dispute_AMT = Excel_data.get("total_Dispute_AMT");
		String activity_Dispute = Excel_data.get("activity_Dispute");
		String other_Dispute = Excel_data.get("other_Dispute");
		String total_Tolerance_Amt = Excel_data.get("total_Tolerance_Amt");
		String disputeNumber = Excel_data.get("disputeNumber");
		String Activity_Type = Excel_data.get("Activity_Type");
		String Invoice_Currency_Select = Excel_data.get("Invoice_Currency_Select");
		String datePicker = Excel_data.get("datePicker");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Feeder_search_Header = Excel_data.get("Feeder_search_Header");
		String Search_condition = Excel_data.get("Search_condition");
		String FDR_Header = Excel_data.get("FDR_Header");
		String FDR_SumNo = Excel_data.get("FDR_SumNo");
		String InvoiceSaved_Popup = Excel_data.get("Saved_Popup_Expected");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String Feeder_search_Conditon = Excel_data.get("Feeder_search_Conditon");
		String Haulage_Expense_Module = Excel_data.get("Haulage_Expense_Module");
		String Feeder_Expense_Agency = Excel_data.get("Feeder_Expense_Agency");

		String Feeder_Summary_Headers = Excel_data.get("Feeder_Summary_Headers");

		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, "Select the Load Agency based on the Expense Report", test, test1);

		SwitchProfile(driver, Agency);
		Step_End(1, "Select the Load Agency based on the Expense Report", test, test1);

		//

		Step_Start(2, "Enter the module name as \"\"Vendor Invoice Registration\"\" in the search.\r\n"
				+ "", test, test1);
		moduleNavigate(driver, Module_Name);
		Step_End(2, "Enter the module name as \"\"Vendor Invoice Registration\"\" in the search.\r\n"
				+ "", test, test1);
		Step_Start(3, "Click the Vendor code search button", test, test1);

		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);
		Step_End(3, "Click the Vendor code search button", test, test1);


		Step_Start(4, "It shows the approved vendor based on the vendor master", test, test1);
		Step_Start(5, "Select the Required vendor code and name", test, test1);

		globalValueSearchWindow(driver, Condition, Vendor_Code_Search, Vendor_Code, "","", "","");
		Step_End(4, "It shows the approved vendor based on the vendor master", test, test1);
		Step_End(5, "Select the Required vendor code and name", test, test1);


		if(!Inv_Registration_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Registration_Date_VIR);
			if (datePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Registration_Date_VIR);
				selectDatePicker(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);

			} else {
				waitForElement(driver, Inv_Registration_Date_VIR);
				clearAndType(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);
			}
		}
		if(!Inv_Receiving_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Receiving_Date_VIR);
			if (datePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				selectDatePicker(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			} else {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				clearAndType(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			}}
		if(!Inv_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, vendor_Inv_Date_VIR);
			if (datePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, vendor_Inv_Date_VIR);
				selectDatePicker(driver, vendor_Inv_Date_VIR, Inv_Date);

			} else {
				waitForElement(driver, vendor_Inv_Date_VIR);
				clearAndType(driver, vendor_Inv_Date_VIR, Inv_Date);

			}
		}
		if(!Invoice_Currency_Select.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_currency_dd_VIR);
			click(driver, Vendorinvoice_currency_dd_VIR);
			formatLocatorClick(driver, DropDown_Select, Invoice_Currency_Select);
		}
		
		Step_Start(8, "Click the Disburse currency dropdown", test, test1);

		if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			Step_End(8, "Click the Disburse currency dropdown", test, test1);
			Step_Start(9, "Select the Require currency.", test, test1);

			formatLocatorClick(driver, DropDown_Select, Disbusse_currency);
			Step_End(9, "Select the Require currency.", test, test1);

		}
		Step_Start(10, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
		Step_Start(11, "Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.", test, test1);
		waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
		String Payment_Method_Value_VIR = getText(driver, Vendorinvoice_Payment_method_dd_VIR);
		System.out.println("Payment_Method_Value_VIR :" + Payment_Method_Value_VIR);

		
			Step_Start(12, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

				if(!Payment_method.trim().equals("")) {
				waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
				click(driver, Vendorinvoice_Payment_method_dd_VIR);
				formatLocatorClick(driver, DropDown_Select, Payment_method);
			}
			
			Step_End(12, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

		

		
		if(!Factor_payee_Input.trim().equals("")) {
			waitForElement(driver, factor_Payee_SearchButton_VIR);
			click(driver, factor_Payee_SearchButton_VIR);
			twoColumnSearchWindow(driver, Factor_payee_search, Condition_Filter, Factor_payee_Input);
		}
		
		if(!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
		}


		if(!Act_Expensive_amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Act_Expensive_amount_VIR);
			clearAndType(driver, Act_Expensive_amount_VIR, Act_Expensive_amount);
		}
		if(!total_bal_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_total_bal_Amount_VIR);
			clearAndType(driver, Vendor_total_bal_Amount_VIR, total_bal_Amount);
		}

		if(!total_bal_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Difference_Amount_VIR);
			clearAndType(driver, Vendor_Difference_Amount_VIR,total_bal_Amount);
		}

		if(!netpaid_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_netpaid_Amount_VIR);
			clearAndType(driver, Vendor_netpaid_Amount_VIR, netpaid_Amount);
		}

		if(!invoice_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
		}

		if(!Disbusement_ROE_Input.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusement_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_Disbusement_ROE_Input_VIR, Disbusement_ROE_Input);
		}

		if(!Disbusement_Amount_Input.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusement_Amount_Input_VIR);
			clearAndType(driver, Vendorinvoice_Disbusement_Amount_Input_VIR, Disbusement_Amount_Input);
		}

		if(!Home_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, home_ROE_Textfield_VIR);
			clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
		}

		if(!total_Dispute_AMT.trim().equalsIgnoreCase("")) {
			waitForElement(driver, total_Dispute_Amt_Textfield_VIR);
			clearAndType(driver, total_Dispute_Amt_Textfield_VIR, total_Dispute_AMT);
		}

		if(!activity_Dispute.trim().equalsIgnoreCase("")) {
			waitForElement(driver, activity_Dispute_Textfield_VIR);
			clearAndType(driver, activity_Dispute_Textfield_VIR, activity_Dispute);
		}


		if(!other_Dispute.trim().equalsIgnoreCase("")) {
			waitForElement(driver, other_Dispute_Textfield_VIR);
			clearAndType(driver, other_Dispute_Textfield_VIR, other_Dispute);
		}


		if(!total_Tolerance_Amt.trim().equalsIgnoreCase("")) {
			waitForElement(driver, total_Tolerance_Amt_Textfield_VIR);
			clearAndType(driver, total_Tolerance_Amt_Textfield_VIR, total_Tolerance_Amt);
		}
		if(!disputeNumber.trim().equalsIgnoreCase("")) {
			waitForElement(driver, disputeNumber_Textfield_VIR);
			clearAndType(driver, disputeNumber_Textfield_VIR, disputeNumber);
		}


		Step_Start(13, "In the Activity details, Click Activity type dropdown and select the activity type as a FDR.", test, test1);
		if(!Activity_Type.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);
			formatLocatorClick(driver, DropDown_Select, Activity_Type);
		}
		Step_End(13, "In the Activity details, Click Activity type dropdown and select the activity type as a FDR.", test, test1);

		Step_Start(6, "Click the Vendor invoice field", test, test1);

		Step_Start(7, "Enter the value up to 25 characters", test, test1);

		waitForElement(driver, Vendor_Invoice_Number_Input_VIR1);
		clearAndType(driver, Vendor_Invoice_Number_Input_VIR1,Invoice_Number_Input);
		Step_End(6, "Click the Vendor invoice field", test, test1);

		Step_End(7, "Enter the value up to 25 characters", test, test1);
		Step_Start(14, "Default system select the Fdr sum no", test, test1);
		String FDR_Status = getAttribute(driver, FDR_Grid_SumNo, "class");

		if (extractstatus(FDR_Status)) {

			System.out.println(
					"Matched ||Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is selected as default ");
			Extent_pass(driver,
					"Matched ||Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is selected as default",
					test, test1);

		} else {

			System.out.println(
					"NotMatched Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is not selected as default ");
			Extent_fail(driver,
					"NotMatched Expected result is : By default system should select the FDR Sum No Tab || Actual result : FDR Sum No tab is not selected as default",
					test, test1);

		}
		Step_End(14, "Default system select the Fdr sum no", test, test1);
		Step_Start(15, "Click the Fdr sum no search and select the Required no", test, test1);
		waitForElement(driver, fdr_sum_number_add);
		click(driver, fdr_sum_number_add);

		twoColumnSearchWindow(driver, FDR_Header, Search_condition, FDR_SumNo);
		Step_End(15, "Click the Fdr sum no search and select the Required no", test, test1);


		Step_Start(16, "Click the 'ADD' button, Details added in the Grid", test, test1);

		waitForElement(driver, FDR_Add);
		click(driver, FDR_Add);

		waitForElement(driver, VIR_Grid_Table);

		reArrangeAG_GridColumns(driver, Filter_Headers);

		waitForElement(driver, VIR_Grid_Filter);
		click(driver, VIR_Grid_Filter);

		if (isdisplayed(driver, FDR_Grid1)) {

			System.out.println(
					"Matched ||Expected result is : Given details should be added in the grid || Actual result is : Given details are added in the grid");
			Extent_pass(driver,
					"Matched ||Expected result is : Given details should be added in the grid || Actual result is : Given details are added in the grid",
					test, test1);
		} else {

			System.out.println(
					"NotMatched Expected result is : Given details should be added in the grid || Actual result is : Given details are not added in the grid");
			Extent_fail(driver,
					"NotMatched Expected result is : Given details should be added in the grid || Actual result is : Given details are not added in the grid",
					test, test1);
		}

		waitForElement(driver, VIR_Grid_Table_refNo);
		String refNo = getText(driver, VIR_Grid_Table_refNo);

		Step_End(16, "Click the 'ADD' button, Details added in the Grid", test, test1);

		scrollTop(driver);

		Step_Start(17, "Click the save while in draft", test, test1);
		mouseOverToElement(driver, SaveButton_ToolBar);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		
		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
		
		waitForPopup(driver, popup_Message, InvoiceSaved_Popup);

		String actual_popupmessage = getText(driver, popup_Message);

		if (actual_popupmessage.equals(InvoiceSaved_Popup)) {

			System.out.println("Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage);
			Extent_pass(driver, "Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage);
			Extent_fail(driver, "Not Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(17, "Click the save while in draft", test, test1);

		Step_Start(18, "It auto generate the Invoice Reg No", test, test1);

		String invoice_register_no = getAttribute(driver, Vendor_Register_Number_VIR, "value");

		if (!invoice_register_no.isEmpty()) {

			System.out.println(
					"Matched ||Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No is autogenerated and the generated no was : "
							+ invoice_register_no);
			Extent_pass(driver,
					"Matched ||Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No is autogenerated and the generated no was : "
							+ invoice_register_no,
							test, test1);
		} else {
			System.out.println(
					"NotMatched Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No is autogenerated and the generated no was : "
							+ invoice_register_no);
			Extent_fail(driver,
					"NotMatched Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No was not autogenerated ",
					test, test1);

		}

		Step_End(18, "It auto generate the Invoice Reg No", test, test1);

		ResetProfile(driver);
		SwitchProfile(driver, Feeder_Expense_Agency);
		
		moduleNavigate(driver, Haulage_Expense_Module);
		
		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		waitForElement(driver, SearchButton_Toolbar);
		mouseOverToElement(driver, SearchButton_Toolbar);
		jsClick(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Feeder_search_Conditon, Feeder_search_Header, FDR_SumNo, "", "",
				"", "");

		waitForElement(driver, FER_Expense_Summary);
		click(driver, FER_Expense_Summary);

		waitForElement(driver, FER_Condition_Filter);
		click(driver, FER_Condition_Filter);
		reArrangeAG_GridColumns(driver,Feeder_Summary_Headers);

		waitForElement(driver, EXP_RefNo_input);
		sendKeys(driver, EXP_RefNo_input, refNo);
		waitForElement(driver, EXP_RefNo_input);
		if (isdisplayed(driver, FER_firstrow)) {
			System.out.println(
					"Matched ||Expected result is : Saved ref no details should show in the Haulage Expense report || Actual result is : Saved ref no details are showing in the Haulage Expense report");
			Extent_pass(driver,
					"Matched ||Expected result is : Saved ref no details should show in the Haulage Expense report || Actual result is : Saved ref no details are showing in the Haulage Expense report",
					test, test1);
		} else {
			System.out.println(
					"NotMatched ||Expected result is : Saved ref no details should show in the Haulage Expense report || Actual result is : Saved ref no details are not showing in the Haulage Expense report");
			Extent_fail(driver,
					"NotMatchedExpected result is : Saved ref no details should show in the Haulage Expense report || Actual result is : Saved ref no details are not showing in the Haulage Expense report",
					test, test1);
		}

		Extent_completed(testcase_Name, test, test1);

	}
}
