package LRP_Finance_Receivable_Receipt_Scripts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Receivable_Receipt_RR23 extends Keywords{
	public void Receivable_Receipt_RR23(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Receivable_Receipt_RR23";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Receivable_Receipt_Module = Excel_data.get("Receivable_Receipt_Module");
		String Customer_Name = Excel_data.get("Customer_Name");
		String Receipt_Date_Input = Excel_data.get("Receipt_Date_Input");
		String Date_Picker = Excel_data.get("Date_Picker");
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
		String Transaction_Numbers = Excel_data.get("Transaction_Numbers");
		String cheque_TT_No = Excel_data.get("cheque_TT_No");
		String Saved_Popup = Excel_data.get("Saved_Popup");
		String description_Data = Excel_data.get("description_Data");
		String roeDifference = Excel_data.get("roeDifference");
		String customer_Header= Excel_data.get("Custome_Header");
		String customer_Header_value= Excel_data.get("Custome_Header_value");
		String customer_Header_filter= Excel_data.get("Customer_filter");
		String Deposit_Header= Excel_data.get("Deposit_Header");
		String Deposit_Header_value= Excel_data.get("Deposit_Header_value");
		String Deposit_Header_filter= Excel_data.get("Deposit_filter");
		String Bank_Header= Excel_data.get("Bank_Header");
		String Bank_Header_value= Excel_data.get("Bank_Header_value");
		String Bank_Header_filter= Excel_data.get("Bank_filter");
		String Bank_Charges_headers= Excel_data.get("Bank_Charges_headers");
		String Bank_Charges_header_values= Excel_data.get("Bank_Charges_header_values");
		String Bank_Charges_filters= Excel_data.get("Bank_Charges_filters");
		String Bank_Charges =Excel_data.get("Bank_Charges");
		String receipt_TotalAmount =Excel_data.get("receipt_TotalAmount");
	
		String ROE_Diff_Header= Excel_data.get("ROE_Diff_Header");
		String ROE_Diff_Value= Excel_data.get("ROE_Diff_Value");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);


		moduleNavigate(driver, Receivable_Receipt_Module);
		Step_Start(1, "Click on the new button in the tool bar", test, test1);
	
		Step_Start(1, "Click on the new button in the tool bar", test, test1);
		newButton(driver);
		Step_End(1, "Click on the new button in the tool bar", test, test1);
		
		if(Receipt_Date_Input.equals("")) {
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
			String actual_Open_Period= getText(driver, RR_Open_Period);
			
		
			if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
			}
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}else {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			if(Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, RR_Receipt_Date, Receipt_Date_Input);
			}
			else {
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
			String actual_Open_Period= getText(driver, RR_Open_Period);
		
			if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be  Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" ||  Actual Open Receipt Date : "+actual_Open_Period+" Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Automatically Not Populated Based On Receipt Date || Expected The Receipt Date is : "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date", test, test1);
			}
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}
		
		
		Step_Start(4, "Select the Customer Name from the search icon in the customer tab.", test, test1);
		waitForElement(driver, RR_Customer_Code);
		click(driver,RR_Customer_Code);
		waitForElement(driver, RR_Customer_Text_Field);
		sendKeys(driver, RR_Customer_Text_Field,Customer_Name);
		click(driver, RR_Customer_Search);
	
		
		twoColumnMultipleSearchWindow(driver,customer_Header,customer_Header_filter,customer_Header_value);
		
		Step_End(4, "Select the Customer Name from the search icon in the customer tab.", test, test1);
		
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

		if(!Trans_From_Date.equals("")) {
			waitForElement(driver, RR_Trans_From_Date);
			if(Date_Picker.equalsIgnoreCase("Yes")) {
			
				selectDatePicker(driver, RR_Trans_From_Date, RR_Trans_From_Date);
			}
			else {
				waitForElement(driver, RR_Trans_From_Date);
				clearAndType(driver, RR_Trans_From_Date, Trans_From_Date);
			}
		}
		if(!Trans_To_Date.equals("")) {
			waitForElement(driver, RR_Trans_To_Date);
			if(Date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, RR_Trans_To_Date, Trans_To_Date);
			}
			else {
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
		waitForElement(driver, RR_Show_Invoice_Button);
		click(driver, RR_Show_Invoice_Button);
		
		
		Step_End(5, "Select Get Details and click show invoice", test, test1);
		
		Step_Start(6, "Select the two transaction number and select and make part payment.", test, test1);
		List<String> Trans_Numbers = splitAndExpand(Transaction_Numbers);
		for(String Trans_Number:Trans_Numbers) {
//			
//			String Select_Trans_Number=String.format(invoice_Select_CheckBox, Trans_Number);
//			waitForElement(driver, Select_Trans_Number);
//			click(driver, Select_Trans_Number);
			String trans_Number_Select = String.format(RR_Select_Trans_Number_Check_Box, Trans_Number);
			waitForElement(driver, trans_Number_Select);
			click(driver, trans_Number_Select);		
		
		}

		Step_End(6, "Select the two transaction number and select and make part payment.", test, test1);
		
		Step_Start(7, "Click on Cash/Bank Detail tab", test, test1);
		
		waitForElement(driver, cash_Bank_Details_Tab_RR);
		click(driver, cash_Bank_Details_Tab_RR);
		
		Step_End(7, "Click on Cash/Bank Detail tab", test, test1);
		
		Step_Start(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);
		waitForElement(driver, cheque_TT_No_Textfield_RR);
		sendKeys(driver, cheque_TT_No_Textfield_RR, cheque_TT_No);
		
		Step_End(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);
		
		Step_Start(9, "Select the Deposit A/c", test, test1);
		click(driver, depositAC_SearchButton_RR);
		waitForElement(driver, acccountName_Filter_RR);
		
		twoColumnMultipleSearchWindow(driver,Deposit_Header,Deposit_Header_filter,Deposit_Header_value);
		

		Step_End(9, "Select the Deposit A/c", test, test1);

		Step_Start(10, "Select the Bank", test, test1);
		click(driver, bank_SearchButton_RR);
		twoColumnMultipleSearchWindow(driver,Bank_Header,Bank_Header_filter,Bank_Header_value);
		
		Step_End(10, "Select the Bank", test, test1);

		if(!roeDifference.trim().equals("")) {
			waitForElement(driver, roe_Differencfe_Textfield_RR);
			clearAndType(driver, roe_Differencfe_Textfield_RR, roeDifference);
			waitForElement(driver, roe_Differencfe_Textfield_RR);
			click(driver, cheque_TT_No_Textfield_RR);
			
		}
		
		waitForElement(driver, roe_Differencfe_Textfield_RR);
		String ROE_Amount_Value_Act=getAttribute(driver, roe_Differencfe_Textfield_RR, "value");
		double RoE_Amount_Act=getNumberValue(ROE_Amount_Value_Act);
		
		if(RoE_Amount_Act!=0) {
			waitForElement(driver, roe_Difference_SearchButton_RR);
			click(driver,roe_Difference_SearchButton_RR);
			twoColumnMultipleSearchWindow(driver,ROE_Diff_Header,Bank_Header_filter,ROE_Diff_Value);
		}
		if(!Bank_Charges.trim().equals("")) {
			waitForElement(driver, bank_Charges_Textfield_RR);
			clearAndType(driver, bank_Charges_Textfield_RR, Bank_Charges);
			waitForElement(driver, bank_Charges_Textfield_RR);
			click(driver, cheque_TT_No_Textfield_RR);
	
			waitForElement(driver, bankCharges_SsearchButton_RR);
			click(driver, bankCharges_SsearchButton_RR);
			
			twoColumnMultipleSearchWindow(driver,Bank_Charges_headers,Bank_Charges_filters,Bank_Charges_header_values);
		}
		
		if(!receipt_TotalAmount.equals("")) {
			waitForElement(driver, localAmount_Textfield_RR);
			clearAndType(driver, localAmount_Textfield_RR, receipt_TotalAmount);
			waitForElement(driver, localAmount_Textfield_RR);
			click(driver, cheque_TT_No_Textfield_RR);
		}
		Step_Start(11, "Click Add", test, test1);

		waitForElement(driver, add_Button_Cash_Bank_Details_RR);
		click(driver, add_Button_Cash_Bank_Details_RR);
		Step_End(11, "Click Add", test, test1);

		Step_Start(12, "Click on Post tab", test, test1);
		waitForElement(driver, post_Tab_Rr);
		click(driver, post_Tab_Rr);
		Step_End(12, "Click on Post tab", test, test1);


		Step_Start(13, "Click the post button", test, test1);
		waitForElement(driver, post_Btn_Rr);
		click(driver, post_Btn_Rr);

		Step_End(13, "Click the post button", test, test1);

		Step_Start(14, "Enter the description field with an alphanumeric upto 4500 characters.", test, test1);
		waitForElement(driver, description_Txtfld_Rr);
		sendKeys(driver, description_Txtfld_Rr, description_Data);

		Step_End(14, "Enter the description field with an alphanumeric upto 4500 characters.", test, test1);

		Step_Start(15, "Click on Save button from the toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(15, "Click on Save button from the toolbar", test, test1);

		Step_Start(16, "Click save, should show the pop up message as \"Receivable Receipt Saved\"", test, test1);
		waitForPopup(driver, popup_Message,Saved_Popup);
		
		String Saved_Receipt_Popup=getText(driver, popup_Message);
         if(Saved_Popup.equals(Saved_Receipt_Popup)) {
        		System.out.println("Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : " + Saved_Popup + " || Actual : After click on save button Popup value is display in the Receivable Receipt Screen : " + Saved_Receipt_Popup);
        		Extent_pass_New(driver,"Matched || Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : " + Saved_Popup + " ||Actual : After click on save button Popup value is display in the Receivable Receipt Screen :" + Saved_Receipt_Popup, test,test1);
           
         } else {
    			System.out.println("Not Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen :" + Saved_Popup + " || Actual : After click on save button Popup value is Not display in the Receivable Receipt Screen : " + Saved_Receipt_Popup);
    			Extent_fail(driver,"Not Matched || Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : " + Saved_Popup + " || Actual : After click on save button Popup value is Not display in the Receivable Receipt Screen : " + Saved_Receipt_Popup,test, test1);
    		}

         waitForElement(driver, popup_Message_Ok_Button);
         click(driver, popup_Message_Ok_Button);
		Step_End(16, "Click save, should show the pop up message as \"Receivable Receipt Saved\"", test, test1);
         
		
		Extent_completed(testcase_Name, test, test1);
	}

}
