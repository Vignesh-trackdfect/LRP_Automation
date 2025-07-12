package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Ecommerce_Notice_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Ecommerce_Notice", "Reference_Name", Testcases.environmentName);

	public static String EN_Title_Textfield = ExcelData.get("EN_Title_Textfield");
	public static String EN_Browse_Button = ExcelData.get("EN_Browse_Button");
	public static String EN_Pdf_File_Upload = ExcelData.get("EN_Pdf_File_Upload");
	public static String Ecom_Main_Menu = ExcelData.get("Ecom_Main_Menu");
	public static String Ecom_Main_Menu_Notice_Option = ExcelData.get("Ecom_Main_Menu_Notice_Option");
	public static String Ecom_Notice_Title = ExcelData.get("Ecom_Notice_Title");
	public static String Ecom_SearchField = ExcelData.get("Ecom_SearchField");

}
