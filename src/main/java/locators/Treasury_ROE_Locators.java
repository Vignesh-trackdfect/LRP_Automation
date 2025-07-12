package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Treasury_ROE_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Treasury_ROE_Locators",
			"Reference_Name", Testcases.environmentName);
	
	public static String TreasuryRoe_Column_Headers = ExcelData.get("TreasuryRoe_Column_Headers");
	public static String TreasuryRoe_Column_Rows = ExcelData.get("TreasuryRoe_Column_Rows");
	
}
