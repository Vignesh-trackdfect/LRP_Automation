package LRP_Finance_Payable_Payment_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Payable_Payment_Locators;

public class TC_Payable_Payment_PP05 extends Keywords{
	
	public void Payable_Payment_PP05(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Payable_Payment_PP05";
		// Get data from test data

		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Payable_Payment = Excel_data.get("Module_Payable_Payment");
		String vendor_Code = Excel_data.get("Vendor_Code");
		String vendor_Name=Excel_data.get("Vendor_Name");
		String Trans_Date_Check_Box = Excel_data.get("Trans_Date_Check_Box");
		String Currency_Check_Box = Excel_data.get("Currency_Check_Box");
		String Trans_No_Check_Box = Excel_data.get("Trans_No_Check_Box");
		String Amount_Range_Check_Box = Excel_data.get("Amount_Range_Check_Box");
		String Trans_From_Date = Excel_data.get("Trans_From_Date");
		String Trans_To_Date = Excel_data.get("Trans_To_Date");
		String Currency_Select_Option = Excel_data.get("Currency_Select_Option");
		String From_Trans_No = Excel_data.get("From_Trans_No");
		String To_Trans_No = Excel_data.get("To_Trans_No");
		String From_Amount_Range = Excel_data.get("From_Amount_Range");
		String To_Amount_Range = Excel_data.get("To_Amount_Range");
		String datePicker = Excel_data.get("DatePicker");
		String transNumber = Excel_data.get("TransNumber");
		String cheque_TT_No = Excel_data.get("Cheque_TT_No");
		String accountName = Excel_data.get("AccountName");
		String currencyCode = Excel_data.get("CurrencyCode");
		String documentAmt = Excel_data.get("DocumentAmt");
		String expectedPopup = Excel_data.get("ExpectedPopup");
		String description_Input = Excel_data.get("Description_Input");
		String cheque_Cash_TT = Excel_data.get("Cheque_Cash_TT");
		String cash_Bank_Details_Date = Excel_data.get("Cash_Bank_Details_Date");
		String accountName_BankCharges = Excel_data.get("AccountName_BankCharges");
		String accountHead_BankCharges = Excel_data.get("AccountHead_BankCharges");
		String payment_Date = Excel_data.get("Payment_Date");
		String bankCharges = Excel_data.get("BankCharges");
		String roeDifference = Excel_data.get("ROE_Difference");
		String accountName_ROE = Excel_data.get("AccountName_ROE");
		String accountHead_ROE = Excel_data.get("AccountHead_ROE");
		String dropdownCondition =Excel_data.get("dropdownCondition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Account_Name_Header = Excel_data.get("Account_Name_Header");
		String currency_SearcButton_PPT_Header = Excel_data.get("currency_SearcButton_PPT_Header");
		
	
		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		moduleNavigate(driver, module_Payable_Payment);
		


		Extent_cal(test, test1, module_Payable_Payment);

		Step_Start(1, "Click on the new button in the tool bar", test, test1);

		newButton(driver);
		
		Step_End(1, "Click on the new button in the tool bar", test, test1);
		
		if(payment_Date.equals("")) {
		Step_Start(2, "Payment date will be automatically selected based on month", test, test1);

		LocalDate current_Date = getOnlyCurrentDate();
		

		waitForElement(driver, paymentDate_PPT);
		String actual_Payment_Date = getAttribute(driver, paymentDate_PPT, "value");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate paymentDate = LocalDate.parse(actual_Payment_Date, formatter);

		
		if (current_Date.equals(paymentDate)) {
			System.out.println("Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+paymentDate+" Payment Date Automatically Selected Based On Month");
			Extent_pass_New(driver,"Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date Selected Based on Month : "+paymentDate+"Payment Date Automatically Selected Based On Month", test, test1);
		} else {
			System.out.println("Not Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+paymentDate+"Payment Date Not Automatically Selected Based On Month");
			Extent_fail(driver,"Not Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+paymentDate+"Payment Date Not Automatically Selected Based On Month", test, test1);
		}
		Step_End(2, "Payment date will be automatically selected based on month", test, test1);
		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);

		waitForElement(driver, openPeriod_PPT);
		String actual_Open_Period= getText(driver, openPeriod_PPT);
	
		
		if(compareMonthAndYear(actual_Payment_Date, actual_Open_Period)) {
			System.out.println("Matched || Open Period Should Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period  Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Payment Date");
			Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period  Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Payment Date", test, test1);
		} else {
			System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Payment Date");
			Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Payment Date", test, test1);
		}
		Step_End(3, "Open period will get automatically populated based on receipt date", test, test1);
		}else {
			Step_Start(2, "Payment date will be automatically selected based on month", test, test1);
			if(datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, paymentDate_PPT, payment_Date);	


			}
			else {
				waitForElement(driver, paymentDate_PPT);
				clearAndType(driver, paymentDate_PPT, payment_Date);
			}
	
		     waitForElement(driver, paymentDate_PPT);
			String actual_Payment_Date = getAttribute(driver, paymentDate_PPT, "value");

			
			if (payment_Date.equals(actual_Payment_Date)) {
				System.out.println("Matched || Payment Date Should be Automatically Select Based On Month : "+payment_Date+" || The Actual Payment Date  : "+actual_Payment_Date+"Payment Date Automatically Selected Based On Month");
				Extent_pass_New(driver,"Matched || Payment Date Should be Automatically Select Based On Month : "+payment_Date+" || The Actual Payment Date : "+actual_Payment_Date+"Payment Date Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Payment Date Should  be Automatically Select Based On Month || Expected Current Date : "+payment_Date+" || The Actual Payment Date : "+actual_Payment_Date+"Payment Date Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Payment Date Should be  Automatically Select Based On Month || Expected Current Date : "+payment_Date+" || The Actual Payment Date : "+actual_Payment_Date+"Payment Date Not Automatically Selected Based On Month", test, test1);
			}
			Step_End(2, "Payment date will be automatically selected based on month", test, test1);
			Step_Start(3, "Select the search icon near customer tab, without entering values in customer field", test, test1);
			waitForElement(driver, openPeriod_PPT);
			String actual_Open_Period= getText(driver, openPeriod_PPT);
			
		
			
			if(compareMonthAndYear(actual_Payment_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be  Automatically Populated Based On Payment Date || Expected Payment Date is "+actual_Payment_Date+" || The Actual Open Period Date : "+actual_Open_Period+" Open Period  Automatically Populated Based On Payment Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is "+actual_Payment_Date+" || The Actual Open Period Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Payment Date", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Payment Date");
				Extent_fail(driver,"Not Matched || Open Period Automatically Not Populated Based On Payment Date || Expected The Payment Date is : "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Payment Date", test, test1);
			}
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}
		
		Step_Start(4, " Select the search icon near customer tab, without entering values in customer field", test, test1);

		 waitForElement(driver, PP_Vendor_Radio_Button);
	     click(driver, PP_Vendor_Radio_Button);
		
		waitForElement(driver, vendor_textield_PPT);
     	sendKeys(driver, vendor_textield_PPT,vendor_Name);
		click(driver,customer_SearchButton_PPT);
		
		twoColumnSearchWindow(driver, Vendor_Code_Header, dropdownCondition, vendor_Code);


	
		
		Step_End(4, "Select the Customer Name from the search icon in the customer tab", test, test1);
		Step_Start(5, "Select Get Details and click show invoice", test, test1);
		
		waitForElement(driver, description_TextArea_PPT);
		sendKeys(driver, description_TextArea_PPT, description_Input);
		

		waitForElement(driver, getDetails_Button_PPT);
		click(driver, getDetails_Button_PPT);
		
		waitForElement(driver, transDate_Checkbox_PPT);
		checkBox(driver, transDate_Checkbox_PPT, Trans_Date_Check_Box);
		
		waitForElement(driver, currency_Checkbox_PPT);
		checkBox(driver, currency_Checkbox_PPT, Currency_Check_Box);
		
		waitForElement(driver, transNumber_No_Checkbox_PPT);
		checkBox(driver, transNumber_No_Checkbox_PPT, Trans_No_Check_Box);
		
		waitForElement(driver, amountRange_Checkbox_PPT);
		checkBox(driver, amountRange_Checkbox_PPT, Amount_Range_Check_Box);
		
		if(!Trans_From_Date.equals("")) {
			waitForElement(driver, trans_FromDate_PPT);
			if(datePicker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, trans_FromDate_PPT, Trans_From_Date);
				
			}
			else {
				waitForElement(driver, trans_FromDate_PPT);
				clearAndType(driver, trans_FromDate_PPT, Trans_From_Date);
				click(driver, trans_ToDate_PPT);

			}
		}
		if(!Trans_To_Date.equals("")) {
			waitForElement(driver, trans_ToDate_PPT);
			if(datePicker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, trans_ToDate_PPT, Trans_To_Date);
				
			}
			else {
				waitForElement(driver, trans_ToDate_PPT);
				clearAndType(driver, trans_ToDate_PPT, Trans_To_Date);
				click(driver, trans_FromDate_PPT);
			}
		}
		if(!Currency_Select_Option.equals("")) {
			waitForElement(driver, currency_Select_Dropdown_PPT);
				click(driver, currency_Select_Dropdown_PPT);
				String Select_Currency=String.format(currency_Select_Option_PPT, Currency_Select_Option);
				waitForElement(driver, Select_Currency);
				click(driver, Select_Currency);
		}
		if(!From_Trans_No.equals("")) {
			waitForElement(driver, Trans_No_From_Date_PPT);
			sendKeys(driver, Trans_No_From_Date_PPT, From_Trans_No);
		}
		if(!To_Trans_No.equals("")) {
			waitForElement(driver, Trans_No_To_Date_PPT);
			sendKeys(driver, Trans_No_To_Date_PPT, To_Trans_No);
		}
		if(!From_Amount_Range.equals("")) {
			waitForElement(driver, amountRange_From_Textfield_PPT);
			clearAndType(driver, amountRange_From_Textfield_PPT, From_Amount_Range);
			click(driver, amountRange_To_Textfield_PPT);
		}
		if(!To_Amount_Range.equals("")) {
			waitForElement(driver, amountRange_To_Textfield_PPT);
			clearAndType(driver, amountRange_To_Textfield_PPT, To_Amount_Range);
			click(driver, amountRange_From_Textfield_PPT);
		}
		waitForElement(driver, show_Invoice_Btn_PPT);
		click(driver, show_Invoice_Btn_PPT);
		
		Step_End(5, "Select Get Details and click show invoice", test, test1);
		Step_Start(6, "Select the respective transaction number", test, test1);
		
		waitForElement(driver, filter_Icon_PPT);
		click(driver, filter_Icon_PPT);
		waitForElement(driver, condition_Filter_PPT);
		click(driver, condition_Filter_PPT);
		waitForElement(driver, transNumber_Filter_PPT);
		sendKeys(driver, transNumber_Filter_PPT, transNumber);
		
		String select_CheckBox=String.format(select_Checkbox_PPT, transNumber);
		
		waitForElement(driver, select_CheckBox);
		checkBox(driver, select_CheckBox, "Yes");
		
		
		Step_End(6, "Select the respective transaction number", test, test1);
		Step_Start(7, "Click \"Cash or Bank detail\" and enter the values in the respective fields", test, test1);

		
		waitForElement(driver, cash_Bank_Details_Tab_PPT);
		click(driver, cash_Bank_Details_Tab_PPT);
		
		
		if(!cheque_Cash_TT.equals("")) {
		waitForElement(driver, cheque_Cash_TT_Dropdown_PPT);
		click(driver, cheque_Cash_TT_Dropdown_PPT);
		String cheque_Drpdwn_Option_Rr=String.format(Payable_Payment_Locators.cheque_Cash_TT_Option_PPT, cheque_Cash_TT);
		waitForElement(driver, cheque_Drpdwn_Option_Rr);
		click(driver, cheque_Drpdwn_Option_Rr);
		}
		if(!cash_Bank_Details_Date.equals("")) {
			waitForElement(driver, date_Cash_Bank_Details_PPT);
			if(datePicker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, date_Cash_Bank_Details_PPT, cash_Bank_Details_Date);
				
			}
			else {
				waitForElement(driver, date_Cash_Bank_Details_PPT);
				clearAndType(driver, date_Cash_Bank_Details_PPT, cash_Bank_Details_Date);
				click(driver, cheque_TT_No_Textfield_PPT);
			}
		}
		
		if(!cheque_TT_No.equals("")) {
		waitForElement(driver, cheque_TT_No_Textfield_PPT);
		sendKeys(driver, cheque_TT_No_Textfield_PPT, cheque_TT_No);
		
		 twoColumnSearchWindow(driver,Account_Name_Header,dropdownCondition, accountName);

		}
		
				
		
		if(!currencyCode.equals("")) {
			
			twoColumnSearchWindow(driver, currency_SearcButton_PPT_Header, dropdownCondition, currencyCode);
			
		
		if(!documentAmt.equals("")) {
		waitForElement(driver, documentAmount_Textfield_RR);
		click(driver, documentAmount_Textfield_RR);
		waitForElement(driver, documentAmount_Textfield_RR);
		Newclear(driver, documentAmount_Textfield_RR);
		waitForElement(driver, documentAmount_Textfield_RR);
		Actionsendkeys(driver, documentAmount_Textfield_RR, documentAmt);
		click(driver, cheque_TT_No_Textfield_PPT);
		}
		
		if(!bankCharges.equals("")) {
		waitForElement(driver, bank_Charges_Textfield_PPT);
		Newclear(driver, bank_Charges_Textfield_PPT);
		waitForElement(driver, bank_Charges_Textfield_PPT);
		Actionsendkeys(driver, bank_Charges_Textfield_PPT, bankCharges);
		waitForElement(driver, bank_Charges_Textfield_PPT);
		click(driver, cheque_TT_No_Textfield_PPT);
		}
		
		if(!accountName_BankCharges.equals("") || !accountHead_BankCharges.equals("")) {
	
			twoColumnSearchWindow(driver, Account_Name_Header, dropdownCondition,accountHead_BankCharges );

		}
		
		if(!roeDifference.equals("")) {
		waitForElement(driver, roe_Differencfe_Textfield_PPT);
		Newclear(driver, roe_Differencfe_Textfield_PPT);
		waitForElement(driver, roe_Differencfe_Textfield_PPT);
		Actionsendkeys(driver, roe_Differencfe_Textfield_PPT, roeDifference);
		waitForElement(driver, roe_Differencfe_Textfield_PPT);
		click(driver, cheque_TT_No_Textfield_PPT);
		
		 twoColumnSearchWindow(driver,accountName_ROE,dropdownCondition, accountHead_ROE);	
		
		}
		
		Step_End(7, "Click \"Cash or Bank detail\" and enter the values in the respective fields", test, test1);
		Step_Start(8, "Click on Add button without entering the value in the \"Cheque/TT No\".", test, test1);

		waitForElement(driver, add_Button_Cash_Bank_Details_PPT);
		click(driver, add_Button_Cash_Bank_Details_PPT);
		
		Step_End(8, "Click on Add button without entering the value in the \"Cheque/TT No\".", test, test1);
		Step_Start(9, "system should show pop up validation as  \"Enter the Cheque or TT Number\"", test, test1);

		waitForPopup(driver, popup_Message,expectedPopup);
		String actualPopup=getText(driver, popup_Message);
		
		if(expectedPopup.equals(actualPopup)) {
			System.out.println("Matched || Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup);
			Extent_pass_New(driver, "Matched ||Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup, test, test1);
		}
		
		Step_End(9, "system should show pop up validation as  \"Enter the Cheque or TT Number\"", test, test1);

		Extent_completed(testCaseName, test, test1);
		
	}
	}
}
