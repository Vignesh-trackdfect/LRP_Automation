package LRP_Vendor_Invoice_Registration_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC60 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC60(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC60";
		//  Get data from excel sheet	
	        String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String agencyCode = Excel_data.get("AgencyCode");
	        String dropdownCondition = Excel_data.get("DropdownCondition");
			String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
			String vendorCode = Excel_data.get("VendorCode");
	        String additional_Invoice_Amount = Excel_data.get("Additional_Invoice_Amount");
			String vendorInvoiceNumber = Excel_data.get("VendorInvoiceNumber");
			String activityType = Excel_data.get("ActivityType");
			String condition = Excel_data.get("Condition");
			String invoiceSaved_Popup = Excel_data.get("InvoiceSaved_Popup");
			String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
			String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
			String Inv_Date = Excel_data.get("Inv_Date");
			String datePicker = Excel_data.get("datePicker");
			String Inv_Amount = Excel_data.get("Inv_Amount");
			String invoice_ROE = Excel_data.get("invoice_ROE");
			String Disbursement_Currency = Excel_data.get("Disbursement_Currency");			
			String invoice_currency = Excel_data.get("Invoice_currency");
			String Home_ROE = Excel_data.get("Home_ROE");
			String RadioButtonDescription = Excel_data.get("RadioButtonDescription");
			String Status_Of_FDR_Sum_NO_RadioButton = Excel_data.get("Status_Of_FDR_Sum_NO_RadioButton");
			String FDR_Sum_No_Header = Excel_data.get("FDR_Sum_No_Header");
			String FDR_Sum_No_Input = Excel_data.get("FDR_Sum_No_Input");
			String AG_Grid_Column_Headers = Excel_data.get("AG_Grid_Column_Headers");

			String Factor_payee_searchType = Excel_data.get("Factor_payee_searchType");
			String Factor_payee_Input = Excel_data.get("Factor_payee_Input");

			
			
			Extent_Start(testCaseName, test, test1);
			navigateUrl(driver, url);

			// Login
			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			SwitchProfile(driver, agencyCode);
			
//			Vendor Invoice Registration
			
			Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

			moduleNavigate(driver, moduleName);

			Step_End(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

			Step_Start(2, "Click the Vendor code search button", test, test1);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			Step_End(2, "Click the Vendor code search button", test, test1);
			Step_Start(3, "It shows the approved vendor based on the vendor master.", test, test1);
			Step_Start(4, "Select the Required vendor code and name.", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			Step_End(3, "It shows the approved vendor based on the vendor master.", test, test1);
			Step_End(4, "Select the Required vendor code and name.", test, test1);

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
					twoColumnSearchWindow(driver, Factor_payee_searchType, condition, Factor_payee_Input);
					
				}
				
				Step_Start(5, "Click the Vendor invoice field.", test, test1);

		// Vendor invoice number		
			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			click(driver, Vendor_Invoice_Number_Input_VIR);
			
			Step_End(5, "Click the Vendor invoice field.", test, test1);
			Step_Start(6, "Enter the value up to 25 characters.", test, test1);
			
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);
			
			Step_End(6, "Enter the value up to 25 characters.", test, test1);
	
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
				
				Step_Start(7, "Click the Disburse currency dropdown", test, test1);

				if(!Disbursement_Currency.trim().equalsIgnoreCase("")) {
					waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
					click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
					
					Step_End(7, "Click the Disburse currency dropdown", test, test1);
					Step_Start(8, "Select the Require currency.", test, test1);

					String currency_select =  String.format(DropDown_Select, Disbursement_Currency); 
					waitForElement(driver, currency_select);
					click(driver, currency_select);
					
					Step_End(8, "Select the Require currency.", test, test1);
				}
				
				Step_Start(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
				
				if(!Home_ROE.trim().equalsIgnoreCase("")) {
					waitForElement(driver, home_ROE_Textfield_VIR);
					clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
				}
				
				Step_Start(12, "In the Activity details, Click Activity type dropdown and select the activity type as a \"FDR\"", test, test1);
			
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);

			String select_ActivityType=String.format(DropDown_Select, activityType);
			waitForElement(driver, select_ActivityType);
			click(driver, select_ActivityType);
			
			Step_End(12, "In the Activity details, Click Activity type dropdown and select the activity type as a \"FDR\"", test, test1);
			Step_Start(13, "Default system select the FDR sum no.", test, test1);

			String actualDescription=String.format(ActivityType_Radiobutton_VIR, RadioButtonDescription);
			waitForElement(driver, actualDescription);
			
			String actualStatus=getAttribute(driver, actualDescription, "class");
			if(actualStatus.contains(Status_Of_FDR_Sum_NO_RadioButton)) {
				System.out.println("Matched || Expected : Fdr Sum No Radio Button should be selected || Actual : Fdr Sum No Radio Button is selected");
				Extent_pass_New(driver, "Matched || Expected : Fdr Sum No Radio Button should be selected || Actual : Fdr Sum No Radio Button is selected", test, test1);
			}
			else {
				System.out.println("Not Matched || Expected : Fdr Sum No Radio Button should be selected || Actual : Fdr Sum No Radio Button is not selected");
				Extent_fail(driver, "Not Matched || Expected : Fdr Sum No Radio Button should be selected || Actual : Fdr Sum No Radio Button is not selected", test, test1);
			}			
			Step_End(13, "Default system select the FDR sum no.", test, test1);
			Step_Start(14, "Select the  FDR sum no.", test, test1);

			waitForElement(driver, sum_No_Add_Button_VIR);
			click(driver, sum_No_Add_Button_VIR);
			
			twoColumnSearchWindow(driver, FDR_Sum_No_Header, condition, FDR_Sum_No_Input);
			
			Step_End(14, "Select the  FDR sum no.", test, test1);

			Step_Start(15, "Click the \"+ADD\" button, Details added in the Grid.", test, test1);

			waitForElement(driver, Add_Button_VIR);
			click(driver, Add_Button_VIR);
			
			scrollBottom(driver);
			
			waitForDisplay(driver, Activity_Table_Gridcell_VIR);
			if(isdisplayed(driver, Activity_Table_Gridcell_VIR)) {
				System.out.println("Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid");
				Extent_pass_New(driver, "Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid");
				Extent_fail(driver, "Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid", test, test1);
			}
			Step_End(15, "Click the \"+ADD\" button, Details added in the Grid.", test, test1);

			
			Step_Start(16, "Edit the Amount greater then Actual amount.Extra amount will show in the Dispute cloumn", test, test1);
			
			
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
			
			Step_End(16, "Edit the Amount greater then Actual amount.Extra amount will show in the Dispute cloumn", test, test1);

			Step_Start(17, "Click save it save the details and Auto generate the Dispute no ", test, test1);
			
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
			
			Step_End(17, "Click save it save the details and Auto generate the Dispute no ", test, test1);


			Extent_completed(testCaseName, test, test1);
	}

}
