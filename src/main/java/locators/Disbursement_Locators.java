package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Disbursement_Locators{

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Disbursement", "Reference_Name", Testcases.environmentName);

	public static String Disbursement_input_ = ExcelData.get("Disbursement_input_");
	public static String From_Date_input_Disbursement = ExcelData.get("From_Date_input_Disbursement");
	public static String By_Date_button_Disbursement = ExcelData.get("By_Date_button_Disbursement");
	public static String Show_button_Disbursment = ExcelData.get("Show_button_Disbursment");

	
}
