package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Global_Search_Locators {
Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Global_Search", "Reference_Name", Testcases.environmentName);
	
	//
	public static String Right_Click_Copy = ExcelData.get("Right_Click_Copy");
	public static String GroupCode_First_Row = ExcelData.get("GroupCode_First_Row");
	public static String GroupCode_Text_Field = ExcelData.get("GroupCode_Text_Field");

}
