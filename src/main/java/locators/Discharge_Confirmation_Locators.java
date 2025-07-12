package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Discharge_Confirmation_Locators{

	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Discharge_Confirmation", "Reference_Name", Testcases.environmentName);

	public static String dischargeshow_Button = ExcelData.get("dischargeshow_Button");
	public static String discharge_activity_date = ExcelData.get("discharge_activity_date");
	public static String discharge_bookingnumber = ExcelData.get("discharge_bookingnumber");
	public static String dischargeselectall = ExcelData.get("dischargeselectall");
	public static String dischargeconfirmation_btn = ExcelData.get("dischargeconfirmation_btn");
	public static String container_no_discharge = ExcelData.get("container_no_discharge");
	public static String match_button_Discharge = ExcelData.get("match_button_Discharge");
	public static String Book_number_btn = ExcelData.get("Book_number_btn");
	public static String container_no_Discharge = ExcelData.get("container_no_Discharge");
	public static String Dischargeconfirmation = ExcelData.get("Dischargeconfirmation");
	public static String Discharge_Show_Button = ExcelData.get("Discharge_Show_Button");
	public static String Discharge_Checkbox = ExcelData.get("Discharge_Checkbox");
	public static String Discharge_Confirmation = ExcelData.get("Discharge_Confirmation");
	public static String VinChassis_BookNo_Select = ExcelData.get("VinChassis_BookNo_Select");
	public static String Discharge_VIN_Chassis_No = ExcelData.get("Discharge_VIN_Chassis_No");
	public static String Match1 = ExcelData.get("Match1");
	public static String show_Button_Discharge = ExcelData.get("show_Button_Discharge");
	public static String Ddischargeshow_Button = ExcelData.get("Ddischargeshow_Button");
	public static String Ddischarge_activity_date = ExcelData.get("Ddischarge_activity_date");
	public static String Ddischarge_bookingnumber = ExcelData.get("Ddischarge_bookingnumber");
	public static String Ddischargeselectall = ExcelData.get("Ddischargeselectall");
	public static String Ddischargeconfirmation_btn = ExcelData.get("Ddischargeconfirmation_btn");
	public static String Dcontainer_no_discharge = ExcelData.get("Dcontainer_no_discharge");
	public static String Dmatch_button_Discharge = ExcelData.get("Dmatch_button_Discharge");
	public static String DBook_number_btn = ExcelData.get("DBook_number_btn");
	public static String Dcontainer_no_Discharge = ExcelData.get("Dcontainer_no_Discharge");
	public static String DDischargeconfirmation = ExcelData.get("DDischargeconfirmation");
	public static String DDischarge_Show_Button = ExcelData.get("DDischarge_Show_Button");
	public static String DDischarge_Checkbox = ExcelData.get("DDischarge_Checkbox");
	public static String DDischarge_Confirmation = ExcelData.get("DDischarge_Confirmation");
	public static String DVinChassis_BookNo_Select = ExcelData.get("DVinChassis_BookNo_Select");
	public static String DDischarge_VIN_Chassis_No = ExcelData.get("DDischarge_VIN_Chassis_No");
	public static String DMatch1 = ExcelData.get("DMatch1");
	public static String Denable_status = ExcelData.get("Denable_status");
	public static String Dshow_Button_Discharge = ExcelData.get("Dshow_Button_Discharge");
	public static String DPlugin_module_id = ExcelData.get("DPlugin_module_id");
	public static String DPlugin_id = ExcelData.get("DPlugin_id");
	public static String Dplugin_row_Click = ExcelData.get("Dplugin_row_Click");
	public static String DContainer_Select = ExcelData.get("DContainer_Select");
	
			
			
}
