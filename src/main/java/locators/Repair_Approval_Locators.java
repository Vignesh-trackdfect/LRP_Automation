package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Repair_Approval_Locators {

Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Repair_Approval", "Reference_Name", Testcases.environmentName);
	
	//
	public static String CMR_Main_Grid_Btn = ExcelData.get("CMR_Main_Grid_Btn");
	public static String CMR_Save_Template_Btn = ExcelData.get("CMR_Save_Template_Btn");
	public static String CMR_Template_Name_Field = ExcelData.get("CMR_Template_Name_Field");
	public static String CMR_Template_Save = ExcelData.get("CMR_Template_Save");
	public static String CMR_Iso_damage_Column = ExcelData.get("CMR_Iso_damage_Column");
	public static String Click_And_Drag_Field = ExcelData.get("Click_And_Drag_Field");
	public static String New_Template_Header = ExcelData.get("New_Template_Header");
}
