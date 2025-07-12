package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Manifest_Closure_Force_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Manifest_Closure_Force", "Reference_Name",
			Testcases.environmentName);
	public static String MCF_By_Bl_No_radio_Button = ExcelData.get("MCF_By_Bl_No_radio_Button");
	public static String MCF_By_Bl_No_Search_Button = ExcelData.get("MCF_By_Bl_No_Search_Button");
	public static String MCF_Show_Button = ExcelData.get("MCF_Show_Button");
	public static String MCF_Select_Checkbox = ExcelData.get("MCF_Select_Checkbox");
	public static String MCF_Force_Close_Button = ExcelData.get("MCF_Force_Close_Button");
	public static String MCF_Remarks_Area = ExcelData.get("MCF_Remarks_Area");
//	public static String MCF_By_Bl_No_Search_Button = ExcelData.get("MCF_By_Bl_No_Search_Button");
//	public static String MCF_Show_Button = ExcelData.get("MCF_Show_Button");
//	public static String MCF_Select_Checkbox = ExcelData.get("MCF_Select_Checkbox");
//	public static String MCF_Force_Close_Button = ExcelData.get("MCF_Force_Close_Button");
//	public static String MCF_By_Bl_No_radio_Button = ExcelData.get("MCF_By_Bl_No_radio_Button");
//	public static String MCF_By_Bl_No_Search_Button = ExcelData.get("MCF_By_Bl_No_Search_Button");
//	public static String MCF_Show_Button = ExcelData.get("MCF_Show_Button");
//	public static String MCF_Select_Checkbox = ExcelData.get("MCF_Select_Checkbox");
//	public static String MCF_Force_Close_Button = ExcelData.get("MCF_Force_Close_Button");
//	public static String MCF_By_Bl_No_radio_Button = ExcelData.get("MCF_By_Bl_No_radio_Button");
//	public static String MCF_By_Bl_No_Search_Button = ExcelData.get("MCF_By_Bl_No_Search_Button");
//	public static String MCF_Show_Button = ExcelData.get("MCF_Show_Button");
//	public static String MCF_Select_Checkbox = ExcelData.get("MCF_Select_Checkbox");
//	public static String MCF_Force_Close_Button = ExcelData.get("MCF_Force_Close_Button");
}
