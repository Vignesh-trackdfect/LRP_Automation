package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Detention_Waiver_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Detention_Waiver", "Reference_Name", Testcases.environmentName);

	public static String DW_BookingNo_Input = ExcelData.get("DW_BookingNo_Input");
	public static String DW_BookingNo_Search = ExcelData.get("DW_BookingNo_Search");
	public static String DW_Show = ExcelData.get("DW_Show");
	public static String DW_ContainersGrid = ExcelData.get("DW_ContainersGrid");
	public static String DW_Waiver_For_option = ExcelData.get("DW_Waiver_For_option");
	public static String DW_Waiver_Lumpsum = ExcelData.get("DW_Waiver_Lumpsum");
	public static String DW_Horizontalscroll = ExcelData.get("DW_Horizontalscroll");
	public static String DW_Net_Tariff_Amount = ExcelData.get("DW_Net_Tariff_Amount");
	public static String DW_selectall_checkbox_option = ExcelData.get("DW_selectall_checkbox_option");
	public static String DW_Total_records = ExcelData.get("DW_Total_records");
	public static String DW_Additional_Free_Days = ExcelData.get("DW_Additional_Free_Days");
	public static String DW_Add_button = ExcelData.get("DW_Add_button");
	public static String DW_Value = ExcelData.get("DW_Value");
	public static String DW_Container_Select = ExcelData.get("DW_Container_Select");
	public static String DW_Radio_Button = ExcelData.get("DW_Radio_Button");
	public static String DW_Percenteage_Input_Field = ExcelData.get("DW_Percenteage_Input_Field");
	public static String DW_Waiver_Reason_Input_Field = ExcelData.get("DW_Waiver_Reason_Input_Field");
	public static String DW_Remarks = ExcelData.get("DW_Remarks");
	public static String DW_BookingNo_Search_btn = ExcelData.get("DW_BookingNo_Search_btn");
	public static String DW_Submitted = ExcelData.get("DW_Submitted");
	public static String DW_Waiver_Reason_Search_Button = ExcelData.get("DW_Waiver_Reason_Search_Button");
	public static String DW_Grid_Waiver_Value_Column = ExcelData.get("DW_Grid_Waiver_Value_Column");
	public static String DW_Shipment_Select = ExcelData.get("DW_Shipment_Select");
	public static String DW_Shipment_Options = ExcelData.get("DW_Shipment_Options");
	public static String DW_Show_Button = ExcelData.get("DW_Show_Button");
	public static String DW_Select_All_Checkbox = ExcelData.get("DW_Select_All_Checkbox");
	public static String DW_Select_Container_Checkbox = ExcelData.get("DW_Select_Container_Checkbox");
	public static String DW_Containers_Column = ExcelData.get("DW_Containers_Column");
	public static String DW_Add_Days_RadioBtn = ExcelData.get("DW_Add_Days_RadioBtn");
	public static String DW_Addition_Days_Input = ExcelData.get("DW_Addition_Days_Input");
	public static String DW_Waiver_Add_button = ExcelData.get("DW_Waiver_Add_button");
	public static String DW_Waiver_Remove_button = ExcelData.get("DW_Waiver_Remove_button");
	public static String DW_Waiver_Table_ = ExcelData.get("DW_Waiver_Table_");
	public static String DW_Waiver_Table_Cell = ExcelData.get("DW_Waiver_Table_Cell");
	public static String DW_Waiver_Table_SelectAll_Checkbox = ExcelData.get("DW_Waiver_Table_SelectAll_Checkbox");
	public static String DW_Lumpsum_radioBtn = ExcelData.get("DW_Lumpsum_radioBtn");
	public static String DW_Lumpsum_Input = ExcelData.get("DW_Lumpsum_Input");
	public static String DW_Waiver_percent_RadioBtn = ExcelData.get("DW_Waiver_percent_RadioBtn");
	public static String DW_Waiver_percent_Input = ExcelData.get("DW_Waiver_percent_Input");
	public static String DW_Waiver_Values_ColumnTable = ExcelData.get("DW_Waiver_Values_ColumnTable");
	public static String DW_Waiver_Amount_ColumnTable = ExcelData.get("DW_Waiver_Amount_ColumnTable");
	public static String DW_Waiver_Status_input = ExcelData.get("DW_Waiver_Status_input");
	public static String DW_Cancelled_Btn = ExcelData.get("DW_Cancelled_Btn");
	public static String DW_Remarks_Input = ExcelData.get("DW_Remarks_Input");
	public static String DW_Waiver_ReasonSearch_btn = ExcelData.get("DW_Waiver_ReasonSearch_btn");
	public static String DW_Waiver_Status = ExcelData.get("DW_Waiver_Status");
	public static String DW_WaiverDate_Column = ExcelData.get("DW_WaiverDate_Column");
	public static String DW_Waiver_Date_Desc_ = ExcelData.get("DW_Waiver_Date_Desc_");
	public static String DW_Waiver_Ref_No_FilterInput = ExcelData.get("DW_Waiver_Ref_No_FilterInput");
	public static String DW_Submitted_Option = ExcelData.get("DW_Submitted_Option");
	public static String DW_Waiver_Reference_input = ExcelData.get("DW_Waiver_Reference_input");
	public static String DW_Table_Filter_Option = ExcelData.get("DW_Table_Filter_Option");
	public static String DW_Net_Tarrif_Amount = ExcelData.get("DW_Net_Tarrif_Amount");
	public static String DW_Container_NumbersColumn = ExcelData.get("DW_Container_NumbersColumn");
	public static String DW_Approved_option = ExcelData.get("DW_Approved_option");
	public static String WG_Submitted_Option = ExcelData.get("WG_Submitted_Option");
	public static String WG_BL_Filter_Input = ExcelData.get("WG_BL_Filter_Input");
	public static String WG_Select_BL_CheckBox = ExcelData.get("WG_Select_BL_CheckBox");
	public static String WG_Approved_Button = ExcelData.get("WG_Approved_Button");
	public static String Addtional_free_days_radio_button = ExcelData.get("Addtional_free_days_radio_button");
	public static String Waiver_lumsum_radio_button = ExcelData.get("Waiver_lumsum_radio_button");
	public static String Waiver_lumsum_iput = ExcelData.get("Waiver_lumsum_iput");
	public static String Due_days_table = ExcelData.get("Due_days_table");
	public static String Due_date_table = ExcelData.get("Due_date_table");
	public static String EX_IN_Field = ExcelData.get("EX_IN_Field");
	public static String inclusive_Field = ExcelData.get("inclusive_Field");
	public static String exclusive_Field = ExcelData.get("exclusive_Field");
	public static String Waiver_value_gird = ExcelData.get("Waiver_value_gird");
	public static String Gress_Local_Amount = ExcelData.get("Gress_Local_Amount");
	public static String net_tariffic_Amount = ExcelData.get("net_tariffic_Amount");
	public static String net_local_Amount = ExcelData.get("net_local_Amount");
	public static String Scroll_DW = ExcelData.get("Scroll_DW");
	public static String Scroll_DW_length = ExcelData.get("Scroll_DW_length");
	public static String DW_WaiverFor = ExcelData.get("DW_WaiverFor");
	public static String DW_WaiverOption = ExcelData.get("DW_WaiverOption");
	public static String DW_DetentionStorageOption = ExcelData.get("DW_DetentionStorageOption");
	public static String DW_BLNo_Input = ExcelData.get("DW_BLNo_Input");
	public static String DW_selectall_checkbox_option_Additional = ExcelData.get("DW_selectall_checkbox_option_Additional");
	public static String DW_remove_button = ExcelData.get("DW_remove_button");
	public static String DW_Addition_First_row = ExcelData.get("DW_Addition_First_row");
	public static String DWAddtionfreedays_Radio_Button = ExcelData.get("DWAddtionfreedays_Radio_Button");
	public static String DWPercentage_Radio_Button = ExcelData.get("DWPercentage_Radio_Button");
	public static String DW_Waiver_Lumpsum_input_field = ExcelData.get("DW_Waiver_Lumpsum_input_field");
	public static String DW_Waiver_Radio_button = ExcelData.get("DW_Waiver_Radio_button");
	public static String DW_select_Container_Row = ExcelData.get("DW_select_Container_Row");
	public static String DW_waiverAmount_Gridcell = ExcelData.get("DW_waiverAmount_Gridcell");
	public static String DW_PrintScreen_Deatils = ExcelData.get("DW_PrintScreen_Deatils");
	public static String DW_PrintScreen = ExcelData.get("DW_PrintScreen");
	public static String DW_PDF_Iframe = ExcelData.get("DW_PDF_Iframe");
	public static String DW_uploadedUser = ExcelData.get("DW_uploadedUser");
	public static String DW_Waiver_input_Field = ExcelData.get("DW_Waiver_input_Field");
	public static String DWAddtionfreedays_Radio_ButtonCheck = ExcelData.get("DWAddtionfreedays_Radio_ButtonCheck");
	public static String DW_PrintScreen_WaiverDays = ExcelData.get("DW_PrintScreen_WaiverDays");
	public static String DW_WaiverNo = ExcelData.get("DW_WaiverNo");
	public static String DW_WaiverStatus = ExcelData.get("DW_WaiverStatus");
	public static String DW_WaiverDate = ExcelData.get("DW_WaiverDate");
	public static String DW_GlobalDateSearch = ExcelData.get("DW_GlobalDateSearch");
	public static String DW_Counter = ExcelData.get("DW_Counter");
	public static String DW_WaiverLumpsum = ExcelData.get("DW_WaiverLumpsum");
	public static String DW_WaiverLumpsum_input = ExcelData.get("DW_WaiverLumpsum_input");
	public static String DW_WaiverAmount = ExcelData.get("DW_WaiverAmount");
	public static String DW_ReasonSearch = ExcelData.get("DW_ReasonSearch");
	public static String DW_WaiverValue = ExcelData.get("DW_WaiverValue");
	public static String DW_percentage = ExcelData.get("DW_percentage");
	public static String DW_percentage_Input = ExcelData.get("DW_percentage_Input");
	public static String DW_SearchScroll = ExcelData.get("DW_SearchScroll");
	public static String DW_Waiverstatus_SearchInput = ExcelData.get("DW_Waiverstatus_SearchInput");
	public static String DW_Approved = ExcelData.get("DW_Approved");
	public static String DW_Uploads = ExcelData.get("DW_Uploads");
	public static String DW_Preview = ExcelData.get("DW_Preview");
	public static String DW_uploadedfilename = ExcelData.get("DW_uploadedfilename");
	public static String DW_uploadedDate = ExcelData.get("DW_uploadedDate");
	public static String DW_ClosePreview = ExcelData.get("DW_ClosePreview");
	public static String DW_PreviewPage = ExcelData.get("DW_PreviewPage");
	public static String DW_WaiverValue1 = ExcelData.get("DW_WaiverValue1");
	public static String DW_ContainersGrid_SelectAll = ExcelData.get("DW_ContainersGrid_SelectAll");
	public static String DW_Container_List = ExcelData.get("DW_Container_List");
	public static String DW_WaiverAmount_GridList = ExcelData.get("DW_WaiverAmount_GridList");
	public static String DW_WaiverValue_GridList = ExcelData.get("DW_WaiverValue_GridList");
	public static String DW_TariffAmount_GridList = ExcelData.get("DW_TariffAmount_GridList");
	public static String DW_Radio_Button_input = ExcelData.get("DW_Radio_Button_input");
	public static String DW_Tariffamount = ExcelData.get("DW_Tariffamount");
	public static String DW_Tariffamount_Grid = ExcelData.get("DW_Tariffamount_Grid");
	public static String Waier_plus_button = ExcelData.get("Waier_plus_button");
	public static String DW_Percenteage_Radio_Button_Verify = ExcelData.get("DW_Percenteage_Radio_Button_Verify");
	public static String DW_Lumpsum_Radio_Button_Verify = ExcelData.get("DW_Lumpsum_Radio_Button_Verify");
	public static String DW_Customer_details_heading = ExcelData.get("DW_Customer_details_heading");
	public static String DW_Customer_details_value = ExcelData.get("DW_Customer_details_value");
	public static String DW_Customer_details_Scroll = ExcelData.get("DW_Customer_details_Scroll");
	public static String DW_Container_Table = ExcelData.get("DW_Container_Table");
	public static String DW_plus_icon = ExcelData.get("DW_plus_icon");
	public static String DW_Waiver_value = ExcelData.get("DW_Waiver_value");
	public static String DW_Action_by_value = ExcelData.get("DW_Action_by_value");
	public static String DW_Detention_Option = ExcelData.get("DW_Detention_Option");
	public static String DW_BookingNo_Input1 = ExcelData.get("DW_BookingNo_Input1");
	public static String DW_select_all_checkbox = ExcelData.get("DW_select_all_checkbox");
	public static String DW_Container_Select1 = ExcelData.get("DW_Container_Select1");
	public static String DW_Storage_Option = ExcelData.get("DW_Storage_Option");
	public static String DW_coloum_button = ExcelData.get("DW_coloum_button");
	public static String DW_Global_BL_Number = ExcelData.get("DW_Global_BL_Number");
	
	//new 1405
	
	public static String DW_Containers_Column_Down = ExcelData.get("DW_Containers_Column_Down");
	public static String Container_Details_Gird = ExcelData.get("Container_Details_Gird");
	public static String Customer_Details_Gird = ExcelData.get("Customer_Details_Gird");
	public static String DW_Select_All_Checkbox_Down = ExcelData.get("DW_Select_All_Checkbox_Down");
	public static String DW_Select_Container_down_gird = ExcelData.get("DW_Select_Container_down_gird");
	public static String DW_Select_Container_Checkbox_Down = ExcelData.get("DW_Select_Container_Checkbox_Down");
	public static String DW_PLA_Value = ExcelData.get("DW_PLA_Value");
	public static String DW_POL_Value = ExcelData.get("DW_POL_Value");
	public static String DW_POD_Value = ExcelData.get("DW_POD_Value");
	public static String DW_PLD_Value = ExcelData.get("DW_PLD_Value");
	
	public static String DW_Accepted_Button = ExcelData.get("DW_Accepted_Button");
	public static String DW_Pending_Button = ExcelData.get("DW_Pending_Button");
	
	public static String Detention_Charges_Tab_ExpInv = ExcelData.get("Detention_Charges_Tab_ExpInv");
	public static String detentionCharges_Table_Rows_EXP_INV = ExcelData.get("detentionCharges_Table_Rows_EXP_INV");
	public static String detentionCharges_Table_Columns_EXP_INV = ExcelData.get("detentionCharges_Table_Columns_EXP_INV");
	public static String Waiver_Value_Table = ExcelData.get("Waiver_Value_Table");
	public static String Waiver_Status_Filter = ExcelData.get("Waiver_Status_Filter");
	public static String Waiver_Container_Table = ExcelData.get("Waiver_Container_Table");
//	public static String DW_Select_All_Checkbox_Down = ExcelData.get("DW_Select_All_Checkbox_Down");
//	public static String DW_Select_Container_down_gird = ExcelData.get("DW_Select_Container_down_gird");
	
	public static String AM_Controlling_Ports_Filter = ExcelData.get("AM_Controlling_Ports_Filter");
	public static String AM_Port_Code_Input_Field = ExcelData.get("AM_Port_Code_Input_Field");
	public static String AM_Port_Code_Row_Values = ExcelData.get("AM_Port_Code_Row_Values");
	
	public static String grid_Container_Number = ExcelData.get("grid_Container_Number");
	public static String Weiver_Input = ExcelData.get("Weiver_Input");
	public static String Line_lumpsum = ExcelData.get("Line_lumpsum");
	public static String DW_Line_Freedays = ExcelData.get("DW_Line_Freedays");
	public static String Detention_container_Grid = ExcelData.get("Detention_container_Grid");
	
	public static String Detention_container_Filter = ExcelData.get("Detention_container_Filter");
	public static String Detention_container_Filter_input = ExcelData.get("Detention_container_Filter_input");
	public static String Detention_container_down = ExcelData.get("Detention_container_down");
	public static String Detention_SelectedContainer_Value = ExcelData.get("Detention_SelectedContainer_Value");
	public static String Detention_Container_Grid2_Filter = ExcelData.get("Detention_Container_Grid2_Filter");
	public static String Detention_Container_Grid2_Filter_Searchfield = ExcelData.get("Detention_Container_Grid2_Filter_Searchfield");

	public static String DW_totalRecords_ContainerTable = ExcelData.get("DW_totalRecords_ContainerTable");
	public static String DW_Gross_Local_Amount_Rows = ExcelData.get("DW_Gross_Local_Amount_Rows");
	public static String DW_Net_Local_Amount = ExcelData.get("DW_Net_Local_Amount");
	public static String DW_Net_Tariff_Amount_Gridcell = ExcelData.get("DW_Net_Tariff_Amount_Gridcell");
	
	
	
	public static String Filter_Icon_Table1_DW = ExcelData.get("Filter_Icon_Table1_DW");
	public static String Detention_Charges_HorizontalScrollBar_EXP = ExcelData.get("Detention_Charges_HorizontalScrollBar_EXP");
	public static String Port_Storage_Charges_HorizontalScrollBar_EXP = ExcelData.get("Port_Storage_Charges_HorizontalScrollBar_EXP");
	public static String Charges_Tab_ExpInv = ExcelData.get("Charges_Tab_ExpInv");
	public static String port_Storage_Tab_Columns_EXP = ExcelData.get("port_Storage_Tab_Columns_EXP");
	public static String port_Storage_Tab_Rows_EXP = ExcelData.get("port_Storage_Tab_Rows_EXP");
	
}





