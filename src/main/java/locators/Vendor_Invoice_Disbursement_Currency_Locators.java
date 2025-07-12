package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Vendor_Invoice_Disbursement_Currency_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Vendor_Invoice_Disbursement",
			"Reference_Name", Testcases.environmentName);
	
	public static String agency_Search_Button_VIDC = ExcelData.get("agency_Search_Button_VIDC");
	public static String location_Code_Plus_Button_VIDC = ExcelData.get("location_Code_Plus_Button_VIDC");
	public static String agency_code_TF_VIDC = ExcelData.get("agency_code_TF_VIDC");
	public static String VIDC_Table_Header = ExcelData.get("VIDC_Table_Header");
	public static String VIDC_Table_Row = ExcelData.get("VIDC_Table_Row");

	
	

}
