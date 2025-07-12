package LRP_Import_Invoice_Scripts;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC021 extends Keywords {

	public void Import_Invoice_SC021(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws AWTException {

		String testCaseName = "TC_Import_Invoice_SC021";
		// Get data from test data


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Field_Names = Excel_data.get("Field_Names");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String BL_Filter_Type_Import_Doc = Excel_data.get("BL_Filter_Type_Import_Doc");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Search_Import_Document = Excel_data.get("Search_Import_Document");
		String Customer_Type = Excel_data.get("Customer_Type");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String uls_module = Excel_data.get("uls_module");
		String condition = Excel_data.get("condition");
		String uls_textfield_data = Excel_data.get("uls_textfield_data");
		String checkbox_click = Excel_data.get("checkbox_click");
		String select_attributes = Excel_data.get("select_attributes");
		String uls_header = Excel_data.get("uls_header");
		String execution_Mode = Excel_data.get("execution_Mode");
		String charges_to_add = Excel_data.get("charges_to_add");
		String currencies = Excel_data.get("currencies");
		String base_rate_unit = Excel_data.get("base_rate_unit_data");
		String containers = Excel_data.get("containers_to_add");
		String rates = Excel_data.get("rate_data");
		String quantity = Excel_data.get("quantity_data");
		String remarks_data = Excel_data.get("remarks_data");
		String col_headers = Excel_data.get("col_headers");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop").trim();
		String columns_to_print_report = Excel_data.get("columns_to_print_report");
		String Invoice_updated_popup = Excel_data.get("Invoice_updated_popup").trim();
		String UserLevel_Header = Excel_data.get("UserLevel_Header");
		String Charge_Header = Excel_data.get("Charge_Header");
		String ROE_Header = Excel_data.get("ROE_Header");
		String BaseRateUnit_Header = Excel_data.get("BaseRateUnit_Header");
		String Container_Header = Excel_data.get("Container_Header");
		String Delete_Import_Invoice = Excel_data.get("Delete_Import_Invoice");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String base_rate_unit_data = Excel_data.get("base_rate_unit_data");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");



		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "1.Open User level Security Module,", test, test1);

		moduleNavigate(driver, uls_module);

		Step_End(1, "1.Open User level Security Module,", test, test1);

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
		List<String> attributes = splitAndExpand(select_attributes);

		// List to store the differences (attributes that are not in privilege_codes)
		List<String> notInPrivilegeCodes = new ArrayList<>();

		// Compare the lists and find attributes not in privilege_codes
		for (String attribute : attributes) {
			if (!privilege_codes.contains(attribute)) {
				notInPrivilegeCodes.add(attribute);
			}
		}

		System.out.println("The attributes not available in privilege_codes are: " + notInPrivilegeCodes);

		Extent_call(test, test1,
				"Make sure that below Privilages added in for Login Users,\r\n"
						+ "EAC-Allow to add additional customer\r\n" + "ENC-Allow to add negative charge\r\n"
						+ "ICC-Allow to change Invoice Category\r\n" + "RCN-Allow to Remove Agency charges");
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

		SwitchProfile(driver, AgencyUser);

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
			waitForElement(driver, voyage_code_input);
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
		if (execution_Mode.equalsIgnoreCase("new")) {

			waitForElement(driver, import_invoice_draft_button);
			scrollBottom(driver);

			Step_Start(5, "go to the additional charges tab", test, test1);

			waitForElement(driver, additional_charges_tab_IN);
			click(driver, additional_charges_tab_IN);

			Step_End(5, "go to the additional charges tab", test, test1);

			waitForElement(driver, edit_input_fields);
			click(driver, edit_input_fields);

			Step_Start(6,
					"following fields are available..1.bl number  2.charge 3.currency/roe 4.base rateunit 5.quantity 6.rate 7.amount 8.container no 9.remarks.",
					test, test1);

			Step_Start(7, "bl number field - bl no has shown", test, test1);

			waitForDisplay(driver, bl_no_field_add_tab);

			if (isdisplayed(driver, bl_no_field_add_tab)) {

				System.out.println(
						"Pass || Expected result is : BL Number field should be availabled || Actual result is : BL Number is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : BL Number field should be availabled || Actual result is : BL Number is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : BL Number field should be available || Actual result is : BL Number is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : BL Number field should be available || Actual result is : BL Number is not displayed",
						test, test1);

			}

			Step_End(7, "bl number field - bl no has shown", test, test1);

			if (isdisplayed(driver, charge_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : Charge code field should be available || Actual result is : Charge code is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Charge code field should be available || Actual result is : Charge code is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Charge code field should be available || Actual result is : Charge code is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Charge code field should be available || Actual result is : Charge code is not displayed",
						test, test1);

			}

			// 3

			if (isdisplayed(driver, curreny_ROE_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : ROE Search field should be available || Actual result is : ROE Search is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : ROE Search field should be available || Actual result is : ROE Search is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : ROE Search field should be available || Actual result is : ROE Search is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : ROE Search field should be available || Actual result is : ROE Search is not displayed",
						test, test1);

			}

			// 4
			if (isdisplayed(driver, baseRateUnit_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is not displayed",
						test, test1);

			}

			// 5

			if (isdisplayed(driver, quantityTextField_IN)) {

				System.out.println(
						"Pass || Expected result is : Quantity field should be available || Actual result is : Quantity field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Quantity field should be available || Actual result is : Quantity field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Quantity field should be available || Actual result is : Quantity field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Quantity field should be available || Actual result is : Quantity field is not displayed",
						test, test1);

			}

			// 6

			if (isdisplayed(driver, rate_TextField_IN)) {

				System.out.println(
						"Pass || Expected result is : Rate field should be available || Actual result is : Rate field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Rate field should be available || Actual result is : Rate field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Rate field should be available || Actual result is : Rate field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Rate field should be available || Actual result is : Rate field is not displayed",
						test, test1);

			}

			// 7

			if (isdisplayed(driver, amount_TextField_IN)) {

				System.out.println(
						"Pass || Expected result is : Amount field should be available || Actual result is : Amount field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Amount field should be available || Actual result is : Amount field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Amount field should be available || Actual result is : Amount field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Amount field should be available || Actual result is : Amount field is not displayed",
						test, test1);

			}

			// 8

			if (isdisplayed(driver, containerNo_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : Container number search button should be available || Actual result is : Container number search button is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Container number search button should be available || Actual result is : Container number search button is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Container number search button should be available || Actual result is : Container number search button is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Container number search button should be available || Actual result is : Container number search button is not displayed",
						test, test1);

			}

			if (isdisplayed(driver, remarksTextArea_IN)) {

				System.out.println(
						"Pass || Expected result is : Remarks field should be available || Actual result is : Remarks field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Remarks field should be available || Actual result is : Remarks field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Remarks field should be available || Actual result is : Remarks field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Remarks field should be available || Actual result is : Remarks field is not displayed",
						test, test1);

			}

			Step_End(6,
					"following fields are available....1.bl number  2.charge 3.currency/roe 4.base rateunit 5.quantity 6.rate 7.amount 8.container no 9.remarks.",
					test, test1);

			List<String> charges_to_select = splitAndExpand(charges_to_add);

			List<String> currency = splitAndExpand(currencies,",");
			List<String> remarks_datas = splitAndExpand(remarks_data,",");
			List<String> quantity_data = splitAndExpand(quantity,",");
			List<String> rate_ = splitAndExpand(rates, ",");
			List<String> Base_Rates = splitAndExpand(base_rate_unit_data, ",");

			List<String> container = splitAndExpand(containers);

			for (int i = 0; i < charges_to_select.size(); i++) {
				
				String charges_value = charges_to_select.get(i);
				String currency_data = currency.get(i);
				String remarks = remarks_datas.get(i);
				String quantity_add = quantity_data.get(i);
				String rate_select = rate_.get(i);
				String baseRate=Base_Rates.get(i);
				String containers_to_add=container.get(i);

				Step_Start(8, "select the charge code from Test data", test, test1);

				// 2
				waitForElement(driver, charge_SearchButton_IN);
				click(driver, charge_SearchButton_IN);
				twoColumnSearchWindow(driver, Charge_Header, condition, charges_value);

				Step_End(8, "select the charge code from Test data", test, test1);
				Step_Start(9, "select the currency/roe from Test data", test, test1);

				// 3
				waitForElement(driver, curreny_ROE_SearchButton_IN);
				click(driver, curreny_ROE_SearchButton_IN);
				twoColumnSearchWindow(driver, ROE_Header, condition, currency_data);

				Step_End(9, "select the currency/roe from Test data", test, test1);
				Step_Start(10, "select the base rate unit from Test data", test, test1);

				// 4
				waitForElement(driver, baseRateUnit_SearchButton_IN);
				click(driver, baseRateUnit_SearchButton_IN);
				twoColumnSearchWindow(driver, BaseRateUnit_Header, condition, baseRate);

				Step_End(10, "select the base rate unit from Test data", test, test1);
				Step_Start(11, "enter the value from Test data", test, test1);

				// 5
				waitForElement(driver, quantityTextField_IN);
				Newclear(driver, quantityTextField_IN);
				sendKeys(driver, quantityTextField_IN, quantity_add);

				Step_End(11, "enter the value from Test data", test, test1);
				Step_Start(12, "enter the value from Test data", test, test1);

				// 6
				waitForElement(driver, rate_TextField_IN);
				Newclear(driver, rate_TextField_IN);
				sendKeys(driver, rate_TextField_IN, rate_select);
//			sendKeysUsingRobot(rate_select);

				Step_End(12, "enter the value from Test data", test, test1);

				Step_Start(13, "amount field automatically converted", test, test1);

				waitForElement(driver, amount_TextField_IN);
				mouseOverToElement(driver, amount_TextField_IN);
				doubleClick(driver, amount_TextField_IN);
				waitForElement(driver, amount_TextField_IN);
				String autoconverted_Amount = getAttribute(driver, amount_TextField_IN, "value");
				System.out.println("Auto-retrieved value is: " + autoconverted_Amount);

				Step_End(13, "amount field automatically converted", test, test1);
				Step_Start(14, "container field - select the container from Test data", test, test1);

				// 7
				
				if(!containers_to_add.trim().equals("")) {
					waitForElement(driver, containerNo_SearchButton_IN);
					click(driver, containerNo_SearchButton_IN);

					twoColumnSearchWindow(driver, Container_Header, condition, containers_to_add);
				}
				
				Step_End(14, "container field - select the container from Test data", test, test1);

				// 8

				waitForElement(driver, remarksTextArea_IN);
				click(driver, remarksTextArea_IN);
				sendKeys(driver, remarksTextArea_IN, remarks);

				Step_Start(15, "click the add button", test, test1);

				waitForElement(driver, add_button_add_tab);
				click(driver, add_button_add_tab);

				Step_End(15, "click the add button", test, test1);

			}

			Step_End(16, "in below grid newly added charges has shown", test, test1);
			Step_Start(17, "select the draft and click the save button in toolbar", test, test1);

			scrollTop(driver);

			waitForElement(driver, importInvoice_Draft_Button);
			click(driver, importInvoice_Draft_Button);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(17, "select the draft and click the save button in toolbar", test, test1);

			Step_Start(18, "system has validate import invoice saved", test, test1);

			waitForPopup(driver, popup_Message, Draft_saved_pop);
			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);
			if (Draft_saved_pop.equals(import_saved_act)) {

				Extent_pass_New(driver, "Matched || Expected Draft Popup : " + Draft_saved_pop + " || Actual Draft Popup : "
						+ import_saved_act, test, test1);
				System.out.println("Matched || Expected Draft Popup : " + Draft_saved_pop + " || Actual Draft Popup : "
						+ import_saved_act);

			} else {
				System.out.println("Not Matched || Expected Draft Popup : " + Draft_saved_pop
						+ " || Actual Draft Popup : " + import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Draft Popup : " + Draft_saved_pop
						+ " || Actual Draft Popup : " + import_saved_act, test, test1);
			}

			Step_End(18, "system has validate import invoice saved", test, test1);

			Step_Start(19, "click ok", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(19, "click ok", test, test1);

			Step_Start(20, "Verify that added charge code listed in Grid", test, test1);

			waitForElement(driver, addtnl_chrgs_table_headers);
			List<Map<String, String>> charges_table1 = getTableData(driver, addtnl_chrgs_table_headers,
					addtnl_chrgs_rows);

			List<String> col_header = splitAndExpand(col_headers);
			List<String> charges_row = getValuesByColumnHeaders(charges_table1, "Amount", "-10.00", col_header);

			System.out.println(charges_row);

			System.out.println(charges_table1);

			Step_End(20, "Verify that added charge code listed in Grid", test, test1);

		} else if (execution_Mode.equalsIgnoreCase("draft")) {

			Step_Start(5, "Select the draft and click the save button in tool bar", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(5, "Select the draft and click the save button in tool bar", test, test1);

			Step_Start(6, "System has validate import invoice saved.", test, test1);

			waitForPopup(driver, popup_Message, Draft_saved_pop);

			String import_saved_act = getText(driver, popup_Message).trim();
			System.out.println(import_saved_act);

			if (Draft_saved_pop.equals(import_saved_act)) {

				Extent_pass_New(driver, "Matched || Expected Draft Popup : " + Draft_saved_pop + " || Actual Draft Popup : "
						+ import_saved_act, test, test1);
				System.out.println("Matched || Expected Draft Popup : " + Draft_saved_pop + " || Actual Draft Popup : "
						+ import_saved_act);

			} else {
				System.out.println("Not Matched || Expected Draft Popup : " + Draft_saved_pop
						+ " || Actual Draft Popup : " + import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Draft Popup : " + Draft_saved_pop
						+ " || Actual Draft Popup : " + import_saved_act, test, test1);
			}

			Step_End(6, "System has validate import invoice saved.", test, test1);

			Step_Start(7, "Click ok", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(7, "Click ok", test, test1);

			Step_Start(8, "Click on Edit Button", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(8, "Click on Edit Button", test, test1);

			Step_Start(9, "Go the additional charges tab", test, test1);

			scrollBottom(driver);
			waitForElement(driver, additional_charges_tab_IN);
			click(driver, additional_charges_tab_IN);

			Step_End(9, "Go the additional charges tab", test, test1);

			waitForElement(driver, edit_input_fields);
			click(driver, edit_input_fields);
			Step_Start(10, "Following field has available", test, test1);
			Step_Start(11,
					"BL number 2. Charge 3. Currency/ROE 4. Base rateunit 5. Quantity 6. Rate 7. Amount 8. Container no 9. Remarks.",
					test, test1);

			// 1
			waitForDisplay(driver, bl_no_field_add_tab);
			if (isdisplayed(driver, bl_no_field_add_tab)) {

				System.out.println(
						"Pass || Expected result is : BL Number field should be availabled || Actual result is : BL Number is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : BL Number field should be availabled || Actual result is : BL Number is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : BL Number field should be available || Actual result is : BL Number is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : BL Number field should be available || Actual result is : BL Number is not displayed",
						test, test1);

			}

			Step_End(7, "bl number field - bl no has shown", test, test1);

			if (isdisplayed(driver, charge_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : Charge code field should be available || Actual result is : Charge code is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Charge code field should be available || Actual result is : Charge code is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Charge code field should be available || Actual result is : Charge code is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Charge code field should be available || Actual result is : Charge code is not displayed",
						test, test1);

			}

			// 3

			if (isdisplayed(driver, curreny_ROE_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : ROE Search field should be available || Actual result is : ROE Search is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : ROE Search field should be available || Actual result is : ROE Search is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : ROE Search field should be available || Actual result is : ROE Search is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : ROE Search field should be available || Actual result is : ROE Search is not displayed",
						test, test1);

			}

			// 4
			if (isdisplayed(driver, baseRateUnit_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Base Rate Unit Search field should be available || Actual result is : Base Rate Unit Search is not displayed",
						test, test1);

			}

			// 5

			if (isdisplayed(driver, quantityTextField_IN)) {

				System.out.println(
						"Pass || Expected result is : Quantity field should be available || Actual result is : Quantity field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Quantity field should be available || Actual result is : Quantity field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Quantity field should be available || Actual result is : Quantity field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Quantity field should be available || Actual result is : Quantity field is not displayed",
						test, test1);

			}

			// 6

			if (isdisplayed(driver, rate_TextField_IN)) {

				System.out.println(
						"Pass || Expected result is : Rate field should be available || Actual result is : Rate field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Rate field should be available || Actual result is : Rate field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Rate field should be available || Actual result is : Rate field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Rate field should be available || Actual result is : Rate field is not displayed",
						test, test1);

			}

			// 7

			if (isdisplayed(driver, amount_TextField_IN)) {

				System.out.println(
						"Pass || Expected result is : Amount field should be available || Actual result is : Amount field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Amount field should be available || Actual result is : Amount field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Amount field should be available || Actual result is : Amount field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Amount field should be available || Actual result is : Amount field is not displayed",
						test, test1);

			}

			// 8

			if (isdisplayed(driver, containerNo_SearchButton_IN)) {

				System.out.println(
						"Pass || Expected result is : Container number search button should be available || Actual result is : Container number search button is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Container number search button should be available || Actual result is : Container number search button is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Container number search button should be available || Actual result is : Container number search button is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Container number search button should be available || Actual result is : Container number search button is not displayed",
						test, test1);

			}

			if (isdisplayed(driver, remarksTextArea_IN)) {

				System.out.println(
						"Pass || Expected result is : Remarks field should be available || Actual result is : Remarks field is displayed");
				Extent_pass_New(driver,
						"Pass || Expected result is : Remarks field should be available || Actual result is : Remarks field is displayed",
						test, test1);

			} else {

				System.out.println(
						"Fail || Expected result is : Remarks field should be available || Actual result is : Remarks field is not displayed");
				Extent_fail(driver,
						"Fail || Expected result is : Remarks field should be available || Actual result is : Remarks field is not displayed",
						test, test1);

			}

			Step_End(10, "Following field has available", test, test1);

			Step_End(11,
					"BL number 2. Charge 3. Currency/ROE 4. Base rateunit 5. Quantity 6. Rate 7. Amount 8. Container no 9. Remarks.",
					test, test1);

			Step_Start(12, "BL number field - BL No has shown.", test, test1);

			String bl_number_present = getText(driver, bl_number_label);

			if (bl_number_present.equals(BL_Number_input)) {

				System.out.println("Bl number is correctly shown" + "||Expected : " + BL_Number_input + "actual :"
						+ bl_number_present);
				Extent_pass_New(driver, "Bl number is correctly shown" + "||Expected : " + BL_Number_input + "actual :"
						+ bl_number_present, test, test1);
			} else {

				System.out.println("Bl number is not correctly shown" + "||Expected : " + BL_Number_input + "actual :"
						+ bl_number_present);
				Extent_fail(driver, "Bl number is not correctly shown" + "||Expected : " + BL_Number_input + "actual :"
						+ bl_number_present, test, test1);

			}
			Step_End(12, "BL number field - BL No has shown.", test, test1);

			List<String> charges_to_select = splitAndExpand(charges_to_add);

			List<String> currency = splitAndExpand(currencies);
			List<String> base_rate_data = splitAndExpand(base_rate_unit);
			List<String> remarks_datas = splitAndExpand(remarks_data);
			List<String> quantity_data = splitAndExpand(quantity);
			List<String> rate_ = splitAndExpand(rates, ",");
			List<String> container = splitAndExpand(containers);

			for (int i = 0; i < charges_to_select.size(); i++) {
				
				String charges_value = charges_to_select.get(i);
				String currency_data = currency.get(i);
				String base_rate = base_rate_data.get(i);
				String remarks = remarks_datas.get(i);
				String quantity_add = quantity_data.get(i);
				String rate_select = rate_.get(i);
				String container_add = container.get(i);

				Step_Start(13, "Select the charge code from Test data", test, test1);

				// 2
				waitForElement(driver, charge_SearchButton_IN);
				click(driver, charge_SearchButton_IN);

				twoColumnSearchWindow(driver, Charge_Header, condition, charges_value);

				Step_End(13, "Select the charge code from Test data", test, test1);

				Step_Start(14, "Select the currency/roe from Test data", test, test1);
				// 3
				waitForElement(driver, curreny_ROE_SearchButton_IN);
				click(driver, curreny_ROE_SearchButton_IN);

				twoColumnSearchWindow(driver, ROE_Header, condition, currency_data);

				Step_End(14, "Select the currency/roe from Test data", test, test1);

				Step_Start(15, "Select the base rate unit from Test data", test, test1);

				// 4
				waitForElement(driver, baseRateUnit_SearchButton_IN);
				click(driver, baseRateUnit_SearchButton_IN);

				twoColumnSearchWindow(driver, BaseRateUnit_Header, condition, base_rate);

				Step_End(15, "Select the base rate unit from Test data", test, test1);

				// 5
				waitForElement(driver, quantityTextField_IN);
				clear(driver, quantityTextField_IN);
				sendKeys(driver, quantityTextField_IN, quantity_add);

				Step_Start(16, "Enter the Amt from Test data with Negative Value", test, test1);
				// 6
				waitForElement(driver, rate_TextField_IN);
				Newclear(driver, rate_TextField_IN);
				waitForElement(driver, rate_TextField_IN);
				click(driver, rate_TextField_IN);
				sendKeys(driver, rate_TextField_IN, rate_select);

//				sendKeysUsingRobot(rate_select);

				Step_End(16, "Enter the Amt from Test data with Negative Value", test, test1);

				Step_Start(18, "Amount field automatically converted", test, test1);
				waitForElement(driver, amount_TextField_IN);
				mouseOverToElement(driver, amount_TextField_IN);
				click(driver, amount_TextField_IN);

				waitForElement(driver, amount_TextField_IN);
				String autoconverted_Amount = getAttribute(driver, amount_TextField_IN, "value");
				System.out.println("Auto-retrieved value is: " + autoconverted_Amount);
				Step_End(18, "Amount field automatically converted", test, test1);

				Step_Start(19, "Container field - select the container from Test data", test, test1);

				// 7
				
				if(!container_add.trim().equals("")) {
					waitForElement(driver, containerNo_SearchButton_IN);
					click(driver, containerNo_SearchButton_IN);

					twoColumnSearchWindow(driver, Container_Header, condition, container_add);
				}
				
				Step_End(19, "Container field - select the container from Test data", test, test1);

				// 8

				waitForElement(driver, remarksTextArea_IN);
				click(driver, remarksTextArea_IN);
				sendKeys(driver, remarksTextArea_IN, remarks);

				Step_Start(20, "Click the add button", test, test1);

				waitForElement(driver, add_button_add_tab);
				click(driver, add_button_add_tab);

				Step_End(20, "Click the add button", test, test1);
			}

			Step_Start(21, "In below grid newly added charges has shown.", test, test1);

			waitForElement(driver, addtnl_chrgs_table_headers);
			List<Map<String, String>> charges_table = getTableData(driver, addtnl_chrgs_table_headers,
					addtnl_chrgs_rows);

			System.out.println(charges_table);

			Step_End(21, "In below grid newly added charges has shown.", test, test1);

			scrollTop(driver);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Invoice_updated_popup);

			String import_saved_act1 = getText(driver, popup_Message);
			System.out.println(import_saved_act1);

			if (Invoice_updated_popup.equals(import_saved_act1)) {

				Extent_pass_New(driver, "Matched || Expected Draft Popup : " + Invoice_updated_popup
						+ " || Actual Draft Popup : " + import_saved_act1, test, test1);
				System.out.println("Matched || Expected Draft Popup : " + Invoice_updated_popup
						+ " || Actual Draft Popup : " + import_saved_act1);

			} else {
				System.out.println("Not Matched || Expected Draft Popup : " + Invoice_updated_popup
						+ " || Actual Draft Popup : " + import_saved_act1);
				Extent_fail(driver, "Not Matched || Expected Draft Popup : " + Invoice_updated_popup
						+ " || Actual Draft Popup : " + import_saved_act1, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			// }

			waitForElement(driver, addtnl_chrgs_table_headers);
			List<Map<String, String>> charges_table1 = getTableData(driver, addtnl_chrgs_table_headers,
					addtnl_chrgs_rows);

			List<String> col_header = splitAndExpand(col_headers);
			List<String> rate = splitAndExpand(rates, ",");

			for (int i = 0; i < rate.size(); i++) {
				List<String> charges_row1 = getValuesByColumnHeaders(charges_table1, "Amount", rate.get(i), col_header);

				System.out.println(charges_row1);

			}

			List<String> final_print = splitAndExpand(columns_to_print_report, ",");
			String table_for_report = TableDataForReport(driver, charges_table1, "final table after added charges",
					final_print);
			System.out.println(charges_table);

			Extent_pass_New(driver, " final : \n" + "<pre>" + table_for_report + "</pre>", test, test1);

			Extent_call(test, test1, "If Import Invoice in draft Status, Kindly Delete it.");

			scrollTop(driver);
			
			
			Import_Invoice_Draft_Delete(driver, Delete_Import_Invoice);
			
			
			
		}

		Extent_completed(testCaseName, test, test1);
	}

}
