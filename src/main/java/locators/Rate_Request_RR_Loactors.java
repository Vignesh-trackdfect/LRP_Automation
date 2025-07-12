package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Rate_Request_RR_Loactors {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Rate_Request_RR", "Reference_Name", Testcases.environmentName);
	
	public static String RR_New_btn = ExcelData.get("RR_New_btn");
	public static String RR_CustomerName = ExcelData.get("RR_CustomerName");
	public static String RR_Auto_Panel_First = ExcelData.get("RR_Auto_Panel_First");
	public static String RR_Fmc = ExcelData.get("RR_Fmc");
	public static String RR_Containerised = ExcelData.get("RR_Containerised");
	public static String RR_N_Fmc = ExcelData.get("RR_N_Fmc");
	public static String RR_NonContainerised = ExcelData.get("RR_NonContainerised");
	public static String RR_Exit = ExcelData.get("RR_Exit");
	public static String RR_Internal_Commodity = ExcelData.get("RR_Internal_Commodity");
	public static String RR_Commodity_val = ExcelData.get("RR_Commodity_val");
	public static String RR_Internal_Commodity_add = ExcelData.get("RR_Internal_Commodity_add");
	public static String RR_Req_Type = ExcelData.get("RR_Req_Type");
	public static String RR_Req_Type_Dropdown = ExcelData.get("RR_Req_Type_Dropdown");
	public static String RR_Eqp_Search = ExcelData.get("RR_Eqp_Search");
	public static String RR_Origin_search = ExcelData.get("RR_Origin_search");
	public static String RR_Delivery_search = ExcelData.get("RR_Delivery_search");
	public static String RR_Pricing_offer = ExcelData.get("RR_Pricing_offer");
	public static String RR_Add_btn = ExcelData.get("RR_Add_btn");
	public static String RR_Remove_btn = ExcelData.get("RR_Remove_btn");
	public static String RR_Submit_btn = ExcelData.get("RR_Submit_btn");
	public static String RR_Edit = ExcelData.get("RR_Edit");
	public static String RR_Approve_Btn = ExcelData.get("RR_Approve_Btn");
	public static String RR_Remarks = ExcelData.get("RR_Remarks");
	public static String RR_Remark_Okbtn = ExcelData.get("RR_Remark_Okbtn");
	public static String RR_Save_Btn = ExcelData.get("RR_Save_Btn");
	public static String RR_Promote_btn = ExcelData.get("RR_Promote_btn");
	public static String RR_Move_To_CMS_Btn = ExcelData.get("RR_Move_To_CMS_Btn");
	public static String RR_Move_To_CMS_New_Cont = ExcelData.get("RR_Move_To_CMS_New_Cont");
	public static String RR_move_okbtn = ExcelData.get("RR_move_okbtn");
	public static String RR_Request_No = ExcelData.get("RR_Request_No");
	public static String RR_Valied_from = ExcelData.get("RR_Valied_from");
	public static String RR_Valied_to = ExcelData.get("RR_Valied_to");
	public static String RR_Add_Dimensions = ExcelData.get("RR_Add_Dimensions");
	
	public static String RR_Gr_wt = ExcelData.get("RR_Gr_wt");
	public static String RR_Length = ExcelData.get("RR_Length");
	public static String RR_Width = ExcelData.get("RR_Width");
	public static String RR_Height = ExcelData.get("RR_Height");
	public static String RR_Quantity  = ExcelData.get("RR_Quantity");
	public static String RR_Add_Dimensions_add = ExcelData.get("RR_Add_Dimensions_add");
	public static String RR_Add_Dimensions_add_ok = ExcelData.get("RR_Add_Dimensions_add_ok");
	public static String RR_Add_Dimensions_add_package_Description_input = ExcelData.get("RR_Add_Dimensions_add_package_Description_input");
	public static String RR_Add_Dimensions_add_package_Description = ExcelData.get("RR_Add_Dimensions_add_package_Description");
	public static String RR_RateCalc_Type = ExcelData.get("RR_RateCalc_Type");
	public static String RR_Origin_select = ExcelData.get("RR_Origin_select");
	public static String RR_Surcharge_Rule_tab = ExcelData.get("RR_Surcharge_Rule_tab");
	public static String RR_Surcharge_charge_Serach = ExcelData.get("RR_Surcharge_charge_Serach");
	public static String RR_Surcharge_Rule_Select = ExcelData.get("RR_Surcharge_Rule_Select");
	public static String RR_Surcharge_Rule_Ratecalc = ExcelData.get("RR_Surcharge_Rule_Ratecalc");
	public static String RR_Surcharge_Rule_Amount = ExcelData.get("RR_Surcharge_Rule_Amount");
	public static String RR_Surcharge_Rule_Addbtn = ExcelData.get("RR_Surcharge_Rule_Addbtn");
	
	
	public static String R_Req_Type_Dropdown_select = ExcelData.get("R_Req_Type_Dropdown_select");
	public static String RR_amdno_reftab = ExcelData.get("RR_amdno_reftab");
	public static String RR_ratereference_tab = ExcelData.get("RR_ratereference_tab");
	public static String RR_raterequestno_reftab = ExcelData.get("RR_raterequestno_reftab");
	public static String RR_contractno_searchbar = ExcelData.get("RR_contractno_searchbar");

	
	
	//
}
