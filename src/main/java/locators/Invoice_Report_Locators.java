package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Invoice_Report_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Invoice_Report", "Reference_Name",
			Testcases.environmentName);
	public static String billing_Period_IR= ExcelData.get("billing_Period_IR");
	public static String show_Button_IR= ExcelData.get("show_Button_IR");
	public static String Billing_Period_Year_Input_IR= ExcelData.get("Billing_Period_Year_Input_IR");
	public static String Vendor_Code_Filter_Input_IR= ExcelData.get("Vendor_Code_Filter_Input_IR");


}
