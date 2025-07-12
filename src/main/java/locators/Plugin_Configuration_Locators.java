package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Plugin_Configuration_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Plugin_Configuration",
			"Reference_Name", Testcases.environmentName);

	public static String Plugin_module_id = ExcelData.get("Plugin_module_id");
	public static String Plugin_id = ExcelData.get("Plugin_id");
	public static String plugin_row_Click = ExcelData.get("plugin_row_Click");
	public static String enable_status = ExcelData.get("enable_status");
	public static String retrieved_PluginID = ExcelData.get("retrieved_PluginID");
	public static String moduleIdFilter_Searchbox = ExcelData.get("moduleIdFilter_Searchbox");
	public static String pluginStatus_Select = ExcelData.get("pluginStatus_Select");
	public static String Condition_Dropdown = ExcelData.get("Condition_Dropdown");
	public static String Plugin_description = ExcelData.get("Plugin_description");
	public static String searched_pluginId = ExcelData.get("searched_pluginId");
	public static String pluginConfiguration_Tab = ExcelData.get("pluginConfiguration_Tab");
	public static String pluginIdFilter_Searchbox = ExcelData.get("pluginIdFilter_Searchbox");
	public static String first_PluginID_Row = ExcelData.get("first_PluginID_Row");
	public static String first_PluginID_Row1 = ExcelData.get("first_PluginID_Row1");
	public static String condition_Input = ExcelData.get("condition_Input");
	public static String PluginTrue = ExcelData.get("PluginTrue");
	public static String PluginFalse = ExcelData.get("PluginFalse");
	public static String description_Select = ExcelData.get("description_Select");
	public static String Attribute_Select = ExcelData.get("Attribute_Select");
	public static String plugin_Configuration = ExcelData.get("plugin_Configuration");
	public static String pluginValue_Select = ExcelData.get("pluginValue_Select");
	public static String selectPluginStatuss = ExcelData.get("selectPluginStatuss");
	public static String plug_in_config_click = ExcelData.get("plug_in_config_click");
	public static String plugin_configuration = ExcelData.get("plugin_configuration");
	public static String truegettext = ExcelData.get("truegettext");
	public static String BKGmoduleIdFilter_Searchbox = ExcelData.get("BKGmoduleIdFilter_Searchbox");
	public static String enable_Status_Dropdown = ExcelData.get("enable_Status_Dropdown");
	public static String first_Plugin_Row = ExcelData.get("first_Plugin_Row");

}
