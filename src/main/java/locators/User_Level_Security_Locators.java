package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface User_Level_Security_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "User_Level_Security",
			"Reference_Name", Testcases.environmentName);
	
	public static String user_Search_button_ULS = ExcelData.get("user_Search_button_ULS");
	public static String UserName_Input_ULS = ExcelData.get("UserName_Input_ULS");
	public static String Load_Module_button_ULS = ExcelData.get("Load_Module_button_ULS");
	public static String Activity_Filter_Input_ULS = ExcelData.get("Activity_Filter_Input_ULS");
	public static String Cost_Activity_Report_ULS = ExcelData.get("Cost_Activity_Report_ULS");
	public static String Table_Description_ULS = ExcelData.get("Table_Description_ULS");
	public static String Description_Add_button_ULS = ExcelData.get("Description_Add_button_ULS");
	public static String post_button = ExcelData.get("post_button");
	public static String invoice_reverse_button = ExcelData.get("invoice_reverse_button");
	public static String privilege_row_click = ExcelData.get("privilege_row_click");
	public static String Description_remove_button_ULS = ExcelData.get("Description_remove_button_ULS");
	public static String Description_select_check_box = ExcelData.get("Description_select_check_box");
	public static String UL_privilege_APM = ExcelData.get("UL_privilege_APM");
	public static String UL_Haulage_Contract = ExcelData.get("UL_Haulage_Contract");
	public static String UL_privilege_RJM = ExcelData.get("UL_privilege_RJM");
	
}
