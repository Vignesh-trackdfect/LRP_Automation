package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Agency_Configiration_Locators{
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Agency_Configuration", "Reference_Name", Testcases.environmentName);

	public static String agencySearch_Button = ExcelData.get("agencySearch_Button");
	public static String AC_Search_Button = ExcelData.get("AC_Search_Button");
	public static String agencyCode_Filter = ExcelData.get("agencyCode_Filter");
	public static String agencyConfiguration_Tab = ExcelData.get("agencyConfiguration_Tab");
	public static String AC_Show_Button = ExcelData.get("AC_Show_Button");
	public static String AC_description_Grid_Filter = ExcelData.get("AC_description_Grid_Filter");
	public static String AC_value_Textfield = ExcelData.get("AC_value_Textfield");
	public static String AC_Plus_Button = ExcelData.get("AC_Plus_Button");
	public static String resetProfile_Button = ExcelData.get("resetProfile_Button");
	public static String vgm_Not_Verfied_Popup1 = ExcelData.get("vgm_Not_Verfied_Popup1");
	public static String plus_Button_ACG = ExcelData.get("plus_Button_ACG");
	public static String AC_first_Description_Select = ExcelData.get("AC_first_Description_Select");
	public static String agencyConfig_Description = ExcelData.get("agencyConfig_Description");
	public static String AC_Remove_Button = ExcelData.get("AC_Remove_Button");
	public static String portCode_Filter1 = ExcelData.get("portCode_Filter1");
	public static String select_Checkbox1 = ExcelData.get("select_Checkbox1");
	public static String scroll_import_service = ExcelData.get("scroll_import_service");
	public static String Add_Button_mcn = ExcelData.get("Add_Button_mcn");
	public static String consinee_name_app = ExcelData.get("consinee_name_app");
	public static String Adress1_app = ExcelData.get("Adress1_app");
	public static String column_Headers = ExcelData.get("column_Headers");
	public static String scrollBar_AN_Table = ExcelData.get("scrollBar_AN_Table");
	public static String portpanel_First_Click = ExcelData.get("portpanel_First_Click");


}
