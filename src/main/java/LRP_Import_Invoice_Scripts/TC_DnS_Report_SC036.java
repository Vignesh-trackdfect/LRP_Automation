package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_DnS_Report_SC036 extends Keywords {

	public void DnS_Report_SC036(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_DnS_Report_SC036";
		
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Import_Invoice_Module = Excel_data.get("Import_Invoice_Module");

		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Filter_Type = Excel_data.get("BL_Filter_Type");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");

		String POD_Code = Excel_data.get("POD_Code");

		String Invoice_saved_pop = Excel_data.get("Invoice_saved_pop");

		String Charges_Based_Header = Excel_data.get("Charges_Based_Header");
		String Charges_Amount_Headers_Invoice = Excel_data.get("Charges_Amount_Headers_Invoice");

		String Detention_Storage_Module = Excel_data.get("Detention_Storage_Module");
		String Load_Profile_Name = Excel_data.get("Load_Profile_Name");
		String Corporate_Agency = Excel_data.get("Corporate_Agency");
		String Agency_Code = Excel_data.get("Agency_Code");
		String Code_Filter_Condition = Excel_data.get("Code_Filter_Condition");
		String Corporate_Header = Excel_data.get("Corporate_Header");
		String Agency_Header = Excel_data.get("Agency_Header");

		String Select_Shipment = Excel_data.get("Select_Shipment");

		String Select_Storage = Excel_data.get("Select_Storage");
		String Select_Detention = Excel_data.get("Select_Detention");

		String Voyage_Filter_Condition = Excel_data.get("Voyage_Filter_Condition");

		String Date_Select_Type = Excel_data.get("Date_Select_Type");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");

		String Supress_Zero_Balance = Excel_data.get("Supress_Zero_Balance");
		String Use_Report_Date = Excel_data.get("Use_Report_Date");
		String Use_ETD_Date = Excel_data.get("Use_ETD_Date");

		String Select_Report_By = Excel_data.get("Select_Report_By");
		String VoyageOptionName = Excel_data.get("VoyageOptionName");
		String Extention_delete_Filter_Type = Excel_data.get("Extention_delete_Filter_Type");

		String DateOptionName = Excel_data.get("DateOptionName");

		String SelectVoyageOption = String.format(Select_ReportOption, VoyageOptionName);
		String SelectDateOption = String.format(Select_ReportOption, DateOptionName);

		String SelectShipmentOption = String.format(ShipmentType, Select_Shipment);
		String Select_Columns = Excel_data.get("Select_Columns");
		String DnS_Report_Header = Excel_data.get("DnS_Report_Header");
		String Compare_Base_Header_Detention = Excel_data.get("Compare_Base_Header_Detention");

		// dete
		String Detention_Demurrage_Module = Excel_data.get("Detention_Demurrage_Module");
		String Detention_Select_value = Excel_data.get("Detention_Select_value");
		String Detention_BL_Number_input = Excel_data.get("Detention_BL_Number_input");
		String Select_Extension = Excel_data.get("Select_Extension");
		String Selection_Type = Excel_data.get("Selection_Type");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Radio_button = Excel_data.get("Radio_button");
		String Date = Excel_data.get("Date");
		String NumberOfDays = Excel_data.get("NumberOfDays");
		String Container_number = Excel_data.get("Container_number");
		String Save_popup = Excel_data.get("Save_popup");

		String Delete_Invoice = Excel_data.get("Delete_Invoice");
		String Invoice_Reversel_Module = Excel_data.get("Invoice_Reversel_Module");
		String Reversal_Filter_Type = Excel_data.get("Reversal_Filter_Type");
		String Reversal_Condition = Excel_data.get("Reversal_Condition");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");
		String Reversal_Invoice_Popup = Excel_data.get("Reversal_Invoice_Popup");

		String Detention_delete_Condition = Excel_data.get("Detention_delete_Condition");
		String Delete_Storage_Popup = Excel_data.get("Delete_Storage_Popup");

		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "open the Detention Demurrage Extension module", test, test1);
		moduleNavigate(driver, Detention_Demurrage_Module);
		Step_End(1, "open the Detention Demurrage Extension module", test, test1);

		Step_Start(2, "click the new button", test, test1);

		newButton(driver);

		Step_End(2, "click the new button", test, test1);

		Step_Start(3, "retrive the bl in bl number search field ", test, test1);

		waitForElement(driver, Detention_BLSearch);
		click(driver, Detention_BLSearch);

		globalValueSearchWindow(driver, BL_Condition, Detention_Select_value, Detention_BL_Number_input, "", "", "",
				"");

		Step_End(4, "search  and select the bl no,", test, test1);

		Step_Start(5, " Select Storage Extension/DO Extension option(It has to be refer from test Data),", test, test1);

		String SelectOption = String.format(SelectTab, Select_Extension);

		waitForElement(driver, SelectOption);
		click(driver, SelectOption);
		Step_End(5, " Select Storage Extension/DO Extension option(It has to be refer from test Data),", test, test1);

		Step_Start(6, "Click on show Button", test, test1);

		waitForElement(driver, Detention_Show);
		click(driver, Detention_Show);

		if (isdisplayed(driver, DetentionOkay_button)) {
			click(driver, DetentionOkay_button);
		}

		if (verifyElementHasText(driver, ContainerNo_Column)) {
			System.out.println(
					"Expected result is : After click on show BL button, BL details should show the Grid || Actula result is : After click on show BL button, BL details are showing the Grid");
			Extent_pass_New(driver,
					"Expected result is : After click on show BL button, BL details should show the Grid || Actula result is : After click on show BL button, BL details are showing the Grid",
					test, test1);

		} else {
			System.out.println(
					"Expected result is : After click on show BL button, BL details should show the Grid || Actula result is : After click on show BL button, BL details are not showing the Grid");
			Extent_fail(driver,
					"Expected result is : After click on show BL button, BL details should show the Grid || Actula result is : After click on show BL button, BL details are not showing the Grid",
					test, test1);
		}

		Step_End(6, "Click on show Button", test, test1);

		Step_Start(7,
				"Choose All/Selected Container(Pass container from Test Data and select it multiple container can be allow) Option",
				test, test1);

		String Select_containeroption = String.format(SelectTab, Selection_Type);
		waitForElement(driver, Select_containeroption);
		click(driver, Select_containeroption);

		List<String> containersList;
		List<Map<String, String>> DetentionTable;
		if (Selection_Type.equalsIgnoreCase("All")) {
			
			 if(Select_Extension.equals("DO Extension(D)")) {
				 waitForElement(driver, AG_Grid_DO_Extention);
				 DetentionTable = extractTableDataByColumn(driver, AG_Grid_DO_Extention);		        	
			 }else {
				 waitForElement(driver, AG_Grid_StorageExtention);
				 DetentionTable = extractTableDataByColumn(driver, AG_Grid_StorageExtention);		        	
			 }
				
			containersList = getTableHeaderCellList(DetentionTable, "Container No.");
		} else {
			containersList = splitAndExpand(Container_number);
		}

		Step_End(7,
				"Choose All/Selected Container(Pass container from Test Data and select it multiple container can be allow) Option",
				test, test1);

		Step_Start(8, "Select DAte/Days Radio Button (It has to be refer from test Data)", test, test1);

		if (Radio_button.equals("Date")) {
			waitForElement(driver, Date_button);
			click(driver, Date_button);

			waitForElement(driver, Calendar_field);
			if (Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, Calendar_field, Date);
			} else {
				waitForElement(driver, Calendar_field);
				click(driver, Calendar_field);
				clear(driver, Calendar_field);
				sendKeys(driver, Calendar_field, Date);
				enter(driver);
			}

		} else if (Radio_button.equals("Days")) {
			
			waitForElement(driver, Days_button);
			click(driver,Days_button);
			waitForElement(driver, Days_Input);
			click(driver, Days_Input);
			sendKeys(driver, Days_Input, NumberOfDays);
		}

		Step_End(8, "Select DAte/Days Radio Button (It has to be refer from test Data)", test, test1);

		Step_Start(9, "click on (+) Button,(Capture Extended Validity and Net AMT)", test, test1);

		if (Selection_Type.equals("Selected Containers")) {
			for (String container : containersList) {
				String container_selector = String.format(Select_container, container);
				waitForElement(driver, container_selector);
				click(driver, container_selector);
			}
		}

		waitForElement(driver, Plus_button);
		click(driver, Plus_button);

		waitForDisplay(driver, Plus_button);

		if (isdisplayed(driver, detentionTab_No)) {
			click(driver, detentionTab_No);
		}

		Step_End(9, "click on (+) Button,(Capture Extended Validity and Net AMT)", test, test1);

		Step_Start(10, "CLick on save button", test, test1);
		
		if(Selection_Type.equalsIgnoreCase("All")) {
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		

		if (isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}

		waitForPopup(driver, Popup_Message, Save_popup);

		String popup_message = getText(driver, Popup_Message);
		if (popup_message.equals(Save_popup)) {
			System.out.println(
					"Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message);
			Extent_pass_New(driver,
					"Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message);
			Extent_fail(driver,
					"Not Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message,
					test, test1);
		}
		}
		
		
		if(Selection_Type.equalsIgnoreCase("Selected Containers")) {
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForElement(driver, Detention_save_Yes_Button);
			click(driver, Detention_save_Yes_Button);
			
			waitForPopup(driver, Popup_Message, Save_popup);

			String popup_message = getText(driver, Popup_Message);
			if (popup_message.equals(Save_popup)) {
				System.out.println(
						"Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message);
				Extent_pass_New(driver,
						"Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message, test,
						test1);

			} else {
				System.out.println(
						"Not Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message);
				Extent_fail(driver,
						"Not Matched || Expected popup was : " + Save_popup + " || Actual popup was : " + popup_message,
						test, test1);
			}
			
		}

		Step_End(10, "CLick on save button", test, test1);

		Step_Start(11, "Close the Module", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(11, "Close the Module", test, test1);

		Step_Start(12, "Open Import invoice module", test, test1);
		moduleNavigate(driver, Import_Invoice_Module);
		Step_End(12, "Open Import invoice module", test, test1);

		Step_Start(13, "Click new button and load the BL NO using By /VSL (Steps has to follow Accoudingly)", test,
				test1);

		newButton(driver);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

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
			sendKeys(driver, PortTerminal_Input, Terminal_Code);
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);

			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);
		

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
		Step_End(13, "Click new button and load the BL NO using By /VSL (Steps has to follow Accoudingly)", test,
				test1);

		scrollBottom(driver);
		List<Map<String, String>> ChargesTabValues;

		if (Select_Extension.contains("Storage Extension")) {
			Step_Start(14, ".A. Go to Detention/Storage CHarges tab", test, test1);
			waitForElement(driver, port_storage_charges_Tab_IN);
			click(driver, port_storage_charges_Tab_IN);
			Step_End(14, ".A  Go to Detention/Storage CHarges tab", test, test1);
			Step_Start(15, ".A END data has to be listed accourding to the continers", test, test1);
			waitForElement(driver, portStorageCharges_Table_Columns_IN);
			ChargesTabValues = getTableData(driver, portStorageCharges_Table_Columns_IN,
					portStorageCharges_Table_Rows_IN);
			Step_End(15, ".A END data has to be listed accourding to the continers", test, test1);
		} else {
			Step_Start(14, "Go to Detention CHarges tab", test, test1);
			waitForElement(driver, Detention_Charges_Tab_IN);
			click(driver, Detention_Charges_Tab_IN);
			Step_End(14, "Go to Detention CHarges tab", test, test1);
			Step_Start(15, "END data has to be listed accourding to the continers", test, test1);
			waitForElement(driver, detentionCharges_Table_Columns_IN);
			ChargesTabValues = getTableData(driver, detentionCharges_Table_Columns_IN, detentionCharges_Table_Rows_IN);
			Step_End(15, "END data has to be listed accourding to the continers", test, test1);
		}

		List<String> columnheaders = splitAndExpand(Charges_Amount_Headers_Invoice);
		Map<String, List<String>> AmountValuesExp = getValuesByID(ChargesTabValues, Charges_Based_Header,
				containersList, columnheaders);
		String AmountValuesExp_Tabledata = TableDataForReport(driver, ChargesTabValues, "Invoice Table Data",
				columnheaders);

		scrollTop(driver);
		Step_Start(16, "Click on save Button  Extention save Completed", test, test1);

		waitForElement(driver, import_Invoice_Issued_Button);
		click(driver, import_Invoice_Issued_Button);
		Step_End(16, "Click on save Button  Extention save Completed", test, test1);

		Step_Start(17, "Import Invoice saved", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Invoice_saved_pop);
		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);
		if (Invoice_saved_pop.equals(import_saved_act)) {
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

		waitForElement(driver, ETA_Date_Input_All);
		String ETAValue = getText(driver, ETA_Date_Input_All);

		Step_End(17, "Import Invoice saved", test, test1);

		if (Load_Profile_Name.equalsIgnoreCase("Line Profile")) {
			Step_Start(18, "Switch to line", test, test1);
			ResetProfile(driver);
			Step_End(18, "Switch to line", test, test1);

			Step_Start(19, " Open Detention Storage Report", test, test1);
			moduleNavigate(driver, Detention_Storage_Module);
			waitForDisplay(driver, NewButton_ToolBar);
			Step_End(19, " Open Detention Storage Report", test, test1);

			Step_Start(20, " Click on New Button", test, test1);
			newButton(driver);
			Step_End(20, " Click on New Button", test, test1);

			Step_Start(20, " A. Select the Corporate COde", test, test1);
			waitForElement(driver, CorporateAgency_SearchBtn);
			click(driver, CorporateAgency_SearchBtn);
			twoColumnSearchWindow(driver, Corporate_Header, Code_Filter_Condition, Corporate_Agency);
			Step_End(20, " A. Select the Corporate COde", test, test1);

			Step_Start(20, ".B  Select the agency COde,", test, test1);
			waitForElement(driver, Agency_SearchBtn);
			click(driver, Agency_SearchBtn);
			twoColumnSearchWindow(driver, Agency_Header, Code_Filter_Condition, Agency_Code);
			Step_End(20, ".B  Select the agency COde,", test, test1);

		} else {
			Step_Start(19, " Open Detention Storage Report", test, test1);
			moduleNavigate(driver, Detention_Storage_Module);
			Step_End(19, " Open Detention Storage Report", test, test1);

			Step_Start(20, " Click on New Button", test, test1);

			newButton(driver);

			Step_End(20, " Click on New Button", test, test1);
		}

		Extent_call(test, test1, "Select Shipment Type -start");
		waitForElement(driver, ShipmentInput);
		click(driver, ShipmentInput);

		waitForElement(driver, SelectShipmentOption);
		click(driver, SelectShipmentOption);
		Extent_call(test, test1, "Select Shipment Type -End");

		Extent_call(test, test1, "Select Report Type -start");
		waitForElement(driver, ReportTypeInput);
		click(driver, ReportTypeInput);

		if (Select_Extension.contains("Storage Extension")) {
			String SelectReportOption = String.format(ReportInput, Select_Storage);
			waitForElement(driver, SelectReportOption);
			click(driver, SelectReportOption);
		} else {
			String SelectReportOption = String.format(ReportInput, Select_Detention);
			waitForElement(driver, SelectReportOption);
			click(driver, SelectReportOption);
		}
		Extent_call(test, test1, "Select Report Type -End");

		Step_Start(21, " Select report By Voyage/Date Option has to refer from Excel", test, test1);

		if (Select_Report_By.equalsIgnoreCase("By Voyage")) {

			waitForElement(driver, SelectVoyageOption);
			click(driver, SelectVoyageOption);
			Extent_cal(test, test1, "If Voyage option follow below,\r\n"
					+ "Select the Service,Vessel, Voyage, Bound,POL, POD, - start");

			waitForElement(driver, ServiceSearchButton_);
			click(driver, ServiceSearchButton_);

			twoColumnSearchWindow(driver, Service_Header, Voyage_Filter_Condition, Service_Code);

			waitForElement(driver, VesselSearchButton_);
			click(driver, VesselSearchButton_);

			twoColumnSearchWindow(driver, Vessel_Header, Voyage_Filter_Condition, Vessel_Code);

			waitForElement(driver, VoyageSearchButton_);
			click(driver, VoyageSearchButton_);

			twoColumnSearchWindow(driver, Voyage_Header, Voyage_Filter_Condition, Voyage_Number);

			if (SelectShipmentOption.equalsIgnoreCase("EXPORT")) {
				waitForElement(driver, POL_SearchButton_);
				click(driver, POL_SearchButton_);
				twoColumnSearchWindow(driver, POL_Header, Voyage_Filter_Condition, Port_Code);
			} else {
				waitForElement(driver, POD_searchbutton_);
				click(driver, POD_searchbutton_);
				twoColumnSearchWindow(driver, POD_Header, Voyage_Filter_Condition, POD_Code);
			}

			Extent_cal(test, test1,
					"If Voyage option follow below,\r\n" + "Select the Service,Vessel, Voyage, Bound,POL, POD, - End");
		} else {

			waitForElement(driver, SelectDateOption);
			click(driver, SelectDateOption);
			Extent_cal(test, test1,
					"If Date option follow below,\r\n" + "Check Shipment Date as ETA/EMS start/EMS END option,\r\n"
							+ "accouding to that go and click it,\r\n" + "Pass From and TO Date   --  Start");
			
			 String Inv_Sts_Rep_StartDate=beforeDaysToDate(ETAValue, "2");
			 String Inv_Sts_Rep_EndDate=addDaysToDate(ETAValue, "3");
				
			
			if (Date_Select_Type.equalsIgnoreCase("Shipment Date")) {
				waitForElement(driver, ShipmentDateOption);
				click(driver, ShipmentDateOption);
				selectDatePicker(driver, Shipment_FromDateInput, Inv_Sts_Rep_StartDate);
				selectDatePicker(driver, Shipment_ToDateInput, Inv_Sts_Rep_EndDate);
			} else if (Date_Select_Type.equalsIgnoreCase("EMS Start activty")) {
				waitForElement(driver, EMS_StartActivityOption);
				click(driver, EMS_StartActivityOption);
				selectDatePicker(driver, EMS_Start_FromDate, From_Date_Value);
				selectDatePicker(driver, EMS_Start_ToDate, To_Date_Value);
			} else {
				waitForElement(driver, EMS_EndActivityOption);
				click(driver, EMS_EndActivityOption);
				selectDatePicker(driver, EMS_End_FromDate, From_Date_Value);
				selectDatePicker(driver, EMS_End_ToDate, To_Date_Value);
			}

			Extent_cal(test, test1,
					"If Date option follow below,\r\n" + "Check Shipment Date as ETA/EMS start/EMS END option,\r\n"
							+ "accouding to that go and click it,\r\n" + "Pass From and TO Date   --  End");
		}

		Step_End(21, " Select report By Voyage/Date Option has to refer from Excel", test, test1);

		if (Supress_Zero_Balance.equalsIgnoreCase("Yes")) {
			waitForElement(driver, SuperZeroInput);
			click(driver, SuperZeroInput);
		}

		if (Use_Report_Date.equalsIgnoreCase("Yes")) {
			waitForElement(driver, UseReportDateCheckBox);
			click(driver, UseReportDateCheckBox);
		}

		if (Use_ETD_Date.equalsIgnoreCase("Yes")) {
			if (Select_Shipment.equalsIgnoreCase("EXPORT")) {
				waitForElement(driver, UseETD_DateCheckBox);
				click(driver, UseETD_DateCheckBox);
			}
		}

		Step_Start(22, " click on SHow button", test, test1);

		waitForElement(driver, ShowButton_);
		click(driver, ShowButton_);

		if (isdisplayed(driver, popup_Message)) {
			String popText = getText(driver, popup_Message);
			Extent_fail(driver,
					"Expected result is : No popup should be shown || Actual result is : Popup Displayed after select Show Button : "
							+ popText,
					test, test1);
		}
		Step_End(22, " click on SHow button", test, test1);

		Step_Start(23, "Go to Invoice Amount Column and Verify  it", test, test1);

		waitForElement(driver, Total_Record);

		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver, AG_Grid_Columns_Button_DW);

		waitForElement(driver, Column_Search_Input);
		click(driver, SelectAll_Column_CheckBox);

		List<String> columns = splitAndExpand(Select_Columns);

		for (String column : columns) {
			waitForElement(driver, Column_Search_Input);
			clear(driver, Column_Search_Input);
			waitForElement(driver, Column_Search_Input);
			sendKeys(driver, Column_Search_Input, column);

			waitForElement(driver, Column_Search_Input);
			click(driver, SelectAll_Column_CheckBox);
		}

		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver, AG_Grid_Columns_Button_DW);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);

		waitForElement(driver, BL_Search_input);
		sendKeys(driver, BL_Search_input, BL_Number_input);

		waitForElement(driver, DetentionStorage_Row);

		List<Map<String, String>> ChargesValues_Dentention = extractTableDataDirect1(driver, Table_DetentionStorage);

		System.out.println("ChargesValues_Dentention : " + ChargesValues_Dentention);
		List<String> ChargesHeader = splitAndExpand(DnS_Report_Header);
		Map<String, List<String>> ChargesValuesAct = getValuesByID(ChargesValues_Dentention,
				Compare_Base_Header_Detention, containersList, ChargesHeader);
		String ChargesValuesAct_Tabledata = TableDataForReport(driver, ChargesValues_Dentention, "Detention Storage",
				ChargesHeader);

		if (CompareMapListValues2(AmountValuesExp, ChargesValuesAct)) {
			System.out.println("Matched || Expected value was : " + AmountValuesExp + " || Actual value was : "
					+ ChargesValuesAct);
			Extent_pass_New(driver,
					"Matched || Expected value was : " + AmountValuesExp + " || Actual value was : " + ChargesValuesAct,
					test, test1);
			Extent_pass_New(driver,
					"Matched || Invoice Table data was : \n" + "<pre>" + AmountValuesExp_Tabledata + "</pre> \n "
							+ "|| Detention Storage Table data was : \n" + "<pre>" + ChargesValuesAct_Tabledata
							+ "</pre>",
					test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + AmountValuesExp + " || Actual value was : "
					+ ChargesValuesAct);
			Extent_fail(driver, "NotMatched || Expected value was : " + AmountValuesExp + " || Actual value was : "
					+ ChargesValuesAct, test, test1);
		}

		Step_End(23, "Go to Invoice Amount Column and Verify  it", test, test1);

		Extent_cal(test, test1, "Delete Script has to Right to reversal the invoice and Delete the Extension. - Start");
		if (Delete_Invoice.equalsIgnoreCase("Yes")) {
			Extent_cal(test, test1, " Delete import invoice");

			SwitchProfile(driver, AgencyUser);

			moduleNavigate(driver, Invoice_Reversel_Module);

			scrollTop(driver);

			newButton(driver);

			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);

			globalValueSearchWindow(driver, Reversal_Condition, Reversal_Filter_Type, BL_Number_input, "", "", "", "");

			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);

			waitForElement(driver, inv_Reversal_Table_Header);
			List<Map<String, String>> invoice_Details_Table = getTableData(driver, inv_Reversal_Table_Header,
					invoiceReversal_Table_Rows);

			List<String> invoice_Numbers = getValuesByHeader(invoice_Details_Table, "Invoice No");

			System.out.println("INVOICE NUMBERS SHOWN IN THE GRID ARE :" + invoice_Numbers);

			waitForElement(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, Invoice_Reversal_Remark);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Reversal_Invoice_Popup);
			String ReversalMessage = getText(driver, popup_Message);
			if (ReversalMessage.contains(Reversal_Invoice_Popup)) {
				System.out.println(
						"Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage);
				Extent_pass_New(driver,
						"Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage, test,
						test1);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			} else {
				System.out.println(
						"Not Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage);
				Extent_fail(driver,
						"Not Matched || Expected : " + Reversal_Invoice_Popup + "  || Actual : " + ReversalMessage,
						test, test1);
			}

			waitForPopup(driver, popup_Message, Invoice_Reversal_Success);
			String ReversalSuccessMessage = getText(driver, popup_Message);
			if (ReversalSuccessMessage.contains(Invoice_Reversal_Success)) {
				System.out.println("Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : "
						+ ReversalSuccessMessage);
				Extent_pass_New(driver,
						"Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : " + ReversalSuccessMessage,
						test, test1);
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : "
						+ ReversalSuccessMessage);
				Extent_fail(driver, "Not Matched || Expected : " + Invoice_Reversal_Success + "  || Actual : "
						+ ReversalSuccessMessage, test, test1);
			}

			moduleNavigate(driver, Detention_Demurrage_Module);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, Detention_delete_Condition, Extention_delete_Filter_Type, BL_Number_input,
					"", "", "", "");

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, Delete_Storage_Popup);
			String StorageDeleteMessage = getText(driver, popup_Message);
			if (StorageDeleteMessage.contains(Delete_Storage_Popup)) {
				System.out.println(
						"Matched || Expected : " + Delete_Storage_Popup + "  || Actual : " + StorageDeleteMessage);
				Extent_pass_New(driver,
						"Matched || Expected : " + Delete_Storage_Popup + "  || Actual : " + StorageDeleteMessage, test,
						test1);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			} else {
				System.out.println(
						"Not Matched || Expected : " + Delete_Storage_Popup + "  || Actual : " + StorageDeleteMessage);
				Extent_fail(driver,
						"Not Matched || Expected : " + Delete_Storage_Popup + "  || Actual : " + StorageDeleteMessage,
						test, test1);
			}

			Extent_cal(test, test1,
					"Delete Script has to Right to reversal the invoice and Delete the Extension. - End");
		}

		Extent_completed(testcase_Name, test, test1);

	}

}
