package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Journal_Uploads_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Journal_Uploads", "Reference_Name",
			Testcases.environmentName);

	public static String JU_Import_Excel_Button = ExcelData.get("JU_Import_Excel_Button");
	public static String JU_Select_Excel_File = ExcelData.get("JU_Select_Excel_File");
	public static String JU_Sheet_Select = ExcelData.get("JU_Sheet_Select");
	public static String JU_Load_Sheet_Button = ExcelData.get("JU_Load_Sheet_Button");
	public static String JU_Excel_AutoMap_Yes_Button = ExcelData.get("JU_Excel_AutoMap_Yes_Button");
	public static String JU_Excel_Upload_Button = ExcelData.get("JU_Excel_Upload_Button");
	public static String JU_Table_Value = ExcelData.get("JU_Table_Value");
	public static String JU_Select_All_Check_Box = ExcelData.get("JU_Select_All_Check_Box");
	public static String JU_Verify_Button = ExcelData.get("JU_Verify_Button");
	public static String JU_Post_Button = ExcelData.get("JU_Post_Button");
	public static String JU_Clear_Button = ExcelData.get("JU_Clear_Button");
	public static String JU_Total_Records = ExcelData.get("JU_Total_Records");
	public static String JU_Template_Button = ExcelData.get("JU_Template_Button");
	public static String JU_Error_Summary = ExcelData.get("JU_Error_Summary");
	public static String JU_Select_Sheet_Option = ExcelData.get("JU_Select_Sheet_Option");
	
}
