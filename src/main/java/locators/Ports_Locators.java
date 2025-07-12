package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ports_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ports", "Reference_Name",
			Testcases.environmentName);

	public static String Statusforport = ExcelData.get("Statusforport");
	public static String Ports_Agency_text_Field = ExcelData.get("Ports_Agency_text_Field");
	public static String EUR_1875_Port_Checkbox = ExcelData.get("EUR_1875_Port_Checkbox");
	public static String Agency_Input_Ports = ExcelData.get("Agency_Input_Ports");

	public static String Ports_Agency_Button = ExcelData.get("Ports_Agency_Button");
	public static String Ports_Loc_Code_Field = ExcelData.get("Ports_Loc_Code_Field");
	public static String Port_Loc_Name_Field = ExcelData.get("Port_Loc_Name_Field");
	public static String Port_Loc_Type_Dropdown = ExcelData.get("Port_Loc_Type_Dropdown");
	public static String Port_Dropdown_Select = ExcelData.get("Port_Dropdown_Select");
	public static String Port_Budget_Checkbox = ExcelData.get("Port_Budget_Checkbox");
	public static String Country_Search_btn = ExcelData.get("Country_Search_btn");
	public static String Sector_Search_Btn = ExcelData.get("Sector_Search_Btn");
	public static String TCA_Search_Btn = ExcelData.get("TCA_Search_Btn");
	public static String Longitute_Text_Field = ExcelData.get("Longitute_Text_Field");
	public static String Latitute_Text_Field = ExcelData.get("Latitute_Text_Field");
	public static String Hemisphere_Dropdown = ExcelData.get("Hemisphere_Dropdown");
	public static String Hemisphere_Dropdown_Sel = ExcelData.get("Hemisphere_Dropdown_Sel");
	public static String Meridian_Dropdown_Sel = ExcelData.get("Meridian_Dropdown_Sel");
	public static String Meridian_Dropdown = ExcelData.get("Meridian_Dropdown");
	public static String Region_Search_btn = ExcelData.get("Region_Search_btn");
	public static String Time_Off_Set_Search_Btn = ExcelData.get("Time_Off_Set_Search_Btn");
	public static String Valid_To_date_field = ExcelData.get("Valid_To_date_field");
	public static String Valid_From_date_field = ExcelData.get("Valid_From_date_field");
	public static String Sea_Port_Checkbox = ExcelData.get("Sea_Port_Checkbox");
	public static String Sea_Port_Search_Btn = ExcelData.get("Sea_Port_Search_Btn");
	public static String Change_To_date_Field = ExcelData.get("Change_To_date_Field");
	public static String Change_From_date_Field = ExcelData.get("Change_From_date_Field");
	public static String Time_Day_Light_Field = ExcelData.get("Time_Day_Light_Field");
	public static String Agency_Search_Btn = ExcelData.get("Agency_Search_Btn");
	public static String TZ_Time_Day_Light_Field = ExcelData.get("TZ_Time_Day_Light_Field");
	public static String Status_for_port = ExcelData.get("Status_for_port");
	public static String Status_for_port_Dropdown_Select = ExcelData.get("Status_for_port_Dropdown_Select");
	public static String Timeoffst_search = ExcelData.get("Timeoffst_search");
	public static String Timezone_Textfield = ExcelData.get("Timezone_Textfield");
	public static String Timezone_timezonemodule = ExcelData.get("Timezone_timezonemodule");
	public static String PS_Region_Input = ExcelData.get("PS_Region_Input");
	public static String ports_ChangeDateFrom = ExcelData.get("ports_ChangeDateFrom");
	public static String ports_ChangeDateTo = ExcelData.get("ports_ChangeDateTo");

}
