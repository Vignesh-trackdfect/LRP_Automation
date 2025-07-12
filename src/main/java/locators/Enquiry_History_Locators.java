package locators;

import java.util.Map;
import commonMethods.Testcases;
import commonMethods.Utils;

public interface Enquiry_History_Locators{
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Enquiry_History_Locators", "Reference_Name", Testcases.environmentName);
	
	public static String Suppress_Details = ExcelData.get("Suppress_Details");
	public static String CHSC_Value = ExcelData.get("CHSC_Value");
	public static String P_enquiryHistory_Page = ExcelData.get("P_enquiryHistory_Page");
	public static String P_equipmentNo_RadioBtn = ExcelData.get("P_equipmentNo_RadioBtn");
	public static String P_equipment_TxtField = ExcelData.get("P_equipment_TxtField");
	public static String P_equipment_SearchIcon = ExcelData.get("P_equipment_SearchIcon");
	public static String P_show_Btn = ExcelData.get("P_show_Btn");
	public static String P_equipmentNo_Details = ExcelData.get("P_equipmentNo_Details");
	public static String selectEquipment = ExcelData.get("selectEquipment");
	public static String Equipment_Number = ExcelData.get("Equipment_Number");
	public static String Tool_Bar_EH = ExcelData.get("Tool_Bar_EH");
	public static String Condition_Filter_EH = ExcelData.get("Condition_Filter_EH");
	public static String Movement_Filter_EH = ExcelData.get("Movement_Filter_EH");
	public static String movement_Value = ExcelData.get("movement_Value");
	public static String Row_List = ExcelData.get("Row_List");
	public static String Equip_Type_Select = ExcelData.get("Equip_Type_Select");
	public static String Radio_Btn_Select = ExcelData.get("Radio_Btn_Select");
	public static String Date_select = ExcelData.get("Date_select");
	public static String deleted_Value = ExcelData.get("deleted_Value");
	public static String grid_element = ExcelData.get("grid_element");
	public static String P_BLNo_EquipNo = ExcelData.get("P_BLNo_EquipNo");
	public static String P_show_DltRec_ChkBox = ExcelData.get("P_show_DltRec_ChkBox");
	public static String P_deleted_Moves = ExcelData.get("P_deleted_Moves");
	public static String P_Grid_NoOfRetrived = ExcelData.get("P_Grid_NoOfRetrived");
	public static String P_BLNo_ActType = ExcelData.get("P_BLNo_ActType");
	public static String P_equipNo_MultiDetail = ExcelData.get("P_equipNo_MultiDetail");
	public static String AResetButton = ExcelData.get("AResetButton");
	public static String P_suppressAct_CheckBox = ExcelData.get("P_suppressAct_CheckBox");
	public static String P_Show_Top_CheckBox = ExcelData.get("P_Show_Top_CheckBox");
	public static String P_Show_Top_Field = ExcelData.get("P_Show_Top_Field");
	public static String movementcode = ExcelData.get("movementcode");
	public static String P_bookNo_RadioBtn = ExcelData.get("P_bookNo_RadioBtn");
	public static String P_bookingNo_Text = ExcelData.get("P_bookingNo_Text");
	public static String Scruoll = ExcelData.get("Scruoll");
	public static String P_BLNo_RadioBtn = ExcelData.get("P_BLNo_RadioBtn");
	public static String Grid_Movement_Codes = ExcelData.get("Grid_Movement_Codes");
	public static String P_equip_MultiSelect_CheckBox = ExcelData.get("P_equip_MultiSelect_CheckBox");
	public static String P_multiSel_SearchNo_Popup = ExcelData.get("P_multiSel_SearchNo_Popup");
	public static String P_multiSel_Search_SelBtn = ExcelData.get("P_multiSel_Search_SelBtn");
	public static String Equip_Search_Field = ExcelData.get("Equip_Search_Field");
	public static String Equip_Type_DD = ExcelData.get("Equip_Type_DD");
	public static String EquipmentActivity_ToolPannel = ExcelData.get("EquipmentActivity_ToolPannel");
	public static String EquipmentActivity_ConditionFilter = ExcelData.get("EquipmentActivity_ConditionFilter");
	public static String EquipmentActivity_ActivityCode_Tf = ExcelData.get("EquipmentActivity_ActivityCode_Tf");
	public static String Book_Number_Option_EH = ExcelData.get("Book_Number_Option_EH");

}
