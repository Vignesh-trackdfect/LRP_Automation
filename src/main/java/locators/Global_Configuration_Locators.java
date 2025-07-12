package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Global_Configuration_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Global_Configuration", "Reference_Name", Testcases.environmentName);
public static String Filter_Menu = ExcelData.get("Filter_Menu");
	public static String Condition_Filter_Button = ExcelData.get("Condition_Filter_Button");
	public static String Attribute_Filter = ExcelData.get("Attribute_Filter");
	public static String valueTextfield = ExcelData.get("valueTextfield");
	public static String Global_Configuration = ExcelData.get("Global_Configuration");
	public static String Global_FilterRow = ExcelData.get("Global_FilterRow");
	public static String global_row_Select = ExcelData.get("global_row_Select");
	//
	public static String Global_Configuration_Multi_Filter_Btn = ExcelData.get("Global_Configuration_Multi_Filter_Btn");
	public static String Attribute_Filter_Btn = ExcelData.get("Attribute_Filter_Btn");
	public static String Attribute_Filter_Option_Click = ExcelData.get("Attribute_Filter_Option_Click");
	public static String Attribute_Column_Row = ExcelData.get("Attribute_Column_Row");
	public static String Attribute_Paste_Field = ExcelData.get("Attribute_Paste_Field");
	public static String Attribute_Copy = ExcelData.get("Attribute_Copy");
	public static String Type_Row_Select = ExcelData.get("Type_Row_Select");
	public static String Type_Filter_Option_Click = ExcelData.get("Type_Filter_Option_Click");
	public static String Attribute_Row_Select = ExcelData.get("Attribute_Row_Select");
	public static String Filter_Clear = ExcelData.get("Filter_Clear");
	public static String Attribute_Paste_value = ExcelData.get("Attribute_Paste_value");
	public static String Global_Configuration_CSV_Btn = ExcelData.get("Global_Configuration_CSV_Btn");
	public static String Global_Grid_Count = ExcelData.get("Global_Grid_Count");
	public static String Global_Conf_Attribute_Field = ExcelData.get("Global_Conf_Attribute_Field");
	public static String GC_Filter_Input_field = ExcelData.get("GC_Filter_Input_field");
	public static String GC_first_row_attribute = ExcelData.get("GC_first_row_attribute");
	public static String GC_Attribute_header = ExcelData.get("GC_Attribute_header");
	public static String GC_Refresh_Button = ExcelData.get("GC_Refresh_Button");
	public static String GC_Grid_Header = ExcelData.get("GC_Grid_Header");
	public static String GC_Exel_File = ExcelData.get("GC_Exel_File");
	public static String GC_Grid_Table = ExcelData.get("GC_Grid_Table");
	public static String GC_Condition_Filter = ExcelData.get("GC_Condition_Filter");
	public static String GC_Type_Input = ExcelData.get("GC_Type_Input");
	public static String GC_Value_Input = ExcelData.get("GC_Value_Input");
	public static String GC_Grid_All_Rows = ExcelData.get("GC_Grid_All_Rows");
	public static String GC_Reset_Button = ExcelData.get("GC_Reset_Button");
	public static String GC_Total_Records = ExcelData.get("GC_Total_Records");
	public static String GC_Refresh_button_option = ExcelData.get("GC_Refresh_button_option");
	public static String GC_AttributeList = ExcelData.get("GC_AttributeList");
	public static String GC_Attribut_input = ExcelData.get("GC_Attribut_input");
	public static String GC_Fullscreeen_grid = ExcelData.get("GC_Fullscreeen_grid");
	
	
	public static String GC_TypeList = ExcelData.get("GC_TypeList");
	public static String GC_DescriptionList = ExcelData.get("GC_DescriptionList");
	public static String GC_ValueList = ExcelData.get("GC_ValueList");
	public static String GC_Attribute_filterIcon = ExcelData.get("GC_Attribute_filterIcon");
	public static String GC_Type_filterIcon = ExcelData.get("GC_Type_filterIcon");
	public static String GC_Description_filterIcon = ExcelData.get("GC_Description_filterIcon");
	public static String GC_Value_filterIcon = ExcelData.get("GC_Value_filterIcon");
	public static String GC_Distinct_Filter = ExcelData.get("GC_Distinct_Filter");
	public static String GC_AttributeGridList = ExcelData.get("GC_AttributeGridList");
	public static String GC_TypeGridList = ExcelData.get("GC_TypeGridList");
	public static String GC_DescriptionGridList = ExcelData.get("GC_DescriptionGridList");
	public static String GC_ValueGridList = ExcelData.get("GC_ValueGridList");
	
	

//	public static String Filter_Menu="Filter_Menu>//div[@id='GCN-GCN_Datagrid_nfr_toolpanel_li_id']";
//	public static String Condition_Filter_Button="Condition_Filter_Button>//a[@id='GCN-GCN_Datagrid_conditionFilter_id']";
//	public static String Attribute_Filter="Attribute_Filter>//input[@aria-label='Atrribute Filter Input']";
//	public static String valueTextfield="valueTextfield>//input[@id='GCN-GCN_txtVal']";
//	public static String Global_Configuration="Global_Configuration>//li[@data-item-label='Global Configuration']";
//	public static String Global_FilterRow="Global_FilterRow>//div[@id='GCN-GCN_Datagrid_tbl']//div[@row-index='0']";
//	public static String global_row_Select="global_row_Select>//div[@id='GCN-GCN_Datagrid_tbl']//div[@ref='eContainer']//div[@row-index='0']";
	//unused
//	public static String global_config_value1 = "global_config_value1>//div[text()='%s']";
//	public static String global_config_value2 = "global_config_value2>//div[text()='%s']";
//	public static String global_config_value3 = "global_config_value3>//div[text()='%s']";
//	public static String Global_EditBtn="Global_EditBtn>//label[text()='Global Configuration']//following::button[contains(@id,'btnTblEdit')]";
//	public static String Global_SaveBtn="Global_SaveBtn>//label[text()='Global Configuration']//following::button[contains(@id,'btnsave')]";
//	public static String firstTab_Edit="firstTab_Edit>(//button[contains(@id,'btnTblEdit')])[1]";
//	public static String globalConfiguration_Tab="globalConfiguration_Tab>//a[@role='presentation']/child::label[.='Global Configuration']";
//	public static String globalConfig_Save_Button="globalConfig_Save_Button>//button[contains(@id,'btnsave') and contains(@name,'GCN')]";
//	public static String globalConfig_Edit_Button="globalConfig_Edit_Button>//button[contains(@id,'btnTblEdit') and contains(@name,'GCN')]";
//	public static String global_Configuration_EditButton="global_Configuration_EditButton>//button[contains(@id,'btnTblEdit') and contains(@name,'GCN')]";
//	public static String global_Configuration_SaveButton="global_Configuration_SaveButton>//button[contains(@id,'btnsave') and contains(@name,'GCN')]";
}
