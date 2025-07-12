package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface DA_Master_Setup_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "DA_Master_Setup", "Reference_Name", Testcases.environmentName);

	public static String Year_Dropdown_DA = ExcelData.get("Year_Dropdown_DA");
	public static String Month_Dropdown_DA = ExcelData.get("Month_Dropdown_DA");
	public static String DA_Month_Dropdown_DA = ExcelData.get("DA_Month_Dropdown_DA");
	public static String Activity_Month_Dropdown_DA = ExcelData.get("Activity_Month_Dropdown_DA");
	public static String Year_Dropdown_DA_Text = ExcelData.get("Year_Dropdown_DA_Text");
	public static String Month_Dropdown_DA_Text = ExcelData.get("Month_Dropdown_DA_Text");
	public static String DA_Month_Dropdown_DA_Text = ExcelData.get("DA_Month_Dropdown_DA_Text");
	public static String Activity_Month_Dropdown_DA_Text = ExcelData.get("Activity_Month_Dropdown_DA_Text");
	public static String DA_Month_List = ExcelData.get("DA_Month_List");
	public static String DA_Month_Select_1 = ExcelData.get("DA_Month_Select_1");
	public static String Activity_Month_Select_1 = ExcelData.get("Activity_Month_Select_1");
	public static String Agency_Code_DA = ExcelData.get("Agency_Code_DA");

		
}
