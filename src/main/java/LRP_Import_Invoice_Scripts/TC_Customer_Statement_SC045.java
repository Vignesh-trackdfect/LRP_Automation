package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.Customer_Statement_Report_Locators;

public class TC_Customer_Statement_SC045 extends Keywords {

	public void Customer_Statement_SC045(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Customer_Statement_SC045";
		// Get data from test data
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_Receipt = Excel_data.get("Module_Receipt");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String payment_Mode = Excel_data.get("PaymentMode");
		String currencyCode = Excel_data.get("CurrencyCode");
		String amount = Excel_data.get("Amount");
		String receiptSavedPopup = Excel_data.get("ReceiptSavedPopup");
		String greenColorCode = Excel_data.get("GreenColorCode");
		String bankname = Excel_data.get("bankname");
		String Reciept_Mode = Excel_data.get("Reciept_Mode");
		String cheque_Number = Excel_data.get("cheque_Number");
		String payAt_Value = Excel_data.get("payAt_Value");
		String delete_Receipt = Excel_data.get("delete_Receipt");

		String customer_statement_module = Excel_data.get("customer_statement_module");
		String Invoice_type_Input_Select = Excel_data.get("Invoice_type_Input_Select");
		String charge_type_Input_Select = Excel_data.get("charge_type_Input_Select");
		String scope_type_Input_Select = Excel_data.get("scope_type_Input_Select");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");
		String Global_Search_Type1_CSR = Excel_data.get("Global_Search_Type1_CSR");
		String Cust_Statement_Report_StartDate = Excel_data.get("Cust_Statement_Report_StartDate");
		String Cust_Statement_Report_EndDate = Excel_data.get("Cust_Statement_Report_EndDate");
		String customer_statement_report_headers = Excel_data.get("customer_statement_report_headers");
		String GlobalSearch_Type1_Receipt = Excel_data.get("GlobalSearch_Type1_Receipt");
		String GlobalSearch_Value1_Receipt = Excel_data.get("GlobalSearch_Value1_Receipt");
		String GlobalSearch_Type2_Receipt = Excel_data.get("GlobalSearch_Type2_Receipt");
		String GlobalSearch_Value2_Receipt = Excel_data.get("GlobalSearch_Value2_Receipt");
		String GlobalSearch_Type3_Receipt = Excel_data.get("GlobalSearch_Type3_Receipt");
		String GlobalSearch_Value3_Receipt = Excel_data.get("GlobalSearch_Value3_Receipt");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Deposit_Bank_Name_Header = Excel_data.get("Deposit_Bank_Name_Header");
		String deposit_bank = Excel_data.get("deposit_bank");
		String Bank_Name_Header = Excel_data.get("Bank_Name_Header");
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");

		String Cannot_Cancel_Receipt_Popup = Excel_data.get("Cannot_Cancel_Receipt_Popup");
		String Cash_Deposit_Module = Excel_data.get("Cash_Deposit_Module");
		String Cash_Deposit_delete_Popup1 = Excel_data.get("Cash_Deposit_delete_Popup1");
		String Cash_Deposit_Delete_Popup2 = Excel_data.get("Cash_Deposit_Delete_Popup2");

		String Cheque_DD_Deposit_Module = Excel_data.get("Cheque_DD_Deposit_Module");
		String DD_Deposit_delete_Popup1 = Excel_data.get("DD_Deposit_delete_Popup1");
		String DD_Deposit_Delete_Popup2 = Excel_data.get("DD_Deposit_Delete_Popup2");
		
		String Cheque_module = Excel_data.get("Cheque_module");
		String Global_search_value_Receipt_No = Excel_data.get("Global_search_value_Receipt_No");
		String reset_Popup_Expected = Excel_data.get("Reset_Popup").trim();
		String reversed_successful_Expected = Excel_data.get("reversed_successful_Popup").trim();
		
		String enterRemarksPopup = Excel_data.get("EnterRemarksPopup");
		String receiptRemark = Excel_data.get("ReceiptRemark");
		String wantToDeletePopup = Excel_data.get("WantToDeletePopup");
		String cancelledPopup = Excel_data.get("CancelledPopup");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		// Switch Agency
		Step_Start(1, "Switch to agency", test, test1);
		if (!agencyUser.equalsIgnoreCase("line")) {
			SwitchProfile(driver, agencyUser);
		} else {
			ResetProfile(driver);
		}

		Step_End(1, "Switch to agency", test, test1);
		Step_Start(2, "open the receipt module", test, test1);
		moduleNavigate(driver, module_Receipt);

		// Receipt
		Extent_cal(test, test1, module_Receipt);

		waitForElement(driver, reciept_Module);
		if (isDisplayed(driver, reciept_Module)) {
			Extent_pass_New(driver,	"Expected : Receipt module should be opened || Actual : " + module_Receipt + "  module is opened",
					test, test1);
			System.out.println(	"Expected : Receipt module should be opened || Actual : " + module_Receipt + "  module is opened");
		} else {
			System.out.println("Expected : Receipt module should be opened || Actual : " + module_Receipt
					+ " module is not opened");
			Extent_fail(driver, "Expected : Receipt module should be opened || Actual : " + module_Receipt
					+ "  module is not opened", test, test1);
		}

		Step_End(2, "open the receipt module", test, test1);
		Step_Start(3, "click the new button", test, test1);
		newButton(driver);
		Step_End(3, "click the new button", test, test1);

		Step_Start(4, "select the advance receipt module", test, test1);
		String mode_Of_Receipt = String.format(receipt_Mode_Button, Reciept_Mode);
		waitForElement(driver, mode_Of_Receipt);
		click(driver, mode_Of_Receipt);
		Step_End(4, "select the advance receipt module", test, test1);
		Step_Start(5, "select the  customer in customer name field-------customername or code given in excel", test,
				test1);

		waitForElement(driver, receipt_Customer_Name_SearchBtn);
		click(driver, receipt_Customer_Name_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_Type1_Receipt, GlobalSearch_Value1_Receipt, GlobalSearch_Type2_Receipt, GlobalSearch_Value2_Receipt, GlobalSearch_Type3_Receipt, GlobalSearch_Value3_Receipt);

		Step_End(5, "select the  customer in customer name field-------customername or code given in excel", test,
				test1);

		Step_Start(6,"once selected the customer ,customer name , address,payercode  and payername  has to be shown. from customer  master",
				test, test1);

		waitForElement(driver, payer_InputField);
		waitForElement(driver, payerName_InputField);
		String actualPayer = getAttribute(driver, payer_InputField, "value");
		String actualPayerName = getAttribute(driver, payerName_InputField, "value");
		String actualCustomer = getAttribute(driver, customer_InputField, "value");
		String actualPayerAddress = getText(driver, payerAddress_InputField);
		String actualCustomer_Name = getAttribute(driver, receipt_Customer_Name, "value");

		if (!actualPayer.trim().equals("")) {
			System.out.println("Expected result is : After selected the customer, payer details should shown || Actual result is : After selected the customer, payer details are shown || Actual Payer is : "
							+ actualPayer);
			Extent_pass_New(driver,"Expected result is : After selected the customer, payer details should shown || Actual result is : After selected the customer, payer details are shown || Actual Payer is : "
							+ actualPayer,
					test, test1);
		} else {
			System.out.println(	"Expected result is : After selected the customer, payer details should shown || Actual result is : After selected the customer, payer details are not shown || Actual Payer is : "
							+ actualPayer);
			Extent_fail(driver,"Expected result is : After selected the customer, payer details should shown || Actual result is : After selected the customer, payer details are not shown || Actual Payer : "
							+ actualPayer,
					test, test1);
		}

		if (!actualPayerName.trim().equals("")) {
			System.out.println(	"Expected result is : After selected the customer, customer, payer Name should shown || Actual result is : After selected the customer, payer Name is shown || Actual Payer Name : "
							+ actualPayerName);
			Extent_pass_New(driver,	"Expected result is : After selected the customer, customer, payer Name should shown || Actual result is : After selected the customer, payer Name is shown || Actual Payer Name : "
							+ actualPayerName,
					test, test1);
		} else {
			System.out.println("Expected result is : After selected the customer, customer, payer Name should shown || Actual result is : After selected the customer, payer Name is not shown || Actual Payer Name : "
							+ actualPayerName);
			Extent_fail(driver,"Expected result is : After selected the customer, customer, payer Name should shown || Actual result is : After selected the customer, payer Name is not shown || Actual Payer Name : "
							+ actualPayerName,
					test, test1);
		}

		if (!actualCustomer.trim().equals("")) {
			System.out.println("Expected result is : After selected the customer, customer, Customer code should shown || Actual result is : After selected the customer, Customer code was shown || Actual Customer : "
							+ actualCustomer);
			Extent_pass_New(driver,"Expected result is : After selected the customer, customer, Customer code should shown || Actual result is : After selected the customer, Customer code was shown || Actual Customer : "
							+ actualCustomer,
					test, test1);
		} else {
			System.out.println("Expected result is : After selected the customer, customer, Customer code should shown || Actual result is : After selected the customer, Customer code was not shown || Actual Customer Code : "
							+ actualCustomer);
			Extent_fail(driver,"Expected result is : After selected the customer, customer, Customer code should shown || Actual result is : After selected the customer, Customer code was not shown || Actual Customer Code : "
							+ actualCustomer,
					test, test1);
		}

		if (!actualPayerAddress.trim().equals("")) {
			System.out.println(
					"Expected result is : After selected the customer, customer, Payer address should shown || Actual result is : After selected the customer, Payer address was shown || Actual Payer Addrress : "
							+ actualPayerAddress);
			Extent_pass_New(driver,
					"Expected result is : After selected the customer, customer, Payer address should shown || Actual result is : After selected the customer, Payer address was shown || Actual Payer Addrress : "
							+ actualPayerAddress,
					test, test1);
		} else {
			System.out.println(
					"Expected result is : After selected the customer, customer, Payer address should shown || Actual result is : After selected the customer, Payer address was not shown|| Actual Payer Addrress : "
							+ actualPayerAddress);
			Extent_fail(driver,
					"Expected result is : After selected the customer, customer, Payer address should shown || Actual result is : After selected the customer, Payer address was not shown || Actual Payer Addrress : "
							+ actualPayerAddress,
					test, test1);
		}

		if (!actualCustomer_Name.trim().equals("")) {
			System.out.println("Expected result is : After selected the customer, customer, Customer name should shown || Actual result is : After selected the customer, Customer name was shown || Actual Customer Name : "
							+ actualCustomer_Name);
			Extent_pass_New(driver,"Expected result is : After selected the customer, customer, Customer name should shown || Actual result is : After selected the customer, Customer name was shown || Actual Customer Name : "
							+ actualCustomer_Name,
					test, test1);
		} else {
			System.out.println("Expected result is : After selected the customer, customer, Customer name should shown || Actual result is : After selected the customer, Customer name was not shown || Actual Customer Name : "
							+ actualCustomer_Name);
			Extent_fail(driver,
					"Expected result is : After selected the customer, customer, Customer name should shown || Actual result is : After selected the customer, Customer name was not shown || Actual Customer Name : "
							+ actualCustomer_Name,
					test, test1);
		}

		Step_End(6,"once selected the customer ,customer name , address,payercode  and payername  has to be shown. from customer  master",
				test, test1);

		Step_Start(7, "go to the payment details", test, test1);

		waitForElement(driver, paymentDetails_Tab);
		click(driver, paymentDetails_Tab);

		Step_End(7, "go to the payment details", test, test1);

		Step_Start(8, "select the cheque mode in mode dropdownfield", test, test1);
		if(!payment_Mode.equals("")) {
				waitForElement(driver, paymentMode_Dropdown);
				click(driver, paymentMode_Dropdown);
				String select_Mode = String.format(paymentMode, payment_Mode);
		
				waitForDisplay(driver, select_Mode);
				click(driver, select_Mode);
		}
		Step_End(8, "select the cheque mode in mode dropdownfield", test, test1);
		if(!cheque_Number.equals("")) {
				Step_Start(9, "enter the number in number field", test, test1);
				waitForElement(driver, number_Txtfield);
				sendKeys(driver, number_Txtfield, cheque_Number);
				Step_End(9, "enter the number in number field", test, test1);
				
		}
		Step_Start(10, "select the payable at", test, test1);
		if(!payAt_Value.trim().equals("")) {
			waitForElement(driver, payAt_Field);
			click(driver, payAt_Field);
			String select_payAt = String.format(payAt_Option, payAt_Value);
			waitForDisplay(driver, select_payAt);
			click(driver, select_payAt);
		}
		
		Step_End(10, "select the payable at", test, test1);
		Step_Start(11, "select the bank name in bank name search field", test, test1);

		if(!bankname.trim().equals("")) {
			waitForElement(driver, bank_Search_Icon);
			click(driver, bank_Search_Icon);
			twoColumnSearchWindow(driver, Bank_Name_Header, Two_Column_Search_Condition, bankname);
		}
		Step_Start(13, "select the currency", test, test1);
		if(!currencyCode.trim().equals("")) {
			waitForElement(driver, currency_SearchButton);
			click(driver, currency_SearchButton);
			twoColumnSearchWindow(driver, Currency_Code_Header, Two_Column_Search_Condition, currencyCode);
		}

		Step_End(13, "select the currency", test, test1);
		Step_Start(14, "once select the currency roe field roe has automatically fetched", test, test1);

		waitForElement(driver, roe_Textfield);
		String actual_ROE = getAttribute(driver, roe_Textfield, "value");
		if (!actual_ROE.equals("")) {
			System.out.println(	"Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was displayed || The selected ROE Was "
							+ actual_ROE);
			Extent_pass_New(driver,"Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was displayed || The selected ROE Was "
							+ actual_ROE,
					test, test1);
		} else {
			System.out.println("Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was not displayed|| The selected ROE Was "
							+ actual_ROE);
			Extent_fail(driver,"Expected : Selected ROE Value should be displayed || Actual : Selected ROE Value was not displayed || The selected ROE Was "
							+ actual_ROE,
					test, test1);
		}

		Step_End(14, "once select the currency roe field roe has automatically fetched", test, test1);

		// Amount * ROE

		Step_Start(12, "enter the amount", test, test1);
		if(!amount.trim().equals("")&&IsElementEnabled(driver, amount_Textfield)) {
			waitForElement(driver, amount_Textfield);
			Newclear(driver, amount_Textfield);
			sendKeys(driver, amount_Textfield, amount);
			click(driver, roe_Textfield);
		}
		Step_End(12, "enter the amount", test, test1);
		
		// deposit bank
		if (!deposit_bank.trim().equals("")&&IsElementEnabled(driver, deposit_Bank_Search_Icon)) {
			// deposit bank
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);
			twoColumnSearchWindow(driver, Deposit_Bank_Name_Header, Two_Column_Search_Condition, deposit_bank);
		}
		
		Step_End(11, "select the bank name in bank name search field", test, test1);

		Step_Start(15, "amount field value has shown , automatically amount fected based on amount * roe", test, test1);

		waitForElement(driver, amountAED_Textfield);
		String act_Amount = getAttribute(driver, amountAED_Textfield, "value");
		String actualAmount = getAttribute(driver, amount_Textfield, "value");
		String actualROE = getAttribute(driver, roe_Textfield, "value");

		double actAmount = getNumberValue1(actualAmount);
		double actROE = getNumberValue1(actualROE);
		System.out.println("actAmount : " + actAmount);
		System.out.println("actROE : " + actROE);

		double exp_Amount =Double.parseDouble(String.format("%.2f", actAmount * actROE));
		double Amount_Act = getNumberValue(act_Amount);
		System.out.println("exp_Amount : " + exp_Amount);

		if (Amount_Act == exp_Amount) {
			System.out.println("Matched || Automatically amount fected based on amount * roe || Expected Amount : "
					+ exp_Amount + " || Actual Amount : " + Amount_Act);
			Extent_pass_New(driver, "Matched || Automatically amount fected based on amount * roe || Expected Amount : "
					+ exp_Amount + " || Actual Amount : " + Amount_Act, test, test1);
		} else {
			System.out.println(
					"Not Matched || Automatically amount not fected based on amount * roe || Expected Amount : "
							+ exp_Amount + " || Actual Amount : " + Amount_Act);
			Extent_fail(driver,
					"Not Matched || Automatically amount not fected based on amount * roe || Expected Amount : "
							+ exp_Amount + " || Actual Amount : " + Amount_Act,
					test, test1);
		}

		Step_End(15, "amount field value has shown , automatically amount fected based on amount * roe", test, test1);
		
		Step_Start(16, "click the add button ", test, test1);

		waitForElement(driver, paymentDetails_Add_Button);
		click(driver, paymentDetails_Add_Button);

		Step_End(16, "click the add button ", test, test1);
		Step_Start(17, "once added the payment,below grid value has shown.", test, test1);

		waitForDisplay(driver, paymentDetails_Table_Rows);
		if (isDisplayed(driver, paymentDetails_Table_Rows)) {
			System.out.println(	"Pass || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are showing in the grid");
			Extent_pass_New(driver,"Pass || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are showing in the grid",
					test, test1);
			
		} else {
			System.out.println("Fail || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are showing in the grid");
			Extent_fail(driver,	"Fail || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are not showing in the grid",
					test, test1);
		}

		Step_End(17, "once added the payment,below grid value has shown.", test, test1);
		Step_Start(18, "click the save button in tool bar", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(18, "click the save button in tool bar", test, test1);

		Step_Start(19, "system has validate --Receipt saved\r\n Ok", test, test1);

		waitForDisplay(driver, popup_Message_Yes_Button);
		if (isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		}

		waitForPopup(driver, popup_Message, receiptSavedPopup);

		String actualSavedPopup = getText(driver, popup_Message);

		if (actualSavedPopup.equals(receiptSavedPopup)) {
			System.out.println("Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
			Extent_pass_New(driver,"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup, test,
					test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
			Extent_fail(driver,	"Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup,
					test, test1);
		}

		Step_End(19, "system has validate --Receipt saved\r\n Ok", test, test1);

		Extent_call(test, test1, "-------------------verify------------------------");
		Step_Start(20, "Receipt number field -newly receipt number generated and showing green color", test, test1);

		waitForElement(driver, recieptNo_Textfield);
		String actualColor = getTextBackgroundColor(driver, recieptNo_Textfield);
		String amount_in_receipt_module = getText(driver, total_amount_in_receipt);
		String Receipt_Date = getAttribute(driver, ReceiptDate_Input, "value");		
		
		String actual_Receipt_number = getAttribute(driver, recieptNo_Textfield, "value");
		waitForElement(driver, Mode_of_Payment_Receipt);
		String ReceiptMode=getText(driver, Mode_of_Payment_Receipt);
		
		if (!actual_Receipt_number.equals("")) {
			System.out.println(	"Matched || Expected : Receipt number should be generated || Actual : Receipt number generated || Generated Receipt Number : "
							+ actual_Receipt_number);
			Extent_pass_New(driver,"Matched || Expected : Receipt number should be generated || Actual :  Receipt number generated || Generated Receipt Number : "
							+ actual_Receipt_number,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected : Receipt number should be generated || Actual :  Receipt number not generated || Generated Receipt Number : "
							+ actual_Receipt_number);
			Extent_fail(driver,"Not Matched || Expected : Receipt number should be generated || Actual :  Receipt number not generated || Generated Receipt Number : "
							+ actual_Receipt_number,
					test, test1);
		}

		String Act_ColorName = getColorName(actualColor);
		if (Act_ColorName.equalsIgnoreCase(greenColorCode)) {
			System.out.println("Newly generated receipt numbers showing in expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + Act_ColorName);
			Extent_pass_New(driver, "Newly generated receipt numbers showing in expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + Act_ColorName, test, test1);
		} else {
			System.out.println("Newly generated receipt numbers are not showing in expected color || Expected color was : "
							+ greenColorCode + " || Actual color was : " + Act_ColorName);
			Extent_fail(driver,"Newly generated receipt numbers are not showing in expected color || Expected color was : "
							+ greenColorCode + " || Actual color was : " + Act_ColorName,
					test, test1);
		}

		Step_End(20, "Receipt number field -newly receipt number generated and showing green color", test, test1);

		Step_Start(21, "once saved the receipt ,tool bar delete button has enable.", test, test1);

		if (isElementAccessible(driver, Delete_button_toolBar)) {
			System.out.println("Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : once saved the receipt ,tool bar delete button is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : once saved the receipt ,tool bar delete button is enabled",
					test, test1);
		} else {
			System.out.println(
					"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : once saved the receipt ,tool bar delete button is enabled");
			Extent_fail(driver,
					"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : once saved the receipt ,tool bar delete button is disabled",
					test, test1);
		}

		Step_End(21, "once saved the receipt ,tool bar delete button has enable.", test, test1);

		// customer collection report
		moduleNavigate(driver, customer_statement_module);
		
		newButton(driver);

		if (!Invoice_type_Input_Select.equals("")) {
			waitForElement(driver, customer_Statement_Invoice_Type_Dropdown);
			click(driver, customer_Statement_Invoice_Type_Dropdown);
			String Invoice_Type_Select = String.format(DropDown_Select, Invoice_type_Input_Select);
			waitForElement(driver, Invoice_Type_Select);
			click(driver, Invoice_Type_Select);
		}

		if (!charge_type_Input_Select.equals("")) {
			waitForElement(driver, customer_statement_Charge_Type_Dropdown);
			click(driver, customer_statement_Charge_Type_Dropdown);
			String charge_Type_Select = String.format(DropDown_Select, charge_type_Input_Select);
			waitForElement(driver, charge_Type_Select);
			click(driver, charge_Type_Select);
		}

		
		if (agencyUser.trim().equalsIgnoreCase("")) {
			if (!scope_type_Input_Select.equals("")) {
				waitForElement(driver, customer_statement_Scope_Select);
				click(driver, customer_statement_Scope_Select);
				String scope_Type_Select = String.format(DropDown_Select, scope_type_Input_Select);
				waitForElement(driver, scope_Type_Select);
				click(driver, scope_Type_Select);
			}
			
			if(scope_type_Input_Select.equals("Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);			
			}
			
			if(scope_type_Input_Select.equals("Corporate Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);		
			}
		}

		
			waitForElement(driver, by_customer_radio_button);
			click(driver, by_customer_radio_button);

			waitForElement(driver, customer_name_search_icon_csr);
			click(driver, customer_name_search_icon_csr);

			globalValueSearchWindow(driver, GlobalSearch_Condition, Global_Search_Type1_CSR, actualCustomer_Name, "", "", "","");

			waitForElement(driver, customer_add_btn_csr);
			click(driver, customer_add_btn_csr);

			waitForElement(driver, advance_receipt_radio_btn);
			click(driver, advance_receipt_radio_btn);
			
			String From_date=beforeDaysToDate(Receipt_Date, Cust_Statement_Report_StartDate);
			String To_date=addDaysToDate(Receipt_Date, Cust_Statement_Report_EndDate);
			waitForDisplay(driver, customer_Statement_From_Date);
			if(IsElementEnabled(driver, customer_Statement_From_Date)) {
				selectDatePicker(driver, customer_Statement_From_Date, From_date);
			}
			
			waitForDisplay(driver, customer_Statement_To_Date);
			if(IsElementEnabled(driver, customer_Statement_To_Date)) {
				selectDatePicker(driver, customer_Statement_To_Date, To_date);
			}
			
			waitForElement(driver, show_btn_csr);
			click(driver, show_btn_csr);

			waitForElement(driver, customer_statement_Table);
			waitForElement(driver, Tool_Pannel_CSR);
			click(driver,Tool_Pannel_CSR);
			
			waitForElement(driver, Customer_Statement_Report_Locators.FilterOption_Menu);
			click(driver,Customer_Statement_Report_Locators.FilterOption_Menu);
			
			waitForElement(driver, AG_Grid_Columns_CSR);
			safeclick(driver, AG_Grid_Columns_CSR);
			waitForElement(driver, AG_Headers_Filter_Input_CSR);
			safeclick(driver, SelectAll_CheckBox_CSR);
			List<String> columns = splitAndExpand(customer_statement_report_headers);
			for (String column : columns) {
				waitForElement(driver, AG_Headers_Filter_Input_CSR);
				Newclear(driver, AG_Headers_Filter_Input_CSR);
				waitForElement(driver, AG_Headers_Filter_Input_CSR);
				sendKeys(driver, AG_Headers_Filter_Input_CSR, column);

				String check_box = String.format(Select_Column_tableHead, column);
				waitForDisplay(driver, check_box);
				jsClick(driver, check_box);
			}
			waitForElement(driver, AG_Grid_Columns_CSR);
			click(driver, AG_Grid_Columns_CSR);
			
			waitForElement(driver, Receipt_No_FilterInput_CSR);
			sendKeys(driver, Receipt_No_FilterInput_CSR, actual_Receipt_number);
			
			waitForElement(driver, customer_statement_Table);
			List<Map<String, String>> csr_total_table1 = extractTableDataByColumn(driver, customer_statement_Table);

			String ReceiptAmt_CSR =getFirstValueByHeader(csr_total_table1, "Receipt Amount"); 
			String ReceiptNumber_CSR =getFirstValueByHeader(csr_total_table1, "Receipt No"); 

			double ActReceiptAmt_CSR=Math.abs(getNumberValue(ReceiptAmt_CSR));
			double amountInReceipt =Math.abs(getNumberValue(amount_in_receipt_module));
			
			// Compare the two values
			if (ActReceiptAmt_CSR == amountInReceipt) {
				System.out.println("Matched || Amount present in the receipt module : " + amountInReceipt
						+ "|| Amount present in the csr module " + ActReceiptAmt_CSR);
				Extent_pass_New(driver, "Matched || Amount present in the receipt module : " + amountInReceipt
						+ "|| Amount present in the csr module " + ActReceiptAmt_CSR, test, test1);

			} else {
				System.out.println("Not Matched || Amount present in the receipt module : " + amountInReceipt
						+ "|| Amount present in the csr module " + ActReceiptAmt_CSR);
				Extent_fail(driver, "Not Matched || Amount present in the receipt module : " + amountInReceipt
						+ "|| Amount present in the csr module " + ActReceiptAmt_CSR, test, test1);
			}
			
			if (ReceiptNumber_CSR.contains(actual_Receipt_number)) {
				System.out.println("Matched || Receipt number present in the receipt module : " + actual_Receipt_number
						+ "|| Receipt number present in the csr module " + ReceiptNumber_CSR);
				Extent_pass_New(driver, "Matched || Receipt number present in the receipt module : " + actual_Receipt_number
						+ "|| Receipt number present in the csr module " + ReceiptNumber_CSR, test, test1);
			} else {

				System.out.println(	"Not Matched || Receipt number present in the receipt module : " + actual_Receipt_number
								+ "|| Receipt number present in the csr module " + ReceiptNumber_CSR);
				Extent_fail(driver,	"Not Matched || Receipt number present in the receipt module : " + actual_Receipt_number
								+ "|| Receipt number present in the csr module " + ReceiptNumber_CSR,
						test, test1);
			}
	
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
		if (delete_Receipt.equalsIgnoreCase("yes")) {
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			waitForElement(driver, popup_Message);
			String PoupValue=getText(driver, popup_Message);			
			if(PoupValue.contains(Cannot_Cancel_Receipt_Popup)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				if(ReceiptMode.equalsIgnoreCase("Cash")) {
					DeleteReceiptInCashDeposit(driver,Cash_Deposit_Module,GlobalSearch_Condition,Global_search_value_Receipt_No,actual_Receipt_number,Cash_Deposit_delete_Popup1,Cash_Deposit_Delete_Popup2);
				}else if (ReceiptMode.equalsIgnoreCase("Wire Transfer")) {
					DeleteReceiptInChequeRealization(driver,Cheque_module,GlobalSearch_Condition,Global_search_value_Receipt_No,actual_Receipt_number,reset_Popup_Expected,reversed_successful_Expected);
				}else if(ReceiptMode.equalsIgnoreCase("Cheque")) {
					DeleteReceiptInDD_Deposit(driver,Cheque_DD_Deposit_Module,GlobalSearch_Condition,Global_search_value_Receipt_No,actual_Receipt_number,DD_Deposit_delete_Popup1,DD_Deposit_Delete_Popup2);
				}				
			}else {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
			}
			
			waitForElement(driver, Delete_button_toolBar);
			if (isElementAccessible(driver, Delete_button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled");
				Extent_fail(driver,
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enabled || Actual result is : once saved the receipt ,tool bar delete button is enabled",
						test, test1);
			}

			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, enterRemarksPopup);

			String actEnterRemarks_popup = getText(driver, popup_Message);

			if (actEnterRemarks_popup.equals(enterRemarksPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);


				click(driver, reciept_Popup_Ok);

			} else {
				System.out.println("Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);

			}

			waitForElement(driver, reciept_remarks_TextArea);
			sendKeys(driver, reciept_remarks_TextArea, receiptRemark);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, wantToDeletePopup);
			String actWantToDelete_popup = getText(driver, popup_Message);
			if (actWantToDelete_popup.equals(wantToDeletePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);


				click(driver, reciept_Popup_Yes);


			} else {
				System.out.println("Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);

			}

			waitForPopup(driver, popup_Message, cancelledPopup);
			String actDeleted_popup = getText(driver, popup_Message);
			if (actDeleted_popup.equals(cancelledPopup)) {
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);
				System.out.println(
						"Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup);
				click(driver, reciept_Popup_Ok);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);

			}
			
			
		}

		Extent_completed(testCaseName, test, test1);
	}

}
