package LRP_Finance_Receivable_Receipt_Scripts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Receivable_Receipt_RR04 extends Keywords {
	public void Receivable_Receipt_RR04(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Receivable_Receipt_RR04";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String module_Name = Excel_data.get("module_Name");
		String Receipt_Date_Input = Excel_data.get("Receipt_Date_Input");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Customer_Name = Excel_data.get("Customer_Name");
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
		String cheque_TT_No = Excel_data.get("Cheque_TT_No");
		String currencyCode = Excel_data.get("CurrencyCode");
		String localAmt = Excel_data.get("LocalAmt");
		String Total_Amount = Excel_data.get("Total_Amount");
		String cheque_Cash_TT = Excel_data.get("Cheque_Cash_TT");
		String cash_Bank_Details_Date = Excel_data.get("Cash_Bank_Details_Date");
		String bankCharges = Excel_data.get("BankCharges");
		String roeDifference = Excel_data.get("ROE_Difference");
		String Limit_Of_Cheque_No_Input = Excel_data.get("Limit_Of_Cheque_No_Input");
		String Limit_Of_Local_Amount_Input = Excel_data.get("Limit_Of_Local_Amount_Input");
		String Saved_Popup = Excel_data.get("Saved_Popup");
		String SearchCustomer_Header = Excel_data.get("SearchCustomer_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String DepositSearch_Header = Excel_data.get("DepositSearch_Header");
		String DepositSearch_Values = Excel_data.get("DepositSearch_Values");
		String BankSearch_Header = Excel_data.get("BankSearch_Header");
		String BankSearch_Values = Excel_data.get("BankSearch_Values");
		String SearchCurrency_Header = Excel_data.get("SearchCurrency_Header");
		String ChargesSearch_Header = Excel_data.get("ChargesSearch_Header");
		String ChargesSearch_Values = Excel_data.get("ChargesSearch_Values");
		String ROESearch_Header = Excel_data.get("ROESearch_Header");
		String ROESearch_Values = Excel_data.get("ROESearch_Values");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		moduleNavigate(driver, module_Name);

		Step_Start(1, "Click on the new button in the tool bar", test, test1);

	newButton(driver);

		Step_End(1, "Click on the new button in the tool bar", test, test1);

		if (Receipt_Date_Input.equals("")) {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			LocalDate current_Date = getOnlyCurrentDate();
			waitForElement(driver, RR_Receipt_Date);
			String actual_Receipt_Date = getAttribute(driver, RR_Receipt_Date, "value");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate Receipt_Date = LocalDate.parse(actual_Receipt_Date, formatter);
		
			if (current_Date.equals(Receipt_Date)) {
				System.out.println("Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+Receipt_Date+" Receipt Date is  Automatically Selected Based On Month");
				Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date : "+Receipt_Date+"Receipt Date is Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month", test, test1);
			}
			Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
			Step_Start(3, "Open period will get automatically populated based on Receipt date", test, test1);
			waitForElement(driver, RR_Open_Period);
			String actual_Open_Period = getText(driver, RR_Open_Period);
		
			
			if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
			}
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		} else {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			if (Date_Picker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, RR_Receipt_Date);
				selectDatePicker(driver, RR_Receipt_Date, Receipt_Date_Input);
			} else {
				waitForElement(driver, RR_Receipt_Date);
				clearAndType(driver, RR_Receipt_Date, Receipt_Date_Input);
			}

			waitForElement(driver, RR_Receipt_Date);
			String actual_Receipt_Date = getAttribute(driver, RR_Receipt_Date, "value");

		
			if (Receipt_Date_Input.equals(actual_Receipt_Date)) {
				System.out.println("Matched || Receipt Date should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date  : "+actual_Receipt_Date+"Receipt Date is Automatically Selected Based On Month ");
				Extent_pass_New(driver,"Matched || Receipt Date should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date  : "+actual_Receipt_Date+"Receipt Date is Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date should be Automatically Not Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date : "+actual_Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Receipt Date should be Automatically Not Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date : "+actual_Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month", test, test1);
			}
			Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
			Step_Start(3, "Open period will get automatically populated based on Receipt date", test, test1);
			waitForElement(driver, RR_Open_Period);
			String actual_Open_Period = getText(driver, RR_Open_Period);

		
			if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be  Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" ||  Actual Open Receipt Date : "+actual_Open_Period+" Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Automatically Not Populated Based On Receipt Date || Expected The Receipt Date is : "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date", test, test1);
			}
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}

		Step_Start(4, "Select the Customer Name from the search icon in the customer tab", test, test1);

		waitForElement(driver, RR_Customer_Code);
		click(driver, RR_Customer_Code);
		
		waitForElement(driver, RR_Customer_Text_Field);
		sendKeys(driver, RR_Customer_Text_Field, Customer_Name);

		click(driver, RR_Customer_Search);

		twoColumnSearchWindow(driver, SearchCustomer_Header, Search_Condition, Customer_Name);

		Step_End(4, "Select the Customer Name from the search icon in the customer tab", test, test1);

		Step_Start(5, "Select Get Details and click show invoice", test, test1);

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
			if (Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, RR_Trans_From_Date, Trans_From_Date);
			} else {
				waitForElement(driver, RR_Trans_From_Date);
				clearAndType(driver, RR_Trans_From_Date, Trans_From_Date);
			}
		}
		if (!Trans_To_Date.equals("")) {
			waitForElement(driver, RR_Trans_To_Date);
			if (Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, RR_Trans_To_Date, Trans_To_Date);
			} else {

				waitForElement(driver, RR_Trans_To_Date);
				clearAndType(driver, RR_Trans_To_Date, Trans_To_Date);
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
			waitForElement(driver, RR_Currency_Select);
			sendKeys(driver, RR_From_Trans_No, From_Trans_No);
		}
		if (!To_Trans_No.equals("")) {
			waitForElement(driver, RR_To_Trans_No);
			sendKeys(driver, RR_To_Trans_No, To_Trans_No);
		}
		if (!From_Amount_Range.equals("")) {
			waitForElement(driver, RR_From_Amount_Range);
			sendKeys(driver, RR_From_Amount_Range, From_Amount_Range);
		}
		if (!To_Amount_Range.equals("")) {
			waitForElement(driver, RR_To_Amount_Range);
			sendKeys(driver, RR_To_Amount_Range, To_Amount_Range);
		}

		waitForElement(driver, RR_Show_Invoice_Button);
		click(driver, RR_Show_Invoice_Button);
		Step_End(5, "Select Get Details and click show invoice", test, test1);
		Step_Start(6, "Click on Cash/Bank Detail tab", test, test1);
		waitForElement(driver, cash_Bank_Details_Tab_RR);
		click(driver, cash_Bank_Details_Tab_RR);
		Step_End(6, "Click on Cash/Bank Detail tab", test, test1);
		Step_Start(7, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);
		waitForElement(driver, cheque_TT_No_Textfield_RR);
		sendKeys(driver, cheque_TT_No_Textfield_RR, cheque_TT_No);

		waitForElement(driver, cheque_TT_No_Textfield_RR);
		String cheque_No = getAttribute(driver, cheque_TT_No_Textfield_RR, "value");
		int total_Cheque_Size = cheque_No.length();
		int exp_Cheque_Size = Integer.parseInt(Limit_Of_Cheque_No_Input);
	
		if(exp_Cheque_Size>=total_Cheque_Size) {
			System.out.println("Matched || The Expected : Enter the negavite Nuumber of Characters Accept should be  Cheque/TT No Field : "+exp_Cheque_Size+" || Actual :Enter the negavite Number of Characters Accept is  Cheque/TT No Field : "+total_Cheque_Size);
			Extent_pass_New(driver, "Matched || The Expected : Enter the negavite Number of Characters Accept should be  Cheque/TT No Field : "+exp_Cheque_Size+" || Actual :Enter the negavite Number of Characters Accept is  Cheque/TT No Field : "+total_Cheque_Size, test, test1);
		}else {
			System.out.println("Not Matched || The Expected : Enter the negavite  Number of Characters Accept should be Cheque/TT No Field : "+exp_Cheque_Size+" || Actual : Enter the negavite Number of Characters Not Accept In  Cheque/TT No Field : "+total_Cheque_Size);
			Extent_fail(driver, "Not Matched || The Expected : Enter the negavite  Number of Characters Accept should be  Cheque/TT No Field : "+exp_Cheque_Size+" || Actual : Enter the negavite  Number of Characters Not Accept In  Cheque/TT No Field : "+total_Cheque_Size, test, test1);
		}
		Step_End(7, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);
		Step_Start(8, "Select the Deposit A/c", test, test1);
		waitForElement(driver, cheque_Cash_TT_Dropdown_RR);
		click(driver, cheque_Cash_TT_Dropdown_RR);

		if (!cheque_Cash_TT.equals("")) {
			String cheque_Drpdwn_Option_Rr = String.format(cheque_Cash_TT_Option, cheque_Cash_TT);
			waitForElement(driver, cheque_Drpdwn_Option_Rr);
			click(driver, cheque_Drpdwn_Option_Rr);
		}
		if (!cash_Bank_Details_Date.equals("")) {
			waitForElement(driver, date_Cash_Bank_Details_RR);
			if (Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, date_Cash_Bank_Details_RR, cash_Bank_Details_Date);
			} else {
				waitForElement(driver, date_Cash_Bank_Details_RR);
				clearAndType(driver, date_Cash_Bank_Details_RR, cash_Bank_Details_Date);
				click(driver, cheque_TT_No_Textfield_RR);
			}
		}

		click(driver, depositAC_SearchButton_RR);

		twoColumnMultipleSearchWindow(driver, DepositSearch_Header, Search_Condition, DepositSearch_Values);

		Step_End(8, "Select the Deposit A/c", test, test1);
		Step_Start(9, "Select the Bank", test, test1);
		click(driver, bank_SearchButton_RR);

		twoColumnMultipleSearchWindow(driver, BankSearch_Header, Search_Condition, BankSearch_Values);

		waitForElement(driver, currency_SearcButton_RR);
		click(driver, currency_SearcButton_RR);

		twoColumnSearchWindow(driver, SearchCurrency_Header, Search_Condition, currencyCode);

		Step_End(9, "Select the Bank", test, test1);
		Step_Start(10, " Enter the Bank charges and select the bank nominal", test, test1);
		waitForElement(driver, bank_Charges_Textfield_RR);
		clearAndType(driver, bank_Charges_Textfield_RR, bankCharges);
		waitForElement(driver, bank_Charges_Textfield_RR);
		click(driver, cheque_TT_No_Textfield_RR);

		waitForElement(driver, bankCharges_SsearchButton_RR);
		click(driver, bankCharges_SsearchButton_RR);
		waitForElement(driver, acccountName_Filter_RR);

		twoColumnMultipleSearchWindow(driver, ChargesSearch_Header, Search_Condition, ChargesSearch_Values);

		Step_End(10, " Enter the Bank charges and select the bank nominal", test, test1);

		Step_Start(11, "Enter the ROE Difference and select ROE/Diff value", test, test1);
		waitForElement(driver, roe_Differencfe_Textfield_RR);
		clearAndType(driver, roe_Differencfe_Textfield_RR, roeDifference);
		waitForElement(driver, roe_Differencfe_Textfield_RR);

		click(driver, cheque_TT_No_Textfield_RR);
		click(driver, roe_Difference_SearchButton_RR);
		waitForElement(driver, acccountName_Filter_RR);

		twoColumnMultipleSearchWindow(driver, ROESearch_Header, Search_Condition, ROESearch_Values);

		Step_End(11, "Enter the ROE Difference and select ROE/Diff value", test, test1);
		Step_Start(12, "Enter the local amount with Numeric values upto 12 characters", test, test1);

		waitForElement(driver, localAmount_Textfield_RR);
		clearAndType(driver, localAmount_Textfield_RR, localAmt);
		waitForElement(driver, localAmount_Textfield_RR);
		click(driver, cheque_TT_No_Textfield_RR);
		waitForElement(driver, localAmount_Textfield_RR);
		String Local_amount = getAttribute(driver, localAmount_Textfield_RR, "value");
		int total_Local_amount_size = Local_amount.length();
		int exp_Limit_Of_Local_Amount_Input = Integer.parseInt(Limit_Of_Local_Amount_Input);
	
		if(exp_Limit_Of_Local_Amount_Input>=total_Local_amount_size) {
			System.out.println("Matched || The Expected : Number Of Charecter Should be Accept In  Local Amount Field : "+exp_Limit_Of_Local_Amount_Input+" || Actual Number Of Charecter is Accept In Local Amount Field : "+total_Local_amount_size);
			Extent_pass_New(driver,"Matched || The Expected Number Of Charecter Should be  Accept In  Local Amount Field : "+exp_Limit_Of_Local_Amount_Input+" || Actual Number Of Charecter is Accept In Local Amount Field : "+total_Local_amount_size, test, test1);
		}else {
			System.out.println("Not Matched || The Expected Number Of Charecter Should be  Accept In  Local Amount Field : "+exp_Limit_Of_Local_Amount_Input+" || Actual Number Of Charecter is Accept In Local Amount Field : "+total_Local_amount_size);
			Extent_fail(driver,"Not Matched || The Expected Number Of Charecter Should be  Accept In  Local Amount Field : "+exp_Limit_Of_Local_Amount_Input+" || Actual Number Of Charecter is Accept In Local Amount Field : "+total_Local_amount_size, test, test1);
		}
		Step_End(12, "Enter the local amount with Numeric values upto 12 characters", test, test1);
		Step_Start(13, "Click on Add button without \"selecting the invoice\"", test, test1);
		waitForElement(driver, Total_Amount_RR);
		clearAndType(driver, Total_Amount_RR, Total_Amount);
		waitForElement(driver, Total_Amount_RR);
		click(driver, cheque_TT_No_Textfield_RR);
		waitForElement(driver, add_Button_Cash_Bank_Details_RR);
		click(driver, add_Button_Cash_Bank_Details_RR);

		Step_End(13, "Click on Add button without \"selecting the invoice\"", test, test1);
		Step_Start(14, "Click save, system should show pop up validation as \"Select the Invoice\"", test, test1);
		waitForDisplay(driver, Select_Nominal_RR);
		if (isDisplayed(driver, Select_Nominal_RR)) {
			click1(driver, Select_Nominal_RR);
		}
		waitForPopup(driver, popup_Message,Saved_Popup);
	
		String actual_Msg = getText(driver, popup_Message);
		if(Saved_Popup.equals(actual_Msg)) {
			System.out.println("Matched || Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : "+Saved_Popup+" ||  Actual : After click on save button Popup value is display in the Receivable Receipt Screen : "+actual_Msg);
			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : "+Saved_Popup+" ||  Actual :After click on save button Popup value is display in the Receivable Receipt Screen : "+actual_Msg, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen: "+Saved_Popup+" || Actual :After click on save button Popup value is not display in the Receivable Receipt Screen : "+actual_Msg);
			Extent_fail(driver, "Not Matched || Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : "+Saved_Popup+" || Actual :After click on save button Popup value is not  display in the Receivable Receipt Screen : "+actual_Msg, test, test1);
		}
		Step_Start(14, "Click save, system should show pop up validation as \"Select the Invoice\"", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
