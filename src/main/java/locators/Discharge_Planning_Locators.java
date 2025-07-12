package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Discharge_Planning_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Discharge_Planning", "Reference_Name", Testcases.environmentName);
	public static String Discharge_planning_DP = ExcelData.get("Discharge_planning_DP");
	public static String Service_input_field_DP  = ExcelData.get("Service_input_field_DP");
	public static String Vessel_input_field_DP  = ExcelData.get("Vessel_input_field_DP");
	public static String Voyage_input_field_DP = ExcelData.get("Voyage_input_field_DP");
	public static String Bound_input_field_DP = ExcelData.get("Bound_input_field_DP");
	public static String Grid_scroll_DP = ExcelData.get("Grid_scroll_DP");
	public static String Grid_scroll_port_DP = ExcelData.get("Grid_scroll_port_DP");
	public static String Grid_terminal_DP = ExcelData.get("Grid_terminal_DP");
	public static String Grid_selectbutton_DP = ExcelData.get("Grid_selectbutton_DP");
	public static String Plan_option_DP = ExcelData.get("Plan_option_DP");
	public static String Plan_optionSelect_DP = ExcelData.get("Plan_optionSelect_DP");
	public static String ReconcilationButton_DP = ExcelData.get("ReconcilationButton_DP");
	public static String Dischargerecon_header_DP = ExcelData.get("Dischargerecon_header_DP");
	public static String download_BL_Button_DRCnavfromDP = ExcelData.get("download_BL_Button_DRCnavfromDP");
	public static String BLnumbers_listed_DP = ExcelData.get("BLnumbers_listed_DP");
}
