package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Routing_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Routing",
			"Reference_Name", Testcases.environmentName);
	
	public static String Routing_Origin_Search = ExcelData.get("Routing_Origin_Search");
	public static String Routing_Delivery_Search = ExcelData.get("Routing_Delivery_Search");
	public static String Routing_Existing_Route_Button = ExcelData.get("Routing_Existing_Route_Button");
	public static String Routing_POL_Search_Button = ExcelData.get("Routing_POL_Search_Button");
	public static String Routing_POL_Terminal_Search_Button = ExcelData.get("Routing_POL_Terminal_Search_Button");
	public static String Routing_Service_Search_Button = ExcelData.get("Routing_Service_Search_Button");
	public static String Routing_POD_Terminal_Search_Button = ExcelData.get("Routing_POD_Terminal_Search_Button");
	public static String Routing_Add_Button = ExcelData.get("Routing_Add_Button");
//	public static String originalTransaction_Tab_Row = ExcelData.get("originalTransaction_Tab_Row");
//	public static String reversalTransaction_Tab_Row = ExcelData.get("reversalTransaction_Tab_Row");
//	public static String reversalStatus = ExcelData.get("reversalStatus");
//	public static String description_textArea_Reversal = ExcelData.get("description_textArea_Reversal");
//	public static String originalTransaction_Tab = ExcelData.get("originalTransaction_Tab");
//	public static String reversalTransaction_Tab = ExcelData.get("reversalTransaction_Tab");
//	public static String financial_Year_Searchbutton_Reversal = ExcelData.get("financial_Year_Searchbutton_Reversal");
//	public static String financial_Year_Filter = ExcelData.get("financial_Year_Filter");
}
