package LRP_Import_Invoice_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Invoice_Status_Report_SC038F extends Keywords{

	public void Invoice_Status_Report_SC038F(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		
		String testcase_Name = "TC_Invoice_Status_Report_SC038F";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Invoice_GlobalSearch_Type1 = Excel_data.get("Invoice_GlobalSearch_Type1");
		String Invoice_GlobalSearch_Value1 = Excel_data.get("Invoice_GlobalSearch_Value1");
		String Invoice_GlobalSearch_Type2 = Excel_data.get("Invoice_GlobalSearch_Type2");
		String Invoice_GlobalSearch_Value2 = Excel_data.get("Invoice_GlobalSearch_Value2");
		String Invoice_GlobalSearch_Type3 = Excel_data.get("Invoice_GlobalSearch_Type3");
		String Invoice_GlobalSearch_Value3 = Excel_data.get("Invoice_GlobalSearch_Value3");
		String Invoice_Status_Module = Excel_data.get("Invoice_Status_Module");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Import_Invoice_ModuleName = Excel_data.get("Import_Invoice_ModuleName");
		String Select_Invoice_Mode = Excel_data.get("Select_Invoice_Mode");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
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
		String Service_Details_Headers_Invoice = Excel_data.get("Service_Details_Headers_Invoice");
		String Invoice_Status_Filters_New = Excel_data.get("Invoice_Status_Filters_New");
		String Service_Headers_Invoice_Status_Report = Excel_data.get("Service_Headers_Invoice_Status_Report");
		
		String Invoice_Status_Report_StartDate = Excel_data.get("Invoice_Status_Report_StartDate");
		String Invoice_Status_Report_EndDate = Excel_data.get("Invoice_Status_Report_EndDate");
		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Invoice_Reversel_Module = Excel_data.get("Invoice_Reversel_Module");
		String Reversal_Filter_Type = Excel_data.get("Reversal_Filter_Type");
		String Reversal_Condition = Excel_data.get("Reversal_Condition");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");
		
		String Invoice_Save_Option = Excel_data.get("Invoice_Save_Option");
		String Delete_Draft_Invoice_popup = Excel_data.get("Delete_Draft_Invoice_popup");
		String Draft_Invoice_Deleted_Popup = Excel_data.get("Draft_Invoice_Deleted_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, Import_Invoice_ModuleName);
		
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
		if (Invoice_saved_pop.equals(import_saved_act)) {
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

		waitForElement(driver, Invoice_Table_Row_All);
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String StartDate=getFirstValueByHeader(TabledataFull,"Inv Date");
		String InvoiceNumber=getFirstValueByHeader(TabledataFull,"Inv Number");
		
		System.out.println("StartDate : "+StartDate);

	    String Inv_Sts_Rep_StartDate=beforeDaysToDate(StartDate, Invoice_Status_Report_StartDate);
	    String Inv_Sts_Rep_EndDate=addDaysToDate(StartDate, Invoice_Status_Report_EndDate);
		
		Map<String, String> ServiceDetails = new HashMap<String, String>();

		String ServiceValue;
		String VesselValue;
		String VoyageValue;
		if (Import_Invoice_ModuleName.equals("Export Invoice")) {
			waitForElement(driver, Service_Field_Export);
			ServiceValue = getAttribute(driver, Service_Field_Export, "value");
		} else {
			waitForElement(driver, service_Txtfield_All);
			ServiceValue = getAttribute(driver, service_Txtfield_All, "value");
		}

		if (Import_Invoice_ModuleName.equals("Invoice")) {
			waitForElement(driver, Vessel_TxtField_Invoice);
			VesselValue = getAttribute(driver, Vessel_TxtField_Invoice, "value");
		} else {
			waitForElement(driver, vessel_Txtfield_All);
			VesselValue = getAttribute(driver, vessel_Txtfield_All, "value");
		}

		if (Import_Invoice_ModuleName.equals("Invoice")) {
			VoyageValue = getAttribute(driver, voyage_Txtfield_Invoice, "value");
		} else {
			VoyageValue = getAttribute(driver, voyage_Txtfield_All, "value");
		}

		String BoundValue = getText(driver, BoundInput_All);
		String POL_Value;
		if (Import_Invoice_ModuleName.equals("Invoice")) {
			POL_Value = getAttribute(driver, POL_Input_Invoice, "value");
		} else {
			POL_Value = getText(driver, POL_Input_All);
		}

		String POL_TerminalValue = getText(driver, POLTerminal_Input_All);
		
		String PODValue = "";
		if(Import_Invoice_ModuleName.equalsIgnoreCase("Invoice")) {
			PODValue = getAttribute(driver, POD_Input_invoice,"value");
		}else {
			PODValue = getText(driver, POD_Input_All);
		}
		String POD_TerminalValue = getText(driver, PODTerminal_Input_All);
		String Call_IdValue;
		if (Import_Invoice_ModuleName.equals("Invoice")) {
			Call_IdValue = getAttribute(driver, Call_Id_Input_Invoice, "value");
		} else {
			Call_IdValue = getText(driver, Call_Id_Input_All);
		}
		String ETAValue = getText(driver, ETA_Date_Input_All);
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");

		
		List<String> ServiceHeaders = splitAndExpand(Service_Details_Headers_Invoice);
		for (String head : ServiceHeaders) {
			if (head.equals("Service")) {
				ServiceDetails.put(head, ServiceValue);
			} else if (head.equals("Vessel")) {
				ServiceDetails.put(head, VesselValue);
			} else if (head.equals("Voyage")) {
				ServiceDetails.put(head, VoyageValue);
			} else if (head.equals("Bound")) {
				ServiceDetails.put(head, BoundValue);
			} else if (head.equals("POL")) {
				ServiceDetails.put(head, POL_Value);
			} else if (head.equals("POL~Terminal")) {
				ServiceDetails.put(head, POL_TerminalValue);
			} else if (head.equals("POD")) {
				ServiceDetails.put(head, PODValue);
			} else if (head.equals("POD~Terminal")) {
				ServiceDetails.put(head, POD_TerminalValue);
			} else if (head.equals("Call ID")) {
				ServiceDetails.put(head, Call_IdValue);
			} else if (head.equals("ETA")|| head.equals("ETD")) {
				ServiceDetails.put(head, ETAValue);
			}
		}
				
		moduleNavigate(driver, Invoice_Status_Module);
		waitForElement(driver, NewButton_ToolBar);
		Step_End(5, "Go to Invoice status Report", test, test1);

		Step_Start(6, "select from and To date as per Invoice Date", test, test1);

		waitForElement(driver, FromDate_ISR);
		selectDatePicker(driver, FromDate_ISR, Inv_Sts_Rep_StartDate);

		waitForElement(driver, ToDate_ISR);
		selectDatePicker(driver, ToDate_ISR, Inv_Sts_Rep_EndDate);
		
		Step_End(6, "select from and To date as per Invoice Date", test, test1);

		Step_Start(7, "click on show Button", test, test1);

		waitForElement(driver, ShowButton_ISR);
		click(driver, ShowButton_ISR);
		
		List<String> FilterHeadersName = splitAndExpand(Invoice_Status_Filters_New);
		waitForElement(driver, TableGrid_ISR);
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

		List<String> columns = splitAndExpand(Service_Headers_Invoice_Status_Report);
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

	
		List<String> filterdetailHeader = splitAndExpand(Invoice_Status_Filters_New);
		for (String head : filterdetailHeader) {
			if (head.equals("Invoice Number")) {
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
		
		List<String> statusHeaderList = splitAndExpand(Service_Headers_Invoice_Status_Report);
		Map<String,String> Act_ServiceDetails= StatusReport_TableData.get(0);
		
		for(String Head:FilterHeadersName) {
			Act_ServiceDetails.remove(Head);
		}
		
		List<String> filterdetailHeader1 = splitAndExpand(Invoice_Status_Filters_New);
		statusHeaderList.addAll(filterdetailHeader1);
		String ExpectedTable=ReportTable(ServiceDetails,"Invoice Table data");
		String ActualTable=ReportTable(Act_ServiceDetails,"Status Report Table");
		
		
		if (CompareMapValues(ServiceDetails, Act_ServiceDetails)) {
			System.out.println(	"Matched || Expected value was : " + ServiceDetails + " || Actual value was : " + Act_ServiceDetails);
			Extent_pass_New(driver,"Matched || Expected  : \n" + "<pre>" + ExpectedTable
							+ "</pre> \n " + "|| Actual : \n" + "<pre>" + ActualTable
							+ "</pre>",
					test, test1);
		} else {
			System.out.println(	"Not Matched || Expected value was : " + ServiceDetails + " || Actual value was : " + Act_ServiceDetails);
			Extent_fail(driver,"Not Matched || Expected  : \n" + "<pre>" + ExpectedTable
							+ "</pre> \n " + "|| Actual : \n" + "<pre>" + ActualTable
							+ "</pre>",
					test, test1);
		}
		
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
		
		
	}
}
