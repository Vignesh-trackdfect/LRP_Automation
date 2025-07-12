package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Import_Documentation_SC042 extends Keywords {

	public void Import_Documentation_SC042(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
	
		String testcase_Name="TC_Import_Documentation_SC042";
	
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String volume = Excel_data.get("Volume");
		String bl_Number = Excel_data.get("bl_Number");
		String quantity = Excel_data.get("Quantity");
		String packages = Excel_data.get("Packages");
		String mark_No = Excel_data.get("Mark_No");
		String commodity_Desc = Excel_data.get("Commodity_Desc");
		String status_Check_Expected = Excel_data.get("Status_Check").trim();
		String DropdownCondition1 = Excel_data.get("DropdownCondition1");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Commodity_equip_ids = Excel_data.get("Commodity_equip_ids");
		String cargo_weights=Excel_data.get("cargo_weights");
		String delete_confirmation_popup = Excel_data.get("delete_confirmation_popup");
		String deleted_popup_expected = Excel_data.get("deleted_popup_expected").trim();
		String volume_expected_popup = Excel_data.get("volume_expected_popup");
		String weight_quantity_popup_exp = Excel_data.get("weight_quantity_popup_exp").trim();
		String condition_filter = Excel_data.get("condition_filter").trim();
		String SavedPopup_exp = Excel_data.get("SavedPopup").trim();
		String columns_to_print = Excel_data.get("columns_to_print").trim();
	
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String Package_Code_Header=Excel_data.get("Package_Code_Header");
		
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
		
		String pol_Value=Excel_data.get("pol_Value");
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, Password);
		
		Extent_cal(test, test1, "Checking the visibility of Main menu");
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
	
		moduleNavigate(driver, ImportDocumentationModule);
		Step_Start(1, "In Import Documentation Retrieve the New bill using tool bar search.", test, test1);
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, DropdownCondition1, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
				
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

				if(!portCode.trim().equals("")) {
					waitForElement(driver, grid_portcodeIMP_DOC);
					sendKeys(driver, grid_portcodeIMP_DOC , portCode);
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
					twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition_filter, pol_Value);
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
				
				twoColumnMultipleSearchWindow(driver, BL_Number_Header, condition_filter, bl_Number);	
		}
		
		waitForElement(driver, BL_status_IMP_DOC);
		String status_Check_Actual = getText(driver, BL_status_IMP_DOC);
		if(status_Check_Actual.contains(status_Check_Expected)) {
			System.out.println("Matched || Expected Status : "+status_Check_Expected+" || Actual Status : "+status_Check_Actual);
			Extent_pass_New(driver, "Matched || Expected Status : "+status_Check_Expected+" || Actual Status : "+status_Check_Actual, test, test1);
			
		}else {
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
	
		Step_End(1, "In Import Documentation Retrieve the New bill using tool bar search.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		scrollBottom(driver);
		Step_Start(2, "After retrieving the BL, edit and go to the Commodity tab", test, test1);  
		waitForElement(driver, Commodity_Tab);
		click(driver, Commodity_Tab);
		waitForElement(driver, Commodity_Table_Header);
		List<String> print_columns = splitAndExpand(columns_to_print);
		List<Map<String, String>> commodity_table_before_edit = getTableData(driver,Commodity_Table_Header , Commodity_Table_Row);
		
		String table_before_edit = TableDataForReport(driver, commodity_table_before_edit, "Table_before_edit", print_columns);
		Step_End(2, "After retrieving the BL, edit and go to the Commodity tab", test, test1);  

		List<String> equip_ids = splitAndExpand(Commodity_equip_ids);
		List<String> volume_values = splitAndExpand(volume);
		List<String> packages_values = splitAndExpand(packages);
		List<String> cargo_weight_values = splitAndExpand(cargo_weights);
		List<String> quantity_values = splitAndExpand(quantity);
		List<String> mark_No_values = splitAndExpand(mark_No);
		List<String> commodity_Desc_values = splitAndExpand(commodity_Desc);
		scrollBottom(driver);
		boolean weight_flag=false;
		boolean quantity_flag=false;
		boolean volume_flag=false;
		System.out.println("weight count : "+cargo_weight_values.size());
		for(int i=0;i<equip_ids.size();i++) {
			
			String volume_data = volume_values.get(i);
			String package_data = packages_values.get(i);
			String cargo_wt_data = cargo_weight_values.get(i);
			String quantity_data = quantity_values.get(i);
			String mark_no_data = mark_No_values.get(i);
			String commodity_Desc_data = commodity_Desc_values.get(i);

			Step_Start(3, "select and double click the container in below grid and change the cargo weight same as another container based on the data sheet.", test, test1);

			String commodity_rows=String.format(commodity_table_row_ids, equip_ids.get(i));
			waitForElement(driver, commodity_rows);
			doubleClick(driver, commodity_rows);
			
			Step_End(3, "select and double click the container in below grid and change the cargo weight same as another container based on the data sheet.", test, test1);

			Step_Start(4, "change the volume.", test, test1);

			if(!volume_data.trim().equals("")) {
				
				waitForElement(driver, comm_Volume_Txtfield);
				click(driver, comm_Volume_Txtfield);
				clearAndType(driver, comm_Volume_Txtfield, volume_data);
				volume_flag=true;
			}
			
			Step_End(4, "change the volume.", test, test1);


			Step_Start(5, "change the Package using search field.", test, test1);

			if(!package_data.trim().equals("")) {
				
				waitForElement(driver, package_Search_Icon);
				click(driver, package_Search_Icon);
				twoColumnMultipleSearchWindow(driver, Package_Code_Header, condition_filter, package_data);
			
			}
			
			Step_End(5, "change the Package using search field.", test, test1);

			//cargo weight
			if(!cargo_wt_data.trim().equals("")) {
				waitForElement(driver, cargo_wt_txtfld);
				click(driver, cargo_wt_txtfld);
				clearAndType(driver, cargo_wt_txtfld, cargo_wt_data);
				weight_flag=true;
			}
			
			//quantity
			if(!quantity_data.trim().equals("")) {
				waitForElement(driver, comm_Quantity_Txtfield);
				clearAndType(driver, comm_Quantity_Txtfield, quantity_data);
				quantity_flag=true;
			}

			Step_Start(6, "Change the MarksNo.", test, test1);

			if(!mark_no_data.trim().equals("")) {
				waitForElement(driver, marksNo_Textarea);
				clearAndType(driver, marksNo_Textarea, mark_no_data);
			}

			Step_End(6, "Change the MarksNo.", test, test1);

			Step_Start(7, "Change the Commodity Desc.", test, test1);
			if(!commodity_Desc_data.trim().equals("")) {
				waitForElement(driver, comm_Description_Textarea);
				clearAndType(driver, comm_Description_Textarea,commodity_Desc_data );
			}

			Step_End(7, "Change the Commodity Desc.", test, test1);

			Step_Start(8, "Click the edit button.", test, test1);
			waitForElement(driver, commodity_Edit_Btn);
			click(driver, commodity_Edit_Btn);
			Step_End(8, "Click the edit button.", test, test1);
		}
		
	
		
	Step_Start(9, "Changed the Commodity details and added in Below grid", test, test1);  
	waitForElement(driver, Commodity_Table_Header);
	mouseOverToElement(driver, Commodity_Table_Header);
	List<Map<String, String>> commodity_table_after_edit = getTableData(driver,Commodity_Table_Header , Commodity_Table_Row);
	String table_after_edit = TableDataForReport(driver, commodity_table_after_edit, "Table_after_edit", print_columns);
	System.out.println("table after editing : "+table_after_edit);

	Step_End(9, "Changed the Commodity details and added in Below grid", test, test1);  

	Step_Start(10, "Save the import documentation", test, test1);  
	scrollTop(driver);
	waitForElement(driver, SaveButton_ToolBar);
	jsClick(driver, SaveButton_ToolBar);
	
	Step_End(10, "Save the import documentation", test, test1);  

	Step_Start(11, "Once saved the import documentation system has validate import documentation is updated", test, test1);  
	if(weight_flag || quantity_flag && volume_flag) {
		
		waitForPopup(driver, mismatch_pop_IMP_DOC,weight_quantity_popup_exp);
		String actual_mismatch_popup = getText(driver, mismatch_pop_IMP_DOC);
		
		if(weight_quantity_popup_exp.equals(actual_mismatch_popup)) {
			System.out.println("Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup);
			Extent_pass_New(driver, "Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup, test, test1);
			click(driver, mismatch_pop_yes_IMP_DOC);
		
		}else {
			System.out.println("Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup);
			Extent_fail(driver, "Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup, test, test1);
		}
		
		waitForPopup(driver, popup_Message, volume_expected_popup);
		String actual_volume_msg = getText(driver, popup_Message);
		
		if(volume_expected_popup.equals(actual_volume_msg)) {
			System.out.println("Expected popup : "+volume_expected_popup+" || Actual popup : "+actual_volume_msg);
			Extent_pass_New(driver, "Expected popup : "+volume_expected_popup+" || Actual  popup : "+actual_volume_msg, test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Expected popup : "+volume_expected_popup+" || Actual popup : "+actual_volume_msg);
			Extent_fail(driver, "Expected popup : "+volume_expected_popup+" || Actual popup : "+actual_volume_msg, test, test1);
		}
		
		
	}else if (weight_flag || quantity_flag && !volume_flag) {
		
		waitForPopup(driver, mismatch_pop_IMP_DOC,weight_quantity_popup_exp);
		String actual_mismatch_popup = getText(driver, mismatch_pop_IMP_DOC);
		
		if(weight_quantity_popup_exp.equals(actual_mismatch_popup)) {
			
			System.out.println("Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup);
			Extent_pass_New(driver, "Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup, test, test1);
			click(driver, mismatch_pop_yes_IMP_DOC);
		
		}else {
			
			System.out.println("Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup);
			Extent_fail(driver, "Expected popup : "+weight_quantity_popup_exp+" || Actual popup : "+actual_mismatch_popup, test, test1);
		}
		
		
	}else if(!weight_flag && !quantity_flag && volume_flag){
		
		waitForPopup(driver, popup_Message, volume_expected_popup);
		String actual_volume_msg = getText(driver, popup_Message);
		if(volume_expected_popup.equals(actual_volume_msg)) {
			System.out.println("Expected popup : "+volume_expected_popup+" || Actual popup : "+actual_volume_msg);
			Extent_pass_New(driver, "Expected popup : "+volume_expected_popup+" || Actual popup : "+actual_volume_msg, test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Expected popup : "+volume_expected_popup+" || Actual popup : "+actual_volume_msg);
			Extent_fail(driver, "Expected popup : "+volume_expected_popup+" || Actual popup : "+actual_volume_msg, test, test1);
		}
		
	}else {
		waitForPopup(driver, popup_Message, SavedPopup_exp);
		String SavedPopup_actual = getText(driver, popup_Message);
		if(SavedPopup_exp.equals(SavedPopup_actual)) {
			System.out.println("Expected popup : "+SavedPopup_exp+" || Actual popup : "+SavedPopup_actual);
			Extent_pass_New(driver, "Expected popup : "+SavedPopup_exp+" || Actual popup : "+SavedPopup_actual, test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Expected popup : "+SavedPopup_exp+" || Actual popup : "+SavedPopup_actual);
			Extent_fail(driver, "Expected popup : "+SavedPopup_exp+" || Actual popup : "+SavedPopup_actual, test, test1);
			
		}
	}
	
	waitForDisplay(driver, popup_Message_Ok_Button);
	if(isdisplayed(driver, popup_Message_Ok_Button)) {
		click(driver, popup_Message_Ok_Button);
	}
	
	Step_End(11, "Once saved the import documentation system has validate import documentation is updated", test, test1);  

	Step_Start(12, "Verify that Cargo Weight, Volume, Packages, Mark No, and Commodity Desc", test, test1);  
	Extent_pass_New(driver, " || Before : \n" + "<pre>" +table_before_edit + "</pre>"+"\n" + " || after : \n" + "<pre>" + table_after_edit+ "</pre>", test, test1);
	Step_End(12, "Verify that Cargo Weight, Volume, Packages, Mark No, and Commodity Desc", test, test1);  

	Step_Start(13, "Once saved the import documentation new, search, edit and delete icon has shown in tool bar", test, test1);  

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
	
	Step_End(13, "Once saved the import documentation new, search, edit and delete icon has shown in tool bar", test, test1);  

	Step_Start(14, "Click the delete icon and system has validate (Do you want to delete import documentation? YES or NO)", test, test1);  
	Step_Start(15, "Click the yes and system has validate import documentation is deleted", test, test1);  

	if(do_you_want_to_delete.equalsIgnoreCase("Yes")) {
		deleteImportDocument(driver, delete_confirmation_popup, deleted_popup_expected);
	}
	Step_End(14, "Click the delete icon and system has validate (Do you want to delete import documentation? YES or NO)", test, test1);  
	Step_End(15, "Click the yes and system has validate import documentation is deleted", test, test1);  

	 Extent_completed(testcase_Name, test, test1);	
	 
	}
}
