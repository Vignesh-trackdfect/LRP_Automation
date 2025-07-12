package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Operation_list_View_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Operation_list_View",
			"Reference_Name", Testcases.environmentName);

	public static String OLV_cocloum_click = ExcelData.get("OLV_cocloum_click");
	public static String OLV_Filter_Btn = ExcelData.get("OLV_Filter_Btn");
	public static String OLV_Row_Count = ExcelData.get("OLV_Row_Count");

	//
	public static String Operation_Module_Show_Btn = ExcelData.get("Operation_Module_Show_Btn");
	public static String Operation_Module_Op_Status_table = ExcelData.get("Operation_Module_Op_Status_table");
	public static String Operation_Grid_Row_Count = ExcelData.get("Operation_Grid_Row_Count");

	//
	public static String Operation_Detail_tracking_Filter_Btn = ExcelData.get("Operation_Detail_tracking_Filter_Btn");
	public static String Operation_Detail_tracking_Op_status_Grid = ExcelData
			.get("Operation_Detail_tracking_Op_status_Grid");
	public static String Operation_Detail_tracking_Op_status_ResetBtn = ExcelData
			.get("Operation_Detail_tracking_Op_status_ResetBtn");
	public static String Operation_Detail_tracking_OPSPOL_Field = ExcelData
			.get("Operation_Detail_tracking_OPSPOL_Field");
	public static String Operation_Detail_tracking_Op_status_Field = ExcelData
			.get("Operation_Detail_tracking_Op_status_Field");
	public static String Olv_Non_Containerized_btn = ExcelData.get("Olv_Non_Containerized_btn");
	public static String Olv_Discharge_List_btn = ExcelData.get("Olv_Discharge_List_btn");
	public static String Show_Container_ss_btn = ExcelData.get("Show_Container_ss_btn");
	public static String Non_cs_Weight_tbl = ExcelData.get("Non_cs_Weight_tbl");
	public static String Non_cs_Bookings_without_BL_tbl = ExcelData.get("Non_cs_Bookings_without_BL_tbl");
	public static String Non_cs_Cargo_details_tbl = ExcelData.get("Non_cs_Cargo_details_tbl");
	public static String OLV_Service_Option = ExcelData.get("OLV_Service_Option");
	public static String OLV_Voyage_Option = ExcelData.get("OLV_Voyage_Option");
	public static String OLV_Vessele_Option = ExcelData.get("OLV_Vessele_Option");
	public static String OLV_Port_Option = ExcelData.get("OLV_Port_Option");
	public static String OLV_Terminal_Option = ExcelData.get("OLV_Terminal_Option");
	public static String OLV_Bound_Value = ExcelData.get("OLV_Bound_Value");
	public static String OLV_Load_btn = ExcelData.get("OLV_Load_btn");

	public static String OLV_grid_selectbtn = ExcelData.get("OLV_grid_selectbtn");
	public static String OLV_Filter_btn = ExcelData.get("OLV_Filter_btn");
	public static String OLV_ManifiesBook_Numbers = ExcelData.get("OLV_ManifiesBook_Numbers");
	public static String OLV_ManifiesBL_Numbers = ExcelData.get("OLV_ManifiesBL_Numbers");
	public static String POL_Grid_Data = ExcelData.get("POL_Grid_Data");
	public static String CBM_Grid_data = ExcelData.get("CBM_Grid_data");
	public static String OLV_Grid_Filter_Btn = ExcelData.get("OLV_Grid_Filter_Btn");
	public static String OLV_Book_No_Filter_Input = ExcelData.get("OLV_Book_No_Filter_Input");
	public static String OLV_Container_Btn = ExcelData.get("OLV_Container_Btn");
	public static String OLV_Multi_Select_Btn = ExcelData.get("OLV_Multi_Select_Btn");
	public static String OLV_Multi_Select_Btn1 = ExcelData.get("OLV_Multi_Select_Btn1");
	public static String OLV_Dropdown_Select = ExcelData.get("OLV_Dropdown_Select");
	public static String OLV_Dropdown = ExcelData.get("OLV_Dropdown");

}
