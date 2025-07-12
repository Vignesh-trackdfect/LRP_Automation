package LRP_Finance_Supplier_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;




public class TC_Supplier_Invoice_S12  extends Keywords{

	public void  Supplier_Invoice_S12(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Supplier_Invoice_S12";
		

		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String Field_Names =Excel_data.get("Field_Names");
		String Activity_date_perform =Excel_data.get("Activity_date_perform");
		String activity_Date_Input =Excel_data.get("activity_Date_Input");
		String invoice_date_perform =Excel_data.get("invoice_date_perform");
		String invoice_Date_Input =Excel_data.get("invoice_Date_Input");
		String Due_date_perform =Excel_data.get("Due_date_perform");
		String Due_Date_Input =Excel_data.get("Due_Date_Input");
		String Nomination_name =Excel_data.get("Nomination_name");
		String Nomination_Amount =Excel_data.get("Nomination_Amount");
		String Currency_code =Excel_data.get("Currency_code");
		String Billing_popup =Excel_data.get("Billing_popup");
		String vendor_name = Excel_data.get("vendor_code");
		String supplier_input_value = Excel_data.get("supplier_input_value");
		String SupplierInv_input_value = Excel_data.get("SupplierInv_input_value");
		String supplier_area_input_value = Excel_data.get("supplier_area_input_value");
		String supplier_factor_payee_input_value = Excel_data.get("supplier_factor_payee_input_value");
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
		LRP_Login(driver, username, pass_word);

		moduleNavigate(driver, Field_Names);
		
		Step_Start(1, " Click on New button in toolbar ", test, test1);

       newButton(driver);
       
		Step_End(1, " Click on New button in toolbar ", test, test1);


		Step_Start(2, "Select the Activity date from the date picker .", test, test1);
		waitForElement(driver, supplier_invoice_activity_date);
		if (Activity_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, supplier_invoice_activity_date, activity_Date_Input);
			
		} else {
			waitForElement(driver, supplier_invoice_activity_date);
			clearAndType(driver, supplier_invoice_activity_date, activity_Date_Input);
		}
		Step_End(2, "Select the Activity date from the date picker .", test, test1);

		Step_Start(3, "Select the Invoice date from the date picker. .", test, test1);
		waitForElement(driver, supplier_invoice_invoice_date);
		
		if (invoice_date_perform.equalsIgnoreCase("Yes")) {		
			selectDatePicker(driver, supplier_invoice_invoice_date, invoice_Date_Input);
			
		} else {
			waitForElement(driver, supplier_invoice_invoice_date);
			clearAndType(driver, supplier_invoice_invoice_date, invoice_Date_Input);
		}
		Step_End(3, "Select the Invoice date from the date picker. .", test, test1);
		Step_Start(4, "Select the Due date from the date picker.", test, test1);
		waitForElement(driver, supplier_invoice_Due_date);
		if (Due_date_perform.equalsIgnoreCase("Yes")) {
			
			selectDatePicker(driver, supplier_invoice_Due_date, Due_Date_Input);
		
		} else {
			waitForElement(driver, supplier_invoice_Due_date);
			clearAndType(driver, supplier_invoice_Due_date, Due_Date_Input);
		}
		Step_End(4, "Select the Due date from the date picker.", test, test1);


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

		Step_Start(5, "Select the vendor.", test, test1);
		
		waitForDisplay(driver, Supplier_vendor_search_button);
		if(isdisplayed(driver, Supplier_vendor_search_button)&&!vendor_name.equals("")) {
		Step_Start(5, "Select the vendor.", test, test1);
		
		waitForElement(driver, Supplier_vendor_search_button);
		click(driver,Supplier_vendor_search_button);
		
		twoColumnSearchWindow(driver, Vendor_Code_Header, dropdownCondition, vendor_name);
		
		Step_End(5, "Select the vendor.", test, test1);
		}
		
		waitForDisplay(driver, Supplier_payment_search);
		if(isdisplayed(driver, Supplier_payment_search)&&!supplier_input_value.equals("")) {
		waitForElement(driver, Supplier_payment_search);
		click(driver,Supplier_payment_search);
		twoColumnSearchWindow(driver, Payment_Code_Header, dropdownCondition, supplier_input_value);
		}
		

		waitForDisplay(driver, Supplier_factor_payee_search);
		if(isdisplayed(driver, Supplier_factor_payee_search)&&!supplier_factor_payee_input_value.equals("")) {
		waitForElement(driver, Supplier_factor_payee_search);
		click(driver,Supplier_factor_payee_search);
		twoColumnSearchWindow(driver, Factor_Payee_Header, dropdownCondition, supplier_factor_payee_input_value);
		}
		

		Step_Start(6, "Based on your activity date open period will automatically changed. ", test, test1);
		waitForElement(driver, Supplier_open_peroid);
		String open_period_value = getText(driver, Supplier_open_peroid);
		System.out.println(open_period_value);
		Extent_call(test, test1, "**open period shows***"+open_period_value);
		Step_End(6, "Based on your activity date open period will automatically changed. ", test, test1);
		Step_Start(7, "Select the Area", test, test1);
		
		waitForDisplay(driver, Supplier_Area_search);
		if(isdisplayed(driver, Supplier_Area_search)&&!supplier_area_input_value.equals("")) {
		waitForElement(driver, Supplier_Area_search);
		click(driver,Supplier_Area_search);
		twoColumnSearchWindow(driver, Area_Master_Header, dropdownCondition, supplier_area_input_value);
		}
		
		
		Step_End(7, "Select the Area", test, test1);
		Step_Start(8, "Select the dr/cr in that dropdown list ", test, test1);
		waitForElement(driver, Supplier_Dr_cr_droupdwn);
		click(driver,Supplier_Dr_cr_droupdwn);
		waitForElement(driver, select_dr);
		click(driver,select_dr);
		Step_End(8, "Select the dr/cr in that dropdown list ", test, test1);
		Step_Start(9, "Select the nominal from the search button for Dr.", test, test1);

		waitForDisplay(driver, Supplier_nomination_search);
		if(isdisplayed(driver, Supplier_nomination_search)&&!Nomination_name.equals("")) {
		waitForElement(driver, Supplier_nomination_search);
		click(driver,Supplier_nomination_search);
		twoColumnSearchWindow(driver, Search_Nominals_Header, dropdownCondition, Nomination_name);
		}
		
		Step_End(9, "Select the nominal from the search button for Dr.", test, test1);
		Step_Start(10, "Enter the valid amount in amount text field for Dr.", test, test1);
		waitForElement(driver, Supplier_amount_field);
		doubleClick(driver, Supplier_amount_field);
		Actionsendkeys(driver, Supplier_amount_field, Nomination_Amount);
		click(driver, Home_amount1);
		
		Step_End(10, "Enter the valid amount in amount text field for Dr.", test, test1);
		Step_Start(11, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change", test, test1);
		
		waitForDisplay(driver, Supplier_currency_search);
		if(isdisplayed(driver, Supplier_currency_search)&&!Currency_code.equals("")) {
		waitForElement(driver, Supplier_currency_search);
		click(driver,Supplier_currency_search);
		twoColumnSearchWindow(driver, Currency_Details_Header, dropdownCondition, Currency_code);
		}
		

		Step_End(11, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change", test, test1);
		Step_Start(12, "Click + button to add the nominals in the grid.", test, test1);
		
		waitForElement(driver, Supplier_Gird_add_button);
		click(driver,Supplier_Gird_add_button);
		
		Step_End(12, "Click + button to add the nominals in the grid.", test, test1);
		Step_Start(13, "System should show the validation as \"Enter the Description\"", test, test1);
		
		waitForPopup(driver, popup_Message,Billing_popup);
		String Actualpopmsg = getText(driver, popup_Message);
		System.out.println(Actualpopmsg);

		if (Billing_popup.equals(Actualpopmsg)) {
			System.out.println("Matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched || " + " Expected popup  value should be display in the Suplier invoice Screen: " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg, test, test1);
			Extent_call(test, test1, Actualpopmsg);
		} else {
			System.out.println("Not matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg);
			Extent_fail(driver, "Not matched || " + "Expected popup  value should be display in the Suplier invoice Screen : " + Billing_popup+ " || Actual popup Dispaly in the Suplier invoice Screen: " + Actualpopmsg, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(13, "System should show the validation as \"Enter the Description\"", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
