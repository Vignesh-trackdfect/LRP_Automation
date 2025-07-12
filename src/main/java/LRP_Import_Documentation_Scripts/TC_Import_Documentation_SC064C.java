package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC064C extends Keywords {

	public void Import_Documentation_SC064C(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC064C";
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
		String Import_Invoice_Delete = Excel_data.get("Import_Invoice_Delete");
		String Invoice_Reverse_Module = Excel_data.get("Invoice_Reverse_Module");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Want_To_Delete_Import_Document = Excel_data.get("Want_To_Delete_Import_Document");
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
			Step_Start(4, "Capture Save validation,", test, test1);	

		}
		Step_End(3, "Save the Import Doc,", test, test1);	
		
		waitForElement(driver, importDoc_RemarksTab);
		click(driver,importDoc_RemarksTab);
		
		String Module_Check="Import Invoice";
		String CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
		waitForElement(driver, CheckBox_Element);
		String checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
		
		Step_Start(4, "Click on Import Invoice Navigation Button or open the import invoice button", test, test1);	

		waitForElement(driver, import_Invoice_Btn);
		click(driver,import_Invoice_Btn);
		
		if(!checkboxSelected.contains("active")) {
			waitForElement(driver, import_Invoice_Issued_Button);
			click(driver,import_Invoice_Issued_Button);
			
			Step_Start(6, "Save the Import Invoice.", test, test1);	

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
			Step_End(6, "Save the Import Invoice.", test, test1);	

		}
		
		Step_Start(7, "Close the Import Invoice,", test, test1);	

		waitForElement(driver, Invoice_Table_Header_All_IMP_DOC);
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All_IMP_DOC, Invoice_Table_Row_All);
		List<String> Invoice_Ref_numbers = getValuesByHeader(TabledataFull, "Inv Number");
		List<String> Invoice_Date_numbers = getValuesByHeader(TabledataFull, "Inv Date");
		
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		Step_End(7, "Close the Import Invoice,", test, test1);	
		Step_Start(8, "Click on search button in the Import Doc module,", test, test1);	

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(8, "Click on search button in the Import Doc module,", test, test1);	
		Step_Start(9, " Load the BL no , ", test, test1);	

		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		Step_End(9, " Load the BL no , ", test, test1);	

		Step_Start(10, " Go to Remarks tab, ", test, test1);	

		waitForElement(driver, importDoc_RemarksTab);
		click(driver,importDoc_RemarksTab);
		
		CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
		waitForElement(driver, CheckBox_Element);
		checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
		Step_End(10, " Go to Remarks tab, ", test, test1);	

		Extent_call(test, test1, "Verify that Import Invoice Check Box Button is CHecked.");
		if(checkboxSelected.contains("active")) {
			System.out.println("Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is selected ");
			Extent_pass(driver, "Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is selected ", test,test1);
		}else {
			System.out.println("Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is not selected ");
			Extent_fail(driver, "Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is not selected ", test,test1);
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
		Step_End(4, "Click on Import Invoice Navigation Button or open the import invoice button", test, test1);	
		Extent_call(test, test1, "Verify that Import Invoice Check Box Button is CHecked.");

		
		if(Import_Invoice_Delete.equalsIgnoreCase("Yes")) {
			
			moduleNavigate(driver, Invoice_Reverse_Module);
			scrollTop(driver);
			waitForDisplay(driver, NewButton_ToolBar);
			click(driver, NewButton_ToolBar);

			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);

			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);

			waitForElement(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, Invoice_Reversal_Remark);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, "Invoice Reversal");
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver,popup_Message_Yes_Button);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
		}
		
		if(Want_To_Delete_Import_Document.equalsIgnoreCase("Yes")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		
		Extent_completed(testcase_Name, test, test1);

	}
}
