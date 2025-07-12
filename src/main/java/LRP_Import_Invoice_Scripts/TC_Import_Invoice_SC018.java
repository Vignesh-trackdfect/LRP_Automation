package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC018 extends Keywords {
	public void Import_Invoice_SC018(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC018";
		
		

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String AgencyUser = Excel_data.get("AgencyUser");
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
		String Search_Import_Document = Excel_data.get("Search_Import_Document");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String Invoice_Save_Type = Excel_data.get("Invoice_Save_Type");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Tab_Name_II = Excel_data.get("Tab_Name_II");
		String container_Option = Excel_data.get("container_Option");
		String Extention_Date = Excel_data.get("Extention_Date");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Container_Numbers = Excel_data.get("Container_Numbers");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		String sys_Code = Excel_data.get("sys_Code");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Import_invoice_delete = Excel_data.get("Import_invoice_delete");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");


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

			
			click(driver, vessels_code_input);
			Actionsendkeys(driver, vessels_code_input, Vessel_Code);
			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, Voyage_Number);
			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_Input);
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
				waitForElement(driver, ID_grid_terminal);
				click(driver, ID_grid_terminal);
				sendKeys(driver, ID_grid_terminal, Terminal_Code_Input);
				waitForElement(driver, service_grid_first_row);
				click(driver, service_grid_first_row);

				waitForElement(driver, service_select_btn);
				click(driver, service_select_btn);

				waitForElement(driver, ID_Show_Button);
				click(driver, ID_Show_Button);
			}

			waitForElement(driver, Container_Tab_IMD);
			scrollBottom(driver);
			waitForElement(driver, Customer_Tab_IMD);
			click(driver, Customer_Tab_IMD);

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

			globalValueSearchWindow1(driver, Customer_Filter_Condition, Customer_Filter_Type, CustomerCode, "", "", "","");

			if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
				waitForElement(driver, SystemCode_FilterInput);
				sendKeys(driver, SystemCode_FilterInput, sys_Code);
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

		Step_Start(12, "Go to Detention/ storage charges tab based on test data", test, test1);

		waitForDisplay(driver, SelectButton);

		String tab_Select = String.format(import_Invoice_Tab, Tab_Name_II);
		waitForDisplay(driver, tab_Select);
		jsClick(driver, tab_Select);

		Step_End(12, "Go to Detention/ storage charges tab based on test data", test, test1);

		Step_Start(13, "select ALL/Selected container option", test, test1);

		List<String> numbers = splitAndExpand(Container_Numbers, ",");

		List<String> Extention_Dates = splitAndExpand(Extention_Date, ",");

		if (Invoice_Save_Type.equalsIgnoreCase("New")) {

			Extent_call(test, test1, "** NEW Mode Start   **");
			if (Tab_Name_II.contains("Detention")) {
				String container_Option_Select = String.format(detention_Select_Option, container_Option);
				waitForElement(driver, container_Option_Select);
				click(driver, container_Option_Select);
				Step_End(13, "select ALL/Selected container option", test, test1);
				if (container_Option.contains("All Container")) {
					Step_Start(14, "Selection the Extension Date and click on + button", test, test1);
					waitForElement(driver, detention_Extention_Date);
					if (Date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, detention_Extention_Date, Extention_Dates.get(0));

					} else {
						waitForElement(driver, detention_Extention_Date);
						Newclear(driver, detention_Extention_Date);
						sendKeys(driver, detention_Extention_Date, Extention_Dates.get(0));
						enter(driver);
					}
					waitForElement(driver, detention_Extention_Date);
					String Expected_Date = getAttribute(driver, detention_Extention_Date, "value");
					waitForElement(driver, detention_Extention_Date_Add_Button);
					click(driver, detention_Extention_Date_Add_Button);
					Step_End(14, "Selection the Extension Date and click on + button", test, test1);
					Step_Start(15,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, detention_Table_Headers);
					List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
							detention_Table_Rows);
					List<String> Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values,
							"Detention Request End Date");
					List<String> Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					
					
					Step_End(15,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					Step_Start(16, "select the draft and click the save button in tool bar ", test, test1);
					scrollTop(driver);
					waitForElement(driver, importInvoice_Draft_Button);
					click(driver, importInvoice_Draft_Button);

					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);

					Step_End(16, "select the draft and click the save button in tool bar ", test, test1);

					Step_Start(17, "system has validate import invoice saved..and  click ok", test, test1);

					waitForPopup(driver, popup_Message, Draft_saved_pop);

					String import_saved_act = getText(driver, popup_Message);
					System.out.println(import_saved_act);
					if (Draft_saved_pop.equals(import_saved_act)) {
						System.out.println("Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act);
						Extent_pass_New(driver, "Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act, test, test1);
					} else {
						System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act);
						Extent_fail(driver, "Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act, test, test1);
					}
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					Step_End(17, "system has validate import invoice saved..and  click ok", test, test1);

				} else if (container_Option.contains("Select Container")) {
					Step_Start(18,
							"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show",
							test, test1);
					for (int i = 0; i < numbers.size(); i++) {
						waitForElement(driver, detention_Container_Select);
						click(driver, detention_Container_Select);
						String select_Container = String.format(DropDown_Select, numbers.get(i));
						waitForElement(driver, select_Container);
						click(driver, select_Container);
						waitForElement(driver, detention_Extention_Date);
						if (Date_Picker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, detention_Extention_Date, Extention_Dates.get(i));
						} else {
							waitForElement(driver, detention_Extention_Date);
							Newclear(driver, detention_Extention_Date);
							sendKeys(driver, detention_Extention_Date, Extention_Dates.get(i));
							enter(driver);
						}
						waitForElement(driver, detention_Extention_Date);
						String Expected_Date = getAttribute(driver, detention_Extention_Date, "value");
						waitForElement(driver, detention_Extention_Date_Add_Button);
						click(driver, detention_Extention_Date_Add_Button);
						waitForElement(driver, detention_Table_Headers);
						List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
								detention_Table_Rows);
						String Grid_Extention_Date = getValueByFirstColumnAndHeader(detention_Teble_Values,
								"Container Number", numbers.get(i), "Detention Request End Date");
						if (Expected_Date.equals(Grid_Extention_Date)) {
							System.out.println("Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						} else {
							System.out.println("Not Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						}
						Step_End(18,
								"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show ",
								test, test1);
						Step_Start(19, "select the draft and click the save button in tool bar", test, test1);
						scrollTop(driver);
						waitForElement(driver, importInvoice_Draft_Button);
						click(driver, importInvoice_Draft_Button);

						Step_End(19, "system has validate import invoice saved..and  click ok", test, test1);
						Step_Start(20, "system has validate import invoice saved..and  click ok", test, test1);
						waitForElement(driver, SaveButton_ToolBar);
						click1(driver, SaveButton_ToolBar);

						waitForPopup(driver, popup_Message, Draft_saved_pop);

						String import_saved_act = getText(driver, popup_Message);
						System.out.println(import_saved_act);

						if (Draft_saved_pop.equals(import_saved_act)) {
							System.out.println("Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
									+ import_saved_act);
							Extent_pass_New(driver, "Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
									+ import_saved_act, test, test1);
						} else {
							System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop
									+ " || Actual Popup : " + import_saved_act);
							Extent_fail(driver, "Not Matched || Expected Popup : " + Draft_saved_pop
									+ " || Actual Popup : " + import_saved_act, test, test1);
						}
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
						Step_End(20, "system has validate import invoice saved..and  click ok", test, test1);
					}
				}
			} else if (Tab_Name_II.contains("Storage")) {
				String container_Option_Select = String.format(storage_Select_Option, container_Option);
				waitForElement(driver, container_Option_Select);
				click(driver, container_Option_Select);
				Step_End(13, "select ALL/Selected container option", test, test1);
				if (container_Option.contains("All Container")) {
					Step_Start(14, "Selection the Extension Date and click on + button", test, test1);
					waitForElement(driver, storage_Extention_Date);
					if (Date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, storage_Extention_Date, Extention_Dates.get(0));
					} else {
						waitForElement(driver, storage_Extention_Date);
						click(driver, storage_Extention_Date);
						Newclear(driver, storage_Extention_Date);
						sendKeys(driver, storage_Extention_Date, Extention_Dates.get(0));
						enter(driver);
					}
					waitForElement(driver, storage_Extention_Date);
					String Expected_Date = getAttribute(driver, storage_Extention_Date, "value");
					waitForElement(driver, storage_Extention_Date_Add_Button);
					click(driver, storage_Extention_Date_Add_Button);
					Step_End(14, "Selection the Extension Date and click on + button", test, test1);
					Step_Start(15,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, storage_Table_Headers);
					List<Map<String, String>> detention_Teble_Values = getTableData(driver, storage_Table_Headers,
							storage_Table_Rows);
					List<String> Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values,
							"Detention Request End Date");
					List<String> Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(15,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					Step_Start(16, "select the draft and click the save button in tool bar ", test, test1);
					scrollTop(driver);
					waitForElement(driver, importInvoice_Draft_Button);
					click(driver, importInvoice_Draft_Button);

					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);

					Step_End(16, "select the draft and click the save button in tool bar ", test, test1);

					Step_Start(17, "system has validate import invoice saved..and  click ok", test, test1);

					waitForPopup(driver, popup_Message, Draft_saved_pop);

					String import_saved_act = getText(driver, popup_Message);
					System.out.println(import_saved_act);

					if (Draft_saved_pop.equals(import_saved_act)) {
						System.out.println("Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act);
						Extent_pass_New(driver, "Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act, test, test1);
					} else {
						System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act);
						Extent_fail(driver, "Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
								+ import_saved_act, test, test1);
					}
					
					Step_End(17, "system has validate import invoice saved..and  click ok", test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				
				} else if (container_Option.contains("Select Container")) {
					Step_Start(18,
							"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show",
							test, test1);
					for (int i = 0; i < numbers.size(); i++) {
						waitForElement(driver, storage_Container_Select);
						click(driver, storage_Container_Select);
						String select_Container = String.format(DropDown_Select, numbers.get(i));
						waitForElement(driver, select_Container);
						click(driver, select_Container);
						waitForElement(driver, storage_Extention_Date);
						if (Date_Picker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, storage_Extention_Date, Extention_Dates.get(i));
						} else {
							waitForElement(driver, storage_Extention_Date);
							Newclear(driver, storage_Extention_Date);
							sendKeys(driver, storage_Extention_Date, Extention_Dates.get(i));
							enter(driver);
						}
						waitForElement(driver, storage_Extention_Date);
						String Expected_Date = getAttribute(driver, storage_Extention_Date, "value");
						waitForElement(driver, storage_Extention_Date_Add_Button);
						click(driver, storage_Extention_Date_Add_Button);
						waitForElement(driver, storage_Table_Headers);
						List<Map<String, String>> detention_Teble_Values = getTableData(driver, storage_Table_Headers,
								storage_Table_Rows);
						String Grid_Extention_Date = getValueByFirstColumnAndHeader(detention_Teble_Values,
								"Container Number", numbers.get(i), "Detention Request End Date");
						if (Expected_Date.equals(Grid_Extention_Date)) {
							System.out.println("Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						} else {
							System.out.println("Not Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						}
						Step_End(18,
								"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show ",
								test, test1);
						Step_Start(19, "select the draft and click the save button in tool bar", test, test1);

						scrollTop(driver);
						waitForElement(driver, importInvoice_Draft_Button);
						click(driver, importInvoice_Draft_Button);

						Step_End(19, "system has validate import invoice saved..and  click ok", test, test1);

						Step_Start(20, "system has validate import invoice saved..and  click ok", test, test1);

						waitForElement(driver, SaveButton_ToolBar);
						click1(driver, SaveButton_ToolBar);

						waitForPopup(driver, popup_Message, Draft_saved_pop);
						String import_saved_act = getText(driver, popup_Message);
						System.out.println(import_saved_act);

						if (Draft_saved_pop.equals(import_saved_act)) {
							System.out.println("Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
									+ import_saved_act);
							Extent_pass_New(driver, "Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
									+ import_saved_act, test, test1);
						} else {
							System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop
									+ " || Actual Popup : " + import_saved_act);
							Extent_fail(driver, "Not Matched || Expected Popup : " + Draft_saved_pop
									+ " || Actual Popup : " + import_saved_act, test, test1);
						}
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
						Step_End(20, "system has validate import invoice saved..and  click ok", test, test1);
					}
				}
			}
			Extent_call(test, test1, "** New Mode End   **");

		} else if (Invoice_Save_Type.equalsIgnoreCase("Draft")) {

			Extent_call(test, test1, "** DRAFT Mode Start   **");

			Step_Start(21, "select the draft and click the save button in tool bar ", test, test1);
			scrollTop(driver);
			waitForElement(driver, importInvoice_Draft_Button);
			click(driver, importInvoice_Draft_Button);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

			Step_End(21, "select the draft and click the save button in tool bar ", test, test1);

			Step_Start(22, "system has validate import invoice saved.", test, test1);

			waitForPopup(driver, popup_Message, Draft_saved_pop);

			String import_Draft_Act = getText(driver, popup_Message);
			System.out.println(import_Draft_Act);

			if (Draft_saved_pop.equals(import_Draft_Act)) {
				System.out.println(
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_Draft_Act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_Draft_Act,
						test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
						+ import_Draft_Act);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_Draft_Act,
						test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(22, "system has validate import invoice saved.", test, test1);

			Step_Start(23, "Click on Edit Button", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click1(driver, Edit_Button_toolBar);

			Step_End(23, " Click on Edit Button", test, test1);
			Step_End(24, "select ALL/Selected container option", test, test1);
			if (Tab_Name_II.contains("Detention")) {
				String container_Option_Select = String.format(detention_Select_Option, container_Option);
				waitForElement(driver, container_Option_Select);
				click(driver, container_Option_Select);
				Step_End(24, "select ALL/Selected container option", test, test1);
				if (container_Option.contains("All Container")) {
					Step_Start(25, "Selection the Extension Date and click on + button", test, test1);
					waitForElement(driver, detention_Extention_Date);
					if (Date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, detention_Extention_Date, Extention_Dates.get(0));
					} else {
						waitForElement(driver, detention_Extention_Date);
						Newclear(driver, detention_Extention_Date);
						sendKeys(driver, detention_Extention_Date, Extention_Dates.get(0));
						enter(driver);
					}
					
					waitForElement(driver, detention_Extention_Date_Add_Button);
					click(driver, detention_Extention_Date_Add_Button);
					waitForElement(driver, detention_Extention_Date);
					String Expected_Date = getAttribute(driver, detention_Extention_Date, "value");
					
					Step_End(25, "Selection the Extension Date and click on + button", test, test1);
					Step_Start(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, detention_Table_Headers);
					List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
							detention_Table_Rows);
					List<String> Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values,
							"Detention Request End Date");
					List<String> Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);

					Step_Start(27, "select the draft and click the save button in tool bar ", test, test1);

					scrollTop(driver);
					waitForElement(driver, importInvoice_Draft_Button);
					click(driver, importInvoice_Draft_Button);

					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);

					Step_End(27, "select the draft and click the save button in tool bar ", test, test1);

					Step_Start(28, "system has validate import invoice updated..and  click ok", test, test1);

					waitForPopup(driver, popup_Message, Issued_saved_pop);
					String import_Updated_act = getText(driver, popup_Message);
					System.out.println(import_Updated_act);

					if (Issued_saved_pop.equals(import_Updated_act)) {
						System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act, test, test1);
					} else {
						System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
								+ " || Actual Popup : " + import_Updated_act, test, test1);
					}
					
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					
					Step_End(28, "system has validate import invoice updated..and  click ok", test, test1);
					
					Step_Start(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					
					waitForElement(driver, detention_Table_Headers);
					
					detention_Teble_Values = getTableData(driver, detention_Table_Headers, detention_Table_Rows);
					Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values, "Detention Request End Date");
					Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);

				} else if (container_Option.contains("Select Container")) {
					Step_Start(18,
							"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show",
							test, test1);
					for (int i = 0; i < numbers.size(); i++) {
						waitForElement(driver, detention_Container_Select);
						click(driver, detention_Container_Select);
						String select_Container = String.format(DropDown_Select, numbers.get(i));
						waitForElement(driver, select_Container);
						click(driver, select_Container);
						waitForElement(driver, detention_Extention_Date);
						if (Date_Picker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, detention_Extention_Date, Extention_Dates.get(i));
						} else {
							waitForElement(driver, detention_Extention_Date);
							Newclear(driver, detention_Extention_Date);
							sendKeys(driver, detention_Extention_Date, Extention_Dates.get(i));
							enter(driver);
						}
						waitForElement(driver, detention_Extention_Date_Add_Button);
						click(driver, detention_Extention_Date_Add_Button);
						waitForElement(driver, detention_Extention_Date);
						String Expected_Date = getAttribute(driver, detention_Extention_Date, "value");
						Step_End(18,
								"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show ",
								test, test1);
						Step_Start(19, "select the draft and click the save button in tool bar", test, test1);
						scrollTop(driver);
						waitForElement(driver, importInvoice_Draft_Button);
						click(driver, importInvoice_Draft_Button);

						Step_End(19, "system has validate import invoice saved..and  click ok", test, test1);

						Step_Start(29, "system has validate import invoice updated..and  click ok.", test, test1);

						waitForElement(driver, SaveButton_ToolBar);
						click1(driver, SaveButton_ToolBar);

						waitForPopup(driver, popup_Message, Issued_saved_pop);
						String import_Updated_act = getText(driver, popup_Message);
						System.out.println(import_Updated_act);

						if (Issued_saved_pop.equals(import_Updated_act)) {
							System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
									+ import_Updated_act);
							Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						} else {
							System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act);
							Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						}
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
						Step_End(29, "system has validate import invoice updated..and  click ok.", test, test1);
						Step_Start(26,
								"Verify that Extension Date Reflected in Detention Request End Date Column",
								test, test1);
						
						
						waitForElement(driver, Edit_Button_toolBar);
						click1(driver, Edit_Button_toolBar);
						waitForElement(driver, detention_Extention_Date_Add_Button);
						click(driver, detention_Extention_Date_Add_Button);
						scrollBottom(driver);
						List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
								detention_Table_Rows);
						String Grid_Extention_Date = getValueByFirstColumnAndHeader(detention_Teble_Values,
								"Container Number", numbers.get(i), "Detention Request End Date");
						if (Expected_Date.equals(Grid_Extention_Date)) {
							System.out.println("Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						} else {
							System.out.println("Not Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							Extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						}
						Step_End(26,
								"Verify that Extension Date Reflected in Detention Request End Date Column",
								test, test1);
					}
					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}
			} else if (Tab_Name_II.contains("Storage")) {
				String container_Option_Select = String.format(storage_Select_Option, container_Option);
				waitForElement(driver, container_Option_Select);
				click(driver, container_Option_Select);
				Step_End(24, "select ALL/Selected container option", test, test1);
				if (container_Option.contains("All Container")) {
					Step_Start(25, "Selection the Extension Date and click on + button", test, test1);
					waitForElement(driver, storage_Extention_Date);
					if (Date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, storage_Extention_Date, Extention_Dates.get(0));
					} else {
						waitForElement(driver, storage_Extention_Date);
						Newclear(driver, storage_Extention_Date);
						sendKeys(driver, storage_Extention_Date, Extention_Dates.get(0));
						enter(driver);
					}
					waitForElement(driver, storage_Extention_Date_Add_Button);
					click(driver, storage_Extention_Date_Add_Button);
					waitForElement(driver, storage_Extention_Date);
					String Expected_Date = getAttribute(driver, storage_Extention_Date, "value");
				
					Step_End(25, "Selection the Extension Date and click on + button", test, test1);
					Step_Start(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, storage_Table_Headers);
					List<Map<String, String>> detention_Teble_Values = getTableData(driver, storage_Table_Headers,
							detention_Table_Rows);
					List<String> Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values,
							"Detention Request End Date");
					List<String> Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);
					Step_Start(27, "select the draft and click the save button in tool bar ", test, test1);
					scrollTop(driver);
					waitForElement(driver, importInvoice_Draft_Button);
					click(driver, importInvoice_Draft_Button);

					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);

					Step_End(27, "select the draft and click the save button in tool bar ", test, test1);

					Step_Start(28, "system has validate import invoice updated..and  click ok", test, test1);

					waitForPopup(driver, popup_Message, Issued_saved_pop);

					String import_Updated_act = getText(driver, popup_Message);
					System.out.println(import_Updated_act);

					if (Issued_saved_pop.equals(import_Updated_act)) {
						System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act, test, test1);
					} else {
						System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
								+ " || Actual Popup : " + import_Updated_act, test, test1);
					}
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					Step_End(28, "system has validate import invoice updated..and  click ok", test, test1);
					Step_Start(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, storage_Table_Headers);
					detention_Teble_Values = getTableData(driver, storage_Table_Headers, storage_Table_Rows);
					Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values, "Detention Request End Date");
					Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);

				} else if (container_Option.contains("Select Container")) {
					Step_Start(18,
							"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show",
							test, test1);
					waitForElement(driver, storage_Container_Select);
					click(driver, storage_Container_Select);
					for (int i = 0; i < numbers.size(); i++) {
						String select_Container = String.format(DropDown_Select, numbers.get(i));
						waitForElement(driver, select_Container);
						click(driver, select_Container);
						waitForElement(driver, storage_Extention_Date);
						if (Date_Picker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, storage_Extention_Date, Extention_Dates.get(i));
						} else {
							waitForElement(driver, storage_Extention_Date);
							Newclear(driver, storage_Extention_Date);
							sendKeys(driver, storage_Extention_Date, Extention_Dates.get(i));
							enter(driver);
						}
						waitForElement(driver, storage_Extention_Date);
						String Expected_Date = getAttribute(driver, storage_Extention_Date, "value");
						Step_End(18,
								"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show ",
								test, test1);
						Step_Start(19, "select the draft and click the save button in tool bar", test, test1);
						scrollTop(driver);
						waitForElement(driver, importInvoice_Draft_Button);
						click(driver, importInvoice_Draft_Button);

						Step_End(19, "system has validate import invoice saved..and  click ok", test, test1);

						Step_Start(29, "system has validate import invoice updated..and  click ok.", test, test1);

						waitForElement(driver, SaveButton_ToolBar);
						click1(driver, SaveButton_ToolBar);

						waitForPopup(driver, popup_Message, Issued_saved_pop);

						String import_Updated_act = getText(driver, popup_Message);
						System.out.println(import_Updated_act);
						if (Issued_saved_pop.equals(import_Updated_act)) {
							System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
									+ import_Updated_act);
							Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						} else {
							System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act);
							Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						}
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
						Step_End(29, "system has validate import invoice updated..and  click ok.", test, test1);
						Step_Start(26,
								"Verify that Extension Date Reflected in Detention Request End Date Column",
								test, test1);
						waitForElement(driver, storage_Extention_Date_Add_Button);
						click(driver, storage_Extention_Date_Add_Button);
						waitForElement(driver, storage_Table_Headers);
						List<Map<String, String>> detention_Teble_Values = getTableData(driver, storage_Table_Headers,
								storage_Table_Rows);
						String Grid_Extention_Date = getValueByFirstColumnAndHeader(detention_Teble_Values,
								"Container Number", numbers.get(i), "Detention Request End Date");
						if (Expected_Date.equals(Grid_Extention_Date)) {
							System.out.println("Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						} else {
							System.out.println("Not Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						}
						Step_End(26,
								"Verify that Extension Date Reflected in Detention Request End Date Column",
								test, test1);
					}
				}
			}
			Extent_call(test, test1, "** DRAFT Mode End   **");

		} else if (Invoice_Save_Type.equalsIgnoreCase("Issue")) {

			Extent_call(test, test1, "** Issue Mode Start   **");

			Step_Start(21, "select the Issue button and click the save button in tool bar", test, test1);
			scrollTop(driver);
			waitForElement(driver, importInvoice_Draft_Button);
			click(driver, importInvoice_Draft_Button);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(21, "select the Issue button and click the save button in tool bar ", test, test1);

			Step_Start(22, "system has validate import invoice saved..and  click ok", test, test1);

			waitForPopup(driver, popup_Message, Draft_saved_pop);

			String import_Draft_Act = getText(driver, popup_Message);
			System.out.println(import_Draft_Act);

			if (Draft_saved_pop.equals(import_Draft_Act)) {
				System.out.println(
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_Draft_Act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_Draft_Act,
						test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
						+ import_Draft_Act);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_Draft_Act,
						test, test1);
			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(22, "system has validate import invoice saved..and  click ok", test, test1);

			Step_Start(23, "Click on Edit Button", test, test1);

			if(IsElementEnabled(driver, Edit_Button_toolBar)) {
				waitForElement(driver, Edit_Button_toolBar);
				click1(driver, Edit_Button_toolBar);

			}
			
			Step_End(23, " Click on Edit Button", test, test1);
			Step_Start(23, "A.Click on Edit Button", test, test1);

			waitForElement(driver, import_Invoice_Issued_Button);
			click1(driver, import_Invoice_Issued_Button);

			Step_End(23, "A.Click on Edit Button", test, test1);
			Step_Start(24, "select ALL/Selected container option", test, test1);
			if (Tab_Name_II.contains("Detention")) {
				String container_Option_Select = String.format(detention_Select_Option, container_Option);
				waitForElement(driver, container_Option_Select);
				click(driver, container_Option_Select);
				Step_End(24, "select ALL/Selected container option", test, test1);
				if (container_Option.contains("All Container")) {
					Step_Start(25, "Selection the Extension Date and click on + button", test, test1);
					waitForElement(driver, detention_Extention_Date);
					if (Date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, detention_Extention_Date, Extention_Dates.get(0));
					} else {
						waitForElement(driver, detention_Extention_Date);
						Newclear(driver, detention_Extention_Date);
						sendKeys(driver, detention_Extention_Date, Extention_Dates.get(0));
						enter(driver);
					}
					waitForElement(driver, detention_Extention_Date);
					String Expected_Date = getAttribute(driver, detention_Extention_Date, "value");
					waitForElement(driver, detention_Extention_Date_Add_Button);
					click(driver, detention_Extention_Date_Add_Button);
					Step_End(25, "Selection the Extension Date and click on + button", test, test1);
					Step_Start(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, detention_Table_Headers);
					List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
							detention_Table_Rows);
					List<String> Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values,
							"Detention Request End Date");
					List<String> Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);

					Step_Start(27, "select the draft and click the save button in tool bar ", test, test1);

					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);

					Step_End(27, "select the draft and click the save button in tool bar ", test, test1);

					Step_Start(28, "system has validate import invoice saved..and  click ok", test, test1);

					waitForPopup(driver, popup_Message, Issued_saved_pop);

					String import_Updated_act = getText(driver, popup_Message);
					System.out.println(import_Updated_act);

					if (Issued_saved_pop.equals(import_Updated_act)) {
						System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act, test, test1);
					} else {
						System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
								+ " || Actual Popup : " + import_Updated_act, test, test1);
					}
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					Step_End(28, "system has validate import invoice saved..and  click ok", test, test1);
					Step_Start(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, detention_Table_Headers);
					detention_Teble_Values = getTableData(driver, detention_Table_Headers, detention_Table_Rows);
					Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values, "Detention Request End Date");
					Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
				} else if (container_Option.contains("Select Container")) {
					Step_Start(18,
							"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show",
							test, test1);
					for (int i = 0; i < numbers.size(); i++) {
						waitForElement(driver, detention_Container_Select);
						click(driver, detention_Container_Select);
						String select_Container = String.format(DropDown_Select, numbers.get(i));
						waitForElement(driver, select_Container);
						click(driver, select_Container);
						waitForElement(driver, detention_Extention_Date);
						if (Date_Picker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, detention_Extention_Date, Extention_Dates.get(i));
						} else {
							waitForElement(driver, detention_Extention_Date);
							Newclear(driver, detention_Extention_Date);
							sendKeys(driver, detention_Extention_Date, Extention_Dates.get(i));
							enter(driver);
						}
						waitForElement(driver, detention_Extention_Date);
						String Expected_Date = getAttribute(driver, detention_Extention_Date, "value");
						waitForElement(driver, detention_Extention_Date_Add_Button);
						click(driver, detention_Extention_Date_Add_Button);
						waitForElement(driver, detention_Table_Headers);
						List<Map<String, String>> detention_Teble_Values = getTableData(driver, detention_Table_Headers,
								detention_Table_Rows);
						String Grid_Extention_Date = getValueByFirstColumnAndHeader(detention_Teble_Values,
								"Container Number", numbers.get(i), "Detention Request End Date");
						if (Expected_Date.equals(Grid_Extention_Date)) {
							System.out.println("Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						} else {
							System.out.println("Not Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						}
						Step_End(18,
								"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show ",
								test, test1);
						scrollTop(driver);

						Step_Start(19, "system has validate import invoice saved..and  click ok", test, test1);

						waitForElement(driver, SaveButton_ToolBar);
						click1(driver, SaveButton_ToolBar);

						waitForPopup(driver, popup_Message, Issued_saved_pop);

						String import_Updated_act = getText(driver, popup_Message);
						System.out.println(import_Updated_act);
						if (Issued_saved_pop.equals(import_Updated_act)) {
							System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
									+ import_Updated_act);
							Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						} else {
							System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act);
							Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						}
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
						Step_End(19, "system has validate import invoice saved..and  click ok", test, test1);
					}
				}
			} else if (Tab_Name_II.contains("Storage")) {
				String container_Option_Select = String.format(storage_Select_Option, container_Option);
				waitForElement(driver, container_Option_Select);
				click(driver, container_Option_Select);
				Step_End(24, "select ALL/Selected container option", test, test1);
				if (container_Option.contains("All Container")) {
					Step_Start(25, "Selection the Extension Date and click on + button", test, test1);
					waitForElement(driver, storage_Extention_Date);
					if (Date_Picker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, storage_Extention_Date, Extention_Dates.get(0));
					} else {
						waitForElement(driver, storage_Extention_Date);
						Newclear(driver, storage_Extention_Date);
						sendKeys(driver, storage_Extention_Date, Extention_Dates.get(0));
						enter(driver);
					}
					waitForElement(driver, storage_Extention_Date);
					String Expected_Date = getAttribute(driver, storage_Extention_Date, "value");
					waitForElement(driver, storage_Extention_Date_Add_Button);
					click(driver, storage_Extention_Date_Add_Button);
					Step_End(25, "Selection the Extension Date and click on + button", test, test1);
					Step_Start(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, storage_Table_Headers);
					List<Map<String, String>> detention_Teble_Values = getTableData(driver, storage_Table_Headers,
							detention_Table_Rows);
					List<String> Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values,
							"Detention Request End Date");
					List<String> Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(26,
							"Verify that Extension Date Reflected in Detention Request End Date Column",
							test, test1);
					Step_Start(27, "select the draft and click the save button in tool bar ", test, test1);
					scrollTop(driver);
					waitForElement(driver, import_Invoice_Issued_Button);
					click(driver, import_Invoice_Issued_Button);

					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);

					Step_End(27, "select the draft and click the save button in tool bar ", test, test1);

					Step_Start(28, "system has validate import invoice updated..and  click ok", test, test1);

					waitForPopup(driver, popup_Message, Issued_saved_pop);
					String import_Updated_act = getText(driver, popup_Message);
					System.out.println(import_Updated_act);
					if (Issued_saved_pop.equals(import_Updated_act)) {
						System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act, test, test1);
					} else {
						System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
								+ import_Updated_act);
						Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
								+ " || Actual Popup : " + import_Updated_act, test, test1);
					}
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					Step_End(28, "system has validate import invoice updated..and  click ok", test, test1);
					Step_Start(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);
					waitForElement(driver, storage_Table_Headers);
					detention_Teble_Values = getTableData(driver, storage_Table_Headers, storage_Table_Rows);
					Grid_Extention_Dates = getValuesByHeader(detention_Teble_Values, "Detention Request End Date");
					Grid_Container_Numbers = getValuesByHeader(detention_Teble_Values, "Container Number");
					for (int i = 0; i < Grid_Extention_Dates.size(); i++) {
						if (Expected_Date.equals(Grid_Extention_Dates.get(i))) {
							System.out
									.println("Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						} else {
							System.out.println(
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Container_Numbers.get(i)
											+ " || And The Container Number is : " + Grid_Container_Numbers.get(i),
									test, test1);
						}
					}
					Step_End(29,
							"Verify that same Extension Date Reflected in All the GRIDs in Detention Request End Date Column",
							test, test1);

				} else if (container_Option.contains("Select Container")) {
					Step_Start(18,
							"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show",
							test, test1);
					for (int i = 0; i < numbers.size(); i++) {
						waitForElement(driver, storage_Container_Select);
						click(driver, storage_Container_Select);
						String select_Container = String.format(DropDown_Select, numbers.get(i));
						waitForElement(driver, select_Container);
						click(driver, select_Container);
						waitForElement(driver, storage_Extention_Date);
						if (Date_Picker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, storage_Extention_Date, Extention_Dates.get(i));
						} else {
							waitForElement(driver, storage_Extention_Date);
							Newclear(driver, storage_Extention_Date);
							sendKeys(driver, storage_Extention_Date, Extention_Dates.get(i));
							enter(driver);
						}
						waitForElement(driver, storage_Extention_Date);
						String Expected_Date = getAttribute(driver, storage_Extention_Date, "value");

						Step_End(18,
								"Pass the Container Number and DO Extension Date from Test Data that has to be selected for each containers. if there are multiple container multiple entry will show ",
								test, test1);

						Step_Start(19, "select the draft and click the save button in tool bar", test, test1);

						scrollTop(driver);
						waitForElement(driver, import_Invoice_Issued_Button);
						click(driver, import_Invoice_Issued_Button);

						Step_End(19, "system has validate import invoice saved..and  click ok", test, test1);

						Step_Start(29, "system has validate import invoice updated..and  click ok.", test, test1);

						waitForElement(driver, SaveButton_ToolBar);
						click1(driver, SaveButton_ToolBar);

						waitForPopup(driver, popup_Message, Issued_saved_pop);

						String import_Updated_act = getText(driver, popup_Message);
						System.out.println(import_Updated_act);
						if (Issued_saved_pop.equals(import_Updated_act)) {
							System.out.println("Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
									+ import_Updated_act);
							Extent_pass_New(driver, "Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						} else {
							System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act);
							Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop
									+ " || Actual Popup : " + import_Updated_act, test, test1);
						}
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);
						Step_End(29, "system has validate import invoice updated..and  click ok.", test, test1);
						Step_Start(26,
								"Verify that Extension Date Reflected in Detention Request End Date Column",
								test, test1);
						waitForElement(driver, storage_Extention_Date_Add_Button);
						click(driver, storage_Extention_Date_Add_Button);
						waitForElement(driver, storage_Table_Headers);
						List<Map<String, String>> detention_Teble_Values = getTableData(driver, storage_Table_Headers,
								storage_Table_Rows);
						String Grid_Extention_Date = getValueByFirstColumnAndHeader(detention_Teble_Values,
								"Container Number", numbers.get(i), "Detention Request End Date");
						if (Expected_Date.equals(Grid_Extention_Date)) {
							System.out.println("Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							Extent_pass_New(driver,
									"Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						} else {
							System.out.println("Not Matched || The Expected Date Given From The Test Data : "
									+ Expected_Date + " || The Actual Date From The Grid : " + Grid_Extention_Date
									+ " || And The Container Number is : " + numbers.get(i));
							extent_fail(driver,
									"Not Matched || The Expected Date Given From The Test Data : " + Expected_Date
											+ " || The Actual Date From The Grid : " + Grid_Extention_Date
											+ " || And The Container Number is : " + numbers.get(i),
									test, test1);
						}
						Step_End(26,
								"Verify that Extension Date Reflected in Detention Request End Date Column",
								test, test1);
					}
				}
			}
			Extent_call(test, test1, "** Issue Mode End   **");

		}

		if (Delete_Invoice.equalsIgnoreCase("Yes")) {
			
			Extent_cal(test, test1, "If import invoice is in draft status Delete import invoice");
			if (Invoice_Save_Type.equalsIgnoreCase("Issue")) {
				Invoice_Reversal(driver, InvoiceReversal_Module, BL_Condition, search_Type_Invoice_Reversal, BL_Number_input, invoiceReversalRemarks, invoiceReversedPopup);

			} else {
				
				scrollTop(driver);
				Import_Invoice_Draft_Delete(driver, Import_invoice_delete);
			}
		}
		Extent_completed(testcase_Name, test, test1);

		Extent_call(test, test1, "**If Import Invoice in draft Status, Kindly Delete it.  - End   **");

	}
}
