package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Invoice_Reversal_Locators{
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Invoice_Reversal", "Reference_Name",
			Testcases.environmentName);
	
	public static String invoiceNo_SearchButton = ExcelData.get("invoiceNo_SearchButton");
	public static String invoiceReversal_Show_Button = ExcelData.get("invoiceReversal_Show_Button");
	public static String invoiceReversal_Table_Rows = ExcelData.get("invoiceReversal_Table_Rows");
	public static String invoiceReversal_Remarks_TextArea = ExcelData.get("invoiceReversal_Remarks_TextArea");
	public static String invoiceReversal_Table_Rows1 = ExcelData.get("invoiceReversal_Table_Rows1");
	
	public static String Invoice_No_Column_IR = ExcelData.get("Invoice_No_Column_IR");

	
}