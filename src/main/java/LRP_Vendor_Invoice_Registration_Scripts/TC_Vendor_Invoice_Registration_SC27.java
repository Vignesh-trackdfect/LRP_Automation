package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC27 extends Keywords{

	public void Vendor_Invoice_Registration_SC27(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
	
		String testCaseName = "TC_Vendor_Invoice_Registration_SC27";
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
		String Disbursement_Currency = Excel_data.get("Disbursement_Currency");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Payment_method = Excel_data.get("Payment_method");
		String invoice_currency = Excel_data.get("Invoice_currency");
		String Home_ROE = Excel_data.get("Home_ROE");
		String Hlg_SumNo_Header = Excel_data.get("Hlg_SumNo_Header");
		String Hlg_SumNo_Header_Value = Excel_data.get("Hlg_SumNo_Header_Value");
		String Grid_value= Excel_data.get("Grid_value");
		String Haulage_Expense_Report_module= Excel_data.get("Haulage_Expense_Report_module");
		String Approved= Excel_data.get("Approved");
		String invoiceSaved_Popup= Excel_data.get("InvoiceSaved_Popup");
		String Hlg_SumNo= Excel_data.get("Hlg_SumNo");
		String haulage_grid= Excel_data.get("haulage_grid");

		Extent_Start(testCaseName, test, test1);
        navigateUrl(driver, url);

		// Login
		
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		
		Step_Start(1, "Select the Load Agency based on the Expense Report ", test, test1);
		SwitchProfile(driver, agencyCode);
		Step_End(1, "Select the Load Agency based on the Expense Report ", test, test1);
		
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
		
		if(!Disbursement_Currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			
			String invoice_select =  String.format(DropDown_Select, Disbursement_Currency); 
			click(driver, invoice_select);
			
		}
		Step_End(8, "Click the Disburse currency dropdown", test, test1);	
		Step_End(9, "Select the Require currency", test, test1);	
		
		Step_Start(10, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);	
		Step_Start(11, "Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master", test, test1);	
		
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
		Step_Start(12, "In the Activity details, Click Activity type dropdown and select the activity type as a \"HCN\"", test, test1);	

			
		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		
		String select_ActivityType=String.format(DropDown_Select, activityType);
		waitForElement(driver, select_ActivityType);
		click(driver, select_ActivityType);
		
		Step_End(12, "In the Activity details, Click Activity type dropdown and select the activity type as a \"HCN\"", test, test1);	
		
		Step_Start(13, "Click the Hlg sum no search and select the Required no", test, test1);	
		
		waitForElement(driver, Vendor_Invoice_HCN_Plus);
		click(driver, Vendor_Invoice_HCN_Plus);
		twoColumnSearchWindow(driver, Hlg_SumNo, condition, Hlg_SumNo_Header_Value);

		Step_End(13, "Click the Hlg sum no search and select the Required no", test, test1);	
		
		Step_Start(14, "Click the \"+ADD\" button, Details added in the Grid", test, test1);	
		
		
		
		waitForElement(driver, Vendor_Invoice_HCN_Add_button);
		click(driver, Vendor_Invoice_HCN_Add_button);
		
		Step_End(14, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		scrollBottom(driver);
	
		reArrangeAG_GridColumns(driver, Grid_value);
		        
        waitForElement(driver, Vendor_Invoice_Activity_Ref_Number);
		String Activity_Ref_No_Value =getText(driver, Vendor_Invoice_Activity_Ref_Number);
        System.out.println("Activity_Ref_No_Value :"+ Activity_Ref_No_Value);
   
	    String [] splittedValue=Activity_Ref_No_Value.split("-");
	    System.out.println("splittedValue 1 : "+splittedValue[0]);
	    
	    scrollTop(driver);
       Step_Start(15, "Click the save while in draft", test, test1);
		mouseOverToElement(driver, SaveButton_ToolBar);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(15, "Click the save while in draft", test, test1);
		
		waitForElement(driver, popup_Message_Ok_Button);
		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
				
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
		
		Step_Start(15, "It auto generate the Invoice Reg No", test, test1);

		waitForElement(driver, invoice_Reg_No_Textfield_VIR);
		String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
		System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
		if(!actual_Vendor_Reg_No.equals("")) {
			System.out.println("Passed || Expected Result is : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_pass_New(driver, "Passed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No, test, test1);
		}else {
			System.out.println("Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_fail(driver, "Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No  is : "+actual_Vendor_Reg_No, test, test1);
		}
		
		
		Step_End(15, "It auto generate the Invoice Reg No", test, test1);
			
			ResetProfile(driver);
			waitForDisplay(driver, popup_Message_Ok_Button);
			if(isdisplayed(driver, popup_Message_Ok_Button)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			}
			
	        moduleNavigate(driver, Haulage_Expense_Report_module);
			
			waitForElement(driver, New_Button_HER);
			click(driver, New_Button_HER);
			
			waitForElement(driver, SearchButton_Toolbar);
			jsClick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, Hlg_SumNo_Header, splittedValue[0], "", "", "", "");
			
			waitForElement(driver, HER_Approved);
			String approved_act =getText(driver, HER_Approved);
			
			if(Approved.equals(approved_act)) {
				System.out.println("Matched || Expected : Haulage Expense Status message should be display : "+Approved+" || Actual : Haulage Expense Status message Is displayed "+approved_act);
				Extent_pass(driver, "Matched || Expected : Haulage Expense Status message should be display : "+Approved+" || Actual : Haulage Expense Status message Is displayed "+approved_act, test, test1);
			}else {
				System.out.println("Not Matched || Expected : Haulage Expense Status message should be display : "+Approved+" || Actual : Haulage Expense Status message Is Not displayed "+approved_act);
				Extent_fail(driver, "Not Matched || Expected : Haulage Expense Status message should be display : "+Approved+" || Actual : Haulage Expense Status message Is Not displayed "+approved_act, test, test1);
			}
			
			waitForElement(driver, HER_Expense_Summary);
			click(driver, HER_Expense_Summary);
			
			waitForElement(driver, EXP_Condition_Filter);
			click(driver, EXP_Condition_Filter);
			
			reArrangeAG_GridColumns(driver, haulage_grid);
			
			waitForElement(driver, EXP_RefNo_input);
			sendKeys(driver, EXP_RefNo_input, Activity_Ref_No_Value);
			
			waitForDisplay(driver, Hlg_Sum_Ref_No_ExpenseSummary);
			if(isdisplayed(driver, Hlg_Sum_Ref_No_ExpenseSummary)) {
				System.out.println("Expected : Haulage Activity Ref Number '"+Activity_Ref_No_Value+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+Activity_Ref_No_Value+"' is displayed in the Haulage Summary Table ");
				Extent_pass_New(driver, "Expected : Haulage Activity Ref Number '"+Activity_Ref_No_Value+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+Activity_Ref_No_Value+"' is displayed in the Haulage Summary Table ", test, test1);
			}else {
				System.out.println("Expected : Haulage Activity Ref Number '"+Activity_Ref_No_Value+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+Activity_Ref_No_Value+"' is not displayed in the Haulage Summary Table ");
				Extent_fail(driver, "Expected : Haulage Activity Ref Number '"+Activity_Ref_No_Value+"' Should be displayed in the Haulage Summary Table || Actual : Haulage Activity Ref No '"+Activity_Ref_No_Value+"' is not displayed in the Haulage Summary Table ", test, test1);
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
