package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC030 extends Keywords {

	public void Import_Invoice_SC030(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Import_Invoice_SC030";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String Draft_colourName = Excel_data.get("Draft_colour");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Customer_Code_edit_pop = Excel_data.get("Customer_Code_edit_pop");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Issued_saved_pop = Excel_data.get("Issued_saved_pop");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Search_Import_Document = Excel_data.get("Search_Import_Document");
		String Import_Doc_Customer_Type_Header = Excel_data.get("Import_Doc_Customer_Type_Header");
		String Import_Doc_Customer_TypeValue = Excel_data.get("Import_Doc_Customer_TypeValue");
		String Import_Doc_Customer_CodeHeader = Excel_data.get("Import_Doc_Customer_CodeHeader");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String Invoice_Save_Type = Excel_data.get("Invoice_Save_Type");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String Customer_Edit_Filter_type = Excel_data.get("Customer_Edit_Filter_type");
		String Customer_Edit_Filter_Condition = Excel_data.get("Customer_Edit_Filter_Condition");
		String Customer_Edit_Code = Excel_data.get("Customer_Edit_Code");
		String Import_Invoice_Compare_Header = Excel_data.get("Import_Invoice_Compare_Header");
		String Import_Invoice_Customer_Name_Header = Excel_data.get("Import_Invoice_Customer_Name_Header");
		String Draft_Module_Type = Excel_data.get("Draft_Module_Type");
		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Delete_Popup_Exp = Excel_data.get("Delete_Popup_Exp");
		String Delete_Success_Msg = Excel_data.get("Delete_Success_Msg");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");
		String Change_Select_row = Excel_data.get("Change_Select_row");

		String Draft_colour = getHexCode(Draft_colourName);
		List<String> rowIndexes = splitAndExpand(Change_Select_row);
		List<String> Customer_Edit_Codes=splitAndExpand(Customer_Edit_Code);
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to import agency", test, test1);
		Step_Start(2, "open the import invoice module and click the new button", test, test1);
		moduleNavigate(driver, Field_Names);

		newButton(driver);

		Step_End(2, "open the import invoice module and click the new button", test, test1);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			Step_Start(3, "Click on BL NO Search and Paste the BL in the search and then load the BL", test, test1);

			waitForDisplay(driver, By_BL_Number_Btn);
			click(driver, By_BL_Number_Btn);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

			if (isdisplayed(driver, popup_Message)) {
				waitForDisplay(driver, popup_Message);
				String act_Popup = getText(driver, popup_Message);
				if (Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println(
							"Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver,
							"Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test,
							test1);

					waitForElement(driver, popup_Message_Ok_Button);
					jsClick(driver, popup_Message_Ok_Button);

					waitForDisplay(driver, popup_Message);
					if (isdisplayed(driver, popup_Message)) {
						act_Popup = getText(driver, popup_Message);
						if (Charges_Popup.equals(act_Popup)) {
							System.out.println(
									"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
							Extent_pass_New(driver,
									"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup,
									test, test1);
							waitForElement(driver, popup_Message_Ok_Button);
							jsClick(driver, popup_Message_Ok_Button);
							waitForDisplay(driver, popup_Up_Ok);
							if (isdisplayed(driver, popup_Up_Ok)) {
								waitForElement(driver, popup_Up_Ok);
								jsClick(driver, popup_Up_Ok);
							}
						}
					}
				} else if (Charges_Popup.equals(act_Popup)) {
					System.out
							.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver,
							"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test,
							test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);

					if (isdisplayed(driver, Popup_Message)) {
						waitForElement(driver, popup_Up_Ok);
						click(driver, popup_Up_Ok);
					}
					waitForDisplay(driver, popup_Message);
					if (isdisplayed(driver, popup_Message)) {
						act_Popup = getText(driver, popup_Message);
						if (Part_Lot_BL_Popup.equals(act_Popup)) {
							System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :"
									+ act_Popup);
							Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup
									+ "||  Actual Popup :" + act_Popup, test, test1);

							waitForElement(driver, popup_Message_Ok_Button);
							click(driver, popup_Message_Ok_Button);
						}
					}
				}

			}

			Step_End(3, "Click on BL NO Search and Paste the BL in the search and then load the BL", test, test1);
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {

			Step_Start(4, "click the by vessel option", test, test1);

			waitForDisplay(driver, By_Vessel_Btn);
			click(driver, By_Vessel_Btn);

			Step_End(4, "click the by vessel option", test, test1);

			Step_Start(5, "enter the service in service field", test, test1);

			waitForElement(driver, service_Txtfield_IN);
			sendKeys(driver, service_Txtfield_IN, Service_Code);

			Step_End(5, "enter the service in service field", test, test1);

			Step_Start(6, "automatically service details has to be populated based on the given service ", test, test1);

			waitForElement(driver, vessels_code_input);

			Step_End(6, "automatically service details has to be populated based on the given service ", test, test1);

			Step_Start(7, "select the serive ,vessel and voyage details for that bl", test, test1);
			sendKeys(driver, vessels_code_input, Vessel_Code);
			sendKeys(driver, voyage_code_input, Voyage_Number);
			sendKeys(driver, bounnd_code_input, Bound_Input);
			sendKeys(driver, PortCode_Input, Port_Code);

			if (!Terminal_Code_Input.equals("")) {
				horizontalscroll(driver, By_Vessel_Scroll, 500);
				sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
			}

			if (!Call_ID.equals("")) {
				waitForElement(driver, By_Vessel_Call_Id);
				sendKeys(driver, By_Vessel_Call_Id, Call_ID);
			}
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);

			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);
			Step_Start(7, "select the serive ,vessel and voyage details for that bl", test, test1);

			Step_Start(8, "before click the customer field go the import documentation module", test, test1);
			moduleNavigate(driver, Search_Import_Document);
			waitForElement(driver, NewButton_ToolBar);
			scrollTop(driver);
			Step_End(8, "before click the customer field go the import documentation module", test, test1);

			Step_Start(9, "retrieve the same bl and go to the customer tab --copy the consignee customer code or name ",
					test, test1);
			if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_BL")) {

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);

				globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type_Import_Doc, BL_Number_input, "", "", "",
						"");

			} else if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_Service")) {

				newButton(driver);
				waitForElement(driver, ID_servicename);
				sendKeys(driver, ID_servicename, Service_Code);

				waitForElement(driver, ID_grid_vesselcode);
				sendKeys(driver, ID_grid_vesselcode, Vessel_Code);
				sendKeys(driver, ID_grid_voyagecode, Voyage_Number);
				sendKeys(driver, ID_grid_bound, Bound_Input);
				sendKeys(driver, ID_grid_portcode, Port_Code);

				horizontalscroll(driver, grid_scroll, 300);
				click(driver, ID_grid_terminal);
				sendKeys(driver, ID_grid_terminal, Terminal_Code);
				waitForElement(driver, service_grid_first_row);
				click(driver, service_grid_first_row);

				waitForElement(driver, service_select_btn);
				click(driver, service_select_btn);

				waitForElement(driver, ID_Show_Button);
				click(driver, ID_Show_Button);
			}

			waitForElement(driver, Container_Tab);
			scrollBottom(driver);
			waitForElement(driver, Customer_Tab);
			click(driver, Customer_Tab);

			waitForElement(driver, Customer_Table_Header);

			List<Map<String, String>> ImportDoc_Customer_Tabledata = getTableData(driver, Customer_Table_Header,
					Customer_Table_Row);
			String CustomerCode = getValueByFirstColumnAndHeader(ImportDoc_Customer_Tabledata,
					Import_Doc_Customer_Type_Header, Import_Doc_Customer_TypeValue, Import_Doc_Customer_CodeHeader);
			scrollTop(driver);

			waitForElement(driver, II_first_tab_inside_click);
			click(driver, II_first_tab_inside_click);
			Step_End(9, "retrieve the same bl and go to the customer tab --copy the consignee customer code or name ",
					test, test1);

			Step_Start(10, "click the customer field and put the CN code or name ", test, test1);

			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow1(driver, Customer_Filter_Condition, Customer_Filter_Type, CustomerCode, "", "", "",
					"");

			waitForElement(driver, SystemCode_FilterInput);
			sendKeys(driver, SystemCode_FilterInput, Import_Doc_Customer_TypeValue);
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			Step_End(10, "click the customer field and put the CN code or name ", test, test1);

			Step_Start(11, "load the same Customer and click on SHow BL button, ", test, test1);
			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);
			Step_End(11, "load the same Customer and click on SHow BL button, ", test, test1);

			if (isdisplayed(driver, popup_Message)) {
				waitForDisplay(driver, popup_Message);
				String act_Popup = getText(driver, popup_Message);
				if (Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println(
							"Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver,
							"Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test,
							test1);

					waitForElement(driver, popup_Message_Ok_Button);
					jsClick(driver, popup_Message_Ok_Button);

					waitForDisplay(driver, popup_Message);
					if (isdisplayed(driver, popup_Message)) {
						act_Popup = getText(driver, popup_Message);
						if (Charges_Popup.equals(act_Popup)) {
							System.out.println(
									"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
							Extent_pass_New(driver,
									"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup,
									test, test1);
							waitForElement(driver, popup_Message_Ok_Button);
							jsClick(driver, popup_Message_Ok_Button);
							waitForDisplay(driver, popup_Up_Ok);
							if (isdisplayed(driver, popup_Up_Ok)) {
								waitForElement(driver, popup_Up_Ok);
								jsClick(driver, popup_Up_Ok);
							}
						}
					}
				} else if (Charges_Popup.equals(act_Popup)) {
					System.out
							.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver,
							"Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test,
							test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);

					if (isdisplayed(driver, Popup_Message)) {
						waitForElement(driver, popup_Up_Ok);
						click(driver, popup_Up_Ok);
					}
					waitForDisplay(driver, popup_Message);
					if (isdisplayed(driver, popup_Message)) {
						act_Popup = getText(driver, popup_Message);
						if (Part_Lot_BL_Popup.equals(act_Popup)) {
							System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :"
									+ act_Popup);
							Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup
									+ "||  Actual Popup :" + act_Popup, test, test1);

							waitForElement(driver, popup_Message_Ok_Button);
							click(driver, popup_Message_Ok_Button);
						}
					}
				}

			}

			RemoveBLfromInvoice(driver, BL_Number_input, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row,
					BL_Details_BL_Select);

		}

		waitForElement(driver, customer_Search_Icon);

		if (Invoice_Save_Type.equalsIgnoreCase("New")) {

			Extent_call(test, test1, "** NEW Mode Start   **");

			Step_Start(12, "Select the Customer code Want to change the Cusotmer ", test, test1);
			Step_Start(13, "right Click it and choose Edit Customeroption", test, test1);

			Step_Start(14, "Window will be Open in that put your customer code from Test data and Select it", test,
					test1);

			Step_Start(15, "Click on Apply address button", test, test1);

			Step_Start(16, "system shows msg as 'Do you want to edit the Customer?'Yes/NO click Yes button", test,
					test1);
			Step_Start(17, "Verify that give Customer codeis listed in the columns", test, test1);

			waitForElement(driver, importInvoice_Table_Header);

			List<Map<String, String>> preEditTableData = getTableData(driver, importInvoice_Table_Header,
					importInvoice_Table_Row);

			List<String> customerCodeBeforeEdit = getValuesByHeader(preEditTableData, Import_Invoice_Compare_Header);
			List<String> customerNameBeforeEdit = getValuesByHeader(preEditTableData,
					Import_Invoice_Customer_Name_Header);

			System.out.println("Customer Code BEFORE Edit: " + customerCodeBeforeEdit);
			System.out.println("Customer Name BEFORE Edit: " + customerNameBeforeEdit);

			int count=0;
			for (String rowStr : rowIndexes) {

				int rowNum=Integer.parseInt(rowStr);
				String rowValue=String.valueOf(rowNum-1);
				
				formatLocatorClick(driver, ImportInvoice_change_selectrow,rowValue );

				formatRightClick(driver, ImportInvoice_change_selectrow, rowValue);

				waitForDisplay(driver, edit_customer);
				jsClick(driver, edit_customer);

				globalValueSearchWindow(driver, Customer_Edit_Filter_Condition, Customer_Edit_Filter_type,
						Customer_Edit_Codes.get(count), "", "", "", "");
				count++;
				waitForPopup(driver, popup_Message, Customer_Code_edit_pop);
				String Customer_Code_edit_pop_act = getText(driver, popup_Message);

				if (Customer_Code_edit_pop.equals(Customer_Code_edit_pop_act)) {
					Extent_pass_New(driver, "Matched || Expected Popup : " + Customer_Code_edit_pop
							+ " || Actual Popup : " + Customer_Code_edit_pop_act, test, test1);
				} else {
					Extent_fail(driver, "Not Matched || Expected Popup : " + Customer_Code_edit_pop
							+ " || Actual Popup : " + Customer_Code_edit_pop_act, test, test1);
				}

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			}

			waitForElement(driver, importInvoice_Table_Header);
			List<Map<String, String>> postEditTableData = getTableData(driver, importInvoice_Table_Header,
					importInvoice_Table_Row);

			List<String> customerCodeAfterEdit = getValuesByHeader(postEditTableData, Import_Invoice_Compare_Header);
			List<String> customerNameAfterEdit = getValuesByHeader(postEditTableData,
					Import_Invoice_Customer_Name_Header);

			System.out.println("Customer Code AFTER Edit: " + customerCodeAfterEdit);
			System.out.println("Customer Name AFTER Edit: " + customerNameAfterEdit);

			List<String> editedRowIndexes = splitAndExpand(Change_Select_row);

			for (String rowStr : editedRowIndexes) {
				int rowIndex = Integer.parseInt(rowStr);

				if (rowIndex < customerCodeAfterEdit.size()) {
					String beforeCode = customerCodeBeforeEdit.get(rowIndex-1);
					String afterCode = customerCodeAfterEdit.get(rowIndex-1);
					String beforeName = customerNameBeforeEdit.get(rowIndex-1);
					String afterName = customerNameAfterEdit.get(rowIndex-1);

					System.out.println("Row " + rowIndex + " - Code Before: " + beforeCode + " | After: " + afterCode);
					System.out.println("Row " + rowIndex + " - Name Before: " + beforeName + " | After: " + afterName);

					if (!beforeCode.equals(afterCode)) {
						Extent_pass_New(driver,
								"Customer Code Changed || Before: " + beforeCode + " || After: " + afterCode, test,
								test1);
					} else {
						Extent_fail(driver,
								"Customer Code NOT Changed || Before: " + beforeCode + " || After: " + afterCode, test,
								test1);
					}

					if (!beforeName.equals(afterName)) {
						Extent_pass_New(driver,
								"Customer Name Changed || Before: " + beforeName + " || After: " + afterName, test,
								test1);
					} else {
						Extent_fail(driver,
								"Customer Name NOT Changed || Before: " + beforeName + " || After: " + afterName, test,
								test1);
					}
				} else {
					System.out.println("Invalid row index: " + rowIndex);
					Extent_fail(driver, "Invalid row index: " + rowIndex, test, test1);
				}
			}

			Step_End(12, "Select the Customer code Want to change the Cusotmer ", test, test1);
			Step_End(13, "right Click it and choose Edit Customeroption", test, test1);

			Step_End(14, "Window will be Open in that put your customer code from Test data and Select it", test,
					test1);

			Step_End(15, "Click on Apply address button", test, test1);

			Step_End(16, "system shows msg as 'Do you want to edit the Customer?'Yes/NO click Yes button", test, test1);

			Step_End(17, "Verify that give Customer codeis listed in the columns", test, test1);

			Step_Start(18, "Click on save Button,", test, test1);
			scrollTop(driver);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(18, "Click on save Button,", test, test1);

			Step_Start(19, "Recevied Msg 'Import Invoice saved'.and click ok.", test, test1);

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
			Step_End(19, "Recevied Msg 'Import Invoice saved'.and click ok.", test, test1);

			Extent_call(test, test1, "** NEW Mode  End   **");

		} else if (Invoice_Save_Type.equalsIgnoreCase("Draft")) {

			Extent_call(test, test1, "** DRAFT Mode Start   **");

			Step_Start(20, "select the draft and click the save button in tool bar ", test, test1);
			scrollTop(driver);
			waitForElement(driver, importInvoice_Draft_Button);
			click(driver, importInvoice_Draft_Button);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(20, "select the draft and click the save button in tool bar ", test, test1);

			Step_Start(21, "system has validate import invoice saved.", test, test1);

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

			Step_End(21, "system has validate import invoice saved.", test, test1);

			Step_Start(22, "click ok", test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			waitForElement(driver, import_invoice_first_row);
			String draftcolouract = getTextBackgroundColor(driver, import_invoice_first_row);
			System.out.println(draftcolouract);

			if (Draft_colour.equals(draftcolouract)) {
				Extent_pass_New(driver, "Matched || Expected row colour was : " + Draft_colour
						+ " || Actual row colour was : " + draftcolouract, test, test1);
				System.out.println("Matched || Expected row colour was : " + Draft_colour
						+ " || Actual row colour was : " + draftcolouract);
			} else {
				Extent_fail(driver, "Not Matched || Expected row colour was : " + Draft_colour
						+ " || Actual row colour was : " + draftcolouract, test, test1);
				System.out.println("Not Matched || Expected row colour was : " + Draft_colour
						+ " || Actual row colour was : " + draftcolouract);
			}

			Step_End(22, "click ok", test, test1);

			if (Draft_Module_Type.equals("Reload Module")) {
				Extent_call(test, test1, "** If it is Reload Module follow steps Start**");
				Step_Start(23, "A. Close the Import Invoice", test, test1);
				waitForElement(driver, close_first_Tab);
				click1(driver, close_first_Tab);
				Step_End(23, "A. Close the Import Invoice", test, test1);

				Step_Start(23, "B. Open Import Invoice", test, test1);
				moduleNavigate(driver, Field_Names);
				Step_End(23, "B. Open Import Invoice", test, test1);

				Step_Start(23, "C. Select the Import Invoice in Drop Drown", test, test1);

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow1(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

				Step_End(23, "C. Select the Import Invoice in Drop Drown", test, test1);

				Step_Start(23, "D. Click on Search button and load the same BL", test, test1);

				waitForElement(driver, invoice_Status);
				sendKeys(driver, invoice_Status, "DRAFT");

				waitForElement(driver, retrivedGlobalValue);
				click(driver, retrivedGlobalValue);

				waitForElement(driver, SelectButton);
				click(driver, SelectButton);
				Step_End(23, "D. Click on Search button and load the same BL", test, test1);

				Extent_call(test, test1, "** If it is Reload Module follow steps End **");
			}

			Step_Start(23, "Click on Edit Button", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click1(driver, Edit_Button_toolBar);

			Step_End(23, " Click on Edit Button", test, test1);

			Step_Start(24, "Select the Customer code Want to change the Cusotmer ", test, test1);
			Step_Start(25, "right Click it and choose Edit Customeroption", test, test1);

			Step_Start(26, "Window will be Open in that put your customer code from Test data and Select it", test,
					test1);

			Step_Start(27, "Click on Apply address button", test, test1);

			Step_Start(28, "system shows msg as 'Do you want to edit the Customer?'Yes/NO click Yes button", test,
					test1);
			Step_Start(29, "Verify that give Customer codeis listed in the columns", test, test1);

			waitForElement(driver, importInvoice_Table_Header);

			List<Map<String, String>> preEditTableData = getTableData(driver, importInvoice_Table_Header,
					importInvoice_Table_Row);

			List<String> customerCodeBeforeEdit = getValuesByHeader(preEditTableData, Import_Invoice_Compare_Header);
			List<String> customerNameBeforeEdit = getValuesByHeader(preEditTableData,
					Import_Invoice_Customer_Name_Header);

			System.out.println("Customer Code BEFORE Edit: " + customerCodeBeforeEdit);
			System.out.println("Customer Name BEFORE Edit: " + customerNameBeforeEdit);

			
			int count=0;
			for (String rowStr : rowIndexes) {

				int rowNum=Integer.parseInt(rowStr);
				String rowValue=String.valueOf(rowNum-1);
				formatLocatorClick(driver, ImportInvoice_change_selectrow, rowValue);

				formatRightClick(driver, ImportInvoice_change_selectrow, rowValue);

				waitForDisplay(driver, edit_customer);
				jsClick(driver, edit_customer);

				globalValueSearchWindow(driver, Customer_Edit_Filter_Condition, Customer_Edit_Filter_type,
						Customer_Edit_Codes.get(count), "", "", "", "");
				count++;
				waitForPopup(driver, popup_Message, Customer_Code_edit_pop);
				String Customer_Code_edit_pop_act1 = getText(driver, popup_Message);

				if (Customer_Code_edit_pop.equals(Customer_Code_edit_pop_act1)) {
					Extent_pass_New(driver, "Matched || Expected Popup : " + Customer_Code_edit_pop
							+ " || Actual Popup : " + Customer_Code_edit_pop_act1, test, test1);
				} else {
					Extent_fail(driver, "Not Matched || Expected Popup : " + Customer_Code_edit_pop
							+ " || Actual Popup : " + Customer_Code_edit_pop_act1, test, test1);
				}

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			}

			waitForElement(driver, importInvoice_Table_Header);
			List<Map<String, String>> postEditTableData = getTableData(driver, importInvoice_Table_Header,
					importInvoice_Table_Row);

			List<String> customerCodeAfterEdit = getValuesByHeader(postEditTableData, Import_Invoice_Compare_Header);
			List<String> customerNameAfterEdit = getValuesByHeader(postEditTableData,
					Import_Invoice_Customer_Name_Header);

			System.out.println("Customer Code AFTER Edit: " + customerCodeAfterEdit);
			System.out.println("Customer Name AFTER Edit: " + customerNameAfterEdit);

			List<String> editedRowIndexes = splitAndExpand(Change_Select_row);

			for (String rowStr : editedRowIndexes) {
				int rowIndex = Integer.parseInt(rowStr);

				if (rowIndex < customerCodeAfterEdit.size()) {
					String beforeCode = customerCodeBeforeEdit.get(rowIndex-1);
					String afterCode = customerCodeAfterEdit.get(rowIndex-1);
					String beforeName = customerNameBeforeEdit.get(rowIndex-1);
					String afterName = customerNameAfterEdit.get(rowIndex-1);

					System.out.println("Row " + rowIndex + " - Code Before: " + beforeCode + " | After: " + afterCode);
					System.out.println("Row " + rowIndex + " - Name Before: " + beforeName + " | After: " + afterName);

					if (!beforeCode.equals(afterCode)) {
						Extent_pass_New(driver,
								"Customer Code Changed || Before: " + beforeCode + " || After: " + afterCode, test,
								test1);
					} else {
						Extent_fail(driver,
								"Customer Code NOT Changed || Before: " + beforeCode + " || After: " + afterCode, test,
								test1);
					}

					if (!beforeName.equals(afterName)) {
						Extent_pass_New(driver,
								"Customer Name Changed || Before: " + beforeName + " || After: " + afterName, test,
								test1);
					} else {
						Extent_fail(driver,
								"Customer Name NOT Changed || Before: " + beforeName + " || After: " + afterName, test,
								test1);
					}
				} else {
					System.out.println("Invalid row index: " + rowIndex);
					Extent_fail(driver, "Invalid row index: " + rowIndex, test, test1);
				}
			}

			Step_End(24, "Select the Customer code Want to change the Cusotmer ", test, test1);
			Step_End(25, "right Click it and choose Edit Customeroption", test, test1);

			Step_End(26, "Window will be Open in that put your customer code from Test data and Select it", test,
					test1);

			Step_End(27, "Click on Apply address button", test, test1);

			Step_End(28, "system shows msg as 'Do you want to edit the Customer?'Yes/NO click Yes button", test, test1);

			Step_End(29, "Verify that give Customer codeis listed in the columns", test, test1);

			Step_Start(30, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(30, "Click on save Button", test, test1);

			Step_Start(31, "Recevied Msg \"Import Invoice Updated\".and click ok", test, test1);

			waitForPopup(driver, popup_Message, Issued_saved_pop);

			String import_Updated_act = getText(driver, popup_Message);
			System.out.println(import_Updated_act);

			if (Issued_saved_pop.equals(import_Updated_act)) {
				System.out.println(
						"Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : " + import_Updated_act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : " + import_Updated_act,
						test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
						+ import_Updated_act);
				Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
						+ import_Updated_act, test, test1);
			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(31, "Recevied Msg 'Import Invoice Updated'.and click ok", test, test1);
			Extent_call(test, test1, "** DRAFT Mode End   **");

		}

		Extent_call(test, test1,
				"** Verify that added Customer code and name listed in Grid for the customers  - Start   **");

		waitForElement(driver, import_invoice_first_row);
		String draftcolouract1 = getTextBackgroundColor(driver, import_invoice_first_row);
		System.out.println(draftcolouract1);

		if (Draft_colour.equals(draftcolouract1)) {
			Extent_pass_New(driver, "Matched || Expected row colour was : " + Draft_colour
					+ " || Actual row colour was : " + draftcolouract1, test, test1);
			System.out.println("Matched || Expected row colour was : " + Draft_colour + " || Actual row colour was : "
					+ draftcolouract1);
		} else {
			Extent_fail(driver, "Not Matched || Expected row colour was : " + Draft_colour
					+ " || Actual row colour was : " + draftcolouract1, test, test1);
			System.out.println("Not Matched || Expected row colour was : " + Draft_colour
					+ " || Actual row colour was : " + draftcolouract1);
		}

		Extent_call(test, test1,
				"** Verify that added Customer code and name listed in Grid for the customers  - End   **");

		Extent_call(test, test1, "** If Import Invoice in draft Status, Kindly Delete it.  - Start   **");

		if (Delete_Invoice.equalsIgnoreCase("Yes")) {
			waitForElement(driver, Delete_button_toolBar);
			click1(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, Delete_Popup_Exp);
			String Act_Delete_popText = getText(driver, popup_Message);
			if (Delete_Popup_Exp.equals(Act_Delete_popText)) {
				Extent_pass_New(driver, "Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText, test, test1);
				System.out.println("Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText);
			} else {
				System.out.println("Not Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText);
				Extent_fail(driver, "Not Matched || Expected Delete Popup : " + Delete_Popup_Exp
						+ " || Actual Delete Popup : " + Act_Delete_popText, test, test1);
			}

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForPopup(driver, popup_Message, Delete_Success_Msg);
			String Act_Delete_Text = getText(driver, popup_Message);
			if (Delete_Success_Msg.equals(Act_Delete_Text)) {
				Extent_pass_New(driver, "Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text, test, test1);
				System.out.println("Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text);
			} else {
				System.out.println("Not Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text);
				Extent_fail(driver, "Not Matched || Expected Delete Popup : " + Delete_Success_Msg
						+ " || Actual Delete Popup : " + Act_Delete_Text, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}

		Extent_call(test, test1, "**If Import Invoice in draft Status, Kindly Delete it.  - End   **");

		Extent_completed(testcase_Name, test, test1);
	}
}
