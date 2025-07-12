package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Cost_Configuration_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Cost_Configuration", "Reference_Name", Testcases.environmentName);

	public static String cost_Attribute_Filter_CSO = ExcelData.get("cost_Attribute_Filter_CSO");
	public static String retrieved_Attribute_Value_CSO = ExcelData.get("retrieved_Attribute_Value_CSO");
	public static String value_Textfield_CSO = ExcelData.get("value_Textfield_CSO");

}
