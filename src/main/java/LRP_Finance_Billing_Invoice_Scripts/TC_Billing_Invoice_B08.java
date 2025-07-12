package LRP_Finance_Billing_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Billing_Invoice_B08  extends Keywords {
	public void  Billing_Invoice_B08(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Billing_Invoice_B08";
		


		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
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
		String Billing_date_popup =Excel_data.get("Billing_date_popup");
		String customer_name =Excel_data.get("customer_name");	
		String Customer_Select_Header = Excel_data.get("Customer_Select_Header");
		String Customer_Select_Condition = Excel_data.get("Customer_Select_Condition");
		String Nominal_Select_Header = Excel_data.get("Nominal_Select_Header");
		String Nominal_Select_Condition = Excel_data.get("Nominal_Select_Condition");
		String CurrencyCode_Select_Header = Excel_data.get("CurrencyCode_Select_Header");
		String CurrencyCode_Select_Condition = Excel_data.get("CurrencyCode_Select_Condition");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Field_Names);
		Step_Start(1, " Click on New button in toolbar ", test, test1);
	    newButton(driver);
		Step_End(1, " Click on New button in toolbar ", test, test1);
		

		Step_Start(2, "Select the Activity date from the date picker .", test, test1);
		waitForElement(driver, billing_invoice_activity_date);
		if (Activity_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_activity_date, activity_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_activity_date);
			clearAndType(driver, billing_invoice_activity_date, activity_Date_Input);
		}
		Step_End(2, "Select the Activity date from the date picker .", test, test1);
	
		Step_Start(3, "Select the Invoice date from the date picker. .", test, test1);
		waitForElement(driver, billing_invoice_invoice_date);
		if (invoice_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_invoice_date, invoice_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_invoice_date);
			clearAndType(driver, billing_invoice_invoice_date, invoice_Date_Input);
		}
		Step_End(3, "Select the Invoice date from the date picker. .", test, test1);
		Step_Start(4, " Select the due date from the date picker which is more or less than the current date", test, test1);
		waitForElement(driver, billing_invoice_Due_date);
		if (Due_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_Due_date, Due_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_Due_date);
			clearAndType(driver, billing_invoice_Due_date, Due_Date_Input);
		}
		Step_End(4, " Select the due date from the date picker which is more or less than the current date", test, test1);
		
		Step_Start(5, "Select the customer.", test, test1);
		waitForDisplay(driver, billing_customer_search_button);
		if(isdisplayed(driver, billing_customer_search_button)&&!customer_name.equals("")) {
		waitForElement(driver, billing_customer_search_button);
		click(driver,billing_customer_search_button);
		twoColumnSearchWindow(driver, Customer_Select_Header, Customer_Select_Condition, customer_name);
		}
		
		Step_End(5, "Select the customer.", test, test1);
		
		Step_Start(7, "Based on your activity date open period will automatically changed. ", test, test1);
		waitForElement(driver, open_peroid);
		String open_period_value = getAttribute(driver, open_peroid,"value");
		System.out.println(open_period_value);
		Extent_call(test, test1, "**open period shows***"+open_period_value);
		Step_End(7, "Based on your activity date open period will automatically changed. ", test, test1);
		
		Step_Start(8, "Enter Alphanumeric characters in description field ", test, test1);
		
		
		waitForDisplay(driver, billing_Discription_input);
		if(isdisplayed(driver, billing_Discription_input)&&!Discription_input.equals("")) {
		waitForElement(driver, billing_Discription_input);
		sendKeys(driver, billing_Discription_input, Discription_input);
		
		}
		
		Step_End(8, "Enter Alphanumeric characters in description field ", test, test1);
	
		Step_Start(9, "Select the dr/cr in that dropdown list ", test, test1);
		waitForElement(driver, billing_Dr_cr_droupdwn);
		click(driver,billing_Dr_cr_droupdwn);
		waitForElement(driver, select_dr);
		click(driver,select_dr);
		Step_End(9, "Select the dr/cr in that dropdown list ", test, test1);
	
	
		waitForDisplay(driver, nomination_search);
		if(isdisplayed(driver, nomination_search)&&!Nomination_name.equals("")) {
		waitForElement(driver, nomination_search);
		click(driver,nomination_search);
		twoColumnSearchWindow(driver, Nominal_Select_Header, Nominal_Select_Condition, Nomination_name);
		}
	
		waitForDisplay(driver, currency_search);
		if(isdisplayed(driver, currency_search)&&!Currency_code.equals("")) {
		waitForElement(driver, currency_search);
		click(driver,currency_search);
		twoColumnSearchWindow(driver, CurrencyCode_Select_Header, CurrencyCode_Select_Condition, Currency_code);
		}

		waitForElement(driver, nominal_amount_field);
		doubleClick(driver, nominal_amount_field);
		Actionsendkeys(driver, nominal_amount_field, Nomination_Amount);
		click(driver, Home_amount);
		Step_Start(10, "Click + button to add the nominals in the grid.", test, test1);
		waitForElement(driver, Gird_add_button);
		click(driver,Gird_add_button);
		Step_End(10, "Click + button to add the nominals in the grid.", test, test1);
		Step_Start(11, " It shows the validation \"The Activity Date must be less than or equal to Invoice Date\" ..", test, test1);
		
		waitForPopup(driver, popup_Message,Billing_date_popup);
		String Actualpopmsg = getText(driver, popup_Message);
		

		if (Billing_date_popup.equals(Actualpopmsg)) {
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_date_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_date_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsg, test, test1);
			Extent_call(test, test1, Actualpopmsg);
		} else {
			System.out.println("Not matched ||Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_date_popup+ " || Actual : After click on save button Popup value is Not display in the Billing Invoice Screen : " + Actualpopmsg);
			Extent_fail(driver, "Not matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_date_popup+ " || Actual : After click on save button Popup value is Not display in the Billing Invoice Screen : " + Actualpopmsg, test, test1);

		}
		Step_End(11, " It shows the validation \"The Activity Date must be less than or equal to Invoice Date\" ..", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Extent_completed(testcase_Name, test, test1);
		
		
   }
	
}
