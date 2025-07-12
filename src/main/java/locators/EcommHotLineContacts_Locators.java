package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EcommHotLineContacts_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EcommHotLineContacts", "Reference_Name", Testcases.environmentName);

	public static String EC_HLC_Contact_Name_Input_Field = ExcelData.get("EC_HLC_Contact_Name_Input_Field");
	public static String EC_HLC_Country_Name_Input_Field = ExcelData.get("EC_HLC_Country_Name_Input_Field");
	public static String EC_HLC_Country_Code_Input_Field = ExcelData.get("EC_HLC_Country_Code_Input_Field");
	public static String EC_HLC_Email_Input_Field = ExcelData.get("EC_HLC_Email_Input_Field");
	public static String EC_HLC_Phone_Input_Field = ExcelData.get("EC_HLC_Phone_Input_Field");
	public static String EC_HLC_Port_Code_Input_Field = ExcelData.get("EC_HLC_Port_Code_Input_Field");
	public static String EC_HLC_Port_Name_Input_Field = ExcelData.get("EC_HLC_Port_Name_Input_Field");
	public static String EC_HLC_Refresh_Button = ExcelData.get("EC_HLC_Refresh_Button");
	public static String EC_HLC_Condition_Filter = ExcelData.get("EC_HLC_Condition_Filter");
	public static String EC_HLC_Condition_Contact_Name_Input_Field = ExcelData.get("EC_HLC_Condition_Contact_Name_Input_Field");
	public static String EC_HLC_Condition_Country_Code_Input_Field = ExcelData.get("EC_HLC_Condition_Country_Code_Input_Field");
	public static String EC_HLC_Condition_Country_Name_Input_Field = ExcelData.get("EC_HLC_Condition_Country_Name_Input_Field");
	public static String EC_HLC_Condition_Email_Input_Field = ExcelData.get("EC_HLC_Condition_Email_Input_Field");
	public static String EC_HLC_Condition_Phone_Input_Field = ExcelData.get("EC_HLC_Condition_Phone_Input_Field");
	public static String EC_HLC_First_row = ExcelData.get("EC_HLC_First_row");
	public static String EC_HLC_Grid_Contact_Name_Input_Field = ExcelData.get("EC_HLC_Grid_Contact_Name_Input_Field");
	public static String EC_HLC_Grid_Country_Code_Input_Field = ExcelData.get("EC_HLC_Grid_Country_Code_Input_Field");
	public static String EC_HLC_Grid_Country_Name_Input_Field = ExcelData.get("EC_HLC_Grid_Country_Name_Input_Field");
	public static String EC_HLC_Grid_Email_Input_Field = ExcelData.get("EC_HLC_Grid_Email_Input_Field");
	public static String EC_HLC_Grid_Phone_Input_Field = ExcelData.get("EC_HLC_Grid_Phone_Input_Field");

     
     
     
}
