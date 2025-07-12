package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Import_Invoice_Locators;

public class TC_Import_Invoice_SC023 extends Keywords {

	public void Import_Invoice_SC023(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
 
		String testcase_Name = "TC_Import_Invoice_SC023";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Container_Numbers = Excel_data.get("Container_Numbers");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String lump_sum_data = Excel_data.get("lump_sum_data");
		String Detention_storage_option = Excel_data.get("Detention_storage_option");
		String waiver_type = Excel_data.get("waiver_type");
		String select_waiver_by = Excel_data.get("select_waiver_by");
		String pending_popup_expected = Excel_data.get("pending_popup_expected").trim();
		String remarks_data = Excel_data.get("remarks_data");
		String submit_popup_expected = Excel_data.get("submit_popup_expected").trim();
		String waiver_gate_module = Excel_data.get("waiver_gate_module");
		String invoice_sts_data = Excel_data.get("invoice_sts_data");
		String detention_waiver_module = Excel_data.get("detention_waiver_module");
		String refresh_inclusion_popup = Excel_data.get("refresh_inclusion_popup").trim();
		String cancel_popup_expected = Excel_data.get("cancel_popup_expected");
		String detention_Waiver_Remarks = Excel_data.get("detention_Waiver_Remarks");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Filter_Type_DW = Excel_data.get("Filter_Type_DW");
		String Waiver_Reasoncode_Header = Excel_data.get("Waiver_Reasoncode_Header");
		String Waiver_Reasoncode = Excel_data.get("Waiver_Reasoncode");
		String Waiver_Condition = Excel_data.get("Waiver_Condition");
		String Delete_Import_Invoice = Excel_data.get("Delete_Import_Invoice");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Additonal_Date_Value = Excel_data.get("Additonal_Date_Value");
		String Select_Containers = Excel_data.get("Select_Containers");
		
		
		
		 List<String> Container_numbers = new ArrayList<>();
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Extent_call(test, test1, "waiver process starts");
		moduleNavigate(driver, detention_waiver_module);

		Step_Start(1, "Click on New Button", test, test1);

		newButton(driver);

		Step_End(1, "Click on New Button", test, test1);

		Step_Start(2, "Select Waiver For Import Shipment, and Click on Detention/Storage", test, test1);
		waitForElement(driver, book_no_search_icon_dw);
		click(driver, book_no_search_icon_dw);

		Step_End(2, "Select Waiver For Import Shipment, and Click on Detention/Storage", test, test1);

		globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type_Import_Doc, BL_Number_input, "", "", "", "");

		waitForElement(driver, waiver_for_dd);
		click(driver, waiver_for_dd);

		String waiver_dd = String.format(waiver_for_dd_options, waiver_type);
		waitForElement(driver, waiver_dd);
		click(driver, waiver_dd);

		String det_store_click = String.format(detntion_storage_option, Detention_storage_option);

		waitForElement(driver, det_store_click);
		click(driver, det_store_click);

		click(driver, show_bl_button_dw);

		scrollBottom(driver);

		scrollBottom(driver);

		Step_Start(7, "Select the container details", test, test1);
		
	     List<WebElement> containerNumbersList = listOfElements(driver, Detention_container_Grid);

		if (Select_Containers.equals("Select All")) {
			waitForDisplay(driver, DW_ContainersGrid_SelectAll);
			click(driver, DW_ContainersGrid_SelectAll);
			 for (WebElement container : containerNumbersList) {
				 Container_numbers.add(container.getText());
			    }
			 System.out.println(Container_numbers);
			
		} else if (Select_Containers.equals("Selected Containers")) {
			Container_numbers = splitAndExpand(Container_Numbers, ",");

			waitForElement(driver, Filter_Icon_Table1_DW);
			click(driver,Filter_Icon_Table1_DW);
			
			
			
		for (String Container_number : Container_numbers) {
			waitForElement(driver, Detention_container_Filter_input);
			Newclear(driver, Detention_container_Filter_input);
		    sendKeys(driver, Detention_container_Filter_input, Container_number);
			
			String customer_Edit = String.format(Import_Invoice_Locators.container_checkBox, Container_number);
			click(driver, customer_Edit);
		}
		}
		Step_End(7, "Select the container details", test, test1);

		if (select_waiver_by.equalsIgnoreCase("Free_Days")) {
			waitForElement(driver, DW_Addition_Days_Input);
			Newclear(driver, DW_Addition_Days_Input);
			Actionsendkeys(driver, DW_Addition_Days_Input, Additonal_Date_Value);
			
			
			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

		}
		
		if (select_waiver_by.equalsIgnoreCase("By_lumpsum")) {

			Step_Start(8, "Click on Waiver Lumpsum text area.", test, test1);

			waitForElement(driver, waiver_Lumpsum_RadioButton);
			click(driver, waiver_Lumpsum_RadioButton);

			Step_End(8, "Click on Waiver Lumpsum text area.", test, test1);

			Step_Start(9, "Enter the additional LP Amount from Test data", test, test1);

			waitForElement(driver, waiver_lumpsum_textfld);
			clear(driver, waiver_lumpsum_textfld);
			sendKeys(driver, waiver_lumpsum_textfld, lump_sum_data);

			Step_End(9, "Enter the additional LP Amount from Test data", test, test1);

			Step_Start(10, "Click on + button ", test, test1);

			waitForElement(driver, waiver_add_button);
			click(driver, waiver_add_button);
			Step_End(10, "Click on + button ", test, test1);

			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String No_Detention_Popup = getText(driver, popup_Message);
				Extent_fail(driver,
						" Expected result : User should give the valid data || Actual result is : Given Data is not correct"
								+ No_Detention_Popup,
						test, test1);
			}

		}

		if (select_waiver_by.equalsIgnoreCase("By%")) {

			Step_Start(8, "Click on Waiver Lumpsum text area.", test, test1);

			waitForElement(driver, waiver_Percentage_Radio_Button);
			click(driver, waiver_Percentage_Radio_Button);

			Step_End(8, "Click on Waiver Lumpsum text area.", test, test1);

			Step_Start(9, "Enter the additional LP Amount from Test data", test, test1);

			waitForElement(driver, waiver_Percentage_Textfield);
			clear(driver, waiver_Percentage_Textfield);

			sendKeys(driver, waiver_Percentage_Textfield, lump_sum_data);

			Step_End(9, "Enter the additional LP Amount from Test data", test, test1);

			Step_Start(10, "Click on + button ", test, test1); 

			waitForElement(driver, waiver_add_button);
			click(driver, waiver_add_button);

			Step_End(10, "Click on + button ", test, test1);

			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String No_Detention_Popup = getText(driver, popup_Message);
				System.out.println(No_Detention_Popup);
				Extent_fail(driver,
						" Expected result : User should give the valid data || Actual result is : Given Data is not correct"
								+ No_Detention_Popup,
						test, test1);
			}
		}

		waitForElement(driver, detention_waiver_Table);
		List<Map<String, String>> detention_waiver_table_data = extractTableDataCountMissMatch(driver, detention_waiver_Table);
		ArrayList<String> detention_List = new ArrayList<String>();
		for (int i = 0; i < Container_numbers.size(); i++) {
			String detension_Value = getValueByFirstColumnAndHeader(detention_waiver_table_data, "Container No",
					Container_numbers.get(i), "Waiver Amount in USD");
			detention_List.add(detension_Value);
		}

		scrollTop(driver);

		Step_Start(11, "Click on save Button", test, test1);

		if (isdisplayed(driver, Waiver_ReasonSearch)) {

			waitForElement(driver, Waiver_ReasonSearch);
			click(driver, Waiver_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reasoncode_Header, Waiver_Condition, Waiver_Reasoncode);

		}

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		Step_End(11, "Click on save Button", test, test1);

		Step_Start(12, "System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		waitForPopup(driver, Popup_Message, pending_popup_expected);
		String pending_popup_actual = getText(driver, Popup_Message).trim();

		// Remove all whitespace characters (spaces, tabs, newlines, etc.)
		String cleanedExpectedText = pending_popup_expected.replaceAll("\\s+", "");
		String cleanedActualText = pending_popup_actual.replaceAll("\\s+", "");

		if (cleanedActualText.equalsIgnoreCase(cleanedExpectedText)) {

			System.out.println("Expected pending popup : " + pending_popup_expected + "|| actual pending popup : "
					+ pending_popup_actual);
			Extent_pass_New(driver, "Expected pending popup : " + pending_popup_expected + "|| actual pending popup : "
					+ pending_popup_actual, test, test1);

		} else {
			System.out.println("Expected pending popup : " + pending_popup_expected + "|| actual pending popup : "
					+ pending_popup_actual);
			Extent_fail(driver, "Expected pending popup : " + pending_popup_expected + "|| actual pending popup : "
					+ pending_popup_actual, test, test1);

		}
		Step_End(12, "System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		Step_Start(13, "Click on Edit Button and Click the Submit button", test, test1);

		waitForElement(driver, waiver_edit_button);
		click(driver, waiver_edit_button);

		waitForElement(driver, remarks_area_dw);
		sendKeys(driver, remarks_area_dw, remarks_data);

		scrollTop(driver);
		click(driver, submitted_button_dw);

		Step_End(13, "Click on Edit Button and Click the Submit button", test, test1);

		Step_Start(14, "click on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(14, "click on save button", test, test1);

		Step_Start(15, "Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		waitForPopup(driver, Popup_Message, submit_popup_expected);
		String submit_popup_actual = getText(driver, Popup_Message).trim();

		// Remove all whitespace characters (spaces, tabs, newlines, etc.)
		String cleanedExpectedText1 = submit_popup_expected.replaceAll("\\s+", "");
		String cleanedActualText1 = submit_popup_actual.replaceAll("\\s+", "");

		if (cleanedActualText1.equalsIgnoreCase(cleanedExpectedText1)) {

			System.out.println("Expected submit popup : " + submit_popup_expected + "|| actual submit popup "
					+ submit_popup_actual);
			Extent_pass_New(driver, "Expected submit popup : " + submit_popup_expected + "|| actual submit popup "
					+ submit_popup_actual, test, test1);

		} else {
			System.out.println("Expected submit popup : " + submit_popup_expected + "|| actual submit popup "
					+ submit_popup_actual);
			Extent_fail(driver, "Expected submit popup : " + submit_popup_expected + "|| actual submit popup "
					+ submit_popup_actual, test, test1);

		}

		Step_End(15, "Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		waitForElement(driver, waiver_ref_num_txtfld);
		String waiver_ref_number = getAttribute(driver, waiver_ref_num_txtfld, "value");

		System.out.println("The generated waiver reference number is: " + waiver_ref_number);
		Extent_pass_New(driver, "The generated waiver reference number is: " + waiver_ref_number, test, test1);
		
		
		
		
		moduleNavigate(driver, Field_Names);
		newButton(driver);
		
		waitForElement(driver, By_BL_NumberBtn_All);
		click(driver, By_BL_NumberBtn_All);
		
		waitForElement(driver, In_bl_Search_Button);
		click(driver, In_bl_Search_Button);
		
		globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");
		
		waitForElement(driver, import_invoice_draft_button);
		click(driver,import_invoice_draft_button);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		Step_Start(16, "Switch to Line Login", test, test1);

		// switch to liner profile
		ResetProfile(driver);

		Step_End(16, "Switch to Line Login", test, test1);

		Step_Start(17, "Open Waiver Gate module", test, test1);

		moduleNavigate(driver, waiver_gate_module);
		Step_End(17, "Open Waiver Gate module", test, test1);

		waitForElement(driver, waiver_gate_submit_button);
		click(driver, waiver_gate_submit_button);

		Step_Start(18, "Select the Row Waiver in waiver gate", test, test1);

		String waiver_checkbox_click = String.format(waiver_gate_checkbox, waiver_ref_number);

		waitForElement(driver, waiver_checkbox_click);
		click(driver, waiver_checkbox_click);
		Step_End(18, "Select the Row Waiver in waiver gate", test, test1);

		Step_Start(20, "Click on approve Button", test, test1);

		waitForElement(driver, waiver_gate_approve_btn);
		click(driver, waiver_gate_approve_btn);
		Step_End(20, "Click on approve Button", test, test1);

		Step_Start(21, "Open the import invoice module and click the Search button", test, test1);

		SwitchProfile(driver, AgencyUser);
		// navigate to import invoice
		moduleNavigate(driver, Field_Names);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(21, "Open the import invoice module and click the Search button", test, test1);

		Step_Start(22, "Load the BL and Click on Edit Button", test, test1);

		globalValueSearchWindow1(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

		waitForElement(driver, invoice_sts_filter_input);
		sendKeys(driver, invoice_sts_filter_input, invoice_sts_data);
		
	
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			
			
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
			
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(22, "Load the BL and Click on Edit Button", test, test1);

		Step_Start(23,
				"If any message Show 'Kindly refresh the Invoice and save it, as the waiver has been approved for inclusion - KGEWAV26.' click ok and click on refresh button",
				test, test1);

		if (isdisplayed(driver, popup_Message)) {

			waitForPopup(driver, popup_Message, refresh_inclusion_popup);
			String refresh_message = getText(driver, popup_Message);

			if (refresh_message.contains(refresh_inclusion_popup)) {

				System.out.println("Matched : Expected popup was" + refresh_inclusion_popup + "Actual popup was "
						+ refresh_message);
				Extent_pass_New(driver, "Matched : Expected popup was " + refresh_inclusion_popup + "Actual popup was "
						+ refresh_message, test, test1);
			} else {

				System.out.println("Not Matched : Expected popup was " + refresh_inclusion_popup + "Actual popup was "
						+ refresh_message);
				Extent_fail(driver, "Not Matched : Expected popup was " + refresh_inclusion_popup + "Actual popup was "
						+ refresh_message, test, test1);

			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}

		Step_End(23,
				"If any message Show 'Kindly refresh the Invoice and save it, as the waiver has been approved for inclusion - KGEWAV26.' click ok and click on refresh button",
				test, test1);

		Step_Start(24, "If there is no Message click on refresh button", test, test1);

		waitForElement(driver, refresh_button_imp_inv);
		click(driver, refresh_button_imp_inv);

		Step_End(24, "If there is no Message click on refresh button", test, test1);

		Step_End(23,
				"If any message Show 'Kindly refresh the Invoice and save it, as the waiver has been approved for inclusion - KGEWAV26.' click ok and click on refresh button",
				test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		waitForElement(driver, importInvoice_Table_Header);
		
		List<Map<String, String>> invoice_Tabledata = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);
		scrollBottom(driver);

		waitForElement(driver, detention_charges_tab);
		Step_Start(25, "Go to Detention /Storage Charges tab", test, test1);

		waitForElement(driver, detention_charges_tab);
		click(driver, detention_charges_tab);

		Step_End(25, "Go to Detention /Storage Charges tab", test, test1);

		Step_Start(26, "Find the Waiver No Column and Ensure that Waiver Ref No is available", test, test1);

	waitForElement(driver, detention_Table_Headers);
		List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
				detention_Table_Rows);
//		String waiver_Num = getFirstValueByHeader(detention_Teble_Values, "Waiver No");
		String waiver_Num="";
		List<String>  waiveravlues=getValuesByHeader(detention_Teble_Values,"Waiver No");
		for(String val:waiveravlues) {
			if(!val.trim().equals("")) {
				waiver_Num=val;
				break;
			}
		}
		
		if(select_waiver_by.equals("By_lumpsum") || select_waiver_by.equals("By%")  ){


		for (int i = 0; i < Container_numbers.size(); i++) {
			String currency_Code = getValueByFirstColumnAndHeader(detention_Teble_Values, "Container Number",
					Container_numbers.get(i), "InvCurrency");
			if (!currency_Code.equalsIgnoreCase("USD")) {
				String Currency_Value = getValueByFirstColumnAndHeader(invoice_Tabledata, "Inv Currency", currency_Code,
						"Inv ROE");
				String Actual_currency_Value = getValueByFirstColumnAndHeader(detention_Teble_Values,
						"Container Number", Container_numbers.get(i), "Waiver Local Amount");
				String Expected_currency_Value = multiplyCurrencyValue(currency_Code, detention_List.get(i),
						Currency_Value);
				double actual_Currency_Value = getNumberValue_roundOff(Actual_currency_Value);
				System.out.println("Actual_currency_Value :" + actual_Currency_Value);

				double expected_Currency_Value = getNumberValue_roundOff(Expected_currency_Value);
				System.out.println("Expected_currency_Value :" + expected_Currency_Value);

				if (areEqualIgnoringSign1(expected_Currency_Value, actual_Currency_Value)) {

					System.out.println("Expected Currency value was :" + expected_Currency_Value
							+ " || Actual currency value was :" + actual_Currency_Value + "is same");
					Extent_pass_New(driver, "Expected Currency value was :" + expected_Currency_Value
							+ " || Actual currency value was :" + actual_Currency_Value + "is same", test, test1);
				} else {
					System.out.println("Expected Currency value was :" + expected_Currency_Value
							+ " || Actual currency value was :" + actual_Currency_Value + "is not same");
					extent_fail(
							driver, "Expected Currency value was :" + expected_Currency_Value
									+ "  || Actual currency value was :" + actual_Currency_Value + "is not same",
							test, test1);
				}

			}

		}
		}
		Step_End(26, "Find the Waiver No Column and Ensure that Waiver Ref No is available", test, test1);
		Step_End(12, "Verify for LP and % option and waiver AMT and Waiver No matched from Waiver and Import Invoice.",
				test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

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
		
if(	formatLocatorIsDisplayed(driver, waiver_Number, waiver_Num)) {
			System.out.println("Waiver Number displayed in Import Invoice Module "+waiver_Num);
			Extent_pass_New(driver, "Waiver Number displayed in Import Invoice Module "+waiver_Num, test, test1);
			
		} else {
			System.out.println("Waiver Number  not displayed in Import Invoice Module "+waiver_Num);
			Extent_fail(driver, "Waiver Number not displayed in Import Invoice Module "+waiver_Num, test, test1);
		}
		

		scrollTop(driver);
		Import_Invoice_Draft_Delete(driver, Delete_Import_Invoice);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Extent_cal(test, test1, "Cancel Detention Waiver");
		moduleNavigate(driver, detention_waiver_module);

		waitForElement(driver, Detention_waiver_Search_Button);
		click(driver, Detention_waiver_Search_Button);

		globalValueSearchWindow(driver, BL_Condition, Filter_Type_DW, waiver_ref_number, "", "", "", "");

		scrollTop(driver);
		waitForElement(driver, Detention_Waiver_Edit_Button);
		click(driver, Detention_Waiver_Edit_Button);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		waitForElement(driver, Detention_Waiver_Remarks_area);
		sendKeys(driver, Detention_Waiver_Remarks_area, detention_Waiver_Remarks);

		scrollTop(driver);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, cancel_popup_expected);

		String cancel_popup_actual = getText(driver, Popup_Message);
		System.out.println(cancel_popup_actual);

		if (cancel_popup_actual.equalsIgnoreCase(cancel_popup_expected)) {

			System.out.println("Expected pending popup : " + cancel_popup_expected + "|| actual pending popup : "
					+ cancel_popup_actual);
			Extent_pass_New(driver, "Expected pending popup : " + cancel_popup_expected + "|| actual pending popup : "
					+ cancel_popup_actual, test, test1);

		} else {
			System.out.println("Expected pending popup : " + cancel_popup_expected + "|| actual pending popup : "
					+ cancel_popup_actual);
			Extent_fail(driver, "Expected pending popup : " + cancel_popup_expected + "|| actual pending popup : "
					+ cancel_popup_actual, test, test1);

		}

		Extent_completed(testcase_Name, test, test1);
	}
	

}
