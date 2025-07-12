package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Discharge_Recollination_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Discharge_Recollination", "Reference_Name", Testcases.environmentName);

	public static String BL_Number_Columns_DR = ExcelData.get("BL_Number_Columns_DR");
	public static String DisRecServiceInput = ExcelData.get("DisRecServiceInput");
	public static String Plan_Option = ExcelData.get("Plan_Option");
	public static String Plan_Option_Select = ExcelData.get("Plan_Option_Select");
	public static String Total_Records = ExcelData.get("Total_Records");
	public static String DR_Scroll = ExcelData.get("DR_Scroll");
	public static String Cargo_type_Value = ExcelData.get("Cargo_type_Value");
	public static String service_Searchfield_DRC = ExcelData.get("service_Searchfield_DRC");
	public static String download_BL_Button_DRC = ExcelData.get("download_BL_Button_DRC");
	public static String importDocumentation_Button_DRC = ExcelData.get("importDocumentation_Button_DRC");
	public static String service_Details_ScrollBar_DRC = ExcelData.get("service_Details_ScrollBar_DRC");
	public static String DisRecServiceInput_DRL = ExcelData.get("DisRecServiceInput_DRL");
	public static String Service_Searchfield_DRL = ExcelData.get("Service_Searchfield_DRL");
	public static String Download_BL_Button_DRL = ExcelData.get("Download_BL_Button_DRL");
	public static String ImportDocumentation_Button_DRL = ExcelData.get("ImportDocumentation_Button_DRL");
	public static String Total_Records_DR = ExcelData.get("Total_Records_DR");
	public static String BL_Numbers_Column_AG_Grid_DR = ExcelData.get("BL_Numbers_Column_AG_Grid_DR");

	
	
	////////////////////////
	
	public static String Summary_Button = ExcelData.get("Summary_Button");
	public static String Value_Get = ExcelData.get("Value_Get");
	public static String Non_Container_Button = ExcelData.get("Non_Container_Button");
	public static String Vessel_SearchField_Button = ExcelData.get("Vessel_SearchField_Button");
	public static String Service_Searchfield_Button = ExcelData.get("Service_Searchfield_Button");
	public static String Voyage_SearchField_Button = ExcelData.get("Voyage_SearchField_Button");
	public static String Port_SearchField_Button = ExcelData.get("Port_SearchField_Button");
	public static String Terminal_SearchField_Button = ExcelData.get("Terminal_SearchField_Button");
	public static String Load_Button = ExcelData.get("Load_Button");
	public static String Discharge_Button = ExcelData.get("Discharge_Button");
	public static String Row_Count = ExcelData.get("Row_Count");
	public static String Voyage_Count = ExcelData.get("Voyage_Count");
	public static String Mapped_bl = ExcelData.get("Mapped_bl");
	public static String Import_Button = ExcelData.get("Import_Button");
	public static String Switch_Discharge_Recon = ExcelData.get("Switch_Discharge_Recon");
	public static String Discharge_Value_select = ExcelData.get("Discharge_Value_select");
	public static String Bl_Number_input_re_con_row_click = ExcelData.get("Bl_Number_input_re_con_row_click");
	

	public static String Refresh_Btn_Dis = ExcelData.get("Refresh_Btn_Dis");
    public static String Text_Get_Yes_No = ExcelData.get("Text_Get_Yes_No");
    public static String Discharge_recon_cocloum_click = ExcelData.get("Discharge_recon_cocloum_click");
    public static String Column_Expand = ExcelData.get("Column_Expand");
    public static String Text_Get_Yes = ExcelData.get("Text_Get_Yes");
    public static String Count_Saved_Label = ExcelData.get("Count_Saved_Label");
    public static String Search_Field = ExcelData.get("Search_Field");
    public static String BL_Text = ExcelData.get("BL_Text");
    public static String Count_UnSaved_Label = ExcelData.get("Count_UnSaved_Label");
    public static String DR_Full_Grid = ExcelData.get("DR_Full_Grid");
    public static String System_BL_Input = ExcelData.get("System_BL_Input");
    
    public static String Equipment_MCN_field = ExcelData.get("Equipment_MCN_field");
    public static String Con_Summary_WithoutBL_Button = ExcelData.get("Con_Summary_WithoutBL_Button");
    public static String Book_Number_input_re_con_row_click = ExcelData.get("Book_Number_input_re_con_row_click");
    public static String Discharge_Recon_Close_Button = ExcelData.get("Discharge_Recon_Close_Button");
    public static String Grid_Discharge_W_O_Container_Field = ExcelData.get("Grid_Discharge_W_O_Container_Field");
    public static String Book_Number_input_re_con = ExcelData.get("Book_Number_input_re_con");
    public static String Con_Number_input_re_con_row_click = ExcelData.get("Con_Number_input_re_con_row_click");
    public static String Book_Number_W_O_row_click = ExcelData.get("Book_Number_W_O_row_click");
    //
    public static String Dis_Reset_Btn = ExcelData.get("Dis_Reset_Btn");
    public static String IGMGrid_records_Count = ExcelData.get("IGMGrid_records_Count");
    public static String Discharge_recon_IGMcocloum_click = ExcelData.get("Discharge_recon_IGMcocloum_click");
    public static String Discharge_recon_Short_Shipment_Btn = ExcelData.get("Discharge_recon_Short_Shipment_Btn");
    public static String shipment_Grid_select_Tble = ExcelData.get("shipment_Grid_select_Tble");
    public static String Shipment_Grid_Row_Count = ExcelData.get("Shipment_Grid_Row_Count");
    public static String Select_BL_Button_Operation = ExcelData.get("Select_BL_Button_Operation");
    public static String Dis_Shipment_Btn_Close = ExcelData.get("Dis_Shipment_Btn_Close");
    public static String Dis_Non_Container_Count = ExcelData.get("Dis_Non_Container_Count");
    public static String Dis_Recon_Grid_Row_Select = ExcelData.get("Dis_Recon_Grid_Row_Select");
    public static String Discharge_Grid_HBL_Select = ExcelData.get("Discharge_Grid_HBL_Select");
    public static String Dis_Grid_Row_Count = ExcelData.get("Dis_Grid_Row_Count");
	
	public static String Service_records_count_DR = ExcelData.get("Service_records_count_DR");
	public static String Pagesize_option_DR= ExcelData.get("Pagesize_option_DR");
	public static String Pagesize_option_select_DR = ExcelData.get("Pagesize_option_select_DR");
	public static String VesselTable_List_DR = ExcelData.get("VesselTable_List_DR");
	public static String Click_page2_DR = ExcelData.get("Click_page2_DR");
	public static String BLNumber_Header_DR= ExcelData.get("BLNumber_Header_DR");
	public static String MoreOption_Button_DR= ExcelData.get("MoreOption_Button_DR");
	public static String ExcelButton_DR= ExcelData.get("ExcelButton_DR");
	public static String BL_Column_DR= ExcelData.get("BL_Column_DR");
	
	public static String GridColumnCount_DR= ExcelData.get("GridColumnCount_DR");
	public static String GridHeaders_DR= ExcelData.get("GridHeaders_DR");
	public static String GridScroll_DR= ExcelData.get("GridScroll_DR");
	public static String Pagecount_DR= ExcelData.get("Pagecount_DR");
	public static String Total_records_count_DR= ExcelData.get("Total_records_count_DR");
	public static String Clickcheckbox_DR = ExcelData.get("Clickcheckbox_DR");
	public static String DoHoldStatus_DR = ExcelData.get("DoHoldStatus_DR");
	public static String popup_Message_Ok_Button = ExcelData.get("popup_Message_Ok_Button");
	public static String Bl_Searchbutton_DR = ExcelData.get("Bl_Searchbutton_DR");
	public static String BL_Filter_DR = ExcelData.get("BL_Filter_DR");
 
	public static String Changedeliverytype_DR = ExcelData.get("Changedeliverytype_DR");
	public static String Deliverytype_fieldinput_DR = ExcelData.get("Deliverytype_fieldinput_DR");
	public static String Select_deliverytype_DR = ExcelData.get("Select_deliverytype_DR");
	public static String Updateclick_DR = ExcelData.get("Updateclick_DR");
	public static String Changedeliverytype_button_DR = ExcelData.get("Changedeliverytype_button_DR");
	public static String verify_deliverytype_DR = ExcelData.get("verify_deliverytype_DR");

	public static String Show_Summary_Btn = ExcelData.get("Show_Summary_Btn");
	public static String Show_Containers_Btn = ExcelData.get("Show_Containers_Btn");
	public static String Toll_Panel = ExcelData.get("Toll_Panel");
	public static String Filter_Bttn = ExcelData.get("Filter_Bttn");
	public static String Non_Container_Shipment_Summary_Btn = ExcelData.get("Non_Container_Shipment_Summary_Btn");
	public static String BL_Number_Filter_Input = ExcelData.get("BL_Number_Filter_Input");
	public static String Mapped_Bls_Count_field = ExcelData.get("Mapped_Bls_Count_field");
	public static String Equipment_section_DR = ExcelData.get("Equipment_section_DR");
	public static String Table_Name = ExcelData.get("Table_Name");
	public static String Discharge_Container_Close_Tab = ExcelData.get("Discharge_Container_Close_Tab");
	public static String Show_Summary_Close_tab = ExcelData.get("Show_Summary_Close_tab");
	public static String Container_Table_Header_DR = ExcelData.get("Container_Table_Header_DR");
	public static String Container_table_Body = ExcelData.get("Container_table_Body");
	public static String Full_Screen_btn = ExcelData.get("Full_Screen_btn");
	public static String Filter_Button_Re_Con = ExcelData.get("Filter_Button_Re_Con");
	public static String DR_System_Bl_Type = ExcelData.get("DR_System_Bl_Type");
	public static String S_BL_System_Bl_Type = ExcelData.get("S_BL_System_Bl_Type");
	public static String Agency_input_tab = ExcelData.get("Agency_input_tab");
	public static String Cargo_Pol_Detials = ExcelData.get("Cargo_Pol_Detials");
	public static String Cargo_Book_Detials = ExcelData.get("Cargo_Book_Detials");
	public static String Non_Container_Shipment_Summary_Close_Btn = ExcelData.get("Non_Container_Shipment_Summary_Close_Btn");
	public static String Cargo_Detials_Filter_Btn = ExcelData.get("Cargo_Detials_Filter_Btn");
	public static String Stuff_BB_Book_no = ExcelData.get("Stuff_BB_Book_no");
	public static String DPD_code_btn = ExcelData.get("DPD_code_btn");
	public static String shipment_catagory_btn = ExcelData.get("shipment_catagory_btn");
	public static String change_shipment_btn = ExcelData.get("change_shipment_btn");
	public static String change_shipment_gategory = ExcelData.get("change_shipment_gategory");
	public static String change_shipment_update_btn = ExcelData.get("change_shipment_update_btn");
	public static String ID_Bl_search_btn = ExcelData.get("ID_Bl_search_btn");
	public static String BL_HBL_Summary_btn = ExcelData.get("BL_HBL_Summary_btn");
	public static String Shipment_catagory_IN_ID = ExcelData.get("Shipment_catagory_IN_ID");
	public static String DR_Shipment_Category_type = ExcelData.get("DR_Shipment_Category_type");
	public static String Bl_numbers_Split = ExcelData.get("Bl_numbers_Split");
	public static String Re_arange_Bl_filter = ExcelData.get("Re_arange_Bl_filter");
	public static String Re_arange_shipment_filter = ExcelData.get("Re_arange_shipment_filter");
	public static String Bill_lading_container_table = ExcelData.get("Bill_lading_container_table");
	public static String Mcn_Container_BillofLading = ExcelData.get("Mcn_Container_BillofLading");
	public static String Cargo_Detials_Column_btn = ExcelData.get("Cargo_Detials_Column_btn");
	public static String Cargo_Cbm_Detials = ExcelData.get("Cargo_Cbm_Detials");
	public static String Cargo_WT_Detials = ExcelData.get("Cargo_WT_Detials");
	public static String Cargo_QTY_Detials = ExcelData.get("Cargo_QTY_Detials");
	public static String Cargo_Commodity_Detials = ExcelData.get("Cargo_Commodity_Detials");
	public static String Show_Summary_Btn_DR=ExcelData.get("Show_Summary_Btn_DR");
	public static String MCN_Ref_btn_DR=ExcelData.get("MCN_Ref_btn_DR");
	public static String MCN_Total_Records_DR = ExcelData.get("MCN_Total_Records_DR");
        public static String Close_btn_DR=ExcelData.get("Close_btn_DR");
        public static String Count_No_DR=ExcelData.get("Count_No_DR");
	public static String Filter_btn_DR=ExcelData.get("Filter_btn_DR");
	public static String MCN_No_DR=ExcelData.get("MCN_No_DR");
	public static String DR_20s_value=ExcelData.get("DR_20s_value");
	public static String DR_40s_value=ExcelData.get("DR_40s_value");
	public static String Equipment_Bill_Of_Lading_field = ExcelData.get("Equipment_Bill_Of_Lading_field");
	public static String BL_No_DR=ExcelData.get("BL_No_DR");
	public static String MCN_No_MR_DR=ExcelData.get("MCN_No_MR_DR");
	public static String Discharge_recon_table=ExcelData.get("Discharge_recon_table");
	public static String Eqip_sum_header=ExcelData.get("Eqip_sum_header");
	public static String Eqip_sum_row=ExcelData.get("Eqip_sum_row");
	public static String Service_Option=ExcelData.get("Service_Option");
	public static String Vessele_Option=ExcelData.get("Vessele_Option");
	public static String DR_Voyage_Option=ExcelData.get("DR_Voyage_Option");
	public static String DR_Manifest_value=ExcelData.get("DR_Manifest_value");
	public static String DR_Ref_Status_tab=ExcelData.get("DR_Ref_Status_tab");
	public static String DR_Manifest_Checkbox=ExcelData.get("DR_Manifest_Checkbox");
	public static String DR_Remarks_tab=ExcelData.get("DR_Remarks_tab");
	public static String DR_Manifest_Date=ExcelData.get("DR_Manifest_Date");
	public static String DR_System_Remarks=ExcelData.get("DR_System_Remarks");
	public static String DR_Checkbox_Mani=ExcelData.get("DR_Checkbox_Mani");
	public static String Bl_Without_MF_btn=ExcelData.get("Bl_Without_MF_btn");
	public static String Bl_No_Without_MF=ExcelData.get("Bl_No_Without_MF");
	public static String Filter_btn_Without_Mf=ExcelData.get("Filter_btn_Without_Mf");
	public static String Bl_without_Mf_cocloum_click=ExcelData.get("Bl_without_Mf_cocloum_click");
	public static String Bl_without_Mf_close_btn=ExcelData.get("Bl_without_Mf_close_btn");
	public static String ManifiesBL_Numbers=ExcelData.get("ManifiesBL_Numbers");
	public static String N0_bl_manifest_notclos=ExcelData.get("N0_bl_manifest_notclos");
	public static String Non_Container_ss_btn=ExcelData.get("Non_Container_ss_btn");
	public static String Bl_No_Cargo_det=ExcelData.get("Bl_No_Cargo_det");
        public static String DR_Cargo_weight=ExcelData.get("DR_Cargo_weight");
        public static String DR_Non_Container_ss_btn=ExcelData.get("DR_Non_Container_ss_btn");
	public static String DR_Cargo_Bl_no=ExcelData.get("DR_Cargo_Bl_no");
	public static String DR_Cargo_count_of_num=ExcelData.get("DR_Cargo_count_of_num");
	public static String DR_WT_count=ExcelData.get("DR_WT_count");
	public static String DR_Booking_BoNo=ExcelData.get("DR_Booking_BoNo");
        public static String DR_Show_Non_container_clbtn=ExcelData.get("DR_Show_Non_container_clbtn");
        public static String DR_Bl_No_show_Container=ExcelData.get("DR_Bl_No_show_Container");
	public static String DR_Show_container_clbtn=ExcelData.get("DR_Show_container_clbtn");
	public static String Non_Cargo_Scroll=ExcelData.get("Non_Cargo_Scroll");
	public static String operations_Con_num_find=ExcelData.get("operations_Con_num_find");
	public static String operations_Con_num_find_status=ExcelData.get("operations_Con_num_find_status");
	public static String Scroll_Discharge_service=ExcelData.get("Scroll_Discharge_service");
	public static String Cargo_gird_Filter = ExcelData.get("Cargo_gird_Filter");
	public static String Cargo_gird_Filter_bl = ExcelData.get("Cargo_gird_Filter_bl");
	public static String Non_Con_tab_close = ExcelData.get("Non_Con_tab_close");
	public static String BL_Shipment_Type = ExcelData.get("BL_Shipment_Type");
	public static String Dis_Bl_Gird_first = ExcelData.get("Dis_Bl_Gird_first");
	public static String MCN_Bl_gird_first = ExcelData.get("MCN_Bl_gird_first");
	public static String MCN_No_gird_first = ExcelData.get("MCN_No_gird_first");
	public static String Discharge_mcn_gird_value = ExcelData.get("Discharge_mcn_gird_value");
	public static String Change_shipment = ExcelData.get("Change_shipment");
	public static String Change_shipment_select = ExcelData.get("Change_shipment_select");
	public static String Change_shipment_select_update = ExcelData.get("Change_shipment_select_update");
	public static String Bl_Number_input_re_con_rowfull_click = ExcelData.get("Bl_Number_input_re_con_rowfull_click");
	public static String Shipment_type_text = ExcelData.get("Shipment_type_text");
	public static String Shipment_Cat_Button = ExcelData.get("Shipment_Cat_Button");
	public static String DPD_CODE_BUTTON = ExcelData.get("DPD_CODE_BUTTON");
	public static String Change_dpd_code = ExcelData.get("Change_dpd_code");
	public static String DPD_Code_input = ExcelData.get("DPD_Code_input");
	public static String DPD_Code_select_update = ExcelData.get("DPD_Code_select_update");
	public static String DPD_Code_text = ExcelData.get("DPD_Code_text");
	public static String Hbl_Number_Gird = ExcelData.get("Hbl_Number_Gird");
	public static String DPD_Code_text_Gird = ExcelData.get("DPD_Code_text_Gird");
	public static String Export_button_Discharge = ExcelData.get("Export_button_Discharge");
	public static String DO_Hold_Checkbox = ExcelData.get("DO_Hold_Checkbox");
	public static String DR_Bbookno = ExcelData.get("DR_Bbookno");
	
	
	
	
	public static String Bl_Number_input_re_con = ExcelData.get("Bl_Number_input_re_con");

}
