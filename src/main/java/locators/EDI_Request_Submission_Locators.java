package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface EDI_Request_Submission_Locators{
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "EDI_Request_Submission", "Reference_Name", Testcases.environmentName);

	public static String searchField = ExcelData.get("searchField");
	public static String ediSearch = ExcelData.get("ediSearch");
	public static String chooseOption = ExcelData.get("chooseOption");
	public static String saveOpt = ExcelData.get("saveOpt");
	public static String Excel_Upload = ExcelData.get("Excel_Upload");



}
