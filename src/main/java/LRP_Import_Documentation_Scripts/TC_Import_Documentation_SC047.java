package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC047 extends Keywords{
	public void Import_Documentation_SC047(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC047";
		
		navigateUrl(driver, url);
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String DropdownCondition1=Excel_data.get("DropdownCondition1");
		String bl_Number=Excel_data.get("bl_Number");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String ChargeCode_To_Edit=Excel_data.get("ChargeCode_To_Edit");
		String BaseRateUnit_datas=Excel_data.get("BaseRateUnit_datas");
		String CurrencyCode_datas=Excel_data.get("CurrencyCode_datas");
		String port_Code=Excel_data.get("port_Code");
		String BL_Status_val = Excel_data.get("BL_Status_val");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String terminalCode = Excel_data.get("terminalCode");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String charge_code_datas=Excel_data.get("charge_code_datas");
		String equipment_type_datas=Excel_data.get("equipment_type_datas");
		String BaseRate_quantity_datas=Excel_data.get("BaseRate_quantity_datas");
		String base_rate_datas=Excel_data.get("base_rate_datas");
		String pay_location_datas=Excel_data.get("pay_location_datas");
		String PayBy_datas=Excel_data.get("PayBy_datas");
		String columns_to_print=Excel_data.get("columns_to_print");
		String condition=Excel_data.get("condition");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String ChargeCode_Header=Excel_data.get("ChargeCode_Header");
		String BaseRate_Unit_Header=Excel_data.get("BaseRate_Unit_Header");
		String Currency_Code_Header=Excel_data.get("Currency_Code_Header");
		String PayLocation_Header=Excel_data.get("PayLocation_Header");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String pol_Value=Excel_data.get("pol_Value");
		String do_you_want_to_delete=Excel_data.get("do_you_want_to_delete");
		String deleted_popup_expected = Excel_data.get("deleted_popup_expected").trim();
		String delete_confirmation_popup = Excel_data.get("delete_confirmation_popup").trim();

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		//		Login

		LRP_Login(driver, username, password);
		
		verifyMainMenu(driver);
		
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

		waitForElement(driver, BL_status_IMP_DOC);
		String BL_StatusValue= getText(driver, BL_status_IMP_DOC);
	   	if(BL_StatusValue.contains(BL_Status_val)) {
	   		System.out.println("Matched || Expected value was : " + BL_Status_val + " || Actual value was : " + BL_StatusValue);
			Extent_pass_New(driver, "Matched || Expected value was : " + BL_Status_val + " || Actual value was : " + BL_StatusValue, test,
					test1);
		} else {
			
			System.out.println("Expected : Given BL should be in 'SAVED' Status || Actual : Given BL is not in 'SAVED' Mode ");
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message_Ok_Button,"Import Documentation Saved");

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
	   	}
	   	
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		jsClick(driver, Edit_Button_toolBar);
		Step_Start(2, "after retrive the bl,go to the charge tab.", test, test1);

		scrollBottom(driver);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		List<String> print_columns = splitAndExpand(columns_to_print);
		waitForElement(driver, collectChargersTab_Coloumns);
		List<Map<String, String>> collect_Chareges_Tabledata = getTableData(driver, collectChargersTab_Coloumns, collectChargersTab_Manifest_Rows);
		String before_adding = TableDataForReport(driver, collect_Chareges_Tabledata, "charges_table_before_adding_charges", print_columns);
		Step_End(2, "after retrive the bl,go to the charge tab.", test, test1);

		System.out.println(before_adding);
		List<String> charge_Code_data = splitAndExpand(charge_code_datas,",");
		List<String> ChargeCode_Edit = splitAndExpand(ChargeCode_To_Edit,",");
		List<String> BaseRateUnit_data = splitAndExpand(BaseRateUnit_datas,",");
		List<String> CurrencyCode_data = splitAndExpand(CurrencyCode_datas,",");
		List<String> equipment_type_data = splitAndExpand(equipment_type_datas,",");
		List<String> BaseRate_quantity_data = splitAndExpand(BaseRate_quantity_datas,",");
		List<String> base_rate_data = splitAndExpand(base_rate_datas,",");
		List<String> PayBy_data = splitAndExpand(PayBy_datas,",");
		List<String> pay_location_data = splitAndExpand(pay_location_datas,",");

		for(int i=0;i<ChargeCode_Edit.size();i++) {
			
			String charge_code = charge_Code_data.get(i);
			String BaseRateUnit = BaseRateUnit_data.get(i);
			String CurrencyCode = CurrencyCode_data.get(i);
			String equipment_type = equipment_type_data.get(i);
			String BaseRate_quantity = BaseRate_quantity_data.get(i);
			String base_rate = base_rate_data.get(i);
			String PayBy = PayBy_data.get(i);
			String pay_location = pay_location_data.get(i);

			String row_to_click=String.format(charge_code_cell, ChargeCode_Edit.get(i));
			Step_Start(3, "select the agency charge and doublt click in the charge tab below grid.", test, test1);
			waitForElement(driver, row_to_click);
			doubleClick(driver, row_to_click);
			
			waitForElement(driver, collectChargeTab_ChargeCode);
			if(!verifyElementHasValueAttribute(driver, collectChargeTab_ChargeCode)) {
				waitForElement(driver, row_to_click);
				doubleClick(driver, row_to_click);
			}
			Step_End(3, "select the agency charge and doublt click in the charge tab below grid.", test, test1);

			Step_Start(4, "charge code details feteched with the respective fields.", test, test1);

			//1charge code
			if(!charge_code.trim().equals("")) {
				waitForElement(driver, chargeCode_SearchButton_IMD);
				click(driver, chargeCode_SearchButton_IMD);
				
				twoColumnMultipleSearchWindow(driver, ChargeCode_Header, condition, charge_code);					
			}
			Step_End(4, "charge code details feteched with the respective fields.", test, test1);

			Step_Start(5, "change  the unit code in base rate unit field.", test, test1);

			//2.base rate unit
			if(!BaseRateUnit.trim().equals("")) {
				waitForElement(driver, baseRateUnit_SearchButton_IMD);
				click(driver, baseRateUnit_SearchButton_IMD);
				twoColumnMultipleSearchWindow(driver, BaseRate_Unit_Header, condition, BaseRateUnit);	

			}
			Step_End(5, "change  the unit code in base rate unit field.", test, test1);

			//3.currency
			Step_Start(6, "change the currrency in using currency code field.", test, test1);
			if(!CurrencyCode.trim().equals("")) {

				waitForElement(driver, currency_SearchButton_IMD);
				click(driver, currency_SearchButton_IMD);
				twoColumnMultipleSearchWindow(driver, Currency_Code_Header, condition, CurrencyCode);	
			}
			Step_End(6, "change the currrency in using currency code field.", test, test1);

			//4.equipment type
			Step_Start(7, ".select the equipment type in equipment type dropdown field.", test, test1);
			if(!equipment_type.trim().equals("")) {
				waitForElement(driver, equipment_type_drpdwn);
				click(driver, equipment_type_drpdwn);
				String equip_type_to_click=String.format(equipment_type_click, equipment_type);
				waitForElement(driver, equip_type_to_click);
				click(driver, equip_type_to_click);
			}
			Step_End(7, ".select the equipment type in equipment type dropdown field.", test, test1);

			Step_Start(8, "Enter the quantity in Base Rate Quantity field.", test, test1);
			//5.base rate quantity
			if(!BaseRate_quantity.trim().equals("")) {
				waitForElement(driver, baseRateQty);
				clearAndType(driver, baseRateQty, BaseRate_quantity);
			}
			Step_End(8, "Enter the quantity in Base Rate Quantity field.", test, test1);

			Step_Start(9, "Enter the Base Rate in Base Rate Field.", test, test1);
			//6.base rate field
			if(!base_rate.trim().equals("")) {
				waitForElement(driver, baseRate_Textfield_IMD);
				click(driver, baseRate_Textfield_IMD);
				clearAndType(driver, baseRate_Textfield_IMD, base_rate);
			}
			Step_End(9, "Enter the Base Rate in Base Rate Field.", test, test1);

			Step_Start(10, "Select the Port in Payby dropdown field.", test, test1);
			//7.pay location
			if(!pay_location.trim().equals("")) {
				waitForElement(driver, payLocation_SearchButton_IMD);
				click(driver, payLocation_SearchButton_IMD);
				twoColumnMultipleSearchWindow(driver, PayLocation_Header, condition, pay_location);	
			}
			Step_End(10, "Select the Port in Payby dropdown field.", test, test1);

			//8payby
			Step_Start(11, "select the pay location .", test, test1);
			if(!PayBy.trim().equals("")) {
				Extent_call(test, test1, "changing the payby");
				waitForElement(driver, payBy_Dropdown_IMD);
				click(driver, payBy_Dropdown_IMD);
				String pay_by_dd=String.format(pay_by_to_select, PayBy);
				waitForElement(driver, pay_by_dd);
				click(driver, pay_by_dd);				
			}			
			Step_End(11, "select the pay location .", test, test1);
			
			Step_Start(12, "click the add button .", test, test1);
			click(driver, collectChargeTab_add_Button);
			waitForElement(driver, collectChargeTab_add_Button);
			Step_End(12, "click the add button .", test, test1);
		}
		
		Step_Start(13, "Added charges shown in Below grid.", test, test1);
		waitForElement(driver, collectChargersTab_Rows);
		List<Map<String, String>> collect_Chareges_Tabledata1 = getTableData(driver, collectChargersTab_Coloumns, collectChargersTab_Manifest_Rows);
		String after_adding = TableDataForReport(driver, collect_Chareges_Tabledata1, "charges_table_after_adding_charges", print_columns);

		System.out.println(after_adding);
		Extent_pass_New(driver, before_adding, test, test1);
		Extent_pass_New(driver, after_adding, test, test1);
		Step_End(13, "Added charges shown in Below grid.", test, test1);

		Step_Start(14, "Save the Import Documentation.and system says Import Documentation updated.", test, test1);
		scrollTop(driver);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, updatedPopup);
		String saved_popup_actual = getText(driver, popup_Message);
		if(updatedPopup.equals(saved_popup_actual)) {
			System.out.println("Matched || Expected saved popup :"+updatedPopup+"|| actual saved popup "+saved_popup_actual);
			Extent_pass_New(driver, "Matched || Expected saved popup :"+updatedPopup+"|| actual saved popup "+saved_popup_actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected saved popup :"+updatedPopup+"|| actual saved popup "+saved_popup_actual);
			Extent_fail(driver, "Not Matched || Expected saved popup :"+updatedPopup+"|| actual saved popup "+saved_popup_actual, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(14, "Save the Import Documentation.and system says Import Documentation updated.", test, test1);
		
		String final_table = compareBeforeAndAfter(before_adding, after_adding);
		System.out.println(final_table);
		Extent_call(test, test1, "Once saved the import documentation  new ,search,edit and delete icon has shown in tool bar");
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

		Step_Start(15, "Click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(16, "Click the yes and system has validate import dcoumentation is deleted ", test, test1);

		if(do_you_want_to_delete.equalsIgnoreCase("yes")) {
			deleteImportDocument(driver, delete_confirmation_popup, deleted_popup_expected);
		}
		Step_End(16, "Click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(15, "Click the yes and system has validate import dcoumentation is deleted ", test, test1);

		Extent_completed(testcase_Name, test, test1);
		
	}
}
