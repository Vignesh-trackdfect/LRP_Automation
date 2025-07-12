package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Detention_Demurage_Extention_Locators {

	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Detention_Demurage_Extention", "Reference_Name", Testcases.environmentName);

	public static String Detention_BLSearch_Detention = ExcelData.get("Detention_BLSearch_Detention");
	public static String SelectTab_Detention = ExcelData.get("SelectTab_Detention");
	public static String Detention_Show_Detention = ExcelData.get("Detention_Show_Detention");
	public static String DetentionOkay_button_Detention = ExcelData.get("DetentionOkay_button_Detention");
	public static String ContainerNo_Column_Detention = ExcelData.get("ContainerNo_Column_Detention");
	public static String Detention_Table_Header_Detention = ExcelData.get("Detention_Table_Header_Detention");
	public static String Detention_Table_Row_Detention = ExcelData.get("Detention_Table_Row_Detention");
	public static String Date_button_Detention = ExcelData.get("Date_button_Detention");
	public static String Calendar_field_Detention = ExcelData.get("Calendar_field_Detention");
	public static String Days_Input_Detention = ExcelData.get("Days_Input_Detention");
	public static String Select_container_Detention = ExcelData.get("Select_container_Detention");
	public static String Plus_button_Detention = ExcelData.get("Plus_button_Detention");
	public static String detentionTab_No_Detention = ExcelData.get("detentionTab_No_Detention");
	public static String Days_Radio_Button_DD=ExcelData.get("Days_Radio_Button_DD");
	
	
	public static String AG_Grid_StorageExtention=ExcelData.get("AG_Grid_StorageExtention");
	public static String AG_Grid_DO_Extention=ExcelData.get("AG_Grid_DO_Extention");

	

}
