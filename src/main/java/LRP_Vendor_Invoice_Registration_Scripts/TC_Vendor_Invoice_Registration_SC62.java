package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC62 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC62(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC62";
		//  Get data from excel sheet	
	        String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String agencyCode = Excel_data.get("AgencyCode");

	        String dropdownCondition = Excel_data.get("DropdownCondition");
			String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
			String vendorCode = Excel_data.get("VendorCode");
			String vendorInvoiceNumber = Excel_data.get("VendorInvoiceNumber");
			String activityType = Excel_data.get("ActivityType");
			String condition = Excel_data.get("Condition");
			String invoiceSaved_Popup = Excel_data.get("InvoiceSaved_Popup");
			String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
			String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
			String Inv_Date = Excel_data.get("Inv_Date");
			String datePicker = Excel_data.get("datePicker");
			String contractType = Excel_data.get("ContractType");

			String Factor_payee_search = Excel_data.get("Factor_payee_search");
			String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
			String Inv_Amount = Excel_data.get("Inv_Amount");
			String Disburse_currency = Excel_data.get("Disburse_currency");
			String invoice_ROE = Excel_data.get("invoice_ROE");
			String Payment_method = Excel_data.get("Payment_method");
			String invoice_currency = Excel_data.get("Invoice_currency");
			String Home_ROE = Excel_data.get("Home_ROE");

			String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
			String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
			String paymentMode_RadioButton_Status = Excel_data.get("PaymentMode_RadioButton_Status");
			String PaymentModes_VIR = Excel_data.get("PaymentModes_VIR");
			String PaymentModes_VM = Excel_data.get("PaymentModes_VM");
			String RadioButtonDescription = Excel_data.get("RadioButtonDescription");
			
			String status_Of_RadioButton = Excel_data.get("Status_Of_RadioButton");
			String AG_Grid_Column_Headers = Excel_data.get("AG_Grid_Column_Headers");
			String CAR_No_Header = Excel_data.get("CAR_No_Header");
			String CAR_No_Input = Excel_data.get("CAR_No_Input");
			String Tolerance_module = Excel_data.get("Tolerance_module");
			String port_Code = Excel_data.get("Port_Code");
			String additional_Invoice_Amount = Excel_data.get("Additional_Invoice_Amount");

			
			Extent_Start(testCaseName, test, test1);
			navigateUrl(driver, url);

			// Login
			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			
			Step_Start(1, "Need to switch the require agency", test, test1);
			
			SwitchProfile(driver, agencyCode);
			
			Step_End(1, "Need to switch the require agency", test, test1);

//			Vendor Master
			moduleNavigate(driver, Vendor_Master_Module);

			waitForElement(driver, new_Button_VM);
			click(driver, new_Button_VM);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

			List<String>paymentModes_VM=splitAndExpand(PaymentModes_VM);
			List<String>paymentModes_VIR=splitAndExpand(PaymentModes_VIR);

			waitForElement(driver, HQ_RadioButton_VM);
			String status_Of_HQ_RadioButton_VM=getAttribute(driver, HQ_RadioButton_VM, "class");
			String status_Of_Disbursement_RadioButton_VM=getAttribute(driver, Disbursement_RadioButton_VM, "class");

			if(status_Of_HQ_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
				status_Of_HQ_RadioButton_VM=paymentMode_RadioButton_Status;
			}
			else if(status_Of_Disbursement_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
				status_Of_Disbursement_RadioButton_VM=paymentMode_RadioButton_Status;

			}
			
			waitForElement(driver, Paymemnt_Method_VM);
			String Payment_Method_Value=getText(driver, Paymemnt_Method_VM);
			System.out.println("Payment_Method_Value VM :"+Payment_Method_Value);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
//			Vendor Invoice Registration
			Step_Start(2, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

			moduleNavigate(driver, moduleName);

			Step_End(2, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

			Step_Start(3, "Click the Vendor code search button", test, test1);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			Step_End(3, "Click the Vendor code search button", test, test1);
			Step_Start(4, "It shows the approved vendor based on the vendor master.", test, test1);
			Step_Start(5, "Select the Required vendor code and name.", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			Step_End(4, "It shows the approved vendor based on the vendor master.", test, test1);
			Step_End(5, "Select the Required vendor code and name.", test, test1);

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
				
				if(!Factor_payee_Input.trim().equals("")) {
					waitForElement(driver, factor_Payee_SearchButton_VIR);
					click(driver, factor_Payee_SearchButton_VIR);
					twoColumnSearchWindow(driver, Factor_payee_search, condition, Factor_payee_Input);
				}
				
				Step_Start(6, "Click the Vendor invoice field.", test, test1);

		// Vendor invoice number		
			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			click(driver, Vendor_Invoice_Number_Input_VIR);
			
			Step_End(6, "Click the Vendor invoice field.", test, test1);
			Step_Start(7, "Enter the value up to 25 characters.", test, test1);
			
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);
			
			Step_End(7, "Enter the value up to 25 characters.", test, test1);
	
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

			if(!Disburse_currency.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
				click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
				
				Step_End(8, "Click the Disburse currency dropdown", test, test1);
				Step_Start(9, "Select the Require currency.", test, test1);

				String currency_select =  String.format(DropDown_Select, Disburse_currency); 
				waitForElement(driver, currency_select);
				click(driver, currency_select);
				
				Step_End(9, "Select the Require currency.", test, test1);

			}
				
			Step_Start(10, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);

			waitForElement(driver, direct_Payment_Mode_Button_VIR);
			String status_Of_direct_Payment_Mode_Button_VIR=getAttribute(driver, direct_Payment_Mode_Button_VIR, "class");
			String status_Of_disbursment_Payement_Mode_Button_VIR=getAttribute(driver, disbursment_Payement_Mode_Button_VIR, "class");

			if(status_Of_direct_Payment_Mode_Button_VIR.contains(status_Of_HQ_RadioButton_VM)) {
				
				System.out.println("Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(0)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(0));
				Extent_pass_New(driver, "Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(0)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(0), test, test1);
			}
			else if(status_Of_disbursment_Payement_Mode_Button_VIR.contains(status_Of_Disbursement_RadioButton_VM)) {
				System.out.println("Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(1)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(1));
				Extent_pass_New(driver, "Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(1)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(1), test, test1);
			}else {
				System.out.println("Not Matched || : "+paymentModes_VM.get(0) +"/"+paymentModes_VM.get(1)+" Radio Button is not selected in Vendor Master module "+paymentModes_VIR.get(0) +"/"+paymentModes_VIR.get(1)+" Radio Button is not selected in Vendor Invoice registration Module ");
				Extent_fail(driver, "Not Matched || : "+paymentModes_VM.get(0) +"/"+paymentModes_VM.get(1)+" Radio Button is not selected in Vendor Master module "+paymentModes_VIR.get(0) +"/"+paymentModes_VIR.get(1)+" Radio Button is not selected in Vendor Invoice registration Module ", test, test1);
			}
			
			Step_End(10, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
			Step_Start(11, "Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.", test, test1);

			waitForElement(driver, Payment_Method_VIR);
			String Payment_Method_Value_VIR=getText(driver, Payment_Method_VIR);
			System.out.println("Payment_Method_Value_VIR :"+Payment_Method_Value_VIR);

			if(Payment_Method_Value.equalsIgnoreCase(Payment_Method_Value_VIR)) {
				System.out.println("Matched ||Payment Method Value Taken from Vendor Master Module :"+Payment_Method_Value + "||Payment Method Value Taken from Vendor Invoice registration Module :"+Payment_Method_Value_VIR);
				Extent_pass_New(driver, "Matched ||Payment Method Value Taken from Vendor Master Module :"+Payment_Method_Value + "||Payment Method Value Taken from Vendor Invoice registration Module :"+Payment_Method_Value_VIR, test, test1);
			
				Step_End(11, "Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.", test, test1);

			}else {
				Step_Start(12, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

				waitForElement(driver, Payment_Method_VIR);
				click(driver, Payment_Method_VIR);
				formatLocatorClick(driver, DropDown_Select, Payment_method);
				Step_End(12, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

			}

			if(!Home_ROE.trim().equalsIgnoreCase("")) {
				waitForElement(driver, home_ROE_Textfield_VIR);
				clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
			}
			
			Step_Start(13, "In the Activity details, Click Activity type dropdown and select the activity type as a \"CAR\"", test, test1);
			
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);
			formatLocatorClick(driver, DropDown_Select, activityType);
			
			waitForElement(driver, vendor_Contract_Typedd);
			click(driver, vendor_Contract_Typedd);
			formatLocatorClick(driver, DropDown_Select, contractType);
			
			String actualDescription=String.format(ActivityType_Radiobutton_VIR, RadioButtonDescription);
			waitForElement(driver, actualDescription);
			
			String actualStatus=getAttribute(driver, actualDescription, "class");

			if(!actualStatus.contains(status_Of_RadioButton)) {
				click(driver, actualDescription);
			}
			
			Step_End(13, "In the Activity details, Click Activity type dropdown and select the activity type as a \"CAR\"", test, test1);
			Step_Start(14, "Select the required CAR No. by using the Add button which is available in the CAR No. field.", test, test1);

			waitForElement(driver, CAR_PLUS_button_VIR);
			click(driver, CAR_PLUS_button_VIR);
			twoColumnSearchWindow(driver, CAR_No_Header, condition, CAR_No_Input);

			Step_End(14, "Select the required CAR No. by using the Add button which is available in the CAR No. field.", test, test1);
			Step_Start(15, "Click the \"+ADD\" button, Details added in the Grid.", test, test1);

			waitForElement(driver, Add_Button_VIR);
			click(driver, Add_Button_VIR);
			
			waitForDisplay(driver, Activity_Table_Gridcell_VIR);
			if(isdisplayed(driver, Activity_Table_Gridcell_VIR)) {
				System.out.println("Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid");
				Extent_pass_New(driver, "Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid");
				Extent_fail(driver, "Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid", test, test1);
			}
			
			Step_End(15, "Click the \"+ADD\" button, Details added in the Grid.", test, test1);
			
//	Tolerance
			moduleNavigate(driver, Tolerance_module);
			
//			waitForElement(driver, filter_Button_AG_Grid_TOL);
//			click(driver, filter_Button_AG_Grid_TOL);
//			
			
			waitForElement(driver, port_Region_Filter_TOL);
			sendKeys(driver, port_Region_Filter_TOL, port_Code);
			
			waitForElement(driver, tolerance_Gridcell_TOL);
			String actual_Tolerance=getText(driver, tolerance_Gridcell_TOL);
			System.out.println("actual_Tolerance : "+actual_Tolerance);
			
			double actualTolerance=getNumberValue(actual_Tolerance);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			
//	Vendor Invoice Reg
			
			
			Step_Start(16, "Edit the Amount greater then Actual amount.", test, test1);

			scrollTop(driver);
			reArrangeAG_GridColumns(driver, AG_Grid_Column_Headers);
			
			waitForElement(driver, invoiceAmount_Gridcell_VIR);
			String actualInvoiceAmt=getText(driver, invoiceAmount_Gridcell_VIR);
			double invoiceAmt=Double.parseDouble(actualInvoiceAmt);
			double edit_Invoice_Amount=Double.parseDouble(additional_Invoice_Amount);
			double editedInvoiceAmount=invoiceAmt+edit_Invoice_Amount;
			String edited_InvoiceAmount=String.valueOf(editedInvoiceAmount);
			doubleClick(driver, invoiceAmount_Gridcell_VIR);
			
			waitForElement(driver, invoiceAmount_Input_Gridcell_VIR);
			clearAndType(driver, invoiceAmount_Input_Gridcell_VIR, edited_InvoiceAmount);
			enter(driver);
			
			Step_End(16, "Edit the Amount greater then Actual amount.", test, test1);
			Step_Start(17, "Extra amount will show in the tolarnce compare the actual amount.", test, test1);

			
			
			double toleranceValue=(actualTolerance/100)*invoiceAmt;
			System.out.println("toleranceValue : "+toleranceValue);
			double toleranceAmount=invoiceAmt+toleranceValue;
			System.out.println("toleranceAmount : "+toleranceAmount);

			
			if(editedInvoiceAmount<=toleranceAmount) {
				waitForElement(driver, tolerance_Amount_Gridcell_VIR);
				String actualToleranceAmt=getText(driver, tolerance_Amount_Gridcell_VIR);
				double actual_ToleranceAmt=Double.parseDouble(actualToleranceAmt);

				if(actual_ToleranceAmt==edit_Invoice_Amount) {
				System.out.println("Matched || Expected Tolerance Amount : "+edit_Invoice_Amount+" || Actual Tolerance Amount : "+actual_ToleranceAmt);
				Extent_pass_New(driver, "Matched || Expected Tolerance Amount : "+edit_Invoice_Amount+" || Actual Tolerance Amount : "+actual_ToleranceAmt, test, test1);
			}else {
				System.out.println("Not Matched || Expected Tolerance Amount : "+editedInvoiceAmount+" || Actual Tolerance Amount : "+actual_ToleranceAmt);
				Extent_fail(driver, "Not Matched || Expected Tolerance Amount : "+edit_Invoice_Amount+" || Actual Tolerance Amount : "+actual_ToleranceAmt, test, test1);
			}
			}else if(editedInvoiceAmount>toleranceAmount) {
				waitForElement(driver, dispute_Amount_Gridcell_VIR);
				String actualDisputeAmt=getText(driver, dispute_Amount_Gridcell_VIR);
				double actual_DisputeAmt=Double.parseDouble(actualDisputeAmt);
				if(actual_DisputeAmt==edit_Invoice_Amount) {
				System.out.println("Matched || Expected Dispute Amount : "+edit_Invoice_Amount+" || Actual Dispute Amount : "+actual_DisputeAmt);
				Extent_pass_New(driver, "Matched || Expected Dispute Amount : "+edit_Invoice_Amount+" || Actual Dispute Amount : "+actual_DisputeAmt, test, test1);
			}else {
				System.out.println("Not Matched || Expected Dispute Amount : "+edit_Invoice_Amount+" || Actual Dispute Amount : "+actual_DisputeAmt);
				Extent_fail(driver, "Not Matched || Expected Dispute Amount : "+edit_Invoice_Amount+" || Actual Dispute Amount : "+actual_DisputeAmt, test, test1);
			}
			}
			
			Step_End(17, "Extra amount will show in the tolarnce compare the actual amount.", test, test1);
			Step_Start(18, "Click save it save the details and Auto generate the Dispute no ", test, test1);

			scrollTop(driver);
			mouseOverToElement(driver, SaveButton_ToolBar);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			
			waitForPopup(driver, popup_Message, invoiceSaved_Popup);
			String actualPopup=getText(driver, popup_Message);
			
			if(actualPopup.equals(invoiceSaved_Popup)) {
				System.out.println("Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
			}
			
			click(driver, popup_Message_Ok_Button);
			
			 if(editedInvoiceAmount>toleranceAmount) {
				waitForElement(driver, dispute_No_Textfield_VIR);
				String actual_Dispute_No=getAttribute(driver, dispute_No_Textfield_VIR, "value");
				System.out.println("Generarted actual_Dispute_No No : "+actual_Dispute_No);
				if(!actual_Dispute_No.equals("")) {
					System.out.println("Passed || Expected : Dispute No should be generated || Actual : Dispute No is generated || generated Dispute No : "+actual_Dispute_No);
					Extent_pass_New(driver, "Passed || Expected : Dispute No should be generated || Actual : Dispute No is generated || generated Dispute No : "+actual_Dispute_No, test, test1);
				}else {
					System.out.println("Failed || Expected : Dispute No should be generated || Actual : Dispute No is not generated || generated Dispute No : "+actual_Dispute_No);
					Extent_fail(driver, "Failed || Expected : Dispute No should be generated || Actual : Dispute No is not generated || generated Dispute No : "+actual_Dispute_No, test, test1);
				}
			 }
			waitForElement(driver, invoice_Reg_No_Textfield_VIR);
			String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
			System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
			if(!actual_Vendor_Reg_No.equals("")) {
				System.out.println("Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
				Extent_pass_New(driver, "Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
			}else {
				System.out.println("Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
				Extent_fail(driver, "Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
			}
			
			Step_End(18, "Click save it save the details and Auto generate the Dispute no ", test, test1);

			Extent_completed(testCaseName, test, test1);
	}

}
