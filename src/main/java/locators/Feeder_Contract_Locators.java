package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Feeder_Contract_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Feeder_Contract_Locators",
			"Reference_Name", Testcases.environmentName);

	public static String FC_Vendor_field = ExcelData.get("FC_Vendor_field");
	public static String FC_Vendor_Search_Button = ExcelData.get("FC_Vendor_Search_Button");
	public static String FC_AddPortPair = ExcelData.get("FC_AddPortPair");
	public static String FC_POL_Search = ExcelData.get("FC_POL_Search");
	public static String FC_POD_Search = ExcelData.get("FC_POD_Search");
	public static String FC_Load_Term = ExcelData.get("FC_Load_Term");
	public static String FC_EquipmentDropdown = ExcelData.get("FC_EquipmentDropdown");
	public static String FC_EqpStatusDropdown = ExcelData.get("FC_EqpStatusDropdown");
	public static String FC_WeightInput = ExcelData.get("FC_WeightInput");
	public static String FC_CurrencySearch = ExcelData.get("FC_CurrencySearch");
	public static String FC_NegotiatedBy_dropdown = ExcelData.get("FC_NegotiatedBy_dropdown");
	public static String FC_DurationType = ExcelData.get("FC_DurationType");
	public static String FC_PickupTerminal = ExcelData.get("FC_PickupTerminal");
	public static String FC_DropTerminal = ExcelData.get("FC_DropTerminal");
	public static String FC_DischargeTerm = ExcelData.get("FC_DischargeTerm");
	public static String FC_ServiceCode_Search = ExcelData.get("FC_ServiceCode_Search");
	public static String FC_AmountInput = ExcelData.get("FC_AmountInput");
	public static String FC_BasisDropdown = ExcelData.get("FC_BasisDropdown");
	public static String FC_TueInput = ExcelData.get("FC_TueInput");
	public static String FC_NegotiatedOn = ExcelData.get("FC_NegotiatedOn");
	public static String FC_ValidFrom = ExcelData.get("FC_ValidFrom");
	public static String FC_Add_Ok = ExcelData.get("FC_Add_Ok");
	public static String FC_Add_Cancel = ExcelData.get("FC_Add_Cancel");
	public static String FC_POL_radiobutton = ExcelData.get("FC_POL_radiobutton");
	public static String FC_POD_radiobutton = ExcelData.get("FC_POD_radiobutton");
	public static String FC_Others_radiobutton = ExcelData.get("FC_Others_radiobutton");
//
	public static String FC_PickupInput = ExcelData.get("FC_PickupInput");
	public static String FC_DropInput = ExcelData.get("FC_DropInput");
	public static String FC_Equipment_Field = ExcelData.get("FC_Equipment_Field");
	public static String FC_Load_Term_Field = ExcelData.get("FC_Load_Term_Field");
	public static String FC_ValidTo = ExcelData.get("FC_ValidTo");
	public static String FC_Grid_Payable = ExcelData.get("FC_Grid_Payable");
	public static String FC_Grid_LocationToPay = ExcelData.get("FC_Grid_LocationToPay");
	public static String FC_OtherTerminalSearch = ExcelData.get("FC_OtherTerminalSearch");
	public static String FC_Grid_Row = ExcelData.get("FC_Grid_Row");
	public static String FC_Copy_Button = ExcelData.get("FC_Copy_Button");
	public static String FC_Equipment_Value = ExcelData.get("FC_Equipment_Value");
	public static String FC_Paste_Check_Box = ExcelData.get("FC_Paste_Check_Box");
	public static String FC_Grid_Table = ExcelData.get("FC_Grid_Table");
	public static String FC_Paste_Ok_Button = ExcelData.get("FC_Paste_Ok_Button");
	public static String FC_Paste_Check_Box_Select = ExcelData.get("FC_Paste_Check_Box_Select");
	public static String FC_Edit_Rate_Button = ExcelData.get("FC_Edit_Rate_Button");
	public static String FC_savedgrid_details = ExcelData.get("FC_savedgrid_details");
	public static String FC_DG_Plus_Button = ExcelData.get("FC_DG_Plus_Button");
	public static String FC_DG_ChargeType_Gridcell = ExcelData.get("FC_DG_ChargeType_Gridcell");
	public static String FC_DG_ChargeType_Gridcell_Dropdown = ExcelData.get("FC_DG_ChargeType_Gridcell_Dropdown");
	public static String FC_DG_Currency_Gridcell = ExcelData.get("FC_DG_Currency_Gridcell");
	public static String FC_DG_Apply_Button = ExcelData.get("FC_DG_Apply_Button");
	public static String FC_DG_Row_Class_Gridcell = ExcelData.get("FC_DG_Row_Class_Gridcell");
	public static String FC_DG_Amount_Gridcell_Textfield = ExcelData.get("FC_DG_Amount_Gridcell_Textfield");
	public static String FC_DG_Amount_Gridcell = ExcelData.get("FC_DG_Amount_Gridcell");
	public static String FC_DG_remove_Button = ExcelData.get("FC_DG_remove_Button");
	public static String FC_AddDischarge = ExcelData.get("FC_AddDischarge");
	public static String FC_SurchargeTable_Header = ExcelData.get("FC_SurchargeTable_Header");
	public static String FC_SurchargeTable_value = ExcelData.get("FC_SurchargeTable_value");
	public static String FC_ChargeType_Dropdown = ExcelData.get("FC_ChargeType_Dropdown");
	public static String FC_Amount_Input = ExcelData.get("FC_Amount_Input");
	public static String FC_FormulaBuilder = ExcelData.get("FC_FormulaBuilder");
	public static String FC_SurchargeRowSelect = ExcelData.get("FC_SurchargeRowSelect");
	public static String FC_Eqp_Dropdown = ExcelData.get("FC_Eqp_Dropdown");
	public static String FC_Selected_Eqp = ExcelData.get("FC_Selected_Eqp");
	public static String FC_ApplySurcharges = ExcelData.get("FC_ApplySurcharges");

	public static String FC_All_Rows_Button = ExcelData.get("FC_All_Rows_Button");
	public static String FC_Selected_Rows_Button = ExcelData.get("FC_Selected_Rows_Button");
	public static String FC_Increase_Rate_By = ExcelData.get("FC_Increase_Rate_By");
	public static String FC_Increase_Rate_By_Amount = ExcelData.get("FC_Increase_Rate_By_Amount");
	public static String FC_Grid_Row_First = ExcelData.get("FC_Grid_Row_First");
	public static String FC_Grid_Row_Amount = ExcelData.get("FC_Grid_Row_Amount");
	public static String FC_Edit_Rates_Check_Box = ExcelData.get("FC_Edit_Rates_Check_Box");
	public static String FC_Edit_Rates_OK_Button = ExcelData.get("FC_Edit_Rates_OK_Button");

	public static String FC_Add_DG = ExcelData.get("FC_Add_DG");
	public static String FC_DG_ChargeType = ExcelData.get("FC_DG_ChargeType");
	public static String FC_DG_AmountInput = ExcelData.get("FC_DG_AmountInput");
	public static String FC_DG_Apply = ExcelData.get("FC_DG_Apply");

	//

	public static String FC_POL_Input = ExcelData.get("FC_POL_Input");
	public static String FC_POD_Input = ExcelData.get("FC_POD_Input");
	public static String FC_Feeder_Contract_Input_Page = ExcelData.get("FC_Feeder_Contract_Input_Page");
	public static String FC_Currency_Input = ExcelData.get("FC_Currency_Input");
	public static String FC_Fdr_Contract_number_field = ExcelData.get("FC_Fdr_Contract_number_field");
	public static String FC_Surcharge_Gird_Value = ExcelData.get("FC_Surcharge_Gird_Value");
	public static String Surcharge_Remove = ExcelData.get("Surcharge_Remove");
	public static String Surcharge_gird_value_FC = ExcelData.get("Surcharge_gird_value_FC");
	public static String Import_Button_FC = ExcelData.get("Import_Button_FC");
	public static String Select_excel_FC = ExcelData.get("Select_excel_FC");
	public static String Server_ok_Button = ExcelData.get("Server_ok_Button");
	public static String Excel_Gird_First_Cell = ExcelData.get("Excel_Gird_First_Cell");
	public static String FC_Remove_Surcharge_Button = ExcelData.get("FC_Remove_Surcharge_Button");

	// 1606

	public static String FC_FDR_Contract_No_Textfield = ExcelData.get("FC_FDR_Contract_No_Textfield");
	public static String FC_Document_Attach_Window = ExcelData.get("FC_Document_Attach_Window");
	public static String FC_Document_Attach_Window_Close = ExcelData.get("FC_Document_Attach_Window_Close");
	public static String FC_Document_Attachment_File_Upload = ExcelData.get("FC_Document_Attachment_File_Upload");
	public static String FC_Document_Attachment_Upload_Button = ExcelData.get("FC_Document_Attachment_Upload_Button");
	public static String FC_AG_Grid_Filter_Button = ExcelData.get("FC_AG_Grid_Filter_Button");
	public static String FC_AG_Grid_Total_Records = ExcelData.get("FC_AG_Grid_Total_Records");
	public static String AG_Grid_POL_Filter_Searchfield = ExcelData.get("AG_Grid_POL_Filter_Searchfield");
	public static String FC_AG_Grid_Cell = ExcelData.get("FC_AG_Grid_Cell");
	public static String FC_Remove_Button = ExcelData.get("FC_Remove_Button");
	public static String FC_Show_Valid_Only_Checkbox = ExcelData.get("FC_Show_Valid_Only_Checkbox");
	public static String FC_AG_Grid_Rows = ExcelData.get("FC_AG_Grid_Rows");
	public static String FC_AG_Grid_Rows_Select = ExcelData.get("FC_AG_Grid_Rows_Select");
	public static String FC_AG_Grid = ExcelData.get("FC_AG_Grid");
	public static String FC_Show_All_RadioButton = ExcelData.get("FC_Show_All_RadioButton");
	public static String Haulage_Feeder_Terms_Mater_Table = ExcelData.get("Haulage_Feeder_Terms_Mater_Table");
	public static String Feeder_Contract_Input_Details_Close_Button = ExcelData
			.get("Feeder_Contract_Input_Details_Close_Button");
	public static String FC_Contract_Term_Column_Gridcells = ExcelData.get("FC_Contract_Term_Column_Gridcells");

	public static String FC_Feeder_Contract_Input_Details = ExcelData.get("FC_Feeder_Contract_Input_Details");
	public static String FC_DischargeTerm_Input = ExcelData.get("FC_DischargeTerm_Input");
	public static String FC_ServiceCode_Input = ExcelData.get("FC_ServiceCode_Input");
	public static String FC_Firstrow = ExcelData.get("FC_Firstrow");

	public static String FC_Paste_Check_Boxes = ExcelData.get("FC_Paste_Check_Boxes");
	public static String FC_Paste_Button = ExcelData.get("FC_Paste_Button");
	public static String FC_All_Rows_Grid = ExcelData.get("FC_All_Rows_Grid");
	public static String FC_Replace_Amout_Value = ExcelData.get("FC_Replace_Amout_Value");

	public static String FC_Search_Window = ExcelData.get("FC_Search_Window");
	public static String FC_Search_Btn = ExcelData.get("FC_Search_Btn");
	public static String FCT_btnRefreshCache = ExcelData.get("FCT_btnRefreshCache");
	public static String FDR_Contract__No_Value = ExcelData.get("FDR_Contract__No_Value");
	public static String FC_Reject_Btn = ExcelData.get("FC_Reject_Btn");
	public static String FC_Username_Search_Btn = ExcelData.get("FC_Username_Search_Btn");
	public static String FC_treeActivitysub_filter_Input = ExcelData.get("FC_treeActivitysub_filter_Input");
	public static String FC_Feeder_Contract_FCT_Checkbox = ExcelData.get("FC_Feeder_Contract_FCT_Checkbox");
	public static String FC_SubGrid_data_select = ExcelData.get("FC_SubGrid_data_select");
	public static String FC_btn_PrivilegeRemove = ExcelData.get("FC_btn_PrivilegeRemove");
	public static String FC_Module_Tab = ExcelData.get("FC_Module_Tab");
	public static String FC_Approve_Btn = ExcelData.get("FC_Approve_Btn");
	public static String FC_Import_Btn = ExcelData.get("FC_Import_Btn");

	public static String FC_Confirmation_Popup = ExcelData.get("FC_Confirmation_Popup");
	public static String FC_Confirmation_Popup_Ok_Btn = ExcelData.get("FC_Confirmation_Popup_Ok_Btn");

	public static String FC_Edit_Input_Fields = ExcelData.get("FC_Edit_Input_Fields");
	public static String FC_Edit_Input_Fields_POL = ExcelData.get("FC_Edit_Input_Fields_POL");
	public static String FC_Edit_Input_Fields_POD = ExcelData.get("FC_Edit_Input_Fields_POD");
	public static String FC_Edit_Input_Fields_Service = ExcelData.get("FC_Edit_Input_Fields_Service");
	public static String FC_Edit_Input_Fields_Discharge_Terminal = ExcelData
			.get("FC_Edit_Input_Fields_Discharge_Terminal");
	public static String FC_Edit_Input_Fields_Load_Term = ExcelData.get("FC_Edit_Input_Fields_Load_Term");
	public static String FC_Edit_Input_Fields_Discharge_Term = ExcelData.get("FC_Edit_Input_Fields_Discharge_Term");
	public static String FC_Edit_Input_Fields_Currency = ExcelData.get("FC_Edit_Input_Fields_Currency");
	public static String FC_Edit_Input_Fields_Equipment = ExcelData.get("FC_Edit_Input_Fields_Equipment");
	public static String FC_Edit_Input_Fields_Eqp_Status = ExcelData.get("FC_Edit_Input_Fields_Eqp_Status");
	public static String FC_Edit_Input_Fields_Negotiated_on = ExcelData.get("FC_Edit_Input_Fields_Negotiated_on");
	public static String FC_Edit_Input_Fields_Negotiated_By = ExcelData.get("FC_Edit_Input_Fields_Negotiated_By");
	public static String FC_Edit_Input_Fields_Valid_From = ExcelData.get("FC_Edit_Input_Fields_Valid_From");
	public static String FC_Edit_Input_Fields_Valid_To = ExcelData.get("FC_Edit_Input_Fields_Valid_To");
	public static String FC_Edit_Input_Fields_Duration_Type = ExcelData.get("FC_Edit_Input_Fields_Duration_Type");
	public static String FC_Edit_Input_Fields_Default_Term = ExcelData.get("FC_Edit_Input_Fields_Default_Term");
	public static String FC_Edit_Input_Fields_lo_ter = ExcelData.get("FC_Edit_Input_Fields_lo_ter");
	public static String FC_Columan_grid_select = ExcelData.get("FC_Columan_grid_select");
	public static String FC_updated_ok_btn = ExcelData.get("FC_updated_ok_btn");
	public static String FC_Fdr_Contract_No = ExcelData.get("FC_Fdr_Contract_No");
	public static String FC_New_Location_Pair = ExcelData.get("FC_New_Location_Pair");
	public static String FC_Approve_btn = ExcelData.get("FC_Approve_btn");
	public static String FC_Reject_btn = ExcelData.get("FC_Reject_btn");

	public static String FC_Confirmation_Message_popup = ExcelData.get("FC_Confirmation_Message_popup");
	public static String FC_Confirmation_Message_okbtn = ExcelData.get("FC_Confirmation_Message_okbtn");
	
	
	public static String FC_DG_Currency_Gridcell_Dropdown = ExcelData.get("FC_DG_Currency_Gridcell_Dropdown");
	public static String FC_DG_Empty_Row = ExcelData.get("FC_DG_Empty_Row");
	public static String FC_Dgremove_aftrapply_Button = ExcelData.get("FC_Dgremove_aftrapply_Button");
	public static String FC_DG_Currency_Input = ExcelData.get("FC_DG_Currency_Input");
	public static String FC_DG_emptyclass_gridcell = ExcelData.get("FC_DG_emptyclass_gridcell");
	public static String FC_DG_class_lastrow = ExcelData.get("FC_DG_class_lastrow");
	public static String FC_DG_row_select = ExcelData.get("FC_DG_row_select");
	public static String FC_GridPOL = ExcelData.get("FC_GridPOL");
	
	public static String FC_DG_Amountvaluefield = ExcelData.get("FC_DG_Amountvaluefield");
	public static String FC_DGRowselect = ExcelData.get("FC_DGRowselect");
	
	public static String FC_excel_Master_tab = ExcelData.get("FC_excel_Master_tab");
	public static String FC_excel_DG_tab = ExcelData.get("FC_excel_DG_tab");
	public static String FC_excel_Surcharge_tab = ExcelData.get("FC_excel_Surcharge_tab");
	public static String FC_excel_Surformula_tab = ExcelData.get("FC_excel_Surformula_tab");
	public static String FC_excel_Surslab_tab = ExcelData.get("FC_excel_Surslab_tab");
	public static String FC_Duplicate_pop = ExcelData.get("FC_Duplicate_pop");
	public static String FC_SurchargeRowselect = ExcelData.get("FC_SurchargeRowselect");
	public static String FC_Duplicate_Msg = ExcelData.get("FC_Duplicate_Msg");
	public static String FC_SelectSheet = ExcelData.get("FC_SelectSheet");
	public static String FC_LoadSheet = ExcelData.get("FC_LoadSheet");
	public static String FC_ImportTabs = ExcelData.get("FC_ImportTabs");
	public static String FC_Upload = ExcelData.get("FC_Upload");
	
	

}
