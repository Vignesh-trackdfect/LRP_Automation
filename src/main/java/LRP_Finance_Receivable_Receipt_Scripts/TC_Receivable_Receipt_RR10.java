package LRP_Finance_Receivable_Receipt_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Receivable_Receipt_Locators;

public class TC_Receivable_Receipt_RR10 extends Keywords {

	public void Receivable_Receipt_RR10(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Receivable_Receipt_RR10";


		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_ReceivableReceipt = Excel_data.get("Module_ReceivableReceipt");
		String customer_Name = Excel_data.get("Customer_Name");
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
		String date_Picker = Excel_data.get("DatePicker");
		String transNumber = Excel_data.get("TransNumber");
		String cheque_TT_No = Excel_data.get("Cheque_TT_No");
		String currencyCode = Excel_data.get("CurrencyCode");
		String localAmt = Excel_data.get("LocalAmt");
		String expectedPopup = Excel_data.get("ExpectedPopup");
		String description_Input = Excel_data.get("Description_Input");
		String cheque_Cash_TT = Excel_data.get("Cheque_Cash_TT");
		String cash_Bank_Details_Date = Excel_data.get("Cash_Bank_Details_Date");
		String SearchCustomer_Header = Excel_data.get("SearchCustomer_Header");
		String SearchCustomer_value = Excel_data.get("SearchCustomer_value");
		String Search_Condition = Excel_data.get("Search_Condition");
		String SearchCurrency_Header = Excel_data.get("SearchCurrency_Header");
		String ChargesSearch_Header = Excel_data.get("ChargesSearch_Header");
		String ChargesSearch_Values = Excel_data.get("ChargesSearch_Values");
		String ROESearch_Header = Excel_data.get("ROESearch_Header");
		String ROESearch_Values = Excel_data.get("ROESearch_Values");
		String BankSearch_Header = Excel_data.get("BankSearch_Header");
		String BankSearch_Values = Excel_data.get("BankSearch_Values");
		String DepositSearch_Header = Excel_data.get("DepositSearch_Header");
		String DepositSearch_Values = Excel_data.get("DepositSearch_Values");
		String bankCharges = Excel_data.get("BankCharges");
		String roeDifference = Excel_data.get("ROE_Difference");
		String accountName_ROE = Excel_data.get("AccountName_ROE");
		String accountHead_ROE = Excel_data.get("AccountHead_ROE");


		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		moduleNavigate(driver, module_ReceivableReceipt);

		Extent_cal(test, test1, module_ReceivableReceipt);

		Step_Start(1, "Click on the new button in the tool bar", test, test1);
        newButton(driver);
		Step_End(1, "Click on the new button in the tool bar", test, test1);
		Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);

		LocalDate current_Date = getOnlyCurrentDate();

		waitForElement(driver, RR_Receipt_Date);
		String actual_Receipt_Date = getAttribute(driver, RR_Receipt_Date, "value");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate reciept_Date = LocalDate.parse(actual_Receipt_Date, formatter);


		if (current_Date.equals(reciept_Date)) {
			System.out.println("Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+reciept_Date+" Receipt Date is  Automatically Selected Based On Month");
			Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date : "+reciept_Date+"Receipt Date is Automatically Selected Based On Month", test, test1);
		} else {
			System.out.println("Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+reciept_Date+"Receipt Date is Not Automatically Selected Based On Month");
			Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+reciept_Date+"Receipt Date is Not Automatically Selected Based On Month", test, test1);
		}
		
		Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);

		waitForElement(driver, RR_Open_Period);
		String actual_Open_Period = getText(driver, RR_Open_Period);
		

		if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
			System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
			Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
		} else {
			System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
			Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
		}
		Step_End(3, "Open period will get automatically populated based on receipt date", test, test1);
		Step_Start(4, "Select the Customer Name from the search icon in the customer tab", test, test1);

		waitForElement(driver, RR_Customer_Code);
		click(driver, RR_Customer_Code);
		
		waitForElement(driver, RR_Customer_Text_Field);
		sendKeys(driver, RR_Customer_Text_Field, customer_Name);
		click(driver, RR_Customer_Search);
		waitForElement(driver, CustomerCode_Filter_RR);

		twoColumnMultipleSearchWindow(driver, SearchCustomer_Header, Search_Condition, SearchCustomer_value);

		Step_End(4, "Select the Customer Name from the search icon in the customer tab", test, test1);
		Step_Start(5, "Select Get Details and click show invoice", test, test1);

		waitForElement(driver, Descriction_Area_RR);
		sendKeys(driver, Descriction_Area_RR, description_Input);

		waitForElement(driver, RR_Get_Details_Button);
		click(driver, RR_Get_Details_Button);

		waitForElement(driver, RR_Trans_Date_Check_Box);
		checkBox(driver, RR_Trans_Date_Check_Box, Trans_Date_Check_Box);

		waitForElement(driver, RR_Currency_Check_Box);
		checkBox(driver, RR_Currency_Check_Box, Currency_Check_Box);

		waitForElement(driver, RR_Trans_No_Check_Box);
		checkBox(driver, RR_Trans_No_Check_Box, Trans_No_Check_Box);

		waitForElement(driver, RR_Amount_Range_Check_Box);
		checkBox(driver, RR_Amount_Range_Check_Box, Amount_Range_Check_Box);

		if (!Trans_From_Date.equals("")) {
			waitForElement(driver, RR_Trans_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, RR_Trans_From_Date, Trans_From_Date);
			} else {
				waitForElement(driver, RR_Trans_From_Date);
				clearAndType(driver, RR_Trans_From_Date, Trans_From_Date);
				click(driver, RR_Trans_To_Date);

			}
		}
		if (!Trans_To_Date.equals("")) {
			waitForElement(driver, RR_Trans_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, RR_Trans_To_Date, Trans_To_Date);
			} else {
				waitForElement(driver, RR_Trans_To_Date);
				clearAndType(driver, RR_Trans_To_Date, Trans_To_Date);
				click(driver, RR_From_Trans_No);
			}
		}
		if (!Currency_Select_Option.equals("")) {
			waitForElement(driver, RR_Currency_Select);
			click(driver, RR_Currency_Select);
			String Select_Currency = String.format(RR_Currency_Select_Option, Currency_Select_Option);
			waitForElement(driver, Select_Currency);
			click(driver, Select_Currency);
		}
		if (!From_Trans_No.equals("")) {
			waitForElement(driver, RR_From_Trans_No);
			sendKeys(driver, RR_From_Trans_No, From_Trans_No);
		}
		if (!To_Trans_No.equals("")) {
			waitForElement(driver, RR_To_Trans_No);
			sendKeys(driver, RR_To_Trans_No, To_Trans_No);
		}
		if (!From_Amount_Range.equals("")) {
			waitForElement(driver, RR_From_Amount_Range);
			clearAndType(driver, RR_From_Amount_Range, From_Amount_Range);
			click(driver, RR_To_Amount_Range);
		}
		if (!To_Amount_Range.equals("")) {
			waitForElement(driver, RR_To_Amount_Range);
			clearAndType(driver, RR_To_Amount_Range, To_Amount_Range);
			click(driver, RR_From_Amount_Range);
		}
		waitForElement(driver, RR_Show_Invoice_Button);
		click(driver, RR_Show_Invoice_Button);

		Step_End(5, "Select Get Details and click show invoice", test, test1);
		Step_Start(6, "Select the respective transaction number", test, test1);

		String trans_Number_Select = String.format(RR_Select_Trans_Number_Check_Box, transNumber);
		waitForElement(driver, trans_Number_Select);
		click(driver, trans_Number_Select);


		Step_End(6, "Select the respective transaction number", test, test1);
		Step_Start(7, "Click \"Cash or Bank detail\" and enter the values in the respective fields", test, test1);

		waitForElement(driver, cash_Bank_Details_Tab_RR);
		click(driver, cash_Bank_Details_Tab_RR);

		if (!cheque_Cash_TT.equals("")) {
			waitForElement(driver, cheque_Cash_TT_Dropdown_RR);
			click(driver, cheque_Cash_TT_Dropdown_RR);
			String cheque_Drpdwn_Option_Rr = String.format(Receivable_Receipt_Locators.cheque_Cash_TT_Option_RR,
					cheque_Cash_TT);
			waitForElement(driver, cheque_Drpdwn_Option_Rr);
			click(driver, cheque_Drpdwn_Option_Rr);
		}
		if (!cash_Bank_Details_Date.equals("")) {
			waitForElement(driver, date_Cash_Bank_Details_RR);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, date_Cash_Bank_Details_RR, cash_Bank_Details_Date);
			} else {
				waitForElement(driver, date_Cash_Bank_Details_RR);
				clearAndType(driver, date_Cash_Bank_Details_RR, cash_Bank_Details_Date);
				click(driver, cheque_TT_No_Textfield_RR);
			}
		}

		waitForElement(driver, cheque_TT_No_Textfield_RR);
		sendKeys(driver, cheque_TT_No_Textfield_RR, cheque_TT_No);

		click(driver, depositAC_SearchButton_RR);
		waitForElement(driver, acccountName_Filter_RR);

		twoColumnMultipleSearchWindow(driver, DepositSearch_Header, Search_Condition, DepositSearch_Values);

		click(driver, bank_SearchButton_RR);
		waitForElement(driver, bankCode_Filter_RR);
		twoColumnMultipleSearchWindow(driver, BankSearch_Header, Search_Condition, BankSearch_Values);

		if (!currencyCode.equals("")) {
			click(driver, currency_SearcButton_RR);
			waitForElement(driver, currencyCode_Filter_RR);
			twoColumnSearchWindow(driver, SearchCurrency_Header, Search_Condition, currencyCode);
		}

		if (!localAmt.equals("")) {
			waitForElement(driver, localAmount_Textfield_RR);
			clearAndType(driver, localAmount_Textfield_RR, localAmt);
			waitForElement(driver, localAmount_Textfield_RR);
			click(driver, cheque_TT_No_Textfield_RR);
		}

		if (!bankCharges.equals("")) {
			waitForElement(driver, bank_Charges_Textfield_RR);
			clearAndType(driver, bank_Charges_Textfield_RR, bankCharges);
			waitForElement(driver, bank_Charges_Textfield_RR);
			click(driver, cheque_TT_No_Textfield_RR);

			click(driver, bankCharges_SsearchButton_RR);
			waitForElement(driver, acccountName_Filter_RR);
			twoColumnMultipleSearchWindow(driver, ChargesSearch_Header, Search_Condition, ChargesSearch_Values);
		}

		waitForElement(driver, roe_Differencfe_Textfield_RR);
		clearAndType(driver, roe_Differencfe_Textfield_RR, roeDifference);
		waitForElement(driver, roe_Differencfe_Textfield_RR);
		click(driver, cheque_TT_No_Textfield_RR);

		if (!accountName_ROE.equals("") || !accountHead_ROE.equals("")) {

			click(driver, roe_Difference_SearchButton_RR);
			waitForElement(driver, acccountName_Filter_RR);
			sendKeys(driver, acccountName_Filter_RR, accountName_ROE);
			waitForElement(driver, acccountHead_Filter_RR);
			twoColumnMultipleSearchWindow(driver, ROESearch_Header, Search_Condition, ROESearch_Values);

		}

		Step_End(7, "Click \"Cash or Bank detail\" and enter the values in the respective fields", test, test1);
		Step_Start(8, "Click on Add button without entering the value in the \"ROE Difference in USD\"", test, test1);

		waitForElement(driver, add_Button_Cash_Bank_Details_RR);
		click(driver, add_Button_Cash_Bank_Details_RR);

		Step_End(8, "Click on Add button without entering the value in the \"ROE Difference in USD\"", test, test1);
		Step_Start(9, "system should show pop up validation as \"Select the Roe/Diff A/C Name\".", test, test1);

		waitForPopup(driver, popup_Message,expectedPopup);
		String actualPopup = getText(driver, popup_Message);


		if(expectedPopup.equals(actualPopup)) {
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : "+expectedPopup+" ||  Actual : After click on save button Popup value is display in the Receivable Receipt Screen : "+actualPopup);
			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : "+expectedPopup+" ||  Actual :After click on save button Popup value is display in the Receivable Receipt Screen : "+actualPopup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen: "+expectedPopup+" || Actual :After click on save button Popup value is not display in the Receivable Receipt Screen : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : "+expectedPopup+" || Actual :After click on save button Popup value is not  display in the Receivable Receipt Screen : "+actualPopup, test, test1);
		}

		Step_End(9, "system should show pop up validation as \"Select the Roe/Diff A/C Name\".", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
