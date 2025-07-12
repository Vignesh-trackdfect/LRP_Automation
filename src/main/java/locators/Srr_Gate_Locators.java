package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Srr_Gate_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Srr_Gate",
			"Reference_Name", Testcases.environmentName);

	public static String submit_RadioButton = ExcelData.get("submit_RadioButton");
	public static String menu_Icon_Grid = ExcelData.get("menu_Icon_Grid");
	public static String filter_Icon_Grid = ExcelData.get("filter_Icon_Grid");
	public static String filter_Inputfield = ExcelData.get("filter_Inputfield");
	public static String srrGate_Tab = ExcelData.get("srrGate_Tab");
	public static String select_Actual_ReqNo = ExcelData.get("select_Actual_ReqNo");
	public static String moveTo_Pending = ExcelData.get("moveTo_Pending");
	public static String close_Moved_Pending_Popup = ExcelData.get("close_Moved_Pending_Popup");
	public static String pending_RadioButton = ExcelData.get("pending_RadioButton");
	public static String SRR_Search_Value = ExcelData.get("SRR_Search_Value");
	public static String SRR_Req_Type = ExcelData.get("SRR_Req_Type");
	public static String All_Req_Type = ExcelData.get("All_Req_Type");
	public static String SRR_Refresh_Btn = ExcelData.get("SRR_Refresh_Btn");
	public static String NOR_Check_Box = ExcelData.get("NOR_Check_Box");
	public static String non_Containerized_RadioButton = ExcelData.get("non_Containerized_RadioButton");
	public static String srrGate_Module = ExcelData.get("srrGate_Module");
	public static String Srr_no = ExcelData.get("Srr_no");





















}
