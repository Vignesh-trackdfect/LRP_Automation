package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Day_Light_Configuration_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Daylight_Configuration", "Reference_Name",
			Testcases.environmentName);

	public static String DLC_ExcelUpload_Checkbox = ExcelData.get("DLC_ExcelUpload_Checkbox");
	public static String DLC_ImportExcel = ExcelData.get("DLC_ImportExcel");
	public static String DLC_TimeDaylight_Grid = ExcelData.get("DLC_TimeDaylight_Grid");
	public static String DLC_Selectall_Checkbox = ExcelData.get("DLC_Selectall_Checkbox");
	public static String DLC_Approve = ExcelData.get("DLC_Approve");
	public static String DLC_ChangeFromDate = ExcelData.get("DLC_ChangeFromDate");
	public static String DLC_ChangeToDate = ExcelData.get("DLC_ChangeToDate");
	
	

}
