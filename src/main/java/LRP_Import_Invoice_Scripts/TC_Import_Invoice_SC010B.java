package LRP_Import_Invoice_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Import_Invoice_Locators;

public class TC_Import_Invoice_SC010B extends Keywords {

	public void Import_Invoice_SC010B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Import_Invoice_SC010B";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Condition = Excel_data.get("BL_Condition");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Attribute_value = Excel_data.get("Attribute_value");
		String Value_checkbox_perform = Excel_data.get("Value_checkbox_perform");
		String Agency_config_module = Excel_data.get("Agency_config_module");
		String BL_Retrive_from_Import_invoice = Excel_data.get("BL_Retrive_from_Import_invoice");
		String service_input = Excel_data.get("service_input");
		String vesselss_code_input = Excel_data.get("vesselss_code_input");
		String voyagee_code_input = Excel_data.get("voyagee_code_input");
		String Bound_code_input = Excel_data.get("Bound_code_input");
		String Customer_Code = Excel_data.get("Customer_Code");
		String customer_code_select = Excel_data.get("customer_code_select");
		String excelFilePath = Excel_data.get("excelFilePath");
		String Sheet_select = Excel_data.get("Sheet_select");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Table_Header_print = Excel_data.get("Table_Header_print_Excel"); 
		String Application_Header = Excel_data.get("Application_Header");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String Verify_By = Excel_data.get("Verify_By");
		String Select_search_global = Excel_data.get("Select_search_global");
		String Draft_saved_pop1 = Excel_data.get("Draft_saved_pop1");
		String Agency_Code = Excel_data.get("Agency_Code");
		String Search_Condition = Excel_data.get("Search_Condition"); 
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String attribute_Header = Excel_data.get("attribute_Header");
		String AC_ChargeCode_Values = Excel_data.get("AC_ChargeCode_Values");
		String ChargesColumn_Header = Excel_data.get("ChargesColumn_Header");
		String UD_ConfigAttribute = Excel_data.get("UD_ConfigAttribute");
		String resetOption = Excel_data.get("resetOption");
		String invoice_sts_data = Excel_data.get("invoice_sts_data");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");





		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		verifyMainMenu(driver);

		Step_End(1, "switch to import agency", test, test1);

		Extent_call(test, test1,
				"Open Accounting configuration module and add this attribute IEU-Invoice - Allow Excel Upload option in the Additional Tab and mark this as Y if it is already available double Click and mark it as Y.");
		Map<String, String> newlyadded = setAccountingConfiguration(driver, Agency_config_module, Agency_Code,attribute_Header,Search_Condition,AgencyUser,Attribute_value,UD_ConfigAttribute,ChargesColumn_Header,AC_ChargeCode_Values,Value_checkbox_perform);


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

			globalValueSearchWindow(driver, BL_Condition, Select_search_value, BL_Number_input, "", "", "", "");

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
			if (BL_Number_input.equals(BL_Numberact)) {
				System.out.println("Matched || Expected BL_Number : " + BL_Number_input + " || Actual BL_Number : "
						+ BL_Numberact);

				Extent_pass_New(driver,
						"Matched || Expected BL_Number : " + BL_Number_input + " || Actual BL_Number : " + BL_Numberact,
						test, test1);

			} else {
				System.out.println("Not Matched || Expected BL_Number : " + BL_Number_input + " || Actual BL_Number : "
						+ BL_Numberact);
				Extent_fail(driver, "Not Matched || Expected BL_Number : " + BL_Number_input + " || Actual BL_Number : "
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
			click(driver, vessels_code_input);
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

			globalValueSearchWindow(driver, BL_Condition, Customer_Code, customer_code_select, "", "", "", "");

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
			
			RemoveBLfromInvoice(driver, BL_Number_input, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);
		}

		Extent_call(test, test1, "In Excel Draft Mode Follow this Steps");

		Step_Start(6, "Load the BL and save it", test, test1);

		scrollTop(driver);
		waitForElement(driver, import_invoice_draft_button);
		click(driver, import_invoice_draft_button);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Load the BL and save it", test, test1);

		Step_Start(7, "getting message import Invoice Saved Click on ok", test, test1);

		waitForPopup(driver, popup_Message, Draft_saved_pop);
		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);
		if (Draft_saved_pop.equals(import_saved_act)) {
			System.out.println(
					"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
					test, test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
					+ import_saved_act);

			Extent_fail(driver,
					"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(7, "getting message import Invoice Saved Click on ok", test, test1);

		if (Verify_By.equalsIgnoreCase("Same_Screen")) {

			Extent_call(test, test1, "In Excel if Defined as Same Screen");

			Step_Start(8, "click on Edit Button Directly.", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			Step_End(8, "click on Edit Button Directly.", test, test1);
			scrollBottom(driver);
			waitForElement(driver, Additional_charges_tab);
			click(driver, Additional_charges_tab);

			if (isClickable(driver, upload_addtional_charges)) {
				waitForElement(driver, upload_addtional_charges);
				click(driver, upload_addtional_charges);

			} else {

				waitForElement(driver, upload_addtional_charges_add);
				click(driver, upload_addtional_charges_add);
				waitForElement(driver, upload_addtional_charges);
				click(driver, upload_addtional_charges);
			}

			waitForElement(driver, upload_addtional_select);
			if (isdisplayed(driver, upload_addtional_select)) {
				System.out.println(
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is opened");
				Extent_pass_New(driver,
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is opened",
						test, test1);
			} else {
				System.out.println(
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is not opened");
				Extent_fail(driver,
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is not opened",
						test, test1);

			}

			waitForPresenceOfElement(driver, ID_ImportExcel);
			uploadfile_new(driver, ID_ImportExcel, excelFilePath);


			waitForElement(driver, Aselectexcelfiledroupdown);
			click(driver, Aselectexcelfiledroupdown);
			String select_sheet = String.format(Import_Invoice_Locators.Sheet_sel, Sheet_select);

			waitForElement(driver, select_sheet);
			safeclick(driver, select_sheet);

			waitForElement(driver, Aloadsheet);
			click(driver, Aloadsheet);

			List<Map<String, String>> fom = getAllExcelData1(excelFilePath, Sheet_select);
			List<String> header = splitAndExpand(Table_Header_print);
			String report = TableDataForReport(driver, fom, "datas", header);
			Extent_pass_New(driver, report, test, test1);

			List<List<String>> Import_invoice_excel_Table = getValuesByHeaders(fom, header);

			if (isdisplayed(driver, Amapyesbutton)) {
				waitForElement(driver, Amapyesbutton);
				click(driver, Amapyesbutton);
			}

			waitForElement(driver, Auploadfile);
			click(driver, Auploadfile);

			scrollTop(driver);
			waitForElement(driver, import_invoice_draft_button);
			click(driver, import_invoice_draft_button);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Draft_saved_pop1);

			String import_saved_act1 = getText(driver, popup_Message);
			System.out.println(import_saved_act1);

			if (Draft_saved_pop1.equals(import_saved_act1)) {
				System.out.println("Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1);
				Extent_pass_New(driver, "Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1, test, test1);

			} else {
				System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1);

				Extent_fail(driver, "Not Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1, test, test1);

			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			List<Map<String, String>> print_table = getTableData(driver, addtional_tab_header,
					addtional_tab_header_row);
			List<String> header1 = splitAndExpand(Application_Header);
			String report_table = TableDataForReport(driver, print_table, "Upload charges was shown", header1);
			Extent_call(test, test1, report_table);
			List<List<String>> Import_invoice_additional_chargesr_Table = getValuesByHeaders(print_table, header1);

			if (compareTableDataNew(Import_invoice_additional_chargesr_Table, Import_invoice_excel_Table)) {
				Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" + report + "</pre>" + "\n"
						+ " || Actual : \n" + "<pre>" + report_table + "</pre>", test, test1);
			} else {
				Extent_fail(driver, "Not Matched || Expected : \n" + "<pre>" + report + "</pre>" + "\n"
						+ " || Actual : \n" + "<pre>" + report_table + "</pre>", test, test1);
			}
			
		}

		if (Verify_By.equalsIgnoreCase("Re_Open_Screen")) {

			Extent_call(test, test1, "In Excel if Defined as Re-open Screen");

			Step_Start(8, "Close the Current Import invoice Window", test, test1);
			scrollTop(driver);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_End(8, "Close the Current Import invoice Window", test, test1);

			Step_Start(9, "Select Import Option,", test, test1);
			moduleNavigate(driver, Field_Names);

			Step_End(9, "Select Import Option,", test, test1);

			Step_Start(10, "load the same BL NO with status as Draft", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);			
			
			globalValueSearchWindow1(driver, BL_Condition, Select_search_global, BL_Number_input, "", "", "", "");

			waitForElement(driver, invoice_sts_filter_input);
			sendKeys(driver, invoice_sts_filter_input, invoice_sts_data);
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);

			Step_End(10, "load the same BL NO with status as Draft", test, test1);

			Step_Start(11, "Click on EDIT button", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(11, "Click on EDIT button", test, test1);

			Step_Start(12, "Go to additional charges tab", test, test1);
			scrollBottom(driver);
			waitForElement(driver, Additional_charges_tab);
			click(driver, Additional_charges_tab);

			Step_End(12, "Go to additional charges tab", test, test1);

			Step_Start(13, "Click on upload Button and upload it save the Imformation", test, test1);

			if (isClickable(driver, upload_addtional_charges)) {
				waitForElement(driver, upload_addtional_charges);
				click(driver, upload_addtional_charges);

			} else {

				waitForElement(driver, upload_addtional_charges_add);
				click(driver, upload_addtional_charges_add);
				waitForElement(driver, upload_addtional_charges);
				click(driver, upload_addtional_charges);
			}

			waitForElement(driver, upload_addtional_select);
			if (isdisplayed(driver, upload_addtional_select)) {
				System.out.println(
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is opened");
				Extent_pass_New(driver,
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is opened",
						test, test1);
			} else {
				System.out.println(
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is not opened");
				Extent_fail(driver,
						"Expected result is : Import excel page should be opened || Actual result is : Import excel page is not opened",
						test, test1);

			}

			uploadfile_new(driver, ID_ImportExcel, excelFilePath);

			waitForElement(driver, Aselectexcelfiledroupdown);
			click(driver, Aselectexcelfiledroupdown);
			String select_sheet = String.format(Import_Invoice_Locators.Sheet_sel, Sheet_select);

			waitForElement(driver, select_sheet);
			safeclick(driver, select_sheet);

			waitForElement(driver, Aloadsheet);
			click(driver, Aloadsheet);

			List<Map<String, String>> fom = getAllExcelData(excelFilePath, Sheet_select);
			List<String> header = splitAndExpand(Table_Header_print);
			String report = TableDataForReport(driver, fom, "datas", header);
			Extent_pass_New(driver, report, test, test1);

			List<List<String>> Import_invoice_excel_Table = getValuesByHeaders(fom, header);

			if (isdisplayed(driver, Amapyesbutton)) {
				waitForElement(driver, Amapyesbutton);
				click(driver, Amapyesbutton);
			}

			waitForElement(driver, Auploadfile);
			click(driver, Auploadfile);

			Step_End(13, "Click on upload Button and upload it save the Imformation", test, test1);

			scrollTop(driver);
			waitForElement(driver, import_invoice_draft_button);
			click(driver, import_invoice_draft_button);

			Step_Start(14, "click the save button in tool bar", test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(14, "click the save button in tool bar", test, test1);

			Step_Start(15, "system has validate import invoice Updated.click ok", test, test1);

			waitForPopup(driver, popup_Message, Draft_saved_pop1);

			String import_saved_act1 = getText(driver, popup_Message);
			System.out.println(import_saved_act1);
			if (Draft_saved_pop1.equals(import_saved_act1)) {
				System.out.println("Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1);
				Extent_pass_New(driver, "Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1, test, test1);

			} else {
				System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1);

				Extent_fail(driver, "Not Matched || Expected Popup : " + Draft_saved_pop1 + " || Actual Popup : "
						+ import_saved_act1, test, test1);

			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(15, "system has validate import invoice Updated.click ok", test, test1);

			List<Map<String, String>> print_table = getTableData(driver, addtional_tab_header,
					addtional_tab_header_row);
			List<String> header1 = splitAndExpand(Application_Header);
			String report_table = TableDataForReport(driver, print_table, "Upload charges was shown", header1);
			Extent_call(test, test1, report_table);
			List<List<String>> Import_invoice_additional_chargesr_Table = getValuesByHeaders(print_table, header1);

			if (compareTableDataNew(Import_invoice_additional_chargesr_Table, Import_invoice_excel_Table)) {
				Extent_pass_New(driver, "Matched || Expected : \n" + "<pre>" + report + "</pre>" + "\n"
						+ " || Actual : \n" + "<pre>" + report_table + "</pre>", test, test1);
			} else {
				Extent_fail(driver, "Not Matched || Expected : \n" + "<pre>" + report + "</pre>" + "\n"
						+ " || Actual : \n" + "<pre>" + report_table + "</pre>", test, test1);
			}
			

		}

		Extent_pass_New(driver, "Expected : Uploaded charges listed in Import invoice module. || Actual : Uploaded charges listed in Import invoice module.", test, test1);
		
		Import_Invoice_Draft_Delete(driver, Delete_Perform);

		
		scrollTop(driver);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		reSetAccountingConfiguration(driver, resetOption, newlyadded, Agency_config_module, Agency_Code, Search_Condition, AgencyUser, Attribute_value, UD_ConfigAttribute);

		
		Extent_completed(testcase_Name, test, test1);


		
	}

}
