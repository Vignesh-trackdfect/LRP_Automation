package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC025A extends Keywords {
	public void Import_Invoice_SC025A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testCaseName = "TC_Import_Invoice_SC025A";
		// Get data from test data
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String GlobalValue = Excel_data.get("GlobalValue");
		String Reset_Option = Excel_data.get("Reset_Option");
		String Configuration_Reset = Excel_data.get("Configuration_Reset");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Global_Search_Type_Import_Doc1 = Excel_data.get("Global_Search_Type_Import_Doc1");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Global_Search_Input1 = Excel_data.get("Global_Search_Input1");
		String Global_Search_Type_Import_Doc2 = Excel_data.get("Global_Search_Type_Import_Doc2");
		String Global_Search_Input2 = Excel_data.get("Global_Search_Input2");
		String Global_Search_Type_Import_Doc3 = Excel_data.get("Global_Search_Type_Import_Doc3");
		String Global_Search_Input3 = Excel_data.get("Global_Search_Input3");
		String Service_Name = Excel_data.get("Service_Name");
		String vesselcode = Excel_data.get("vesselcode");
		String voyagecode = Excel_data.get("voyagecode");
		String bound = Excel_data.get("bound");
		String terminal = Excel_data.get("terminal");
		String portcode = Excel_data.get("portcode");
		String Pol_Header = Excel_data.get("Pol_Header");
		String Condition = Excel_data.get("Condition");
		String pol_Value = Excel_data.get("pol_Value");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String ContainerNumbers_Header = Excel_data.get("ContainerNumbers_Header");
		String Container_columns_Headers = Excel_data.get("Container_columns_Headers");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Option1 = Excel_data.get("BookingSearch_Option1");
		String BookingSearch_Option2 = Excel_data.get("BookingSearch_Option2");
		String BookingSearch_Option3 = Excel_data.get("BookingSearch_Option3");
		String Select_Containers = Excel_data.get("Select_Containers");
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
		String Container_Column_Detention = Excel_data.get("Container_Column_Detention");
		String Container_Column_Storage = Excel_data.get("Container_Column_Storage");
		
		
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
		// Import Documentation
		moduleNavigate(driver, ImportDocumentationModule);
		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, Global_Search_Condition, Global_Search_Type_Import_Doc1,
					Global_Search_Input1, Global_Search_Type_Import_Doc2, Global_Search_Input2,
					Global_Search_Type_Import_Doc3, Global_Search_Input3);
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			newButton(driver);
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service_Name);
			if (!vesselcode.equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, vesselcode);
			}
			if (!voyagecode.equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, voyagecode);
			}
			if (!bound.equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, bound);
			}
			if (!portcode.equals("")) {
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, portcode);
			}
			if (!terminal.equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				click1(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, terminal); 
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			scrollTop(driver);
			if (!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, Condition, pol_Value);
			}
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			formatLocatorClick(driver, DropDown_Select, Label_Select_1);
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			formatLocatorClick(driver, DropDown_Select, Label_Select_2);
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			waitForElement(driver, BL_Number);
			String Get_BL_Number = getAttribute(driver, BL_Number, "value");
			System.out.println("Get_BL_Number:" + Get_BL_Number);
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition, Global_Search_Input1);
		}
		if (House_Bl_Option.equalsIgnoreCase("Yes")) {
			waitForElement(driver, HBL_Num_click);
			click(driver, HBL_Num_click);
			formatLocatorClick(driver, DropDown_Select, House_Bl_Number);
		}
		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);
		scrollBottom(driver);
		waitForElement(driver, Container_Table_Header);
		List<Map<String, String>> tableData = getTableDatawithscroll(driver, Container_Table_Header,
				Container_Table_Row, Container_Table_Scroll, 80, 0);
		List<String> free_Days_From_ImportDoc = getValuesByHeader(tableData, Container_columns_Headers);
		List<String> givencontainers = getValuesByHeader(tableData, ContainerNumbers_Header);
		// Detention Waiver
		moduleNavigate(driver, Detention_Module);
		newButton(driver);
		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		String Waiveroption = String.format(DW_WaiverOption, WaiverOption);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);
		String DetentionStorage_Option = "";
		if (Container_columns_Headers.equals(Container_Column_Detention)) {
			DetentionStorage_Option = Detention_Option_For_DW;
		} else if (Container_columns_Headers.equals(Container_Column_Storage)) {
			DetentionStorage_Option = Storage_Option_For_Dw;
		}
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
		waitForElement(driver, DW_BLNo_Input);
		scrollUsingElement(driver, DW_ContainersGrid);
		if (Select_Containers.equals("Select All")) {
			waitForDisplay(driver, DW_ContainersGrid_SelectAll);
			jsClick(driver, DW_ContainersGrid_SelectAll);
		} else if (Select_Containers.equals("Selected Containers")) {
			
			mouseOverToElement(driver, Filter_Icon_Table1_DW);
			waitForElement(driver, Filter_Icon_Table1_DW);
			jsClick(driver,Filter_Icon_Table1_DW);
			
			for (String containerNum : givencontainers) {
				
				waitForElement(driver, Detention_container_Filter_input);
				Newclear(driver, Detention_container_Filter_input);
			    sendKeys(driver, Detention_container_Filter_input, containerNum);
			    
				String container_element = String.format(DW_Container_Select, containerNum);
				mouseOverToElement(driver, container_element);
				jsClick(driver, container_element);
			}
		}
		waitForElement(driver, DW_Additional_Free_Days);
		click(driver, DW_Additional_Free_Days);
		Newclear(driver, DW_Additional_Free_Days);
		Actionsendkeys(driver, DW_Additional_Free_Days, Additional_FreeDays);
		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);
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
		String popup_Message = getText(driver, popup);
		if (popup_Message.equals(Approved_Success_popup_Detention)) {
			System.out.println("Detention Waiver Approved successfully || Expected popup : "
					+ Approved_Success_popup_Detention + " || Actual popup : " + popup_Message);
			Extent_pass_New(driver, "Detention Waiver Approved successfully || Expected popup : "
					+ Approved_Success_popup_Detention + " || Actual popup : " + popup_Message, test, test1);
		} else {
			System.out.println("Detention Waiver not Approved || Expected popup : " + Approved_Success_popup_Detention
					+ " || Actual popup : " + popup_Message);
			Extent_fail(driver, "Detention Waiver not Approved || Expected popup : " + Approved_Success_popup_Detention
					+ " || Actual popup : " + popup_Message, test, test1);
		}
		List<Double> totalFreeDaysValues = addStringValueToList(free_Days_From_ImportDoc, Additional_FreeDays);
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
				globalValueSearchWindow(driver, Global_Search_Condition, Import_BL_Filter_Type1, House_Bl_Number,
						Import_BL_Filter_Type2, Global_Search_Input2, Import_BL_Filter_Type3, Global_Search_Input3);
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
			}
		}
		if (DetentionStorage_Option.equals(Detention_Option_For_DW)) {
			formatLocatorClick(driver, import_Invoice_Tab, Detention_Tab_Name_In_Iport_Invoice);
			waitForElement(driver, detention_Table_Headers);
			List<Map<String, String>> manifest_Table_Data = getTableData(driver, detention_Table_Headers,
					detention_Table_Rows);
			List<String> actual_Free_Days = getValuesByHeader(manifest_Table_Data, "Free Days");
			List<Double> doubleList = convertStringListToDoubleList(driver, actual_Free_Days);
			for (int i = 0; i < doubleList.size(); i++) {
				Double ExpectedFreeDays = totalFreeDaysValues.get(i);
				Double ActualFreeDays = doubleList.get(i);
				if (Double.compare(ExpectedFreeDays, ActualFreeDays) == 0) {
					System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
							+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_pass_New(driver,
							"Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
									+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.",
							test, test1);
				} else {
					System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
							+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_fail(driver,
							"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
									+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
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
				Double ExpectedFreeDays = totalFreeDaysValues.get(i);
				Double ActualFreeDays = doubleList.get(i);
				if (Double.compare(ExpectedFreeDays, ActualFreeDays) == 0) {
					System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
							+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_pass_New(driver,
							"Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
									+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.",
							test, test1);
				} else {
					System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
							+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_fail(driver,
							"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + free_Days_From_ImportDoc.get(i)
									+ " The Free days Added From The Detention Waiver value is : " + Additional_FreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.",
							test, test1);
				}
			}
		}
		// reSet Global Configuration
		reSetGlobalConfiguration(driver, Reset_Option, GlobalConfigurationModule, GlobalID, Configuration_Reset);
		// Script End
		Extent_completed(testCaseName, test, test1);
	}
}