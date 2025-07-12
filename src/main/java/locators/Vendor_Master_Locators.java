package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Vendor_Master_Locators {
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Vendor_Master",
			"Reference_Name", Testcases.environmentName);
	
	public static String new_Button_VM = ExcelData.get("new_Button_VM");
	public static String Paymemnt_Method_VM = ExcelData.get("Paymemnt_Method_VM");
	public static String HQ_RadioButton_VM = ExcelData.get("HQ_RadioButton_VM");
	public static String Disbursement_RadioButton_VM = ExcelData.get("Disbursement_RadioButton_VM");
	public static String Vendor_Master_Eye_icon = ExcelData.get("Vendor_Master_Eye_icon");
	public static String Vendor_Master_Status = ExcelData.get("Vendor_Master_Status");
	public static String Vendor_Master_Open_Approved_Status = ExcelData.get("Vendor_Master_Open_Approved_Status");
	public static String Vendor_Master_Status_Box = ExcelData.get("Vendor_Master_Status_Box");
	public static String Type_Of_Contract_VM = ExcelData.get("Type_Of_Contract_VM");
	public static String Vendor_Master_Type_of_Contract = ExcelData.get("Vendor_Master_Type_of_Contract");
	
	public static String VM_Action_Option = ExcelData.get("VM_Action_Option");
	public static String VM_Vendor_Code_Input = ExcelData.get("VM_Vendor_Code_Input");
	public static String VM_Back_Option_Button = ExcelData.get("VM_Back_Option_Button");
	public static String VM_Activity = ExcelData.get("VM_Activity");
	public static String VM_Void = ExcelData.get("VM_Void");
	public static String VM_Total_Records = ExcelData.get("VM_Total_Records");
	
	
	
	
	
    
}
