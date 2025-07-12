package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecommerce_Gateway_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecommerce_Gateway", "Reference_Name", Testcases.environmentName);

	public static String EG_Transaction_type = ExcelData.get("EG_Transaction_type");
	public static String EG_Select_Transaction_type = ExcelData.get("EG_Select_Transaction_type");
	public static String EG_byDate_Checkbox = ExcelData.get("EG_byDate_Checkbox");
	public static String EG_FromDate_Input = ExcelData.get("EG_FromDate_Input");
	public static String EG_ToDate_Input = ExcelData.get("EG_ToDate_Input");
	public static String EG_NonProcessed_Checkbox = ExcelData.get("EG_NonProcessed_Checkbox");
	public static String EG_Archive_Checkbox = ExcelData.get("EG_Archive_Checkbox");
	public static String EG_ReferenceNo_Input = ExcelData.get("EG_ReferenceNo_Input");
	public static String EG_Refresh = ExcelData.get("EG_Refresh");
	public static String EG_BookingNo_input = ExcelData.get("EG_BookingNo_input");
	public static String EG_BLNo_input = ExcelData.get("EG_BLNo_input");
	public static String EG_ConditionFilter = ExcelData.get("EG_ConditionFilter");
	public static String EG_SourceName = ExcelData.get("EG_SourceName");
	public static String EG_SourceName_FilterInput = ExcelData.get("EG_SourceName_FilterInput");
	public static String EG_ReferenceNo = ExcelData.get("EG_ReferenceNo");
	public static String EG_AG_Grid_Show_Original = ExcelData.get("EG_AG_Grid_Show_Original");
	public static String EG_Grid_Status = ExcelData.get("EG_Grid_Status");
	public static String EG_Grid_ReceivedDate = ExcelData.get("EG_Grid_ReceivedDate");
	public static String EG_Grid_TotalRecords = ExcelData.get("EG_Grid_TotalRecords");
	public static String EG_Grid_RefNo = ExcelData.get("EG_Grid_RefNo");
	public static String EG_Grid_BookNo = ExcelData.get("EG_Grid_BookNo");
	public static String EG_Grid_BLNo = ExcelData.get("EG_Grid_BLNo");
	public static String EG_Grid_Select_ref = ExcelData.get("EG_Grid_Select_ref");
	public static String EG_Grid_Select_Book = ExcelData.get("EG_Grid_Select_Book");
	public static String EG_Grid_Select_BL = ExcelData.get("EG_Grid_Select_BL");
	public static String EG_ShowOriginal = ExcelData.get("EG_ShowOriginal");
	public static String Ref_Number_Filter_Input_Ecomm_Gateway = ExcelData.get("Ref_Number_Filter_Input_Ecomm_Gateway");
	public static String Select_Ref_no_Ecomm_Gateway = ExcelData.get("Select_Ref_no_Ecomm_Gateway");

	public static String First_Row_Grid_Ecomm_Gate_Way = ExcelData.get("First_Row_Grid_Ecomm_Gate_Way");

	
	
}
