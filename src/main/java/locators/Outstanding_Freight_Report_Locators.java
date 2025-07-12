package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Outstanding_Freight_Report_Locators  {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Outstanding_Freight_Report", "Reference_Name",
			Testcases.environmentName);
	
	public static String DropDown_Select = ExcelData.get("DropDown_Select");
	public static String ofr_Selection = ExcelData.get("ofr_Selection");
	public static String ofr_Invoice_Type = ExcelData.get("ofr_Invoice_Type");
	public static String ofr_Charge_Type = ExcelData.get("ofr_Charge_Type");
	public static String ofr_Scope = ExcelData.get("ofr_Scope");
	public static String ofr_Show_Button = ExcelData.get("ofr_Show_Button");
	public static String ofr_Invoice_Date = ExcelData.get("ofr_Invoice_Date");
	public static String ofr_Aging_Days = ExcelData.get("ofr_Aging_Days");
	public static String ofr_Customer_Search_Button = ExcelData.get("ofr_Customer_Search_Button");
	public static String ofr_Service_Search_Button = ExcelData.get("ofr_Service_Search_Button");
	public static String ofr_Voyage_Search_Button = ExcelData.get("ofr_Voyage_Search_Button");
	public static String ofr_Terminal_Search_Button = ExcelData.get("ofr_Terminal_Search_Button");
	public static String ofr_Vessel_Search_Button = ExcelData.get("ofr_Vessel_Search_Button");
	public static String ofr_Port_Search_Button = ExcelData.get("ofr_Port_Search_Button");
	public static String ofr_Scope_Plus_Button = ExcelData.get("ofr_Scope_Plus_Button");
	public static String Total_RecordInput = ExcelData.get("Total_RecordInput");
	public static String OFR_Date_Select_Input = ExcelData.get("OFR_Date_Select_Input");
	public static String OFR_Show_Button = ExcelData.get("OFR_Show_Button");
	public static String OFR_GridTable = ExcelData.get("OFR_GridTable");
	public static String OFR_Grid_Row = ExcelData.get("OFR_Grid_Row");
	public static String ofr_Invoice_No_Filter = ExcelData.get("ofr_Invoice_No_Filter");
	public static String bl_PLA = ExcelData.get("bl_PLA");
	public static String bl_POL = ExcelData.get("bl_POL");
	public static String bl_POD = ExcelData.get("bl_POD");
	public static String bl_PLD = ExcelData.get("bl_PLD");
	public static String bl_MCN_Approved_Value = ExcelData.get("bl_MCN_Approved_Value");

}
