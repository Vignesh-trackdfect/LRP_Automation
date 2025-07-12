package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Local_Contacts_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Local_Contacts", "Reference_Name", Testcases.environmentName);
	public static String LC_Terminal_Filter = ExcelData.get("LC_Terminal_Filter");
	public static String LC_Terminal_Name_Gridcell = ExcelData.get("LC_Terminal_Name_Gridcell");
}
