package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC096 extends Keywords {

	public void Import_Documentation_SC096(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC096";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("Module_Search");
		String BL_Num = Excel_data.get("BL_Num");
		String AccountingConfiguration = Excel_data.get("AccountingConfiguration");
		String Attribute_value = Excel_data.get("Attribute_value");
		String Value_checkbox_perform = Excel_data.get("Value_checkbox_perform");
		String Type_Verify1 = Excel_data.get("Type_Verify1");
		String Table_name = Excel_data.get("Table_name");
		String Tables_headers = Excel_data.get("Tables_headers");
		String Type_Verify = Excel_data.get("Type_Verify");
		String System_bl_type = Excel_data.get("System_bl_type");
		String AC_ChargeCode_Values = Excel_data.get("AC_ChargeCode_Values");
		String Attribute_value_1 = Excel_data.get("Attribute_value_1");
		String Import_Documentation_delete_perform = Excel_data.get("Import_Documentation_delete_perform");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Agency_Code_Header = Excel_data.get("Agency_Code_Header");
		String AC_ChargeCode_Header = Excel_data.get("AC_ChargeCode_Header");
		String accounting_Configuration_Reset = Excel_data.get("accounting_Configuration_Reset");
		String attribute_Header = Excel_data.get("attribute_Header");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		Step_Start(1, "open the import documentation and  retrieve the bill using tool bar search", test, test1);


		Step_Start(1, ".1.Open the accounting configuration Configuration Module.", test, test1);

		 Map<String, String> newlyadded = setAccountingConfiguration(driver, AccountingConfiguration, Agency_Code_Header,attribute_Header,Condition_Filter,AgencyUser,Attribute_value,Attribute_value_1,AC_ChargeCode_Header,AC_ChargeCode_Values,Value_checkbox_perform);
		Step_Start(6, "'open the import documentation module", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(6, "'open the import documentation module", test, test1);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			Step_End(2, "Open the import documentation module click on search field and enter the BL no", test, test1);
			Step_Start(3, "Load the BL in search field ", test, test1);
			Step_End(3, "Load the BL in search field ", test, test1);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
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
			if(!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, Condition_Filter, pol_Value);
			}
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);
			click(driver, Show_BL_Button);
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);
		}
		
		Step_Start(4, "All datas has to be shown ", test, test1);
		waitForDisplay(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		if(!BL_Value.equalsIgnoreCase("NEW")) {
			System.out.println("bl was already saved");
		}else {
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, Edit_Button_toolBar);
		if(isClickable(driver, Edit_Button_toolBar)) {
			click(driver, Edit_Button_toolBar);
		}
		
		waitForElement(driver, BL_Tab_IMD);
		click(driver, BL_Tab_IMD);
		waitForElement(driver,Transport_service_l);
		Step_Start(8, "'after retrieve the part lot bl,go to the collect charge tab.", test, test1);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		waitForElement(driver, sysout_BL_Typee);
		String System_bl_act = getText(driver, sysout_BL_Typee);
		System.out.println(System_bl_act);
		if (System_bl_type.equals(System_bl_act)) {
			System.out.println(	"Matched || Expected value was : " + System_bl_type + " || Actual value was : " + System_bl_act);
			Extent_pass_New(driver,	"Matched || Expected value was : " + System_bl_type + " || Actual value was : " + System_bl_act, test,
					test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + System_bl_type + " || Actual value was : " + System_bl_act);
			Extent_fail(driver,"NotMatched || Expected value was : " + System_bl_type + " || Actual value was : " + System_bl_act,
					test, test1);
		}
		Step_End(8, "'after retrieve the part lot bl,go to the collect charge tab.", test, test1);
		Step_Start(9, "'IDO charge code only shown for part lot bl ,refer from agency local charges  module..", test, test1);
		List<Map<String, String>> collect_table = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
		List<String> type_values = getValuesByHeader(collect_table, "Type");
		List<String> coloum_headd = splitAndExpand(Tables_headers);
		String HBL_Table = TableDataForReport(driver, collect_table,Table_name,coloum_headd);
		for(String type_value :type_values) {
			if (Type_Verify.equals(type_value)||Type_Verify1.equals(type_value)) {
				System.out.println("Expected : Manifeast and Agency should be present || Actual : Manifeast and Agency are present || Expected : "+Type_Verify+" || Actual : "+type_value);
				Extent_pass_New(driver, "Expected : Manifeast and Agency should be present || Actual : Manifeast and Agency are present || Expected : "+Type_Verify+" || Actual : "+type_value, test, test1);
				Extent_pass_New(driver," Matched || Actual : n"+ "<pre>" +HBL_Table + "</pre>", test, test1);	
			}else {
				System.out.println("Expected : Manifeast and Agency should be present || Actual : Manifeast and Agency are not present || Expected : "+Type_Verify+" || Actual : "+type_value);
				Extent_fail(driver, "Expected : Manifeast and Agency should be present || Actual : Manifeast and Agency are not present || Expected : "+Type_Verify+" || Actual : "+type_value, test, test1);
			}
			Step_Start(9, "'IDO charge code only shown for part lot bl ,refer from agency local charges  module..", test, test1);
		}
		if(Import_Documentation_delete_perform.equalsIgnoreCase("YES")) {
			scrollTop(driver);
			
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);	
			
		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		reSetAccountingConfiguration(driver, accounting_Configuration_Reset, newlyadded, AccountingConfiguration, Agency_Code_Header, Condition_Filter, AgencyUser, Attribute_value, Attribute_value_1);
		Extent_completed(testcase_Name, test, test1);
	}
}
