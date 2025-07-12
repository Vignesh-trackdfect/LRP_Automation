package LRP_Import_Invoice_Scripts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Receipt_SC032 extends Keywords {

	public void Receipt_SC032(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Receipt_SC032";
		// Get data from test data
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_Receipt = Excel_data.get("Module_Receipt");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String globalSearch_Value_1 = Excel_data.get("GlobalSearch_Value_1");
		String globalSearch_Value_2 = Excel_data.get("GlobalSearch_Value_2");
		String globalSearchFilterOption_1 = Excel_data.get("GlobalSearchFilterOption_1");
		String globalSearchFilterOption_2 = Excel_data.get("GlobalSearchFilterOption_2");
		String payment_Mode = Excel_data.get("PaymentMode");
		String currencyCode = Excel_data.get("CurrencyCode");
		String amount = Excel_data.get("Amount");
		String paymentDetail_Columns = Excel_data.get("PaymentDetail_Columns");
		String paymentDetails_Table_Name = Excel_data.get("PaymentDetails_Table_Name");
		String receiptSavedPopup = Excel_data.get("ReceiptSavedPopup");
		String greenColorCode = Excel_data.get("GreenColorCode");
		String wantToDeletePopup = Excel_data.get("WantToDeletePopup");
		String receiptRemark = Excel_data.get("ReceiptRemark");
		String cancelledPopup = Excel_data.get("CancelledPopup");
		String enterRemarksPopup = Excel_data.get("EnterRemarksPopup");
		String redColorCode = Excel_data.get("RedColorCode");
		String bankname = Excel_data.get("bankname");
		String Reciept_Mode = Excel_data.get("Reciept_Mode");
		String cheque_Number = Excel_data.get("cheque_Number");
		String payAt_Value = Excel_data.get("payAt_Value");
		String delete_Receipt = Excel_data.get("delete_Receipt");
		String condition = Excel_data.get("condition");

		String Bankcode_Header = Excel_data.get("Bankcode_Header");
		String Currency_Header = Excel_data.get("Currency_Header");
		String Deposit_Bank_Header = Excel_data.get("Deposit_Bank_Header");
		String Deposit_Bank_Value = Excel_data.get("Deposit_Bank_Value");
		
		String Payer_Code_SearchType = Excel_data.get("Payer_Code_SearchType");
		String Payer_Code_Value = Excel_data.get("Payer_Code_Value");
		String Date_Value_Receipt = Excel_data.get("Date_Value_Receipt");
		String Proposed_Date_Receipt = Excel_data.get("Proposed_Date_Receipt");
		String Receipt_Remarks = Excel_data.get("Receipt_Remarks");
		String Excess_Invo_No = Excel_data.get("Excess_Invo_No");

		String Cheque_module = Excel_data.get("Cheque_module");
		String Global_search_value_Receipt_No = Excel_data.get("Global_search_value_Receipt_No");
		String reset_Popup_Expected = Excel_data.get("reset_Popup_Expected").trim();
		String reversed_successful_Expected = Excel_data.get("reversed_successful_Expected").trim();
		
		String Cannot_Cancel_Receipt_Popup = Excel_data.get("Cannot_Cancel_Receipt_Popup").trim();
		String Cash_Deposit_Module = Excel_data.get("Cash_Deposit_Module").trim();
		String Cash_Deposit_delete_Popup1 = Excel_data.get("Cash_Deposit_delete_Popup1").trim();
		String Cash_Deposit_Delete_Popup2 = Excel_data.get("Cash_Deposit_Delete_Popup2").trim();

		String Cheque_DD_Deposit_Module = Excel_data.get("Cheque_DD_Deposit_Module").trim();
		String DD_Deposit_delete_Popup1 = Excel_data.get("DD_Deposit_delete_Popup1").trim();
		String DD_Deposit_Delete_Popup2 = Excel_data.get("DD_Deposit_Delete_Popup2").trim();
		
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		// Switch Agency

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "open the receipt module", test, test1);

		moduleNavigate(driver, module_Receipt);

		// Receipt
		Extent_cal(test, test1, module_Receipt);

		waitForDisplay(driver, reciept_Module);
		if (isDisplayed(driver, reciept_Module)) {
			Extent_pass_New(driver, "Expected result is : Receipt module should be opened || Actual result is :"
					+ module_Receipt + "  module is opened", test, test1);
			System.out.println("Expected result is : Receipt module should be opened || Actual result is :"
					+ module_Receipt + "  module is opened");
		} else {
			System.out.println("Expected result is : Receipt module should be opened || Actual result is :"
					+ module_Receipt + "  module is not opened");
			Extent_fail(driver, "Expected result is : Receipt module should be opened || Actual result is :"
					+ module_Receipt + "  module is not opened", test, test1);
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

		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_1, globalSearch_Value_1,
				globalSearchFilterOption_2, globalSearch_Value_2, "", "");

		Step_End(5, "select the  customer in customer name field-------customername or code given in excel", test,
				test1);
		Step_Start(6,
				"once selected the customer ,customer name , address,payercode  and payername  has to be shown. from customer  master",
				test, test1);

		waitForElement(driver, payer_InputField);
		waitForElement(driver, payerName_InputField);
		String actualPayer = getAttribute(driver, payer_InputField, "value");
		String actualPayerName = getAttribute(driver, payerName_InputField, "value");
		String actualCustomer = getAttribute(driver, customer_InputField, "value");
		String actualPayerAddress = getText(driver, payerAddress_InputField);
		String actualCustomer_Name = getAttribute(driver, receipt_Customer_Name, "value");

		if(!Payer_Code_Value.trim().equals("")) {
			waitForElement(driver, Payer_Search_Btn_Receipt);
			click(driver,Payer_Search_Btn_Receipt);
			
			globalValueSearchWindow(driver, dropdownCondition, Payer_Code_SearchType, Payer_Code_Value,
					"", "", "", "");
			
		}
		//Payer_Search_Btn_Receipt
		
		if (!actualPayer.equals("")) {
			System.out.println(
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are shown || Actual Payer is : "
							+ actualPayer);
			Extent_pass_New(driver,
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are shown || Actual Payer is : "
							+ actualPayer,
					test, test1);
		} else {
			System.out.println(
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are not shown || Actual Payer is : "
							+ actualPayer);
			Extent_fail(driver,
					" Expected result is :  After selected the customer, payer details should be shown || Actual result is : After selected the customer, payer details are not shown || Actual Payer is : "
							+ actualPayer,
					test, test1);
		}

		if (!actualPayerName.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is shown || Actual Payer Name : "
							+ actualPayerName);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is shown || Actual Payer Name : "
							+ actualPayerName,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is not shown || Actual Payer Name : "
							+ actualPayerName);
			Extent_fail(driver,
					"Expected result is :  After selected the customer, payer name should be shown || Actual result is : After selected the customer, payer Name is not shown || Actual Payer Name : "
							+ actualPayerName,
					test, test1);
		}

		if (!actualCustomer.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was shown || Actual Customer : "
							+ actualCustomer);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was shown || Actual Customer : "
							+ actualCustomer,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was not shown || Actual Customer : "
							+ actualCustomer);
			Extent_fail(driver,
					"Expected result is :  After selected the customer, customer code should be shown || Actual result is :  After selected the customer, Customer code was not shown || Actual Customer : "
							+ actualCustomer,
					test, test1);
		}

		if (!actualPayerAddress.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was shown || Actual Payer Addrress : "
							+ actualPayerAddress);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was shown || Actual Payer Addrress : "
							+ actualPayerAddress,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was not shown || Actual Payer Addrress : "
							+ actualPayerAddress);
			Extent_fail(driver,
					"Expected result is :  After selected the customer, payer address should be shown || Actual result is : After selected the customer, Payer address was not shown || Actual Payer Addrress : "
							+ actualPayerAddress,
					test, test1);
		}

		if (!actualCustomer_Name.equals("")) {
			System.out.println(
					"Expected result is :  After selected the customer, Customer name should be shown || Actual result is : After selected the customer, Customer name was shown || Actual Customer Name : "
							+ actualCustomer_Name);
			Extent_pass_New(driver,
					"Expected result is :  After selected the customer, Customer name should be shown || Actual result is : After selected the customer, Customer name was shown || Actual Customer Name : "
							+ actualCustomer_Name,
					test, test1);
		} else {
			System.out.println(
					"Expected result is :  After selected the customer, Customer name should be shown || Actual result is : After selected the customer, Customer name was not shown || Actual Customer Name : "
							+ actualCustomer_Name);
			Extent_fail(driver,
					"Expected result is :  After selected the customer, Customer name should be shown || Actual result is : After selected the customer, Customer name was not shown || Actual Customer Name : "
							+ actualCustomer_Name,
					test, test1);
		}

		Step_End(6,
				"once selected the customer ,customer name , address,payercode  and payername  has to be shown. from customer  master",
				test, test1);

		Step_Start(7, "go to the payment details", test, test1);

		waitForElement(driver, paymentDetails_Tab);
		click(driver, paymentDetails_Tab);
		scrollBottom(driver);
		Step_End(7, "go to the payment details", test, test1);

		Step_Start(8, "select the cheque mode in mode dropdownfield", test, test1);

		if(!payment_Mode.trim().equals("")) {

			waitForElement(driver, paymentMode_Dropdown);
			click(driver, paymentMode_Dropdown);
			String select_Mode = String.format(paymentMode, payment_Mode);
			waitForDisplay(driver, select_Mode);
			click(driver, select_Mode);
		}
		Step_End(8, "select the cheque mode in mode dropdownfield", test, test1);

		Step_Start(9, "enter the number in number field", test, test1);

		
		if(!Excess_Invo_No.trim().equals("")) {
			waitForElement(driver, Excess_Invoice_Number_Receipt);
			click(driver,Excess_Invoice_Number_Receipt);
			formatLocatorClick(driver, DropDown_Select, Excess_Invo_No);
		}
		
		if(!cheque_Number.trim().equals("")) {
			waitForElement(driver, number_Txtfield);
			sendKeys(driver, number_Txtfield, cheque_Number);
		}
		
		Step_End(9, "enter the number in number field", test, test1);

		
		if(!Date_Value_Receipt.trim().equals("")) {
			waitForElement(driver, Date_Input_Receipt);
			try {
				click(driver,Date_Input_Receipt);
				selectDateInCalender(driver,Date_Value_Receipt,Date_Text_Value,Month_Text_Value,Year_Text_Value,previous_Button_DatePicker,next_Button_DatePicker);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(!Proposed_Date_Receipt.trim().equals("")) {
			
			waitForElement(driver, Proposal_Date_Input_Receipt);
			click(driver,Proposal_Date_Input_Receipt);
			try {
				selectDateInCalender(driver,Proposed_Date_Receipt,Date_Text_Value,Month_Text_Value,Year_Text_Value,previous_Button_DatePicker,next_Button_DatePicker);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
			twoColumnSearchWindow(driver, Bankcode_Header, condition, bankname);

		}
		
		Step_End(11, "select the bank name in bank name search field", test, test1);

		Step_Start(13, "select the currency", test, test1);
		if(!currencyCode.trim().equals("")) {

			waitForElement(driver, currency_SearchButton);
			click(driver, currency_SearchButton);
	
			twoColumnSearchWindow(driver, Currency_Header, condition, currencyCode);
		}
		Step_End(13, "select the currency", test, test1);
		
		
		
		Step_Start(14, "once select the currency roe field roe has automatically fetched", test, test1);		
		if(!Deposit_Bank_Value.trim().equals("")) {
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);
			twoColumnSearchWindow(driver, Deposit_Bank_Header, condition, Deposit_Bank_Value);
		}
		
		if(!Receipt_Remarks.trim().equals("")) {
			
			waitForElement(driver, Remarks_Input_Receipt);
			sendKeys(driver, Remarks_Input_Receipt, Receipt_Remarks);
			
		}
		
		waitForElement(driver, roe_Textfield);
		String actual_ROE = getAttribute(driver, roe_Textfield, "value");
		if (!actual_ROE.equals("")) {
			System.out.println(
					"Expected result is : Selected ROE Value should be displayed || Actual result is : Selected ROE Value was displayed || The selected ROE Was "
							+ actual_ROE);
			Extent_pass_New(driver,
					"Expected result is : Selected ROE Value should be displayed || Actual result is : Selected ROE Value was displayed || The selected ROE Was "
							+ actual_ROE,
					test, test1);
		} else {
			System.out.println(
					"Expected result is : Selected ROE Value should be displayed || Actual result is : Selected ROE Value was not displayed || The selected ROE Was "
							+ actual_ROE);
			Extent_fail(driver,
					"Expected result is : Selected ROE Value should be displayed || Actual result is : Selected ROE Value was not displayed || The selected ROE Was "
							+ actual_ROE,
					test, test1);
		}

		Step_End(14, "once select the currency roe field roe has automatically fetched", test, test1);
		Step_Start(15, "amount field value has shown , automatically amount fected based on amount * roe", test, test1);

		// Amount * ROE

		String act_Amount = getAttribute(driver, amountAED_Textfield, "value");
		String actual_Amount = act_Amount.replace(",", "");
		String actualAmount = getAttribute(driver, amount_Textfield, "value");
		String actualROE = getAttribute(driver, roe_Textfield, "value");

		double actAmount = Double.parseDouble(actualAmount);
		double actROE = Double.parseDouble(actualROE);
		System.out.println("actAmount : " + actAmount);
		System.out.println("actROE : " + actROE);

		double exp_Amount = actAmount * actROE;

		System.out.println("exp_Amount : " + exp_Amount);

		BigDecimal bigDecimal = new BigDecimal(exp_Amount).setScale(2, RoundingMode.HALF_UP);
		String expected_Amount = bigDecimal.toString();
		System.out.println(expected_Amount);

		if (actual_Amount.equals(expected_Amount)) {
			System.out.println("Matched || Automatically amount fected based on amount * roe || Expected Amount : "
					+ expected_Amount + " || Actual Amount : " + actual_Amount);
			Extent_pass_New(driver, "Matched || Automatically amount fected based on amount * roe || Expected Amount : "
					+ expected_Amount + " || Actual Amount : " + actual_Amount, test, test1);
		} else {
			System.out.println(
					"Not Matched || Automatically amount not fected based on amount * roe || Expected Amount : "
							+ expected_Amount + " || Actual Amount : " + actual_Amount);
			Extent_fail(driver,
					"Not Matched || Automatically amount not fected based on amount * roe || Expected Amount : "
							+ expected_Amount + " || Actual Amount : " + actual_Amount,
					test, test1);
		}

		Step_End(15, "amount field value has shown , automatically amount fected based on amount * roe", test, test1);
		Step_Start(12, "enter the amount", test, test1);
		
		if(!amount.trim().equals("")) {
			waitForElement(driver, amount_Textfield);
			click(driver, amount_Textfield);
			waitForElement(driver, amount_Textfield);
			clearAndType(driver, amount_Textfield, amount);
			waitForElement(driver, amount_Textfield);
			click(driver, amount_Textfield);
		}
		
		Step_End(12, "enter the amount", test, test1);
		Step_Start(16, "click the add button ", test, test1);

		waitForElement(driver, paymentDetails_Add_Button);
		click(driver, paymentDetails_Add_Button);

		Step_End(16, "click the add button ", test, test1);
		Step_Start(17, "once added the payment,below grid value has shown.", test, test1);

		waitForElement(driver, paymentDetails_Table_Rows);

		List<Map<String, String>> paymentDetails_Table = getTableData(driver, paymentDetails_Table_Columns,
				paymentDetails_Table_Rows);

		List<String> paymentDetailsColumnHeaders = splitAndExpand(paymentDetail_Columns);

		String paymentDetails_Table_data = TableDataForReport(driver, paymentDetails_Table, paymentDetails_Table_Name,
				paymentDetailsColumnHeaders);

		if (isDisplayed(driver, paymentDetails_Table_Rows)) {

			System.out.println(
					"Pass || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are showing in the grid");
			Extent_pass_New(driver,
					"Pass || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are showing in the grid",
					test, test1);
			Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" + paymentDetails_Table_data + "</pre>", test,
					test1);
		} else {
			System.out.println(
					"Fail || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are showing in the grid");
			Extent_fail(driver,
					"Fail || Expected result was : Once added the payment, Values should show in the grid || Actual result is : Once added the payment, Values are not showing in the grid",
					test, test1);

		}

		Step_End(17, "once added the payment,below grid value has shown.", test, test1);
		Step_Start(18, "click the save button in tool bar", test, test1);

		scrollTop(driver);
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
			System.out.println(
					"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup, test,
					test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup);
			Extent_fail(driver,
					"Not Matched || Expected Popup : " + receiptSavedPopup + " || Actual Popup : " + actualSavedPopup,
					test, test1);
		}

		Step_End(19, "system has validate --Receipt saved\r\n Ok", test, test1);

		Extent_call(test, test1, "-------------------verify------------------------");
		Step_Start(20, "Receipt number field -newly receipt number generated and showing green color", test, test1);

		waitForElement(driver, recieptNo_Textfield);

		String actualColor = getTextBackgroundColor(driver, recieptNo_Textfield);
		String Receipt_No=getAttribute(driver, recieptNo_Textfield, "value");
		
		waitForElement(driver, Mode_of_Payment_Receipt);
		String ReceiptMode=getText(driver, Mode_of_Payment_Receipt);
		
		
		String Actcolor=getColorName(actualColor);
		System.out.println(Actcolor);
		
		if (Actcolor.equalsIgnoreCase(greenColorCode)) {
			System.out.println("Receipt number fields are showing as expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + Actcolor);
			Extent_pass_New(driver, "Receipt number fields are showing as expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + Actcolor, test, test1);
		} else {
			System.out.println("Receipt number fields are not showing as expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + Actcolor);
			Extent_fail(driver, "Receipt number fields are not showing as expected color || Expected color was : "
					+ greenColorCode + " || Actual color was : " + Actcolor, test, test1);
		}

		Step_End(20, "Receipt number field -newly receipt number generated and showing green color", test, test1);
		if (delete_Receipt.equalsIgnoreCase("yes")) {
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			waitForElement(driver, popup_Message);
			String PoupValue=getText(driver, popup_Message);
			if(PoupValue.contains(Cannot_Cancel_Receipt_Popup)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				if(ReceiptMode.equalsIgnoreCase("Cash")) {
					DeleteReceiptInCashDeposit(driver,Cash_Deposit_Module,dropdownCondition,Global_search_value_Receipt_No,Receipt_No,Cash_Deposit_delete_Popup1,Cash_Deposit_Delete_Popup2);
				}else if (ReceiptMode.equalsIgnoreCase("Wire Transfer")) {
					DeleteReceiptInChequeRealization(driver,Cheque_module,dropdownCondition,Global_search_value_Receipt_No,Receipt_No,reset_Popup_Expected,reversed_successful_Expected);
				}else if(ReceiptMode.equalsIgnoreCase("Cheque")) {
					DeleteReceiptInDD_Deposit(driver,Cheque_DD_Deposit_Module,dropdownCondition,Global_search_value_Receipt_No,Receipt_No,DD_Deposit_delete_Popup1,DD_Deposit_Delete_Popup2);
				}
				
				
				
			}else {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
			}
				
				
			Step_Start(21, "once saved the receipt ,tool bar delete button has enable.", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			if (isElementAccessible(driver, Delete_button_toolBar)) {
				System.out.println(
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled");
				Extent_pass_New(driver,
						"Pass || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled");
				Extent_fail(driver,
						"Fail || Expected result is : once saved the receipt ,tool bar delete button should be enable || Actual result is : Delete button is disabled",
						test, test1);
			}
			Step_End(21, "once saved the receipt ,tool bar delete button has enable.", test, test1);
			Step_Start(22, "click the delete button -system has validate -enter the remarks", test, test1);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, enterRemarksPopup);
			String actEnterRemarks_popup = getText(driver, popup_Message);
			if (actEnterRemarks_popup.equals(enterRemarksPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);

				Step_End(22, "click the delete button -system has validate -enter the remarks", test, test1);
				Step_Start(23, "click ok", test, test1);

				click(driver, popup_Message_Ok_Button);

				Step_End(23, "click ok", test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + enterRemarksPopup + " || Actual popup : "
						+ actEnterRemarks_popup, test, test1);

			}

			Step_Start(24, "enter the remarks ", test, test1);

			waitForElement(driver, reciept_remarks_TextArea);
			sendKeys(driver, reciept_remarks_TextArea, receiptRemark);

			Step_End(24, "enter the remarks ", test, test1);
			Step_Start(25, "click the delete buton", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			Step_End(25, "click the delete buton", test, test1);
			Step_Start(26, "system has validate - Are you sure you want to delete ? \r\n No Yes", test, test1);

			waitForPopup(driver, popup_Message, wantToDeletePopup);
			String actWantToDelete_popup = getText(driver, popup_Message);
			if (actWantToDelete_popup.equals(wantToDeletePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);
				System.out.println("Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);

				Step_End(26, "system has validate - Are you sure you want to delete ? \r\n No Yes", test, test1);
				Step_Start(28, "click the yes button", test, test1);

				click(driver, popup_Message_Yes_Button);

				Step_End(28, "click the yes button", test, test1);

			} else {
				System.out.println("Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup);
				Extent_fail(driver, "Not Matched || Expected Popup : " + wantToDeletePopup + " || Actual popup : "
						+ actWantToDelete_popup, test, test1);

			}

			Step_Start(29, "Receipt cancelled-receipt no showing red color", test, test1);

			waitForPopup(driver, popup_Message, cancelledPopup);

			String actDeleted_popup = getText(driver, popup_Message);

			if (actDeleted_popup.equals(cancelledPopup)) {
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);
				System.out.println(
						"Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + cancelledPopup + " || Actual popup : " + actDeleted_popup,
						test, test1);

			}

			waitForElement(driver, recieptNo_Textfield);
			String actualCancelledColor = getTextBackgroundColor(driver, recieptNo_Textfield);

			String Act_Color=getColorName(actualCancelledColor);
			if (Act_Color.equalsIgnoreCase(redColorCode)) {
				System.out.println("Receipt number fields are showing as expected color || Expected color was : "
						+ redColorCode + " || Actual color was : " + Act_Color);
				Extent_pass_New(driver, "Receipt number fields are showing as expected color || Expected color was : "
						+ redColorCode + " || Actual color was : " + Act_Color, test, test1);
			} else {
				System.out.println("Receipt number fields are not showing as expected color || Expected color was : "
						+ redColorCode + " || Actual color was : " + Act_Color);
				Extent_fail(driver, "Receipt number fields are not showing as expected color || Expected color was : "
						+ redColorCode + " || Actual color was : " + Act_Color, test, test1);
			}

			Step_End(29, "Receipt cancelled-receipt no showing red color", test, test1);
		}

		Extent_completed(testCaseName, test, test1);
	}
}
