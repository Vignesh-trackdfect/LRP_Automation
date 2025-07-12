package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Schedule_Security_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Schedule_Security",
			"Reference_Name", Testcases.environmentName);

	public static String schedule_Security_username_search_btn = ExcelData.get("schedule_Security_username_search_btn");
	public static String schedule_Security_username_search_input = ExcelData.get("schedule_Security_username_search_input");
	public static String schedule_Security_Service_Code_Add = ExcelData.get("schedule_Security_Service_Code_Add");
	public static String schedule_Security_Service_Code_Input = ExcelData.get("schedule_Security_Service_Code_Input");
	public static String schedule_Security_Vessel_Code_Add = ExcelData.get("schedule_Security_Vessel_Code_Add");
	public static String schedule_Security_Vessel_Code_Input = ExcelData.get("schedule_Security_Vessel_Code_Input");
	public static String schedule_Security_Group_Code_Add = ExcelData.get("schedule_Security_Group_Code_Add");
	public static String show_All_User_Group = ExcelData.get("show_All_User_Group");
	public static String schedule_Security_clear_Btn = ExcelData.get("schedule_Security_clear_Btn");
	public static String schedule_Security_Btn_Click = ExcelData.get("schedule_Security_Btn_Click");
	public static String schedule_Security_gird_select = ExcelData.get("schedule_Security_gird_select");
	public static String schedule_Security_gird_select1 = ExcelData.get("schedule_Security_gird_select1");
	public static String schedule_Security_select = ExcelData.get("schedule_Security_select");
	public static String Doc_Agency = ExcelData.get("Doc_Agency");
	public static String Profile_Dropdown = ExcelData.get("Profile_Dropdown");
	public static String Corporate_Profile = ExcelData.get("Corporate_Profile");
	public static String Location_Profile = ExcelData.get("Location_Profile");
	public static String reset_Profile_Button = ExcelData.get("reset_Profile_Button");
	public static String hide_Menu_ID = ExcelData.get("hide_Menu_ID");
	public static String main_Menu_ID = ExcelData.get("main_Menu_ID");
	public static String already_Having_Popup = ExcelData.get("already_Having_Popup");
	public static String continue_Button = ExcelData.get("continue_Button");
	public static String schedule_Security_group_input = ExcelData.get("schedule_Security_group_input");
	public static String schedule_Security_username_filter = ExcelData.get("schedule_Security_username_filter");
	public static String schedule_Security_servicecode_filter = ExcelData.get("schedule_Security_servicecode_filter");
	public static String schedule_Security_vesselcode_filter = ExcelData.get("schedule_Security_vesselcode_filter");
	public static String schedule_Security_access_filter = ExcelData.get("schedule_Security_access_filter");
	public static String schedule_Security_user_filter = ExcelData.get("schedule_Security_user_filter");
	public static String schedule_Security_filter = ExcelData.get("schedule_Security_filter");
	public static String schedule_Security_filter_click = ExcelData.get("schedule_Security_filter_click");
	public static String Module_Select = ExcelData.get("Module_Select");
	public static String package_search_input_select = ExcelData.get("package_search_input_select");
	public static String package_value = ExcelData.get("package_value");
	public static String Empty_reference_input = ExcelData.get("Empty_reference_input");
	public static String SelectBtn = ExcelData.get("SelectBtn");
	public static String Import_Documentation = ExcelData.get("Import_Documentation");
	public static String BL_Number_select = ExcelData.get("BL_Number_select");
	public static String container_Tab_Table = ExcelData.get("container_Tab_Table");
	public static String AgencyConfiguration = ExcelData.get("AgencyConfiguration");
	public static String Agency_User_Select = ExcelData.get("Agency_User_Select");
	public static String House_BL_No_select = ExcelData.get("House_BL_No_select");
	public static String schedule_Security_gird_firstclick = ExcelData.get("schedule_Security_gird_firstclick");
	
	
	
}
