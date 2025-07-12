package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC025E extends Keywords {
	public void Import_Invoice_SC025E(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testCaseName = "TC_Import_Invoice_SC025E";
		// Get data from test data
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String GlobalValue = Excel_data.get("GlobalValue");
		String Reset_Option = Excel_data.get("Reset_Option");
		String Configuration_Reset = Excel_data.get("Configuration_Reset");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Global_Search_Input1 = Excel_data.get("Global_Search_Input1");
		String Global_Search_Input2 = Excel_data.get("Global_Search_Input2");
		String Global_Search_Input3 = Excel_data.get("Global_Search_Input3");
		String Service_Name = Excel_data.get("Service_Name");
		String vesselcode = Excel_data.get("vesselcode");
		String voyagecode = Excel_data.get("voyagecode");
		String bound = Excel_data.get("bound");
		String terminal = Excel_data.get("terminal");
		String portcode = Excel_data.get("portcode");
		String Condition = Excel_data.get("Condition");
		String ContainerNumbers_Header = Excel_data.get("ContainerNumbers_Header");
		String Container_columns_Headers = Excel_data.get("Container_columns_Headers");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Option1 = Excel_data.get("BookingSearch_Option1");
		String BookingSearch_Option2 = Excel_data.get("BookingSearch_Option2");
		String BookingSearch_Option3 = Excel_data.get("BookingSearch_Option3");
		String WaiverOption = Excel_data.get("WaiverOption");
		String Additional_FreeDays = Excel_data.get("Additional_FreeDays");
		String Remark = Excel_data.get("Remark");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Remarks_value = Excel_data.get("Remarks_value");
		String Approved_Success_popup_Detention = Excel_data.get("Approved_Success_popup_Detention");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Reason = Excel_data.get("Reason");
		String Module_Import_Invoice = Excel_data.get("Module_Import_Invoice");
		String Import_BL_Retrive_Option = Excel_data.get("Import_BL_Retrive_Option");
		String Import_BL_Filter_Type1 = Excel_data.get("Import_BL_Filter_Type1");
		String Import_BL_Filter_Type2 = Excel_data.get("Import_BL_Filter_Type2");
		String Import_BL_Filter_Type3 = Excel_data.get("Import_BL_Filter_Type3");
		String Import_Customer_Filter_Type1 = Excel_data.get("Import_Customer_Filter_Type1");
		String CustomerCode_Input1 = Excel_data.get("CustomerCode_Input1");
		String Import_Customer_Filter_Type2 = Excel_data.get("Import_Customer_Filter_Type2");
		String CustomerCode_Input2 = Excel_data.get("CustomerCode_Input2");
		String CustomerCode_Input3 = Excel_data.get("CustomerCode_Input3");
		String Import_Customer_Filter_Type3 = Excel_data.get("Import_Customer_Filter_Type3");
		String House_Bl_Option = Excel_data.get("House_Bl_Option");
		String House_Bl_Number = Excel_data.get("House_Bl_Number");
		String Detention_Option_For_DW = Excel_data.get("Detention_Option_For_DW");
		String Storage_Option_For_Dw = Excel_data.get("Storage_Option_For_Dw");
		String Detention_Tab_Name_In_Iport_Invoice = Excel_data.get("Detention_Tab_Name_In_Iport_Invoice");
		String Storage_Tab_Name_In_Iport_Invoice = Excel_data.get("Storage_Tab_Name_In_Iport_Invoice");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Excl_Incl_Data = Excel_data.get("Excl_Incl_Data");
		String Delete_option_perform = Excel_data.get("Delete_option_perform");
		String Waiver_number_option = Excel_data.get("Waiver_number_option");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		
		
		
		
		// Navigate the url
		navigateUrl(driver, url);
		// Script Start
		Extent_Start(testCaseName, test, test1);
		// Login
		LRP_Login(driver, username, password);
		// Verify Main Menu
		verifyMainMenu(driver);
		// Switch Agency
		SwitchProfile(driver, AgencyUser);
		// Set Global Configuration
		setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
		
		// Detention Waiver
		
		List<String> Detention_Waiver_Numbers = new ArrayList<>();

		moduleNavigate(driver, Detention_Module);
		newButton(driver);
		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		String Waiveroption = String.format(DW_WaiverOption, WaiverOption);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);
		
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);
		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);
		globalValueSearchWindow(driver, Global_Search_Condition, BookingSearch_Option1, Global_Search_Input1,
				BookingSearch_Option2, Global_Search_Input2, BookingSearch_Option3, Global_Search_Input3);
		waitForElement(driver, DW_BLNo_Input);
		String Booking_No = getAttribute(driver, DW_BLNo_Input, "value");
		if (Booking_No.equals(Global_Search_Input1)) {
			System.out.println("Given Booking number was retrived || Expected : " + Global_Search_Input1
					+ " || Actual : " + Booking_No);
			Extent_pass_New(driver, "Given Booking number was retrived || Expected : " + Global_Search_Input1
					+ " || Actual : " + Booking_No, test, test1);
		} else {
			System.out.println("Given Booking number was not retrived || Expected : " + Global_Search_Input1
					+ " || Actual : " + Booking_No);
			Extent_fail(driver, "Given Booking number was not retrived || Expected : " + Global_Search_Input1
					+ " || Actual : " + Booking_No, test, test1);
		}
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		scrollBottom(driver);
		waitForElement(driver, DW_ContainersGrid_SelectAll);
			click(driver, DW_ContainersGrid_SelectAll);
		waitForElement(driver, DW_Additional_Free_Days);
		click(driver, DW_Additional_Free_Days);
		Newclear(driver, DW_Additional_Free_Days);
		Actionsendkeys(driver, DW_Additional_Free_Days, Additional_FreeDays);
		waitForElement(driver, EX_IN_Field);
		click(driver, EX_IN_Field);
		formatLocatorClick(driver, DropDown_Select, Excl_Incl_Data);
		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);
		waitForElement(driver, Waiver_Value_Table);
		List<Map<String, String>> waiverTable = extractTableDataCountMissMatch(driver, Waiver_Value_Table);
		List<String> free_Days = getValuesByHeader(waiverTable, Container_columns_Headers);
		List<Double> Expected_Freedays = convertStringListToDoubleList(driver, free_Days);
		List<String> givencontainers = getValuesByHeader(waiverTable, ContainerNumbers_Header);
		scrollTop(driver);
		Step_Start(6, "Enter the Remarks in Remarks section", test, test1);
		waitForElement(driver, DW_Remarks);
		click(driver, DW_Remarks);
		sendKeys(driver, DW_Remarks, Remark);
		if (isdisplayed(driver, DW_ReasonSearch)) {
			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);
			twoColumnSearchWindow(driver, Waiver_Reason_Header, Condition, Reason);
		}
		scrollTop(driver);
		waitForElement(driver, DW_Submitted);
		jsClick(driver, DW_Submitted);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup, Submitted_Popup);
		String Submit_popup_Message = getText(driver, popup);
		if (Submit_popup_Message.equals(Submitted_Popup)) {
			System.out.println("Detention Waiver submitted successfully || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message);
			Extent_pass_New(driver, "Detention Waiver submitted successfully || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message, test, test1);
		} else {
			System.out.println("Detention Waiver not submitted || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message);
			Extent_fail(driver, "Detention Waiver not submitted || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message, test, test1);
		}
		waitForElement(driver, DW_Waiver_Reference_input);
		String Waiver_Number = getAttribute(driver, DW_Waiver_Reference_input, "value");
		System.out.println("Detention_waiver_Number : " +Waiver_Number);
		Detention_Waiver_Numbers.add(Waiver_Number);

		
		ResetProfile(driver);
		moduleNavigate(driver, Detention_Module);
		waitForElement(driver, last_Common_btn);
		jsClick(driver, last_Common_btn);
		waitForElement(driver, DW_WaiverStatus);
		String Status = getText(driver, DW_WaiverStatus);
		if (Status.contains("Submitted")) {
			System.out.println(
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status);
			Extent_pass_New(driver,
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status,
					test, test1);
		} else {
			System.err.println(
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status);
			Extent_fail(driver,
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status,
					test, test1);
		}
		waitForElement(driver, Edit_Button_toolBar);
		jsClick(driver, Edit_Button_toolBar);
		waitForElement(driver, DW_Approved_option);
		jsClick(driver, DW_Approved_option);
		scrollBottom(driver);
		waitForElement(driver, DW_Remarks_Input);
		sendKeys(driver, DW_Remarks_Input, Remarks_value);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup, Approved_Success_popup_Detention);
		String popupMessage = getText(driver, popup);
		if (popupMessage.equals(Approved_Success_popup_Detention)) {
			System.out.println("Detention Waiver Approved successfully || Expected popup : "
					+ Approved_Success_popup_Detention + " || Actual popup : " + popupMessage);
			Extent_pass_New(driver, "Detention Waiver Approved successfully || Expected popup : "
					+ Approved_Success_popup_Detention + " || Actual popup : " + popupMessage, test, test1);
		} else {
			System.out.println("Detention Waiver not Approved || Expected popup : " + Approved_Success_popup_Detention
					+ " || Actual popup : " + popupMessage);
			Extent_fail(driver, "Detention Waiver not Approved || Expected popup : " + Approved_Success_popup_Detention
					+ " || Actual popup : " + popupMessage, test, test1);
		}
		// Switch Agency
		SwitchProfile(driver, AgencyUser);
		// Import Invoice
		moduleNavigate(driver, Module_Import_Invoice);
		newButton(driver);
		if (Import_BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForDisplay(driver, By_BL_Number_Btn);
			click(driver, By_BL_Number_Btn);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);
			if (House_Bl_Option.equalsIgnoreCase("Yes")) {
				globalValueSearchWindow(driver, Global_Search_Condition, Import_BL_Filter_Type1, House_Bl_Number,Import_BL_Filter_Type2, Global_Search_Input2, Import_BL_Filter_Type3, Global_Search_Input3);
			} else {
				globalValueSearchWindow(driver, Global_Search_Condition, Import_BL_Filter_Type1, Global_Search_Input1,
						Import_BL_Filter_Type2, Global_Search_Input2, Import_BL_Filter_Type3, Global_Search_Input3);
			}
		} else if (Import_BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
			waitForDisplay(driver, By_Vessel_Btn);
			click(driver, By_Vessel_Btn);
			waitForElement(driver, service_Txtfield_IN);
			sendKeys(driver, service_Txtfield_IN, Service_Name);
			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, vesselcode);
			sendKeys(driver, voyage_code_input, voyagecode);
			sendKeys(driver, bounnd_code_input, bound);
			sendKeys(driver, PortCode_Input, portcode);
			horizontalscroll(driver, InvoiceGridScroll, 300);
			click(driver, PortTerminal_Input);
			sendKeys(driver, PortTerminal_Input, terminal);
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);
			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);
			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);
			globalValueSearchWindow(driver, Global_Search_Condition, Import_Customer_Filter_Type1, CustomerCode_Input1,
					Import_Customer_Filter_Type2, CustomerCode_Input2, Import_Customer_Filter_Type3,
					CustomerCode_Input3);
			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);
			waitForDisplay(driver, popup_Message_Ok_Button);
			if (isdisplayed(driver, popup_Message_Ok_Button)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			}if(isdisplayed(driver, popup_Message)) {
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


				waitForElement(driver, Import_Invoice_BL_Details_Table_Row);

				if (verifyElementHasText(driver, Import_Invoice_BL_Details_Table_Row)) {

					System.out.println(
							"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab");
					Extent_pass_New(driver,
							"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab",
							test, test1);

				} else {
					System.out.println(
							"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab");
					Extent_fail(driver,
							"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab",
							test, test1);
				}

				
				
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
				
				
				
				RemoveBLfromInvoice(driver, Global_Search_Input1, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);
		}
		if (DetentionStorage_Option.equals(Detention_Option_For_DW)) {
			formatLocatorClick(driver, import_Invoice_Tab, Detention_Tab_Name_In_Iport_Invoice);
			waitForElement(driver, detention_Table_Headers);
			List<Map<String, String>> manifest_Table_Data = getTableData(driver, detention_Table_Headers,
					detention_Table_Rows);
			List<String> actual_Free_Days = getValuesByHeader(manifest_Table_Data, "Free Days");
			List<Double> doubleList = convertStringListToDoubleList(driver, actual_Free_Days);
			for (int i = 0; i < doubleList.size(); i++) {
				Double ExpectedFreeDays = Expected_Freedays.get(i);
				Double ActualFreeDays = doubleList.get(i);
				if (Double.compare(ExpectedFreeDays, ActualFreeDays) == 0) {
					System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers +" The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_pass_New(driver,
							"Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.",
							test, test1);
				} else {
					System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_fail(driver,
							"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers +" The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.",
							test, test1);
				}
			}
		}
		if (DetentionStorage_Option.equals(Storage_Option_For_Dw)) {
			formatLocatorClick(driver, import_Invoice_Tab, Storage_Tab_Name_In_Iport_Invoice);
			waitForElement(driver, storage_Table_Headers);
			List<Map<String, String>> manifest_Table_Data = getTableData(driver, storage_Table_Headers,
					storage_Table_Rows);
			List<String> actual_Free_Days = getValuesByHeader(manifest_Table_Data, "Free Days");
			List<Double> doubleList = convertStringListToDoubleList(driver, actual_Free_Days);
			for (int i = 0; i < doubleList.size(); i++) {
				Double ExpectedFreeDays = Expected_Freedays.get(i);
				Double ActualFreeDays = doubleList.get(i);
				if (Double.compare(ExpectedFreeDays, ActualFreeDays) == 0) {
					System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_pass_New(driver,
							"Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.",
							test, test1);
				} else {
					System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_fail(driver,
							"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers +" The Free days Added From The Detention Waiver value is : " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.",
							test, test1);
				}
			}
		}
		// reSet Global Configuration
		reSetGlobalConfiguration(driver, Reset_Option, GlobalConfigurationModule, GlobalID, Configuration_Reset);

		moduleNavigate(driver, Detention_Module);
		for(int i = 0;i<Detention_Waiver_Numbers.size();i++) {
		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			waitForElement(driver, SearchButton_Toolbar);
			jsClick(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, Global_Search_Condition, Waiver_number_option, Detention_Waiver_Numbers.get(i), "", "", "", "");

			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
			waitForElement(driver, popup_Message_Yes_Button);
			jsClick(driver, popup_Message_Yes_Button);
			waitForElement(driver, DW_Remarks_Input);
			clearAndType(driver, DW_Remarks_Input, Remarks_value);

			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

		}
		}
		
		// Script End
		Extent_completed(testCaseName, test, test1);
	}
}