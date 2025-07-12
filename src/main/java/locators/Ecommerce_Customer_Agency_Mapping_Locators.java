package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecommerce_Customer_Agency_Mapping_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecom_Customer_Agency_Mapping", "Reference_Name", Testcases.environmentName);

	public static String customer_Agency_Mapping_Module_Title = ExcelData.get("customer_Agency_Mapping_Module_Title");
	public static String Agency_Code_Search_button_CAM = ExcelData.get("Agency_Code_Search_button_CAM");
	public static String customer_Code_Search_Button_CAM = ExcelData.get("customer_Code_Search_Button_CAM");
	public static String Refresh_Button_CAM = ExcelData.get("Refresh_Button_CAM");
	public static String agency_Code_filter_CAM = ExcelData.get("agency_Code_filter_CAM");
	public static String customer_Code_Filter_CAM = ExcelData.get("customer_Code_Filter_CAM");
	public static String agency_Grid_Value = ExcelData.get("agency_Grid_Value");
	public static String Customer_Grid_Value = ExcelData.get("Customer_Grid_Value");

	
}
