package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EDI_Code_Mapping_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EDI_Code_Mapping", "Reference_Name",
			Testcases.environmentName);

	public static String Click_ISO_Tab = ExcelData.get("Click_ISO_Tab_ECM");

	public static String Partner_ID_Search = ExcelData.get("Partner_ID_Search");
	public static String Partner_ID_Input = ExcelData.get("Partner_ID_Input");
	public static String EDI_ID_Search = ExcelData.get("EDI_ID_Search_ECM");
	public static String Liner_Eqp_Type = ExcelData.get("Liner_Eqp_Type");
	public static String EDI_Eqp_Type_Input = ExcelData.get("EDI_Eqp_Type_Input");
	public static String SaveButton_ToolBar = ExcelData.get("SaveButton_ToolBar");
	public static String popup_Message = ExcelData.get("popup_Message_ECM");
	public static String Click_Package_Tab = ExcelData.get("Click_Package_Tab_ECM");
	public static String Liner_Package_Search = ExcelData.get("Liner_Package_Search");
	public static String EDI_Package_Input = ExcelData.get("EDI_Package_Input");
	public static String Commodity_Code_Tab = ExcelData.get("Commodity_Code_Tab_ECM");
	public static String Commodity_Code_Search = ExcelData.get("Commodity_Code_Search");
	public static String EDI_Commodity_Code_Input = ExcelData.get("EDI_Commodity_Code_Input");
	public static String Sender_Receiver_Tab = ExcelData.get("Sender_Receiver_Tab_ECM");
	public static String Sender_ID_Input = ExcelData.get("Sender_ID_Input_ECM");
	public static String Port_Tab_ECM = ExcelData.get("Port_Tab_ECM");
	public static String Depot_Tab_ECM = ExcelData.get("Depot_Tab_ECM");
	public static String Port_Search_ECM = ExcelData.get("Port_Search_ECM");
	public static String Depot_Terminal_Search = ExcelData.get("Depot_Terminal_Search");
	public static String Filter_Button_ECM = ExcelData.get("Filter_Button_ECM");
	public static String ParterID_Field_ECM = ExcelData.get("ParterID_Field_ECM");
	public static String EDI_ID_Field_ECM = ExcelData.get("EDI_ID_Field_ECM");
	public static String Liner_Eqp_Type_Field_ECM = ExcelData.get("Liner_Eqp_Type_Field_ECM");
	public static String EDI_eqp_Type_field_ECM = ExcelData.get("EDI_eqp_Type_field_ECM");
	public static String EDI_Code_Mapping_EDI_Package_Field = ExcelData.get("EDI_Code_Mapping_EDI_Package_Field");
	public static String EDI_CommodityCode_Field = ExcelData.get("EDI_CommodityCode_Field");
	public static String CommodityCode_Field = ExcelData.get("CommodityCode_Field");
	public static String Filter_Button_CommodityCode = ExcelData.get("Filter_Button_CommodityCode");

	public static String EDI_Code_Mapping_Partner_Id_Value = ExcelData.get("EDI_Code_Mapping_Partner_Id_Value");

	public static String EDI_Code_Mapping_EDI_ID_Value = ExcelData.get("EDI_Code_Mapping_EDI_ID_Value");
	public static String EDI_Code_Mapping_EDI_Eqp_Type_Value = ExcelData.get("EDI_Code_Mapping_EDI_Eqp_Type_Value");
	public static String EDI_Code_Mapping_EDI_package_Input_Value = ExcelData
			.get("EDI_Code_Mapping_EDI_package_Input_Value");
	public static String EDI_CommodityCode_Field_Value = ExcelData.get("EDI_CommodityCode_Field_Value");
	public static String CommodityCode_Field_Value = ExcelData.get("CommodityCode_Field_Value");
	public static String Receiver_Id_Input_ECM = ExcelData.get("Receiver_Id_Input_ECM");
	public static String SenderId_Filter_Input = ExcelData.get("SenderId_Filter_Input");
	public static String ReceiverId_Filter_Input = ExcelData.get("ReceiverId_Filter_Input");
	public static String FilterButton_Sender_Receiver_ECM = ExcelData.get("FilterButton_Sender_Receiver_ECM");
	public static String EDI_Code_Mapping_SenderID_Value = ExcelData.get("EDI_Code_Mapping_SenderID_Value");
	public static String EDI_Code_Mapping_ReceiverID_Value = ExcelData.get("EDI_Code_Mapping_ReceiverID_Value");
	public static String EDI_Code_Show_Btn = ExcelData.get("EDI_Code_Show_Btn");
	public static String Double_Click_senderId_Value = ExcelData.get("Double_Click_senderId_Value");
	public static String Status_dropdown = ExcelData.get("Status_dropdown");
	public static String Firstrow_select_ECM = ExcelData.get("Firstrow_select_ECM");
	public static String LinerPortCode_Searchbtn_ECM = ExcelData.get("LinerPortCode_Searchbtn_ECM");
	public static String EDI_Port_Code_ECM = ExcelData.get("EDI_Port_Code_ECM");
	public static String EDI_Port_Code_Filter_Input = ExcelData.get("EDI_Port_Code_Filter_Input");
	public static String Liner_Port_Code_Filter_Input = ExcelData.get("Liner_Port_Code_Filter_Input");
	public static String Filter_btn_Port = ExcelData.get("Filter_btn_Port");
	public static String Port_firstrow_ECM = ExcelData.get("Port_firstrow_ECM");
	public static String Port_Status_dropdown_ECM = ExcelData.get("Port_Status_dropdown_ECM");
	public static String EDI_Dep_Code_Input_ECM = ExcelData.get("EDI_Dep_Code_Input_ECM");
	public static String EDI_Filterbutton_Dep_Code = ExcelData.get("EDI_Filterbutton_Dep_Code");
	public static String EDI_Dep_Code_Filter_Input_ECM = ExcelData.get("EDI_Dep_Code_Filter_Input_ECM");
	public static String EDI_Depcode_Firstrow_select_ECM = ExcelData.get("EDI_Depcode_Firstrow_select_ECM");
	public static String EDI_DEP_CODE_Firstrow_Select_ECM = ExcelData.get("EDI_DEP_CODE_Firstrow_Select_ECM");
	public static String EDI_DEP_CODE_Dropdown_ECM = ExcelData.get("EDI_DEP_CODE_Dropdown_ECM");
	public static String EDI_DEP_CODE_Filter_ECM = ExcelData.get("EDI_DEP_CODE_Filter_ECM");

	public static String Click_Package_Tab_ECM = ExcelData.get("Click_Package_Tab_ECM");
	public static String Liner_Package_Search_ECM = ExcelData.get("Liner_Package_Search_ECM");
	public static String EDI_Package_Input_Field = ExcelData.get("EDI_Package_Input_ECM");
	public static String Commodity_Code_Search_ECM = ExcelData.get("Commodity_Code_Search_ECM");
	public static String EDI_Commodity_Code_Input_ECM = ExcelData.get("EDI_Commodity_Code_Input_ECM");
	public static String Sender_Receiver_Tab_ECM = ExcelData.get("Sender_Receiver_Tab_ECM");
	public static String Sender_ID_Input_ECM = ExcelData.get("Sender_ID_Input_ECM");
	public static String Depot_Terminal_Search_ECM = ExcelData.get("Depot_Terminal_Search_ECM");
	public static String EDI_CommodityCode_Field_ECM = ExcelData.get("EDI_CommodityCode_Field_ECM");
	public static String CommodityCode_Field_ECM = ExcelData.get("CommodityCode_Field_ECM");
	public static String Filter_Button_CommodityCode_ECM = ExcelData.get("Filter_Button_CommodityCode_ECM");
	public static String EDI_Code_Show_Btn_ECM = ExcelData.get("EDI_Code_Show_Btn_ECM");
	public static String Select_row_Commodity_ECM = ExcelData.get("Select_row_Commodity_ECM");
	public static String Edit_Button_toolBar = ExcelData.get("Edit_Button_toolBar");
	public static String Double_click_Commodity_Code_ECM = ExcelData.get("Double_click_Commodity_Code_ECM");
	public static String Filter_btn_Package_ECM = ExcelData.get("Filter_btn_Package_ECM");
	public static String Select_row_Package_ECM = ExcelData.get("Select_row_Package_ECM");
	public static String Liner_Package_Filter_Input_ECM = ExcelData.get("Liner_Package_Filter_Input_ECM");
	public static String EDI_Package_Filter_Input_ECM = ExcelData.get("EDI_Package_Filter_Input_ECM");
	public static String Double_click_Liner_Package_ECM = ExcelData.get("Double_click_Liner_Package_ECM");
	public static String Parter_ID_Field_Package_ECM = ExcelData.get("Parter_ID_Field_Package_ECM");
	public static String Filter_btn_ISO_ECM = ExcelData.get("Filter_btn_ISO_ECM");
	public static String Select_Row_ISO_ECM = ExcelData.get("Select_Row_ISO_ECM");
	public static String Double_click_Liner_Eqp_Type_ECM = ExcelData.get("Double_click_Liner_Eqp_Type_ECM");
	public static String Liner_Eqp_Type_Field_ISO_ECM = ExcelData.get("Liner_Eqp_Type_Field_ISO_ECM");
	public static String Filter_btn_Depot_ECM = ExcelData.get("Filter_btn_Depot_ECM");
	public static String Terminal_Name_Filter_Input = ExcelData.get("Terminal_Name_Filter_Input");
	public static String Select_Row_Depot = ExcelData.get("Select_Row_Depot");
	public static String Double_Click_Terminal_Code_ECM = ExcelData.get("Double_Click_Terminal_Code_ECM");
	public static String Eqp_Dep_Code_Input_ECM = ExcelData.get("Eqp_Dep_Code_Input_ECM");
	public static String Terminal_Code_Filter_Input_ECM = ExcelData.get("Terminal_Code_Filter_Input_ECM");
	public static String Filter_btn_Port_ECM = ExcelData.get("Filter_btn_Port_ECM");
	public static String Liner_Port_Code_Filter_Input_ECM = ExcelData.get("Liner_Port_Code_Filter_Input_ECM");
	public static String EDI_Port_Code_Filter_Input_ECM = ExcelData.get("EDI_Port_Code_Filter_Input_ECM");
	public static String Select_Row_Port = ExcelData.get("Select_Row_Port");
	public static String Double_Click_Liner_Code = ExcelData.get("Double_Click_Liner_Code");
	public static String EDI_Port_Code_Input_Port_Tab_ECM = ExcelData.get("EDI_Port_Code_Input_Port_Tab_ECM");
	public static String Filter_btn_Sender_Receiver_ECM = ExcelData.get("Filter_btn_Sender_Receiver_ECM");
	public static String Receiver_ID_Input_ECM = ExcelData.get("Receiver_ID_Input_ECM");
	public static String Double_Click_Fliter_Sender_ID_ECM = ExcelData.get("Double_Click_Fliter_Sender_ID_ECM");
	public static String Sender_ID_Filter_Input_ECM = ExcelData.get("Sender_ID_Filter_Input_ECM");
	public static String Receiver_ID_Filter_Input_ECM = ExcelData.get("Receiver_ID_Filter_Input_ECM");
	public static String Status_btn_Click_ECM = ExcelData.get("Status_btn_Click_ECM");
	public static String Select_Filter_First_Row_ECM = ExcelData.get("Select_Filter_First_Row_ECM");
	public static String Status_btn_Click_Package_Tab_ECM = ExcelData.get("Status_btn_Click_Package_Tab_ECM");
	public static String Commodity_Code_Tab_ECM = ExcelData.get("Commodity_Code_Tab_ECM");
	public static String Status_btn_Click_Commodity_Tab_ECM = ExcelData.get("Status_btn_Click_Commodity_Tab_ECM");
	public static String Double_Click_Liner_Code_ECM = ExcelData.get("Double_Click_Liner_Code_ECM");
	public static String Depot_Tab_ECM_Sender_ID_Input = ExcelData.get("Depot_Tab_ECM_Sender_ID_Input");
	public static String Depot_Tab_ECM_Vendorcode_Input = ExcelData.get("Depot_Tab_ECM_Vendorcode_Input");
	public static String Depot_Tab_ECM_Referenceid = ExcelData.get("Depot_Tab_ECM_Referenceid");
	public static String Depot_Type_Search_Btn = ExcelData.get("Depot_Type_Search_Btn");
	public static String Status_Btn_Click_Depot_Tab = ExcelData.get("Status_Btn_Click_Depot_Tab");

	public static String DoubleClick_EDI_DepCode_ECM = ExcelData.get("DoubleClick_EDI_DepCode_ECM");

	public static String EDI_Code_Mapping_Partner_Id_Value_ECM = ExcelData.get("EDI_Code_Mapping_Partner_Id_Value_ECM");

	public static String EDI_CommodityCode_Field_Value_ECM = ExcelData.get("EDI_CommodityCode_Field_Value_ECM");
	public static String CommodityCode_Field_Value_ECM = ExcelData.get("CommodityCode_Field_Value_ECM");
	public static String Liner_Package_Value_ECM = ExcelData.get("Liner_Package_Value_ECM");
	public static String EDI_Package_Value_ECM = ExcelData.get("EDI_Package_Value_ECM");
	public static String EDI_Code_Mapping_EDI_Terminal_Code_Value = ExcelData
			.get("EDI_Code_Mapping_EDI_Terminal_Code_Value");
	public static String EDI_Code_Mapping_EDI_Dep_Code_Value = ExcelData.get("EDI_Code_Mapping_EDI_Dep_Code_Value");
	
	public static String Ref_FilterInput_ECM = ExcelData.get("Ref_FilterInput_ECM");

	
	

}
