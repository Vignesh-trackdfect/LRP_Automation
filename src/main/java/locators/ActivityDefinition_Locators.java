package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface ActivityDefinition_Locators{
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "ActivityDefinition", "Reference_Name", Testcases.environmentName);

	public static String P_Fst_Coloumn_Name = ExcelData.get("P_Fst_Coloumn_Name");
	public static String P_ActCode_IsUpdate_DD = ExcelData.get("P_ActCode_IsUpdate_DD");
	public static String P_Act_AddEdit_Btn = ExcelData.get("P_Act_AddEdit_Btn");
	public static String P_Act_Fourth_Page = ExcelData.get("P_Act_Fourth_Page");
	public static String kActivitySearch = ExcelData.get("kActivitySearch");
	public static String kSecondSearch = ExcelData.get("kSecondSearch");
	public static String kActivityDefinitionSelect = ExcelData.get("kActivityDefinitionSelect");
	public static String kActivityDefinitionEdit = ExcelData.get("kActivityDefinitionEdit");
	public static String kActivityDefinitionColumName = ExcelData.get("kActivityDefinitionColumName");
	public static String kColumNameSelect = ExcelData.get("kColumNameSelect");
	public static String kActivityDefinitionIsUpdate = ExcelData.get("kActivityDefinitionIsUpdate");
	public static String kActivityDefinitionIsUpdateYesOption = ExcelData.get("kActivityDefinitionIsUpdateYesOption");
	public static String kActivityDefinitionValidationType = ExcelData.get("kActivityDefinitionValidationType");
	public static String kActivityDefinitionVOption = ExcelData.get("kActivityDefinitionVOption");
	public static String kActivityDefinitionCopyFromPrevious = ExcelData.get("kActivityDefinitionCopyFromPrevious");
	public static String kActivityDefinitionCopyFromPreviousYes = ExcelData.get("kActivityDefinitionCopyFromPreviousYes");
	public static String kActivityDefinitionCopyToPrevious = ExcelData.get("kActivityDefinitionCopyToPrevious");
	public static String kActivityDefinitionCopyToPreviousNo = ExcelData.get("kActivityDefinitionCopyToPreviousNo");
	public static String kActivityDefinitionCopyToPreviousAdd = ExcelData.get("kActivityDefinitionCopyToPreviousAdd");
	public static String kActivityDefinitionSave = ExcelData.get("kActivityDefinitionSave");
	public static String Updated_Value = ExcelData.get("Updated_Value");
	public static String Valid_Type_Value = ExcelData.get("Valid_Type_Value");
	public static String CMBCpy_Value_1 = ExcelData.get("CMBCpy_Value_1");
	public static String CMBCpy_Value_2 = ExcelData.get("CMBCpy_Value_2");
	public static String ADD_button_select = ExcelData.get("ADD_button_select");
	public static String Column_Value = ExcelData.get("Column_Value");
	public static String column_Filter = ExcelData.get("column_Filter");
	public static String Added_Column_Value = ExcelData.get("Added_Column_Value");
	public static String column_Filter_AD = ExcelData.get("column_Filter_AD");
	public static String deleted_Column_Value_AD = ExcelData.get("deleted_Column_Value_AD");

	
	
}
