package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC064G extends Keywords {

	public void Import_Documentation_SC064G(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		
		String testcase_Name="TC_Import_Documentation_SC064G";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String NewImportDocumentationPopup=Excel_data.get("NewImportDocumentationPopup");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Terminal = Excel_data.get("Terminal");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Import_Document_SavedPopup = Excel_data.get("Import_Document_SavedPopup");
		String Remarks_Tab_Refer_Head = Excel_data.get("Remarks_Tab_Refer_Head");
		String Import_Invoice_Saved_Popup = Excel_data.get("Import_Invoice_Saved_Popup");
		String Module_Import_Invoice = Excel_data.get("Module_Import_Invoice");
		String ImportInvoice_Select_Type = Excel_data.get("ImportInvoice_Select_Type");
		String Invoice_Already_CreatedPopup = Excel_data.get("Invoice_Already_CreatedPopup");
		String Enquiry_History_Module = Excel_data.get("Enquiry_History_Module");
		String Movement_Entry_Module = Excel_data.get("Movement_Entry_Module");
		String Movement_Entry_Final = Excel_data.get("Movement_Entry_Final");
		String RCVE_Days_Add = Excel_data.get("RCVE_Days_Add");
		String SNTC_Days_Add = Excel_data.get("SNTC_Days_Add");		
		String Port_Code_Header_ME = Excel_data.get("Port_Code_Header_ME");
		String Terminal_Code_Header_ME = Excel_data.get("Terminal_Code_Header_ME");
		String Book_Number_Header_ME = Excel_data.get("Book_Number_Header_ME");
		String Book_Number_Value_ME = Excel_data.get("Book_Number_Value_ME");
		String Invoice_Retrive_Type = Excel_data.get("Invoice_Retrive_Type");
		String Invoice_Mode_Input = Excel_data.get("Invoice_Mode_Input");
		String Final_Detention_Saved_Popup = Excel_data.get("Final_Detention_Saved_Popup");

		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		
		Step_Start(1, "Open Import Documentation module", test, test1);	
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(1, "open the import documentation module", test, test1);

		Step_Start(2, "CLick Search Button and Load the BL No", test, test1);	

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation=getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation, test,test1);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation,test, test1);
				}
			}
			
			
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);

			if(!Vessel.equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);

			scrollTop(driver);
			if(!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
			}

			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);
			
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);

			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition_Filter, BL_Num);	
		}
		Step_End(2, "CLick Search Button and Load the BL No", test, test1);	

		Step_Start(3, "Save the Import Doc,", test, test1);	
		
		waitForElement(driver, BL_status_IMP_DOC);
		String BL_Status_Act=getText(driver, BL_status_IMP_DOC);
		if(BL_Status_Act.equalsIgnoreCase("NEW")) {

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

			Step_Start(4, "Capture Save validation", test, test1);
			waitForPopup(driver, popup_Message, Import_Document_SavedPopup);
			String ImportDocumentationSaved=getText(driver, popup_Message);
			if (Import_Document_SavedPopup.equals(ImportDocumentationSaved)) {
				System.out.println("Matched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_pass(driver, "Matched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
						test1);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
						test, test1);
			}
			Step_End(4, "Capture Save validation", test, test1);
		}
		Step_End(3, "Save the Import Doc,", test, test1);	

		
		waitForElement(driver, importDoc_RemarksTab);
		click(driver,importDoc_RemarksTab);

		String Module_Check="Final Invoice";
		String CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
		waitForElement(driver, CheckBox_Element);
		String checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
		
		List<String>  MovementEntry_AddList=new ArrayList<String>();

		waitForElement(driver, Actual_Eta_Date);
		String ETA_Date_Import=getText(driver, Actual_Eta_Date);
		
		String ImportInvoice_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, "Import Invoice");
		waitForElement(driver, ImportInvoice_Element);
		String ImportInvoiceSelected=getAttribute(driver, ImportInvoice_Element, "class");
		
		List<String> Import_Invoice_Number_ID_Created=new ArrayList<String>();
		if(ImportInvoiceSelected.contains("active")) {
			List<Map<String, String>> importDoc_RemarksTab_Table_Data=getTableData(driver, Invoice_Remarks_Table_Header, Invoice_Remarks_Table_Row);
			Import_Invoice_Number_ID_Created = getValuesByFirstColumnAndHeader(importDoc_RemarksTab_Table_Data, "Reference Type", "Import Invoice", "Reference Value");
		}
		Step_Start(4, "Click on Import Invoice Navigation Button or open the import invoice button", test, test1);	

		moduleNavigate(driver, Module_Import_Invoice);
		Step_End(4, "Click on Import Invoice Navigation Button or open the import invoice button", test, test1);	

		if(!ImportInvoiceSelected.contains("active")&&!checkboxSelected.contains("active")) {
			
			Step_Start(5, "Save the Import Invoice.-capture the container no in import invoice ", test, test1);	

			newButton(driver);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);
			globalValueSearchWindow(driver, BL_Condition, ImportInvoice_Select_Type,BL_Num, "", "", "", "");
			waitForElement(driver, detentionCharges_Tab_IN);
			click(driver,detentionCharges_Tab_IN);
			
			waitForElement(driver, detentionCharges_Table_Columns_IN);
			List<Map<String, String>>  DetentionTable_Data_IN=getTableData(driver,detentionCharges_Table_Columns_IN,detentionCharges_Table_Rows_IN);
			
			List<String> Container_Numbers_List=getTableHeaderCellList(DetentionTable_Data_IN,"Container Number");//container values from import invoice page
			
			Step_Start(7, ".check the bill in enquiry history module -check the  movement entry code", test, test1);	

			moduleNavigate(driver, Enquiry_History_Module);
			
			waitForElement(driver, Book_Number_Option_EH);
			click(driver,Book_Number_Option_EH);
			
			waitForElement(driver, BL_Search_Input_EH);
			sendKeys(driver, BL_Search_Input_EH, Book_Number_Value_ME);
			
			waitForElement(driver, Show_Button_EH);
			click(driver,Show_Button_EH);
			
			waitForElement(driver, Tool_Bar_EH);
			click(driver,Tool_Bar_EH);
			
			waitForElement(driver, Condition_Filter_EH);
			click(driver,Condition_Filter_EH);
			
			List<String> movementLists=splitAndExpand(Movement_Entry_Final);
			
			for(String code:movementLists) {
				waitForElement(driver, Movement_Code_Filter_Input_EH);
				clear(driver,Movement_Code_Filter_Input_EH);
				sendKeys(driver, Movement_Code_Filter_Input_EH, code);
				waitForElement(driver, Movement_Code_Filter_Input_EH);
				if(!isdisplayed(driver, Table_Column_Cell_EH)) {
					MovementEntry_AddList.add(code);
				}
			}
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			Step_End(7, ".check the bill in enquiry history module -check the  movement entry code", test, test1);	

			//Movement Entry Add Code part Start
			if(MovementEntry_AddList.size()>=1) {
				
				Step_Start(8, "if movement entry code DCHF is available then open the movement entry module", test, test1);	
				moduleNavigate(driver, Movement_Entry_Module);
				Step_End(8, "if movement entry code DCHF is available then open the movement entry module", test, test1);	

				Step_Start(9, "select the single or mutilple equipment entry based on data sheet.", test, test1);	

				waitForElement(driver, Multiple_Equipment_ME);
				click(driver,Multiple_Equipment_ME);
				Step_End(9, "select the single or mutilple equipment entry based on data sheet.", test, test1);	

				Step_Start(10, "enter the activity and select the date and click show.---based on data sheet", test, test1);	

				for(String Entrycode:MovementEntry_AddList) {
					
					if(Entrycode.equals("RCVE")||Entrycode.equals("GIM")||Entrycode.equals("RCVC")) {
						continue;
					}
					
					waitForElement(driver, Actvity_Search_Input_ME);
					clear(driver,Actvity_Search_Input_ME);
					sendKeys(driver, Actvity_Search_Input_ME, Entrycode);
					String move_Code=String.format(Movement_Code_Select, Entrycode);
					waitForElement(driver, move_Code);
					jsClick(driver,move_Code);
										
					if(Entrycode.equals("SNTC")||Entrycode.equals("DCF")) {
						String addnewDate=addDaysToDate(ETA_Date_Import, SNTC_Days_Add);
						waitForElement(driver, Activity_Input_ME);
						selectDatePicker(driver, Activity_Input_ME, addnewDate);
					
					}else {
						waitForElement(driver, Activity_Input_ME);
						selectDatePicker(driver, Activity_Input_ME, ETA_Date_Import);
					}
					
					waitForElement(driver, Show_Button_ME);
					click(driver,Show_Button_ME);
					Step_Start(11, "enter the details in below tab like booking field .", test, test1);	

					waitForElement(driver, Location_Search_Btn_ME);
					click(driver,Location_Search_Btn_ME);
					
					twoColumnMultipleSearchWindow(driver, Port_Code_Header_ME, Condition_Filter, Port);

					waitForElement(driver, Terminal_Search_Btn_ME);
					click(driver,Terminal_Search_Btn_ME);
					twoColumnMultipleSearchWindow(driver, Terminal_Code_Header_ME, Condition_Filter, Terminal);

					if(IsElementEnabled(driver, bookingNo_SearchButton_ME)) {
						waitForElement(driver, bookingNo_SearchButton_ME);
						click(driver, bookingNo_SearchButton_ME);
						twoColumnMultipleSearchWindow(driver, Book_Number_Header_ME, Condition_Filter, Book_Number_Value_ME);
					}
					
					Step_End(11, "enter the details in below tab like booking field .", test, test1);	

					Step_Start(12, "paste the container no in below grid and then save system has validate -multiple movement entry saved", test, test1);	

					for(int k=0;k<Container_Numbers_List.size();k++) {
						
						Step_Start(9, "press Add button once all required field is entered", test, test1);
						
						waitForElement(driver, addButtonMulti_L);
						click(driver, addButtonMulti_L);

						Step_End(9, "press Add button once all required field is entered", test, test1);
						Step_Start(10, "Enter valid container no in Equipment no field in grid", test, test1);
						
					String equipmentNumber_Add=String.format(equipmentNumber_Grid_Textfield, k);
					String equipmentNumber_Input_Add=String.format(equipmentNumber_Grid_Input_Textfield, k);
					String equipmentNo=Container_Numbers_List.get(k);
					
					waitForDisplay(driver, equipmentNumber_Add);
					scrollUsingElement(driver, equipmentNumber_Add);
					waitForElement(driver, equipmentNumber_Add);
					click(driver, equipmentNumber_Add);

					waitForElement(driver, equipmentNumber_Input_Add);
					sendKeys(driver, equipmentNumber_Input_Add, equipmentNo);

					}
					Step_End(12, "paste the container no in below grid and then save system has validate -multiple movement entry saved", test, test1);	

					Step_Start(13, "save Charge movement entry once completed the movement entry code.", test, test1);	

					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);

					waitForDisplay(driver, errorRecordsFrame_BOOKING);
					if (isdisplayed(driver, errorRecordsFrame_BOOKING)) {
						waitForDisplay(driver, errorRecApply_L);
						if (isdisplayed(driver, errorRecApply_L)) {
							click(driver, errorRecApply_L);

						}else if (isdisplayed(driver, okButtonErrorFrame_BOOKING)) {
							waitForElement(driver, okButtonErrorFrame_BOOKING);
							click(driver, okButtonErrorFrame_BOOKING);
						}
					}
					
					if(isdisplayed(driver, popup_Message_Ok_Button)) {
						waitForElement(driver, popup_Message_Ok_Button);
						click(driver,popup_Message_Ok_Button);
					}
					
					
					waitForElement(driver, cancel_Common_btn);
					click(driver, cancel_Common_btn);
					newButton(driver);
					Step_End(13, "save Charge movement entry once completed the movement entry code.", test, test1);	

				}
				Step_End(10, "enter the activity and select the date and click show.---based on data sheet", test, test1);	

				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver,Close_Current_tab);
				
				waitForElement(driver, bl_Search_Button_IN);
				click(driver, bl_Search_Button_IN);
				globalValueSearchWindow(driver, BL_Condition, ImportInvoice_Select_Type,BL_Num, "", "", "", "");
			}
			//Movement Entry Add Code part End
			
			waitForElement(driver, import_Invoice_Issued_Button);
			click(driver,import_Invoice_Issued_Button);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Import_Invoice_Saved_Popup);
			String import_saved_act=getText(driver, popup_Message);
			System.out.println(import_saved_act);
			if(Import_Invoice_Saved_Popup.equals(import_saved_act)) {
				System.out.println("Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act);
				Extent_pass(driver, "Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			Step_End(5, "Save the Import Invoice.-capture the container no in import invoice ", test, test1);	

		}else {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BL_Condition, Invoice_Retrive_Type,Import_Invoice_Number_ID_Created.get(0), "", "", "", "");
		
			if(isdisplayed(driver,popup_Message)) {
				String popupAct=getText(driver, popup_Message);
				if(Invoice_Already_CreatedPopup.equalsIgnoreCase(popupAct)) {
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver,popup_Message_Ok_Button);
				}
			}
		}
		waitForElement(driver, Invoice_Table_Header_All);
		List<Map<String, String>> Tabledata = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		List<String> Import_Invoice_Number_IN = getValuesByHeader(Tabledata, "Inv Number");
		System.out.println("Import_Invoice_Number_IN :"+Import_Invoice_Number_IN);
		
		Step_Start(14, "open the import invoice -select the final detention invoice dropdownfield", test, test1);	

		waitForElement(driver, invoice_Mode_dropdown);
		click(driver, invoice_Mode_dropdown);
		formatLocatorClick(driver, invoice_Mode_select, Invoice_Mode_Input);

		Step_End(14, "open the import invoice -select the final detention invoice dropdownfield", test, test1);	

		newButton(driver);
		waitForElement(driver, By_BL_Number_Btn);
		click(driver, By_BL_Number_Btn);
		waitForElement(driver, bl_Search_Button_IN);
		click(driver, bl_Search_Button_IN);
		globalValueSearchWindow(driver, BL_Condition, ImportInvoice_Select_Type,BL_Num, "", "", "", "");
		
		
		if(isdisplayed(driver,popup_Message)) {
			String popupAct=getText(driver, popup_Message);
			if(Invoice_Already_CreatedPopup.equalsIgnoreCase(popupAct)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
			}
		}
		waitForElement(driver, detentionCharges_Tab_IN);
		click(driver,detentionCharges_Tab_IN);
		
		waitForElement(driver, detentionCharges_Table_Columns_IN);
		List<Map<String, String>>  DetentionTable_Data_IN=getTableData(driver,detentionCharges_Table_Columns_IN,detentionCharges_Table_Rows_IN);
		
		List<String> Container_Numbers_List=getTableHeaderCellList(DetentionTable_Data_IN,"Container Number");//container values from import invoice page
		
		if(!checkboxSelected.contains("active")) {
			if(MovementEntry_AddList.contains("RCVE")||MovementEntry_AddList.contains("GIM")||MovementEntry_AddList.contains("RCVC")) {	
				Step_Start(8, "if movement entry code DCHF is available then open the movement entry module", test, test1);	

					moduleNavigate(driver, Movement_Entry_Module);
					Step_End(8, "if movement entry code DCHF is available then open the movement entry module", test, test1);	

					Step_Start(9, "select the single or mutilple equipment entry based on data sheet.", test, test1);	

					waitForElement(driver, Multiple_Equipment_ME);
					click(driver,Multiple_Equipment_ME);
					Step_End(9, "select the single or mutilple equipment entry based on data sheet.", test, test1);	

					Step_Start(10, "enter the activity and select the date and click show.---based on data sheet", test, test1);	

					for(String Entrycode:MovementEntry_AddList) {
						waitForElement(driver, Actvity_Search_Input_ME);
						clear(driver,Actvity_Search_Input_ME);
						sendKeys(driver, Actvity_Search_Input_ME, Entrycode);
						String move_Code=String.format(Movement_Code_Select, Entrycode);
						waitForElement(driver, move_Code);
						jsClick(driver,move_Code);
						
						if(Entrycode.equals("RCVE")||Entrycode.equals("GIM")||Entrycode.equals("RCVC")) {
							String addnewDate=addDaysToDate(ETA_Date_Import, RCVE_Days_Add);
							waitForElement(driver, Activity_Input_ME);
							click(driver,Activity_Input_ME);
							selectDatePicker(driver, Activity_Input_ME, addnewDate);
							
							waitForElement(driver, Show_Button_ME);
							click(driver,Show_Button_ME);
							
							Step_Start(11, ".enter the details in below tab like booking field .", test, test1);	

							waitForElement(driver, Location_Search_Btn_ME);
							click(driver,Location_Search_Btn_ME);
							
							twoColumnMultipleSearchWindow(driver, Port_Code_Header_ME, Condition_Filter, Port);

							waitForElement(driver, Terminal_Search_Btn_ME);
							click(driver,Terminal_Search_Btn_ME);
							twoColumnMultipleSearchWindow(driver, Terminal_Code_Header_ME, Condition_Filter, Terminal);

							if(IsElementEnabled(driver, bookingNo_SearchButton_ME)) {
								waitForElement(driver, bookingNo_SearchButton_ME);
								click(driver, bookingNo_SearchButton_ME);
								waitForDisplay(driver, type_Select1);
								if(isdisplayed(driver, type_Select1)) {
									globalValueSearchWindow(driver, BL_Condition, Book_Number_Header_ME,Book_Number_Value_ME, "", "", "", "");
								}else {
									twoColumnMultipleSearchWindow(driver, Book_Number_Header_ME, Condition_Filter, Book_Number_Value_ME);
								}
							}
							Step_End(11, ".enter the details in below tab like booking field .", test, test1);	

							for(int k=0;k<Container_Numbers_List.size();k++) {
								Step_Start(12, "paste the container no in below grid and then save system has validate -multiple movement entry saved", test, test1);	
	
								waitForElement(driver, addButtonMulti_L);
								click(driver, addButtonMulti_L);
	
								String equipmentNumber_Add=String.format(equipmentNumber_Grid_Textfield, k);
								String equipmentNumber_Input_Add=String.format(equipmentNumber_Grid_Input_Textfield, k);
								String equipmentNo=Container_Numbers_List.get(k);
								
								waitForDisplay(driver, equipmentNumber_Add);
								scrollUsingElement(driver, equipmentNumber_Add);
								waitForElement(driver, equipmentNumber_Add);
								click(driver, equipmentNumber_Add);
	
								waitForElement(driver, equipmentNumber_Input_Add);
								sendKeys(driver, equipmentNumber_Input_Add, equipmentNo);
	
								Step_End(12, "paste the container no in below grid and then save system has validate -multiple movement entry saved", test, test1);	
							}
							
							Step_Start(13, "save Charge movement entry --", test, test1);	

							scrollTop(driver);
							waitForElement(driver, SaveButton_ToolBar);
							click(driver, SaveButton_ToolBar);

							waitForDisplay(driver, errorRecordsFrame_BOOKING);
							if (isdisplayed(driver, errorRecordsFrame_BOOKING)) {
								waitForDisplay(driver, errorRecApply_L);
								if (isdisplayed(driver, errorRecApply_L)) {
									click(driver, errorRecApply_L);

								}else if (isdisplayed(driver, okButtonErrorFrame_BOOKING)) {
									waitForElement(driver, okButtonErrorFrame_BOOKING);
									click(driver, okButtonErrorFrame_BOOKING);
								}
							}
							
							waitForElement(driver, popup_Message_Ok_Button);
							click(driver,popup_Message_Ok_Button);
							
							Step_End(13, "save Charge movement entry --", test, test1);	

							waitForElement(driver, cancel_Common_btn);
							click(driver, cancel_Common_btn);
							newButton(driver);
						}else {
							continue;
						}
						
					}
					Step_End(10, "enter the activity and select the date and click show.---based on data sheet", test, test1);	

					scrollTop(driver);
					waitForElement(driver, Close_Current_tab);
					click(driver,Close_Current_tab);
					
					waitForElement(driver, bl_Search_Button_IN);
					click(driver, bl_Search_Button_IN);
					globalValueSearchWindow(driver, BL_Condition, ImportInvoice_Select_Type,BL_Num, "", "", "", "");
			}
			
			
			Step_Start(15, "load the bill and isssued the invoice", test, test1);	

			waitForElement(driver, Issued_Button_Invoice);
			click(driver, Issued_Button_Invoice);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, Final_Detention_Saved_Popup);
			String Final_Detention_Saved_Popup_Act=getText(driver, popup_Message);
			System.out.println(Final_Detention_Saved_Popup_Act);
			if(Final_Detention_Saved_Popup.equals(Final_Detention_Saved_Popup_Act)) {
				System.out.println("Matched || Expected Popup : "+Final_Detention_Saved_Popup+" || Actual Popup : "+Final_Detention_Saved_Popup_Act);
				Extent_pass(driver, "Matched || Expected Popup : "+Final_Detention_Saved_Popup+" || Actual Popup : "+Final_Detention_Saved_Popup_Act, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+Final_Detention_Saved_Popup+" || Actual Popup : "+Final_Detention_Saved_Popup_Act);
				Extent_fail(driver, "Not Matched || Expected Popup : "+Final_Detention_Saved_Popup+" || Actual Popup : "+Final_Detention_Saved_Popup_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			Step_End(15, "load the bill and isssued the invoice", test, test1);	

			waitForElement(driver, Invoice_Table_Header_All);
			List<Map<String, String>> Tabledata_IN = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		
			
			List<String> Final_Invoice_Import_Invoice_Number_IN = getValuesByHeader(Tabledata_IN, "Inv Number");
			System.out.println("Final_Invoice_Import_Invoice_Number_ :"+Final_Invoice_Import_Invoice_Number_IN);
			
			Step_Start(15, ".open the import documentation retrive the bill", test, test1);	

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			Step_End(15, ".open the import documentation retrive the bill", test, test1);	
			Step_Start(16, "Click on search button in the Import Doc module,", test, test1);	

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			Step_End(16, "Click on search button in the Import Doc module,", test, test1);	

			Step_Start(17, "Load the BL no , ", test, test1);	

			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			scrollBottom(driver);
			Step_End(17, "Load the BL no , ", test, test1);	

			Step_Start(18, "Go to Remarks tab,", test, test1);	

			waitForElement(driver, importDoc_RemarksTab);
			click(driver,importDoc_RemarksTab);
			
			Step_End(18, "Go to Remarks tab,", test, test1);	

			Extent_call(test, test1, "Verify that Import Invoice and final detention invoice  Check Box Button is checked and details has shown.");
			List<Map<String, String>> importDoc_RemarksTab_Table_Data=getTableData(driver, Invoice_Remarks_Table_Header, Invoice_Remarks_Table_Row);
		
			List<String> import_Invoice_Number_ID = getValuesByFirstColumnAndHeader(importDoc_RemarksTab_Table_Data, "Reference Type", "Import Invoice", "Reference Value");
			List<String> Final_Invoice_Number = getValuesByFirstColumnAndHeader(importDoc_RemarksTab_Table_Data, "Reference Type", "Final Invoice", "Reference Value");
			
             System.out.println("import_Invoice_Number :"+import_Invoice_Number_ID);
			
            System.out.println("Final_Invoice_Number"+Final_Invoice_Number);
			
            if(Final_Invoice_Import_Invoice_Number_IN.equals(Final_Invoice_Number)) {
            	System.out.println("Matched || Import Invoice Number from ImportInvoice Tab : "+Final_Invoice_Import_Invoice_Number_IN+" ||  Import Invoice Number from Importdocumetation Remarks Tab : "+Final_Invoice_Number);
            	Extent_pass(driver, "Matched ||  Import Invoice Number from ImportInvoice Tab : "+Final_Invoice_Import_Invoice_Number_IN+" || Import Invoice Number from Importdocumetation Remarks Tab  : "+Final_Invoice_Number, test, test1);
            }else {
            	System.out.println("Not Matched ||  Import Invoice Number from ImportInvoice Tab : "+Final_Invoice_Import_Invoice_Number_IN+" || Import Invoice Number from Importdocumetation Remarks Tab  : "+Final_Invoice_Number);
            	Extent_fail(driver, "Not Matched ||  Import Invoice Number from ImportInvoice Tab : "+Final_Invoice_Import_Invoice_Number_IN+" || Import Invoice Number from Importdocumetation Remarks Tab  : "+Final_Invoice_Number, test, test1);
            }
            
            if(Import_Invoice_Number_IN.equals(import_Invoice_Number_ID)) {
            	System.out.println("Matched || Import Invoice Number from ImportInvoice Tab : "+Import_Invoice_Number_IN+" ||  Import Invoice Number from Importdocumetation Remarks Tab : "+import_Invoice_Number_ID);
            	Extent_pass(driver, "Matched ||  Import Invoice Number from ImportInvoice Tab : "+Import_Invoice_Number_IN+" || Import Invoice Number from Importdocumetation Remarks Tab  : "+import_Invoice_Number_ID, test, test1);
            }else {
            	System.out.println("Not Matched ||  Import Invoice Number from ImportInvoice Tab : "+Import_Invoice_Number_IN+" || Import Invoice Number from Importdocumetation Remarks Tab  : "+import_Invoice_Number_ID);
            	Extent_fail(driver, "Not Matched ||  Import Invoice Number from ImportInvoice Tab : "+Import_Invoice_Number_IN+" || Import Invoice Number from Importdocumetation Remarks Tab  : "+import_Invoice_Number_ID, test, test1);
            }
			Extent_call(test, test1, "Verify that Import Invoice and final detention invoice  Check Box Button is checked and details has shown.");

		}else {
			Extent_call(test, test1, "Verify that Import Invoice and final detention invoice  Check Box Button is checked and details has shown.");

			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			waitForElement(driver, remarksTab_Table_Row_IMP_DOC);
			List<Map<String, String>>  RemarksTable_Data=getTableData(driver,remarksTab_Table_Header_IMP_DOC,remarksTab_Table_Row_IMP_DOC);

			String Ref_value_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, Module_Check, "Reference Value");
			String Ref_Date_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, Module_Check, "Reference Date");

			moduleNavigate(driver, Module_Import_Invoice);
			
			waitForElement(driver, invoice_Mode_dropdown);
			click(driver, invoice_Mode_dropdown);
			formatLocatorClick(driver, invoice_Mode_select, Invoice_Mode_Input);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver,SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, Invoice_Retrive_Type, Ref_value_Import, "", "", "", "");

			waitForElement(driver, Invoice_Table_Header_All);
			List<Map<String, String>> Tabledata_IN = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		
			
			String Final_Invoice_Ref_Number_IN = getFirstRowValueByHeaderFromTableData(Tabledata_IN, "Inv Number");
			System.out.println("Final_Invoice_Ref_Number_IN :"+Final_Invoice_Ref_Number_IN);

			String Final_Invoice_Date_IN = getFirstRowValueByHeaderFromTableData(Tabledata_IN, "Inv Due Date");
			System.out.println("Final_Invoice_Date_IN :"+Final_Invoice_Date_IN);

			if(Ref_value_Import.equals(Final_Invoice_Ref_Number_IN)) {
				System.out.println("Ref No Matched  ||  Expected : "+Ref_value_Import+"   ||   Actual : "+Final_Invoice_Ref_Number_IN);
				Extent_pass(driver,"Ref No Matched ||  Expected : "+Ref_value_Import+"   ||   Actual : "+Final_Invoice_Ref_Number_IN, test,test1);
			}else {
				System.out.println("Ref No Not Matched ||  Expected : "+Ref_value_Import+"   ||   Actual : "+Final_Invoice_Ref_Number_IN);
				Extent_fail(driver,"Ref No Not Matched ||  Expected : "+Ref_value_Import+"   ||   Actual : "+Final_Invoice_Ref_Number_IN, test,test1);
			}
			
			if(CompareDateValues(Ref_Date_Import,Final_Invoice_Date_IN)) {
				System.out.println("Ref Date Matched ||  Expected : "+Ref_Date_Import+"   ||   Actual : "+Final_Invoice_Date_IN);
				Extent_pass(driver,"Ref Date Matched ||  Expected : "+Ref_Date_Import+"   ||   Actual : "+Final_Invoice_Date_IN, test,test1);
			}else {
				System.out.println("Ref Date Not Matched ||  Expected : "+Ref_Date_Import+"   ||   Actual : "+Final_Invoice_Date_IN);
				Extent_fail(driver,"Ref Date Not Matched ||  Expected : "+Ref_Date_Import+"   ||   Actual : "+Final_Invoice_Date_IN, test,test1);
			}
			
			Extent_call(test, test1, "Verify that Import Invoice and final detention invoice  Check Box Button is checked and details has shown.");

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
		}
		
	
		Extent_completed(testcase_Name, test, test1);
		
	}
}
