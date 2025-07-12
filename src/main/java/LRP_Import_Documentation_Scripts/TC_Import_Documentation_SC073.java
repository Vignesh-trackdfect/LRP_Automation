package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
public class TC_Import_Documentation_SC073  extends Keywords {
	
	public void Import_Documentation_SC073(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC073";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String Want_To_Delete_ImportDoc = Excel_data.get("Want_To_Delete_ImportDoc");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Import_Invoice_Saved_Popup = Excel_data.get("Import_Invoice_Saved_Popup");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		String Import_Document_Saved_popup = Excel_data.get("Import_Document_Saved_popup");		
		String Invoice_Reversal_Module = Excel_data.get("Invoice_Reversal_Module");		
		String Invoice_Reversal_Remarks = Excel_data.get("Invoice_Reversal_Remarks");		
		String Invoice_Reversed_popup = Excel_data.get("Invoice_Reversed_popup");		
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
//		Switch the Profile
		SwitchProfile(driver, AgencyUser);		
		
		Extent_cal(test, test1, "Import Documentation");	
		Step_Start(1, "open the import documentation and retrieve the bill using tool bar search", test, test1);

		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(isdisplayed(driver, NewButton_ToolBar) && IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForElement(driver, popup_Message_Yes_Button);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation=getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation, test,test1);
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
				twoColumnSearchWindow(driver, Pol_Header, Condition_Filter, pol_Value);

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
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);

		}
		
		
		Step_End(1, "open the import documentation and retrieve the bill using tool bar search", test, test1);
		
		Step_Start(2, "click the save button - bl has saved in import documentation.", test, test1);
		waitForDisplay(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		if(BL_Value.equalsIgnoreCase("NEW")) {
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, Import_Document_Saved_popup);
			String savedPopupAct=getText(driver, popup_Message);
			if(Import_Document_Saved_popup.equalsIgnoreCase(savedPopupAct)) {
				System.out.println("Popup Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct);
				Extent_pass_New(driver, "Popup Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct, test, test1);
			}else {
				System.out.println("Popup Not Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct);
				Extent_fail(driver, "Popup Not Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct, test, test1);
			
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		
		Step_End(2, "click the save button - bl has saved in import documentation. system has validate import documentation is saved", test, test1);
		
        waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
        
		waitForElement(driver, Import_Invoice_Chk_Box);
		String Import_invoice_perform = getAttribute(driver, Import_Invoice_Chk_Box, "class");
				
		if(!Import_invoice_perform.contains("active")&&!Import_invoice_perform.contains("Active")) {
	        Step_Start(3, "once saved the import documentation navigate to the import invoice", test, test1);

			waitForElement(driver, import_invoice_button);
			click(driver, import_invoice_button);
			Step_End(3, "once saved the import documentation navigate to the import invoice", test, test1);
			
			Step_Start(4, "open the import invoice and saved the import invoice", test, test1);
			waitForElement(driver, issued_Button_IMP_INV);
			click(driver,issued_Button_IMP_INV);
			
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Import_Invoice_Saved_Popup);
		   	String Import_updated_pop= getText(driver, popup_Message);
			
			if(Import_updated_pop.equals(Import_Invoice_Saved_Popup)) {
		   		System.out.println("Matched || Expected Popup was : " + Import_Invoice_Saved_Popup + " || Actual Popup was : " + Import_updated_pop);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + Import_Invoice_Saved_Popup + " || Actual Popup was : " + Import_updated_pop, test,
						test1);

			} else {
				System.out.println("NotMatched || Expected Popup was : " + Import_Invoice_Saved_Popup + " || Actual Popup was : " + Import_updated_pop);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + Import_Invoice_Saved_Popup + " || Actual Popup was : " + Import_updated_pop,
						test, test1);
		   	}		
			
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			Step_End(4, "open the import invoice and saved the import invoice", test, test1);
			Step_Start(5, "come to the import documentation module ", test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab); 
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			Step_End(5, "come to the import documentation module ", test, test1);

		}
		 
		Step_Start(6, "click the edit button in import documentation", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
        click(driver, Edit_Button_toolBar);
        if(isdisplayed(driver, popup_Message_Ok_Button)) {
        	waitForElement(driver, popup_Message_Ok_Button);
        	safeclick(driver, popup_Message_Ok_Button);
        }
        Step_End(6, "click the edit button in import documentation", test, test1);    
        
        Step_Start(7, "DO issue location field has disabled.", test, test1);
        
    	waitForElement(driver, Issue_location_search_IMP);
		if(isClickable(driver, Issue_location_search_IMP)) {
			System.out.println("Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is Enabled when Import Invoice is available.");
			Extent_fail(driver, "Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is Enabled when Import Invoice is available.", test, test1);
		}else {
			System.out.println("Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is not Enabled when Import Invoice is available.");
			Extent_pass_New(driver, "Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is not Enabled when Import Invoice is available.", test, test1);
		}
        Step_End(7, "DO issue location field has disabled.", test, test1);

        Step_Start(8, "once verified then close the import documentation module.", test, test1);

        scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
				
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
        Step_End(8, "once verified then close the import documentation module.", test, test1);

		if(Want_To_Delete_ImportDoc.equalsIgnoreCase("YES")) {
			

	        Step_Start(9, "open the IMPORT INVOICE module and retive the bill", test, test1);
	        Step_Start(10, "delete the import invoice .", test, test1);
	        
			moduleNavigate(driver, Invoice_Reversal_Module);
			newButton(driver);

			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);

			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, "", "", "", "");

			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);

			waitForElement(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Table_Rows);
			click(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, Invoice_Reversal_Remarks);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}

			waitForPopup(driver, popup_Message, Invoice_Reversed_popup);
			String actualReversedPopup = getText(driver, popup_Message);
			if (actualReversedPopup.equals(Invoice_Reversed_popup)) {
				Extent_pass_New(driver, "Matched || Expected Reveresed Popup : " + Invoice_Reversed_popup	+ " Actual Reveresed Popup : " + actualReversedPopup, test, test1);
				System.out.println("Matched || Expected Reveresed Popup : " + Invoice_Reversed_popup+ " Actual Reveresed Popup : " + actualReversedPopup);
				
			} else {
				System.out.println("Not Matched || Expected Reveresed Popup : " + Invoice_Reversed_popup
						+ " Actual Reveresed Popup : " + actualReversedPopup);
				Extent_fail(driver, "Not Matched || Expected Reveresed Popup : " + Invoice_Reversed_popup
						+ " Actual Reveresed Popup : " + actualReversedPopup, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);

	        Step_End(9, "open the IMPORT INVOICE module and retive the bill", test, test1);
	        Step_End(10, "delete the import invoice .", test, test1);
	        

	        Step_Start(11, "open the import documentation module and retrive the bill", test, test1);
	        Step_Start(12, "new ,search,edit and delete icon has shown in tool bar", test, test1);
	        
			moduleNavigate(driver, ImportDocumentationModule);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			Step_End(11, "open the import documentation module and retrive the bill", test, test1);
	        Step_End(12, "new ,search,edit and delete icon has shown in tool bar", test, test1);
	        
	        Step_Start(13, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
	        		+ " YES or N0 ", test, test1);
	        Step_Start(14, "click the yes and system has validate import documentation is deleted ", test, test1);
	        
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
			
			 Step_End(13, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
		        		+ " YES or N0 ", test, test1);
		        Step_End(14, "click the yes and system has validate import documentation is deleted ", test, test1);
		}
				
		Extent_completed(testcase_Name, test, test1);

	}

}
