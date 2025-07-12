package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Import_Invoice_Locators;

public class TC_Import_Invoice_SC022 extends Keywords {

	public void Import_Invoice_SC022(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Import_Invoice_SC022";
		// Get data from test data
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Module_ImportInvoice = Excel_data.get("Module_ImportInvoice");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Search_Import_Document = Excel_data.get("Search_Import_Document");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String Customer_Type = Excel_data.get("Customer_Type");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Invoice_Save_Type = Excel_data.get("Invoice_Save_Type");
		String customer_Counts = Excel_data.get("customer_Counts");
		String Customer_edit_address = Excel_data.get("Customer_edit_address");
		String address1 = Excel_data.get("address1");
		String address2 = Excel_data.get("address2");
		String Customer_edit_address_Popup = Excel_data.get("Customer_edit_address_Popup").trim();
		String saved_pop = Excel_data.get("saved_pop");
		String import_Invoice_Delete = Excel_data.get("import_Invoice_Delete");
		String Headers = Excel_data.get("Headers");
		String customer_Address1_Inputs = Excel_data.get("customer_Address1_Inputs");
		String customer_Address2_Inputs = Excel_data.get("customer_Address2_Inputs");
		String updated_Popup = Excel_data.get("updated_Popup").trim();
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");


		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, username, password);

		// Switch Agency
		verifyMainMenu(driver);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, "open the import invoice module and click the new button", test, test1);

		moduleNavigate(driver, Module_ImportInvoice);

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
			waitForDisplay(driver, NewButton_ToolBar);

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

			globalValueSearchWindow1(driver, BL_Condition, Customer_Filter_Type, CustomerCode, "", "", "", "");

			if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
				waitForElement(driver, SystemCode_FilterInput);
				sendKeys(driver, SystemCode_FilterInput, Customer_Type);
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

		scrollTop(driver);
		if (Invoice_Save_Type.equalsIgnoreCase("New")) {

			Extent_call(test, test1, "** NEW Mode Start   **");

			List<String> headers = splitAndExpand(Headers, ",");
			List<String> Customer_Address1_Input = splitAndExpand(customer_Address1_Inputs, ",");
			List<String> Customer_Address2_Input = splitAndExpand(customer_Address2_Inputs, ",");
			List<String> customer_counts = splitAndExpand(customer_Counts, ",");

			for (int i = 0; i < customer_counts.size(); i++) {

				int count = Integer.parseInt(customer_counts.get(i));
				System.out.println("count : " + count);
				Step_Start(12, "Select the Customer code Want to change the address", test, test1);
				String customer_Edit = String.format(Import_Invoice_Locators.Edit_Grid_IN, customer_counts.get(i));
				waitForElement(driver, customer_Edit);
				click(driver, customer_Edit);
				Step_End(12, "Select the Customer code Want to change the address", test, test1);

				Step_Start(13, "right Click it and choose Edit Customer address option", test, test1);
				waitForElement(driver, customer_Edit);
				RightClick(driver, customer_Edit);
				String customer_address_Edit = String.format(Import_Invoice_Locators.Customer_Edit_Address,
						Customer_edit_address);
				waitForElement(driver, customer_address_Edit);
				click(driver, customer_address_Edit);
				Step_End(13, "right Click it and choose Edit Customer address option", test, test1);

				Step_Start(14, "Window will be Open Enter the Address 1 and Address 2 Details", test, test1);
				if (address1.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Customer_Address1);
					Newclear(driver, Customer_Address1);
					sendKeys(driver, Customer_Address1, Customer_Address1_Input.get(i));
				}

				if (address2.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Customer_Address2);
					Newclear(driver, Customer_Address2);
					sendKeys(driver, Customer_Address2, Customer_Address2_Input.get(i));
				}

				Step_End(14, "Window will be Open Enter the Address 1 and Address 2 Details", test, test1);

				Step_Start(15, "Click on Apply address button", test, test1);
				scrollUsingElement(driver, apply_Address_Button);
				waitForElement(driver, apply_Address_Button);
				click(driver, apply_Address_Button);

				Step_End(15, "Click on Apply address button", test, test1);

				Step_Start(16, "system shows msg as 'Do you want to edit the Customer Address?'Yes/NO click Yes button",
						test, test1);

				waitForPopup(driver, popup_Message, Customer_edit_address_Popup);

				String Customer_Code_edit_pop_act = getText(driver, popup_Message);
				System.out.println(Customer_Code_edit_pop_act);

				if (Customer_edit_address_Popup.equals(Customer_Code_edit_pop_act)) {
					System.out.println("Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act);
					Extent_pass_New(driver, "Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act, test, test1);
				} else {
					System.out.println("Not Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act);
					Extent_fail(driver, "Not Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act, test, test1);
				}

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			}
			Step_End(16, "system shows msg as 'Do you want to edit the Customer Address?'Yes/NO click Yes button", test,
					test1);

			Step_Start(17, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(17, "Click on save Button", test, test1);

			Step_Start(18, "Recevied Msg \"Import Invoice saved\".and click ok", test, test1);

			waitForPopup(driver, popup_Message, saved_pop);

			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			if (saved_pop.equals(import_saved_act)) {
				System.out
						.println("Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act, test,
						test1);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act, test,
						test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(18, "Recevied Msg \"Import Invoice saved\".and click ok", test, test1);

			Step_Start(19, "Verify that added add1 and add2 listed in Grid for the customers", test, test1);

			for (int i = 0; i < headers.size(); i++) {

				List<Map<String, String>> ImportInvoice_Tabledata1 = getTableData(driver, import_Invoice_header,
						import_Invoice_row);
				if (address1.equalsIgnoreCase("Yes")) {

				if (headers.get(i).equals("Address 1")) {
					for (int j = 0; j < Customer_Address1_Input.size(); j++) {
						int count = Integer.parseInt(customer_counts.get(j)) - 1;
						Map<String, String> address_Grid = getValueByRowAndHeaders(ImportInvoice_Tabledata1, count,
								headers);
						System.out.println(address_Grid);
						String Address = address_Grid.get(headers.get(i));
						if (Customer_Address1_Input.get(j).equalsIgnoreCase(Address)) {
							System.out.println("Matched || Expected Value in address1 : " + Customer_Address1_Input.get(j)
									+ " || Actual Value in address1 : " + Address);
							Extent_pass_New(driver, "Matched || Expected Value in address1 : " + Customer_Address1_Input.get(j)
									+ " || Actual Value in address1 : " + Address, test, test1);

						} else {

							System.out.println("Not Matched || Expected Value in address1 : " + Customer_Address1_Input.get(j)
									+ " || Actual Value in address1 : " + Address);
							Extent_fail(driver, "Not Matched || Expected Value in address1 : " + Customer_Address1_Input.get(j)
									+ " || Actual Value in address1 : " + Address, test, test1);

						}

					}
				}
				}
				if (address2.equalsIgnoreCase("Yes")) {

				if (headers.get(i).equals("Address 2/POBOX/City/PinCode/ZipCode/State/Country/Phone No/Fax No")) {
					for (int j = 0; j < Customer_Address2_Input.size(); j++) {
						int count = Integer.parseInt(customer_counts.get(j)) - 1;
						Map<String, String> address_Grid = getValueByRowAndHeaders(ImportInvoice_Tabledata1, count,
								headers);
						System.out.println(address_Grid);
						String Address = address_Grid.get(headers.get(i));
						if (Customer_Address2_Input.get(j).equalsIgnoreCase(Address)) {

							System.out.println("Matched || Expected Value in address2 : " + Customer_Address2_Input.get(j)
									+ " || Actual Value in address2 : " + Address);
							Extent_pass_New(driver, "Matched ||  Expected Value in address2 : " + Customer_Address2_Input.get(j)
									+ " || Actual Value in address2 : " + Address, test, test1);

						} else {

							System.out.println("Not Matched ||  Expected Value in address2 : " + Customer_Address2_Input.get(j)
									+ " || Actual Value in address2 : " + Address);
							Extent_fail(driver, "Not Matched ||  Expected Value in address2 : " + Customer_Address2_Input.get(j)
									+ " || Actual Value in address2 : " + Address, test, test1);

						}

					}
				}
			}
			}

			Step_End(19, "Verify that added add1 and add2 listed in Grid for the customers", test, test1);

			
			Import_Invoice_Draft_Delete(driver, import_Invoice_Delete);
			
			Step_End(20, "Delete Import Invoice", test, test1);

		} else if (Invoice_Save_Type.equalsIgnoreCase("Draft")) {

			Extent_call(test, test1, "** DRAFT Mode Start   **");

			Step_Start(5, "select the draft and click the save button in tool bar", test, test1);
			scrollTop(driver);
			waitForElement(driver, importInvoice_Draft_Button);
			click(driver, importInvoice_Draft_Button);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "select the draft and click the save button in tool bar", test, test1);

			Step_Start(6, "system has validate import invoice saved", test, test1);

			waitForPopup(driver, popup_Message, saved_pop);

			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			if (saved_pop.equals(import_saved_act)) {
				System.out
						.println("Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act, test,
						test1);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + saved_pop + " || Actual Popup : " + import_saved_act, test,
						test1);
			}

			Step_End(6, "system has validate import invoice saved", test, test1);
			Step_Start(7, "click ok", test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(7, "click ok", test, test1);

			Step_Start(8, "Click on Edit Button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			Step_End(8, "Click on Edit Button", test, test1);

			List<String> headers = splitAndExpand(Headers, ",");
			List<String> Customer_Address1_Input = splitAndExpand(customer_Address1_Inputs, ",");
			List<String> Customer_Address2_Input = splitAndExpand(customer_Address2_Inputs, ",");
			List<String> customer_counts = splitAndExpand(customer_Counts, ",");
			for (int i = 0; i < customer_counts.size(); i++) {
				int count = Integer.parseInt(customer_counts.get(i));
				System.out.println("count : " + count);
				Step_Start(9, "Select the Customer code Want to change the address", test, test1);
				String customer_Edit = String.format(Import_Invoice_Locators.Edit_Grid_IN, customer_counts.get(i));
				waitForElement(driver, customer_Edit);
				click(driver, customer_Edit);
				Step_End(9, "Select the Customer code Want to change the address", test, test1);

				Step_Start(10, "right Click it and choose Edit Customer address option", test, test1);
				waitForElement(driver, customer_Edit);
				RightClick(driver, customer_Edit);
				String customer_address_Edit = String.format(Import_Invoice_Locators.Customer_Edit_Address,
						Customer_edit_address);
				waitForElement(driver, customer_address_Edit);
				click(driver, customer_address_Edit);

				Step_End(10, "right Click it and choose Edit Customer address option", test, test1);

				Step_Start(11, "Window will be Open Enter the Address 1 and Address 2 Details", test, test1);

				if (address1.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Customer_Address1);
					Newclear(driver, Customer_Address1);
					sendKeys(driver, Customer_Address1, Customer_Address1_Input.get(i));

				}

				if (address2.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Customer_Address2);
					Newclear(driver, Customer_Address2);
					sendKeys(driver, Customer_Address2, Customer_Address2_Input.get(i));

				}

				Step_End(11, "Window will be Open Enter the Address 1 and Address 2 Details", test, test1);

				Step_Start(12, "Click on Apply address button", test, test1);

				scrollUsingElement(driver, apply_Address_Button);
				waitForElement(driver, apply_Address_Button);
				click(driver, apply_Address_Button);

				Step_End(12, "Click on Apply address button", test, test1);

				Step_Start(13, "system shows msg as 'Do you want to edit the Customer Address?'Yes/NO click Yes button",
						test, test1);

				waitForPopup(driver, popup_Message, Customer_edit_address_Popup);

				String Customer_Code_edit_pop_act = getText(driver, popup_Message);
				System.out.println(Customer_Code_edit_pop_act);

				if (Customer_edit_address_Popup.equals(Customer_Code_edit_pop_act)) {
					System.out.println("Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act);
					Extent_pass_New(driver, "Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act, test, test1);
				} else {
					System.out.println("Not Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act);
					Extent_fail(driver, "Not Matched || Expected Popup : " + Customer_edit_address_Popup
							+ " || Actual Popup : " + Customer_Code_edit_pop_act, test, test1);
				}

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			}

			Step_End(13, "system shows msg as 'Do you want to edit the Customer Address?'Yes/NO click Yes button", test,
					test1);

			Step_Start(14, "Click on save Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(14, "Click on save Button", test, test1);

			Step_Start(15, "Recevied Msg \"Import Invoice Updated\".and click ok", test, test1);

			waitForPopup(driver, popup_Message, updated_Popup);
			String import_saved_act1 = getText(driver, popup_Message);
			System.out.println(import_saved_act1);
			if (updated_Popup.equals(import_saved_act1)) {
				System.out.println(
						"Matched || Expected Popup : " + updated_Popup + " || Actual Popup : " + import_saved_act1);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + updated_Popup + " || Actual Popup : " + import_saved_act1,
						test, test1);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + updated_Popup + " || Actual Popup : " + import_saved_act1);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + updated_Popup + " || Actual Popup : " + import_saved_act1,
						test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(15, "Recevied Msg \"Import Invoice Updated\".and click ok", test, test1);
			Step_Start(16, "Verify that added add1 and add2 listed in Grid for the customers", test, test1);

			for (int i = 0; i < headers.size(); i++) {

				List<Map<String, String>> ImportInvoice_Tabledata1 = getTableData(driver, import_Invoice_header,
						import_Invoice_row);
				if (address1.equalsIgnoreCase("Yes")) {

				if (headers.get(i).equals("Address 1")) {
					for (int j = 0; j < Customer_Address1_Input.size(); j++) {
						int count = Integer.parseInt(customer_counts.get(j)) - 1;
						Map<String, String> address_Grid = getValueByRowAndHeaders(ImportInvoice_Tabledata1, count,
								headers);
						System.out.println(address_Grid);
						String Address = address_Grid.get(headers.get(i));
						if (Customer_Address1_Input.get(j).equalsIgnoreCase(Address)) {
							System.out.println("Given data's are added in the grid || Expected Value in address1 : "
									+ Customer_Address1_Input.get(j) + " || Actual Value in address1 : " + Address);
							Extent_pass_New(driver,
									"Given data's are added in the grid || Expected Value in address1 : "
											+ Customer_Address1_Input.get(j) + " || Actual Value in address1 : " + Address,
									test, test1);

						} else {

							System.out.println("Given data's are not added in the grid || Expected Value in address1 : "
									+ Customer_Address1_Input.get(j) + " || Actual Value in address1 : " + Address);
							Extent_fail(driver,
									"Given data's are not added in the grid ||Expected Value in address1 : "
											+ Customer_Address1_Input.get(j) + " ||Actual Value in address1 : " + Address,
									test, test1);

						}

					}
				}
				}
				if (address2.equalsIgnoreCase("Yes")) {

				if (headers.get(i).equals("Address 2/POBOX/City/PinCode/ZipCode/State/Country/Phone No/Fax No")) {
					for (int j = 0; j < Customer_Address2_Input.size(); j++) {
						int count = Integer.parseInt(customer_counts.get(j)) - 1;
						Map<String, String> address_Grid = getValueByRowAndHeaders(ImportInvoice_Tabledata1, count,
								headers);
						System.out.println(address_Grid);
						String Address = address_Grid.get(headers.get(i));
						if (Customer_Address2_Input.get(j).equalsIgnoreCase(Address)) {

							System.out.println("Given data's are added in the grid ||  Expected Value in address2 : "
									+ Customer_Address2_Input.get(j) + " || Actual Value in address2 : " + Address);
							Extent_pass_New(driver,
									"Given data's are added in the grid || Expected Value in address2 : "
											+ Customer_Address2_Input.get(j) + " || Actual Value in address2 : " + Address,
									test, test1);

						} else {

							System.out.println("Not Matched ||  Expected Value in address2 : " + Customer_Address2_Input.get(j)
									+ " ||Actual Value in address2 : " + Address);
							Extent_fail(driver, "Not Matched ||  Expected Value in address2 : " + Customer_Address2_Input.get(j)
									+ " || Actual Value in address2 : " + Address, test, test1);

						}

					}
				}
			}
			}
			Step_End(16, "Verify that added add1 and add2 listed in Grid for the customers", test, test1);
			Step_Start(17, "Delete Import Invoice", test, test1);

			Import_Invoice_Draft_Delete(driver, import_Invoice_Delete);


			Step_End(17, "Delete Import Invoice", test, test1);

		}

		Extent_completed(testCaseName, test, test1);

	}

}
