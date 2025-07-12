package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Accounting_Configuration_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Accounting_Configuration", "Reference_Name", Testcases.environmentName);

	
	public static String privilegeCode_Filter_SelectButton = ExcelData.get("privilegeCode_Filter_SelectButton");
	public static String att_add_btn = ExcelData.get("att_add_btn");
	public static String att_add_input = ExcelData.get("att_add_input");
	public static String att_add_input_close = ExcelData.get("att_add_input_close");
	public static String att_remove_btn = ExcelData.get("att_remove_btn");
	public static String acc_config_filter = ExcelData.get("acc_config_filter");
	public static String condition_filter = ExcelData.get("condition_filter");
	public static String acc_config_agency = ExcelData.get("acc_config_agency");
	public static String acc_config_agency_input = ExcelData.get("acc_config_agency_input");
	public static String Attributr_search = ExcelData.get("Attributr_search");
	public static String Attributr_show = ExcelData.get("Attributr_show");
	public static String Value_checkbox = ExcelData.get("Value_checkbox");
	public static String Value_checkbox_edit = ExcelData.get("Value_checkbox_edit");
	public static String accountingConfig_Attribute = ExcelData.get("accountingConfig_Attribute");
	public static String Attribute_search_click = ExcelData.get("Attribute_search_click");
	public static String condition_filter_Account_Config = ExcelData.get("condition_filter_Account_Config");
	public static String Att_add_btn_Account_Config = ExcelData.get("Att_add_btn_Account_Config");
	public static String Att_remove_btn_Account_Config = ExcelData.get("Att_remove_btn_Account_Config");
	public static String Att_add_input_Account_Config = ExcelData.get("Att_add_input_Account_Config");
	public static String acc_Config_First_Value = ExcelData.get("acc_Config_First_Value");
	public static String acc_UD_Config_Add_Button = ExcelData.get("acc_UD_Config_Add_Button");
	public static String acc_UD_Config_First_Value = ExcelData.get("acc_UD_Config_First_Value");
	public static String acc_Value_List = ExcelData.get("acc_Value_List");
	public static String acc_Value_List_Add_Button = ExcelData.get("acc_Value_List_Add_Button");
	public static String acc_Value_Field = ExcelData.get("acc_Value_Field");
	public static String acc_Value_Add_Button = ExcelData.get("acc_Value_Add_Button");

	
}
