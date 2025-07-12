package LRP_Import_Invoice_Scripts;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Import_Invoice_SC026 extends Keywords {

	public void Import_Invoice_SC026(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Import_Invoice_SC026";
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
		String Import_Doc_Customer_Type_Header = Excel_data.get("Import_Doc_Customer_Type_Header");
		String Import_Doc_Customer_TypeValue = Excel_data.get("Import_Doc_Customer_TypeValue");
		String Import_Doc_Customer_CodeHeader = Excel_data.get("Import_Doc_Customer_CodeHeader");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String BL_Retrive_Option_ImportDoc = Excel_data.get("BL_Retrive_Option_ImportDoc");
		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String condition = Excel_data.get("condition");
		String Table_Name = Excel_data.get("Table_Name");
		String charges_to_add = Excel_data.get("charges_to_add");
		String currencies = Excel_data.get("currencies");
		String base_rate_unit = Excel_data.get("base_rate_unit_data");
		String containers = Excel_data.get("containers_to_add");
		String rates = Excel_data.get("rate_data");
		String quantity = Excel_data.get("quantity_data");
		String remarks_data = Excel_data.get("remarks_data");
		String col_headers = Excel_data.get("col_headers");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		String Issued_saved_pop = Excel_data.get("Issued_saved_pop");
		String Charge_Header = Excel_data.get("Charge_Header");
		String ROE_Header = Excel_data.get("ROE_Header");
		String BaseRateUnit_Header = Excel_data.get("BaseRateUnit_Header");
		String Container_Header = Excel_data.get("Container_Header");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");

		String Tolerance_Value = Excel_data.get("Tolerance_Value");

		

		DecimalFormat df=new DecimalFormat("0.00");
	
		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		verifyMainMenu(driver);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, "open the import invoice module and click the new button", test, test1);

		moduleNavigate(driver, Field_Names);

		newButton(driver);

		Step_End(2, "open the import invoice module and click the new button", test, test1);

		Step_Start(3, "retrive the bl in bl number search field", test, test1);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForDisplay(driver, By_BL_Number_Btn);
			click(driver, By_BL_Number_Btn);

			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);

			globalValueSearchWindow(driver, BL_Condition, BL_Filter_Type, BL_Number_input, "", "", "", "");

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

			horizontalscroll(driver, By_Vessel_Scroll, 500);
			if(!Terminal_Code_Input.equals("")) {
				waitForElement(driver, By_Vessel_Terminal);
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

		Step_End(4, "search  and select the bl no", test, test1);

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
		Step_Start(7, "bl number field -bl no has shown", test, test1);

		waitForElement(driver, bl_no_field_add_tab);
		if (isdisplayed(driver, bl_no_field_add_tab)) {

			System.out.println(
					"Pass || Expected result is : BL Number field should be available || Actual result is : BL Number is displayed");
			Extent_pass_New(driver,
					"Pass || Expected result is : BL Number field should be available || Actual result is : BL Number is displayed",
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

		Step_End(7, "bl number field -bl no has shown", test, test1);

		Step_End(6,
				"following fields are available....1.bl number  2.charge 3.currency/roe 4.base rateunit 5.quantity 6.rate 7.amount 8.container no 9.remarks.",
				test, test1);
		List<String> charges_to_select = splitAndExpand(charges_to_add);
		for (int i = 0; i < charges_to_select.size(); i++) {
			List<String> currency = splitAndExpand(currencies);
			List<String> base_rate_data = splitAndExpand(base_rate_unit);
			List<String> remarks_datas = splitAndExpand(remarks_data);
			List<String> quantity_data = splitAndExpand(quantity);
			List<String> rate = splitAndExpand(rates, ",");
			List<String> container = splitAndExpand(containers);

			String charges_value = charges_to_select.get(i);
			String currency_data = currency.get(i);
			String base_rate = base_rate_data.get(i);
			String remarks = remarks_datas.get(i);
			String quantity_add = quantity_data.get(i);
			String rate_select = rate.get(i);
			String container_add = container.get(i);
			Step_Start(8, "select the charge code from Test data", test, test1);
			// 2

			waitForElement(driver, charge_SearchButton_IN);
			click(driver, charge_SearchButton_IN);

			twoColumnSearchWindow(driver, Charge_Header, condition, charges_value);

			Step_End(8, "select the charge code from Test data", test, test1);

			Step_Start(9, "select the currency/roe from Test data", test, test1);

			waitForElement(driver, curreny_ROE_SearchButton_IN);
			click(driver, curreny_ROE_SearchButton_IN);

			twoColumnSearchWindow(driver, ROE_Header, condition, currency_data);

			Step_End(9, "select the currency/roe from Test data", test, test1);

			Step_Start(10, "select the base rate unit from Test data", test, test1);
			// 4
			waitForElement(driver, baseRateUnit_SearchButton_IN);
			click(driver, baseRateUnit_SearchButton_IN);

			twoColumnSearchWindow(driver, BaseRateUnit_Header, condition, base_rate);

			Step_End(10, "select the base rate unit from Test data", test, test1);

			Step_Start(11, "enter the value from Test data", test, test1);
			// 5
			waitForElement(driver, quantityTextField_IN);
			clear(driver, quantityTextField_IN);
			sendKeys(driver, quantityTextField_IN, quantity_add);
			Step_End(11, "enter the value from Test data", test, test1);
			Step_Start(12, "enter the value from Test data", test, test1);
			// 6
			waitForElement(driver, rate_TextField_IN);
			click(driver, rate_TextField_IN);
			Newclear_Type(driver);
			sendKeys(driver, rate_TextField_IN, rate_select);
			click(driver, rate_TextField_IN);
			Step_End(12, "enter the value from Test data", test, test1);

			Step_Start(13, "amount field automatically converted", test, test1);
			
			Step_Start(14, "container field - select the container from Test data", test, test1);

			// 7
			waitForElement(driver, containerNo_SearchButton_IN);
			click(driver, containerNo_SearchButton_IN);

			twoColumnSearchWindow(driver, Container_Header, condition, container_add);

			waitForElement(driver, amount_TextField_IN);
			String autoconvertedAmount = getAttribute(driver, amount_TextField_IN, "value");
			double autoConvertAmt=Double.parseDouble(autoconvertedAmount);
			String autoconverted_Amount=df.format(autoConvertAmt);
			
			
			Step_End(13, "amount field automatically converted", test, test1);
			
			Step_End(14, "container field - select the container from Test data", test, test1);

			waitForElement(driver, remarksTextArea_IN);
			click(driver, remarksTextArea_IN);
			sendKeys(driver, remarksTextArea_IN, remarks);

			Step_Start(15, "click the add button", test, test1);

			waitForElement(driver, add_button_add_tab);
			click(driver, add_button_add_tab);

			Step_End(15, "click the add button", test, test1);
			waitForElement(driver, addtnl_chrgs_table_headers);
			List<Map<String, String>> charges_table = getTableData(driver, addtnl_chrgs_table_headers,
					addtnl_chrgs_rows);
			String chargeCode_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value,
					"Charge Code");
			String currency_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value,
					"Currency");
			String quantity_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value,
					"Quantity");
			String rate_Value = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value, "Rate");
			String amountValue = getValueByFirstColumnAndHeader(charges_table, "Charge Code", charges_value, "Amount");
			double gridAmt=Double.parseDouble(amountValue);
			String amount_Value=df.format(gridAmt);
			
			
			if (chargeCode_Value.equals(charges_value)) {
				System.out.println("Matched || The Expected Charge Code Value From The Excel Sheet is : "
						+ charges_value + " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
						+ chargeCode_Value);
				Extent_pass_New(driver,
						"Matched || The Expected Charge Code Value From The Excel Sheet is : " + charges_value
								+ " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
								+ chargeCode_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Charge Code Value From The Excel Sheet is : "
						+ charges_value + " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
						+ chargeCode_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Charge Code Value From The Excel Sheet is : " + charges_value
								+ " || The Actual Charge Code Value From The Additional Charges Tab Table is : "
								+ chargeCode_Value,
						test, test1);
			}
			if (currency_data.equals(currency_Value)) {
				System.out.println("Matched || The Expected Currency Value From The Excel Sheet is : " + currency_data
						+ " || The Actual Currency Value From The Additional Charges Tab Table is : " + currency_Value);
				Extent_pass_New(driver, "Matched || The Expected Currency Value From The Excel Sheet is : " + currency_data
						+ " || The Actual Currency Value From The Additional Charges Tab Table is : " + currency_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Currency Value From The Excel Sheet is : "
						+ currency_data + " || The Actual Currency Value From The Additional Charges Tab Table is : "
						+ currency_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Currency Value From The Excel Sheet is : " + currency_data
								+ " || The Actual Currency Value From The Additional Charges Tab Table is : "
								+ currency_Value,
						test, test1);
			}
			
			double qtyExp=getNumberValue(quantity_add);
			double qtyAct=getNumberValue(quantity_Value);
			double tolerance=getNumberValue(Tolerance_Value);
			
			if (compareAmounts(qtyExp, qtyAct, tolerance)) {
				System.out.println("Matched || The Expected Quantity Value From The Excel Sheet is : " + quantity_add
						+ " || The Actual Quantity Value From The Additional Charges Tab Table is : " + quantity_Value);
				Extent_pass_New(driver, "Matched || The Expected Quantity Value From The Excel Sheet is : " + quantity_add
						+ " || The Actual Quantity Value From The Additional Charges Tab Table is : " + quantity_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Quantity Value From The Excel Sheet is : "
						+ quantity_add + " || The Actual Quantity Value From The Additional Charges Tab Table is : "
						+ quantity_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Quantity Value From The Excel Sheet is : " + quantity_add
								+ " || The Actual Quantity Value From The Additional Charges Tab Table is : "
								+ quantity_Value,
						test, test1);
			}
			
			
			double expRate=getNumberValue(rate_select);
			double ActRate=getNumberValue(rate_Value);
			
			if (compareAmounts(expRate, ActRate, tolerance)) {
				System.out.println("Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
						+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value);
				Extent_pass_New(driver,
						"Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
								+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
						+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Rates Value From The Excel Sheet is : " + rate_select
								+ " || The Actual Rates Value From The Additional Charges Tab Table is : " + rate_Value,
						test, test1);
			}
			
			
			double expAmt=getNumberValue(autoconverted_Amount);
			double ActAmt=getNumberValue(amount_Value);
			
			if (compareAmounts(expAmt, ActAmt, tolerance)) {
				System.out.println("Matched || The Expected Automatically Converted Amount is : " + autoconverted_Amount
						+ " || The Actual Amount Value From The Additional Charges Tab Table is : " + amount_Value);
				Extent_pass_New(driver,
						"Matched || The Expected Automatically Converted Amount is : " + autoconverted_Amount
								+ " || The Actual Amount Value From The Additional Charges Tab Table is : "
								+ amount_Value,
						test, test1);
			} else {
				System.out.println("Not Matched || The Expected Automatically Converted Amount is : "
						+ autoconverted_Amount
						+ " || The Actual Amount Value From The Additional Charges Tab Table is : " + amount_Value);
				Extent_fail(driver,
						"Not Matched || The Expected Automatically Converted Amount is : " + autoconverted_Amount
								+ " || The Actual Amount Value From The Additional Charges Tab Table is : "
								+ amount_Value,
						test, test1);
			}
		}

		Step_Start(16, "in below grid newly added charges has shown", test, test1);
		waitForElement(driver, addtnl_chrgs_table_headers);
		List<Map<String, String>> charges_table = getTableData(driver, addtnl_chrgs_table_headers, addtnl_chrgs_rows);
		List<String> headers = splitAndExpand(col_headers, ",");
		String table_Value = TableDataForReport(driver, charges_table, Table_Name, headers);
		Extent_pass_New(driver, "<pre>" + table_Value + "</pre>", test, test1);
		Step_End(16, "in below grid newly added charges has shown", test, test1);
		Step_Start(17, "select the draft and click the save button in toolbar", test, test1);

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

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
			System.out.println("Not Matched || Expected Draft Popup : " + Draft_saved_pop + " || Actual Draft Popup : "
					+ import_saved_act);
			Extent_fail(driver, "Not Matched || Expected Draft Popup : " + Draft_saved_pop + " || Actual Draft Popup : "
					+ import_saved_act, test, test1);
		}

		Step_End(18, "system has validate import invoice saved", test, test1);

		Step_Start(19, "click ok", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(19, "click ok", test, test1);

		Step_Start(20, "click the edit button in tool bar", test, test1);

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		Step_End(20, "click the edit button in tool bar", test, test1);

		Step_Start(21, "select the issued ", test, test1);

		waitForElement(driver, import_Invoice_Issued_Button);
		click1(driver, import_Invoice_Issued_Button);

		Step_End(21, "select the issued ", test, test1);

		Step_Start(22, "click the save button in tool bar", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		Step_End(22, "click the save button in tool bar", test, test1);

		Step_Start(23, "system has validate import invoice updated.click ok", test, test1);

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
			System.out.println(
					"Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : " + import_Updated_act);
			Extent_fail(driver,
					"Not Matched || Expected Popup : " + Issued_saved_pop + " || Actual Popup : " + import_Updated_act,
					test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(23, "system has validate import invoice updated.click ok", test, test1);
		Step_Start(24, "once issued the invoice ,additional charges tab newly added charges has to be shown", test,
				test1);
		scrollBottom(driver);
		waitForElement(driver, addtnl_chrgs_table_headers);
		charges_table = getTableData(driver, addtnl_chrgs_table_headers, addtnl_chrgs_rows);
		headers = splitAndExpand(col_headers, ",");
		table_Value = TableDataForReport(driver, charges_table, Table_Name, headers);
		Extent_pass_New(driver, "<pre>" + table_Value + "</pre>", test, test1);

		
		waitForElement(driver, Invoice_Table_Row_All);
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String InvoiceNumber=getFirstValueByHeader(TabledataFull,"Inv Number");
		
		Step_End(24, "once issued the invoice ,additional charges tab newly added charges has to be shown", test,
				test1);
		Step_Start(25, "once saved the import issued invoice", test, test1);
		if (Delete_Invoice.equalsIgnoreCase("Yes")) {
			Extent_cal(test, test1, "Invoice reversal started");
			Invoice_Reversal(driver,InvoiceReversal_Module,BL_Condition,search_Type_Invoice_Reversal,InvoiceNumber,invoiceReversalRemarks,invoiceReversedPopup);
			Extent_cal(test, test1, "Invoice reversal Ended");
		}

		Step_End(25, "once saved the import issued invoice", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
