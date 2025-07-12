package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface ENDPoint_Configuration_Locators {
	
	
	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "ENDPoint_Configuration", "Reference_Name", Testcases.environmentName);

	//FTP/SFTP Locators
	
	public static String EC_PartnerID_Search = ExcelData.get("EC_PartnerID_Search");
	public static String EC_ProfileId_Input = ExcelData.get("EC_ProfileId_Input");
	public static String EC_FTP_Url_input = ExcelData.get("EC_FTP_Url_input");
	public static String EC_FTP_UserId_input = ExcelData.get("EC_FTP_UserId_input");
	public static String EC_FTP_Password_input = ExcelData.get("EC_FTP_Password_input");
	public static String EC_FTP_JobCode_input = ExcelData.get("EC_FTP_JobCode_input");
	public static String EC_SFTP_Checkbox = ExcelData.get("EC_SFTP_Checkbox");
	public static String EC_Mode_Dropdown = ExcelData.get("EC_Mode_Dropdown");
	public static String EC_Type_Dropdown = ExcelData.get("EC_Type_Dropdown");
	public static String EC_API_Dropdown = ExcelData.get("EC_API_Dropdown");
	public static String EC_Status_Dropdown = ExcelData.get("EC_Status_Dropdown");
	public static String EC_Port_Input = ExcelData.get("EC_Port_Input");
	public static String EC_Directory_Input = ExcelData.get("EC_Directory_Input");
	public static String EC_RSA_Checkbox = ExcelData.get("EC_RSA_Checkbox");
	public static String EC_DSA_Checkbox = ExcelData.get("EC_DSA_Checkbox");
	public static String EC_LoginType_Dropdown = ExcelData.get("EC_LoginType_Dropdown");
	public static String EC_Encryption_Dropdown = ExcelData.get("EC_Encryption_Dropdown");
	public static String EC_JSCH_Checkbox = ExcelData.get("EC_JSCH_Checkbox");
	public static String EC_Key_Checkbox = ExcelData.get("EC_Key_Checkbox");
	public static String EC_Filepath_Input = ExcelData.get("EC_Filepath_Input");
	public static String EC_PassPhrase_Input = ExcelData.get("EC_PassPhrase_Input");
	public static String EC_Numoffiles_Input = ExcelData.get("EC_Numoffiles_Input");
	public static String EC_Interval_Input = ExcelData.get("EC_Interval_Input");
	public static String EC_ScheduleTime_Input = ExcelData.get("EC_ScheduleTime_Input");
	public static String EC_ScheduleTime_Input2 = ExcelData.get("EC_ScheduleTime_Input2");
	public static String EC_ScheduleDays_drodown = ExcelData.get("EC_ScheduleDays_drodown");
	public static String EC_Temp_Checkbox = ExcelData.get("EC_Temp_Checkbox");
	public static String EC_AccountInput = ExcelData.get("EC_AccountInput");
	public static String EC_ConditionFilter = ExcelData.get("EC_ConditionFilter");
	public static String EC_PartnerID_Filter = ExcelData.get("EC_PartnerID_Filter");
	public static String EC_ProfileName_Filter = ExcelData.get("EC_ProfileName_Filter");
	public static String EC_Archieve_Dropdown = ExcelData.get("EC_Archieve_Dropdown");
	public static String EC_RemoveButton = ExcelData.get("EC_RemoveButton");
	public static String EC_TabName = ExcelData.get("EC_TabName");
	public static String FTP_GridRow1 = ExcelData.get("FTP_GridRow1");
	
	//Share Path Locators
	
	public static String SP_PartnerId_Search = ExcelData.get("SP_PartnerId_Search");
	public static String SP_ProfileId = ExcelData.get("SP_ProfileId");
	public static String SP_Path_Input = ExcelData.get("SP_Path_Input");
	public static String SP_LocalDrive = ExcelData.get("SP_LocalDrive");
	public static String SP_NetworkDrive = ExcelData.get("SP_NetworkDrive");
	public static String SP_StatusDrodown = ExcelData.get("SP_StatusDrodown");
	public static String SP_Username = ExcelData.get("SP_Username");
	public static String SP_Password = ExcelData.get("SP_Password");
	public static String SP_ConditionFilter = ExcelData.get("SP_ConditionFilter");
	public static String SP_LocalDrive_input = ExcelData.get("SP_LocalDrive_input");
	public static String SP_ProfileName_Filter = ExcelData.get("SP_ProfileName_Filter");
	public static String SP_GridRow1 = ExcelData.get("SP_GridRow1");
	public static String EDI_DriveGrid = ExcelData.get("EDI_DriveGrid");
	public static String EDI_Sharepathgrid = ExcelData.get("EDI_Sharepathgrid");
	public static String EDI_Usernamegrid = ExcelData.get("EDI_Usernamegrid");
	
	//AS2 Locators
	
	public static String AS2_Status = ExcelData.get("AS2_Status");
	public static String AS2_GatewayURL = ExcelData.get("AS2_GatewayURL");
	public static String AS2_Keystore = ExcelData.get("AS2_Keystore");
	public static String AS2_Alias = ExcelData.get("AS2_Alias");
	public static String AS2_Password = ExcelData.get("AS2_Password");
	public static String AS2_AS2Id = ExcelData.get("AS2_AS2Id");
	public static String AS2_ProfileID = ExcelData.get("AS2_ProfileID");
	public static String AS2_PartnerID = ExcelData.get("AS2_PartnerID");
	public static String AS2_ConditionFilter = ExcelData.get("AS2_ConditionFilter");
	public static String AS2_ProfilenameFilterInput = ExcelData.get("AS2_ProfilenameFilterInput");
	public static String AS2_PartnerAS2FilterInput = ExcelData.get("AS2_PartnerAS2FilterInput");
	public static String AS2_KeystoreFilterInput = ExcelData.get("AS2_KeystoreFilterInput");
	public static String AS2_AliasFilterInput = ExcelData.get("AS2_AliasFilterInput");
	public static String AS2_GatewayFilter = ExcelData.get("AS2_GatewayFilter");
	public static String AS2_Row1 = ExcelData.get("AS2_Row1");
	
	//Web Service locators
	
	public static String WS_PartnerID = ExcelData.get("WS_PartnerID");
	public static String WS_ProfileID = ExcelData.get("WS_ProfileID");
	public static String WS_Attribute = ExcelData.get("WS_Attribute");
	public static String WS_Value = ExcelData.get("WS_Value");
	public static String WS_Addallocation = ExcelData.get("WS_Addallocation");
	public static String WS_ConditionFilter = ExcelData.get("WS_ConditionFilter");
	public static String WS_ProfileID_Filter = ExcelData.get("WS_ProfileID_Filter");
	public static String WS_Value_Filter = ExcelData.get("WS_Value_Filter");
	public static String WS_Attribute_Filter = ExcelData.get("WS_Attribute_Filter");
	public static String WS_Row1 = ExcelData.get("WS_Row1");
	public static String WS_Status = ExcelData.get("WS_Status");
	public static String WS_Removerecord = ExcelData.get("WS_Removerecord");
	

}
