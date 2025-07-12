package LRP_Finance_Receivable_Receipt_Scripts;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Receivable_Receipt_RR18 extends Keywords {

	public void Receivable_Receipt_RR18(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Receivable_Receipt_RR18";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String receivable_Receipt_Module = Excel_data.get("receivable_Receipt_Module");
		String customer_Name_Data = Excel_data.get("customer_Data");
		String trans_Number_Data = Excel_data.get("trans_Number_Data").trim();
		String cheque_Txtfld_Data = Excel_data.get("cheque_Txtfld_Data").trim();
		String currencyCode = Excel_data.get("currencyCode");
		String roe_Treasury_Module = Excel_data.get("roe_Treasury_Module");
		String Trans_Date_Check_Box = Excel_data.get("Trans_Date_Check_Box");//
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
		String Date_Picker = Excel_data.get("Date_Picker");
		String Currency_Header = Excel_data.get("Currency_Header");
		String SearchCustomer_Header = Excel_data.get("SearchCustomer_Header");
		String SearchCustomer_value = Excel_data.get("SearchCustomer_value");
		String Search_Condition = Excel_data.get("Search_Condition");
		String DepositSearch_Header = Excel_data.get("DepositSearch_Header");
		String DepositSearch_Values = Excel_data.get("DepositSearch_Values");
		String BankSearch_Header = Excel_data.get("BankSearch_Header");
		String BankSearch_Values = Excel_data.get("BankSearch_Values");
		String Treasury_ROE_Header = Excel_data.get("Treasury_ROE_Header");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		moduleNavigate(driver, receivable_Receipt_Module);

		Step_Start(1, "Click on the new button in the tool bar", test, test1);

		newButton(driver);

		Step_End(1, "Click on the new button in the tool bar", test, test1);

		Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);

		LocalDate current_Date = getOnlyCurrentDate();

		waitForElement(driver, RR_Reciept_Date);
		String actual_Receipt_Date = getAttribute(driver, RR_Reciept_Date, "value");
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

		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);

		waitForElement(driver, RR_Reciept_Date);
		String actual_Reciept_Date = getAttribute(driver, RR_Reciept_Date, "value");

		waitForElement(driver, RR_Open_Period);
		String actual_Open_Period = getText(driver, RR_Open_Period);

		if(compareMonthAndYear(actual_Reciept_Date, actual_Open_Period)) {
			System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
			Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
		} else {
			System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
			Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
		}

		

		Step_End(3, "Open period will get automatically populated based on receipt date", test, test1);

		Step_Start(4, "Select the Customer Name from the search icon in the customer tab", test, test1);
		
		waitForElement(driver, RR_Customer_Code);
		click(driver, RR_Customer_Code);
		
		waitForElement(driver, RR_Customer_Text_Field);
		sendKeys(driver, RR_Customer_Text_Field, customer_Name_Data);

		click(driver, RR_Customer_Search);

		waitForElement(driver, RR_Customer_Code_Text_Field);

		twoColumnMultipleSearchWindow(driver, SearchCustomer_Header, Search_Condition, SearchCustomer_value);

		Step_End(4, "Select the Customer Name from the search icon in the customer tab", test, test1);

		Step_Start(5, "Select Get Details and click show invoice", test, test1);

		waitForElement(driver, get_Details_Btn_Rr);
		click(driver, get_Details_Btn_Rr);

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

		waitForElement(driver, show_Invoice_Btn_Rr);
		click(driver, show_Invoice_Btn_Rr);

		Step_End(5, "Select Get Details and click show invoice", test, test1);

		Step_Start(6, "Select the respective transaction number and select and make full payment", test, test1);

		String trans_Number_Select = String.format(RR_Select_Trans_Number_Check_Box, trans_Number_Data);
		waitForElement(driver, trans_Number_Select);
		click(driver, trans_Number_Select);

		Step_End(6, "Select the respective transaction number and select and make full payment", test, test1);

		Step_Start(7, "Click Cash/Bank Detail tab", test, test1);

		waitForElement(driver, cash_Bank_Detail_Tab_Rr);
		click(driver, cash_Bank_Detail_Tab_Rr);

		Step_End(7, "Click Cash/Bank Detail tab", test, test1);

		Step_Start(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);

		waitForElement(driver, chequeTT_No_Txtfld_Rr);
		sendKeys(driver, chequeTT_No_Txtfld_Rr, cheque_Txtfld_Data);

		Step_End(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);

		Step_Start(9, "Select Deposit A/c", test, test1);

		click(driver, deposit_Ac_Search_Btn_Rr);

		waitForElement(driver, account_Head_Txtfld_Rr);
		twoColumnMultipleSearchWindow(driver, DepositSearch_Header, Search_Condition, DepositSearch_Values);

		Step_End(9, "Select Deposit A/c", test, test1);

		Step_Start(10, "Select Bank", test, test1);

		waitForElement(driver, bank_Search_Btn_Rr);
		click(driver, bank_Search_Btn_Rr);

		waitForElement(driver, bank_Code_Txtfld_Rr);

		twoColumnMultipleSearchWindow(driver, BankSearch_Header, Search_Condition, BankSearch_Values);

		Step_End(10, "Select Bank", test, test1);

		Step_Start(11, "Select the Currency", test, test1);

		click(driver, currency_SearcButton_RR);
		waitForElement(driver, currencyCode_Filter_RR);

		twoColumnSearchWindow(driver, Currency_Header, Search_Condition, currencyCode);

		waitForElement(driver, roe_Cash_Bank_Tab_RR);
		String roe_Value_In_Cash_Bank_tab = getAttribute(driver, roe_Cash_Bank_Tab_RR, "value");

		Step_End(11, "Select the Currency", test, test1);

		moduleNavigate(driver, roe_Treasury_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		String roe_Date_Data = actual_Receipt_Date.replace("/", "-");
		waitForElement(driver, roe_date_Txtfld_Tr);
		
		twoColumnSearchWindow(driver, Treasury_ROE_Header, Search_Condition, roe_Date_Data);
		
		waitForElement(driver, currency_Code_Txtfld_Roe);
		sendKeys(driver, currency_Code_Txtfld_Roe, currencyCode);

		Step_Start(12, "ROE value should get automatically selected based on document currency", test, test1);

		waitForElement(driver, roe_Cell_Roe);

		String roe_Value_In_TreasuryRoe = getText(driver, roe_Cell_Roe);

		DecimalFormat df = new DecimalFormat("#.000");
		String roe_Value_In_Cash_Bank_tab_1 = df.format(Double.parseDouble(roe_Value_In_Cash_Bank_tab));
		String roe_Value_In_TreasuryRoe_1 = df.format(Double.parseDouble(roe_Value_In_TreasuryRoe));


		if (roe_Value_In_Cash_Bank_tab_1.equals(roe_Value_In_TreasuryRoe_1)) {

			
			System.out.println("MATCHED ||EXPECTED : ROE value should be get automatically selected based on document currency : " + roe_Value_In_Cash_Bank_tab_1+ "|| ROE value is get automatically selected based on document currency: " + roe_Value_In_TreasuryRoe_1);
			Extent_pass_New(driver,"MATCHED ||EXPECTED : ROE value should be get automatically selected based on document currency : " + roe_Value_In_Cash_Bank_tab_1+ "|| ROE value is get automatically selected based on document currency : " + roe_Value_In_TreasuryRoe_1,test, test1);
		} else {

			
			System.out.println("NOT MATCHED || EXPECTED: ROE value should be get automatically selected based on document currency : " + roe_Value_In_Cash_Bank_tab_1+ "|| ROE value is not  get automatically selected based on document currency: " + roe_Value_In_TreasuryRoe_1);
			Extent_fail(driver,"NOT MATCHED || EXPECTED: ROE value should be get automatically selected based on document currency: " + roe_Value_In_Cash_Bank_tab_1+ "|| ROE value is not get automatically selected based on document currency : " + roe_Value_In_TreasuryRoe_1,test, test1);
		}

		Step_End(12, "ROE value should get automatically selected based on document currency", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
