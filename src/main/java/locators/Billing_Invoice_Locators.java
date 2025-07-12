package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Billing_Invoice_Locators{
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Billing_Invoice", "Reference_Name", Testcases.environmentName);

	public static String billing_invoice_click = ExcelData.get("billing_invoice_click");
	public static String billing_invoice_activity_date = ExcelData.get("billing_invoice_activity_date");
	public static String billing_invoice_invoice_date = ExcelData.get("billing_invoice_invoice_date");
	public static String billing_invoice_Due_date = ExcelData.get("billing_invoice_Due_date");
	public static String billing_customer_search_button = ExcelData.get("billing_customer_search_button");
	public static String billing_customer_name_input = ExcelData.get("billing_customer_name_input");
	public static String billing_Dr_cr_droupdwn = ExcelData.get("billing_Dr_cr_droupdwn");
	public static String select_dr = ExcelData.get("select_dr");
	public static String select_cr = ExcelData.get("select_cr");
	public static String nomination_search = ExcelData.get("nomination_search");
	public static String nominal_amount_field = ExcelData.get("nominal_amount_field");
	public static String currency_search = ExcelData.get("currency_search");
	public static String currency_input = ExcelData.get("currency_input");
	public static String Gird_add_button = ExcelData.get("Gird_add_button");
	public static String vendor_search_ok = ExcelData.get("vendor_search_ok");
	public static String open_peroid = ExcelData.get("open_peroid");
	public static String service_code_input = ExcelData.get("service_code_input");
	public static String vessel_code_input = ExcelData.get("vessel_code_input");
	public static String port_orgin_input = ExcelData.get("port_orgin_input");
	public static String billing_pop = ExcelData.get("billing_pop");
	public static String trans_number = ExcelData.get("trans_number");
	public static String Home_amount = ExcelData.get("Home_amount");
	public static String accountTransElements1 = ExcelData.get("accountTransElements1");
	public static String select_First_Row = ExcelData.get("select_First_Row");
	public static String customer_Checkbox = ExcelData.get("customer_Checkbox");
	public static String billing_popup = ExcelData.get("billing_popup");
	public static String open_period = ExcelData.get("open_period");
	public static String navigate_Button_First_BI = ExcelData.get("navigate_Button_First_BI");
	public static String navigate_Next_Button_BI = ExcelData.get("navigate_Next_Button_BI");
	public static String navigate_Previous_Button_BI = ExcelData.get("navigate_Previous_Button_BI");
	public static String navigate_Button_Last_BI = ExcelData.get("navigate_Button_Last_BI");
	public static String global_search_1 = ExcelData.get("global_search_1");
	public static String global_search_11 = ExcelData.get("global_search_11");
	public static String global_search_2 = ExcelData.get("global_search_2");
	public static String global_search_3 = ExcelData.get("global_search_3");
	public static String global_search_list = ExcelData.get("global_search_list");
	public static String mainLineVessel_CheckBox = ExcelData.get("mainLineVessel_CheckBox");
	public static String mainLineVoyageBound_CheckBox = ExcelData.get("mainLineVoyageBound_CheckBox");
	public static String location_PortOfOrigin_CheckBox = ExcelData.get("location_PortOfOrigin_CheckBox");
	public static String agency_CheckBox = ExcelData.get("agency_CheckBox");
	public static String financialCategory_CheckBox = ExcelData.get("financialCategory_CheckBox");
	public static String retrieved_Value_select = ExcelData.get("retrieved_Value_select");
	public static String agency_BTN_Jnl = ExcelData.get("agency_BTN_Jnl");
	public static String billOfLading_SearchButton_BL = ExcelData.get("billOfLading_SearchButton_BL");
	public static String mainLineService_SearchButton_BL = ExcelData.get("mainLineService_SearchButton_BL");
	public static String mainLineVessel_SearchButton_BL = ExcelData.get("mainLineVessel_SearchButton_BL");
	public static String mainLineVoyageBound_SearchButton_BL = ExcelData.get("mainLineVoyageBound_SearchButton_BL");
	public static String location_PortOfOrigin_SearchButton_BL = ExcelData.get("location_PortOfOrigin_SearchButton_BL");
	public static String agency_SearchButton_BL = ExcelData.get("agency_SearchButton_BL");
	public static String firstService_SearchButton_BL = ExcelData.get("firstService_SearchButton_BL");
	public static String firstVessel_SearchButton_BL = ExcelData.get("firstVessel_SearchButton_BL");
	public static String firstVoyage_Bound_SearchButton1 = ExcelData.get("firstVoyage_Bound_SearchButton1");
	public static String location_Port_Of_Discharge_SearchButton_BL = ExcelData.get("location_Port_Of_Discharge_SearchButton_BL");
	public static String depot_CFS_Terminal_SearchButton_BL = ExcelData.get("depot_CFS_Terminal_SearchButton_BL");
	public static String eqpType_SearchButton_BL = ExcelData.get("eqpType_SearchButton_BL");
	public static String vendor_SearchButton_BL = ExcelData.get("vendor_SearchButton_BL");
	public static String employee_SearchButton_BL = ExcelData.get("employee_SearchButton_BL");
	public static String departments_SearchButton_BL = ExcelData.get("departments_SearchButton_BL");
	public static String fuelGrade_SearchButton_BL = ExcelData.get("fuelGrade_SearchButton_BL");
	public static String lastVessel_SearchButton_BL = ExcelData.get("lastVessel_SearchButton_BL");
	public static String contractNumber_SearchButton_BL = ExcelData.get("contractNumber_SearchButton_BL");
	public static String interCompanyCodes_SearchButton_BL = ExcelData.get("interCompanyCodes_SearchButton_BL");
	public static String fuelType_SearchButton_BL = ExcelData.get("fuelType_SearchButton_BL");
	public static String flowElement_SearchButton_BL = ExcelData.get("flowElement_SearchButton_BL");
	public static String financialCategory_SearchButton_BL = ExcelData.get("financialCategory_SearchButton_BL");
	public static String svm_SearchButton_BL = ExcelData.get("svm_SearchButton_BL");
	public static String taxCode_SearchButton_BL = ExcelData.get("taxCode_SearchButton_BL");
	public static String lastService_SearchButton_BL = ExcelData.get("lastService_SearchButton_BL");
	public static String lastVoyage_Bound_SearchButton_BL = ExcelData.get("lastVoyage_Bound_SearchButton_BL");
	public static String customerSearchButton1 = ExcelData.get("customerSearchButton1");
	public static String vendor_search = ExcelData.get("vendor_search");
	public static String billing_Discription_input = ExcelData.get("billing_Discription_input");
	public static String first_line_bound_search = ExcelData.get("first_line_bound_search");
	public static String last_service_search = ExcelData.get("last_service_search");
	public static String last_voyage_bound_search = ExcelData.get("last_voyage_bound_search");
	public static String location_port_orgin_search = ExcelData.get("location_port_orgin_search");
	public static String billing_conform = ExcelData.get("billing_conform");
	public static String Bill_agency_CheckBox_Jnl = ExcelData.get("Bill_agency_CheckBox_Jnl");

		
		
// Un used	
//		public static String retrieved_Value_select="retrieved_Value_select>//table[@id='nfr_sch_jdlg_form-nfr_sch_jd_pnl']//div[@ref='eCenterColsClipper']//div[@role='row']";
//		public static String ID_Popup_Ok_Button1 = "ID_Popup_Ok_Button>//span[text()='This is not an InterCompany Customer']//following::button";
//		public static String ID_Popup_Ok_Button2 = "ID_Popup_Ok_Button>//span[text()='This is not an InterCompany Vendor']//following::button[1]";
//		public static String ID_Popup_Ok_Button3 = "ID_Popup_Ok_Button>//span[text()='This is not an InterCompany Customer']//following::button[1]";
//      public static String okButton_AddElements1 = "okButton_AddElements>//button[@id='RBK_applyadd']";		
//		public static String vendor_box_search="vendor_box_search>//label[text()='Vendor']//following::button[contains(@id,'RBK_solverBtn')][1]";
//		public static String bill_of_lading="bill_of_lading>//label[text()='Bill of lading']//following::button[contains(@id,'RBK_solverBtn')][1]";	
//		public static String main_line_vessels_search="main_line_vessels_search>//label[text()='Main Line Vessel']//following::button[contains(@id,'RBK_solverBtn')][1]";
//		public static String main_line_bound_search="main_line_bound_search>//label[text()='Main Line Voyage/Bound']//following::button[contains(@id,'RBK_solverBtn')][1]";
//		public static String main_line_bound_input="main_line_bound_input>//input[@aria-label='Voyage/Bound Code Filter Input']";
//		public static String first_service_search="first_service_search>//label[text()='First Service']//following::button[contains(@id,'RBK_solverBtn')][1]";
//		public static String first_vessels_search="first_vessels_search>//label[text()='First Vessel']//following::button[contains(@id,'RBK_solverBtn')][1]";	
//		public static String customer_search_box="customer_search_box>//label[text()='Customer']//following::button[contains(@id,'RBK_solverBtn')][1]";	
//		public static String billing_invoice_new_button="billing_invoice_new_button>//button[@id='RBK-tbl-btnTblNew']";
//		public static String billing_invoice_search_button="billing_invoice_search_button>//button[@id='RBK-tbl-btnTblJdlgSearch']";
//		public static String billing_invoice_save_button="billing_invoice_save_button>//button[@id='RBK-tbl-btnsave']";
//		public static String billing_invoice_edit_button="billing_invoice_edit_button>//button[@id='RBK-tbl-btnTblEdit']";
//		public static String billing_invoice_delete_button="billing_invoice_delete_button>//button[@id='RBK-tbl-btnTblDelete']";	
	
	
}
