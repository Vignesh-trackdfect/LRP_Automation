package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC29 extends Keywords{

	public void Vendor_Invoice_Registration_SC29(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
	
		String testCaseName = "TC_Vendor_Invoice_Registration_SC29";
		// Get data from excel sheet
		
        String username = Excel_data.get("Username");
        String password = Excel_data.get("Password");
        String moduleName = Excel_data.get("Module_Name");
        String agencyCode = Excel_data.get("AgencyCode");
        String dropdownCondition = Excel_data.get("DropdownCondition");
    	String vendorCode = Excel_data.get("VendorCode");
    	String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
    	String Vendor_Invoice_No_Char = Excel_data.get("Vendor_Invoice_No_Char");
    	String activityType = Excel_data.get("ActivityType"); 	
    	String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
		String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
		String Inv_Date = Excel_data.get("Inv_Date");
		String datePicker = Excel_data.get("datePicker");
		String condition = Excel_data.get("Condition");
		String Factor_payee_search = Excel_data.get("Factor_payee_search");
		String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String Disbusse_currency = Excel_data.get("Disbusse_currency");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Payment_method = Excel_data.get("Payment_method");
		String invoice_currency = Excel_data.get("Invoice_currency");
		String Home_ROE = Excel_data.get("Home_ROE");
		String Hlg_SumNo_Header = Excel_data.get("Hlg_SumNo_Header");
		String Hlg_SumNo_Header_Value = Excel_data.get("Hlg_SumNo_Header_Value");
		String Grid_value= Excel_data.get("Grid_value");
		String Haulage_Expense_Report_module= Excel_data.get("Haulage_Expense_Report_module");
		String Haulage_Expense_Report_header= Excel_data.get("Haulage_Expense_Report_header");
		String Haulage_Status_Approved= Excel_data.get("Haulage_Status_Approved");
		String InvoiceSaved_Popup= Excel_data.get("InvoiceSaved_Popup");
		String haulage_grid= Excel_data.get("haulage_grid");
		
		String Vendor_Master_Module= Excel_data.get("Vendor_Master_Module");
		String PaymentModes_VM= Excel_data.get("PaymentModes_VM");
		String PaymentModes_VIR= Excel_data.get("PaymentModes_VIR");
		String PaymentMode_RadioButton_Status= Excel_data.get("PaymentMode_RadioButton_Status");		
		
		Extent_Start(testCaseName, test, test1);
        navigateUrl(driver, url);

		// Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "Select the Load Agency based on the Expense Report ", test, test1);
		SwitchProfile(driver, agencyCode);
		Step_End(1, "Select the Load Agency based on the Expense Report ", test, test1);
		
		
		Extent_call(test, test1, "Vendor Master screen - Start");
		moduleNavigate(driver, Vendor_Master_Module);

		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

		List<String> paymentModes_VM = splitAndExpand(PaymentModes_VM);
		List<String> paymentModes_VIR = splitAndExpand(PaymentModes_VIR);

		waitForElement(driver, HQ_RadioButton_VM);
		String status_Of_HQ_RadioButton_VM = getAttribute(driver, HQ_RadioButton_VM, "class");
		String status_Of_Disbursement_RadioButton_VM = getAttribute(driver, Disbursement_RadioButton_VM, "class");

		if (status_Of_HQ_RadioButton_VM.contains(PaymentMode_RadioButton_Status)) {
			status_Of_HQ_RadioButton_VM = PaymentMode_RadioButton_Status;
		} else if (status_Of_Disbursement_RadioButton_VM.contains(PaymentMode_RadioButton_Status)) {
			status_Of_Disbursement_RadioButton_VM = PaymentMode_RadioButton_Status;

		}

		waitForElement(driver, Paymemnt_Method_VM);
		String Payment_Method_Value = getText(driver, Paymemnt_Method_VM);
		System.out.println("Payment_Method_Value VM :" + Payment_Method_Value);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		
		Extent_call(test, test1, "Vendor Master screen - End");
		
		
		
		Step_Start(2, ".Enter the screen name as a \"Vendor Invoice Registration\" in the Search.", test, test1);
		moduleNavigate(driver, moduleName);
		Step_End(2, ".Enter the screen name as a \"Vendor Invoice Registration\" in the Search.", test, test1);
		
		Step_Start(3, "Click the Vendor code search button", test, test1);
		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver,Vedor_Code_Search_Button_VIR);
		Step_End(3, "Click the Vendor code search button", test, test1);
		
		
		Step_Start(4, "It shows the approved vendor based on the vendor master", test, test1);
		Step_Start(5, "Select the Required vendor code and name.", test, test1);
		Step_Start(6, "Click the Vendor invoice field", test, test1);
		
		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");
		
		Step_End(4, "It shows the approved vendor based on the vendor master", test, test1);
		Step_End(5, "Select the Required vendor code and name.", test, test1);
		Step_End(6, "Click the Vendor invoice field", test, test1);
		
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
			}
		}
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
			
			if(!Factor_payee_Input.trim().equals("")) {
				waitForDisplay(driver, factor_Payee_SearchButton_VIR);
				if(isdisplayed(driver, factor_Payee_SearchButton_VIR)) {
				click(driver, factor_Payee_SearchButton_VIR);
				twoColumnSearchWindow(driver, Factor_payee_search, condition, Factor_payee_Input);
				}
			}
			
			// Vendor invoice number		
		Step_Start(7, ".Enter the value up to 25 characters", test, test1);	
		
		waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
		sendKeys(driver, Vendor_Invoice_Number_Input_VIR, Vendor_Invoice_No_Char);
		
		Step_End(7, ".Enter the value up to 25 characters", test, test1);	
		
		
		if(!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
			}
			
			if(!invoice_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, invoiceCurrency_Dropdown_VIR);
			click(driver, invoiceCurrency_Dropdown_VIR);
			
			String invoiceCurrency_select =  String.format(DropDown_Select, invoice_currency); 
			click(driver, invoiceCurrency_select);
			
			}
			
			
			if(!invoice_ROE.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
				clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
			}
			
			Step_Start(8, "Click the Disburse currency dropdown", test, test1);	
			Step_Start(9, "Select the Require currency", test, test1);	
			
			if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
				click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
				
				String invoice_select =  String.format(DropDown_Select, Disbusse_currency); 
				click(driver, invoice_select);
				
			}
			Step_End(8, "Click the Disburse currency dropdown", test, test1);	
			Step_End(9, "Select the Require currency", test, test1);	
			
			Step_Start(10, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);	
			
			
			waitForElement(driver, direct_Payment_Mode_Button_VIR);
			String status_Of_direct_Payment_Mode_Button_VIR = getAttribute(driver, direct_Payment_Mode_Button_VIR, "class");
			String status_Of_disbursment_Payement_Mode_Button_VIR = getAttribute(driver,
					disbursment_Payement_Mode_Button_VIR, "class");

			if (status_Of_direct_Payment_Mode_Button_VIR.contains(status_Of_HQ_RadioButton_VM)) {

				System.out.println(
						"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(0)
								+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
								+ paymentModes_VIR.get(0));
				Extent_pass(driver,
						"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(0)
								+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
								+ paymentModes_VIR.get(0),
						test, test1);
			} else if (status_Of_disbursment_Payement_Mode_Button_VIR.contains(status_Of_Disbursement_RadioButton_VM)) {
				System.out.println(
						"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(1)
								+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
								+ paymentModes_VIR.get(1));
				Extent_pass(driver,
						"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(1)
								+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
								+ paymentModes_VIR.get(1),
						test, test1);
			} else {
				System.out.println(
						"Not Matched || Expected result is : expected radio button should be selected || Actual result is : Expected Radio Button is not selected");
				Extent_fail(driver,
						"Not Matched || Expected result is : expected radio button should be selected || Actual result is : Expected Radio Button is not selected",
						test, test1);
			}

			Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
			Step_Start(10,
					"Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.",
					test, test1);

			waitForElement(driver, Payment_Method_VIR);
			String Payment_Method_Value_VIR = getText(driver, Payment_Method_VIR);
			System.out.println("Payment_Method_Value_VIR :" + Payment_Method_Value_VIR);

			if (Payment_Method_Value.equalsIgnoreCase(Payment_Method_Value_VIR)) {
				System.out.println("Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_Method_Value
						+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
						+ Payment_Method_Value_VIR);
				Extent_pass(driver,
						"Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_Method_Value
								+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
								+ Payment_Method_Value_VIR,
						test, test1);

				Step_End(10,
						"Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.",
						test, test1);

			} else {
				Step_Start(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

				if(!Payment_method.trim().equals("")) {
					waitForElement(driver, Payment_Method_VIR);
					click(driver, Payment_Method_VIR);
					formatLocatorClick(driver, DropDown_Select, Payment_method);
				}
				Step_End(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);
			}
			
			if(!Payment_method.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
				click(driver, Vendorinvoice_Payment_method_dd_VIR);
				formatLocatorClick(driver, DropDown_Select, Payment_method);
			}
			Step_End(10, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);	
			Step_End(11, "Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master", test, test1);	
			if(!Home_ROE.trim().equalsIgnoreCase("")) {
				waitForElement(driver, home_ROE_Textfield_VIR);
				clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
			}
		
		Step_Start(13, "In the Activity details, Click Activity type dropdown and select the activity type as a \"HCN\"", test, test1);	
			
		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		
		String select_ActivityType=String.format(DropDown_Select, activityType);
		waitForElement(driver, select_ActivityType);
		click(driver, select_ActivityType);
		
		Step_End(13, "In the Activity details, Click Activity type dropdown and select the activity type as a \"HCN\"", test, test1);	
		
		Step_Start(14, "Default system select the Hlg sum no", test, test1);	
		
		waitForElement(driver, Vendor_Invoice_HCN_Plus);
		click(driver, Vendor_Invoice_HCN_Plus);
		
		Step_End(14, "Default system select the Hlg sum no", test, test1);	
		
		Step_Start(15, "Click the Hlg sum no search and select the Required no", test, test1);	
		
		twoColumnSearchWindow(driver, Hlg_SumNo_Header, condition, Hlg_SumNo_Header_Value);
		
		Step_End(15, "Click the Hlg sum no search and select the Required no", test, test1);	
		
		Step_Start(16, "Click the \"+ADD\" button, Details added in the Grid", test, test1);	
		waitForElement(driver, Vendor_Invoice_HCN_Add_button);
		click(driver, Vendor_Invoice_HCN_Add_button);
		Step_End(16, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		
		Step_Start(17, "Click the save while in draft", test, test1);	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
	
	   waitForPopup(driver, popup_Message, InvoiceSaved_Popup);
	   String act_popup =getText(driver, popup_Message);
		
		if(InvoiceSaved_Popup.equals(act_popup)) {
			System.out.println("Matched || Expected : After click on save button the pop up message should be display : "+InvoiceSaved_Popup+" || Actual : After click on save button the pop up message is display :"+act_popup);
			Extent_pass(driver, "Matched || Expected : After click on save button the pop up message should be display : "+InvoiceSaved_Popup+" || Actual : After click on save button the pop up message is display "+act_popup, test, test1);
		}else{
			System.out.println("Not Matched || Expected : After click on save button the pop up message should be display : "+InvoiceSaved_Popup+" || Actual : After click on save button the pop up message is not display :"+act_popup);
			Extent_fail(driver, "Not Matched || Expected : After click on save button the pop up message should be display : "+InvoiceSaved_Popup+" || Actual : After click on save button the pop up message is not  display "+act_popup, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(17, "Click the save while in draft", test, test1);
		
		Step_Start(18, "It auto generate the Invoice Reg No.", test, test1);
	
		reArrangeAG_Grid_Outer_Column_CS(driver, Grid_value);
		
		waitForElement(driver, Vendor_Invoice_Activity_Ref_Number);
		String activity_ref_number =getText(driver, Vendor_Invoice_Activity_Ref_Number);
		System.out.println("activity_ref_number :"+activity_ref_number);
	    String [] splittedValue=activity_ref_number.split("-");
	    System.out.println("splittedValue 1 :: "+splittedValue[0]);
	    
		ResetProfile(driver);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
		}
		
		moduleNavigate(driver, Haulage_Expense_Report_module);
		
		waitForElement(driver, HER_new_button);
		click(driver, HER_new_button);
		
		waitForElement(driver, SearchButton_Toolbar);
		jsClick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition, Haulage_Expense_Report_header, splittedValue[0], "", "", "", "");
		
		waitForElement(driver, HER_Approved);
		String approved_act =getText(driver, HER_Approved);
		
		if(Haulage_Status_Approved.equals(approved_act)) {
			System.out.println("Matched || Expected : Haulage Expense Status message should be display : "+Haulage_Status_Approved+" || Actual : Haulage Expense Status message Is displayed "+approved_act);
			Extent_pass(driver, "Matched || Expected : Haulage Expense Status message should be display : "+Haulage_Status_Approved+" || Actual : Haulage Expense Status message Is displayed "+approved_act, test, test1);
		}else {
			System.out.println("Not Matched || Expected : Haulage Expense Status message should be display : "+Haulage_Status_Approved+" || Actual : Haulage Expense Status message Is Not displayed "+approved_act);
			Extent_fail(driver, "Not Matched || Expected : Haulage Expense Status message should be display : "+Haulage_Status_Approved+" || Actual : Haulage Expense Status message Is Not displayed "+approved_act, test, test1);
		}
		
		waitForElement(driver, HER_Expense_Summary);
		click(driver, HER_Expense_Summary);
		
		waitForElement(driver, EXP_Condition_Filter);
		click(driver, EXP_Condition_Filter);
		
		reArrangeAG_GridColumns(driver, haulage_grid);
		
		waitForElement(driver, EXP_RefNo_input);
		sendKeys(driver, EXP_RefNo_input, activity_ref_number);
		
		waitForDisplay(driver, Hlg_Sum_Ref_No_ExpenseSummary);
		if(isdisplayed(driver, Hlg_Sum_Ref_No_ExpenseSummary)) {
			System.out.println("Expected : Haulage Activity Ref Number '"+activity_ref_number+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+activity_ref_number+"' is displayed in the Haulage Summary Table ");
			Extent_pass_New(driver, "Expected : Haulage Activity Ref Number '"+activity_ref_number+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+activity_ref_number+"' is displayed in the Haulage Summary Table ", test, test1);
		}else {
			System.out.println("Expected : Haulage Activity Ref Number '"+activity_ref_number+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+activity_ref_number+"' is not displayed in the Haulage Summary Table ");
			Extent_fail(driver, "Expected : Haulage Activity Ref Number '"+activity_ref_number+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+activity_ref_number+"' is not displayed in the Haulage Summary Table ", test, test1);
		}
		
		waitForElement(driver, HER_Discharge_Agency);
		String Act_Discharge_Agency =getText(driver, HER_Discharge_Agency);
		
		if(isdisplayed(driver, HER_Discharge_Agency)) {
			System.out.println("Matched || Expected : After click on  Haulage Expense Report valuse was Discharge agency valus Should be is display "+Act_Discharge_Agency +"|| Actual : After click on  Haulage Expense Report valuse was Discharge agency valus  is displayed ");
			Extent_pass(driver, "Matched || Expected : After click on  Haulage Expense Report valuse was Discharge agency valus Should be is display "+Act_Discharge_Agency+"|| Actual : After click on  Haulage Expense Report valuse was Discharge agency valus  is displayed ", test, test1);
		}else {
			System.out.println("Not Matched || Expected :  After click on  Haulage Expense Report valuse was Discharge agency valus is not  display "+Act_Discharge_Agency+"|| Actual : After click on  Haulage Expense Report valuse was Discharge agency valus  is not  displayed ");
			Extent_fail(driver, "Not Matched || Expected : After click on  Haulage Expense Report valuse was Discharge agency valus is not display "+Act_Discharge_Agency+"|| Actual : After click on  Haulage Expense Report valuse was Discharge agency valus  is not displayed ", test, test1);
		}
		
		Extent_completed(testCaseName, test, test1);
	}
}