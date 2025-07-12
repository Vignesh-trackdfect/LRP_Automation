package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EMS_EDI_Configuration_Locators {
 
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EMS_EDI_Configuration", "Reference_Name", Testcases.environmentName);

	public static String EEC_GENERAL_Condition_Filter = ExcelData.get("EEC_GENERAL_Condition_Filter");
	public static String EEC_GENERAL_Condition_Filter_Partner_id = ExcelData.get("EEC_GENERAL_Condition_Filter_Partner_id");
	public static String EEC_Format_Dropdown = ExcelData.get("EEC_Format_Dropdown");
	public static String EEC_Movement_Code_Input_Field = ExcelData.get("EEC_Movement_Code_Input_Field");
	public static String EEC_Movement_Code_Search_Button = ExcelData.get("EEC_Movement_Code_Search_Button");
	public static String EEC_EDI_Code_Dropdown = ExcelData.get("EEC_EDI_Code_Dropdown");
	public static String EEC_Special_Condition_Checkbox = ExcelData.get("EEC_Special_Condition_Checkbox");
	public static String EEC_Transport_Mode_Dropdown = ExcelData.get("EEC_Transport_Mode_Dropdown");
	public static String EEC_LOC_Input_Field = ExcelData.get("EEC_LOC_Input_Field");
	public static String EEC_RFF_Input_Field = ExcelData.get("EEC_RFF_Input_Field");
	public static String EEC_Previous_Move_Input_Field = ExcelData.get("EEC_Previous_Move_Input_Field");
	public static String EEC_Previous_Move_Search_Field = ExcelData.get("EEC_Previous_Move_Search_Field");
	public static String EEC_Status_Activity_Dropdown = ExcelData.get("EEC_Status_Activity_Dropdown");
	public static String EEC_Add_button = ExcelData.get("EEC_Add_button");
	public static String EEC_Remove_button = ExcelData.get("EEC_Remove_button");
	public static String EEC_Apply_To_EDI_Button = ExcelData.get("EEC_Apply_To_EDI_Button");
	public static String EEC_Save_Button = ExcelData.get("EEC_Save_Button");
	public static String EEC_Select_Id_Apply_Button = ExcelData.get("EEC_Select_Id_Apply_Button");
	public static String EEC_By_EDI_Total_Records = ExcelData.get("EEC_By_EDI_Total_Records");
	public static String EEC_GENERAL_Condition_Filter_Port_code = ExcelData.get("EEC_GENERAL_Condition_Filter_Port_code");
	public static String EEC_GENERAL_Condition_Filter_EDI_ID_Input_Field = ExcelData.get("EEC_GENERAL_Condition_Filter_EDI_ID_Input_Field");
	public static String EEC_EDI_ID_Table = ExcelData.get("EEC_EDI_ID_Table");
	public static String EEC_Tab_Option = ExcelData.get("EEC_Tab_Option");
	public static String EEC_Partner_Id_Input_Field = ExcelData.get("EEC_Partner_Id_Input_Field");
	public static String EEC_Partner_Id_Search_Button = ExcelData.get("EEC_Partner_Id_Search_Button");
	public static String EEC_EDI_Id_Search_Button = ExcelData.get("EEC_EDI_Id_Search_Button");
	public static String EEC_EDI_Id_Input_Field = ExcelData.get("EEC_EDI_Id_Input_Field");
	public static String EEC_Show_Button = ExcelData.get("EEC_Show_Button");
	public static String EEC_Show_All_Button = ExcelData.get("EEC_Show_All_Button");
	public static String EEC_By_EDI_Add_Button = ExcelData.get("EEC_By_EDI_Add_Button");
	public static String EEC_By_EDI_Remove_Button = ExcelData.get("EEC_By_EDI_Remove_Button");
	public static String EEC_GENERAL_Partner_Id_Input_Field = ExcelData.get("EEC_GENERAL_Partner_Id_Input_Field");
	public static String EEC_GENERAL_Partner_Id_Search_Button = ExcelData.get("EEC_GENERAL_Partner_Id_Search_Button");
	public static String EEC_GENERAL_EDI_Id_Input_Field = ExcelData.get("EEC_GENERAL_EDI_Id_Input_Field");
	public static String EEC_GENERAL_EDI_Id__Search_Button = ExcelData.get("EEC_GENERAL_EDI_Id__Search_Button");
	public static String EEC_GENERAL_Port_Code_Input_Filed = ExcelData.get("EEC_GENERAL_Port_Code_Input_Filed");
	public static String EEC_GENERAL_Port_Code_Search_Button = ExcelData.get("EEC_GENERAL_Port_Code_Search_Button");
	public static String EEC_GENERAL_Vessel_Mapping_Input_Field = ExcelData.get("EEC_GENERAL_Vessel_Mapping_Input_Field");
	public static String EEC_GENERAL_Damage_Check_Box = ExcelData.get("EEC_GENERAL_Damage_Check_Box");
	public static String EEC_GENERAL_VGP_Update_Check_Box = ExcelData.get("EEC_GENERAL_VGP_Update_Check_Box");
	public static String EEC_GENERAL_OPS_Auto_Confirm = ExcelData.get("EEC_GENERAL_OPS_Auto_Confirm");
	public static String EEC_General_Button = ExcelData.get("EEC_General_Button");
	public static String EEC_GENERAL_Ag_Grid_Table = ExcelData.get("EEC_GENERAL_Ag_Grid_Table");
	public static String EEC_Status_Event_Partner_Id_Input_Field = ExcelData.get("EEC_Status_Event_Partner_Id_Input_Field");
	public static String EEC_Status_Event_Partner_Id_Search_Button = ExcelData.get("EEC_Status_Event_Partner_Id_Search_Button");
	public static String EEC_Status_Event_Movement_Code_Input_Field = ExcelData.get("EEC_Status_Event_Movement_Code_Input_Field");
	public static String EEC_Status_Event_Movement_Code_Search_Button = ExcelData.get("EEC_Status_Event_Movement_Code_Search_Button");
	public static String EEC_Status_Event_EDI_Id_Input_Field = ExcelData.get("EEC_Status_Event_EDI_Id_Input_Field");
	public static String EEC_Status_Event_EDI_Id_Search_Field = ExcelData.get("EEC_Status_Event_EDI_Id_Search_Field");
	public static String EEC_Status_Event_Add_Button = ExcelData.get("EEC_Status_Event_Add_Button");
	public static String EEC_Status_Event_Remove_Button = ExcelData.get("EEC_Status_Event_Remove_Button");
	public static String EEC_Status_Event_Status_Dropdown = ExcelData.get("EEC_Status_Event_Status_Dropdown");
	public static String EEC_SelectFormat_Option = ExcelData.get("EEC_SelectFormat_Option");
	public static String EEC_SelectEDI_Option = ExcelData.get("EEC_SelectEDI_Option");
	public static String EEC_EQD_Segment = ExcelData.get("EEC_EQD_Segment");
	public static String EEC_SelectEQD_Option = ExcelData.get("EEC_SelectEQD_Option");
	public static String EEC_SelectTransport_Option = ExcelData.get("EEC_SelectTransport_Option");
	public static String EEC_SpecialCondition_Checkbox = ExcelData.get("EEC_SpecialCondition_Checkbox");
	public static String EEC_SelectStatus_Option = ExcelData.get("EEC_SelectStatus_Option");
	public static String EEC_ByFormat_Filter = ExcelData.get("EEC_ByFormat_Filter");
	public static String EEC_MovementCode_FilterInput = ExcelData.get("EEC_MovementCode_FilterInput");
	public static String EEC_EDICode_FilterInput = ExcelData.get("EEC_EDICode_FilterInput");
	public static String EEC_TSP_FilterInput = ExcelData.get("EEC_TSP_FilterInput");
	public static String EEC_Status_FilterInput = ExcelData.get("EEC_Status_FilterInput");
	public static String EEC_MovementCodeValue1 = ExcelData.get("EEC_MovementCodeValue1");
	public static String EEC_MovementSelect = ExcelData.get("EEC_MovementSelect");
	public static String BY_EDI_Total_redords = ExcelData.get("BY_EDI_Total_redords");
	public static String BY_EDI_General_Total_redords = ExcelData.get("BY_EDI_General_Total_redords");
	public static String BY_EDI_Checkbox2 = ExcelData.get("BY_EDI_Checkbox2");
	public static String BY_EDI_Checkbox1 = ExcelData.get("BY_EDI_Checkbox1");
	public static String BY_EDI_Filter = ExcelData.get("BY_EDI_Filter");
	public static String BY_EDI_Filterinside = ExcelData.get("BY_EDI_Filterinside");
	public static String BY_EDI_movement_code_input = ExcelData.get("BY_EDI_movement_code_input");
	public static String EEC_GENERAL_OPS_AURO_CONFORM_DD = ExcelData.get("EEC_GENERAL_OPS_AURO_CONFORM_DD");
	public static String Damage_checkbox_input = ExcelData.get("Damage_checkbox_input");
	public static String EDI_Gridvalue = ExcelData.get("EDI_Gridvalue");
	public static String EEC_By_Format_Table = ExcelData.get("EEC_By_Format_Table");
	public static String EEC_By_Format_Total_Records = ExcelData.get("EEC_By_Format_Total_Records");
	public static String EEC_EDI_Name_Filter = ExcelData.get("EEC_EDI_Name_Filter");
	public static String EEC_Partner_Name_Filter = ExcelData.get("EEC_Partner_Name_Filter");
	public static String EEC_Select_Id_CheckBox = ExcelData.get("EEC_Select_Id_CheckBox");
	public static String EEC_GENERAL_TotalRecords = ExcelData.get("EEC_GENERAL_TotalRecords");

	public static String EDI_Status_Event_Option = ExcelData.get("EDI_Status_Event_Option");
	public static String EDI_Status_Event_Staus_DropDown = ExcelData.get("EDI_Status_Event_Staus_DropDown");
	public static String EDI_Status_Event_Dropdown_Select = ExcelData.get("EDI_Status_Event_Dropdown_Select");
	public static String EDI_Status_Add_button = ExcelData.get("EDI_Status_Add_button");
	public static String EDI_Status_Event_Filter = ExcelData.get("EDI_Status_Event_Filter");
	public static String EDI_Status_Partner_Id_Input = ExcelData.get("EDI_Status_Partner_Id_Input");
	public static String EDI_Status_Event_Partner_in_Value = ExcelData.get("EDI_Status_Event_Partner_in_Value");
	public static String EDI_Status_EDI_Id_Input = ExcelData.get("EDI_Status_EDI_Id_Input");
	public static String EDI_Status_Event_Edi_Id_Value = ExcelData.get("EDI_Status_Event_Edi_Id_Value");
	public static String EDI_Status_Movement_Code_Input = ExcelData.get("EDI_Status_Movement_Code_Input");
	public static String EDI_Status_Movement_Code_Id_Value = ExcelData.get("EDI_Status_Movement_Code_Id_Value");
	public static String EDI_Status_Event_Movement_Name_Value = ExcelData.get("EDI_Status_Event_Movement_Name_Value");
	public static String EDI_Status_EDI_MovementCode_Input = ExcelData.get("EDI_Status_EDI_MovementCode_Input");
	public static String EDI_Status_Event_select_First_row = ExcelData.get("EDI_Status_Event_select_First_row");
	
	
		
}

