package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Work_Order_Creation_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Work_Order_Creation",
			"Reference_Name", Testcases.environmentName);
	
	public static String feederRadio_Button = ExcelData.get("feederRadio_Button");
	public static String loadPort_Searchfield = ExcelData.get("loadPort_Searchfield");
	public static String dischPort_Searchfield = ExcelData.get("dischPort_Searchfield");
	public static String routing_Button = ExcelData.get("routing_Button");
	public static String routingDetailsSearch_Frame = ExcelData.get("routingDetailsSearch_Frame");
	public static String service_Filter = ExcelData.get("service_Filter");
	public static String select_FirstRouting = ExcelData.get("select_FirstRouting");
	public static String vesselSearch_Button = ExcelData.get("vesselSearch_Button");
	public static String voyageSearch_Button = ExcelData.get("voyageSearch_Button");
	public static String first_Row_Col2 = ExcelData.get("first_Row_Col2");
	public static String polTerminal_SearchButton = ExcelData.get("polTerminal_SearchButton");
	public static String vendor_SearchButton = ExcelData.get("vendor_SearchButton");
	public static String eqpType_SearchButton = ExcelData.get("eqpType_SearchButton");
	public static String quantity_Textfield = ExcelData.get("quantity_Textfield");
	public static String plus_Icon = ExcelData.get("plus_Icon");
	public static String container_WOC = ExcelData.get("container_WOC");
	public static String containerGrid_Edit = ExcelData.get("containerGrid_Edit");
	public static String smartImport_Button = ExcelData.get("smartImport_Button");
	public static String paste_Button = ExcelData.get("paste_Button");
	public static String workOrderNo_Textfield = ExcelData.get("workOrderNo_Textfield");
	public static String approved_RadioButton = ExcelData.get("approved_RadioButton");
	public static String podTerminal_SearchButton = ExcelData.get("podTerminal_SearchButton");

}
