package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecom_insurance_acess {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecom_insurance_acess", "Reference_Name", Testcases.environmentName);

	public static String Customer_code_search = ExcelData.get("Customer_code_search");
	public static String Customer_code_input = ExcelData.get("Customer_code_input");
	public static String Customer_name_input = ExcelData.get("Customer_name_input");
	public static String show_user_checkbox = ExcelData.get("show_user_checkbox");
	public static String refresh_button_ecom = ExcelData.get("refresh_button_ecom");
	public static String Customer_code_input_text = ExcelData.get("Customer_code_input_text");
	public static String Customer_name_input_text = ExcelData.get("Customer_name_input_text");

}
