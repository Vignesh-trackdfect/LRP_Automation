package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Haulage_Contract_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Haulage_Contract", "Reference_Name", Testcases.environmentName);

	
	public static String Vendor_Search_Button = ExcelData.get("Vendor_Search_Button");
	public static String Vendor_code_Field = ExcelData.get("Vendor_code_Field");
	public static String HC_Plus_Button = ExcelData.get("HC_Plus_Button");
	public static String HC_Haulage_Contract_Input_Page = ExcelData.get("HC_Haulage_Contract_Input_Page");
	public static String HC_Pickup_Location_Search_Button = ExcelData.get("HC_Pickup_Location_Search_Button");
	public static String HC_Pickup_Location_Field = ExcelData.get("HC_Pickup_Location_Field");
	public static String HC_Pickup_Type_Dropdown = ExcelData.get("HC_Pickup_Type_Dropdown");
	public static String HC_Pickup_Terminal_Search_Button = ExcelData.get("HC_Pickup_Terminal_Search_Button");
	public static String HC_Drop_Location_Search_Button = ExcelData.get("HC_Drop_Location_Search_Button");
	public static String HC_drop_Type_Dropdown = ExcelData.get("HC_drop_Type_Dropdown");
	public static String HC_drop_Terminal_search_Button = ExcelData.get("HC_drop_Terminal_search_Button");
	public static String HC_Equipment_select = ExcelData.get("HC_Equipment_select");
	public static String HC_LDN_MTY_Select = ExcelData.get("HC_LDN_MTY_Select");
	public static String Hc_Drop_Loc_Search_Button = ExcelData.get("Hc_Drop_Loc_Search_Button");
	public static String Hc_Vendor_Code_Input_details = ExcelData.get("Hc_Vendor_Code_Input_details");
	public static String HC_Vendor_Name_Field = ExcelData.get("HC_Vendor_Name_Field");
	public static String HC_Vendor_Name_Input_Details = ExcelData.get("HC_Vendor_Name_Input_Details");
	public static String HC_PickUp_Term = ExcelData.get("HC_PickUp_Term");
	public static String HC_Drop_Term = ExcelData.get("HC_Drop_Term");
	public static String HC_From_Date = ExcelData.get("HC_From_Date");
	public static String HC_To_Date = ExcelData.get("HC_To_Date");
	public static String HC_Pickup_Term_List = ExcelData.get("HC_Pickup_Term_List");
	public static String HC_H_Mode = ExcelData.get("HC_H_Mode");
	public static String HC_Trip_Types = ExcelData.get("HC_Trip_Types");
	public static String HC_Neg_on_date = ExcelData.get("HC_Neg_on_date");
	public static String HC_Neg_by_Input = ExcelData.get("HC_Neg_by_Input");
	public static String HC_Amount_Select = ExcelData.get("HC_Amount_Select");
	public static String HC_Amount_Input = ExcelData.get("HC_Amount_Input");
	public static String HC_Currency_Search = ExcelData.get("HC_Currency_Search");
	public static String HC_Tab_Ok_Button = ExcelData.get("HC_Tab_Ok_Button");
	public static String HC_Add_Gird_Table = ExcelData.get("HC_Add_Gird_Table");
	public static String HC_Copy_Button = ExcelData.get("HC_Copy_Button");
	public static String HC_Paste_Button = ExcelData.get("HC_Paste_Button");
	public static String HC_Equipment_Type_Select_Checkbox = ExcelData.get("HC_Equipment_Type_Select_Checkbox");
	public static String HC_Equipment_Type_select_Ok_Button = ExcelData.get("HC_Equipment_Type_select_Ok_Button");
	public static String HC_Grid_Row = ExcelData.get("HC_Grid_Row");
	public static String HC_Discharge_Add_Button = ExcelData.get("HC_Discharge_Add_Button");
	public static String HC_Surcharge_Grid_Value = ExcelData.get("HC_Surcharge_Grid_Value");
	public static String HC_Remove_surcharge_Button = ExcelData.get("HC_Remove_surcharge_Button");
	public static String HC_Approve_Button = ExcelData.get("HC_Approve_Button");
	public static String HC_Reject_Button = ExcelData.get("HC_Reject_Button");
	public static String HC_Remove_Button = ExcelData.get("HC_Remove_Button");
	public static String HC_show_All_Radio_Button = ExcelData.get("HC_show_All_Radio_Button");
	public static String HC_Import_Excel_Button = ExcelData.get("HC_Import_Excel_Button");
	public static String HC_Eqp_Behavier_click = ExcelData.get("HC_Eqp_Behavier_click");
	public static String HC_Apply_Charges_Button = ExcelData.get("HC_Apply_Charges_Button");
	public static String HC_Amount_Grid = ExcelData.get("HC_Amount_Grid");
	public static String HC_DG_Plus_Button = ExcelData.get("HC_DG_Plus_Button");
	public static String HC_DG_Amount_Gridcell_Textfield = ExcelData.get("HC_DG_Amount_Gridcell_Textfield");
	public static String HC_DG_Amount_Gridcell = ExcelData.get("HC_DG_Amount_Gridcell");
	public static String HC_DG_Apply_Button = ExcelData.get("HC_DG_Apply_Button");
	public static String HC_DG_Row_Class_Gridcell = ExcelData.get("HC_DG_Row_Class_Gridcell");
	public static String HC_show_Validity_Only_Radio_Button = ExcelData.get("HC_show_Validity_Only_Radio_Button");
	public static String HC_grid_Table = ExcelData.get("HC_grid_Table");
	public static String HC_Vendor_code_TF = ExcelData.get("HC_Vendor_code_TF");
	public static String HC_Vendor_code_Data = ExcelData.get("HC_Vendor_code_Data");
	public static String HC_Edit_Input_fields_Plus_Button = ExcelData.get("HC_Edit_Input_fields_Plus_Button");
	public static String HC_Edit_Pickup_Loc_search_Button = ExcelData.get("HC_Edit_Pickup_Loc_search_Button");
	public static String HC_Formula_Builder_Button = ExcelData.get("HC_Formula_Builder_Button");
	public static String HC_Pickup_Loc_Field = ExcelData.get("HC_Pickup_Loc_Field");
	public static String HC_SurchargeRowSelect = ExcelData.get("HC_SurchargeRowSelect");
	public static String HC_ChargeType_Dropdown = ExcelData.get("HC_ChargeType_Dropdown");
	public static String HC_Amount_Input_data = ExcelData.get("HC_Amount_Input_data");
	public static String HC_Edit_Pickup_Type = ExcelData.get("HC_Edit_Pickup_Type");
	public static String HC_Edit_Pickup_Terminal_Search_Button = ExcelData.get("HC_Edit_Pickup_Terminal_Search_Button");
	public static String HC_Edit_Drop_Location_Search_Button = ExcelData.get("HC_Edit_Drop_Location_Search_Button");
	public static String HC_Edit_Drop_Location_Field = ExcelData.get("HC_Edit_Drop_Location_Field");
	public static String HC_Edit_drop_Type_Dropdown = ExcelData.get("HC_Edit_drop_Type_Dropdown");
	public static String HC_Edit_Drop_Terminal_Search_Button = ExcelData.get("HC_Edit_Drop_Terminal_Search_Button");
	public static String HC_Edit_Equipment_Dropdown = ExcelData.get("HC_Edit_Equipment_Dropdown");
	public static String HC_Trip_Types_Dropdown = ExcelData.get("HC_Trip_Types_Dropdown");
	public static String HC_Currency_Dropdown = ExcelData.get("HC_Currency_Dropdown");
	public static String HC_LDN_MTY_Dropdown = ExcelData.get("HC_LDN_MTY_Dropdown");
	public static String HC_Pickup_Term_Dropdown = ExcelData.get("HC_Pickup_Term_Dropdown");
	public static String HC_Edit_Valid_From = ExcelData.get("HC_Edit_Valid_From");
	public static String HC_Edit_Valid_To = ExcelData.get("HC_Edit_Valid_To");
	public static String HC_Edit_H_Mode = ExcelData.get("HC_Edit_H_Mode");
	public static String HC_Edit_Drop_Term_Dropdown = ExcelData.get("HC_Edit_Drop_Term_Dropdown");
	public static String HC_grid_row = ExcelData.get("HC_grid_row");
	public static String HC_grid_Row_Amount = ExcelData.get("HC_grid_Row_Amount");
	public static String HC_Edit_Rate_Button = ExcelData.get("HC_Edit_Rate_Button");
	public static String HC_Edit_Rate_Option = ExcelData.get("HC_Edit_Rate_Option");
	public static String HC_Increase_By_Radio_Button = ExcelData.get("HC_Increase_By_Radio_Button");
	public static String HC_Increase_By_Percentage_TF = ExcelData.get("HC_Increase_By_Percentage_TF");
	public static String HC_Edit_Rate_ok_Button = ExcelData.get("HC_Edit_Rate_ok_Button");
	public static String HC_Increase_Rates_By_Number_TF = ExcelData.get("HC_Increase_Rates_By_Number_TF");
	public static String HC_Replace_Rates_By_Number_TF = ExcelData.get("HC_Replace_Rates_By_Number_TF");
	public static String HC_Drop_Location_Field = ExcelData.get("HC_Drop_Location_Field");
	public static String HC_Pickup_Search_Header = ExcelData.get("HC_Pickup_Search_Header");
	public static String HC_Pickup_Term_List_Inside = ExcelData.get("HC_Pickup_Term_List_Inside");
	public static String HC_Drop_Term_List = ExcelData.get("HC_Drop_Term_List");
	public static String HC_Drop_Term_List_Inside = ExcelData.get("HC_Drop_Term_List_Inside");
	public static String HC_Tab_Close = ExcelData.get("HC_Tab_Close");
	public static String HC_Contract_Team_Gird = ExcelData.get("HC_Contract_Team_Gird");
	public static String HC_Neg_by_Input_Value = ExcelData.get("HC_Neg_by_Input_Value");
	public static String HC_Pickup_Terminal = ExcelData.get("HC_Pickup_Terminal");
	public static String HC_Currency_Text = ExcelData.get("HC_Currency_Text");
	public static String Location_Search_Button = ExcelData.get("Location_Search_Button");
	public static String Payable_At_Others = ExcelData.get("Payable_At_Others");
	public static String Payable_At_Pod = ExcelData.get("Payable_At_Pod");
	public static String Payable_At_Pol = ExcelData.get("Payable_At_Pol");
	public static String HC_Table_Grid = ExcelData.get("HC_Table_Grid");
	public static String amount_Textfield_HC = ExcelData.get("amount_Textfield_HC");
	public static String currency_Textfield_HC = ExcelData.get("currency_Textfield_HC");
	public static String amount_Type_Dropdown_HC = ExcelData.get("amount_Type_Dropdown_HC");
	public static String currency_SearchButton_HC= ExcelData.get("currency_SearchButton_HC");
	public static String HC_Drop_Terminal= ExcelData.get("HC_Drop_Terminal");
	public static String HC_DG_Currency_Gridcell_Dropdown= ExcelData.get("HC_DG_Currency_Gridcell_Dropdown");
	public static String HC_DG_Currency_Gridcell= ExcelData.get("HC_DG_Currency_Gridcell");
	public static String HC_DG_ChargeType_Gridcell_Dropdown= ExcelData.get("HC_DG_ChargeType_Gridcell_Dropdown");
	public static String HC_DG_ChargeType_Gridcell= ExcelData.get("HC_DG_ChargeType_Gridcell");
	public static String HC_DG_Minus_Button= ExcelData.get("HC_DG_Minus_Button");
	public static String HC_DG_Empty_Row= ExcelData.get("HC_DG_Empty_Row");
	public static String HC_DGCharge_Grid_Value= ExcelData.get("HC_DGCharge_Grid_Value");
	public static String HC_Refresh_Button= ExcelData.get("HC_Refresh_Button");
	public static String HC_DG_remove_Button= ExcelData.get("HC_DG_remove_Button");
	public static String HC_Contarct_Number_Field= ExcelData.get("HC_Contarct_Number_Field");
	public static String HC_ADD_Haulage_Contract_text= ExcelData.get("HC_ADD_Haulage_Contract_text");
	public static String HC_ADD_Haulage_Contract= ExcelData.get("HC_ADD_Haulage_Contract");
	public static String HC_Paste_Number= ExcelData.get("HC_Paste_Number");
	public static String HC_New_Location_radio_Button= ExcelData.get("HC_New_Location_radio_Button");





































































	






















	
	
	

}
