package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Import_Invoice_Locators;

public class TC_Import_Invoice_SC024 extends Keywords {

	public void Import_Invoice_SC024(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Import_Invoice_SC024";
		// Get data from test data

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String detention_waiver_module = Excel_data.get("detention_waiver_module");
		String waiver_type = Excel_data.get("waiver_type");
		String Detention_storage_option = Excel_data.get("Detention_storage_option");
		String BL_Filter_Type_Detention_waiver = Excel_data.get("BL_Filter_Type_Detention_waiver");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Container_Numbers = Excel_data.get("Container_Numbers");
		String select_waiver_by = Excel_data.get("select_waiver_by");
		String lump_sum_data = Excel_data.get("lump_sum_data");
		String pending_popup_expected = Excel_data.get("pending_popup_expected").trim();
		String remarks_data = Excel_data.get("remarks_data");
		String submit_popup_expected = Excel_data.get("submit_popup_expected").trim();
		String waiver_gate_module = Excel_data.get("waiver_gate_module");
		String import_invoice_Module = Excel_data.get("import_invoice_Module");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Search_Import_Document = Excel_data.get("Search_Import_Document");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String Import_Doc_Customer_TypeValue = Excel_data.get("Import_Doc_Customer_TypeValue");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Filter_Type_DW = Excel_data.get("Filter_Type_DW");
		String detention_Waiver_Remarks = Excel_data.get("detention_Waiver_Remarks");
		String cancel_popup_expected = Excel_data.get("cancel_popup_expected");
		String Waiver_Reasoncode_Header = Excel_data.get("Waiver_Reasoncode_Header");
		String Waiver_Reasoncode = Excel_data.get("Waiver_Reasoncode");
		String Waiver_Condition = Excel_data.get("Waiver_Condition");
		String Delete_Import_Invoice = Excel_data.get("Delete_Import_Invoice");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Select_Containers = Excel_data.get("Select_Containers");
		String Additonal_Date_Value = Excel_data.get("Additonal_Date_Value");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");
		

		 List<String> Container_numbers = new ArrayList<>();


		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, username, password);

		// Switch Agency
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "Open Detention Waiver", test, test1);
		moduleNavigate(driver, detention_waiver_module);

		Step_End(1, "Open Detention Waiver", test, test1);

		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);

		Step_Start(3, "Select Waiver For Import Shipment, and Click on Detention/Storage", test, test1);
		waitForElement(driver, waiver_for_dd);
		click(driver, waiver_for_dd);

		String waiver_dd = String.format(waiver_for_dd_options, waiver_type);
		waitForElement(driver, waiver_dd);
		click(driver, waiver_dd);

		String det_store_click = String.format(detntion_storage_option, Detention_storage_option);

		waitForElement(driver, det_store_click);
		click(driver, det_store_click);

		Step_End(3, "Select Waiver For Import Shipment, and Click on Detention/Storage", test, test1);

		Step_Start(4, " Click on BL No Search Field ", test, test1);

		waitForElement(driver, book_no_search_icon_dw);
		click(driver, book_no_search_icon_dw);
		Step_End(4, " Click on BL No Search Field ", test, test1);

		Step_Start(5, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type_Detention_waiver, BL_Number_input, "", "", "", "");

		Step_End(5, "Input your Confirm BL No", test, test1);

		Step_Start(6, "Click on show Button", test, test1);

		waitForElement(driver, show_bl_button_dw);
		click(driver, show_bl_button_dw);
		Step_End(6, "Click on show Button", test, test1);

		scrollBottom(driver);
		waitForElement(driver, Detention_container_Grid);
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
				System.out.println(No_Detention_Popup);
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

		List<Map<String, String>> detention_waiver_table_data = extractTableDataDirect3(driver, detention_waiver_Table);

		ArrayList<String> detention_List = new ArrayList<String>();

		for (int i = 0; i < Container_numbers.size(); i++) {
			String detension_Value = getValueByFirstColumnAndHeader(detention_waiver_table_data, "Container No",
					Container_numbers.get(i), "Waiver Amount in USD");
			detention_List.add(detension_Value);
		}

		Step_Start(11, "Click on save Button", test, test1);
		scrollTop(driver);

		if (isdisplayed(driver, Waiver_ReasonSearch)) {

			waitForElement(driver, Waiver_ReasonSearch);
			click(driver, Waiver_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reasoncode_Header, Waiver_Condition, Waiver_Reasoncode);

		}

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(11, "Click on save Button", test, test1);

		Step_Start(12, "System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		waitForPopup(driver, popup, pending_popup_expected);
		String pending_popup_actual = getText(driver, popup);

		if (pending_popup_actual.equalsIgnoreCase(pending_popup_expected)) {

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
		waitForElement(driver, submitted_button_dw);
		click(driver, submitted_button_dw);

		Step_End(13, "Click on Edit Button and Click the Submit button", test, test1);

		Step_Start(14, "click on save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(14, "click on save button", test, test1);

		Step_Start(15, "Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		waitForPopup(driver, popup, submit_popup_expected);
		String submit_popup_actual = getText(driver, popup);

		if (submit_popup_actual.equalsIgnoreCase(submit_popup_expected)) {

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

		Step_Start(16, "Capture the Waiver No and waiver Amount", test, test1);
		waitForElement(driver, waiver_ref_num_txtfld);
		String waiver_ref_number = getAttribute(driver, waiver_ref_num_txtfld, "value");

		System.out.println("The generated waiver reference number is: " + waiver_ref_number);
		Extent_pass_New(driver, "The generated waiver reference number is: " + waiver_ref_number, test, test1);

		Step_End(16, "Capture the Waiver No and waiver Amount", test, test1);

		Step_Start(17, "Switch to Line Login", test, test1);
		// switch to liner profile
		ResetProfile(driver);
		Step_End(17, "Switch to Line Login", test, test1);

		Step_Start(18, "Open Waiver Gate module", test, test1);

		moduleNavigate(driver, waiver_gate_module);
		Step_End(18, "Open Waiver Gate module", test, test1);

		waitForElement(driver, waiver_gate_submit_button);
		click(driver, waiver_gate_submit_button);

		Step_Start(19, "Select the Row Waiver in waiver gate", test, test1);
		String waiver_checkbox_click = String.format(waiver_gate_checkbox, waiver_ref_number);

		waitForElement(driver, waiver_checkbox_click);
		click(driver, waiver_checkbox_click);
		Step_End(19, "Select the Row Waiver in waiver gate", test, test1);

		Step_Start(20, "Click on approve Button", test, test1);
		waitForElement(driver, waiver_gate_approve_btn);
		click(driver, waiver_gate_approve_btn);
		Step_End(20, "Click on approve Button", test, test1);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, "open the import invoice module and click the new button", test, test1);
		moduleNavigate(driver, import_invoice_Module);

		newButton(driver);

		Step_End(2, "open the import invoice module and click the new button", test, test1);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			Step_Start(3, "Click on BL NO Search and Paste the BL in the search and then load the BL", test, test1);

			waitForDisplay(driver, By_BL_Number_Btn);
			click(driver, By_BL_Number_Btn);

			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");
			
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
			waitForElement(driver, service_Txtfield_IN);
			sendKeys(driver, vessels_code_input, Vessel_Code);
			
			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, Voyage_Number);
			
			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_Input);
			
			waitForElement(driver, PortCode_Input);
			sendKeys(driver, PortCode_Input, Port_Code);

			horizontalscroll(driver, By_Vessel_Scroll, 500); 
			if(!Terminal_Code_Input.equals("")) {
				horizontalscroll(driver, By_Vessel_Scroll, 500);
				sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
			}
				
			if(!Call_ID.equals("")) {
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

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type_Import_Doc, BL_Number_input, "", "", "",
						"");

			} else if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_Service")) {

				newButton(driver);
				waitForElement(driver, ID_servicename);
				sendKeys(driver, ID_servicename, Service_Code);

				waitForElement(driver, ID_grid_vesselcode);
				sendKeys(driver, ID_grid_vesselcode, Vessel_Code);
				
				waitForElement(driver, ID_grid_voyagecode);
				sendKeys(driver, ID_grid_voyagecode, Voyage_Number);
				
				waitForElement(driver, ID_grid_bound);
				sendKeys(driver, ID_grid_bound, Bound_Input);
				
				waitForElement(driver, ID_grid_portcode);
				sendKeys(driver, ID_grid_portcode, Port_Code);

				horizontalscroll(driver, grid_scroll, 300);
				click(driver, ID_grid_terminal);
				sendKeys(driver, ID_grid_terminal, Terminal_Code_Input);
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

			waitForElement(driver, customer_code_copy);
			String CustomerCode = getText(driver, customer_code_copy);
		
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

			if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
				waitForElement(driver, SystemCode_FilterInput);
				sendKeys(driver, SystemCode_FilterInput, Import_Doc_Customer_TypeValue);
			}
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			Step_End(10, "click the customer field and put the CN code or name ", test, test1);

			Step_Start(11, "load the same Customer and click on SHow BL button, ", test, test1);

			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);
			Step_End(11, "load the same Customer and click on SHow BL button, ", test, test1);
			
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

		Step_Start(12,
				"Verify for LP and % option and waiver AMT and Waiver No matched from Waiver and Import Invoice.", test,
				test1);
		waitForElement(driver, importInvoice_Table_Header);
		List<Map<String, String>> invoice_Tabledata = getTableData(driver, importInvoice_Table_Header,
				importInvoice_Table_Row);

		scrollBottom(driver);

		waitForElement(driver, detention_charges_tab);
		click(driver, detention_charges_tab);

		waitForElement(driver, detention_Table_Headers);

		List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
				detention_Table_Rows);

		String waiver_Num = getFirstValueByHeader(detention_Teble_Values, "Waiver No");

		for (int i = 0; i < Container_numbers.size(); i++) {
			String currency_Code = getValueByFirstColumnAndHeader(detention_Teble_Values, "Container Number",
					Container_numbers.get(i), "InvCurrency");
			if (!currency_Code.equalsIgnoreCase("USD")) {
				String Currency_Value = getValueByFirstColumnAndHeader(invoice_Tabledata, "Inv Currency", currency_Code,
						"Inv ROE");
				String Actual_currency_Value = getValueByFirstColumnAndHeader(detention_Teble_Values,
						"Container Number", Container_numbers.get(i), "Waiver Invoice Amount").replace(",", "");
				System.out.println(Actual_currency_Value);
				String Expected_currency_Value = multiplyCurrencyValue(currency_Code, detention_List.get(i),
						Currency_Value).replace(",", "");
				System.out.println(Expected_currency_Value);

				double actual_Currency_Value = getNumberValue(Actual_currency_Value);
				double expected_Currency_Value = getNumberValue(Expected_currency_Value);

				System.out.println("Actual_currency_Value :" + actual_Currency_Value);

				System.out.println("Expected_currency_Value :" + expected_Currency_Value);

				if (areEqualIgnoringSign1(expected_Currency_Value, actual_Currency_Value)) {

					System.out.println("Matched || Expected Currency value was :" + expected_Currency_Value
							+ "  ||Actual currency value was :" + actual_Currency_Value + "is same");
					Extent_pass_New(driver,
							"Matched || Expected Currency value was :" + expected_Currency_Value
									+ "|| Actual currency value was :" + actual_Currency_Value + "is same",
							test, test1);
				} else {
					System.out.println("Not Matched || Expected Currency value was :" + expected_Currency_Value
							+ "|| Actual currency value was :" + actual_Currency_Value + "is not same");
					extent_fail(driver,
							"Not Matched || Expected Currency value was :" + expected_Currency_Value
									+ "|| Actual currency value was :" + actual_Currency_Value + "is not same",
							test, test1);
				}

			}

		}
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

		if (waiver_ref_number.equals(waiver_Num)) {
			Extent_pass_New(driver, "Matched || Waiver Number from Detention Waiver Module : " + waiver_ref_number
					+ "|| Waiver Number from Import Invoice Module : " + waiver_Num, test, test1);
			System.out.println("Matched || Waiver Number from Detention Waiver Module : " + waiver_ref_number
					+ " || Waiver Number from Import Invoice Module : " + waiver_Num);
		} else {
			System.out.println("Not Matched || Waiver Number from Detention Waiver Module : " + waiver_ref_number
					+ "|| Waiver Number from Import Invoice Module : " + waiver_Num);
			Extent_fail(driver, "Not Matched || Waiver Number from Detention Waiver Module : " + waiver_ref_number
					+ "||  Waiver Number from Import Invoice Module : " + waiver_Num, test, test1);
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

		Extent_completed(testCaseName, test, test1);

	}

}
