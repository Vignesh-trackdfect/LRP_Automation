package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EMS_Gate_Locators{
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EMS_Gate", "Reference_Name", Testcases.environmentName);

	public static String EMS_Gate_From_Date = ExcelData.get("EMS_Gate_From_Date");
	public static String EMS_Gate_To_Date = ExcelData.get("EMS_Gate_To_Date");
	public static String Action_Required_CheckBox = ExcelData.get("Action_Required_CheckBox");
	public static String Action_NotRequired_CheckBox = ExcelData.get("Action_NotRequired_CheckBox");
	public static String refresh_Button_Ems_Gate = ExcelData.get("refresh_Button_Ems_Gate");
	public static String Status_Menu = ExcelData.get("Status_Menu");
	public static String Filter_Option = ExcelData.get("Filter_Option");
	public static String Select_all_CheckBox = ExcelData.get("Select_all_CheckBox");
	public static String select_value = ExcelData.get("select_value");
	public static String Error_Record_List = ExcelData.get("Error_Record_List");
	public static String error_row = ExcelData.get("error_row");
	public static String error_file = ExcelData.get("error_file");
	public static String Error_Record_Grid = ExcelData.get("Error_Record_Grid");
	public static String EDI_ErrorMoments_EqpNo = ExcelData.get("EDI_ErrorMoments_EqpNo");
	public static String EDI_Value = ExcelData.get("EDI_Value");
	public static String Ems_gate_Frame = ExcelData.get("Ems_gate_Frame");
	public static String Norecordsround_okbtn1 = ExcelData.get("Norecordsround_okbtn1");
	public static String custom_search = ExcelData.get("custom_search");
	public static String ToolPanel = ExcelData.get("ToolPanel");
	public static String Confitionfilter = ExcelData.get("Confitionfilter");
	public static String EDI_Date = ExcelData.get("EDI_Date");
	public static String Error_Date = ExcelData.get("Error_Date");
	public static String System_fileName_TF = ExcelData.get("System_fileName_TF");
	public static String show_Btn = ExcelData.get("show_Btn");
	public static String Error_Grid = ExcelData.get("Error_Grid");
	public static String Firstgrid = ExcelData.get("Firstgrid");
	public static String P_Equip_Filter_CheckBox = ExcelData.get("P_Equip_Filter_CheckBox");
	public static String kFromDate = ExcelData.get("kFromDate");
	public static String kToDate = ExcelData.get("kToDate");
	public static String kAddOption = ExcelData.get("kAddOption");
	public static String kSelectFirstOpt = ExcelData.get("kSelectFirstOpt");
	public static String kGetValu = ExcelData.get("kGetValu");
	public static String kSelectOption = ExcelData.get("kSelectOption");
	public static String kShowOp = ExcelData.get("kShowOp");
	public static String kErrorList = ExcelData.get("kErrorList");
	public static String EDI_ErrorMoments_ToolPannel = ExcelData.get("EDI_ErrorMoments_ToolPannel");
	public static String EDI_ErrorMoments_ConditionFilter = ExcelData.get("EDI_ErrorMoments_ConditionFilter");
	public static String EDI_ErrorMoments_Equipment_No = ExcelData.get("EDI_ErrorMoments_Equipment_No");
	public static String Filter_Option_Gate = ExcelData.get("Filter_Option_Gate");
	public static String Error_Grid_Gate = ExcelData.get("Error_Grid_Gate");


}
