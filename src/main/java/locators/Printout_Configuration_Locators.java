package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Printout_Configuration_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Printout_Configuration", "Reference_Name", Testcases.environmentName);
	public static String moduleName_Search_Dropdown = ExcelData.get("moduleName_Search_Dropdown");
	public static String band_Select = ExcelData.get("band_Select");

}
