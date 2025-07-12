package LRP_Finance_Billing_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Billing_Invoice_B05 extends Keywords{
	public void  Billing_Invoice_B05(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Billing_Invoice_B05";
		
		

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
		
		Step_Start(2, " Receipt date will be automatically selected based on month.", test, test1);
		waitForElement(driver, billing_invoice_activity_date);
		if (Activity_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_activity_date, activity_Date_Input);
			
		} else {
			waitForElement(driver, billing_invoice_activity_date);
			clearAndType(driver, billing_invoice_activity_date, activity_Date_Input);
		}
		
		waitForElement(driver, billing_invoice_invoice_date);
		if (invoice_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_invoice_date, invoice_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_invoice_date);
			clearAndType(driver, billing_invoice_invoice_date, invoice_Date_Input);
		}
		
		waitForElement(driver, billing_invoice_Due_date);
		if (Due_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_Due_date, Due_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_Due_date);
			clearAndType(driver, billing_invoice_Due_date, Due_Date_Input);
		}
	
		Step_End(2, " Receipt date will be automatically selected based on month.", test, test1);
		Step_Start(3, "Based on your activity date open period will automatically changed. ", test, test1);
		waitForElement(driver, open_peroid);
		String open_period_value = getText(driver, open_peroid);
		System.out.println(open_period_value);
		Extent_call(test, test1, "**open period shows***"+open_period_value);
		Step_End(3, "Based on your activity date open period will automatically changed. ", test, test1);
		Step_Start(4, "select the search icon near customer tab, without entering values in customer field", test, test1);
	
		waitForDisplay(driver, billing_Discription_input);
		if(isdisplayed(driver, billing_Discription_input)&&!Discription_input.equals("")) {
		waitForElement(driver, billing_Discription_input);
		sendKeys(driver, billing_Discription_input, Discription_input);
		
		}
		
		
		waitForElement(driver, billing_Dr_cr_droupdwn);
		click(driver,billing_Dr_cr_droupdwn);
		waitForElement(driver, select_dr);
		click(driver,select_dr);
	
		waitForDisplay(driver, nomination_search);
		if(isdisplayed(driver, nomination_search)&&!Nomination_name.equals("")) {
		waitForElement(driver, nomination_search);
		click(driver,nomination_search);
		twoColumnSearchWindow(driver, Nominal_Select_Header, Nominal_Select_Condition, Nomination_name);
		}
		
		Step_End(4, "select the search icon near customer tab, without entering values in customer field", test, test1);
		
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
		waitForElement(driver, Gird_add_button);
		click(driver,Gird_add_button);
		
		Step_Start(5, "System should show the validation pop up as \"Enter the Customer Name\".", test, test1);
		waitForPopup(driver, popup_Message,Billing_date_popup);

		String Actualpopmsg = getText(driver, popup_Message);
		

		if (Billing_date_popup.equals(Actualpopmsg)) {
			System.out.println("Matched ||Expected : After click on add button Popup value should be display in the Billing Invoice Screen : " + Billing_date_popup+ " || Actual After click on add button Popup value is display in the Billing Invoice Screen : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched || Expected : After click on add button Popup value should be display in the Billing Invoice Screen : " + Billing_date_popup+ " || Actual After click on add button Popup value is display in the Billing Invoice Screen: " + Actualpopmsg, test, test1);
			Extent_call(test, test1, Actualpopmsg);
		} else {
			System.out.println("Not matched ||Expected : After click on add button Popup value should be display in the Billing Invoice Screen : " + Billing_date_popup+ " || Actual After click on add button Popup value is not display in the Billing Invoice Screen: " + Actualpopmsg);
			Extent_fail(driver, "Not matched || Expected : After click on add button Popup value should be display in the Billing Invoice Screen :" + Billing_date_popup+ " || Actual After click on add button Popup value is not display in the Billing Invoice Screen : " + Actualpopmsg, test, test1);

		}
		Step_End(5, "System should show the validation pop up as \"Enter the Customer Name\".", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Extent_completed(testcase_Name, test, test1);
   }
	
}
