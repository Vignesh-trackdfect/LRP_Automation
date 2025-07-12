package LRP_Finance_Receivable_Receipt_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_Receivable_Receipt_RR17 extends Keywords {

	public void Receivable_Receipt_RR17(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Receivable_Receipt_RR17";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String receivable_Receipt_Module = Excel_data.get("receivable_Receipt_Module");
		String Receipt_Date_Input = Excel_data.get("Receipt_Date_Input");
		String customer_Name_Data = Excel_data.get("customer_Data");
		String trans_Number_Data = Excel_data.get("trans_Number_Data").trim();
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
		String Date_Picker = Excel_data.get("Date_Picker");
		String SearchCustomer_Header = Excel_data.get("SearchCustomer_Header");
		String SearchCustomer_value = Excel_data.get("SearchCustomer_value");
		String Search_Condition = Excel_data.get("Search_Condition");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		moduleNavigate(driver, receivable_Receipt_Module);
		Step_Start(1, "Click on the new button in the tool bar", test, test1);

		newButton(driver);
		Step_End(1, "Click on the new button in the tool bar", test, test1);

		waitForElement(driver, RR_Reciept_Date);
		String actual_Receipt_Date = null;
		if (Receipt_Date_Input.equals("")) {

			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);

			LocalDate current_Date = getOnlyCurrentDate();

			waitForElement(driver, RR_Reciept_Date);

			actual_Receipt_Date = getAttribute(driver, RR_Reciept_Date, "value");
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

		} else {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			waitForElement(driver, RR_Reciept_Date);
			if (Date_Picker.equalsIgnoreCase("Yes")) {

				selectDatePicker(driver, RR_Reciept_Date, Receipt_Date_Input);
			} else {
				waitForElement(driver, RR_Reciept_Date);
				clearAndType(driver, RR_Reciept_Date, Receipt_Date_Input);
			}
			waitForElement(driver, RR_Reciept_Date);
			actual_Receipt_Date = getAttribute(driver, RR_Reciept_Date, "value");

			if (Receipt_Date_Input.equals(actual_Receipt_Date)) {
				System.out.println("Matched || Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+ Receipt_Date_Input + " || The Actual Receipt Date is Automatically Selected Based On Month : "+ actual_Receipt_Date);
				Extent_pass_New(driver,"Matched || Receipt Date  Should be Automatically Selected Based On Month || Expected Current Date : "+ Receipt_Date_Input + " || The Actual Receipt Date is Automatically Selected Based On Month : "+ actual_Receipt_Date,test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+ Receipt_Date_Input + " || The Actual Receipt Date is Not Automatically Selected Based On Month : " + actual_Receipt_Date);
				Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+ Receipt_Date_Input + " || The Actual Receipt Date is Not Automatically Selected Based On Month : " + actual_Receipt_Date,test, test1);
			}
			
			
			Step_End(2, "Receipt date will be automatically selected based on month", test, test1);

		}

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

		Step_Start(6, "Select the respective transaction number ", test, test1);


		String trans_Number_Select = String.format(RR_Select_Trans_Number_Check_Box, trans_Number_Data);
		waitForElement(driver, trans_Number_Select);
		click(driver, trans_Number_Select);
		
		Step_End(6, "Select the respective transaction number ", test, test1);

		Step_Start(7, "Click Cash/Bank Detail tab", test, test1);

		waitForElement(driver, cash_Bank_Detail_Tab_Rr);
		click(driver, cash_Bank_Detail_Tab_Rr);

		Step_End(7, "Click Cash/Bank Detail tab", test, test1);

		Step_Start(8, "In Cash/Bank Detail, date should be the same as Receipt date", test, test1);

		waitForElement(driver, date_Cash_Bank_Details_RR);

		String date_Cash_Bank = getAttribute(driver, date_Cash_Bank_Details_RR, "value");

		if (actual_Receipt_Date.equals(date_Cash_Bank)) {

			System.out.println("BOTH ACTUAL PAYMENT DATE AND CASH_BANK DATES ARE EQUAL");
			System.out.println("MATCHED || Expeted : After click on In Cash/Bank Detail ,Date should be the same as Receipt date : "+actual_Receipt_Date+" Actual The Receipt date  : "+date_Cash_Bank+"Click on In Cash/Bank Detail ,Date is the same as Receipt date");
			Extent_pass_New(driver, "MATCHED || Expeted : After click on In Cash/Bank Detail ,Date should be the same as Receipt date "+actual_Receipt_Date+"  Actual The Receipt date  : "+date_Cash_Bank+"Click on In Cash/Bank Detail ,Date is the same as Receipt date", test, test1);
		} else {
			System.out.println("BOTH ACTUAL PAYMENT DATE AND CASH_BANK DATES ARE EQUAL");
			System.out.println("Not MATCHED || Expeted : After click on In Cash/Bank Detail ,Date should be the same as Receipt date : "+actual_Receipt_Date+" Actual The Receipt date  : "+date_Cash_Bank+"Click on In Cash/Bank Detail ,Date is Not same as Receipt date");
			Extent_fail(driver, "Not MATCHED || Expeted : After click on In Cash/Bank Detail ,Date should be the same as Receipt date "+actual_Receipt_Date+"  Actual The Receipt date  : "+date_Cash_Bank+"Click on In Cash/Bank Detail ,Date is Npt same as Receipt date", test, test1);
			
		}
		Step_End(8, "In Cash/Bank Detail, date should be the same as Receipt date", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
