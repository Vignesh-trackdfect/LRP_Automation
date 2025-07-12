package LRP_Import_Invoice_Scripts;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Import_Invoice_SC020 extends Keywords {
	public void Import_Invoice_SC020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws AWTException {

		String testcase_Name = "TC_Import_Invoice_SC020";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Issued_saved_pop = Excel_data.get("Issued_saved_pop");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String uls_module = Excel_data.get("uls_module");
		String condition = Excel_data.get("condition");
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
		String Invoice_Save_Type = Excel_data.get("Invoice_Save_Type");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Tab_Name_II = Excel_data.get("Tab_Name_II");
		String uls_Remove_Newly_Added_Attributes = Excel_data.get("uls_Remove_Newly_Added_Attributes");
		String Non_Manifest_Charge_Codes = Excel_data.get("Non_Manifest_Charge_Codes");
		String Remove_Msg = Excel_data.get("Remove_Msg");
		String UserLevel_Header = Excel_data.get("UserLevel_Header");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Import_Doc_Customer_CodeHeader = Excel_data.get("Import_Doc_Customer_CodeHeader");
		String Import_Doc_Customer_TypeValue = Excel_data.get("Import_Doc_Customer_TypeValue");
		String Import_Doc_Customer_Type_Header = Excel_data.get("Import_Doc_Customer_Type_Header");
		
		
		

		Actions action = new Actions(driver);

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
 
		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, uls_module);

		waitForElement(driver, user_search_icon_uls);
		click(driver, user_search_icon_uls);

		twoColumnSearchWindow(driver, UserLevel_Header, condition, username);

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
		List<String> attributes = splitAndExpand(select_attributes,",");

		// List to store the differences (attributes that are not in privilege_codes)
		List<String> notInPrivilegeCodes = new ArrayList<>();
		// Compare the lists and find attributes not in privilege_codes
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
			System.out.println("No attributes to process. Skipping the loop.");
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
			waitForDisplay(driver, By_Vessel_Btn);
			click(driver, By_Vessel_Btn);
			waitForElement(driver, service_Txtfield_IN);
			sendKeys(driver, service_Txtfield_IN, Service_Code);
			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, Vessel_Code);
			sendKeys(driver, voyage_code_input, Voyage_Number);
			sendKeys(driver, bounnd_code_input, Bound_Input);
			sendKeys(driver, PortCode_Input, Port_Code);

			horizontalscroll(driver, InvoiceGridScroll, 300);
			click(driver, PortTerminal_Input);
			sendKeys(driver, PortTerminal_Input, Terminal_Code_Input);
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);

			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);
			moduleNavigate(driver, Search_Import_Document);
			waitForElement(driver, NewButton_ToolBar);

			scrollTop(driver);

			if (BL_Retrive_Option_ImportDoc.equalsIgnoreCase("By_BL")) {

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type_Import_Doc, BL_Number_input, "", "", "",
						"");

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

			waitForElement(driver, Customer_Table_Header);

			List<Map<String, String>> ImportDoc_Customer_Tabledata = getTableData(driver, Customer_Table_Header,
					Customer_Table_Row);
			String CustomerCode = getValueByFirstColumnAndHeader(ImportDoc_Customer_Tabledata,
					Import_Doc_Customer_Type_Header, Import_Doc_Customer_TypeValue, Import_Doc_Customer_CodeHeader);
			scrollTop(driver);

			waitForElement(driver, II_first_tab_inside_click);
			click(driver, II_first_tab_inside_click);
			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow1(driver, BL_Condition, Customer_Filter_Type, CustomerCode, "", "", "", "");

			if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
				waitForElement(driver, SystemCode_FilterInput);
				sendKeys(driver, SystemCode_FilterInput, Import_Doc_Customer_TypeValue);
			}
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);

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
		List<String> Charge_Codes = splitAndExpand(Non_Manifest_Charge_Codes, ",");

		if (Invoice_Save_Type.equalsIgnoreCase("New")) {
			Extent_call(test, test1, "** NEW Mode Start   **");

			Step_Start(14, "Go to Non Manifest tab", test, test1);
			String tab_Select = String.format(import_Invoice_Tab, Tab_Name_II);
			waitForElement(driver, tab_Select);
			click(driver, tab_Select);

			Step_End(14, "Go to Non Manifest tab", test, test1);

			Step_Start(15, "Click on Edit Button", test, test1);

			if(IsElementEnabled(driver, Edit_Button_toolBar)) {
				waitForElement(driver, Edit_Button_toolBar);
				click1(driver, Edit_Button_toolBar);
			}
			
			Step_End(15, "Click on Edit Button", test, test1);
			Step_Start(16, "Go to non Manifest charges tab", test, test1);
			waitForElement(driver, tab_Select);
			click(driver, tab_Select);
			Step_End(16, "Go to non Manifest charges tab", test, test1);
			Step_Start(17,
					"Select the charge code which is defined in Test Data,(It can be allow multiple charges as well)",
					test, test1);
			action.keyDown(Keys.CONTROL).build().perform();
			for (int j = 0; j < Charge_Codes.size(); j++) {
				String charge_Code_Select = String.format(non_Manifest_Charge_Code, Charge_Codes.get(j));
				waitForElement(driver, charge_Code_Select);
				mouseOverToElement(driver, charge_Code_Select);
				click(driver, charge_Code_Select);
			}
			action.keyUp(Keys.CONTROL).build().perform();
			Step_End(17,
					"Select the charge code which is defined in Test Data,(It can be allow multiple charges as well)",
					test, test1);
			Step_Start(18, "Click on remove button", test, test1);

			waitForElement(driver, non_Manifest_Remove_Button);
			click(driver, non_Manifest_Remove_Button);

			Step_End(18, "Click on remove button", test, test1);

			Step_Start(19, "msg shows \"Do you want to remove charges ?\" Yes/No Click Yes", test, test1);

			waitForPopup(driver, popup_Message, Remove_Msg);

			String import_act_popup = getText(driver, popup_Message);
			System.out.println(import_act_popup);

			if (Remove_Msg.trim().equals(import_act_popup.trim())) {
				System.out.println(
						"Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup, test,
						test1);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup,
						test, test1);
			}
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			Step_End(19, "msg shows \"Do you want to remove charges ?\" Yes/No Click Yes", test, test1);

			Step_Start(20, "Click on save button", test, test1);

			scrollTop(driver);
			waitForElement(driver, importInvoice_Draft_Button);
			click(driver, importInvoice_Draft_Button);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

			Step_End(20, "Click on save button", test, test1);

			Step_Start(21, "Import invoice update msg received and click ok button", test, test1);

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
			Step_End(21, "Import invoice update msg received and click ok button", test, test1);
			Extent_call(test, test1, "** New Mode End   **");

		} else if (Invoice_Save_Type.equalsIgnoreCase("Draft")) {

			Extent_call(test, test1, "** DRAFT Mode Start   **");
			Step_Start(12, "Click on save button", test, test1);
			scrollTop(driver);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			Step_End(12, "Click on save button", test, test1);

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

			Step_Start(14, "Go to Non Manifest tab", test, test1);
			String tab_Select = String.format(import_Invoice_Tab, Tab_Name_II);
			waitForElement(driver, tab_Select);
			click(driver, tab_Select);

			Step_End(14, "Go to Non Manifest tab", test, test1);

			Step_Start(15, "Click on Edit Button", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click1(driver, Edit_Button_toolBar);
			Step_End(15, "Click on Edit Button", test, test1);
			Step_Start(16, "Go to non Manifest charges tab", test, test1);
			waitForElement(driver, tab_Select);
			click(driver, tab_Select);
			Step_End(16, "Go to non Manifest charges tab", test, test1);
			Step_Start(17,
					"Select the charge code which is defined in Test Data,(It can be allow multiple charges as well)",
					test, test1);
			action.keyDown(Keys.CONTROL).build().perform();
			for (int j = 0; j < Charge_Codes.size(); j++) {

				click(driver, charge_Code_Filter);
				System.out.println("Charge_Codes : " + Charge_Codes.get(j));
				sendKeysUsingRobot(Charge_Codes.get(j));

				String charge_Code_Select = String.format(non_Manifest_Charge_Code, Charge_Codes.get(j));
				waitForElement(driver, charge_Code_Select);
				List<WebElement> chargecodes = listOfElements(driver, charge_Code_Select);

				for (int i = 0; i < chargecodes.size(); i++) {
					try {
						// Re-fetch the element inside the loop to avoid stale reference
						WebElement element = chargecodes.get(i);
						action.moveToElement(element).click().sendKeys(Charge_Codes.get(j)).build().perform();
					} catch (StaleElementReferenceException e) {
						System.out.println("Stale Element, retrying...");
						i--; // Retry the same index
					}
				}
				clear(driver, charge_Code_Filter);
				enter(driver);

			}
			action.keyUp(Keys.CONTROL).build().perform();

			Step_End(17,
					"Select the charge code which is defined in Test Data,(It can be allow multiple charges as well)",
					test, test1);

			Step_Start(18, "Click on remove button", test, test1);

			waitForElement(driver, non_Manifest_Remove_Button);
			click(driver, non_Manifest_Remove_Button);

			Step_End(18, "Click on remove button", test, test1);

			Step_Start(19, "msg shows \"Do you want to remove charges ?\" Yes/No Click Yes", test, test1);

			waitForPopup(driver, popup_Message, Remove_Msg);

			String import_act_popup = getText(driver, popup_Message);
			System.out.println(import_act_popup);
			if (Remove_Msg.trim().equals(import_act_popup.trim())) {
				System.out.println(
						"Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup, test,
						test1);
			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup);
				Extent_fail(driver,
						"Not Matched || Expected Popup : " + Remove_Msg + " || Actual Popup : " + import_act_popup,
						test, test1);
			}

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			Step_End(19, "msg shows \"Do you want to remove charges ?\" Yes/No Click Yes", test, test1);

			Step_Start(20, "Click on save button", test, test1);

			scrollTop(driver);

			waitForElement(driver, importInvoice_Draft_Button);
			click(driver, importInvoice_Draft_Button);

			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

			Step_End(20, "Click on save button", test, test1);

			Step_Start(21, "Import invoice update msg received and click ok button", test, test1);

			waitForPopup(driver, popup_Message, Issued_saved_pop);

			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			if (Issued_saved_pop.equals(import_saved_act)) {
				System.out.println(
						"Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : " + import_saved_act,
						test, test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
						+ import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : "
						+ import_saved_act, test, test1);
			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(21, "Import invoice update msg received and click ok button", test, test1);
			Extent_call(test, test1, "** DRAFT Mode End   **");
		}
		
		
		waitForElement(driver, nonManifestCharges_Tab_IN);
		click(driver,nonManifestCharges_Tab_IN);
		
		waitForElement(driver, non_Manifest_Charges_Headers);//
		List<Map<String, String>> non_Manifest_Table_Data = getTableData(driver, non_Manifest_Charges_Headers,
				non_Manifest_Charges_Rows);
		List<String> avilable_Values = getValuesByHeader(non_Manifest_Table_Data, "Charge Code");
		for (int i = 0; i < Charge_Codes.size(); i++) {
			if (!avilable_Values.contains(Charge_Codes.get(i))) {
				Extent_pass_New(driver,
						"Expected : Selected charges Should be removed : "
								+ Charge_Codes.get(i)
								+ " Actual : Selected charges are removed : "
								+ Non_Manifest_Charge_Codes,
						test, test1);
				System.out.println("Expected : Selected charges Should be removed : "
						+ Charge_Codes.get(i)
						+ " Actual : Selected charges are removed : "
						+ Non_Manifest_Charge_Codes);
			} else {
				System.out.println("Expected : Selected charges Should be removed : "
						+ Charge_Codes.get(i)
						+ " Actual : Selected charges are not removed : "
						+ Non_Manifest_Charge_Codes);
				Extent_fail(driver,
						"Expected : Selected charges Should be removed : "
								+ Charge_Codes.get(i)
								+ " Actual : Selected charges are not removed : "
								+ Non_Manifest_Charge_Codes,
						test, test1);
			}
		}

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

				twoColumnSearchWindow(driver, UserLevel_Header, condition, username);

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
