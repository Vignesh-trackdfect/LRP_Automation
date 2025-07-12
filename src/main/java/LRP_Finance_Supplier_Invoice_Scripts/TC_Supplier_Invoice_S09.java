package LRP_Finance_Supplier_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Supplier_Invoice_S09  extends Keywords{

	public void  Supplier_Invoice_S09(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Supplier_Invoice_S09";
		
		
		String username = Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String Field_Names =Excel_data.get("Field_Names");
		String Activity_date_perform =Excel_data.get("Activity_date_perform");
		String activity_Date_Input =Excel_data.get("activity_Date_Input");
		String invoice_date_perform =Excel_data.get("invoice_date_perform");
		String invoice_Date_Input =Excel_data.get("invoice_Date_Input");
		String Due_date_perform =Excel_data.get("Due_date_perform");
		String Due_Date_Input =Excel_data.get("Due_Date_Input");
		String Discription_input =Excel_data.get("Discription_input");
		String Nomination_name =Excel_data.get("Nomination_name");
		String Nomination_Amount =Excel_data.get("Nomination_Amount");
		String Currency_code =Excel_data.get("Currency_code");
		String Billing_popup =Excel_data.get("Billing_popup");
		String vendor_name = Excel_data.get("vendor_code");
		String supplier_input_value = Excel_data.get("supplier_input_value");
		String SupplierInv_input_value = Excel_data.get("SupplierInv_input_value");
		String supplier_area_input_value = Excel_data.get("supplier_area_input_value");
		String supplier_factor_payee_input_value = Excel_data.get("supplier_factor_payee_input_value");
		String Limit_Of_Reference_Field_Input = Excel_data.get("Limit_Of_Reference_Field_Input");
		String Reference_Field_Input = Excel_data.get("Reference_Field_Input");
		String Vendor_Code_Header  = Excel_data.get("Vendor_Code_Header");
		String Payment_Code_Header  = Excel_data.get("Payment_Code_Header");
		String Factor_Payee_Header  = Excel_data.get("Factor_Payee_Header");
		String Area_Master_Header  = Excel_data.get("Area_Master_Header");
		String Search_Nominals_Header  = Excel_data.get("Search_Nominals_Header");
		String Currency_Details_Header  = Excel_data.get("Currency_Details_Header");
		String dropdownCondition =Excel_data.get("dropdownCondition");
		String Refer_Input = Excel_data.get("Refer_Input");	
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, password);

		moduleNavigate(driver, Field_Names);

		Step_Start(1, "Click new on toolbar", test, test1);
		
		newButton(driver);
		
		Step_End(1, "Click new on toolbar", test, test1);

	
		Step_Start(2, "Select the activity date from the date picker which is greater than the current date", test, test1);
		waitForElement(driver, supplier_invoice_activity_date);
		if (Activity_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, supplier_invoice_activity_date, activity_Date_Input);
			
		} else {
			waitForElement(driver, supplier_invoice_activity_date);
			clearAndType(driver, supplier_invoice_activity_date, activity_Date_Input);
		}
		Step_End(2, "Select the activity date from the date picker which is greater than the current date", test, test1);

		Step_Start(3, "Select the trans date from the date picker which is less than the current date ", test, test1);
		waitForElement(driver, supplier_invoice_invoice_date);
		if (invoice_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, supplier_invoice_invoice_date, invoice_Date_Input);
			
		} else {
			waitForElement(driver, supplier_invoice_invoice_date);
			clearAndType(driver, supplier_invoice_invoice_date, invoice_Date_Input);
		}
		Step_End(3, "Select the trans date from the date picker which is less than the current date ", test, test1);
		Step_Start(4, "Select the due date from the date picker which is more or less than the current date", test, test1);
		waitForElement(driver, supplier_invoice_Due_date);
		if (Due_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, supplier_invoice_Due_date, Due_Date_Input);
			
		} else {
			waitForElement(driver, supplier_invoice_Due_date);
			clearAndType(driver, supplier_invoice_Due_date, Due_Date_Input);
		}
		Step_End(4, "Select the due date from the date picker which is more or less than the current date", test, test1);
		
		
		waitForDisplay(driver, SupplierInv_input);
		if(isdisplayed(driver, SupplierInv_input)&&!SupplierInv_input_value.equals("")) {
		 waitForElement(driver, SupplierInv_input);
         sendKeys(driver, SupplierInv_input, SupplierInv_input_value);
		}
		
		waitForDisplay(driver, SI_Refernce_Input);
		if(isdisplayed(driver, SI_Refernce_Input)&&!Refer_Input.equals("")) {
			 waitForElement(driver, SI_Refernce_Input);
			 sendKeys(driver, SI_Refernce_Input, Refer_Input);
		}
		
		
		waitForDisplay(driver, Supplier_payment_search);
		if(isdisplayed(driver, Supplier_payment_search)&&!supplier_input_value.equals("")) {
		waitForElement(driver, Supplier_payment_search);
		click(driver,Supplier_payment_search);
		twoColumnSearchWindow(driver, Payment_Code_Header, dropdownCondition, supplier_input_value);
		}
		

		

		waitForDisplay(driver, Supplier_Area_search);
		if(isdisplayed(driver, Supplier_Area_search)&&!supplier_area_input_value.equals("")) {
		waitForElement(driver, Supplier_Area_search);
		click(driver,Supplier_Area_search);
		twoColumnSearchWindow(driver, Area_Master_Header, dropdownCondition, supplier_area_input_value);
		}
		
		waitForDisplay(driver, Supplier_factor_payee_search);
		if(isdisplayed(driver, Supplier_factor_payee_search)&&!supplier_factor_payee_input_value.equals("")) {
		waitForElement(driver, Supplier_factor_payee_search);
		click(driver,Supplier_factor_payee_search);
		twoColumnSearchWindow(driver, Factor_Payee_Header, dropdownCondition, supplier_factor_payee_input_value);
		}
		
		waitForDisplay(driver, Supplier_vendor_search_button);
		if(isdisplayed(driver, Supplier_vendor_search_button)&&!vendor_name.equals("")) {
		Step_Start(5, "Select the vendor.", test, test1);
		
		waitForElement(driver, Supplier_vendor_search_button);
		click(driver,Supplier_vendor_search_button);
		
		twoColumnSearchWindow(driver, Vendor_Code_Header, dropdownCondition, vendor_name);
		
		Step_End(5, "Select the vendor.", test, test1);
		}

		Step_Start(6, "Enter  Alphanumeric characters or only numerical values upto (46) characters in that OriginalRef field", test, test1);
		waitForElement(driver, reference_Text_Field_SI);
		sendKeys(driver, reference_Text_Field_SI, Reference_Field_Input);
		waitForElement(driver, reference_Text_Field_SI);
		String reference_Field_Charecter_Count = getAttribute(driver, reference_Text_Field_SI,"value");
		int total_Reference_Field_Input = reference_Field_Charecter_Count.length();
		int exp_Limit_Of_Reference_Field_Input = Integer.parseInt(Limit_Of_Reference_Field_Input);
		
		if(exp_Limit_Of_Reference_Field_Input>=total_Reference_Field_Input) {
			System.out.println("Matched ||  Expected : Once Enter  Alphanumeric characters or only numerical values upto (46) characters Should be  OriginalRef field : "+exp_Limit_Of_Reference_Field_Input+" || Actual : Once Enter  Alphanumeric characters or only numerical values upto (46) characters is  OriginalRef field: "+total_Reference_Field_Input);
			Extent_pass_New(driver,"Matched || Expected : Once Enter  Alphanumeric characters or only numerical values upto (46) characters Should be  OriginalRef field : "+exp_Limit_Of_Reference_Field_Input+" || Actual : Once Enter  Alphanumeric characters or only numerical values upto (46) characters is  OriginalRef field : "+total_Reference_Field_Input, test, test1);
		}else {
			System.out.println("Not Matched || Expected : Once Enter  Alphanumeric characters or only numerical values upto (46) characters Should be  OriginalRef field : "+exp_Limit_Of_Reference_Field_Input+" || Actual : Once Enter  Alphanumeric characters or only numerical values upto (46) characters is not OriginalRef field : "+total_Reference_Field_Input);
			Extent_fail(driver,"Not Matched || Expected : Once Enter  Alphanumeric characters or only numerical values upto (46) characters Should be  OriginalRef field : "+exp_Limit_Of_Reference_Field_Input+" || Actual : Once Enter  Alphanumeric characters or only numerical values upto (46) characters is not OriginalRef field : "+total_Reference_Field_Input, test, test1);
		}
		Step_End(6, "Enter  Alphanumeric characters or only numerical values upto (46) characters in that OriginalRef field", test, test1);
		Step_Start(7, "Based on your activity date open period will automatically changed", test, test1);
		waitForElement(driver, Supplier_open_peroid);
		String open_period_value = getText(driver, Supplier_open_peroid);
		System.out.println(open_period_value);
		Extent_call(test, test1, "**open period shows***"+open_period_value);
		Step_End(7, "Based on your activity date open period will automatically changed", test, test1);

		Step_Start(8, "Enter Alphanumeric characters in description field ", test, test1);
		
		waitForDisplay(driver, Supplier_Discription_input);
		if(isdisplayed(driver, Supplier_Discription_input)&&!Discription_input.equals("")) {
		
		waitForElement(driver, Supplier_Discription_input);
		sendKeys(driver, Supplier_Discription_input, Discription_input);
		
		}
		Step_End(8, "Enter Alphanumeric characters in description field ", test, test1);
		Step_Start(9, "Select the dr/cr in that dropdown list ", test, test1);
		waitForElement(driver, Supplier_Dr_cr_droupdwn);
		click(driver,Supplier_Dr_cr_droupdwn);
		waitForElement(driver, select_dr);
		click(driver,select_dr);

		waitForDisplay(driver, Supplier_nomination_search);
		if(isdisplayed(driver, Supplier_nomination_search)&&!Nomination_name.equals("")) {
		waitForElement(driver, Supplier_nomination_search);
		click(driver,Supplier_nomination_search);
		twoColumnSearchWindow(driver, Search_Nominals_Header, dropdownCondition, Nomination_name);
		}
		
		
		waitForDisplay(driver, Supplier_payment_search);
		if(isdisplayed(driver, Supplier_payment_search)&&!supplier_input_value.equals("")) {
		waitForElement(driver, Supplier_payment_search);
		click(driver,Supplier_payment_search);
		twoColumnSearchWindow(driver, Payment_Code_Header, dropdownCondition, supplier_input_value);
		}
		

		
		
		
		
		waitForDisplay(driver, Supplier_currency_search);
		if(isdisplayed(driver, Supplier_currency_search)&&!Currency_code.equals("")) {
		waitForElement(driver, Supplier_currency_search);
		click(driver,Supplier_currency_search);
		twoColumnSearchWindow(driver, Currency_Details_Header, dropdownCondition, Currency_code);
		}
		
		waitForElement(driver, Supplier_amount_field);
		doubleClick(driver, Supplier_amount_field);
		Actionsendkeys(driver, Supplier_amount_field, Nomination_Amount);
		click(driver, Home_amount1);
		Step_End(9, "Select the dr/cr in that dropdown list ", test, test1);
		Step_Start(10, "Click + button to add the nominals in the grid", test, test1);
		
		waitForElement(driver, Supplier_Gird_add_button);
		click(driver,Supplier_Gird_add_button);
		
		Step_End(10, "Click + button to add the nominals in the grid", test, test1);
		Step_End(11, "It shows the validation \"The Activity Date must be less than or equal to Invoice Date\"", test, test1);

	
		waitForPopup(driver, popup_Message,Billing_popup);
		String Actualpopmsg = getText(driver, popup_Message);
		
		System.out.println(Actualpopmsg);
		if (Billing_popup.equals(Actualpopmsg)) {
			System.out.println("Matched || " + "Expected popup  value should be display in the Suplier invoice Screen : " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen  : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen  : " + Actualpopmsg, test, test1);
			Extent_call(test, test1, Actualpopmsg);
		} else {
			System.out.println("Not matched || " + " Expected popup  value should be display in the Suplier invoice Screen: " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen  : " + Actualpopmsg);
			Extent_fail(driver, "Not matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen  : " + Actualpopmsg, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(11, "It shows the validation The Activity Date must be less than or equal to Invoice Date\"", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
