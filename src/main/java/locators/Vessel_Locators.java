package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Vessel_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Vessel",
			"Reference_Name", Testcases.environmentName);
	
	public static String Vessel_Code_Filter_Input_VSL = ExcelData.get("Vessel_Code_Filter_Input_VSL");
	public static String Vessel_Code_Action_button_VSL = ExcelData.get("Vessel_Code_Action_button_VSL");
	public static String P_vessel_Status_TxtField = ExcelData.get("P_vessel_Status_TxtField");
	public static String P_vessel_NewBtn = ExcelData.get("P_vessel_NewBtn");
	public static String Get_Varibale_Value_VSL = ExcelData.get("Get_Varibale_Value_VSL");
	public static String switchButton = ExcelData.get("switchButton");
	public static String vesselCode_In_Vessel = ExcelData.get("vesselCode_In_Vessel");
	public static String statusDropDown = ExcelData.get("statusDropDown");
	public static String Vessel_Operator_Gridcell = ExcelData.get("Vessel_Operator_Gridcell");

	
	
}
