package LRP_Import_Invoice_Scripts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.Import_Invoice_Locators;

public class TC_Import_Invoice_SC011B extends Keywords {
	public void Import_Invoice_SC011B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws ParseException {

		String testcase_Name = "TC_Import_Invoice_SC011B";
		
		
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Condition = Excel_data.get("BL_Condition");
		String AgencyUser = Excel_data.get("AgencyUser");
		String BL_Num = Excel_data.get("BL_Num");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String service_input = Excel_data.get("service_input");
		String vesselss_code_input = Excel_data.get("vesselss_code_input");
		String voyagee_code_input = Excel_data.get("voyagee_code_input");
		String Bound_code_input = Excel_data.get("Bound_code_input");
		String headers = Excel_data.get("headers");
		String Row_Number = Excel_data.get("Row_Number");
		String Print_reason = Excel_data.get("Print_reason");
		String Field_Names_R = Excel_data.get("Field_Names_R");
		String Select_search_value_Reversal = Excel_data.get("Select_search_value_Reversal");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String Date_Headers = Excel_data.get("Date_Headers");
		String colour = Excel_data.get("colour");
		String Import_Doc_Customer_CodeHeader = Excel_data.get("Import_Doc_Customer_CodeHeader");
		String reverse_Option = Excel_data.get("reverse_Option");
		String Select_search_value = Excel_data.get("Select_search_value");
		String BL_Retrive_from_Import_invoice = Excel_data.get("BL_Retrive_from_Import_invoice");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String customer_code_select = Excel_data.get("customer_code_select");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");


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

		if (BL_Retrive_from_Import_invoice.equals("By_bl_Number")) {

			Step_Start(3, "click the new button", test, test1);

			newButton(driver);

			Step_End(3, "click the new button", test, test1);

			Step_Start(4, "search and select the bl no/Vessel option", test, test1);

			waitForElement(driver, import_invoice_bl_search);
			click(driver, import_invoice_bl_search);

			globalValueSearchWindow(driver, BL_Condition, Select_search_value, BL_Num, "", "", "", "");
			if(isdisplayed(driver, popup_Message)) {
				waitForDisplay(driver, popup_Message);
				String act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					jsClick(driver, popup_Message_Ok_Button);
					
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
					if(Charges_Popup.equals(act_Popup)) {
						System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
						Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
						waitForElement(driver, popup_Message_Ok_Button);
						jsClick(driver, popup_Message_Ok_Button);
						waitForDisplay(driver, popup_Up_Ok);
						if(isdisplayed(driver, popup_Up_Ok)) {
							waitForElement(driver, popup_Up_Ok);
							jsClick(driver, popup_Up_Ok);
					}
					}
				}
				}
				else if(Charges_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					
					if(isdisplayed(driver, Popup_Message)) {
						waitForElement(driver, popup_Up_Ok);
						click(driver, popup_Up_Ok);
				}
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}
					}
				}
				
			}

			Step_End(4, "search and select the bl no/Vessel option", test, test1);

			waitForElement(driver, import_invoice_bl);
			String BL_Numberact = getAttribute(driver, import_invoice_bl, "value");
			System.out.println(BL_Numberact);
			if (BL_Num.equals(BL_Numberact)) {
				System.out.println("Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : "
						+ BL_Numberact);

				Extent_pass_New(driver,
						"Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : " + BL_Numberact,
						test, test1);

			} else {
				System.out.println("Not Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : "
						+ BL_Numberact);
				Extent_fail(driver, "Not Matched || Expected BL_Number : " + BL_Num + " || Actual BL_Number : "
						+ BL_Numberact, test, test1);

			}
		}

		if (BL_Retrive_from_Import_invoice.equals("By_Vessels")) {

			Step_Start(3, "click the new button", test, test1);
			newButton(driver);
			Step_End(3, "click the new button", test, test1);
			waitForElement(driver, by_vessels_select);
			click(driver, by_vessels_select);
			Step_Start(5,
					"if BL no choose retrieve the bl in blnumber search field if vessel choose follow vessel flow",
					test, test1);
			waitForElement(driver, service_text);
			sendKeys(driver, service_text, service_input);

			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, vesselss_code_input);
			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, voyagee_code_input);
			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_code_input);

			horizontalscroll(driver, By_Vessel_Scroll, 500);  if(!Terminal_Code_Input.equals("")) {
				horizontalscroll(driver, By_Vessel_Scroll, 500);
				sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
				}
				
				if(!Call_ID.equals("")) {
				waitForElement(driver, By_Vessel_Call_Id);
				sendKeys(driver, By_Vessel_Call_Id, Call_ID);
				}
			waitForElement(driver, Select_grid);
			click(driver, Select_grid);

			waitForElement(driver, customer_search);
			click(driver, customer_search);

			globalValueSearchWindow(driver, BL_Condition, Import_Doc_Customer_CodeHeader, customer_code_select, "", "", "", "");

			Step_End(5, "if BL no choose retrieve the bl in blnumber search field if vessel choose follow vessel flow",
					test, test1);

			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);

		

			if(isdisplayed(driver, popup_Message)) {
				waitForDisplay(driver, popup_Message);
				String act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					jsClick(driver, popup_Message_Ok_Button);
					
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
					if(Charges_Popup.equals(act_Popup)) {
						System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
						Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
						waitForElement(driver, popup_Message_Ok_Button);
						jsClick(driver, popup_Message_Ok_Button);
						waitForDisplay(driver, popup_Up_Ok);
						if(isdisplayed(driver, popup_Up_Ok)) {
							waitForElement(driver, popup_Up_Ok);
							jsClick(driver, popup_Up_Ok);
					}
					}
				}
				}
				else if(Charges_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					
					if(isdisplayed(driver, Popup_Message)) {
						waitForElement(driver, popup_Up_Ok);
						click(driver, popup_Up_Ok);
				}
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}
					}
				}
				
			}
			RemoveBLfromInvoice(driver, BL_Num, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);

		}


		waitForElement(driver, Billing_number_filter);
		waitForElement(driver, Billing_number_filter);
		sendKeys(driver, Billing_number_filter, BL_Num);
		waitForElement(driver, Billing_number_filter_select);
		click(driver, Billing_number_filter_select);

		Step_End(12,
				"In the BL details tab, the system has displayed only the saved BLs from the import documentation module in the import invoice module.",
				test, test1);

		Step_Start(13, "click on save button ", test, test1);

		

		waitForElement(driver, import_Invoice_Issued_Button);
		click(driver, import_Invoice_Issued_Button);

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

		String row_select_print = String.format(Import_Invoice_Locators.row_click, Row_Number);
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
		String print_select = String.format(Import_Invoice_Locators.import_invoice_print_dialogue, Print_reason);
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

		Extent_pass_New(driver, "Expected : Uploaded charges listed in Import invoice module. || Actual : Uploaded charges listed in Import invoice module. ", test, test1);
		
		driver.switchTo().defaultContent();
		waitForElement(driver, import_Invoice_print_close);
		click(driver, import_Invoice_print_close);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		if (reverse_Option.equalsIgnoreCase("Yes")) {
			
			Invoice_Reversal(driver, Field_Names_R, BL_Condition, Select_search_value_Reversal, BL_Num, invoiceReversalRemarks, invoiceReversedPopup);
		
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		Extent_completed(testcase_Name, test, test1);

	}

}
