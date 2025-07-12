package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Master_Reactivation_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Master_Reactivation", "Reference_Name",
			Testcases.environmentName);
	public static String module_Nume_search_button_MR = ExcelData.get("module_Nume_search_button_MR");
	public static String module_Name_Filter_MR = ExcelData.get("module_Name_Filter_MR");
	public static String select_Btn = ExcelData.get("select_Btn");
	public static String show_Button_MR = ExcelData.get("show_Button_MR");
	public static String activity_Code_TF_MR = ExcelData.get("activity_Code_TF_MR");
	public static String activity_Code_Select_MR = ExcelData.get("activity_Code_Select_MR");
	public static String reactive_Button_MR = ExcelData.get("reactive_Button_MR");
	public static String Grid_Select = ExcelData.get("Grid_Select");
	public static String module_Name_search_button_MR = ExcelData.get("module_Name_search_button_MR");
	public static String show_button_MR = ExcelData.get("show_button_MR");
	public static String activity_code_Select_MR = ExcelData.get("activity_code_Select_MR");
	public static String reactive_button_MR = ExcelData.get("reactive_button_MR");
	public static String ResetButton = ExcelData.get("ResetButton");
	public static String select_Btn_MR = ExcelData.get("select_Btn_MR");
	public static String Module_Name_Filter_MR = ExcelData.get("Module_Name_Filter_MR");
	public static String Activity_Code_TF_MR = ExcelData.get("Activity_Code_TF_MR");
	public static String module_Nume_search_button_MRD = ExcelData.get("module_Nume_search_button_MRD");
	public static String show_Button_MRD = ExcelData.get("show_Button_MRD");
	public static String activity_Code_TF_MRD = ExcelData.get("activity_Code_TF_MRD");
	public static String activity_Code_Select_MRD = ExcelData.get("activity_Code_Select_MRD");
	public static String reactive_Button_MRD = ExcelData.get("reactive_Button_MRD");
}
