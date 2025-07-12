package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Charge_Detail_Report_SC041 extends Keywords {

	public void Charge_Detail_Report_SC041(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Charge_Detail_Report_SC041";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Verify_In = Excel_data.get("Verify_In");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Module_Name = Excel_data.get("Module_Name");
		String Invoice_Mode_Option = Excel_data.get("Invoice_Mode_Option");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String customer_Code = Excel_data.get("customer_Code");
		String customer_Code_Input = Excel_data.get("customer_Code_Input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code_Value = Excel_data.get("Port_Code_Value");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Expected_Popup = Excel_data.get("Expected_Popup");
		String reverse_Invoice = Excel_data.get("reverse_Invoice");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		String Field_Names2 = Excel_data.get("ChargeDetailReport_Module");
		String Report_Type = Excel_data.get("ReportType");
		String chargeType = Excel_data.get("ChargeType");
		String shipment = Excel_data.get("Shipment");
		String chargeCategory = Excel_data.get("ChargeCategory");
		String reportType = Excel_data.get("ReportType");
		String scope = Excel_data.get("Scope");
		String exclude_Checkbox = Excel_data.get("Exclude_Checkbox");
		String supressZeroAmount_Checkbox = Excel_data.get("SupressZeroAmount_Checkbox");
		String datePicker = Excel_data.get("DatePicker");
		String ServiceHeader = Excel_data.get("ServiceHeader");
		String VesselHeader = Excel_data.get("VesselHeader");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String PortHeader = Excel_data.get("PortHeader");
		String Invoice_Already_Exist = Excel_data.get("Invoice_Already_Exist");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Region_Header = Excel_data.get("Region_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String GlobalSearch_Type1_Invoice = Excel_data.get("GlobalSearch_Type1_Invoice");
		String GlobalSearch_Value1_Invoice = Excel_data.get("GlobalSearch_Value1_Invoice");
		String GlobalSearch_Type2_Invoice = Excel_data.get("GlobalSearch_Type2_Invoice");
		String GlobalSearch_Value2_Invoice = Excel_data.get("GlobalSearch_Value2_Invoice");
		String GlobalSearch_Type3_Invoice = Excel_data.get("GlobalSearch_Type3_Invoice");
		String GlobalSearch_Value3_Invoice = Excel_data.get("GlobalSearch_Value3_Invoice");
		String Select_Radio_Button_Option = Excel_data.get("Select_Radio_Button_Option");

		String Charge_Detail_Report_StartDate = Excel_data.get("Charge_Detail_Report_StartDate");
		String Charge_Detail_Report_EndDate = Excel_data.get("Charge_Detail_Report_EndDate");


		//
		 
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		if(!Verify_In.equalsIgnoreCase("Line")) {
			SwitchProfile(driver, AgencyUser);
		}
		moduleNavigate(driver, Module_Name);
		waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);
		
		formatLocatorClick(driver, DropDown_Select, Invoice_Mode_Option);
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

			globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_Type1_Invoice, GlobalSearch_Value1_Invoice, GlobalSearch_Type2_Invoice, GlobalSearch_Value2_Invoice, GlobalSearch_Type3_Invoice, GlobalSearch_Value3_Invoice);
			
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
					System.out.println("Popup Displayed When load the BL Number . popup : " + poputext_Act);
					Extent_FailNew(driver, "Popup Displayed When load the BL Number . popup : " + poputext_Act, test,
							test1);
				} else {
					System.out.println("Popup Displayed When load the BL Number . popup : " + poputext_Act);
					Extent_fail(driver, "Popup Displayed When load the BL Number . popup : " + poputext_Act, test,
							test1);
				}
			}

			waitForElement(driver, invoice_Customer_Text_Field);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);

				globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Code, customer_Code_Input, "", "", "", "");

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
			
			if(!Port_Code_Value.trim().equals("")) {
				waitForElement(driver, POL_PortCode_Input);
				sendKeys(driver, POL_PortCode_Input, Port_Code_Value);
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

			if(!customer_Code_Input.trim().equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);
				globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Code, customer_Code_Input, "", "", "", "");
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

			globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_Type1_Invoice, GlobalSearch_Value1_Invoice, GlobalSearch_Type2_Invoice, GlobalSearch_Value2_Invoice, GlobalSearch_Type3_Invoice, GlobalSearch_Value3_Invoice);

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);		
			
		}

		scrollTop(driver);
		
		waitForElement(driver, In_Issued_Button);
		click(driver, In_Issued_Button);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Expected_Popup);
		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);
		if (Expected_Popup.equals(import_saved_act)) {
			System.out.println(
					"Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act);

			Extent_fail(driver,
					"Not Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act,
					test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Invoice_Table_Header_All);
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		List<String> Invoices = getValuesByHeader(TabledataFull, "Inv Number");
		String Invoice_Date=getFirstValueByHeader(TabledataFull,"Inv Date");
		String ETA_Date=getText(driver, ETA_Date_Input_All);
		scrollBottom(driver);
		int detailed_row_counts = 0;

		if (Module_Name.equals("Import Invoice")) {

			List<WebElement> datas = listOfElements(driver, Import_Invoice_Headers);

			int i = 1;
			while (i <= datas.size()) {
				String tabCount = String.valueOf(i);

				if (!tabCount.equals("1")) {
					String ele = String.format(import_invoice_Tabs, tabCount);
					waitForElement(driver, ele);
					click(driver, ele);

				

					String row_counts = String.format(Import_Invoice_girs_size, tabCount);

					if (isdisplayed(driver, row_counts)) {
						List<WebElement> elements = listOfElements(driver, row_counts);

						if (elements.size() > 0) {
							System.out.println("Number of rows: " + elements.size());
							int row_size = elements.size();

							detailed_row_counts = detailed_row_counts + row_size;

							System.out.println(row_size);
						} else {
							System.out.println("No elements found.");
						}
					}
				}

				i++;

			}

		} else if (Module_Name.equals("Export Invoice")) {

			List<WebElement> datas = listOfElements(driver, Export_Invoice_Headers);

			int i = 1;
			while (i <= datas.size()) {
				String tabCount = String.valueOf(i);

				if (!tabCount.equals("1")) {

					String ele = String.format(Export_invoice_Tabs, tabCount);
					waitForElement(driver, ele);
					click(driver, ele);


					String row_counts = String.format(Export_Invoice_girs_size, tabCount);

					if (isdisplayed(driver, row_counts)) {
						List<WebElement> elements = listOfElements(driver, row_counts);

						if (elements.size() > 0) {
							System.out.println("Number of rows: " + elements.size());
							int row_size = elements.size();

							detailed_row_counts = detailed_row_counts + row_size;

							System.out.println(row_size);
						} else {
							System.out.println("No elements found.");
						}
					}

				}

				i++;

			}

		} else if (Module_Name.equals("Invoice")) {

			List<WebElement> datas = listOfElements(driver, Invoice_Headers);

			int i = 1;
			while (i <= datas.size()) {
				String tabCount = String.valueOf(i);

				if (!tabCount.equals("1")) {
					String ele = String.format(Invoice_Tabs_Headers, tabCount);
					waitForElement(driver, ele);
					click(driver, ele);


					String row_counts = String.format(Invoice_Table_Grid_Rows, tabCount);

					if (isdisplayed(driver, row_counts)) {
						List<WebElement> elements = listOfElements(driver, row_counts);

						if (elements.size() > 0) {
							System.out.println("Number of rows: " + elements.size());
							int row_size = elements.size();

							detailed_row_counts = detailed_row_counts + row_size;

							System.out.println(row_size);
						} else {
							System.out.println("No elements found.");
						}
					}

				}

				i++;

			}

		}

		String allCounts = String.valueOf(detailed_row_counts);

		System.out.println("All the column counts : " + allCounts);

		scrollTop(driver);

		moduleNavigate(driver, Field_Names2);

		newButton(driver);
		
		scrollTop(driver);
		mouseOverToElement(driver, In_reportType_Dropdown);
		waitForElement(driver, In_reportType_Dropdown);
		click(driver, In_reportType_Dropdown);

		String select_ReportType = String.format(In_reportType_Dropdown_Options, Report_Type);
		waitForElement(driver, select_ReportType);
		click(driver, select_ReportType);

		waitForElement(driver, Shipment_Charge_Detail);
		click(driver, Shipment_Charge_Detail);

		String select_Shipment = String.format(shipment_Dropdown_Options, shipment);
		waitForElement(driver, select_Shipment);
		click(driver, select_Shipment);

		waitForElement(driver, chargeCategory_Dropdown);
		click(driver, chargeCategory_Dropdown);

		String select_ChargeCategory = String.format(chargeCategory_Dropdown_Options, chargeCategory);
		waitForElement(driver, select_ChargeCategory);
		click(driver, select_ChargeCategory);

		waitForElement(driver, chargeType_Dropdown);
		click(driver, chargeType_Dropdown);

		formatLocatorClick(driver, chargeType_Dropdown_Options, chargeType);

		String Charge_Detail_Rep_StartDate=Invoice_Date;
		String Charge_Detail_Rep_EndDate=Invoice_Date;
		
		if(Report_Type.equals("BY INVOICE DATE")) {
			 Charge_Detail_Rep_StartDate=beforeDaysToDate(Invoice_Date, Charge_Detail_Report_StartDate);
			 Charge_Detail_Rep_EndDate=addDaysToDate(Invoice_Date, Charge_Detail_Report_EndDate);
		}else if(Report_Type.equals("BY SAILING DATE")) {
			Charge_Detail_Rep_StartDate=beforeDaysToDate(ETA_Date, Charge_Detail_Report_StartDate);
			 Charge_Detail_Rep_EndDate=addDaysToDate(ETA_Date, Charge_Detail_Report_EndDate);
		}
		
		if(!Charge_Detail_Rep_StartDate.trim().equals("")) {
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, fromDate_CDR, Charge_Detail_Rep_StartDate);
			}else {
				click(driver, fromDate_CDR);
				Newclear(driver, fromDate_CDR);
				waitForElement(driver, fromDate_CDR);
				sendKeys(driver, fromDate_CDR, Charge_Detail_Rep_StartDate);
			}
		}
		
		if(!Charge_Detail_Rep_EndDate.trim().equals("")) {
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, toDate_CDR, Charge_Detail_Rep_EndDate);
			}else {
				click(driver, toDate_CDR);
				Newclear(driver, toDate_CDR);
				waitForElement(driver, toDate_CDR);
				sendKeys(driver, toDate_CDR, Charge_Detail_Rep_EndDate);
			}
		}

		waitForElement(driver, scope_Dropdown);
		click(driver, scope_Dropdown);

		formatLocatorClick(driver, scope_Dropdown_Options, scope);

		if (Verify_In.equals("Line")) {
			if (scope.equalsIgnoreCase("Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}

			if (scope.equalsIgnoreCase("Region")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, Region_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}

			if (scope.equalsIgnoreCase("Corporate Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}
		}
		
		if (reportType.equalsIgnoreCase("BY VESSEL")) {

			if (!Service_Code.trim().equals("")) {
				waitForElement(driver, service_Search_CDR);
				click(driver, service_Search_CDR);
				twoColumnSearchWindow(driver, ServiceHeader, Two_Column_Search_Condition, Service_Code);
			}
			
			if (!Vessel_Code.trim().equals("")) {
				waitForElement(driver, vessel_Search_CDR);
				click(driver, vessel_Search_CDR);
				twoColumnSearchWindow(driver, VesselHeader, Two_Column_Search_Condition, Vessel_Code);
			}
			
			if (!Voyage_Number.trim().equals("")) {
				waitForElement(driver, voyage_Search_CDR);
				click(driver, voyage_Search_CDR);
				twoColumnSearchWindow(driver, Voyage_Header, Two_Column_Search_Condition, Voyage_Number);
			}

			if (!Port_Code_Value.trim().equals("")) {
				waitForElement(driver, port_Search_CDR);
				click(driver, port_Search_CDR);
				twoColumnSearchWindow(driver, PortHeader, Two_Column_Search_Condition, Port_Code_Value);
			}
		}

		String RadioBtnOption= String.format(Radio_Buttons_CDR, Select_Radio_Button_Option);
		waitForElement(driver, RadioBtnOption);
		click(driver,RadioBtnOption);
	

		if (exclude_Checkbox.equalsIgnoreCase("Yes")) {
			waitForElement(driver, exclude_Reversal_Checkbox);
			click(driver, exclude_Reversal_Checkbox);
		}
		if (supressZeroAmount_Checkbox.equalsIgnoreCase("Yes")) {
			waitForElement(driver, supress_ZeroAmount);
			click(driver, supress_ZeroAmount);
		}
		Step_End(3, "Input All The Entry from Test Data", test, test1);
		Step_Start(4, "Click on Show Button", test, test1);

		waitForElement(driver, show_Button_CDR);
		click(driver, show_Button_CDR);

		waitForElement(driver, cd_filter);
		click(driver, cd_filter);

		waitForElement(driver, cd_filter_inside);
		click(driver, cd_filter_inside);

		waitForElement(driver, BL_Row1);

		int total_filters = 0;

		for (String Invoice_Number : Invoices) {

			waitForElement(driver, Invoice_input);
			clear(driver, Invoice_input);
			sendKeys(driver, Invoice_input, Invoice_Number);

			String Total_records = getText(driver, Total_count);

			String total_count[] = Total_records.split("of");

			String report_count = total_count[0].trim();

			int counts = Integer.parseInt(report_count);

			total_filters = total_filters + counts;

			System.out.println("report_count : " + report_count);

		}

		String report_count = String.valueOf(total_filters);

		if (report_count.equals(allCounts)) {
			System.out.println("BL Number coulmn values are correctly showing || Expected " + allCounts + " Actual : "
					+ report_count);
			Extent_pass_New(driver, "BL Number coulmn values are correctly showing || Expected " + allCounts + " Actual : "
					+ report_count, test, test1);
		} else {
			System.out.println("BL Number coulmn values are not correctly showing  || Expected " + allCounts
					+ " Actual : " + report_count);
			Extent_fail(driver, "BL Number coulmn values are not correctly showing  || Expected " + allCounts
					+ " Actual : " + report_count, test, test1);
		}

		if (reverse_Invoice.equalsIgnoreCase("Yes")) {
			Extent_call(test, test1, "Invoice Reversal - Start");
			Invoice_Reversal(driver,InvoiceReversal_Module,GlobalSearch_Condition,search_Type_Invoice_Reversal,Invoices.get(0),invoiceReversalRemarks,invoiceReversedPopup);
			Extent_call(test, test1, "Invoice Reversal - Stop");
		}

		Extent_completed(testcase_Name, test, test1);

	}
}
