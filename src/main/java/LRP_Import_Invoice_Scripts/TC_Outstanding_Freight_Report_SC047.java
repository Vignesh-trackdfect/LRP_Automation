package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Outstanding_Freight_Report_SC047 extends Keywords {

	public void Outstanding_Freight_ReportSC47(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Outstanding_Freight_Report_SC047";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");

		String Invoice_ModuleType = Excel_data.get("Invoice_ModuleType");
		String Select_Invoice_Mode = Excel_data.get("Select_Invoice_Mode");

		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Input_Filter_Type = Excel_data.get("Input_Filter_Type");
		String Input_Filter_Condition = Excel_data.get("Input_Filter_Condition");
		String Input_Number = Excel_data.get("Input_Number");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");

		String Customer_Code = Excel_data.get("Customer_Code");
		String Customer_Filter_Type = Excel_data.get("Customer_Filter_Type");
		String Customer_Filter_Condition = Excel_data.get("Customer_Filter_Condition");

		String Agency_Master_Module_ = Excel_data.get("Agency_Master_Module_");
		String Agency_Master_Filter_type = Excel_data.get("Agency_Master_Filter_type");
		String Agency_Master_Filter_Condition = Excel_data.get("Agency_Master_Filter_Condition");

		String Invoice_saved_pop = Excel_data.get("Invoice_saved_pop");
		String Invoice_Already_Exist = Excel_data.get("Invoice_Already_Exist");
		String Invoice_Table_Headers = Excel_data.get("Invoice_Table_Headers");
		String Invoice_Validation_Row = Excel_data.get("Invoice_Validation_Row");

		String OFR_Module_Name = Excel_data.get("OFR_Module_Name");
		String OFR_Table_Headers = Excel_data.get("OFR_Table_Headers");
		String Tolerance_Value = Excel_data.get("Tolerance_Value");

		String Voyage_ROE_Module = Excel_data.get("Voyage_ROE_Module");
		String Voyage_ROE_Filter_type = Excel_data.get("Voyage_ROE_Filter_type");
		String Voyage_ROE_Filter_Condition = Excel_data.get("Voyage_ROE_Filter_Condition");
		String Voyage_Currency_Header = Excel_data.get("Voyage_Currency_Header");
		String Voyage_ROE_Header = Excel_data.get("Voyage_ROE_Header");

		String Agency_ROE_Module = Excel_data.get("Agency_ROE_Module");
		String Agency_ROE_Filter_Type = Excel_data.get("Agency_ROE_Filter_Type");
		String Agency_ROE_Filter_Condition = Excel_data.get("Agency_ROE_Filter_Condition");
		String Agency_ROE_Currency_Header = Excel_data.get("Agency_ROE_Currency_Header");
		String Agency_ROE_Header = Excel_data.get("Agency_ROE_Header");

		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Invoice_Reversel_Module = Excel_data.get("Invoice_Reversel_Module");
		String Reversal_Condition = Excel_data.get("Reversal_Condition");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");
		String Reversal_Filter_Type_Vessel = Excel_data.get("Reversal_Filter_Type_Vessel");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Charges_Popup = Excel_data.get("Charges_Popup");

		

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "Open Invoice Module", test, test1);

		moduleNavigate(driver, Invoice_ModuleType);
		waitForElement(driver, SearchButton_Toolbar);

		Step_End(1, "Open Invoice Module", test, test1);

		waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);

		String modeSelect = String.format(InvoiceMode_SelectOption, Select_Invoice_Mode);

		waitForElement(driver, modeSelect);
		click(driver, modeSelect);

		newButton(driver);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL") || BL_Retrive_Option.equalsIgnoreCase("By_Book")) {
			if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
				waitForElement(driver, By_BL_NumberBtn_All);
				click(driver, By_BL_NumberBtn_All);
			} else {
				waitForElement(driver, By_Book_Button_All);
				click(driver, By_Book_Button_All);
			}
			waitForElement(driver, In_bl_Search_Button);
			click(driver, In_bl_Search_Button);

			globalValueSearchWindow(driver, Input_Filter_Condition, Input_Filter_Type, Input_Number, "", "", "", "");
			
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
				

			waitForElement(driver, Actual_Cust_All);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);

				globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, Customer_Code, "", "",
						"", "");

				waitForElement(driver, In_Show_BL_Button);
				click(driver, In_Show_BL_Button);
			}
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
			waitForElement(driver, By_Vessel_Button_All);
			click(driver, By_Vessel_Button_All);

			waitForElement(driver, Service_Code_Input_All);
			click(driver, Service_Code_Input_All);
			sendKeys(driver, Service_Code_Input_All, Service_Code);

			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, Vessel_Code);

			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, Voyage_Number);

			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_Input);

			waitForElement(driver, POL_PortCode_Input);
			sendKeys(driver, POL_PortCode_Input, Port_Code);

			horizontalscroll(driver, InvoiceGridScroll, 300);
			click(driver, POL_PortTerminal_Input);

			sendKeys(driver, POL_PortTerminal_Input, Terminal_Code);
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);
			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);

			waitForElement(driver, In_customer_Search_Button);
			click(driver, In_customer_Search_Button);

			globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, Customer_Code, "", "", "",
					"");

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
			
			
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
				
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Customer")) {
			waitForElement(driver, In_customer_Search_Button);
			click(driver, In_customer_Search_Button);

			globalValueSearchWindow(driver, Customer_Filter_Condition, Customer_Filter_Type, Customer_Code, "", "", "",
					"");

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
		}

		if (isdisplayed(driver, popup_Message)) {
			String popupText = getText(driver, popup_Message);
			if (popupText.equals(Invoice_Already_Exist)) {
				System.out.println("Popup Displayed After retrieving the BL : " + popupText);
				Extent_FailNew(driver, "Popup Displayed After retrieving the BL :  " + popupText, test, test1);
			} else {
				Extent_fail(driver, "Popup Displayed After retrieving the BL : " + popupText, test, test1);
			}
		}

		scrollTop(driver);

		waitForElement(driver, In_Issued_Button);
		click(driver, In_Issued_Button);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Invoice_saved_pop);
		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);
		if (import_saved_act.contains(Invoice_saved_pop)) {
			System.out.println(
					"Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act);
			Extent_fail(driver,
					"Not Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, Invoice_Table_Header_All);

		List<String> InvoiceSelectRow = splitAndExpand(Invoice_Validation_Row);
		List<String> columnHeaders = splitAndExpand(Invoice_Table_Headers);
		Map<String, Map<String, String>> InvoiceTableValues = new HashMap<String, Map<String, String>>();
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		System.out.println("TabledataFull : " + TabledataFull);
		String ETAValue = getText(driver, ETA_Date_Invoice_All);
		Input_Number = getAttribute(driver, BL_Number_Input_All, "value");
		String VesselValue;
		if (Invoice_ModuleType.equals("Invoice")) {
			waitForElement(driver, Vessel_TxtField_Invoice);
			VesselValue = getAttribute(driver, Vessel_TxtField_Invoice, "value");
		} else {
			waitForElement(driver, vessel_Txtfield_All);
			VesselValue = getAttribute(driver, vessel_Txtfield_All, "value");
		}
		String InvoiceNumber_Reverse = getFirstValueByHeader(TabledataFull, "Inv Number");
		List<String> ROE_Values = new ArrayList<String>();
		for (String rowCount : InvoiceSelectRow) {
			String SelectRowValidate = String.format(Invoice_Row_AllPage, rowCount);
			waitForElement(driver, Invoice_Table_Header_All);
			List<Map<String, String>> tabledata1 = getTableData(driver, Invoice_Table_Header_All, SelectRowValidate);
			Map<String, Map<String, String>> rowValues = getRowValuesByHeaders(tabledata1, columnHeaders, rowCount);
			System.out.println("rowValues : " + rowValues);
			String ROE_Value = getFirstValueByHeader(tabledata1, "ROE Type");
			ROE_Values.add(ROE_Value);

			InvoiceTableValues.putAll(rowValues);
		}

		String StartDate = getFirstValueByHeader(TabledataFull, "Inv Date");

		System.out.println("InvoiceTableValues  : " + InvoiceTableValues);
		moduleNavigate(driver, Agency_Master_Module_);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Agency_Master_Filter_Condition, Agency_Master_Filter_type, AgencyUser, "", "",
				"", "");

		waitForElement(driver, CurrencyCode_AgencyMaster);
		String Agency_ROE_ValueExp = getAttribute(driver, CurrencyCode_AgencyMaster, "value");

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, OFR_Module_Name);

		newButton(driver);

		waitForElement(driver, OFR_Date_Select_Input);
		selectDatePicker(driver, OFR_Date_Select_Input, StartDate);

		waitForElement(driver, OFR_Show_Button);
		click(driver, OFR_Show_Button);

		List<String> OFR_Headers = splitAndExpand(OFR_Table_Headers);

		waitForElement(driver, OFR_GridTable);

		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver, AG_Grid_Columns_Button_DW);
		waitForElement(driver, Column_Search_Input);
		click(driver, AG_Grid_Column_All_Select_Checkbox_DW);

		for (String FilterHeader : OFR_Headers) {
			waitForElement(driver, Column_Search_Input);
			clear(driver, Column_Search_Input);
			waitForElement(driver, Column_Search_Input);
			sendKeys(driver, Column_Search_Input, FilterHeader);

			String checkbox = String.format(Select_Column_tableHead, FilterHeader);
			waitForElement(driver, checkbox);
			jsClick(driver, checkbox);
		}

		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver, AG_Grid_Columns_Button_DW);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);

		int a = 0;
		for (Map.Entry<String, Map<String, String>> entry : InvoiceTableValues.entrySet()) {
			String key = entry.getKey();

			String InvoiceNumber = InvoiceTableValues.get(key).get("Inv Number");
			waitForElement(driver, Invoice_NumberFilter);
			clear(driver, Invoice_NumberFilter);
			sendKeys(driver, Invoice_NumberFilter, InvoiceNumber);

			waitForElement(driver, OFR_GridTable);
			waitForElement(driver, OFR_Grid_Row);

			List<Map<String, String>> StatusReport_TableData = extractTableDataByColumn(driver, OFR_GridTable);
			System.out.println("StatusReport_TableData : " + StatusReport_TableData);

			String ROE_ValueInvoice = ROE_Values.get(a);
			a++;
			String AmountValue_Invoice = InvoiceTableValues.get(key).get("Amount");

			String CurrencyStatus = getFirstValueByHeader(StatusReport_TableData, "Invoice Currency");

			double USD_AmountValue;
			double AgencyMaster_Amount;
			double Agency_Amount;
			if (ROE_ValueInvoice.equalsIgnoreCase("V")) {
				moduleNavigate(driver, Voyage_ROE_Module);

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, Voyage_ROE_Filter_Condition, Voyage_ROE_Filter_type, VesselValue, "",
						"", "", "");

				waitForElement(driver, MoreOption_Grid);
				click(driver,MoreOption_Grid);
				
				waitForElement(driver, FilterOption_Menu);
				click(driver,FilterOption_Menu);
				
				AG_Grid_FilterInputs(driver,Voyage_Currency_Header,"USD");
				
				waitForElement(driver, Voyage_Roe_Table);
				List<Map<String, String>> VoyageROE_TableFul = extractTableDataDirect2(driver, Voyage_Roe_Table);
				String USD_Value = getValueByFirstColumnAndHeader(VoyageROE_TableFul, Voyage_Currency_Header, "USD",
						Voyage_ROE_Header);
				USD_AmountValue = getNumberValue(USD_Value);
				
				
				AG_Grid_FilterInputs(driver,Voyage_Currency_Header,Agency_ROE_ValueExp);
				waitForElement(driver, Voyage_Roe_Table);
				List<Map<String, String>> VoyageROE_TableFul1 = extractTableDataByColumn(driver, Voyage_Roe_Table);
				
				String AgencyMasterValues = getValueByFirstColumnAndHeader(VoyageROE_TableFul1, Voyage_Currency_Header,
						Agency_ROE_ValueExp, Voyage_ROE_Header);
				AgencyMaster_Amount = getNumberValue(AgencyMasterValues);

				
				AG_Grid_FilterInputs(driver,Voyage_Currency_Header,CurrencyStatus);
				waitForElement(driver, Voyage_Roe_Table);
				List<Map<String, String>> VoyageROE_TableFul2 = extractTableDataByColumn(driver, Voyage_Roe_Table);
				String AgencyValues = getValueByFirstColumnAndHeader(VoyageROE_TableFul2, Voyage_Currency_Header,
						CurrencyStatus, Voyage_ROE_Header);
				Agency_Amount = getNumberValue(AgencyValues);
				

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);

			} else {
				moduleNavigate(driver, Agency_ROE_Module);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				String DateValue;
				if (ROE_ValueInvoice.equalsIgnoreCase("S")) {
					DateValue = ETAValue;
				} else {
					DateValue = StartDate;
				}

				waitForElement(driver, type_Select1);
				click(driver, type_Select1);
				waitForElement(driver, type_Select1);
				selectByText(driver, type_Select1, Agency_ROE_Filter_Type);
				if (Agency_ROE_Filter_Type.equalsIgnoreCase("Roe date")) {
					waitForElement(driver, Date_Condition);
					selectByText(driver, Date_Condition, Agency_ROE_Filter_Condition);
					waitForElement(driver, Date_Input_);
					sendKeys(driver, Date_Input_, DateValue);
				} else {
					waitForElement(driver, globalSearch_Condition_Dropdown1);
					selectByText(driver, globalSearch_Condition_Dropdown1, Agency_ROE_Filter_Condition);
					waitForElement(driver, globalSearch_InputTextfield1);
					click(driver, globalSearch_InputTextfield1);
					sendKeys(driver, globalSearch_InputTextfield1, DateValue);
				}

				waitForElement(driver, globalSearch_Frame_SearchButton);
				click(driver, globalSearch_Frame_SearchButton);
				waitForElement(driver, retrivedGlobalValue);
				click(driver, retrivedGlobalValue);
				waitForElement(driver, SelectButton);
				click(driver, SelectButton);
				
				waitForElement(driver, Corporate_Option_AgencyROE);
				click(driver,Corporate_Option_AgencyROE);
				
				waitForElement(driver, AgencyRoe_TableRow);
				List<Map<String, String>> AgencyROE_TableFul = getTableData(driver, AgencyRoe_TableHeader,
						AgencyRoe_TableRow);

				String USD_Value = getValueByFirstColumnAndHeader(AgencyROE_TableFul, Agency_ROE_Currency_Header, "USD",
						Agency_ROE_Header);
				USD_AmountValue = getNumberValue(USD_Value);
				String AgencyMasterValues = getValueByFirstColumnAndHeader(AgencyROE_TableFul,
						Agency_ROE_Currency_Header, Agency_ROE_ValueExp, Agency_ROE_Header);
				AgencyMaster_Amount = getNumberValue(AgencyMasterValues);

				String AgencyValues = getValueByFirstColumnAndHeader(AgencyROE_TableFul, Agency_ROE_Currency_Header,
						CurrencyStatus, Agency_ROE_Header);
				Agency_Amount = getNumberValue(AgencyValues);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			}
			double toleranceAmounut = Double.parseDouble(Tolerance_Value);
			waitForElement(driver, OFR_GridTable);
			double Exp_Amount_Invoice = getNumberValue(AmountValue_Invoice);
			for (String col : OFR_Headers) {
				String value = getFirstValueByHeader(StatusReport_TableData, col);
				System.out.println("col  :  " + col);
				System.out.println("value  :  " + value);
				double AmountValue = getNumberValue(value);
				if (col.equals("Invoice Amount")) {
					if (Exp_Amount_Invoice == AmountValue) {
						System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
								+ " || Expected value was : " + Exp_Amount_Invoice + " || Actual value was : "
								+ AmountValue);
						Extent_pass_New(driver, col + " Matched for " + CurrencyStatus + " || Expected value was : "
								+ Exp_Amount_Invoice + " || Actual value was : " + AmountValue, test, test1);
					} else {
						System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
								+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_Amount_Invoice
								+ " || Actual value was : " + AmountValue);
						Extent_fail(driver,
								col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
										+ " || Expected value was : " + Exp_Amount_Invoice + " || Actual value was : "
										+ AmountValue,
								test, test1);
					}
				} else if (col.equals("Invoice Amount In USD")) {
					double usdAmountExp = Exp_Amount_Invoice * (USD_AmountValue / Agency_Amount);
					usdAmountExp = Double.parseDouble(String.format("%.2f", usdAmountExp));
					if (compareAmounts(usdAmountExp, AmountValue, toleranceAmounut)) {
						System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
								+ " || Expected value was : " + usdAmountExp + " || Actual value was : " + AmountValue);
						Extent_pass_New(driver, col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
								+ " || Expected value was : " + usdAmountExp + " || Actual value was : " + AmountValue,
								test, test1);
					} else {
						System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
								+ Agency_ROE_ValueExp + " || Expected value was : " + usdAmountExp
								+ " || Actual value was : " + AmountValue);
						Extent_fail(driver,
								col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
										+ " || Expected value was : " + usdAmountExp + " || Actual value was : "
										+ AmountValue,
								test, test1);
					}
				} else if (col.equals("Invoice Amount In Home")) {
					Extent_cal(test, test1, "Find the Home Currnecy from agency master - Start");

					if (CurrencyStatus.equals(Agency_ROE_ValueExp)) {

						Extent_cal(test, test1,
								"Case 1: If Invoice currency and Agency master Currency Same Directly Paste the Invoice Amount Value in Invoice Amount in Home Currency - Start");
						if (Exp_Amount_Invoice == AmountValue) {
							System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_Amount_Invoice
									+ " || Actual value was : " + AmountValue);
							Extent_pass_New(driver,
									col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + Exp_Amount_Invoice
											+ " || Actual value was : " + AmountValue,
									test, test1);
						} else {
							System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_Amount_Invoice
									+ " || Actual value was : " + AmountValue);
							Extent_fail(driver,
									col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + Exp_Amount_Invoice
											+ " || Actual value was : " + AmountValue,
									test, test1);
						}
						Extent_cal(test, test1,
								"Case 1: If Invoice currency and Agency master Currency Same Directly Paste the Invoice Amount Value in Invoice Amount in Home Currency - End");

					} else if (CurrencyStatus.equalsIgnoreCase("USD")) {

						Extent_cal(test, test1,
								"Case2 : If Invoice currency and Agency master Currency Different follow below, \r\n"
										+ "if agency master currency is USD Follow Below steps -  Start");
						double expHomeAmount = Exp_Amount_Invoice * AgencyMaster_Amount;
						if (compareAmounts(expHomeAmount, AmountValue, toleranceAmounut)) {
							System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
									+ " || Actual value was : " + AmountValue);
							Extent_pass_New(driver,
									col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + expHomeAmount + " || Actual value was : "
											+ AmountValue,
									test, test1);
						} else {
							System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
									+ " || Actual value was : " + AmountValue);
							Extent_fail(driver,
									col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + expHomeAmount + " || Actual value was : "
											+ AmountValue,
									test, test1);
						}
						Extent_cal(test, test1,
								"Case2 : If Invoice currency and Agency master Currency Different follow below, \r\n"
										+ "if agency master currency is USD Follow Below steps -  End");
					} else {
						Extent_cal(test, test1,
								"Case2 A : if agency master currency is Third Party(Not USD and Not Invoice Currency) Follow Below steps  - Start");

						double expHomeAmount = Exp_Amount_Invoice * (AgencyMaster_Amount / Agency_Amount);
						if (compareAmounts(expHomeAmount, AmountValue, toleranceAmounut)) {
							System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
									+ " || Actual value was : " + AmountValue);
							Extent_pass_New(driver,
									col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + expHomeAmount + " || Actual value was : "
											+ AmountValue,
									test, test1);
						} else {
							System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
									+ " || Actual value was : " + AmountValue);
							Extent_fail(driver,
									col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + expHomeAmount + " || Actual value was : "
											+ AmountValue,
									test, test1);
						}
						Extent_cal(test, test1,
								"Case2 A : if agency master currency is Third Party(Not USD and Not Invoice Currency) Follow Below steps  - End");

					}
					Extent_cal(test, test1, "Find the Home Currnecy from agency master - End");
				}

				if (columnHeaders.contains("Balance")) {
					String BalanceAmount_Invoice = InvoiceTableValues.get(key).get("Balance");
					double Exp_BalaceAmount_Invoice = getNumberValue(BalanceAmount_Invoice);

					if (col.equals("Balance Amount")) {
						if (Exp_BalaceAmount_Invoice == AmountValue) {
							System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_BalaceAmount_Invoice
									+ " || Actual value was : " + AmountValue);
							Extent_pass_New(driver,
									col + " Matched for " + CurrencyStatus + " || Expected value was : "
											+ Exp_BalaceAmount_Invoice + " || Actual value was : " + AmountValue,
									test, test1);
						} else {
							System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_BalaceAmount_Invoice
									+ " || Actual value was : " + AmountValue);
							Extent_fail(driver,
									col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + Exp_BalaceAmount_Invoice
											+ " || Actual value was : " + AmountValue,
									test, test1);
						}
					} else if (col.equals("Balance Amount In USD")) {
						double usdAmountExp = Exp_BalaceAmount_Invoice * (USD_AmountValue / Agency_Amount);
						usdAmountExp = Double.parseDouble(String.format("%.2f", usdAmountExp));
						if (compareAmounts(usdAmountExp, AmountValue, toleranceAmounut)) {
							System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + usdAmountExp
									+ " || Actual value was : " + AmountValue);
							Extent_pass_New(driver,
									col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + usdAmountExp + " || Actual value was : "
											+ AmountValue,
									test, test1);
						} else {
							System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + usdAmountExp
									+ " || Actual value was : " + AmountValue);
							Extent_fail(driver,
									col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
											+ " || Expected value was : " + usdAmountExp + " || Actual value was : "
											+ AmountValue,
									test, test1);
						}
					} else if (col.equals("Balance Amount In Home")) {
						if (CurrencyStatus.equals(Agency_ROE_ValueExp)) {
							Extent_cal(test, test1,
									"Case 1: If Invoice currency and Agency master Currency Same Directly Paste the Invoice Amount Value in Invoice Amount in Home Currency - Start");
							if (Exp_BalaceAmount_Invoice == AmountValue) {
								System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_BalaceAmount_Invoice
										+ " || Actual value was : " + AmountValue);
								Extent_pass_New(driver,
										col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
												+ " || Expected value was : " + Exp_BalaceAmount_Invoice
												+ " || Actual value was : " + AmountValue,
										test, test1);
							} else {
								System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_BalaceAmount_Invoice
										+ " || Actual value was : " + AmountValue);
								Extent_fail(driver,
										col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
												+ " || Expected value was : " + Exp_BalaceAmount_Invoice
												+ " || Actual value was : " + AmountValue,
										test, test1);
							}
							Extent_cal(test, test1,
									"Case 1: If Invoice currency and Agency master Currency Same Directly Paste the Invoice Amount Value in Invoice Amount in Home Currency - End");

						} else if (CurrencyStatus.equalsIgnoreCase("USD")) {

							Extent_cal(test, test1,
									"Case2 : If Invoice currency and Agency master Currency Different follow below, \r\n"
											+ "if agency master currency is USD Follow Below steps -  Start");
							double expHomeAmount = Exp_BalaceAmount_Invoice * AgencyMaster_Amount;
							if (compareAmounts(expHomeAmount, AmountValue, toleranceAmounut)) {
								System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + AmountValue);
								Extent_pass_New(driver,
										col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
												+ " || Expected value was : " + expHomeAmount
												+ " || Actual value was : " + AmountValue,
										test, test1);
							} else {
								System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + AmountValue);
								Extent_fail(driver,
										col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
												+ " || Expected value was : " + expHomeAmount
												+ " || Actual value was : " + AmountValue,
										test, test1);
							}
							Extent_cal(test, test1,
									"Case2 : If Invoice currency and Agency master Currency Different follow below, \r\n"
											+ "if agency master currency is USD Follow Below steps -  End");
						} else {
							Extent_cal(test, test1,
									"Case2 A : if agency master currency is Third Party(Not USD and Not Invoice Currency) Follow Below steps  - Start");

							double expHomeAmount = Exp_BalaceAmount_Invoice * (AgencyMaster_Amount / Agency_Amount);
							if (compareAmounts(expHomeAmount, AmountValue, toleranceAmounut)) {
								System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + AmountValue);
								Extent_pass_New(driver,
										col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
												+ " || Expected value was : " + expHomeAmount
												+ " || Actual value was : " + AmountValue,
										test, test1);
							} else {
								System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + AmountValue);
								Extent_fail(driver,
										col + " Not Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
												+ " || Expected value was : " + expHomeAmount
												+ " || Actual value was : " + AmountValue,
										test, test1);
							}
							Extent_cal(test, test1,
									"Case2 A : if agency master currency is Third Party(Not USD and Not Invoice Currency) Follow Below steps  - End");
						}
					}

				}
			}

		}

		if (Delete_Invoice.equalsIgnoreCase("Yes")) {
			Extent_cal(test, test1, "Delete / Reverse Invoice - Start");

			Invoice_Reversal(driver,Invoice_Reversel_Module,Reversal_Condition,Reversal_Filter_Type_Vessel,InvoiceNumber_Reverse,Invoice_Reversal_Remark,Invoice_Reversal_Success);
			
//			moduleNavigate(driver, Invoice_Reversel_Module);
//
//			newButton(driver);
//
//			waitForElement(driver, invoiceNo_SearchButton);
//			click(driver, invoiceNo_SearchButton);
//
//			waitForElement(driver, select_first);
//			if (!BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
//				selectByText(driver, select_first, Reversal_Filter_Type);
//			} else {
//				selectByText(driver, select_first, Reversal_Filter_Type_Vessel);
//			}
//			waitForElement(driver, globalSearch_Condition_Dropdown1);
//			selectByText(driver, globalSearch_Condition_Dropdown1, Reversal_Condition);
//			waitForElement(driver, globalSearch_InputTextfield1);
//			if (!BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
//				sendKeys(driver, globalSearch_InputTextfield1, Input_Number);
//			} else {
//				sendKeys(driver, globalSearch_InputTextfield1, InvoiceNumber_Reverse);
//			}
//
//			waitForElement(driver, globalSearch_Frame_SearchButton);
//			click(driver, globalSearch_Frame_SearchButton);
//
//			waitForElement(driver, retrivedGlobalValue);
//			click(driver, retrivedGlobalValue);
//			waitForElement(driver, SelectButton);
//			click(driver, SelectButton);
//
//			waitForElement(driver, invoiceReversal_Show_Button);
//			click(driver, invoiceReversal_Show_Button);
//
//			waitForElement(driver, inv_Reversal_Table_Header);
//			List<Map<String, String>> invoice_Details_Table = getTableData(driver, inv_Reversal_Table_Header,
//					invoiceReversal_Table_Rows);
//
//			List<String> invoice_Numbers = getValuesByHeader(invoice_Details_Table, "Invoice No");
//
//			System.out.println("INVOICE NUMBERS SHOWN IN THE GRID ARE :" + invoice_Numbers);
//
//			waitForElement(driver, invoiceReversal_Table_Rows);
//			if (!BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
//				click(driver, invoiceReversal_Table_Rows);
//			} else {
//				List<WebElement> invoicesRow = listOfElements(driver, invoiceReversal_Table_Rows);
//				int lastSize = invoicesRow.size() - 1;
//				invoicesRow.get(lastSize).click();
//			}
//
//			click(driver, invoiceReversal_Remarks_TextArea);
//			sendKeys(driver, invoiceReversal_Remarks_TextArea, Invoice_Reversal_Remark);
//
//			scrollTop(driver);
//			waitForElement(driver, SaveButton_ToolBar);
//			click1(driver, SaveButton_ToolBar);
//
//			waitForElement(driver, popup_Message);
//			String ReversalMessage = getText(driver, popup_Message);
//			if (ReversalMessage.contains(Reversal_Invoice_Popup)) {
//				System.out.println(
//						"Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage);
//				Extent_pass_New(driver,
//						"Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage, test,
//						test1);
//				waitForElement(driver, popup_Message_Yes_Button);
//				click(driver, popup_Message_Yes_Button);
//			} else if (ReversalMessage.contains(Reversal_Invoice_Popup_Group)) {
//				System.out.println(
//						"Matched || Expected : " + Reversal_Invoice_Popup_Group + "  || Actual : " + ReversalMessage);
//				Extent_pass_New(driver,
//						"Matched || Expected : " + Reversal_Invoice_Popup_Group + "  || Actual : " + ReversalMessage,
//						test, test1);
//				waitForElement(driver, popup_Message_Yes_Button);
//				click(driver, popup_Message_Yes_Button);
//			} else {
//				System.out.println(
//						"Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage);
//				Extent_fail(driver,
//						"Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage, test,
//						test1);
//			}
//
//			waitForPopup(driver, popup_Message, Invoice_Reversal_Success);
//			String ReversalSuccessMessage = getText(driver, popup_Message);
//			if (ReversalSuccessMessage.contains(Invoice_Reversal_Success)) {
//				System.out.println("Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : "
//						+ ReversalSuccessMessage);
//				Extent_pass_New(driver,
//						"Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : " + ReversalSuccessMessage,
//						test, test1);
//				waitForElement(driver, popup_Message_Ok_Button);
//				click(driver, popup_Message_Ok_Button);
//			} else {
//				System.out.println("Not Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : "
//						+ ReversalSuccessMessage);
//				Extent_fail(driver, "Not Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : "
//						+ ReversalSuccessMessage, test, test1);
//			}

			Extent_cal(test, test1, "Delete / Reverse Invoice - End");
		}

		Extent_completed(testcase_Name, test, test1);

	}

}
