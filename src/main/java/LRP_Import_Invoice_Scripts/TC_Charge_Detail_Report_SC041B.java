package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Charge_Detail_Report_SC041B extends Keywords {

	public void Charge_Detail_Report_SC041B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Charge_Detail_Report_SC041B";
		
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
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Expected_Popup = Excel_data.get("Expected_Popup");
		String Verification_Columns = Excel_data.get("Verification_Columns");
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
		String Agency_Master_Module_ = Excel_data.get("Agency_Master_Module_");
		String Agency_Master_Filter_type = Excel_data.get("Agency_Master_Filter_type");
		String Agency_Master_Filter_Condition = Excel_data.get("Agency_Master_Filter_Condition");
		String Voyage_ROE_Module = Excel_data.get("Voyage_ROE_Module");
		String Voyage_ROE_Filter_type = Excel_data.get("Voyage_ROE_Filter_type");
		String Voyage_ROE_Filter_Condition = Excel_data.get("Voyage_ROE_Filter_Condition");
		String Agency_ROE_Module = Excel_data.get("Agency_ROE_Module");
		String Agency_ROE_Filter_Type = Excel_data.get("Agency_ROE_Filter_Type");
		String Agency_ROE_Filter_Condition = Excel_data.get("Agency_ROE_Filter_Condition");
		String Tolerance_Value = Excel_data.get("Tolerance_Value");
		String Amount_Validation_Seperate = Excel_data.get("Amount_Validation_Seperate");
		String reverse_Invoice = Excel_data.get("reverse_Invoice");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String ServiceHeader = Excel_data.get("ServiceHeader");
		String VesselHeader = Excel_data.get("VesselHeader");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String PortHeader = Excel_data.get("PortHeader");
		String Invoice_Already_Exist = Excel_data.get("Invoice_Already_Exist");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");

		String GlobalSearch_Type1_Invoice = Excel_data.get("GlobalSearch_Type1_Invoice");
		String GlobalSearch_Value1_Invoice = Excel_data.get("GlobalSearch_Value1_Invoice");
		String GlobalSearch_Type2_Invoice = Excel_data.get("GlobalSearch_Type2_Invoice");
		String GlobalSearch_Value2_Invoice = Excel_data.get("GlobalSearch_Value2_Invoice");
		String GlobalSearch_Type3_Invoice = Excel_data.get("GlobalSearch_Type3_Invoice");
		String GlobalSearch_Value3_Invoice = Excel_data.get("GlobalSearch_Value3_Invoice");

		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Region_Header = Excel_data.get("Region_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");
		String Charge_Detail_Report_StartDate = Excel_data.get("Charge_Detail_Report_StartDate");
		String Charge_Detail_Report_EndDate = Excel_data.get("Charge_Detail_Report_EndDate");
		String Select_Radio_Button_Option = Excel_data.get("Select_Radio_Button_Option");

		
		String Agency_ROE_Header = Excel_data.get("Agency_ROE_Header");
		String Voyage_ROE_Header = Excel_data.get("Voyage_ROE_Header");

		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		Step_Start(1, "Create the Import Invoice in Draft status(Use By Vessel/BL option )", test, test1);
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
					System.out.println(
							"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act);
					Extent_FailNew(driver,
							"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				} else {
					System.out.println(
							"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act);
					Extent_fail(driver,
							"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				}
			}

			waitForElement(driver, invoice_Customer_Text_Field);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.trim().equals("")) {
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
			System.out.println("Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,"Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act, test,
					test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act);

			Extent_fail(driver,"Not Matched || Expected Popup : " + Expected_Popup + " || Actual Popup : " + import_saved_act,
					test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		// new
		Step_End(1, "Create the Import Invoice in Draft status(Use By Vessel/BL option )", test, test1);

		Step_Start(2,"Copy the Invoice No (Get the Invoice Currency Amount by invoice level if multiple invoice also take it)",
				test, test1);

		waitForElement(driver, ETA_Date_Invoice_All);
		String ETAValue = getText(driver, ETA_Date_Invoice_All);
		waitForElement(driver, Invoice_Table_Header_All);
		List<Map<String, String>> tabledata1 = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String AmountInvoice = getFirstValueByHeader(tabledata1, "Amount");
		String ROE_Value = getFirstValueByHeader(tabledata1, "ROE Type");
		String INV_Date = getFirstValueByHeader(tabledata1, "Inv Date");
		waitForElement(driver, TabList_All);
		List<String> AmountDetails_AllTabs = new ArrayList<String>();
		List<String> AmountInUSD_AllTabs = new ArrayList<String>();

		if (Module_Name.equals("Import Invoice")) {

			List<WebElement> Invoice_Tabs = listOfElements(driver, TabList_All);

			int i = 1;
			while (i <= Invoice_Tabs.size()) {
				String tabCount = String.valueOf(i);
				String ele = String.format(import_invoice_Tabs, tabCount);
				waitForElement(driver, ele);

				String TabName = getText(driver, ele);

				if (TabName.equals("BL Details")) {

					System.out.println("BL Details tab");
				} else {

					click(driver, ele);

					waitForDisplay(driver, ImportInvoice_Headers_);
					if (isdisplayed(driver, ImportInvoice_Rows_)) {
						List<Map<String, String>> TableData = getTableData(driver, ImportInvoice_Headers_,
								ImportInvoice_Rows_);
						List<String> AmountValues = getValuesByHeader(TableData, "Amount");
						AmountDetails_AllTabs.addAll(AmountValues);
						List<String> AmountUSD = getValuesByHeader(TableData, "Amount in USD");
						AmountInUSD_AllTabs.addAll(AmountUSD);

					}

				}

				i++;
			}

		} else if (Module_Name.equals("Export Invoice")) {

			List<WebElement> Invoice_Tabs = listOfElements(driver, TabList_All);

			int i = 1;
			while (i <= Invoice_Tabs.size()) {
				String tabCount = String.valueOf(i);
				String ele = String.format(Export_invoice_Tabs, tabCount);
				waitForElement(driver, ele);

				String TabName = getText(driver, ele);

				if (TabName.equals("BL Details")) {

					System.out.println("BL Details tab");
				} else {

					click(driver, ele);

					waitForDisplay(driver, ExportInvoice_Headers_);
					if (isdisplayed(driver, ExportInvoice_Rows_)) {
						List<Map<String, String>> TableData = getTableData(driver, ExportInvoice_Headers_,
								ExportInvoice_Rows_);
						List<String> AmountValues = getValuesByHeader(TableData, "Amount");
						AmountDetails_AllTabs.addAll(AmountValues);
						List<String> AmountUSD = getValuesByHeader(TableData, "Amount in USD");
						AmountInUSD_AllTabs.addAll(AmountUSD);

					}
				}
				i++;
			}

		} else if (Module_Name.equals("Invoice")) {

			List<WebElement> Invoice_Tabs = listOfElements(driver, TabList_All);

			int i = 1;
			while (i <= Invoice_Tabs.size()) {
				String tabCount = String.valueOf(i);
				String ele = String.format(Export_invoice_Tabs, tabCount);
				waitForElement(driver, ele);

				String TabName = getText(driver, ele);

				if (TabName.equals("BL Details")) {

					System.out.println("BL Details tab");
				} else {

					click(driver, ele);

					waitForDisplay(driver, Invoice_Headers_);
					if (isdisplayed(driver, Invoice_Rows_)) {
						List<Map<String, String>> TableData = getTableData(driver, Invoice_Headers_, Invoice_Rows_);
						List<String> AmountValues = getValuesByHeader(TableData, "Amount");
						AmountDetails_AllTabs.addAll(AmountValues);
						List<String> AmountUSD = getValuesByHeader(TableData, "Amount in USD");
						AmountInUSD_AllTabs.addAll(AmountUSD);

					}
				}

				i++;
			}
		}

		String Invoice_Number=getFirstValueByHeader(tabledata1,"Inv Number");
		String Vessel_Service;
		String VoyageValue;
		if (Module_Name.equals("Invoice")) {
			waitForElement(driver, Vessel_TxtField_Invoice);
			Vessel_Service = getAttribute(driver, Vessel_TxtField_Invoice, "value");
		} else {
			waitForElement(driver, vessel_Txtfield_All);
			Vessel_Service = getAttribute(driver, vessel_Txtfield_All, "value");
		}

		if (Module_Name.equals("Invoice")) {
			VoyageValue = getAttribute(driver, voyage_Txtfield_Invoice, "value");
		} else {
			VoyageValue = getAttribute(driver, voyage_Txtfield_All, "value");
		}
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");
		
		Step_End(2,"Copy the Invoice No (Get the Invoice Currency Amount by invoice level if multiple invoice also take it)",
				test, test1);

		Step_Start(6, "Open charge Details report", test, test1);

		moduleNavigate(driver, Field_Names2);

		Step_End(6, "Open charge Details report", test, test1);

		Step_Start(7, " Input All The Entry from Test Data", test, test1);

		newButton(driver);

		waitForElement(driver, In_reportType_Dropdown);
		click(driver, In_reportType_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Report_Type);

		waitForElement(driver, Shipment_Charge_Detail);
		click(driver, Shipment_Charge_Detail);
		formatLocatorClick(driver, DropDown_Select, shipment);
		
		waitForElement(driver, chargeCategory_Dropdown);
		click(driver, chargeCategory_Dropdown);
		formatLocatorClick(driver, DropDown_Select, chargeCategory);

		waitForElement(driver, chargeType_Dropdown);
		click(driver, chargeType_Dropdown);
		formatLocatorClick(driver, chargeType_Dropdown_Options, chargeType);

		
		
		String Charge_Detail_Rep_StartDate=INV_Date;
		String Charge_Detail_Rep_EndDate=INV_Date;
		
		if(Report_Type.equals("BY INVOICE DATE")) {
			 Charge_Detail_Rep_StartDate=beforeDaysToDate(INV_Date, Charge_Detail_Report_StartDate);
			 Charge_Detail_Rep_EndDate=addDaysToDate(INV_Date, Charge_Detail_Report_EndDate);
		}else if(Report_Type.equals("BY SAILING DATE")) {
			Charge_Detail_Rep_StartDate=beforeDaysToDate(ETAValue, Charge_Detail_Report_StartDate);
			 Charge_Detail_Rep_EndDate=addDaysToDate(ETAValue, Charge_Detail_Report_EndDate);
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
		formatLocatorClick(driver, DropDown_Select, scope);
	
		if (Verify_In.equals("Line")) {
			if (scope.equalsIgnoreCase("Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}

			if (scope.equalsIgnoreCase("Region")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, Region_Header, Two_Column_Search_Condition, Select_Scope_Value);
			}

			if (scope.equalsIgnoreCase("Corporate Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindow(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);
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

			if (!Port_Code.trim().equals("")) {
				waitForElement(driver, port_Search_CDR);
				click(driver, port_Search_CDR);
				twoColumnSearchWindow(driver, PortHeader, Two_Column_Search_Condition, Port_Code);
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
		Step_End(7, " Input All The Entry from Test Data", test, test1);

		Step_Start(8, "Click on Show Button", test, test1);

		waitForElement(driver, show_Button_CDR);
		click(driver, show_Button_CDR);

		Step_End(8, "Click on Show Button", test, test1);

		Step_Start(9, "filter based on Invoice Number and Compare Below and Invoices.", test, test1);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);

		if(Invoice_Number!=null) {
			waitForElement(driver, Invoice_input);
			sendKeys(driver, Invoice_input, Invoice_Number);
		}
		
		if(BL_Number_input!=null&& !BL_Number_input.equals("-")) {
			waitForElement(driver, bl_number_input);
			sendKeys(driver, bl_number_input, BL_Number_input);
		}
		
		reArrangeAG_GridColumnsNew(driver, AG_Grid_Column, Verification_Columns);

		String Total_records = getText(driver, Total_count);

		if (Total_records.contains("of")) {
			String total_count1[] = Total_records.split("of");

			Total_records = total_count1[0].trim();
		}
		List<String> InvoiceCurrency_Grid = new ArrayList<String>();
		List<String> AmountInHome = new ArrayList<String>();
		List<String> AmountInUSD = new ArrayList<String>();

		for (int k = 0; k < Integer.parseInt(Total_records); k++) {

			String currency_grid = String.format(Invoice_currency, k);

			mouseOverToElement(driver, currency_grid);

			String Currency_value = getText(driver, currency_grid);

			InvoiceCurrency_Grid.add(Currency_value);

			String Roe_Value = String.format(AmountInHome_Column, k);

			mouseOverToElement(driver, Roe_Value);

			String roe = getText(driver, Roe_Value);

			AmountInHome.add(roe);

			String inv_Type = String.format(AmountInUSD_Column, k);

			mouseOverToElement(driver, inv_Type);

			String invTypes = getText(driver, inv_Type);

			AmountInUSD.add(invTypes);

		}

		moduleNavigate(driver, Agency_Master_Module_);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Agency_Master_Filter_Condition, Agency_Master_Filter_type, AgencyUser, "", "",
				"", "");

		waitForElement(driver, CurrencyCode_AgencyMaster);
		String Agency_ROE_ValueExp = getAttribute(driver, CurrencyCode_AgencyMaster, "value");

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		List<Map<String, String>> Currency_ROE_Values;

		if (ROE_Value.equalsIgnoreCase("V")) {
			moduleNavigate(driver, Voyage_ROE_Module);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow1(driver, Voyage_ROE_Filter_Condition, Voyage_ROE_Filter_type, Vessel_Service, "",
					"", "", "");

			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, VoyageValue);

			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);

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
			if (ROE_Value.equalsIgnoreCase("S")) {
				DateValue = ETAValue;
			} else {
				DateValue = INV_Date;
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
			
		}
		String currencyHeader;
		if (ROE_Value.equalsIgnoreCase("V")) {
			currencyHeader = "Currency";
		} else {
			currencyHeader = "Currency Code";
		}
		double AgencyMaster_Amount=0;
		double USD_AmountValue=0;
		
		if(ROE_Value.equalsIgnoreCase("V")) {
			waitForElement(driver, MoreOption_Grid);
			click(driver,MoreOption_Grid);
			
			waitForElement(driver, FilterOption_Menu);
			click(driver,FilterOption_Menu);
			
			AG_Grid_FilterInputs(driver,currencyHeader,"USD");
			waitForElement(driver, Voyage_Roe_Table);
			Currency_ROE_Values = extractTableDataByColumn(driver, Voyage_Roe_Table);
			String USD_Value = getValueByFirstColumnAndHeader(Currency_ROE_Values, currencyHeader, "USD", Voyage_ROE_Header);
			USD_AmountValue = getNumberValue(USD_Value);
			
			AG_Grid_FilterInputs(driver,currencyHeader,Agency_ROE_ValueExp);
			waitForElement(driver, Voyage_Roe_Table);
			Currency_ROE_Values = extractTableDataByColumn(driver, Voyage_Roe_Table);
			String AgencyMasterValues = getValueByFirstColumnAndHeader(Currency_ROE_Values, currencyHeader,Agency_ROE_ValueExp, Voyage_ROE_Header);
			AgencyMaster_Amount = getNumberValue(AgencyMasterValues);
			
		}else {
			
			waitForElement(driver, AgencyRoe_TableRow);
			Currency_ROE_Values = getTableData(driver, AgencyRoe_TableHeader, AgencyRoe_TableRow);
			
			String AgencyMasterValues = getValueByFirstColumnAndHeader(Currency_ROE_Values, currencyHeader,Agency_ROE_ValueExp, Agency_ROE_Header);
			AgencyMaster_Amount = getNumberValue(AgencyMasterValues);
			
			String USD_Value = getValueByFirstColumnAndHeader(Currency_ROE_Values, currencyHeader, "USD", Agency_ROE_Header);
			USD_AmountValue = getNumberValue(USD_Value);
			
		}
		
		double toleranceAmounut = getNumberValue1(Tolerance_Value);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		if (Amount_Validation_Seperate.equalsIgnoreCase("Yes")) {
			for (int i = 0; i < AmountDetails_AllTabs.size(); i++) {

				String Actual_AmoundUSD = AmountInUSD.get(i);
				String Expected_AmoundUSD = AmountInUSD_AllTabs.get(i);
				double ActualUSD_Amount = getNumberValue(Actual_AmoundUSD);
				ActualUSD_Amount = Double.parseDouble(String.format("%.2f", ActualUSD_Amount));
				double ExpectedUSD_Amount = getNumberValue(Expected_AmoundUSD);
				ExpectedUSD_Amount = Double.parseDouble(String.format("%.2f", ExpectedUSD_Amount));

				String CurrentCurrency = InvoiceCurrency_Grid.get(i);
				String Amount_Value = AmountDetails_AllTabs.get(i);
				double Expected_Amount = getNumberValue(Amount_Value);

				String Amount_Home_Value = AmountInHome.get(i);
				double Act_AmountHome = getNumberValue(Amount_Home_Value);

				String AgencyValues = getValueByFirstColumnAndHeader(Currency_ROE_Values, currencyHeader,
						CurrentCurrency, Agency_ROE_Header);
				double Agency_Amount = getNumberValue(AgencyValues);

				if (CurrentCurrency.equals(Agency_ROE_ValueExp)) {

					if (Expected_Amount == Act_AmountHome) {
						System.out.println("Amount in Home Matched for " + CurrentCurrency + "  Row : " + i
								+ ",  Agency : " + Agency_ROE_ValueExp + " || Expected value was : " + Expected_Amount
								+ " || Actual value was : " + Act_AmountHome);
						Extent_pass_New(driver,
								"Amount in Home Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + Expected_Amount
										+ " || Actual value was : " + Act_AmountHome,
								test, test1);
					} else {
						System.out.println("Amount in Home Not Matched for " + CurrentCurrency + "  Row : " + i
								+ ",  Agency : " + Agency_ROE_ValueExp + " || Expected value was : " + Expected_Amount
								+ " || Actual value was : " + Act_AmountHome);
						Extent_fail(driver,
								"Amount in Home Not Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + Expected_Amount
										+ " || Actual value was : " + Act_AmountHome,
								test, test1);
					}

				} else if (CurrentCurrency.equalsIgnoreCase("USD")) {

					double expHomeAmount = Expected_Amount * AgencyMaster_Amount;

					if (compareAmounts(expHomeAmount, Act_AmountHome, toleranceAmounut)) {
						System.out.println("Amount in Home Matched for " + CurrentCurrency + "  Row : " + i
								+ ",  Agency : " + Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
								+ " || Actual value was : " + Act_AmountHome);
						Extent_pass_New(driver,
								"Amount in Home Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + Act_AmountHome,
								test, test1);
					} else {
						System.out.println("Amount in Home Not Matched for " + CurrentCurrency + "  Row : " + i
								+ ",  Agency : " + Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
								+ " || Actual value was : " + Act_AmountHome);
						Extent_fail(driver,
								"Amount in Home Not Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + Act_AmountHome,
								test, test1);
					}

				} else {

					double expHomeAmount = Expected_Amount * (AgencyMaster_Amount / Agency_Amount);
					if (compareAmounts(expHomeAmount, Act_AmountHome, toleranceAmounut)) {
						System.out.println("Amount in Home Matched for " + CurrentCurrency + "  Row : " + i
								+ ",  Agency : " + Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
								+ " || Actual value was : " + Act_AmountHome);
						Extent_pass_New(driver,
								"Amount in Home Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + Act_AmountHome,
								test, test1);
					} else {
						System.out.println("Amount in Home Not Matched for " + CurrentCurrency + "  Row : " + i
								+ ",  Agency : " + Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
								+ " || Actual value was : " + Act_AmountHome);
						Extent_fail(driver,
								"Amount in Home Not Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
										+ Agency_ROE_ValueExp + " || Expected value was : " + expHomeAmount
										+ " || Actual value was : " + Act_AmountHome,
								test, test1);
					}

				}

				if (ExpectedUSD_Amount == ActualUSD_Amount) {

					System.out.println("Amount in USD Matched for " + CurrentCurrency + "  Row : " + i + ",  Agency : "
							+ Agency_ROE_ValueExp + " || Expected value was : " + Expected_AmoundUSD
							+ " || Actual value was : " + Act_AmountHome);
					Extent_pass_New(driver,
							"Amount in USD Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + Expected_AmoundUSD
									+ " || Actual value was : " + Act_AmountHome,
							test, test1);

				} else {

					System.out.println("Amount in USD not Matched for " + CurrentCurrency + "  Row : " + i
							+ ",  Agency : " + Agency_ROE_ValueExp + " || Expected value was : " + Expected_AmoundUSD
							+ " || Actual value was : " + Act_AmountHome);
					Extent_fail(driver,
							"Amount in USD not Matched for " + CurrentCurrency + " Row : " + i + ", Agency : "
									+ Agency_ROE_ValueExp + " || Expected value was : " + Expected_AmoundUSD
									+ " || Actual value was : " + Act_AmountHome,
							test, test1);
				}
			}
		}

		double Total_Amount_Charge = 0;
		double Total_USDAmount_Charge = 0;
		double Total_Amount_Invoice = getNumberValue(AmountInvoice);
		for (String val : AmountInHome) {
			double rowAmount = getNumberValue(val);
			Total_Amount_Charge = Total_Amount_Charge + rowAmount;
		}

		for (String val : AmountInUSD) {
			double rowAmount = getNumberValue(val);
			Total_USDAmount_Charge = Total_USDAmount_Charge + rowAmount;
		}

		String CurrentCurrency = InvoiceCurrency_Grid.get(0);

		String AgencyValues = getValueByFirstColumnAndHeader(Currency_ROE_Values, currencyHeader, CurrentCurrency,
				"ROE");
		double Agency_Amount = getNumberValue(AgencyValues);

		if (CurrentCurrency.equals(Agency_ROE_ValueExp)) {

			if (Total_Amount_Invoice == Total_Amount_Charge) {
				System.out.println("Total Amount in Home Matched  || Expected value was : " + Total_Amount_Invoice
						+ " || Actual value was : " + Total_Amount_Charge);
				Extent_pass_New(driver, "Total Amount in Home Matched  || Expected value was : " + Total_Amount_Invoice
						+ " || Actual value was : " + Total_Amount_Charge, test, test1);

			} else {
				System.out.println("Total Amount in Home Not Matched  || Expected value was : " + Total_Amount_Invoice
						+ " || Actual value was : " + Total_Amount_Charge);
				Extent_fail(driver, "Total Amount in Home Not Matched  || Expected value was : " + Total_Amount_Invoice
						+ " || Actual value was : " + Total_Amount_Charge, test, test1);
			}

		} else if (CurrentCurrency.equalsIgnoreCase("USD")) {
			double expHomeAmount = Total_Amount_Invoice * AgencyMaster_Amount;
			if (compareAmounts(expHomeAmount, Total_Amount_Charge, toleranceAmounut)) {
				System.out.println("Total Amount in Home Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge);
				Extent_pass_New(driver, "Total Amount in Home Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge, test, test1);

			} else {
				System.out.println("Total Amount in Home Not Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge);
				Extent_fail(driver, "Total Amount in Home Not Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge, test, test1);
			}
		} else {
			double expHomeAmount = Total_Amount_Invoice * (AgencyMaster_Amount / Agency_Amount);
			if (compareAmounts(expHomeAmount, Total_Amount_Charge, toleranceAmounut)) {
				System.out.println("Total Amount in Home Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge);
				Extent_pass_New(driver, "Total Amount in Home Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge, test, test1);

			} else {
				System.out.println("Total Amount in Home Not Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge);
				Extent_fail(driver, "Total Amount in Home Not Matched  || Expected value was : " + expHomeAmount
						+ " || Actual value was : " + Total_Amount_Charge, test, test1);
			}
		}

		double usdAmountExp = Total_Amount_Invoice * (USD_AmountValue / Agency_Amount);
		usdAmountExp = Double.parseDouble(String.format("%.2f", usdAmountExp));

		if (compareAmounts(usdAmountExp, Total_USDAmount_Charge, toleranceAmounut)) {
			System.out.println("Total Amount in USD Matched  || Expected value was : " + usdAmountExp
					+ " || Actual value was : " + Total_USDAmount_Charge);
			Extent_pass_New(driver, "Total Amount in USD Matched  || Expected value was : " + usdAmountExp
					+ " || Actual value was : " + Total_USDAmount_Charge, test, test1);

		} else {
			System.out.println("Total Amount in USD Not Matched  || Expected value was : " + usdAmountExp
					+ " || Actual value was : " + Total_USDAmount_Charge);
			Extent_fail(driver, "Total Amount in USD Not Matched  || Expected value was : " + usdAmountExp
					+ " || Actual value was : " + Total_USDAmount_Charge, test, test1);
		}

		if (reverse_Invoice.equalsIgnoreCase("Yes")) {
			Extent_call(test, test1, "Invoice Reversal - Start");
			Invoice_Reversal(driver,InvoiceReversal_Module,GlobalSearch_Condition,search_Type_Invoice_Reversal,Invoice_Number,invoiceReversalRemarks,invoiceReversedPopup);
			Extent_call(test, test1, "Invoice Reversal - Stop");
		}

		Extent_completed(testcase_Name, test, test1);

	}
}
