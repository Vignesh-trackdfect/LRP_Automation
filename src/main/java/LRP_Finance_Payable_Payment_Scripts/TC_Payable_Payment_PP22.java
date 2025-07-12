package LRP_Finance_Payable_Payment_Scripts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Payable_Payment_PP22 extends Keywords{
	public void Payable_Payment_PP22(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Payable_Payment_PP22";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Payable_Payment_Module = Excel_data.get("Payable_Payment_Module");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Vendor_Name = Excel_data.get("Vendor_Name");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code");
		String Amount_Range_Check_Box = Excel_data.get("Amount_Range_Check_Box");
		String Trans_No_Check_Box = Excel_data.get("Trans_No_Check_Box");
		String Currency_Check_Box = Excel_data.get("Currency_Check_Box");
		String Trans_Date_Check_Box = Excel_data.get("Trans_Date_Check_Box");
		String Trans_From_Date = Excel_data.get("Trans_From_Date");
		String Trans_To_Date = Excel_data.get("Trans_To_Date");
		String Currency_Select_Option = Excel_data.get("Currency_Select_Option");
		String From_Trans_No = Excel_data.get("From_Trans_No");
		String To_Trans_No = Excel_data.get("To_Trans_No");
		String From_Amount_Range = Excel_data.get("From_Amount_Range");
		String To_Amount_Range = Excel_data.get("To_Amount_Range");
		String Transaction_Number = Excel_data.get("Transaction_Number");
		String cheque_TT_No = Excel_data.get("Cheque_TT_No");
		String Limit_Of_Cheque_No_Input = Excel_data.get("Limit_Of_Cheque_No_Input");
		String accountName_VAL = Excel_data.get("accountName_VAL");
		String payAmount = Excel_data.get("PayAmount");
		String Limit_Of_Description_Input = Excel_data.get("Limit_Of_Description_Input");
		String description_Data = Excel_data.get("description_Data");
		String Payable_Payment_Popup = Excel_data.get("Payable_Payment_Popup");
		String payment_Date = Excel_data.get("Payment_Date");
		String currencyCode = Excel_data.get("CurrencyCode");
		String documentAmt = Excel_data.get("DocumentAmt");
		String bankCharges = Excel_data.get("BankCharges");
		String accountHead_BankCharges = Excel_data.get("AccountHead_BankCharges");
		String accountName_BankCharges = Excel_data.get("AccountName_BankCharges");
		String roeDifference = Excel_data.get("roeDifference");
		String accountName_ROE = Excel_data.get("AccountName_ROE");
		String accountHead_ROE = Excel_data.get("AccountHead_ROE");
		String currency_SearcButton_PPT_Header = Excel_data.get("currency_SearcButton_PPT_Header");
		String dropdownCondition =Excel_data.get("dropdownCondition");
		String AccountHead_Header = Excel_data.get("AccountHead_Header");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
        String Account_Name_Header = Excel_data.get("Account_Name_Header");
		

		

		Extent_Start(testcase_Name, test, test1);

		
		
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, Payable_Payment_Module);


		Step_Start(1, "Click on the new button in the tool bar", test, test1);
		
         newButton(driver);
       
		Step_End(1, "Click on the new button in the tool bar", test, test1);


		if(payment_Date.equals("")) {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			LocalDate current_Date = getOnlyCurrentDate();

			waitForElement(driver, paymentDate_PPT);
			String actual_Receipt_Date = getAttribute(driver, paymentDate_PPT, "value");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate Receipt_Date = LocalDate.parse(actual_Receipt_Date, formatter);

			
			if (current_Date.equals(Receipt_Date)) {
				System.out.println("Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+Receipt_Date+" Payment Date Automatically Selected Based On Month");
				Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date Selected Based on Month : "+Receipt_Date+"Payment Date Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Payment Date Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Payment Date Not Automatically Selected Based On Month", test, test1);
			}
			
			
			
			Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
			Step_Start(3, "Open period will get automatically populated based on Receipt date", test, test1);
			waitForElement(driver, open_Period_PPT);
			String actual_Open_Period= getText(driver, open_Period_PPT);
			
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
				
				waitForElement(driver, paymentDate_PPT);
				selectDatePicker(driver, paymentDate_PPT, payment_Date);

			}
			else {
				waitForElement(driver, paymentDate_PPT);
				clearAndType(driver, paymentDate_PPT, payment_Date);
			}
			waitForElement(driver, paymentDate_PPT);
			String actual_Receipt_Date = getAttribute(driver, paymentDate_PPT, "value");


         if (payment_Date.equals(actual_Receipt_Date)) {
				System.out.println("Matched || Receipt Date Should be Automatically Select Based On Month : "+payment_Date+" || The Actual Payment Date  : "+actual_Receipt_Date+"Receipt Date Automatically Selected Based On Month");
				Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Select Based On Month : "+payment_Date+" || The Actual Payment Date : "+actual_Receipt_Date+"Receipt Date Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date Should  be Automatically Select Based On Month || Expected Current Date : "+payment_Date+" || The Actual Receipt Date : "+actual_Receipt_Date+"Receipt Date Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Receipt Date Should be  Automatically Select Based On Month || Expected Current Date : "+payment_Date+" || The Actual Receipt Date : "+actual_Receipt_Date+"Receipt Date Not Automatically Selected Based On Month", test, test1);
			}
			
			Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
			Step_Start(3, "Open period will get automatically populated based on Receipt date", test, test1);
			waitForElement(driver, open_Period_PPT);
			String actual_Open_Period= getText(driver, open_Period_PPT);
			
	
			
			if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be  Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" ||  Actual Open Receipt Date : "+actual_Open_Period+" Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Automatically Not Populated Based On Receipt Date || Expected The Receipt Date is : "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date", test, test1);
			}
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}

		Step_Start(4, "Select the vendor Name from the search icon in the vendor tab", test, test1);

		 waitForElement(driver, PP_Vendor_Radio_Button);
	     click(driver, PP_Vendor_Radio_Button);
	     
		
		waitForElement(driver, customer_Searchfield_PPT);
		sendKeys(driver, customer_Searchfield_PPT,Vendor_Name);
		click(driver, customer_SearchButton_PPT);
		
		twoColumnSearchWindow(driver, Vendor_Code_Header, dropdownCondition,Vendor_Code_Value );

		Step_End(4, "Select the vendor Name from the search icon in the vendor tab", test, test1);

		Step_Start(5, "Select Get Details and click show invoice", test, test1);

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
			if(Date_Picker.equalsIgnoreCase("Yes")) {
				click(driver, trans_FromDate_PPT);
				selectDatePicker(driver,trans_FromDate_PPT , date_select);
		
			}
			else {
				waitForElement(driver, trans_FromDate_PPT);
				clearAndType(driver, trans_FromDate_PPT, Trans_From_Date);
			}
		}
		if(!Trans_To_Date.equals("")) {
			waitForElement(driver, trans_ToDate_PPT);
			if(Date_Picker.equalsIgnoreCase("Yes")) {
				click(driver, trans_ToDate_PPT);
				selectDatePicker(driver,trans_ToDate_PPT , date_select);

			}
			else {
				waitForElement(driver, trans_ToDate_PPT);
				clearAndType(driver, trans_ToDate_PPT, Trans_To_Date);
			}
		}
		if(!Currency_Select_Option.equals("")) {
			waitForElement(driver, currency_Select_PPT);
			click(driver, currency_Select_PPT);
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
			sendKeys(driver, amountRange_From_Textfield_PPT, From_Amount_Range);
		}
		if(!To_Amount_Range.equals("")) {
			waitForElement(driver, amountRange_To_Textfield_PPT);
			sendKeys(driver, amountRange_To_Textfield_PPT, To_Amount_Range);
		}
		waitForElement(driver, show_Invoice_Btn_PPT);
		click(driver, show_Invoice_Btn_PPT);
		Step_End(5, "Select Get Details and click show invoice", test, test1);

		Step_Start(6, "Select the respective transaction number and select receipt amount (home currency) and make part payment", test, test1);

		waitForElement(driver, filter_Icon_PPT);
		click(driver, filter_Icon_PPT);
		waitForElement(driver, condition_Filter_PPT);
		click(driver, condition_Filter_PPT);
		waitForElement(driver, transNumber_Filter_PPT);
		sendKeys(driver, transNumber_Filter_PPT, Transaction_Number);

		String select_CheckBox=String.format(select_Checkbox_PPT, Transaction_Number);

		waitForElement(driver, select_CheckBox);
		checkBox(driver, select_CheckBox, "Yes");

		waitForDisplay(driver, scroll);
		if(isdisplayed(driver, scroll)) {
		horizontalscroll(driver, scroll, 500);
		}
		String clickPayAmount_Gridcell=String.format(payAmount_GridCell_PPT, Transaction_Number);
		horizontalscroll(driver, scroll, -500);
		waitForElement(driver, clickPayAmount_Gridcell);
		doubleClick(driver, clickPayAmount_Gridcell);

		String editPayAmount_Gridcell=String.format(payAmount_GridCell_Edit_PPT, Transaction_Number);
		waitForElement(driver, editPayAmount_Gridcell);
		clear(driver, editPayAmount_Gridcell);
		sendKeys(driver, editPayAmount_Gridcell, payAmount);
		enter(driver);
		Step_End(6, "Select the respective transaction number and select receipt amount (home currency) and make part payment", test, test1);

		Step_Start(7, "Enter the negative value in receipt amount column, balance amount column should show difference amount.", test, test1);

		String Balance_Amnt=String.format(balance_Amount_PPT, Transaction_Number);
		waitForElement(driver, Balance_Amnt);
		String Balance_Amount=getText(driver, Balance_Amnt);
		System.out.println(Balance_Amount);


		waitForElement(driver, cash_Bank_Details_Tab_PPT);
		click(driver, cash_Bank_Details_Tab_PPT);

		waitForElement(driver, cheque_TT_No_Textfield_PPT);
		sendKeys(driver, cheque_TT_No_Textfield_PPT, cheque_TT_No);
		waitForElement(driver, cheque_TT_No_Textfield_PPT);
		String cheque_No = getAttribute(driver, cheque_TT_No_Textfield_PPT, "value");
		int total_Cheque_Size = cheque_No.length();
		int exp_Cheque_Size = Integer.parseInt(Limit_Of_Cheque_No_Input);


        if(exp_Cheque_Size>=total_Cheque_Size) {
			
			System.out.println("Matched || The Expected After Enter the Cheque/TT should be accept with Numeric values upto 20 characters : "+exp_Cheque_Size+" || Actual Enter the Cheque/TT  accept with Numeric values upto 20 characters : "+total_Cheque_Size);
			Extent_pass_New(driver, "Matched ||The Expected After Enter the Cheque/TT should be accept with Numeric values upto 20 characters : "+exp_Cheque_Size+" ||  Actual Enter the Cheque/TT  accept with Numeric values upto 20 characters : "+total_Cheque_Size, test, test1);
		}else {
			System.out.println("Not Matched || The Expected After Enter the Cheque/TT should be accept with Numeric values upto 20 characters: "+exp_Cheque_Size+" ||  Actual Enter the Cheque/TT  accept with Numeric values upto 20 characters : "+total_Cheque_Size);
			Extent_fail(driver, "Not Matched || The Expected After Enter the Cheque/TT should be accept with Numeric values upto 20 characters : "+exp_Cheque_Size+" ||  Actual Enter the Cheque/TT  accept with Numeric values upto 20 characters : "+total_Cheque_Size, test, test1);
		}

		click(driver, paymentAC_SearchButton_PPT);
		 twoColumnMultipleSearchWindow(driver,Account_Name_Header,dropdownCondition, accountName_VAL);


		if(!currencyCode.equals("")) {
			click(driver, currency_SearcButton_PPT);
			
			twoColumnSearchWindow(driver, currency_SearcButton_PPT_Header, dropdownCondition, currencyCode);
	
	}


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
			click(driver, bankCharges_SearchButton_PPT);
			twoColumnSearchWindow(driver,AccountHead_Header, dropdownCondition,accountHead_BankCharges );

		}


		if(!roeDifference.equals("")) {
			waitForElement(driver, roe_Differencfe_Textfield_PPT);
			Newclear(driver, roe_Differencfe_Textfield_PPT);
			waitForElement(driver, roe_Differencfe_Textfield_PPT);
			Actionsendkeys(driver, roe_Differencfe_Textfield_PPT, roeDifference);
			waitForElement(driver, roe_Differencfe_Textfield_PPT);
			click(driver, cheque_TT_No_Textfield_PPT);
		}

		if(!accountName_ROE.equals("") || !accountHead_ROE.equals("")) {

			click(driver, roe_Difference_SearchButton_PPT);
			 twoColumnSearchWindow(driver,AccountHead_Header,dropdownCondition, accountHead_ROE);	

		}
		

		waitForElement(driver, Add_Button_PPT);
		click(driver, Add_Button_PPT);

		waitForElement(driver, post_Tab_PPT);
		click(driver, post_Tab_PPT);

		waitForElement(driver, post_Button_PPT);
		click(driver, post_Button_PPT);

		waitForElement(driver, description_TextArea_PPT);
		sendKeys(driver, description_TextArea_PPT, description_Data);
		waitForElement(driver, description_TextArea_PPT);
		String Description_Input = getTextJavascript(driver, description_TextArea_PPT);
		int total_Description_Input = Description_Input.length();
		int exp_Limit_Of_Description_Input = Integer.parseInt(Limit_Of_Description_Input);
		if(exp_Limit_Of_Description_Input>=total_Description_Input) {
			System.out.println("Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Accept In Description Field : "+total_Description_Input);
			Extent_pass_New(driver,"Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Accept In Description Field : "+total_Description_Input, test, test1);
		}else {
			System.out.println("Not Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Accept In Description Field : "+total_Description_Input);
			Extent_fail(driver,"Not Matched || The Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_Description_Input+" || Actual Number of Characters is Accept In Description Field : "+total_Description_Input, test, test1);
		}


		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		


        waitForPopup(driver, popup_Message,Payable_Payment_Popup);
        
		String PPT_Popup=getText(driver, popup_Message);
		if(Payable_Payment_Popup.equals(PPT_Popup)) {
			System.out.println("Matched || Expected After click on save button Popup value should be display in the Payable Payment Screen : " + Payable_Payment_Popup + " || Actual : Click on save button Popup value Is Not display in the Payable Payment Screen : " + PPT_Popup);
			Extent_pass_New(driver,"Matched ||Expected After click on save button Popup value should be display in the Payable Payment Screen " + Payable_Payment_Popup + " || Actual : Click on save button Popup value Is Not display in the Payable Payment Screen : " + PPT_Popup, test,test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		} else {
			System.out.println("Not Matched || Expected After click on save button Popup value should be display in the Payable Payment Screen : " + Payable_Payment_Popup + " ||Actual : Click on save button Popup value Is Not display in the Payable Payment Screen : " + PPT_Popup);
			Extent_fail(driver,"Not Matched || Expected After click on save button Popup value should be display in the Payable Payment Screen : " + Payable_Payment_Popup + " || Actual : Click on save button Popup value Is Not display in the Payable Payment Screen  : " + PPT_Popup,test, test1);

		}

		Step_End(7, "Enter the negative value in receipt amount column, balance amount column should show difference amount.", test, test1);


		Extent_completed(testcase_Name, test, test1);



	}
	}
	
