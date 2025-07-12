package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EDI_Dashboard_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EDI_Dashboard", "Reference_Name", Testcases.environmentName);

	public static String EDI_DB_Agency_Button = ExcelData.get("EDI_DB_Agency_Button");
	public static String EDI_DB_EDI_Buttton = ExcelData.get("EDI_DB_EDI_Buttton");
	public static String EDI_DB_Mess_Function_Dropdwn = ExcelData.get("EDI_DB_Mess_Function_Dropdwn");
	public static String EDI_DB_Select_Mess_fuction = ExcelData.get("EDI_DB_Select_Mess_fuction");
	public static String EDI_Service_Code_Input = ExcelData.get("EDI_Service_Code_Input");
	public static String EDI_DB_Serivice_input = ExcelData.get("EDI_DB_Serivice_input");
	public static String EDI_DB_Vessel_input = ExcelData.get("EDI_DB_Vessel_input");
	public static String EDI_DB_Voyage_Input = ExcelData.get("EDI_DB_Voyage_Input");
	public static String EDI_DB_Bound = ExcelData.get("EDI_DB_Bound");
	public static String EDI_DB_POL = ExcelData.get("EDI_DB_POL");
	public static String EDI_DB_Service_First_Row = ExcelData.get("EDI_DB_Service_First_Row");
	public static String EDI_DB_Show_Button = ExcelData.get("EDI_DB_Show_Button");
	public static String EDI_DB_Grid_Select_All = ExcelData.get("EDI_DB_Grid_Select_All");
	public static String EDI_DB_Generate_EDI_Button = ExcelData.get("EDI_DB_Generate_EDI_Button");
	public static String EDI_Tracks_Show_Button = ExcelData.get("EDI_Tracks_Show_Button");
	public static String EDI_DB_Operation_Type_DropDown = ExcelData.get("EDI_DB_Operation_Type_DropDown");
	public static String EDI_DB_Operation_Type_Option = ExcelData.get("EDI_DB_Operation_Type_Option");
	public static String EDI_DB_Input_Details = ExcelData.get("EDI_DB_Input_Details");
	public static String EDI_Track_Filter_Option = ExcelData.get("EDI_Track_Filter_Option");
	public static String EDI_Track_Input_Status_Field = ExcelData.get("EDI_Track_Input_Status_Field");
	public static String EDI_DB_Edi_Ref_Field = ExcelData.get("EDI_DB_Edi_Ref_Field");
	public static String EDI_DB_Date_Cr = ExcelData.get("EDI_DB_Date_Cr");
	public static String EDI_DB_Dynamic_Data_Button = ExcelData.get("EDI_DB_Dynamic_Data_Button");
	public static String EDI_DB_Select_All_CheckBox = ExcelData.get("EDI_DB_Select_All_CheckBox");
	public static String EDI_DB_Pol_Input = ExcelData.get("EDI_DB_Pol_Input");
	public static String EDI_Dynamic_Data_Table = ExcelData.get("EDI_Dynamic_Data_Table");
	public static String EDI_Dynamic_Data_Input_Table = ExcelData.get("EDI_Dynamic_Data_Input_Table");
	public static String EDI_Dynamic_Apply_Button = ExcelData.get("EDI_Dynamic_Apply_Button");
	public static String EDI_DB_Reset_Button = ExcelData.get("EDI_DB_Reset_Button");
	public static String EDI_DB_Report_Check_Box = ExcelData.get("EDI_DB_Report_Check_Box");
	public static String EDI_DB_From_Date_Input = ExcelData.get("EDI_DB_From_Date_Input");
	public static String EDI_DB_To_Date_Input = ExcelData.get("EDI_DB_To_Date_Input");
	public static String EDI_DB_Color = ExcelData.get("EDI_DB_Color");
    public static String EDI_DB_Mess_Enable = ExcelData.get("EDI_DB_Mess_Enable");
    public static String EDI_DB_References_Input = ExcelData.get("EDI_DB_References_Input");
	
	
	
}



