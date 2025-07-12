package LRP_Ecommerce_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_035 extends Keywords {

	public void Ecommerce_Gateway_Validator_035(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_035";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Transaction_Type = Excel_data.get("Transaction_Type");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Customer_Master_Module = Excel_data.get("Customer_Master_Module");
		String Customer_Type_Header = Excel_data.get("Customer_Type_Header");
		String Customer_Type = Excel_data.get("Customer_Type");
		String Customer_Detail_Option = Excel_data.get("Customer_Detail_Option");

		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_Port = Excel_data.get("SearchBy_Port");
		String SingleFillingPopup = Excel_data.get("SingleFillingPopup");
		String Buyer_Seller_Popup = Excel_data.get("Buyer_Seller_Popup");
		String searchBy_Customer = Excel_data.get("SearchBy_Customer");
		String Buyer_Seller_CustomerType = Excel_data.get("Buyer_Seller_CustomerType");

		String Supplementary_Declarant_Details_Popup = Excel_data.get("Supplementary_Declarant_Details_Popup");
		String Button_Status = Excel_data.get("Button_Status");
		String Method_Of_Payment = Excel_data.get("Method_Of_Payment");
		String Agreement_Party_Popup = Excel_data.get("Agreement_Party_Popup");

		String DateCheckbox_Status = Excel_data.get("DateCheckbox_Status");
		String Given_From_Date = Excel_data.get("Given_From_Date");
		String Given_To_Date = Excel_data.get("Given_To_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Customer_Master_Updated_Popup = Excel_data.get("Customer_Master_Updated_Popup");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForDownload(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Transaction_Type);

		if (DateCheckbox_Status.equals("Yes")) {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_FromDate_Input);
				selectDatePicker(driver, EG_FromDate_Input, Given_From_Date);

			} else {

				waitForElement(driver, EG_FromDate_Input);
				clear(driver, EG_FromDate_Input);
				sendKeys(driver, EG_FromDate_Input, Given_From_Date);

			}

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_ToDate_Input);
				selectDatePicker(driver, EG_ToDate_Input, Given_To_Date);

			} else {

				waitForElement(driver, EG_ToDate_Input);
				clear(driver, EG_ToDate_Input);
				sendKeys(driver, EG_ToDate_Input, Given_To_Date);

			}

		} else {

			waitForElement(driver, EG_FromDate_Input);

			Given_From_Date = getAttribute(driver, EG_FromDate_Input, "value");
			Given_To_Date = getAttribute(driver, EG_ToDate_Input, "value");

		}

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}

		if (!Booking_Number.equals("")) {
			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);
		}

		if (!Reference_Number.equals("")) {
			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);
		}

		if (!bl_NumberInput.equals("")) {
			waitForElement(driver, EG_BLNo_input);
			sendKeys(driver, EG_BLNo_input, bl_NumberInput);
		}

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		String actual_DischarePort = getAttribute1(driver, EBK_Discharge_Port_Value, "value");

		Step_Start(1,
				"SI (ENS Customer Declaration): \"Delivery or Discharge Port EU1875\" flag in Port Master should be considered for ENS filing.",
				test, test1);

		moduleNavigate(driver, Ports_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Port, actual_DischarePort, "", "", "", "");

		if (isElementSelected(driver, EUR_1875_Port_Checkbox)) {
			System.out.println("Passed || Expected : EUR 1875 Port checkbox Should be selected || Actual : EUR 1875 Port checkbox is selected");
			Extent_pass_New(driver, "Passed || Expected : EUR 1875 Port checkbox Should be selected || Actual : EUR 1875 Port checkbox is selected", test, test1);
		} else {
			System.out.println("Failed || Expected : EUR 1875 Port checkbox Should be selected || Actual : EUR 1875 Port checkbox is unselected");
			Extent_fail(driver, "Failed || Expected : EUR 1875 Port checkbox Should be selected || Actual : EUR 1875 Port checkbox is unselected", test, test1);
		}

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(1,
				"SI (ENS Customer Declaration): \"Delivery or Discharge Port EU1875\" flag in Port Master should be considered for ENS filing.",
				test, test1);
		Step_Start(2,
				"Booking: If AP Customer Multiple Filing is not enabled, system shows message: \"Agreement Party is not allowed for Multiple Filing.\"",
				test, test1);

		waitForElement(driver, EBK_Customer_Tab);
		click(driver, EBK_Customer_Tab);

		waitForElement(driver, EBK_Customer_Table_Rows);
		List<Map<String, String>> customerTableData = getTableData(driver, EBK_Customer_Table_Headers,
				EBK_Customer_Table_Rows);
		String actualCustomer = getValueByFirstColumnAndHeader(customerTableData, Customer_Type_Header, Customer_Type,
				Customer_Detail_Option);

//	Customer master
		moduleNavigate(driver, Customer_Master_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Customer, actualCustomer, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, multiple_Filing_Agreement_Checkbox);
		checkBox(driver, multiple_Filing_Agreement_Checkbox, "No");

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Customer_Master_Updated_Popup);
		String actPopup=getText(driver, popup_Message);
		if(actPopup.equals(Customer_Master_Updated_Popup)) {
			System.out.println("Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_pass_New(driver, "Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		
		waitForElement(driver, EBK_ENS_Declaration_Tab);
		click(driver, EBK_ENS_Declaration_Tab);

		waitForElement(driver, EBK_Multiple_Filling_Button);
		String multiFill_RadioButtonStatus = getAttribute(driver, EBK_Multiple_Filling_Button, "class");

		if (multiFill_RadioButtonStatus.contains(Button_Status)) {
			click(driver, EBK_Single_Filling_Button);
		}
		
		waitForElement(driver, EBK_Multiple_Filling_Button);
		click(driver, EBK_Multiple_Filling_Button);

		waitForPopup(driver, popup_Message,Agreement_Party_Popup);
		String actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Agreement_Party_Popup)) {
			System.out.println("Matched || Expected Popup Message: " + Agreement_Party_Popup
					+ " || Actual Popup Message :" + actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup Message: " + Agreement_Party_Popup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Popup Message: " + Agreement_Party_Popup
					+ " || Actual Popup Message :" + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Popup Message: " + Agreement_Party_Popup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(2,
				"Booking: If AP Customer Multiple Filing is not enabled, system shows message: \"Agreement Party is not allowed for Multiple Filing.\"",
				test, test1);
		Step_Start(3, "Ecom SI & BL: Single Filing is allowed only for Straight BL.", test, test1);

		moduleNavigate(driver, Customer_Master_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Customer, actualCustomer, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, multiple_Filing_Agreement_Checkbox);
		checkBox(driver, multiple_Filing_Agreement_Checkbox, "Yes");

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Customer_Master_Updated_Popup);
		actPopup=getText(driver, popup_Message);
		if(actPopup.equals(Customer_Master_Updated_Popup)) {
			System.out.println("Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_pass_New(driver, "Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EBK_ENS_Declaration_Tab);
		click(driver, EBK_ENS_Declaration_Tab);

		waitForElement(driver, EBK_Master_BL_Button);
		click(driver, EBK_Master_BL_Button);

		waitForElement(driver, EBK_Single_Filling_Button);
		click(driver, EBK_Single_Filling_Button);

		waitForPopup(driver, popup_Message,SingleFillingPopup);
		actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(SingleFillingPopup)) {
			System.out.println("Matched || Expected Popup Message: " + SingleFillingPopup + " || Actual Popup Message :"
					+ actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup Message: " + SingleFillingPopup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Popup Message: " + SingleFillingPopup
					+ " || Actual Popup Message :" + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Popup Message: " + SingleFillingPopup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(3, "Ecom SI & BL: Single Filing is allowed only for Straight BL.", test, test1);
		Step_Start(4, "Ecom SI & BL: Multiple Filing is allowed for Straight BL and Master BL.", test, test1);


		waitForElement(driver, EBK_Straight_BL_Button);
		click(driver, EBK_Straight_BL_Button);

		waitForElement(driver, EBK_Single_Filling_Button);
		click(driver, EBK_Single_Filling_Button);

		waitForElement(driver, EBK_Multiple_Filling_Button);
		click(driver, EBK_Multiple_Filling_Button);

		waitForElement(driver, EBK_Master_BL_Button);
		click(driver, EBK_Master_BL_Button);

		waitForElement(driver, EBK_Straight_BL_Button);
		click(driver, EBK_Straight_BL_Button);

		Step_End(4, "Ecom SI & BL: Multiple Filing is allowed for Straight BL and Master BL.", test, test1);
		Step_Start(5, "Ecom SI & BL: Buyer and Seller selection is mandatory for Single Filing", test, test1);

// customer tab
		waitForElement(driver, EBK_Customer_Tab);
		click(driver, EBK_Customer_Tab);

		List<String> buyer_Seller = splitAndExpand(Buyer_Seller_CustomerType);

		for (int i = 0; i < buyer_Seller.size(); i++) {
			String customerType = String.format(EBK_Customer_Table_CustomerType, buyer_Seller.get(i));
			waitForDisplay(driver, customerType);
			if (isdisplayed(driver, customerType)) {
				doubleClick(driver, customerType);

				waitForElement(driver, EBK_Customer_Remove_Button);
				click(driver, EBK_Customer_Remove_Button);
			}
		}

//		ENS_Declaration_Tab

		waitForElement(driver, EBK_ENS_Declaration_Tab);
		click(driver, EBK_ENS_Declaration_Tab);

		waitForElement(driver, EBK_Single_Filling_Button);
		click(driver, EBK_Single_Filling_Button);

		String methodOfPayment = String.format(EBK_Of_Payment_Button, Method_Of_Payment);
		waitForElement(driver, methodOfPayment);
		String actualStatus = getAttribute(driver, methodOfPayment, "class");

		if (!actualStatus.contains(Button_Status)) {
			click(driver, methodOfPayment);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Buyer_Seller_Popup);
		actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Buyer_Seller_Popup)) {
			System.out.println("Matched || Expected Popup Message: " + Buyer_Seller_Popup + " || Actual Popup Message :"
					+ actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup Message: " + Buyer_Seller_Popup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Popup Message: " + Buyer_Seller_Popup
					+ " || Actual Popup Message :" + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Popup Message: " + Buyer_Seller_Popup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(5, "Ecom SI & BL: Buyer and Seller selection is mandatory for Single Filing", test, test1);
		Step_Start(6,
				" Ecom SI & BL: Multiple Filing - Supplementary Declarant details are mandatory for Multiple Filing",
				test, test1);

		waitForElement(driver, EBK_ENS_Declaration_Tab);
		click(driver, EBK_ENS_Declaration_Tab);

		waitForElement(driver, EBK_Multiple_Filling_Button);
		click(driver, EBK_Multiple_Filling_Button);

		waitForElement(driver, methodOfPayment);

		actualStatus = getAttribute(driver, methodOfPayment, "class");
		if (!actualStatus.contains(Button_Status)) {
			click(driver, methodOfPayment);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Supplementary_Declarant_Details_Popup);
		actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Supplementary_Declarant_Details_Popup)) {
			System.out.println("Matched || Expected Popup Message: " + Supplementary_Declarant_Details_Popup
					+ " || Actual Popup Message :" + actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup Message: " + Supplementary_Declarant_Details_Popup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Popup Message: " + Supplementary_Declarant_Details_Popup
					+ " || Actual Popup Message :" + actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Popup Message: " + Supplementary_Declarant_Details_Popup
					+ " || Actual Popup Message :" + actual_Popup, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6,
				" Ecom SI & BL: Multiple Filing - Supplementary Declarant details are mandatory for Multiple Filing",
				test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
