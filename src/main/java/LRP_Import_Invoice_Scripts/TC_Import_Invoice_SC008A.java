package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC008A extends Keywords {

	public void Import_Invoice_SC008A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC008A";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Import_Invoice_Module = Excel_data.get("Import_Invoice_Module");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Invoice_saved_pop = Excel_data.get("Invoice_saved_pop");
		String Charges_Based_Header = Excel_data.get("Charges_Based_Header");
		String Storage_Amount_Headers_Invoice = Excel_data.get("Storage_Amount_Headers_Invoice");
		String Detention_Amount_Headers_Invoice = Excel_data.get("Detention_Amount_Headers_Invoice");
		String Detention_Demurrage_Module = Excel_data.get("Detention_Demurrage_Module");
		String Detention_Select_value = Excel_data.get("Detention_Select_value");
		String Detention_BL_Condition = Excel_data.get("Detention_BL_Condition");
		String Select_Extension = Excel_data.get("Select_Extension");
		String Selection_Type = Excel_data.get("Selection_Type");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Radio_button = Excel_data.get("Radio_button");
		String Date = Excel_data.get("Date");
		String NumberOfDays = Excel_data.get("NumberOfDays");
		String Container_number = Excel_data.get("Container_number");
		String Save_popup = Excel_data.get("Save_popup");
		String Detention_ContainerHeader = Excel_data.get("Detention_ContainerHeader");
		String Reversal_Condition = Excel_data.get("Reversal_Condition");
		String Delete_Storage_Popup = Excel_data.get("Delete_Storage_Popup");
		String Storage_delete_Success = Excel_data.get("Storage_delete_Success");
		String Detention_Delete_Storage_Popup = Excel_data.get("Detention_Delete_Storage_Popup");
		String Detention_Storage_delete_Success = Excel_data.get("Detention_Storage_delete_Success");
		String Customer_Code = Excel_data.get("Customer_Code");
		String customer_code_select = Excel_data.get("customer_code_select");
		String Columns = Excel_data.get("Columns");
		String Delete_Import_Invoice = Excel_data.get("Delete_Import_Invoice");
		String Delete_Detention_Demurrage = Excel_data.get("Delete_Detention_Demurrage");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");


		Extent_cal(test, test1, "To Save Extention to import agency");

		Extent_Start(testcase_Name, test, test1);

		Step_Start(1, "switch to import agency ", test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to import agency ", test, test1);

		Step_Start(2, "open the Detention Demurrage Extension module", test, test1);

		moduleNavigate(driver, Detention_Demurrage_Module);
		Step_End(2, "open the Detention Demurrage Extension module", test, test1);

		Step_Start(3, "click the new button", test, test1);

		newButton(driver);

		Step_End(3, "click the new button", test, test1);

		Step_Start(4, "retrive the bl in bl number search field ", test, test1);

		Step_Start(5, "search  and select the bl no,", test, test1);

		waitForElement(driver, Detention_BLSearch);
		click(driver, Detention_BLSearch);

		globalValueSearchWindow(driver, Detention_BL_Condition, Detention_Select_value, BL_Number_input, "",
				"", "", "");

		Step_End(4, "retrive the bl in bl number search field ", test, test1);

		Step_End(5, "search  and select the bl no,", test, test1);

		Step_Start(5, ".A Select Storage Extension/DO Extension option(It has to be refer from test Data),", test,
				test1);

		String SelectOption = String.format(SelectTab, Select_Extension);

		waitForElement(driver, SelectOption);
		click(driver, SelectOption);
		Step_End(5, ".A Select Storage Extension/DO Extension option(It has to be refer from test Data),", test, test1);

		Step_Start(6, "Click on show Button", test, test1);

		waitForElement(driver, Detention_Show);
		click(driver, Detention_Show);

		if (isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
		}

		if (verifyElementHasText(driver, ContainerNo_Column)) {
			System.out.println(
					"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab");
			Extent_pass_New(driver,
					"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab",
					test, test1);

		} else {
			System.out.println(
					"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab");
			Extent_fail(driver,
					"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab",
					test, test1);
		}

		Step_End(6, "Click on show Button", test, test1);

		Step_Start(7,
				"Choose All/Selected Container(Pass container from Test Data and select it multiple container can be allow) Option",
				test, test1);
		
		String Select_containeroption = String.format(SelectTab, Selection_Type);
		waitForElement(driver, Select_containeroption);
		click(driver, Select_containeroption);
		
		List<String> containersList;
		List<Map<String, String>> DetentionTable = getTableData(driver, Detention_Table_Header, Detention_Table_Row);
		if (Selection_Type.equalsIgnoreCase("All")) {
			containersList = getTableHeaderCellList(DetentionTable, Detention_ContainerHeader);
		} else {
			containersList = splitAndExpand(Container_number);
		}

		
		Step_End(7,
				"Choose All/Selected Container(Pass container from Test Data and select it multiple container can be allow) Option",
				test, test1);

		Step_Start(8, "Select DAte/Days Radio Button (It has to be refer from test Data)", test, test1);

		if (Radio_button.equals("Date")) {

			waitForElement(driver, Date_button);
			click(driver, Date_button);

			waitForElement(driver, Calendar_field);
			if (Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, Calendar_field, Date);
			} else {
				waitForElement(driver, Calendar_field);
				click(driver, Calendar_field);
				Newclear(driver, Calendar_field);
				sendKeys(driver, Calendar_field, Date);
				enter(driver);
			}

		} else if (Radio_button.equals("Days")) {
			waitForElement(driver, Days_button);
			click(driver,Days_button);
			
			waitForElement(driver, Days_Input);
			click(driver, Days_Input);
			sendKeys(driver, Days_Input, NumberOfDays);
		}

		Step_End(8, "Select Date/Days Radio Button (It has to be refer from test Data)", test, test1);

		Step_Start(9, "click on (+) Button,(Capture Extended Validity and Net AMT)", test, test1);

		List<String> Container_costs = new ArrayList<String>();

		if (Selection_Type.equals("Selected Containers")) {
			for (String container : containersList) {

				String container_selector = String.format(Select_container, container);
				waitForElement(driver, container_selector);
				click(driver, container_selector);

			}
		}

		waitForElement(driver, Plus_button);
		click(driver, Plus_button);

		if (isdisplayed(driver, detentionTab_No)) {
			click(driver, detentionTab_No);
		}

		waitForElement(driver, Filter_column);
		click(driver, Filter_column);

		jsClick(driver, Deselect_all);

		List<String> Columnlist = splitAndExpand(Columns);

		for (String columns_list : Columnlist) {
			waitForElement(driver, Filter_column_input);
			clearAndType1(driver, Filter_column_input, columns_list);
			enter(driver);
		}

		if (Selection_Type.equals("Selected Containers")) {
			for (String container : containersList) {

				String Containers_cost = String.format(Container_cost, container);
				String costs = getText(driver, Containers_cost);
				Container_costs.add(costs);

			}
		}

		Step_End(9, "click on (+) Button,(Capture Extended Validity and Net AMT)", test, test1);

		Step_Start(10, "CLick on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		String popup_message="";
		waitForDisplay(driver, Popup_Message);
		if(isdisplayed(driver, Popup_Message)) {
			waitForPopup(driver, Popup_Message, Save_popup);
			 popup_message = getText(driver, Popup_Message);
		}

		if (isdisplayed(driver, DTE_Save_Yes)) {
			waitForElement(driver, DTE_Save_Yes);
			click(driver, DTE_Save_Yes);
		}
		waitForDisplay(driver, Popup_Message);
		if(isdisplayed(driver, Popup_Message)) {
			waitForPopup(driver, Popup_Message, Save_popup);
			 popup_message = getText(driver, Popup_Message);
		}
		if (isdisplayed(driver, Save_yes)) {
			waitForElement(driver, Save_yes);
			click(driver, Save_yes);
		}

		waitForDisplay(driver, Popup_Message);
		if(isdisplayed(driver, Popup_Message)) {
			waitForPopup(driver, Popup_Message, Save_popup);
			 popup_message = getText(driver, Popup_Message);
		}

		if (popup_message.equals(Save_popup)) {
			System.out.println("Matched || Expected popup : " + Save_popup + " || Actual popup : " + popup_message);
			Extent_pass_New(driver, "Matched || Expected popup : " + Save_popup + " || Actual popup : " + popup_message,
					test, test1);

		} else {
			System.out.println("Not Matched || Expected popup : " + Save_popup + " || Actual popup : " + popup_message);
			Extent_fail(driver, "Not Matched || Expected popup : " + Save_popup + " || Actual popup : " + popup_message,
					test, test1);
		}

		Step_End(10, "CLick on save button", test, test1);

		Step_Start(11, "Close the Module", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(11, "Close the Module", test, test1);


		Step_Start(12, "Open Import invoice module", test, test1);

		moduleNavigate(driver, Import_Invoice_Module);

		Step_End(12, "Open Import invoice module", test, test1);

		Step_Start(13, "Click new button and load the BL NO using By BL/ By VS", test, test1);

		newButton(driver);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
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
							

		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
			waitForDisplay(driver, By_Vessel_Btn);
			click(driver, By_Vessel_Btn);

			waitForElement(driver, service_Txtfield_IN);
			sendKeys(driver, service_Txtfield_IN, Service_Code);
			
			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, Vessel_Code);
			
			
			waitForElement(driver, vessels_code_input);
			sendKeys(driver, voyage_code_input, Voyage_Number);
			
			waitForElement(driver, vessels_code_input);
			sendKeys(driver, bounnd_code_input, Bound_Input);
			
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);

			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);

			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow(driver, BL_Condition, Customer_Code, customer_code_select, "", "", "", "");

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

		scrollBottom(driver);

		Step_End(13, "Click new button and load the BL NO using By BL/ By VS", test, test1);

		Step_Start(14, "Go to Detention/Extendion CHarges tab", test, test1);

		List<Map<String, String>> ChargesTabValues;

		if (Select_Extension.contains("Storage Extension")) {
			waitForElement(driver, port_storage_charges_Tab_IN);
			click(driver, port_storage_charges_Tab_IN);

			
			waitForElement(driver, portStorageCharges_Table_Columns_IN);
			ChargesTabValues = getTableData(driver, portStorageCharges_Table_Columns_IN,
					portStorageCharges_Table_Rows_IN);
		} else {
			waitForElement(driver, Detention_Charges_Tab_IN);
			click(driver, Detention_Charges_Tab_IN);
			

			waitForElement(driver, detentionCharges_Table_Columns_IN);
			ChargesTabValues = getTableData(driver, detentionCharges_Table_Columns_IN, detentionCharges_Table_Rows_IN);
		}

		Step_End(14, "Go to Detention CHarges tab", test, test1);

		Step_Start(15, "END data has to be listed according to the containers", test, test1);

		List<String> columnheaders = new ArrayList<String>();
		if (Select_Extension.equals("Storage Extension(S)")) {
			columnheaders = splitAndExpand(Storage_Amount_Headers_Invoice);
		} else {
			columnheaders = splitAndExpand(Detention_Amount_Headers_Invoice);
		}

		Map<String, List<String>> AmountValuesExp = getValuesByID(ChargesTabValues, Charges_Based_Header,
				containersList, columnheaders);

		int i = 0;

		if (Selection_Type.equals("Selected Containers")) {
			for (String container : containersList) {

				List<String> values = AmountValuesExp.get(container);

				String Amount = values.get(0);
				String Expected_amount = Container_costs.get(i);

				if (Radio_button.equals("Date")) {
					String ActualDate = values.get(1);

					if (ActualDate.equals(Date)) {

						System.out.println("Containers are added with expected detention date || Expected Detention date : "
								+ Date + " || Actual Detention date : " + ActualDate);
						Extent_pass_New(driver,
								"Containers are added with expected detention date  || Expected Detention date : " + Date
										+ " || Actual Detention date : " + ActualDate,
								test, test1);
					} else {
						System.out.println(
								"Containers are not added with expected detention date  || Expected Detention date : "
										+ Date + " || Actual Detention date : " + ActualDate);
						Extent_fail(driver,
								"Containers are not added with expected detention date  || Expected Detention date : "
										+ Date + " || Actual Detention date : " + ActualDate,
								test, test1);
					}
				}
				

				if (Amount.equals(Expected_amount)) {
					System.out.println("Containers are added with expected Amount  || Expected Net amount : " + Expected_amount
							+ " || Actual Net amount : " + Amount);
					Extent_pass_New(driver, "Containers are added with expected Amount || Expected Net amount : " + Expected_amount
							+ " || Actual Net amount : " + Amount, test, test1);
				} else {
					System.out.println("Containers are not added with expected Amount || Expected Net amount : " + Expected_amount
							+ " || Actual Net amount : " + Amount);
					Extent_fail(driver, "Containers are not added with expected Amount || Expected Net amount : " + Expected_amount
							+ " || Actual Net amount : " + Amount, test, test1);
				}

				i++;
			}

		
		}
		Step_End(15, "END data has to be listed according to the containers", test, test1);

		scrollTop(driver);


			Step_Start(16, "Click on save Button", test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Invoice_saved_pop);

			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			if (Invoice_saved_pop.equals(import_saved_act)) {
				System.out.println(
						"Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act,
						test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : "
						+ import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : "
						+ import_saved_act, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(16, "Click on save Button", test, test1);
		
			
			Extent_pass_New(driver, "Expected : Import invoice should be save in Draft status with  Extention detail ||  Actual : Import invoice saved in Draft status with  Extention detail ", test, test1);
			
			Import_Invoice_Draft_Delete(driver, Delete_Import_Invoice);
			
			
			Extent_cal(test, test1, "Delete the detension");

			if(Delete_Detention_Demurrage.equalsIgnoreCase("Yes")) {
			moduleNavigate(driver, Detention_Demurrage_Module);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, Reversal_Condition, Detention_Select_value, BL_Number_input, "", "", "",
					"");

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			if (Select_Extension.contains("Storage Extension")) {

				waitForPopup(driver, popup_Message, Delete_Storage_Popup);

				String StorageDeleteMessage = getText(driver, popup_Message);

				if (StorageDeleteMessage.contains(Delete_Storage_Popup)) {
					System.out.println("Matched || Expected popup : " + Delete_Storage_Popup + "  || Actual popup : "
							+ StorageDeleteMessage);
					Extent_pass_New(driver, "Matched || Expected popup : " + Delete_Storage_Popup + "  || Actual popup : "
							+ StorageDeleteMessage, test, test1);
					waitForElement(driver, popup_Message_Yes_Button);
					click(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("Matched || Expected popup : " + Delete_Storage_Popup + "  || Actual popup : "
							+ StorageDeleteMessage);
					Extent_fail(driver, "Not Matched || Expected popup : " + Delete_Storage_Popup
							+ "  || Actual popup : " + StorageDeleteMessage, test, test1);
				}

				waitForPopup(driver, Popup_Message, Storage_delete_Success);

				String popup_messagedelete = getText(driver, Popup_Message);
				if (popup_messagedelete.contains(Storage_delete_Success)) {
					System.out.println("Matched || Expected popup : " + Storage_delete_Success + " Actual popup : "
							+ Storage_delete_Success);
					Extent_pass_New(driver, "Matched || Expected popup : " + Storage_delete_Success + " Actual popup : "
							+ Storage_delete_Success, test, test1);

				} else {
					System.out.println("Not Matched || Expected popup : " + Storage_delete_Success + " Actual popup : "
							+ Storage_delete_Success);
					Extent_fail(driver, "Not Matched || Expected popup : " + Storage_delete_Success + " Actual popup : "
							+ Storage_delete_Success, test, test1);
				}

			} else {

				waitForPopup(driver, popup_Message, Detention_Delete_Storage_Popup);

				String StorageDeleteMessage = getText(driver, popup_Message);

				if (StorageDeleteMessage.contains(Detention_Delete_Storage_Popup)) {
					System.out.println("Matched || Expected : " + Detention_Delete_Storage_Popup + "  || Actual : "
							+ StorageDeleteMessage);
					Extent_pass_New(driver, "Matched || Expected : " + Detention_Delete_Storage_Popup + "  || Actual : "
							+ StorageDeleteMessage, test, test1);
					waitForElement(driver, popup_Message_Yes_Button);
					click(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("Matched || Expected : " + Detention_Delete_Storage_Popup + "  || Actual : "
							+ StorageDeleteMessage);
					Extent_fail(driver, "Not Matched || Expected : " + Detention_Delete_Storage_Popup + "  || Actual : "
							+ StorageDeleteMessage, test, test1);
				}

				waitForPopup(driver, Popup_Message, Detention_Storage_delete_Success);

				String popup_messagedelete = getText(driver, Popup_Message);
				if (popup_messagedelete.contains(Detention_Storage_delete_Success)) {
					System.out.println("Matched || Expected popup is : " + Detention_Storage_delete_Success
							+ " || Actual popup is : " + popup_messagedelete);
					Extent_pass_New(driver, "Matched || Expected popup is : " + Detention_Storage_delete_Success
							+ " || Actual popup is : " + popup_messagedelete, test, test1);

				} else {
					System.out.println("Not Matched || Expected popup is : " + Detention_Storage_delete_Success
							+ " || Actual popup is : " + popup_messagedelete);
					Extent_fail(driver, "Not Matched || Expected popup is : " + Detention_Storage_delete_Success
							+ " || Actual popup is : " + popup_messagedelete, test, test1);

				}

			}

			}
			
			
			Extent_completed(testcase_Name, test, test1);
			
			
	}

}
