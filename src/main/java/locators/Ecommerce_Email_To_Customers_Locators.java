package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecommerce_Email_To_Customers_Locators {
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecommerce_Email_To_Customers", "Reference_Name", Testcases.environmentName);

	public static String ETC_All_Customers_radioButton = ExcelData.get("ETC_All_Customers_radioButton");
	public static String ETC_subject_TextField = ExcelData.get("ETC_subject_TextField");
	public static String ETC_content_Frame = ExcelData.get("ETC_content_Frame");
	public static String ETC_Mail_Content_TF = ExcelData.get("ETC_Mail_Content_TF");
	public static String ETC_Send_Button = ExcelData.get("ETC_Send_Button");
	public static String ETC_By_Country_RadioButton = ExcelData.get("ETC_By_Country_RadioButton");
	public static String ETC_Country_Plus_Button = ExcelData.get("ETC_Country_Plus_Button");
	public static String ETc_By_Customer_RadioButton = ExcelData.get("ETc_By_Customer_RadioButton");
	public static String ETC_Customer_Plus_Button = ExcelData.get("ETC_Customer_Plus_Button");
	public static String ETC_By_Mail_RadioButton = ExcelData.get("ETC_By_Mail_RadioButton");
	public static String ETC_Email_Plus_Button = ExcelData.get("ETC_Email_Plus_Button");
	public static String ETC_Module_title = ExcelData.get("ETC_Module_title");

	
	
	
}
