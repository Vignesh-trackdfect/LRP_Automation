package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Customer_Statement_Report_Locators{

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Customer_Statement_Report", "Reference_Name", Testcases.environmentName);

	public static String customer_Statement_Invoice_Type_Dropdown = ExcelData.get("customer_Statement_Invoice_Type_Dropdown");
	public static String customer_Statement_Invoice_Type_Select = ExcelData.get("customer_Statement_Invoice_Type_Select");
	public static String customer_statement_Charge_Type_Dropdown = ExcelData.get("customer_statement_Charge_Type_Dropdown");
	public static String DropDown_Select = ExcelData.get("DropDown_Select");
	public static String customer_statement_Scope_Select = ExcelData.get("customer_statement_Scope_Select");
	public static String customer_Statement_Report_Scope_Plus_Button = ExcelData.get("customer_Statement_Report_Scope_Plus_Button");
	public static String customer_Statement_Radio_Button = ExcelData.get("customer_Statement_Radio_Button");
	public static String customer_Group_Name_Search_Button = ExcelData.get("customer_Group_Name_Search_Button");
	public static String customer_Group_Plus_button = ExcelData.get("customer_Group_Plus_button");
	public static String Service_Search_Button = ExcelData.get("Service_Search_Button");
	public static String Vessel_Search_Button = ExcelData.get("Vessel_Search_Button");
	public static String Voyage_Search_Button = ExcelData.get("Voyage_Search_Button");
	public static String port_Search_Button = ExcelData.get("port_Search_Button");
	public static String BL_Plus_Button = ExcelData.get("BL_Plus_Button");
	public static String customer_Statement_From_Date = ExcelData.get("customer_Statement_From_Date");
	public static String customer_Statement_To_Date = ExcelData.get("customer_Statement_To_Date");
	public static String input_Selection_Radio_Button = ExcelData.get("input_Selection_Radio_Button");
	public static String Aging_Bucket_CheckBox = ExcelData.get("Aging_Bucket_CheckBox");
	public static String summary_CheckBox = ExcelData.get("summary_CheckBox");
	public static String customer_Statement_show_Button = ExcelData.get("customer_Statement_show_Button");
	public static String customer_Statement_total_Records = ExcelData.get("customer_Statement_total_Records");
	public static String by_Select_Option = ExcelData.get("by_Select_Option");
	public static String MoreOption_Grid = ExcelData.get("MoreOption_Grid");
	public static String Download_Excel_Xlsx = ExcelData.get("Download_Excel_Xlsx");
	public static String FilterOption_Menu = ExcelData.get("FilterOption_Menu");
	public static String report_type_cd = ExcelData.get("report_type_cd");
	public static String shipment_type_cd = ExcelData.get("shipment_type_cd");
	public static String reportType_Dropdown = ExcelData.get("reportType_Dropdown");
	public static String reportType_Dropdown_Options = ExcelData.get("reportType_Dropdown_Options");
	public static String service_Search_CDR = ExcelData.get("service_Search_CDR");
	public static String vessel_Search_CDR = ExcelData.get("vessel_Search_CDR");
	public static String voyage_Search_CDR = ExcelData.get("voyage_Search_CDR");
	public static String port_Search_CDR = ExcelData.get("port_Search_CDR");
	public static String export_search = ExcelData.get("export_search");
	public static String eport_dp = ExcelData.get("eport_dp");
	public static String eport_number = ExcelData.get("eport_number");
	public static String eport_service = ExcelData.get("eport_service");
	public static String import_invoice_inv_text = ExcelData.get("import_invoice_inv_text");
	public static String invoice_inv_text = ExcelData.get("invoice_inv_text");
	public static String invoice_pop = ExcelData.get("invoice_pop");
	public static String import_invoice_dp = ExcelData.get("import_invoice_dp");
	public static String customer_statement_Table = ExcelData.get("customer_statement_Table");
	public static String condition_filter_customer_statement = ExcelData.get("condition_filter_customer_statement");
	public static String horizontal_scroll = ExcelData.get("horizontal_scroll");
	public static String invoice_num_TF = ExcelData.get("invoice_num_TF");

	public static String By_Group_Radio_Button = ExcelData.get("By_Group_Radio_Button");
	public static String Tool_Pannel_CSR = ExcelData.get("Tool_Pannel_CSR");
	public static String Excel_Button = ExcelData.get("Excel_Button");
	public static String By_Customer_Radio_Button = ExcelData.get("By_Customer_Radio_Button");
	public static String By_Service_Radio_Button = ExcelData.get("By_Service_Radio_Button");
	public static String By_BL_Radio_Button = ExcelData.get("By_BL_Radio_Button");
	public static String By_Date_Radio_Button = ExcelData.get("By_Date_Radio_Button");
	public static String AG_Grid_Columns_CSR = ExcelData.get("AG_Grid_Columns_CSR");
	public static String Receipt_No_FilterInput_CSR = ExcelData.get("Receipt_No_FilterInput_CSR");
	public static String AG_Headers_Filter_Input_CSR = ExcelData.get("AG_Headers_Filter_Input_CSR");
	public static String SelectAll_CheckBox_CSR = ExcelData.get("SelectAll_CheckBox_CSR");
}
