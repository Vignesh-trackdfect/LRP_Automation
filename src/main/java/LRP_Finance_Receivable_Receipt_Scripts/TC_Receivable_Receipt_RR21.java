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

public class TC_Receivable_Receipt_RR21 extends Keywords{
	public void Receivable_Receipt_RR21(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Receivable_Receipt_RR21";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Receivable_Receipt_Module = Excel_data.get("Receivable_Receipt_Module");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Receipt_Date_Input = Excel_data.get("Receipt_Date_Input");
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
		String Transaction_Number = Excel_data.get("Transaction_Number");
		String cheque_TT_No = Excel_data.get("cheque_TT_No");
		String description_Data = Excel_data.get("description_Data");
		String Saved_Popup = Excel_data.get("Saved_Popup");
		String Limit_Of_Description_Input = Excel_data.get("Limit_Of_Description_Input");
		String cheque_Cash_TT = Excel_data.get("cheque_Cash_TT");
		String cash_Bank_Details_Date = Excel_data.get("cash_Bank_Details_Date");
		String Limit_Of_Cheque_No_Input = Excel_data.get("Limit_Of_Cheque_No_Input");
		String customer_Header= Excel_data.get("Custome_Header");
		String customer_Header_value= Excel_data.get("Custome_Header_value");
		String customer_Header_filter= Excel_data.get("Customer_filter");
		String Deposit_Header= Excel_data.get("Deposit_Header");
		String Deposit_Header_value= Excel_data.get("Deposit_Header_value");
		String Deposit_Header_filter= Excel_data.get("Deposit_filter");
		String Bank_Header= Excel_data.get("Bank_Header");
		String Bank_Header_value= Excel_data.get("Bank_Header_value");
		String Bank_Header_filter= Excel_data.get("Bank_filter");
		String localAmt = Excel_data.get("LocalAmt");
		String ROE_Diff_Header= Excel_data.get("ROE_Diff_Header");
		String ROE_Diff_Value= Excel_data.get("ROE_Diff_Value");
		String Roe_Difference_Amount= Excel_data.get("Roe_Difference_Amount");
		
		Extent_Start(testcase_Name, test, test1);

		//Login
		navigateUrl(driver, url);                                                                                                  
		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, Receivable_Receipt_Module);

		Step_Start(1, "Click on the new button in the tool bar", test, test1);
		newButton(driver);
		Step_End(1, "Click on the new button in the tool bar", test, test1);

		Step_Start(2, "Select receipt date as past date from the current date", test, test1);
		waitForElement(driver, RR_Receipt_Date);
		
		if(Date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, RR_Receipt_Date, Receipt_Date_Input);
			
		}
		else {
			waitForElement(driver, RR_Receipt_Date);
			clearAndType(driver, RR_Receipt_Date, Receipt_Date_Input);
		}

		Step_End(2, "Select receipt date as past date from the current date", test, test1);

		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);


		waitForElement(driver, RR_Receipt_Date);
		String actual_Reciept_Date = getAttribute(driver, RR_Receipt_Date, "value");
		
		LocalDate Current_Date = getOnlyCurrentDate();
		DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate actual_date = LocalDate.parse(actual_Reciept_Date, dateFormatter1);
        
         if(actual_date.isBefore(Current_Date)) {
        	 
		if (Receipt_Date_Input.equals(actual_Reciept_Date)) {
			System.out.println("Matched || Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || Receipt Date is Automatically Selected Based On Month : "+actual_Reciept_Date);
			Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || Receipt Date is Automatically Selected Based On Month : "+actual_Reciept_Date, test, test1);
		} else {
			System.out.println("Not Matched || Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || Receipt Date is Not Automatically Selected Based On Month : "+actual_Reciept_Date);
			Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || Receipt Date is Not Automatically Selected Based On Month: "+actual_Reciept_Date, test, test1);
		}
		
		
		waitForElement(driver, RR_Open_Period);
		String actual_Open_Period= getText(driver, RR_Open_Period);
		System.out.println("actual_Open_Period :"+actual_Open_Period);
		
	
		if(compareMonthAndYear(actual_Reciept_Date, actual_Open_Period)) {
			System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
			Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
		} else {
			System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
			Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
		}

		Step_End(3, "Open period will get automatically populated based on receipt date", test, test1);

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
				selectDatePicker(driver, RR_Trans_From_Date, Trans_From_Date);
				
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

		Step_Start(6, "Select the respective transaction number and select and make full payment", test, test1);
		
		
		String trans_Number_Select = String.format(RR_Select_Trans_Number_Check_Box, Transaction_Number);
		waitForElement(driver, trans_Number_Select);
		click(driver, trans_Number_Select);		
		
		Step_End(6, "Select the respective transaction number and select and make full payment", test, test1);

		Step_Start(7, "Click on Cash/Bank Detail tab", test, test1);
		waitForElement(driver, cash_Bank_Details_Tab_RR);
		click(driver, cash_Bank_Details_Tab_RR);
		Step_End(7, "Click on Cash/Bank Detail tab", test, test1);

		Step_Start(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);
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
			

		Step_End(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);

		if(!cheque_Cash_TT.equals("")) {
			String cheque_Drpdwn_Option_Rr=String.format(cheque_Cash_TT_Option, cheque_Cash_TT);
			waitForElement(driver, cheque_Drpdwn_Option_Rr);
			click(driver, cheque_Drpdwn_Option_Rr);
		}
		if(!cash_Bank_Details_Date.equals("")) {
			waitForElement(driver, date_Cash_Bank_Details_RR);
			if(Date_Picker.equalsIgnoreCase("Yes")) {	
				selectDatePicker(driver, date_Cash_Bank_Details_RR, cash_Bank_Details_Date);
			}
			else {
				waitForElement(driver, date_Cash_Bank_Details_RR);
				clearAndType(driver, date_Cash_Bank_Details_RR, cash_Bank_Details_Date);
				click(driver, cheque_TT_No_Textfield_RR);
			}
		}
		
		
		Step_Start(9, "Select the Deposit A/c", test, test1);
		click(driver, depositAC_SearchButton_RR);
		
		twoColumnMultipleSearchWindow(driver,Deposit_Header,Deposit_Header_filter,Deposit_Header_value);
		
		Step_End(9, "Select the Deposit A/c", test, test1);

		Step_Start(10, "Select the Bank", test, test1);
		waitForElement(driver, bank_SearchButton_RR);
		click(driver, bank_SearchButton_RR);
		
		twoColumnMultipleSearchWindow(driver,Bank_Header,Bank_Header_filter,Bank_Header_value);
		
		waitForElement(driver, localAmount_Textfield_RR);
		clearAndType(driver, localAmount_Textfield_RR, localAmt);
		waitForElement(driver, localAmount_Textfield_RR);
		click(driver, cheque_TT_No_Textfield_RR);
		 
		Step_End(10, "Select the Bank", test, test1);

		if(!Roe_Difference_Amount.trim().equals("")) {
			waitForElement(driver, roe_Differencfe_Textfield_RR);
			clearAndType(driver, roe_Differencfe_Textfield_RR, Roe_Difference_Amount);
			waitForElement(driver, roe_Differencfe_Textfield_RR);
			click(driver, cheque_TT_No_Textfield_RR);
		}
		
		if(!ROE_Diff_Value.trim().equals("")) {
			waitForElement(driver, roe_Difference_SearchButton_RR);
			click(driver,roe_Difference_SearchButton_RR);
			twoColumnMultipleSearchWindow(driver,ROE_Diff_Header,Bank_Header_filter,ROE_Diff_Value);
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

		Step_Start(14, "Enter the description field with an alphanumeric upto 250 characters.", test, test1);

		waitForElement(driver, description_Txtfld_Rr);
		sendKeys(driver, description_Txtfld_Rr, description_Data);
		waitForElement(driver, description_Txtfld_Rr);
		String Description_Input = getTextJavascript(driver, description_Txtfld_Rr);
		int total_Description_Input = Description_Input.length();
		int exp_Limit_Of_Description_Input = Integer.parseInt(Limit_Of_Description_Input);
		
		if(exp_Limit_Of_Description_Input>=total_Description_Input) {
			System.out.println("Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Accept In Description Field : "+total_Description_Input);
			Extent_pass_New(driver,"Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Accept In Description Field : "+total_Description_Input, test, test1);
		}else {
			System.out.println("Not Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Not  Accept In Description Field : "+total_Description_Input);
			Extent_fail(driver,"Not Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Not Accept In Description Field : "+total_Description_Input, test, test1);
		}
		
		
	
		Step_End(14, "Enter the description field with an alphanumeric upto 250 characters.", test, test1);

		Step_Start(15, "Click on Save button from the toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(15, "Click on Save button from the toolbar", test, test1);

		Step_Start(16, "Click save, should show the pop up message as Receivable Receipt Saved\"", test, test1);
		
		waitForPopup(driver, popup_Message,Saved_Popup);
		
		String Saved_Receipt_Popup=getText(driver, popup_Message);
         if(Saved_Popup.equals(Saved_Receipt_Popup)) {
        		System.out.println("Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : " + Saved_Popup + " || Actual After click on save button Popup value is display in the Receivable Receipt Screen : " + Saved_Receipt_Popup);
        		Extent_pass_New(driver,"Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : " + Saved_Popup + " || Actual After click on save button Popup value is display in the Receivable Receipt Screen : : " + Saved_Receipt_Popup, test,test1);
    
           
         } else {
    			System.out.println("Not Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : " + Saved_Popup + " || Actual After click on save button Popup value is Not display in the Receivable Receipt Screen : : " + Saved_Receipt_Popup);
    			Extent_fail(driver,"Not Expected : After click on save button Popup value should be display in the Receivable Receipt Screen:  " + Saved_Popup + " || Actual After click on save button Popup value is Not display in the Receivable Receipt Screen :  : " + Saved_Receipt_Popup,test, test1);
    		}

         waitForElement(driver, popup_Message_Ok_Button);
         click(driver, popup_Message_Ok_Button);
		Step_End(16, "Click save, should show the pop up message as \"Receivable Receipt Saved\"", test, test1);
         
         }else {
        	 System.out.println("Expected Result is : system should not allow to create a receivable receipt by past date || Actual Result is :  system not allows to create a receivable receipt by past date ");
        	 Extent_fail(driver, "Expected Result is : system should not allow to create a receivable receipt by past date || Actual Result is :  system not allows to create a receivable receipt by past date ", test, test1);
         }
         Step_End(16, "Click save, should show the pop up message as Receivable Receipt Saved", test, test1);
         
         Extent_completed(testcase_Name, test, test1);
	}

}
