package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Supplier_Invoice_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Supplier_Invoice",
			"Reference_Name", Testcases.environmentName);
	public static String supplier_income_click = ExcelData.get("supplier_income_click");
	public static String supplier_income_new_btn = ExcelData.get("supplier_income_new_btn");
	public static String supplier_invoice_search_button = ExcelData.get("supplier_invoice_search_button");
	public static String supplier_invoice_save_button = ExcelData.get("supplier_invoice_save_button");
	public static String supplier_invoice_edit_button = ExcelData.get("supplier_invoice_edit_button");
	public static String supplier_Invoice_Cancel_Button = ExcelData.get("supplier_Invoice_Cancel_Button");
	public static String supplier_invoice_delete_button = ExcelData.get("supplier_invoice_delete_button");
	public static String supplier_invoice_activity_date = ExcelData.get("supplier_invoice_activity_date");
	public static String supplier_invoice_invoice_date = ExcelData.get("supplier_invoice_invoice_date");
	public static String supplier_invoice_Due_date = ExcelData.get("supplier_invoice_Due_date");
	public static String supplier_customer_search_button = ExcelData.get("supplier_customer_search_button");
	public static String SupplierInv_input = ExcelData.get("SupplierInv_input");
	public static String Supplier_vendor_search_button = ExcelData.get("Supplier_vendor_search_button");
	public static String Supplier_vendor_search_input = ExcelData.get("Supplier_vendor_search_input");
	public static String Supplier_open_peroid = ExcelData.get("Supplier_open_peroid");
	public static String Supplier_Discription_input = ExcelData.get("Supplier_Discription_input");
	public static String Supplier_Dr_cr_droupdwn = ExcelData.get("Supplier_Dr_cr_droupdwn");
	public static String Supplier_nomination_search = ExcelData.get("Supplier_nomination_search");
	public static String Supplier_currency_search = ExcelData.get("Supplier_currency_search");
	public static String Supplier_amount_field = ExcelData.get("Supplier_amount_field");
	public static String Supplier_Gird_add_button = ExcelData.get("Supplier_Gird_add_button");
	public static String Home_amount1 = ExcelData.get("Home_amount1");
	public static String Supplier_Area_search = ExcelData.get("Supplier_Area_search");
	public static String Supplier_Area_input = ExcelData.get("Supplier_Area_input");
	public static String Supplier_payment_search = ExcelData.get("Supplier_payment_search");
	public static String Supplier_payment_input = ExcelData.get("Supplier_payment_input");
	public static String Supplier_factor_payee_search = ExcelData.get("Supplier_factor_payee_search");
	public static String Supplier_factor_payee_input = ExcelData.get("Supplier_factor_payee_input");
	public static String accountTransElements11 = ExcelData.get("accountTransElements11");
	public static String vendor_search_ok1 = ExcelData.get("vendor_search_ok1");
	public static String supplier_trans_number = ExcelData.get("supplier_trans_number");
	public static String supplier_pop = ExcelData.get("supplier_pop");
	public static String supplier_conform = ExcelData.get("supplier_conform");
	public static String ID_Popup_Ok_Button1 = ExcelData.get("ID_Popup_Ok_Button1");
	public static String ID_Popup_Ok_Button2 = ExcelData.get("ID_Popup_Ok_Button2");
	public static String ID_Popup_Ok_Button3 = ExcelData.get("ID_Popup_Ok_Button3");
	public static String billOfLading_SearchButton_BL1 = ExcelData.get("billOfLading_SearchButton_BL1");
	public static String mainLineService_SearchButton_BL1 = ExcelData.get("mainLineService_SearchButton_BL1");
	public static String mainLineVessel_SearchButton_BL1 = ExcelData.get("mainLineVessel_SearchButton_BL1");
	public static String mainLineVoyageBound_SearchButton_BL1 = ExcelData.get("mainLineVoyageBound_SearchButton_BL1");
	public static String location_PortOfOrigin_SearchButton_BL1 = ExcelData.get("location_PortOfOrigin_SearchButton_BL1");
	public static String agency_SearchButton_BL1 = ExcelData.get("agency_SearchButton_BL1");
	public static String firstService_SearchButton_BL1 = ExcelData.get("firstService_SearchButton_BL1");
	public static String firstVessel_SearchButton_BL1 = ExcelData.get("firstVessel_SearchButton_BL1");
	public static String firstVoyage_Bound_SearchButton11 = ExcelData.get("firstVoyage_Bound_SearchButton11");
	public static String location_Port_Of_Discharge_SearchButton_BL1 = ExcelData.get("location_Port_Of_Discharge_SearchButton_BL1");
	public static String depot_CFS_Terminal_SearchButton_BL1 = ExcelData.get("depot_CFS_Terminal_SearchButton_BL1");
	public static String eqpType_SearchButton_BL1 = ExcelData.get("eqpType_SearchButton_BL1");
	public static String vendor_SearchButton_BL1 = ExcelData.get("vendor_SearchButton_BL1");
	public static String employee_SearchButton_BL1 = ExcelData.get("employee_SearchButton_BL1");
	public static String departments_SearchButton_BL1 = ExcelData.get("departments_SearchButton_BL1");
	public static String fuelGrade_SearchButton_BL1 = ExcelData.get("fuelGrade_SearchButton_BL1");
	public static String lastVessel_SearchButton_BL1 = ExcelData.get("lastVessel_SearchButton_BL1");
	public static String contractNumber_SearchButton_BL1 = ExcelData.get("contractNumber_SearchButton_BL1");
	public static String interCompanyCodes_SearchButton_BL1 = ExcelData.get("interCompanyCodes_SearchButton_BL1");
	public static String fuelType_SearchButton_BL1 = ExcelData.get("fuelType_SearchButton_BL1");
	public static String flowElement_SearchButton_BL1 = ExcelData.get("flowElement_SearchButton_BL1");
	public static String financialCategory_SearchButton_BL1 = ExcelData.get("financialCategory_SearchButton_BL1");
	public static String svm_SearchButton_BL1 = ExcelData.get("svm_SearchButton_BL1");
	public static String taxCode_SearchButton_BL1 = ExcelData.get("taxCode_SearchButton_BL1");
	public static String lastService_SearchButton_BL1 = ExcelData.get("lastService_SearchButton_BL1");
	public static String lastVoyage_Bound_SearchButton_BL1 = ExcelData.get("lastVoyage_Bound_SearchButton_BL1");
	public static String customerSearchButton11 = ExcelData.get("customerSearchButton11");
	public static String navigate_Button_First_SI = ExcelData.get("navigate_Button_First_SI");
	public static String navigate_Next_Button_SI = ExcelData.get("navigate_Next_Button_SI");
	public static String navigate_Previous_Button_SI = ExcelData.get("navigate_Previous_Button_SI");
	public static String navigate_Button_Last_SI = ExcelData.get("navigate_Button_Last_SI");
	public static String reference_Text_Field_SI = ExcelData.get("reference_Text_Field_SI");
	public static String Doc_Agency = ExcelData.get("Doc_Agency");
	public static String Profile_Dropdown = ExcelData.get("Profile_Dropdown");
	public static String Corporate_Profile = ExcelData.get("Corporate_Profile");
	public static String Location_Profile = ExcelData.get("Location_Profile");
	public static String reset_Profile_Button = ExcelData.get("reset_Profile_Button");
	public static String Module_Select = ExcelData.get("Module_Select");
	public static String first_row = ExcelData.get("first_row");
	public static String SI_agency_CheckBox_Jnl = ExcelData.get("SI_agency_CheckBox_Jnl");

	public static String SI_Refernce_Input = ExcelData.get("SI_Refernce_Input");


}
