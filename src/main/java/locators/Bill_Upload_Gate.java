package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Bill_Upload_Gate{
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Bill_Upload_Gate", "Reference_Name", Testcases.environmentName);

	public static String Aimport_excelll = ExcelData.get("Aimport_excelll");
	public static String Aselectexcelfile = ExcelData.get("Aselectexcelfile");
	public static String Aselectexcelfiledroupdown = ExcelData.get("Aselectexcelfiledroupdown");
	public static String Asheert7 = ExcelData.get("Asheert7");
	public static String Aloadsheet = ExcelData.get("Aloadsheet");
	public static String Amapyesbutton = ExcelData.get("Amapyesbutton");
	public static String Auploadfile = ExcelData.get("Auploadfile");
	public static String Aproccedd = ExcelData.get("Aproccedd");
	public static String Arowoneclick = ExcelData.get("Arowoneclick");
	public static String Aclearbills = ExcelData.get("Aclearbills");
	public static String Arefresh = ExcelData.get("Arefresh");
	public static String Acontractnumbergrid = ExcelData.get("Acontractnumbergrid");
	public static String gird_val = ExcelData.get("gird_val");
	public static String Sheet_sel = ExcelData.get("Sheet_sel");
	public static String Tool_Panel_Bill_Upload_Gate = ExcelData.get("Tool_Panel_Bill_Upload_Gate");
	public static String Condition_Filter_Bill_Upload_Gate = ExcelData.get("Condition_Filter_Bill_Upload_Gate");
	public static String Contract_No_Filter = ExcelData.get("Contract_No_Filter");
	public static String Billing_Period_Filter = ExcelData.get("Billing_Period_Filter");
	public static String Aimport_excelll_BU = ExcelData.get("Aimport_excelll_BU");
	public static String gird_val_BU = ExcelData.get("gird_val_BU");
	public static String Lessor_BU = ExcelData.get("Lessor_BU");
	public static String Bill_no_BU = ExcelData.get("Bill_no_BU");
	public static String Billing_number_BU = ExcelData.get("Billing_number_BU");
	public static String Status_BU = ExcelData.get("Status_BU");
	public static String from_Date_BUG = ExcelData.get("from_Date_BUG");
	public static String to_Date_BUG = ExcelData.get("to_Date_BUG");

	public static String Lessor_Bill_File_Upload = ExcelData.get("Lessor_Bill_File_Upload");
		

	   

		
}
