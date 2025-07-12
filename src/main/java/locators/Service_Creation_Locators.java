package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Service_Creation_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Service_Creation",
			"Reference_Name", Testcases.environmentName);

	public static String Service_CodeI = ExcelData.get("Service_CodeI");
	public static String Service_NameI = ExcelData.get("Service_NameI");
	public static String No_of_Bound = ExcelData.get("No_of_Bound");
	public static String Service_Type = ExcelData.get("Service_Type");
	public static String Freqency = ExcelData.get("Freqency");
	public static String pnlServiceType = ExcelData.get("pnlServiceType");
	public static String agGrid_Filter = ExcelData.get("agGrid_Filter");
	public static String serviceCode_FilterSearch = ExcelData.get("serviceCode_FilterSearch");
	public static String select_ServiceCode = ExcelData.get("select_ServiceCode");
	public static String serviceName_FilterSearch = ExcelData.get("serviceName_FilterSearch");
	public static String frequency_Textfield = ExcelData.get("frequency_Textfield");
	public static String No_of_Ships1 = ExcelData.get("No_of_Ships1");
	public static String Ext_Fdr = ExcelData.get("Ext_Fdr");
	public static String Start_Date = ExcelData.get("Start_Date");
	public static String ext_FDR_Dropdown = ExcelData.get("ext_FDR_Dropdown");
	public static String End_Date = ExcelData.get("End_Date");
	public static String service_Code_Textfield_SER = ExcelData.get("service_Code_Textfield_SER");
	public static String status_Dropdown_SER = ExcelData.get("status_Dropdown_SER");
	public static String condition_Filter_AG_Grid_SER = ExcelData.get("condition_Filter_AG_Grid_SER");
	public static String status_Dropdown_Value_SER = ExcelData.get("status_Dropdown_Value_SER");

}
