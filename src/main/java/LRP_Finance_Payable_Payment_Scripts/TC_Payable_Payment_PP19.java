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



public class TC_Payable_Payment_PP19 extends Keywords{
	public void Payable_Payment_PP19(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Payable_Payment_PP19";
		
		




		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Payable_Payment_Module = Excel_data.get("Payable_Payment_Module");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Payment_Date_Input = Excel_data.get("Payment_Date_Input");
		String Vendor_Name = Excel_data.get("Vendor_Name");
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
		String cheque_TT_No = Excel_data.get("cheque_TT_No");
		String Limit_Of_Cheque_No_Input = Excel_data.get("Limit_Of_Cheque_No_Input");
		String Limit_Of_Description_Input = Excel_data.get("Limit_Of_Description_Input");
		String description_Data = Excel_data.get("description_Data");
		String Payable_Payment_Popup = Excel_data.get("Payable_Payment_Popup");
		String currencyCode = Excel_data.get("currencyCode");
		String documentAmt = Excel_data.get("documentAmt");
		String bankCharges = Excel_data.get("bankCharges");
		String accountHead_BankCharges = Excel_data.get("accountHead_BankCharges");
		String accountName_BankCharges = Excel_data.get("accountName_BankCharges");
		String roeDifference = Excel_data.get("roeDifference");
		String accountName_ROE = Excel_data.get("accountName_ROE");
		String accountHead_ROE = Excel_data.get("accountHead_ROE");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String vendor_Code = Excel_data.get("Vendor_Code_1");
		String Account=Excel_data.get("Account");
		String accountName_val= Excel_data.get("accountName_val");
        String value_1 = Excel_data.get("Account_value");


		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);


		
		moduleNavigate(driver, Payable_Payment_Module);


		Step_Start(1, "Click on the new button in the tool bar", test, test1);

		newButton(driver);
		
		Step_End(1, "Click on the new button in the tool bar", test, test1);

		Step_Start(2, "payment date will be automatically selected based on month", test, test1);

		waitForElement(driver, payment_Date_PPT);
		String actual_Payment_Date = getAttribute(driver, payment_Date_PPT, "value");
		System.out.println(actual_Payment_Date);

		waitForElement(driver, payment_Date_PPT);
		if(Date_Picker.equalsIgnoreCase("Yes")) {
			//added
			selectDatePicker(driver, payment_Date_PPT, Payment_Date_Input);

		}
		else {
			waitForElement(driver, payment_Date_PPT);
			clearAndType(driver, payment_Date_PPT, Payment_Date_Input);
		}

		waitForElement(driver, payment_Date_PPT);
		String actual_Reciept_Date = getAttribute(driver, payment_Date_PPT, "value");

		LocalDate Current_Date = getOnlyCurrentDate();
		DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate actual_date = LocalDate.parse(actual_Reciept_Date, dateFormatter1);

		if(actual_date.isBefore(Current_Date)) {
			if (Payment_Date_Input.equals(actual_Reciept_Date)) {
				System.out.println("Matched ||  Expected: Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+Payment_Date_Input+" || The Actual Reciept Date is Automatically Selected Based on Month : "+actual_Reciept_Date);
				Extent_pass_New(driver,"Matched ||  Expected: Receipt Date Should be Automatically Selected Based On Month || Expected Current Date : "+Payment_Date_Input+" || The Actual Reciept Date ia Automatically Selected Based on Month : "+actual_Reciept_Date, test, test1);
			} else {
				System.out.println("Not Matched || Expected: Receipt Date Should be Automatically Not Selected Based On Month || Expected Current Date : "+Payment_Date_Input+" || The Actual Reciept Date not Automatically Selected Based on Month : "+actual_Reciept_Date);
				Extent_fail(driver,"Not Matched || Expected: Receipt Date Should be Automatically Not Selected Based On Month || Expected Current Date : "+Payment_Date_Input+" || The Actual Reciept Date not Automatically Selected Based on Month : "+actual_Reciept_Date, test, test1);
			}

			waitForElement(driver, open_Period_PPT);
			String actual_Open_Period= getText(driver, open_Period_PPT);
			

			if(compareMonthAndYear(actual_Reciept_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
			}
			

			Step_Start(4, "Select the vendor name from the search icon in the vendor tab", test, test1);
			
			 waitForElement(driver, PP_Vendor_Radio_Button);
		     click(driver, PP_Vendor_Radio_Button);
		     
			waitForElement(driver, customer_Searchfield_PPT);
			sendKeys(driver, customer_Searchfield_PPT,Vendor_Name);
			click(driver, customer_SearchButton_PPT);
			
			twoColumnSearchWindow(driver,Vendor_Code_Header,dropdownCondition, vendor_Code);



			Step_End(4, "Select the vendor name from the search icon in the vendor tab", test, test1);


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
					//added
					selectDatePicker(driver, trans_FromDate_PPT, Trans_From_Date);

					
				}
				else {
					waitForElement(driver, trans_FromDate_PPT);
					clearAndType(driver, trans_FromDate_PPT, Trans_From_Date);
				}
			}
			if(!Trans_To_Date.equals("")) {
				waitForElement(driver, trans_ToDate_PPT);
				if(Date_Picker.equalsIgnoreCase("Yes")) {
					
					//added
					selectDatePicker(driver, trans_ToDate_PPT,Trans_To_Date );

					
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
			
			waitForElement(driver, filter_Icon_PPT);
			click(driver, filter_Icon_PPT);
			waitForElement(driver, condition_Filter_PPT);
			click(driver, condition_Filter_PPT);
			waitForElement(driver, transNumber_Filter_PPT);
			sendKeys(driver, transNumber_Filter_PPT, Transaction_Number);

			Step_Start(6, "Select the respective transaction number and select and make full payment.", test, test1);

				String Select_Trans_Number=String.format(select_Checkbox_PPT, Transaction_Number);

			waitForElement(driver, Select_Trans_Number);
			click(driver, Select_Trans_Number);

			Step_End(6, "Select the respective transaction number and select and make full payment.", test, test1);

			Step_Start(7, "Click Cash/Bank Detail tab", test, test1);
			waitForElement(driver, cash_Bank_Details_Tab_PPT);
			click(driver, cash_Bank_Details_Tab_PPT);

			Step_End(7, "Click Cash/Bank Detail tab", test, test1);

			Step_Start(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);
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
			
			Step_End(8, "Enter the Cheque/TT No with Numeric values upto 30 characters", test, test1);

			Step_Start(9, " Select Payment A/c", test, test1);
			click(driver, paymentAC_SearchButton_PPT);
			
			
            twoColumnMultipleSearchWindow(driver,accountName_val,dropdownCondition,value_1);


			Step_End(9, " Select Payment A/c", test, test1);


			Step_Start(10, "Enter the ROE Difference and select ROE/Diff value id different currency", test, test1);

			if(!currencyCode.equals("")) {
				click(driver, currency_SearcButton_PPT);
	            twoColumnMultipleSearchWindow(driver,accountName_val,dropdownCondition,currencyCode);
		
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

			// two  column
			if(!accountName_BankCharges.equals("") || !accountHead_BankCharges.equals("")) {
				click(driver, bankCharges_SearchButton_PPT);
				waitForElement(driver, acccountName_Filter);
				
	            twoColumnMultipleSearchWindow(driver,Account,dropdownCondition,accountName_BankCharges);
                System.out.println("done1");

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

				//two column
				click(driver, roe_Difference_SearchButton_PPT);
				waitForElement(driver, acccountName_Filter);
				
	            twoColumnMultipleSearchWindow(driver,Account,dropdownCondition,accountName_ROE);
                System.out.println("done2");


			}


			Step_End(10, "Enter the ROE Difference and select ROE/Diff value id different currency", test, test1);

			Step_Start(11, "Click Add", test, test1);

			waitForElement(driver, Add_Button_PPT);
			click(driver, Add_Button_PPT);

			Step_End(11, "Click Add", test, test1);

			Step_Start(12, "Click the post button", test, test1);

			waitForElement(driver, post_Tab_PPT);
			click(driver, post_Tab_PPT);

			waitForElement(driver, post_Button_PPT);
			click(driver, post_Button_PPT);

			Step_End(12, "Click the post button", test, test1);

			Step_Start(13, "Enter the description field with an alphanumeric upto 250 characters.", test, test1);

			waitForElement(driver, description_TextArea_PPT);
			sendKeys(driver, description_TextArea_PPT, description_Data);
			waitForElement(driver, description_TextArea_PPT);
			String Description_Input = getTextJavascript(driver, description_TextArea_PPT);
	
			int total_Description_Input = Description_Input.length();
			int exp_Limit_Of_Description_Input = Integer.parseInt(Limit_Of_Description_Input);
			
			if(exp_Limit_Of_Description_Input>=total_Description_Input) {
				
				System.out.println("Matched || The Expected : Enter the description field should be an alphanumeric upto 250 characters "+exp_Limit_Of_Description_Input+" || Actual Enter the description field is an alphanumeric upto 250 characters : "+total_Description_Input);
				Extent_pass_New(driver,"Matched || The Expected : Enter the description field should be an alphanumeric upto 250 characters  : "+exp_Limit_Of_Description_Input+" || Actual Enter the description field is an alphanumeric upto 250 characters : "+total_Description_Input, test, test1);
			}else {
				System.out.println("Not Matched || Expected : Enter the description field should be an alphanumeric upto 250 characters  : "+exp_Limit_Of_Description_Input+" || Actual Enter the description field is an alphanumeric upto 250 characters : "+total_Description_Input);
				Extent_fail(driver,"Not Matched || Expected : Enter the description field should be an alphanumeric upto 250 characters  : "+exp_Limit_Of_Description_Input+" || Actual Enter the description field is an alphanumeric upto 250 characters : "+total_Description_Input, test, test1);
			}
			Step_End(13, "Enter the description field with an alphanumeric upto 250 characters.", test, test1);


			Step_Start(14, "Click save, should show the pop up message as \"Payable payment", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message,Payable_Payment_Popup);

			String PPT_Popup=getText(driver, popup_Message);
			if(Payable_Payment_Popup.equals(PPT_Popup)) {
				System.out.println("Matched ||Expected After click on save button Popup value should be display in the Payable Payment Screen : " + Payable_Payment_Popup + " || Actual  After click on save button Popup value is display in the Payable Payment Screen : " + PPT_Popup);
				Extent_pass_New(driver,"Matched || Expected After click on save button Popup value should be display in the Payable Payment Screen : " + Payable_Payment_Popup + " || Actual  After click on save button Popup value is display in the Payable Payment Screen : " + PPT_Popup, test,test1);
				Extent_pass_New(driver, " system allows to create a Payable payment by past date ", test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);

			} else {
				System.out.println("Not Matched ||Expected After click on save button Popup value should be display in the Payable Payment Screen : " + Payable_Payment_Popup + " || Actual  After click on save button Popup value is display in the Payable Payment Screen : " + PPT_Popup);
				Extent_fail(driver,"Not Matched ||Expected After click on save button Popup value should be display in the Payable Payment Screen : " + Payable_Payment_Popup + " || Actual  After click on save button Popup value is display in the Payable Payment Screen :  " + PPT_Popup,test, test1);

			}
		}

		else {
			System.out.println(" system not allows to create a Payable payment by past date ");
			Extent_fail(driver, " system not allows to create a Payable payment by past date ", test, test1);
		}
		Step_End(14, "Click save, should show the pop up message as \"Payable payment", test, test1);



		Extent_completed(testcase_Name, test, test1);




}
	}
