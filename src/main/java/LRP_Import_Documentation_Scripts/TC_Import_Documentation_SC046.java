package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC046  extends Keywords{
	
	public void Import_Documentation_SC046(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
	
		String testcase_Name="TC_Import_Documentation_SC046";

			String Username = Excel_data.get("Username");
			String Password = Excel_data.get("Password");
			String AgencyUser = Excel_data.get("AgencyUser");
			String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
			String bl_Number = Excel_data.get("bl_Number");
			String DropdownCondition1 = Excel_data.get("DropdownCondition1");
			String ChargeCodevalues=Excel_data.get("ChargeCodevalues");
			String baseRateUnit=Excel_data.get("BaseRateUnit");
			String BaseRateQuantity=Excel_data.get("BaseRateQuantity");
			String currencyCode=Excel_data.get("CurrencyCode");
			String baseRate=Excel_data.get("BaseRate");
			String payBy=Excel_data.get("PayBy");
			String Updated_popup_expected=Excel_data.get("Updated_popup");
			String payLocation=Excel_data.get("PayLocation");
			String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
			String first_service_data = Excel_data.get("first_service_data");
			String Vessels = Excel_data.get("Vessels");
			String Voyagenumber1 = Excel_data.get("Voyagenumber1");
			String Boundinput = Excel_data.get("Boundinput");
			String portCode = Excel_data.get("portCode");
			String terminalCode = Excel_data.get("terminalCode");
			String columns_to_print = Excel_data.get("columns_to_print");
			String deleted_popup_expected = Excel_data.get("deleted_popup_expected").trim();
			String delete_confirmation_popup = Excel_data.get("delete_confirmation_popup").trim();
			String condition = Excel_data.get("condition").trim();
			String Equipment_Value=Excel_data.get("Equipment_Value");
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
			String Status_Check = Excel_data.get("Status_Check");
			String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
			String pol_Value=Excel_data.get("pol_Value");
			String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
			String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
			
			Extent_Start(testcase_Name, test, test1);
			navigateUrl(driver, url);

			LRP_Login(driver, Username, Password);

			Extent_cal(test, test1, "Checking the visibility of Main menu");
			verifyMainMenu(driver);

			Step_Start(1, "switch to agency", test, test1);
			SwitchProfile(driver, AgencyUser);
			
			Step_End(1, "switch to agency", test, test1);
			
			moduleNavigate(driver, ImportDocumentationModule);
			
			//new steps 
			
			Step_Start(1, "Open the Import Documentation and Retrieve the saved bill using tool bar search.", test, test1);
			
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
			Step_End(1, "open the Import Documentation Retrive the new  bill using tool bar search", test, test1);

			waitForElement(driver, BL_status_IMP_DOC);
			String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
			if (house_BL_Status.contains(Status_Check)) {
				System.out.println("Expected : Given BL should be in 'SAVED' Status || Actual : Given BL is in 'SAVED' Mode ");
				Extent_pass_New(driver, "Expected : Given BL should be in 'SAVED' Status || Actual : Given BL is in 'SAVED' Mode ", test, test1);
			}else {

				System.out.println("Expected : Given BL should be in 'SAVED' Status || Actual : Given BL is not in 'SAVED' Mode ");
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				jsClick(driver, SaveButton_ToolBar);
				waitForPopup(driver, popup_Message_Ok_Button,"Import Documentation Saved");

				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				///click save then ok then click edit
			}
			
			Step_Start(2, "Click on Edit button, go to the charge tab.", test, test1);
			if(isClickable(driver,Edit_Button_toolBar)) {
				waitForElement(driver, Edit_Button_toolBar);
				jsClick(driver, Edit_Button_toolBar);
			}
			
			Step_End(2, "Click on Edit button, go to the charge tab.", test, test1);

			waitForElement(driver, Collect_Charges_Tab);
			click(driver, Collect_Charges_Tab);
			
			List<String> print_columns = splitAndExpand(columns_to_print,",");
			
			waitForElement(driver, charges_table_headers);
			List<Map<String, String>> charges_tabledata = getTableData(driver, charges_table_headers, charges_table_rows);
			
			String before_adding = TableDataForReport(driver, charges_tabledata, "charges_table_before_adding_charges", print_columns);
			
			Extent_pass_New(driver, before_adding, test, test1);

			List<String> charge_codes = splitAndExpand(ChargeCodevalues,",");
			List<String> baseRateUnit_values = splitAndExpand(baseRateUnit,",");
			List<String> currencyCode_values = splitAndExpand(currencyCode,",");
			List<String> BaseRateQuantity_values = splitAndExpand(BaseRateQuantity,",");
			List<String> payLocation_values = splitAndExpand(payLocation,",");
			List<String> baseRate_values = splitAndExpand(baseRate,",");
			List<String> payBy_values = splitAndExpand(payBy,",");
			List<String> Equipment_Values = splitAndExpand(Equipment_Value,",");

			
			for(int i=0;i<charge_codes.size();i++) {
				
				Step_Start(3, "Select the charge code using charge code search field. Same as multiple charge code has to be added based on the data sheet.", test, test1);

				if(charge_codes.get(i)!=null&&!charge_codes.get(i).trim().equals("")) {
					waitForElement(driver, chargeCode_SearchButton_IMD);
					click(driver, chargeCode_SearchButton_IMD);
					twoColumnMultipleSearchWindow(driver, ChargeCode_Header, condition, charge_codes.get(i));	

				}
				Step_End(3, "Select the charge code using charge code search field. Same as multiple charge code has to be added based on the data sheet.", test, test1);

				Step_Start(4, "Select the unit code using base rate unit field.", test, test1);
				if(baseRateUnit_values.get(i)!=null&&!baseRateUnit_values.get(i).equals(" ")) {
					waitForElement(driver, baseRateUnit_SearchButton_IMD);
					click(driver, baseRateUnit_SearchButton_IMD);
					twoColumnMultipleSearchWindow(driver, BaseRate_Unit_Header, condition, baseRateUnit_values.get(i));	
				}
				
				Step_End(4, "Select the unit code using base rate unit field.", test, test1);

				Step_Start(5, "Select the currency code using currency code field.", test, test1);

				if(currencyCode_values.get(i)!=null&&!currencyCode_values.get(i).trim().equals("")) {
					waitForElement(driver, currency_SearchButton_IMD);
					click(driver, currency_SearchButton_IMD);
					twoColumnMultipleSearchWindow(driver, Currency_Code_Header, condition, currencyCode_values.get(i));	
				}
				
				Step_End(5, "Select the currency code using currency code field.", test, test1);

				Step_Start(6, "Select the equipment type using equipment type dropdown field.", test, test1);

				if(Equipment_Values.get(i)!=null&&!Equipment_Values.get(i).trim().equals("")) {
					waitForElement(driver, equipment_type_label);
					click(driver, equipment_type_label);
					String equipment_type_option=String.format(ImportDocumentation_Locators.equipment_type_option, Equipment_Values.get(i));
					waitForElement(driver, equipment_type_option);
					click(driver, equipment_type_option);
				}
				Step_End(6, "Select the equipment type using equipment type dropdown field.", test, test1);

				Step_Start(7, "Enter the quantity in Base Rate Quantity field.", test, test1);
				
				if(BaseRateQuantity_values.get(i)!=null&&!BaseRateQuantity_values.get(i).trim().equals("")) {
					waitForElement(driver, charges_Rate_Quantity);
					click(driver, charges_Rate_Quantity);
					clearAndType(driver, charges_Rate_Quantity,BaseRateQuantity_values.get(i) );
				}
				
				Step_End(7, "Enter the quantity in Base Rate Quantity field.", test, test1);

				Step_Start(8, "Enter the Base Rate in Base Rate Field.", test, test1);

				if(baseRate_values.get(i)!=null&&!baseRate_values.get(i).trim().equals("")) {
					waitForElement(driver, baseRate_Textfield_IMD);
					click(driver, baseRate_Textfield_IMD);
					clearAndType(driver, baseRate_Textfield_IMD, baseRate_values.get(i));
				}
				
				Step_End(8, "Enter the Base Rate in Base Rate Field.", test, test1);

				Step_Start(9, "Select the Port in Payby dropdown field.", test, test1);
				
				if(payLocation_values.get(i)!=null&&!payLocation_values.get(i).trim().equals("")) {
					waitForElement(driver, payLocation_SearchButton_IMD);
					click(driver, payLocation_SearchButton_IMD);
					twoColumnMultipleSearchWindow(driver, PayLocation_Header, condition, payLocation_values.get(i));	

				}
				Step_End(9, "Select the Port in Payby dropdown field.", test, test1);

				if(payBy_values.get(i)!=null&&!payBy_values.get(i).trim().equals("")) {
					click(driver, payBy_Dropdown_IMD);
					String select_PayBy=String.format(ImportDocumentation_Locators.select_PayBy, payBy_values.get(i)); 
					waitForElement(driver, select_PayBy);
					click(driver, select_PayBy);
				}
				
				Step_Start(10, "Click the add button.", test, test1);
				waitForElement(driver, collectChargeTab_add_Button);
				click(driver, collectChargeTab_add_Button);

				Step_End(10, "Click the add button.", test, test1);
			}
			

			Step_Start(11, "Added charges shown in Below grid.", test, test1);
			waitForElement(driver, charges_table_headers);
			mouseOverToElement(driver, charges_table_headers);
			List<Map<String, String>> charges_tabledata1 = getTableData(driver, charges_table_headers, charges_table_rows);
			String after_adding = TableDataForReport(driver, charges_tabledata1, "charges_table_after_adding_charges", print_columns);
			
			Extent_pass_New(driver, after_adding, test, test1);
			Step_End(11, "Added charges shown in Below grid.", test, test1);

			Step_Start(12, "Update the Import Documentation.", test, test1);
			
			scrollTop(driver);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			Step_End(12, "Update the Import Documentation.", test, test1);
			
			Step_Start(13, "Once updated, the import documentation system has validate import documentation is updated.", test, test1);

			waitForPopup(driver, popup_Message, Updated_popup_expected);
			String saved_popup_actual = getText(driver, popup_Message);
			
			if(Updated_popup_expected.equals(saved_popup_actual)) {
				
				System.out.println("Matched || Expected saved popup :"+Updated_popup_expected+"|| actual saved popup "+saved_popup_actual);
				Extent_pass_New(driver, "Matched || Expected saved popup :"+Updated_popup_expected+"|| actual saved popup "+saved_popup_actual, test, test1);
			}else {
				
				System.out.println("Not Matched || Expected saved popup :"+Updated_popup_expected+"|| actual saved popup "+saved_popup_actual);
				Extent_fail(driver, "Not Matched || Expected saved popup :"+Updated_popup_expected+"|| actual saved popup "+saved_popup_actual, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			Step_End(13, "Once updated, the import documentation system has validate import documentation is updated.", test, test1);

			Step_Start(14, "Verify that added charges are available in the Grid.", test, test1);
			
			
			Step_End(14, "Verify that added charges are available in the Grid.", test, test1);

			Step_Start(15, "Once saved, the import documentation new, search, edit and delete icon has shown in tool bar.", test, test1);
		
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

			Step_End(15, "Once saved, the import documentation new, search, edit and delete icon has shown in tool bar.", test, test1);

			Step_Start(16, "Click the delete icon and system has validate (Do you want to delete import documentation? YES or NO).", test, test1);
			Step_Start(17, "Click the yes and system has validate import documentation is deleted.", test, test1);

			if(do_you_want_to_delete.equalsIgnoreCase("Yes")) {
				deleteImportDocument(driver, delete_confirmation_popup, deleted_popup_expected);
			}
			Step_End(16, "Click the delete icon and system has validate (Do you want to delete import documentation? YES or NO).", test, test1);
			Step_End(17, "Click the yes and system has validate import documentation is deleted.", test, test1);

			Extent_completed(testcase_Name, test, test1);

			
	}
	
}