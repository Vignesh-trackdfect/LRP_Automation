package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC025D extends Keywords {
	public void Import_Invoice_SC025D(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testCaseName = "TC_Import_Invoice_SC025D";
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
		String Detention_Tab_Name_In_Iport_Invoice = Excel_data.get("Detention_Tab_Name_In_Iport_Invoice");
		String Storage_Tab_Name_In_Iport_Invoice = Excel_data.get("Storage_Tab_Name_In_Iport_Invoice");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
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
		if (Detention_Tab_Name_In_Iport_Invoice .contains(DetentionStorage_Option)) {
			formatLocatorClick(driver, import_Invoice_Tab, Detention_Tab_Name_In_Iport_Invoice);
			waitForElement(driver, detention_Table_Headers);
			List<Map<String, String>> manifest_Table_Data = getTableData(driver, detention_Table_Headers,
					detention_Table_Rows);
			List<String> actual_Free_Days = getValuesByHeader(manifest_Table_Data, "Free Days");
			List<String> actual_Container_Type = getValuesByHeader(manifest_Table_Data, "Container Type");
			List<Double> doubleList = convertStringListToDoubleList(driver, actual_Free_Days);
			List<Double> totalFreeDaysValues = convertStringListToDoubleList(driver, free_Days_From_ImportDoc);
			for (int i = 0; i < doubleList.size(); i++) {
				Double ExpectedFreeDays = totalFreeDaysValues.get(i);
				Double ActualFreeDays = doubleList.get(i);
				if (Double.compare(ExpectedFreeDays, ActualFreeDays) == 0) {
					System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_fail(driver,
							"Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.",
									test, test1);
				} else {
					System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_pass_New(driver,
							"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab.",
									test, test1);
					formatLocatorDoubleClick(driver, DetentionTab_Container_Select, givencontainers.get(i));
					scrollBottom(driver);
					formatLocatorDoubleClick(driver, Tarrif_EquipmentType_Select, actual_Container_Type.get(i));
					waitForElement(driver, Tarrif_Equip_Table_Header);
					List<Map<String, String>> EquipTable_Data = getTableData(driver, Tarrif_Equip_Table_Header, Tarrif_Equip_Table_Rows);
					String tariff_FreeDays = getFirstRowValueByHeaderFromTableData(EquipTable_Data, "Slab To");
					if (actual_Free_Days.get(i).equals(tariff_FreeDays)) {
						System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
								+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
								+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays);
						Extent_pass_New(driver,
								"Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
										+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
										+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays,
										test, test1);
					} else {
						System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
								+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
								+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays);
						Extent_fail(driver,
								"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
										+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
										+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays,
										test, test1);
					}
					scrollTop(driver);
					waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab);
				}
			}
		}
		if (Storage_Tab_Name_In_Iport_Invoice .contains(DetentionStorage_Option)) {
			formatLocatorClick(driver, import_Invoice_Tab, Storage_Tab_Name_In_Iport_Invoice);
			waitForElement(driver, storage_Table_Headers);
			List<Map<String, String>> manifest_Table_Data = getTableData(driver, storage_Table_Headers,
					storage_Table_Rows);
			List<String> actual_Free_Days = getValuesByHeader(manifest_Table_Data, "Free Days");
			List<String> actual_Container_Type = getValuesByHeader(manifest_Table_Data, "Container Type");
			List<Double> doubleList = convertStringListToDoubleList(driver, actual_Free_Days);
			List<Double> totalFreeDaysValues = convertStringListToDoubleList(driver, free_Days_From_ImportDoc);
			for (int i = 0; i < doubleList.size(); i++) {
				Double ExpectedFreeDays = totalFreeDaysValues.get(i);
				Double ActualFreeDays = doubleList.get(i);
				if (Double.compare(ExpectedFreeDays, ActualFreeDays) == 0) {
					System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_fail(driver,
							"Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.",
									test, test1);
				} else {
					System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
							+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
							+ " || The Actual Value from the Import Invoice Freedays Value is : " + ActualFreeDays
							+ " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.");
					Extent_pass_New(driver,
							"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The "
									+ Container_columns_Headers + " Value From Import Documentation " + ExpectedFreeDays
									+ " || The Actual Value from the Import Invoice Freedays Value is : "
									+ ActualFreeDays + " in " + Storage_Tab_Name_In_Iport_Invoice + " Tab.",
									test, test1);
					formatLocatorDoubleClick(driver, StorageTab_Container_Select, givencontainers.get(i));
					scrollBottom(driver);
					formatLocatorDoubleClick(driver, Tarrif_EquipmentType_Select, actual_Container_Type.get(i));
					waitForElement(driver, Tarrif_Equip_Table_Header);
					List<Map<String, String>> EquipTable_Data = getTableData(driver, Tarrif_Equip_Table_Header, Tarrif_Equip_Table_Rows);
					String tariff_FreeDays = getFirstRowValueByHeaderFromTableData(EquipTable_Data, "Slab To");
					if (actual_Free_Days.get(i).equals(tariff_FreeDays)) {
						System.out.println("Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
								+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
								+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays);
						Extent_pass_New(driver,
								"Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
										+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
										+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays,
										test, test1);
					} else {
						System.out.println("Not Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
								+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
								+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays);
						Extent_fail(driver,
								"Not Matched || The Container Number is : " + givencontainers.get(i) + " || The Equipment Type is : "
										+ actual_Container_Type.get(i) + " Free days Value From Import Import Invoice " + actual_Free_Days.get(i)+ " in " + Detention_Tab_Name_In_Iport_Invoice + " Tab."
										+ " || The Actual Free Days Value from the Detention and Demurrage Tariff is : " + ActualFreeDays,
										test, test1);
					}
					scrollTop(driver);
					waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab);
				}
			}
		}
		// reSet Global Configuration
		reSetGlobalConfiguration(driver, Reset_Option, GlobalConfigurationModule, GlobalID, Configuration_Reset);
		// Script End
		Extent_completed(testCaseName, test, test1);
	}
}