package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Split_BL_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Split_BL_Locators", "Reference_Name", Testcases.environmentName);

	public static String PC_PluginID_input = ExcelData.get("PC_PluginID_input");
	public static String PC_Plugin_Status = ExcelData.get("PC_Plugin_Status");
	public static String SB_Containerised = ExcelData.get("SB_Containerised");
	public static String SB_NonContainerised = ExcelData.get("SB_NonContainerised");
	public static String SB_Cargo = ExcelData.get("SB_Cargo");
	public static String SB_UnCargo = ExcelData.get("SB_UnCargo");
	public static String SB_Tab1 = ExcelData.get("SB_Tab1");
	
	

}
