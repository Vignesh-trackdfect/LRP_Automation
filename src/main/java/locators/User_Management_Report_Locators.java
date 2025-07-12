package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface User_Management_Report_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "User_Management_Report", "Reference_Name", Testcases.environmentName);
	
	
	public static String UMR_User_Option_drop_down = ExcelData.get("UMR_User_Option_drop_down");
	public static String UMR_User_Name_Button = ExcelData.get("UMR_User_Name_Button");
	public static String UMR_User_Name_Input = ExcelData.get("UMR_User_Name_Input");
	public static String UMR_Show_Button = ExcelData.get("UMR_Show_Button");
	public static String UMR_Main_Filter_Option = ExcelData.get("UMR_Main_Filter_Option");
	public static String UMR_Multiple_Filter = ExcelData.get("UMR_Multiple_Filter");
	public static String UMR_Total_Records = ExcelData.get("UMR_Total_Records");
	public static String UMR_Login_Name_Rows = ExcelData.get("UMR_Login_Name_Rows");
	public static String UMR_Copy_Option = ExcelData.get("UMR_Copy_Option");
	public static String UMR_Login_Name_Filter_button = ExcelData.get("UMR_Login_Name_Filter_button");
	public static String UMR_Paste_Input_Field = ExcelData.get("UMR_Paste_Input_Field");
	public static String UMR_Paste_Input_Field_Option = ExcelData.get("UMR_Paste_Input_Field_Option");
	public static String UMR_Filter_button = ExcelData.get("UMR_Filter_button");
	public static String UMR_Selected_Rows = ExcelData.get("UMR_Selected_Rows");
	public static String UMR_CSV_button = ExcelData.get("UMR_CSV_button");
	public static String UMR_Grid_Headers = ExcelData.get("UMR_Grid_Headers");
	public static String UMR_Grid_Header_Input_Field = ExcelData.get("UMR_Grid_Header_Input_Field");
	public static String UMR_Grid_Select_All_Check_Box = ExcelData.get("UMR_Grid_Select_All_Check_Box");
	public static String UMR_Grid_Select_Text_Value = ExcelData.get("UMR_Grid_Select_Text_Value");
	public static String UMR_Grid_Header_Table = ExcelData.get("UMR_Grid_Header_Table");
	public static String UMR_Excel_Button = ExcelData.get("UMR_Excel_Button");
	public static String UMR_Filter_Option_Dropdown = ExcelData.get("UMR_Filter_Option_Dropdown");
	public static String UMR_Condition_Option = ExcelData.get("UMR_Condition_Option");
	public static String UMR_Paste_Values_Row = ExcelData.get("UMR_Paste_Values_Row");
	public static String UMR_Status = ExcelData.get("UMR_Status");

	//
	public static String UMS_UserType_Header = ExcelData.get("UMS_UserType_Header");
	public static String UMS_UserType_First_Row = ExcelData.get("UMS_UserType_First_Row");
	public static String UMS_Grid_ToolBar = ExcelData.get("UMS_Grid_ToolBar");
	public static String UMS_Grid_Reset_Btn = ExcelData.get("UMS_Grid_Reset_Btn");
	public static String UMS_Grid_FullScreen_Btn = ExcelData.get("UMS_Grid_FullScreen_Btn");
	
	
	
	//
	public static String UMR_Usercode_menu_Button = ExcelData.get("UMR_Usercode_menu_Button");
	public static String UMR_usercode_Pincolumn = ExcelData.get("UMR_usercode_Pincolumn");
	public static String UMR_usercode_Pincolumn_pinleft = ExcelData.get("UMR_usercode_Pincolumn_pinleft");
	public static String UMR_optionsmenu_button = ExcelData.get("UMR_optionsmenu_button");
	public static String UMR_saveTemplate_button = ExcelData.get("UMR_saveTemplate_button");
	public static String UMR_Template_name_field = ExcelData.get("UMR_Template_name_field");
	public static String UMR_pin_Right = ExcelData.get("UMR_pin_Right");
	public static String UMR_pin_Left = ExcelData.get("UMR_pin_Left");
	public static String UMR_column_Header = ExcelData.get("UMR_column_Header");
	public static String UMR_SaveTemplate_savebutton_Click = ExcelData.get("UMR_SaveTemplate_savebutton_Click");
	public static String UMR_DeleteTemplate_Button = ExcelData.get("UMR_DeleteTemplate_Button");
	public static String UMR_Select_savedtemplate = ExcelData.get("UMR_Select_savedtemplate");
	public static String UMR_total_records = ExcelData.get("UMR_total_records");
	public static String UMR_search_input_condition = ExcelData.get("UMR_search_input_condition");
	public static String UMR_Distint_Filter = ExcelData.get("UMR_Distint_Filter");
	public static String UMR_selectAll_checkbox = ExcelData.get("UMR_selectAll_checkbox");
	public static String UMR_select_Header = ExcelData.get("UMR_select_Header");
	public static String UMR_AG_Table = ExcelData.get("UMR_AG_Table");
	public static String UMR_Dashboard_Tab = ExcelData.get("UMR_Dashboard_Tab");
	public static String UMR_module_tab = ExcelData.get("UMR_module_tab");
	public static String UMR_Reset_button = ExcelData.get("UMR_Reset_button");
	public static String UMR_Filter_Input_field = ExcelData.get("UMR_Filter_Input_field");
	public static String UMR_AG_All_rows = ExcelData.get("UMR_AG_All_rows");
	public static String UMR_Condition_Filter = ExcelData.get("UMR_Condition_Filter");
	public static String UMR_input_data_tab = ExcelData.get("UMR_input_data_tab");
	public static String UMR_Treetable = ExcelData.get("UMR_Treetable");
	public static String UMR_SaveasTemplate = ExcelData.get("UMR_SaveasTemplate");
	public static String UMR_TemplateNameInput = ExcelData.get("UMR_TemplateNameInput");
	public static String UMR_Save_templateInput = ExcelData.get("UMR_Save_templateInput");
	public static String UMR_Select_Template = ExcelData.get("UMR_Select_Template");
	
	
	
}
