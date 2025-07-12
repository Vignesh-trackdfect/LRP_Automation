package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Reversal_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Reversal",
			"Reference_Name", Testcases.environmentName);
	public static String reversalModule = ExcelData.get("reversalModule");
	public static String journal_Button = ExcelData.get("journal_Button");
	public static String journalNo_SearchButton = ExcelData.get("journalNo_SearchButton");
	public static String transactionNo_Textfield = ExcelData.get("transactionNo_Textfield");
	public static String transactionDate_Textfield = ExcelData.get("transactionDate_Textfield");
	public static String date_Of_Reverion_Field = ExcelData.get("date_Of_Reverion_Field");
	public static String reversal_Button = ExcelData.get("reversal_Button");
	public static String clear_Button = ExcelData.get("clear_Button");
	public static String originalTransaction_Tab_Row = ExcelData.get("originalTransaction_Tab_Row");
	public static String reversalTransaction_Tab_Row = ExcelData.get("reversalTransaction_Tab_Row");
	public static String reversalStatus = ExcelData.get("reversalStatus");
	public static String description_textArea_Reversal = ExcelData.get("description_textArea_Reversal");
	public static String originalTransaction_Tab = ExcelData.get("originalTransaction_Tab");
	public static String reversalTransaction_Tab = ExcelData.get("reversalTransaction_Tab");
	public static String financial_Year_Searchbutton_Reversal = ExcelData.get("financial_Year_Searchbutton_Reversal");
	public static String financial_Year_Filter = ExcelData.get("financial_Year_Filter");
}
