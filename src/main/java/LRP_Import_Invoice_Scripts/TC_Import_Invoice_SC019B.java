package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC019B extends Keywords{
	public void Import_Invoice_SC019B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC019B";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String uls_module = Excel_data.get("uls_module");
		String uls_textfield_data = Excel_data.get("uls_textfield_data");
		String checkbox_click = Excel_data.get("checkbox_click");
		String select_attributes = Excel_data.get("select_attributes");
		String uls_header = Excel_data.get("uls_header");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Search_Import_Document = Excel_data.get("Search_Import_Document");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Tab_Name_II = Excel_data.get("Tab_Name_II");
		String CustomerCode = Excel_data.get("Customer_Code");
		String Customer_Code_from_Import_Doc = Excel_data.get("Customer_Code_from_Import_Doc");
		String Manifest_Charge_Codes = Excel_data.get("Manifest_Charge_Codes");
		String New_Invoice_Number_Popup = Excel_data.get("New_Invoice_Number_Popup");
		String uls_Remove_Newly_Added_Attributes = Excel_data.get("uls_Remove_Newly_Added_Attributes");
		String Non_Manifest_Charge_Codes = Excel_data.get("Non_Manifest_Charge_Codes");
		String User_Condition = Excel_data.get("User_Condition");
		String UserLevel_Header = Excel_data.get("UserLevel_Header");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");

		

		Actions action = new Actions(driver);
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, uls_module);

		waitForElement(driver, user_search_icon_uls);
		click(driver, user_search_icon_uls);

		twoColumnSearchWindow(driver, UserLevel_Header, User_Condition, username);

		waitForElement(driver, edit_btn_uls);
		click(driver, edit_btn_uls);

		waitForElement(driver, uls_textfield);
		sendKeys(driver, uls_textfield, uls_textfield_data);

		waitForElement(driver, imp_inv_checkbox_uls);

		checkBox(driver, imp_inv_checkbox_uls, checkbox_click);

		waitForElement(driver, privileage_table_headers);
		List<Map<String, String>> privileage_table = getTableData(driver, privileage_table_headers,
				privileage_table_rows);

		List<String> privilege_codes = getValuesByHeader(privileage_table, uls_header);
		List<String> attributes = splitAndExpand(select_attributes);

		List<String> notInPrivilegeCodes = new ArrayList<>();

		for (String attribute : attributes) {
			if (!privilege_codes.contains(attribute)) {
				notInPrivilegeCodes.add(attribute);
			}
		}

		System.out.println("The attributes not available in privilege_codes are: " + notInPrivilegeCodes);

		if (notInPrivilegeCodes != null && !notInPrivilegeCodes.isEmpty()) {
			click(driver, privileage_Add_icon_uls);
			for (int i = 0; i < notInPrivilegeCodes.size(); i++) {

				String privileage_code = String.format(privileage_codes, notInPrivilegeCodes.get(i));
				mouseOverToElement(driver, privileage_code);
				click1(driver, privileage_code);

			}
			click(driver, select_Button);
		} else {
			System.out.println("No attributes to process. Skipping the loop");
			Extent_cal(test, test1, "No attributes to process, Skipping the loop");

		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

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

			sendKeys(driver, vessels_code_input, Vessel_Code);
			sendKeys(driver, voyage_code_input, Voyage_Number);
			sendKeys(driver, bounnd_code_input, Bound_Input);
			sendKeys(driver, PortCode_Input, Port_Code);

			horizontalscroll(driver, By_Vessel_Scroll, 500);  if(!Terminal_Code_Input.equals("")) {
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

			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, CustomerCode, "", "", "",
					"");

			Step_Start(7, "select the serive ,vessel and voyage details for that bl", test, test1);
			if (Customer_Code_from_Import_Doc.equalsIgnoreCase("Yes")) {
				Step_Start(8, "before click the customer field go the import documentation module", test, test1);

				moduleNavigate(driver, Search_Import_Document);
				Step_End(8, "before click the customer field go the import documentation module", test, test1);

				Step_Start(9,
						"retrieve the same bl and go to the customer tab --copy the consignee customer code or name ",
						test, test1);
				if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_BL")) {

					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);

					globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type_Import_Doc, BL_Number_input, "", "",
							"", "");

				} else if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_Service")) {

					newButton(driver);
					waitForElement(driver, ID_servicename);
					sendKeys(driver, ID_servicename, Service_Code);

					sendKeys(driver, ID_grid_vesselcode, Vessel_Code);
					sendKeys(driver, ID_grid_voyagecode, Voyage_Number);
					sendKeys(driver, ID_grid_bound, Bound_Input);
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

				waitForElement(driver, customer_code_copy);
				CustomerCode = getText(driver, customer_code_copy);

				scrollTop(driver);
				
				waitForElement(driver, II_first_tab_inside_click);
				click(driver, II_first_tab_inside_click);
				
				Step_End(9,
						"retrieve the same bl and go to the customer tab --copy the consignee customer code or name ",
						test, test1);
				
				Step_Start(11, "load the same Customer and click on SHow BL button, ", test, test1);
				
				Step_Start(10, "click the customer field and put the CN code or name ", test, test1);
				
				waitForElement(driver, customer_Search_Icon);
				click(driver, customer_Search_Icon);

				globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, CustomerCode, "", "",
						"", "");

				Step_End(10, "click the customer field and put the CN code or name ", test, test1);
				Step_End(11, "load the same Customer and click on SHow BL button, ", test, test1);

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
		}
		
		Extent_call(test, test1, "** DRAFT Mode Start   **");
		Step_Start(12, "click on save button, import invoice saved in draft status", test, test1);
		scrollTop(driver);
		waitForElement(driver, importInvoice_Draft_Button);
		click(driver, importInvoice_Draft_Button);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		Step_End(12, "click on save button, import invoice saved in draft status", test, test1);

		Step_Start(13, "Import invoice save msg received and click ok button", test, test1);

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
		Step_End(13, "Import invoice save msg received and click ok button", test, test1);

		Step_Start(14, "Click on edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		Step_End(14, "Click on edit button", test, test1);
		Step_Start(14,
				"Go to Manifest/Non Manifest/Detention charges /Storage charges Tab(Depends on Test Data selection)it can be multiple Selection as well",
				test, test1);
		if (!Customer_Code_from_Import_Doc.equalsIgnoreCase("Yes")) {
			Step_Start(15, "Click on Customer search button", test, test1);
			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			Step_End(15, "Click on Customer search button", test, test1);

			Step_Start(16, "Enter the Customer via Test Data and Add by click on + button it", test, test1);

			globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, CustomerCode, "", "",
					"", "");
		}
		waitForElement(driver, customer_add_Button);
		click(driver, customer_add_Button);
		Step_End(16, "Enter the Customer via Test Data and Add by click on + button it", test, test1);
		Step_Start(17,
				"Go to Manifest/Non Manifest/Detention charges /Storage charges Tab(Depends on Test Data selection)it can be multiple Selection as well",
				test, test1);
		List<String> Tab_Names = splitAndExpand(Tab_Name_II, ",");
		for (int i = 0; i < Tab_Names.size(); i++) {
			String tab_Select = String.format(import_Invoice_Tab, Tab_Names.get(i));
			waitForElement(driver, tab_Select);
			click(driver, tab_Select);
			Step_End(17,
					"Go to Manifest/Non Manifest/Detention charges /Storage charges Tab(Depends on Test Data selection)it can be multiple Selection as well",
					test, test1);
			if (Tab_Names.get(i).equals("Manifest Charges")) {
				Step_Start(18, "Select the charge codes it can be multiple as well", test, test1);
				List<String> Charge_Codes = splitAndExpand(Manifest_Charge_Codes, ",");
				for (int j = 0; j < Charge_Codes.size(); j++) {
					String charge_Code_Select = String.format(manifest_Charge_Code, Charge_Codes.get(j));
					waitForElement(driver, charge_Code_Select);
					click(driver, charge_Code_Select);
					Step_End(18, "Select the charge codes it can be multiple as well", test, test1);
					Step_Start(19, "right click and select the newly added customer based category", test, test1);
					waitForElement(driver, charge_Code_Select);
					RightClick(driver, charge_Code_Select);
					String customer_Select = String.format(select_Customer, CustomerCode);
					waitForElement(driver, customer_Select);
					click1(driver, customer_Select);
					Step_End(19, "right click and select the newly added customer based category", test, test1);
					Step_Start(20, "make sure that newly assign charge code moved to recently added customer", test,
							test1);
					waitForElement(driver, manifest_Charges_Headers);
					List<Map<String, String>> manifest_Table_Data = getTableData(driver, manifest_Charges_Headers,
							II_manifest_Charges_Rows);
					String new_Customer_Code = getValueByFirstColumnAndHeader(manifest_Table_Data, "Charge Code",
							Charge_Codes.get(j), "Customer");
					if (CustomerCode.equals(new_Customer_Code)) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_pass_New(driver,
								"Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_fail(driver,
								"Not Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					}
					Step_End(20, "make sure that newly assign charge code moved to recently added customer", test,
							test1);
				}
			}
			if (Tab_Names.get(i).equals("Non Manifest")) {
				Step_Start(18, "Select the charge codes it can be multiple as well", test, test1);
				List<String> Charge_Codes = splitAndExpand(Non_Manifest_Charge_Codes, ",");
				for (int j = 0; j < Charge_Codes.size(); j++) {
					String charge_Code_Select = String.format(non_Manifest_Charge_Code, Charge_Codes.get(j));
					waitForElement(driver, charge_Code_Select);
					click(driver, charge_Code_Select);
					Step_End(18, "Select the charge codes it can be multiple as well", test, test1);
					Step_Start(19, "right click and select the newly added customer based category", test, test1);
					waitForElement(driver, charge_Code_Select);
					RightClick(driver, charge_Code_Select);
					String customer_Select = String.format(select_Customer, CustomerCode);
					waitForElement(driver, customer_Select);
					click1(driver, customer_Select);
					Step_End(19, "right click and select the newly added customer based category", test, test1);
					Step_Start(20, "make sure that newly assign charge code moved to recently added customer", test,
							test1);
					waitForElement(driver, non_Manifest_Charges_Headers);
					List<Map<String, String>> manifest_Table_Data = getTableData(driver,
							non_Manifest_Charges_Headers, non_Manifest_Charges_Rows);
					String new_Customer_Code = getValueByFirstColumnAndHeader(manifest_Table_Data, "Charge Code",
							Charge_Codes.get(j), "Customer");
					if (CustomerCode.equals(new_Customer_Code)) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_pass_New(driver,
								"Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_fail(driver,
								"Not Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					}
					Step_End(20, "make sure that newly assign charge code moved to recently added customer", test,
							test1);
				}

			}
			if (Tab_Names.get(i).equals("Detention Charges")) {
				Step_Start(18, "Select the charge codes it can be multiple as well", test, test1);
				waitForElement(driver, detention_Table_Rows);
				List<WebElement> detention_Rows = listOfElements(driver, detention_Table_Rows);
				for (int k = 1; k <= detention_Rows.size(); k++) {
					String row_Select = String.format(detention_Table_Row, k);
					waitForElement(driver, row_Select);
					click(driver, row_Select);
					waitForElement(driver, row_Select);
					click(driver, row_Select);
					Step_Start(19, "right click and select the newly added customer based category", test, test1);
					waitForElement(driver, row_Select);
					RightClick(driver, row_Select);
					Step_End(19, "right click and select the newly added customer based category", test, test1);
					Step_End(18, "Select the charge codes it can be multiple as well", test, test1);
					String customer_Select = String.format(select_Customer, CustomerCode);
					waitForElement(driver, customer_Select);
					click1(driver, customer_Select);

				}
				Step_Start(20, "make sure that newly assign charge code moved to recently added customer", test,
						test1);
				waitForElement(driver, detention_Table_Headers);
				waitForElement(driver, detention_Table_Headers);
				List<Map<String, String>> manifest_Table_Data = getTableData(driver, detention_Table_Headers,
						detention_Table_Rows);
				List<String> new_Customer_Codes = getValuesByHeader(manifest_Table_Data, "Customer");
				for (int j = 0; j < new_Customer_Codes.size(); j++) {
					if (CustomerCode.equals(new_Customer_Codes.get(j))) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_pass_New(driver, "Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_fail(driver, "Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					}
				}
				Step_End(20, "make sure that newly assign charge code moved to recently added customer", test,
						test1);

			}
			if (Tab_Names.get(i).equals("Port Storage Charges")) {
				Step_Start(18, "Select the charge codes it can be multiple as well", test, test1);
				List<WebElement> detention_Rows = listOfElements(driver, storage_Table_Rows);
				for (int k = 1; k <= detention_Rows.size(); k++) {
					String row_Select = String.format(storage_Table_Row, k);
					action.keyDown(Keys.CONTROL).build().perform();
					waitForElement(driver, row_Select);
					click(driver, row_Select);
					waitForElement(driver, row_Select);
					click(driver, row_Select);
					Step_Start(19, "right click and select the newly added customer based category", test, test1);
					waitForElement(driver, row_Select);
					RightClick(driver, row_Select);
					Step_End(19, "right click and select the newly added customer based category", test, test1);
					Step_End(18, "Select the charge codes it can be multiple as well", test, test1);
					String customer_Select = String.format(select_Customer, CustomerCode);
					waitForElement(driver, customer_Select);
					click1(driver, customer_Select);

				}

				Step_Start(20, "make sure that newly assign charge code moved to recently added customer", test,
						test1);
				waitForElement(driver, storage_Table_Headers);
				List<Map<String, String>> manifest_Table_Data = getTableData(driver, storage_Table_Headers,
						storage_Table_Rows);
				List<String> new_Customer_Codes = getValuesByHeader(manifest_Table_Data, "Customer");
				for (int j = 0; j < new_Customer_Codes.size(); j++) {
					if (CustomerCode.equals(new_Customer_Codes.get(j))) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_pass_New(driver, "Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_fail(driver, "Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					}
				}
				Step_End(20, "make sure that newly assign charge code moved to recently added customer", test,
						test1);
			}
		}

		Step_Start(21, "Click on save button", test, test1);

		scrollTop(driver);
		waitForElement(driver, importInvoice_Draft_Button);
		click(driver, importInvoice_Draft_Button);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		Step_End(21, "Click on save button", test, test1);
		Step_Start(22,
				"system shows this msg\"Draft Invoice Numbers will change to New Invoice Number for this new allocation. Do you want to proceed further ? yes/No CLick on Yes button",
				test, test1);

		waitForPopup(driver, popup_Message, New_Invoice_Number_Popup);

		String import_act_popup = getText(driver, popup_Message);
		System.out.println(import_act_popup);

		if (New_Invoice_Number_Popup.trim().equals(import_act_popup.trim())) {
			System.out.println("Matched || Expected Popup : " + New_Invoice_Number_Popup + " || Actual Popup : "
					+ import_act_popup);
			Extent_pass_New(driver, "Matched || Expected Popup : " + New_Invoice_Number_Popup + " || Actual Popup : "
					+ import_act_popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Popup : " + New_Invoice_Number_Popup + " || Actual Popup : "
					+ import_act_popup);
			Extent_fail(driver, "Not Matched || Expected Popup : " + New_Invoice_Number_Popup
					+ " || Actual Popup : " + import_act_popup, test, test1);
		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(22,
				"system shows this msg\"Draft Invoice Numbers will change to New Invoice Number for this new allocation. Do you want to proceed further ? yes/No CLick on Yes button",
				test, test1);

		Step_Start(23, "received  Import Invoice Saved msg click on okey button", test, test1);

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
		Step_End(23, "received  Import Invoice Saved msg click on okey button", test, test1);
		for (int i = 0; i < Tab_Names.size(); i++) {
			Step_Start(24, "Go to Manifest/Non Manifest/Detention charges /Storage charges Tab", test, test1);
			String tab_Select = String.format(import_Invoice_Tab, Tab_Names.get(i));
			waitForElement(driver, tab_Select);
			click(driver, tab_Select);
			Step_End(24, "Go to Manifest/Non Manifest/Detention charges /Storage charges Tab", test, test1);
			if (Tab_Names.get(i).equals("Manifest Charges")) {
				scrollBottom(driver);
				Extent_cal(test, test1,
						"Verify that changed charge codes are listed under the recently added customers - Start");
				List<String> Charge_Codes = splitAndExpand(Manifest_Charge_Codes, ",");
				for (int j = 0; j < Charge_Codes.size(); j++) {
					waitForElement(driver, manifest_Charges_Headers);
					List<Map<String, String>> manifest_Table_Data = getTableData(driver, manifest_Charges_Headers,
							II_manifest_Charges_Rows);
					String new_Customer_Code = getValueByFirstColumnAndHeader(manifest_Table_Data, "Charge Code",
							Charge_Codes.get(j), "Customer");
					if (CustomerCode.equals(new_Customer_Code)) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_pass_New(driver,
								"Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_fail(driver,
								"Not Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					}
				}
				Extent_cal(test, test1,
						"Verify that changed charge codes are listed under the recently added customers - End");
			}
			if (Tab_Names.get(i).equals("Non Manifest")) {
				List<String> Charge_Codes = splitAndExpand(Non_Manifest_Charge_Codes, ",");
				for (int j = 0; j < Charge_Codes.size(); j++) {
					scrollBottom(driver);
					Extent_cal(test, test1,
							"Verify that changed charge codes are listed under the recently added customers - Start");
					waitForElement(driver, non_Manifest_Charges_Headers);
					List<Map<String, String>> manifest_Table_Data = getTableData(driver,
							non_Manifest_Charges_Headers, non_Manifest_Charges_Rows);
					String new_Customer_Code = getValueByFirstColumnAndHeader(manifest_Table_Data, "Charge Code",
							Charge_Codes.get(j), "Customer");
					if (CustomerCode.equals(new_Customer_Code)) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_pass_New(driver,
								"Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Code + " For This Charge Code : "
								+ Charge_Codes.get(j));
						Extent_fail(driver,
								"Not Matched || Expected Customer Code : " + CustomerCode
										+ " || Actual Customer Code : " + new_Customer_Code
										+ " For This Charge Code : " + Charge_Codes.get(j),
								test, test1);
					}
				}
				Extent_cal(test, test1,
						"Verify that changed charge codes are listed under the recently added customers - End");

			}
			if (Tab_Names.get(i).equals("Detention Charges")) {
				scrollBottom(driver);
				Extent_cal(test, test1,
						"Verify that changed charge codes are listed under the recently added customers - Start");
				waitForElement(driver, detention_Table_Headers);
				List<Map<String, String>> manifest_Table_Data = getTableData(driver, detention_Table_Headers,
						detention_Table_Rows);
				List<String> new_Customer_Codes = getValuesByHeader(manifest_Table_Data, "Customer");
				for (int j = 0; j < new_Customer_Codes.size(); j++) {
					if (CustomerCode.equals(new_Customer_Codes.get(j))) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_pass_New(driver, "Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_fail(driver, "Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					}
				}
				Extent_cal(test, test1,
						"Verify that changed charge codes are listed under the recently added customers - End");

			}
			if (Tab_Names.get(i).equals("Port Storage Charges")) {
				scrollBottom(driver);
				Extent_cal(test, test1,
						"Verify that changed charge codes are listed under the recently added customers - Start");
				waitForElement(driver, storage_Table_Headers);
				List<Map<String, String>> manifest_Table_Data = getTableData(driver, storage_Table_Headers,
						storage_Table_Rows);
				List<String> new_Customer_Codes = getValuesByHeader(manifest_Table_Data, "Customer");
				for (int j = 0; j < new_Customer_Codes.size(); j++) {
					if (CustomerCode.equals(new_Customer_Codes.get(j))) {
						System.out.println("Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_pass_New(driver, "Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					} else {
						System.out.println("Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j));
						Extent_fail(driver, "Not Matched || Expected Customer Code : " + CustomerCode
								+ " || Actual Customer Code : " + new_Customer_Codes.get(j), test, test1);
					}
				}
				Extent_cal(test, test1,
						"Verify that changed charge codes are listed under the recently added customers - End");

			}
		}
		Extent_call(test, test1, "** DRAFT Mode End   **");
	
		scrollTop(driver);
		Import_Invoice_Draft_Delete(driver, Delete_Invoice);
		
		
		if (uls_Remove_Newly_Added_Attributes.equalsIgnoreCase("Yes")) {
			if (notInPrivilegeCodes.size() == 0) {
				System.out.println("New Attributes are Not Added in the User Level Security Module");
				Extent_pass_New(driver, "New Attributes are Not Added in the User Level Security Module", test, test1);
			} else {
				ResetProfile(driver);
				moduleNavigate(driver, uls_module);
				scrollTop(driver);
				waitForElement(driver, user_search_icon_uls);
				click(driver, user_search_icon_uls);

				twoColumnSearchWindow(driver, UserLevel_Header, User_Condition, username);

				waitForElement(driver, edit_btn_uls);
				click(driver, edit_btn_uls);
				waitForElement(driver, uls_textfield);
				sendKeys(driver, uls_textfield, uls_textfield_data);

				waitForElement(driver, imp_inv_checkbox_uls);

				checkBox(driver, imp_inv_checkbox_uls, checkbox_click);
				action.keyDown(Keys.CONTROL).build().perform();
				for (int i = 0; i < notInPrivilegeCodes.size(); i++) {
					String remove_Code = String.format(previllage_Code, notInPrivilegeCodes.get(i));
					waitForElement(driver, remove_Code);
					click(driver, remove_Code);
				}
				action.keyUp(Keys.CONTROL).build().perform();
				waitForElement(driver, uls_Remove_Button);
				click(driver, uls_Remove_Button);
				scrollTop(driver);

				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			}
		}
		
		Extent_completed(testcase_Name, test, test1);	
		

}

}
