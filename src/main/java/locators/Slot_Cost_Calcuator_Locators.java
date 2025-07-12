package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Slot_Cost_Calcuator_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Slot_Cost_Calcuator", "Reference_Name", Testcases.environmentName);

	public static String SCC_Slot_Cost_Calculator_Option = ExcelData.get("SCC_Slot_Cost_Calculator_Option");
	public static String SCC_Action_Button = ExcelData.get("SCC_Action_Button");
	public static String SCC_Teu_Option = ExcelData.get("SCC_Teu_Option");
	public static String SCC_Teu_Input_Option = ExcelData.get("SCC_Teu_Input_Option");
	public static String SCC_Arr_pilot_Option = ExcelData.get("SCC_Arr_pilot_Option");
	public static String SCC_Arr_pilot_Option_Input = ExcelData.get("SCC_Arr_pilot_Option_Input");
	public static String SCC_Port_First_row = ExcelData.get("SCC_Port_First_row");
	public static String SSC_Status = ExcelData.get("SSC_Status");
	public static String SCC_Arr_Dock_Option = ExcelData.get("SCC_Arr_Dock_Option");
	public static String SCC_Arr_Dock_Option_Input = ExcelData.get("SCC_Arr_Dock_Option_Input");
	public static String SCC_Dep_Dock_input = ExcelData.get("SCC_Dep_Dock_input");
	
	
}
