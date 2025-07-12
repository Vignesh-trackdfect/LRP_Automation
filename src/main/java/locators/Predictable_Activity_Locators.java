package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Predictable_Activity_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Predictable_Activity",
			"Reference_Name", Testcases.environmentName);

	public static String Predictable_Activity_Table_PAB = ExcelData.get("Predictable_Activity_Table_PAB");
	public static String Activity_Column_PAB = ExcelData.get("Activity_Column_PAB");
	public static String Activity_Name_PAB = ExcelData.get("Activity_Name_PAB");
	public static String Add_item_PAB = ExcelData.get("Add_item_PAB");
	public static String Add_Main_Item_PAB = ExcelData.get("Add_Main_Item_PAB");
	public static String Contract_type_Input_PAB = ExcelData.get("Contract_type_Input_PAB");
	public static String Select_Contract_Type_PAB = ExcelData.get("Select_Contract_Type_PAB");
	public static String From_Date_Input_PAB = ExcelData.get("From_Date_Input_PAB");
	public static String Port_Input_PAB = ExcelData.get("Port_Input_PAB");
	public static String Terminal_Port_PAB = ExcelData.get("Terminal_Port_PAB");
	public static String Show_Button_PAB = ExcelData.get("Show_Button_PAB");
	public static String Template_Numer_Input_PAB = ExcelData.get("Template_Numer_Input_PAB");
	public static String Predictable_Reporting_checkbox = ExcelData.get("Predictable_Reporting_checkbox");
	public static String Un_Predictable_Reporting_checkbox = ExcelData.get("Un_Predictable_Reporting_checkbox");
	public static String Un_Predictable_Reporting_Quantity1 = ExcelData.get("Un_Predictable_Reporting_Quantity1");
	public static String Un_Predictable_Reporting_Quantity_Input_Field = ExcelData.get("Un_Predictable_Reporting_Quantity_Input_Field");
	public static String Global_Search = ExcelData.get("Global_Search");
	public static String Approved_Total = ExcelData.get("Approved_Total");
	public static String Approved_table = ExcelData.get("Approved_table");
	public static String show_Row_values = ExcelData.get("show_Row_values");
	public static String Show_Currency_Value = ExcelData.get("Show_Currency_Value");
	public static String Show_Amount_Value = ExcelData.get("Show_Amount_Value");
	public static String Quantity_Input_CAR1 = ExcelData.get("Quantity_Input_CAR1");
	public static String Approved_Expensive_all_values = ExcelData.get("Approved_Expensive_all_values");
	public static String Delete = ExcelData.get("Delete");
	public static String port_Mapping_ID_Textfield_CM = ExcelData.get("port_Mapping_ID_Textfield_CM");
	public static String mainActivityName_Unpred_CAR = ExcelData.get("mainActivityName_Unpred_CAR");
	public static String Message_Ok_Button_CAR = ExcelData.get("Message_Ok_Button_CAR");
	public static String predictable_SubActivity_Column_Ctl = ExcelData.get("predictable_SubActivity_Column_Ctl");
	public static String predictable_Table_Toolpanel_Car = ExcelData.get("predictable_Table_Toolpanel_Car");
	public static String predictable_MainActivity_Column_Ctl = ExcelData.get("predictable_MainActivity_Column_Ctl");
	public static String Predictable_Activity_Table_Column = ExcelData.get("Predictable_Activity_Table_Column");
	public static String column_All_Select_CheckBox = ExcelData.get("column_All_Select_CheckBox");
}
