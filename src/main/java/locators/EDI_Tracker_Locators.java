package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EDI_Tracker_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Edi_Tracker", "Reference_Name",
			Testcases.environmentName);

	public static String EDI_Direction_Dropdown = ExcelData.get("EDI_Direction_Dropdown");
	public static String EDI_from_date_selecter = ExcelData.get("EDI_from_date_selecter");
	public static String EDI_to_date_selecter = ExcelData.get("EDI_to_date_selecter");
	public static String EDI_show_button = ExcelData.get("EDI_show_button");
	public static String EDI_enable_checkbox = ExcelData.get("EDI_enable_checkbox");
	public static String EDI_download_button = ExcelData.get("EDI_download_button");
	public static String EDI_agency_code_search = ExcelData.get("EDI_agency_code_search");
	public static String EDI_partner_code_search = ExcelData.get("EDI_partner_code_search");
	public static String EDI_grid_rows = ExcelData.get("EDI_grid_rows");
	public static String EDI_PartnerId_Grid = ExcelData.get("EDI_PartnerId_Grid");
	public static String EDI_grid = ExcelData.get("EDI_grid");
	public static String EDI_Agency_column = ExcelData.get("EDI_Agency_column");
	public static String Edi_code_search = ExcelData.get("Edi_code_search");
	public static String EDI_Total_Records = ExcelData.get("EDI_Total_Records");
	public static String EDI_Status_Dropdown = ExcelData.get("EDI_Status_Dropdown");
	public static String EDI_Table = ExcelData.get("EDI_Table");
	public static String EDI_Refrence_id = ExcelData.get("EDI_Refrence_id");
	public static String EDI_Refrence_id_grid = ExcelData.get("EDI_Refrence_id_grid");
	public static String EDI_Errorstatus_grid_firstrow = ExcelData.get("EDI_Errorstatus_grid_firstrow");
	public static String EDI_Viewerror_Button = ExcelData.get("EDI_Viewerror_Button");
	public static String EDI_Viewfile_Error_button = ExcelData.get("EDI_Viewfile_Error_button");
	public static String EDI_Compressed_Download_button = ExcelData.get("EDI_Compressed_Download_button");
	public static String EDI_Selectall_checkbox = ExcelData.get("EDI_Selectall_checkbox");

	public static String Direction_dropdown_btn_click_ET = ExcelData.get("Direction_dropdown_btn_click_ET");
	public static String Select_Calender_Month_ET = ExcelData.get("Select_Calender_Month_ET");
	public static String Select_Calender_From_Date_ET = ExcelData.get("Select_Calender_From_Date_ET");
	public static String Select_Calender_To_Date_ET = ExcelData.get("Select_Calender_To_Date_ET");
	public static String Status_Dropdown_ET = ExcelData.get("Status_Dropdown_ET");
	public static String Show_Btn_ET = ExcelData.get("Show_Btn_ET");
	public static String View_File_Btn_ET = ExcelData.get("View_File_Btn_ET");
	public static String EDI_File_Details_Popup_ET = ExcelData.get("EDI_File_Details_Popup_ET");
	public static String Reference_ID_Verify_ET = ExcelData.get("Reference_ID_Verify_ET");
	public static String EDI_File_text_verify_ET = ExcelData.get("EDI_File_text_verify_ET");
	public static String From_Date_Input_Field_ET = ExcelData.get("From_Date_Input_Field_ET");
	public static String To_Date_Input_Field_ET = ExcelData.get("To_Date_Input_Field_ET");
	public static String Reference_ID_Input_Field_ET = ExcelData.get("Reference_ID_Input_Field_ET");
	public static String Select_First_Row_ET = ExcelData.get("Select_First_Row_ET");

	public static String Total_Count_ET = ExcelData.get("Total_Count_ET");
	public static String Row_Data_ET = ExcelData.get("Row_Data_ET");
	public static String Resent_Btn_ET = ExcelData.get("Resent_Btn_ET");
	public static String ReferenceID_Column_ET = ExcelData.get("ReferenceID_Column_ET");
	public static String EDI_ID_Column = ExcelData.get("EDI_ID_Column");
	public static String Partner_ID_ET = ExcelData.get("Partner_ID_ET");
	public static String Agency_Column_ET = ExcelData.get("Agency_Column_ET");
	public static String Grid_Filter_Btn_ET = ExcelData.get("Grid_Filter_Btn_ET");
	public static String Reference_ID_Filter_Input_Field_ET = ExcelData.get("Reference_ID_Filter_Input_Field_ET");
	public static String Verify_Reference_ID_Value_ET = ExcelData.get("Verify_Reference_ID_Value_ET");
	public static String ReInitate_Btn_ET = ExcelData.get("ReInitate_Btn_ET");

	public static String Error_Details_ET = ExcelData.get("Error_Details_ET");
	public static String Error_Close_ET = ExcelData.get("Error_Close_ET");
	public static String RefGrid_list_ET = ExcelData.get("RefGrid_list_ET");
	public static String EDIGrid_list_ET = ExcelData.get("EDIGrid_list_ET");
	public static String PartnerIDGrid_list_ET = ExcelData.get("PartnerIDGrid_list_ET");

	public static String FileDetails_ET = ExcelData.get("FileDetails_ET");
	public static String Status_List_ET = ExcelData.get("Status_List_ET");

}
