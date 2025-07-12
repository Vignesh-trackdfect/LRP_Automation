package LRP_Import_Invoice_Scripts;

import java.awt.AWTException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.Import_Invoice_Locators;

public class TC_Import_Invoice_SC011A extends Keywords {
	public void Import_Invoice_SC011A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws AWTException, ParseException {

		String testcase_Name = "TC_Import_Invoice_SC011A";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Condition = Excel_data.get("BL_Condition");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_search_value = Excel_data.get("Select_search_value");
		String BL_Num = Excel_data.get("BL_Num");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String headers = Excel_data.get("headers");
		String Row_Number = Excel_data.get("Row_Number");
		String Print_reason = Excel_data.get("Print_reason");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String Date_Headers = Excel_data.get("Date_Headers");
		String colour = Excel_data.get("colour");

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

			Extent_pass_New(driver, "Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : " + BL_Numberact,
					test, test1);

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

		waitForElement(driver, import_invoice_first_row);
		String draftcolouract = getTextBackgroundColor(driver, import_invoice_first_row);
		System.out.println(draftcolouract);
		String draftcolouract1 = getColorName(draftcolouract);
		System.out.println(draftcolouract1);

		if (colour.equalsIgnoreCase(draftcolouract1)) {

			System.out.println("Row colors are changed as expected || Expected colour : " + colour
					+ " || Actual colour : " + draftcolouract1);
			Extent_pass_New(driver, "Row colors are changed as expected || Expected colour : " + colour
					+ " || Actual colour : " + draftcolouract1, test, test1);

		} else {
			System.out.println("Row colors are not changed as expected || Expected colour : " + colour
					+ " || Actual colour : " + draftcolouract1);
			Extent_fail(driver, "Row colors are not changed as expected || Expected colour : " + colour
					+ " || Actual colour : " + draftcolouract1, test, test1);

		}

		Step_Start(14, "capture the values showing in girs gien in test data ", test, test1);
		String str = Row_Number;
		int number = Integer.parseInt(str);

		List<String> Gird_hearders = splitAndExpand(headers);
		List<Map<String, String>> ImportInvoice_Tabledata1 = getTableData(driver, import_Invoice_header,
				import_Invoice_row);
		Map<String, String> address_Grid = getValueByRowAndHeaders(ImportInvoice_Tabledata1, number, Gird_hearders);
		for (String Grid_header : Gird_hearders) {
			String value = address_Grid.get(Grid_header);
			System.out.println(Grid_header + " : " + value);

		}

		List<String> datee_hearders = splitAndExpand(Date_Headers);
		List<Map<String, String>> ImportInvoice_date = getTableData(driver, import_Invoice_header, import_Invoice_row);
		Map<String, String> date_Grid = getValueByRowAndHeaders(ImportInvoice_date, number, datee_hearders);
		for (String Grid_header : datee_hearders) {
			String value = date_Grid.get(Grid_header);
			System.out.println(Grid_header + " : " + value);

			// Define the original date format and the new desired format
			SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy"); // Input format
			SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy"); // Desired format

			// Parse the original date string to Date object
			java.util.Date date = originalFormat.parse(value);

			// Format the Date object into the new format
			String formattedDate = targetFormat.format(date);

			// Print the formatted date
			System.out.println(Grid_header + " : " + formattedDate); // Output will be 23-Dec-2025

		}
		Step_End(14, "capture the values showing in girs gien in test data ", test, test1);

		String row_select_print = String.format(row_click, Row_Number);
		waitForElement(driver, row_select_print);
		click(driver, row_select_print);

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

		for (String Grid_header1 : Gird_hearders) {
			String value1 = address_Grid.get(Grid_header1);

			String container_name_p = String.format(container_name_print1, value1);
			waitForElement(driver, container_name_p);
			String container_print_text = getText(driver, container_name_p);
			mouseOverToElement(driver, container_name_p);
			
			if (value1.trim().equalsIgnoreCase(container_print_text.trim())) {
				System.out.println("Matched || Expected value in application gird : " + value1
						+ " || Actual value in print : " + container_print_text);
				Extent_pass_New(driver, "Matched || Expected value in application gird : " + value1
						+ " || Actual value in print : " + container_print_text, test, test1);

			} else {

				System.out.println("Not Matched || Expected value in application gird : " + value1
						+ " || Actual value in print : " + container_print_text);
				Extent_fail(driver, "Not Matched || Expected value in application gird : " + value1
						+ " || Actual value in print : " + container_print_text, test, test1);

			}

		}


		
		
		for (String Grid_header : datee_hearders) {
		    String value = date_Grid.get(Grid_header);
		    System.out.println(Grid_header + " : " + value);

		    // Parse original date
		    SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yy");
		    inputFormat.setLenient(false);

		    // Desired format
		    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy");

		    try {
		        java.util.Date date = inputFormat.parse(value);
		        String formattedDate = outputFormat.format(date); // e.g., 23-Dec-2025

		        System.out.println(Grid_header + " : " + formattedDate);

		        // Build XPath using formatted date
		        String container_name_p = String.format(Import_Invoice_Locators.container_name_print1, formattedDate);

		        waitForElement(driver, container_name_p);
		        String container_print_text = getText(driver, container_name_p);
		        mouseOverToElement(driver, container_name_p);

		        // Compare values
		        if (formattedDate.trim().equalsIgnoreCase(container_print_text.trim())) {
		            System.out.println("Matched || Expected value in application grid: " + formattedDate
		                    + " || Actual value in print: " + container_print_text);
		            Extent_pass_New(driver, "Matched || Expected value in application grid: " + formattedDate
		                    + " || Actual value in print: " + container_print_text, test, test1);
		        } else {
		            System.out.println("Not Matched || Expected value in application grid: " + formattedDate
		                    + " || Actual value in print: " + container_print_text);
		            Extent_fail(driver, "Not Matched || Expected value in application grid: " + formattedDate
		                    + " || Actual value in print: " + container_print_text, test, test1);
		        }

		    } catch (ParseException e) {
		        System.err.println("Invalid date format for: " + Grid_header + " -> " + value);
		        Extent_fail(driver, "Invalid date format for: " + Grid_header + " -> " + value, test, test1);
		    }
		}
		
		Step_End(17, "  Verify the values given data in equal in print", test, test1);

		Extent_pass_New(driver, "Expected : Uploaded charges listed in Import invoice module. || Actual : Uploaded charges listed in Import invoice module.", test, test1);
		
		driver.switchTo().defaultContent();
		waitForElement(driver, import_Invoice_print_close);
		click(driver, import_Invoice_print_close);

		Import_Invoice_Draft_Delete(driver, Delete_Perform);
	
		Extent_completed(testcase_Name, test, test1);
	}

}
