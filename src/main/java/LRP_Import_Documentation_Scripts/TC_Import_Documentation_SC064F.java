package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC064F extends Keywords {

	public void Import_Documentation_SC064F(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC064F";
		
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

		String Enquiry_History_Module = Excel_data.get("Enquiry_History_Module");
		String Movement_Entry_Module = Excel_data.get("Movement_Entry_Module");
		String Movement_Entry_Detention = Excel_data.get("Movement_Entry_Detention");
		String SNTC_Days_Add = Excel_data.get("SNTC_Days_Add");
		String Port_Code_Header_ME = Excel_data.get("Port_Code_Header_ME");
		String Terminal_Code_Header_ME = Excel_data.get("Terminal_Code_Header_ME");
		String Book_Number_Header_ME = Excel_data.get("Book_Number_Header_ME");
		String Book_Number_Value_ME = Excel_data.get("Book_Number_Value_ME");
		String Detention_Demurage_Module = Excel_data.get("Detention_Demurage_Module");
		String Select_Extension = Excel_data.get("Select_Extension");
		String Selection_Type =Excel_data.get("Selection_Type");
		String Date_Picker =Excel_data.get("Date_Picker");
		String Radio_button =Excel_data.get("Radio_button");
		String Date =Excel_data.get("Date");
		String NumberOfDays =Excel_data.get("NumberOfDays");
		String Container_number =Excel_data.get("Container_number");
		String Detention_ContainerHeader =Excel_data.get("Detention_ContainerHeader");
		String Detention_Saved_Popup =Excel_data.get("Detention_Saved_Popup");
		String Detention_Invoice_Saved_Popup =Excel_data.get("Detention_Invoice_Saved_Popup");
		String Detention_Retreive_Type =Excel_data.get("Detention_Retreive_Type");
		String Detention_Invoice_Mode_Option =Excel_data.get("Detention_Invoice_Mode_Option");
		String Detention_Invoice_Num_Type =Excel_data.get("Detention_Invoice_Num_Type");
		String Final_Invoice_ExistPopup =Excel_data.get("Final_Invoice_ExistPopup");

		
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
			
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			
			waitForElement(driver, select_Option_2);
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

		String Module_Check="Detention Invoice";
		String CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
		waitForElement(driver, CheckBox_Element);
		String checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
		
		waitForElement(driver, Actual_Eta_Date);
		String ETA_Date_Import=getText(driver, Actual_Eta_Date);
		
		String ImportInvoice_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, "Import Invoice");
		waitForElement(driver, ImportInvoice_Element);
		String ImportInvoiceSelected=getAttribute(driver, ImportInvoice_Element, "class");
		
		if(!ImportInvoiceSelected.contains("active")&&!checkboxSelected.contains("active")) {
			Step_Start(5, " Click on Import Invoice Navigation Button or open the import invoice button", test, test1);	

			moduleNavigate(driver, Module_Import_Invoice);
			Step_End(5, " Click on Import Invoice Navigation Button or open the import invoice button", test, test1);	

			Step_Start(6, "Save the Import Invoice.-capture the container no in import invoice", test, test1);	

			newButton(driver);
			waitForElement(driver, bl_Search_Button_IN);
			click(driver, bl_Search_Button_IN);
			globalValueSearchWindow(driver, BL_Condition, ImportInvoice_Select_Type,BL_Num, "", "", "", "");
			waitForElement(driver, detentionCharges_Tab_IN);
			click(driver,detentionCharges_Tab_IN);
			
			waitForElement(driver, detentionCharges_Table_Columns_IN);
			List<Map<String, String>>  DetentionTable_Data_IN=getTableData(driver,detentionCharges_Table_Columns_IN,detentionCharges_Table_Rows_IN);
			
			List<String> Container_Numbers_List=getTableHeaderCellList(DetentionTable_Data_IN,"Container Number");//container values from import invoice page
			
			moduleNavigate(driver, Enquiry_History_Module);
			
			List<String>  MovementEntry_AddList=new ArrayList<String>();
			
			waitForElement(driver, Book_Number_Option_EH);
			click(driver,Book_Number_Option_EH);
			
			waitForElement(driver, BL_Search_Input_EH);
			sendKeys(driver, BL_Search_Input_EH, Book_Number_Value_ME);
			
			waitForElement(driver, Show_Button_EH);
			click(driver,Show_Button_EH);
			
			waitForElement(driver, MoreOption_Grid);
			click(driver,MoreOption_Grid);
			
			waitForElement(driver, FilterOption_Menu);
			click(driver,FilterOption_Menu);
			
			List<String> movementLists=splitAndExpand(Movement_Entry_Detention);
			
			for(String code:movementLists) {
				waitForElement(driver, Movement_Code_Filter_Input_EH);
				Newclear(driver,Movement_Code_Filter_Input_EH);
				sendKeys(driver, Movement_Code_Filter_Input_EH, code);
				waitForElement(driver, Movement_Code_Filter_Input_EH);
				if(!isdisplayed(driver, Table_Column_Cell_EH)) {
					MovementEntry_AddList.add(code);
				}
			}
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			
			//Movement Entry Add Code part Start
			if(MovementEntry_AddList.size()>=1) {
				
				moduleNavigate(driver, Movement_Entry_Module);

				waitForElement(driver, Multiple_Equipment_ME);
				click(driver,Multiple_Equipment_ME);
				
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
						selectDatePicker(driver, Activity_Input_ME, addnewDate);
					
					}else {
						selectDatePicker(driver, Activity_Input_ME, ETA_Date_Import);
					}
					
					waitForElement(driver, Show_Button_ME);
					click(driver,Show_Button_ME);
					
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

					for(int k=0;k<Container_Numbers_List.size();k++) {
						
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
					}
					
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
				}
				
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver,Close_Current_tab);
				waitForElement(driver, bl_Search_Button_IN);
				click(driver, bl_Search_Button_IN);
				globalValueSearchWindow(driver, BL_Condition, ImportInvoice_Select_Type,BL_Num, "", "", "", "");
				
			}
			//Movement Entry Add Code part End
			
			Step_Start(6, "Save the Import Invoice.-capture the container no in import invoice", test, test1);	

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
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(6, "Save the Import Invoice.-capture the container no in import invoice", test, test1);	

		}
		
		
		if(!checkboxSelected.contains("active")) {
			Step_Start(7, "open the detention demurrgae extension module.", test, test1);	

			moduleNavigate(driver, Detention_Demurage_Module);
			
			newButton(driver);
			Step_End(7, "open the detention demurrgae extension module.", test, test1);	
			Step_Start(8, "load the bill and click show ", test, test1);	

			waitForElement(driver, Detention_BLSearch_Detention);
			click(driver, Detention_BLSearch_Detention);

			globalValueSearchWindow(driver, BL_Condition, Detention_Retreive_Type, BL_Num, "", "", "", "");
			Step_End(8, "load the bill and click show ", test, test1);	
			
			Step_Start(9, "storage or detention button is available ---based on select (datasheet)", test, test1);	
			String SelectOption = String.format(SelectTab_Detention, Select_Extension);
			waitForElement(driver, SelectOption);
			click(driver, SelectOption);
			Step_End(9, "storage or detention button is available ---based on select (datasheet)", test, test1);	

			Step_Start(10, "once click and select detention or storage -container details has shown.", test, test1);	

			waitForElement(driver, Detention_Show_Detention);
			click(driver, Detention_Show_Detention);
			
			if(isdisplayed(driver, Popup_Message)) {
				String FinalInvoiceExistPopupAct=getText(driver, Popup_Message);
				if(Final_Invoice_ExistPopup.equalsIgnoreCase(FinalInvoiceExistPopupAct)) {
					System.out.println("Expected : After clicking Show button container details should display || Actual : popup displayed atfer clicking the show button : "+FinalInvoiceExistPopupAct);
					Extent_FailNew(driver, "Expected : After clicking Show button container details should display || Actual : popup displayed atfer clicking the show button : "+FinalInvoiceExistPopupAct, test, test1);
				}else {
					System.out.println("Expected : After clicking Show button container details should display || Actual : popup displayed atfer clicking the show button : "+FinalInvoiceExistPopupAct);
					Extent_fail(driver, "Expected : After clicking Show button container details should display || Actual : popup displayed atfer clicking the show button : "+FinalInvoiceExistPopupAct, test, test1);
				}
			}
			
			if(isdisplayed(driver, DetentionOkay_button_Detention)) {
				click(driver,DetentionOkay_button_Detention);
			}
			
			if (verifyElementHasText(driver, ContainerNo_Column_Detention)) {
				System.out.println("After click on show BL button, BL details are showing the Grid");
				Extent_pass(driver, "After click on show BL button, BL details are showing the Grid", test, test1);

			} else {
				System.out.println("After click on show BL button, BL details are not showing the Grid");
				Extent_fail(driver, "After click on show BL button, BL details are not showing the Grid", test, test1);
			}
			Step_End(10, "once click and select detention or storage -container details has shown.", test, test1);	

			Step_Start(11, "below all or select container details option is available -based on select ( datasheet)", test, test1);	

			String Select_containeroption = String.format(SelectTab_Detention, Selection_Type);
			waitForElement(driver, Select_containeroption);
			click(driver, Select_containeroption);
			
			List<String> containersList;
			
			List<Map<String, String>> DetentionTable = getTableData(driver, Detention_Table_Header_Detention, Detention_Table_Row_Detention);
			if(Selection_Type.equalsIgnoreCase("All")) {
				containersList=getTableHeaderCellList(DetentionTable,Detention_ContainerHeader);
			}else {
				containersList=splitAndExpand(Container_number);
			}
			Step_End(11, "below all or select container details option is available -based on select ( datasheet)", test, test1);	
			Step_Start(12, "date or days option is available based on select (datesheet)", test, test1);	

			if (Radio_button.equals("Date")) {
				waitForElement(driver, Date_button_Detention);
				click(driver, Date_button_Detention);

				waitForElement(driver, Calendar_field_Detention);
				if (Date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, Calendar_field_Detention, Date);
				} else {
					waitForElement(driver, Calendar_field_Detention);
					click(driver, Calendar_field_Detention);
					clear(driver, Calendar_field_Detention);
					sendKeys(driver, Calendar_field_Detention, Date);
					enter(driver);
				}

			} else if (Radio_button.equals("Days")) {
				
				waitForElement(driver, Days_Radio_Button_DD);
				click(driver,Days_Radio_Button_DD);
				
				waitForElement(driver, Days_Input_Detention);
				click(driver, Days_Input_Detention);
				sendKeys(driver, Days_Input_Detention, NumberOfDays);
			}
			Step_End(12, "date or days option is available based on select (datesheet)", test, test1);	

			Step_Start(13, "if click all-then all conainer details has changed based on date option or days option", test, test1);	

			if (Selection_Type.equals("Selected Containers")) {
				for(String container: containersList) {
					String container_selector = String.format(Select_container_Detention, container);
					waitForElement(driver, container_selector);
					click(driver, container_selector);
				}
			}
			Step_End(13, "if click all-then all conainer details has changed based on date option or days option", test, test1);	
			Step_Start(14, "once add the date or days saved the extension", test, test1);	
			waitForElement(driver, Plus_button_Detention);
			click(driver, Plus_button_Detention);
			
			if(isdisplayed(driver, detentionTab_No_Detention)) {
				click(driver,detentionTab_No_Detention);
			}
			
			waitForElement(driver, Detention_table_);
			List<Map<String, String>>  detentionTable_Data=extractTableDataByColumnWithoutScroll(driver, Detention_table_);
			
			if (Radio_button.equals("Date")) {
				
				List<String> AppliedDateValues=getValuesByFirstColumnAndHeader(detentionTable_Data,"Container No.",containersList,"Extend Validity");
				for(String dateAct:AppliedDateValues) {
					if(dateAct.equals(Date)) {
						System.out.println("Date Matched ||  Expected Value : "+Date+"   ||  Actual Value : "+dateAct);
						Extent_pass(driver, "Date Matched ||  Expected Value : "+Date+"   ||  Actual Value : "+dateAct, test, test1);
					}else {
						System.out.println("Date Not Matched ||  Expected Value : "+Date+"   ||  Actual Value : "+dateAct);
						Extent_fail(driver, "Date Not Matched ||  Expected Value : "+Date+"   ||  Actual Value : "+dateAct, test, test1);
					}
				}
				
			}else {
				
				List<String> AppliedDateValues=getValuesByFirstColumnAndHeader(detentionTable_Data,"Container No.",containersList,"Extend Validity");
				List<String> PreviousDateValues=getValuesByFirstColumnAndHeader(detentionTable_Data,"Container No.",containersList,"Prev. Validity");

				for(int l=0;l<containersList.size();l++) {
					
					String newDateAdde=addDaysToDate(PreviousDateValues.get(l), NumberOfDays);

					if(AppliedDateValues.get(l).equals(newDateAdde)) {
						System.out.println("Date Matched for "+containersList.get(l)+"||  Expected : "+newDateAdde+"   ||  Actual  : "+AppliedDateValues.get(l));
						Extent_pass(driver, "Date Matched for "+containersList.get(l)+" ||  Expected : "+newDateAdde+"   ||  Actual  : "+AppliedDateValues.get(l), test, test1);
					}else {
						System.out.println("Date Not Matched for  "+containersList.get(l)+"  ||  Expected : "+newDateAdde+"   ||  Actual  : "+AppliedDateValues.get(l));
						Extent_fail(driver, "Date Not Matched for "+ containersList.get(l)+" ||  Expected : "+newDateAdde+"   ||  Actual  : "+AppliedDateValues.get(l), test, test1);
					}
				}
			}
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			waitForDisplay(driver, Detention_Demurage_Extention_Yes);
			if(isdisplayed(driver, Detention_Demurage_Extention_Yes)) {
				click(driver, Detention_Demurage_Extention_Yes);
			}else if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			Step_Start(15, "validate shown", test, test1);	

			waitForPopup(driver, Popup_Message,Detention_Saved_Popup);
			String popup_message = getText(driver, Popup_Message);
			if (popup_message.equals(Detention_Saved_Popup)) {
				System.out.println("Expected : Detention / Storage Extension Should be saved || Actual : Detention / Storage Extension successfully saved");
				Extent_pass(driver, "Expected : Detention / Storage Extension Should be saved || Actual : Detention / Storage Extension successfully saved", test, test1);

			} else {
				System.out.println("Expected : Detention / Storage Extension Should be saved || Actual : Detention / Storage Extension not saved and the error message was " + popup_message);
				Extent_fail(driver, "Expected : Detention / Storage Extension Should be saved || Actual : Detention / Storage Extension not saved and the error message was " + popup_message,test, test1);
			}
			Step_End(15, "validate shown", test, test1);	

			Step_End(14, "once add the date or days saved the extension", test, test1);	

			Step_Start(16, "click the invoice navigation button ", test, test1);	
			waitForElement(driver, Detention_Invoice_Btn);
			click(driver,Detention_Invoice_Btn);
			Step_End(16, "click the invoice navigation button ", test, test1);	

			Step_Start(17, "directly details has shown in detention invoice ", test, test1);	
			Step_Start(18, "issued the detention invoice ", test, test1);	

			waitForElement(driver, import_Invoice_Issued_Button);
			click(driver,import_Invoice_Issued_Button);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Detention_Invoice_Saved_Popup);
			String import_saved_act=getText(driver, popup_Message);
			System.out.println(import_saved_act);
			if(Detention_Invoice_Saved_Popup.equals(import_saved_act)) {
				System.out.println("Matched || Expected Popup : "+Detention_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act);
				Extent_pass(driver, "Matched || Expected Popup : "+Detention_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+Detention_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Popup : "+Detention_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			Step_End(18, "issued the detention invoice ", test, test1);	
			Step_End(17, "directly details has shown in detention invoice ", test, test1);	

			waitForElement(driver, Invoice_Table_Header_All);
			List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
			List<String> Invoice_Ref_numbers = getValuesByHeader(TabledataFull, "Inv Number");
			List<String> Invoice_Date_numbers = getValuesByHeader(TabledataFull, "Inv Date");
			
			scrollTop(driver);
			waitForElement(driver, Module_Close);
			click(driver,Module_Close);
			
			Step_Start(18, "open the import documentation retrive the bill", test, test1);	

			scrollTop(driver);
			waitForElement(driver, Module_Close);
			click(driver,Module_Close);
			Step_End(18, "open the import documentation retrive the bill", test, test1);	

			Step_Start(19, "Click on search button in the Import Doc module,", test, test1);	

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			Step_End(19, "Click on search button in the Import Doc module,", test, test1);	

			Step_Start(20, "Load the BL no , ", test, test1);	
			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			Step_End(20, "Load the BL no , ", test, test1);	

			Step_Start(21, "Go to Remarks tab,", test, test1);	
			waitForElement(driver, Reference_Tab_IMD);
			waitForElement(driver, importDoc_RemarksTab);
			click(driver,importDoc_RemarksTab);
			Step_End(21, "Go to Remarks tab,", test, test1);	

			Extent_call(test, test1, "Verify that Import Invoice and detention invoice  Check Box Button is CHecked.and details has shown.");
			CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
			waitForElement(driver, CheckBox_Element);
			checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
			
			if(checkboxSelected.contains("active")) {
				System.out.println("Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is selected ");
				Extent_pass(driver, "Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is selected ", test,test1);
			}else {
				System.out.println("Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is not selected ");
				Extent_fail(driver, "Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is not selected ", test,test1);
			}
			
			ImportInvoice_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, "Import Invoice");
			waitForElement(driver, ImportInvoice_Element);
			ImportInvoiceSelected=getAttribute(driver, ImportInvoice_Element, "class");
			
			if(ImportInvoiceSelected.contains("active")) {
				System.out.println("Expected : Import Invoice Checkbox should be selected || Actual : Import Invoice Checkbox is selected ");
				Extent_pass(driver,"Expected : Import Invoice Checkbox should be selected || Actual : Import Invoice Checkbox is selected ", test,test1);
			}else {
				System.out.println("Expected : Import Invoice Checkbox should be selected || Actual : Import Invoice Checkbox is not selected ");
				Extent_fail(driver, "Expected : Import Invoice Checkbox should be selected || Actual : Import Invoice Checkbox is not selected ", test,test1);
			}
			
			waitForElement(driver, remarksTab_Table_Row_IMP_DOC);
			List<Map<String, String>>  RemarksTable_Data=getTableData(driver,remarksTab_Table_Header_IMP_DOC,remarksTab_Table_Row_IMP_DOC);

			List<String> columnvalues=splitAndExpand(Module_Check);
			List<String> Invoice_Ref_numbers_ImportDoc=getValuesByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, columnvalues, "Reference Value");
			List<String> Invoice_Ref_Dates_ImportDoc=getValuesByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, columnvalues, "Reference Date");

			if(CompareListvalues(Invoice_Ref_numbers_ImportDoc,Invoice_Ref_numbers)) {
				System.out.println("Invoice Ref No Matched || Expected  : "+Invoice_Ref_numbers+" || Actual  : "+Invoice_Ref_numbers_ImportDoc);
				Extent_pass(driver, "Invoice Ref No Matched || Expected  : "+Invoice_Ref_numbers+" || Actual  : "+Invoice_Ref_numbers_ImportDoc, test, test1);
			}else {
				System.out.println("Invoice Ref No Not Matched || Expected  : "+Invoice_Ref_numbers+" || Actual  : "+Invoice_Ref_numbers_ImportDoc);
				Extent_fail(driver, "Invoice Ref No Not Matched || Expected  : "+Invoice_Ref_numbers+" || Actual  : "+Invoice_Ref_numbers_ImportDoc, test, test1);
			}
			
			if(CompareListvalues(Invoice_Date_numbers,Invoice_Ref_Dates_ImportDoc)) {
				System.out.println("Invoice Ref Date Matched || Expected  : "+Invoice_Date_numbers+" || Actual  : "+Invoice_Ref_Dates_ImportDoc);
				Extent_pass(driver, "Invoice Ref Date Matched || Expected  : "+Invoice_Date_numbers+" || Actual  : "+Invoice_Ref_Dates_ImportDoc, test, test1);
			}else {
				System.out.println("Invoice Ref Date Not Matched || Expected  : "+Invoice_Date_numbers+" || Actual  : "+Invoice_Ref_Dates_ImportDoc);
				Extent_fail(driver, "Invoice Ref Date Not Matched || Expected  : "+Invoice_Date_numbers+" || Actual  : "+Invoice_Ref_Dates_ImportDoc, test, test1);
			}
			Extent_call(test, test1, "Verify that Import Invoice and detention invoice  Check Box Button is CHecked.and details has shown.");

		}else {
			Extent_call(test, test1, "Verify that Import Invoice and detention invoice  Check Box Button is CHecked.and details has shown.");

			waitForElement(driver, remarksTab_Table_Row_IMP_DOC);
			List<Map<String, String>>  RemarksTable_Data=getTableData(driver,remarksTab_Table_Header_IMP_DOC,remarksTab_Table_Row_IMP_DOC);

			String Ref_value_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, Module_Check, "Reference Value");
			String Ref_Date_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, Module_Check, "Reference Date");

			moduleNavigate(driver, Module_Import_Invoice);
			waitForElement(driver, Invoice_Mode_Input_All_IMP_DOC);
			click(driver, Invoice_Mode_Input_All_IMP_DOC);
			formatLocatorClick(driver, DropDown_Select, Detention_Invoice_Mode_Option);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver,SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, Detention_Invoice_Num_Type, Ref_value_Import, "", "", "", "");

			waitForElement(driver, Invoice_Table_Header_All_IMP_DOC);
			List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All_IMP_DOC, Invoice_Table_Row_All);
			List<String> Invoice_Ref_numbers = getValuesByHeader(TabledataFull, "Inv Number");
			List<String> Invoice_Date_numbers = getValuesByHeader(TabledataFull, "Inv Date");
			
			if(Invoice_Ref_numbers.contains(Ref_value_Import)) {
				System.out.println("Ref No Matched  ||  Expected value : "+Ref_value_Import+"   ||   Actual value : "+Invoice_Ref_numbers);
				Extent_pass(driver,"Ref No Matched ||  Expected value : "+Ref_value_Import+"   ||   Actual value : "+Invoice_Ref_numbers, test,test1);
			}else {
				System.out.println("Ref No Not Matched ||  Expected value : "+Ref_value_Import+"   ||   Actual value : "+Invoice_Ref_numbers);
				Extent_fail(driver,"Ref No Not Matched ||  Expected value : "+Ref_value_Import+"   ||   Actual value : "+Invoice_Ref_numbers, test,test1);
			}
			
			if(Invoice_Date_numbers.contains(Ref_Date_Import)) {
				System.out.println("Ref Date Matched ||  Expected value : "+Ref_Date_Import+"   ||   Actual value : "+Invoice_Date_numbers);
				Extent_pass(driver,"Ref Date Matched ||  Expected value : "+Ref_Date_Import+"   ||   Actual value : "+Invoice_Date_numbers, test,test1);
			}else {
				System.out.println("Ref Date Not Matched ||  Expected value : "+Ref_Date_Import+"   ||   Actual value : "+Invoice_Date_numbers);
				Extent_fail(driver,"Ref Date Not Matched ||  Expected value : "+Ref_Date_Import+"   ||   Actual value : "+Invoice_Date_numbers, test,test1);
			}
			
			Extent_call(test, test1, "Verify that Import Invoice and detention invoice  Check Box Button is CHecked.and details has shown.");

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
		}
		
		Extent_completed(testcase_Name, test, test1);
	
	}
	
}
