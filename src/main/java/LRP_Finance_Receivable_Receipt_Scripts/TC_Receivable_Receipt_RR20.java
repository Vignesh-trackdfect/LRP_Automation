package LRP_Finance_Receivable_Receipt_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Receivable_Receipt_Locators;

public class TC_Receivable_Receipt_RR20 extends Keywords {

	public void Receivable_Receipt_RR20(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Receivable_Receipt_RR20";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String receivable_Receipt_Module = Excel_data.get("receivable_Receipt_Module");
		String Date_Picker = Excel_data.get("Date_Picker");
		String customer_Name_Data = Excel_data.get("customer_Data");
		String trans_Number_Data = Excel_data.get("trans_Number_Data").trim();
		String cheque_Drpdwn_Data = Excel_data.get("cheque_Drpdwn_Data");
		String description_Data = Excel_data.get("description_Data");
		String expected_Popup = Excel_data.get("expected_Popup");
		String chequeTt_Data = Excel_data.get("chequeTt_Data");
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
		String SearchCustomer_Header = Excel_data.get("SearchCustomer_Header");
		String SearchCustomer_value = Excel_data.get("SearchCustomer_value");
		String Search_Condition = Excel_data.get("Search_Condition");
		String DepositSearch_Header = Excel_data.get("DepositSearch_Header");
		String DepositSearch_Values = Excel_data.get("DepositSearch_Values");
		String BankSearch_Header = Excel_data.get("BankSearch_Header");
		String BankSearch_Values = Excel_data.get("BankSearch_Values");
		String Receipt_Date_Input = Excel_data.get("Receipt_Date_Input");
		String cheque_Drpdwn_Option_Rr=String.format(Receivable_Receipt_Locators.cheque_Drpdwn_Option_Rr, cheque_Drpdwn_Data);

		
		
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		moduleNavigate(driver, receivable_Receipt_Module);
		Step_Start(1, "Click on the new button in the tool bar", test, test1);

		newButton(driver);
		Step_End(1, "Click on the new button in the tool bar", test, test1);

		Step_Start(2, "Select the receipt date in future from the date picker", test, test1);
		
		waitForElement(driver, RR_Reciept_Date);
		String actual_Reciept_Date = getAttribute(driver, RR_Reciept_Date, "value");
		
		waitForElement(driver, RR_Reciept_Date);
		if(Date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, RR_Reciept_Date, Receipt_Date_Input);
			
		}
		else {
			waitForElement(driver, RR_Reciept_Date);
			clearAndType(driver, RR_Reciept_Date, Receipt_Date_Input);
		}

		Step_End(2, "Receipt date will be automatically selected based on month", test, test1);

		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);

		
		waitForElement(driver, RR_Open_Period);
		String actual_Open_Period= getText(driver, RR_Open_Period);
		
	
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
		
		if(!Trans_From_Date.equals("")) {
			if (!Trans_From_Date.equals("")) {
				waitForElement(driver, RR_Trans_From_Date);
				if (Date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, RR_Trans_From_Date, Trans_From_Date);
				 }else {
					waitForElement(driver, RR_Trans_From_Date);
					clearAndType(driver, RR_Trans_From_Date, Trans_From_Date);
				}
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
		if(!Currency_Select_Option.equals("")) {
			waitForElement(driver, RR_Currency_Select);
				click(driver, RR_Currency_Select);
				String Select_Currency=String.format(RR_Currency_Select_Option, Currency_Select_Option);
				waitForElement(driver, Select_Currency);
				click(driver, Select_Currency);
		}
		if(!From_Trans_No.equals("")) {
			waitForElement(driver, RR_Currency_Select);
			sendKeys(driver, RR_From_Trans_No, From_Trans_No);
		}
		if(!To_Trans_No.equals("")) {
			waitForElement(driver, RR_To_Trans_No);
			sendKeys(driver, RR_To_Trans_No, To_Trans_No);
		}
		if(!From_Amount_Range.equals("")) {
			waitForElement(driver, RR_From_Amount_Range);
			sendKeys(driver, RR_From_Amount_Range, From_Amount_Range);
		}
		if(!To_Amount_Range.equals("")) {
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
		
		waitForElement(driver, cheque_Drpdwn_Rr);
		click(driver, cheque_Drpdwn_Rr);
		
		waitForElement(driver, cheque_Drpdwn_Option_Rr);
		click(driver, cheque_Drpdwn_Option_Rr);
		
		waitForElement(driver, chequeTT_No_Txtfld_Rr);
		sendKeys(driver, chequeTT_No_Txtfld_Rr, chequeTt_Data);
		
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

		Step_Start(11, "Click Add", test, test1);
		
		waitForElement(driver, add_Symbol_Rr);
		click(driver, add_Symbol_Rr);
		Step_End(11, "Click Add", test, test1);

		Step_Start(12, "Click Post tab", test, test1);
		
		waitForElement(driver, post_Tab_Rr);
		click(driver, post_Tab_Rr);
		
		Step_End(12, "Click Post tab", test, test1);

		Step_Start(13, "Click 'Post' button", test, test1);
		
		waitForElement(driver, post_Btn_Rr);
		click(driver, post_Btn_Rr);
		
		Step_End(13, "Click 'Post' button", test, test1);

		Step_Start(14, "Enter the description field with an alphanumeric upto 4500 characters", test, test1);
		
		waitForElement(driver, description_Txtfld_Rr);
		sendKeys(driver, description_Txtfld_Rr, description_Data);
		
		Step_End(14, "Enter the description field with an alphanumeric upto 4500 characters", test, test1);

		Step_Start(15, "Click on Save button from the toolbar", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(15, "Click on Save button from the toolbar", test, test1);

		Step_Start(16, "Click save, system should show the pop up message as 'Receipt Date must be earlier than or equal to current date'", test, test1);
		
		waitForPopup(driver, popup_Message,expected_Popup);
		String actual_Popup = getText(driver, popup_Message);
		
		if(expected_Popup.equals(actual_Popup)) {
			
			
			System.out.println("Matched || Expected popup: After click save, system should be show the pop up message as The Receipt Date must be earlier than or equal to the current date  : " + expected_Popup + " || Actual Saved Popup :  After click save, system is show the pop up message as The Receipt Date must be earlier than or equal to the current date" + actual_Popup);
    		Extent_pass_New(driver,"Matched || Expected popup: After click save, system should be show the pop up message as The Receipt Date must be earlier than or equal to the current date :" + expected_Popup + " || Actual Saved Popup :  After click save, system is show the pop up message as The Receipt Date must be earlier than or equal to the current date : " + actual_Popup, test,test1);

		}else {
			
			System.out.println("Not Matched || Expected popup: After click save, system should be show the pop up message as The Receipt Date must be earlier than or equal to the current date  : " + expected_Popup + " || Actual Saved Popup :  After click save, system is show the pop up message as The Receipt Date must be earlier than or equal to the current date" + actual_Popup);
			Extent_fail(driver, "NOT MATCHED || Expected popup: After click save, system should be show the pop up message as The Receipt Date must be earlier than or equal to the current date : "+expected_Popup+" || ACTUAL Saved Popup :  After click save, system is show the pop up message as The Receipt Date must be earlier than or equal to the current date"+actual_Popup, test, test1);
		
		}
		
		Step_End(16, "Click save, system should show the pop up message as 'Receipt Date must be earlier than or equal to current date'", test, test1);

		
		
		Extent_completed(testcase_Name, test, test1);
	}

}
