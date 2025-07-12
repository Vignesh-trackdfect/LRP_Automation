package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Contract_Mapping_Locators{

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Contract_Mapping", "Reference_Name", Testcases.environmentName);

	public static String port_Plus_Button_CM = ExcelData.get("port_Plus_Button_CM");
	public static String terminal_Select_Checkbox_CM = ExcelData.get("terminal_Select_Checkbox_CM");
	public static String terminal_Select_Ok_Button_CM = ExcelData.get("terminal_Select_Ok_Button_CM");
	public static String port_Mapping_ID_Textfield_CM = ExcelData.get("port_Mapping_ID_Textfield_CM");
	public static String Terminal_Gridcell_ContractMapping = ExcelData.get("Terminal_Gridcell_ContractMapping");
	public static String CM_VendorCode = ExcelData.get("CM_VendorCode");
	public static String CM_ContractNo = ExcelData.get("CM_ContractNo");
	public static String Port_Code_Next_Button_CM = ExcelData.get("Port_Code_Next_Button_CM");

}
