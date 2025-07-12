package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EComm_KYC_Detail_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EComm_KYC_Detail", "Reference_Name", Testcases.environmentName);

	public static String Country_SearchBtn_KYC_Details = ExcelData.get("Country_SearchBtn_KYC_Details");
	public static String FieldName_Input_KYC_Details = ExcelData.get("FieldName_Input_KYC_Details");
	public static String Mandatory_Fields_KYC_Details = ExcelData.get("Mandatory_Fields_KYC_Details");
	public static String Mandatory_Field_Select_KYC_Details = ExcelData.get("Mandatory_Field_Select_KYC_Details");
	public static String Refresh_Btn_KYC_Details = ExcelData.get("Refresh_Btn_KYC_Details");
	public static String Country_Filter_Input_KYC_Details = ExcelData.get("Country_Filter_Input_KYC_Details");
	public static String FieldName_Filter_Input_KYC_Details = ExcelData.get("FieldName_Filter_Input_KYC_Details");
	public static String Mandatory_Filter_Input_KYC_Details = ExcelData.get("Mandatory_Filter_Input_KYC_Details");
	public static String KYC_Details_Table_Column = ExcelData.get("KYC_Details_Table_Column");
	public static String KYC_Detail_Table_Row_Edit = ExcelData.get("KYC_Detail_Table_Row_Edit");

	
	
}
