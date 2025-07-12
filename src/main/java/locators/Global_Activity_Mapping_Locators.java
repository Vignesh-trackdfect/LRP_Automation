package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Global_Activity_Mapping_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Global_Activity_Mapping", "Reference_Name", Testcases.environmentName);

	public static String contract_type_search_icon_Gam = ExcelData.get("contract_type_search_icon_Gam");
	public static String show_button_Gam_Mod = ExcelData.get("show_button_Gam_Mod");
	public static String act_code_textfield = ExcelData.get("act_code_textfield");
	public static String main_activity_to_map = ExcelData.get("main_activity_to_map");
	public static String plus_icon_Gam = ExcelData.get("plus_icon_Gam");
	public static String subActivity_Table_Row_GAM = ExcelData.get("subActivity_Table_Row_GAM");
	public static String ActivityName_Filter_Input_GAM = ExcelData.get("ActivityName_Filter_Input_GAM");
	public static String Parent_Activity_Checkbox_GAM = ExcelData.get("Parent_Activity_Checkbox_GAM");

//	public static String contract_type_search_icon_Gam = "contract_type_search_icon_Gam>//button[@id='GLO-GLO_btnContract-GLO_btnContract']";
//	public static String show_button_Gam_Mod = "show_button_Gam_Mod>//button[@id='GLO-GLO_btnShow']";
//	public static String act_code_textfield = "act_code_textfield>//fieldset[@id='GLO-GLO_subactivity']//span[.='Activity Code']/..//input[contains(@id,'GLO_gridActivity')]";
//	public static String main_activity_to_map = "main_activity_to_map>//div[@id='GLO-GLO_treeActivity']//li//span[contains(text(),'%s')]";
//	public static String plus_icon_Gam = "plus_icon_Gam>//button[@id='GLO-GLO_btnAddTree']/span[1]";
//	public static String subActivity_Table_Row_GAM = "subActivity_Table_Row_GAM>//tbody[@id='GLO-GLO_gridActivity_data']/tr";

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
