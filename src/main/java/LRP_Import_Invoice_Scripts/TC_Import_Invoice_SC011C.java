package LRP_Import_Invoice_Scripts;

import java.awt.AWTException;
import java.text.ParseException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC011C extends Keywords {
	public void Import_Invoice_SC011C(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws AWTException, ParseException {

		String testcase_Name = "TC_Import_Invoice_SC011C";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Condition = Excel_data.get("BL_Condition");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_search_value = Excel_data.get("Select_search_value");
		String BL_Num = Excel_data.get("BL_Num");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Print_reason = Excel_data.get("Print_reason");
		String Customer_Master_Module = Excel_data.get("Customer_Master_Module");
		String Customer_Filter_Type1 = Excel_data.get("Customer_Filter_Type1");
		String invoice_sts_data = Excel_data.get("invoice_sts_data");
		String Import_invoice_delete = Excel_data.get("Import_invoice_delete");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		verifyMainMenu(driver);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, "open the import invoice module", test, test1);

		moduleNavigate(driver, Field_Names);
		Step_End(2, "open the import invoice module", test, test1);

		Extent_call(test, test1, "If like to Go By BL follow below step,");

		Step_Start(3, "click the new button", test, test1);

		newButton(driver);

		Step_End(3, "click the new button", test, test1);

		Step_Start(4, "Click on BL NO Search and Paste the BL in the search and then load the BL.", test, test1);

		waitForElement(driver, import_invoice_bl_search);
		click(driver, import_invoice_bl_search);

		globalValueSearchWindow(driver, BL_Condition, Select_search_value, BL_Num, "", "", "", "");

		Step_End(4, "Click on BL NO Search and Paste the BL in the search and then load the BL.", test, test1);

		waitForElement(driver, import_invoice_bl);
		String BL_Numberact = getAttribute(driver, import_invoice_bl, "value");

		System.out.println(BL_Numberact);

		if (BL_Num.equals(BL_Numberact)) {
			System.out.println("Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : " + BL_Numberact);

			Extent_pass_New(driver,
					"Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : " + BL_Numberact, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : " + BL_Numberact);
			Extent_fail(driver,
					"Not Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : " + BL_Numberact, test,
					test1);

		}
		Step_Start(12,
				"In the BL details tab, the system has displayed only the saved BLs from the import documentation module in the import invoice module.",
				test, test1);

		waitForElement(driver, Billing_number_filter);
		waitForElement(driver, Billing_number_filter);
		sendKeys(driver, Billing_number_filter, BL_Num);
		waitForElement(driver, Billing_number_filter_select);
		click(driver, Billing_number_filter_select);

		Step_End(12,
				"In the BL details tab, the system has displayed only the saved BLs from the import documentation module in the import invoice module.",
				test, test1);

		Step_Start(13, "click on save button ", test, test1);

		waitForElement(driver, import_Invoice_Actual_customer_Code);
		String Customer_Code_Text = getAttribute(driver, import_Invoice_Actual_customer_Code, "value");
		System.out.println(Customer_Code_Text);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		Extent_call(test, test1, "For Verify Draft Invoice");
		waitForElement(driver, import_invoice_draft_button);
		click(driver, import_invoice_draft_button);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(13, "click on save button ", test, test1);

		waitForPopup(driver, popup_Message, Draft_saved_pop);

		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);

		if (Draft_saved_pop.equals(import_saved_act)) {
			System.out.println(
					"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act);

			Extent_fail(driver,
					"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
					test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_Start(14, "capture the values showing in grid gien in test data ", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
//		

		moduleNavigate(driver, Customer_Master_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, BL_Condition, Customer_Filter_Type1, Customer_Code_Text, "", "", "", "");

		waitForElement(driver, Customer_Code_Field);
		String Customer_Code_CM = getAttribute(driver, Customer_Code_Field, "value");

		waitForElement(driver, CustomerName_CM);
		String Customer_Name_CM = getAttribute(driver, CustomerName_CM, "value");

		scrollBottom(driver);
		waitForElement(driver, Bill_Address1);
		String Bill_Address_CM = getAttribute(driver, Bill_Address1, "value");

		scrollTop(driver);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, Field_Names);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, BL_Condition, Select_search_value, BL_Num, "", "", "", "");

		waitForElement(driver, invoice_sts_filter_input);
		sendKeys(driver, invoice_sts_filter_input, invoice_sts_data);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);

		scrollTop(driver);

		Step_Start(15, " Click on Print Button, ", test, test1);

		waitForElement(driver, import_invoice_print_button);
		click(driver, import_invoice_print_button);

		Step_End(15, " Click on Print Button, ", test, test1);

		Step_Start(16,
				"  System will open Invoice printout Dialoge Box User has to select any one of the option as per User Wish ",
				test, test1);
		String print_select = String.format(import_invoice_print_dialogue, Print_reason);
		waitForElement(driver, print_select);
		click(driver, print_select);

//		waitForElement(driver, print_contnr_numbr_chckbx);
//		click(driver, print_contnr_numbr_chckbx);

		waitForElement(driver, import_invoice_print_box_inside);
		click(driver, import_invoice_print_box_inside);

		Step_End(16,
				"  System will open Invoice printout Dialoge Box User has to select any one of the option as per User Wish ",
				test, test1);

		wait(driver, "5");

		waitForDisplay(driver, jsp_Iframe);
		switchToFrame(driver, jsp_Iframe);

		Step_Start(17, "  Verify the values given data in equal in print", test, test1);

		String container_name_p = String.format(container_name_print1, Customer_Code_CM);
		waitForElement(driver, container_name_p);
		String container_print_text = getText(driver, container_name_p);
		mouseOverToElement(driver, container_name_p);

		if (Customer_Code_CM.equals(container_print_text)) {
			System.out.println(
					"Matched || Expected Result is : Customer Code from Customer Master Module : " + Customer_Code_CM
							+ " || Actual Result is : Customer Code From Import Invoice Print " + container_print_text);
			Extent_pass_New(driver,
					"Matched || Expected Result is : Customer Code from Customer Master Module : " + Customer_Code_CM
							+ " || Actual Result is : Customer Code From Import Invoice Print " + container_print_text,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Result is : Customer Code from Customer Master Module : "
					+ Customer_Code_CM + " || Actual Result is : Customer Code From Import Invoice Print "
					+ container_print_text);
			Extent_fail(driver,
					"Not Matched || Expected Result is : Customer Code from Customer Master Module : "
							+ Customer_Code_CM + " || Actual Result is : Customer Code From Import Invoice Print "
							+ container_print_text,
					test, test1);
		}

		String customer_Name = String.format(container_name_print1, Customer_Name_CM);
		waitForElement(driver, customer_Name);
		String customer_Name_Text = getText(driver, customer_Name);
		mouseOverToElement(driver, customer_Name);

		if (Customer_Name_CM.equals(customer_Name_Text)) {
			System.out.println(
					"Matched || Expected Result is : Customer Name from Customer Master Module : " + Customer_Name_CM
							+ " || Actual Result is : Customer Name From Import Invoice Print " + customer_Name_Text);
			Extent_pass_New(driver,
					"Matched || Expected Result is : Customer Name from Customer Master Module : " + Customer_Name_CM
							+ " || Actual Result is : Customer Name From Import Invoice Print " + customer_Name_Text,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Result is : Customer Name from Customer Master Module : "
					+ Customer_Name_CM + " || Actual Result is : Customer Name From Import Invoice Print "
					+ customer_Name_Text);
			Extent_fail(driver,
					"Not Matched || Expected Result is : Customer Name from Customer Master Module : "
							+ Customer_Name_CM + " || Actual Result is : Customer Name From Import Invoice Print "
							+ customer_Name_Text,
					test, test1);
		}

		String customer_Address = String.format(container_name_print1, Bill_Address_CM.toUpperCase());
		waitForElement(driver, customer_Address);
		String customer_Address_Text = getText(driver, customer_Address);
		mouseOverToElement(driver, customer_Address);

		if (Bill_Address_CM.toUpperCase().contains(customer_Address_Text.toUpperCase())) {
			System.out.println("Matched || Expected Result is : Customer Address from Customer Master Module : "
					+ Bill_Address_CM + " || Actual Result is : Customer Address From Import Invoice Print "
					+ customer_Address_Text);
			Extent_pass_New(driver,
					"Matched || Expected Result is : Customer Address from Customer Master Module : " + Bill_Address_CM
							+ " || Actual Result is : Customer Address From Import Invoice Print "
							+ customer_Address_Text,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Result is : Customer Address from Customer Master Module : "
					+ Bill_Address_CM + " || Actual Result is : Customer Address From Import Invoice Print "
					+ customer_Address_Text);
			Extent_fail(driver,
					"Not Matched || Expected Result is : Customer Address from Customer Master Module : "
							+ Bill_Address_CM + " || Actual Result is : Customer Address From Import Invoice Print "
							+ customer_Address_Text,
					test, test1);
		}

		driver.switchTo().defaultContent();
		waitForElement(driver, import_Invoice_print_close);
		click(driver, import_Invoice_print_close);

		Import_Invoice_Draft_Delete(driver, Import_invoice_delete);

		Extent_completed(testcase_Name, test, test1);

	}
}
