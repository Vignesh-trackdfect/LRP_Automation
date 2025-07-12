package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Capacity_Allocation {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Capacity_Allocation", "Reference_Name", Testcases.environmentName);

	public static String CA_Service = ExcelData.get("CA_Service");
	public static String CA_From_Date = ExcelData.get("CA_From_Date");
	public static String CA_To_Date = ExcelData.get("CA_To_Date");
	public static String CA_Show_Button = ExcelData.get("CA_Show_Button");
	public static String CA_Vessel_Name = ExcelData.get("CA_Vessel_Name");
	public static String CA_Ports_Capacity = ExcelData.get("CA_Ports_Capacity");
	public static String CA_Filter_Button = ExcelData.get("CA_Filter_Button");
	public static String CA_Port_Input_Filed = ExcelData.get("CA_Port_Input_Filed");
	public static String CA_Allocated_Last_option = ExcelData.get("CA_Allocated_Last_option");
	public static String CA_Agency_Allocation = ExcelData.get("CA_Agency_Allocation");
	public static String CA_Agency_Load_Input_Field = ExcelData.get("CA_Agency_Load_Input_Field");
	public static String CA_INNSA = ExcelData.get("CA_INNSA");
	public static String CA_TeusValue = ExcelData.get("CA_TeusValue");
	public static String CA_Svm_Allcation_W_Value = ExcelData.get("CA_Svm_Allcation_W_Value");
	public static String CA_SVM_WT_Value = ExcelData.get("CA_SVM_WT_Value");
	public static String CA_SSL_Alllocation_W_Value = ExcelData.get("CA_SSL_Alllocation_W_Value");
	public static String CA_SVM_Tons_value = ExcelData.get("CA_SVM_Tons_value");
	public static String CA_SSL_Tons_Value = ExcelData.get("CA_SSL_Tons_Value");
	public static String CA_Allocated_Details = ExcelData.get("CA_Allocated_Details");
	public static String CA_SVM_Amount = ExcelData.get("CA_SVM_Amount");
	public static String CA_SSL_Amount = ExcelData.get("CA_SSL_Amount");
	public static String CA_SVM_Tues = ExcelData.get("CA_SVM_Tues");
	public static String CA_SSL_Tues = ExcelData.get("CA_SSL_Tues");
	public static String CA_Allocation_Aejea_Amounts = ExcelData.get("CA_Allocation_Aejea_Amounts");
	public static String CA_Allocation_Amount = ExcelData.get("CA_Allocation_Amount");
	public static String BK_plus_Button = ExcelData.get("BK_plus_Button");
	public static String Booking_Vessel_Allocation_Table = ExcelData.get("Booking_Vessel_Allocation_Table");
	public static String Booking_Vessel_Row_Vessel = ExcelData.get("Booking_Vessel_Row_Vessel");
	//unsed
	
//	public static String CA_Agency_Filter_Button ="CA_Agency_Filter_Button>(//a[@id='AAL-AAL_dsAgencyGrid_conditionFilter_id'])[2]";
	
	
}
