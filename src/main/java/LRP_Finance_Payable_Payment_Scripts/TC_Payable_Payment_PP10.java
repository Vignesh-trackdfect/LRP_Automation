package LRP_Finance_Payable_Payment_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Payable_Payment_Locators;

public class TC_Payable_Payment_PP10 extends Keywords{

public void Payable_Payment_PP10(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		String testcase_Name="TC_Payable_Payment_PP10";
		
		




		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String payable_Payment_Module = Excel_data.get("payable_Payment_Module");
		String payment_Date = Excel_data.get("payment_Date");
		String vendor_Name = Excel_data.get("vendor_Name");
		String datePicker = Excel_data.get("datePicker");
		String trans_Number_Data = Excel_data.get("trans_Number_Data");
		String cheque_TT_Data = Excel_data.get("cheque_TT_Data");
		String acc_Name_Data = Excel_data.get("acc_Name_Data");
		String expected_Popup = Excel_data.get("expected_Popup");
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
		String Account_Name_Header = Excel_data.get("Account_Name_Header");
		String dropdownCondition =Excel_data.get("dropdownCondition");
		String Vendor_Code_Header  = Excel_data.get("Vendor_Code_Header");
		String vendor_Code = Excel_data.get("Vendor_Code");
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, payable_Payment_Module);
	
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
				System.out.println("Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period  Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Payment Date");
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


		Step_Start(4, "Select the Customer Name from the search icon in the customer tab", test, test1);
		
		 waitForElement(driver, PP_Vendor_Radio_Button);
	     click(driver, PP_Vendor_Radio_Button);
		
		waitForElement(driver, vendor_textield_PPT);
     	sendKeys(driver, vendor_textield_PPT,vendor_Name);	
		click(driver,customer_SearchButton_PPT);	
		
		twoColumnSearchWindow(driver, Vendor_Code_Header, dropdownCondition, vendor_Code);
		
		Step_End(4, "Select the Customer Name from the search icon in the customer tab", test, test1);

		Step_Start(5, "Select Get Details and click show invoice", test, test1);
		
		waitForElement(driver, getDetails_Button_PPT);
		click(driver, getDetails_Button_PPT);
		
		waitForElement(driver, Trans_Date_Check_Box_PPT);
		checkBox(driver, Trans_Date_Check_Box_PPT, Trans_Date_Check_Box);
		
		waitForElement(driver, Currency_Check_Box_PPT);
		checkBox(driver, Currency_Check_Box_PPT, Currency_Check_Box);
		
		waitForElement(driver, transNumber_Checkbox_PPT);
		checkBox(driver, transNumber_Checkbox_PPT, Trans_No_Check_Box);
		
		waitForElement(driver, amountRange_Checkbox_PPT);
		checkBox(driver, amountRange_Checkbox_PPT, Amount_Range_Check_Box);
		
		if(!Trans_From_Date.equals("")) {
			waitForElement(driver, trans_FromDate_PPT);
			if(datePicker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, trans_FromDate_PPT, Trans_From_Date);
				
				
			}
			else {
				waitForElement(driver, RR_Trans_From_Date);
				clearAndType(driver, RR_Trans_From_Date, Trans_From_Date);
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
			}
		}
		if(!Currency_Select_Option.equals("")) {
			waitForElement(driver, currency_Drpdwn_PPT);
				click(driver, currency_Drpdwn_PPT);
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

		Step_Start(6, "Select the respective transaction number", test, test1);
		
		waitForElement(driver, filter_Icon_PPT);
		click(driver, filter_Icon_PPT);
		waitForElement(driver, condition_Filter_PPT);
		click(driver, condition_Filter_PPT);
		waitForElement(driver, transNumber_Filter_PPT);
		sendKeys(driver, transNumber_Filter_PPT, trans_Number_Data);
		
		String trans_No_Checkboc_PPT=String.format(Payable_Payment_Locators.select_Checkbox_PPT, trans_Number_Data);

		waitForElement(driver, trans_No_Checkboc_PPT);
		click(driver, trans_No_Checkboc_PPT);
		
		Step_End(6, "Select the respective transaction number", test, test1);

		Step_Start(7, "Click 'Cash or Bank detail' and enter the values in the respective fields", test, test1);
		
		waitForElement(driver, cash_Bank_Details_Tab_PPT);
		click(driver, cash_Bank_Details_Tab_PPT);
		
		waitForElement(driver, chequeTT_No_Txtfld_PPT);
		sendKeys(driver, chequeTT_No_Txtfld_PPT, cheque_TT_Data);
		
		waitForElement(driver, deposit_Ac_Search_Btn_PPT);
		click(driver, deposit_Ac_Search_Btn_PPT);
		
		twoColumnSearchWindow(driver, Account_Name_Header, dropdownCondition, acc_Name_Data);	

		waitForElement(driver, add_Symbol_PPT);
		click(driver, add_Symbol_PPT);
		
		
		Step_End(7, "Click 'Cash or Bank detail' and enter the values in the respective fields", test, test1);

		Step_Start(8, "Click on save button without entering the value in 'Description'", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(8, "Click on save button without entering the value in 'Description'", test, test1);

		Step_Start(9, "Click save, system should show pop up validation as 'Enter the Description'", test, test1);
		
		waitForPopup(driver, popup_Message,expected_Popup);
		
		String actual_Popup = getText(driver, popup_Message);
		
		if(expected_Popup.equals(actual_Popup)) {
			
		System.out.println("MATCHED || Expected After click on save button Popup value should be display in the Payable Payment Screen: "+expected_Popup+"|| Actual : Click on save button Popup value Is Not display in the Payable Payment Screen  : "+actual_Popup);
		Extent_pass_New(driver, "MATCHED ||Expected After click on save button Popup value should be display in the Payable Payment Screen : "+expected_Popup+"|| Actual : Click on save button Popup value Is Not display in the Payable Payment Screen : "+actual_Popup, test, test1);
		click(driver, popup_Message_Ok_Button);
		}else {
			
			System.out.println("NOT MATCHED ||Expected After click on save button Popup value should be display in the Payable Payment Screen: "+expected_Popup+"|| Actual : Click on save button Popup value Is Not display in the Payable Payment Screen :"+actual_Popup);
			Extent_fail(driver, "NOT MATCHED || Expected After click on save button Popup value should be display in the Payable Payment Screen : "+expected_Popup+"||Actual : Click on save button Popup value Is Not display in the Payable Payment Screen  :"+actual_Popup, test, test1);
			
			
		}
		
		Step_End(9, "Click save, system should show pop up validation as 'Enter the Description'", test, test1);

		Extent_completed(testcase_Name, test, test1);

	
	
}
	
	
	
}
