package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Invoice_Status_Report_SC038D extends Keywords {

	public void Invoice_Status_Report_SC038D(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Invoice_Status_Report_SC038D";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Invoice_Validation_Row = Excel_data.get("Invoice_Validation_Row");
		String Amount_Validation_Header_Status = Excel_data.get("Amount_Validation_Header_Status");
		String Invoice_Status_Module = Excel_data.get("Invoice_Status_Module");
		String Invoice_Status_Filters_New = Excel_data.get("Invoice_Status_Filters_New");
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

		String Agency_Master_Module_ = Excel_data.get("Agency_Master_Module_");
		String Agency_Master_Filter_type = Excel_data.get("Agency_Master_Filter_type");
		String Agency_Master_Filter_Condition = Excel_data.get("Agency_Master_Filter_Condition");

		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Invoice_Reversel_Module = Excel_data.get("Invoice_Reversel_Module");
		String Reversal_Filter_Type = Excel_data.get("Reversal_Filter_Type");
		String Reversal_Condition = Excel_data.get("Reversal_Condition");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");
		String Tolerance_Value = Excel_data.get("Tolerance_Value");
		String Invoice_ModuleType = Excel_data.get("Invoice_ModuleType");
		String Select_Invoice_Mode = Excel_data.get("Select_Invoice_Mode");
		
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Invoice_GlobalSearch_Type1 = Excel_data.get("Invoice_GlobalSearch_Type1");
		String Invoice_GlobalSearch_Value1 = Excel_data.get("Invoice_GlobalSearch_Value1");
		String Invoice_GlobalSearch_Type2 = Excel_data.get("Invoice_GlobalSearch_Type2");
		String Invoice_GlobalSearch_Value2 = Excel_data.get("Invoice_GlobalSearch_Value2");
		String Invoice_GlobalSearch_Type3 = Excel_data.get("Invoice_GlobalSearch_Type3");
		String Invoice_GlobalSearch_Value3 = Excel_data.get("Invoice_GlobalSearch_Value3");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Invoice_Already_Exist = Excel_data.get("Invoice_Already_Exist");
		String customer_Code_SearchType = Excel_data.get("customer_Code_SearchType");
		String customer_Code_Input = Excel_data.get("customer_Code_Input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Invoice_saved_pop = Excel_data.get("Invoice_saved_pop");
		String Invoice_Status_Report_StartDate = Excel_data.get("Invoice_Status_Report_StartDate");
		String Invoice_Status_Report_EndDate = Excel_data.get("Invoice_Status_Report_EndDate");
		String Invoice_Headers_Values = Excel_data.get("Invoice_Headers_Values");		
		
		String Invoice_Save_Option = Excel_data.get("Invoice_Save_Option");
		String Delete_Draft_Invoice_popup = Excel_data.get("Delete_Draft_Invoice_popup");
		String Draft_Invoice_Deleted_Popup = Excel_data.get("Draft_Invoice_Deleted_Popup");

		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "Open Invoice Module", test, test1);

		moduleNavigate(driver, Invoice_ModuleType);
		
		Step_End(1, "open the import invoice module.", test, test1);

     	waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);
		formatLocatorClick(driver, DropDown_Select, Select_Invoice_Mode);

		newButton(driver);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL") || BL_Retrive_Option.equalsIgnoreCase("By_Book")) {
			// button click
			if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
				waitForElement(driver, By_BL_NumberBtn_All);
				click(driver, By_BL_NumberBtn_All);
			} else {
				waitForElement(driver, By_Book_Button_All);
				click(driver, By_Book_Button_All);
			}
			waitForElement(driver, In_bl_Search_Button);
			click(driver, In_bl_Search_Button);

			globalValueSearchWindow(driver, Global_Search_Condition, Invoice_GlobalSearch_Type1, Invoice_GlobalSearch_Value1, Invoice_GlobalSearch_Type2, Invoice_GlobalSearch_Value2,Invoice_GlobalSearch_Type3, Invoice_GlobalSearch_Value3);				

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
			
			if (isdisplayed(driver, popup_Message)) {
				String poputext_Act = getText(driver, popup_Message);
				if (poputext_Act.equals(Invoice_Already_Exist)) {
					System.out.println("Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act);
					Extent_FailNew(driver,"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				} else {
					System.out.println("Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
								+ poputext_Act);
					Extent_fail(driver,"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				}
			}

			waitForElement(driver, invoice_Customer_Text_Field);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.trim().equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);

				globalValueSearchWindow(driver, Global_Search_Condition, customer_Code_SearchType, customer_Code_Input, "", "", "", "");

				waitForElement(driver, In_Show_BL_Button);
				click(driver, In_Show_BL_Button);
			}
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
			waitForElement(driver, By_Vessel_Button_All);
			click(driver, By_Vessel_Button_All);
			waitForElement(driver, invoice_Service_Text_Field);
			sendKeys(driver, invoice_Service_Text_Field, Service_Code);

			if(!Vessel_Code.trim().equals("")) {
				waitForElement(driver, vessels_code_input);
				sendKeys(driver, vessels_code_input, Vessel_Code);
			}
			
			if(!Voyage_Number.trim().equals("")) {
				waitForElement(driver, voyage_code_input);
				sendKeys(driver, voyage_code_input, Voyage_Number);
			}
			
			if(!Bound_Input.trim().equals("")) {
				waitForElement(driver, bounnd_code_input);
				sendKeys(driver, bounnd_code_input, Bound_Input);
			}
			
			if(!Port_Code.trim().equals("")) {
				waitForElement(driver, POL_PortCode_Input);
				sendKeys(driver, POL_PortCode_Input, Port_Code);
			}
			
			if(!Terminal_Code.trim().equals("")) {
				horizontalscroll(driver, InvoiceGridScroll, 300);
				click(driver, POL_PortTerminal_Input);
				sendKeys(driver, POL_PortTerminal_Input, Terminal_Code);
			}
			
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);
			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);

			waitForElement(driver, invoice_Customer_Text_Field);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.trim().equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);

				globalValueSearchWindow(driver, Global_Search_Condition, customer_Code_SearchType, customer_Code_Input, "", "", "", "");

			}
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

			globalValueSearchWindow(driver, Global_Search_Condition, customer_Code_SearchType, customer_Code_Input, "", "", "", "");

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
		}

		scrollTop(driver);
		if(Invoice_Save_Option.equalsIgnoreCase("Draft")) {
			waitForElement(driver, import_invoice_draft_button);
			click(driver,import_invoice_draft_button);
		}else {
			waitForElement(driver, In_Issued_Button);
			click(driver, In_Issued_Button);
		}
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Invoice_saved_pop);
		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);
		if (Invoice_saved_pop.equalsIgnoreCase(import_saved_act)) {
			System.out.println("Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,"Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act, test,
					test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act);
			Extent_fail(driver,"Not Matched || Expected Popup : " + Invoice_saved_pop + " || Actual Popup : " + import_saved_act,
					test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(6, "bl details and charges has to be shown in below tab for that bl no", test, test1);

		String VesselValue;
		if (Invoice_ModuleType.equals("Invoice")) {
			waitForElement(driver, Vessel_TxtField_Invoice);
			VesselValue = getAttribute(driver, Vessel_TxtField_Invoice, "value");
		} else {
			waitForElement(driver, vessel_Txtfield_All);
			VesselValue = getAttribute(driver, vessel_Txtfield_All, "value");
		}

		Extent_cal(test, test1, "Get All the Details from Invoice Module  - start");

		List<String> InvoiceSelectRow = splitAndExpand(Invoice_Validation_Row);
		Map<String, Map<String, String>> InvoiceTableValues = new HashMap<String, Map<String, String>>();

		waitForElement(driver, BL_Number_Input_All);
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");
		String ETAValue = getText(driver, ETA_Date_Input_All);

		List<String> columnHeaders = splitAndExpand(Invoice_Headers_Values);
		for (String rowCount : InvoiceSelectRow) {
			String SelectRowValidate = String.format(Invoice_Row_AllPage, rowCount);
			waitForElement(driver, Invoice_Table_Header_All);
			List<Map<String, String>> tabledata1 = getTableData(driver, Invoice_Table_Header_All, SelectRowValidate);
			Map<String, Map<String, String>> rowValues = getRowValuesByHeaders(tabledata1, columnHeaders, rowCount);

			rowValues.get(rowCount).put("BL Number", BL_Number_input);

			InvoiceTableValues.putAll(rowValues);
		}
		
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String AmountValuesExp_Tabledata = TableDataForReport(driver, TabledataFull, "Invoice Table Data",
				columnHeaders);
		
		String StartDate = InvoiceTableValues.get(InvoiceSelectRow.get(0)).get("Inv Date");
		
		List<String> ROE_Values=getValuesByHeader(TabledataFull,"ROE Type");
		List<String> CurrecnyNames=getValuesByHeader(TabledataFull,"Inv Currency");
		
		String Inv_Sts_Rep_StartDate=beforeDaysToDate(StartDate, Invoice_Status_Report_StartDate);
		String Inv_Sts_Rep_EndDate=addDaysToDate(StartDate, Invoice_Status_Report_EndDate);
		
		Extent_cal(test, test1, "Get All the Details from Invoice Module  - End");
		moduleNavigate(driver, Agency_Master_Module_);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Agency_Master_Filter_Condition, Agency_Master_Filter_type, AgencyUser, "", "",
				"", "");

		waitForElement(driver, CurrencyCode_AgencyMaster);
		String Agency_ROE_ValueExp = getAttribute(driver, CurrencyCode_AgencyMaster, "value");

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_Start(2, "Go to Invoice status Report", test, test1);
		moduleNavigate(driver, Invoice_Status_Module);
		waitForElement(driver, NewButton_ToolBar);
		Step_End(2, "Go to Invoice status Report", test, test1);

		Step_Start(3, "select from and To date as per Invoice Date", test, test1);
		waitForElement(driver, FromDate_ISR);
		selectDatePicker(driver, FromDate_ISR, Inv_Sts_Rep_StartDate);
		waitForElement(driver, ToDate_ISR);
		selectDatePicker(driver, ToDate_ISR, Inv_Sts_Rep_EndDate);
		Step_End(3, "select from and To date as per Invoice Date", test, test1);

		Step_Start(4, "click on show Button", test, test1);
		waitForElement(driver, ShowButton_ISR);
		click(driver, ShowButton_ISR);
		Step_End(4, "click on show Button", test, test1);

		Step_Start(5, "Verify that below Invoice Number,\r\n" + "Invoice Date,\r\n" + "Invoice Status\r\n"
				+ "Customer Code,\r\n" + "Customer Name\r\n" + "Vessel,Voyage,Bound,\r\n" + "Invoice Due Date\r\n"
				+ "BL Number\r\n" + "ETD\r\n" + "ETA\r\n" + "Invoice Currency\r\n" + "Invoice Amount", test, test1);
		waitForElement(driver, TableGrid_ISR);
		List<String> FilterHeadersName = splitAndExpand(Invoice_Status_Filters_New);
		
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		
		waitForElement(driver, invoice_sts_filter_input);
		if(Invoice_Save_Option.equalsIgnoreCase("Draft")) {
			sendKeys(driver, invoice_sts_filter_input, "Draft");
		}else {
			sendKeys(driver, invoice_sts_filter_input, "Confirm");
		}	
		
		waitForElement(driver, II_Status_Column);
		click(driver, II_Status_Column);

		waitForElement(driver, Column_Search_Input);
		click(driver, SelectAll_Column_CheckBox);

		for (String FilterHeader : FilterHeadersName) {
			waitForElement(driver, Column_Search_Input);
			clear(driver, Column_Search_Input);
			waitForElement(driver, Column_Search_Input);
			sendKeys(driver, Column_Search_Input, FilterHeader);

			String checkbox = String.format(Select_Column_tableHead, FilterHeader);
			waitForElement(driver, checkbox);
			jsClick(driver, checkbox);
		}

		
		List<String> columns = splitAndExpand(Amount_Validation_Header_Status);
		for (String column : columns) {
			if (Invoice_Status_Filters_New.contains(column)) {
				continue;
			}
			waitForElement(driver, Column_Search_Input);
			clear(driver, Column_Search_Input);
			waitForElement(driver, Column_Search_Input);
			sendKeys(driver, Column_Search_Input, column);

			String checkbox = String.format(Select_Column_tableHead, column);
			waitForElement(driver, checkbox);
			jsClick(driver, checkbox);
		}
	

		waitForElement(driver, II_Status_Column);
		click(driver, II_Status_Column);
		
		for (Map.Entry<String, Map<String, String>> entry : InvoiceTableValues.entrySet()) {
			String key = entry.getKey();

			List<String> filterdetailHeader1 = splitAndExpand(Invoice_Status_Filters_New);
			for (String head : filterdetailHeader1) {
				if (head.equals("Invoice Number")) {
					String InvoiceNumber = InvoiceTableValues.get(key).get("Inv Number");
					if(InvoiceNumber!=null&&!InvoiceNumber.equals("-")) {
						waitForElement(driver, InVoiceNumber_FilterInput);
						Newclear(driver, InVoiceNumber_FilterInput);
						sendKeys(driver, InVoiceNumber_FilterInput, InvoiceNumber);
					}
				} else if (head.equals("BL Number")) {
					if(BL_Number_input!=null&&!BL_Number_input.equals("-")) {
						waitForElement(driver, BL_Search_input);
						Newclear(driver, BL_Search_input);
						sendKeys(driver, BL_Search_input, BL_Number_input);
					}
				} else if (Select_Invoice_Mode.equals("Manifest Corrector Invoice")) {
					if(BL_Number_input!=null&&!BL_Number_input.equals("-")) {
						waitForElement(driver, MCN_NumberFilter_Input);
						Newclear(driver, MCN_NumberFilter_Input);
						sendKeys(driver, MCN_NumberFilter_Input, BL_Number_input);
					}
				}
			}
		
			waitForElement(driver, TableGrid_ISR);
			waitForElement(driver, statusReporttableRow);
			List<Map<String, String>> StatusReport_TableData = extractTableDataByColumn(driver, TableGrid_ISR);
			System.out.println("StatusReport_TableData : " + StatusReport_TableData);
			
			List<String> tableReportColumns=new ArrayList<String>();
			tableReportColumns.addAll(columns);
			tableReportColumns.addAll(FilterHeadersName);
			
			String Act_Tabledata = TableDataForReport(driver, StatusReport_TableData,"Invoice Status Report Table Data", tableReportColumns);

			int val_Row=Integer.parseInt(key)-1;
			String ROE_ValueInvoice =  ROE_Values.get(val_Row);			
			String AmountValue_Invoice = InvoiceTableValues.get(key).get("Amount");
						
			String CurrencyStatus =CurrecnyNames.get(val_Row) ;     

			double USD_AmountValue;
			double AgencyMaster_Amount;
			double Agency_Amount;
			if (ROE_ValueInvoice.equalsIgnoreCase("V")) {
				moduleNavigate(driver, Voyage_ROE_Module);

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, Voyage_ROE_Filter_Condition, Voyage_ROE_Filter_type, VesselValue,
						"", "", "", "");

				waitForElement(driver, MoreOption_Grid);
				click(driver,MoreOption_Grid);
				
				waitForElement(driver, FilterOption_Menu);
				click(driver,FilterOption_Menu);
				
				AG_Grid_FilterInputs(driver,Voyage_Currency_Header,"USD");
				
				waitForElement(driver, Voyage_Roe_Table);
				List<Map<String, String>> VoyageROE_TableFul = extractTableDataByColumn(driver, Voyage_Roe_Table);
				String USD_Value = getValueByFirstColumnAndHeader(VoyageROE_TableFul, Voyage_Currency_Header, "USD",
						Voyage_ROE_Header);
				USD_AmountValue = getNumberValue1(USD_Value);
				
				AG_Grid_FilterInputs(driver,Voyage_Currency_Header,Agency_ROE_ValueExp);
				waitForElement(driver, Voyage_Roe_Table);
				List<Map<String, String>> VoyageROE_TableFul1 = extractTableDataByColumn(driver, Voyage_Roe_Table);
				String AgencyMasterValues = getValueByFirstColumnAndHeader(VoyageROE_TableFul1,
						Voyage_Currency_Header, Agency_ROE_ValueExp, Voyage_ROE_Header);
				AgencyMaster_Amount = getNumberValue1(AgencyMasterValues);

				
				AG_Grid_FilterInputs(driver,Voyage_Currency_Header,CurrencyStatus);
				waitForElement(driver, Voyage_Roe_Table);
				List<Map<String, String>> VoyageROE_TableFul2 = extractTableDataByColumn(driver, Voyage_Roe_Table);
				String AgencyValues = getValueByFirstColumnAndHeader(VoyageROE_TableFul2, Voyage_Currency_Header,
						CurrencyStatus, Voyage_ROE_Header);
				Agency_Amount = getNumberValue1(AgencyValues);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);

			} else {

				moduleNavigate(driver, Agency_ROE_Module);
				waitForElement(driver, SearchButton_Toolbar);
				if(isdisplayed(driver, popup_Message_Ok_Button)) {
					waitForDisplay(driver, popup_Message_Ok_Button);
					jsClick(driver, popup_Message_Ok_Button);
					waitForElement(driver, SearchButton_Toolbar);
				}
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

				String USD_Value = getValueByFirstColumnAndHeader(AgencyROE_TableFul, Agency_ROE_Currency_Header,
						"USD", Agency_ROE_Header);
				USD_AmountValue = getNumberValue1(USD_Value);
				String AgencyMasterValues = getValueByFirstColumnAndHeader(AgencyROE_TableFul,
						Agency_ROE_Currency_Header, Agency_ROE_ValueExp, Agency_ROE_Header);
				AgencyMaster_Amount = getNumberValue1(AgencyMasterValues);

				String AgencyValues = getValueByFirstColumnAndHeader(AgencyROE_TableFul, Agency_ROE_Currency_Header,
						CurrencyStatus, Agency_ROE_Header);
				Agency_Amount = getNumberValue1(AgencyValues);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			}
			double toleranceAmounut = Double.parseDouble(Tolerance_Value);
			waitForElement(driver, TableGrid_ISR);
			double Exp_Amount_Invoice = getNumberValue(AmountValue_Invoice);
			
			Extent_call(test, test1, "Invoice Table data was : \n" + "<pre>" + AmountValuesExp_Tabledata
					+ "</pre> \n " + "|| Status Report Table data was : \n" + "<pre>" + Act_Tabledata
					+ "</pre>");
			
			List<String> columns1 = splitAndExpand(Amount_Validation_Header_Status);
			for (String col : columns1) {
				
				String value="";
				if(Invoice_Save_Option.equalsIgnoreCase("Draft")) {
					value = getHeaderValueByRow(StatusReport_TableData,col,key);  
				}else {
					value = getHeaderValueByRow(StatusReport_TableData,col,"1");  
				}
				
				System.out.println("col  :  " + col);
				System.out.println("value  :  " + value);
				double AmountValue = getNumberValue(value);
				if (col.equals("Invoice Amount")) {
					if (Exp_Amount_Invoice == AmountValue) {
						System.out.println(col + " Matched for " + CurrencyStatus + "  Agency : "
								+ Agency_ROE_ValueExp + " || Expected value was : " + Exp_Amount_Invoice
								+ " || Actual value was : " + AmountValue);
						Extent_pass_New(driver,
								col + " Matched for " + CurrencyStatus + " || Expected value was : "
										+ Exp_Amount_Invoice + " || Actual value was : " + AmountValue,
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
				} else if (col.equals("Invoice Amount In USD")) {
					double usdAmountExp = Exp_Amount_Invoice * (USD_AmountValue / Agency_Amount);
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
						expHomeAmount = Double.parseDouble(String.format("%.2f", expHomeAmount));
						
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

						double expHomeAmount = Exp_Amount_Invoice * (AgencyMaster_Amount / Agency_Amount);
						expHomeAmount = Double.parseDouble(String.format("%.2f", expHomeAmount));
						
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
										+ Agency_ROE_ValueExp + " || Expected value was : "
										+ Exp_BalaceAmount_Invoice + " || Actual value was : " + AmountValue);
								Extent_pass_New(driver,
										col + " Matched for " + CurrencyStatus + "  Agency : " + Agency_ROE_ValueExp
												+ " || Expected value was : " + Exp_BalaceAmount_Invoice
												+ " || Actual value was : " + AmountValue,
										test, test1);
							} else {
								System.out.println(col + " Not Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : "
										+ Exp_BalaceAmount_Invoice + " || Actual value was : " + AmountValue);
								Extent_fail(driver, col + " Not Matched for " + CurrencyStatus + "  Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : "
										+ Exp_BalaceAmount_Invoice + " || Actual value was : " + AmountValue, test,
										test1);
							}
							Extent_cal(test, test1,
									"Case 1: If Invoice currency and Agency master Currency Same Directly Paste the Invoice Amount Value in Invoice Amount in Home Currency - End");

						} else if (CurrencyStatus.equalsIgnoreCase("USD")) {

							Extent_cal(test, test1,
									"Case2 : If Invoice currency and Agency master Currency Different follow below, \r\n"
											+ "if agency master currency is USD Follow Below steps -  Start");
							double expHomeAmount = Exp_BalaceAmount_Invoice * AgencyMaster_Amount;
							expHomeAmount = Double.parseDouble(String.format("%.2f", expHomeAmount));
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
										col + " Not Matched for " + CurrencyStatus + "  Agency : "
												+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
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
							expHomeAmount = Double.parseDouble(String.format("%.2f", expHomeAmount));
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
										col + " Not Matched for " + CurrencyStatus + "  Agency : "
												+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
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

		Step_End(5, "Verify that below Invoice Number,\r\n" + "Invoice Date,\r\n" + "Invoice Status\r\n"
				+ "Customer Code,\r\n" + "Customer Name\r\n" + "Vessel,Voyage,Bound,\r\n" + "Invoice Due Date\r\n"
				+ "BL Number\r\n" + "ETD\r\n" + "ETA\r\n" + "Invoice Currency\r\n" + "Invoice Amount", test, test1);

	
		if (Delete_Invoice.equalsIgnoreCase("Yes")) {
			Extent_cal(test, test1, "Delete / Reverse Invoice - Start");

			if(Invoice_Save_Option.equalsIgnoreCase("Draft")) {
				waitForElement(driver, Close_Current_tab);
				click(driver,Close_Current_tab);
				deleteImportDocument(driver, Delete_Draft_Invoice_popup, Draft_Invoice_Deleted_Popup);
				
			}else {
				Invoice_Reversal(driver,Invoice_Reversel_Module,Reversal_Condition,Reversal_Filter_Type,BL_Number_input,Invoice_Reversal_Remark,Invoice_Reversal_Success);
			}
			Extent_cal(test, test1, "Delete / Reverse Invoice - End");
			
		}

		Extent_completed(testcase_Name, test, test1);
	}

}
