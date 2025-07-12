package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC048 extends Keywords {

	public void Import_Documentation_SC048(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC048";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String DropdownCondition1 = Excel_data.get("DropdownCondition1");
		String BL_Status_val = Excel_data.get("BL_Status_val");
		String bl_Number = Excel_data.get("bl_Number");
		String wantToRemovePopup = Excel_data.get("WantToRemovePopup");
		String ID_Charges_Table_Headers = Excel_data.get("ID_Charges_Table_Headers");
		String updatedPopup = Excel_data.get("UpdatedPopup");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String terminalCode = Excel_data.get("terminalCode");
		String port_Code=Excel_data.get("port_Code");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String rows_to_remove_by_chargecode=Excel_data.get("rows_to_remove_by_chargecode");
		String do_you_want_to_delete=Excel_data.get("do_you_want_to_delete");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String condition=Excel_data.get("condition");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String pol_Value=Excel_data.get("pol_Value");
		String deleted_popup_expected = Excel_data.get("deleted_popup_expected").trim();
		String delete_confirmation_popup = Excel_data.get("delete_confirmation_popup").trim();

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		

		Extent_Start(testcase_Name, test, test1);
		// Login
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		SwitchProfile(driver, agencyUser);
		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(1, "Open the Import Documentation and Retrive the saved bill using tool bar search.", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, DropdownCondition1, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
		}else if (BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
				
				newButton(driver);
				
				waitForElement(driver, ServiceInput_IMD );
				sendKeys(driver, ServiceInput_IMD , first_service_data);
				
				if(!Vessels.trim().equals("")) {
					waitForElement(driver, grid_vesselcode_IMP_DOC);
					sendKeys(driver, grid_vesselcode_IMP_DOC ,Vessels);
				}
				
				if(!Voyagenumber1.trim().equals("")) {
					waitForElement(driver, grid_voyagecode_IMP_DOC);
					sendKeys(driver, grid_voyagecode_IMP_DOC , Voyagenumber1);
				}
				
				if(!Boundinput.trim().equals("")) {
					waitForElement(driver, grid_bound_IMP_DOC);
					sendKeys(driver, grid_bound_IMP_DOC, Boundinput);
				}
				
				if(!port_Code.trim().equals("")) {
					waitForElement(driver, grid_portcodeIMP_DOC);
					sendKeys(driver, grid_portcodeIMP_DOC , port_Code);
				}
				
				if(!terminalCode.trim().equals("")) {
					horizontalscroll(driver, grid_scroll, 300);		
					click(driver, grid_terminal_IMP_DOC);
					sendKeys(driver, grid_terminal_IMP_DOC , terminalCode);
				}
				
				waitForElement(driver, Select_Service_Details);
				click(driver, Select_Service_Details);
				waitForElement(driver, grid_selectbtn_IMP_DOC);
				click(driver, grid_selectbtn_IMP_DOC);
				
				scrollTop(driver);
				scrollTop(driver);
				if(!pol_Value.trim().equals("")) {
					waitForElement(driver, POLSearch);
					click(driver, POLSearch);
					twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition, pol_Value);
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
				
				twoColumnMultipleSearchWindow(driver, BL_Number_Header, condition, bl_Number);	
		}
		
		Step_End(1, "Open the Import Documentation and Retrive the saved bill using tool bar search.", test, test1);
		scrollTop(driver);
		waitForElement(driver, BL_status_IMP_DOC);
		String BL_StatusValue= getText(driver, BL_status_IMP_DOC);
	   	if(BL_StatusValue.contains(BL_Status_val)) {
	   		System.out.println("Matched || Expected value was : " + BL_Status_val + " || Actual value was : " + BL_StatusValue);
			Extent_pass_New(driver, "Matched || Expected value was : " + BL_Status_val + " || Actual value was : " + BL_StatusValue, test,
					test1);

		} else {
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message_Ok_Button,"Import Documentation Saved");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
	   	}
		
		waitForElement(driver, Edit_Button_toolBar);
		jsClick(driver, Edit_Button_toolBar);
	
		Step_Start(2, "After retrive the bl,go to the charge tab.", test, test1);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);

		mouseOverToElement(driver, collectChargersTab_Coloumns);
		waitForElement(driver, collectChargersTab_Coloumns);
		scrollBottom(driver);

		List<Map<String, String>> collect_Chareges_TabledataBefore = getTableData(driver, collectChargersTab_Coloumns,
				collectChargersTab_Manifest_Rows);
		List<String> headers_To_print = splitAndExpand(ID_Charges_Table_Headers);

		String charges_table_Before_remove = TableDataForReport(driver, collect_Chareges_TabledataBefore, "charges_table_Before_remove", headers_To_print);
		List<String> rows_to_remove = splitAndExpand(rows_to_remove_by_chargecode,",");
		//
		for(int i=0;i<rows_to_remove.size();i++) {
			
			String remove_row=String.format(charge_code_cell, rows_to_remove.get(i));
			waitForElement(driver, remove_row);
			doubleClick(driver, remove_row);
			
			waitForElement(driver, collectChargeTab_ChargeCode);
			if(!verifyElementHasValueAttribute(driver, collectChargeTab_ChargeCode)) {
				doubleClick(driver, remove_row);
			}
			
			Step_Start(4, "Click the remove button ", test, test1);
			waitForElement(driver, collectCharges_Remove_Button);
			click(driver, collectCharges_Remove_Button);

			Step_End(4, "Click the remove button ", test, test1);
			
			Step_Start(5, "system has validate Do you want to remove the row yes or no ", test, test1);
			waitForPopup(driver, popup_Message, wantToRemovePopup);
			String actualPopup = getText(driver, popup_Message);
			if (actualPopup.equals(wantToRemovePopup)) {
				System.out.println("Matched || Expected Popup :" + wantToRemovePopup + " || Actual Popup : " + actualPopup);

				Extent_pass_New(driver,"Matched || Expected Popup :" + wantToRemovePopup + " || Actual Popup : " + actualPopup,
						test, test1);

				Step_End(5, "system has validate Do you want to remove the row yes or no ", test, test1);
				Step_Start(6, "Click the yes button", test, test1);
				click(driver, popup_Message_Yes_Button);
				Step_End(6, "Click the yes button", test, test1);
			} else {
				
				System.out.println("Not Matched || Expected Popup :" + wantToRemovePopup + " || Actual Popup : " + actualPopup);

				Extent_fail(driver,	"Not Matched || Expected Popup :" + wantToRemovePopup + " || Actual Popup : " + actualPopup,
						test, test1);				
			}
		}
			
		scrollTop(driver);

		Step_Start(8, "Save the import documentation", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(8, "Save the import documentation", test, test1);
		Step_Start(9, "Once saved the import documentation system has validate import documentation is updated", test,
				test1);
		waitForPopup(driver, popup_Message, updatedPopup);
		String actualPopup = getText(driver, popup_Message);
		if (actualPopup.equals(updatedPopup)) {
			System.out.println("Matched || Expected Popup :" + updatedPopup + " || Actual Popup : " + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup :" + updatedPopup + " || Actual Popup : " + actualPopup,
					test, test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup :" + updatedPopup + " || Actual Popup : " + actualPopup);
			Extent_fail(driver,"Not Matched || Expected Popup :" + updatedPopup + " || Actual Popup : " + actualPopup, test,
					test1);
		}

		Step_End(9, "Once saved the import documentation system has validate import documentation is updated", test,
				test1);
		
		Step_Start(9, "9A. Verify that Charges been removed from collect charges Tab.", test, test1);
		scrollBottom(driver);

		waitForElement(driver, collectChargersTab_Coloumns);
		List<Map<String, String>> collect_Chareges_Tabledata2 = getTableData(driver, collectChargersTab_Coloumns,
				collectChargersTab_Manifest_Rows);
		
		List<String> ChargeCode_Values=extractDataByHeader(driver, collect_Chareges_Tabledata2, "Charge Code");
		String charges_table_after_remove = TableDataForReport(driver, collect_Chareges_Tabledata2, "charges_table_after_remove", headers_To_print);

		if(CompareListNotPresent(rows_to_remove,ChargeCode_Values)) {
			System.out.println("Expected : Removed Charge codes should not present in the Collect Chrages Tab || Actual : Removed Charge code "+rows_to_remove+" are not present in the Collect Chrages Tab");
			Extent_pass_New(driver," Before Removed : \n"+ "<pre>" +charges_table_Before_remove + "</pre>" +"|| After removed : \n"+ "<pre>" +charges_table_after_remove+ "</pre>"  , test, test1);
			Extent_pass_New(driver, "Expected : Removed Charge codes should not present in the Collect Chrages Tab || Actual : Removed Charge code "+rows_to_remove+" are not present in the Collect Chrages Tab", test, test1);
		}else {
			System.out.println("Expected : Removed Charge codes should not present in the Collect Chrages Tab || Actual : Removed Charge code "+rows_to_remove+" are present in the Collect Chrages Tab");
			Extent_pass_New(driver," Before Removed : \n"+ "<pre>" +charges_table_Before_remove + "</pre>" +"|| After removed : \n"+ "<pre>" +charges_table_after_remove+ "</pre>"  , test, test1);
			Extent_fail(driver, "Expected : Removed Charge codes should not present in the Collect Chrages Tab || Actual : Removed Charge code "+rows_to_remove+" are present in the Collect Chrages Tab", test, test1);
		
		}
		
		Step_Start(10, "Once saved the import documentation  new ,search,edit and delete icon has shown in tool bar",
				test, test1);
		scrollTop(driver);
		waitForDisplay(driver, NewButton_ToolBar);
		if(isdisplayed(driver, NewButton_ToolBar)) {
			System.out.println("Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is not displayed in the Toolbar", test, test1);
		}
		
		if(isdisplayed(driver, SearchButton_Toolbar)) {
			System.out.println("Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is not displayed in the Toolbar", test, test1);
		}
		
		if(isdisplayed(driver, Edit_Button_toolBar)) {
			System.out.println("Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is not displayed in the Toolbar", test, test1);
		}
		
	    if(isdisplayed(driver, Delete_button_toolBar)) {
	    	System.out.println("Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is not displayed in the Toolbar", test, test1);
		}

		Step_End(10, "Once saved the import documentation  new ,search,edit and delete icon has shown in tool bar",test, test1);
	
		Step_Start(11,
				"Click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)",
				test, test1);
		
		Step_Start(12, "Click the yes and system has validate import dcoumentation is deleted ", test, test1);

		if(do_you_want_to_delete.equalsIgnoreCase("yes")) {
			deleteImportDocument(driver, delete_confirmation_popup, deleted_popup_expected);
		}
		//
		Step_End(11, "Click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(12, "Click the yes and system has validate import dcoumentation is deleted ", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
