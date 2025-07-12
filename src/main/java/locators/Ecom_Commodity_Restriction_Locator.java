package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecom_Commodity_Restriction_Locator {
   
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecom_Commodity_Restriction", "Reference_Name", Testcases.environmentName);

	public static String ECR_Commodity_Code = ExcelData.get("ECR_Commodity_Code");
	public static String ECR_Commodity_Code_Search_Button = ExcelData.get("ECR_Commodity_Code_Search_Button");
	public static String ECR_Commodity_Code_Input_Field = ExcelData.get("ECR_Commodity_Code_Input_Field");
	public static String ECR_Commodity_Name_Input_Field = ExcelData.get("ECR_Commodity_Name_Input_Field");
	public static String ECR_Show_User_Info_and_Status_checkbox = ExcelData.get("ECR_Show_User_Info_and_Status_checkbox");
	public static String ECR_Grid_Commodity_Code = ExcelData.get("ECR_Grid_Commodity_Code");
	public static String ECR_Grid_Commodity_Name = ExcelData.get("ECR_Grid_Commodity_Name");
	public static String ECR_Refresh_Button = ExcelData.get("ECR_Refresh_Button");

}
