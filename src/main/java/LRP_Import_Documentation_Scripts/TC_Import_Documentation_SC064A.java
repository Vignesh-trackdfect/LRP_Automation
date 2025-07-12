package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC064A extends Keywords{

	public void Import_Documentation_SC064A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Import_Documentation_SC064A";
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
		String IGM_Module = Excel_data.get("IGM_Module");
		String IGM_Global_Filter_Type = Excel_data.get("IGM_Global_Filter_Type");
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Filter_Header = Excel_data.get("Vessel_Filter_Header");
		String Voyage_Filter_Header = Excel_data.get("Voyage_Filter_Header");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String Terminal_Code_Header = Excel_data.get("Terminal_Code_Header");
		String Terminal_Code_Condition = Excel_data.get("Terminal_Code_Condition");
		String IGM_Saved_Popup = Excel_data.get("IGM_Saved_Popup");		
		String Remarks_Tab_Refer_Head = Excel_data.get("Remarks_Tab_Refer_Head");
		String Want_To_Delete_IGM = Excel_data.get("Want_To_Delete_IGM");
		String Want_To_Delete_Import_Document = Excel_data.get("Want_To_Delete_Import_Document");
		String IGM_Global_Filter_Type_Delete = Excel_data.get("IGM_Global_Filter_Type_Delete");
		String IGM_Delete_Remarks = Excel_data.get("IGM_Delete_Remarks");
		String IGM_Delete_warning_popup = Excel_data.get("IGM_Delete_warning_popup");
		String IGM_Delete_Success_Popup = Excel_data.get("IGM_Delete_Success_Popup");		
		
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		
		Step_Start(1, "Open Import Documentation module,", test, test1);	
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(1, "Open Import Documentation module,", test, test1);	

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

			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.trim().equals("")) {
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
			if(!pol_Value.trim().equals("")) {
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
			Step_Start(4, "Capture Save validation,", test, test1);	

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
			Step_End(4, "Capture Save validation,", test, test1);	

		}
		Step_End(3, "Save the Import Doc,", test, test1);	


		waitForElement(driver, importDoc_RemarksTab);
		click(driver,importDoc_RemarksTab);
		
		String Module_Check="IGM Field";
		String CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
		waitForElement(driver, CheckBox_Element);
		String checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
	
		String CargoType_Import=getText(driver, IMD_cargotype);
		Step_Start(5, ".open the IGM edi generation module -load the service based on the data sheeet", test, test1);	

		if(!checkboxSelected.contains("active")) {

			moduleNavigate(driver, IGM_Module);
			newButton(driver);
			
			Step_Start(6, "if local then load the service and save the igm", test, test1);	
			Step_Start(7, "if bl is transhipment then load the service and save the igm ", test, test1);	

			if(AgencyUser.equalsIgnoreCase("AEESAD")) {
				if(CargoType_Import.equalsIgnoreCase("Local")) {
					waitForElement(driver, Local_Manifiest_IGM);
					click(driver,Local_Manifiest_IGM);
				}else {
					waitForElement(driver, Transhipment_Manifiest_IGM);
					click(driver,Transhipment_Manifiest_IGM);
				}
			}
			
			waitForElement(driver, Service_Btn_IGM);
			click(driver,Service_Btn_IGM);
			twoColumnMultipleSearchWindow(driver, Service_Header, Condition_Filter, Service);

			if(!Vessel.trim().equals("")) {
				waitForElement(driver, Vessel_Btn_IGM);
				click(driver,Vessel_Btn_IGM);
				twoColumnMultipleSearchWindow(driver, Vessel_Filter_Header, Condition_Filter, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				waitForElement(driver, Voyage_Btn_IGM);
				click(driver,Voyage_Btn_IGM);
				twoColumnMultipleSearchWindow(driver, Voyage_Filter_Header, Condition_Filter, Voyage);
			}
			
			if(!Port.trim().equals("")) {
				waitForElement(driver, PortCode_Btn_IGM);
				click(driver,PortCode_Btn_IGM);
				twoColumnMultipleSearchWindow(driver, Port_Code_Header, Condition_Filter, Port);
			
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, Terminal_Btn_IGM);
				click(driver,Terminal_Btn_IGM);
				twoColumnMultipleSearchWindow(driver, Terminal_Code_Header, Terminal_Code_Condition, Terminal);
			}
			
			waitForElement(driver, Show_Button_IGM);
			click(driver,Show_Button_IGM);
			
			waitForDisplay(driver, popup_Message_Yes_Button);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver,popup_Message_Yes_Button);
			}
			
			waitForElement(driver, BL_Filter_input_IGM_grid);
			sendKeys(driver, BL_Filter_input_IGM_grid, BL_Num);
			
			String checkBox_Select=String.format(Select_BL_NumCheck_IGM, BL_Num);
			waitForDisplay(driver, checkBox_Select);
			jsClick(driver, checkBox_Select);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver,SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, IGM_Saved_Popup);
			String IGM_SuccessMsg=getText(driver, popup_Message);
			if(IGM_Saved_Popup.equals(IGM_SuccessMsg)) {
				System.out.println("Matched || Expected Popup : "+IGM_Saved_Popup+" || Actual Popup : "+IGM_SuccessMsg);
				Extent_pass(driver, "Matched || Expected Popup : "+IGM_Saved_Popup+" || Actual Popup : "+IGM_SuccessMsg, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+IGM_Saved_Popup+" || Actual Popup : "+IGM_SuccessMsg);
				Extent_fail(driver, "Not Matched || Expected Popup : "+IGM_Saved_Popup+" || Actual Popup : "+IGM_SuccessMsg, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			Step_End(6, "if local then load the service and save the igm", test, test1);	
			Step_End(7, "if bl is transhipment then load the service and save the igm ", test, test1);	

			waitForElement(driver, IGM_Ref_Input);
			String IGM_Ref_Number_Value=getAttribute(driver, IGM_Ref_Input, "value");
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
			waitForElement(driver, importDoc_RemarksTab);
			click(driver,importDoc_RemarksTab);
			
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
			
			waitForElement(driver, remarksTab_Table_Row_IMP_DOC);
			List<Map<String, String>>  RemarksTable_Data=getTableData(driver,remarksTab_Table_Header_IMP_DOC,remarksTab_Table_Row_IMP_DOC);

			String Ref_value_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, "IGM File No", "Reference Value");

			if (IGM_Ref_Number_Value.equals(Ref_value_Import)) {
				System.out.println("Matched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import);
				Extent_pass(driver, "Matched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import, test,
						test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import);
				Extent_fail(driver, "NotMatched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import,
						test, test1);
			}
			
			if(Want_To_Delete_IGM.equalsIgnoreCase("Yes")) {
				
				moduleNavigate(driver, IGM_Module);
				waitForDisplay(driver, cancel_Common_btn);
				if(IsElementEnabled(driver, cancel_Common_btn)) {
					waitForElement(driver, cancel_Common_btn);
					click(driver,cancel_Common_btn);
				}
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, BL_Condition, IGM_Global_Filter_Type_Delete, IGM_Ref_Number_Value, "", "", "", "");
				
				waitForElement(driver, BL_Filter_input_IGM_grid);
				sendKeys(driver, BL_Filter_input_IGM_grid, BL_Num);
				
				checkBox_Select=String.format(Select_BL_NumCheck_IGM, BL_Num);
				waitForDisplay(driver, checkBox_Select);
				jsClick(driver, checkBox_Select);
				
				waitForElement(driver, remarks_Txtfld);
				sendKeys(driver, remarks_Txtfld, IGM_Delete_Remarks);
				
				scrollTop(driver);
				
				waitForElement(driver, Delete_button_toolBar);
				click(driver,Delete_button_toolBar);
				
				waitForPopup(driver, popup_Message, IGM_Delete_warning_popup);
				String IGM_warningPoupAct=getText(driver, popup_Message);
				if(IGM_Delete_warning_popup.equalsIgnoreCase(IGM_warningPoupAct)) {
					System.out.println("Popup Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct);
					Extent_pass(driver, "Popup Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct, test, test1);
				}else {
					System.out.println("Popup Not Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct);
					Extent_fail(driver, "Popup Not Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct, test, test1);
				}
				
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver,popup_Message_Yes_Button);
				
				waitForPopup(driver, popup_Message, IGM_Delete_Success_Popup);
				String IGM_DeletePoupAct=getText(driver, popup_Message);
				if(IGM_Delete_Success_Popup.equalsIgnoreCase(IGM_DeletePoupAct)) {
					System.out.println("Popup Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct);
					Extent_pass(driver, "Popup Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct, test, test1);
				}else {
					System.out.println("Popup Not Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct);
					Extent_fail(driver, "Popup Not Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct, test, test1);
				}
				
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				waitForElement(driver, Close_Current_tab);
				click(driver,Close_Current_tab);
				
			}
			
			if(Want_To_Delete_Import_Document.equalsIgnoreCase("Yes")) {
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
				
				deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
			}
			
		}else {
			
			waitForElement(driver, remarksTab_Table_Row_IMP_DOC);
			List<Map<String, String>>  RemarksTable_Data=getTableData(driver,remarksTab_Table_Header_IMP_DOC,remarksTab_Table_Row_IMP_DOC);

			String Ref_value_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, "IGM File No", "Reference Value");
			moduleNavigate(driver, IGM_Module);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow1(driver, BL_Condition, IGM_Global_Filter_Type, BL_Num, "", "", "", "");
			
			waitForElement(driver, IGM_Filter_Input);
			sendKeys(driver, IGM_Filter_Input, Ref_value_Import);
			
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);		
			
			waitForElement(driver, IGM_Ref_Input);
			String IGM_Ref_Number_Value=getAttribute(driver, IGM_Ref_Input, "value");
			
			if (IGM_Ref_Number_Value.equals(Ref_value_Import)) {
				System.out.println("Matched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import);
				Extent_pass(driver, "Matched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import, test,
						test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import);
				Extent_fail(driver, "NotMatched || Expected value was : " + IGM_Ref_Number_Value + " || Actual value was : " + Ref_value_Import,
						test, test1);
			}
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			if(Want_To_Delete_IGM.equalsIgnoreCase("Yes")) {
				
				moduleNavigate(driver, IGM_Module);
				waitForDisplay(driver, cancel_Common_btn);
				if(IsElementEnabled(driver, cancel_Common_btn)) {
					waitForElement(driver, cancel_Common_btn);
					click(driver,cancel_Common_btn);
				}
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver,SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, BL_Condition, IGM_Global_Filter_Type_Delete, IGM_Ref_Number_Value, "", "", "", "");
				
				waitForElement(driver, BL_Filter_input_IGM_grid);
				sendKeys(driver, BL_Filter_input_IGM_grid, BL_Num);
				
				String checkBox_Select=String.format(Select_BL_NumCheck_IGM, BL_Num);
				waitForDisplay(driver, checkBox_Select);
				jsClick(driver, checkBox_Select);
				
				waitForElement(driver, remarks_Txtfld);
				sendKeys(driver, remarks_Txtfld, IGM_Delete_Remarks);
				
				scrollTop(driver);
				
				waitForElement(driver, Delete_button_toolBar);
				click(driver,Delete_button_toolBar);
				
				waitForPopup(driver, popup_Message, IGM_Delete_warning_popup);
				String IGM_warningPoupAct=getText(driver, popup_Message);
				if(IGM_Delete_warning_popup.equalsIgnoreCase(IGM_warningPoupAct)) {
					System.out.println("Popup Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct);
					Extent_pass(driver, "Popup Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct, test, test1);
				}else {
					System.out.println("Popup Not Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct);
					Extent_fail(driver, "Popup Not Matched || Expected : "+IGM_Delete_warning_popup+" || Actual : "+IGM_warningPoupAct, test, test1);
				}
				
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver,popup_Message_Yes_Button);
				
				waitForPopup(driver, popup_Message, IGM_Delete_Success_Popup);
				String IGM_DeletePoupAct=getText(driver, popup_Message);
				if(IGM_Delete_Success_Popup.equalsIgnoreCase(IGM_DeletePoupAct)) {
					System.out.println("Popup Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct);
					Extent_pass(driver, "Popup Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct, test, test1);
				}else {
					System.out.println("Popup Not Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct);
					Extent_fail(driver, "Popup Not Matched || Expected : "+IGM_Delete_Success_Popup+" || Actual : "+IGM_DeletePoupAct, test, test1);
				}
				
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				waitForElement(driver, Close_Current_tab);
				click(driver,Close_Current_tab);
				
			}
			
			if(Want_To_Delete_Import_Document.equalsIgnoreCase("Yes")) {
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
				
				deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
			}
			
		}
		Step_End(4, ".open the IGM edi generation module -load the service based on the data sheeet", test, test1);	
		
		Extent_completed(testcase_Name, test, test1);

	}
}
