package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Regional_Trade_Mapping_Locators {
	
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Regional_Trade_Mapping_Locators",
			"Reference_Name", Testcases.environmentName);
	
	
	public static String RTM_LocationCode_Filter = ExcelData.get("RTM_LocationCode_Filter");
	public static String RTM_TableHeader = ExcelData.get("RTM_TableHeader");
	public static String RTM_TableRowValues = ExcelData.get("RTM_TableRowValues");
	
	

}
