package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Vessel_Info_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Vessel_Info", "Reference_Name", Testcases.environmentName);
	public static String VSI_Rotation_No_Textfield = ExcelData.get("VSI_Rotation_No_Textfield");
	public static String VSI_Terminal_Vessel_Id_Textfield = ExcelData.get("VSI_Terminal_Vessel_Id_Textfield");
	
}
